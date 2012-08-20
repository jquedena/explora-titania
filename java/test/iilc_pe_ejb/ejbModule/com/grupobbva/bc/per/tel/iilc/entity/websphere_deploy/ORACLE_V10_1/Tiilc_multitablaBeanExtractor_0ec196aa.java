package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_multitablaBeanExtractor_0ec196aa
 */
public class Tiilc_multitablaBeanExtractor_0ec196aa extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiilc_multitablaBeanExtractor_0ec196aa
	 */
	public Tiilc_multitablaBeanExtractor_0ec196aa() {
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

		com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_multitablaBeanCacheEntryImpl_0ec196aa entry=
			(com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_multitablaBeanCacheEntryImpl_0ec196aa) createDataCacheEntry();

		entry.setDataForCOD_MULT(dataRow.getString(dataColumns[0]));
		entry.setDataForCOD_ELE(dataRow.getString(dataColumns[1]));
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

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey key=
			new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey();

		key.cod_mult=dataRow.getString(primaryKeyColumns[0]);
		key.cod_ele=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiilc_multitabla";
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
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_multitablaBeanCacheEntryImpl_0ec196aa();
	}
}
