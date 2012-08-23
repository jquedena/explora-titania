create or replace view viido_ingresos_modificados as
select t.cod_usuario
  , t.nombres nombres
  , t.cargo cargo
  , '****' cod_terr
  , t.nom_territorio territorio
  , t.cod_oficina cod_ofi
  , x.nom_ofic desc_ofi
  , nvl(c.cod_gestor_m, '***') cod_gestor_m
  , nvl(c.cod_oficina_m, '***') cod_oficina_m
  , max(nvl((select z.nom_gestor || '|' || z.cod_perfil
    from iido.tiido_metas_gestor z
    where z.cod_gestor=c.cod_gestor_m
          and z.cod_ofic=c.cod_oficina_m
          and z.anho=c.anio
          and z.mes=lpad(trim(c.mes), 2, '0')
          and rownum=1), '')) nom_gestor_m
  , c.nom_ofic nom_ofic_m
  , c.nom_terr nom_terr_m
  , nvl(c.mes, to_char(t.fecha, 'mm')) mes
  , nvl(c.anio, to_char(t.fecha, 'yyyy')) anio
  , to_char(t.fecha, 'ddmmyyyy') fecha
  , sum(t.cta) cta
from (
     select a.cod_usuario, a.cod_oficina, a.cargo, a.nom_territorio, a.fecha fecha, a.nombres, count(*) cta
     from iido.tiido_ingresos a
     group by a.cod_usuario, a.cod_oficina, a.cargo, a.nom_territorio, a.fecha, a.nombres) t
  left join iido.tiido_oficina x on t.cod_oficina=x.cod_ofic
  left join (
    select cod_usuario
      , nom_ofic
      , nom_terr
      , cod_gestor_m
      , cod_oficina_m
      , to_char(fecha_act, 'ddmmyyyy') fecha
      , mes
      , anio
    from iido.viido_ingresos_form
    group by cod_usuario
      , nom_ofic
      , nom_terr
      , cod_gestor_m
      , cod_oficina_m
      , to_char(fecha_act, 'ddmmyyyy')
      , mes
      , anio
  ) c on t.cod_usuario=c.cod_usuario and to_char(t.fecha, 'ddmmyyyy')=c.fecha
group by t.cod_usuario
  , t.nombres
  , t.cargo
  , t.nom_territorio
  , t.cod_oficina
  , x.nom_ofic
  , nvl(c.mes, to_char(t.fecha, 'mm'))
  , nvl(c.anio, to_char(t.fecha, 'yyyy'))
  , c.cod_gestor_m
  , c.cod_oficina_m
  , c.nom_ofic
  , c.nom_terr
  , to_char(t.fecha, 'ddmmyyyy');
