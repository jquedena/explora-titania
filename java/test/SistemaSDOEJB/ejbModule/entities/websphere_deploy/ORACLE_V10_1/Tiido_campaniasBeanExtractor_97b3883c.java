package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_campaniasBeanExtractor_97b3883c
 */
public class Tiido_campaniasBeanExtractor_97b3883c extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_campaniasBeanExtractor_97b3883c
	 */
	public Tiido_campaniasBeanExtractor_97b3883c() {
		int[] pkCols={1,2,3,12,13};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_campaniasBeanCacheEntryImpl_97b3883c entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_campaniasBeanCacheEntryImpl_97b3883c) createDataCacheEntry();

		entry.setDataForCOD_CAMP(dataRow.getInt(dataColumns[0]), dataRow.wasNull());
		entry.setDataForANHO(dataRow.getString(dataColumns[1]));
		entry.setDataForMES(dataRow.getString(dataColumns[2]));
		entry.setDataForNOM_CAMP(dataRow.getString(dataColumns[3]));
		entry.setDataForCOD_GEST(dataRow.getString(dataColumns[4]));
		entry.setDataForORDEN(dataRow.getString(dataColumns[5]));
		entry.setDataForGTE(dataRow.getString(dataColumns[6]));
		entry.setDataForFEC_REGI(dataRow.getDate(dataColumns[7]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[8]));
		entry.setDataForFEC_ACTU(dataRow.getDate(dataColumns[9]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[10]));
		entry.setDataForCOD_OFIC(dataRow.getString(dataColumns[11]));
		entry.setDataForCOD_TERR(dataRow.getString(dataColumns[12]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_campaniasKey key=
			new entities.Tiido_campaniasKey();

		key.cod_camp=new Integer(dataRow.getInt(primaryKeyColumns[0]));
		key.anho=dataRow.getString(primaryKeyColumns[1]);
		key.mes=dataRow.getString(primaryKeyColumns[2]);
		key.tiido_cam_oficina_fk_cod_ofic=dataRow.getString(primaryKeyColumns[3]);
		key.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr=dataRow.getString(primaryKeyColumns[4]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_campanias";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 12;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_campaniasBeanCacheEntryImpl_97b3883c();
	}
}
