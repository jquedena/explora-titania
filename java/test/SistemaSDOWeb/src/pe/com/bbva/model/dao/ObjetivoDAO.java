package pe.com.bbva.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import pe.com.indra.component.model.AbstractSQL;

import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;

public class ObjetivoDAO extends AbstractSQL {
	
	public String[] registrar(MetasGestor meta) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("P_COD_OFIC", meta.getOficina());
		parameters.put("P_COD_EPIGRAFE", meta.getCodEpigrafe());
		parameters.put("P_ANHO", meta.getAnho());
		parameters.put("P_COD_GESTOR", meta.getCodGestor());
		parameters.put("P_MES", meta.getMes());
		parameters.put("P_ORDEN", meta.getOrden());
		parameters.put("P_PORC_ASIG", meta.getPorcAsignado());
		parameters.put("P_NOM_EPIGRAFE", meta.getNomEpigrafe());
		parameters.put("P_NOM_GESTOR", meta.getNomGestor());
		parameters.put("P_COD_PERFIL", meta.getCodPerfil());
		parameters.put("P_USU_REGI", meta.getUsuario());
		
		ResultSet rst = this.executeProcedure("IIDO.PK_OBJETIVO.PROC_INSERTAR_OBJETIVO", parameters, "P_REF");
		String[] result = new String[2];
		
		try {
			if(rst != null) {
				result[0] = rst.getString("COD_META_GESTOR");
				result[1] = rst.getString("ACCION");
			}
		} catch(SQLException e) {
			log.error("ObjetivoDAO :: registrar", e);
		}
		
		this.close();
		
		return result;
	}
}
