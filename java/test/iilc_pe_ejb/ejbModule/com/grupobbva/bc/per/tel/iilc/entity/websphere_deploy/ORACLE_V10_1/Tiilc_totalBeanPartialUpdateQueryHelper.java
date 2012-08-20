package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiilc_totalBeanPartialUpdateQueryHelper
 */
public class Tiilc_totalBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"COD_TERRITORIO = ?, ","IND_REGISTRO = ?, ","COD_OFICINA = ?, ","COD_GESTOR = ?, ","CLIXGEST = ?, ","SEG_10100 = ?, ","SEG_10200 = ?, ","SEG_20100 = ?, ","SEG_20200 = ?, ","SEG_20300 = ?, ","SEG_20400 = ?, ","SEG_20500 = ?, ","SEG_20600 = ?, ","SEG_30100 = ?, ","SEG_30200 = ?, ","SEG_30300 = ?, ","SEG_30400 = ?, ","SEG_40100 = ?, ","SEG_40200 = ?, ","SEG_40300 = ?, ","SEG_40400 = ?, ","SEG_50100 = ?, ","SEG_50200 = ?, ","SEG_50300 = ?, ","SEG_50400 = ?, ","SEG_60100 = ?, ","SEG_60200 = ?, ","SEG_60300 = ?, ","SEG_60400 = ?, ","SEG_80100 = ?, ","SEG_80200 = ?, ","SEG_80300 = ?, ","SEG_80400 = ?, ","SEG_80500 = ?, ","SEG_80600 = ?, ","SEG_80700 = ?, ","SEG_90200 = ?, ","SEG_99900 = ?, ","DESVIN = ?, ","POCOVIN = ?, ","VIN = ?, ","MUYVIN = ?, ","NATDESVIN = ?, ","NATVIN = ?, ","JURVIN = ?, ","AHOR_T = ?, ","AHSD_T = ?, ","AVAL_T = ?, ","B24_T = ?, ","CCTE_T = ?, ","CEXT_T = ?, ","CLOC_T = ?, ","COLB_T = ?, ","CPTE_T = ?, ","CTS_T = ?, ","CTSD_T = ?, ","VIP_T = ?, ","DSCT_T = ?, ","FCEX_T = ?, ","FMUT_T = ?, ","LCTA_T = ?, ","LEAS_T = ?, ","MCLA_T = ?, ","MORO_T = ?, ","MP_T = ?, ","PAUT_T = ?, ","PCOM_T = ?, ","PER_T = ?, ","PH_T = ?, ","PHIP_T = ?, ","PLZO_T = ?, ","PMAS_T = ?, ","PMIV_T = ?, ","PPER_T = ?, ","PPPER_T = ?, ","PREF_T = ?, ","PROM_T = ?, ","PSER_T = ?, ","PSERV_T = ?, ","DEP_T = ?, ","SDEP_T = ?, ","SEXT_T = ?, ","SONC_T = ?, ","SPRO_T = ?, ","VID_T = ?, ","SVID_T = ?, ","TDE_T = ?, ","SVIP_T = ?, ","TVIP_T = ?, ","VARC_T = ?, ","VCLA_T = ?, ","VCTR_T = ?, ","VEMP_T = ?, ","VNAC_T = ?, ","VORO_T = ?, ","VPLA_T = ?, ","VPOLA_T = ?, ","VREP_T = ?, ","TDEB_T = ?, ","CNET_T = ?, ","LINCO_T = ?, ","POS_T = ?, ","EMPH_T = ?, ","RIESGO_D_T = ?, ","RIESGO_I_T = ?, ","RIESGO_T = ?, ","PASIVO_T = ?, ","VOLUMEN_T = ?, ","SUM_T_ACT = ?, ","SUM_T_ACT1 = ?, ","SUM_T_ACT2 = ?, ","SUM_T_ACT3 = ?, ","SUM_T_ACT4 = ?, ","SUM_T_ACT5 = ?, ","SUM_T_ACT6 = ?, ","SUM_ACT_CTO = ?, ","SUM_ACT_CT1 = ?, ","SUM_ACT_CT2 = ?, ","SUM_ACT_CT3 = ?, ","SUM_ACT_CT4 = ?, ","SUM_ACT_CT5 = ?, ","SUM_ACT_CT6 = ?, ","CEMP_T = ?, ","CVIP_T = ?, ","ICALICTE00 = ?, ","ICALICTE10 = ?, ","ICALICTE20 = ?, ","ICALICTE30 = ?, ","ICALICTE40 = ?, ","MOFACTV_T = ?, ","CS000LINEAMAXTC_T = ?, ","CS000MTOPRESTAMO_T = ?, ","MONTOVEHICULAR_T = ?, ","MONTOHIPOTECARIO_T = ?, ","MONTOSUBROGADOS_T = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IILC.TIILC_TOTAL SET ", " WHERE COD_TOTAL = ? ", assignmentColumns,2213, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
