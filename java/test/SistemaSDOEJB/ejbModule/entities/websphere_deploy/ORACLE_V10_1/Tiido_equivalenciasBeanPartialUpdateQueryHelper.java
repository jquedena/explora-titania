package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_equivalenciasBeanPartialUpdateQueryHelper
 */
public class Tiido_equivalenciasBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"COD_PER = ?, ","USU_REGI = ?, ","FEC_REGI = ?, ","USU_ACTU = ?, ","FEC_ACTU = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_EQUIVALENCIAS SET ", " WHERE COD_CAR = ? ", assignmentColumns,135, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
