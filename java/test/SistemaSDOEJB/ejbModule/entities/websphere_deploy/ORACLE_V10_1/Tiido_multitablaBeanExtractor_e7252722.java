package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_multitablaBeanExtractor_e7252722
 */
public class Tiido_multitablaBeanExtractor_e7252722 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_multitablaBeanExtractor_e7252722
	 */
	public Tiido_multitablaBeanExtractor_e7252722() {
		int[] pkCols={1,2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_multitablaBeanCacheEntryImpl_e7252722 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_multitablaBeanCacheEntryImpl_e7252722) createDataCacheEntry();

		entry.setDataForCOD_MULT(dataRow.getString(dataColumns[0]));
		entry.setDataForCOD_ELEM(dataRow.getString(dataColumns[1]));
		entry.setDataForVALOR1(dataRow.getString(dataColumns[2]));
		entry.setDataForVALOR2(dataRow.getString(dataColumns[3]));
		entry.setDataForVALOR3(dataRow.getString(dataColumns[4]));
		entry.setDataForVALOR4(dataRow.getString(dataColumns[5]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_multitablaKey key=
			new entities.Tiido_multitablaKey();

		key.cod_mult=dataRow.getString(primaryKeyColumns[0]);
		key.cod_elem=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_multitabla";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 6;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_multitablaBeanCacheEntryImpl_e7252722();
	}
}
