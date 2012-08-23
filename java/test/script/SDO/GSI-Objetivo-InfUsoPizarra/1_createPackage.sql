spool 1_createPackage.log
CREATE OR REPLACE PACKAGE IIDO.PK_OBJETIVO IS
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
    , P_REF OUT SYS_REFCURSOR);
END PK_OBJETIVO;
/
spool off