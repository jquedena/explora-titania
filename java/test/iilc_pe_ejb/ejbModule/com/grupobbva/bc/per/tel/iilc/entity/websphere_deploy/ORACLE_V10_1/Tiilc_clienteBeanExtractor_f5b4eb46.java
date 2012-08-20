package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_clienteBeanExtractor_f5b4eb46
 */
public class Tiilc_clienteBeanExtractor_f5b4eb46 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * Tiilc_clienteBeanExtractor_f5b4eb46
	 */
	public Tiilc_clienteBeanExtractor_f5b4eb46() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_clienteBeanCacheEntryImpl_f5b4eb46 entry=
			(com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_clienteBeanCacheEntryImpl_f5b4eb46) createDataCacheEntry();

		entry.setDataForCOD_CLIENTE(dataRow.getBigDecimal(dataColumns[0]));
		entry.setDataForCODIGO(dataRow.getString(dataColumns[1]));
		entry.setDataForCOD_OFICINA(dataRow.getString(dataColumns[2]));
		entry.setDataForCOD_GESTOR(dataRow.getString(dataColumns[3]));
		entry.setDataForNOMBRE(dataRow.getString(dataColumns[4]));
		entry.setDataForCOD_TERRITORIO(dataRow.getString(dataColumns[5]));
		entry.setDataForSEGMENT1(dataRow.getString(dataColumns[6]));
		entry.setDataForEDAD(dataRow.getBigDecimal(dataColumns[7]));
		entry.setDataForESTCIVIL(dataRow.getString(dataColumns[8]));
		entry.setDataForCALLE(dataRow.getString(dataColumns[9]));
		entry.setDataForNRO(dataRow.getString(dataColumns[10]));
		entry.setDataForPERFIL(dataRow.getString(dataColumns[11]));
		entry.setDataForDIREC1(dataRow.getString(dataColumns[12]));
		entry.setDataForDISTRITO(dataRow.getString(dataColumns[13]));
		entry.setDataForPROVINCIA(dataRow.getString(dataColumns[14]));
		entry.setDataForDEPARTAMENTO(dataRow.getString(dataColumns[15]));
		entry.setDataForTIPO_PERSONA(dataRow.getString(dataColumns[16]));
		entry.setDataForCLASIFICACION(dataRow.getString(dataColumns[17]));
		entry.setDataForTELEFONO(dataRow.getString(dataColumns[18]));
		entry.setDataForVINCULACION(dataRow.getString(dataColumns[19]));
		entry.setDataForPPER(dataRow.getBigDecimal(dataColumns[20]));
		entry.setDataForPCOM(dataRow.getBigDecimal(dataColumns[21]));
		entry.setDataForVNAC(dataRow.getBigDecimal(dataColumns[22]));
		entry.setDataForCCTE(dataRow.getBigDecimal(dataColumns[23]));
		entry.setDataForCOLB(dataRow.getBigDecimal(dataColumns[24]));
		entry.setDataForCNET(dataRow.getBigDecimal(dataColumns[25]));
		entry.setDataForPAUT(dataRow.getBigDecimal(dataColumns[26]));
		entry.setDataForDSCT(dataRow.getBigDecimal(dataColumns[27]));
		entry.setDataForVARC(dataRow.getBigDecimal(dataColumns[28]));
		entry.setDataForCEMP(dataRow.getBigDecimal(dataColumns[29]));
		entry.setDataForSDEP(dataRow.getBigDecimal(dataColumns[30]));
		entry.setDataForCEXT(dataRow.getBigDecimal(dataColumns[31]));
		entry.setDataForPHIP(dataRow.getBigDecimal(dataColumns[32]));
		entry.setDataForLEAS(dataRow.getBigDecimal(dataColumns[33]));
		entry.setDataForVCLA(dataRow.getBigDecimal(dataColumns[34]));
		entry.setDataForCVIP(dataRow.getBigDecimal(dataColumns[35]));
		entry.setDataForSVID(dataRow.getBigDecimal(dataColumns[36]));
		entry.setDataForLINCO(dataRow.getBigDecimal(dataColumns[37]));
		entry.setDataForPMIV(dataRow.getBigDecimal(dataColumns[38]));
		entry.setDataForCLOC(dataRow.getBigDecimal(dataColumns[39]));
		entry.setDataForVREP(dataRow.getBigDecimal(dataColumns[40]));
		entry.setDataForAHSD(dataRow.getBigDecimal(dataColumns[41]));
		entry.setDataForSONC(dataRow.getBigDecimal(dataColumns[42]));
		entry.setDataForTCO(dataRow.getBigDecimal(dataColumns[43]));
		entry.setDataForB24(dataRow.getBigDecimal(dataColumns[44]));
		entry.setDataForCPTE(dataRow.getBigDecimal(dataColumns[45]));
		entry.setDataForPREF(dataRow.getBigDecimal(dataColumns[46]));
		entry.setDataForVORO(dataRow.getBigDecimal(dataColumns[47]));
		entry.setDataForAHOR(dataRow.getBigDecimal(dataColumns[48]));
		entry.setDataForSPRO(dataRow.getBigDecimal(dataColumns[49]));
		entry.setDataForPOS(dataRow.getBigDecimal(dataColumns[50]));
		entry.setDataForT_ACT2(dataRow.getBigDecimal(dataColumns[51]));
		entry.setDataForPMAS(dataRow.getBigDecimal(dataColumns[52]));
		entry.setDataForT_ACT3(dataRow.getBigDecimal(dataColumns[53]));
		entry.setDataForLCTA(dataRow.getBigDecimal(dataColumns[54]));
		entry.setDataForT_ACT4(dataRow.getBigDecimal(dataColumns[55]));
		entry.setDataForVPLA(dataRow.getBigDecimal(dataColumns[56]));
		entry.setDataForT_ACT5(dataRow.getBigDecimal(dataColumns[57]));
		entry.setDataForPLZO(dataRow.getBigDecimal(dataColumns[58]));
		entry.setDataForT_ACT6(dataRow.getBigDecimal(dataColumns[59]));
		entry.setDataForPSERV(dataRow.getBigDecimal(dataColumns[60]));
		entry.setDataForTPR(dataRow.getBigDecimal(dataColumns[61]));
		entry.setDataForPROM(dataRow.getBigDecimal(dataColumns[62]));
		entry.setDataForT_ACT_CT2(dataRow.getBigDecimal(dataColumns[63]));
		entry.setDataForVEMP(dataRow.getBigDecimal(dataColumns[64]));
		entry.setDataForT_ACT_CT3(dataRow.getBigDecimal(dataColumns[65]));
		entry.setDataForPH(dataRow.getBigDecimal(dataColumns[66]));
		entry.setDataForT_ACT_CT4(dataRow.getBigDecimal(dataColumns[67]));
		entry.setDataForFCEX(dataRow.getBigDecimal(dataColumns[68]));
		entry.setDataForT_ACT_CT5(dataRow.getBigDecimal(dataColumns[69]));
		entry.setDataForVCTR(dataRow.getBigDecimal(dataColumns[70]));
		entry.setDataForT_ACT_CT6(dataRow.getBigDecimal(dataColumns[71]));
		entry.setDataForFMUT(dataRow.getBigDecimal(dataColumns[72]));
		entry.setDataForMARGENO(dataRow.getBigDecimal(dataColumns[73]));
		entry.setDataForNRO_DOCUMENTO(dataRow.getString(dataColumns[74]));
		entry.setDataForBCORIE(dataRow.getBigDecimal(dataColumns[75]));
		entry.setDataForEMPH(dataRow.getBigDecimal(dataColumns[76]));
		entry.setDataForBCORID(dataRow.getBigDecimal(dataColumns[77]));
		entry.setDataForAVAL(dataRow.getBigDecimal(dataColumns[78]));
		entry.setDataForBCORII(dataRow.getBigDecimal(dataColumns[79]));
		entry.setDataForMCLA(dataRow.getBigDecimal(dataColumns[80]));
		entry.setDataForBCOPAS(dataRow.getBigDecimal(dataColumns[81]));
		entry.setDataForCTS(dataRow.getBigDecimal(dataColumns[82]));
		entry.setDataForBCOVOL(dataRow.getBigDecimal(dataColumns[83]));
		entry.setDataForTDEB(dataRow.getBigDecimal(dataColumns[84]));
		entry.setDataForPORCRIE(dataRow.getBigDecimal(dataColumns[85]));
		entry.setDataForMORO(dataRow.getBigDecimal(dataColumns[86]));
		entry.setDataForPORCRID(dataRow.getBigDecimal(dataColumns[87]));
		entry.setDataForCTSD(dataRow.getBigDecimal(dataColumns[88]));
		entry.setDataForPORCRII(dataRow.getBigDecimal(dataColumns[89]));
		entry.setDataForTVIP(dataRow.getBigDecimal(dataColumns[90]));
		entry.setDataForSBSRIE(dataRow.getBigDecimal(dataColumns[91]));
		entry.setDataForSBSRID(dataRow.getBigDecimal(dataColumns[92]));
		entry.setDataForSBSRII(dataRow.getBigDecimal(dataColumns[93]));
		entry.setDataForSBSJUD(dataRow.getBigDecimal(dataColumns[94]));
		entry.setDataForCOD_EMPRESA(dataRow.getString(dataColumns[95]));
		entry.setDataForDES_EMPRESA(dataRow.getString(dataColumns[96]));
		entry.setDataForINTERVPAS(dataRow.getString(dataColumns[97]));
		entry.setDataForMOFACTV(dataRow.getBigDecimal(dataColumns[98]));
		entry.setDataForCS000LINEAMAXTC(dataRow.getBigDecimal(dataColumns[99]));
		entry.setDataForMOFPASV(dataRow.getString(dataColumns[100]));
		entry.setDataForMOFSERV(dataRow.getString(dataColumns[101]));
		entry.setDataForMOFCANAL(dataRow.getString(dataColumns[102]));
		entry.setDataForMPHPASV(dataRow.getString(dataColumns[103]));
		entry.setDataForCS000MTOPRESTAMO(dataRow.getBigDecimal(dataColumns[104]));
		entry.setDataForMONTOVEHICULAR(dataRow.getBigDecimal(dataColumns[105]));
		entry.setDataForCTACTEOFERTA(dataRow.getString(dataColumns[106]));
		entry.setDataForCTAAHOFERTA(dataRow.getString(dataColumns[107]));
		entry.setDataForCTAPOFERTA(dataRow.getString(dataColumns[108]));
		entry.setDataForFMUTUOOFERT(dataRow.getString(dataColumns[109]));
		entry.setDataForCTACTSOFERT(dataRow.getString(dataColumns[110]));
		entry.setDataForTCONSACTV(dataRow.getBigDecimal(dataColumns[111]));
		entry.setDataForMONTOSUBROGADOS(dataRow.getBigDecimal(dataColumns[112]));
		entry.setDataForTSUBACTV(dataRow.getBigDecimal(dataColumns[113]));
		entry.setDataForTHIPOTACTV(dataRow.getBigDecimal(dataColumns[114]));
		entry.setDataForTVEHICACTV(dataRow.getBigDecimal(dataColumns[115]));
		entry.setDataForTCUOT36ACT(dataRow.getBigDecimal(dataColumns[116]));
		entry.setDataForTCUOT48ACT(dataRow.getBigDecimal(dataColumns[117]));
		entry.setDataForCS000MONTOCTA60(dataRow.getBigDecimal(dataColumns[118]));
		entry.setDataForTCUOT60ACT(dataRow.getBigDecimal(dataColumns[119]));
		entry.setDataForCSS000PRESMENA5000(dataRow.getBigDecimal(dataColumns[120]));
		entry.setDataForCS000COMISDESEMEN5000(dataRow.getBigDecimal(dataColumns[121]));
		entry.setDataForCS000PRES5000A15000(dataRow.getBigDecimal(dataColumns[122]));
		entry.setDataForC5000COMDES15000ACT(dataRow.getBigDecimal(dataColumns[123]));
		entry.setDataForCS000PRESMAYA15000(dataRow.getBigDecimal(dataColumns[124]));
		entry.setDataForCOMDES15000AC(dataRow.getBigDecimal(dataColumns[125]));
		entry.setDataForCS000LINMINADQTC(dataRow.getBigDecimal(dataColumns[126]));
		entry.setDataForCS000TIPODECREDITO(dataRow.getString(dataColumns[127]));
		entry.setDataForCS000MIXMONPREST(dataRow.getBigDecimal(dataColumns[128]));
		entry.setDataForCS000MIXLINASISTC(dataRow.getBigDecimal(dataColumns[129]));
		entry.setDataForCS000MIXTIPOTC(dataRow.getString(dataColumns[130]));
		entry.setDataForCS000PRESTCMENA5000(dataRow.getBigDecimal(dataColumns[131]));
		entry.setDataForCS000PRESTC500015000(dataRow.getBigDecimal(dataColumns[132]));
		entry.setDataForCS000PRESTCMAYA15000(dataRow.getBigDecimal(dataColumns[133]));
		entry.setDataForATRIBCTACTEPASV(dataRow.getString(dataColumns[134]));
		entry.setDataForATRIBCTAAHPASV(dataRow.getString(dataColumns[135]));
		entry.setDataForATRIBCTAPLAZPASV(dataRow.getString(dataColumns[136]));
		entry.setDataForATRIBCTSPASV(dataRow.getString(dataColumns[137]));
		entry.setDataForATRIBFMUTUOPASV(dataRow.getString(dataColumns[138]));
		entry.setDataForCOBOFSERV(dataRow.getString(dataColumns[139]));
		entry.setDataForSVIDOFSERV(dataRow.getString(dataColumns[140]));
		entry.setDataForSONCOFSERV(dataRow.getString(dataColumns[141]));
		entry.setDataForSVINCOFSERV(dataRow.getString(dataColumns[142]));
		entry.setDataForPHOFSERV(dataRow.getString(dataColumns[143]));
		entry.setDataForDEBOFSERV(dataRow.getString(dataColumns[144]));
		entry.setDataForVIPOFSERV(dataRow.getString(dataColumns[145]));
		entry.setDataForOFCNETCAN(dataRow.getString(dataColumns[146]));
		entry.setDataForOFCEMPCAN(dataRow.getString(dataColumns[147]));
		entry.setDataForOFLINCOCAN(dataRow.getString(dataColumns[148]));
		entry.setDataForOFB24CAN(dataRow.getString(dataColumns[149]));
		entry.setDataForOFPOSCAN(dataRow.getString(dataColumns[150]));
		entry.setDataForPREFIJO(dataRow.getString(dataColumns[151]));
		entry.setDataForMONTOHIPOTECARIO(dataRow.getBigDecimal(dataColumns[152]));
		entry.setDataForCS000MONTOCTA36(dataRow.getString(dataColumns[153]));
		entry.setDataForCS000MONTOCTA48(dataRow.getBigDecimal(dataColumns[154]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey key=
			new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey();

		key.cod_cliente=dataRow.getBigDecimal(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Tiilc_cliente";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 155;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_clienteBeanCacheEntryImpl_f5b4eb46();
	}
}
