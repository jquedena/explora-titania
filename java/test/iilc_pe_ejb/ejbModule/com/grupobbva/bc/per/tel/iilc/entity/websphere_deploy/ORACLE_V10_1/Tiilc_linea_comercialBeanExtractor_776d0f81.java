package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_linea_comercialBeanExtractor_776d0f81
 */
public class Tiilc_linea_comercialBeanExtractor_776d0f81 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiilc_linea_comercialBeanExtractor_776d0f81
	 */
	public Tiilc_linea_comercialBeanExtractor_776d0f81() {
		int[] pkCols={1,2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_linea_comercialBeanCacheEntryImpl_776d0f81 entry=
			(com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_linea_comercialBeanCacheEntryImpl_776d0f81) createDataCacheEntry();

		entry.setDataForCOD_GRUPO(dataRow.getString(dataColumns[0]));
		entry.setDataForCOD_LINCOM(dataRow.getString(dataColumns[1]));
		entry.setDataForDES_LINCOM(dataRow.getString(dataColumns[2]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey key=
			new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey();

		key.cod_grupo=dataRow.getString(primaryKeyColumns[0]);
		key.cod_lincom=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiilc_linea_comercial";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 3;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_linea_comercialBeanCacheEntryImpl_776d0f81();
	}
}
