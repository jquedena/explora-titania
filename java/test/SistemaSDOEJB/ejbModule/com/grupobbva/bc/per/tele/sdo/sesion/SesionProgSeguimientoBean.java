package com.grupobbva.bc.per.tele.sdo.sesion;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import org.apache.log4j.Logger;
/**
 * Bean implementation class for Enterprise Bean: SesionProgSeguimiento
 */
@SuppressWarnings({"serial", "unused", "unchecked"})
public class SesionProgSeguimientoBean implements javax.ejb.SessionBean {
	private static Logger log = Logger.getLogger(SesionProgSeguimientoBean.class);
	
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_SesionMultitablaHome_REF_NAME = "ejb/SesionMultitabla";
	private final static Class STATIC_SesionMultitablaHome_CLASS = SesionMultitablaHome.class;
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
	
	protected SesionMultitabla createSesionMultitabla() {
		try {
			log.info("[SesionProgSeguimientoBean :: createSesionMultitabla] Inicio");
			
			SesionMultitablaHome aSesionMultitablaHome = (SesionMultitablaHome) ServiceLocatorManager
			.getRemoteHome(STATIC_SesionMultitablaHome_REF_NAME,
					STATIC_SesionMultitablaHome_CLASS);
			
			if (aSesionMultitablaHome != null) {
				log.info("[SesionProgSeguimientoBean :: createSesionMultitabla] Fin");
				
				return aSesionMultitablaHome.create();
			}
			
			log.info("[SesionProgSeguimientoBean :: createSesionMultitabla] Fin");
		} catch (javax.ejb.CreateException e) {
			log.error("[SesionProgSeguimientoBean :: createSesionMultitabla] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (RemoteException e) {
			log.error("[SesionProgSeguimientoBean :: createSesionMultitabla] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionProgSeguimientoBean :: createSesionMultitabla] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	
	public Vector findTodosProgTerritorio(ProgSeguimiento progTerritorio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		boolean resp = false;
		int cont = 0;
		String sql = null;
		String cond = null;
		ProgSeguimiento nuevoProgTerritorio = null;
		Vector vector = null;

		try {
			log.info("[SesionProgSeguimientoBean :: findTodosProgTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionProgSeguimientoBean :: findTodosProgTerritorio] Fin");
				
				return null;
			}
			
			log.info("[SesionProgSeguimientoBean :: findTodosProgTerritorio] DATASOURCE_CONTEXT::: " + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			try {
				if (progTerritorio != null) {
					s = con.createStatement();
					cond = progTerritorio.getCodTerritorio() != null ? "WHERE cod_terr = '"
							+ progTerritorio.getCodTerritorio() + "' "
							: "";

					sql = "SELECT cod_terr, (SELECT t.nom_terr FROM iido.tiido_territorio t WHERE t.cod_terr = p.cod_terr) nom_terr, "
							+ "mes, anio, seg1_ini, seg1_fin, seg2_ini, seg2_fin FROM iido.tiido_prog_seguimiento p "
							+ cond
							+ "ORDER BY cod_terr ASC, anio DESC, mes DESC";

					log.info("[SesionProgSeguimientoBean :: findTodosProgTerritorio] SQL: " + sql);

					rst = s.executeQuery(sql);
					vector = new Vector();
					while (rst.next()) {
						nuevoProgTerritorio = new ProgSeguimiento();
						nuevoProgTerritorio.setCodTerritorio(rst
								.getString("cod_terr"));
						nuevoProgTerritorio.setNomTerritorio(rst
								.getString("nom_terr"));
						nuevoProgTerritorio.setMes(rst.getString("mes"));
						nuevoProgTerritorio.setAnio(rst.getInt("anio"));
						nuevoProgTerritorio.setSeg1Ini(rst
								.getString("seg1_ini"));
						nuevoProgTerritorio.setSeg1Fin(rst
								.getString("seg1_fin"));
						nuevoProgTerritorio.setSeg2Ini(rst
								.getString("seg2_ini"));
						nuevoProgTerritorio.setSeg2Fin(rst
								.getString("seg2_fin"));

						vector.add(nuevoProgTerritorio);
					}
				}
				
				log.info("[SesionProgSeguimientoBean :: findTodosProgTerritorio] Fin");
			} catch (SQLException e) {
				log.error("[SesionProgSeguimientoBean :: findTodosProgTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		} catch (Exception e) {
			log.error("[SesionProgSeguimientoBean :: findTodosProgTerritorio] ");
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
				log.error("[SesionProgSeguimientoBean :: findTodosProgTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		}

		return vector;
	}

	public ProgSeguimiento findProgTerritorio(ProgSeguimiento progTerritorio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		boolean resp = false;
		int cont = 0;
		String sql = null;
		ProgSeguimiento nuevoProgTerritorio = null;

		try {
			log.info("[SesionProgSeguimientoBean :: findProgTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionProgSeguimientoBean :: findProgTerritorio] Fin");
				
				return null;
			}
			
			log.info("[SesionProgSeguimientoBean :: findProgTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				
				log.info("[SesionProgSeguimientoBean :: findProgTerritorio] Fin");
				return null;
			}

			try {
				if (progTerritorio != null) {
					s = con.createStatement();
					sql = "SELECT cod_terr, (SELECT t.nom_terr FROM iido.tiido_territorio t WHERE t.cod_terr = p.cod_terr) nom_terr, "
							+ "seg1_ini, seg1_fin, seg2_ini, seg2_fin FROM iido.tiido_prog_seguimiento p "
							+ "WHERE cod_terr = '"
							+ progTerritorio.getCodTerritorio()
							+ "' AND mes = decode("
							+ progTerritorio.getMes()
							+ ", 0, to_char(sysdate, 'mm'), "
							+ progTerritorio.getMes()
							+ ") AND anio = decode("
							+ progTerritorio.getAnio()
							+ ", 0, to_char(sysdate, 'yyyy'), "
							+ progTerritorio.getAnio()
							+ ")";

					log.info("[SesionProgSeguimientoBean :: findProgTerritorio] SQL: " + sql);

					rst = s.executeQuery(sql);
					if (rst.next()) {
						nuevoProgTerritorio = new ProgSeguimiento();
						nuevoProgTerritorio.setCodTerritorio(rst.getString("cod_terr"));
						nuevoProgTerritorio.setNomTerritorio(rst.getString("nom_terr"));
						nuevoProgTerritorio.setMes(progTerritorio.getMes());
						nuevoProgTerritorio.setAnio(progTerritorio.getAnio());
						nuevoProgTerritorio.setSeg1Ini(ConstantesUtil.formatearFechaString(rst.getString("seg1_ini")));
						nuevoProgTerritorio.setSeg1Fin(ConstantesUtil.formatearFechaString(rst.getString("seg1_fin")));
						nuevoProgTerritorio.setSeg2Ini(ConstantesUtil.formatearFechaString(rst.getString("seg2_ini")));
						nuevoProgTerritorio.setSeg2Fin(ConstantesUtil.formatearFechaString(rst.getString("seg2_fin")));
					}
				}
			} catch (SQLException e) {
				log.error("[SesionProgSeguimientoBean :: findProgTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionProgSeguimientoBean :: findProgTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionProgSeguimientoBean :: findProgTerritorio] ");
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
				log.error("[SesionProgSeguimientoBean :: findProgTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		}

		return nuevoProgTerritorio;
	}

	public boolean crearProgTerritorio(ProgSeguimiento progTerritorio) {
		Connection con = null;
		Context initialContext = null;
		PreparedStatement s = null;
		boolean resp = false;
		String sql = null;

		try {
			log.info("[SesionProgSeguimientoBean :: crearProgTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionProgSeguimientoBean :: crearProgTerritorio] Fin");
				
				return false;
			}
			
			log.info("[SesionProgSeguimientoBean :: crearProgTerritorio] DATASOURCE_CONTEXT::: " +  ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				
				log.info("[SesionProgSeguimientoBean :: crearProgTerritorio] Fin");
				return resp;
			}

			try {
				if (progTerritorio != null) {
					sql = "INSERT INTO iido.tiido_prog_seguimiento (cod_terr, mes, "
							+ "anio, seg1_ini, seg1_fin, seg2_ini, seg2_fin, usu_regi, usu_actu, "
							+ "fec_regi, fec_actu) VALUES ('"
							+ progTerritorio.getCodTerritorio()
							+ "', '"
							+ progTerritorio.getMes()
							+ "', '"
							+ progTerritorio.getAnio()
							+ "', TO_DATE('"
							+ progTerritorio.getSeg1Ini()
							+ "', 'DD/MM/YYYY'), TO_DATE('"
							+ progTerritorio.getSeg1Fin()
							+ "', 'DD/MM/YYYY'), TO_DATE('"
							+ progTerritorio.getSeg2Ini()
							+ "', 'DD/MM/YYYY'), TO_DATE('"
							+ progTerritorio.getSeg2Fin()
							+ "', 'DD/MM/YYYY'), '"
							+ progTerritorio.getUsuCrea() + "', NULL, SYSDATE, NULL)";

					s = con.prepareStatement(sql);

					log.info("[SesionProgSeguimientoBean :: crearProgTerritorio] SQL:" + sql);
					resp = s.executeUpdate() > 0 ? true : false;
				}
			} catch (SQLException e) {
				log.error("[SesionProgSeguimientoBean :: crearProgTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				resp = false;
			}
			
			log.info("[SesionProgSeguimientoBean :: crearProgTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionProgSeguimientoBean :: crearProgTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			resp = false;
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
				log.error("[SesionProgSeguimientoBean :: crearProgTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				resp = false;
			}
		}

		return resp;
	}

	public boolean actualizarProgTerritorio(ProgSeguimiento progTerritorio) {
		Connection con = null;
		Context initialContext = null;
		PreparedStatement s = null;
		boolean resp = false;
		String sql = null;

		try {
			log.info("[SesionProgSeguimientoBean :: actualizarProgTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionProgSeguimientoBean :: actualizarProgTerritorio] Fin");
				
				return false;
			}
			
			log.info("[SesionProgSeguimientoBean :: actualizarProgTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				
				log.info("[SesionProgSeguimientoBean :: actualizarProgTerritorio] Fin");
				return resp;
			}

			try {
				if (progTerritorio != null) {
					sql = "UPDATE iido.tiido_prog_seguimiento SET seg1_fin=TO_DATE(?, 'DD/MM/YYYY'), "
							+ "seg2_ini=TO_DATE(?, 'DD/MM/YYYY'), "
							+ "seg2_fin=TO_DATE(?, 'DD/MM/YYYY'), usu_actu=?, "
							+ "fec_actu=SYSDATE "
							+ "WHERE cod_terr = ? AND mes = ? AND anio = ?";

					s = con.prepareStatement(sql);
					s.setString(1, progTerritorio.getSeg1Fin());
					s.setString(2, progTerritorio.getSeg2Ini());
					s.setString(3, progTerritorio.getSeg2Fin());
					s.setString(4, progTerritorio.getUsuActu());
					s.setString(5, progTerritorio.getCodTerritorio());
					s.setString(6, progTerritorio.getMes());
					s.setInt(7, progTerritorio.getAnio());

					log.info("[SesionProgSeguimientoBean :: actualizarProgTerritorio] SQL:" + sql);
					resp = s.executeUpdate() > 0 ? true : false;
				}
			} catch (SQLException e) {
				log.error("[SesionProgSeguimientoBean :: actualizarProgTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				resp = false;
			}
			
			log.info("[SesionProgSeguimientoBean :: actualizarProgTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionProgSeguimientoBean :: actualizarProgTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);

			resp = false;
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
				log.error("[SesionProgSeguimientoBean :: actualizarProgTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				resp = false;
			}
		}

		return resp;
	}

	public boolean eliminarProgTerritorio(ProgSeguimiento progTerritorio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		boolean resp = false;
		int cont = 0;
		String sql = null;

		try {
			log.info("[SesionProgSeguimientoBean :: eliminarProgTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionProgSeguimientoBean :: eliminarProgTerritorio] Fin");
				
				return false;
			}
			
			log.info("[SesionProgSeguimientoBean :: eliminarProgTerritorio] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				
				log.info("[SesionProgSeguimientoBean :: eliminarProgTerritorio] Fin");
				return false;
			}

			try {
				if (progTerritorio != null) {
					s = con.createStatement();
					sql = "DELETE FROM iido.tiido_prog_seguimiento "
							+ "WHERE cod_terr = '"
							+ progTerritorio.getCodTerritorio()
							+ "' AND mes = " + progTerritorio.getMes()
							+ " AND anio = " + progTerritorio.getAnio();

					log.info("[SesionProgSeguimientoBean :: eliminarProgTerritorio] SQL:" + sql);

					resp = s.executeUpdate(sql) > 0 ? true : false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				resp = false;
			}
			
			log.info("[SesionProgSeguimientoBean :: eliminarProgTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionProgSeguimientoBean :: eliminarProgTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);

			resp = false;
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
				log.error("[SesionProgSeguimientoBean :: eliminarProgTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				resp = false;
			}
		}

		return resp;
	}

	public ProgSeguimiento findProgramacionSeguimiento(String mes, String anio,
			String codTerritorio) {
		ProgSeguimiento progSeguimiento = null;
		SesionMultitabla aSesionMultitabla = null;
		ProgSeguimiento programacion = null;

		try {
			log.info("[SesionProgSeguimientoBean :: findProgramacionSeguimiento] Inicio");
			
			progSeguimiento = new ProgSeguimiento();
			aSesionMultitabla = createSesionMultitabla();

			if (mes == null) {
				throw new Exception("No se seteado el mes.");
			}

			if (anio == null) {
				throw new Exception("No se seteado el anio.");
			}

			if (codTerritorio == null) {
				throw new Exception("No se seteado el c" + (char) 243 + "digo de territorio.");
			}

			progSeguimiento.setMes(mes);
			progSeguimiento.setAnio(Integer.parseInt(anio));
			progSeguimiento.setCodTerritorio(codTerritorio);

			programacion = findProgTerritorio(progSeguimiento);

			if (programacion == null) {
				programacion = aSesionMultitabla.obtenerProgramacionSeguimientoDefault(mes, anio);
				programacion.setMes(mes);
				programacion.setAnio(Integer.parseInt(anio));
				programacion.setCodTerritorio(codTerritorio);
				
				if (programacion == null) {
					throw new Exception(
							"No se ha configurado tabla multitabla con la programaci" + (char) 243 + "n de seguimiento.");
				}
			}
			
			log.info("[SesionProgSeguimientoBean :: findProgramacionSeguimiento] Fin");
		} catch (Exception e) {
			log.error("[SesionProgSeguimientoBean :: findProgramacionSeguimiento] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return programacion;
	}
}