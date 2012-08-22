package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_epigrafeBeanExtractor_b2c8f8ed
 */
public class Tiido_epigrafeBeanExtractor_b2c8f8ed extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_epigrafeBeanExtractor_b2c8f8ed
	 */
	public Tiido_epigrafeBeanExtractor_b2c8f8ed() {
		int[] pkCols={1,2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanCacheEntryImpl_b2c8f8ed entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanCacheEntryImpl_b2c8f8ed) createDataCacheEntry();

		entry.setDataForCOD_EPIGRAFE(dataRow.getString(dataColumns[0]));
		entry.setDataForANHO(dataRow.getString(dataColumns[1]));
		entry.setDataForNOM_EPIGRAFE(dataRow.getString(dataColumns[2]));
		entry.setDataForIND_CLASE(dataRow.getString(dataColumns[3]));
		entry.setDataForIND_SUB_CLASE(dataRow.getString(dataColumns[4]));
		entry.setDataForORDEN(dataRow.getString(dataColumns[5]));
		entry.setDataForIND_GRUPO(dataRow.getString(dataColumns[6]));
		entry.setDataForABREVIATURA(dataRow.getString(dataColumns[7]));
		entry.setDataForIND_HIJO(dataRow.getString(dataColumns[8]));
		entry.setDataForIND_AFECTA(dataRow.getString(dataColumns[9]));
		entry.setDataForPORCENTAJE_MAX(dataRow.getBigDecimal(dataColumns[10]));
		entry.setDataForPORCENTAJE_MIN(dataRow.getBigDecimal(dataColumns[11]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_epigrafeKey key=
			new entities.Tiido_epigrafeKey();

		key.cod_epigrafe=dataRow.getString(primaryKeyColumns[0]);
		key.anho=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_epigrafe";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 12;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanCacheEntryImpl_b2c8f8ed();
	}
}
