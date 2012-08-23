spool 3_createView.log
CREATE OR REPLACE VIEW VIIDO_GESTORES AS
SELECT A.NOM_GESTOR, B.COD_PERFIL, A.ANHO, A.MES, A.COD_OFIC, A.COD_TERR, A.COD_GESTOR
FROM (
  SELECT MIN(UPPER(NOM_GESTOR)) NOM_GESTOR, COD_PERFIL, ANHO
    , MES, COD_OFIC, COD_TERR, COD_GESTOR
    , MAX(COD_META_GESTOR) COD_META_GESTOR
  FROM IIDO.TIIDO_METAS_GESTOR
  GROUP BY COD_PERFIL, ANHO, MES, COD_OFIC, COD_TERR, COD_GESTOR) A
INNER JOIN IIDO.TIIDO_METAS_GESTOR B ON A.COD_META_GESTOR=B.COD_META_GESTOR;
/
spool