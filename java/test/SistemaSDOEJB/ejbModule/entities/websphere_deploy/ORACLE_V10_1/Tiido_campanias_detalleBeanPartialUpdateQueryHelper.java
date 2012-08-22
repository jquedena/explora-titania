package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_campanias_detalleBeanPartialUpdateQueryHelper
 */
public class Tiido_campanias_detalleBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"NOM_CAMP = ?, ","COD_GEST = ?, ","NRO_CLIE = ?, ","COMP_GEST = ?, ","NRO_GEST_SEGU_1 = ?, ","NRO_CONC_SEGU_1 = ?, ","MONT_SEGU_1 = ?, ","NRO_GEST_SEGU_2 = ?, ","NRO_CONC_SEGU_2 = ?, ","MONT_SEGU_2 = ?, ","FEC_REGI = ?, ","FEC_SEGU_1 = ?, ","FEC_SEGU_2 = ?, ","USU_REGI = ?, ","FEC_ACTU = ?, ","USU_ACTU = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_CAMPANIAS_DETALLE SET ", " WHERE COD_CAMP_DETA = ?  AND COD_CAMP = ? AND ANHO = ? AND MES = ? AND COD_OFIC = ? AND COD_TERR = ?", assignmentColumns,437, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
