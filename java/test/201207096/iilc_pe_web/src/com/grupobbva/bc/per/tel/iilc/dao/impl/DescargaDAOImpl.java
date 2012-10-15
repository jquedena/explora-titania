package com.grupobbva.bc.per.tel.iilc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.jdbc.driver.OracleTypes;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.beans.Descarga;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;

public class DescargaDAOImpl {
	
	private Logger logger = Logger.getLogger(DescargaDAOImpl.class);
	
	protected Connection getConnection(){
		Connection connection = null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext != null) {
				DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
				if (datasource != null) {
					connection = datasource.getConnection();
				}
			}
		} catch (Exception e) {
			logger.error("DescargaDAOImpl :: getConnection", e);
		}
		return connection;
	}
	
	public int insertar(String registro, String archivo, String descripcion) {
		String sql = "{call iilc.piilc_descargas_excel.sp_insertar(?, ?, ?, ?)}";
		Connection cnn = getConnection();
		CallableStatement stm = null;
		int result = -1;
		
		try {
			stm = cnn.prepareCall(sql);
			stm.setString(1, registro);
			stm.setString(2, archivo);
			stm.setString(3, descripcion);
			stm.registerOutParameter(4, OracleTypes.INTEGER);
			stm.execute();
			result = stm.getInt(4);
		} catch (SQLException e) {
			logger.error("DescargaDAOImpl :: insertar", e);
		} catch (NullPointerException e) {
			logger.error("DescargaDAOImpl :: insertar", e);
		} finally {
			try {
				if(stm != null)
					stm.close();
			} catch (SQLException e) {
				logger.error("DescargaDAOImpl :: insertar :: stm", e);
			}
			try {
				if(cnn != null)
					cnn.close();
			} catch (SQLException e) {
				logger.error("DescargaDAOImpl :: insertar :: cnn", e);
			}
		}
		
		return result;
	}

	public void actualizar(int id, int estado) {
		String sql = "{call iilc.piilc_descargas_excel.sp_actualizar(?, ?)}";
		Connection cnn = getConnection();
		CallableStatement stm = null;
		
		try {
			stm = cnn.prepareCall(sql);
			stm.setInt(1, id);
			stm.setInt(2, estado);
			stm.execute();
		} catch (SQLException e) {
			logger.error("DescargaDAOImpl :: actualizar", e);
		} catch (NullPointerException e) {
			logger.error("DescargaDAOImpl :: actualizar", e);
		} finally {
			try {
				if(stm != null)
					stm.close();
			} catch (SQLException e) {
				logger.error("DescargaDAOImpl :: actualizar :: stm", e);
			}
			try {
				if(cnn != null)
					cnn.close();
			} catch (SQLException e) {
				logger.error("DescargaDAOImpl :: actualizar :: cnn", e);
			}
		}
	}
	
	public List<Descarga> findDescargas(String registro) {
		String sql = "{call iilc.piilc_descargas_excel.sp_listar(?, ?)}";
		Connection cnn = getConnection();
		CallableStatement stm = null;
		ResultSet rss = null;
		Descarga descarga = null;
		List<Descarga> result = new ArrayList<Descarga>();
		
		try {
			stm = cnn.prepareCall(sql);
			stm.setString(1, registro);
			stm.registerOutParameter(2, OracleTypes.CURSOR);
			stm.execute();
			rss = (ResultSet) stm.getObject(2);
			
			while(rss.next()) {
				descarga = new Descarga();
				descarga.setId(rss.getInt("id"));
				descarga.setFecha((Timestamp) rss.getTimestamp("fecha"));
				descarga.setRegistro(rss.getString("registro"));
				descarga.setArchivo(rss.getString("archivo"));
				// descarga.setDescripcion(rss.getString("descripcion"));
				descarga.setEstado(rss.getInt("estado"));
				
				result.add(descarga);
			}
		} catch (SQLException e) {
			logger.error("DescargaDAOImpl :: findDescargas", e);
		} catch (NullPointerException e) {
			logger.error("DescargaDAOImpl :: findDescargas", e);
		} finally {
			try {
				if(rss != null)
					rss.close();
			} catch (SQLException e) {
				logger.error("DescargaDAOImpl :: findDescargas :: rss", e);
			}
			try {
				if(stm != null)
					stm.close();
			} catch (SQLException e) {
				logger.error("DescargaDAOImpl :: findDescargas :: stm", e);
			}
			try {
				if(cnn != null)
					cnn.close();
			} catch (SQLException e) {
				logger.error("DescargaDAOImpl :: findDescargas :: cnn", e);
			}
		}
		
		return result;
	}
	
	public void eliminar(int id) {
		String sql = "{call iilc.piilc_descargas_excel.sp_eliminar(?)}";
		Connection cnn = getConnection();
		CallableStatement stm = null;
		
		try {
			stm = cnn.prepareCall(sql);
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			logger.error("DescargaDAOImpl :: eliminar", e);
		} catch (NullPointerException e) {
			logger.error("DescargaDAOImpl :: eliminar", e);
		} finally {
			try {
				if(stm != null)
					stm.close();
			} catch (SQLException e) {
				logger.error("DescargaDAOImpl :: eliminar :: stm", e);
			}
			try {
				if(cnn != null)
					cnn.close();
			} catch (SQLException e) {
				logger.error("DescargaDAOImpl :: eliminar :: cnn", e);
			}
		}
	}
	
}