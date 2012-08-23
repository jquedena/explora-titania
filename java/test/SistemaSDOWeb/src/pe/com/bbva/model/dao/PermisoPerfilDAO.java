package pe.com.bbva.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import pe.com.indra.component.model.AbstractSQL;

import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;
import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;

public class PermisoPerfilDAO extends AbstractSQL {
	
	public PermisoPerfil findPermisoPerfilxTipAccxValorRCP(String codReg, String codCat, String path) {
		
		String query = "";
		String codRcp = "";				
		PermisoPerfil permisoPerfil = null;
		Perfil perfil = null;
		Equivalencia equivalencia = null;
		PerfilDAO dao = new PerfilDAO();

		log.info("[PermisoPerfilDAO :: findPermisoPerfilxTipAccxValorRCP] Inicio");
		
		for (int y = 1; y <= 2; y++) {

			switch (y) {
			case 1:
				codRcp = codReg;
				break;
			case 2:
				codRcp = codCat;
				break;
			case 3:
				codRcp = path;
				break;
			}

			query = "select COD_PERFIL, TIP_ACCESO, VALOR_RCP, USUARIO, USU_REGI, FEC_REGI, USU_ACTU, FEC_ACTU from IIDO.TIIDO_PERMISO_PERFIL q1 where TIP_ACCESO='" + y + "'  and VALOR_RCP='" + codRcp + "'  order by COD_PERFIL asc";
			
			try {
				ResultSet rst = this.executeQuery(query);		
				try {
					if(rst != null) {
						permisoPerfil = new PermisoPerfil();
						permisoPerfil.setCodPerfil(rst.getString("COD_PERFIL"));
						permisoPerfil.setTipoAcceso(rst.getString("TIP_ACCESO"));
						permisoPerfil.setValorRCP(rst.getString("VALOR_RCP"));

						equivalencia = dao.findEquivalenciaByCodCargo(codCat);
						perfil = new Perfil();
						perfil.setCodPerfil(equivalencia.getCodPerfil());
						perfil.setNomPerfil(equivalencia.getNombrePerfil());
						
						rst.close();
					}
				} catch(SQLException e) {
					log.error("PermisoPerfilDAO :: findPermisoPerfilxTipAccxValorRCP", e);
				}
			} catch(Exception e) {
				log.error("PermisoPerfilDAO :: findPermisoPerfilxTipAccxValorRCP", e);
			} finally {
				this.close();
			}
		}
		
		log.info("[PermisoPerfilDAO :: findPermisoPerfilxTipAccxValorRCP] Fin");
		return permisoPerfil;
	}
}
