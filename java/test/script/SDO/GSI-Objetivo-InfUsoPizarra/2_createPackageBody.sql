spool 2_createPackageBody.log
CREATE OR REPLACE PACKAGE BODY IIDO.PK_OFICINA AS

  PROCEDURE PROC_LIST_OFICINAS(PI_COD_TERR IN VARCHAR2,
                               PI_COD_OFIC IN VARCHAR2,
                               OFICINAS_CUR_REF OUT SYS_REFCURSOR)
  AS
  BEGIN

    OPEN OFICINAS_CUR_REF FOR
    SELECT COD_OFIC, COD_TERR, NOM_OFIC
    FROM IIDO.TIIDO_OFICINA
    WHERE (PI_COD_TERR IS NULL OR COD_TERR = PI_COD_TERR) AND
          (PI_COD_OFIC IS NULL OR COD_OFIC = PI_COD_OFIC) AND
          ESTADO = '1'
    ORDER BY NOM_OFIC;

  END PROC_LIST_OFICINAS;

  PROCEDURE PROC_LIST_OFICINAS_HIJAS(PI_COD_OFIC IN VARCHAR2,
                               OFICINAS_CUR_REF OUT SYS_REFCURSOR)
  AS
    COD_TERRITORIO VARCHAR2(4) := '';
  BEGIN
    SELECT COD_TERR INTO COD_TERRITORIO FROM IIDO.TIIDO_OFICINA WHERE COD_OFIC=PI_COD_OFIC;

    OPEN OFICINAS_CUR_REF FOR
    SELECT A.OFICINA_HIJA_ID COD_OFIC, COD_TERRITORIO COD_TERR, A.DESCRIPCION NOM_OFIC
    FROM IIDO.TIIDO_OFICINA_HIJA A
    WHERE A.OFICINA_ID = PI_COD_OFIC
    ORDER BY A.DESCRIPCION;

  END PROC_LIST_OFICINAS_HIJAS;

