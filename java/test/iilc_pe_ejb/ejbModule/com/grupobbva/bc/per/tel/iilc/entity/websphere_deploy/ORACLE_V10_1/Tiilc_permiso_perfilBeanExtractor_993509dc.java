package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_permiso_perfilBeanExtractor_993509dc
 */
public class Tiilc_permiso_perfilBeanExtractor_993509dc extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiilc_permiso_perfilBeanExtractor_993509dc
	 */
	public Tiilc_permiso_perfilBeanExtractor_993509dc() {
		int[] pkCols={1,2,3};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_permiso_perfilBeanCacheEntryImpl_993509dc entry=
			(com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_permiso_perfilBeanCacheEntryImpl_993509dc) createDataCacheEntry();

		entry.setDataForCOD_PERFIL(dataRow.getString(dataColumns[0]));
		entry.setDataForTIPO_ACCESO(dataRow.getBigDecimal(dataColumns[1]));
		entry.setDataForVALOR_RCP(dataRow.getString(dataColumns[2]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey key=
			new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey();

		key.cod_perfil=dataRow.getString(primaryKeyColumns[0]);
		key.tipo_acceso=dataRow.getBigDecimal(primaryKeyColumns[1]);
		key.valor_rcp=dataRow.getString(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiilc_permiso_perfil";
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
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_permiso_perfilBeanCacheEntryImpl_993509dc();
	}
}
