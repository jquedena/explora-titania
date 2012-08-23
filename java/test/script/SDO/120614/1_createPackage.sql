create or replace package iido.pk_planes is
  procedure proc_consulta_planes(p_codTerritorio varchar2, p_codOficina varchar2, p_mes varchar2, p_anho varchar2, sys_planes out sys_refcursor);
end pk_planes;
/
create or replace package iido.pk_perfil is
  procedure proc_consulta_perfil(p_codCargo varchar2, sys_perfil out sys_refcursor);
end pk_perfil;
/
create or replace package body iido.pk_planes is

  procedure proc_consulta_planes(p_codTerritorio varchar2, p_codOficina varchar2, p_mes varchar2, p_anho varchar2, sys_planes out sys_refcursor)
  as
  begin
    open sys_planes for
    select cod_epigrafe
      , nom_epigrafe
      , sum(peso_dor) peso_dor
      , sum(monto) monto
      , case when upper(nom_epigrafe) like '%CARTERA ATRASADA%' 
        then (100 - (round(sum(monto / saldmedi_dic), 2) * 100)) + 100
        else round(sum(monto / saldmedi_dic), 2) * 100
        end porc_alcanzado
      , sum(desv_ppto) desv_ppto
      , avg(nro_meses_falt) nro_meses_falt
      , sum(proy_crec_men) proy_crec_men
      , sum(ajuste_estimado_terr) ajuste_estimado_terr
      , sum(proy_ajuste_men) proy_ajuste_men
      , sum(saldmedi_junio) saldmedi_junio
      , sum(porc_saldmedi_junio) porc_saldmedi_junio
      , sum(sald_dic_ante) sald_dic_ante
      , sum(saldmedi_dic) saldmedi_dic
      , sum(porc_saldmedi_dic) porc_saldmedi_dic
      , sum(fac_aju_sal_pun) fac_aju_sal_pun
      , sum(hist_bajas) hist_bajas
      , sum(met_messald_punt) met_messald_punt
      , sum(met_ger_ofi) met_ger_ofi
      , '' prioridad
      , avg(mes_eval) mes_eval
      , sum(ind_dor) ind_dor
      , sum(var_mes) var_mes
      , sum(ajus_ppto) ajus_ppto
      , sum(desv_ppto_ajus) desv_ppto_ajus
      , sum(fact_ajus_terri) fact_ajus_terri
      , sum(fact_asig_gte_of) fact_asig_gte_of 
    from iido.tiido_planes t 
    where t.cod_terr = p_codTerritorio 
      and t.cod_ofic = p_codOficina
      and t.anho_plan = p_mes
      and t.mes_plan = p_anho
      and exists(select e.cod_epigrafe from tiido_epigrafe e where e.cod_epigrafe = t.cod_epigrafe and e.anho = p_anho)  
    group by cod_epigrafe, nom_epigrafe;
    commit; 
  exception
  when others then
    rollback; 
  end proc_consulta_planes;
end pk_planes;
/
create or replace package body iido.pk_perfil is
  procedure proc_consulta_perfil(p_codCargo varchar2, sys_perfil out sys_refcursor)
  as
  begin
    open sys_perfil for
    select a.*, b.perfil from iido.tiido_equivalencias a
      inner join iido.tiido_perfiles b on a.cod_per=b.cod_perfil
    where upper(a.cod_car)=upper(p_codCargo);
    commit;
  exception
  when others then
    rollback;
  end proc_consulta_perfil;
end pk_perfil;