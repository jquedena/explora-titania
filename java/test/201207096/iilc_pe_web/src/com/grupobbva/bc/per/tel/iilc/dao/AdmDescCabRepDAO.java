package com.grupobbva.bc.per.tel.iilc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;

@SuppressWarnings({"unchecked"})
public class AdmDescCabRepDAO {
	Connection conn;
	Statement stmt;

	public AdmDescCabRepDAO() {

	}

	public List obtenerDescripcion(String tipoConfiguracion) {
		List listado = new ArrayList();
		String query = "";
		try {

			query = "Select * from iilc.TIILC_CONF_CABECERAS_REP where TIPO  = "
					+ tipoConfiguracion + "  order by orden ";

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				Tiilc_conf_cabeceras_rep confcabe = new Tiilc_conf_cabeceras_rep();
				confcabe.setTipo(rs.getString(1));
				confcabe.setOrden(rs.getString(2));
				confcabe.setCampo(rs.getString(3));
				confcabe.setDescorta(rs.getString(4));
				confcabe.setDeslarga(rs.getString(5));
				confcabe.setDetalle(rs.getString(10));
				confcabe.setFuncion(rs.getString(11));
				confcabe.setAgrupador1(rs.getString("agrupador_1"));
				confcabe.setAgrupador2(rs.getString("agrupador_2"));
				confcabe.setEstilo(rs.getString("estilo"));
				confcabe.setOculto(rs.getString("oculto") == null ? "0" : rs.getString("oculto"));
				
				listado.add(confcabe);
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listado;
	}

	public void actualizarDescripcion(Tiilc_conf_cabeceras_rep entidad) {

		try {
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			String sql = "UPDATE iilc.TIILC_CONF_CABECERAS_REP "
					+ "   SET DSC_CORTA=?, DSC_LARGA=?, USUMOD = ? , FECMOD = ? "
					+ " WHERE TIPO = ? and ORDEN =? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			pstmt.setString(1, entidad.getDescorta());
			pstmt.setString(2, entidad.getDeslarga());
			pstmt.setString(3, entidad.getUsuaModi());
			pstmt.setDate(4, sqlDate);
			pstmt.setInt(5, new Integer(entidad.getTipo()));
			pstmt.setInt(6, new Integer(entidad.getOrden()));
			pstmt.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarDescripcionAgrupada(Tiilc_conf_cabeceras_rep entidad) {

		try {
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			String sql = "UPDATE iilc.TIILC_CONF_CABECERAS_REP "
					+ " SET DSC_CORTA=?, DSC_LARGA=?, USUMOD = ? , FECMOD = ?, AGRUPADOR_1 = ?, AGRUPADOR_2 = ?, OCULTO = ? "
					+ " WHERE TIPO = ? and ORDEN =? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			pstmt.setString(1, entidad.getDescorta());
			pstmt.setString(2, entidad.getDeslarga());
			pstmt.setString(3, entidad.getUsuaModi());
			pstmt.setDate(4, sqlDate);
			pstmt.setString(5, entidad.getAgrupador1());
			pstmt.setString(6, entidad.getAgrupador2());
			pstmt.setString(7, entidad.getOculto());
			pstmt.setInt(8, new Integer(entidad.getTipo()));
			pstmt.setInt(9, new Integer(entidad.getOrden()));
			pstmt.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
