package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_areaBeanExtractor_fdd98ec5
 */
public class Tiilc_areaBeanExtractor_fdd98ec5 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiilc_areaBeanExtractor_fdd98ec5
	 */
	public Tiilc_areaBeanExtractor_fdd98ec5() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_areaBeanCacheEntryImpl_fdd98ec5 entry=
			(com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_areaBeanCacheEntryImpl_fdd98ec5) createDataCacheEntry();

		entry.setDataForCOD_AREA(dataRow.getString(dataColumns[0]));
		entry.setDataForDES_AREA(dataRow.getString(dataColumns[1]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey key=
			new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey();

		key.cod_area=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiilc_area";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 2;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_areaBeanCacheEntryImpl_fdd98ec5();
	}
}
