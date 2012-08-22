package com.grupobbva.bc.per.tele.sdo.sesion;

import java.math.BigDecimal;
import java.sql.CallableStatement;
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

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.serializable.CampaniasGeneral;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.PlanesAcciones;
import com.grupobbva.bc.per.tele.sdo.serializable.Seguimiento;
import com.grupobbva.bc.per.tele.sdo.serializable.TAcciones;
import com.grupobbva.bc.per.tele.sdo.serializable.TCampanhas;
import com.grupobbva.bc.per.tele.sdo.serializable.TCampanhasDetalle;
import com.grupobbva.bc.per.tele.sdo.serializable.TEpigrafes;
import com.grupobbva.bc.per.tele.sdo.serializable.TEquivalencias;
import com.grupobbva.bc.per.tele.sdo.serializable.TFirmas;
import com.grupobbva.bc.per.tele.sdo.serializable.TMaestroPlanes;
import com.grupobbva.bc.per.tele.sdo.serializable.TMetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.TOficina;
import com.grupobbva.bc.per.tele.sdo.serializable.TParametros;
import com.grupobbva.bc.per.tele.sdo.serializable.TPerfiles;
import com.grupobbva.bc.per.tele.sdo.serializable.TPlanes;
import com.grupobbva.bc.per.tele.sdo.serializable.TTerritorio;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.serializable.UsuarioLDAP;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

/**
 * Bean implementation class for Enterprise Bean: SessionUtil
 */
