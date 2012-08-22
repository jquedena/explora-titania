package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_ingresosBeanPartialUpdateQueryHelper
 */
public class Tiido_ingresosBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"VECES = ?, ","VALIDO_VECES = ?, ","COD_USUARIO = ?, ","CARGO = ?, ","NOM_TERRITORIO = ?, ","COD_OFICINA = ?, ","FECHA = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_INGRESOS SET ", " WHERE ID_INGRESOS = ? ", assignmentColumns,174, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5,6,7};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