END PK_OFICINA;
/
CREATE OR REPLACE PACKAGE BODY IIDO.PK_INFORME_USO AS

  PROCEDURE PROC_LISTA_INFORME_USO(PI_COD_TERR IN VARCHAR2,
                                    PI_COD_OFI  IN VARCHAR2,
                                    PI_FECHA_DESDE IN VARCHAR2,
                                    PI_FECHA_HASTA IN VARCHAR2,
                                    LISTA_INFORME_CUR_REF OUT SYS_REFCURSOR)
   AS

    V_ID_MES NUMBER;
    V_MES_00 VARCHAR2(2);
    V_ANIO VARCHAR2(4);

   BEGIN

    V_ANIO := SUBSTR(PI_FECHA_DESDE, 1, 4);
    V_MES_00 := SUBSTR(PI_FECHA_DESDE, 5, 2);

    SELECT ID_PAR INTO V_ID_MES FROM IIDO.PARAMETRO WHERE PADRE_PAR = 6 AND COD_PAR = V_MES_00;

     OPEN LISTA_INFORME_CUR_REF FOR
     SELECT TE.NOM_TERR, OFI.COD_OFIC, OFI.NOM_OFIC,
            NVL(META.PORCENTAJE, 0) AS PORC_META,
            NVL(LOGRO.PORCENTAJE, 0) AS PORC_LOGRO
     FROM IIDO.TIIDO_OFICINA OFI
      INNER JOIN IIDO.TIIDO_TERRITORIO TE ON TE.COD_TERR = OFI.COD_TERR
      LEFT JOIN
      (
        SELECT OFI.COD_TERR, OFI.COD_OFIC,
               ROUND((SUM(NVL(MET_MENS.INDICADOR,0))*100/COUNT(*))/2) AS PORCENTAJE
        FROM IIDO.TIIDO_OFICINA OFI
              INNER JOIN IIDO.ASIGNACION_RUBRO AR
                  ON (AR.COD_TERR = '-1' OR AR.COD_TERR = OFI.COD_TERR)  AND
                     (AR.COD_OFIC = '-1' OR AR.COD_OFIC = OFI.COD_OFIC) AND
                     (AR.ANIO = -1 OR AR.ANIO = TO_NUMBER(V_ANIO)) AND
                     (AR.MES = -1 OR AR.MES = V_ID_MES)
                LEFT JOIN
                (
                  SELECT DISTINCT COD_TERR, COD_OFIC, ID_RUBRO, 1 AS INDICADOR
                  FROM IIDO.META_MENSUAL
                  WHERE (PI_COD_TERR = '-1' OR COD_TERR = PI_COD_TERR) AND
                        (PI_COD_OFI = '-1' OR COD_OFIC = PI_COD_OFI) AND
                        TO_CHAR(FEC_REGI,'yyyymmdd') <= TO_CHAR(IIDO.PK_UTIL.FC_PRIMER_DIA_UTIL(V_MES_00,V_ANIO),'yyyymmdd')
                ) MET_MENS
                  ON OFI.COD_TERR = MET_MENS.COD_TERR AND
                     OFI.COD_OFIC = MET_MENS.COD_OFIC AND
                     AR.ID_RUBRO = MET_MENS.ID_RUBRO
        WHERE (PI_COD_TERR = '-1' OR OFI.COD_TERR = PI_COD_TERR) AND
               (PI_COD_OFI = '-1' OR OFI.COD_OFIC = PI_COD_OFI)
        GROUP BY OFI.COD_TERR, OFI.COD_OFIC
      ) META
        ON OFI.COD_OFIC = META.COD_OFIC AND
           OFI.COD_TERR = META.COD_TERR
       LEFT JOIN
       (
          SELECT OFI.COD_TERR, OFI.COD_OFIC,
                 ROUND((SUM(NVL(LOGRO.INDICADOR,0))*100/IIDO.PK_UTIL.FC_GET_DIAS_LABORABLES(TO_DATE(PI_FECHA_DESDE,'YYYYMMDD'),TO_DATE(PI_FECHA_HASTA,'YYYYMMDD')))/2) AS PORCENTAJE
          FROM IIDO.TIIDO_OFICINA OFI
           LEFT JOIN
           (
              SELECT DISTINCT COD_OFIC, COD_TERR, TO_CHAR(FEC_REGI,'yyyymmdd') AS FECHA, 1 AS INDICADOR
              FROM IIDO.RUBRO_LOGRO
              WHERE (PI_COD_TERR = '-1' OR COD_TERR = PI_COD_TERR) AND
                    (PI_COD_OFI = '-1' OR COD_OFIC = PI_COD_OFI) AND
                    (PI_FECHA_DESDE IS NULL OR TO_CHAR(FEC_REGI,'yyyymmdd') >= PI_FECHA_DESDE) AND
                    (PI_FECHA_HASTA IS NULL OR TO_CHAR(FEC_REGI,'yyyymmdd') <= PI_FECHA_HASTA)
           ) LOGRO
              ON OFI.COD_TERR = LOGRO.COD_TERR AND
                 OFI.COD_OFIC = LOGRO.COD_OFIC
            WHERE (PI_COD_TERR = '-1' OR OFI.COD_TERR = PI_COD_TERR) AND
                  (PI_COD_OFI = '-1' OR OFI.COD_OFIC = PI_COD_OFI)
            GROUP BY OFI.COD_TERR, OFI.COD_OFIC
          ) LOGRO
            ON OFI.COD_OFIC = LOGRO.COD_OFIC AND
              OFI.COD_TERR = LOGRO.COD_TERR
          WHERE (PI_COD_TERR = '-1' OR OFI.COD_TERR = PI_COD_TERR) AND
                (PI_COD_OFI = '-1' OR OFI.COD_OFIC = PI_COD_OFI) AND
                (TE.ESTADO = '0') AND (OFI.ESTADO = '1') AND
                (SUBSTR(OFI.COD_OFIC, 2, 3)=SUBSTR(OFI.COD_TERR, 2, 3))
          ORDER BY TE.NOM_TERR, OFI.NOM_OFIC;

     END  PROC_LISTA_INFORME_USO;
