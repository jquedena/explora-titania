package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_territorioBeanExtractor_9aeef014
 */
public class Tiido_territorioBeanExtractor_9aeef014 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_territorioBeanExtractor_9aeef014
	 */
	public Tiido_territorioBeanExtractor_9aeef014() {
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

		entities.websphere_deploy.ORACLE_V10_1.Tiido_territorioBeanCacheEntryImpl_9aeef014 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_territorioBeanCacheEntryImpl_9aeef014) createDataCacheEntry();

		entry.setDataForCOD_TERR(dataRow.getString(dataColumns[0]));
		entry.setDataForNOM_TERR(dataRow.getString(dataColumns[1]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[2]));
		entry.setDataForFEC_REGI(dataRow.getDate(dataColumns[3]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[4]));
		entry.setDataForFEC_ACTU(dataRow.getDate(dataColumns[5]));
		entry.setDataForESTADO(dataRow.getString(dataColumns[6]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_territorioKey key=
			new entities.Tiido_territorioKey();

		key.cod_terr=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_territorio";
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
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_territorioBeanCacheEntryImpl_9aeef014();
	}
}
