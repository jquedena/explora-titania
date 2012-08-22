package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_permiso_perfilBeanExtractor_edfb184d
 */
public class Tiido_permiso_perfilBeanExtractor_edfb184d extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_permiso_perfilBeanExtractor_edfb184d
	 */
	public Tiido_permiso_perfilBeanExtractor_edfb184d() {
		int[] pkCols={1,2,3};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_permiso_perfilBeanCacheEntryImpl_edfb184d entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_permiso_perfilBeanCacheEntryImpl_edfb184d) createDataCacheEntry();

		entry.setDataForCOD_PERFIL(dataRow.getString(dataColumns[0]));
		entry.setDataForTIP_ACCESO(dataRow.getString(dataColumns[1]));
		entry.setDataForVALOR_RCP(dataRow.getString(dataColumns[2]));
		entry.setDataForUSUARIO(dataRow.getString(dataColumns[3]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[4]));
		entry.setDataForFEC_REGI(dataRow.getTimestamp(dataColumns[5]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[6]));
		entry.setDataForFEC_ACTU(dataRow.getTimestamp(dataColumns[7]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_permiso_perfilKey key=
			new entities.Tiido_permiso_perfilKey();

		key.cod_perfil=dataRow.getString(primaryKeyColumns[0]);
		key.tip_acceso=dataRow.getString(primaryKeyColumns[1]);
		key.valor_rcp=dataRow.getString(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_permiso_perfil";
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
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_permiso_perfilBeanCacheEntryImpl_edfb184d();
	}
}
