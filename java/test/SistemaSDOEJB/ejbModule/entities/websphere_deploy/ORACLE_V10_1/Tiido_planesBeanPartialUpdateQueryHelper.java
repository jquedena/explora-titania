package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate;

/**
 * Tiido_planesBeanPartialUpdateQueryHelper
 */
public class Tiido_planesBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"NOM_EPIGRAFE = ?, ","PESO_DOR = ?, ","MONTO = ?, ","PORC_ALCANZADO = ?, ","DESV_PPTO = ?, ","NRO_MESES_FALT = ?, ","PROY_CREC_MEN = ?, ","AJUSTE_ESTIMADO_TERR = ?, ","PROY_AJUSTE_MEN = ?, ","SALDMEDI_JUNIO = ?, ","PORC_SALDMEDI_JUNIO = ?, ","SALD_DIC_ANTE = ?, ","SALDMEDI_DIC = ?, ","COD_TERRI = ?, ","PORC_SALDMEDI_DIC = ?, ","FAC_AJU_SAL_PUN = ?, ","HIST_BAJAS = ?, ","MET_MESSALD_PUNT = ?, ","MET_GER_OFI = ?, ","PRIORIDAD = ?, ","MES_EVAL = ?, ","IND_DOR = ?, ","VAR_MES = ?, ","AJUS_PPTO = ?, ","DESV_PPTO_AJUS = ?, ","FACT_AJUS_TERRI = ?, ","FACT_ASIG_GTE_OF = ?, ","FEC_ACTU = ?, ","USU_REGI = ?, ","USU_ACTU = ?, ","FEC_REGI = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE IIDO.TIIDO_PLANES SET ", " WHERE MES_PLAN = ?  AND ANHO_PLAN = ? AND COD_EPIGRAFE = ? AND COD_TERR = ? AND COD_OFIC = ?", assignmentColumns,734, isNullablePredicates);
			String[] predicateColumns = {"FEC_ACTU", "USU_REGI", "USU_ACTU", "FEC_REGI"};
			aTemplate0.setPredicateColumns(predicateColumns,846);
			int[] dirtyMap = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,32,33,34,35};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
