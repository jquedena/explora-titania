package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_oficinaBeanExtractor_9f94ea7f
 */
public class Tiilc_oficinaBeanExtractor_9f94ea7f extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiilc_oficinaBeanExtractor_9f94ea7f
	 */
	public Tiilc_oficinaBeanExtractor_9f94ea7f() {
		int[] pkCols={1,3,4};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanCacheEntryImpl_9f94ea7f entry=
			(com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanCacheEntryImpl_9f94ea7f) createDataCacheEntry();

		entry.setDataForCOD_OFICINA(dataRow.getString(dataColumns[0]));
		entry.setDataForDES_OFICINA(dataRow.getString(dataColumns[1]));
		entry.setDataForCOD_TERRITORIO(dataRow.getString(dataColumns[2]));
		entry.setDataForCOD_AREA(dataRow.getString(dataColumns[3]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key=
			new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey();

		key.cod_oficina=dataRow.getString(primaryKeyColumns[0]);
		key.tiilc_territorio_fk_cod_territorio=dataRow.getString(primaryKeyColumns[1]);
		key.tiilc_territorio_fk_tiilc_area_fk_cod_area=dataRow.getString(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiilc_oficina";
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
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanCacheEntryImpl_9f94ea7f();
	}
}
