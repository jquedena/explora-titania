package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_planesBeanExtractor_f95fafaa
 */
public class Tiido_planesBeanExtractor_f95fafaa extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_planesBeanExtractor_f95fafaa
	 */
	public Tiido_planesBeanExtractor_f95fafaa() {
		int[] pkCols={1,2,3,35,36};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_planesBeanCacheEntryImpl_f95fafaa entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_planesBeanCacheEntryImpl_f95fafaa) createDataCacheEntry();

		entry.setDataForMES_PLAN(dataRow.getString(dataColumns[0]));
		entry.setDataForANHO_PLAN(dataRow.getString(dataColumns[1]));
		entry.setDataForCOD_EPIGRAFE(dataRow.getString(dataColumns[2]));
		entry.setDataForNOM_EPIGRAFE(dataRow.getString(dataColumns[3]));
		entry.setDataForPESO_DOR(dataRow.getBigDecimal(dataColumns[4]));
		entry.setDataForMONTO(dataRow.getBigDecimal(dataColumns[5]));
		entry.setDataForPORC_ALCANZADO(dataRow.getBigDecimal(dataColumns[6]));
		entry.setDataForDESV_PPTO(dataRow.getBigDecimal(dataColumns[7]));
		entry.setDataForNRO_MESES_FALT(dataRow.getBigDecimal(dataColumns[8]));
		entry.setDataForPROY_CREC_MEN(dataRow.getBigDecimal(dataColumns[9]));
		entry.setDataForAJUSTE_ESTIMADO_TERR(dataRow.getBigDecimal(dataColumns[10]));
		entry.setDataForPROY_AJUSTE_MEN(dataRow.getBigDecimal(dataColumns[11]));
		entry.setDataForSALDMEDI_JUNIO(dataRow.getBigDecimal(dataColumns[12]));
		entry.setDataForPORC_SALDMEDI_JUNIO(dataRow.getBigDecimal(dataColumns[13]));
		entry.setDataForSALD_DIC_ANTE(dataRow.getBigDecimal(dataColumns[14]));
		entry.setDataForSALDMEDI_DIC(dataRow.getBigDecimal(dataColumns[15]));
		entry.setDataForCOD_TERRI(dataRow.getString(dataColumns[16]));
		entry.setDataForPORC_SALDMEDI_DIC(dataRow.getBigDecimal(dataColumns[17]));
		entry.setDataForFAC_AJU_SAL_PUN(dataRow.getBigDecimal(dataColumns[18]));
		entry.setDataForHIST_BAJAS(dataRow.getBigDecimal(dataColumns[19]));
		entry.setDataForMET_MESSALD_PUNT(dataRow.getBigDecimal(dataColumns[20]));
		entry.setDataForMET_GER_OFI(dataRow.getBigDecimal(dataColumns[21]));
		entry.setDataForPRIORIDAD(dataRow.getBigDecimal(dataColumns[22]));
		entry.setDataForMES_EVAL(dataRow.getString(dataColumns[23]));
		entry.setDataForIND_DOR(dataRow.getString(dataColumns[24]));
		entry.setDataForVAR_MES(dataRow.getBigDecimal(dataColumns[25]));
		entry.setDataForAJUS_PPTO(dataRow.getBigDecimal(dataColumns[26]));
		entry.setDataForDESV_PPTO_AJUS(dataRow.getBigDecimal(dataColumns[27]));
		entry.setDataForFACT_AJUS_TERRI(dataRow.getBigDecimal(dataColumns[28]));
		entry.setDataForFACT_ASIG_GTE_OF(dataRow.getBigDecimal(dataColumns[29]));
		entry.setDataForFEC_ACTU(dataRow.getTimestamp(dataColumns[30]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[31]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[32]));
		entry.setDataForFEC_REGI(dataRow.getTimestamp(dataColumns[33]));
		entry.setDataForCOD_OFIC(dataRow.getString(dataColumns[34]));
		entry.setDataForCOD_TERR(dataRow.getString(dataColumns[35]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_planesKey key=
			new entities.Tiido_planesKey();

		key.mes_plan=dataRow.getString(primaryKeyColumns[0]);
		key.anho_plan=dataRow.getString(primaryKeyColumns[1]);
		key.cod_epigrafe=dataRow.getString(primaryKeyColumns[2]);
		key.tiido_pla_oficina_fk_cod_ofic=dataRow.getString(primaryKeyColumns[3]);
		key.tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr=dataRow.getString(primaryKeyColumns[4]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_planes";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 35;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_planesBeanCacheEntryImpl_f95fafaa();
	}
}
