package com.grupobbva.bc.per.tel.iilc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.jdbc.driver.OracleTypes;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_his_ingresos_carp_com;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_vinculacion_gco;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_vinculacion_ph;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_vinculacion_vip;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.servlet.ApplicationInitServlet;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;

@SuppressWarnings( { "unused", "unchecked" })
public class ReporteVinculacionDAO_Old {
	private Connection conn;
	private Statement stmt;
	private static Logger logger = Logger.getLogger(ApplicationInitServlet.class);
	private String cod_terr;
	
	public ResultSet obtenerPagina(String procedimiento, int pagina, String idTerritorio, String idOficina, String idGestor) {
		Context initialContext = null;
		DataSource datasource = null;
		Connection cnn = null;
		CallableStatement stm = null;
		ResultSet result = null;
		try {
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				logger.info("initialContext = null");
				return result;
			}
			
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
			
			if (datasource != null) {
				cnn = datasource.getConnection();
			} else {
				initialContext = null;
				logger.info("datasource = null");
				return result;
			}
			
			String sql = "{call iilc.piilc_paginacion_vinculacion." + procedimiento + "(?, ?, ?, ?, ?)}";			
			logger.info("query: " + sql);

			stm = cnn.prepareCall(sql);
			stm.setInt("pagina", pagina);
			stm.setString("id_territorio", idTerritorio);
			stm.setString("id_oficina", idOficina);
			stm.setString("id_gestor", idGestor);
			stm.registerOutParameter("result_pagina", OracleTypes.CURSOR);
			stm.execute();
		
			result = (ResultSet) stm.getObject("result_pagina");
		} catch (SQLException e) {
			logger.error("SQLException = " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("Exception = " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {	
				if (stm != null) {
					stm.close();
				}
	
				if (cnn != null) {
					cnn.close();
				}
	
				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				logger.error("Cerrando la conexion. Exception = " + e.getMessage());	
				return result;
			}
		}
		
		return result;		
	}
	
	public List obtenerCabeceras(String tipoConfiguracion) {
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
				confcabe.setDescorta("<span title='" + rs.getString(5) + "'>"
						+ rs.getString(4) + "</span>");
				confcabe.setDeslarga(rs.getString(5));
				confcabe.setDetalle(rs.getString(10));
				confcabe.setFuncion(rs.getString(11));

				listado.add(confcabe);

			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error("obtenerCabeceras", e);
		}

		return listado;
	}

