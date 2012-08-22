package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_parametrosBeanExtractor_5280f63c
 */
public class Tiido_parametrosBeanExtractor_5280f63c extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_parametrosBeanExtractor_5280f63c
	 */
	public Tiido_parametrosBeanExtractor_5280f63c() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_parametrosBeanCacheEntryImpl_5280f63c entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_parametrosBeanCacheEntryImpl_5280f63c) createDataCacheEntry();

		entry.setDataForCOD_PARAMETRO(dataRow.getString(dataColumns[0]));
		entry.setDataForFEC_ACCI(dataRow.getDate(dataColumns[1]));
		entry.setDataForFEC_SEGU_1(dataRow.getDate(dataColumns[2]));
		entry.setDataForFEC_SEGU_2(dataRow.getDate(dataColumns[3]));
		entry.setDataForAFEC_ACCI(dataRow.getString(dataColumns[4]));
		entry.setDataForAFEC_SEGU(dataRow.getString(dataColumns[5]));
		entry.setDataForAFEC_PLAN(dataRow.getString(dataColumns[6]));
		entry.setDataForFEC_PLAN(dataRow.getDate(dataColumns[7]));
		entry.setDataForTAP_USU_REGI(dataRow.getString(dataColumns[8]));
		entry.setDataForFEC_REGI(dataRow.getDate(dataColumns[9]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[10]));
		entry.setDataForFEC_ACTU(dataRow.getDate(dataColumns[11]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_parametrosKey key=
			new entities.Tiido_parametrosKey();

		key.cod_parametro=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_parametros";
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
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_parametrosBeanCacheEntryImpl_5280f63c();
	}
}
