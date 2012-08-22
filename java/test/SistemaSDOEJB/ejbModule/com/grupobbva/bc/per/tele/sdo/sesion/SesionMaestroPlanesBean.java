package com.grupobbva.bc.per.tele.sdo.sesion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio;
import com.grupobbva.bc.per.tele.sdo.serializable.MaestroPlan;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_maestro_planesLocal;
import entities.Tiido_maestro_planesLocalHome;
import entities.Tiido_oficinaKey;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionMaestroPlanes
 */
public class SesionMaestroPlanesBean implements javax.ejb.SessionBean {
	private static Logger log = Logger.getLogger(SesionMaestroPlanesBean.class);
	
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiido_maestro_planesLocalHome_REF_NAME = "ejb/Tiido_maestro_planes";

	private final static Class STATIC_Tiido_maestro_planesLocalHome_CLASS = Tiido_maestro_planesLocalHome.class;

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

	public MaestroPlan findUbicar(String mes, String anho, String codOficina,
			String codTerritorio) {
		MaestroPlan maestroPlan = new MaestroPlan();
		
		try {
			log.info("[SesionMaestroPlanesBean :: findUbicar] Inicio");
			
			Tiido_maestro_planesLocal aTiido_maestro_planesLocal = find_Tiido_maestro_planesLocalHome_findUbicar(
					mes, anho, codOficina);
			if (aTiido_maestro_planesLocal != null) {
				maestroPlan.setAnho(aTiido_maestro_planesLocal.getAnho());
				maestroPlan.setCodOficina(((Tiido_oficinaKey)aTiido_maestro_planesLocal
						.getTiido_maepla_oficina_fk().getPrimaryKey()).getCod_ofic());
				maestroPlan.setCodTerritorio(codTerritorio);
				maestroPlan.setFecGrabacion(aTiido_maestro_planesLocal
						.getFec_grab());
				maestroPlan.setMes(aTiido_maestro_planesLocal.getMes());
				maestroPlan.setPrioridad(aTiido_maestro_planesLocal
						.getPrioridad());
			}
			
			log.info("[SesionMaestroPlanesBean :: findUbicar] Fin");
		} catch (Exception e) {
			log.error("[SesionMaestroPlanesBean :: findUbicar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return maestroPlan;
	}

	protected Tiido_maestro_planesLocal find_Tiido_maestro_planesLocalHome_findUbicar(
			String mes, String anho, String codOficina) {
		
		try {
			log.info("[SesionMaestroPlanesBean :: find_Tiido_maestro_planesLocalHome_findUbicar] Inicio");
			
			Tiido_maestro_planesLocalHome aTiido_maestro_planesLocalHome = (Tiido_maestro_planesLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_maestro_planesLocalHome_REF_NAME,
					STATIC_Tiido_maestro_planesLocalHome_CLASS);
			
			if (aTiido_maestro_planesLocalHome != null) {
				log.info("[SesionMaestroPlanesBean :: find_Tiido_maestro_planesLocalHome_findUbicar] Fin");
				
				return aTiido_maestro_planesLocalHome.findUbicar(mes, anho,
						codOficina);
			}
			
			log.info("[SesionMaestroPlanesBean :: find_Tiido_maestro_planesLocalHome_findUbicar] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionMaestroPlanesBean :: find_Tiido_maestro_planesLocalHome_findUbicar] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	public boolean createMaestroPlan(String anho, String mes, String codOfi, String codTerr) {
		try {
			log.info("[SesionMaestroPlanesBean :: createMaestroPlan] Inicio");
			
			Tiido_maestro_planesLocal aTiido_maestro_planesLocal = createTiido_maestro_planesLocal(
					mes, anho, codOfi, codTerr);
			
			log.info("[SesionMaestroPlanesBean :: createMaestroPlan] Fin");
			if (aTiido_maestro_planesLocal != null)
				return true;
			else
				return false;
		}
		catch (Exception e) {
			log.error("[SesionMaestroPlanesBean :: createMaestroPlan] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return false;
		} 
	}
	
//	OSCAR CORTEZ - PGO RESUMEN LDAP
	public Vector reportePGOResumen(String codTerritorio, Hashtable hash) {
		Vector res = null;
		Gestor bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionMaestroPlanesBean :: reportePGOResumen] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}			
			
			log.info("[SesionMaestroPlanesBean :: reportePGOResumen] DATASOURCE_LDAP::: "
					+ ConstantesUtil.DATASOURCE_LDAP);
			DataSource datasource =(DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_LDAP);			

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"SELECT CODOFI as codigo_Oficina, desnivel4 as Nombre_Oficina, desnivel3 as Nombre_Territorio, count(*)"+
					"as total_gestores FROM ldapperu2 WHERE codcargo in('B25','B23') and codnivel3='"+codTerritorio+"'"+
					" group by CODOFI, desnivel4, desnivel3";
					
				log.info("[SesionMaestroPlanesBean :: reportePGOResumen] SQL: " + sql);
						
				rst = s.executeQuery(sql);				
				int nroGest=0;				
				int nroGestPen=0;
				int in=0;
				int pen=0;
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Gestor();
					
					bean.setCodigoOficina(rst.getString(1));
					bean.setNombreOficina(rst.getString(2));
					bean.setNombreTerritorio(rst.getString(3));
					bean.setTotalGestores(rst.getInt(4));
					nroGest=nroGest+rst.getInt(4);
					int x=0;

					if(hash.get(rst.getString(1))==null){
						bean.setIngresos("0");
						int j=0;
						x=j;
						in=in+0;
					}
						
					else{
						bean.setIngresos(hash.get(rst.getString(1)));						
						int j=Integer.parseInt((String) hash.get(rst.getString(1)));
						x=j;
						in=in+Integer.parseInt((String) hash.get(rst.getString(1)));
					}						
					bean.setPendientes(nroGestPen=rst.getInt(4)-x);
					pen=pen+rst.getInt(4)-x;					
					res.add(bean);
					
				}
				
				bean = new Gestor();
				bean.setSumtotalGestores(nroGest);
				bean.setTotalIngresos(in);
				bean.setTotalpendientes(pen);
				
				if (res == null) {
					res = new Vector(0, 1);
				}
				
				res.add(bean);
				
			} catch (SQLException e) {
				log.error("[SesionMaestroPlanesBean :: reportePGOResumen] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionMaestroPlanesBean :: reportePGOResumen] Fin");
		} catch (Exception e) {
			log.error("[SesionMaestroPlanesBean :: reportePGOResumen] ");
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
				log.error("[SesionMaestroPlanesBean :: reportePGOResumen] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}	
	
	public Vector reportePGOResumenxAnioMes(String codTerritorio, String mes, String anio) {		
		Vector res = null;
		Gestor bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		int sumaTotalGestores = 0;
		int sumaIngresos = 0;
		int sumaPendientes = 0;
		
		try {			
			log.info("[SesionMaestroPlanesBean :: reportePGOResumenxAnioMes] Inicio");
			
			initialContext = new InitialContext();
			
			if (initialContext == null) {
				return null;
			}
			
			log.info("[SesionMaestroPlanesBean :: reportePGOResumenxAnioMes] DATASOURCE_CONTEXT::: "
					+ ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource =(DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);			

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					" SELECT o.cod_ofic, o.nom_ofic, " + 
					" (SELECT COUNT(DISTINCT(cod_gestor)) FROM tiido_metas_gestor m WHERE m.cod_terr = o.cod_terr AND m.cod_ofic = o.cod_ofic " +
					" AND m.anho = '" + anio + "' and m.mes = '" + mes + "') total, " +
					" (SELECT COUNT(DISTINCT(a.cod_gest)) FROM tiido_acciones a WHERE a.cod_terr = o.cod_terr AND a.cod_ofic = o.cod_ofic " +
					" AND a.anho = '" + anio + "' and a.mes_acci = '" + mes + "') ingresos " +
					" FROM tiido_oficina o WHERE o.estado = '1' AND o.cod_terr = '" + codTerritorio + "' ORDER BY o.cod_ofic";
					
				log.info("[SesionMaestroPlanesBean :: reportePGOResumenxAnioMes] SQL: " + sql);
				rst = s.executeQuery(sql);							
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Gestor();
					
					bean.setCodigoOficina(rst.getString(1));
					bean.setNombreOficina(rst.getString(2));
					
					bean.setTotalGestores(rst.getInt(3));
					bean.setTotalIngresos(rst.getInt(4));
					bean.setTotalpendientes(rst.getInt(3) - rst.getInt(4));
					
					sumaTotalGestores += bean.getTotalGestores();
					sumaIngresos += bean.getTotalIngresos();
					sumaPendientes += bean.getTotalpendientes();		
		
					res.add(bean);
				}
				
				bean = new Gestor();
				bean.setSumtotalGestores(sumaTotalGestores);
				bean.setSumtotalIngresos(sumaIngresos);
				bean.setSumtotalPendientes(sumaPendientes);
				
				if (res == null) {
					res = new Vector(0, 1);
				}
				
				res.add(bean);
				
			} catch (SQLException e) {
				log.error("[SesionMaestroPlanesBean :: reportePGOResumenxAnioMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}	
			
			log.info("[SesionMaestroPlanesBean :: reportePGOResumenxAnioMes] Fin");
		} catch (Exception e) {
			log.error("[SesionMaestroPlanesBean :: reportePGOResumenxAnioMes] ");
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
				log.error("[SesionMaestroPlanesBean :: reportePGOResumenxAnioMes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				return null;
			}
		}			
		
		return res;	
	}	
	//FIN - OSCAR CORTEZ - PGO RESUMEN LDAP

//	OSCAR CORTEZ - PGO RESUMEN SDO
	public Hashtable reportePGOResumen2(String codTerritorio, String mes, String anho) {
		Hashtable t=null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			log.info("[SesionMaestroPlanesBean :: reportePGOResumen2] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}
			
			log.info("[SesionMaestroPlanesBean :: reportePGOResumen2] DATASOURCE_CONTEXT::: "
					+ ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"select cod_ofic as codigo_oficina, count(COD_GEST) as INGRESOS from tiido_acciones where anho='"+anho+"' and mes_acci='"+mes+"' and cod_terr='"+codTerritorio+"' group by cod_ofic";

				log.info("[SesionMaestroPlanesBean :: reportePGOResumen2] SQL: " + sql);
				rst = s.executeQuery(sql);
				t = new Hashtable();

				while (rst.next()) {		
			
					t.put(rst.getString(1),rst.getString(2));}	
					
								
			} catch (SQLException e) {
				log.error("[SesionMaestroPlanesBean :: reportePGOResumen2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionMaestroPlanesBean :: reportePGOResumen2] Fin");
		} catch (Exception e) {
			log.error("[SesionMaestroPlanesBean :: reportePGOResumen2] ");
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
				log.error("[SesionMaestroPlanesBean :: reportePGOResumen2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return t;	
	}	
	//FIN - OSCAR CORTEZ - PGO RESUMEN SDO
	
	/**
	 * ELIMINA LOS PLANES INGRESADOS MEDIANTE CARGA DE ARCHIVO
	 * @return Borra true si es exitoso y false si no es exitoso
	 */
	public boolean borrarMaestro() {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		boolean fResult = false; 
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			log.info("[SesionMaestroPlanesBean :: borrarMaestro] Inicio");
			
			Calendar calendario= Calendar.getInstance();
			
			int mesA=calendario.get(Calendar.MONTH)+1;
			int anhoA=calendario.get(Calendar.YEAR);
			
			String cMesA = String.valueOf(mesA);
			
			if (mesA < 10) {
				cMesA = "0"+cMesA;
			}
			
			// BORRAR
			//cMesA = "06";
		
			initialContext = new InitialContext();
			if (initialContext == null) {
				return fResult;
			}			
			
			log.info("[SesionMaestroPlanesBean :: reportePGOResumen] DATASOURCE_CONTEXT::: "
					+ ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return fResult;
			}

			s = con.createStatement();
			try {
				String sql = "Delete tiido_maestro_planes Where anho = '"+anhoA+"' and mes = '"+cMesA+"'";
					
				log.info("[SesionMaestroPlanesBean :: borrarMaestro] SQL: " + sql);
				rst = s.executeQuery(sql);			
				fResult = true;
			} catch (SQLException e) {
				fResult = false;
				
				log.error("[SesionMaestroPlanesBean :: borrarMaestro] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionMaestroPlanesBean :: borrarMaestro] Fin");
		} catch (Exception e) {
			log.error("[SesionMaestroPlanesBean :: borrarMaestro] ");
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
				log.error("[SesionMaestroPlanesBean :: borrarMaestro] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}			
		
		return fResult;		
	}
	
	protected Tiido_maestro_planesLocal createTiido_maestro_planesLocal(
			String mes, String anho, String tiido_maepla_oficina_fk_cod_ofic,
			String tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr) {
		try {
			log.info("[SesionMaestroPlanesBean :: createTiido_maestro_planesLocal] Inicio");
			
			Tiido_maestro_planesLocalHome aTiido_maestro_planesLocalHome = (Tiido_maestro_planesLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_maestro_planesLocalHome_REF_NAME,
					STATIC_Tiido_maestro_planesLocalHome_CLASS);
			
			if (aTiido_maestro_planesLocalHome != null) {
				log.info("[SesionMaestroPlanesBean :: createTiido_maestro_planesLocal] Fin");
				
				return aTiido_maestro_planesLocalHome.create(mes, anho,
						tiido_maepla_oficina_fk_cod_ofic,
						tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
			}
			
			log.info("[SesionMaestroPlanesBean :: createTiido_maestro_planesLocal] Fin");
		} catch (javax.ejb.CreateException ce) {
		} catch (Exception e) {
			log.error("[SesionMaestroPlanesBean :: createTiido_maestro_planesLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);

		}
		
		return null;
	}
	
	public boolean existeDataMesAnio(String mes, String anio) {
		boolean resp = false;
		int valor = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			log.info("[SesionMaestroPlanesBean :: existeDataMesAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				return false;
			}
			
			log.info("[SesionMaestroPlanesBean :: reportePGOResumen] DATASOURCE_CONTEXT::: "
					+ ConstantesUtil.DATASOURCE_CONTEXT);
			
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
				String sql = "SELECT COUNT(*) FROM tiido_maestro_planes WHERE TO_NUMBER(anho)="+anio+" and mes='"+mes+"'";				
				
				log.info("[SesionMaestroPlanesBean :: reportePGOResumen] SQL: " + sql);
				
				rst = s.executeQuery(sql);
				if (rst.next()) {					
					valor = rst.getInt(1);
					
					if(valor > 0) {
						resp = true;
					}					
				}									
				
				log.info("[SesionMaestroPlanesBean :: reportePGOResumen] Fin");
			} catch (SQLException e) {
				log.error("[SesionMaestroPlanesBean :: reportePGOResumen] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		} catch (Exception e) {
			log.error("[SesionMaestroPlanesBean :: reportePGOResumen] ");
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
				log.error("[SesionMaestroPlanesBean :: reportePGOResumen] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				return false;
			}
		}
		
		return resp;	
	}	
}
