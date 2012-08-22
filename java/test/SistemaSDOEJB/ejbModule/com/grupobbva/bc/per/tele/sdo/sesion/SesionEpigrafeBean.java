package com.grupobbva.bc.per.tele.sdo.sesion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_epigrafeLocal;
import entities.Tiido_epigrafeLocalHome;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionEpigrafe
 */
@SuppressWarnings({"unchecked", "unused", "serial"})
public class SesionEpigrafeBean implements javax.ejb.SessionBean {
	private static Logger log = Logger.getLogger(SesionEpigrafeBean.class);
	
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiido_epigrafeLocalHome_REF_NAME = "ejb/Tiido_epigrafe";

	private final static Class STATIC_Tiido_epigrafeLocalHome_CLASS = Tiido_epigrafeLocalHome.class;

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

	public Vector findEpiByAnho(String anho) {
		Vector listaEpigrafe = new Vector();
		Tiido_epigrafeLocal epigrafeLocal = null;
		
		try {
			log.info("[SesionEpigrafeBean :: findEpiByAnho] Inicio");
			
			Collection aCollection = find_Tiido_epigrafeLocalHome_findEpiByAnho(anho);
			Iterator epigrafeIterator = aCollection.iterator();
			while (epigrafeIterator.hasNext()) {
				Epigrafe epigrafe = new Epigrafe();
				epigrafeLocal = (Tiido_epigrafeLocal) epigrafeIterator.next();
				epigrafe.setAbreviatura(epigrafeLocal.getAbreviatura());
				epigrafe.setAnho(epigrafeLocal.getAnho());
				epigrafe.setCodEpigrafe(epigrafeLocal.getCod_epigrafe());
				epigrafe.setIndAfecta(epigrafeLocal.getInd_afecta());
				epigrafe.setIndClase(epigrafeLocal.getInd_clase());
				epigrafe.setIndGrupo(epigrafeLocal.getInd_grupo());
				epigrafe.setIndHijo(epigrafeLocal.getInd_hijo());
				epigrafe.setIndSubClase(epigrafeLocal.getInd_sub_clase());
				epigrafe.setNomEpigrafe(epigrafeLocal.getNom_epigrafe());
				epigrafe.setOrden(epigrafeLocal.getOrden());
				epigrafe.setPorcentajeMax(epigrafeLocal.getPorcentaje_max());
				epigrafe.setPorcentajeMin(epigrafeLocal.getPorcentaje_min());
				listaEpigrafe.add(epigrafe);
			}
			
			log.info("[SesionEpigrafeBean :: findEpiByAnho] Fin");
			
			return listaEpigrafe;
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: findEpiByAnho] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
	}
	
	/* Por optimizar */
	/*public Epigrafe findByCodEpigAnho(String codEpigrafe, String anho) {
		Epigrafe epigrafe = new Epigrafe();
		try {
			Tiido_epigrafeLocal aTiido_epigrafeLocal = find_Tiido_epigrafeLocalHome_findByCodEpigAnho(
					codEpigrafe, anho);
			if (aTiido_epigrafeLocal != null) {
				epigrafe.setAbreviatura(aTiido_epigrafeLocal.getAbreviatura());
				epigrafe.setAnho(aTiido_epigrafeLocal.getAnho());
				epigrafe.setCodEpigrafe(aTiido_epigrafeLocal.getCod_epigrafe());
				epigrafe.setIndAfecta(aTiido_epigrafeLocal.getInd_afecta());
				epigrafe.setIndClase(aTiido_epigrafeLocal.getInd_clase());
				epigrafe.setIndGrupo(aTiido_epigrafeLocal.getInd_grupo());
				epigrafe.setIndHijo(aTiido_epigrafeLocal.getInd_hijo());
				epigrafe
						.setIndSubClase(aTiido_epigrafeLocal.getInd_sub_clase());
				epigrafe.setNomEpigrafe(aTiido_epigrafeLocal.getNom_epigrafe());
				epigrafe.setOrden(aTiido_epigrafeLocal.getOrden());
				epigrafe.setPorcentajeMax(aTiido_epigrafeLocal
						.getPorcentaje_max());
				epigrafe.setPorcentajeMin(aTiido_epigrafeLocal
						.getPorcentaje_min());
			}
		} catch (Exception e) {
		}
		return epigrafe;
	}*/
	
