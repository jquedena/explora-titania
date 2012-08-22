package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_oficinaBeanPartialUpdateQueryHelper
 */
public class Tiido_oficinaBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"NOM_OFIC = ?, ","USU_REGI = ?, ","FEC_REGI = ?, ","USU_ACTU = ?, ","FEC_ACTU = ?, ","ESTADO = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_OFICINA SET ", " WHERE COD_OFIC = ?  AND COD_TERR = ?", assignmentColumns,162, isNullablePredicates);
			String[] predicateColumns = {"ESTADO"};
			aTemplate0.setPredicateColumns(predicateColumns,188);
			int[] dirtyMap = {1,2,3,4,5,7};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
