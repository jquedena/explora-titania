package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_metas_gestorBeanExtractor_238e66e0
 */
public class Tiido_metas_gestorBeanExtractor_238e66e0 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_metas_gestorBeanExtractor_238e66e0
	 */
	public Tiido_metas_gestorBeanExtractor_238e66e0() {
		int[] pkCols={1,14,15,16,17};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_metas_gestorBeanCacheEntryImpl_238e66e0 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_metas_gestorBeanCacheEntryImpl_238e66e0) createDataCacheEntry();

		entry.setDataForCOD_META_GESTOR(dataRow.getString(dataColumns[0]));
		entry.setDataForCOD_GESTOR(dataRow.getString(dataColumns[1]));
		entry.setDataForMES(dataRow.getString(dataColumns[2]));
		entry.setDataForORDEN(dataRow.getString(dataColumns[3]));
		entry.setDataForFEC_REGI(dataRow.getDate(dataColumns[4]));
		entry.setDataForPORC_ASIG(dataRow.getBigDecimal(dataColumns[5]));
		entry.setDataForNOM_EPIGRAFE(dataRow.getString(dataColumns[6]));
		entry.setDataForNOM_GESTOR(dataRow.getString(dataColumns[7]));
		entry.setDataForCOD_PERFIL(dataRow.getString(dataColumns[8]));
		entry.setDataForESTADO(dataRow.getString(dataColumns[9]));
		entry.setDataForFEC_ACTU(dataRow.getTimestamp(dataColumns[10]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[11]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[12]));
		entry.setDataForCOD_EPIGRAFE(dataRow.getString(dataColumns[13]));
		entry.setDataForANHO(dataRow.getString(dataColumns[14]));
		entry.setDataForCOD_OFIC(dataRow.getString(dataColumns[15]));
		entry.setDataForCOD_TERR(dataRow.getString(dataColumns[16]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_metas_gestorKey key=
			new entities.Tiido_metas_gestorKey();

		key.cod_meta_gestor=dataRow.getString(primaryKeyColumns[0]);
		key.tiido_metges_epigrafe_fk_cod_epigrafe=dataRow.getString(primaryKeyColumns[1]);
		key.tiido_metges_epigrafe_fk_anho=dataRow.getString(primaryKeyColumns[2]);
		key.tiido_metges_oficina_fk_cod_ofic=dataRow.getString(primaryKeyColumns[3]);
		key.tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr=dataRow.getString(primaryKeyColumns[4]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_metas_gestor";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 15;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_metas_gestorBeanCacheEntryImpl_238e66e0();
	}
}
