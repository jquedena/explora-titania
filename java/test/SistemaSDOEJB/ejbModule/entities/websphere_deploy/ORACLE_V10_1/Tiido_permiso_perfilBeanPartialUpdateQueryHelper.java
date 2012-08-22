package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_permiso_perfilBeanPartialUpdateQueryHelper
 */
public class Tiido_permiso_perfilBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"USUARIO = ?, ","USU_REGI = ?, ","FEC_REGI = ?, ","USU_ACTU = ?, ","FEC_ACTU = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_PERMISO_PERFIL SET ", " WHERE COD_PERFIL = ?  AND TIP_ACCESO = ? AND VALOR_RCP = ?", assignmentColumns,176, isNullablePredicates);
			String[] predicateColumns = {"USUARIO", "USU_REGI", "FEC_REGI", "USU_ACTU", "FEC_ACTU"};
			aTemplate0.setPredicateColumns(predicateColumns,315);
			int[] dirtyMap = {3,4,5,6,7};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
