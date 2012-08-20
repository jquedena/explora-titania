package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiilc_multitablaBeanPartialUpdateQueryHelper
 */
public class Tiilc_multitablaBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"VALOR1 = ?, ","VALOR2 = ?, ","VALOR3 = ?, ","VALOR4 = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IILC.TIILC_MULTITABLA SET ", " WHERE COD_MULT = ?  AND COD_ELE = ?", assignmentColumns,126, isNullablePredicates);
			int[] dirtyMap = {2,3,4,5};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
