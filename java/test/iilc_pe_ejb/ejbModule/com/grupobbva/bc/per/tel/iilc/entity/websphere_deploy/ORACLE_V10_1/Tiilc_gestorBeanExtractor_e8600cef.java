package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_gestorBeanExtractor_e8600cef
 */
public class Tiilc_gestorBeanExtractor_e8600cef extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiilc_gestorBeanExtractor_e8600cef
	 */
	public Tiilc_gestorBeanExtractor_e8600cef() {
		int[] pkCols={1,5,6,7};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_gestorBeanCacheEntryImpl_e8600cef entry=
			(com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_gestorBeanCacheEntryImpl_e8600cef) createDataCacheEntry();

		entry.setDataForCOD_GESTOR(dataRow.getString(dataColumns[0]));
		entry.setDataForNOM_GESTOR(dataRow.getString(dataColumns[1]));
		entry.setDataForREG_GESTOR(dataRow.getString(dataColumns[2]));
		entry.setDataForPERFIL_GESTOR(dataRow.getString(dataColumns[3]));
		entry.setDataForCOD_OFICINA(dataRow.getString(dataColumns[4]));
		entry.setDataForCOD_TERRITORIO(dataRow.getString(dataColumns[5]));
		entry.setDataForCOD_AREA(dataRow.getString(dataColumns[6]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey key=
			new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey();

		key.cod_gestor=dataRow.getString(primaryKeyColumns[0]);
		key.tiilc_oficina_fk_cod_oficina=dataRow.getString(primaryKeyColumns[1]);
		key.tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio=dataRow.getString(primaryKeyColumns[2]);
		key.tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area=dataRow.getString(primaryKeyColumns[3]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiilc_gestor";
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
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_gestorBeanCacheEntryImpl_e8600cef();
	}
}
