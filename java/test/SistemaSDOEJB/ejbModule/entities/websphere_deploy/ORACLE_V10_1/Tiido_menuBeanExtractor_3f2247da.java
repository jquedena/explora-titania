package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_menuBeanExtractor_3f2247da
 */
public class Tiido_menuBeanExtractor_3f2247da extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_menuBeanExtractor_3f2247da
	 */
	public Tiido_menuBeanExtractor_3f2247da() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_menuBeanCacheEntryImpl_3f2247da entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_menuBeanCacheEntryImpl_3f2247da) createDataCacheEntry();

		entry.setDataForPADRE(dataRow.getString(dataColumns[0]));
		entry.setDataForLINK(dataRow.getString(dataColumns[1]));
		entry.setDataForHIJO(dataRow.getString(dataColumns[2]));
		entry.setDataForDESCRIPCION(dataRow.getString(dataColumns[3]));
		entry.setDataForCOD_PERFIL(dataRow.getString(dataColumns[4]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_menuKey key=
			new entities.Tiido_menuKey();

		key.padre=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_menu";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 5;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_menuBeanCacheEntryImpl_3f2247da();
	}
}