@SuppressWarnings("unchecked")
public class SessionUtilBean implements javax.ejb.SessionBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(SessionUtilBean.class);
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

	public String getCorrelativo(String nomTabla, String nomCampo, String tamano) {
		String next = null;
		Connection con = null;
		Context initialContext = null;
		CallableStatement cs = null;

		try {
			log.info("[SessionUtilBean :: getCorrelativo] Inicio");

			initialContext = new InitialContext();

			if (initialContext == null) {
				log.info("[SessionUtilBean :: getCorrelativo] Fin");

				return null;
			}

			DataSource datasource = (DataSource) initialContext
					.lookup("jdbc/IIDO");
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: getCorrelativo] Fin");

				return null;
			}

			cs = con.prepareCall("{? = call IIDO.PKG_UTIL.GENERA_CODIGO_CORRELATIVO(?,?,?)}");
			cs.registerOutParameter(1, OracleTypes.VARCHAR);
			cs.setString(2, nomTabla);
			cs.setString(3, nomCampo);
			cs.setString(4, tamano);
			cs.execute();
			next = cs.getString(1);

			log.info("[SessionUtilBean :: getCorrelativo] Valor: "
					+ cs.getString(1));

			log.info("[SessionUtilBean :: getCorrelativo] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: getCorrelativo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SessionUtilBean :: getCorrelativo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		}

		return next;
	}

	public String getMontoByCodPerfil(String codPerfil, String codEpigrafe) {
		String next = null;
		Connection con = null;
		Context initialContext = null;
		CallableStatement cs = null;

		try {
			log.info("[SessionUtilBean :: getMontoByCodPerfil] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: getMontoByCodPerfil] Fin");

				return null;
			}

			DataSource datasource = (DataSource) initialContext
					.lookup("jdbc/ORA_Biido001");
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: getMontoByCodPerfil] Fin");

				return null;
			}

			cs = con
					.prepareCall("{? = call IIGR.PKG_UTIL.GENERA_CODIGO_CORRELATIVO(?,?,?)}");
			cs.registerOutParameter(1, OracleTypes.VARCHAR);
			cs.setString(2, codPerfil);
			cs.setString(3, codEpigrafe);
			cs.execute();
			next = cs.getString(1);

			log.info("[SessionUtilBean :: getMontoByCodPerfil] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: getMontoByCodPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SessionUtilBean :: getMontoByCodPerfil] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		}

		return next;
	}

	public Vector consultarPLanesAccion(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		Vector listaPlanesAccion = new Vector();
		Connection con = null;
		Context initialContext = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			log.info("[SessionUtilBean :: consultarPLanesAccion] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}

			DataSource datasource = (DataSource) initialContext
					.lookup("jdbc/ORA_Biido001");
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			cs = con
					.prepareCall("{call IIDO.PKG_UTIL.SP_LIST_PLANES_ACCION(?,?,?,?)}");
			cs.setString(1, codigoOficina);
			cs.setString(2, anho);
			cs.setString(3, mes);
			cs.registerOutParameter(4, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet) cs.getObject(4);
			while (rs.next()) {
				PlanesAcciones planAccion = new PlanesAcciones();
				planAccion.setCodigoEpigrafe(rs.getString(1));
				planAccion.setNombreEpigrafe(rs.getString(2));
				planAccion.setCodigoOficina(rs.getString(3));
				planAccion.setMes(rs.getString(4));
				planAccion.setAnho(rs.getString(5));
				planAccion.setMetaMesSaldoPuntual(rs.getBigDecimal(6));
				planAccion.setPrioridad(rs.getBigDecimal(7));
				planAccion.setMetaGerenteOficina(rs.getBigDecimal(8));
				planAccion.setNombreAccion(rs.getString(9));
				planAccion.setCodigoGestor(rs.getString(10));
				planAccion.setNroClientes(rs.getBigDecimal(11));
				planAccion.setCompromisoGestor(rs.getBigDecimal(12));
				planAccion.setNroGestorSeguimiento1(rs.getBigDecimal(13));
				planAccion.setNroConcSeguimiento1(rs.getBigDecimal(14));
				planAccion.setMontoSeguimiento1(rs.getBigDecimal(15));
				planAccion.setNroGestorSeguimiento2(rs.getBigDecimal(16));
				planAccion.setNroConcSeguimiento2(rs.getBigDecimal(17));
				planAccion.setMontoSeguimiento2(rs.getBigDecimal(18));
				planAccion.setCodigoAcciones(rs.getString(19));
				planAccion.setIndicadorAfecta(rs.getString(20));
				planAccion.setAsignado(rs.getBigDecimal(21));
				listaPlanesAccion.add(planAccion);
			}
			log.info("[SessionUtilBean :: consultarPLanesAccion] Fin");

			return listaPlanesAccion;
		} catch (Exception e) {
			log.error("[SessionUtilBean :: consultarPLanesAccion] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);

			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (cs != null) {
					cs.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SessionUtilBean :: consultarPLanesAccion] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}
	}

	public Vector consultarPlanesAccionesPPG(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		Vector listaPlanesAccion = new Vector();
		Connection con = null;
		Context initialContext = null;
		ResultSet rs = null;
		CallableStatement cs = null;

		try {
			log.info("[SessionUtilBean :: consultarPlanesAccionesPPG] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: consultarPlanesAccionesPPG] Fin");

				return null;
			}
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: consultarPlanesAccionesPPG] Fin");

				return null;
			}

			/*
			 * String sql =
			 * " SELECT (SELECT e.cod_epigrafe FROM TIIDO_EPIGRAFE e WHERE e.cod_epigrafe = b.cod_epigrafe and e.anho = b.anho) codEpigrafe, "
			 * +
			 * " (SELECT e.nom_epigrafe FROM TIIDO_EPIGRAFE e WHERE e.cod_epigrafe = b.cod_epigrafe and e.anho = b.anho) nomEpigrafe, "
			 * +
			 * "	a.COD_OFIC, a.MES_PLAN mesPlan, a.ANHO_PLAN anoPlan, a.MET_MESSALD_PUNT metMesSaldPuntual, "
			 * +
			 * " a.PRIORIDAD prioridad, a.MET_GER_OFI metGestOficina,  b.NOM_ACCI nomAccion, b.COD_GEST codGestor, "
			 * +
			 * " b.NRO_CLIE nroCliente,  b.COMP_GEST compGestor, b.NRO_GEST_SEGU_1 nroGestSeg1, "
			 * +
			 * " b.NRO_CONC_SEGU_1 nroConcSeg1,  b.MON_SEGU_1 montSeg1, b.NRO_GEST_SEGU_2 nroGestSeg2, "
			 * +
			 * " b.NRO_CONC_SEGU_2 nroConcSeg2,  b.MON_SEGU_2 montSeg1, b.COD_ACCI codAccion, "
			 * +
			 * " (SELECT e.ind_Afecta FROM TIIDO_EPIGRAFE e WHERE e.cod_epigrafe = b.cod_epigrafe and e.anho = b.anho) indAfecta, "
			 * + " NVL((SELECT SUM(d.porc_asig) FROM tiido_metas_gestor d " +
			 * "  WHERE d.cod_gestor = b.cod_gest and " +
			 * "        d.cod_terr = b.cod_terr and d.cod_ofic =b.cod_ofic and "
			 * +
			 * "        d.anho = b.anho and d.cod_epigrafe = b.cod_epigrafe), 0) porc_asig "
			 * + "  FROM TIIDO_PLANES a, TIIDO_ACCIONES b " +
			 * " WHERE a.COD_EPIGRAFE = b.COD_EPIGRAFE and " +
			 * "  a.COD_OFIC = '" + codigoOficina + "' and " +
			 * " 	a.ANHO_PLAN = '" + anho + "' and " + "	b.COD_OFIC = '" +
			 * codigoOficina + "' and " + "	b.ANHO =   '" + anho + "' and " +
			 * "	a.MES_PLAN = '" + mes + "' and " + "	b.MES_ACCI = '" + mes +
			 * "' and " + "	b.cod_gest = '" + codigoGestor + "'" +
			 * "  ORDER BY a.PRIORIDAD, a.MET_MESSALD_PUNT, a.COD_EPIGRAFE , b.COD_GEST , b.COD_ACCI"
			 * ;
			 */

			String sql = "SELECT (SELECT e.cod_epigrafe FROM TIIDO_EPIGRAFE e WHERE e.cod_epigrafe = ta.cod_epigrafe and e.anho = ta.anho) codEpigrafe, "
					+ " (SELECT e.nom_epigrafe FROM TIIDO_EPIGRAFE e WHERE e.cod_epigrafe = ta.cod_epigrafe and e.anho = ta.anho) nomEpigrafe, "
					+ "  ta.cod_ofic, ta.mes_acci, ta.anho, "
					+ "(SELECT p.prioridad "
					+ "FROM tiido_planes p "
					+ "WHERE p.cod_ofic = ta.cod_ofic AND "
					+ "      p.anho_plan = ta.anho AND "
					+ "      p.mes_plan = ta.mes_acci AND "
					+ "      p.cod_epigrafe = ta.cod_epigrafe "
					+ ") prioridad, "
					+ "(SELECT p.met_ger_ofi "
					+ "FROM tiido_planes p "
					+ "WHERE p.cod_ofic = ta.cod_ofic AND "
					+ "     p.anho_plan = ta.anho AND "
					+ "     p.mes_plan =ta.mes_acci AND "
					+ "     p.cod_epigrafe = ta.cod_epigrafe "
					+ ") met_ger_ofi, "
					+ "ta.nom_acci, ta.cod_gest, ta.nro_clie, ta.comp_gest, ta.nro_gest_segu_1, ta.nro_conc_segu_1, "
					+ "ta.mon_segu_1, ta.nro_gest_segu_2, ta.nro_conc_segu_2, "
					+ "ta.mon_segu_2, ta.cod_acci, "
					+ "(SELECT e.ind_Afecta FROM TIIDO_EPIGRAFE e WHERE e.cod_epigrafe = ta.cod_epigrafe and e.anho = ta.anho) indAfecta, "
					+ "NVL((SELECT SUM(d.porc_asig) "
					+ "       FROM tiido_metas_gestor d "
					+ "       WHERE d.cod_gestor = ta.cod_gest AND "
					+ "             d.cod_ofic = ta.cod_ofic AND "
					+ "             d.anho = ta.anho AND "
					+ "             d.mes = ta.mes_acci AND "
					+ "             d.cod_epigrafe = ta.cod_epigrafe), 0) porc_asig "
					+ "FROM TIIDO_ACCIONES ta "
					+ "WHERE ta.cod_ofic = '"
					+ codigoOficina
					+ "' AND "
					+ "ta.anho = "
					+ anho
					+ " AND "
					+ "ta.mes_acci = "
					+ mes
					+ " AND "
					+ "ta.cod_gest = '"
					+ codigoGestor
					+ "' "
					+ "ORDER BY prioridad, ta.cod_epigrafe, ta.cod_gest, ta.cod_acci";

			log.info("[SessionUtilBean :: consultarPlanesAccionesPPG] SQL:"
					+ sql);

			cs = con.prepareCall(sql);

			rs = cs.executeQuery();

			while (rs.next()) {
				PlanesAcciones planAccion = new PlanesAcciones();
				planAccion.setCodigoEpigrafe(rs.getString("codepigrafe"));
				planAccion.setNombreEpigrafe(rs.getString("nomepigrafe"));
				planAccion.setCodigoOficina(rs.getString("cod_ofic"));
				planAccion.setMes(rs.getString("mes_acci"));
				planAccion.setAnho(rs.getString("anho"));
				planAccion.setPrioridad(rs.getBigDecimal("prioridad"));
				planAccion.setMetaGerenteOficina(rs
						.getBigDecimal("met_ger_ofi"));
				planAccion.setNombreAccion(rs.getString("nom_acci"));
				planAccion.setCodigoGestor(rs.getString("cod_gest"));
				planAccion.setNroClientes(rs.getBigDecimal("nro_clie"));
				planAccion.setCompromisoGestor(rs.getBigDecimal("comp_gest"));
				planAccion.setNroGestorSeguimiento1(rs
						.getBigDecimal("nro_gest_segu_1"));
				planAccion.setNroConcSeguimiento1(rs
						.getBigDecimal("nro_conc_segu_1"));
				planAccion.setMontoSeguimiento1(rs.getBigDecimal("mon_segu_1"));
				planAccion.setNroGestorSeguimiento2(rs
						.getBigDecimal("nro_gest_segu_2"));
				planAccion.setNroConcSeguimiento2(rs
						.getBigDecimal("nro_conc_segu_2"));
				planAccion.setMontoSeguimiento2(rs.getBigDecimal("mon_segu_2"));
				planAccion.setCodigoAcciones(rs.getString("cod_acci"));
				planAccion.setIndicadorAfecta(rs.getString("indAfecta"));
				planAccion.setAsignado(rs.getBigDecimal("porc_asig"));

				listaPlanesAccion.add(planAccion);
			}

			log.info("[SessionUtilBean :: consultarPlanesAccionesPPG] Fin");

			return listaPlanesAccion;
		} catch (Exception e) {
			log.error("[SessionUtilBean :: consultarPlanesAccionesPPG] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);

			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (cs != null) {
					cs.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SessionUtilBean :: consultarPlanesAccionesPPG] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}
	}

	public Vector consultarCampaniasDetalles(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		Vector listaCampanaDetalle = new Vector();
		Connection con = null;
		Context initialContext = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			log.info("[SessionUtilBean :: consultarCampaniasDetalles] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: consultarCampaniasDetalles] Fin");

				return null;
			}

			DataSource datasource = (DataSource) initialContext
					.lookup("jdbc/ORA_Biido001");
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: consultarCampaniasDetalles] Fin");

				return null;
			}

			cs = con
					.prepareCall("{call IIDO.PKG_UTIL.SP_LIST_CAMPA_DETALLE(?,?,?,?)}");
			cs.setString(1, codigoOficina);
			cs.setString(2, anho);
			cs.setString(3, mes);
			cs.registerOutParameter(4, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet) cs.getObject(4);
			while (rs.next()) {
				CampaniasGeneral campGeneral = new CampaniasGeneral();
				campGeneral.setCodigoCampania(rs.getString(1));
				campGeneral.setNombreCampania(rs.getString(2));
				campGeneral.setCodigoOficina(rs.getString(3));
				campGeneral.setMes(rs.getString(4));
				campGeneral.setAnho(rs.getString(5));
				campGeneral.setOrden(rs.getString(6));
				campGeneral.setNombreCampaniaDetalle(rs.getString(7));
				campGeneral.setCodigoGestor(rs.getString(8));
				campGeneral.setNroClientes(rs.getBigDecimal(9));
				campGeneral.setCompromisoGestor(rs.getBigDecimal(10));
				campGeneral.setNroGestorSeguimiento1(rs.getBigDecimal(11));
				campGeneral.setNroConcSeguimiento1(rs.getBigDecimal(12));
				campGeneral.setMontoSeguimiento1(rs.getBigDecimal(13));
				campGeneral.setNroGestorSeguimiento2(rs.getBigDecimal(14));
				campGeneral.setNroConcSeguimiento2(rs.getBigDecimal(15));
				campGeneral.setMontoSeguimiento2(rs.getBigDecimal(16));
				campGeneral.setCodigoCampaniaDetalle(rs.getString(17));
				listaCampanaDetalle.add(campGeneral);
			}

			log.info("[SessionUtilBean :: consultarCampaniasDetalles] Fin");

			return listaCampanaDetalle;
		} catch (Exception e) {
			log.error("[SessionUtilBean :: consultarCampaniasDetalles] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);

			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (cs != null) {
					cs.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SessionUtilBean :: consultarCampaniasDetalles] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}
	}

	public Vector findAllOficinaConMetas(String codTerritorio, String mes,
			String anio) {
		String sql;
		Context initialContext = null;
		Connection con = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		Oficina bean = null;
		Territorio bean2 = null;

		try {
			log.info("[SessionUtilBean :: findAllOficinaConMetas] Inicio");

			sql = "select distinct o.* from tiido_oficina o, tiido_metas_gestor mg "
					+ "where mg.cod_ofic = o.cod_ofic and mg.anho = '"
					+ anio
					+ "' and mg.mes = '" + mes + "'";
			initialContext = new InitialContext();
			DataSource datasource = (DataSource) initialContext
					.lookup("jdbc/ORA_Biido001");
			con = datasource.getConnection();
			s = con.createStatement();

			log.info("[SessionUtilBean :: findAllOficinaConMetas] SQL:" + sql);

			rst = s.executeQuery(sql);

			while (rst.next()) {
				if (res == null)
					res = new Vector(0, 1);
				bean = new Oficina();
				bean2 = new Territorio();
				bean.setCodOfic(rst.getString(1));
				bean2.setCodTerr(rst.getString(2));
				bean.setTerr(bean2);
				bean.setCodNomOficina(rst.getString(3));
				res.add(bean);
			}

			log.info("[SessionUtilBean :: findAllOficinaConMetas] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: findAllOficinaConMetas] ");
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
				log.error("[SessionUtilBean :: findAllOficinaConMetas] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public Vector consultarCampaniasDetallesPGG(String codigoOficina,
			String mes, String anho, String codigoGestor) {
		Vector listaCampanaDetalle = new Vector();
		Connection con = null;
		Context initialContext = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			log
					.info("[SessionUtilBean :: consultarCampaniasDetallesPGG] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log
						.info("[SessionUtilBean :: consultarCampaniasDetallesPGG] Fin");

				return null;
			}

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log
						.info("[SessionUtilBean :: consultarCampaniasDetallesPGG] Fin");

				return null;
			}
			/*
			 * CallableStatement cs = null; cs = con.prepareCall("{call
			 * IIDO.PKG_UTIL.SP_LIST_CAMPA_DETA_PGG(?,?,?,?,?)}");
			 * cs.setString(1,codigoOficina); cs.setString(2,anho);
			 * cs.setString(3,mes); cs.setString(4,codigoGestor);
			 * cs.registerOutParameter(5,OracleTypes.CURSOR); cs.execute();
			 * 
			 * ResultSet rs = (ResultSet)cs.getObject(5);
			 */

			String sql = " SELECT d.COD_CAMP codCampana, d.NOM_CAMP nomCampana, d.COD_OFIC codOficina, "
					+ " d.MES mes, d.ANHO anho, b.NOM_CAMP nombreCampaniaDetalle, "
					+ " d.COD_GEST codGestor, b.NRO_CLIE nroCliente, "
					+
					// "b.COMP_GEST compGestor, " +

					"(SELECT g.porc_asig FROM tiido_metas_gestor g "
					+ "      WHERE g.cod_meta_gestor = d.cod_gest and "
					+ "            g.cod_terr = d.cod_terr and "
					+ "            g.cod_ofic =d.cod_ofic and "
					+ "            g.anho = d.anho and "
					+ "            rownum <= 1) compGestor, "
					+

					" b.NRO_GEST_SEGU_1 nroGestSeg1, b.NRO_CONC_SEGU_1 nroConcSeg1, b.MONT_SEGU_1 nomtSeg1, "
					+ " b.NRO_GEST_SEGU_2 nroGestSeg2, b.NRO_CONC_SEGU_2 nroConcSeg2, b.MONT_SEGU_2 nomtSeg2, "
					+ " b.COD_CAMP_DETA codCampDeta, d.orden "
					+ " FROM IIDO.TIIDO_campanias_detalle b, IIDO.TIIDO_campanias  d "
					+ " WHERE b.COD_CAMP = d.COD_CAMP and d.COD_OFIC = '"
					+ codigoOficina
					+ "' "
					+ " and d.ANHO = '"
					+ anho
					+ "' and b.COD_OFIC = '"
					+ codigoOficina
					+ "' "
					+ " and b.ANHO = '"
					+ anho
					+ "' and b.MES = '"
					+ mes
					+ "' "
					+ " and b.COD_GEST = d.COD_GEST "
					+ "  and b.COD_GEST = '"
					+ codigoGestor
					+ "' "
					+ "  and d.COD_GEST = '"
					+ codigoGestor
					+ "' "
					+ " ORDER BY d.orden, b.COD_GEST , b.COD_CAMP_DETA";

			log.info("[SessionUtilBean :: consultarCampaniasDetallesPGG] SQL:"
					+ sql);

			cs = con.prepareCall(sql);

			rs = cs.executeQuery();
			while (rs.next()) {
				CampaniasGeneral campGeneral = new CampaniasGeneral();
				campGeneral.setCodigoCampania(rs.getString(1));
				campGeneral.setNombreCampania(rs.getString(2));
				campGeneral.setCodigoOficina(rs.getString(3));
				campGeneral.setMes(rs.getString(4));
				campGeneral.setAnho(rs.getString(5));
				// campGeneral.setOrden(rs.getString(6));
				campGeneral.setNombreCampaniaDetalle(rs.getString(6));
				campGeneral.setCodigoGestor(rs.getString(7));
				campGeneral.setNroClientes(rs.getBigDecimal(8));
				campGeneral.setCompromisoGestor(rs.getBigDecimal(9));
				campGeneral
						.setNroGestorSeguimiento1(rs.getBigDecimal(10) != null ? rs
								.getBigDecimal(10)
								: new BigDecimal("0"));
				campGeneral
						.setNroConcSeguimiento1(rs.getBigDecimal(11) != null ? rs
								.getBigDecimal(11)
								: new BigDecimal("0"));
				campGeneral
						.setMontoSeguimiento1(rs.getBigDecimal(12) != null ? rs
								.getBigDecimal(12) : new BigDecimal("0"));
				campGeneral
						.setNroGestorSeguimiento2(rs.getBigDecimal(13) != null ? rs
								.getBigDecimal(13)
								: new BigDecimal("0"));
				campGeneral
						.setNroConcSeguimiento2(rs.getBigDecimal(14) != null ? rs
								.getBigDecimal(14)
								: new BigDecimal("0"));
				campGeneral
						.setMontoSeguimiento2(rs.getBigDecimal(15) != null ? rs
								.getBigDecimal(15) : new BigDecimal("0"));
				campGeneral.setCodigoCampaniaDetalle(rs.getString(16));
				campGeneral.setOrden(rs.getString(17));
				listaCampanaDetalle.add(campGeneral);
			}

			log.info("[SessionUtilBean :: consultarCampaniasDetallesPGG] Fin");

			return listaCampanaDetalle;
		} catch (Exception e) {
			log.error("[SessionUtilBean :: consultarCampaniasDetallesPGG] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);

			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (cs != null) {
					cs.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log
						.error("[SessionUtilBean :: consultarCampaniasDetallesPGG] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

	}

	public Vector xBusAllTablaAccionesAntiguo(String mes, String anho) {
		Vector res = null;
		TAcciones bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: xBusAllTablaAccionesAntiguo] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log
						.info("[SessionUtilBean :: xBusAllTablaAccionesAntiguo] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaAccionesAntiguo] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log
						.info("[SessionUtilBean :: xBusAllTablaAccionesAntiguo] Fin");

				return null;
			}
			s = con.createStatement();

			String sql = "";

			if (anho.equals("2007") && mes.equals("05")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho>'" + anho + "' ";
			}

			if (anho.equals("2008") && mes.equals("05")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho<'" + anho + "' ";
			}
			if (anho.equals("2006") && mes.equals("06")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho<='" + anho + "' ";
			}
			if (anho.equals("2007") && mes.equals("06")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho='" + anho + "' ";
			}

			if (anho.equals("2008") && mes.equals("06")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho>='" + anho + "' ";
			}
			if (anho.equals("2006") && mes.equals("07")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho<='" + anho + "' ";
			}
			if (anho.equals("2007") && mes.equals("07")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho='" + anho + "'";
			}
			if (anho.equals("2008") && mes.equals("07")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho>='" + anho + "' ";
			}
			if (anho.equals("2006") && mes.equals("08")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho<='" + anho + "' ";
			}
			if (anho.equals("2007") && mes.equals("08")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho='" + anho + "'";
			}
			if (anho.equals("2008") && mes.equals("08")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho>='" + anho + "' ";
			}
			if (anho.equals("2006") && mes.equals("09")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho>'" + anho + "' ";
			}
			if (anho.equals("2007") && mes.equals("09")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho<'" + anho + "' ";
			}
			if (anho.equals("2006") && mes.equals("10")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho<='" + anho + "' ";
			}
			if (anho.equals("2007") && mes.equals("10")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho='" + anho + "'";
			}
			if (anho.equals("2008") && mes.equals("10")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho>='" + anho + "' ";
			}
			if (anho.equals("2006") && mes.equals("11")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho>'" + anho + "' ";
			}
			if (anho.equals("2007") && mes.equals("11")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho<'" + anho + "' ";
			}
			if (anho.equals("2006") && mes.equals("12")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho>'" + anho + "' ";
			}
			if (anho.equals("2007") && mes.equals("12")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "' and anho<'" + anho + "' ";
			}
			if (anho.equals("")) {
				sql = "select nombreaccion, codigogestor, mes, anho, nroclientes, compromisogestor, "
						+ "nrogestorseguimiento1, nroconcseguimiento1, montoseguimiento1, "
						+ "nrogestorseguimiento2, nroconcseguimiento2, montoseguimiento2, "
						+ "codigoacciones, codigooficina, codigoepigrafe, fecha_seg1, fecha_seg2, "
						+ "fecha_grabacion from tiigoacciones where mes='"
						+ mes + "'";
			}

			log.info("[SessionUtilBean :: xBusAllTablaAccionesAntiguo] SQL:"
					+ sql);

			rst = s.executeQuery(sql);

			while (rst.next()) {
				if (res == null)
					res = new Vector(0, 1);
				bean = new TAcciones();

				bean.setNombreAccion(rst.getString("nombreaccion"));
				bean.setCodigoGestor(rst.getString("codigogestor"));
				bean.setMes(rst.getString("mes"));
				bean.setAnho(rst.getString("anho"));
				bean.setNroClientes(rst.getInt("nroclientes"));
				bean.setCompromisoGestor(rst.getInt("compromisogestor"));
				bean.setNroGestorSeguimiento1(rst
						.getInt("nrogestorseguimiento1"));
				bean.setNroConcSeguimiento1(rst.getInt("nroconcseguimiento1"));
				bean.setMontoSeguimiento1(rst.getInt("montoseguimiento1"));
				bean.setNroGestorSeguimiento1(rst
						.getInt("nrogestorseguimiento2"));
				bean.setNroConcSeguimiento1(rst.getInt("nroconcseguimiento2"));
				bean.setMontoSeguimiento1(rst.getInt("montoseguimiento2"));
				bean.setCodigoAccion(rst.getString("codigoacciones"));
				bean.setCodigoOficina(rst.getString("codigooficina"));
				bean.setCodigoEpigrafe(rst.getString("codigoepigrafe"));
				bean.setFechaSeg1(rst.getDate("fecha_seg1"));
				bean.setFechaSeg2(rst.getDate("fecha_seg2"));
				bean.setFechaGrabacion(rst.getDate("fecha_grabacion"));
				res.add(bean);
			}

			log.info("[SessionUtilBean :: xBusAllTablaAccionesAntiguo] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaAccionesAntiguo] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaAccionesAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public Vector xBusAllTablaEpigrafesAntiguo() {
		Vector res = null;
		TEpigrafes bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log
					.info("[SessionUtilBean :: xBusAllTablaEpigrafesAntiguo] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log
						.info("[SessionUtilBean :: xBusAllTablaEpigrafesAntiguo] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaEpigrafesAntiguo] DATASOURCE_CONTEXT::: "
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log
						.info("[SessionUtilBean :: xBusAllTablaEpigrafesAntiguo] Fin");

				return null;
			}

			s = con.createStatement();

			String sql = "select codigoepigrafe, nombreepigrafe, anho, indicadorclase, "
					+ "indicadorsubclase, orden, indicadorgrupo, abreviatura, indicadorhijo, "
					+ "indicadorafecta from tiigoepigrafes";

			log.debug(sql);
			rst = s.executeQuery(sql);

			while (rst.next()) {
				if (res == null)
					res = new Vector(0, 1);
				bean = new TEpigrafes();

				bean.setCodigoepigrafe(rst.getString("codigoepigrafe"));
				bean.setNombreepigrafe(rst.getString("nombreepigrafe"));
				bean.setAnho(rst.getString("anho"));
				bean.setIndicadorclase(rst.getString("indicadorclase"));
				bean.setIndicadorsubclase(rst.getString("indicadorsubclase"));
				bean.setOrden(rst.getString("orden"));
				bean.setIndicadorgrupo(rst.getString("indicadorgrupo"));
				bean.setAbreviatura(rst.getString("abreviatura"));
				bean.setIndicadorhijo(rst.getString("indicadorhijo"));
				bean.setIndicadorafecta(rst.getString("indicadorafecta"));

				res.add(bean);
			}

			log.info("[SessionUtilBean :: xBusAllTablaEpigrafesAntiguo] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaEpigrafesAntiguo] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaEpigrafesAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public Vector xBusAllTablaTerritorioAntiguo() {
		Vector res = null;
		TTerritorio bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log
					.info("[SessionUtilBean :: xBusAllTablaTerritorioAntiguo] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log
						.info("[SessionUtilBean :: xBusAllTablaTerritorioAntiguo] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaTerritorioAntiguo] DATASOURCE_CONTEXT::: "
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log
						.info("[SessionUtilBean :: xBusAllTablaTerritorioAntiguo] Fin");

				return null;
			}

			s = con.createStatement();

			try {
				String sql = "select CODIGOTERRITORIO, NOMBRETERRITORIO from tiigoterritorio";

				log
						.info("[SessionUtilBean :: xBusAllTablaTerritorioAntiguo] SQL: "
								+ sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TTerritorio();

					bean.setCodigoTerritorio(rst.getString("CODIGOTERRITORIO"));
					bean.setNombreTerritorio(rst.getString("NOMBRETERRITORIO"));

					res.add(bean);
				}

			} catch (SQLException e) {
				log
						.error("[SessionUtilBean :: xBusAllTablaTerritorioAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaTerritorioAntiguo] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaTerritorioAntiguo] ");
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
				log
						.error("[SessionUtilBean :: xBusAllTablaTerritorioAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public String xDameTerritorio(String codigoOficina) {
		String territorio = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: xDameTerritorio] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xDameTerritorio] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xDameTerritorio] DATASOURCE_CONTEXT::: "
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xDameTerritorio] Fin");

				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select codigoterritorio from tiigooficinas where codigooficina='"
						+ codigoOficina + "'";

				log.info("[SessionUtilBean :: xDameTerritorio] SQL:" + sql);

				rst = s.executeQuery(sql);
				if (rst.next()) {
					territorio = rst.getString("codigoterritorio");
				}

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xDameTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xDameTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xDameTerritorio] ");
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
				log.error("[SessionUtilBean :: xDameTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return territorio;
	}

	public int xInsertarTAcciones(String codigoAccion, String nomberAccion,
			String codigoGestor, String mes, String anho, int nroClientes,
			int compromisoGestor, int nroGestorSeguimiento1,
			int nroConcSeguimiento1, int montoSeguimiento1,
			int nroGestorSeguimiento2, int nroConcSeguimiento2,
			int montoSeguimiento2, String codigoOficina, String codigoEpigrafe,
			Date fechaSeg1, Date fechaSeg2, Date fechaGrabacion,
			String codTerritorio) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTAcciones] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTAcciones] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTAcciones] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTAcciones] Fin");

				return 0;
			}
			int codAccion = Integer.parseInt(codigoAccion);
			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_ACCIONES (COD_ACCI, COD_EPIGRAFE, ANHO, COD_TERR, "
						+ "COD_OFIC, NOM_ACCI, COD_GEST, MES_ACCI, NRO_CLIE, COMP_GEST, "
						+ "NRO_GEST_SEGU_1, NRO_CONC_SEGU_1, MON_SEGU_1, NRO_GEST_SEGU_2, "
						+ "NRO_CONC_SEGU_2, MON_SEGU_2, FEC_SEGU_1, FEC_SEGU_2, FEC_REGI) "
						+ "VALUES " + "('"
						+ codAccion
						+ "', '"
						+ codigoEpigrafe
						+ "', '"
						+ anho
						+ "', '"
						+ codTerritorio
						+ "', "
						+ "'"
						+ codigoOficina
						+ "', '"
						+ nomberAccion
						+ "', '"
						+ codigoGestor
						+ "', '"
						+ mes
						+ "', '"
						+ nroClientes
						+ "', "
						+ "'"
						+ compromisoGestor
						+ "', '"
						+ nroGestorSeguimiento1
						+ "', '"
						+ nroConcSeguimiento1
						+ "', '"
						+ montoSeguimiento1
						+ "', '"
						+ nroGestorSeguimiento2
						+ "', '"
						+ nroConcSeguimiento2
						+ "', '"
						+ montoSeguimiento2
						+ "',"
						+ " TO_DATE('"
						+ (fechaSeg1 == null ? "" : utilDateToString(fechaSeg1,
								"yyyy/MM/dd"))
						+ "', 'YYYY/MM/DD'), "
						+ "TO_DATE('"
						+ (fechaSeg2 == null ? "" : utilDateToString(fechaSeg2,
								"yyyy/MM/dd"))
						+ "', 'YYYY/MM/DD'), TO_DATE('"
						+ (fechaGrabacion == null ? "" : utilDateToString(
								fechaGrabacion, "yyyy/MM/dd"))
						+ "', 'YYYY/MM/DD'))";

				log.info("[SessionUtilBean :: xInsertarTAcciones] SQL:" + sql);

				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTAcciones] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTAcciones] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTAcciones] ");
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
				log.error("[SessionUtilBean :: xInsertarTAcciones] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public String utilDateToString(java.util.Date sqlDateFecha, String pattern) {
		String str = null;

		log.info("[SessionUtilBean :: utilDateToString] Inicio");

		if (sqlDateFecha != null) {
			if (pattern == null) {
				pattern = "dd/MM/yyyy";
			}
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			str = formatter.format(sqlDateFecha);
		}

		log.info("[SessionUtilBean :: utilDateToString] Fin");

		return str;
	}

	public int xInsertarTEpigrafes(String codigoepigrafe,
			String nombreepigrafe, String anho, String indicadorclase,
			String indicadorsubclase, String orden, String indicadorgrupo,
			String abreviatura, String indicadorhijo, String indicadorafecta) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTEpigrafes] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTEpigrafes] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTEpigrafes] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTEpigrafes] Fin");

				return 0;
			}
			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_EPIGRAFE (COD_EPIGRAFE, NOM_EPIGRAFE, ANHO, IND_CLASE, IND_SUB_CLASE, ORDEN, IND_GRUPO, ABREVIATURA, IND_HIJO, IND_AFECTA) "
						+ "VALUES "
						+ "('"
						+ codigoepigrafe
						+ "', '"
						+ nombreepigrafe
						+ "', '"
						+ anho
						+ "', '"
						+ indicadorclase
						+ "', '"
						+ indicadorclase
						+ "', '"
						+ orden
						+ "', '"
						+ indicadorgrupo
						+ "', '"
						+ abreviatura
						+ "', '"
						+ indicadorhijo
						+ "', '"
						+ indicadorafecta + "')";

				log.info("[SessionUtilBean :: xInsertarTEpigrafes] SQL:" + sql);
				// indicador = s.executeUpdate(sql);

				boolean rpta = s.execute(sql);
				if (rpta) {
					indicador = 1;
				} else {
					indicador = 0;
				}

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTEpigrafes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTEpigrafes] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTEpigrafes] ");
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
				log.error("[SessionUtilBean :: xInsertarTEpigrafes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public int xInsertarTTerritorio(String codigoTerritorio,
			String nombreTerritorio) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTTerritorio] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTTerritorio] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTTerritorio] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return 0;
			}
			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_TERRITORIO (COD_TERR, NOM_TERR) "
						+ "VALUES " + "('" + codigoTerritorio + "', '"
						+ nombreTerritorio + "')";

				log.debug(sql);
				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
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
				log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaOficinaAntiguo() {
		Vector res = null;
		TOficina bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: xBusAllTablaOficinaAntiguo] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xBusAllTablaOficinaAntiguo] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaOficinaAntiguo] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xBusAllTablaOficinaAntiguo] Fin");

				return null;
			}
			s = con.createStatement();
			try {
				String sql = "select CODIGOOFICINA, NOMBREOFICINA, CODIGOTERRITORIO from tiigooficinas";

				log.info("[SessionUtilBean :: xBusAllTablaOficinaAntiguo] SQL:"
						+ sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TOficina();
					bean.setCodigoOficina(rst.getString("CODIGOOFICINA"));
					bean.setNombreOficina(rst.getString("NOMBREOFICINA"));
					bean.setCodigoTerritorio(rst.getString("CODIGOTERRITORIO"));

					res.add(bean);
				}

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xBusAllTablaOficinaAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaOficinaAntiguo] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaOficinaAntiguo] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaOficinaAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTOficina(String codigoTerritorio, String nombreOficina,
			String codigoOficina) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTOficina] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTOficina] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTOficina] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTOficina] Fin");

				return 0;
			}
			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_OFICINA (COD_OFIC, COD_TERR, NOM_OFIC) "
						+ "VALUES "
						+ "('"
						+ codigoOficina
						+ "', '"
						+ codigoTerritorio + "', '" + nombreOficina + "')";

				log.info("[SessionUtilBean :: xInsertarTOficina] SQL:" + sql);
				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTOficina] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTOficina] ");
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
				log.error("[SessionUtilBean :: xInsertarTOficina] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaCampanhasAntiguo(String anho) {
		Vector res = null;
		TCampanhas bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log
					.info("[SessionUtilBean :: xBusAllTablaCampanhasAntiguo] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log
						.info("[SessionUtilBean :: xBusAllTablaCampanhasAntiguo] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaCampanhasAntiguo] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log
						.info("[SessionUtilBean :: xBusAllTablaCampanhasAntiguo] Fin");

				return null;
			}
			s = con.createStatement();
			try {
				String sql = "";

				if (anho.equals("2005")) {

					sql = "select CODIGOCAMPANIA, ANHO, MES, NOMBRECAMPANIA, CODIGOOFICINA, "
							+ "CODIGOGESTOR, ORDEN, GTE, FECHA_GRABACION from tiigocampanias where "
							+ " anho<='" + anho + "'";
				}

				if (anho.equals("2006")) {

					sql = "select CODIGOCAMPANIA, ANHO, MES, NOMBRECAMPANIA, CODIGOOFICINA, "
							+ "CODIGOGESTOR, ORDEN, GTE, FECHA_GRABACION from tiigocampanias where "
							+ " anho='" + anho + "'";
				}
				if (anho.equals("2007")) {

					sql = "select CODIGOCAMPANIA, ANHO, MES, NOMBRECAMPANIA, CODIGOOFICINA, "
							+ "CODIGOGESTOR, ORDEN, GTE, FECHA_GRABACION from tiigocampanias where "
							+ " anho>='" + anho + "'";
				}

				log
						.info("[SessionUtilBean :: xBusAllTablaCampanhasAntiguo] SQL:"
								+ sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TCampanhas();
					bean.setCodigoCampania(rst.getString("CODIGOCAMPANIA"));
					bean.setAnho(rst.getString("ANHO"));
					bean.setMes(rst.getString("MES"));
					bean.setNombreCampania(rst.getString("NOMBRECAMPANIA"));
					bean.setCodigoOficina(rst.getString("CODIGOOFICINA"));
					bean.setCodigoGestor(rst.getString("CODIGOGESTOR"));
					bean.setOrden(rst.getString("ORDEN"));
					bean.setGte(rst.getString("GTE"));
					bean.setFechaGrabacion(rst.getDate("FECHA_GRABACION"));

					res.add(bean);
				}

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xBusAllTablaCampanhasAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaCampanhasAntiguo] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaCampanhasAntiguo] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaCampanhasAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTCampanhas(String codigoCampania, String anho,
			String mes, String nombreCampania, String codigoOficina,
			String codigoGestor, String orden, String gte, Date fechaGrabacion,
			String codigoTerritorio) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTCampanhas] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTCampanhas] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTCampanhas] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTCampanhas] Fin");

				return 0;
			}
			int codCampania = Integer.parseInt(codigoCampania);
			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_CAMPANIAS (COD_CAMP, COD_OFIC, COD_TERR, ANHO, MES, "
						+ "NOM_CAMP, COD_GEST, ORDEN, GTE, FEC_REGI) "
						+ "VALUES " + "('"
						+ codCampania
						+ "', '"
						+ codigoOficina
						+ "', '"
						+ codigoTerritorio
						+ "', '"
						+ anho
						+ "', '"
						+ mes
						+ "', "
						+ "'"
						+ nombreCampania
						+ "', '"
						+ codigoGestor
						+ "', '"
						+ orden
						+ "', '"
						+ gte
						+ "', "
						+ "TO_DATE('"
						+ (fechaGrabacion == null ? "" : utilDateToString(
								fechaGrabacion, "yyyy/MM/dd"))
						+ "', 'YYYY/MM/DD'))";

				log.info("[SessionUtilBean :: xInsertarTCampanhas] SQL:" + sql);
				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTCampanhas] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTCampanhas] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTCampanhas] ");
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
				log.error("[SessionUtilBean :: xInsertarTCampanhas] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaCampanhasDetalleAntiguo() {
		Vector res = null;
		TCampanhasDetalle bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log
					.info("[SessionUtilBean :: xBusAllTablaCampanhasDetalleAntiguo] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log
						.info("[SessionUtilBean :: xBusAllTablaCampanhasDetalleAntiguo] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaCampanhasDetalleAntiguo] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log
						.info("[SessionUtilBean :: xBusAllTablaCampanhasDetalleAntiguo] Fin");

				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select nombrecampania, codigogestor, mes, anho, nroclientes, "
						+ "compromisogestor, nrogestorseguimiento1, nroconcseguimiento1, "
						+ "montoseguimiento1, nrogestorseguimiento2, nroconcseguimiento2, "
						+ "montoseguimiento2, codigocampaniadetalle, codigooficina, codigocampania, "
						+ "fecha_grabacion, fecha_seg1, fecha_seg2 from tiigocampaniasdetalle";

				log
						.info("[SessionUtilBean :: xBusAllTablaCampanhasDetalleAntiguo] SQL:"
								+ sql);

				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TCampanhasDetalle();
					bean.setNombreCampanha(rst.getString("nombrecampania"));
					bean.setCodigoGestor(rst.getString("codigogestor"));
					bean.setMes(rst.getString("MES"));
					bean.setAnho(rst.getString("anho"));
					bean.setNroClientes(rst.getInt("nroclientes"));
					bean.setCompromisoGestor(rst.getInt("compromisogestor"));
					bean.setNroGestorSeguimiento1(rst
							.getInt("nrogestorseguimiento1"));
					bean.setNroConcSeguimiento1(rst
							.getInt("nroconcseguimiento1"));
					bean.setMontoSeguimiento1(rst.getInt("montoseguimiento1"));
					bean.setNroGestorSeguimiento2(rst
							.getInt("nrogestorseguimiento2"));
					bean.setNroConcSeguimiento2(rst
							.getInt("nroconcseguimiento2"));
					bean.setMontoSeguimiento2(rst.getInt("montoseguimiento2"));
					bean.setCodigoCampanhaDetalle(rst
							.getString("codigocampaniadetalle"));
					bean.setCodigoOficina(rst.getString("codigooficina"));
					bean.setCodigoCampanha(rst.getString("codigocampania"));
					bean.setFechaGrabacion(rst.getDate("fecha_grabacion"));
					bean.setFechaSeg1(rst.getDate("fecha_seg1"));
					bean.setFechaSeg2(rst.getDate("fecha_seg2"));

					res.add(bean);
				}
			} catch (SQLException e) {
				log
						.error("[SessionUtilBean :: xBusAllTablaCampanhasDetalleAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaCampanhasDetalleAntiguo] Fin");
		} catch (Exception e) {
			log
					.error("[SessionUtilBean :: xBusAllTablaCampanhasDetalleAntiguo] ");
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
				log
						.error("[SessionUtilBean :: xBusAllTablaCampanhasDetalleAntiguo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTCampanhasDetalle(String codigoCampanhaDetalle,
			String nombreCampanha, String codigoGestor, String mes,
			String anho, int nroClientes, int compromisoGestor,
			int nroGestorSeguimiento1, int nroConcSeguimiento1,
			int montoSeguimiento1, int nroGestorSeguimiento2,
			int nroConcSeguimiento2, int montoSeguimiento2,
			String codigoOficina, String codigoCampanha, Date fechaGrabacion,
			Date fechaSeg1, Date fechaSeg2, String codigoTerritorio) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTCampanhasDetalle] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTCampanhasDetalle] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTCampanhasDetalle] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTCampanhasDetalle] Fin");

				return 0;
			}
			int codCampanhaDetalle = Integer.parseInt(codigoCampanhaDetalle);
			int codCampanha = Integer.parseInt(codigoCampanha);
			s = con.createStatement();
			String sql = "";

			try {
				sql = "INSERT INTO TIIDO_CAMPANIAS_DETALLE (COD_CAMP_DETA, COD_TERR, "
						+ "COD_OFIC, COD_CAMP, MES, ANHO, NOM_CAMP, COD_GEST, "
						+ "NRO_CLIE, COMP_GEST, NRO_GEST_SEGU_1, NRO_CONC_SEGU_1, "
						+ "MONT_SEGU_1, NRO_GEST_SEGU_2, NRO_CONC_SEGU_2, MONT_SEGU_2, "
						+ "FEC_REGI, FEC_SEGU_1, FEC_SEGU_2) "
						+ "VALUES "
						+ "('"
						+ codCampanhaDetalle
						+ "', '"
						+ codigoTerritorio
						+ "', '"
						+ codigoOficina
						+ "', '"
						+ codCampanha
						+ "', '"
						+ mes
						+ "', "
						+ "'"
						+ anho
						+ "', '"
						+ nombreCampanha
						+ "', '"
						+ codigoGestor
						+ "', '"
						+ nroClientes
						+ "', "
						+ "'"
						+ compromisoGestor
						+ "', '"
						+ nroGestorSeguimiento1
						+ "', '"
						+ nroConcSeguimiento1
						+ "', "
						+ "'"
						+ montoSeguimiento1
						+ "', '"
						+ nroGestorSeguimiento2
						+ "', '"
						+ nroConcSeguimiento2
						+ "', "
						+ "'"
						+ montoSeguimiento2
						+ "', TO_DATE('"
						+ (fechaGrabacion == null ? "" : utilDateToString(
								fechaGrabacion, "yyyy/MM/dd"))
						+ "', 'YYYY/MM/DD'), "
						+ "TO_DATE('"
						+ (fechaSeg1 == null ? "" : utilDateToString(fechaSeg1,
								"yyyy/MM/dd"))
						+ "', 'YYYY/MM/DD'), TO_DATE('"
						+ (fechaSeg2 == null ? "" : utilDateToString(fechaSeg2,
								"yyyy/MM/dd")) + "', 'YYYY/MM/DD'))";

				log.info("[SessionUtilBean :: xInsertarTCampanhasDetalle] SQL:"
						+ sql);

				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTCampanhasDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTCampanhasDetalle] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTCampanhasDetalle] ");
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
				log.error("[SessionUtilBean :: xInsertarTCampanhasDetalle] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaEquivalencias() {
		Vector res = null;
		TEquivalencias bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: xBusAllTablaEquivalencias] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xBusAllTablaEquivalencias] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaEquivalencias] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xBusAllTablaEquivalencias] Fin");

				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select codigocargo, codigoperfil from tiigoequivalencias";

				log.debug(sql);
				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TEquivalencias();
					bean.setCodigoCargo(rst.getString("codigocargo"));
					bean.setCodigoPerfil(rst.getString("codigoperfil"));

					res.add(bean);
				}
			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xBusAllTablaEquivalencias] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaEquivalencias] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaEquivalencias] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaEquivalencias] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTEquivalencias(String codigoCargo, String codigoPerfil) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTEquivalencias] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTEquivalencias] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTEquivalencias] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTEquivalencias] Fin");

				return 0;
			}
			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_EQUIVALENCIAS (COD_CAR, COD_PER) VALUES "
						+ "('" + codigoCargo + "', '" + codigoPerfil + "')";

				log.info("[SessionUtilBean :: xInsertarTEquivalencias] SQL:"
						+ sql);
				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTEquivalencias] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTEquivalencias] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTEquivalencias] ");
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
				log.error("[SessionUtilBean :: xInsertarTEquivalencias] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaPerfiles() {
		Vector res = null;
		TPerfiles bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xBusAllTablaPerfiles] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xBusAllTablaPerfiles] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaPerfiles] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xBusAllTablaPerfiles] Fin");

				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select codigoperfil, nombreperfil from tiigoperfiles";

				log
						.info("[SessionUtilBean :: xBusAllTablaPerfiles] SQL:"
								+ sql);

				ResultSet rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TPerfiles();
					bean.setCodigoPerfil(rst.getString("codigoperfil"));
					bean.setNombrePerfil(rst.getString("nombreperfil"));

					res.add(bean);
				}
			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xBusAllTablaPerfiles] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaPerfiles] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaPerfiles] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaPerfiles] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTPerfiles(String codigoPerfil, String nombrePerfil) {
		int indicador = 0;
		Context initialContext = null;
		Connection con = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTPerfiles] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTPerfiles] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTPerfiles] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTPerfiles] Fin");

				return 0;
			}
			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_PERFILES (COD_PERFIL, NOM_PERFIL) VALUES ('"
						+ codigoPerfil + "', '" + nombrePerfil + "')";

				log.info("[SessionUtilBean :: xInsertarTPerfiles] SQL:" + sql);

				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTPerfiles] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
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
				log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaFirmas() {
		Vector res = null;
		TFirmas bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: xBusAllTablaFirmas] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xBusAllTablaFirmas] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaFirmas] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xBusAllTablaFirmas] Fin");

				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select anho, mes, item, codigogestor, codigooficina, descripcion, fecha from tiigofirmas";

				log.info("[SessionUtilBean :: xBusAllTablaFirmas] SQL:" + sql);

				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TFirmas();
					bean.setAnho(rst.getString("anho"));
					bean.setMes(rst.getString("mes"));
					bean.setItem(rst.getString("item"));
					bean.setCodigoGestor(rst.getString("codigogestor"));
					bean.setCodigoOficina(rst.getString("codigooficina"));
					bean.setDescripcion(rst.getString("descripcion"));
					bean.setFecha(rst.getDate("fecha"));

					res.add(bean);
				}
			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xBusAllTablaFirmas] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaFirmas] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaFirmas] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaFirmas] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTFirmas(String anho, String mes, String item,
			String codigoGestor, String codigoOficina, String descripcion,
			Date fecha) {

		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTFirmas] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTFirmas] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTFirmas] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTFirmas] Fin");

				return 0;
			}
			s = con.createStatement();
			try {
				String sql = "";

				log.info("[SessionUtilBean :: xInsertarTFirmas] SQL:" + sql);

				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTFirmas] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
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
				log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaMaestroPlanes(String contadorMes) {
		Vector res = null;
		TMaestroPlanes bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: xBusAllTablaMaestroPlanes] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xBusAllTablaMaestroPlanes] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaMaestroPlanes] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xBusAllTablaMaestroPlanes] Fin");

				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select codigooficina, mes, anho, codigoterritorio, prioridad, "
						+ "fecha_grabacion from tiigomaestroplanes where mes='"
						+ contadorMes + "'";

				log.info("[SessionUtilBean :: xBusAllTablaMaestroPlanes] SQL:"
						+ sql);

				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TMaestroPlanes();
					bean.setCodigoOficina(rst.getString("codigooficina"));
					bean.setMes(rst.getString("mes"));
					bean.setAnho(rst.getString("anho"));
					bean.setCodigoTerritorio(rst.getString("codigoterritorio"));
					bean.setPrioridad(rst.getString("prioridad"));
					bean.setFechaGrabacion(rst.getDate("fecha_grabacion"));

					res.add(bean);
				}
			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xBusAllTablaMaestroPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaMaestroPlanes] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaMaestroPlanes] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaMaestroPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTMaestroPlanes(String codigoOficina, String mes,
			String anho, String codigoTerritorio, String prioridad,
			Date fechaGrabacion) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTMaestroPlanes] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTMaestroPlanes] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTMaestroPlanes] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTMaestroPlanes] Fin");

				return 0;
			}
			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_MAESTRO_PLANES (MES, ANHO, COD_TERR, COD_OFIC, PRIORIDAD, FEC_GRAB) VALUES ('"
						+ mes
						+ "', '"
						+ anho
						+ "', '"
						+ codigoTerritorio
						+ "', '"
						+ codigoOficina
						+ "', '"
						+ prioridad
						+ "', TO_DATE('"
						+ (fechaGrabacion == null ? "" : utilDateToString(
								fechaGrabacion, "yyyy/MM/dd"))
						+ "', 'YYYY/MM/DD'))";

				log.info("[SessionUtilBean :: xInsertarTMaestroPlanes] SQL:"
						+ sql);

				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTMaestroPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTMaestroPlanes] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTMaestroPlanes] ");
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
				log.error("[SessionUtilBean :: xInsertarTMaestroPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaMetasGestor(String contadorMes) {
		Vector res = null;
		TMetasGestor bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: xBusAllTablaMetasGestor] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xBusAllTablaMetasGestor] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaMetasGestor] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xBusAllTablaMetasGestor] Fin");

				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select CODIGOMETAGESTOR, CODIGOEPIGRAFE, CODIGOOFICINA, CODIGOGESTOR, "
						+ "ANHO, MES, ORDEN, FECHA_GRABACION, PORC_ASIGNADO, NOMBREEPIGRAFE, "
						+ "NOMBREGESTOR from tiigometasgestor where mes='"
						+ contadorMes + "'";

				log.info("[SessionUtilBean :: xBusAllTablaMetasGestor] SQL:"
						+ sql);

				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TMetasGestor();
					bean.setCodigoMetaGestor(rst.getString("CODIGOMETAGESTOR"));
					bean.setCodigoEpigrafe(rst.getString("CODIGOEPIGRAFE"));
					bean.setCodigoOficina(rst.getString("CODIGOOFICINA"));
					bean.setCodigoGestor(rst.getString("CODIGOGESTOR"));
					bean.setAnho(rst.getString("ANHO"));
					bean.setMes(rst.getString("MES"));
					bean.setOrden(rst.getString("ORDEN"));
					bean.setFecgaGrabacion(rst.getDate("FECHA_GRABACION"));
					bean.setPorcAsignado(rst.getString("PORC_ASIGNADO"));
					bean.setNombreEpigrafe(rst.getString("NOMBREEPIGRAFE"));
					bean.setNombreGestor(rst.getString("NOMBREGESTOR"));

					res.add(bean);
				}
			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaMetasGestor] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
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
				log.error("[SessionUtilBean :: xInsertarTTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTMetasGestor(String codigoMetaGestor,
			String codigoEpigrafe, String codigoOficina, String codigoGestor,
			String anho, String mes, String orden, Date fechaGrabacion,
			String porcAsignado, String nombreEpigrafe, String nombreGestor,
			String codigoTerritorio) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTMetasGestor] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTMetasGestor] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTMetasGestor] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTMetasGestor] Fin");

				return 0;
			}
			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_METAS_GESTOR "
						+ "(COD_META_GESTOR, COD_TERR, COD_OFIC, COD_EPIGRAFE, ANHO, COD_GESTOR, "
						+ "MES, ORDEN, FEC_REGI, PORC_ASIG, NOM_EPIGRAFE, NOM_GESTOR) "
						+ "VALUES " + "('"
						+ codigoMetaGestor
						+ "', '"
						+ codigoTerritorio
						+ "', '"
						+ codigoOficina
						+ "', '"
						+ codigoEpigrafe
						+ "', '"
						+ anho
						+ "', '"
						+ codigoGestor
						+ "', "
						+ "'"
						+ mes
						+ "', '"
						+ orden
						+ "', TO_DATE('"
						+ (fechaGrabacion == null ? "" : utilDateToString(
								fechaGrabacion, "yyyy/MM/dd"))
						+ "', 'YYYY/MM/DD'), to_number(replace(('"
						+ porcAsignado
						+ "'),'.',',')), '"
						+ nombreEpigrafe
						+ "', " + "'" + nombreGestor + "')";

				log.info("[SessionUtilBean :: xInsertarTMetasGestor] SQL:"
						+ sql);

				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTMetasGestor] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTMetasGestor] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTMetasGestor] ");
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
				log.error("[SessionUtilBean :: xInsertarTMetasGestor] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaParametros() {
		Vector res = null;
		TParametros bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: xBusAllTablaParametros] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xBusAllTablaParametros] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaParametros] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xBusAllTablaParametros] Fin");

				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select FECHAACCION, FECHASEGUIMIENTO1, FECHASEGUIMIENTO2, "
						+ "AFECTAACCION, AFECTASEGUIMIENTO, AFECTAPLANIFICACION, "
						+ "FECHAPLANIFICACION from tiigoparametros ";

				log.info("[SessionUtilBean :: xBusAllTablaParametros] SQL:"
						+ sql);

				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TParametros();
					bean.setFechaAccion(rst.getDate("FECHAACCION"));
					bean.setFechaSeguimiento1(rst.getDate("FECHASEGUIMIENTO1"));
					bean.setFechaSeguimiento2(rst.getDate("FECHASEGUIMIENTO2"));
					bean.setAfectaAccion(rst.getString("AFECTAACCION"));
					bean.setAfectaSeguimiento(rst
							.getString("AFECTASEGUIMIENTO"));
					bean.setAfectaPlanificacion(rst
							.getString("AFECTAPLANIFICACION"));
					bean.setFechaPlanificacion(rst
							.getDate("FECHAPLANIFICACION"));

					res.add(bean);
				}
			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xBusAllTablaParametros] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaParametros] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaParametros] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaParametros] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTParametros(Date fechaAccion, Date fechaSeguimiento1,
			Date fechaSeguimiento2, String afectaAccion,
			String afectaSeguimiento, String afectaPlanificacion,
			Date fechaPlanificacion) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTParametros] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTParametros] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTParametros] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTParametros] Fin");

				return 0;
			}

			s = con.createStatement();
			try {
				String sql = "";

				log
						.info("[SessionUtilBean :: xInsertarTParametros] SQL:"
								+ sql);

				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTParametros] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTParametros] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTParametros] ");
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
				log.error("[SessionUtilBean :: xInsertarTParametros] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public Vector xBusAllTablaPlanes(String mes, String anho) {
		Vector res = null;
		TPlanes bean = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: xBusAllTablaPlanes] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xBusAllTablaPlanes] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: xBusAllTablaPlanes] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT_ANTIGUO);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xBusAllTablaPlanes] Fin");

				return null;
			}

			s = con.createStatement();
			String indicadorInsert = anho.substring(4);
			anho = anho.substring(0, 4);
			try {
				String sql = "";
				if (indicadorInsert.equals("1")) {

					if (anho.equals("2005")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho<='"
								+ anho
								+ "' and monto<='10000'";
					}
					if (anho.equals("2006")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho='"
								+ anho
								+ "' and monto<='10000'";
					}
					if (anho.equals("2007")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho='"
								+ anho
								+ "' and monto<='10000'";
					}
					if (anho.equals("2008")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho='"
								+ anho
								+ "' and monto<='10000'";
					}
					if (anho.equals("2009")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho>='"
								+ anho
								+ "' and monto<='10000'";
					}
				} else {
					if (anho.equals("2005")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho<='"
								+ anho
								+ "' and monto>'10000'";
					}
					if (anho.equals("2006")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho='"
								+ anho
								+ "' and monto>'10000'";
					}
					if (anho.equals("2007")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho='"
								+ anho
								+ "' and monto>'10000'";
					}
					if (anho.equals("2008")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho='"
								+ anho
								+ "' and monto>'10000'";
					}
					if (anho.equals("2009")) {
						sql = "select CODIGOOFICINA, MES, ANHO, CODIGOEPIGRAFE, NOMBREEPIGRAFE, PESODOR, MONTO, PORCALCANZADO, DESVPPTO, NROMESESFALT, "
								+ "PROYCRECMENSUAL, AJUSTEESTIMADOTERR, PROYAJUSTEMENSUAL, SALDOMEDIOJUNIO, PORCSALDOMEDIOJUNIO, SALDODICIEMBREANTERIOR, "
								+ "SALDOMEDIODICIEMBRE, CODIGOTERRITORIO, PORCSALDOMEDIODICIEMBRE, FACTORAJUSTESALDOPUNTUAL, HISTORICOBAJAS, "
								+ "METAMESSALDOPUNTUAL, METAGERENTEOFICINA, PRIORIDAD, MESEVALUACION, INDICADORDOR, VAR_MES, AJUSTE_PSPTO, "
								+ "DESV_PSPTO_AJUSTADO, FACT_AJUST_TERRITORIAL, FACT_ASIGN_GTE_OF from tiigoplanes where mes='"
								+ mes
								+ "' and anho>='"
								+ anho
								+ "' and monto>'10000'";
					}
				}

				log.info("[SessionUtilBean :: xBusAllTablaPlanes] SQL:" + sql);

				rst = s.executeQuery(sql);

				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new TPlanes();
					bean.setCodigoOficina(rst.getString("CODIGOOFICINA"));
					bean.setMes(rst.getString("MES"));
					bean.setAnho(rst.getString("ANHO"));
					bean.setCodigoEpigrafe(rst.getString("CODIGOEPIGRAFE"));
					bean.setNombreEpigrafe(rst.getString("NOMBREEPIGRAFE"));
					bean.setPesodor(rst.getInt("PESODOR"));
					bean.setMonto(rst.getInt("MONTO"));
					bean.setPorcAlcanzado(rst.getInt("PORCALCANZADO"));
					bean.setDesvpPto(rst.getInt("DESVPPTO"));
					bean.setNroMesesFalt(rst.getInt("NROMESESFALT"));
					bean.setProyCrecMensual(rst.getInt("PROYCRECMENSUAL"));
					bean
							.setAjusteEstimadoTerr(rst
									.getInt("AJUSTEESTIMADOTERR"));
					bean.setProyAjusteMensual(rst.getInt("PROYAJUSTEMENSUAL"));
					bean.setSaldoMedioJunio(rst.getInt("SALDOMEDIOJUNIO"));
					bean.setPorcSaldoMedioJunio(rst
							.getInt("PORCSALDOMEDIOJUNIO"));
					bean.setSaldoDiciembreAnterior(rst
							.getInt("SALDODICIEMBREANTERIOR"));
					bean.setSaldoMedioDiciembre(rst
							.getInt("SALDOMEDIODICIEMBRE"));
					bean.setCodigoTerritorio(rst.getString("CODIGOTERRITORIO"));
					bean.setPorcSaldoMedioDiciembre(rst
							.getInt("PORCSALDOMEDIODICIEMBRE"));
					bean.setFactorAjusteSaldoPuntual(rst
							.getInt("FACTORAJUSTESALDOPUNTUAL"));
					bean.setHistoricoBajas(rst.getInt("HISTORICOBAJAS"));
					bean.setMetaMesSaldoPuntual(rst
							.getInt("METAMESSALDOPUNTUAL"));
					bean
							.setMetaGerenteOficina(rst
									.getInt("METAGERENTEOFICINA"));
					bean.setPrioridad(rst.getInt("PRIORIDAD"));
					bean.setMesEvaluacion(rst.getString("MESEVALUACION"));
					bean.setIndicadorDor(rst.getString("INDICADORDOR"));
					bean.setVarMes(rst.getInt("VAR_MES"));
					bean.setAjustePspto(rst.getInt("AJUSTE_PSPTO"));
					bean
							.setDesvPsptoAjustado(rst
									.getInt("DESV_PSPTO_AJUSTADO"));
					bean.setFactAjustTerritorial(rst
							.getInt("FACT_AJUST_TERRITORIAL"));
					bean.setFactAsignGteOf(rst.getInt("FACT_ASIGN_GTE_OF"));
					res.add(bean);
				}
			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xBusAllTablaPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xBusAllTablaPlanes] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xBusAllTablaPlanes] ");
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
				log.error("[SessionUtilBean :: xBusAllTablaPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public int xInsertarTPlanes(String codigoOficina, String mes, String anho,
			String codigoEpigrafe, String nombreEpigrafe, int pesodor,
			int monto, int porcAlcanzado, int desvpPto, int nroMesesFalt,
			int proyCrecMensual, int ajusteEstimadoTerr, int proyAjusteMensual,
			int saldoMedioJunio, int porcSaldoMedioJunio,
			int saldoDiciembreAnterior, int saldoMedioDiciembre,
			String codigoTerritorio, int porcSaldoMedioDiciembre,
			int factorAjusteSaldoPuntual, int historicoBajas,
			int metaMesSaldoPuntual, int metaGerenteOficina, int prioridad,
			String mesEvaluacion, String indicadorDor, int varMes,
			int ajustePspto, int desvPsptoAjustado, int factAjustTerritorial,
			int factAsignGteOf) {

		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: xInsertarTPlanes] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: xInsertarTPlanes] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: xInsertarTPlanes] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: xInsertarTPlanes] Fin");

				return 0;
			}

			s = con.createStatement();
			String sql = "";
			try {
				sql = "INSERT INTO TIIDO_PLANES (COD_OFIC, COD_TERR, MES_PLAN, ANHO_PLAN, COD_EPIGRAFE, NOM_EPIGRAFE, "
						+ "PESO_DOR, MONTO, PORC_ALCANZADO, DESV_PPTO, NRO_MESES_FALT, PROY_CREC_MEN, AJUSTE_ESTIMADO_TERR, "
						+ "PROY_AJUSTE_MEN, SALDMEDI_JUNIO, PORC_SALDMEDI_JUNIO, SALD_DIC_ANTE, SALDMEDI_DIC, COD_TERRI, "
						+ "PORC_SALDMEDI_DIC, FAC_AJU_SAL_PUN, HIST_BAJAS, MET_MESSALD_PUNT, "
						+ "MET_GER_OFI, PRIORIDAD, MES_EVAL, IND_DOR, VAR_MES, AJUS_PPTO, DESV_PPTO_AJUS, "
						+ "FACT_AJUS_TERRI, FACT_ASIG_GTE_OF) "
						+ "VALUES "
						+ "('"
						+ codigoOficina
						+ "', '"
						+ codigoTerritorio
						+ "', '"
						+ mes
						+ "', '"
						+ anho
						+ "', '"
						+ codigoEpigrafe
						+ "', '"
						+ nombreEpigrafe
						+ "', "
						+ "'"
						+ pesodor
						+ "', '"
						+ monto
						+ "', '"
						+ porcAlcanzado
						+ "', '"
						+ desvpPto
						+ "', '"
						+ nroMesesFalt
						+ "', '"
						+ proyCrecMensual
						+ "', '"
						+ ajusteEstimadoTerr
						+ "', "
						+ "'"
						+ proyAjusteMensual
						+ "', '"
						+ saldoMedioJunio
						+ "', '"
						+ porcSaldoMedioJunio
						+ "', '"
						+ saldoDiciembreAnterior
						+ "', '"
						+ saldoMedioDiciembre
						+ "', '"
						+ codigoTerritorio
						+ "', "
						+ "'"
						+ porcSaldoMedioDiciembre
						+ "', '"
						+ factorAjusteSaldoPuntual
						+ "', '"
						+ historicoBajas
						+ "', '"
						+ metaMesSaldoPuntual
						+ "', "
						+ "'"
						+ metaGerenteOficina
						+ "', '"
						+ prioridad
						+ "', '"
						+ mesEvaluacion
						+ "', '"
						+ indicadorDor
						+ "', '"
						+ varMes
						+ "', '"
						+ ajustePspto
						+ "', '"
						+ desvPsptoAjustado
						+ "', "
						+ "'"
						+ factAjustTerritorial + "', '" + factAsignGteOf + "')";

				log.info("[SessionUtilBean :: xInsertarTPlanes] SQL:" + sql);

				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: xInsertarTPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: xInsertarTPlanes] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: xInsertarTPlanes] ");
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
				log.error("[SessionUtilBean :: xInsertarTPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public int actualizarEstadoFlag(String flag) {
		int indicador = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;

		try {
			log.info("[SessionUtilBean :: actualizarEstadoFlag] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: actualizarEstadoFlag] Fin");

				return 0;
			}

			log
					.info("[SessionUtilBean :: actualizarEstadoFlag] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: actualizarEstadoFlag] Fin");

				return 0;
			}
			s = con.createStatement();
			try {
				String sql = "UPDATE TIIDO_MULTITABLA SET VALOR2 = '" + flag
						+ "' WHERE cod_mult='T13'";

				log
						.info("[SessionUtilBean :: actualizarEstadoFlag] SQL:"
								+ sql);

				indicador = s.executeUpdate(sql);

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: actualizarEstadoFlag] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: actualizarEstadoFlag] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: actualizarEstadoFlag] ");
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
				log.error("[SessionUtilBean :: actualizarEstadoFlag] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return 0;
			}
		}

		return indicador;
	}

	public String buscarEstadoFlag() {
		String estadoFlag = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SessionUtilBean :: buscarEstadoFlag] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: buscarEstadoFlag] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: buscarEstadoFlag] DATASOURCE_CONTEXT:::"
							+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: buscarEstadoFlag] Fin");

				return null;
			}

			s = con.createStatement();
			try {
				String sql = "select VALOR2 from tiido_multitabla where cod_mult='T13'";

				log.info("[SessionUtilBean :: buscarEstadoFlag] SQL:" + sql);

				rst = s.executeQuery(sql);
				if (rst.next()) {
					estadoFlag = rst.getString("VALOR2");
				}

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: buscarEstadoFlag] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: buscarEstadoFlag] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: buscarEstadoFlag] ");
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
				log.error("[SessionUtilBean :: buscarEstadoFlag] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return estadoFlag;
	}

	// TODO: Extraer a la parte Web
	public Vector buscarUsuariosLDAP(String codOficina, String codEmpresa,
			int limiteOcurrencias) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector res = null;
		UsuarioLDAP bean = null;

		try {
			log.info("[SessionUtilBean :: buscarUsuariosLDAP] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: buscarUsuariosLDAP] Fin");

				return null;
			}

			log
					.info("[SessionUtilBean :: buscarUsuariosLDAP] DATASOURCE_LDAP:::"
							+ ConstantesUtil.DATASOURCE_LDAP);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_LDAP);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			s = con.createStatement();
			try {
				String sql = "SELECT TRIM(codusu) codusu, TRIM(INITCAP(nombre || ' '|| apepat)) nombres, codcargo, codofi "
						+ "FROM ldapperu2 "
						+ "WHERE codofi like '"
						+ codOficina
						+ "' AND codemp = '"
						+ codEmpresa
						+ "' "
						+ "ORDER BY codcargo ASC, apepat ASC";

				log.info("[SessionUtilBean :: buscarUsuariosLDAP] SQL:" + sql);

				rst = s.executeQuery(sql);
				s.setMaxRows(limiteOcurrencias);
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);
					bean = new UsuarioLDAP();

					bean.setUID(rst.getString("codusu"));
					bean.setNombreCompleto(rst.getString("nombres"));
					bean.setCodigoCargo(rst.getString("codcargo"));
					bean.setCodigoOficina(rst.getString("codofi"));
					res.add(bean);
				}

			} catch (SQLException e) {
				log.error("[SessionUtilBean :: buscarUsuariosLDAP] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: buscarUsuariosLDAP] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: buscarUsuariosLDAP] ");
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
				log.error("[SessionUtilBean :: buscarUsuariosLDAP] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return res;
	}

	public String testearBD() {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		String errorBD = null;

		try {
			log.info("[SessionUtilBean :: testearBD] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: testearBD] Fin");

				return null;
			}

			log.info("[SessionUtilBean :: testearBD] DATASOURCE_CONTEXT:::"
					+ ConstantesUtil.DATASOURCE_CONTEXT);

			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: testearBD] Fin");

				return null;
			}

			s = con.createStatement();
			sql = "SELECT * FROM dual";

			log.info("[SessionUtilBean :: testearBD] SQL:" + sql);

			s.executeQuery(sql);

			log.info("[SessionUtilBean :: testearBD] Fin");
		} catch (Exception e) {
			String mensajeException = e.getMessage();
			if (mensajeException != null) {
				if (mensajeException.indexOf("ORA-12505") > 0) {
					errorBD = "ErrorBD";
				}
			}
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
				log.error("[SessionUtilBean :: testearBD] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return null;
			}
		}

		return errorBD;
	}

	public Vector exportarTablasTXT(int tabla, int mes, int anio) {
		DataSource datasource = null;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		Vector lista = null;
		String cabecera = null;

		try {
			log.info("[SessionUtilBean :: exportarTablasTXT] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: exportarTablasTXT] Fin");

				return lista;
			}

			datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SessionUtilBean :: exportarTablasTXT] Fin");

				return lista;
			}

			switch (tabla) {
			case 1: // Planes
				cabecera = "cod_ofic|cod_terr|mes_plan|anho_plan|cod_epigrafe|nom_epigrafe|peso_dor|monto|"
						+ "porc_alcanzado|desv_ppto|nro_meses_falt|proy_crec_men|ajuste_estimado_terr|"
						+ "proy_ajuste_men|saldmedi_junio|porc_saldmedi_junio|sald_dic_ante|saldmedi_dic|"
						+ "cod_terri|porc_saldmedi_dic|fac_aju_sal_pun|hist_bajas|met_messald_punt|"
						+ "met_ger_ofi|prioridad|mes_eval|ind_dor|var_mes|ajus_ppto|desv_ppto_ajus|"
						+ "fact_ajus_terri|fact_asig_gte_of|fec_regi|fec_actu|usu_regi|usu_actu";

				sql = "SELECT    cod_ofic || '|' || cod_terr || '|' || mes_plan || '|' || anho_plan || '|' || cod_epigrafe || '|' || "
						+ "nom_epigrafe || '|' || peso_dor || '|' || monto || '|' || porc_alcanzado || '|' || desv_ppto || '|' || "
						+ "nro_meses_falt || '|' || proy_crec_men || '|' || ajuste_estimado_terr || '|' || "
						+ "proy_ajuste_men || '|' || saldmedi_junio || '|' || porc_saldmedi_junio || '|' || "
						+ "sald_dic_ante || '|' || saldmedi_dic || '|' || cod_terri || '|' || porc_saldmedi_dic || '|' || "
						+ "fac_aju_sal_pun || '|' || hist_bajas || '|' || met_messald_punt || '|' || met_ger_ofi || '|' || "
						+ "prioridad || '|' || mes_eval || '|' || ind_dor || '|' || var_mes || '|' || ajus_ppto || '|' || "
						+ "desv_ppto_ajus || '|' || fact_ajus_terri || '|' || fact_asig_gte_of || '|' || "
						+ "TO_CHAR(fec_regi, 'dd/mm/yyyy HH24:MI:SS') || '|' || "
						+ "TO_CHAR(fec_actu, 'dd/mm/yyyy HH24:MI:SS') || '|' || usu_regi || '|' || usu_actu "
						+ "FROM tiido_planes "
						+ "WHERE mes_plan = "
						+ mes
						+ " AND anho_plan = "
						+ anio
						+ " "
						+ "ORDER BY cod_ofic ASC";

				break;

			case 2: // Meta Gestor
				cabecera = "cod_meta_gestor|cod_terr|cod_ofic|cod_epigrafe|anho|cod_gestor|mes|orden|"
						+ "porc_asig|nom_epigrafe|nom_gestor|cod_perfil|estado|fec_regi|"
						+ "fec_actu|usu_regi|usu_actu";

				sql = "SELECT cod_meta_gestor || '|' || cod_terr || '|' || cod_ofic || '|' || cod_epigrafe || '|' || "
						+ "anho || '|' || cod_gestor || '|' || mes || '|' || orden || '|' || porc_asig || '|' || "
						+ "nom_epigrafe || '|' || nom_gestor || '|' || cod_perfil || '|' || "
						+ "estado || '|' || TO_CHAR(fec_regi, 'dd/mm/yyyy HH24:MI:SS') || '|' || "
						+ "TO_CHAR(fec_actu, 'dd/mm/yyyy HH24:MI:SS') || '|' || usu_regi || '|' || usu_actu "
						+ "FROM tiido_metas_gestor "
						+ "WHERE mes = "
						+ mes
						+ " AND anho = "
						+ anio
						+ " "
						+ "ORDER BY cod_meta_gestor ASC";
				break;

			case 3: // Acciones
				cabecera = "cod_acci|cod_epigrafe|anho|cod_terr|cod_ofic|nom_acci|cod_gest|"
						+ "mes_acci|nro_clie|comp_gest|nro_gest_segu_1|nro_conc_segu_1|"
						+ "mon_segu_1|nro_gest_segu_2|nro_conc_segu_2|mon_segu_2|fec_segu_1|"
						+ "fec_segu_2|fec_regi|fec_actu|usu_regi|usu_actu";

				sql = "SELECT cod_acci || '|' || cod_epigrafe || '|' || anho || '|' || cod_terr || '|' || "
						+ "cod_ofic || '|' || nom_acci || '|' || cod_gest || '|' || mes_acci || '|' || nro_clie || '|' || "
						+ "comp_gest || '|' || nro_gest_segu_1 || '|' || nro_conc_segu_1 || '|' || mon_segu_1 || '|' || "
						+ "nro_gest_segu_2 || '|' || nro_conc_segu_2 || '|' || mon_segu_2 || '|' || "
						+ "TO_CHAR(fec_segu_1, 'dd/mm/yyyy HH24:MI:SS') || '|' || "
						+ "TO_CHAR(fec_segu_2, 'dd/mm/yyyy HH24:MI:SS') || '|' || "
						+ "TO_CHAR(fec_regi, 'dd/mm/yyyy HH24:MI:SS') || '|' || "
						+ "TO_CHAR(fec_actu, 'dd/mm/yyyy HH24:MI:SS') || '|' || usu_regi || '|' || usu_actu "
						+ "FROM tiido_acciones "
						+ "WHERE mes_acci = "
						+ mes
						+ " AND anho = " + anio + " " + "ORDER BY cod_acci ASC";
				break;
			case 4: // Esfuerzos
				cabecera = "cod_camp|cod_ofic|cod_terr|anho|mes|nom_camp|cod_gest|orden|gte|"
						+ "fec_regi|fec_actu|usu_regi|usu_actu";

				sql = "SELECT cod_camp || '|' || cod_ofic || '|' || cod_terr || '|' || anho || '|' || "
						+ "mes || '|' || nom_camp || '|' || cod_gest || '|' || orden || '|' || gte || '|' || "
						+ "TO_CHAR(fec_regi, 'dd/mm/yyyy HH24:MI:SS')  || '|' || TO_CHAR(fec_actu, 'dd/mm/yyyy HH24:MI:SS') || '|' || "
						+ "usu_regi || '|' || usu_actu "
						+ "FROM tiido_campanias "
						+ "WHERE mes = "
						+ mes
						+ " AND anho = " + anio + " " + "ORDER BY cod_camp ASC";
				break;
			case 5: // Esfuerzos detalle
				cabecera = "cod_camp_deta|cod_terr|cod_ofic|cod_camp|mes|anho|nom_camp|cod_gest|nro_clie|comp_gest|"
						+ "nro_gest_segu_1|nro_conc_segu_1|mont_segu_1|nro_gest_segu_2|nro_conc_segu_2|"
						+ "mont_segu_2|fec_segu_1|fec_segu_2|fec_regi|fec_actu|usu_regi|usu_actu";

				sql = "SELECT cod_camp_deta || '|' || cod_terr || '|' || cod_ofic || '|' || cod_camp || '|' ||  mes || '|' || "
						+ "anho || '|' || nom_camp || '|' || cod_gest || '|' || nro_clie || '|' || comp_gest || '|' || "
						+ "nro_gest_segu_1 || '|' || nro_conc_segu_1 || '|' || mont_segu_1 || '|' || nro_gest_segu_2 || '|' || "
						+ "nro_conc_segu_2 || '|' || mont_segu_2 || '|' || TO_CHAR(fec_segu_1, 'dd/mm/yyyy HH24:MI:SS') || '|' || "
						+ "TO_CHAR(fec_segu_2, 'dd/mm/yyyy HH24:MI:SS') || '|' || TO_CHAR(fec_regi, 'dd/mm/yyyy HH24:MI:SS') || '|' || "
						+ "TO_CHAR(fec_actu, 'dd/mm/yyyy HH24:MI:SS') || '|' || usu_regi || '|' || usu_actu "
						+ "FROM tiido_campanias_detalle "
						+ "WHERE mes = "
						+ mes
						+ " AND anho = "
						+ anio
						+ " "
						+ "ORDER BY cod_camp_deta ASC";
				break;
			case 6: // Ingresos
				cabecera = "id_ingresos|veces|valido_veces|cod_usuario|cargo|nom_territorio|cod_oficina|fecha|nombres";

				sql = "SELECT id_ingresos || '|' || veces || '|' || valido_veces || '|' || cod_usuario || '|' || cargo || '|' || "
						+ "nom_territorio || '|' || cod_oficina || '|' || TO_CHAR(fecha, 'dd/mm/yyyy HH24:MI:SS') || '|' || nombres "
						+ "FROM tiido_ingresos "
						+ "WHERE TO_CHAR(fecha, 'mm') = "
						+ mes
						+ " AND TO_CHAR(fecha, 'yyyy') = "
						+ anio
						+ " "
						+ "ORDER BY id_ingresos ASC";
				break;
			case 7: // Ingresos Form
				cabecera = "form_id|tipo_form|fecha_act|cod_usuario|mes|anio|edit_usuario";

				sql = "SELECT form_id || '|' || tipo_form || '|' || TO_CHAR(fecha_act, 'dd/mm/yyyy HH24:MI:SS') || '|' || "
						+ "cod_usuario || '|' || mes || '|' || anio || '|' || edit_usuario "
						+ "FROM tiido_ingresos_form "
						+ "WHERE mes = "
						+ mes
						+ " AND anio = " + anio + " " + "ORDER BY form_id ASC";
				break;

			}

			s = con.createStatement();
			log.info("[SessionUtilBean :: exportarTablasTXT] SQL:" + sql);
			rst = s.executeQuery(sql);

			while (rst.next()) {
				if (lista == null) {
					lista = new Vector();
					lista.add(cabecera);
				}

				lista.add(rst.getString(1));
			}

			log.info("[SessionUtilBean :: exportarTablasTXT] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: exportarTablasTXT] ");
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
				log.error("[SessionUtilBean :: exportarTablasTXT] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return lista;
			}
		}

		return lista;
	}

	public Vector<Seguimiento> consultaSeguimientoAccionEsfuerzo(String codOfi, String mes, String anho, String codGestor) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector<Seguimiento> res = new Vector<Seguimiento>();
		Seguimiento bean = null;
		Seguimiento temp = null;
		Seguimiento acci = null;

		try {
			log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzo] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzo] Fin :: initialContext == null");
				return null;
			}

			log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzo] DATASOURCE_CONTEXT ::" + ConstantesUtil.DATASOURCE_CONTEXT);
			DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			s = con.createStatement();
			try {
				String sql = "SELECT * FROM VIIDO_SEGUIMIENTO a WHERE a.cod_ofic = '"
						+ codOfi
						+ "' AND a.anho = '"
						+ anho
						+ "' AND a.mes_acci = '"
						+ mes
						+ "' AND a.cod_gest = '"
						+ codGestor + "' ";
				sql += "ORDER BY cod_gest, tipo DESC, DECODE(prioridad, '', '99', prioridad), codepigrafe";
				log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzo] SQL:" + sql);

				rst = s.executeQuery(sql);

				while (rst.next()) {

					bean = new Seguimiento();
					bean.setCodEpigrafe(rst.getString("codepigrafe"));
					bean.setNomEpigrafe(rst.getString("nomepigrafe"));
					bean.setCodOfic(rst.getString("cod_ofic"));
					bean.setMes(rst.getString("mes_acci"));
					bean.setAnho(rst.getString("anho"));
					bean.setPrioridad((rst.getString("prioridad") == null) ? "" : rst.getString("prioridad"));
					// bean.setMetGerOfi(rst.getBigDecimal("met_ger_ofi"));
					bean.setMetGerOfi(rst.getBigDecimal("porc_asig"));
					bean.setNomAcci(rst.getString("nom_acci"));
					bean.setCodGest(rst.getString("cod_gest"));
					bean.setNroClie(rst.getBigDecimal("nro_clie"));
					bean.setCompGest(rst.getBigDecimal("comp_gest"));
					bean.setNroGestSegu1(rst.getBigDecimal("nro_gest_segu_1"));
					bean.setNroConcSegu1(rst.getBigDecimal("nro_conc_segu_1"));
					bean.setMonSegu1(rst.getBigDecimal("mon_segu_1"));
					bean.setNroGestSegu2(rst.getBigDecimal("nro_gest_segu_2"));
					bean.setNroConcSegu2(rst.getBigDecimal("nro_conc_segu_2"));
					bean.setMonSegu2(rst.getBigDecimal("mon_segu_2"));
					bean.setCodAcci(rst.getBigDecimal("cod_acci"));
					bean.setIndAfecta(rst.getString("indafecta"));
					bean.setPorcAsig(rst.getBigDecimal("porc_asig"));
					bean.setCodPerfil(rst.getString("cod_perfil"));
					// bean.setOrden(rst.getString("orden"));
					bean.setTipo(rst.getString("tipo"));
					bean.setTotalMIS(rst.getBigDecimal("total"));
					bean.setPorcentajeMin(rst.getBigDecimal("porcentaje_min"));
					bean.setPorcentajeMax(rst.getBigDecimal("porcentaje_max"));

					if (temp != null) {
						if (temp.getCodEpigrafe().equalsIgnoreCase(bean.getCodEpigrafe())
								&& temp.getTipo().equalsIgnoreCase(bean.getTipo())) {
							acumularSubTotal(temp, bean);
							bean.setOrden("0");
						} else {
							res.add(temp);
							// log.info(temp.getPorcConsecucion());
							temp = crearSubTotal(bean);
							bean.setOrden("1");
						}
					} else {
						temp = crearSubTotal(bean);
						bean.setOrden("1");
					}
					
					if (acci != null) {
						if (acci.getTipo().equalsIgnoreCase(bean.getTipo())) {
							acumularSubTotal(acci, bean);
						} else {
							res.add(acci);
							// log.info(acci.getPorcConsecucion());
							acci = crearSubTotal(bean, "TOTAL");
						}
					} else {
						acci = crearSubTotal(bean, "TOTAL");
					}
					
					res.add(bean);
				}

				if(temp != null) {
					res.add(temp);
				}
				
				if(acci != null) {
					res.add(acci);
				}
				
			} catch (SQLException e) {
				log.error("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzo] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzo] Error");
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
				log.error("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzo] Error");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				return null;
			}
		}

		return res;
	}
	
	private Seguimiento crearSubTotal(Seguimiento entidad) {
		return crearSubTotal(entidad, "SUBTOTAL");
	}
		
	private Seguimiento crearSubTotal(Seguimiento entidad, String tipo) {
		Seguimiento subtotal = new Seguimiento();
		subtotal.setCodEpigrafe(entidad.getCodEpigrafe());
		subtotal.setNomEpigrafe(entidad.getNomEpigrafe());
		subtotal.setTipo(entidad.getTipo());
		subtotal.setMetGerOfi(entidad.getMetGerOfi());
		subtotal.setPorcentajeMin(entidad.getPorcentajeMin());
		subtotal.setPorcentajeMax(entidad.getPorcentajeMax());
		subtotal.setNomAcci(tipo);
		subtotal.setTotalMIS(entidad.getTotalMIS());
		subtotal.setNroClie(BigDecimal.ZERO);
		subtotal.setCompGest(BigDecimal.ZERO);
		subtotal.setNroGestSegu1(BigDecimal.ZERO);
		subtotal.setNroConcSegu1(BigDecimal.ZERO);
		subtotal.setMonSegu1(BigDecimal.ZERO);
		subtotal.setNroGestSegu2(BigDecimal.ZERO);
		subtotal.setNroConcSegu2(BigDecimal.ZERO);
		subtotal.setMonSegu2(BigDecimal.ZERO);
		acumularSubTotal(subtotal, entidad);
		return subtotal;
	}
	
	private void acumularSubTotal(Seguimiento subtotal, Seguimiento entidad) {
		acumularSubTotal(subtotal, entidad, "SUBTOTAL");
	}
	
	private void acumularSubTotal(Seguimiento subtotal, Seguimiento entidad, String tipo) {
		subtotal.setNroClie(subtotal.getNroClie().add(entidad.getNroClie()));
		subtotal.setCompGest(subtotal.getCompGest().add(entidad.getCompGest()));
		subtotal.setNroGestSegu1(subtotal.getNroGestSegu1().add(entidad.getNroGestSegu1()));
		subtotal.setNroConcSegu1(subtotal.getNroConcSegu1().add(entidad.getNroConcSegu1()));
		subtotal.setMonSegu1(subtotal.getMonSegu1().add(entidad.getMonSegu1()));
		subtotal.setNroGestSegu2(subtotal.getNroGestSegu2().add(entidad.getNroGestSegu2()));
		subtotal.setNroConcSegu2(subtotal.getNroConcSegu2().add(entidad.getNroConcSegu2()));
		subtotal.setMonSegu2(subtotal.getMonSegu2().add(entidad.getMonSegu2()));
	}
	
	public Vector<Seguimiento> consultaSeguimientoAccionEsfuerzoPGO(String codOfi, String mes, String anho) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		Vector<Seguimiento> res = new Vector<Seguimiento>();
		Seguimiento bean = null;
		Seguimiento temp = null;
		Seguimiento acci = null;
		Seguimiento gest = null;

		try {
			log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzoPGO] Inicio");

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzoPGO] Fin :: initialContext == null");
				return null;
			}

			log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzoPGO] DATASOURCE_CONTEXT ::" + ConstantesUtil.DATASOURCE_CONTEXT);
			DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			s = con.createStatement();
			try {
				String sql = "SELECT a.*, b.total total_mis_oficina FROM iido.viido_seguimiento a LEFT JOIN iido.viido_mis_oficina b "
						+ "ON a.cod_ofic=b.cod_ofic AND a.anho=b.anho AND a.mes_acci=b.mes AND a.codepigrafe=b.cod_epi "
						+ "WHERE a.cod_ofic = '"
						+ codOfi
						+ "' AND a.anho = '"
						+ anho
						+ "' AND a.mes_acci = '"
						+ mes
						+ "' ";
				sql += "ORDER BY a.tipo DESC, DECODE(a.prioridad, '', '99', a.prioridad), a.codepigrafe, a.cod_gest";
				log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzoPGO] SQL:" + sql);

				rst = s.executeQuery(sql);

				while (rst.next()) {

					bean = new Seguimiento();
					bean.setCodEpigrafe(rst.getString("codepigrafe"));
					bean.setNomEpigrafe(rst.getString("nomepigrafe"));
					bean.setCodOfic(rst.getString("cod_ofic"));
					bean.setMes(rst.getString("mes_acci"));
					bean.setAnho(rst.getString("anho"));
					bean.setPrioridad((rst.getString("prioridad") == null) ? "" : rst.getString("prioridad"));
					bean.setMetGerOfi(rst.getBigDecimal("met_ger_ofi"));
					bean.setNomAcci(rst.getString("nom_acci"));
					bean.setCodGest(rst.getString("cod_gest"));
					bean.setNomGest(rst.getString("nom_gest"));
					bean.setNroClie(rst.getBigDecimal("nro_clie"));
					bean.setCompGest(rst.getBigDecimal("comp_gest"));
					bean.setNroGestSegu1(rst.getBigDecimal("nro_gest_segu_1"));
					bean.setNroConcSegu1(rst.getBigDecimal("nro_conc_segu_1"));
					bean.setMonSegu1(rst.getBigDecimal("mon_segu_1"));
					bean.setNroGestSegu2(rst.getBigDecimal("nro_gest_segu_2"));
					bean.setNroConcSegu2(rst.getBigDecimal("nro_conc_segu_2"));
					bean.setMonSegu2(rst.getBigDecimal("mon_segu_2"));
					bean.setCodAcci(rst.getBigDecimal("cod_acci"));
					bean.setIndAfecta(rst.getString("indafecta"));
					bean.setPorcAsig(rst.getBigDecimal("porc_asig"));
					bean.setCodPerfil(rst.getString("cod_perfil"));
					bean.setTipo(rst.getString("tipo"));
					bean.setTotalMIS(rst.getBigDecimal("total_mis_oficina"));
					bean.setPorcentajeMin(rst.getBigDecimal("porcentaje_min"));
					bean.setPorcentajeMax(rst.getBigDecimal("porcentaje_max"));

					if (temp != null) {
						if (temp.getCodEpigrafe().equalsIgnoreCase(bean.getCodEpigrafe()) && temp.getTipo().equalsIgnoreCase(bean.getTipo())) {
							acumularSubTotal(temp, bean); // , "TOTAL"
							bean.setOrden("0");
						} else {
							res.add(temp);
							temp = crearSubTotal(bean);
							bean.setOrden("1");
						}
					} else {
						temp = crearSubTotal(bean);
						bean.setOrden("1");
					}
					
					if (gest != null) {
						if (!gest.getCodGest().equalsIgnoreCase(bean.getCodGest())) {
							if(bean.getOrden().equalsIgnoreCase("0")) {
								bean.setOrden("2");
							}
						}
					} else {
						gest = bean;
					}
					
					if (acci != null) {
						if (acci.getTipo().equalsIgnoreCase(bean.getTipo())) {
							acumularSubTotal(acci, bean);
						} else {
							res.add(acci);
							acci = crearSubTotal(bean, "TOTAL");
						}
					} else {
						acci = crearSubTotal(bean, "TOTAL");
					}
					
					res.add(bean);
				}

				if(temp != null) {
					res.add(temp);
				}
				
				if(acci != null) {
					res.add(acci);
				}
				
			} catch (SQLException e) {
				log.error("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzoPGO] Error");
				log.error(e);
			}

			log.info("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzoPGO] Fin");
		} catch (Exception e) {
			log.error("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzoPGO] Error");
			log.error(e);
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
				log.error("[SessionUtilBean :: consultaSeguimientoAccionEsfuerzoPGO] Error");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				return null;
			}
		}

		return res;
	}
}
