package com.grupobbva.bc.per.tele.sdo.sesion;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import entities.Tiido_territorioLocal;
import com.ibm.etools.service.locator.ServiceLocatorManager;
import entities.Tiido_territorioLocalHome;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionTerritorio
 */

@SuppressWarnings({"serial", "unchecked", "unused"})
public class SesionTerritorioBean implements javax.ejb.SessionBean {
	
	private static Logger log = Logger.getLogger(SesionTerritorioBean.class);
	private javax.ejb.SessionContext mySessionCtx;
	private final static String STATIC_Tiido_territorioLocalHome_REF_NAME = "ejb/Tiido_territorio";
	private final static Class STATIC_Tiido_territorioLocalHome_CLASS = Tiido_territorioLocalHome.class;

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

	public Territorio findByCodTerritorio(String codTerritorio) {
		Territorio territorio = new Territorio();
		
		try {
			log.info("[SesionTerritorioBean :: findByCodTerritorio] Inicio");
			
			Tiido_territorioLocal aTiido_territorioLocal = find_Tiido_territorioLocalHome_findByCodTerritorio(codTerritorio);
			if (aTiido_territorioLocal != null) {
				territorio.setCodTerr(aTiido_territorioLocal.getCod_terr());
				territorio.setNomTerr(aTiido_territorioLocal.getNom_terr());
			}
			
			log.info("[SesionTerritorioBean :: findByCodTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: findByCodTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return territorio;
	}

	public Vector findAllTerritorio() {
		Vector listaTerritorio = new Vector();
		ListabusAllTerritorio territorioLocal = null;
		
		try {
			log.info("[SesionTerritorioBean :: findAllTerritorio] Inicio");
			
			// Collection aCollection = find_Tiido_territorioLocalHome_findAllTerritorio();
			Vector aCollection = busAllTerritorio();
			Iterator territorioIterator = aCollection.iterator();
			while (territorioIterator.hasNext()) {
					Territorio territorio = new Territorio();
					territorioLocal = (ListabusAllTerritorio) territorioIterator.next();				
					territorio.setCodTerr(territorioLocal.getCodTerritorio());
					territorio.setNomTerr(territorioLocal.getNomTerritorio());
					listaTerritorio.add(territorio);
			}
			
			log.info("[SesionTerritorioBean :: findAllTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: findAllTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
		return listaTerritorio;
	}
	
	protected Tiido_territorioLocal find_Tiido_territorioLocalHome_findByCodTerritorio(
			String codTerritorio) {
		try {
			log.info("[SesionTerritorioBean :: find_Tiido_territorioLocalHome_findByCodTerritorio] Inicio");
			
			Tiido_territorioLocalHome aTiido_territorioLocalHome = (Tiido_territorioLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_territorioLocalHome_REF_NAME,
					STATIC_Tiido_territorioLocalHome_CLASS);
			
			if (aTiido_territorioLocalHome != null) {
				log.info("[SesionTerritorioBean :: find_Tiido_territorioLocalHome_findByCodTerritorio] Fin");
				
				return aTiido_territorioLocalHome
						.findByCodTerritorio(codTerritorio);
			}
			
			log.info("[SesionTerritorioBean :: find_Tiido_territorioLocalHome_findByCodTerritorio] Fin");
		} catch (javax.ejb.FinderException e) {
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: find_Tiido_territorioLocalHome_findByCodTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Collection find_Tiido_territorioLocalHome_findAllTerritorio() {
		try {
			log.info("[SesionTerritorioBean :: find_Tiido_territorioLocalHome_findAllTerritorio] Inicio");
			
			Tiido_territorioLocalHome aTiido_territorioLocalHome = (Tiido_territorioLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_territorioLocalHome_REF_NAME,
					STATIC_Tiido_territorioLocalHome_CLASS);
			
			if (aTiido_territorioLocalHome != null) {
				log.info("[SesionTerritorioBean :: find_Tiido_territorioLocalHome_findAllTerritorio] Fin");
				
				return aTiido_territorioLocalHome.findAllTerritorio();
			}
			
			log.info("[SesionTerritorioBean :: find_Tiido_territorioLocalHome_findAllTerritorio] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: find_Tiido_territorioLocalHome_findAllTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	
//	OSCAR CORTEZ - BUSCAR TODOS LOS TERRITORIOS
	public Vector busAllTerritorio() {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {			
			log.info("[SesionTerritorioBean :: busAllTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionTerritorioBean :: busAllTerritorio] Fin");
				
				return null;
			}			
			
			log.info("[SesionTerritorioBean :: busAllTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionTerritorioBean :: busAllTerritorio] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				// Mostrar solo los territorios activos
				String sql =
					"select COD_TERR, NOM_TERR, ESTADO, MENSAJE  from tiido_territorio where estado = '0'order by NOM_TERR ASC";									
					
				log.info("[SesionTerritorioBean :: busAllTerritorio] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ListabusAllTerritorio();
					
					bean.setCodTerritorio(rst.getString(1));
					bean.setNomTerritorio(rst.getString(2));
					bean.setEstado(rst.getString(3));
					bean.setMensaje(rst.getString(4));
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionTerritorioBean :: busAllTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}		
			
			log.info("[SesionTerritorioBean :: busAllTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: busAllTerritorio] ");
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
				log.error("[SesionTerritorioBean :: busAllTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}	
	//FIN - OSCAR CORTEZ - BUSCAR TODOS LOS TERRITORIOS
	
	public Vector busAllTerritorioActivo() {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {			
			log.info("[SesionTerritorioBean :: busAllTerritorioActivo] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionTerritorioBean :: busAllTerritorioActivo] Fin");
				
				return null;
			}			
			
			log.info("[SesionTerritorioBean :: busAllTerritorioActivo] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionTerritorioBean :: busAllTerritorioActivo] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				// Muestra todos los territorios
				String sql = "SELECT cod_terr, nom_terr, estado FROM iido.tiido_territorio " +
						"ORDER BY nom_terr ASC ";									
					
				log.info("[SesionTerritorioBean :: busAllTerritorioActivo] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ListabusAllTerritorio();
					
					bean.setCodTerritorio(rst.getString(1));
					bean.setNomTerritorio(rst.getString(2));
					bean.setEstado(rst.getString(3));
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionTerritorioBean :: busAllTerritorioActivo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
			
			log.info("[SesionTerritorioBean :: busAllTerritorioActivo] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: busAllTerritorioActivo] ");
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
				log.error("[SesionTerritorioBean :: busAllTerritorioActivo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}					
		
		return res;	
	}	
	
	
	//	OSCAR CORTEZ - CREAR NUEVOS TERRITORIOS
	public Vector nuevoTerritorio(String codTerritorio, String nomTerritorio, 
			String mensaje, String colorFondo, String usuario) {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {			
			log.info("[SesionTerritorioBean :: nuevoTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionTerritorioBean :: nuevoTerritorio] Fin");
				
				return null;
			}	
			
			log.info("[SesionTerritorioBean :: nuevoTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionTerritorioBean :: nuevoTerritorio] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"Insert into TIIDO_TERRITORIO (COD_TERR,NOM_TERR,ESTADO, mensaje, color_fondo, usu_regi) VALUES " +
					"('"+codTerritorio+"','"+nomTerritorio+"','0', '" + mensaje + "', '" + colorFondo + "', '" + usuario + "')";								
					
				log.info("[SesionTerritorioBean :: nuevoTerritorio] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ListabusAllTerritorio();
					
					bean.setCodTerritorio(rst.getString(1));
					bean.setNomTerritorio(rst.getString(2));
					
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionTerritorioBean :: nuevoTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}	
			
			log.info("[SesionTerritorioBean :: nuevoTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: nuevoTerritorio] ");
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
				log.error("[SesionTerritorioBean :: nuevoTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}					
		
		return res;	
	}	
	//	FIN - OSCAR CORTEZ - CREAR NUEVOS TERRITORIOS
	
	//	OSCAR CORTEZ - MODIFICAR TERRITORIOS
	public Vector modificarTerritorio(String codTerritorio, String nomTerritorio, String estado, 
			String mensaje, String colorFondo, String usuario) {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {			
			log.info("[SesionTerritorioBean :: modificarTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionTerritorioBean :: modificarTerritorio] Fin");
				
				return null;
			}			
			
			log.info("[SesionTerritorioBean :: modificarTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionTerritorioBean :: modificarTerritorio] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"UPDATE tiido_territorio SET NOM_TERR='"+nomTerritorio+"', ESTADO='"+estado+"', mensaje = '"+ 
					mensaje + "', color_fondo = '"+  colorFondo + "', usu_actu='" + usuario +  "', fec_actu = SYSDATE " +  
					"WHERE COD_TERR = '"+codTerritorio+"'";
					
				log.info("[SesionTerritorioBean :: modificarTerritorio] SQL:" + sql);
				// rst = s.executeQuery(sql);
				s.execute(sql);
				
				/*while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ListabusAllTerritorio();
					
					bean.setCodTerritorio(rst.getString(1));
					bean.setNomTerritorio(rst.getString(2));
					
						
					res.add(bean);
				}*/
		
			} catch (SQLException e) {
				log.error("[SesionTerritorioBean :: modificarTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionTerritorioBean :: modificarTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: modificarTerritorio] ");
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
				log.error("[SesionTerritorioBean :: modificarTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}					
		
		return res;	
	}	
	//	FIN - OSCAR CORTEZ - MODIFICAR TERRITORIOS
	
//	OSCAR CORTEZ - BUSCAR TERRITORIO X CODIGO
	public Vector busTerritorioxCod(String codTerritorio) {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			log.info("[SesionTerritorioBean :: busTerritorioxCod] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionTerritorioBean :: busTerritorioxCod] Fin");
				
				return null;
			}		
			
			log.info("[SesionTerritorioBean :: busTerritorioxCod] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionTerritorioBean :: busTerritorioxCod] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"select COD_TERR, NOM_TERR, ESTADO, mensaje, color_fondo FROM tiido_territorio where COD_TERR='"+codTerritorio+"'";									
					
				log.info("[SesionTerritorioBean :: busTerritorioxCod] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ListabusAllTerritorio();
					
					bean.setCodTerritorio(rst.getString(1));
					bean.setNomTerritorio(rst.getString(2));
					bean.setEstado(rst.getString(3));
					bean.setMensaje(rst.getString(4));
					bean.setColorFondo(rst.getString(5));
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionTerritorioBean :: busTerritorioxCod] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
			
			log.info("[SesionTerritorioBean :: busTerritorioxCod] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: busTerritorioxCod] ");
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
				log.error("[SesionTerritorioBean :: busTerritorioxCod] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				return null;
			}
		}			
		
		return res;
	}	
	//FIN - OSCAR CORTEZ - BUSCAR TERRITORIO X CODIGO
	
//	OSCAR CORTEZ - ELIMINAR TERRITORIO
	public Vector eliminarTerritorio(String codTerritorio) {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {			
			log.info("[SesionTerritorioBean :: eliminarTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionTerritorioBean :: eliminarTerritorio] Fin");
				
				return null;
			}		
			
			log.info("[SesionTerritorioBean :: eliminarTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionTerritorioBean :: eliminarTerritorio] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"UPDATE tiido_territorio SET estado='1' WHERE COD_TERR = '"+codTerritorio+"'";
					
				log.info("[SesionTerritorioBean :: eliminarTerritorio] SQL:" + sql);
				rst = s.executeQuery(sql);			
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ListabusAllTerritorio();
					
					bean.setCodTerritorio(rst.getString(1));
					bean.setNomTerritorio(rst.getString(2));
					
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionTerritorioBean :: eliminarTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
			
			log.info("[SesionTerritorioBean :: eliminarTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: eliminarTerritorio] ");
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
				log.error("[SesionTerritorioBean :: eliminarTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}					
		
		return res;		
	}	
	//FIN - OSCAR CORTEZ - ELIMINAR TERRITORIO
	
	//INICIO - OSCAR CORTEZ - busTerritorioxRegistroLDAP
	public Vector busTerritorioxRegistroLDAP(String codGestor) {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {			
			log.info("[SesionTerritorioBean :: busTerritorioxRegistroLDAP] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionTerritorioBean :: busTerritorioxRegistroLDAP] Fin");
				
				return null;
			}			
			
			log.info("[SesionTerritorioBean :: busTerritorioxRegistroLDAP] DATASOURCE_LDAP:::" + ConstantesUtil.DATASOURCE_LDAP);
			
			DataSource datasource =(DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_LDAP);			

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionTerritorioBean :: busTerritorioxRegistroLDAP] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"SELECT codnivel3 FROM ldapperu2 where codusu='"+codGestor+"'";					
					
				log.info("[SesionTerritorioBean :: busTerritorioxRegistroLDAP] SQL:" + sql);
				rst = s.executeQuery(sql);			
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ListabusAllTerritorio();
					
					bean.setCodTerritorio(rst.getString(1));
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionTerritorioBean :: busTerritorioxRegistroLDAP] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}		
			
			log.info("[SesionTerritorioBean :: busTerritorioxRegistroLDAP] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: busTerritorioxRegistroLDAP] ");
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
				log.error("[SesionTerritorioBean :: busTerritorioxRegistroLDAP] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}					
		
		return res;		
	}
	
	public void editarMensajeTerritorio(String codTerritorio, String mensaje, String colorFondo) {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null; 
		
		try {			
			log.info("[SesionTerritorioBean :: editarMensajeTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionTerritorioBean :: editarMensajeTerritorio] Fin");
				
				return;
			}			
			
			log.info("[SesionTerritorioBean :: editarMensajeTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionTerritorioBean :: editarMensajeTerritorio] Fin");
				
				return;
			}

			s = con.createStatement();
			sql = "UPDATE tiido_territorio SET mensaje = '" + mensaje + "', color_fondo = '" + colorFondo + "' WHERE cod_terr = '" + codTerritorio + "'";
				
			log.info("[SesionTerritorioBean :: editarMensajeTerritorio] SQL: " +  sql);
			s.executeUpdate(sql);			
			
			log.info("[SesionTerritorioBean :: editarMensajeTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionTerritorioBean :: editarMensajeTerritorio] ");
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
				log.error("[SesionTerritorioBean :: editarMensajeTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return;
			}
		}					
		
		return;		
	}	
}
