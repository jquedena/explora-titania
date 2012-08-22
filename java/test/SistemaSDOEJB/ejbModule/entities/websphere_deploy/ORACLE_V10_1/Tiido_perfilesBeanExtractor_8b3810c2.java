package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_perfilesBeanExtractor_8b3810c2
 */
public class Tiido_perfilesBeanExtractor_8b3810c2 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_perfilesBeanExtractor_8b3810c2
	 */
	public Tiido_perfilesBeanExtractor_8b3810c2() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_perfilesBeanCacheEntryImpl_8b3810c2 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_perfilesBeanCacheEntryImpl_8b3810c2) createDataCacheEntry();

		entry.setDataForCOD_PERFIL(dataRow.getString(dataColumns[0]));
		entry.setDataForNOM_PERFIL(dataRow.getString(dataColumns[1]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[2]));
		entry.setDataForFEC_REGI(dataRow.getDate(dataColumns[3]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[4]));
		entry.setDataForFEC_ACTU(dataRow.getDate(dataColumns[5]));
		entry.setDataForPERFIL(dataRow.getString(dataColumns[6]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_perfilesKey key=
			new entities.Tiido_perfilesKey();

		key.cod_perfil=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_perfiles";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 7;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_perfilesBeanCacheEntryImpl_8b3810c2();
	}
}
