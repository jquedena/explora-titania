package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_maestro_planesBeanExtractor_83d95438
 */
public class Tiido_maestro_planesBeanExtractor_83d95438 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_maestro_planesBeanExtractor_83d95438
	 */
	public Tiido_maestro_planesBeanExtractor_83d95438() {
		int[] pkCols={1,2,5,6};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_maestro_planesBeanCacheEntryImpl_83d95438 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_maestro_planesBeanCacheEntryImpl_83d95438) createDataCacheEntry();

		entry.setDataForMES(dataRow.getString(dataColumns[0]));
		entry.setDataForANHO(dataRow.getString(dataColumns[1]));
		entry.setDataForPRIORIDAD(dataRow.getBigDecimal(dataColumns[2]));
		entry.setDataForFEC_GRAB(dataRow.getDate(dataColumns[3]));
		entry.setDataForCOD_OFIC(dataRow.getString(dataColumns[4]));
		entry.setDataForCOD_TERR(dataRow.getString(dataColumns[5]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_maestro_planesKey key=
			new entities.Tiido_maestro_planesKey();

		key.mes=dataRow.getString(primaryKeyColumns[0]);
		key.anho=dataRow.getString(primaryKeyColumns[1]);
		key.tiido_maepla_oficina_fk_cod_ofic=dataRow.getString(primaryKeyColumns[2]);
		key.tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr=dataRow.getString(primaryKeyColumns[3]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_maestro_planes";
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
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_maestro_planesBeanCacheEntryImpl_83d95438();
	}
}
