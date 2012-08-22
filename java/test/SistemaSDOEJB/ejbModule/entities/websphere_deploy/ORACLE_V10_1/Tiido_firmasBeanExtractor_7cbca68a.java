package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_firmasBeanExtractor_7cbca68a
 */
public class Tiido_firmasBeanExtractor_7cbca68a extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_firmasBeanExtractor_7cbca68a
	 */
	public Tiido_firmasBeanExtractor_7cbca68a() {
		int[] pkCols={1,8,9};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_firmasBeanCacheEntryImpl_7cbca68a entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_firmasBeanCacheEntryImpl_7cbca68a) createDataCacheEntry();

		entry.setDataForCOD_FIRMA(dataRow.getString(dataColumns[0]));
		entry.setDataForANHO_FIRM(dataRow.getString(dataColumns[1]));
		entry.setDataForMES_FIRM(dataRow.getString(dataColumns[2]));
		entry.setDataForITEM_FIRM(dataRow.getString(dataColumns[3]));
		entry.setDataForCOD_GESTOR(dataRow.getString(dataColumns[4]));
		entry.setDataForDESCRIPCION(dataRow.getString(dataColumns[5]));
		entry.setDataForFEC_FIRM(dataRow.getDate(dataColumns[6]));
		entry.setDataForCOD_OFIC(dataRow.getString(dataColumns[7]));
		entry.setDataForCOD_TERR(dataRow.getString(dataColumns[8]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_firmasKey key=
			new entities.Tiido_firmasKey();

		key.cod_firma=dataRow.getString(primaryKeyColumns[0]);
		key.tiido_fir_oficina_fk_cod_ofic=dataRow.getString(primaryKeyColumns[1]);
		key.tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr=dataRow.getString(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_firmas";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 8;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_firmasBeanCacheEntryImpl_7cbca68a();
	}
}
