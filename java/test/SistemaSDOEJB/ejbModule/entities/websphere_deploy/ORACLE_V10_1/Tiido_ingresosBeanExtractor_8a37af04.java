package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_ingresosBeanExtractor_8a37af04
 */
public class Tiido_ingresosBeanExtractor_8a37af04 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_ingresosBeanExtractor_8a37af04
	 */
	public Tiido_ingresosBeanExtractor_8a37af04() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_ingresosBeanCacheEntryImpl_8a37af04 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_ingresosBeanCacheEntryImpl_8a37af04) createDataCacheEntry();

		entry.setDataForID_INGRESOS(dataRow.getBigDecimal(dataColumns[0]));
		entry.setDataForVECES(dataRow.getString(dataColumns[1]));
		entry.setDataForVALIDO_VECES(dataRow.getString(dataColumns[2]));
		entry.setDataForCOD_USUARIO(dataRow.getString(dataColumns[3]));
		entry.setDataForCARGO(dataRow.getString(dataColumns[4]));
		entry.setDataForNOM_TERRITORIO(dataRow.getString(dataColumns[5]));
		entry.setDataForCOD_OFICINA(dataRow.getString(dataColumns[6]));
		entry.setDataForFECHA(dataRow.getString(dataColumns[7]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_ingresosKey key=
			new entities.Tiido_ingresosKey();

		key.id_ingresos=dataRow.getBigDecimal(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_ingresos";
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
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_ingresosBeanCacheEntryImpl_8a37af04();
	}
}
