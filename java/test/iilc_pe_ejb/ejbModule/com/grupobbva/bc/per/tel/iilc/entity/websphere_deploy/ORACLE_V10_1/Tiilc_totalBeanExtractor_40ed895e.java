package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_totalBeanExtractor_40ed895e
 */
public class Tiilc_totalBeanExtractor_40ed895e extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiilc_totalBeanExtractor_40ed895e
	 */
	public Tiilc_totalBeanExtractor_40ed895e() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_totalBeanCacheEntryImpl_40ed895e entry=
			(com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_totalBeanCacheEntryImpl_40ed895e) createDataCacheEntry();

		entry.setDataForCOD_TOTAL(dataRow.getBigDecimal(dataColumns[0]));
		entry.setDataForCOD_TERRITORIO(dataRow.getString(dataColumns[1]));
		entry.setDataForIND_REGISTRO(dataRow.getString(dataColumns[2]));
		entry.setDataForCOD_OFICINA(dataRow.getString(dataColumns[3]));
		entry.setDataForCOD_GESTOR(dataRow.getString(dataColumns[4]));
		entry.setDataForCLIXGEST(dataRow.getBigDecimal(dataColumns[5]));
		entry.setDataForSEG_10100(dataRow.getBigDecimal(dataColumns[6]));
		entry.setDataForSEG_10200(dataRow.getBigDecimal(dataColumns[7]));
		entry.setDataForSEG_20100(dataRow.getBigDecimal(dataColumns[8]));
		entry.setDataForSEG_20200(dataRow.getBigDecimal(dataColumns[9]));
		entry.setDataForSEG_20300(dataRow.getBigDecimal(dataColumns[10]));
		entry.setDataForSEG_20400(dataRow.getBigDecimal(dataColumns[11]));
		entry.setDataForSEG_20500(dataRow.getBigDecimal(dataColumns[12]));
		entry.setDataForSEG_20600(dataRow.getBigDecimal(dataColumns[13]));
		entry.setDataForSEG_30100(dataRow.getBigDecimal(dataColumns[14]));
		entry.setDataForSEG_30200(dataRow.getBigDecimal(dataColumns[15]));
		entry.setDataForSEG_30300(dataRow.getBigDecimal(dataColumns[16]));
		entry.setDataForSEG_30400(dataRow.getBigDecimal(dataColumns[17]));
		entry.setDataForSEG_40100(dataRow.getBigDecimal(dataColumns[18]));
		entry.setDataForSEG_40200(dataRow.getBigDecimal(dataColumns[19]));
		entry.setDataForSEG_40300(dataRow.getBigDecimal(dataColumns[20]));
		entry.setDataForSEG_40400(dataRow.getBigDecimal(dataColumns[21]));
		entry.setDataForSEG_50100(dataRow.getBigDecimal(dataColumns[22]));
		entry.setDataForSEG_50200(dataRow.getBigDecimal(dataColumns[23]));
		entry.setDataForSEG_50300(dataRow.getBigDecimal(dataColumns[24]));
		entry.setDataForSEG_50400(dataRow.getBigDecimal(dataColumns[25]));
		entry.setDataForSEG_60100(dataRow.getBigDecimal(dataColumns[26]));
		entry.setDataForSEG_60200(dataRow.getBigDecimal(dataColumns[27]));
		entry.setDataForSEG_60300(dataRow.getBigDecimal(dataColumns[28]));
		entry.setDataForSEG_60400(dataRow.getBigDecimal(dataColumns[29]));
		entry.setDataForSEG_80100(dataRow.getBigDecimal(dataColumns[30]));
		entry.setDataForSEG_80200(dataRow.getBigDecimal(dataColumns[31]));
		entry.setDataForSEG_80300(dataRow.getBigDecimal(dataColumns[32]));
		entry.setDataForSEG_80400(dataRow.getBigDecimal(dataColumns[33]));
		entry.setDataForSEG_80500(dataRow.getBigDecimal(dataColumns[34]));
		entry.setDataForSEG_80600(dataRow.getBigDecimal(dataColumns[35]));
		entry.setDataForSEG_80700(dataRow.getBigDecimal(dataColumns[36]));
		entry.setDataForSEG_90200(dataRow.getBigDecimal(dataColumns[37]));
		entry.setDataForSEG_99900(dataRow.getBigDecimal(dataColumns[38]));
		entry.setDataForDESVIN(dataRow.getBigDecimal(dataColumns[39]));
		entry.setDataForPOCOVIN(dataRow.getBigDecimal(dataColumns[40]));
		entry.setDataForVIN(dataRow.getBigDecimal(dataColumns[41]));
		entry.setDataForMUYVIN(dataRow.getBigDecimal(dataColumns[42]));
		entry.setDataForNATDESVIN(dataRow.getBigDecimal(dataColumns[43]));
		entry.setDataForNATVIN(dataRow.getBigDecimal(dataColumns[44]));
		entry.setDataForJURVIN(dataRow.getBigDecimal(dataColumns[45]));
		entry.setDataForAHOR_T(dataRow.getBigDecimal(dataColumns[46]));
		entry.setDataForAHSD_T(dataRow.getBigDecimal(dataColumns[47]));
		entry.setDataForAVAL_T(dataRow.getBigDecimal(dataColumns[48]));
		entry.setDataForB24_T(dataRow.getBigDecimal(dataColumns[49]));
		entry.setDataForCCTE_T(dataRow.getBigDecimal(dataColumns[50]));
		entry.setDataForCEXT_T(dataRow.getBigDecimal(dataColumns[51]));
		entry.setDataForCLOC_T(dataRow.getBigDecimal(dataColumns[52]));
		entry.setDataForCOLB_T(dataRow.getBigDecimal(dataColumns[53]));
		entry.setDataForCPTE_T(dataRow.getBigDecimal(dataColumns[54]));
		entry.setDataForCTS_T(dataRow.getBigDecimal(dataColumns[55]));
		entry.setDataForCTSD_T(dataRow.getBigDecimal(dataColumns[56]));
		entry.setDataForVIP_T(dataRow.getBigDecimal(dataColumns[57]));
		entry.setDataForDSCT_T(dataRow.getBigDecimal(dataColumns[58]));
		entry.setDataForFCEX_T(dataRow.getBigDecimal(dataColumns[59]));
		entry.setDataForFMUT_T(dataRow.getBigDecimal(dataColumns[60]));
		entry.setDataForLCTA_T(dataRow.getBigDecimal(dataColumns[61]));
		entry.setDataForLEAS_T(dataRow.getBigDecimal(dataColumns[62]));
		entry.setDataForMCLA_T(dataRow.getBigDecimal(dataColumns[63]));
		entry.setDataForMORO_T(dataRow.getBigDecimal(dataColumns[64]));
		entry.setDataForMP_T(dataRow.getBigDecimal(dataColumns[65]));
		entry.setDataForPAUT_T(dataRow.getBigDecimal(dataColumns[66]));
		entry.setDataForPCOM_T(dataRow.getBigDecimal(dataColumns[67]));
		entry.setDataForPER_T(dataRow.getBigDecimal(dataColumns[68]));
		entry.setDataForPH_T(dataRow.getBigDecimal(dataColumns[69]));
		entry.setDataForPHIP_T(dataRow.getBigDecimal(dataColumns[70]));
		entry.setDataForPLZO_T(dataRow.getBigDecimal(dataColumns[71]));
		entry.setDataForPMAS_T(dataRow.getBigDecimal(dataColumns[72]));
		entry.setDataForPMIV_T(dataRow.getBigDecimal(dataColumns[73]));
		entry.setDataForPPER_T(dataRow.getBigDecimal(dataColumns[74]));
		entry.setDataForPPPER_T(dataRow.getBigDecimal(dataColumns[75]));
		entry.setDataForPREF_T(dataRow.getBigDecimal(dataColumns[76]));
		entry.setDataForPROM_T(dataRow.getBigDecimal(dataColumns[77]));
		entry.setDataForPSER_T(dataRow.getBigDecimal(dataColumns[78]));
		entry.setDataForPSERV_T(dataRow.getBigDecimal(dataColumns[79]));
		entry.setDataForDEP_T(dataRow.getBigDecimal(dataColumns[80]));
		entry.setDataForSDEP_T(dataRow.getBigDecimal(dataColumns[81]));
		entry.setDataForSEXT_T(dataRow.getBigDecimal(dataColumns[82]));
		entry.setDataForSONC_T(dataRow.getBigDecimal(dataColumns[83]));
		entry.setDataForSPRO_T(dataRow.getBigDecimal(dataColumns[84]));
		entry.setDataForVID_T(dataRow.getBigDecimal(dataColumns[85]));
		entry.setDataForSVID_T(dataRow.getBigDecimal(dataColumns[86]));
		entry.setDataForTDE_T(dataRow.getBigDecimal(dataColumns[87]));
		entry.setDataForSVIP_T(dataRow.getBigDecimal(dataColumns[88]));
		entry.setDataForTVIP_T(dataRow.getBigDecimal(dataColumns[89]));
		entry.setDataForVARC_T(dataRow.getBigDecimal(dataColumns[90]));
		entry.setDataForVCLA_T(dataRow.getBigDecimal(dataColumns[91]));
		entry.setDataForVCTR_T(dataRow.getBigDecimal(dataColumns[92]));
		entry.setDataForVEMP_T(dataRow.getBigDecimal(dataColumns[93]));
		entry.setDataForVNAC_T(dataRow.getBigDecimal(dataColumns[94]));
		entry.setDataForVORO_T(dataRow.getBigDecimal(dataColumns[95]));
		entry.setDataForVPLA_T(dataRow.getBigDecimal(dataColumns[96]));
		entry.setDataForVPOLA_T(dataRow.getBigDecimal(dataColumns[97]));
		entry.setDataForVREP_T(dataRow.getBigDecimal(dataColumns[98]));
		entry.setDataForTDEB_T(dataRow.getBigDecimal(dataColumns[99]));
		entry.setDataForCNET_T(dataRow.getBigDecimal(dataColumns[100]));
		entry.setDataForLINCO_T(dataRow.getBigDecimal(dataColumns[101]));
		entry.setDataForPOS_T(dataRow.getBigDecimal(dataColumns[102]));
		entry.setDataForEMPH_T(dataRow.getBigDecimal(dataColumns[103]));
		entry.setDataForRIESGO_D_T(dataRow.getBigDecimal(dataColumns[104]));
		entry.setDataForRIESGO_I_T(dataRow.getBigDecimal(dataColumns[105]));
		entry.setDataForRIESGO_T(dataRow.getBigDecimal(dataColumns[106]));
		entry.setDataForPASIVO_T(dataRow.getBigDecimal(dataColumns[107]));
		entry.setDataForVOLUMEN_T(dataRow.getBigDecimal(dataColumns[108]));
		entry.setDataForSUM_T_ACT(dataRow.getBigDecimal(dataColumns[109]));
		entry.setDataForSUM_T_ACT1(dataRow.getBigDecimal(dataColumns[110]));
		entry.setDataForSUM_T_ACT2(dataRow.getBigDecimal(dataColumns[111]));
		entry.setDataForSUM_T_ACT3(dataRow.getBigDecimal(dataColumns[112]));
		entry.setDataForSUM_T_ACT4(dataRow.getBigDecimal(dataColumns[113]));
		entry.setDataForSUM_T_ACT5(dataRow.getBigDecimal(dataColumns[114]));
		entry.setDataForSUM_T_ACT6(dataRow.getBigDecimal(dataColumns[115]));
		entry.setDataForSUM_ACT_CTO(dataRow.getBigDecimal(dataColumns[116]));
		entry.setDataForSUM_ACT_CT1(dataRow.getBigDecimal(dataColumns[117]));
		entry.setDataForSUM_ACT_CT2(dataRow.getBigDecimal(dataColumns[118]));
		entry.setDataForSUM_ACT_CT3(dataRow.getBigDecimal(dataColumns[119]));
		entry.setDataForSUM_ACT_CT4(dataRow.getBigDecimal(dataColumns[120]));
		entry.setDataForSUM_ACT_CT5(dataRow.getBigDecimal(dataColumns[121]));
		entry.setDataForSUM_ACT_CT6(dataRow.getBigDecimal(dataColumns[122]));
		entry.setDataForCEMP_T(dataRow.getBigDecimal(dataColumns[123]));
		entry.setDataForCVIP_T(dataRow.getBigDecimal(dataColumns[124]));
		entry.setDataForICALICTE00(dataRow.getBigDecimal(dataColumns[125]));
		entry.setDataForICALICTE10(dataRow.getBigDecimal(dataColumns[126]));
		entry.setDataForICALICTE20(dataRow.getBigDecimal(dataColumns[127]));
		entry.setDataForICALICTE30(dataRow.getBigDecimal(dataColumns[128]));
		entry.setDataForICALICTE40(dataRow.getBigDecimal(dataColumns[129]));
		entry.setDataForMOFACTV_T(dataRow.getBigDecimal(dataColumns[130]));
		entry.setDataForCS000LINEAMAXTC_T(dataRow.getBigDecimal(dataColumns[131]));
		entry.setDataForCS000MTOPRESTAMO_T(dataRow.getBigDecimal(dataColumns[132]));
		entry.setDataForMONTOVEHICULAR_T(dataRow.getBigDecimal(dataColumns[133]));
		entry.setDataForMONTOHIPOTECARIO_T(dataRow.getBigDecimal(dataColumns[134]));
		entry.setDataForMONTOSUBROGADOS_T(dataRow.getBigDecimal(dataColumns[135]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey key=
			new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey();

		key.cod_total=dataRow.getBigDecimal(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiilc_total";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 136;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_totalBeanCacheEntryImpl_40ed895e();
	}
}
