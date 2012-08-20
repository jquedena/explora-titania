package com.grupobbva.bc.per.tel.iilc.logic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion;

public class ThreadCargaVinculacionPH extends Thread {

	static Logger logger = Logger.getLogger(ThreadCargaVinculacionPH.class);
	private long idRegistroCargaPH;
	private int rptaCarga;
	private AdministracionCargaVinculacion horario;

	public void run() {
		DataSource datasource = null;
		Connection con = null;
		ConexionDAO conexion = new ConexionDAO();
		CallableStatement stmt = null;
		try {
			Context initialContext = new InitialContext();
			datasource = (DataSource) initialContext
					.lookup(Constantes.DATASOURCE_CONTEXT);
			con = datasource.getConnection();
			String query = "{ call IILC.PIILC_CARGA_VINCULACION.sp_carga_vinculacion_ph(?,?) }";
			stmt = con.prepareCall(query);
			stmt.registerOutParameter(2, Types.INTEGER);
			stmt.setLong(1, this.getIdRegistroCargaPH());
			stmt.execute();
			this.setRptaCarga(stmt.getInt(2));

			Thread.sleep(120000);
			if (Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO.equals(String
					.valueOf(this.getRptaCarga()))) {
				conexion.actualizarEstadoCarga(this.getHorario(),
						Constantes.INDICADOR_NO_PROCESANDO_VINCULACION,
						Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO);
			} else {
				conexion.actualizarEstadoCarga(this.getHorario(),
						Constantes.INDICADOR_NO_PROCESANDO_VINCULACION,
						Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO_ERROR);
			}

		} catch (Exception e1) {
			try {
				conexion.actualizarEstadoCarga(this.getHorario(),
						Constantes.INDICADOR_NO_PROCESANDO_VINCULACION,
						Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO_ERROR);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
			logger.error(" ThreadCargaVinculacionPH :" + e1.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Throwable e) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Throwable e) {

			}
		}
	}

	/**
	 * @return Returns the idRegistroCargaPH.
	 */
	public long getIdRegistroCargaPH() {
		return idRegistroCargaPH;
	}

	/**
	 * @param idRegistroCargaPH
	 *            The idRegistroCargaPH to set.
	 */
	public void setIdRegistroCargaPH(long idRegistroCargaPH) {
		this.idRegistroCargaPH = idRegistroCargaPH;
	}

	public int getRptaCarga() {
		return rptaCarga;
	}

	public void setRptaCarga(int rptaCarga) {
		this.rptaCarga = rptaCarga;
	}

	public AdministracionCargaVinculacion getHorario() {
		return horario;
	}

	public void setHorario(AdministracionCargaVinculacion horario) {
		this.horario = horario;
	}

	
}