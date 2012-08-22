package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_multitablaBeanPartialUpdateQueryHelper
 */
public class Tiido_multitablaBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"VALOR1 = ?, ","VALOR2 = ?, ","VALOR3 = ?, ","VALOR4 = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_MULTITABLA SET ", " WHERE COD_MULT = ?  AND COD_ELEM = ?", assignmentColumns,127, isNullablePredicates);
			int[] dirtyMap = {2,3,4,5};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
