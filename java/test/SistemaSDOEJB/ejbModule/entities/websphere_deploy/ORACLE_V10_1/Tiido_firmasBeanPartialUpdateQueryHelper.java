package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_firmasBeanPartialUpdateQueryHelper
 */
public class Tiido_firmasBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"ANHO_FIRM = ?, ","MES_FIRM = ?, ","ITEM_FIRM = ?, ","COD_GESTOR = ?, ","DESCRIPCION = ?, ","FEC_FIRM = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_FIRMAS SET ", " WHERE COD_FIRMA = ?  AND COD_TERR = ? AND COD_OFIC = ?", assignmentColumns,188, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5,6};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
