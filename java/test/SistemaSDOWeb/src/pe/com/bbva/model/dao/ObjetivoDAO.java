package pe.com.bbva.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import pe.com.indra.component.model.AbstractSQL;

import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;

public class ObjetivoDAO extends AbstractSQL {
	
	public String[] registrar(MetasGestor meta) {
		String[] result = {"", ""};
		Object[] parameters = new Object[12];
		
		parameters[0] = meta.getOficina().getCodOfic(); // P_COD_OFIC
		parameters[1] = meta.getOficina().getTerr().getCodTerr(); // P_COD_TERR
		parameters[2] = meta.getCodEpigrafe(); // P_COD_EPIGRAFE
		parameters[3] = meta.getAnho(); // P_ANHO
		parameters[4] = meta.getCodGestor(); // P_COD_GESTOR
		parameters[5] = meta.getMes(); // P_MES
		parameters[6] = meta.getOrden() == null ? "" : meta.getOrden(); // P_ORDEN
		parameters[7] = meta.getPorcAsignado(); // P_PORC_ASIG
		parameters[8] = meta.getNomEpigrafe(); // P_NOM_EPIGRAFE
		parameters[9] = meta.getNomGestor(); // P_NOM_GESTOR 
		parameters[10] = meta.getCodPerfil(); // P_COD_PERFIL
		parameters[11] = meta.getUsuario(); // P_USU_REGI
		
		try {
			ResultSet rst = this.executeProcedure("IIDO.PK_OBJETIVO.PROC_INSERTAR_OBJETIVO", parameters);		
			try {
				if(rst != null) {
					result[0] = rst.getString("COD_META_GESTOR");
					result[1] = rst.getString("ACCION");
					rst.close();
				}
			} catch(SQLException e) {
				log.error("ObjetivoDAO :: registrar", e);
			}
		} catch(Exception e) {
			log.error("ObjetivoDAO :: registrar", e);
		} finally {
			this.close();
		}
		return result;
	}
}
