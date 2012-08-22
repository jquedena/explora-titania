package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_accionesBeanPartialUpdateQueryHelper
 */
public class Tiido_accionesBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"NOM_ACCI = ?, ","COD_GEST = ?, ","MES_ACCI = ?, ","NRO_CLIE = ?, ","COMP_GEST = ?, ","NRO_GEST_SEGU_1 = ?, ","NRO_CONC_SEGU_1 = ?, ","MON_SEGU_1 = ?, ","NRO_GEST_SEGU_2 = ?, ","NRO_CONC_SEGU_2 = ?, ","MON_SEGU_2 = ?, ","FEC_SEGU_1 = ?, ","FEC_SEGU_2 = ?, ","USU_REGI = ?, ","USU_ACTU = ?, ","FEC_REGI = ?, ","FEC_ACTU = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_ACCIONES SET ", " WHERE COD_ACCI = ?  AND COD_EPIGRAFE = ? AND ANHO = ? AND COD_TERR = ? AND COD_OFIC = ?", assignmentColumns,429, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
