package com.grupobbva.bc.per.tele.sdo.sesion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tele.sdo.serializable.Campanias;
import com.grupobbva.bc.per.tele.sdo.serializable.CampaniasGeneral;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionCampaniasDetalle
 */
@SuppressWarnings({"unchecked", "unused", "serial"})
public class SesionCampaniasDetalleBean implements javax.ejb.SessionBean {
	private static Logger log = Logger.getLogger(SesionCampaniasDetalleBean.class);
	
	private javax.ejb.SessionContext mySessionCtx;
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
	
//	OSCAR CORTEZ - LISTAR REPORTE - PLANIFICACION
	public Vector listaReportePlanificacion() {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		CampaniasGeneral bean = null;
		
		try {
			log.info("[SesionCampaniasDetalleBean :: listaReportePlanificacion] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				
				log.info("[SesionCampaniasDetalleBean :: listaReportePlanificacion] Fin");
				return null;
			}			
			
			log.info("[SesionCampaniasDetalleBean :: listaReportePlanificacion] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				
				log.info("[SesionCampaniasDetalleBean :: listaReportePlanificacion] Fin");
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"select COD_OFIC, mes, anho, FEC_GRAB from tiido_maestro_planes b order by anho, mes, cod_ofic";
				
				
				log.info("[SesionCampaniasDetalleBean :: listaReportePlanificacion] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new CampaniasGeneral();
					
					bean.setCodigoOficina(rst.getString(1));
					bean.setMes(rst.getString(2));
					bean.setAnho(rst.getString(3));
					bean.setFechaGrabacion(rst.getDate(4));
					
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasDetalleBean :: listaReportePlanificacion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
			
			log.info("[SesionCampaniasDetalleBean :: listaReportePlanificacion] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasDetalleBean :: listaReportePlanificacion] ");
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
				log.error("[SesionCampaniasDetalleBean :: listaReportePlanificacion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}	
		
		return res;	
	}
	//OSCAR CORTEZ - FIN - LISTAR REPORTE / PLANIFICACION

	//OSCAR CORTEZ - LISTAR REPORTE - PPG
	public Vector listaReportePPG(String anho, String mes) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		CampaniasGeneral bean = null;

		try {
			log.info("[SesionCampaniasDetalleBean :: listaReportePPG] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasDetalleBean :: listaReportePPG] Fin");
				
				return null;
			}	
			
			log.info("[SesionCampaniasDetalleBean :: listaReportePPG] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasDetalleBean :: listaReportePPG] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"select a.COD_OFIC, a.COD_GEST, to_char(max(a.FEC_REGI),'DD/MM/YY'), to_char(max(c.FEC_REGI),'DD/MM/YY') from tiido_acciones a, tiido_campanias c where a.cod_ofic=c.cod_ofic and a.anho='"+anho+"' and a.mes_acci='"+mes+"' and c.anho='"+anho+"' and c.mes='"+mes+"' group by a.anho, a.mes_acci, a.cod_ofic, a.cod_gest order by a.anho, a.mes_acci, a.cod_ofic";
											
				log.info("[SesionCampaniasDetalleBean :: listaReportePPG] SQL:" + sql);
				rst = s.executeQuery(sql);
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yy");
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new CampaniasGeneral();
					Date fecha = null;

					bean.setCodigoOficina(rst.getString(1));
					bean.setCodigoGestor(rst.getString(2));
					fecha = formatoDelTexto.parse(rst.getString(3));
					bean.setFEC_REGI(fecha);
					fecha = formatoDelTexto.parse(rst.getString(4));
					bean.setFechaGrabacion(fecha);
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasDetalleBean :: listaReportePPG] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}		
			
			log.info("[SesionCampaniasDetalleBean :: listaReportePPG] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasDetalleBean :: listaReportePPG] ");
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
				log.error("[SesionCampaniasDetalleBean :: listaReportePPG] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	//OSCAR CORTEZ - FIN - LISTAR REPORTE / PPG

	//OSCAR CORTEZ - LISTAR REPORTE - SEGUIMIENTO 1
	public Vector listaReporteSeguimiento1(String anho, String mes) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		CampaniasGeneral bean = null;

		try {
			log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento1] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				
				log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento1] Fin");
				return null;
			}		
			
			log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento1] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento1] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"select a.COD_OFIC, a.COD_GEST, to_char(max(a.fec_segu_1),'DD/MM/YY'), to_char(max(c.fec_segu_1),'DD/MM/YY') from tiido_acciones a, tiido_campanias_detalle c where a.cod_ofic=c.cod_ofic and a.anho='"+anho+"' and a.mes_acci='"+mes+"' and c.anho='"+anho+"' and c.mes='"+mes+"' group by a.anho, a.mes_acci, a.cod_ofic, a.cod_gest order by a.anho, a.mes_acci, a.cod_ofic";
					
