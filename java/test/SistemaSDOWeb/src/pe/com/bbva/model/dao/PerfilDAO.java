package pe.com.bbva.model.dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;

import pe.com.indra.component.model.AbstractSQL;

import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;

public class PerfilDAO extends AbstractSQL {

	private HashMap<String, Object> crearParametros(Perfil perfil) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("P_COD_PERFIL", perfil.getCodPerfil());
		parameters.put("P_NOM_PERFIL", perfil.getNomPerfil());
		parameters.put("P_USU_REGI", perfil.getUsuRegi());
		parameters.put("P_FEC_REGI", new Date());
		parameters.put("P_PERFIL", perfil.getPerfil());
		
		return parameters;
	}
	
	public boolean crearPerfil(Perfil perfil) {
		return (this.executeProcedure("iido.pk_perfil.proc_insertar_perfil", crearParametros(perfil)) != -1);
	}
	
	public boolean actualizarPerfil(Perfil perfil) {
		return (this.executeProcedure("iido.pk_perfil.proc_actualizar_perfil", crearParametros(perfil)) != -1);
	}
	
	public Equivalencia findEquivalenciaByCodCargo(String codCargo) {
		ResultSet rst = null;
		Equivalencia result = new Equivalencia();
		result.setCodPerfil("");
		result.setPerfil("");
		try {
			Object[] parameters = new Object[1];
			parameters[0] = codCargo;
			rst = this.executeProcedure("iido.pk_perfil.proc_consulta_perfil", parameters);
			
			if(rst != null) {
				while(rst.next()) {
					result.setCodCargo(rst.getString("COD_CAR")); 
					result.setCodPerfil(rst.getString("COD_PER"));
					result.setPerfil(rst.getString("PERFIL"));
					result.setNombrePerfil(rst.getString("NOM_PERFIL"));
					result.setUsuActualizo(rst.getString("USU_ACTU"));
					result.setUsuRegistro(rst.getString("USU_REGI"));
				}
				rst.close();
			}
		} catch(Exception e) {
			log.error("findEquivalenciaByCodCargo", e);
		} finally {
			this.close();
		}
		
		return result;
	}
}
