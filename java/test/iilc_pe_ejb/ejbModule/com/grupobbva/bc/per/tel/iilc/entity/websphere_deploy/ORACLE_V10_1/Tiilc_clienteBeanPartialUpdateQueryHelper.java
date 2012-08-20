package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiilc_clienteBeanPartialUpdateQueryHelper
 */
public class Tiilc_clienteBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"CODIGO = ?, ","COD_OFICINA = ?, ","COD_GESTOR = ?, ","NOMBRE = ?, ","COD_TERRITORIO = ?, ","SEGMENT1 = ?, ","EDAD = ?, ","ESTCIVIL = ?, ","CALLE = ?, ","NRO = ?, ","PERFIL = ?, ","DIREC1 = ?, ","DISTRITO = ?, ","PROVINCIA = ?, ","DEPARTAMENTO = ?, ","TIPO_PERSONA = ?, ","CLASIFICACION = ?, ","TELEFONO = ?, ","VINCULACION = ?, ","PPER = ?, ","PCOM = ?, ","VNAC = ?, ","CCTE = ?, ","COLB = ?, ","CNET = ?, ","PAUT = ?, ","DSCT = ?, ","VARC = ?, ","CEMP = ?, ","SDEP = ?, ","CEXT = ?, ","PHIP = ?, ","LEAS = ?, ","VCLA = ?, ","CVIP = ?, ","SVID = ?, ","LINCO = ?, ","PMIV = ?, ","CLOC = ?, ","VREP = ?, ","AHSD = ?, ","SONC = ?, ","TCO = ?, ","B24 = ?, ","CPTE = ?, ","PREF = ?, ","VORO = ?, ","AHOR = ?, ","SPRO = ?, ","POS = ?, ","T_ACT2 = ?, ","PMAS = ?, ","T_ACT3 = ?, ","LCTA = ?, ","T_ACT4 = ?, ","VPLA = ?, ","T_ACT5 = ?, ","PLZO = ?, ","T_ACT6 = ?, ","PSERV = ?, ","TPR = ?, ","PROM = ?, ","T_ACT_CT2 = ?, ","VEMP = ?, ","T_ACT_CT3 = ?, ","PH = ?, ","T_ACT_CT4 = ?, ","FCEX = ?, ","T_ACT_CT5 = ?, ","VCTR = ?, ","T_ACT_CT6 = ?, ","FMUT = ?, ","MARGENO = ?, ","NRO_DOCUMENTO = ?, ","BCORIE = ?, ","EMPH = ?, ","BCORID = ?, ","AVAL = ?, ","BCORII = ?, ","MCLA = ?, ","BCOPAS = ?, ","CTS = ?, ","BCOVOL = ?, ","TDEB = ?, ","PORCRIE = ?, ","MORO = ?, ","PORCRID = ?, ","CTSD = ?, ","PORCRII = ?, ","TVIP = ?, ","SBSRIE = ?, ","SBSRID = ?, ","SBSRII = ?, ","SBSJUD = ?, ","COD_EMPRESA = ?, ","DES_EMPRESA = ?, ","INTERVPAS = ?, ","MOFACTV = ?, ","CS000LINEAMAXTC = ?, ","MOFPASV = ?, ","MOFSERV = ?, ","MOFCANAL = ?, ","MPHPASV = ?, ","CS000MTOPRESTAMO = ?, ","MONTOVEHICULAR = ?, ","CTACTEOFERTA = ?, ","CTAAHOFERTA = ?, ","CTAPOFERTA = ?, ","FMUTUOOFERT = ?, ","CTACTSOFERT = ?, ","TCONSACTV = ?, ","MONTOSUBROGADOS = ?, ","TSUBACTV = ?, ","THIPOTACTV = ?, ","TVEHICACTV = ?, ","TCUOT36ACT = ?, ","TCUOT48ACT = ?, ","CS000MONTOCTA60 = ?, ","TCUOT60ACT = ?, ","CSS000PRESMENA5000 = ?, ","CS000COMISDESEMEN5000 = ?, ","CS000PRES5000A15000 = ?, ","C5000COMDES15000ACT = ?, ","CS000PRESMAYA15000 = ?, ","COMDES15000AC = ?, ","CS000LINMINADQTC = ?, ","CS000TIPODECREDITO = ?, ","CS000MIXMONPREST = ?, ","CS000MIXLINASISTC = ?, ","CS000MIXTIPOTC = ?, ","CS000PRESTCMENA5000 = ?, ","CS000PRESTC500015000 = ?, ","CS000PRESTCMAYA15000 = ?, ","ATRIBCTACTEPASV = ?, ","ATRIBCTAAHPASV = ?, ","ATRIBCTAPLAZPASV = ?, ","ATRIBCTSPASV = ?, ","ATRIBFMUTUOPASV = ?, ","COBOFSERV = ?, ","SVIDOFSERV = ?, ","SONCOFSERV = ?, ","SVINCOFSERV = ?, ","PHOFSERV = ?, ","DEBOFSERV = ?, ","VIPOFSERV = ?, ","OFCNETCAN = ?, ","OFCEMPCAN = ?, ","OFLINCOCAN = ?, ","OFB24CAN = ?, ","OFPOSCAN = ?, ","PREFIJO = ?, ","MONTOHIPOTECARIO = ?, ","CS000MONTOCTA36 = ?, ","CS000MONTOCTA48 = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IILC.TIILC_CLIENTE SET ", " WHERE COD_CLIENTE = ? ", assignmentColumns,2562, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,107,108,109,110,111,112,113,114,115,116,118,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,106,117,119};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
