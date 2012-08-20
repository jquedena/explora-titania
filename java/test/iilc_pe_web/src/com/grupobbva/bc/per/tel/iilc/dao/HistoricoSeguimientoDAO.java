package com.grupobbva.bc.per.tel.iilc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_his_ingresos_carp_com;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;

@Service("historicoSeguimientoDAO")
public class HistoricoSeguimientoDAO {
	Connection conn;
	Statement stmt;

	public void eliminarHistorico() {

		try {
			DataSource datasource = null;
			Connection con = null;
			CallableStatement stmt = null; 
				Context initialContext = new InitialContext();
				datasource = (DataSource) initialContext
						.lookup(Constantes.DATASOURCE_CONTEXT);
				con = datasource.getConnection();
				String query = "{ call IILC.PIILC_UTILITARIO.sp_eliminar_historico() }";
				stmt = con.prepareCall(query);
				stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Tiilc_his_ingresos_carp_com getHistorico(String sessionid) {
		Tiilc_his_ingresos_carp_com historico = null;
		try {
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			String sql = "SELECT * FROM iilc.TIILC_HIS_INGRESOS_CARP_COM WHERE ID_REGISTRO = '"
					+ sessionid + "'";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {

				historico = new Tiilc_his_ingresos_carp_com();
				historico.setRegistro_id(rs.getString(1));
				historico.setFecha(rs.getString(2));
				historico.setCod_territorio(rs.getString(3));
				historico.setCod_oficina(rs.getString(4));
				historico.setCod_perfil(rs.getString(5));
				historico.setCod_gestor(rs.getString(6));
				historico.setNivel_vinculacion(rs.getInt(7));
				historico.setClasificacion(rs.getInt(8));
				historico.setMargen_ordinario(rs.getInt(9));
				historico.setEtiqueta(rs.getInt(10));
				historico.setEdad(rs.getInt(11));
				historico.setCuota(rs.getInt(12));
				historico.setPago(rs.getInt(13));
				historico.setTodos(rs.getInt(14));
				historico.setActivo(rs.getInt(15));
				historico.setTarjetas(rs.getInt(16));
				historico.setPasivo(rs.getInt(17));
				historico.setServicios(rs.getInt(18));
				historico.setCanales(rs.getInt(19));
				historico.setOfertas(rs.getInt(20));
				historico.setExportar(rs.getInt(21));

			}

			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return historico;

	}

	public void actualizarHistorico(Tiilc_his_ingresos_carp_com historico) {

		try {
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			String sql = "UPDATE iilc.TIILC_HIS_INGRESOS_CARP_COM "
					+ "   SET NIVEL_VINCULACION = ? , CLASIFICACION = ? , MARGEN_ORDINARIO = ?, ETIQUETA = ? , EDAD = ? , CUOTA_RIESGO_TOT = ?, PAGO_HABERES = ? , TODOS = ?, ACTIVO = ?, TARJETAS = ?, PASIVO = ? , SERVICIOS = ? , CANALES = ? , OFERTAS = ? ,EXPORTAR = ?    "
					+ " WHERE ID_REGISTRO =? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			/*
			 * pstmt.setString(1, entidad.getDescorta()); pstmt.setString(2,
			 * entidad.getDeslarga()); pstmt.setString(3,
			 * entidad.getUsuaModi()); pstmt.setDate(4, sqlDate);
			 * pstmt.setInt(5, new Integer(entidad.getTipo()));
			 */

			pstmt.setInt(1, historico.getNivel_vinculacion());
			pstmt.setInt(2, historico.getClasificacion());
			pstmt.setInt(3, historico.getMargen_ordinario());
			pstmt.setInt(4, historico.getEtiqueta());
			pstmt.setInt(5, historico.getEdad());
			pstmt.setInt(6, historico.getCuota());
			pstmt.setInt(7, historico.getPago());
			pstmt.setInt(8, historico.getTodos());
			pstmt.setInt(9, historico.getActivo());
			pstmt.setInt(10, historico.getTarjetas());
			pstmt.setInt(11, historico.getPasivo());
			pstmt.setInt(12, historico.getServicios());
			pstmt.setInt(13, historico.getCanales());
			pstmt.setInt(14, historico.getOfertas());
			pstmt.setInt(15, historico.getExportar());
			pstmt.setString(16, historico.getRegistro_id());

			pstmt.executeUpdate();
			// conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void registrarHistorico(Tiilc_his_ingresos_carp_com historico) {

		try {
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			String sql = " INSERT INTO iilc.TIILC_HIS_INGRESOS_CARP_COM "
					+ "   (ID_REGISTRO,FECHA_INGRESO,COD_TERRITORIO,COD_OFICINA, COD_PERFIL,COD_GESTOR,NIVEL_VINCULACION , CLASIFICACION , MARGEN_ORDINARIO , ETIQUETA , EDAD , CUOTA_RIESGO_TOT , PAGO_HABERES  , TODOS , ACTIVO , TARJETAS , PASIVO  , SERVICIOS  , CANALES , OFERTAS ,EXPORTAR ,USUREG, FECREG,NOMBRE_USUREG,COD_CARGO,DES_CARGO )   "
					+ "    VALUES (?, ? ,? ,?,?, ? ,? ,?,?, ? ,? ,?,?, ? ,? ,?,?, ? ,? ,?,?,?,?,?,?,?) ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			pstmt.setString(1, historico.getRegistro_id());
			pstmt.setDate(2, sqlDate);
			pstmt.setString(3, historico.getCod_territorio());
			pstmt.setString(4, historico.getCod_oficina());
			pstmt.setString(5, historico.getCod_perfil());
			pstmt.setString(6, historico.getCod_gestor());

			pstmt.setInt(7, historico.getNivel_vinculacion());
			pstmt.setInt(8, historico.getClasificacion());
			pstmt.setInt(9, historico.getMargen_ordinario());
			pstmt.setInt(10, historico.getEtiqueta());
			pstmt.setInt(11, historico.getEdad());
			pstmt.setInt(12, historico.getCuota());
			pstmt.setInt(13, historico.getPago());
			pstmt.setInt(14, historico.getTodos());
			pstmt.setInt(15, historico.getActivo());
			pstmt.setInt(16, historico.getTarjetas());
			pstmt.setInt(17, historico.getPasivo());
			pstmt.setInt(18, historico.getServicios());
			pstmt.setInt(19, historico.getCanales());
			pstmt.setInt(20, historico.getOfertas());
			pstmt.setInt(21, historico.getExportar());
			pstmt.setString(22, historico.getUsuario());
			pstmt.setDate(23, sqlDate);
			pstmt.setString(24, historico.getNombre_usuario());
			pstmt.setString(25, historico.getCod_cargo());
			pstmt.setString(26, historico.getDes_cargo());
			pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actualizarHistorico2(Tiilc_his_ingresos_carp_com historico) {

		try {
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			String sql = "UPDATE iilc.TIILC_HIS_INGRESOS_CARP_COM "
					+ "   SET TODOS = ?, ACTIVO = ?, TARJETAS = ?, PASIVO = ? , SERVICIOS = ? , CANALES = ? , OFERTAS = ? ,EXPORTAR = ?    "
					+ " WHERE ID_REGISTRO =? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			pstmt.setInt(1, historico.getTodos());
			pstmt.setInt(2, historico.getActivo());
			pstmt.setInt(3, historico.getTarjetas());
			pstmt.setInt(4, historico.getPasivo());
			pstmt.setInt(5, historico.getServicios());
			pstmt.setInt(6, historico.getCanales());
			pstmt.setInt(7, historico.getOfertas());
			pstmt.setInt(8, historico.getExportar());
			pstmt.setString(9, historico.getRegistro_id());

			pstmt.executeUpdate();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
