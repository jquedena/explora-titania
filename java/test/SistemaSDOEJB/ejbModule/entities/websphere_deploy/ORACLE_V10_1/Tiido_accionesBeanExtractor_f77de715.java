package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_accionesBeanExtractor_f77de715
 */
public class Tiido_accionesBeanExtractor_f77de715 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiido_accionesBeanExtractor_f77de715
	 */
	public Tiido_accionesBeanExtractor_f77de715() {
		int[] pkCols={1,19,20,21,22};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		entities.websphere_deploy.ORACLE_V10_1.Tiido_accionesBeanCacheEntryImpl_f77de715 entry=
			(entities.websphere_deploy.ORACLE_V10_1.Tiido_accionesBeanCacheEntryImpl_f77de715) createDataCacheEntry();

		entry.setDataForCOD_ACCI(dataRow.getInt(dataColumns[0]), dataRow.wasNull());
		entry.setDataForNOM_ACCI(dataRow.getString(dataColumns[1]));
		entry.setDataForCOD_GEST(dataRow.getString(dataColumns[2]));
		entry.setDataForMES_ACCI(dataRow.getString(dataColumns[3]));
		entry.setDataForNRO_CLIE(dataRow.getBigDecimal(dataColumns[4]));
		entry.setDataForCOMP_GEST(dataRow.getBigDecimal(dataColumns[5]));
		entry.setDataForNRO_GEST_SEGU_1(dataRow.getBigDecimal(dataColumns[6]));
		entry.setDataForNRO_CONC_SEGU_1(dataRow.getBigDecimal(dataColumns[7]));
		entry.setDataForMON_SEGU_1(dataRow.getBigDecimal(dataColumns[8]));
		entry.setDataForNRO_GEST_SEGU_2(dataRow.getBigDecimal(dataColumns[9]));
		entry.setDataForNRO_CONC_SEGU_2(dataRow.getBigDecimal(dataColumns[10]));
		entry.setDataForMON_SEGU_2(dataRow.getBigDecimal(dataColumns[11]));
		entry.setDataForFEC_SEGU_1(dataRow.getDate(dataColumns[12]));
		entry.setDataForFEC_SEGU_2(dataRow.getDate(dataColumns[13]));
		entry.setDataForUSU_REGI(dataRow.getString(dataColumns[14]));
		entry.setDataForUSU_ACTU(dataRow.getString(dataColumns[15]));
		entry.setDataForFEC_REGI(dataRow.getDate(dataColumns[16]));
		entry.setDataForFEC_ACTU(dataRow.getDate(dataColumns[17]));
		entry.setDataForCOD_EPIGRAFE(dataRow.getString(dataColumns[18]));
		entry.setDataForANHO(dataRow.getString(dataColumns[19]));
		entry.setDataForCOD_OFIC(dataRow.getString(dataColumns[20]));
		entry.setDataForCOD_TERR(dataRow.getString(dataColumns[21]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		entities.Tiido_accionesKey key=
			new entities.Tiido_accionesKey();

		key.cod_acci=new Integer(dataRow.getInt(primaryKeyColumns[0]));
		key.tiido_acc_epigrafe_fk_cod_epigrafe=dataRow.getString(primaryKeyColumns[1]);
		key.tiido_acc_epigrafe_fk_anho=dataRow.getString(primaryKeyColumns[2]);
		key.tiido_acc_oficina_fk_cod_ofic=dataRow.getString(primaryKeyColumns[3]);
		key.tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr=dataRow.getString(primaryKeyColumns[4]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiido_acciones";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 20;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_accionesBeanCacheEntryImpl_f77de715();
	}
}
