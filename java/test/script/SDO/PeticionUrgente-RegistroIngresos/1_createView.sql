CREATE OR REPLACE VIEW IIDO.VIIDO_INGRESOS AS
SELECT A.COD_USUARIO ,
    A.NOMBRES ,
    A.CARGO ,
    NVL(A.NOM_TERRITORIO, D.NOM_TERR) NOM_TERRITORIO,
    A.COD_OFICINA ,
    C.NOM_OFIC ,
    TO_CHAR(A.FECHA, 'DD/MM/YYYY') FECHA ,
    TO_CHAR(A.FECHA, 'DDMMYYYY') FECHA2 ,
    NVL(D.COD_TERR, '****') COD_TERR ,
    COUNT(A.COD_USUARIO) CTA ,
    TO_NUMBER(TO_CHAR(A.FECHA, 'MM')) MES ,
    TO_NUMBER(TO_CHAR(A.FECHA, 'YYYY')) ANIO
  FROM (
    SELECT AX.COD_USUARIO, AX.NOMBRES, AX.CARGO, AX.NOM_TERRITORIO, AX.COD_OFICINA, AX.FECHA FROM IIDO.TIIDO_INGRESOS AX
    UNION ALL
    SELECT AX.COD_USUARIO
      , BX.NOMBRES
      , BX.CARGO
      , BX.NOM_TERRITORIO
      , BX.COD_OFICINA
      , AX.FECHA_ACT FECHA
    FROM IIDO.TIIDO_INGRESOS_FORM AX
      INNER JOIN IIDO.TIIDO_INGRESOS BX ON AX.COD_USUARIO=BX.COD_USUARIO AND TO_CHAR(AX.FECHA_ACT, 'MMYYYY')=TO_CHAR(BX.FECHA, 'MMYYYY')
  ) A
    LEFT JOIN (
      SELECT COD_OFIC, COD_TERR, NOM_OFIC FROM IIDO.TIIDO_OFICINA
      UNION ALL
      SELECT OFICINA_HIJA_ID, B.COD_TERR, DESCRIPCION FROM IIDO.TIIDO_OFICINA_HIJA A INNER JOIN IIDO.TIIDO_OFICINA B ON A.OFICINA_ID=B.COD_OFIC 
    ) C ON A.COD_OFICINA=C.COD_OFIC
    LEFT JOIN IIDO.TIIDO_TERRITORIO D ON C.COD_TERR=D.COD_TERR
  GROUP BY A.COD_USUARIO ,
    A.NOMBRES ,
    A.CARGO ,
    NVL(A.NOM_TERRITORIO, D.NOM_TERR),
    A.COD_OFICINA ,
    C.NOM_OFIC ,
    TO_CHAR(A.FECHA, 'DD/MM/YYYY') ,
    TO_CHAR(A.FECHA, 'DDMMYYYY') ,
    NVL(D.COD_TERR, '****') ,
    TO_NUMBER(TO_CHAR(A.FECHA, 'MM')) ,
    TO_NUMBER(TO_CHAR(A.FECHA, 'YYYY'));