	public Vector<Multitabla> obtenerFiltroPerfil() {
		Vector<Multitabla> listado = new Vector();
		String query = "";
		try {

			query = "select perfil from iilc.tiilc_vinculacion_vip  group by perfil";

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Multitabla bean = new Multitabla();
				bean.setCod_mult("");
				bean.setCod_ele(rs.getString(1).substring(0, 1));
				bean.setValor1(rs.getString(1));
				bean.setValor2(rs.getString(1));
				listado.add(bean);

			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listado;
	}

	public String obtenerDescripcionTerritorio(String codigo) {
		String query = "";
		try {
			query = "select * from iilc.tiilc_territorio where cod_territorio='" + codigo + "'";
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				return rs.getString("des_territorio");
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "";
	}

	public Vector<Multitabla> obtenerFiltroTerritorio(String cod_area, String codUsuario) {
		Vector<Multitabla> listado = new Vector();
		String query = "";
		try {

			if (!cod_area.equals(Constantes.TODOS_TERRITORIOS)) {
				cod_area = " cod_area='" + cod_area + "' and ";
			} else {
				cod_area = "";
			}

			if(codUsuario.length()==0) {
				query = "select * from iilc.tiilc_territorio "; // where substr(des_territorio,0,4)='G.T.' 
			} else { 
				query = "select * from iilc.tiilc_territorio a inner join ("
						  + " select cod_territorio from iilc.tiilc_permiso_usuario_consulta where cod_usuario='" 
						  + codUsuario 
						  + "' group by cod_territorio) b on a.cod_territorio=b.cod_territorio";
			}
			
			
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Multitabla bean = new Multitabla();
				bean.setCod_mult("");
				bean.setCod_ele(rs.getString("cod_territorio"));
				bean.setValor1(rs.getString("des_territorio"));
				listado.add(bean);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listado;
	}

	public String obtenerDescripcionOficina(String codigo) {
		Vector<Multitabla> listado = new Vector();
		String query = "";
		try {
			query = "select * from iilc.tiilc_oficina where cod_oficina='" + codigo
					+ "'";
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				return rs.getString("des_oficina");
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "";
	}

	public Vector<Multitabla> obtenerFiltroOficina(String cod_territorio, String codUsuario) {
		Vector<Multitabla> listado = new Vector();
		String query = "";
		try {

			StringTokenizer cod_territorioTok = new StringTokenizer(
					cod_territorio + ",", ",");
			cod_territorio = "";
			int i = 0;
			while (cod_territorioTok.hasMoreTokens()) {
				cod_territorio = cod_territorio + "'" + cod_territorioTok.nextToken() + "'";
				if (cod_territorioTok.hasMoreTokens()) {
					cod_territorio = cod_territorio + ",";
				}
				i++;
			}

			if(codUsuario.length()==0) {
				query = "select * from iilc.tiilc_oficina where cod_territorio in ("
						+ cod_territorio + ") ";
			} else {
				query = "select * from iilc.tiilc_oficina a inner join ("
				  + " select cod_oficina from iilc.tiilc_permiso_usuario_consulta where cod_usuario='" 
				  + codUsuario 
				  + "' group by cod_oficina) b on a.cod_oficina=b.cod_oficina"
				  + " where cod_territorio in (" + cod_territorio + ") ";
			}
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Multitabla bean = new Multitabla();
				bean.setCod_mult("");
				bean.setCod_ele(rs.getString("cod_oficina"));
				bean.setValor1(rs.getString("des_oficina"));
				listado.add(bean);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listado;
	}

	public Vector<Multitabla> obtenerFiltroPerfilGeneral() {
		Vector<Multitabla> listado = new Vector();
		String query = "";
		try {

			query = "select * from iilc.tiilc_perfil where cod_perfil not in('LC05')";

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Multitabla bean = new Multitabla();
				bean.setCod_mult("");
				bean.setCod_ele(rs.getString("cod_perfil"));
				bean.setValor1(rs.getString("des_perfil"));
				listado.add(bean);

			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listado;
	}

	public String obtenerDescripcionGestor(String codigo) {
		Vector<Multitabla> listado = new Vector();
		String query = "";
		try {
			query = "select * from iilc.tiilc_gestor where cod_gestor='" + codigo + "'";
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				return rs.getString("nom_gestor");
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "";
	}

	public Vector<Multitabla> obtenerFiltroGestor(String cod_territorio,
			String oficina) {
		Vector<Multitabla> listado = new Vector();
		String query = "";
		try {

			query = "select * from tiilc_gestor where  cod_oficina in("
					+ oficina + ") ";
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Multitabla bean = new Multitabla();
				bean.setCod_mult("");
				bean.setCod_ele("'"+rs.getString("cod_gestor")+"'");
				bean.setValor1(rs.getString("cod_oficina") + " - " + rs.getString("nom_gestor"));
				listado.add(bean);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listado;
	}

	public List construirSelectHistorico(String tipoReporte,
			String fechaInicio, String fechaFin, String territorio,
			String oficina, String perfil, String gestor, String pagina) {
		List listado = new ArrayList();
		String query = "";
		try {

			StringTokenizer fechaInicioTok = new StringTokenizer(fechaInicio
					+ "-", "-");
			fechaInicio = Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio = fechaInicio + "-"
					+ Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio = fechaInicio + "-"
					+ Utilitario.dosCeros(fechaInicioTok.nextToken());

			StringTokenizer fechaFinTok = new StringTokenizer(fechaFin + "-",
					"-");
			fechaFin = Utilitario.dosCeros(fechaFinTok.nextToken());
			fechaFin = fechaFin + "-"
					+ Utilitario.dosCeros(fechaFinTok.nextToken());
			fechaFin = fechaFin + "-"
					+ Utilitario.dosCeros(fechaFinTok.nextToken());

			String campoConsolidadoDia = "";
			String condicional = "";

			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				condicional = condicional + " and c.cod_territorio in ("
						+ territorio + ") ";
			}

			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				condicional = condicional + " and c.cod_oficina in (" + oficina
						+ ") ";
			}

			if (perfil != null && !perfil.equals("-1")) {

				StringTokenizer perfilTok = new StringTokenizer(perfil + ",",
						",");
				perfil = "";
				int i = 0;
				while (perfilTok.hasMoreTokens()) {
					perfil = perfil + "'" + perfilTok.nextToken() + "'";
					if (perfilTok.hasMoreTokens()) {
						perfil = perfil + ",";
					}
					i++;
				}

				condicional = condicional + " and c.COD_PERFIL in (" + perfil
						+ ") ";
			}

			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				condicional = condicional + " and c.cod_gestor in (" + gestor
						+ ") ";
			}

			if (tipoReporte.equals("D")) {
				campoConsolidadoDia = ",to_char(FECHA_INGRESO,'dd/mm/yyyy') FECHA_INGRESO,C.FECHA_INGRESO FECHA ";
			}
			query = " SELECT  " + " c.COD_TERRITORIO," + " t.DES_TERRITORIO,"
					+ " c.COD_OFICINA," + " o.DES_OFICINA," 
					//+ " c.COD_GESTOR,"
					//+ " g.NOM_GESTOR," 
					+ " c.des_cargo," 
					+ " c.NOMBRE_USUREG,"
					+ " c.USUREG," 
					+ "c.COD_CARGO" 
					+ campoConsolidadoDia
					+ ","
					+ " count(*) TOTAL,"
					+ " sum(NIVEL_VINCULACION) NIVEL_VINCULACION,"
					+ " sum(CLASIFICACION) CLASIFICACION,"
					+ " sum(MARGEN_ORDINARIO) MARGEN_ORDINARIO,"
					+ " sum(ETIQUETA) ETIQUETA,"
					+ " sum(EDAD) EDAD,"
					+ " sum(CUOTA_RIESGO_TOT) CUOTA_RIESGO_TOT,"
					+ " sum(PAGO_HABERES) PAGO_HABERES,"
					+ " sum(TODOS) TODOS,"
					+ " sum(ACTIVO) ACTIVO,"
					+ " sum(TARJETAS) TARJETAS,"
					+ " sum(PASIVO) PASIVO,"
					+ " sum(SERVICIOS) SERVICIOS,"
					+ " sum(CANALES) CANALES,"
					+ " sum(OFERTAS) OFERTAS,"
					+ " sum(EXPORTAR) EXPORTAR"
					+ " FROM iilc.TIILC_HIS_INGRESOS_CARP_COM c"
					+ " left join tiilc_territorio t on t.cod_territorio=c.cod_territorio"
					+ " left join tiilc_oficina o on o.cod_oficina=c.cod_oficina"
					+ " left join tiilc_gestor g on g.cod_gestor=c.cod_gestor"
					+ " WHERE FECHA_INGRESO between to_date('"
					+ fechaInicio
					+ "','dd-MM-yyyy') and to_date('"
					+ fechaFin
					+ "','dd-MM-yyyy') "
					+ " "
					+ condicional
					+ " group by c.COD_TERRITORIO,t.DES_TERRITORIO,"
					+ " c.COD_OFICINA,o.DES_OFICINA,"
					//+ " c.COD_GESTOR,"
					//+ " g.NOM_GESTOR,"
					+ " c.des_cargo,"
					+ " c.NOMBRE_USUREG,"
					+ " c.USUREG," 
					+ "c.cod_cargo  ";

			if (tipoReporte.equals("D")) {
				query = query + ",FECHA_INGRESO ";
				query = "select * from (" + query + ") x order by x.FECHA asc";
			}

			/* Esta parte sera para usar el select con paginacion */
			int inicio = 0;
			int fin = 0;
			int pagina_entera = Integer.parseInt(pagina);
			if (pagina_entera == 1) {
				inicio = 1;
				fin = Constantes.PAGINACION_VINCULACION;
			} else {
				inicio = (Constantes.PAGINACION_VINCULACION * (pagina_entera - 1)) + 1;
				fin = pagina_entera * Constantes.PAGINACION_VINCULACION;
			}

			query = paginarSelect(query, inicio, fin);
			/* fin de parte select con paginacion */

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Tiilc_his_ingresos_carp_com bean = new Tiilc_his_ingresos_carp_com();

				bean.setCod_territorio(rs.getString("cod_territorio"));
				bean.setDes_territorio(rs.getString("des_territorio"));
				bean.setCod_oficina(rs.getString("cod_oficina"));
				bean.setDes_oficina(rs.getString("des_oficina"));
				bean.setUsuario(rs.getString("USUREG"));
				if (StringUtils.isNotBlank(bean.getCod_oficina()) && (StringUtils.isBlank(bean.getDes_oficina()))) {
					IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(bean.getUsuario().trim().toUpperCase());
					bean.setDes_oficina(user.getBancoOficina().getDescripcion());

				}

				bean.setCod_cargo(rs.getString("cod_cargo"));
				bean.setDes_cargo(rs.getString("des_cargo"));
				//bean.setCod_gestor(rs.getString("cod_gestor"));
				/*if (bean.getCod_perfil().equals("LC01")
						|| bean.getCod_perfil().equals("LC02")) {
					bean.setNom_gestor(rs.getString("NOMBRE_USUREG"));
				} else {
					bean.setNom_gestor(rs.getString("nom_gestor"));
				}
				*/
				if (tipoReporte.equals("D")) {
					bean.setFecha_ingreso(rs.getString("fecha_ingreso"));
				}

				bean.setNivel_vinculacion(rs.getInt("nivel_vinculacion"));
				bean.setClasificacion(rs.getInt("clasificacion"));
				bean.setMargen_ordinario(rs.getInt("margen_ordinario"));
				bean.setEtiqueta(rs.getInt("etiqueta"));
				bean.setEdad(rs.getInt("edad"));
				bean.setCuota(rs.getInt("CUOTA_RIESGO_TOT"));
				bean.setPago(rs.getInt("PAGO_HABERES"));
				bean.setTodos(rs.getInt("TODOS"));
				bean.setActivo(rs.getInt("activo"));
				bean.setTarjetas(rs.getInt("tarjetas"));
				bean.setPasivo(rs.getInt("pasivo"));
				bean.setServicios(rs.getInt("servicios"));
				bean.setCanales(rs.getInt("canales"));
				bean.setOfertas(rs.getInt("ofertas"));
				bean.setExportar(rs.getInt("exportar"));
				bean.setTotal(rs.getInt("TOTAL"));
				bean.setNombre_usuario(rs.getString("NOMBRE_USUREG"));
				listado.add(bean);
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return listado;
	}

	public String validarFechas(String fechaInicio, String fechaFin,
			String formato) {
		String query = "";
		try {

			StringTokenizer fechaInicioTok = new StringTokenizer(fechaInicio
					+ "-", "-");
			fechaInicio = Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio = fechaInicio + "-"
					+ Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio = fechaInicio + "-"
					+ Utilitario.dosCeros(fechaInicioTok.nextToken());

			StringTokenizer fechaFinTok = new StringTokenizer(fechaFin + "-",
					"-");
			fechaFin = Utilitario.dosCeros(fechaFinTok.nextToken());
			fechaFin = fechaFin + "-"
					+ Utilitario.dosCeros(fechaFinTok.nextToken());
			fechaFin = fechaFin + "-"
					+ Utilitario.dosCeros(fechaFinTok.nextToken());

			query = "  select case when  to_date('" + fechaInicio + "','"
					+ formato + "') > to_date('" + fechaFin + "','" + formato
					+ "') then '1' else '0' end as resultado from dual";

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return rs.getString("resultado");
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "1";
	}

	public List construirSelectHistoricoCompleto(String tipoReporte,
			String fechaInicio, String fechaFin, String territorio,
			String oficina, String perfil, String gestor) {
		List listado = new ArrayList();
		String query = "";
		try {

			StringTokenizer fechaInicioTok = new StringTokenizer(fechaInicio
					+ "-", "-");
			fechaInicio = Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio = fechaInicio + "-"
					+ Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio = fechaInicio + "-"
					+ Utilitario.dosCeros(fechaInicioTok.nextToken());

			StringTokenizer fechaFinTok = new StringTokenizer(fechaFin + "-",
					"-");
			fechaFin = Utilitario.dosCeros(fechaFinTok.nextToken());
			fechaFin = fechaFin + "-"
					+ Utilitario.dosCeros(fechaFinTok.nextToken());
			fechaFin = fechaFin + "-"
					+ Utilitario.dosCeros(fechaFinTok.nextToken());

			String campoConsolidadoDia = "";
			String condicional = "";

			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				condicional = condicional + " and c.cod_territorio in ("
						+ territorio + ") ";
			}

			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				condicional = condicional + " and c.cod_oficina in (" + oficina
						+ ") ";
			}

			if (perfil != null && !perfil.equals("-1")) {

				StringTokenizer perfilTok = new StringTokenizer(perfil + ",",
						",");
				perfil = "";
				int i = 0;
				while (perfilTok.hasMoreTokens()) {
					perfil = perfil + "'" + perfilTok.nextToken() + "'";
					if (perfilTok.hasMoreTokens()) {
						perfil = perfil + ",";
					}
					i++;
				}

				condicional = condicional + " and c.COD_PERFIL in (" + perfil
						+ ") ";
			}

			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				condicional = condicional + " and c.cod_gestor in (" + gestor
						+ ") ";
			}

			if (tipoReporte.equals("D")) {
				campoConsolidadoDia = ",to_char(FECHA_INGRESO,'dd/mm/yyyy') FECHA_INGRESO,c.FECHA_INGRESO FECHA ";
			}
			query = " SELECT  " + " c.COD_TERRITORIO," + " t.DES_TERRITORIO,"
					+ " c.COD_OFICINA," + " o.DES_OFICINA," 
					//+ " c.COD_GESTOR,"
					//+ " g.NOM_GESTOR," 
					+ " c.DES_CARGO," 
					+ " c.USUREG,"
					+ " c.NOMBRE_USUREG," 
					+ " c.COD_CARGO "
					+ campoConsolidadoDia
					+ ","
					+ " count(*) TOTAL,"
					+ " sum(NIVEL_VINCULACION) NIVEL_VINCULACION,"
					+ " sum(CLASIFICACION) CLASIFICACION,"
					+ " sum(MARGEN_ORDINARIO) MARGEN_ORDINARIO,"
					+ " sum(ETIQUETA) ETIQUETA,"
					+ " sum(EDAD) EDAD,"
					+ " sum(CUOTA_RIESGO_TOT) CUOTA_RIESGO_TOT,"
					+ " sum(PAGO_HABERES) PAGO_HABERES,"
					+ " sum(TODOS) TODOS,"
					+ " sum(ACTIVO) ACTIVO,"
					+ " sum(TARJETAS) TARJETAS,"
					+ " sum(PASIVO) PASIVO,"
					+ " sum(SERVICIOS) SERVICIOS,"
					+ " sum(CANALES) CANALES,"
					+ " sum(OFERTAS) OFERTAS,"
					+ " sum(EXPORTAR) EXPORTAR"
					+ " FROM iilc.TIILC_HIS_INGRESOS_CARP_COM c"
					+ " left join tiilc_territorio t on t.cod_territorio=c.cod_territorio"
					+ " left join tiilc_oficina o on o.cod_oficina=c.cod_oficina"
					+ " left join tiilc_gestor g on g.cod_gestor=c.cod_gestor"
					+ " WHERE rownum<="
					+ Constantes.MAXIMO_REGISTROS_REPORTE_EXCEL
					+ " and FECHA_INGRESO between to_date('"
					+ fechaInicio
					+ "','dd-MM-yyyy') and to_date('"
					+ fechaFin
					+ "','dd-MM-yyyy') "
					+ " "
					+ condicional
					+ " group by c.COD_TERRITORIO,t.DES_TERRITORIO,"
					+ " c.COD_OFICINA,o.DES_OFICINA,"
					//+ " c.COD_GESTOR,"
					//+ " g.NOM_GESTOR,"
					+ " c.USUREG,"
					+ " c.NOMBRE_USUREG,"
					+ " c.DES_CARGO," + " c.COD_CARGO ";

			if (tipoReporte.equals("D")) {
				query = query + ",FECHA_INGRESO ";

				query = "select * from (" + query + ") x order by x.FECHA asc";
			}

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Tiilc_his_ingresos_carp_com bean = new Tiilc_his_ingresos_carp_com();

				bean.setCod_territorio(rs.getString("cod_territorio"));
				bean.setDes_territorio(rs.getString("des_territorio"));
				bean.setCod_oficina(rs.getString("cod_oficina"));
				bean.setDes_oficina(rs.getString("des_oficina"));
				bean.setNombre_usuario(rs.getString("NOMBRE_USUREG"));
				bean.setUsuario(rs.getString("USUREG"));
				if (StringUtils.isNotBlank(bean.getCod_oficina())
						&& (StringUtils.isBlank(bean.getDes_oficina()))) {
					IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(bean
							.getUsuario().trim().toUpperCase());

					bean
							.setDes_oficina(user.getBancoOficina()
									.getDescripcion());

				}

				bean.setDes_cargo(rs.getString("des_cargo"));
				bean.setCod_cargo(rs.getString("cod_cargo"));
				//bean.setCod_gestor(rs.getString("cod_gestor"));
				//bean.setNom_gestor(rs.getString("nom_gestor"));

				if (tipoReporte.equals("D")) {
					bean.setFecha_ingreso(rs.getString("fecha_ingreso"));
				}

				bean.setNivel_vinculacion(rs.getInt("nivel_vinculacion"));
				bean.setClasificacion(rs.getInt("clasificacion"));
				bean.setMargen_ordinario(rs.getInt("margen_ordinario"));
				bean.setEtiqueta(rs.getInt("etiqueta"));
				bean.setEdad(rs.getInt("edad"));
				bean.setCuota(rs.getInt("CUOTA_RIESGO_TOT"));
				bean.setPago(rs.getInt("PAGO_HABERES"));
				bean.setTodos(rs.getInt("TODOS"));
				bean.setActivo(rs.getInt("activo"));
				bean.setTarjetas(rs.getInt("tarjetas"));
				bean.setPasivo(rs.getInt("pasivo"));
				bean.setServicios(rs.getInt("servicios"));
				bean.setCanales(rs.getInt("canales"));
				bean.setOfertas(rs.getInt("ofertas"));
				bean.setExportar(rs.getInt("exportar"));
				bean.setTotal(rs.getInt("TOTAL"));

				listado.add(bean);
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listado;
	}

	public int contarSelectHistorico(String tipoReporte, String fechaInicio,
			String fechaFin, String territorio, String oficina, String perfil,
			String gestor) {

		String query = "";
		try {

			StringTokenizer fechaInicioTok = new StringTokenizer(fechaInicio
					+ "-", "-");
			fechaInicio = Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio = fechaInicio + "-"
					+ Utilitario.dosCeros(fechaInicioTok.nextToken());
			fechaInicio = fechaInicio + "-"
					+ Utilitario.dosCeros(fechaInicioTok.nextToken());

			StringTokenizer fechaFinTok = new StringTokenizer(fechaFin + "-",
					"-");
			fechaFin = Utilitario.dosCeros(fechaFinTok.nextToken());
			fechaFin = fechaFin + "-"
					+ Utilitario.dosCeros(fechaFinTok.nextToken());
			fechaFin = fechaFin + "-"
					+ Utilitario.dosCeros(fechaFinTok.nextToken());

			String campoConsolidadoDia = "";
			String condicional = "";

			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				condicional = condicional + " and c.cod_territorio in ("
						+ territorio + ") ";
			}

			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				condicional = condicional + " and c.cod_oficina in (" + oficina
						+ ") ";
			}

			if (perfil != null && !perfil.equals("-1")) {

				StringTokenizer perfilTok = new StringTokenizer(perfil + ",",
						",");
				perfil = "";
				int i = 0;
				while (perfilTok.hasMoreTokens()) {
					perfil = perfil + "'" + perfilTok.nextToken() + "'";
					if (perfilTok.hasMoreTokens()) {
						perfil = perfil + ",";
					}
					i++;
				}

				condicional = condicional + " and c.COD_PERFIL in (" + perfil
						+ ") ";
			}

			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				condicional = condicional + " and c.cod_gestor in (" + gestor
						+ ") ";
			}

			if (tipoReporte.equals("D")) {
				campoConsolidadoDia = ",to_char(FECHA_INGRESO,'dd/mm/yyyy') FECHA_INGRESO ";
			}

			query = " SELECT  " + " c.COD_TERRITORIO," + " t.DES_TERRITORIO,"
					+ " c.COD_OFICINA," 
					+ " o.DES_OFICINA,"
					//+ " c.COD_GESTOR,"
					//+ " g.NOM_GESTOR,"
					+ " c.NOMBRE_USUREG,"
					+ " c.USUREG," 
					+ " c.des_cargo"
					+ campoConsolidadoDia
					+ ","
					+ " count(*) TOTAL,"
					+ " sum(NIVEL_VINCULACION) NIVEL_VINCULACION,"
					+ " sum(CLASIFICACION) CLASIFICACION,"
					+ " sum(MARGEN_ORDINARIO) MARGEN_ORDINARIO,"
					+ " sum(ETIQUETA) ETIQUETA,"
					+ " sum(EDAD) EDAD,"
					+ " sum(CUOTA_RIESGO_TOT) CUOTA_RIESGO_TOT,"
					+ " sum(PAGO_HABERES) PAGO_HABERES,"
					+ " sum(TODOS) TODOS,"
					+ " sum(ACTIVO) ACTIVO,"
					+ " sum(TARJETAS) TARJETAS,"
					+ " sum(PASIVO) PASIVO,"
					+ " sum(SERVICIOS) SERVICIOS,"
					+ " sum(CANALES) CANALES,"
					+ " sum(OFERTAS) OFERTAS,"
					+ " sum(EXPORTAR) EXPORTAR"
					+ " FROM iilc.TIILC_HIS_INGRESOS_CARP_COM c"
					+ " left join tiilc_territorio t on t.cod_territorio=c.cod_territorio"
					+ " left join tiilc_oficina o on o.cod_oficina=c.cod_oficina"
					+ " left join tiilc_gestor g on g.cod_gestor=c.cod_gestor"
					+ " WHERE rownum<="
					+ Constantes.MAXIMO_REGISTROS_REPORTE_EXCEL
					+ " and FECHA_INGRESO between to_date('"
					+ fechaInicio
					+ "','dd-MM-yyyy') and to_date('"
					+ fechaFin
					+ "','dd-MM-yyyy') "
					+ " "
					+ condicional
					+ " group by c.COD_TERRITORIO,t.DES_TERRITORIO,"
					+ " c.COD_OFICINA,o.DES_OFICINA,"
					+ " c.NOMBRE_USUREG,"
					+ " c.USUREG," 
					//+ " c.COD_GESTOR,"
					//+ " g.NOM_GESTOR," 
					+ " c.DES_CARGO ";

			if (tipoReporte.equals("D")) {
				query = query + ",FECHA_INGRESO order by FECHA_INGRESO asc";
			}

			query = "select " + " case when mod(count(*),"
					+ Constantes.PAGINACION_VINCULACION
					+ ")>0 then ((count(*)-mod(count(*),"
					+ Constantes.PAGINACION_VINCULACION + "))/"
					+ Constantes.PAGINACION_VINCULACION + ")+1 else count(*)/"
					+ Constantes.PAGINACION_VINCULACION + " end as registros "
					+ " from (" + query + ")";

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return rs.getInt("registros");
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int contarSelectVinculacionVIP(String territorio, String oficina,
			String gestor) {
		String query = "";
		try {

			String where = " ";

			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_territorio in (" + territorio + ") ";
			}
			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_oficina in (" + oficina + ") ";
			}
			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_gestor in (" + gestor + ") ";
			}

			query = "Select case when mod(count(*),"
					+ Constantes.PAGINACION_VINCULACION
					+ ")>0 then ((count(*)-mod(count(*),"
					+ Constantes.PAGINACION_VINCULACION
					+ "))/"
					+ Constantes.PAGINACION_VINCULACION
					+ ")+1 else count(*)/"
					+ Constantes.PAGINACION_VINCULACION
					+ " end as registros from iilc.TIILC_VINCULACION_VIP  t    "
					+ where;
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return Integer.parseInt(rs.getString("registros"));
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return 0;
	}

	public List construirSelectVinculacionVIP(String pagina, String territorio, String oficina, String gestor) {
		List listado = new ArrayList();
		String query = "";
		try {

			String where = " ";
			int inicio = 0;
			int fin = 0;
			
			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_territorio in (" + territorio + ") ";
			}
			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_oficina in (" + oficina + ") ";
			}
			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_gestor in (" + gestor + ") ";
			}
			int pagina_entera = Integer.parseInt(pagina);
			if (pagina_entera == 1) {
				inicio = 1;
				fin = Constantes.PAGINACION_VINCULACION;
			} else {
				inicio = (Constantes.PAGINACION_VINCULACION * (pagina_entera - 1)) + 1;
				fin = pagina_entera * Constantes.PAGINACION_VINCULACION;
			}
			query = "Select t.* from iilc.TIILC_VINCULACION_VIP  t    " + where
					+ "  order by cod_territorio,cod_oficina,codigo_cliente";
			query = paginarSelect(query, inicio, fin);
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();

			logger.info(query);
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Tiilc_vinculacion_vip bean = new Tiilc_vinculacion_vip();
				bean.setCod_oficina(rs.getString("cod_oficina"));
				bean.setCodigo_cliente(rs.getString("codigo_cliente"));
				bean.setNombre_cliente(rs.getString("nombre_cliente"));
				bean.setCod_gestor(rs.getString("cod_gestor"));
				bean.setNom_gestor(rs.getString("nom_gestor"));
				bean.setSegmento(rs.getString("segmento"));
				bean.setAhorro_cta_cero(rs.getString("ahorro_cta_cero"));
				bean.setCuenta_cte_vip(rs.getString("cuenta_cte_vip"));
				bean.setAhorro_cta_gan(rs.getString("ahorro_cta_gan"));
				bean.setOtras_ctas_ahorro(rs.getString("otras_ctas_ahorro"));
				bean.setFamilia1(rs.getString("familia1"));
				bean.setPlazo(rs.getString("plazo"));
				bean.setFondos_mutuos(rs.getString("fondos_mutuos"));
				bean.setBolsa(rs.getString("bolsa"));
				bean.setCts(rs.getString("cts"));
				bean.setFamilia2(rs.getString("familia2"));
				bean.setPres_libre_dis(rs.getString("pres_libre_dis"));
				bean.setPres_auto(rs.getString("pres_auto"));
				bean.setPres_hipotecario(rs.getString("pres_hipotecario"));
				bean.setTc_activas(rs.getString("tc_activas"));
				bean.setFamilia3(rs.getString("familia3"));
				bean.setInfomail(rs.getString("infomail"));
				bean.setHaberes(rs.getString("haberes"));
				bean.setBca_internet(rs.getString("bca_internet"));
				bean.setDomiciliado(rs.getString("domiciliado"));
				bean.setFamilia4(rs.getString("familia4"));
				bean.setVida(rs.getString("vida"));
				bean.setOnc_dent(rs.getString("onc_dent"));
				bean.setProteccion_tc(rs.getString("proteccion_tc"));
				bean.setOtros_seguros(rs.getString("otros_seguros"));
				bean.setFamilia5(rs.getString("familia5"));
				bean.setTotal_puntos(rs.getString("total_puntos"));
				bean.setPerfil(rs.getString("perfil"));
				bean.setLibre1(rs.getString("libre1"));
				bean.setLibre2(rs.getString("libre2"));
				bean.setLibre3(rs.getString("libre3"));
				listado.add(bean);
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return listado;
	}

