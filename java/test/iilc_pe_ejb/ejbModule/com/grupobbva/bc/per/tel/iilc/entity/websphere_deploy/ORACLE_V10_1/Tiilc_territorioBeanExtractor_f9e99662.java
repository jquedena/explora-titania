package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_territorioBeanExtractor_f9e99662
 */
public class Tiilc_territorioBeanExtractor_f9e99662 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiilc_territorioBeanExtractor_f9e99662
	 */
	public Tiilc_territorioBeanExtractor_f9e99662() {
		int[] pkCols={1,3};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_territorioBeanCacheEntryImpl_f9e99662 entry=
			(com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_territorioBeanCacheEntryImpl_f9e99662) createDataCacheEntry();

		entry.setDataForCOD_TERRITORIO(dataRow.getString(dataColumns[0]));
		entry.setDataForDES_TERRITORIO(dataRow.getString(dataColumns[1]));
		entry.setDataForCOD_AREA(dataRow.getString(dataColumns[2]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key=
			new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey();

		key.cod_territorio=dataRow.getString(primaryKeyColumns[0]);
		key.tiilc_area_fk_cod_area=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiilc_territorio";
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
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_territorioBeanCacheEntryImpl_f9e99662();
	}
}
