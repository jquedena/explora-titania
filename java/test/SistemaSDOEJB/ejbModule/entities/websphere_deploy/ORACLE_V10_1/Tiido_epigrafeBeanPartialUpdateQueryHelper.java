package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_epigrafeBeanPartialUpdateQueryHelper
 */
public class Tiido_epigrafeBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"NOM_EPIGRAFE = ?, ","IND_CLASE = ?, ","IND_SUB_CLASE = ?, ","ORDEN = ?, ","IND_GRUPO = ?, ","ABREVIATURA = ?, ","IND_HIJO = ?, ","IND_AFECTA = ?, ","PORCENTAJE_MAX = ?, ","PORCENTAJE_MIN = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_EPIGRAFE SET ", " WHERE COD_EPIGRAFE = ?  AND ANHO = ?", assignmentColumns,254, isNullablePredicates);
			String[] predicateColumns = {"PORCENTAJE_MAX", "PORCENTAJE_MIN"};
			aTemplate0.setPredicateColumns(predicateColumns,322);
			int[] dirtyMap = {2,3,4,5,6,7,8,9,10,11};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