	public List construirSelectVinculacionVIPCompleto(String territorio,
			String oficina, String gestor) {
		List listado = new ArrayList();
		String query = "";
		try {

			String where = " ";
			int inicio = 0;
			int fin = 0;
			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				where = where + " and  cod_territorio in (" + territorio + ") ";
			}
			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				where = where + " and  cod_oficina in (" + oficina + ") ";
			}
			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				where = where + " and cod_gestor in (" + gestor + ") ";
			}

			query = "Select t.*,rownum from iilc.TIILC_VINCULACION_VIP  t  where rownum<="
					+ Constantes.MAXIMO_REGISTROS_REPORTE_EXCEL
					+ "   "
					+ where
					+ "      "
					+ "  order by cod_territorio,cod_oficina,codigo_cliente";

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();

			logger.info(query);
			logger.info(new Date());
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Tiilc_vinculacion_vip bean = new Tiilc_vinculacion_vip();
				bean.setCod_oficina(rs.getString("cod_oficina"));
				bean.setCodigo_cliente(rs.getString("codigo_cliente"));
				bean.setNombre_cliente(rs.getString("nombre_cliente"));
				bean.setCod_gestor(rs.getString("cod_gestor"));
				bean.setNom_gestor(rs.getString("nom_gestor"));
				bean.setSegmento(rs.getString("segmento"));
				bean.setAhorro_cta_cero(rs.getString("ahorro_cta_cero"));
				bean.setCuenta_cte_vip(rs.getString("cuenta_cte_vip"));
				bean.setAhorro_cta_gan(rs.getString("ahorro_cta_gan"));
				bean.setOtras_ctas_ahorro(rs.getString("otras_ctas_ahorro"));
				bean.setFamilia1(rs.getString("familia1"));
				bean.setPlazo(rs.getString("plazo"));
				bean.setFondos_mutuos(rs.getString("fondos_mutuos"));
				bean.setBolsa(rs.getString("bolsa"));
				bean.setCts(rs.getString("cts"));
				bean.setFamilia2(rs.getString("familia2"));
				bean.setPres_libre_dis(rs.getString("pres_libre_dis"));
				bean.setPres_auto(rs.getString("pres_auto"));
				bean.setPres_hipotecario(rs.getString("pres_hipotecario"));
				bean.setTc_activas(rs.getString("tc_activas"));
				bean.setFamilia3(rs.getString("familia3"));
				bean.setInfomail(rs.getString("infomail"));
				bean.setHaberes(rs.getString("haberes"));
				bean.setBca_internet(rs.getString("bca_internet"));
				bean.setDomiciliado(rs.getString("domiciliado"));
				bean.setFamilia4(rs.getString("familia4"));
				bean.setVida(rs.getString("vida"));
				bean.setOnc_dent(rs.getString("onc_dent"));
				bean.setProteccion_tc(rs.getString("proteccion_tc"));
				bean.setOtros_seguros(rs.getString("otros_seguros"));
				bean.setFamilia5(rs.getString("familia5"));
				bean.setTotal_puntos(rs.getString("total_puntos"));
				bean.setPerfil(rs.getString("perfil"));
				bean.setLibre1(rs.getString("libre1"));
				bean.setLibre2(rs.getString("libre2"));
				bean.setLibre3(rs.getString("libre3"));
				listado.add(bean);
			}
			
			stmt.close();
			conn.close();

			logger.info(new Date());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return listado;
	}

	public String paginarSelect(String query, int inicio, int fin) {

		/*String query_final = "SELECT * FROM ( "
				+ "SELECT ROWNUM AS FILA, CONSULTA.* FROM (" + query + ")"
				+ "CONSULTA" + ")" + "WHERE FILA >=" + inicio + " AND FILA <= "
				+ fin;*/
		
		String query_final = "SELECT ROWNUM AS FILA, CONSULTA.* FROM (" + query + ")"
			+ "CONSULTA WHERE ROWNUM >=" + inicio + " AND ROWNUM <= "
			+ fin;
			// + "CONSULTA WHERE ROWNUM <= 30";
			
		
		return query_final;
	}

	public List construirSelectVinculacionVIPVinculado(String perfiles,
			String cargo, String filtro) {
		List listado = new ArrayList();
		String query = "";
		try {
			String where = "  ";
			if (cargo.equals("LC02")) {
				where = where + " where cod_territorio='" + filtro + "' ";
			} else if (cargo.equals("LC03")) {
				where = where + " where cod_oficina='" + filtro + "' ";
			} else if (cargo.equals("LC04")) {
				where = where + " where cod_gestor='" + filtro + "' ";
			}
			if (perfiles.equals("-1")) {
				query = "Select cod_gestor,nom_gestor,perfil,count(*) total from iilc.TIILC_VINCULACION_VIP  "
						+ where
						+ " group by cod_gestor,nom_gestor,perfil order by perfil,cod_gestor";
			} else {

				StringTokenizer perfilesTok = new StringTokenizer(perfiles
						+ ",", ",");
				perfiles = "";
				int i = 0;
				while (perfilesTok.hasMoreTokens()) {
					perfiles = perfiles + "'" + perfilesTok.nextToken() + "'";
					if (perfilesTok.hasMoreTokens()) {
						perfiles = perfiles + ",";
					}
					i++;
				}

				query = "Select cod_gestor,nom_gestor,perfil,count(*) total from iilc.TIILC_VINCULACION_VIP "
						+ (where.trim().equals("") ? " where " : where
								+ " and ")
						+ "  substr(perfil,0,1) in("
						+ perfiles
						+ ") "
						+ " group by cod_gestor,nom_gestor,perfil order by perfil, cod_gestor ";
			}
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();

			logger.info(query);
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Tiilc_vinculacion_vip bean = new Tiilc_vinculacion_vip();
				bean.setCod_gestor(rs.getString("cod_gestor"));
				bean.setNom_gestor(rs.getString("nom_gestor"));
				bean.setPerfil(rs.getString("perfil"));
				bean.setTotal_puntos(rs.getString("total"));
				listado.add(bean);

			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listado;
	}

	public List construirSelectVinculacionVIPSegmentado(String segmento,
			String cargo, String filtro) {
		List listado = new ArrayList();
		String query = "";
		try {
			String where = "  ";
			if (cargo.equals("LC02")) {
				where = where + " where cod_territorio='" + filtro + "' ";
			} else if (cargo.equals("LC03")) {
				where = where + " where cod_oficina='" + filtro + "' ";
			} else if (cargo.equals("LC04")) {
				where = where + " where cod_gestor='" + filtro + "' ";
			}
			if (segmento.equals("-1")) {
				query = "Select cod_gestor,nom_gestor,segmento,count(*) total from iilc.TIILC_VINCULACION_VIP "
						+ where
						+ " group by cod_gestor,nom_gestor,segmento order by segmento,cod_gestor";
			} else {

				StringTokenizer perfilesTok = new StringTokenizer(segmento
						+ ",", ",");
				segmento = "";
				int i = 0;
				while (perfilesTok.hasMoreTokens()) {
					segmento = segmento + "'" + perfilesTok.nextToken() + "'";
					if (perfilesTok.hasMoreTokens()) {
						segmento = segmento + ",";
					}
					i++;
				}

				query = "Select cod_gestor,nom_gestor,segmento,count(*) total from iilc.TIILC_VINCULACION_VIP "
						+ (where.trim().equals("") ? " where " : where
								+ " and ")
						+ " segmento in( select valor1 from tiilc_multitabla where cod_mult||cod_ele in ("
						+ segmento
						+ ") ) "
						+ " group by cod_gestor,nom_gestor,segmento order by segmento,cod_gestor ";
			}

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();
			stmt = conn.createStatement();

			logger.info(query);
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Tiilc_vinculacion_vip bean = new Tiilc_vinculacion_vip();
				bean.setCod_gestor(rs.getString("cod_gestor"));
				bean.setNom_gestor(rs.getString("nom_gestor"));
				bean.setSegmento(rs.getString("segmento"));
				bean.setTotal_puntos(rs.getString("total"));
				listado.add(bean);

			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listado;
	}

	public int contarSelectVinculacionGCO(String territorio, String oficina,
			String gestor) {
		String query = "";
		try {
			String where = " ";
			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_territorio in (" + territorio + ") ";
			}
			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_oficina in (" + oficina + ") ";
			}
			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_gestor in (" + gestor + ") ";
			}

			query = "Select case when mod(count(*),"
					+ Constantes.PAGINACION_VINCULACION
					+ ")>0 then ((count(*)-mod(count(*),"
					+ Constantes.PAGINACION_VINCULACION + "))/"
					+ Constantes.PAGINACION_VINCULACION + ")+1 else count(*)/"
					+ Constantes.PAGINACION_VINCULACION
					+ " end filas from iilc.TIILC_VINCULACION_GCO " + where;

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return rs.getInt("filas");
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

	public List construirSelectVinculacionGCO(String pagina, String territorio, String oficina, String gestor) {
		List listado = new ArrayList();
		String query = "";
		try {
			String where = " ";
			if (territorio != null && !territorio.equals("-1") && !territorio.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_territorio in (" + territorio + ") ";
			}
			if (oficina != null && !oficina.equals("-1") && !oficina.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_oficina in (" + oficina + ") ";
			}
			if (gestor != null && !gestor.equals("-1") && !gestor.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_gestor in (" + gestor + ") ";
			}

			int inicio = 0;
			int fin = 0;
			int pagina_entera = Integer.parseInt(pagina);
			if (pagina_entera == 1) {
				inicio = 1;
				fin = Constantes.PAGINACION_VINCULACION;
			} else {
				inicio = (Constantes.PAGINACION_VINCULACION * (pagina_entera - 1)) + 1;
				fin = pagina_entera * Constantes.PAGINACION_VINCULACION;
			}
			query = "Select * from iilc.TIILC_VINCULACION_GCO " + where
					+ "  order by cod_territorio,cod_oficina,codigo_cliente";
			query = paginarSelect(query, inicio, fin);

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();
			logger.info(query);
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Tiilc_vinculacion_gco bean = new Tiilc_vinculacion_gco();

				bean.setCod_oficina(rs.getString("cod_oficina"));
				bean.setCodigo_cliente(rs.getString("codigo_cliente"));
				bean.setNombre_cliente(rs.getString("nombre_cliente"));
				bean.setCod_gestor(rs.getString("cod_gestor"));
				bean.setNom_gestor(rs.getString("nom_gestor"));
				bean.setSegmento(rs.getString("segmento"));
				bean.setBloque(rs.getString("bloque"));
				bean.setPres_com_letras(rs.getString("pres_com_letras"));
				bean.setCom_exterior(rs.getString("com_exterior"));
				bean.setLeasing(rs.getString("leasing"));
				bean.setRiesgo_firma(rs.getString("riesgo_firma"));
				bean.setTarjeta_cap_tra(rs.getString("tarjeta_cap_tra"));
				bean.setTotal_tar_empre(rs.getString("total_tar_empre"));
				bean.setHipo_autos(rs.getString("hipo_autos"));
				bean.setCta_plazo(rs.getString("cta_plazo"));
				bean.setFmutuos(rs.getString("fmutuos"));
				bean.setCta_cte_ahorro(rs.getString("cta_cte_ahorro"));
				bean.setTotal_sal_pa_py(rs.getString("total_sal_pa_py"));
				bean.setBolsa(rs.getString("bolsa"));
				bean.setHaberes(rs.getString("haberes"));
				bean.setProveedores(rs.getString("proveedores"));
				bean.setRecaudacion(rs.getString("recaudacion"));
				bean.setBanca_internet(rs.getString("banca_internet"));
				bean.setSeguros(rs.getString("seguros"));
				bean.setPtos_prescom_letras(rs.getString("ptos_prescom_letras"));
				bean.setPtos_com_ext(rs.getString("ptos_com_ext"));
				bean.setPtos_leasing(rs.getString("ptos_leasing"));
				bean.setPtos_riesgo_firma(rs.getString("ptos_riesgo_firma"));
				bean.setPtos_tarj_cap_trab(rs.getString("ptos_tarj_cap_trab"));
				bean.setPtos_tarj_emp(rs.getString("ptos_tarj_emp"));
				bean.setPtos_hipo_autos(rs.getString("ptos_hipo_autos"));
				bean.setPtos_cta_cte_ahorro(rs.getString("ptos_cta_cte_ahorro"));
				bean.setPtos_cta_plazo(rs.getString("ptos_cta_plazo"));
				bean.setPtos_fmutuos(rs.getString("ptos_fmutuos"));
				bean.setPtos_tot_pas_pym(rs.getString("ptos_tot_pas_pym"));
				bean.setPtos_bolsa(rs.getString("ptos_bolsa"));
				bean.setPtos_pago_haberes(rs.getString("ptos_pago_haberes"));
				bean.setPtos_pago_prov(rs.getString("ptos_pago_prov"));
				bean.setPtos_recaudaciones(rs.getString("ptos_recaudaciones"));
				bean.setPtos_banca_internet(rs.getString("ptos_banca_internet"));
				bean.setPtos_seguros(rs.getString("ptos_seguros"));
				bean.setTotal_puntos(rs.getString("total_puntos"));
				bean.setVinculado(rs.getString("vinculado"));
				bean.setRango_vinculacion(rs.getString("rango_vinculacion"));
				bean.setLibre1(rs.getString("libre1"));
				bean.setLibre2(rs.getString("libre2"));
				bean.setLibre3(rs.getString("libre3"));
				listado.add(bean);
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listado;
	}

	public List construirSelectVinculacionGCOCompleto(String territorio,
			String oficina, String gestor) {
		List listado = new ArrayList();
		String query = "";
		try {
			String where = " ";
			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				where = where + " and  cod_territorio in (" + territorio + ") ";
			}
			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				where = where + " and  cod_oficina in (" + oficina + ") ";
			}
			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				where = where + " and cod_gestor in (" + gestor + ") ";
			}

			query = "Select * from iilc.TIILC_VINCULACION_GCO where rownum<="
					+ Constantes.MAXIMO_REGISTROS_REPORTE_EXCEL + " " + where
					+ " "
					+ "  order by cod_territorio,cod_oficina,codigo_cliente";

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();
			logger.info(query);
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Tiilc_vinculacion_gco bean = new Tiilc_vinculacion_gco();

				bean.setCod_oficina(rs.getString("cod_oficina"));
				bean.setCodigo_cliente(rs.getString("codigo_cliente"));
				bean.setNombre_cliente(rs.getString("nombre_cliente"));
				bean.setCod_gestor(rs.getString("cod_gestor"));
				bean.setNom_gestor(rs.getString("nom_gestor"));
				bean.setSegmento(rs.getString("segmento"));
				bean.setBloque(rs.getString("bloque"));
				bean.setPres_com_letras(rs.getString("pres_com_letras"));
				bean.setCom_exterior(rs.getString("com_exterior"));
				bean.setLeasing(rs.getString("leasing"));
				bean.setRiesgo_firma(rs.getString("riesgo_firma"));
				bean.setTarjeta_cap_tra(rs.getString("tarjeta_cap_tra"));
				bean.setTotal_tar_empre(rs.getString("total_tar_empre"));
				bean.setHipo_autos(rs.getString("hipo_autos"));
				bean.setCta_plazo(rs.getString("cta_plazo"));
				bean.setFmutuos(rs.getString("fmutuos"));
				bean.setCta_cte_ahorro(rs.getString("cta_cte_ahorro"));
				bean.setTotal_sal_pa_py(rs.getString("total_sal_pa_py"));
				bean.setBolsa(rs.getString("bolsa"));
				bean.setHaberes(rs.getString("haberes"));
				bean.setProveedores(rs.getString("proveedores"));
				bean.setRecaudacion(rs.getString("recaudacion"));
				bean.setBanca_internet(rs.getString("banca_internet"));
				bean.setSeguros(rs.getString("seguros"));
				bean.setPtos_prescom_letras(rs.getString("ptos_prescom_letras"));
				bean.setPtos_com_ext(rs.getString("ptos_com_ext"));
				bean.setPtos_leasing(rs.getString("ptos_leasing"));
				bean.setPtos_riesgo_firma(rs.getString("ptos_riesgo_firma"));
				bean.setPtos_tarj_cap_trab(rs.getString("ptos_tarj_cap_trab"));
				bean.setPtos_tarj_emp(rs.getString("ptos_tarj_emp"));
				bean.setPtos_hipo_autos(rs.getString("ptos_hipo_autos"));
				bean.setPtos_cta_cte_ahorro(rs.getString("ptos_cta_cte_ahorro"));
				bean.setPtos_cta_plazo(rs.getString("ptos_cta_plazo"));
				bean.setPtos_fmutuos(rs.getString("ptos_fmutuos"));
				bean.setPtos_tot_pas_pym(rs.getString("ptos_tot_pas_pym"));
				bean.setPtos_bolsa(rs.getString("ptos_bolsa"));
				bean.setPtos_pago_haberes(rs.getString("ptos_pago_haberes"));
				bean.setPtos_pago_prov(rs.getString("ptos_pago_prov"));
				bean.setPtos_recaudaciones(rs.getString("ptos_recaudaciones"));
				bean.setPtos_banca_internet(rs.getString("ptos_banca_internet"));
				bean.setPtos_seguros(rs.getString("ptos_seguros"));
				bean.setTotal_puntos(rs.getString("total_puntos"));
				bean.setVinculado(rs.getString("vinculado"));
				bean.setRango_vinculacion(rs.getString("rango_vinculacion"));
				bean.setLibre1(rs.getString("libre1"));
				bean.setLibre2(rs.getString("libre2"));
				bean.setLibre3(rs.getString("libre3"));
				listado.add(bean);

			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listado;
	}

	public int contarSelectVinculacionPH(String territorio, String oficina,
			String gestor) {
		String query = "";
		try {
			String where = " ";
			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_territorio in (" + territorio + ") ";
			}
			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_oficina in (" + oficina + ") ";
			}
			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_gestor in (" + gestor + ") ";
			}
			query = "Select case when mod(count(*),"
					+ Constantes.PAGINACION_VINCULACION
					+ ")>0 then ((count(*)-mod(count(*),"
					+ Constantes.PAGINACION_VINCULACION + "))/"
					+ Constantes.PAGINACION_VINCULACION + ")+1 else count(*)/"
					+ Constantes.PAGINACION_VINCULACION
					+ " end filas from iilc.TIILC_VINCULACION_PH " + where;
			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return rs.getInt("filas");
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return 0;
	}

	public List construirSelectVinculacionPH(String pagina, String territorio, String oficina, String gestor, String ultimoCodigo, int pagAnt) {
		List listado = new ArrayList();
		String query = "";
		try {
			String where = " ";
			
			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_territorio in (" + territorio + ") ";
			}
			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_oficina in (" + oficina + ") ";
			}
			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				where = where + (where.trim().equals("") ? " where " : " and ")
						+ " cod_gestor in (" + gestor + ") ";
			}

			int inicio = 0;// mensajero.enviarCorreo(Constantes.CODIGO_LCONDUCC,Constantes.ESTADO_CARGA_ERROR, fecha);
			int fin = 0;
			int pagina_entera = Integer.parseInt(pagina);
			if (pagina_entera == 1) {
				inicio = 1;
				fin = Constantes.PAGINACION_VINCULACION;
				
				// where = where + " where COD_TERRITORIO || COD_OFICINA || CODIGO_CLIENTE > '" + ultimoCodigo + "'";
			} else {
				inicio = (Constantes.PAGINACION_VINCULACION * (pagina_entera - 1)) + 1;
				fin = pagina_entera * Constantes.PAGINACION_VINCULACION;
				
				/* if(where.trim().length() == 0) where = " where ";
				else where = " and ";
				
				where = where + "COD_TERRITORIO || COD_OFICINA || CODIGO_CLIENTE " + (pagAnt < pagina_entera ? ">" : "<=") + " '" + ultimoCodigo + "'";*/
			}
			
			query = "Select * from iilc.TIILC_VINCULACION_PH " + where
					+ "  order by cod_territorio,cod_oficina,codigo_cliente";
			query = paginarSelect(query, inicio, fin);

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();
			logger.info(query);
			logger.info(new Date());
			
			ResultSet rs = stmt.executeQuery(query);
			Tiilc_vinculacion_ph bean = null;
			while (rs.next()) {
				bean = new Tiilc_vinculacion_ph();
				bean.setDes_territorio(rs.getString("des_territorio"));
				bean.setCod_oficina(rs.getString("cod_oficina"));
				bean.setDes_oficina(rs.getString("des_oficina"));
				bean.setCodcli_emisora(rs.getString("codcli_emisora"));
				bean.setNom_emisora(rs.getString("nom_emisora"));
				bean.setCodigo_cliente(rs.getString("codigo_cliente"));
				bean.setNombre(rs.getString("nombre"));
				bean.setApellido1(rs.getString("apellido1"));
				bean.setApellido2(rs.getString("apellido2"));
				bean.setTipdoc_identidad(rs.getString("tipdoc_identidad"));
				bean.setDoc_identidad(rs.getString("doc_identidad"));
				bean.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
				bean.setTipo_tlf1(rs.getString("tipo_tlf1"));
				bean.setCod_ciudad_tlf1(rs.getString("cod_ciudad_tlf1"));
				bean.setNro_tlf1(rs.getString("nro_tlf1"));
				bean.setTipo_tlf2(rs.getString("tipo_tlf2"));
				bean.setCod_ciudad_tlf2(rs.getString("cod_ciudad_tlf2"));
				bean.setNro_tlf2(rs.getString("nro_tlf2"));
				bean.setTipo_tlf3(rs.getString("tipo_tlf3"));
				bean.setCod_ciudad_tlf3(rs.getString("cod_ciudad_tlf3"));
				bean.setNro_tlf3(rs.getString("nro_tlf3"));
				bean.setSegmento(rs.getString("segmento"));
				bean.setClasificacion_rcc(rs.getString("clasificacion_rcc"));
				bean.setRango_ingreso(rs.getString("rango_ingreso"));
				bean.setSm_prest_consumo(rs.getString("sm_prest_consumo"));
				bean.setNro_prest_consumo(rs.getString("nro_prest_consumo"));
				bean.setSm_prest_hipo(rs.getString("sm_prest_hipo"));
				bean.setNro_prest_hipo(rs.getString("nro_prest_hipo"));
				bean.setSm_tarj_cred(rs.getString("sm_tarj_cred"));
				bean.setNro_plasticos(rs.getString("nro_plasticos"));
				bean.setTarj_creditos(rs.getString("tarj_creditos"));
				bean.setNro_ctas_ahorro(rs.getString("nro_ctas_ahorro"));
				bean.setNro_ctas_vista(rs.getString("nro_ctas_vista"));
				bean.setNro_ctas_fmutuos(rs.getString("nro_ctas_fmutuos"));
				bean.setNro_ctas_plazo(rs.getString("nro_ctas_plazo"));
				bean.setNro_ctas_cts(rs.getString("nro_ctas_cts"));
				bean.setMargen_ordinario(rs.getString("margen_ordinario"));
				bean.setMargen_ordinario_acum(rs.getString("margen_ordinario_acum"));
				bean.setTipo_oferta(rs.getString("tipo_oferta"));
				bean.setImp_oferta_consumo(rs.getString("imp_oferta_consumo"));
				bean.setTasa1(rs.getString("tasa1"));
				bean.setTasa2(rs.getString("tasa2"));
				bean.setTasa3(rs.getString("tasa3"));
				bean.setImp_oferta_tarjeta(rs.getString("imp_oferta_tarjeta"));
				bean.setLinea_tc(rs.getString("linea_tc"));
				bean.setCanal(rs.getString("canal"));
				bean.setLibre1(rs.getString("libre1"));
				bean.setLibre2(rs.getString("libre2"));
				bean.setLibre3(rs.getString("libre3"));
				listado.add(bean);

				cod_terr = rs.getString("cod_territorio");
			}
			
			cod_terr += bean.getCod_oficina() + bean.getCodigo_cliente();
			
			stmt.close();
			conn.close();

			logger.info(cod_terr);
			logger.info(new Date());// mensajero.enviarCorreo(Constantes.CODIGO_LCONDUCC,Constantes.ESTADO_CARGA_ERROR, fecha);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listado;
	}

	public List construirSelectVinculacionPHCompleto(String territorio,
			String oficina, String gestor) {
		List listado = new ArrayList();
		String query = "";
		try {
			String where = " ";
			if (territorio != null && !territorio.equals("-1")
					&& !territorio.equals("null")) {
				where = where + " and  cod_territorio in (" + territorio + ") ";
			}
			if (oficina != null && !oficina.equals("-1")
					&& !oficina.equals("null")) {
				where = where + " and  cod_oficina in (" + oficina + ") ";
			}
			if (gestor != null && !gestor.equals("-1")
					&& !gestor.equals("null")) {
				where = where + " and cod_gestor in (" + gestor + ") ";
			}

			query = "Select * from iilc.TIILC_VINCULACION_PH  where  rownum<="
					+ Constantes.MAXIMO_REGISTROS_REPORTE_EXCEL + "  " + where
					+ " "
					+ "  order by cod_territorio,cod_oficina,codigo_cliente";

			ConexionDAO con = new ConexionDAO();
			conn = con.getConexion();

			stmt = conn.createStatement();
			logger.info(query);
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Tiilc_vinculacion_ph bean = new Tiilc_vinculacion_ph();
				bean.setDes_territorio(rs.getString("des_territorio"));
				bean.setCod_oficina(rs.getString("cod_oficina"));
				bean.setDes_oficina(rs.getString("des_oficina"));
				bean.setCodcli_emisora(rs.getString("codcli_emisora"));
				bean.setNom_emisora(rs.getString("nom_emisora"));
				bean.setCodigo_cliente(rs.getString("codigo_cliente"));
				bean.setNombre(rs.getString("nombre"));
				bean.setApellido1(rs.getString("apellido1"));
				bean.setApellido2(rs.getString("apellido2"));
				bean.setTipdoc_identidad(rs.getString("tipdoc_identidad"));
				bean.setDoc_identidad(rs.getString("doc_identidad"));
				bean.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
				bean.setTipo_tlf1(rs.getString("tipo_tlf1"));
				bean.setCod_ciudad_tlf1(rs.getString("cod_ciudad_tlf1"));
				bean.setNro_tlf1(rs.getString("nro_tlf1"));
				bean.setTipo_tlf2(rs.getString("tipo_tlf2"));
				bean.setCod_ciudad_tlf2(rs.getString("cod_ciudad_tlf2"));
				bean.setNro_tlf2(rs.getString("nro_tlf2"));
				bean.setTipo_tlf3(rs.getString("tipo_tlf3"));
				bean.setCod_ciudad_tlf3(rs.getString("cod_ciudad_tlf3"));
				bean.setNro_tlf3(rs.getString("nro_tlf3"));
				bean.setSegmento(rs.getString("segmento"));
				bean.setClasificacion_rcc(rs.getString("clasificacion_rcc"));
				bean.setRango_ingreso(rs.getString("rango_ingreso"));
				bean.setSm_prest_consumo(rs.getString("sm_prest_consumo"));
				bean.setNro_prest_consumo(rs.getString("nro_prest_consumo"));
				bean.setSm_prest_hipo(rs.getString("sm_prest_hipo"));
				bean.setNro_prest_hipo(rs.getString("nro_prest_hipo"));
				bean.setSm_tarj_cred(rs.getString("sm_tarj_cred"));
				bean.setNro_plasticos(rs.getString("nro_plasticos"));
				bean.setTarj_creditos(rs.getString("tarj_creditos"));
				bean.setNro_ctas_ahorro(rs.getString("nro_ctas_ahorro"));
				bean.setNro_ctas_vista(rs.getString("nro_ctas_vista"));
				bean.setNro_ctas_fmutuos(rs.getString("nro_ctas_fmutuos"));
				bean.setNro_ctas_plazo(rs.getString("nro_ctas_plazo"));
				bean.setNro_ctas_cts(rs.getString("nro_ctas_cts"));
				bean.setMargen_ordinario(rs.getString("margen_ordinario"));
				bean.setMargen_ordinario_acum(rs.getString("margen_ordinario_acum"));
				bean.setTipo_oferta(rs.getString("tipo_oferta"));
				bean.setImp_oferta_consumo(rs.getString("imp_oferta_consumo"));
				bean.setTasa1(rs.getString("tasa1"));
				bean.setTasa2(rs.getString("tasa2"));
				bean.setTasa3(rs.getString("tasa3"));
				bean.setImp_oferta_tarjeta(rs.getString("imp_oferta_tarjeta"));
				bean.setLinea_tc(rs.getString("linea_tc"));
				bean.setCanal(rs.getString("canal"));
				bean.setLibre1(rs.getString("libre1"));
				bean.setLibre2(rs.getString("libre2"));
				bean.setLibre3(rs.getString("libre3"));
				listado.add(bean);

			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listado;
	}

	public String getCod_terr() {
		return cod_terr;
	}	
}
