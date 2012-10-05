package com.grupobbva.bc.per.tele.sdo.sesion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.serializable.Accion;
import com.grupobbva.bc.per.tele.sdo.serializable.Campanias;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

/**
 * Bean implementation class for Enterprise Bean: SesionAcciones
 */
public class SesionAccionesBean implements javax.ejb.SessionBean {

	private static final long serialVersionUID = -2019690425496504289L;
	private static Logger log = Logger.getLogger(SesionAccionesBean.class);
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

	@SuppressWarnings("unchecked")
	public Vector busAllAnho() {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;

		try {
			log.info("[SesionAccionesBean :: busAllAnho] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: busAllAnho] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: busAllAnho] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: busAllAnho] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =

				"select distinct(anho) from tiido_acciones order by anho desc";

				log.info("[SesionAccionesBean :: busAllAnho] SQL:" + sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Accion();

					bean.setAnho(rst.getString(1));

					res.add(bean);
				}

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: busAllAnho] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: busAllAnho] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: busAllAnho] ");
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
				log.error("[SesionAccionesBean :: busAllAnho] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public Vector busAccionesPGG3(String codAnho, String codMes,
			String codGestor, String codEpigrafe) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;

		try {
			log.info("[SesionAccionesBean :: busAccionesPGG3] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: busAccionesPGG3] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: busAccionesPGG3] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: busAccionesPGG3] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =

				"select * from tiido_acciones where anho='" + codAnho
						+ "' and mes_acci = '" + codMes + "' and cod_Gest = '"
						+ codGestor + "' and cod_Epigrafe = '" + codEpigrafe
						+ "' order by cod_Acci";

				log.info("[SesionAccionesBean :: busAccionesPGG3] SQL:" + sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Accion();

					bean.setCodAccion(rst.getString(1));
					bean.setNomAccion(rst.getString(6));
					bean.setNumeroCliente(rst.getString(9));
					bean.setCompGestor(rst.getString(10));
					bean.setNumeroGestiones1(rst.getInt(11));
					bean.setNumeroConcretados1(rst.getInt(12));
					bean.setMonto1(rst.getInt(13));
					bean.setNumeroGestiones2(rst.getInt(14));
					bean.setNumeroConcretados2(rst.getInt(15));
					bean.setMonto2(rst.getInt(16));
					bean.setTotalNumeroGestiones(rst.getInt(11)
							+ rst.getInt(14));
					bean.setTotalNumeroConcretados(rst.getInt(12)
							+ rst.getInt(15));
					bean.setTotalMonto(rst.getInt(13) + rst.getInt(16));

					res.add(bean);
				}

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: busAccionesPGG3] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: busAccionesPGG3] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: busAccionesPGG3] ");
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
				log.error("[SesionAccionesBean :: busAccionesPGG3] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public Vector nuevaAccion(String cod_acci, String cod_epigrafe,
			String anho, String cod_terr, String cod_ofic, String nom_acci,
			String cod_gest, String mes_acci, String nro_clie,
			String comp_gest, String nro_gest_segu_1, String nro_conc_segu_1,
			String mon_segu_1, String nro_gest_segu_2, String nro_conc_segu_2,
			String mon_segu_2, String usuario) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;

		try {
			log.info("[SesionAccionesBean :: nuevaAccion] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: nuevaAccion] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: nuevaAccion] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: nuevaAccion] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql =

				"Insert into tiido_acciones (cod_acci, cod_epigrafe, anho, cod_terr, cod_ofic, nom_acci,"
						+ " cod_gest, mes_acci, nro_clie, comp_gest, nro_gest_segu_1, nro_conc_segu_1, mon_segu_1, nro_gest_segu_2,"
						+ " nro_conc_segu_2, mon_segu_2, fec_segu_1, fec_segu_2, usu_regi) VALUES"
						+ "('"
						+ cod_acci
						+ "','"
						+ cod_epigrafe
						+ "','"
						+ anho
						+ "','"
						+ cod_terr
						+ "','"
						+ cod_ofic
						+ "','"
						+ nom_acci
						+ "','"
						+ cod_gest
						+ "','"
						+ mes_acci
						+ "','"
						+ nro_clie
						+ "','"
						+ comp_gest
						+ "',"
						+ "'"
						+ nro_gest_segu_1
						+ "','"
						+ nro_conc_segu_1
						+ "','"
						+ mon_segu_1
						+ "','"
						+ nro_gest_segu_2
						+ "','"
						+ nro_conc_segu_2
						+ "','"
						+ mon_segu_2
						+ "',sysdate,sysdate,'" + usuario + "')";

				log.info("[SesionAccionesBean :: nuevaAccion] SQL:" + sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Accion();

					res.add(bean);
				}

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: nuevaAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: nuevaAccion] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: nuevaAccion] ");
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
				log.error("[SesionAccionesBean :: nuevaAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return res;
	}

	public Accion busAccion(String codAccion) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Accion bean = null;

		try {
			log.info("[SesionAccionesBean :: busAccion] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: busAccion] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: busAccion] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: busAccion] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql = "SELECT nom_acci, nro_clie, comp_gest FROM tiido_acciones WHERE cod_acci="
						+ codAccion;

				log.info("[SesionAccionesBean :: busAccion] SQL:" + sql);
				rst = s.executeQuery(sql);

				if (rst.next()) {
					bean = new Accion();

					bean.setNomAccion(rst.getString(1));
					bean.setNumeroCliente(rst.getString(2));
					bean.setCompGestor(rst.getString(3));
				}

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: busAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: busAccion] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: busAccion] ");
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
				log.error("[SesionAccionesBean :: busAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return bean;
	}

	public boolean edicionAccion(String codAccion, String descAccion,
			String numeroCliente, String compromisoGestor, String usuario) {
		boolean resp = false;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionAccionesBean :: edicionAccion] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: edicionAccion] Fin");
				
				return false;
			}
			
			log.info("[SesionAccionesBean :: edicionAccion] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: edicionAccion] Fin");
				
				return false;
			}

			s = con.createStatement();
			try {
				String sql = "UPDATE tiido_acciones SET nom_acci='"
						+ descAccion + "', nro_clie=" + numeroCliente
						+ ", comp_gest=" + compromisoGestor 
						+ ", usu_actu='" + usuario
						+ "', fec_actu=sysdate" 
						+ " WHERE cod_acci=" + codAccion;

				log.info("[SesionAccionesBean :: edicionAccion] SQL:" + sql);
				s.execute(sql);

				resp = true;
			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: edicionAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: edicionAccion] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: edicionAccion] ");
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
				log.error("[SesionAccionesBean :: edicionAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}

		return resp;
	}

	public int codigoAccion() {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		int codAccion = 0;

		try {
			log.info("[SesionAccionesBean :: codigoAccion] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: codigoAccion] Fin");
				
				return 0;
			}
			
			log.info("[SesionAccionesBean :: codigoAccion] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: codigoAccion] Fin");
				
				return 0;
			}

			s = con.createStatement();

			try {
				String sql =

				"select max(cod_acci) from tiido_acciones";

				log.info("[SesionAccionesBean :: codigoAccion] SQL:" + sql);
				rst = s.executeQuery(sql); 

				while (rst.next()) {
					codAccion = rst.getInt(1);
				}

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: codigoAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: codigoAccion] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: codigoAccion] ");
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
				log.error("[SesionAccionesBean :: codigoAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return 0;
			}
		}

		return codAccion;
	}

	@SuppressWarnings("unchecked")
	public Vector eliminarAccion(String codAccion) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Campanias bean = null;

		try {
			log.info("[SesionAccionesBean :: eliminarAccion] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: eliminarAccion] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: eliminarAccion] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: eliminarAccion] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql = "Delete From tiido_acciones Where cod_acci='"
						+ codAccion + "'";

				log.info("[SesionAccionesBean :: eliminarAccion] SQL:" + sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Campanias();

					res.add(bean);
				}

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: eliminarAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: eliminarAccion] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: eliminarAccion] ");
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
				log.error("[SesionAccionesBean :: eliminarAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public Vector codOficinaMax(String codTerritorio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Campanias bean = null;

		try {
			log.info("[SesionAccionesBean :: codOficinaMax] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: codOficinaMax] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: codOficinaMax] DATASOURCE_LDAP:::" + ConstantesUtil.DATASOURCE_LDAP);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_LDAP);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: codOficinaMax] Fin");
				
				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select MIN(CODNIVEL4) from ldapperu2 where CODNIVEL3='"
						+ codTerritorio + "'";

				log.info("[SesionAccionesBean :: codOficinaMax] SQL:" + sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Campanias();

					bean.setCodOficicina(rst.getString(1));

					res.add(bean);
				}

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: codOficinaMax] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: codOficinaMax] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: codOficinaMax] ");
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
				log.error("[SesionAccionesBean :: codOficinaMax] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public Vector pggSeguimiento1(String mes, String anho, String codOficina,
			String codGestor) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;
		Accion subBean = null;
		int compGestor = 0;
		int numeroCliente = 0;
		int monto = 0;
		int numeroConcretados = 0;
		int numeroGestiones = 0;
		Vector newRes = null;
		String cond = null;

		try {
			log.info("[SesionAccionesBean :: pggSeguimiento1] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: pggSeguimiento1] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: pggSeguimiento1] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: pggSeguimiento1] Fin");
				
				return null;
			}

			boolean mostrar = false;

			s = con.createStatement();
			try {
				/*
				 * String sql = "SELECT distinct(b.nom_epigrafe), a.orden,
				 * c.comp_gest, c.nom_acci, c.nro_clie, d.porc_asig, c.fec_regi,
				 * d.cod_gestor, c.nro_conc_segu_1, c.mon_segu_1 " + ",
				 * c.COD_ACCI, c.COD_EPIGRAFE " + " from tiido_campanias a,
				 * tiido_epigrafe b, tiido_acciones c, tiido_metas_gestor d
				 * where c.anho='"+anho+"' and" + " c.mes_acci='"+mes+"' and
				 * c.cod_ofic='"+codOficina+"' AND to_char(C.fec_regi,'dd')
				 * <'16' and d.cod_gestor='"+codGestor+"'" + " and c.cod_gest=
				 * a.cod_gest and c.cod_epigrafe= b.cod_epigrafe and C.cod_gest=
				 * d.cod_gestor";
				 */
				/*
				 * String sql = "SELECT distinct(TRIM(b.nom_epigrafe)), b.orden,
				 * c.comp_gest, c.nom_acci, c.nro_clie, d.porc_asig, c.fec_regi,
				 * d.cod_gestor, c.nro_conc_segu_1, c.mon_segu_1,
				 * c.COD_EPIGRAFE, c.COD_ACCI, c.nro_gest_segu_1 " + "from
				 * tiido_epigrafe b, tiido_acciones c, tiido_metas_gestor d " +
				 * "where c.anho='"+anho+"' and c.mes_acci='"+mes+"' and
				 * c.cod_ofic='"+codOficina+"' AND to_char(C.fec_regi,'dd')
				 * <'16' and d.cod_gestor='"+codGestor+"' " + "and
				 * c.cod_epigrafe= b.cod_epigrafe and C.cod_gest= d.cod_gestor
				 * and d.cod_epigrafe = b.cod_epigrafe order by c.COD_EPIGRAFE,
				 * c.COD_ACCI ";
				 */
				java.util.Calendar c = java.util.Calendar.getInstance();
				@SuppressWarnings("unused")
				Date d = c.getTime();

				if (Integer.parseInt(mes) == 3) {
					cond = " (to_char(c.fec_regi,'mm') = '03' AND to_char(c.fec_regi,'mm') BETWEEN 1 AND 31) AND ";
					mostrar = true;
				}

				if (Integer.parseInt(mes) == 4) {
					cond = " (to_char(c.fec_regi,'mm') = '04' AND to_char(c.fec_regi,'mm') BETWEEN 1 AND 30) AND ";
					mostrar = true;
				}

				if (Integer.parseInt(mes) == 5) {
					cond = " (to_char(c.fec_regi,'mm') = '05' AND to_char(c.fec_regi,'dd') BETWEEN 1 AND 30) AND ";
					mostrar = true;
				}

				String sql = "SELECT (SELECT b.nom_epigrafe FROM tiido_epigrafe b "
						+ "         WHERE b.cod_epigrafe = c.cod_epigrafe and b.anho = c.anho) nom_epigrafe, "
						+
						//" (SELECT b.orden FROM tiido_epigrafe b " +
						//" WHERE b.cod_epigrafe = c.cod_epigrafe and b.anho =
						// c.anho) orden, " +
						"        	(SELECT p.prioridad FROM tiido_planes p "
						+ "                WHERE p.cod_ofic = '"
						+ codOficina
						+ "' AND p.mes_plan = '"
						+ mes
						+ "' AND p.anho_plan = '"
						+ anho
						+ "' AND p.cod_epigrafe = c.cod_epigrafe AND rownum <= 1) orden, "
						+ "                c.comp_gest, c.nom_acci, c.nro_clie, "
						+ "               (SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "               WHERE d.cod_meta_gestor = c.cod_gest and "
						+ "                      d.cod_terr = c.cod_terr and "
						+ "                     d.cod_ofic = c.cod_ofic and "
						+ "                      d.cod_epigrafe = c.cod_epigrafe and "
						+ "                     d.anho = c.anho "
						+ "                     ) porc_asig, "
						+ "               c.fec_regi, c.cod_gest, c.nro_conc_segu_1, c.mon_segu_1, c.COD_EPIGRAFE, c.COD_ACCI, c.nro_gest_segu_1, "
						+ "					   (SELECT (ROUND(a.Fact_ajus_terri) - ROUND(a.Fact_asig_gte_of)) "
						+ "						FROM TIIDO_PLANES a WHERE a.COD_OFIC = '"
						+ codOficina
						+ "' and a.ANHO_PLAN = '"
						+ anho
						+ "' and "
						+ "						a.MES_PLAN = '"
						+ mes
						+ "' and a.cod_epigrafe = c.cod_epigrafe) fact"
						+ "        from iido.tiido_acciones c "
						+ "        where c.anho='"
						+ anho
						+ "' and "
						+ "              c.mes_acci='"
						+ mes
						+ "' and "
						+ "              c.cod_ofic='"
						+ codOficina
						+ "' AND "
						+ cond
						+
						//" to_char(c.fec_regi,'dd')<'23' and " +
						// POR MIENTRAS
						//" to_char(c.fec_regi,'dd')<= 31 and " +
						//" to_char(c.fec_regi,'mm')=" + (d.getMonth() + 1) + "
						// and " +
						"     to_char(c.fec_regi,'mm')="
						+ (Integer.parseInt(mes))
						+ " and "
						+ "         	  c.cod_gest = '"
						+ codGestor
						+ "' "
						+ "       order by c.COD_EPIGRAFE, c.COD_ACCI ";

				if (mostrar) {
					log.info("[SesionAccionesBean :: pggSeguimiento1] SQL:" + sql);
					
					rst = s.executeQuery(sql);
					@SuppressWarnings("unused")
					String codEpigrafe = "";
					HashMap mapCont = new HashMap();

					while (rst.next()) {
						if (res == null)
							res = new Vector(0, 1);
						bean = new Accion();

						//
						bean.setCodEpigrafe(rst.getString("COD_EPIGRAFE"));
						bean.setCodAccion(rst.getString("COD_ACCI"));
						bean.setNomEpigrafe(rst.getString(1));
						bean.setOrden(rst.getString(2));
						bean.setCompGestor(rst.getString(3));
						bean.setNomAccion(rst.getString(4));
						bean.setNumeroCliente(rst.getString(5) != null ? rst.getString(5) : "0");
						//bean.setPorc_asig(rst.getString(6) != null ? rst.getString(6) : "");
						bean.setFec_regi(rst.getString(7));
						bean.setCodGestor(rst.getString(8));
						bean.setNumeroConcretados1(rst.getInt(9));
						bean.setMonto1(rst.getInt(10));
						bean.setNumeroGestiones1(rst.getInt(13));
						bean.setPorc_asig(rst.getString("fact") != null ? rst.getString("fact") : "");

						compGestor = compGestor + Integer.parseInt(rst.getString(3) != null ? rst.getString(3) : "0");
						numeroCliente = numeroCliente + Integer.parseInt(rst.getString(5) != null ? rst.getString(5) : "0");
						numeroConcretados = numeroConcretados + rst.getInt(9);
						monto = monto + rst.getInt(10);
						numeroGestiones = numeroGestiones + rst.getInt(13);

						res.add(bean);

						if (mapCont.get(bean.getCodEpigrafe()) == null) {
							mapCont.put(bean.getCodEpigrafe(), new Integer(1));
						} else {
							mapCont.put(bean.getCodEpigrafe(), new Integer(((Integer) mapCont.get(bean.getCodEpigrafe())).intValue() + 1));
						}
					}

					if (res != null) {
						newRes = new Vector();
						Iterator lista = res.iterator();
						while (lista.hasNext()) {
							Accion accionBean = (Accion) lista.next();
							@SuppressWarnings("unused")
							String codEpi = accionBean.getCodEpigrafe();
							int num = ((Integer) mapCont.get(accionBean
									.getCodEpigrafe())).intValue();
							subBean = new Accion();
							newRes.add(accionBean);

							//
							subBean.setOrden("");
							subBean.setNomEpigrafe("");
							subBean.setPorc_asig("");
							subBean.setNomAccion("Subtotal");

							subBean
									.setNumeroCliente(String
											.valueOf(Integer
													.parseInt(subBean
															.getNumeroCliente() != null ? subBean
															.getNumeroCliente()
															: "0")
													+ Integer
															.parseInt(accionBean
																	.getNumeroCliente())));

							subBean.setCompGestor(String
									.valueOf(Integer.parseInt(subBean
											.getCompGestor() != null ? subBean
											.getCompGestor() : "0")
											+ Integer.parseInt(accionBean
													.getCompGestor())));

							subBean.setNumeroGestiones1(subBean
									.getNumeroGestiones1()
									+ accionBean.getNumeroGestiones1());

							subBean.setNumeroConcretados1(subBean
									.getNumeroConcretados1()
									+ accionBean.getNumeroConcretados1());

							subBean.setMonto1(subBean.getMonto1()
									+ accionBean.getMonto1());

							if (num > 1) {
								for (int i = 1; i < num; i++) {
									accionBean = (Accion) lista.next();

									accionBean.setOrden("");
									accionBean.setNomEpigrafe("");
									accionBean.setPorc_asig("");
									subBean.setNomAccion("Subtotal");

									subBean
											.setNumeroCliente(String
													.valueOf(Integer
															.parseInt(subBean
																	.getNumeroCliente() != null ? subBean
																	.getNumeroCliente()
																	: "0")
															+ Integer
																	.parseInt(accionBean
																			.getNumeroCliente())));

									subBean.setCompGestor(String.valueOf(Integer.parseInt(subBean.getCompGestor() != null ? subBean.getCompGestor() : "0") + Integer.parseInt(accionBean.getCompGestor())));
									subBean.setNumeroGestiones1(subBean.getNumeroGestiones1() + accionBean.getNumeroGestiones1());
									subBean.setNumeroConcretados1(subBean.getNumeroConcretados1() + accionBean.getNumeroConcretados1());
									subBean.setMonto1(subBean.getMonto1() + accionBean.getMonto1());

									newRes.add(accionBean);
								}
							}

							newRes.add(subBean);
						}
					}
				}
				bean = new Accion();
				if (res == null) {
					newRes = new Vector(0, 1);
				}

				bean.setTotalCompGestor(compGestor);
				bean.setTotalClientes(numeroCliente);
				bean.setTotalNumeroConcretados(numeroConcretados);
				bean.setTotalMonto(monto);
				bean.setTotalNumeroGestiones(numeroGestiones);
				newRes.add(bean);

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: pggSeguimiento1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: pggSeguimiento1] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: pggSeguimiento1] ");
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
				log.error("[SesionAccionesBean :: pggSeguimiento1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return newRes;

	}

	@SuppressWarnings("unchecked")
	public Vector pggSeguimiento1(String mes, String anho, String codOficina,
			String codGestor, ProgSeguimiento progSeguimiento) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;
		Accion subBean = null;
		int compGestor = 0;
		int numeroCliente = 0;
		int monto = 0;
		int numeroConcretados = 0;
		int numeroGestiones = 0;
		Vector newRes = null;
		String cond = null;
		@SuppressWarnings("unused")
		String codTerritorio = "";

		try {
			log.info("[SesionAccionesBean :: pggSeguimiento1] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: pggSeguimiento1] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: pggSeguimiento1] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: pggSeguimiento1] Fin");
				
				return null;
			}

			s = con.createStatement();

			try {
				if (progSeguimiento == null) {
					throw new Exception(
							"No se ha configurado tabla multitabla con la programaci" + (char) 243 + "n de seguimiento.");
				}

				//cond = " c.fec_regi BETWEEN TO_DATE('" +
				// progSeguimiento.getSeg1Ini() + "', 'DD/MM/YYYY') AND
				// TO_DATE('" + progSeguimiento.getSeg1Fin() + "', 'DD/MM/YYYY')
				// ";
				/*cond = " TO_CHAR(c.fec_regi, 'YYYYMMDD') BETWEEN '"
						+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
								.getSeg1Ini())
						+ "' AND '"
						+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
								.getSeg1Fin()) + "' ";
				*/
				cond = " TO_CHAR(sysdate, 'YYYYMMDD') BETWEEN '"
				+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
						.getSeg1Ini())
				+ "' AND '"
				+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
						.getSeg1Fin()) + "' ";		

				String sql = 
					
						"SELECT case when "+ cond +" then 1 else 0 end as estado, "						
						+ " (SELECT b.nom_epigrafe FROM tiido_epigrafe b "
						+ "         WHERE b.cod_epigrafe = c.cod_epigrafe and b.anho = c.anho) nom_epigrafe, "
						+ "        	(SELECT p.prioridad FROM tiido_planes p "
						+ "                WHERE p.cod_ofic = '"
						+ codOficina
						+ "' AND p.mes_plan = '"
						+ mes
						+ "' "
						+ " 				AND p.anho_plan = '"
						+ anho
						+ "' AND p.cod_epigrafe = c.cod_epigrafe AND rownum <= 1) orden, "
						+ "  c.comp_gest, c.nom_acci, c.nro_clie, "
						+ "         (SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "               WHERE d.cod_meta_gestor = c.cod_gest and "
						+ "                     d.cod_terr = c.cod_terr and "
						+ "                     d.cod_ofic = c.cod_ofic and "
						+ "                     d.cod_epigrafe = c.cod_epigrafe and "
						+ "                     d.anho = c.anho "
						+ "                     ) porc_asig, "
						+ "c.fec_regi, c.cod_gest, c.nro_conc_segu_1, c.mon_segu_1, c.COD_EPIGRAFE, c.COD_ACCI, c.nro_gest_segu_1, "
						+ " (SELECT (ROUND(a.Fact_ajus_terri) - ROUND(a.Fact_asig_gte_of)) "
						+ " FROM TIIDO_PLANES a "
						+ " WHERE a.COD_OFIC = '"
						+ codOficina
						+ "' and a.ANHO_PLAN = '"
						+ anho
						+ "' "
						+ "  AND a.MES_PLAN = '"
						+ mes
						+ "' and a.cod_epigrafe = c.cod_epigrafe) fact "
						+ "FROM iido.tiido_acciones c "
						+ "WHERE c.anho='"
						+ anho
						+ "' AND c.mes_acci='"
						+ mes
						+ "' AND c.cod_ofic='"
						+ codOficina
						+ "'"
						+ " AND c.cod_gest = '"
						+ codGestor
						+ "' "
						+ "ORDER BY c.COD_EPIGRAFE, c.COD_ACCI";

				log.info("[SesionAccionesBean :: pggSeguimiento1] SQL:" + sql);
				rst = s.executeQuery(sql);
				@SuppressWarnings("unused")
				String codEpigrafe = "";
				HashMap mapCont = new HashMap();

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Accion();
					bean.setCodEpigrafe(rst.getString("COD_EPIGRAFE"));
					bean.setCodAccion(rst.getString("COD_ACCI"));
					bean.setEstado(rst.getInt(1));
					bean.setNomEpigrafe(rst.getString(2));
					bean.setOrden(rst.getString(3));
					bean.setCompGestor(rst.getString(4));
					bean.setNomAccion(rst.getString(5));
					bean.setNumeroCliente(rst.getString(6)!= null ? rst.getString(6) : "0");
					//bean.setPorc_asig(rst.getString(6) != null ?
					// rst.getString(6) : "");
					bean.setFec_regi(rst.getString(8));
					bean.setCodGestor(rst.getString(9));
					bean.setNumeroConcretados1(rst.getInt(10));
					bean.setMonto1(rst.getInt(11));
					bean.setNumeroGestiones1(rst.getInt(14));
					bean.setPorc_asig(rst.getString("fact") != null ? rst.getString("fact") : "");
					compGestor = compGestor+ Integer.parseInt(rst.getString(4) != null ? rst.getString(4) : "0");
					numeroCliente = numeroCliente+ Integer.parseInt(rst.getString(6) != null ? rst.getString(6) : "0");
					numeroConcretados = numeroConcretados + rst.getInt(10);
					monto = monto + rst.getInt(11);
					numeroGestiones = numeroGestiones + rst.getInt(14);
					res.add(bean);

					if (mapCont.get(bean.getCodEpigrafe()) == null) {
						mapCont.put(bean.getCodEpigrafe(), new Integer(1));
					} else {
						mapCont.put(bean.getCodEpigrafe(), new Integer(
								((Integer) mapCont.get(bean.getCodEpigrafe()))
										.intValue() + 1));
					}
				}

				if (res != null) {
					newRes = new Vector();
					Iterator lista = res.iterator();
					while (lista.hasNext()) {
						Accion accionBean = (Accion) lista.next();
						@SuppressWarnings("unused")
						String codEpi = accionBean.getCodEpigrafe();
						int num = ((Integer) mapCont.get(accionBean.getCodEpigrafe())).intValue();
						subBean = new Accion();
						newRes.add(accionBean);

						//
						subBean.setOrden("");
						subBean.setNomEpigrafe("");
						subBean.setPorc_asig("");
						subBean.setNomAccion("Subtotal");

						subBean.setNumeroCliente(String
								.valueOf(Integer.parseInt(subBean
										.getNumeroCliente() != null ? subBean
										.getNumeroCliente() : "0")
										+ Integer.parseInt(accionBean
												.getNumeroCliente())));

						subBean.setCompGestor(String.valueOf(Integer.parseInt(subBean
										.getCompGestor() != null ? subBean
										.getCompGestor() : "0")
										+ Integer.parseInt(accionBean
												.getCompGestor())));

						subBean.setNumeroGestiones1(subBean
								.getNumeroGestiones1()
								+ accionBean.getNumeroGestiones1());

						subBean.setNumeroConcretados1(subBean
								.getNumeroConcretados1()
								+ accionBean.getNumeroConcretados1());

						subBean.setMonto1(subBean.getMonto1()
								+ accionBean.getMonto1());

						if (num > 1) {
							for (int i = 1; i < num; i++) {
								accionBean = (Accion) lista.next();

								accionBean.setOrden("");
								accionBean.setNomEpigrafe("");
								accionBean.setPorc_asig("");
								subBean.setNomAccion("Subtotal");

								subBean
										.setNumeroCliente(String
												.valueOf(Integer
														.parseInt(subBean
																.getNumeroCliente() != null ? subBean
																.getNumeroCliente()
																: "0")
														+ Integer
																.parseInt(accionBean
																		.getNumeroCliente())));

								subBean
										.setCompGestor(String
												.valueOf(Integer
														.parseInt(subBean
																.getCompGestor() != null ? subBean
																.getCompGestor()
																: "0")
														+ Integer
																.parseInt(accionBean
																		.getCompGestor())));

								subBean.setNumeroGestiones1(subBean
										.getNumeroGestiones1()
										+ accionBean.getNumeroGestiones1());

								subBean.setNumeroConcretados1(subBean
										.getNumeroConcretados1()
										+ accionBean.getNumeroConcretados1());

								subBean.setMonto1(subBean.getMonto1()
										+ accionBean.getMonto1());

								newRes.add(accionBean);
							}
						}

						newRes.add(subBean);
					}
				}
				bean = new Accion();
				if (res == null) {
					newRes = new Vector(0, 1);
				}

				bean.setTotalCompGestor(compGestor);
				bean.setTotalClientes(numeroCliente);
				bean.setTotalNumeroConcretados(numeroConcretados);
				bean.setTotalMonto(monto);
				bean.setTotalNumeroGestiones(numeroGestiones);
				newRes.add(bean);

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: pggSeguimiento1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: pggSeguimiento1] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: pggSeguimiento1] ");
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
				log.error("[SesionAccionesBean :: pggSeguimiento1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return newRes;

	}

	@SuppressWarnings("unchecked")
	public Vector pggEsfuerzoAdicional1(String mes, String anho,
			String codOficina, String codGestor) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;

		int compGestor = 0;
		int numeroCliente = 0;
		int monto = 0;
		int numeroConcretados = 0;
		int numeroGestiones = 0;
		Vector newRes = null;
		Accion subBean = null;
		String cond = null;

		try {
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] Fin");
				
				return null;
			}

			s = con.createStatement();
			boolean mostrar = false;

			try {
				java.util.Calendar c = java.util.Calendar.getInstance();
				@SuppressWarnings("unused")
				Date d = c.getTime();

				if (Integer.parseInt(mes) == 3) {
					cond = " (to_char(b.fec_regi,'mm') = '03' AND to_char(b.fec_regi,'mm') BETWEEN 1 AND 31) AND ";
					mostrar = true;
				}

				if (Integer.parseInt(mes) == 4) {
					cond = " (to_char(b.fec_regi,'mm') = '04' AND to_char(b.fec_regi,'mm') BETWEEN 1 AND 30) AND ";
					mostrar = true;
				}

				if (Integer.parseInt(mes) == 5) {
					cond = " (to_char(b.fec_regi,'mm') = '05' AND to_char(b.fec_regi,'dd') BETWEEN 1 AND 30) AND ";
					mostrar = true;
				}

				String sql = " SELECT a.nom_camp, a.orden, b.comp_gest, b.nom_camp, b.nro_clie, "
						+ "(SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "      WHERE d.cod_meta_gestor = a.cod_gest and "
						+ "            d.cod_terr = a.cod_terr and "
						+ "            d.cod_ofic =a.cod_ofic and "
						+ "            d.anho = a.anho and "
						+ "            rownum <= 1 "
						+ "            ) porc_asig, "
						+ " b.fec_regi, a.cod_gest, b.nro_conc_segu_1, b.mont_segu_1, b.nro_gest_segu_1, b.COD_CAMP_DETA "
						+ " from tiido_campanias a, tiido_campanias_detalle b "
						+ " where b.anho='"
						+ anho
						+ "' and "
						+ "     b.mes='"
						+ mes
						+ "' and "
						+ "     b.cod_ofic='"
						+ codOficina
						+ "' AND "
						+ cond
						+
						// POR MIENTRAS
						//" (to_char(b.fec_regi,'dd')<'23' and " +
						//" to_char(b.fec_regi,'dd')<= 31) and " +
						//" to_char(b.fec_regi,'mm')=" + (d.getMonth() + 1) + "
						// and " +
						"     to_char(b.fec_regi,'mm')="
						+ (Integer.parseInt(mes))
						+ " and "
						+ "     b.cod_gest='"
						+ codGestor
						+ "' and "
						+ "     b.cod_gest= a.cod_gest "
						+ "     and a.cod_camp = b.cod_camp "
						+ " ORDER BY COD_CAMP_DETA";

				/*
				 * String sql = " SELECT a.nom_camp, a.orden, b.comp_gest,
				 * b.nom_camp, b.nro_clie, " + "(SELECT d.porc_asig FROM
				 * tiido_metas_gestor d " + " WHERE d.cod_meta_gestor =
				 * a.cod_gest and " + " d.cod_terr = a.cod_terr and " + "
				 * d.cod_ofic =a.cod_ofic and " + " d.anho = a.anho and " + "
				 * rownum <= 1 " + " ) porc_asig, " + " b.fec_regi, a.cod_gest,
				 * b.nro_conc_segu_1, b.mont_segu_1, b.nro_gest_segu_1,
				 * b.COD_CAMP_DETA " + " from tiido_campanias a LEFT JOIN
				 * tiido_campanias_detalle b ON a.cod_camp = b.cod_camp " + "
				 * where a.anho='"+anho+"' and " + " a.mes='"+mes+"' and " + "
				 * a.cod_ofic='"+codOficina+"' AND " + "
				 * to_char(a.fec_regi,'dd') <'23' and " + "
				 * to_char(a.fec_regi,'mm')=" + (d.getMonth() + 1) + " and " + "
				 * a.cod_gest='"+codGestor+"' and " + " a.cod_gest= a.cod_gest " + "
				 * ORDER BY COD_CAMP_DETA";
				 */

				if (mostrar) {
					log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] SQL:" + sql);
					
					rst = s.executeQuery(sql);
					HashMap mapCont = new HashMap();

					while (rst.next()) {
						if (res == null)
							res = new Vector(0, 1);
						bean = new Accion();

						bean
								.setCodAccion(rst.getString("COD_CAMP_DETA") != null ? rst
										.getString("COD_CAMP_DETA")
										: "");
						bean.setCodEpigrafe(rst.getString("nom_camp"));
						bean.setNomCampania(rst.getString(1) != null ? rst
								.getString(1) : "");
						bean.setOrden(rst.getString(2));
						bean.setCompGestor(rst.getString(3) != null ? rst
								.getString(3) : "0");
						bean.setNomAccion(rst.getString(4) != null ? rst
								.getString(4) : "");
						bean.setNumeroCliente(rst.getString(5) != null ? rst
								.getString(5) : "0");
						bean.setPorc_asig(rst.getString(6) != null ? rst
								.getString(6) : "");
						bean.setFec_regi(rst.getString(7));
						bean.setCodGestor(rst.getString(8));
						bean.setNumeroConcretados1(rst.getInt(9));
						bean.setMonto1(rst.getInt(10));
						bean.setNumeroGestiones1(rst.getInt(11));

						compGestor = compGestor
								+ Integer
										.parseInt(rst.getString(3) != null ? rst
												.getString(3)
												: "0");
						numeroCliente = numeroCliente
								+ Integer
										.parseInt(rst.getString(5) != null ? rst
												.getString(5)
												: "0");
						numeroConcretados = numeroConcretados + rst.getInt(9);
						monto = monto + rst.getInt(10);
						numeroGestiones = numeroGestiones + rst.getInt(11);

						res.add(bean);

						if (mapCont.get(bean.getCodEpigrafe()) == null) {
							mapCont.put(bean.getCodEpigrafe(), new Integer(1));
						} else {
							mapCont
									.put(bean.getCodEpigrafe(), new Integer(
											((Integer) mapCont.get(bean
													.getCodEpigrafe()))
													.intValue() + 1));
						}
					}

					if (res == null) {
						res = new Vector(0, 1);
					}

					if (res != null) {
						newRes = new Vector();
						Iterator lista = res.iterator();
						while (lista.hasNext()) {
							Accion accionBean = (Accion) lista.next();
							@SuppressWarnings("unused")
							String codEpi = accionBean.getCodEpigrafe();
							int num = ((Integer) mapCont.get(accionBean
									.getCodEpigrafe())).intValue();
							subBean = new Accion();
							newRes.add(accionBean);

							//
							subBean.setOrden("");
							subBean.setNomCampania("");
							subBean.setPorc_asig("");
							subBean.setNomAccion("Subtotal");

							subBean
									.setNumeroCliente(String
											.valueOf(Integer
													.parseInt(subBean
															.getNumeroCliente() != null ? subBean
															.getNumeroCliente()
															: "0")
													+ Integer
															.parseInt(accionBean
																	.getNumeroCliente())));

							subBean.setCompGestor(String
									.valueOf(Integer.parseInt(subBean
											.getCompGestor() != null ? subBean
											.getCompGestor() : "0")
											+ Integer.parseInt(accionBean
													.getCompGestor())));

							if (num > 1) {
								for (int i = 1; i < num; i++) {
									accionBean = (Accion) lista.next();

									accionBean.setOrden("");
									accionBean.setNomCampania("");
									accionBean.setPorc_asig("");
									subBean.setNomAccion("Subtotal");

									subBean
											.setNumeroCliente(String
													.valueOf(Integer
															.parseInt(subBean
																	.getNumeroCliente() != null ? subBean
																	.getNumeroCliente()
																	: "0")
															+ Integer
																	.parseInt(accionBean
																			.getNumeroCliente())));

									subBean
											.setCompGestor(String
													.valueOf(Integer
															.parseInt(subBean
																	.getCompGestor() != null ? subBean
																	.getCompGestor()
																	: "0")
															+ Integer
																	.parseInt(accionBean
																			.getCompGestor())));

									newRes.add(accionBean);
								}
							}

							newRes.add(subBean);
						}
					}
				}
				bean = new Accion();
				if (res == null) {
					newRes = new Vector(0, 1);
				}

				bean.setTotalCompGestor(compGestor);
				bean.setTotalClientes(numeroCliente);
				bean.setTotalNumeroConcretados(numeroConcretados);
				bean.setTotalMonto(monto);
				bean.setTotalNumeroGestiones(numeroGestiones);
				newRes.add(bean);

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: pggEsfuerzoAdicional1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: pggEsfuerzoAdicional1] ");
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
				log.error("[SesionAccionesBean :: pggEsfuerzoAdicional1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return newRes;

	}

	@SuppressWarnings("unchecked")
	public Vector pggEsfuerzoAdicional1(String mes, String anho,
			String codOficina, String codGestor, ProgSeguimiento progSeguimiento) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;

		int compGestor = 0;
		int numeroCliente = 0;
		int monto = 0;
		int numeroConcretados = 0;
		int numeroGestiones = 0;
		Vector newRes = null;
		Accion subBean = null;
		String cond = null;

		try {
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] Fin");
				return null;
			}
			
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			s = con.createStatement();
			cond = " TO_CHAR(sysdate, 'YYYYMMDD') BETWEEN '"
			+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento.getSeg1Ini())
			+ "' AND '"
			+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento.getSeg1Fin()) + "' ";
													
			try {
				String sql = " SELECT a.nom_camp, a.orden, b.comp_gest, b.nom_camp, b.nro_clie, "
						+ "(SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "      WHERE d.cod_meta_gestor = a.cod_gest and "
						+ "            d.cod_terr = a.cod_terr and "
						+ "            d.cod_ofic =a.cod_ofic and "
						+ "            d.anho = a.anho and "
						+ "            rownum <= 1 "
						+ "            ) porc_asig, "
						+ " b.fec_regi, a.cod_gest, b.nro_conc_segu_1, b.mont_segu_1, b.nro_gest_segu_1, b.COD_CAMP_DETA, " 
						+ " case when "+ cond +" then 1 else 0 end as estado, a.cod_epigrafe "
						+ " FROM tiido_campanias a, tiido_campanias_detalle b "
						+ " WHERE b.anho='"
						+ anho
						+ "' AND b.mes='"
						+ mes
						+ "' AND b.cod_ofic='"
						+ codOficina
						+ "' AND "
						+ " b.cod_gest='"
						+ codGestor
						+ "' AND "
						+ "     b.cod_gest= a.cod_gest "
						+ "     and a.cod_camp = b.cod_camp "
						+ " ORDER BY COD_CAMP_DETA";
 
				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] SQL:" + sql);
				rst = s.executeQuery(sql);
				HashMap mapCont = new HashMap();

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					
					bean = new Accion();
					bean.setCodAccion(rst.getString("COD_CAMP_DETA") != null ? rst.getString("COD_CAMP_DETA") : "");
					bean.setCodEpigrafe(rst.getString("cod_epigrafe")); // nom_camp
					bean.setEstado(rst.getInt("estado"));
					bean.setNomCampania(rst.getString(1) != null ? rst.getString(1) : "");
					bean.setOrden(rst.getString(2));
					bean.setCompGestor(rst.getString(3) != null ? rst.getString(3) : "0");
					bean.setNomAccion(rst.getString(4) != null ? rst.getString(4) : "");
					bean.setNumeroCliente(rst.getString(5) != null ? rst.getString(5) : "0");
					bean.setPorc_asig(rst.getString(6) != null ? rst.getString(6) : "");
					bean.setFec_regi(rst.getString(7));
					bean.setCodGestor(rst.getString(8));
					bean.setNumeroConcretados1(rst.getInt(9));
					bean.setMonto1(rst.getInt(10));
					bean.setNumeroGestiones1(rst.getInt(11));
					compGestor = compGestor + Integer.parseInt(rst.getString(3) != null ? rst.getString(3) : "0");
					numeroCliente = numeroCliente + Integer.parseInt(rst.getString(5) != null ? rst.getString(5) : "0");
					numeroConcretados = numeroConcretados + rst.getInt(9);
					monto = monto + rst.getInt(10);
					numeroGestiones = numeroGestiones + rst.getInt(11);

					res.add(bean);

					/*
					if (mapCont.get(bean.getCodEpigrafe()) == null) {
						mapCont.put(bean.getCodEpigrafe(), new Integer(1));
					} else {
						mapCont.put(bean.getCodEpigrafe(), new Integer(((Integer) mapCont.get(bean.getCodEpigrafe())).intValue() + 1));
					}
					*/
					if (mapCont.get(bean.getNomCampania()) == null) {
						mapCont.put(bean.getNomCampania(), new Integer(1));
					} else {
						mapCont.put(bean.getNomCampania(), new Integer(((Integer) mapCont.get(bean.getNomCampania())).intValue() + 1));
					}
				}

				if (res == null) {
					res = new Vector(0, 1);
				}

				if (res != null) {
					newRes = new Vector();
					Iterator lista = res.iterator();
					while (lista.hasNext()) {
						Accion accionBean = (Accion) lista.next();
					
						int num = ((Integer) mapCont.get(accionBean.getNomCampania())).intValue();
						
						subBean = new Accion();
						newRes.add(accionBean);

						subBean.setOrden("");
						subBean.setNomCampania("");
						subBean.setPorc_asig("");
						subBean.setNomAccion("Subtotal");

						subBean.setNumeroCliente(String
								.valueOf(Integer.parseInt(subBean
										.getNumeroCliente() != null ? subBean
										.getNumeroCliente() : "0")
										+ Integer.parseInt(accionBean
												.getNumeroCliente())));

						subBean.setCompGestor(String
								.valueOf(Integer.parseInt(subBean
										.getCompGestor() != null ? subBean
										.getCompGestor() : "0")
										+ Integer.parseInt(accionBean
												.getCompGestor())));

						if (num > 1) {
							for (int i = 1; i < num; i++) {
								accionBean = (Accion) lista.next();

								accionBean.setOrden("");
								accionBean.setNomCampania("");
								accionBean.setPorc_asig("");
								subBean.setNomAccion("Subtotal");

								subBean
										.setNumeroCliente(String
												.valueOf(Integer
														.parseInt(subBean
																.getNumeroCliente() != null ? subBean
																.getNumeroCliente()
																: "0")
														+ Integer
																.parseInt(accionBean
																		.getNumeroCliente())));

								subBean
										.setCompGestor(String
												.valueOf(Integer
														.parseInt(subBean
																.getCompGestor() != null ? subBean
																.getCompGestor()
																: "0")
														+ Integer
																.parseInt(accionBean
																		.getCompGestor())));

								newRes.add(accionBean);
							} 
						} 

						newRes.add(subBean);
					}
				}
				bean = new Accion();
				if (res == null) {
					newRes = new Vector(0, 1);
				}

				bean.setTotalCompGestor(compGestor);
				bean.setTotalClientes(numeroCliente);
				bean.setTotalNumeroConcretados(numeroConcretados);
				bean.setTotalMonto(monto);
				bean.setTotalNumeroGestiones(numeroGestiones);
				newRes.add(bean);

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: pggEsfuerzoAdicional1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional1] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: pggEsfuerzoAdicional1] ");
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
				log.error("[SesionAccionesBean :: pggEsfuerzoAdicional1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return newRes;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Vector pggSeguimiento2(String mes, String anho, String codOficina,
			String codGestor) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;
		int compGestor = 0;
		int numeroCliente = 0;
		int monto = 0;
		int numeroConcretados = 0;
		int numeroGestiones = 0;
		Accion subBean = null;
		Vector newRes = null;

		try {
			log.info("[SesionAccionesBean :: pggSeguimiento2] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: pggSeguimiento2] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: pggSeguimiento2] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: pggSeguimiento2] Fin");
				
				return null;
			}

			s = con.createStatement();
			java.util.Calendar c = java.util.Calendar.getInstance();
			Date d = c.getTime();
			@SuppressWarnings("unused")
			int diaActual = c.get(Calendar.DATE);
			@SuppressWarnings("unused")
			int mesActual = d.getMonth() + 1;
			@SuppressWarnings("unused")
			int anioActual = 1900 + d.getYear();
			String cond = "";
			String condSeg1 = "";
			boolean mostrar = false;

			if (Integer.parseInt(mes) == 3) {
				cond = " (to_char(c.fec_regi,'mm') = '04' AND to_char(c.fec_regi,'mm') BETWEEN 1 AND 30) AND ";
				condSeg1 = " (to_char(c.fec_regi,'mm') = '03' AND to_char(c.fec_regi,'mm') BETWEEN 1 AND 31) AND ";
				mostrar = true;
			}

			if (Integer.parseInt(mes) == 4) {
				cond = " (to_char(c.fec_regi,'mm') = '04' AND to_char(c.fec_regi,'DD') BETWEEN 1 AND 30) AND ";
				condSeg1 = " (to_char(c.fec_regi,'mm') = '05' AND to_char(c.fec_regi,'DD') BETWEEN 1 AND 30) AND ";
				mostrar = true;
			}

			// nueva modiiii
			if (Integer.parseInt(mes) == 5) {
				mostrar = false;
			}

			try {
				/*
				 * if(diaActual > 22) { condicionDia = " "; } else {
				 * condicionDia = " to_char(c.fec_regi,'dd')>'22' and "; }
				 */

				String sql = "SELECT (SELECT b.nom_epigrafe FROM tiido_epigrafe b "
						+ "			 WHERE b.cod_epigrafe = c.cod_epigrafe and b.anho = c.anho) nom_epigrafe, "
						+
						//" (SELECT b.orden FROM tiido_epigrafe b " +
						//" WHERE b.cod_epigrafe = c.cod_epigrafe and b.anho =
						// c.anho) orden, " +
						"        	(SELECT p.prioridad FROM tiido_planes p "
						+ "                WHERE p.cod_ofic = '"
						+ codOficina
						+ "' AND p.mes_plan = '"
						+ mes
						+ "' AND p.anho_plan = '"
						+ anho
						+ "' AND p.cod_epigrafe = c.cod_epigrafe AND rownum <= 1) orden, "
						+ " 				       c.comp_gest, c.nom_acci, c.nro_clie, "
						+ "				       (SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "				       WHERE d.cod_meta_gestor = c.cod_gest and "
						+ "			 	             d.cod_terr = c.cod_terr and "
						+ "				             d.cod_ofic = c.cod_ofic and "
						+ "			 	             d.cod_epigrafe = c.cod_epigrafe and "
						+ "				             d.anho = c.anho "
						+ "				             ) porc_asig, "
						+ "				       c.fec_regi, c.cod_gest, c.nro_conc_segu_2, c.mon_segu_2, c.COD_EPIGRAFE, c.COD_ACCI, c.nro_gest_segu_2, "
						+ "					   (SELECT (ROUND(a.Fact_ajus_terri) - ROUND(a.Fact_asig_gte_of)) "
						+ "						FROM TIIDO_PLANES a WHERE a.COD_OFIC = '"
						+ codOficina
						+ "' and a.ANHO_PLAN = '"
						+ anho
						+ "' and "
						+ "						a.MES_PLAN = '"
						+ mes
						+ "' and a.cod_epigrafe = c.cod_epigrafe) fact"
						+ "   			from iido.tiido_acciones c "
						+ "				where c.anho='"
						+ anho
						+ "' and "
						+ "				      c.mes_acci='"
						+ mes
						+ "' and "
						+ "				      c.cod_ofic='"
						+ codOficina
						+ "' AND "
						+ cond +
						//" to_char(c.fec_regi,'mm')=" + Integer.parseInt(mes)
						// + " and " +
						"         c.cod_gest = '" + codGestor + "' " +
						//" order by c.COD_EPIGRAFE, c.COD_ACCI ";
						"     UNION ";

				/*
				 * if(mesActual == 12) { mesActual = 1; anioActual++; } else {
				 * mesActual++; }
				 */

				sql += "SELECT (SELECT b.nom_epigrafe FROM tiido_epigrafe b "
						+ "         WHERE b.cod_epigrafe = c.cod_epigrafe and b.anho = c.anho) nom_epigrafe, "
						+
						//" (SELECT b.orden FROM tiido_epigrafe b " +
						//" WHERE b.cod_epigrafe = c.cod_epigrafe and b.anho =
						// c.anho) orden, " +
						"        	(SELECT p.prioridad FROM tiido_planes p "
						+ "                WHERE p.cod_ofic = '"
						+ codOficina
						+ "' AND p.mes_plan = '"
						+ mes
						+ "' AND p.anho_plan = '"
						+ anho
						+ "' AND p.cod_epigrafe = c.cod_epigrafe AND rownum <= 1) orden, "
						+ "                c.comp_gest, c.nom_acci, c.nro_clie, "
						+ "               (SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "               WHERE d.cod_meta_gestor = c.cod_gest and "
						+ "                      d.cod_terr = c.cod_terr and "
						+ "                     d.cod_ofic = c.cod_ofic and "
						+ "                      d.cod_epigrafe = c.cod_epigrafe and "
						+ "                     d.anho = c.anho "
						+ "                     ) porc_asig, "
						+ "               c.fec_regi, c.cod_gest, c.nro_conc_segu_2, c.mon_segu_2, c.COD_EPIGRAFE, c.COD_ACCI, c.nro_gest_segu_2, "
						+ "					   (SELECT (ROUND(a.Fact_ajus_terri) - ROUND(a.Fact_asig_gte_of)) "
						+ "						FROM TIIDO_PLANES a WHERE a.COD_OFIC = '"
						+ codOficina + "' and a.ANHO_PLAN = '" + anho
						+ "' and " + "						a.MES_PLAN = '" + mes
						+ "' and a.cod_epigrafe = c.cod_epigrafe) fact"
						+ "        from iido.tiido_acciones c "
						+ "        where c.anho='" + anho + "' and "
						+ "              c.mes_acci='" + mes + "' and "
						+ "              c.cod_ofic='" + codOficina + "' AND "
						+ condSeg1 +
						//" to_char(c.fec_regi,'mm')=" +
						// (Integer.parseInt(mes)) + " and " +
						"         	  c.cod_gest = '" + codGestor + "' "
						+ "       order by 11, 12 ";

				if (mostrar) {

					log.info("[SesionAccionesBean :: pggSeguimiento2] SQL:" + sql);
					rst = s.executeQuery(sql);
					@SuppressWarnings("unused")
					String codEpigrafe = "";
					HashMap mapCont = new HashMap();

					while (rst.next()) {
						if (res == null)
							res = new Vector(0, 1);
						bean = new Accion();

						bean.setCodEpigrafe(rst.getString("COD_EPIGRAFE"));
						bean.setCodAccion(rst.getString("COD_ACCI"));
						bean.setNomEpigrafe(rst.getString(1));
						bean.setOrden(rst.getString(2));
						bean.setCompGestor(rst.getString(3) != null ? rst.getString(3) : "0");
						bean.setNomAccion(rst.getString(4));
						bean.setNumeroCliente(rst.getString(5));
						//bean.setPorc_asig(rst.getString(6) != null ? rst.getString(6) : "" );
						bean.setFec_regi(rst.getString(7));
						bean.setCodGestor(rst.getString(8));
						bean.setNumeroConcretados2(rst.getInt(9));
						bean.setMonto2(rst.getInt(10));
						bean.setNumeroGestiones2(rst.getInt(13));
						bean.setPorc_asig(rst.getString("fact") != null ? rst.getString("fact") : "");

						compGestor = compGestor + Integer.parseInt(rst.getString(3) != null ? rst.getString(3) : "0");
						numeroCliente = numeroCliente + Integer.parseInt(rst.getString(5) != null ? rst.getString(5) : "0");
						numeroConcretados = numeroConcretados + rst.getInt(9);
						monto = monto + rst.getInt(10);
						numeroGestiones = numeroGestiones + rst.getInt(13);

						res.add(bean);

						if (mapCont.get(bean.getCodEpigrafe()) == null) {
							mapCont.put(bean.getCodEpigrafe(), new Integer(1));
						} else {
							mapCont
									.put(bean.getCodEpigrafe(), new Integer(
											((Integer) mapCont.get(bean
													.getCodEpigrafe()))
													.intValue() + 1));
						}
					}

					if (res != null) {
						newRes = new Vector();
						Iterator lista = res.iterator();
						while (lista.hasNext()) {
							Accion accionBean = (Accion) lista.next();
							@SuppressWarnings("unused")
							String codEpi = accionBean.getCodEpigrafe();
							int num = ((Integer) mapCont.get(accionBean
									.getCodEpigrafe())).intValue();
							subBean = new Accion();
							newRes.add(accionBean);

							//
							subBean.setOrden("");
							subBean.setNomEpigrafe("");
							subBean.setPorc_asig("");
							subBean.setNomAccion("Subtotal");

							subBean
									.setNumeroCliente(String.valueOf(Integer.parseInt(subBean.getNumeroCliente() != null ? subBean.getNumeroCliente() : "0")
													+ Integer.parseInt(accionBean.getNumeroCliente() != null ? accionBean.getNumeroCliente() : "0")));

							subBean
									.setCompGestor(String
											.valueOf(Integer
													.parseInt(subBean
															.getCompGestor() != null ? subBean
															.getCompGestor()
															: "0")
													+ Integer
															.parseInt(accionBean
																	.getCompGestor() != null ? accionBean
																	.getCompGestor()
																	: "0")));

							subBean.setNumeroGestiones2(subBean
									.getNumeroGestiones2()
									+ accionBean.getNumeroGestiones2());

							subBean.setNumeroConcretados2(subBean
									.getNumeroConcretados2()
									+ accionBean.getNumeroConcretados2());

							subBean.setMonto2(subBean.getMonto2()
									+ accionBean.getMonto2());

							if (num > 1) {
								for (int i = 1; i < num; i++) {
									accionBean = (Accion) lista.next();

									accionBean.setOrden("");
									accionBean.setNomEpigrafe("");
									accionBean.setPorc_asig("");
									subBean.setNomAccion("Subtotal");

									subBean
											.setNumeroCliente(String
													.valueOf(Integer
															.parseInt(subBean
																	.getNumeroCliente() != null ? subBean
																	.getNumeroCliente()
																	: "0")
															+ Integer
																	.parseInt(accionBean
																			.getNumeroCliente() != null ? accionBean
																			.getNumeroCliente()
																			: "0")));

									subBean
											.setCompGestor(String
													.valueOf(Integer
															.parseInt(subBean
																	.getCompGestor() != null ? subBean
																	.getCompGestor()
																	: "0")
															+ Integer
																	.parseInt(accionBean
																			.getCompGestor() != null ? accionBean
																			.getCompGestor()
																			: "0")));

									subBean.setNumeroGestiones2(subBean
											.getNumeroGestiones2()
											+ accionBean.getNumeroGestiones2());

									subBean.setNumeroConcretados2(subBean
											.getNumeroConcretados2()
											+ accionBean
													.getNumeroConcretados2());

									subBean.setMonto2(subBean.getMonto2()
											+ accionBean.getMonto2());

									newRes.add(accionBean);
								}
							}

							newRes.add(subBean);
						}
					}
				}

				bean = new Accion();
				if (res == null) {
					newRes = new Vector(0, 1);
				}

				bean.setTotalCompGestor(compGestor);
				bean.setTotalClientes(numeroCliente);
				bean.setTotalNumeroConcretados(numeroConcretados);
				bean.setTotalMonto(monto);
				bean.setTotalNumeroGestiones(numeroGestiones);
				newRes.add(bean);

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: pggSeguimiento2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: pggSeguimiento2] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: pggSeguimiento2] ");
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
				log.error("[SesionAccionesBean :: pggSeguimiento2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return newRes;

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Vector pggSeguimiento2(String mes, String anho, String codOficina,
			String codGestor, ProgSeguimiento progSeguimiento) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;
		int compGestor = 0;
		int numeroCliente = 0;
		int monto = 0;
		int numeroConcretados = 0;
		int numeroGestiones = 0;
		Accion subBean = null;
		Vector newRes = null;

		try {
			log.info("[SesionAccionesBean :: pggSeguimiento2] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: pggSeguimiento2] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: pggSeguimiento2] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: pggSeguimiento2] Fin");
				
				return null;
			}

			s = con.createStatement();
			java.util.Calendar c = java.util.Calendar.getInstance();
			Date d = c.getTime();
			@SuppressWarnings("unused")
			int diaActual = c.get(Calendar.DATE);
			@SuppressWarnings("unused")
			int mesActual = d.getMonth() + 1;
			@SuppressWarnings("unused")
			int anioActual = 1900 + d.getYear();
			String cond = "";

			try {
				cond = "( TO_CHAR(sysdate, 'YYYYMMDD') BETWEEN '"
						+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
								.getSeg2Ini())
						+ "' AND '"
						+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
								.getSeg2Fin()) + "')";
				
				String sql = "SELECT (SELECT b.nom_epigrafe FROM tiido_epigrafe b "
						+ "			 WHERE b.cod_epigrafe = c.cod_epigrafe and b.anho = c.anho) nom_epigrafe, "
						+ "        	(SELECT p.prioridad FROM tiido_planes p "
						+ "                WHERE p.cod_ofic = '"
						+ codOficina
						+ "' AND p.mes_plan = '"
						+ mes
						+ "' AND p.anho_plan = '"
						+ anho
						+ "' AND p.cod_epigrafe = c.cod_epigrafe AND rownum <= 1) orden, "
						+ " 				       c.comp_gest, c.nom_acci, c.nro_clie, "
						+ "				       (SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "				       WHERE d.cod_meta_gestor = c.cod_gest and "
						+ "			 	             d.cod_terr = c.cod_terr and "
						+ "				             d.cod_ofic = c.cod_ofic and "
						+ "			 	             d.cod_epigrafe = c.cod_epigrafe and "
						+ "				             d.anho = c.anho "
						+ "				             ) porc_asig, "
						+ "				       c.fec_regi, c.cod_gest, c.nro_conc_segu_2, c.mon_segu_2, c.COD_EPIGRAFE, c.COD_ACCI, c.nro_gest_segu_2, "
						+ "					   (SELECT (ROUND(a.Fact_ajus_terri) - ROUND(a.Fact_asig_gte_of)) "
						+ "						FROM TIIDO_PLANES a WHERE a.COD_OFIC = '"
						+ codOficina
						+ "' and a.ANHO_PLAN = '"
						+ anho
						+ "' AND a.MES_PLAN = '"
						+ mes
						+ "' AND a.cod_epigrafe = c.cod_epigrafe) fact, "
						+ "case when "+ cond +" then 1 else 0 end as estado, c.cod_epigrafe " 
						+ "FROM iido.tiido_acciones c "
						+ "WHERE c.anho='"
						+ anho
						+ "' AND c.mes_acci='"
						+ mes
						+ "' AND c.cod_ofic='"
						+ codOficina
						+ "' AND "
						+ " c.cod_gest = '"
						+ codGestor
						+ "' "
						+ "ORDER BY 11, 12 ";

				log.info("[SesionAccionesBean :: pggSeguimiento2] SQL:" + sql);
				rst = s.executeQuery(sql);
				@SuppressWarnings("unused")
				String codEpigrafe = "";
				HashMap mapCont = new HashMap();

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Accion();

					bean.setCodEpigrafe(rst.getString("COD_EPIGRAFE"));
					bean.setCodAccion(rst.getString("COD_ACCI"));
					bean.setEstado(rst.getInt("estado"));
					bean.setNomEpigrafe(rst.getString(1));
					bean.setOrden(rst.getString(2));
					bean.setCompGestor(rst.getString(3) != null ? rst.getString(3) : "0");
					bean.setNomAccion(rst.getString(4));
					bean.setNumeroCliente(rst.getString(5));
					//bean.setPorc_asig(rst.getString(6) != null ?
					// rst.getString(6) : "" );
					bean.setFec_regi(rst.getString(7));
					bean.setCodGestor(rst.getString(8));
					bean.setNumeroConcretados2(rst.getInt(9));
					bean.setMonto2(rst.getInt(10));
					bean.setNumeroGestiones2(rst.getInt(13));
					bean.setPorc_asig(rst.getString("fact") != null ? rst.getString("fact") : "");

					compGestor = compGestor
							+ Integer.parseInt(rst.getString(3) != null ? rst
									.getString(3) : "0");
					numeroCliente = numeroCliente
							+ Integer.parseInt(rst.getString(5) != null ? rst
									.getString(5) : "0");
					numeroConcretados = numeroConcretados + rst.getInt(9);
					monto = monto + rst.getInt(10);
					numeroGestiones = numeroGestiones + rst.getInt(13);

					res.add(bean);

					if (mapCont.get(bean.getCodEpigrafe()) == null) {
						mapCont.put(bean.getCodEpigrafe(), new Integer(1));
					} else {
						mapCont.put(bean.getCodEpigrafe(), new Integer(
								((Integer) mapCont.get(bean.getCodEpigrafe()))
										.intValue() + 1));
					}
				}

				if (res != null) {
					newRes = new Vector();
					Iterator lista = res.iterator();
					while (lista.hasNext()) {
						Accion accionBean = (Accion) lista.next();
						@SuppressWarnings("unused")
						String codEpi = accionBean.getCodEpigrafe();
						int num = ((Integer) mapCont.get(accionBean
								.getCodEpigrafe())).intValue();
						subBean = new Accion();
						newRes.add(accionBean);

						//
						subBean.setOrden("");
						subBean.setNomEpigrafe("");
						subBean.setPorc_asig("");
						subBean.setNomAccion("Subtotal");

						subBean
								.setNumeroCliente(String
										.valueOf(Integer
												.parseInt(subBean
														.getNumeroCliente() != null ? subBean
														.getNumeroCliente()
														: "0")
												+ Integer
														.parseInt(accionBean
																.getNumeroCliente() != null ? accionBean
																.getNumeroCliente()
																: "0")));

						subBean
								.setCompGestor(String
										.valueOf(Integer
												.parseInt(subBean
														.getCompGestor() != null ? subBean
														.getCompGestor()
														: "0")
												+ Integer
														.parseInt(accionBean
																.getCompGestor() != null ? accionBean
																.getCompGestor()
																: "0")));

						subBean.setNumeroGestiones2(subBean
								.getNumeroGestiones2()
								+ accionBean.getNumeroGestiones2());

						subBean.setNumeroConcretados2(subBean
								.getNumeroConcretados2()
								+ accionBean.getNumeroConcretados2());

						subBean.setMonto2(subBean.getMonto2()
								+ accionBean.getMonto2());

						if (num > 1) {
							for (int i = 1; i < num; i++) {
								accionBean = (Accion) lista.next();

								accionBean.setOrden("");
								accionBean.setNomEpigrafe("");
								accionBean.setPorc_asig("");
								subBean.setNomAccion("Subtotal");

								subBean
										.setNumeroCliente(String
												.valueOf(Integer
														.parseInt(subBean
																.getNumeroCliente() != null ? subBean
																.getNumeroCliente()
																: "0")
														+ Integer
																.parseInt(accionBean
																		.getNumeroCliente() != null ? accionBean
																		.getNumeroCliente()
																		: "0")));

								subBean
										.setCompGestor(String
												.valueOf(Integer
														.parseInt(subBean
																.getCompGestor() != null ? subBean
																.getCompGestor()
																: "0")
														+ Integer
																.parseInt(accionBean
																		.getCompGestor() != null ? accionBean
																		.getCompGestor()
																		: "0")));

								subBean.setNumeroGestiones2(subBean
										.getNumeroGestiones2()
										+ accionBean.getNumeroGestiones2());

								subBean.setNumeroConcretados2(subBean
										.getNumeroConcretados2()
										+ accionBean.getNumeroConcretados2());

								subBean.setMonto2(subBean.getMonto2()
										+ accionBean.getMonto2());

								newRes.add(accionBean);
							}
						}

						newRes.add(subBean);
					}
				}

				bean = new Accion();
				if (res == null) {
					newRes = new Vector(0, 1);
				}

				bean.setTotalClientes(numeroCliente);
				bean.setTotalCompGestor(compGestor);
				bean.setTotalNumeroConcretados(numeroConcretados);
				bean.setTotalMonto(monto);
				bean.setTotalNumeroGestiones(numeroGestiones);
				newRes.add(bean);

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: pggSeguimiento2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: pggSeguimiento2] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: pggSeguimiento2] ");
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
				log.error("[SesionAccionesBean :: pggSeguimiento2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return newRes;

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Vector pggEsfuerzoAdicional2(String mes, String anho,
			String codOficina, String codGestor) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;
		int compGestor = 0;
		int numeroCliente = 0;
		int monto = 0;
		int numeroConcretados = 0;
		int numeroGestiones = 0;
		Vector newRes = null;
		Accion subBean = null;

		
		try {
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] Fin");
				
				return null;
			}

			s = con.createStatement();
			java.util.Calendar c = java.util.Calendar.getInstance();
			Date d = c.getTime();
			@SuppressWarnings("unused")
			int diaActual = c.get(Calendar.DATE);
			@SuppressWarnings("unused")
			int mesActual = d.getMonth() + 1;
			@SuppressWarnings("unused")
			int anioActual = 1900 + d.getYear();
			@SuppressWarnings("unused")
			String cond = "";
			String condSeg1 = "";
			boolean mostrar = false;

			try {
				/*
				 * if(diaActual > 22) { condicionDia = " "; } else {
				 * condicionDia = " to_char(a.fec_regi,'dd')>'22' and "; }
				 */
				if (Integer.parseInt(mes) == 3) {
					cond = " (to_char(c.fec_regi,'mm') = '04' AND to_char(c.fec_regi,'mm') BETWEEN 1 AND 30) AND ";
					condSeg1 = " (to_char(b.fec_regi,'mm') = '03' AND to_char(b.fec_regi,'mm') BETWEEN 1 AND 31) AND ";
					mostrar = true;
				}
				//---
				if (Integer.parseInt(mes) == 4) {
					cond = " (to_char(c.fec_regi,'mm') = '04' AND to_char(c.fec_regi,'dd') BETWEEN 1 AND 30) AND ";
					condSeg1 = " (to_char(b.fec_regi,'mm') = '05' AND to_char(b.fec_regi,'dd') BETWEEN 1 AND 31) AND ";
					mostrar = true;
				}

				// nueva modi
				if (Integer.parseInt(mes) == 5) {
					mostrar = false;
				}

				String sql = " SELECT a.nom_camp, a.orden, b.comp_gest, b.nom_camp, b.nro_clie, "
						+ "(SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "      WHERE d.cod_meta_gestor = a.cod_gest and "
						+ "            d.cod_terr = a.cod_terr and "
						+ "            d.cod_ofic =a.cod_ofic and "
						+ "            d.anho = a.anho and "
						+ "            rownum <= 1) porc_asig, "
						+ " b.fec_regi, a.cod_gest, b.nro_conc_segu_2, b.mont_segu_2, b.nro_gest_segu_2, b.COD_CAMP_DETA "
						+ " from tiido_campanias a, tiido_campanias_detalle b "
						+ " where b.anho='"
						+ anho
						+ "' and "
						+ "     b.mes='"
						+ mes
						+ "' and "
						+ "     b.cod_ofic='"
						+ codOficina
						+ "' AND "
						+
						//condicionDia +
						//" to_char(b.fec_regi,'mm')=" + Integer.parseInt(mes)
						// + " and " +
						"     b.cod_gest='"
						+ codGestor
						+ "' and "
						+ "     b.cod_gest= a.cod_gest "
						+ "     and a.cod_camp = b.cod_camp " +
						//" ORDER BY COD_CAMP_DETA ";
						"     UNION ";

				sql += " SELECT a.nom_camp, a.orden, b.comp_gest, b.nom_camp, b.nro_clie, "
						+ "(SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "      WHERE d.cod_meta_gestor = a.cod_gest and "
						+ "            d.cod_terr = a.cod_terr and "
						+ "            d.cod_ofic =a.cod_ofic and "
						+ "            d.anho = a.anho and "
						+ "            rownum <= 1 "
						+ "            ) porc_asig, "
						+ " b.fec_regi, a.cod_gest, b.nro_conc_segu_2, b.mont_segu_2, b.nro_gest_segu_2, b.COD_CAMP_DETA "
						+ " from tiido_campanias a, tiido_campanias_detalle b "
						+ " where b.anho='"
						+ anho
						+ "' and "
						+ "     b.mes='"
						+ mes
						+ "' and "
						+ "     b.cod_ofic='"
						+ codOficina
						+ "' AND "
						+ condSeg1
						+
						//" to_char(b.fec_regi,'mm')=" +
						// (Integer.parseInt(mes)) + " and " +
						"     b.cod_gest='"
						+ codGestor
						+ "' and "
						+ "     b.cod_gest= a.cod_gest "
						+ "     and a.cod_camp = b.cod_camp "
						+ " ORDER BY COD_CAMP_DETA";

				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] SQL:" + sql);

				if (mostrar) {

					rst = s.executeQuery(sql);
					HashMap mapCont = new HashMap();

					while (rst.next()) {
						if (res == null)
							res = new Vector(0, 1);
						bean = new Accion();

						bean.setCodAccion(rst.getString("COD_CAMP_DETA"));
						bean.setCodEpigrafe(rst.getString("nom_camp"));
						bean.setNomCampania(rst.getString(1));
						bean.setOrden(rst.getString(2));
						bean.setCompGestor(rst.getString(3) != null ? rst
								.getString(3) : "0");
						bean.setNomAccion(rst.getString(4));
						bean.setNumeroCliente(rst.getString(5) != null ? rst
								.getString(5) : "0");
						bean.setPorc_asig(rst.getString(6) != null ? rst
								.getString(6) : "");
						bean.setFec_regi(rst.getString(7));
						bean.setCodGestor(rst.getString(8));
						bean.setNumeroConcretados2(rst.getInt(9));
						bean.setMonto2(rst.getInt(10));
						bean.setNumeroGestiones2(rst.getInt(11));

						compGestor = compGestor
								+ Integer
										.parseInt(rst.getString(3) != null ? rst
												.getString(3)
												: "0");
						numeroCliente = numeroCliente
								+ Integer
										.parseInt(rst.getString(5) != null ? rst
												.getString(5)
												: "0");
						numeroConcretados = numeroConcretados + rst.getInt(9);
						monto = monto + rst.getInt(10);
						numeroGestiones = numeroGestiones + rst.getInt(11);

						res.add(bean);

						if (mapCont.get(bean.getCodEpigrafe()) == null) {
							mapCont.put(bean.getCodEpigrafe(), new Integer(1));
						} else {
							mapCont
									.put(bean.getCodEpigrafe(), new Integer(
											((Integer) mapCont.get(bean
													.getCodEpigrafe()))
													.intValue() + 1));
						}
					}

					if (res != null) {
						newRes = new Vector();
						Iterator lista = res.iterator();
						while (lista.hasNext()) {
							Accion accionBean = (Accion) lista.next();
							@SuppressWarnings("unused")
							String codEpi = accionBean.getCodEpigrafe();
							int num = ((Integer) mapCont.get(accionBean
									.getCodEpigrafe())).intValue();
							subBean = new Accion();
							newRes.add(accionBean);

							//
							subBean.setOrden("");
							subBean.setNomCampania("");
							subBean.setPorc_asig("");
							subBean.setNomAccion("Subtotal");

							subBean
									.setNumeroCliente(String
											.valueOf(Integer
													.parseInt(subBean
															.getNumeroCliente() != null ? subBean
															.getNumeroCliente()
															: "0")
													+ Integer
															.parseInt(accionBean
																	.getNumeroCliente())));

							subBean.setCompGestor(String
									.valueOf(Integer.parseInt(subBean
											.getCompGestor() != null ? subBean
											.getCompGestor() : "0")
											+ Integer.parseInt(accionBean
													.getCompGestor())));

							subBean.setNumeroGestiones2(subBean
									.getNumeroGestiones2()
									+ accionBean.getNumeroGestiones2());

							subBean.setNumeroConcretados2(subBean
									.getNumeroConcretados2()
									+ accionBean.getNumeroConcretados2());

							subBean.setMonto2(subBean.getMonto2()
									+ accionBean.getMonto2());

							if (num > 1) {
								for (int i = 1; i < num; i++) {
									accionBean = (Accion) lista.next();

									accionBean.setOrden("");
									accionBean.setNomCampania("");
									accionBean.setPorc_asig("");
									subBean.setNomAccion("Subtotal");

									subBean
											.setNumeroCliente(String
													.valueOf(Integer
															.parseInt(subBean
																	.getNumeroCliente() != null ? subBean
																	.getNumeroCliente()
																	: "0")
															+ Integer
																	.parseInt(accionBean
																			.getNumeroCliente())));

									subBean
											.setCompGestor(String
													.valueOf(Integer
															.parseInt(subBean
																	.getCompGestor() != null ? subBean
																	.getCompGestor()
																	: "0")
															+ Integer
																	.parseInt(accionBean
																			.getCompGestor())));

									subBean.setNumeroGestiones2(subBean
											.getNumeroGestiones2()
											+ accionBean.getNumeroGestiones2());

									subBean.setNumeroConcretados2(subBean
											.getNumeroConcretados2()
											+ accionBean
													.getNumeroConcretados2());

									subBean.setMonto2(subBean.getMonto2()
											+ accionBean.getMonto2());

									newRes.add(accionBean);
								}
							}

							newRes.add(subBean);
						}
					}
				}

				bean = new Accion();
				if (res == null) {
					newRes = new Vector(0, 1);
				}

				// POR MIENTRAS
				//newRes = new Vector(0, 1);

				bean.setTotalCompGestor(compGestor);
				//bean.setTotalClientes(numeroCliente);
				//POR MIENTRAS
				//bean.setTotalClientes(0);

				bean.setTotalNumeroConcretados(numeroConcretados);
				bean.setTotalMonto(monto);
				bean.setTotalNumeroGestiones(numeroGestiones);
				newRes.add(bean);

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: pggEsfuerzoAdicional2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: pggEsfuerzoAdicional2] ");
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
				log.error("[SesionAccionesBean :: pggEsfuerzoAdicional2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return newRes;

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Vector pggEsfuerzoAdicional2(String mes, String anho,
			String codOficina, String codGestor, ProgSeguimiento progSeguimiento) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Accion bean = null;
		int compGestor = 0;
		int numeroCliente = 0;
		int monto = 0;
		int numeroConcretados = 0;
		int numeroGestiones = 0;
		Vector newRes = null;
		Accion subBean = null;

		try {
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] Fin");
				
				return null;
			}
			
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] Fin");
				
				return null;
			}

			s = con.createStatement();
			java.util.Calendar c = java.util.Calendar.getInstance();
			Date d = c.getTime();
			@SuppressWarnings("unused")
			int diaActual = c.get(Calendar.DATE);
			@SuppressWarnings("unused")
			int mesActual = d.getMonth() + 1;
			@SuppressWarnings("unused")
			int anioActual = 1900 + d.getYear();
			String cond = "";

			try {
				//cond = " ((b.fec_regi BETWEEN TO_DATE('" +
				// progSeguimiento.getSeg1Ini() + "', 'DD/MM/YYYY') AND
				// TO_DATE('" + progSeguimiento.getSeg1Fin() + "',
				// 'DD/MM/YYYY')) OR "
				//	+ " (b.fec_regi BETWEEN TO_DATE('" +
				// progSeguimiento.getSeg2Ini() + "', 'DD/MM/YYYY') AND
				// TO_DATE('" + progSeguimiento.getSeg2Fin() + "',
				// 'DD/MM/YYYY'))) ";
				/*cond = "(( TO_CHAR(b.fec_regi, 'YYYYMMDD') BETWEEN '"
						+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
								.getSeg1Ini())
						+ "' AND '"
						+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
								.getSeg1Fin())
						+ "') OR "
						+ "( TO_CHAR(b.fec_regi, 'YYYYMMDD') BETWEEN '"
						+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
								.getSeg2Ini())
						+ "' AND '"
						+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
								.getSeg2Fin()) + "'))";
				*/
				cond = "( TO_CHAR(sysdate, 'YYYYMMDD') BETWEEN '"
					+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
							.getSeg2Ini())
					+ "' AND '"
					+ ConstantesUtil.fechaFormatoAnsi(progSeguimiento
							.getSeg2Fin()) + "')";
				
				String sql = " SELECT a.nom_camp, a.orden, b.comp_gest, b.nom_camp, b.nro_clie, "
						+ "(SELECT d.porc_asig FROM tiido_metas_gestor d "
						+ "      WHERE d.cod_meta_gestor = a.cod_gest and "
						+ "            d.cod_terr = a.cod_terr and "
						+ "            d.cod_ofic =a.cod_ofic and "
						+ "            d.anho = a.anho and "
						+ "            rownum <= 1) porc_asig, "
						+ " b.fec_regi, a.cod_gest, b.nro_conc_segu_2, b.mont_segu_2, b.nro_gest_segu_2, b.COD_CAMP_DETA, "
						+ " case when "+ cond +" then 1 else 0 end as estado, a.cod_epigrafe "
						+ " FROM tiido_campanias a, tiido_campanias_detalle b "
						+ " WHERE b.anho='"
						+ anho
						+ "' AND b.mes='"
						+ mes
						+ "' AND b.cod_ofic='"
						+ codOficina
						+ "' AND b.cod_gest='"
						+ codGestor
						+ "' AND "
						+ " b.cod_gest= a.cod_gest "
						+ " AND a.cod_camp = b.cod_camp "
						+ " ORDER BY COD_CAMP_DETA";

				log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] SQL:" + sql);

				rst = s.executeQuery(sql);
				HashMap mapCont = new HashMap();

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new Accion();

					
					bean.setCodAccion(rst.getString("COD_CAMP_DETA"));
					bean.setCodEpigrafe(rst.getString("cod_epigrafe")); // nom_camp
					bean.setEstado(rst.getInt("estado"));
					bean.setNomCampania(rst.getString(1));
					bean.setOrden(rst.getString(2));
					bean.setCompGestor(rst.getString(3) != null ? rst.getString(3) : "0");
					bean.setNomAccion(rst.getString(4));
					bean.setNumeroCliente(rst.getString(5) != null ? rst.getString(5) : "0");
					bean.setPorc_asig(rst.getString(6) != null ? rst.getString(6) : "");
					bean.setFec_regi(rst.getString(7));
					bean.setCodGestor(rst.getString(8));
					bean.setNumeroConcretados2(rst.getInt(9));
					bean.setMonto2(rst.getInt(10));
					bean.setNumeroGestiones2(rst.getInt(11));

					compGestor = compGestor
							+ Integer.parseInt(rst.getString(3) != null ? rst
									.getString(3) : "0");
					numeroCliente = numeroCliente
							+ Integer.parseInt(rst.getString(5) != null ? rst
									.getString(5) : "0");
					numeroConcretados = numeroConcretados + rst.getInt(9);
					monto = monto + rst.getInt(10);
					numeroGestiones = numeroGestiones + rst.getInt(11);

					res.add(bean);

					if (mapCont.get(bean.getCodEpigrafe()) == null) {
						mapCont.put(bean.getCodEpigrafe(), new Integer(1));
					} else {
						mapCont.put(bean.getCodEpigrafe(), new Integer(
								((Integer) mapCont.get(bean.getCodEpigrafe()))
										.intValue() + 1));
					}
				}

				if (res != null) {
					newRes = new Vector();
					Iterator lista = res.iterator();
					while (lista.hasNext()) {
						Accion accionBean = (Accion) lista.next();
						@SuppressWarnings("unused")
						String codEpi = accionBean.getCodEpigrafe();
						int num = ((Integer) mapCont.get(accionBean.getCodEpigrafe())).intValue();
						subBean = new Accion();
						newRes.add(accionBean);

						//
						subBean.setOrden("");
						subBean.setNomCampania("");
						subBean.setPorc_asig("");
						subBean.setNomAccion("Subtotal");

						subBean.setNumeroCliente(String
								.valueOf(Integer.parseInt(subBean
										.getNumeroCliente() != null ? subBean
										.getNumeroCliente() : "0")
										+ Integer.parseInt(accionBean
												.getNumeroCliente())));

						subBean.setCompGestor(String
								.valueOf(Integer.parseInt(subBean
										.getCompGestor() != null ? subBean
										.getCompGestor() : "0")
										+ Integer.parseInt(accionBean
												.getCompGestor())));

						subBean.setNumeroGestiones2(subBean
								.getNumeroGestiones2()
								+ accionBean.getNumeroGestiones2());

						subBean.setNumeroConcretados2(subBean
								.getNumeroConcretados2()
								+ accionBean.getNumeroConcretados2());

						subBean.setMonto2(subBean.getMonto2()
								+ accionBean.getMonto2());

						if (num > 1) {
							for (int i = 1; i < num; i++) {
								accionBean = (Accion) lista.next();

								accionBean.setOrden("");
								accionBean.setNomCampania("");
								accionBean.setPorc_asig("");
								subBean.setNomAccion("Subtotal");

								subBean
										.setNumeroCliente(String
												.valueOf(Integer
														.parseInt(subBean
																.getNumeroCliente() != null ? subBean
																.getNumeroCliente()
																: "0")
														+ Integer
																.parseInt(accionBean
																		.getNumeroCliente())));

								subBean
										.setCompGestor(String
												.valueOf(Integer
														.parseInt(subBean
																.getCompGestor() != null ? subBean
																.getCompGestor()
																: "0")
														+ Integer
																.parseInt(accionBean
																		.getCompGestor())));

								subBean.setNumeroGestiones2(subBean
										.getNumeroGestiones2()
										+ accionBean.getNumeroGestiones2());

								subBean.setNumeroConcretados2(subBean
										.getNumeroConcretados2()
										+ accionBean.getNumeroConcretados2());

								subBean.setMonto2(subBean.getMonto2()
										+ accionBean.getMonto2());

								newRes.add(accionBean);
							}
						}

						newRes.add(subBean);
					}
				}

				bean = new Accion();
				if (res == null) {
					newRes = new Vector(0, 1);
				}

				bean.setTotalClientes(numeroCliente);
				bean.setTotalCompGestor(compGestor);
				bean.setTotalNumeroConcretados(numeroConcretados);
				bean.setTotalMonto(monto);
				bean.setTotalNumeroGestiones(numeroGestiones);
				newRes.add(bean);

			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: pggEsfuerzoAdicional2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: pggEsfuerzoAdicional2] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: pggEsfuerzoAdicional2] ");
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
				log.error("[SesionAccionesBean :: pggEsfuerzoAdicional2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return newRes;

	}

	public boolean actualizarSeguimiento1(String tipoSeguimiento,
			String numDato, String codigo1, String codigo2, String valor, String usuario) {
		boolean res = false;
		String sqlValor = "";
		String sql = "";
		
		log.info("[SesionAccionesBean :: actualizarSeguimiento1] Inicio");

		if (tipoSeguimiento.equals("1")) {
			//acciones
			if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST))
				sqlValor = " NRO_GEST_SEGU_1 = " + valor + " ";
			else if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR))
				sqlValor = " NRO_CONC_SEGU_1 = " + valor + " ";
			else if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO))
				sqlValor = " MON_SEGU_1 = " + valor + " ";
			
			if(!sqlValor.equals("")) {
				sqlValor += ", fec_actu=sysdate, usu_actu='" + usuario + "'";
			}
			
			sql = "update TIIDO_ACCIONES set " + sqlValor + " where COD_ACCI='"
					+ codigo1 + "' and COD_EPIGRAFE='" + codigo2 + "'";
		} else if (tipoSeguimiento.equals("2")) {
			//campanias
			if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST))
				sqlValor = " NRO_GEST_SEGU_1 = " + valor + " ";
			else if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR))
				sqlValor = " NRO_CONC_SEGU_1 = " + valor + " ";
			else if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO))
				sqlValor = " MONT_SEGU_1 = " + valor + " ";
			
			if(!sqlValor.equals("")) {
				sqlValor += ", fec_actu=sysdate, usu_actu='" + usuario + "'";
			}
			
			sql = "update TIIDO_CAMPANIAS_DETALLE set " + sqlValor
					+ " where COD_CAMP_DETA='" + codigo1 + "'";
		}

		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			String DATASOURCE_CONTEXT = ConstantesUtil.DATASOURCE_CONTEXT;
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: actualizarSeguimiento1] Fin");
				
				return false;
			}
			
			DataSource datasource = (DataSource) initialContext
					.lookup(DATASOURCE_CONTEXT);
			if (datasource != null)
				con = datasource.getConnection();
			else
				return false;

			s = con.createStatement();

			try {
				log.info("[SesionAccionesBean :: actualizarSeguimiento1] SQL:" + sql);
				
				s.executeUpdate(sql);
				res = true;
			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: actualizarSeguimiento1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionAccionesBean :: actualizarSeguimiento1] Fin");
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: actualizarSeguimiento1] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
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
				log.error("[SesionAccionesBean :: actualizarSeguimiento1] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}

		return res;
	}

	public boolean actualizarSeguimiento2(String tipoSeguimiento,
			String numDato, String codigo1, String codigo2, String valor, String usuario) {
		boolean res = false;
		String sqlValor = "";
		String sql = "";
		
		log.info("[SesionAccionesBean :: actualizarSeguimiento2] Inicio");
		
		if (tipoSeguimiento.equals("1")) {
			//acciones
			if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST))
				sqlValor = " NRO_GEST_SEGU_2 = " + valor + " ";
			else if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR))
				sqlValor = " NRO_CONC_SEGU_2 = " + valor + " ";
			else if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO))
				sqlValor = " MON_SEGU_2 = " + valor + " ";
			
			if(!sqlValor.equals("")) {
				sqlValor += ", fec_actu=sysdate, usu_actu='" + usuario + "'";
			}
			
			sql = "update TIIDO_ACCIONES set " + sqlValor + " where COD_ACCI='"
					+ codigo1 + "' and COD_EPIGRAFE='" + codigo2 + "'";
		} else if (tipoSeguimiento.equals("2")) {
			//campanias
			if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_GEST))
				sqlValor = " NRO_GEST_SEGU_2 = " + valor + " ";
			else if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_CONCR))
				sqlValor = " NRO_CONC_SEGU_2 = " + valor + " ";
			else if (numDato.equals(ConstantesUtil.SEG_ACTUALIZAR_NUM_MONTO))
				sqlValor = " MONT_SEGU_2 = " + valor + " ";
			
			if(!sqlValor.equals("")) {
				sqlValor += ", fec_actu=sysdate, usu_actu='" + usuario + "'";
			}
			
			sql = "update TIIDO_CAMPANIAS_DETALLE set " + sqlValor
					+ " where COD_CAMP_DETA='" + codigo1 + "'";
		}

		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			String DATASOURCE_CONTEXT = ConstantesUtil.DATASOURCE_CONTEXT;
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionAccionesBean :: actualizarSeguimiento2] Fin");
				
				return false;
			}
			
			DataSource datasource = (DataSource) initialContext
					.lookup(DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				log.info("[SesionAccionesBean :: actualizarSeguimiento2] Fin");
				
				return false;
			}

			s = con.createStatement();

			try {
				log.info("[SesionAccionesBean :: actualizarSeguimiento2] SQL:" + sql);
				
				s.executeUpdate(sql);
				res = true;
			} catch (SQLException e) {
				log.error("[SesionAccionesBean :: actualizarSeguimiento2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		} catch (Exception e) {
			log.error("[SesionAccionesBean :: actualizarSeguimiento2] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
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
				log.error("[SesionAccionesBean :: actualizarSeguimiento2] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}

		return res;
	}
}