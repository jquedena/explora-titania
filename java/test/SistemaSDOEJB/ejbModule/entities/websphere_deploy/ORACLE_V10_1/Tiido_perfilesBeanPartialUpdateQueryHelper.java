package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_perfilesBeanPartialUpdateQueryHelper
 */
public class Tiido_perfilesBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"NOM_PERFIL = ?, ","USU_REGI = ?, ","FEC_REGI = ?, ","USU_ACTU = ?, ","FEC_ACTU = ?, ","PERFIL = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_PERFILES SET ", " WHERE COD_PERFIL = ? ", assignmentColumns,150, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5,6};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
