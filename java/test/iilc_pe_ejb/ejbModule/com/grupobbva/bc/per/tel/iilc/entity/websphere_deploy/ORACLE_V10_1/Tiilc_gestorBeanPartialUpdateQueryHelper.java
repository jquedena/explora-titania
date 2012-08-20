package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiilc_gestorBeanPartialUpdateQueryHelper
 */
public class Tiilc_gestorBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"NOM_GESTOR = ?, ","REG_GESTOR = ?, ","PERFIL_GESTOR = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IILC.TIILC_GESTOR SET ", " WHERE COD_GESTOR = ?  AND COD_AREA = ? AND COD_TERRITORIO = ? AND COD_OFICINA = ?", assignmentColumns,169, isNullablePredicates);
			int[] dirtyMap = {1,2,3};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