	public Epigrafe findByCodEpigAnho(String codEpigrafe, String anho) {
		Epigrafe epigrafe = new Epigrafe();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;

		try {
			log.info("[SesionEpigrafeBean :: findByCodEpigAnho] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionEpigrafeBean :: findByCodEpigAnho] Fin");
				
				return epigrafe;
			}
			
			log.info("[SesionEpigrafeBean :: findByCodEpigAnho] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				
				log.info("[SesionEpigrafeBean :: findByCodEpigAnho] Fin");
				return epigrafe;
			}

			s = con.createStatement();
			sql = "SELECT abreviatura, anho, cod_epigrafe, ind_afecta, ind_clase, ind_grupo, ind_hijo, ind_sub_clase, " +
				  "nom_epigrafe, orden, porcentaje_max, porcentaje_min " +
				  "FROM tiido_epigrafe e WHERE  cod_epigrafe = '" + codEpigrafe + "' AND  anho = '" + anho + "'";

			log.info("[SesionEpigrafeBean :: findByCodEpigAnho] SQL:" + sql);
			rst = s.executeQuery(sql);

			if (rst.next()) {
				epigrafe.setAbreviatura(rst.getString("abreviatura"));
				epigrafe.setAnho(rst.getString("anho"));
				epigrafe.setCodEpigrafe(rst.getString("cod_epigrafe"));
				epigrafe.setIndAfecta(rst.getString("ind_afecta"));
				epigrafe.setIndClase(rst.getString("ind_clase"));
				epigrafe.setIndGrupo(rst.getString("ind_grupo"));
				epigrafe.setIndHijo(rst.getString("ind_hijo"));
				epigrafe.setIndSubClase(rst.getString("ind_sub_clase"));
				epigrafe.setNomEpigrafe(rst.getString("nom_epigrafe"));
				epigrafe.setOrden(rst.getString("orden"));
				epigrafe.setPorcentajeMax(rst.getString("porcentaje_max") != null ? new BigDecimal(rst.getString("porcentaje_max")) : new BigDecimal(0));
				epigrafe.setPorcentajeMin(rst.getString("porcentaje_min") != null ? new BigDecimal(rst.getString("porcentaje_min")) : new BigDecimal(0));				
			}
			
			log.info("[SesionEpigrafeBean :: findByCodEpigAnho] Fin");
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: findByCodEpigAnho] ");
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
				log.error("[SesionEpigrafeBean :: findByCodEpigAnho] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return epigrafe;
			}
		}

		return epigrafe;
	}	
	
	public boolean existeEpigrafe(String codEpigrafe, String anho) {
		boolean resp = false;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;

		try {
			log.info("[SesionEpigrafeBean :: existeEpigrafe] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				return false;
			}
			
			log.info("[SesionEpigrafeBean :: existeEpigrafe] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				
				log.info("[SesionEpigrafeBean :: existeEpigrafe] Fin");
				return false;
			}

			s = con.createStatement();
			sql = "SELECT COUNT(*) FROM tiido_epigrafe e WHERE  cod_epigrafe = '" + codEpigrafe + "' AND  anho = '" + anho + "'";

			log.info("[SesionEpigrafeBean :: existeEpigrafe] SQL:" + sql);
			rst = s.executeQuery(sql);

			if (rst.next()) {
				if(rst.getInt(1) > 0) {
					resp = true;
				}												
			}
			
			log.info("[SesionEpigrafeBean :: existeEpigrafe] Fin");
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: existeEpigrafe] ");
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
				log.error("[SesionEpigrafeBean :: existeEpigrafe] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		}

		return resp;
	}	
	
	public Oficina findByCodOficina(String codOficina) {
		Territorio territorio = null;
		Oficina oficina = new Oficina();
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;

		try {
			log.info("[SesionEpigrafeBean :: findByCodOficina] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionEpigrafeBean :: findByCodOficina] Fin");
				
				return oficina;
			}
			
			log.info("[SesionEpigrafeBean :: findByCodOficina] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionEpigrafeBean :: findByCodOficina] Fin");
				
				return oficina;
			}

			s = con.createStatement();
			sql = "SELECT o.cod_ofic cod_ofic, o.nom_ofic nom_ofic, o.cod_terr cod_terr " + 
				  "FROM tiido_oficina o,  tiido_territorio t "+
				  "WHERE  o.cod_terr = t.cod_terr AND " +
			      "o.cod_ofic = '" + codOficina + "' AND t.estado = '0'";

			log.info("[SesionEpigrafeBean :: findByCodOficina] SQL:" + sql);
			rst = s.executeQuery(sql);

			if (rst.next()) {
				territorio = new Territorio();
				territorio.setCodTerr(rst.getString("cod_terr"));
				
				oficina.setCodOfic(rst.getString("cod_ofic"));
				oficina.setCodNomOficina(rst.getString("nom_ofic"));
				oficina.setTerr(territorio);				
			}
			
			log.info("[SesionEpigrafeBean :: findByCodOficina] Fin");
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: findByCodOficina] ");
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
				log.error("[SesionEpigrafeBean :: findByCodOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return oficina;
			}
		}

		return oficina;
	}	

	/**
	 * Auto: Godofredo Ureta
	 * Fecha: 09/07/2009
	 * @param anho
	 * @return Vector, con toda la lista de epigrafes con sus respectivos valores.
	 */
	public Vector findEpigrafeInf(String anho) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector listaEpigrafe = new Vector();
		Vector listarRest = new Vector();
		Tiido_epigrafeLocal epigrafeLocal = null;
		boolean fResult = false;
		String codOficinas = "";
		
		try {
			log.info("[SesionEpigrafeBean :: findEpigrafeInf] Inicio");
			
			initialContext = new InitialContext();
			
			
			log.info("[SesionEpigrafeBean :: findEpigrafeInf] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
			}

			s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			try {
				//String sql = "Delete tiido_epigrafe Where anho = '"+anhoA+"'";
				String sql = "Select cod_epigrafe, cod_ofic, Sum(SaldMedi_Junio - Monto) As Valor ";
				sql = sql + " From tiido_planes Where anho_plan = '" + anho
						+ "' and mes_plan = '05' ";
				sql = sql + " Group By cod_epigrafe, cod_ofic ";
				sql = sql + " Having Sum(SaldMedi_Junio - Monto) < 0 ";
				sql = sql + " Order By cod_epigrafe, cod_ofic ";

				log.info("[SesionEpigrafeBean :: findEpigrafeInf] SQL:" + sql);
				rst = s.executeQuery(sql);
				fResult = true;

			} catch (SQLException e) {
				fResult = false;				
				log.error("[SesionEpigrafeBean :: findEpigrafeInf] ");
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
					log.error("[SesionEpigrafeBean :: findEpigrafeInf] ");
					ConstantesUtil.mostrarMensajeExcepcion(e);
					return null;
				}
			}			

			Collection aCollection = find_Tiido_epigrafeLocalHome_findEpiByAnho(anho);
			Iterator epigrafeIterator = aCollection.iterator();
			while (epigrafeIterator.hasNext()) {
				Epigrafe epigrafe = new Epigrafe();
				epigrafeLocal = (Tiido_epigrafeLocal) epigrafeIterator.next();
				epigrafe.setAnho(epigrafeLocal.getAnho());
				epigrafe.setCodEpigrafe(epigrafeLocal.getCod_epigrafe());

				while (rst.next()) {

					if (epigrafeLocal.getCod_epigrafe().trim().equals(
							rst.getString(1).trim())) {

						if (codOficinas == "") {
							codOficinas = rst.getString(2);
						} else {
							codOficinas = codOficinas + ", " + rst.getString(2);
						}
					}
				}

				boolean rsFirst = rst.first();

				epigrafe.setAbreviatura(codOficinas);
				codOficinas = "";
				epigrafe.setIndAfecta(epigrafeLocal.getInd_afecta());
				epigrafe.setIndClase(epigrafeLocal.getInd_clase());
				epigrafe.setIndGrupo(epigrafeLocal.getInd_grupo());
				epigrafe.setIndHijo(epigrafeLocal.getInd_hijo());
				epigrafe.setIndSubClase(epigrafeLocal.getInd_sub_clase());
				epigrafe.setNomEpigrafe(epigrafeLocal.getNom_epigrafe());
				epigrafe.setOrden(epigrafeLocal.getOrden());
				listaEpigrafe.add(epigrafe);
			}			
			
			log.info("[SesionEpigrafeBean :: findEpigrafeInf] Fin");
			
			return listaEpigrafe;
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: findEpigrafeInf] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			return null;
		}
	}

	public int actualizarPorcentajeEpigrafe(Epigrafe datos) {
		log.info("[SesionEpigrafeBean :: actualizarPorcentajeEpigrafe] Inicio");
		
		int res = 0;
		Epigrafe epigrafe = null;  	
		Tiido_epigrafeLocal aTiido_epigrafeLocal = find_Tiido_epigrafeLocalHome_findByCodEpigAnho(
				datos.getCodEpigrafe(), datos.getAnho());
		
		if (aTiido_epigrafeLocal != null){
			aTiido_epigrafeLocal.setPorcentaje_max(datos.getPorcentajeMax());
			aTiido_epigrafeLocal.setPorcentaje_min(datos.getPorcentajeMin());
			res = 1;
		}
		
		epigrafe = findByCodEpigAnho(datos.getCodEpigrafe(), datos.getAnho());
		if(epigrafe != null && epigrafe.getCodEpigrafe() != null) {
			res = 1;
		}
		
		log.info("[SesionEpigrafeBean :: actualizarPorcentajeEpigrafe] Fin");
		
		return res;
	}
	
	
	/**
	 * Auto: Godofredo Ureta
	 * Fecha: 02/06/2009
	 * @param epigrafe
	 * @return Boolena, True si todo se genero bien, y False si no tuvo exito
	 */
	public boolean createEpigrafe(Epigrafe epigrafe) {
		Tiido_epigrafeLocal aTiido_epigrafeLocal = null; 
		boolean resp = false;
	
		try {
			log.info("[SesionEpigrafeBean :: createEpigrafe] Inicio");
			
			//(2011.02.04) Validar como duplicado considerando tamanio
			aTiido_epigrafeLocal = find_Tiido_epigrafeLocalHome_findByCodEpigAnho(epigrafe.getCodEpigrafe(),epigrafe.getAnho());
			if (aTiido_epigrafeLocal != null) {
				//aTiido_epigrafeLocal.setAnho(epigrafe.getAnho());
				aTiido_epigrafeLocal.setInd_afecta(epigrafe.getIndAfecta());
				aTiido_epigrafeLocal.setInd_clase(epigrafe.getIndClase());
				aTiido_epigrafeLocal.setInd_hijo(epigrafe.getIndHijo());
				aTiido_epigrafeLocal.setInd_sub_clase(epigrafe.getIndSubClase());
				aTiido_epigrafeLocal.setNom_epigrafe(epigrafe.getNomEpigrafe());				
				aTiido_epigrafeLocal.setOrden(epigrafe.getOrden());
				
				resp = true;
			} else {
				aTiido_epigrafeLocal = createTiido_epigrafeLocal(epigrafe);
				if (aTiido_epigrafeLocal != null) {
					resp = true;
				}
			}
			
			log.info("[SesionEpigrafeBean :: createEpigrafe] Fin");
		} catch (Exception e) {
			log.error("[PerfilAction :: createEpigrafe] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			resp =  false;
		}
		
		return resp;
	}
	
	/**
	 * ELIMINA LOS EPIGRAFES INGRESADOS MEDIANTE CARGA DE ARCHIVO
	 * @return Borra true si es exitoso y false si no es exitoso
	 */
	public boolean borrarEpigrafe() {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		boolean fResult = false; 
		Calendar calendario= Calendar.getInstance();
		int anhoA=calendario.get(Calendar.YEAR);
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			log.info("[SesionEpigrafeBean :: borrarEpigrafe] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				
				log.info("[SesionEpigrafeBean :: borrarEpigrafe] Fin");
				return fResult;
			}
			
			log.info("[SesionEpigrafeBean :: borrarEpigrafe] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				
				log.info("[SesionEpigrafeBean :: borrarEpigrafe] Fin");
				return fResult;
			}

			s = con.createStatement();
			try {
				String sql = "Delete tiido_epigrafe Where anho = '"+anhoA+"'";
					
				log.info("[SesionEpigrafeBean :: borrarEpigrafe] SQL:" + sql);
				rst = s.executeQuery(sql);
				fResult = true;
		
			} catch (SQLException e) {
				fResult = false;
				log.error("[SesionEpigrafeBean :: borrarEpigrafe] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionEpigrafeBean :: borrarEpigrafe] Fin");
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: borrarEpigrafe] ");
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
				log.error("[SesionEpigrafeBean :: borrarEpigrafe] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}			
		
		return fResult;		
	}
	
	protected Tiido_epigrafeLocal find_Tiido_epigrafeLocalHome_findByCodEpigAnho(
			String codEpigrafe, String anho) {
		
		try {
			log.info("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findByCodEpigAnho] Inicio");
			
			Tiido_epigrafeLocalHome aTiido_epigrafeLocalHome = (Tiido_epigrafeLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_epigrafeLocalHome_REF_NAME,
					STATIC_Tiido_epigrafeLocalHome_CLASS);
			
			if (aTiido_epigrafeLocalHome != null) {
				log.info("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findByCodEpigAnho] Fin");
				
				return aTiido_epigrafeLocalHome.findByCodEpigAnho(codEpigrafe,
						anho);
			}
			
			log.info("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findByCodEpigAnho] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findByCodEpigAnho] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return null;
	}
	
	protected Collection find_Tiido_epigrafeLocalHome_findEpiByAnho(String anho) {
		try {
			log.info("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findEpiByAnho] Inicio");
			
			Tiido_epigrafeLocalHome aTiido_epigrafeLocalHome = (Tiido_epigrafeLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_epigrafeLocalHome_REF_NAME,
					STATIC_Tiido_epigrafeLocalHome_CLASS);
			
			if (aTiido_epigrafeLocalHome != null) {
				log.info("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findEpiByAnho] Fin");
				
				return aTiido_epigrafeLocalHome.findEpiByAnho(anho);
			}
			
			log.info("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findEpiByAnho] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findEpiByAnho] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_epigrafeLocal createTiido_epigrafeLocal(Epigrafe epigrafe) {
		try {
			log.info("[SesionEpigrafeBean :: createTiido_epigrafeLocal] Inicio");
			
			Tiido_epigrafeLocalHome aTiido_epigrafeLocalHome = (Tiido_epigrafeLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_epigrafeLocalHome_REF_NAME,
					STATIC_Tiido_epigrafeLocalHome_CLASS);
			
			if (aTiido_epigrafeLocalHome != null) {
				log.info("[SesionEpigrafeBean :: createTiido_epigrafeLocal] Fin");
				
				return aTiido_epigrafeLocalHome.create(epigrafe);
			}
			
			log.info("[SesionEpigrafeBean :: createTiido_epigrafeLocal] Fin");
		} catch (javax.ejb.CreateException e) {
			log.error("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findEpiByAnho] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findEpiByAnho] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}	
	
	protected Tiido_epigrafeLocal find_Tiido_epigrafeLocalHome_findByCodEpig(
			String codEpigrafe) {
		try {
			log.info("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findByCodEpig] Inicio");
			
			Tiido_epigrafeLocalHome aTiido_epigrafeLocalHome = (Tiido_epigrafeLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_epigrafeLocalHome_REF_NAME,
					STATIC_Tiido_epigrafeLocalHome_CLASS);
			
			if (aTiido_epigrafeLocalHome != null) {
				log.info("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findByCodEpig] Fin");
				
				return aTiido_epigrafeLocalHome.findByCodEpig(codEpigrafe);
			}
			
			log.info("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findByCodEpig] Fin");
		} catch (javax.ejb.FinderException e) {
			log.error("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findEpiByAnho] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionEpigrafeBean :: find_Tiido_epigrafeLocalHome_findEpiByAnho] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
}
