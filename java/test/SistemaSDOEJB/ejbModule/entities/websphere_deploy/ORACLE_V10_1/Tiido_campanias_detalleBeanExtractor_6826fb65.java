package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_campanias_detalleBeanExtractor_6826fb65
 */
public class Tiido_campanias_detalleBeanExtractor_6826fb65 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_campanias_detalleBeanExtractor_6826fb65
	 */
	public Tiido_campanias_detalleBeanExtractor_6826fb65() {
		int[] pkCols={1,18,19,20,21,22};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_campanias_detalleBeanCacheEntryImpl_6826fb65 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_campanias_detalleBeanCacheEntryImpl_6826fb65) createDataCacheEntry();

		entry.setDataForCOD_CAMP_DETA(dataRow.getInt(dataColumns[0]), dataRow.wasNull());
		entry.setDataForNOM_CAMP(dataRow.getString(dataColumns[1]));
		entry.setDataForCOD_GEST(dataRow.getString(dataColumns[2]));
		entry.setDataForNRO_CLIE(dataRow.getBigDecimal(dataColumns[3]));
		entry.setDataForCOMP_GEST(dataRow.getBigDecimal(dataColumns[4]));
		entry.setDataForNRO_GEST_SEGU_1(dataRow.getBigDecimal(dataColumns[5]));
		entry.setDataForNRO_CONC_SEGU_1(dataRow.getBigDecimal(dataColumns[6]));
		entry.setDataForMONT_SEGU_1(dataRow.getBigDecimal(dataColumns[7]));
		entry.setDataForNRO_GEST_SEGU_2(dataRow.getBigDecimal(dataColumns[8]));
		entry.setDataForNRO_CONC_SEGU_2(dataRow.getBigDecimal(dataColumns[9]));
		entry.setDataForMONT_SEGU_2(dataRow.getBigDecimal(dataColumns[10]));
		entry.setDataForFEC_REGI(dataRow.getDate(dataColumns[11]));
		entry.setDataForFEC_SEGU_1(dataRow.getDate(dataColumns[12]));
		entry.setDataForFEC_SEGU_2(dataRow.getDate(dataColumns[13]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[14]));
		entry.setDataForFEC_ACTU(dataRow.getDate(dataColumns[15]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[16]));
		entry.setDataForCOD_CAMP(dataRow.getInt(dataColumns[17]), dataRow.wasNull());
		entry.setDataForANHO(dataRow.getString(dataColumns[18]));
		entry.setDataForMES(dataRow.getString(dataColumns[19]));
		entry.setDataForCOD_OFIC(dataRow.getString(dataColumns[20]));
		entry.setDataForCOD_TERR(dataRow.getString(dataColumns[21]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_campanias_detalleKey key=
			new entities.Tiido_campanias_detalleKey();

		key.cod_camp_deta=new Integer(dataRow.getInt(primaryKeyColumns[0]));
		key.tiido_camdet_campanias_fk_cod_camp=new Integer(dataRow.getInt(primaryKeyColumns[1]));
		key.tiido_camdet_campanias_fk_anho=dataRow.getString(primaryKeyColumns[2]);
		key.tiido_camdet_campanias_fk_mes=dataRow.getString(primaryKeyColumns[3]);
		key.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic=dataRow.getString(primaryKeyColumns[4]);
		key.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr=dataRow.getString(primaryKeyColumns[5]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_campanias_detalle";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 18;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_campanias_detalleBeanCacheEntryImpl_6826fb65();
	}
}
