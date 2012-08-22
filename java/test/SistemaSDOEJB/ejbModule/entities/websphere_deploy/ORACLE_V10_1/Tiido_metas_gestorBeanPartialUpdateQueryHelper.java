package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_metas_gestorBeanPartialUpdateQueryHelper
 */
public class Tiido_metas_gestorBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"COD_GESTOR = ?, ","MES = ?, ","ORDEN = ?, ","FEC_REGI = ?, ","PORC_ASIG = ?, ","NOM_EPIGRAFE = ?, ","NOM_GESTOR = ?, ","COD_PERFIL = ?, ","ESTADO = ?, ","FEC_ACTU = ?, ","USU_REGI = ?, ","USU_ACTU = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_METAS_GESTOR SET ", " WHERE COD_META_GESTOR = ?  AND COD_EPIGRAFE = ? AND ANHO = ? AND COD_TERR = ? AND COD_OFIC = ?", assignmentColumns,324, isNullablePredicates);
			String[] predicateColumns = {"COD_PERFIL", "ESTADO", "FEC_ACTU", "USU_REGI", "USU_ACTU"};
			aTemplate0.setPredicateColumns(predicateColumns,464);
			int[] dirtyMap = {1,2,3,4,5,6,7,12,13,14,15,16};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
