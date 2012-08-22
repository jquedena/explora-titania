package com.grupobbva.bc.per.tele.sdo.sesion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tele.sdo.serializable.Accion;
import com.grupobbva.bc.per.tele.sdo.serializable.Campanias;
import com.grupobbva.bc.per.tele.sdo.serializable.ReportePPG;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionCampanias
 */
@SuppressWarnings({"unchecked", "unused", "serial"})
public class SesionCampaniasBean implements javax.ejb.SessionBean {
	private static Logger log = Logger.getLogger(SesionCampaniasBean.class);
	
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
	
	public Vector nuevaCampania(int codCamp, String nomCamp, String codOficicina, String codTerritorio,
			String codGestor, String anho, String mes, String orden, String get, String usuario, String codEpigrafe){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;		
		Vector res = null;
		Campanias bean = null;

		try {
			log.info("[SesionCampaniasBean :: nuevaCampania] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: nuevaCampania] Fin");
				
				return null;
			}	
			
			log.info("[SesionCampaniasBean :: nuevaCampania] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: nuevaCampania] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					
					"Insert into tiido_campanias (COD_CAMP,NOM_CAMP,COD_OFIC, cod_terr, COD_GEST, anho, mes, orden, gte, usu_regi, COD_EPIGRAFE) VALUES"+
					"('"+codCamp+"','"+nomCamp+"','"+codOficicina+"','"+codTerritorio+"','"+codGestor+"','"+anho+"','"+mes+"','"+orden+"','" + 
					get+"', '" + usuario + "','" + codEpigrafe + "')";								
					
				log.info("[SesionCampaniasBean :: nuevaCampania] SQL:" + sql);
				
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Campanias();			
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: nuevaCampania] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasBean :: nuevaCampania] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: nuevaCampania] ");
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
				log.error("[SesionCampaniasBean :: nuevaCampania] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
	}
	public Vector mostrarEsfuerzoCampania(String codGest, String mes, String anho, String codOficina){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;		
		Vector res = null;
		ReportePPG bean = null;

		try {
			log.info("[SesionCampaniasBean :: mostrarEsfuerzoCampania] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: mostrarEsfuerzoCampania] Fin");
				
				return null;
			}			
			
			log.info("[SesionCampaniasBean :: mostrarEsfuerzoCampania] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: mostrarEsfuerzoCampania] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =					
					" SELECT cod_camp, NOM_CAMP, nvl(cod_epigrafe, '***') cod_epigrafe FROM tiido_campanias where cod_gest='" + codGest + "' and " + 
					" mes='" + mes + "' and anho='" + anho + "' and cod_ofic='" + codOficina + "'";  			
					
				log.info("[SesionCampaniasBean :: mostrarEsfuerzoCampania] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ReportePPG();
					
					bean.setCodCamp(rst.getString(1));
					bean.setEsfuerzo(rst.getString(2));
					bean.setCodEpigrafe(rst.getString(3));
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: mostrarEsfuerzoCampania] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}		
			
			log.info("[SesionCampaniasBean :: mostrarEsfuerzoCampania] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: mostrarEsfuerzoCampania] ");
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
				e.printStackTrace();
				return null;
			}
		}			
		
		return res;
	}
	public int codigoCampMax(){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		int codCamp=0;

		try {
			log.info("[SesionCampaniasBean :: codigoCampMax] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: codigoCampMax] Fin");
				
				return 0;
			}	
			
			log.info("[SesionCampaniasBean :: codigoCampMax] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: codigoCampMax] Fin");
				
				return 0;
			}

			s = con.createStatement();
			
			try {
				String sql =
					
					"select max(cod_camp) from tiido_campanias";			
					
				log.info("[SesionCampaniasBean :: codigoCampMax] SQL:" + sql);
				rst = s.executeQuery(sql);				
						
				while (rst.next()) {
				codCamp= rst.getInt(1);	
				}
				
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: codigoCampMax] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasBean :: codigoCampMax] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: codigoCampMax] ");
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
				log.error("[SesionCampaniasBean :: codigoCampMax] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return 0;
			}
		}			
		
		return codCamp;
	}	
	
	public Vector eliminarCampania(String codCamp){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Campanias bean = null;

		try {
			log.info("[SesionCampaniasBean :: eliminarCampania] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: eliminarCampania] Fin");
				
				return null;
			}			
			
			log.info("[SesionCampaniasBean :: eliminarCampania] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: eliminarCampania] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"Delete From tiido_campanias Where cod_camp='"+codCamp+"'";
					
				log.info("[SesionCampaniasBean :: eliminarCampania] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Campanias();				
						
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: eliminarCampania] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasBean :: eliminarCampania] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: eliminarCampania] ");
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
				log.error("[SesionCampaniasBean :: eliminarCampania] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;
	}
	
	public Vector mostrarEditarCampania(String codCamp){
		Vector res = null;
		Campanias bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionCampaniasBean :: mostrarEditarCampania] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: mostrarEditarCampania] Fin");
				
				return null;
			}			
			
			log.info("[SesionCampaniasBean :: mostrarEditarCampania] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: mostrarEditarCampania] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"select mes, anho, nom_camp, orden, nvl(cod_epigrafe, '***') cod_epigrafe from tiido_campanias where cod_camp='"+codCamp+"'";
					
				log.info("[SesionCampaniasBean :: mostrarEditarCampania] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Campanias();				
						
					bean.setMes(rst.getString(1));
					bean.setAnho(rst.getString(2));
					bean.setNomCamp(rst.getString(3));
					bean.setOrden(rst.getString(4));
					bean.setCodEpigrafe(rst.getString("cod_epigrafe"));
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: mostrarEditarCampania] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasBean :: mostrarEditarCampania] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: mostrarEditarCampania] ");
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
				log.error("[SesionCampaniasBean :: mostrarEditarCampania] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;
	}
	public Vector editarCampania(String anho, String mes, String nomCamp,String orden, 
			String codCamp, String usuario, String codEpigrafe){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Campanias bean = null;
		
		try {
			log.info("[SesionCampaniasBean :: editarCampania] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: editarCampania] Fin");
				
				return null;
			}		
			
			log.info("[SesionCampaniasBean :: editarCampania] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: editarCampania] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"UPDATE tiido_campanias SET anho='"+anho+"', mes='"+mes+"', nom_camp='"+nomCamp + 
					"', orden='"+orden+"', usu_actu = '" + usuario + "', fec_actu = sysdate, cod_epigrafe='" + codEpigrafe + "' " +
					"WHERE cod_camp = '"+codCamp+"'";
					
				log.info("[SesionCampaniasBean :: editarCampania] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Campanias();				
						

					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: editarCampania] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasBean :: editarCampania] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: editarCampania] ");
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
				log.error("[SesionCampaniasBean :: editarCampania] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;
	}
	public int metasOficina(String codOficina, int anio, int mes, String codEpigrafe){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		int totalMetaOficina=0;

		try {
			log.info("[SesionCampaniasBean :: metasOficina] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: metasOficina] Fin");
				
				return 0;
			}			
			
			log.info("[SesionCampaniasBean :: metasOficina] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: metasOficina] Fin");
				
				return 0;
			}

			s = con.createStatement();
			
			try {
				String sql =					
					"select sum(PORC_ASIG) from tiido_metas_gestor where cod_ofic='"+codOficina+"' AND anho = " + anio + " AND mes = " + mes  + " AND cod_epigrafe = '" + codEpigrafe + "'";			
					
				log.info("[SesionCampaniasBean :: metasOficina] SQL:" + sql);
				rst = s.executeQuery(sql);				
						
				while (rst.next()) {
					totalMetaOficina= rst.getInt(1);	
				}
				
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: metasOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasBean :: metasOficina] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: metasOficina] ");
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
				log.error("[SesionCampaniasBean :: metasOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return 0;
			}
		}			
		
		return totalMetaOficina;
	}
	
	public int metasGestor(String codGestor, int anio, int mes, String codEpigrafe){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		int totalMetaGestor=0;

		try {
			log.info("[SesionCampaniasBean :: metasGestor] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: metasGestor] Fin");
				
				return 0;
			}			
			
			log.info("[SesionCampaniasBean :: metasGestor] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: metasGestor] Fin");
				
				return 0;
			}

			s = con.createStatement();
			
			try {
				String sql =
					
					"SELECT sum(PORC_ASIG) FROM tiido_metas_gestor WHERE cod_gestor='"+codGestor+"' AND anho = " + anio + " AND mes = " + mes  + " AND cod_epigrafe = '" + codEpigrafe + "'";			
					
				log.info("[SesionCampaniasBean :: metasGestor] SQL:" + sql);
				rst = s.executeQuery(sql);				
						
				while (rst.next()) {
					totalMetaGestor= rst.getInt(1);	
				}
				
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: metasGestor] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasBean :: metasGestor] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: metasGestor] ");
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
				log.error("[SesionCampaniasBean :: metasGestor] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return 0;
			}
		}			
		
		return totalMetaGestor;
	}
	public Vector busAnhosAcciones(){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		ReportePPG bean = null;
		
		try {
			log.info("[SesionCampaniasBean :: busAnhosAcciones] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: busAnhosAcciones] Fin");
				
				return null;
			}			
			
			log.info("[SesionCampaniasBean :: busAnhosAcciones] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: busAnhosAcciones] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"SELECT distinct ANHO from tiido_acciones order by ANHO DESC";
					
				log.info("[SesionCampaniasBean :: busAnhosAcciones] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ReportePPG();				
						
					bean.setAnho(rst.getString(1));
					
					res.add(bean);
				}
		
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: busAnhosAcciones] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionCampaniasBean :: busAnhosAcciones] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: busAnhosAcciones] ");
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
				log.error("[SesionCampaniasBean :: busAnhosAcciones] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
			
	}
	public Vector busAnhoMaxAcciones(){
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		ReportePPG bean = null;
		
		try {
			log.info("[SesionCampaniasBean :: busAnhoMaxAcciones] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionCampaniasBean :: busAnhoMaxAcciones] Fin");
				
				return null;
			}			
			
			log.info("[SesionCampaniasBean :: busAnhoMaxAcciones] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionCampaniasBean :: busAnhoMaxAcciones] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =
					"SELECT MAX(ANHO) FROM TIIDO_ACCIONES";
					
				log.info("[SesionCampaniasBean :: busAnhoMaxAcciones] SQL:" + sql);
				rst = s.executeQuery(sql);				
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new ReportePPG();				
						
					bean.setAnho(rst.getString(1));
					
					res.add(bean);
				}
				
			} catch (SQLException e) {
				log.error("[SesionCampaniasBean :: busAnhoMaxAcciones] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}			
			
			log.info("[SesionCampaniasBean :: busAnhoMaxAcciones] Fin");
		} catch (Exception e) {
			log.error("[SesionCampaniasBean :: busAnhoMaxAcciones] ");
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
				log.error("[SesionCampaniasBean :: busAnhoMaxAcciones] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}			
		
		return res;	
		
	}
}
