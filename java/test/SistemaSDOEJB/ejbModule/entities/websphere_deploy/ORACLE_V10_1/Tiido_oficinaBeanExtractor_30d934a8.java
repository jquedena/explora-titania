package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_oficinaBeanExtractor_30d934a8
 */
public class Tiido_oficinaBeanExtractor_30d934a8 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_oficinaBeanExtractor_30d934a8
	 */
	public Tiido_oficinaBeanExtractor_30d934a8() {
		int[] pkCols={1,8};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_oficinaBeanCacheEntryImpl_30d934a8 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_oficinaBeanCacheEntryImpl_30d934a8) createDataCacheEntry();

		entry.setDataForCOD_OFIC(dataRow.getString(dataColumns[0]));
		entry.setDataForNOM_OFIC(dataRow.getString(dataColumns[1]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[2]));
		entry.setDataForFEC_REGI(dataRow.getDate(dataColumns[3]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[4]));
		entry.setDataForFEC_ACTU(dataRow.getDate(dataColumns[5]));
		entry.setDataForESTADO(dataRow.getString(dataColumns[6]));
		entry.setDataForCOD_TERR(dataRow.getString(dataColumns[7]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_oficinaKey key=
			new entities.Tiido_oficinaKey();

		key.cod_ofic=dataRow.getString(primaryKeyColumns[0]);
		key.tiido_territorio_fk_cod_terr=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_oficina";
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
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_oficinaBeanCacheEntryImpl_30d934a8();
	}
}
