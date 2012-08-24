spool 4_loadInitialData.log
insert into IIDO.PARAMETRO (ID_PAR, TIP_PAR, COD_PAR, NOM_PAR, DES_PAR, PADRE_PAR, VAL_ENT_PAR, VAL_DEC_PAR, VAL_TEX_PAR, USU_REGI, FEC_REGI, USU_ACTU, FEC_ACTU, EST_REG) values (45, 3, '', 'Cargos Gerentes', '', null, null, null, '''B21'',''CE0'',''CN1''', 'ADMIN', sysdate, '', null, 'A');
insert into IIDO.PARAMETRO (ID_PAR, TIP_PAR, COD_PAR, NOM_PAR, DES_PAR, PADRE_PAR, VAL_ENT_PAR, VAL_DEC_PAR, VAL_TEX_PAR, USU_REGI, FEC_REGI, USU_ACTU, FEC_ACTU, EST_REG) values (46, 3, '', 'Cargos Sin SubGerentes', '', null, null, null, '''B67'',''B23'',''B25'',''B52''', 'ADMIN', sysdate, '', null, 'A');
insert into IIDO.PARAMETRO (ID_PAR, TIP_PAR, COD_PAR, NOM_PAR, DES_PAR, PADRE_PAR, VAL_ENT_PAR, VAL_DEC_PAR, VAL_TEX_PAR, USU_REGI, FEC_REGI, USU_ACTU, FEC_ACTU, EST_REG) values (47, 3, '', 'Cargos Usuarios', '', null, null, null, '''B41'',''B67'',''B23'',''B25'',''B52''', 'ADMIN', sysdate, '', null, 'A');
insert into IIDO.PARAMETRO (ID_PAR, TIP_PAR, COD_PAR, NOM_PAR, DES_PAR, PADRE_PAR, VAL_ENT_PAR, VAL_DEC_PAR, VAL_TEX_PAR, USU_REGI, FEC_REGI, USU_ACTU, FEC_ACTU, EST_REG) values (48, 3, '', 'Cargos GOF', '', null, null, null, '''B21''', 'ADMIN', sysdate, '', null, 'A');
commit;
/
spool off