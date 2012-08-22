package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_parametrosBeanPartialUpdateQueryHelper
 */
public class Tiido_parametrosBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"FEC_ACCI = ?, ","FEC_SEGU_1 = ?, ","FEC_SEGU_2 = ?, ","AFEC_ACCI = ?, ","AFEC_SEGU = ?, ","AFEC_PLAN = ?, ","FEC_PLAN = ?, ","TAP_USU_REGI = ?, ","FEC_REGI = ?, ","USU_ACTU = ?, ","FEC_ACTU = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_PARAMETROS SET ", " WHERE COD_PARAMETRO = ? ", assignmentColumns,246, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5,6,7,8,9,10,11};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
