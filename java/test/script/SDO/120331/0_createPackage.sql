create or replace package iido.pkg_carga_datos
as
  type refcursor is ref cursor;
  -- funciones
  --//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
  function is_date(cdate in varchar2)
    return int;
  function is_number(cnumber in varchar2) 
    return int;
  -- procedimientos
  --//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
  procedure sp_valida_carga(exitCode out number, errMsg out varchar2);
  procedure sp_valida_carga_periodo(periodo in varchar2, exitCode out number, errMsg out varchar2);
  procedure sp_carga_datos_mis(exitCode out number, errMsg out varchar2);
  procedure sp_cambia_estado(exitCode out number, errMsg out varchar2);
end pkg_carga_datos;
/