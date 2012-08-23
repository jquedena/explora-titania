create or replace package body iido.pkg_carga_datos
as
-- funciones
--//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
function is_date ( cdate in varchar2 )
return int
is
  esfecha int;
  fecha date;
begin
  fecha := to_date ( cdate, 'dd/mm/yyyy' );
  esfecha := 1;
  return esfecha;
exception
when others then
  esfecha := 0;
  return esfecha;
end;

function is_number ( cnumber in varchar2 )
return int
is
  esnumero int;
  totalcaracteres int;
begin
  totalcaracteres := length ( trim ( translate ( cnumber, ' +-.0123456789', ' ' ) ) );
  if totalcaracteres is null then
    esnumero := 1;
  else
    esnumero := 0;
  end if;
return esnumero;
end;

-- procedimientos
--//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
procedure sp_valida_carga(exitCode out number, errMsg out varchar2)
is
begin
  errMsg := '';
    
  update iido.tiido_multitabla set valor1='1'
  where cod_mult='T16' and cod_elem='1' and valor1='0';
  commit;
  
  select to_number(valor1) into exitCode
  from iido.tiido_multitabla
  where cod_mult='T16' and cod_elem='1';
exception
when others then
  rollback;
  exitCode := -1;
  errMsg := 'Error: ' || to_number(sqlcode) || ' - ' || sqlerrm;
end sp_valida_carga;

procedure sp_valida_carga_periodo(periodo in varchar2, exitCode out number, errMsg out varchar2)
is
begin
  errMsg := '';

  select count(1) into exitCode from iido.tiido_multitabla where cod_mult='T02' and valor1=periodo;
  
  if(exitCode = 0) then  
    update iido.tiido_multitabla set valor1=periodo
    where cod_mult='T02';
    commit;
    exitCode := 1;
  end if;
  
exception
when others then
  rollback;
  exitCode := -1;
  errMsg := 'Error: ' || to_number(sqlcode) || ' - ' || sqlerrm;
end sp_valida_carga_periodo;

procedure sp_carga_datos_mis(exitCode out number, errMsg out varchar2)
is
  maxLog number;
