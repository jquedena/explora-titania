package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_territorioBeanPartialUpdateQueryHelper
 */
public class Tiido_territorioBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"NOM_TERR = ?, ","USU_REGI = ?, ","FEC_REGI = ?, ","USU_ACTU = ?, ","FEC_ACTU = ?, ","ESTADO = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_TERRITORIO SET ", " WHERE COD_TERR = ? ", assignmentColumns,148, isNullablePredicates);
			String[] predicateColumns = {"ESTADO"};
			aTemplate0.setPredicateColumns(predicateColumns,174);
			int[] dirtyMap = {1,2,3,4,5,6};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