END PK_INFORME_USO;
/
CREATE OR REPLACE PACKAGE BODY IIDO.PK_OBJETIVO IS
  PROCEDURE PROC_INSERTAR_OBJETIVO(
      P_COD_OFIC IN VARCHAR2
    , P_COD_TERR IN VARCHAR2
    , P_COD_EPIGRAFE IN VARCHAR2
    , P_ANHO IN VARCHAR2
    , P_COD_GESTOR IN VARCHAR2
    , P_MES IN VARCHAR2
    , P_ORDEN IN VARCHAR2
    , P_PORC_ASIG IN NUMBER
    , P_NOM_EPIGRAFE IN VARCHAR2
    , P_NOM_GESTOR IN VARCHAR2
    , P_COD_PERFIL IN VARCHAR2
    , P_USU_REGI IN VARCHAR2
    , P_REF OUT SYS_REFCURSOR)
  IS
    SE_ENCONTRA NUMBER := 0;
    P_COD_META_GESTOR VARCHAR2(8) := '';
    P_ACCION VARCHAR2(1) := '';
    P_ERROR VARCHAR(3000) := '';
  BEGIN
 
    SELECT MAX(COD_META_GESTOR), COUNT(1) INTO P_COD_META_GESTOR, SE_ENCONTRA
    FROM IIDO.TIIDO_METAS_GESTOR WHERE 
      ANHO = P_ANHO AND
      MES = P_MES AND
      COD_TERR = P_COD_TERR AND
      COD_OFIC = P_COD_OFIC AND
      COD_EPIGRAFE = P_COD_EPIGRAFE AND
      COD_GESTOR = P_COD_GESTOR;

    IF SE_ENCONTRA = 0 THEN
      SELECT TRIM(TO_CHAR(MAX(NVL(TO_NUMBER(COD_META_GESTOR), 0)) + 1, '00000000')) INTO P_COD_META_GESTOR FROM IIDO.TIIDO_METAS_GESTOR;
    
      INSERT INTO IIDO.TIIDO_METAS_GESTOR(
          COD_META_GESTOR, COD_TERR, COD_OFIC
        , COD_EPIGRAFE, ANHO, COD_GESTOR
        , MES, ORDEN, PORC_ASIG
        , NOM_EPIGRAFE, NOM_GESTOR, COD_PERFIL
        , ESTADO, USU_REGI, FEC_REGI) VALUES(
          P_COD_META_GESTOR, P_COD_TERR, P_COD_OFIC
        , P_COD_EPIGRAFE, P_ANHO, P_COD_GESTOR
        , P_MES, P_ORDEN, P_PORC_ASIG
        , P_NOM_EPIGRAFE, P_NOM_GESTOR, P_COD_PERFIL
        , 'A', P_USU_REGI, SYSDATE());
      P_ACCION := '1';
    ELSE
      UPDATE IIDO.TIIDO_METAS_GESTOR SET
          PORC_ASIG = P_PORC_ASIG
        , USU_ACTU = P_USU_REGI
        , FEC_ACTU = SYSDATE
      WHERE COD_META_GESTOR = P_COD_META_GESTOR;
      P_ACCION := '2';
    END IF;

    OPEN P_REF FOR SELECT P_COD_META_GESTOR COD_META_GESTOR, P_ACCION ACCION FROM SYS.DUAL;
    COMMIT;
  EXCEPTION
    WHEN OTHERS THEN
      ROLLBACK;
      P_ERROR := SQLERRM || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE;
      OPEN P_REF FOR SELECT P_ERROR COD_META_GESTOR, '-' ACCION FROM SYS.DUAL;
      COMMIT;
  END PROC_INSERTAR_OBJETIVO;
END PK_OBJETIVO;
/
spool off