begin
  errMsg := '';
  execute immediate 'alter session set nls_numeric_characters = ".,"';
  -- execute immediate 'truncate table iido.tiido_interfaz_mis';
  insert into iido.tiido_interfaz_mis ( id_row
    , cod_epi
    , fec_facturacion
    , cod_territorio
    , cod_oficina
    , cod_registro
    , monto_facturacion )
  select iido.seq_interfaz_miz.nextval
    , i.cod_epi
    , i.fec_facturacion
    , '3' || substr(trim(i.cod_territorio), 2, 3)
    , i.cod_oficina
    , i.cod_registro
    , to_number(i.monto_facturacion)
  from iido.tiido_ext_interfaz_mis i
    left join iido.tiido_territorio t on '3' || substr(trim(i.cod_territorio), 2, 3) = t.cod_terr
  where not(( i.monto_facturacion is null 
        and i.fec_facturacion is null 
        and i.cod_territorio is null 
        and i.cod_registro is null 
        and i.cod_oficina is null 
        and i.cod_epi is null )
    or ( i.monto_facturacion is null 
        or i.fec_facturacion is null 
        or i.cod_territorio is null 
        or i.cod_registro is null 
        or i.cod_oficina is null 
        or i.cod_epi is null )
    or ( t.cod_terr is null 
        or iido.pkg_carga_datos.is_date ( i.fec_facturacion ) = 0 
        or iido.pkg_carga_datos.is_number ( i.monto_facturacion ) = 0 ) );


  /* execute immediate 'truncate table iido.tiido_equivalencia_sdo_mis';
  insert into iido.tiido_equivalencia_sdo_mis ( id_row
    , cod_epi
    , cod_epi_mis
    , signo_mis
    , tipo_saldo_mis )
  select iido.seq_equivalencia_sdo_mis.nextval
    , cod_epi
    , cod_epi_mis
    , signo_mis
    , tipo_saldo_mis
  from iido.tiido_ext_equivalencia_sdo_mis; */
  
  -- generando log
  execute immediate 'truncate table iido.tiido_log_carga_mis';
  select nvl(max(idlog), 0) into maxLog from tiido_log_carga_mis;
  insert into iido.tiido_log_carga_mis ( idlog, nro_linea, iderror, desc_error, fecha)
  select rownum + maxLog as idlog
  	, i.id_row as linea
    , case 
      when ( i.monto_facturacion is null 
        and i.fec_facturacion is null 
        and i.cod_territorio is null 
        and i.cod_registro is null 
        and i.cod_oficina is null 
        and i.cod_epi is null )then 1
      when ( i.monto_facturacion is null 
        or i.fec_facturacion is null 
        or i.cod_territorio is null 
        or i.cod_registro is null 
        or i.cod_oficina is null 
        or i.cod_epi is null ) then 2
      when t.cod_terr is null then 3
      when iido.pkg_carga_datos.is_date ( i.fec_facturacion ) = 0 then 4
      when iido.pkg_carga_datos.is_number ( i.monto_facturacion ) = 0 then 5
      end
    , case 
      when ( i.monto_facturacion is null 
        and i.fec_facturacion is null 
        and i.cod_territorio is null 
        and i.cod_registro is null 
        and i.cod_oficina is null 
        and i.cod_epi is null ) then 'Linea en blanco'
      when ( i.monto_facturacion is null 
        or i.fec_facturacion is null 
        or i.cod_territorio is null 
        or i.cod_registro is null 
        or i.cod_oficina is null 
        or i.cod_epi is null ) then 'Valores nulos'
      when t.cod_terr is null then 'No se encontro el codigo de territorio'
      when iido.pkg_carga_datos.is_date ( i.fec_facturacion ) = 0 then 'Fecha invalida'
      when iido.pkg_carga_datos.is_number ( i.monto_facturacion ) = 0 then 'Monto facturacion invalido'
      end
    , to_char(sysdate, 'dd/mm/yyyy hh24:mi:ss') fecha         
  from (select rownum id_row, x.* from iido.tiido_ext_interfaz_mis x) i
    left join iido.tiido_territorio t on '3' || substr(trim(i.cod_territorio), 2, 3) = t.cod_terr
  where ( i.monto_facturacion is null 
        and i.fec_facturacion is null 
        and i.cod_territorio is null 
        and i.cod_registro is null 
        and i.cod_oficina is null 
        and i.cod_epi is null )
    or ( i.monto_facturacion is null 
        or i.fec_facturacion is null 
        or i.cod_territorio is null 
        or i.cod_registro is null 
        or i.cod_oficina is null 
        or i.cod_epi is null )
    or ( t.cod_terr is null 
        or iido.pkg_carga_datos.is_date ( i.fec_facturacion ) = 0 
        or iido.pkg_carga_datos.is_number ( i.monto_facturacion ) = 0 );
        
  -- update iido.tiido_multitabla set valor1='0' where cod_mult='T16' and cod_elem='1';      
  commit;
  exitCode := 2;
exception
when others then
  rollback;
  
  exitCode := 0;
  errMsg := 'Error: ' || to_number(sqlcode) || ' - ' || sqlerrm;
end sp_carga_datos_mis;

procedure sp_cambia_estado(exitCode out number, errMsg out varchar2)
is
begin
  update iido.tiido_multitabla set valor1='0' where cod_mult='T16' and cod_elem='1';      
  commit;
  exitCode := 1;
exception
when others then
  rollback;
  
  exitCode := 0;
  errMsg := 'Error: ' || to_number(sqlcode) || ' - ' || sqlerrm;
end sp_cambia_estado;

end pkg_carga_datos;
/