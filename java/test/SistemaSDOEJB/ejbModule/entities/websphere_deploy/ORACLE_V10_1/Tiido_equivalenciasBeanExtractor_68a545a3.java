package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_equivalenciasBeanExtractor_68a545a3
 */
public class Tiido_equivalenciasBeanExtractor_68a545a3 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_equivalenciasBeanExtractor_68a545a3
	 */
	public Tiido_equivalenciasBeanExtractor_68a545a3() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_equivalenciasBeanCacheEntryImpl_68a545a3 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_equivalenciasBeanCacheEntryImpl_68a545a3) createDataCacheEntry();

		entry.setDataForCOD_CAR(dataRow.getString(dataColumns[0]));
		entry.setDataForCOD_PER(dataRow.getString(dataColumns[1]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[2]));
		entry.setDataForFEC_REGI(dataRow.getDate(dataColumns[3]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[4]));
		entry.setDataForFEC_ACTU(dataRow.getDate(dataColumns[5]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_equivalenciasKey key=
			new entities.Tiido_equivalenciasKey();

		key.cod_car=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_equivalencias";
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
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_equivalenciasBeanCacheEntryImpl_68a545a3();
	}
}
