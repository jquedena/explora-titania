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

public class ThreadCargaVinculacionGCO extends Thread {
	
	static Logger logger = Logger.getLogger(ThreadCargaVinculacionGCO.class);	
	private long idRegistroCargaGCO;
	private int rptaCarga;
	private AdministracionCargaVinculacion horario;
	public void run() {
		DataSource datasource = null;
		Connection con = null;
		CallableStatement stmt = null;
		ConexionDAO conexion = new ConexionDAO();
		try {
			Context initialContext = new InitialContext();
			datasource = (DataSource) initialContext
					.lookup(Constantes.DATASOURCE_CONTEXT);
			con = datasource.getConnection();
			String query = "{ call IILC.PIILC_CARGA_VINCULACION.sp_carga_vinculacion_gco(?,?) }";
			stmt = con.prepareCall(query);
			stmt.registerOutParameter(2, Types.INTEGER);
			stmt.setLong(1, this.getIdRegistroCargaGCO());
			stmt.execute();
			this.setRptaCarga(stmt.getInt(2)); 
			Thread.sleep(120000);
			if (Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO.equals(String.valueOf(this.getRptaCarga()))){
				conexion.actualizarEstadoCarga(this.getHorario(),Constantes.INDICADOR_NO_PROCESANDO_VINCULACION,Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO);
			} else {
				conexion.actualizarEstadoCarga(this.getHorario(),Constantes.INDICADOR_NO_PROCESANDO_VINCULACION,Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO_ERROR);
			}
		} catch (Exception e1) {
			try {
				conexion.actualizarEstadoCarga(this.getHorario(),Constantes.INDICADOR_NO_PROCESANDO_VINCULACION,Constantes.ID_ESTADO_CARGA_VINCULACION_CULMINADO_ERROR);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
			logger.error(" ThreadCargaVinculacionGCO :" + e1.getMessage());
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
	 * @return Returns the idRegistroCargaGCO.
	 */
	public long getIdRegistroCargaGCO() {
		return idRegistroCargaGCO;
	}
	/**
	 * @param idRegistroCargaGCO The idRegistroCargaGCO to set.
	 */
	public void setIdRegistroCargaGCO(long idRegistroCargaGCO) {
		this.idRegistroCargaGCO = idRegistroCargaGCO;
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