				log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento1] SQL:" + sql);
				rst = s.executeQuery(sql);				 
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new CampaniasGeneral();
					
					bean.setCodigoOficina(rst.getString(1));
					bean.setCodigoGestor(rst.getString(2));
					bean.setFEC_segu_1(rst.getDate(3));
					bean.setFEC_segu_2(rst.getDate(4));

						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasDetalleBean :: listaReporteSeguimiento1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento1] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasDetalleBean :: listaReporteSeguimiento1] ");
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
				log.error("[SesionCampaniasDetalleBean :: listaReporteSeguimiento1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	//OSCAR CORTEZ - FIN - LISTAR REPORTE / SEGUIMIENTO 1
	
	//OSCAR CORTEZ - LISTAR REPORTE - SEGUIMIENTO 2
	public Vector listaReporteSeguimiento2(String anho, String mes) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		CampaniasGeneral bean = null;

		try {
			log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento2] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento2] Fin");
				return null;
			}			
			
			log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento2] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento2] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"select a.COD_OFIC, a.COD_GEST, to_char(max(a.fec_segu_2),'DD/MM/YY'), to_char(max(c.fec_segu_2),'DD/MM/YY') from tiido_acciones a, tiido_campanias_detalle c where a.cod_ofic=c.cod_ofic and a.anho='"+anho+"' and a.mes_acci='"+mes+"' and c.anho='"+anho+"' and c.mes='"+mes+"' group by a.anho, a.mes_acci, a.cod_ofic, a.cod_gest order by a.anho, a.mes_acci, a.cod_ofic";
											
				log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento2] SQL:" + sql);	
				
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new CampaniasGeneral();
					
					bean.setCodigoOficina(rst.getString(1));
					bean.setCodigoGestor(rst.getString(2));
					bean.setFEC_segu_1(rst.getDate(3));
					bean.setFEC_segu_2(rst.getDate(4));

						
					res.add(bean);
				}
				
			} catch (SQLException e) {
				log.error("[SesionCampaniasDetalleBean :: listaReporteSeguimiento2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasDetalleBean :: listaReporteSeguimiento2] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasDetalleBean :: listaReporteSeguimiento2] ");
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
				log.error("[SesionCampaniasDetalleBean :: listaReporteSeguimiento2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	//OSCAR CORTEZ - FIN - LISTAR REPORTE / SEGUIMIENTO 2
	
	public boolean nuevoCampaniaDetalle(String codTerritorio, String codOficina, String codCampania, String mes,
			String anho, String nomCampania, String codGest, int nroClie, double compGest, String usuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		boolean resp = false;

		try {
			log.info("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] Inicio");	
			
			initialContext = new InitialContext();
			
			if (initialContext == null) {
				log.info("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] Fin");
				
				return false;
			}			
			log.info("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] Fin");
				
				return false;
			}

			s = con.createStatement();
			String sql = ""; 
			int codCampDeta = 1;
				
			try {
				sql = "SELECT MAX(cod_camp_deta) from iido.tiido_campanias_detalle";							
				log.info("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] SQL:" + sql);
				
				rst = s.executeQuery(sql);				
						
				if (rst.next()) {
					codCampDeta = rst.getInt(1) + 1;	
				}
				
				sql = " INSERT INTO iido.tiido_campanias_detalle " + 
							 " (cod_camp_deta, cod_terr, cod_ofic, cod_camp, mes, " +
							 " anho, nom_camp, cod_gest, nro_clie, comp_gest, fec_segu_1, fec_segu_2, usu_regi) " +
							 " VALUES('" + codCampDeta + "', '" +  codTerritorio + "', " + 
							 " '" + codOficina + "', '" +  codCampania + "', " +
							 " '" + mes + "', '" +  anho + "', " +
							 " '" + nomCampania + "', '" +  codGest + "', " +
							 " " + nroClie + ", " +  compGest + ", sysdate,sysdate, '" + usuario + "')";							 
					
				log.info("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] SQL:" + sql);
				
				resp = s.execute(sql);
			} catch (SQLException e) {
				log.error("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] ");
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
				log.error("[SesionCampaniasDetalleBean :: nuevoCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}			
		
		return resp;	
	}
	
	public boolean edicionCampaniaDetalle(String codCampaniaDetalle, String nomCampania, int nroClie, double compGest, String usuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		boolean resp = false;

		try {
			log.info("[SesionCampaniasDetalleBean :: edicionCampaniaDetalle] Inicio");
			
			initialContext = new InitialContext();
			
			if (initialContext == null) {
				log.info("[SesionCampaniasDetalleBean :: edicionCampaniaDetalle] Fin");
				
				return false;
			}			
			
			log.info("[SesionCampaniasDetalleBean :: edicionCampaniaDetalle] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasDetalleBean :: edicionCampaniaDetalle] Fin");
				
				return false;
			}

			s = con.createStatement();
			String sql = ""; 
				
			try {
				sql = " UPDATE iido.tiido_campanias_detalle SET " + 
					  " nom_camp='"+nomCampania+"' , nro_clie="+nroClie+", comp_gest="+compGest +
					  ", usu_actu='"+usuario+"', fec_actu=sysdate " +  
					  " WHERE cod_camp_deta="+codCampaniaDetalle;							 
					
				log.info("[SesionCampaniasDetalleBean :: edicionCampaniaDetalle] SQL:" + sql);
				
				resp = s.execute(sql);
			} catch (SQLException e) {
				log.error("[SesionCampaniasDetalleBean :: edicionCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasDetalleBean :: edicionCampaniaDetalle] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasDetalleBean :: edicionCampaniaDetalle] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
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
				log.error("[SesionCampaniasDetalleBean :: edicionCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}			
		
		return resp;	
	}
	
	public Vector listaCampaniaDetalle(String codTerritorio, String codOficina, String codCamp, String mes, String anho) {
		Vector res = null;
		CampaniasGeneral bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;		

		try {
			log.info("[SesionCampaniasDetalleBean :: listaCampaniaDetalle] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasDetalleBean :: listaCampaniaDetalle] Fin");
				
				return null;
			}			
			
			log.info("[SesionCampaniasDetalleBean :: listaCampaniaDetalle] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasDetalleBean :: listaCampaniaDetalle] Fin");
				
				return null;
			}

			s = con.createStatement();
			
			try {
				String sql = " SELECT TO_CHAR(cod_camp_deta), cod_ofic, TO_CHAR(cod_camp), mes, anho, nom_camp, " + 
							 " cod_gest, nro_clie, comp_gest, nro_gest_segu_1, nro_conc_segu_1, mont_segu_1, " + 
							 " nro_gest_segu_2, nro_conc_segu_2, mont_segu_2, " +
							 " NVL2(nro_gest_segu_1,nro_gest_segu_1,0) + NVL2(nro_gest_segu_2,nro_gest_segu_2,0), " +
							 " NVL2(nro_conc_segu_1,nro_conc_segu_1,0) + NVL2(nro_conc_segu_2,nro_conc_segu_2,0), " +
							 " NVL2(mont_segu_1,mont_segu_1,0) + NVL2(mont_segu_2,mont_segu_2,0) " +
							 " FROM tiido_campanias_detalle " + 
							 " WHERE cod_terr = '" + codTerritorio + "' AND " +
							 " cod_ofic = '" + codOficina + "' AND " +
							 " cod_camp = '" + codCamp + "' AND " + 	
							 " mes = '" + mes + "' AND " +
							 " anho = '" + anho + "' " +
							 " UNION " +
							 " SELECT '', '', '', '',  '',  'TOTAL CLIENTES / GESTIONES / MONTOS', '', " + 
							 " SUM(nro_clie), SUM(comp_gest), SUM(nro_gest_segu_1), SUM(nro_conc_segu_1), SUM(mont_segu_1), " + 
							 " SUM(nro_gest_segu_2), SUM(nro_conc_segu_2), SUM(mont_segu_2), " +
							 " SUM(NVL2(nro_gest_segu_1,nro_gest_segu_1, 0) + NVL2(nro_gest_segu_2,nro_gest_segu_2,0)), " +
							 " SUM(NVL2(nro_conc_segu_1,nro_conc_segu_1,0) + NVL2(nro_conc_segu_2,nro_conc_segu_2,0)), " +
							 " SUM(NVL2(mont_segu_1,mont_segu_1,0) + NVL2(mont_segu_2,mont_segu_2,0)) " +
							 " FROM tiido_campanias_detalle " + 
							 " WHERE cod_terr = '" + codTerritorio + "' AND " +
							 " cod_ofic = '" + codOficina + "' AND " +
							 " cod_camp = '" + codCamp + "' AND " + 	
							 " mes = '" + mes + "' AND " +
							 " anho = '" + anho + "' " +
							 " ORDER BY 1";
					
				log.info("[SesionCampaniasDetalleBean :: listaCampaniaDetalle] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null) {
						res = new Vector(0, 1);
					}
					
					bean = new CampaniasGeneral();					
					bean.setCodigoCampaniaDetalle(rst.getString(1));
					bean.setCodigoOficina(rst.getString(2));
					bean.setCodigoCampania(rst.getString(3));
					bean.setMes(rst.getString(4));
					bean.setAnho(rst.getString(5));
					bean.setNombreCampania(rst.getString(6));
					bean.setCodigoGestor(rst.getString(7));
					bean.setNroClientes(new BigDecimal(rst.getString(8) != null ? rst.getString(8) : "0"));
					bean.setCompromisoGestor(new BigDecimal(rst.getString(9) != null ? rst.getString(9) : "0"));
					bean.setNroGestorSeguimiento1(new BigDecimal(rst.getString(10) != null ? rst.getString(10) : "0"));
					bean.setNroConcSeguimiento1(new BigDecimal(rst.getString(11) != null ? rst.getString(11) : "0"));
					bean.setMontoSeguimiento1(new BigDecimal(rst.getString(12) != null ? rst.getString(12) : "0"));
					bean.setNroGestorSeguimiento2(new BigDecimal(rst.getString(13) != null ? rst.getString(13) : "0"));
					bean.setNroConcSeguimiento2(new BigDecimal(rst.getString(14) != null ? rst.getString(14) : "0"));
					bean.setMontoSeguimiento2(new BigDecimal(rst.getString(15) != null ? rst.getString(15) : "0"));
					bean.setTotalNroGestor(new BigDecimal(rst.getString(16) != null ? rst.getString(16) : "0"));
					bean.setTotalNroConc(new BigDecimal(rst.getString(17) != null ? rst.getString(17) : "0"));
					bean.setTotalMonto(new BigDecimal(rst.getString(18) != null ? rst.getString(18) : "0"));
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasDetalleBean :: listaCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasDetalleBean :: listaCampaniaDetalle] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasDetalleBean :: listaCampaniaDetalle] ");
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
				log.error("[SesionCampaniasDetalleBean :: listaCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	
	public boolean eliminarCampaniaDetalle(String codCamp){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		Vector res = null;
		boolean resp = false;
		
		try {
			log.info("[SesionCampaniasDetalleBean :: eliminarCampaniaDetalle] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasDetalleBean :: eliminarCampaniaDetalle] Fin");
				
				return false;
			}			
			
			log.info("[SesionCampaniasDetalleBean :: eliminarCampaniaDetalle] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
		
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasDetalleBean :: eliminarCampaniaDetalle] Fin");
				
				return false;
			}

			s = con.createStatement();
			try {
				String sql =
					"DELETE FROM tiido_campanias_detalle WHERE cod_camp_deta = '"+codCamp+"'";
					
				log.info("[SesionCampaniasDetalleBean :: eliminarCampaniaDetalle] SQL:" + sql);
				resp = s.execute(sql);				
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasDetalleBean :: eliminarCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasDetalleBean :: eliminarCampaniaDetalle] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasDetalleBean :: eliminarCampaniaDetalle] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
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
				log.error("[SesionCampaniasDetalleBean :: eliminarCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}			
		
		return resp;
	}
	
	public Campanias busCampaniaDetalle(String codCampaniaDetalle) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Campanias bean = null;

		try {
			log.info("[SesionCampaniasDetalleBean :: busCampaniaDetalle] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasDetalleBean :: busCampaniaDetalle] Fin");
				
				return null;
			}			
			
			log.info("[SesionCampaniasDetalleBean :: busCampaniaDetalle] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
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
					"SELECT nom_camp, nro_clie, comp_gest FROM iido.tiido_campanias_detalle WHERE cod_camp_deta="+codCampaniaDetalle;									
					
				log.info("[SesionCampaniasDetalleBean :: busCampaniaDetalle] SQL:" + sql);
				rst = s.executeQuery(sql);
				
				if (rst.next()) {
					bean = new Campanias();
					
					bean.setNomCamp(rst.getString(1));
					bean.setNumeroCliente(rst.getString(2));
					bean.setCompGestor(rst.getString(3));
				}

			} catch (SQLException e) {
				log.error("[SesionCampaniasDetalleBean :: busCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
			
			log.info("[SesionCampaniasDetalleBean :: busCampaniaDetalle] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasDetalleBean :: busCampaniaDetalle] ");
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
				log.error("[SesionCampaniasDetalleBean :: busCampaniaDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}
		
		return bean;	
	}	
}
