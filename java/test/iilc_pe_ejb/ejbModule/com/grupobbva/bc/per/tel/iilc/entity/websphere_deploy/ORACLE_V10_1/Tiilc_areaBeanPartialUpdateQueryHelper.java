package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiilc_areaBeanPartialUpdateQueryHelper
 */
public class Tiilc_areaBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"DES_AREA = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IILC.TIILC_AREA SET ", " WHERE COD_AREA = ? ", assignmentColumns,64, isNullablePredicates);
			int[] dirtyMap = {1};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
