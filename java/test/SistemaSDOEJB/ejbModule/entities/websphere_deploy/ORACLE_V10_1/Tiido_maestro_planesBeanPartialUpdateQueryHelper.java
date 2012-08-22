package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_maestro_planesBeanPartialUpdateQueryHelper
 */
public class Tiido_maestro_planesBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"PRIORIDAD = ?, ","FEC_GRAB = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_MAESTRO_PLANES SET ", " WHERE MES = ?  AND ANHO = ? AND COD_TERR = ? AND COD_OFIC = ?", assignmentColumns,133, isNullablePredicates);
			int[] dirtyMap = {2,3};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
