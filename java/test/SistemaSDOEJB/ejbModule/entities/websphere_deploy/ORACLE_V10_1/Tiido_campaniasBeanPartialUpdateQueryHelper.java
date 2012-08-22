package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_campaniasBeanPartialUpdateQueryHelper
 */
public class Tiido_campaniasBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"NOM_CAMP = ?, ","COD_GEST = ?, ","ORDEN = ?, ","GTE = ?, ","FEC_REGI = ?, ","USU_REGI = ?, ","FEC_ACTU = ?, ","USU_ACTU = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_CAMPANIAS SET ", " WHERE COD_CAMP = ?  AND ANHO = ? AND MES = ? AND COD_TERR = ? AND COD_OFIC = ?", assignmentColumns,232, isNullablePredicates);
			int[] dirtyMap = {3,4,5,6,7,8,9,10};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
