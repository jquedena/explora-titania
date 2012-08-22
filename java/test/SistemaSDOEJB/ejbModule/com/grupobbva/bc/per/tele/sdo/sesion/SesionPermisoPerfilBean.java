package com.grupobbva.bc.per.tele.sdo.sesion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;
import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_perfilesKey;
import entities.Tiido_perfilesLocal;
import entities.Tiido_perfilesLocalHome;
import entities.Tiido_permiso_perfilKey;
import entities.Tiido_permiso_perfilLocal;
import entities.Tiido_permiso_perfilLocalHome;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionPermisoPerfil
 */
public class SesionPermisoPerfilBean implements javax.ejb.SessionBean {
	private static Logger log = Logger.getLogger(SesionPermisoPerfilBean.class);
	
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiido_permiso_perfilLocalHome_REF_NAME = "ejb/Tiido_permiso_perfil";

	private final static Class STATIC_Tiido_permiso_perfilLocalHome_CLASS = Tiido_permiso_perfilLocalHome.class;

	private final static String STATIC_Tiido_perfilesLocalHome_REF_NAME = "ejb/Tiido_perfiles";

	private final static Class STATIC_Tiido_perfilesLocalHome_CLASS = Tiido_perfilesLocalHome.class;

	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}

	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}

	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}

	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}

	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}

	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}

	public PermisoPerfil findPermisoPerfilxTipAccxValorRCP(String codReg,
			String codCat, String path) {
		PermisoPerfil permisoPerfil = null;
		String codRcp = null;
		
		log.info("[SesionPermisoPerfilBean :: findPermisoPerfilxTipAccxValorRCP] Inicio");
		
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

			String b = String.valueOf(y);
			Tiido_permiso_perfilLocal aTiicr_permiso_perfilLocal = null;
			Collection aCollection = find_Tiido_permiso_perfilLocalHome_findPermisoPerfilxTipAccxValorRCP(
					b, codRcp);

			if (aCollection.iterator().hasNext()) {
				aTiicr_permiso_perfilLocal = (Tiido_permiso_perfilLocal) aCollection
						.iterator().next();
			}

			if (aTiicr_permiso_perfilLocal != null) {
				Tiido_perfilesLocal aTiido_perfilesLocal = find_Tiido_perfilesLocalHome_findByPrimaryKey(new Tiido_perfilesKey(
						aTiicr_permiso_perfilLocal.getCod_perfil()));

				permisoPerfil = new PermisoPerfil();
				permisoPerfil.setCodPerfil(aTiicr_permiso_perfilLocal
						.getCod_perfil());
				permisoPerfil.setTipoAcceso(aTiicr_permiso_perfilLocal
						.getTip_acceso());
				permisoPerfil.setValorRCP(aTiicr_permiso_perfilLocal
						.getValor_rcp());

				if (aTiido_perfilesLocal != null) {
					Perfil perfil = new Perfil();
					perfil.setCodPerfil(aTiido_perfilesLocal.getCod_perfil());
					perfil.setNomPerfil(aTiido_perfilesLocal.getNom_perfil());
					permisoPerfil.setPerfil(perfil);
				} else
					permisoPerfil = null;
			}
			if (permisoPerfil != null) {
			}
			
		}
		if (permisoPerfil == null) {
			log.info("[SesionPermisoPerfilBean :: findPermisoPerfilxTipAccxValorRCP] Fin");
			
			return null;
		}
		
		log.info("[SesionPermisoPerfilBean :: findPermisoPerfilxTipAccxValorRCP] Fin");
		return permisoPerfil;
	}

	public Vector findAllPermisoPerfil() {
		Vector listoPermisos = null;
		Collection aCollection = null; 
			
		try {
			log.info("[SesionPermisoPerfilBean :: findAllPermisoPerfil] Inicio");
			
			aCollection = find_Tiido_permiso_perfilLocalHome_findAllPermisoPerfil();
			
			if (aCollection != null && aCollection.size() > 0) {
				Iterator it = aCollection.iterator();
				listoPermisos = new Vector();
	
				while (it.hasNext()) {
					Tiido_permiso_perfilLocal local = (Tiido_permiso_perfilLocal) it
							.next();
	
					if (local != null) {
						PermisoPerfil objPermiso = new PermisoPerfil();																	
						
						objPermiso.setCodPerfil(local.getCod_perfil());	
						
						String nombrePerfil = "";
						Tiido_perfilesLocal localPerfil = find_Tiido_perfilesLocalHome_findByPrimaryKey(new Tiido_perfilesKey(
								objPermiso.getCodPerfil()));
						
						if (localPerfil != null) {							
							nombrePerfil = localPerfil.getNom_perfil();
						}
						
						objPermiso.setNombrePerfil(nombrePerfil);											
						objPermiso.setValorRCP(local.getValor_rcp());
						objPermiso.setTipoAcceso(local.getTip_acceso());
						
						int valor = Integer.parseInt(objPermiso.getTipoAcceso());
						String nombreTipoAcceso = "";
						
						switch(valor) {
							case 1: nombreTipoAcceso = "Registro"; break; 
							case 2: nombreTipoAcceso = "Cargo"; break;
							case 3: nombreTipoAcceso = "Oficina"; break;
						}						
						
						objPermiso.setNombreTipoAcceso(nombreTipoAcceso);
						objPermiso.setUsuario(local.getUsuario());
						
						listoPermisos.add(objPermiso);
					}
				}
			}
			
			log.info("[SesionPermisoPerfilBean :: findAllPermisoPerfil] Fin");
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: findAllPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listoPermisos;
	}

	public PermisoPerfil findPermisoPerfilById(String codPerfil,
			String tipoAcceso, String valorRCP) {
		PermisoPerfil objPermiso = null;
		
		try {
			log.info("[SesionPermisoPerfilBean :: findPermisoPerfilById] Inicio");
			
			Tiido_permiso_perfilLocal aTiido_permiso_perfilLocal = find_Tiido_permiso_perfilLocalHome_findByPrimaryKey(new Tiido_permiso_perfilKey(
					codPerfil, tipoAcceso, valorRCP));

			if (aTiido_permiso_perfilLocal != null) {
				objPermiso = new PermisoPerfil();
				
				objPermiso.setCodPerfil(aTiido_permiso_perfilLocal
						.getCod_perfil());
				objPermiso.setValorRCP(aTiido_permiso_perfilLocal
						.getValor_rcp());
				objPermiso.setTipoAcceso(aTiido_permiso_perfilLocal
						.getTip_acceso());				
				objPermiso.setUsuario(aTiido_permiso_perfilLocal
						.getUsuario());
			}
			
			log.info("[SesionPermisoPerfilBean :: findPermisoPerfilById] Fin");
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: findPermisoPerfilById] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return objPermiso;
	}

	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil){
		try {
			log.info("[SesionPermisoPerfilBean :: createPermisoPerfil] Inicio");
			
			Tiido_permiso_perfilLocal aTiido_permiso_perfilLocal = createTiido_permiso_perfilLocal(permisoPerfil);
			if(aTiido_permiso_perfilLocal != null) {
				updateCreacionPermisoPerfilAuditoria(permisoPerfil);
			}
			
			log.info("[SesionPermisoPerfilBean :: createPermisoPerfil] Fin");
			
			return true;
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: createPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}
	
	public void updateCreacionPermisoPerfilAuditoria(PermisoPerfil permisoPerfil) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionPermisoPerfilBean :: updateCreacionPermisoPerfilAuditoria] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				return;
			}
			
			log.info("[SesionPermisoPerfilBean :: updateCreacionPermisoPerfilAuditoria] DATASOURCE_CONTEXT::: " + 
					ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				
				log.info("[SesionPermisoPerfilBean :: updateCreacionPermisoPerfilAuditoria] Fin");
				
				return;
			}

			s = con.createStatement();
			try {
				String sql = "UPDATE tiido_permiso_perfil SET usu_regi='" + permisoPerfil.getUsuRegi() + "'"   
						+ ", fec_regi = SYSDATE " 
						+ " WHERE cod_perfil='" + permisoPerfil.getCodPerfil() + "' AND "
						+ " tip_acceso='" + permisoPerfil.getTipoAcceso() + "' AND "
						+ " valor_rcp='" + permisoPerfil.getValorRCP() + "'";

				log.info("[SesionPermisoPerfilBean :: updateCreacionPermisoPerfilAuditoria] SQL: " + sql);
				
				s.execute(sql);
			} catch (SQLException e) {
				log.error("[SesionPermisoPerfilBean :: updateCreacionPermisoPerfilAuditoria] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionPermisoPerfilBean :: updateCreacionPermisoPerfilAuditoria] Fin");
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: updateCreacionPermisoPerfilAuditoria] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionPermisoPerfilBean :: updateCreacionPermisoPerfilAuditoria] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return;
			}
		}

		return;
	}

	public boolean deletePermisoPerfil(String codPerfil, String tipoAcceso,
			String valorRCP) {
		
		try {
			log.info("[SesionPermisoPerfilBean :: deletePermisoPerfil] Inicio");
			
			Tiido_permiso_perfilLocal aTiido_permiso_perfilLocal = find_Tiido_permiso_perfilLocalHome_findByPrimaryKey(new Tiido_permiso_perfilKey(
					codPerfil, tipoAcceso, valorRCP));

			if (aTiido_permiso_perfilLocal != null) {				
				aTiido_permiso_perfilLocal.remove();
				
				log.info("[SesionPermisoPerfilBean :: deletePermisoPerfil] Fin");
				return true;
			}
			
			log.info("[SesionPermisoPerfilBean :: deletePermisoPerfil] Fin");
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: deletePermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}

	public boolean updatePermisoPerfil(PermisoPerfil origPermisoPerfil, PermisoPerfil nuevoPermisoPerfil) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {			
			log.info("[SesionPermisoPerfilBean :: updatePermisoPerfil] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPermisoPerfilBean :: updatePermisoPerfil] Fin");
				
				return false;
			}			
			
			log.info("[SesionPermisoPerfilBean :: updatePermisoPerfil] DATASOURCE_CONTEXT:::" + 
					ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return false;
			}

			s = con.createStatement();
			try {
				String sql =					
					"UPDATE  iido.tiido_permiso_perfil SET cod_perfil='"+nuevoPermisoPerfil.getCodPerfil()+"', tip_acceso='"+nuevoPermisoPerfil.getTipoAcceso()+"'," +
							" valor_rcp='"+nuevoPermisoPerfil.getValorRCP()+"', usuario='"+nuevoPermisoPerfil.getUsuario()
							+"', usu_actu='"+nuevoPermisoPerfil.getUsuActu()+"', fec_actu=sysdate " +
							"WHERE cod_perfil='"+origPermisoPerfil.getCodPerfil()+"' and tip_acceso='"+origPermisoPerfil.getTipoAcceso()+"' and " +
							" valor_rcp='"+origPermisoPerfil.getValorRCP()+"'";								
				
				log.info("[SesionPermisoPerfilBean :: updatePermisoPerfil] SQL:" + sql);
				
				s.execute(sql);	
				
				log.info("[SesionPermisoPerfilBean :: updatePermisoPerfil] Fin");
			} catch (SQLException e) {
				log.error("[SesionPermisoPerfilBean :: updatePermisoPerfil] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: updatePermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(s != null) {
					s.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionPermisoPerfilBean :: updatePermisoPerfil] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}						
				
		return true;
	}
	
	protected Collection find_Tiido_permiso_perfilLocalHome_findPermisoPerfilxTipAccxValorRCP(
			String tipo_acceso, String valor_rcp) {
		
		try {
			log.info("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findPermisoPerfilxTipAccxValorRCP] Inicio");
			
			Tiido_permiso_perfilLocalHome aTiido_permiso_perfilLocalHome = (Tiido_permiso_perfilLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_permiso_perfilLocalHome_REF_NAME,
					STATIC_Tiido_permiso_perfilLocalHome_CLASS);
			
			if (aTiido_permiso_perfilLocalHome != null) {
				log.info("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findPermisoPerfilxTipAccxValorRCP] Fin");
				
				return aTiido_permiso_perfilLocalHome
						.findPermisoPerfilxTipAccxValorRCP(tipo_acceso,
								valor_rcp);
			}
			
			log.info("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findPermisoPerfilxTipAccxValorRCP] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findPermisoPerfilxTipAccxValorRCP] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_perfilesLocal find_Tiido_perfilesLocalHome_findByPrimaryKey(
			Tiido_perfilesKey primaryKey) {
		try {
			log.info("[SesionPermisoPerfilBean :: find_Tiido_perfilesLocalHome_findByPrimaryKey] Inicio");
			
			Tiido_perfilesLocalHome aTiido_perfilesLocalHome = (Tiido_perfilesLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_perfilesLocalHome_REF_NAME,
					STATIC_Tiido_perfilesLocalHome_CLASS);
			
			if (aTiido_perfilesLocalHome != null) {
				log.info("[SesionPermisoPerfilBean :: find_Tiido_perfilesLocalHome_findByPrimaryKey] Fin");
				
				return aTiido_perfilesLocalHome.findByPrimaryKey(primaryKey);
			}
			
			log.info("[SesionPermisoPerfilBean :: find_Tiido_perfilesLocalHome_findByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: find_Tiido_perfilesLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Collection find_Tiido_permiso_perfilLocalHome_findAllPermisoPerfil() {
		
		try {
			log.info("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findAllPermisoPerfil] Inicio");
			
			Tiido_permiso_perfilLocalHome aTiido_permiso_perfilLocalHome = (Tiido_permiso_perfilLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_permiso_perfilLocalHome_REF_NAME,
					STATIC_Tiido_permiso_perfilLocalHome_CLASS);
			
			if (aTiido_permiso_perfilLocalHome != null) {
				log.info("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findAllPermisoPerfil] Fin");
				
				return aTiido_permiso_perfilLocalHome.findAllPermisoPerfil();
			}
			
			log.info("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findAllPermisoPerfil] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findAllPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_permiso_perfilLocal find_Tiido_permiso_perfilLocalHome_findByPrimaryKey(
			Tiido_permiso_perfilKey primaryKey) {
	
		try {
			log.info("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findByPrimaryKey] Inicio");
			
			Tiido_permiso_perfilLocalHome aTiido_permiso_perfilLocalHome = (Tiido_permiso_perfilLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_permiso_perfilLocalHome_REF_NAME,
					STATIC_Tiido_permiso_perfilLocalHome_CLASS);
			
			if (aTiido_permiso_perfilLocalHome != null) {
				log.info("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findByPrimaryKey] Fin");
				
				return aTiido_permiso_perfilLocalHome
						.findByPrimaryKey(primaryKey);
			}
			
			log.info("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: find_Tiido_permiso_perfilLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_permiso_perfilLocal createTiido_permiso_perfilLocal(
			String cod_perfil, String tip_acceso, String valor_rcp) {
		
		try {
			log.info("[SesionPermisoPerfilBean :: createTiido_permiso_perfilLocal] Inicio");
			
			Tiido_permiso_perfilLocalHome aTiido_permiso_perfilLocalHome = (Tiido_permiso_perfilLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_permiso_perfilLocalHome_REF_NAME,
					STATIC_Tiido_permiso_perfilLocalHome_CLASS);
			
			if (aTiido_permiso_perfilLocalHome != null) {
				log.info("[SesionPermisoPerfilBean :: createTiido_permiso_perfilLocal] Fin");
				
				return aTiido_permiso_perfilLocalHome.create(cod_perfil,
						tip_acceso, valor_rcp);
			}
			
			log.info("[SesionPermisoPerfilBean :: createTiido_permiso_perfilLocal] Fin");
		} catch (javax.ejb.CreateException ce) {
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: createTiido_permiso_perfilLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	
	protected Tiido_permiso_perfilLocal createTiido_permiso_perfilLocal(
			PermisoPerfil permisoPerfil) {
		
		try {
			log.info("[SesionPermisoPerfilBean :: createTiido_permiso_perfilLocal] Inicio");
			
			Tiido_permiso_perfilLocalHome aTiido_permiso_perfilLocalHome = (Tiido_permiso_perfilLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_permiso_perfilLocalHome_REF_NAME,
					STATIC_Tiido_permiso_perfilLocalHome_CLASS);
			
			if (aTiido_permiso_perfilLocalHome != null) {
				log.info("[SesionPermisoPerfilBean :: createTiido_permiso_perfilLocal] Fin");
				
				return aTiido_permiso_perfilLocalHome.create(permisoPerfil);
			}
			
			log.info("[SesionPermisoPerfilBean :: createTiido_permiso_perfilLocal] Fin");
		} catch (javax.ejb.CreateException ce) {
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: createTiido_permiso_perfilLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	
	public int registrarPermisoPerfil(PermisoPerfil permisoPerfil){
		Connection con = null;
		Context initialContext = null;
		PreparedStatement statement = null; 
		int resultado = 0;
		String sql = null;
		
		try {			
			log.info("[SesionPermisoPerfilBean :: registrarPermisoPerfil] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPermisoPerfilBean :: registrarPermisoPerfil] Fin");
				
				return resultado;
			}			
			
			log.info("[SesionPermisoPerfilBean :: registrarPermisoPerfil] DATASOURCE_CONTEXT:::" + 
					ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return resultado;
			}
			
			permisoPerfil.setCodPerfil(permisoPerfil.getCodPerfil() != null ? 
					permisoPerfil.getCodPerfil().trim() : permisoPerfil.getCodPerfil());
			permisoPerfil.setTipoAcceso(permisoPerfil.getTipoAcceso() != null ? 
					permisoPerfil.getTipoAcceso().trim() : permisoPerfil.getTipoAcceso());
			permisoPerfil.setValorRCP(permisoPerfil.getValorRCP() != null ? 
					permisoPerfil.getValorRCP().trim() : permisoPerfil.getValorRCP());
			permisoPerfil.setUsuario(permisoPerfil.getUsuario() != null ? 
					permisoPerfil.getUsuario().trim() : permisoPerfil.getUsuario());

			sql = "INSERT INTO tiido_permiso_perfil(cod_perfil, tip_acceso, valor_rcp, usuario, usu_regi) VALUES (?,?,?,?,?)";
			
			log.info("[SesionPermisoPerfilBean :: registrarPermisoPerfil] SQL:" + sql);
			
			statement = con.prepareStatement(sql);
			statement.setString(1, permisoPerfil.getCodPerfil());
			statement.setString(2, permisoPerfil.getTipoAcceso());
			statement.setString(3, permisoPerfil.getValorRCP());
			statement.setString(4, permisoPerfil.getUsuario());
			statement.setString(5, permisoPerfil.getUsuRegi());
			
			resultado = statement.executeUpdate();
			
			log.info("[SesionPermisoPerfilBean :: registrarPermisoPerfil] Fin");
		} catch (Exception e) {
			log.error("[SesionPermisoPerfilBean :: registrarPermisoPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(con != null) {
					con.close();
				}
				
				if(initialContext != null) {
					initialContext.close();
				}		
			} catch (Exception e) {
				log.error("[SesionPermisoPerfilBean :: registrarPermisoPerfil] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return resultado;
			}
		}				
		
		return resultado;
	}
}
