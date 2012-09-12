package com.grupobbva.bc.per.tel.iilc.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Consulta;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.grupobbva.bc.per.tel.iilc.serializable.EstadoCarga;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

public class ClienteDAOImpl {
	
	private Logger logger = Logger.getLogger(ClienteDAOImpl.class);
	private String tableName = "iilc.tiilc_cliente";
	
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
			logger.error("ClienteDAOImpl :: getConnection", e);
		}
		return connection;
	}

	protected List<Multitabla> findMultitablaSegmento(String codMult, String valor2) {
		String sql = "SELECT o.* FROM iilc.tiilc_multitabla o WHERE o.cod_mult=? and o.valor2=?";
		Connection cnn = getConnection();
		CallableStatement stm;
		Multitabla multitabla = null;
		List<Multitabla> result = new ArrayList<Multitabla>(); 
		try {
			stm = cnn.prepareCall(sql);
			stm.setString(1, codMult);
			stm.setString(2, valor2);
			
			ResultSet rss = stm.executeQuery();
			
			while(rss.next()) {
				multitabla = new Multitabla();
				multitabla.setCod_mult(rss.getString("cod_mult"));
				multitabla.setCod_ele(rss.getString("cod_ele"));
				multitabla.setValor1(rss.getString("valor1"));
				multitabla.setValor2(rss.getString("valor2"));
				multitabla.setValor3(rss.getString("valor3"));
				multitabla.setValor4(rss.getString("valor4"));
				
				result.add(multitabla);
			}
			
			stm.close();
			cnn.close();
		} catch (SQLException e) {
			logger.error(e);
		} catch (NullPointerException e) {
			logger.error(e);
		}
		
		return result;
	}
	
	protected Multitabla findMultitabla(String codMult, String codEle) {
		String sql = "SELECT o.* FROM iilc.tiilc_multitabla o WHERE o.cod_mult=? and o.cod_ele=?";
		Connection cnn = getConnection();
		CallableStatement stm;
		Multitabla multitabla = null;
		try {
			stm = cnn.prepareCall(sql);
			stm.setString(1, codMult);
			stm.setString(2, codEle);
			
			ResultSet rss = stm.executeQuery();
			
			if(rss.next()) {
				multitabla = new Multitabla();
				multitabla.setCod_mult(rss.getString("cod_mult"));
				multitabla.setCod_ele(rss.getString("cod_ele"));
				multitabla.setValor1(rss.getString("valor1"));
				multitabla.setValor2(rss.getString("valor2"));
				multitabla.setValor3(rss.getString("valor3"));
				multitabla.setValor4(rss.getString("valor4"));
			}
			
			stm.close();
			cnn.close();
		} catch (SQLException e) {
			logger.error(e);
		} catch (NullPointerException e) {
			logger.error(e);
		}
		
		return multitabla;
	}
	
	private Vector<String> armarParametros(String cod_territorio
			, String cod_oficina
			, String cod_gestor
			, String nivel_vinculacion
			, String clasificacion
			, String margen
			, String etiqueta
			, String edad
			, String porcrie
			, String cod_empresa
			, String tipo_cliente
			, String cod_cliente) {
		
		tableName = "iilc.tiilc_cliente";
		Vector<String> parametros = new Vector<String>(0, 1);
		String temp;
		
		if (!cod_territorio.equals("-1")) {
			cod_territorio = cod_territorio.replaceAll(",", "','");
			temp = "o.cod_territorio in ('" + cod_territorio + "')";
			logger.info("Territorio: " + temp);
			parametros.add(temp);
		}
		
		if (!cod_oficina.equals("-1")) {
			cod_oficina = cod_oficina.replaceAll(",", "','");
			temp = "o.cod_oficina in ('" + cod_oficina + "')";
			logger.info("Oficina: " + temp);
			parametros.add(temp);
		}
		
		if (!cod_gestor.equals("-1")) {	
			cod_gestor = cod_gestor.replaceAll(",", "','");
			temp = "o.cod_gestor in ('" + cod_gestor + "')";
			logger.info("Gestor: " + temp);
			parametros.add(temp);
		}
		
		if (!nivel_vinculacion.equals("-1")) {
			temp = construirNivelVinculacion(nivel_vinculacion);
			logger.info("Nivel Vinculacion: " + temp);
			parametros.add(temp);	
		}
		
		if (!clasificacion.equals("-1")) {
			temp = construirClasificacion(clasificacion);
			logger.info("Clasificacion: " + temp);
			parametros.add(temp);
		}
		
		if (!margen.equals("-1")) {
			temp = construirMargenesOrdinarios(margen);
			logger.info("Margenes: " + temp);
			parametros.add(temp);
		}
		
		if (!etiqueta.equals("-1")) {
			temp = construirEtiqueta(etiqueta);
			logger.info("Etiqueta: " + temp);
			tableName = "iilc.viilc_cliente";
			parametros.add(temp);
		}
		
		if (!edad.equals("-1")) {
			temp = construirEdad(edad);
			logger.info("Edad: " + temp);
			parametros.add(temp);
		}
		
		// Porcentaje margen ordinario
		if (!porcrie.equals("-1")) {
			temp = construirPorcentaje(porcrie);
			logger.info("Porcentaje: " + temp);
			parametros.add(temp);
		}
		
		// Pago de Haberes
		if(!cod_empresa.equals("-1")) {
			String[] o = cod_empresa.split(",");
			String tmp = "";
			temp = "";
			for(int i = 0; i < o.length; i++) {
				if(tmp.length() > 0) tmp +=",";
				tmp += "'" + o[i] + "'";
				
				if(((i + 1) % 999) == 0) {
					if(temp.length() > 0) temp += " or ";
					temp += "o.cod_empresa in(" + tmp + ")";
					tmp = "";
				}
			}
			
			if(temp.length() > 0) temp += " or ";
			temp += "o.cod_empresa in(" + tmp + ")";
			tmp = "";
			
			// cod_empresa = cod_empresa.replaceAll(",", "','");
			// temp = "o.cod_empresa in('" + cod_empresa + "')";
			temp = "(" + temp + ")";
			// logger.info("cod_empresa: " + temp);
			parametros.add(temp);
		}

		if(!tipo_cliente.equals("-1")) {
			tipo_cliente = tipo_cliente.replaceAll(",", "','");
			temp = "o.tipo_persona in ('" + tipo_cliente + "')";
			logger.info("tipo_persona: " + temp);
			parametros.add(temp);
		}

		if(!cod_cliente.equals("-1")) {
			cod_cliente = cod_cliente.replaceAll(",", "','");
			temp = "o.codigo = '" + cod_cliente + "'";
			logger.info("codigo: " + temp);
			// parametros.clear();
			parametros.add(temp);
		}
		
		return parametros;
	}
	
	public List<Multitabla> findAllCabeceras(String codigo) {
		List<Multitabla> result = new ArrayList<Multitabla>();
		String sql = "SELECT o.* FROM iilc.tiilc_multitabla o WHERE o.cod_mult=? ORDER BY to_number(o.cod_ele)";
		Connection cnn = getConnection();
		CallableStatement stm;
		Multitabla multitabla = null;
		try {
			stm = cnn.prepareCall(sql);
			stm.setString(1, codigo);
			
			ResultSet rss = stm.executeQuery();
			
			while(rss.next()) {
				multitabla = new Multitabla();
				multitabla.setCod_mult(rss.getString("cod_mult"));
				multitabla.setCod_ele(rss.getString("cod_ele"));
				multitabla.setValor1(rss.getString("valor1"));
				multitabla.setValor2(rss.getString("valor2"));
				multitabla.setValor3(rss.getString("valor3"));
				multitabla.setValor4(rss.getString("valor4"));
				
				result.add(multitabla);
			}
		} catch (SQLException e) {
			logger.error(e);
		} catch (NullPointerException e) {
			logger.error(e);
		}
		return result;
	}
	
	public Map<String, String> findCliente(String cod_cliente) {
		Map<String, String> result = null;
		String sql = "SELECT o.cod_oficina, o.cod_gestor, o.cod_territorio, o.codigo, " +
			"nvl(f.des_oficina, o.cod_oficina) des_oficina, nvl(g.nom_gestor, o.cod_gestor) nom_gestor " +
			"FROM iilc.tiilc_cliente o " +
			"INNER JOIN iilc.tiilc_oficina f ON o.cod_oficina=f.cod_oficina " +
			"INNER JOIN iilc.tiilc_gestor g ON o.cod_gestor=g.cod_gestor WHERE o.codigo = '" + cod_cliente + "'";
		logger.info("SQL: " + sql);
		
		try {
			Connection con = getConnection();
			Statement s = con.createStatement();
			ResultSet rst = s.executeQuery(sql);
			
			if(rst.next()) {
				result = new HashMap<String, String>();
				result.put("cod_oficina", rst.getString("cod_oficina"));
				result.put("des_oficina", rst.getString("cod_oficina") + " - " + rst.getString("des_oficina"));
				result.put("nom_gestor", rst.getString("nom_gestor"));
			}
			
			s.close();
			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		
		return result;
	}
	
	public int convertNumero(String n) {
		int result = 0;
		try {
			result = Integer.parseInt((n.length() == 0) ? "0" : n);
		} catch(NumberFormatException e) {
			logger.error(e.getMessage());
		} catch(NullPointerException e) {
			logger.error(e.getMessage());
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public Vector<Cliente> findAllClientebyFilter(int pos_ini
			, int pos_fin
			, String cod_territorio
			, String cod_oficina
			, String cod_gestor
			, String nivel_vinculacion
			, String clasificacion
			, String margen
			, String etiqueta
			, String edad
			, String porcrie
			, String cod_empresa
			, String tipo_cliente
			, String cod_cliente
			, String orden
			, boolean pestanaTodos
			, int tipoOpcion) {
		
		Vector<Cliente> res = null;		
		String sql = null;
		
		
		try {
			Cliente cliente = null;

			sql = findAllClientebyFilter_sql(pos_ini
					, pos_fin
					, cod_territorio
					, cod_oficina
					, cod_gestor
					, nivel_vinculacion
					, clasificacion
					, margen
					, etiqueta
					, edad
					, porcrie
					, cod_empresa
					, tipo_cliente
					, cod_cliente
					, orden
					, pestanaTodos
					, tipoOpcion);

			logger.info("SQL: " + sql);
			Connection con = getConnection();
			Statement s = con.createStatement();
			try {
				ResultSet rst = s.executeQuery(sql);
				if(rst != null) {
					rst.setFetchSize(512);
					while (rst.next()) {
						if (res == null) res = new Vector<Cliente>(0, 1);
						
						cliente = new Cliente();
						cliente.setCod_cliente(rst.getInt("Cod_cliente"));
						cliente.setCodigo(rst.getString("Codigo"));
						cliente.setCod_oficina(rst.getString("Cod_oficina"));
						cliente.setCod_gestor(rst.getString("Cod_gestor"));
						cliente.setNombre(rst.getString("Nombre"));
						cliente.setCod_territorio(rst.getString("Cod_territorio"));
						cliente.setSegment1(rst.getString("Segment1"));
						cliente.setEdad(rst.getInt("Edad"));
						cliente.setEstcivil(rst.getString("Estcivil"));
						cliente.setCalle(rst.getString("Calle"));
						cliente.setNro(rst.getString("Nro"));
						cliente.setPerfil(rst.getString("Perfil"));
						cliente.setDirec1(rst.getString("Direc1"));
						cliente.setDistrito(rst.getString("Distrito"));
						cliente.setProvincia(rst.getString("Provincia"));
						cliente.setDepartamento(rst.getString("Departamento"));
						cliente.setTipo_persona(rst.getString("Tipo_persona"));
						cliente.setClasificacion(rst.getString("Clasificacion"));
						cliente.setTelefono(rst.getString("Telefono"));
						cliente.setVinculacion(rst.getString("Vinculacion"));
						cliente.setPper(rst.getInt("Pper"));
						cliente.setPcom(rst.getInt("Pcom"));
						cliente.setVnac(rst.getInt("Vnac"));
						cliente.setCcte(rst.getInt("Ccte"));
						cliente.setColb(rst.getInt("Colb"));
						cliente.setCnet(rst.getString("Cnet"));
						cliente.setPaut(rst.getInt("Paut"));
						cliente.setDsct(rst.getInt("Dsct"));
						cliente.setVarc(rst.getInt("Varc"));
						cliente.setCemp(rst.getString("Cemp"));
						cliente.setSdep(rst.getInt("Sdep"));
						cliente.setCext(rst.getInt("Cext"));
						cliente.setPhip(rst.getInt("Phip"));
						cliente.setLeas(rst.getInt("Leas"));
						cliente.setVcla(rst.getInt("Vcla"));
						cliente.setCvip(rst.getInt("Cvip"));
						cliente.setSvid(rst.getInt("Svid"));
						cliente.setLinco(rst.getString("Linco"));
						cliente.setPmiv(rst.getInt("Pmiv"));
						cliente.setCloc(rst.getInt("Cloc"));
						cliente.setVrep(rst.getInt("Vrep"));
						cliente.setAhsd(rst.getInt("Ahsd"));
						cliente.setSonc(rst.getInt("Sonc"));
						cliente.setTco(rst.getInt("Tco"));
						cliente.setB24(rst.getString("B24"));
						cliente.setCpte(rst.getInt("Cpte"));
						cliente.setPref(rst.getInt("Pref"));
						cliente.setVoro(rst.getInt("Voro"));
						cliente.setAhor(rst.getInt("Ahor"));
						cliente.setSpro(rst.getInt("Spro"));
						cliente.setPos(rst.getString("Pos"));
						cliente.setT_act2(rst.getInt("T_act2"));
						cliente.setPmas(rst.getInt("Pmas"));
						cliente.setT_act3(rst.getInt("T_act3"));
						cliente.setLcta(rst.getInt("Lcta"));
						cliente.setT_act4(rst.getInt("T_act4"));
						cliente.setVpla(rst.getInt("Vpla"));
						cliente.setT_act5(rst.getInt("T_act5"));
						cliente.setPlzo(rst.getInt("Plzo"));
						cliente.setT_act6(rst.getInt("T_act6"));
						cliente.setPserv(rst.getInt("Pserv"));
						cliente.setTpr(rst.getInt("Tpr"));
						cliente.setProm(rst.getInt("Prom"));
						cliente.setT_act_ct2(rst.getInt("T_act_ct2"));
						cliente.setVemp(rst.getInt("Vemp"));
						cliente.setT_act_ct3(rst.getInt("T_act_ct3"));
						cliente.setPh(rst.getInt("Ph"));
						cliente.setT_act_ct4(rst.getInt("T_act_ct4"));
						cliente.setFcex(rst.getInt("Fcex"));
						cliente.setT_act_ct5(rst.getInt("T_act_ct5"));
						cliente.setVctr(rst.getInt("Vctr"));
						cliente.setT_act_ct6(rst.getString("T_act_ct6"));
						cliente.setFmut(rst.getInt("Fmut"));
						cliente.setMargeno(rst.getInt("Margeno"));
						cliente.setNro_documento(rst.getString("Nro_documento"));
						cliente.setBcorie(rst.getInt("Bcorie"));
						cliente.setEmph(rst.getInt("Emph"));
						cliente.setBcorid(rst.getInt("Bcorid"));
						cliente.setAval(rst.getInt("Aval"));
						cliente.setBcorii(rst.getInt("Bcorii"));
						cliente.setMcla(rst.getInt("Mcla"));
						cliente.setBcopas(rst.getInt("Bcopas"));
						cliente.setCts(rst.getInt("Cts"));
						cliente.setBcovol(rst.getInt("Bcovol"));
						cliente.setTdeb(rst.getInt("Tdeb"));
						cliente.setPorcrie(rst.getInt("Porcrie"));
						cliente.setMoro(rst.getInt("Moro"));
						cliente.setPorcrid(rst.getInt("Porcrid"));
						cliente.setCtsd(rst.getInt("Ctsd"));
						cliente.setPorcrii(rst.getInt("Porcrii"));
						cliente.setTvip(rst.getInt("Tvip"));
						cliente.setSbsrie(rst.getInt("Sbsrie"));
						cliente.setSbsrid(rst.getInt("Sbsrid"));
						cliente.setSbsrii(rst.getInt("Sbsrii"));
						cliente.setSbsjud(rst.getInt("Sbsjud"));
						cliente.setCod_empresa(rst.getString("Cod_empresa"));
						cliente.setDes_empresa(rst.getString("Des_empresa"));
	
						// Campos Oferta
						cliente.setIntervpas(rst.getString("intervpas"));
						cliente.setMofactv(rst.getLong("mofactv"));
						cliente.setCs000lineamaxtc(rst.getLong("cs000lineamaxtc"));
						cliente.setMofpasv(rst.getString("mofpasv"));
						cliente.setMofserv(rst.getString("mofserv"));
						cliente.setMofcanal(rst.getString("mofcanal"));
						cliente.setMphpasv(rst.getString("mphpasv"));
						cliente.setCs000mtoprestamo(rst.getLong("cs000mtoprestamo"));
						cliente.setMontovehicular(rst.getLong("montovehicular"));
						cliente.setMontohipotecario(rst.getLong("montohipotecario"));
						cliente.setCtacteoferta(rst.getString("ctacteoferta"));
						cliente.setCtaahoferta(rst.getString("ctaahoferta"));
						cliente.setCtapoferta(rst.getString("ctapoferta"));
						cliente.setFmutuoofert(rst.getString("fmutuoofert"));
						cliente.setCtactsofert(rst.getString("ctactsofert"));
						cliente.setTconsactv(rst.getBigDecimal("tconsactv"));
						cliente.setMontosubrogados(rst.getLong("montosubrogados"));
						cliente.setTsubactv(rst.getBigDecimal("tsubactv"));
						cliente.setThipotactv(rst.getBigDecimal("thipotactv"));
						cliente.setTvehicactv(rst.getBigDecimal("tvehicactv"));
						cliente.setCs000montocta36(rst.getString("cs000montocta36"));
						cliente.setTcuot36act(rst.getBigDecimal("tcuot36act"));
						cliente.setCs000montocta48(rst.getLong("cs000montocta48"));
						cliente.setTcuot48act(rst.getBigDecimal("tcuot48act"));
						cliente.setCs000montocta60(rst.getBigDecimal("cs000montocta60"));
						cliente.setTcuot60act(rst.getBigDecimal("tcuot60act"));
						cliente.setCs000presmena5000(rst.getBigDecimal("css000presmena5000"));
						cliente.setCs000comisdesemen5000(rst.getBigDecimal("cs000comisdesemen5000"));
						cliente.setCs000pres5000a15000(rst.getBigDecimal("cs000pres5000a15000"));
						cliente.setC5000comdes15000act(rst.getBigDecimal("c5000comdes15000act"));
						cliente.setCs000presmaya15000(rst.getBigDecimal("cs000presmaya15000"));
						cliente.setComdes15000ac(rst.getBigDecimal("comdes15000ac"));
						cliente.setCs000linminadqtc(rst.getLong("cs000linminadqtc"));
						cliente.setCs000tipodecredito(rst.getString("cs000tipodecredito"));
						cliente.setCs000mixmonprest(rst.getLong("cs000mixmonprest"));
						cliente.setCs000mixlinasistc(rst.getLong("cs000mixlinasistc"));
						cliente.setCs000mixtipotc(rst.getString("cs000mixtipotc"));
						cliente.setCs000prestcmena5000(rst.getBigDecimal("cs000prestcmena5000"));
						cliente.setCs000prestc500015000(rst.getBigDecimal("cs000prestc500015000"));
						cliente.setCs000prestcmaya15000(rst.getBigDecimal("cs000prestcmaya15000"));
						cliente.setAtribctactepasv(rst.getString("atribctactepasv"));
						cliente.setAtribctaahpasv(rst.getString("atribctaahpasv"));
						cliente.setAtribctaplazpasv(rst.getString("atribctaplazpasv"));
						cliente.setAtribctspasv(rst.getString("atribctspasv"));
						cliente.setAtribfmutuopasv(rst.getString("atribfmutuopasv"));
						cliente.setCobofserv(rst.getString("cobofserv"));
						cliente.setSvidofserv(rst.getString("svidofserv"));
						cliente.setSoncofserv(rst.getString("soncofserv"));
						cliente.setSvincofserv(rst.getString("svincofserv"));
						cliente.setPhofserv(rst.getString("phofserv"));
						cliente.setDebofserv(rst.getString("debofserv"));
						cliente.setVipofserv(rst.getString("vipofserv"));
						cliente.setOfcnetcan(rst.getString("ofcnetcan"));
						cliente.setOfcempcan(rst.getString("ofcempcan"));
						cliente.setOflincocan(rst.getString("oflincocan"));
						cliente.setOfb24can(rst.getString("ofb24can"));
						cliente.setOfposcan(rst.getString("ofposcan"));			
	
						cliente.setPrefijo(rst.getString("prefijo"));
						res.add(cliente);
					}
				} else {
					logger.error("ClienteDAOImpl :: findAllClientebyFilter :: Error al obtener el resultado de la consulta.");
					logger.error("SQL: " + sql);
				}
			} catch (SQLException e) {
				logger.error("ClienteDAOImpl", e);
				logger.error("SQL: " + sql);
			}
			s.close();			
			con.close();
		} catch (Exception e) {
			logger.error("ClienteDAOImpl", e);
			logger.error("SQL: " + sql);
		}
		return res;
	}
	
	private String findAllClientebyFilter_sql(int pos_ini
			, int pos_fin
			, String cod_territorio
			, String cod_oficina
			, String cod_gestor
			, String nivel_vinculacion
			, String clasificacion
			, String margen
			, String etiqueta
			, String edad
			, String porcrie
			, String cod_empresa
			, String tipo_cliente
			, String cod_cliente
			, String orden
			, boolean pestanaTodos
			, int tipoOpcion) {
		String sql = "";
		
		Vector<String> parametros = armarParametros(cod_territorio
				, cod_oficina
				, cod_gestor
				, nivel_vinculacion
				, clasificacion
				, margen
				, etiqueta
				, edad
				, porcrie
				, cod_empresa
				, tipo_cliente
				, cod_cliente);

		for (int i = 0; i < parametros.size(); i++) {
			sql += " " + (String) parametros.elementAt(i);
			if (i < parametros.size() - 1) {
				sql += " AND";
			}
		}
		
		if (sql.length() > 0){
			sql = " WHERE " + sql;
			
			if(!pestanaTodos){
				sql=sql+" AND ";
			}
			
		} else if(!pestanaTodos){
			sql = " WHERE ";
		}
		
		String condicional="";
		if(!pestanaTodos){
			condicional=" ("
			+ "nvl(mofactv, 0) + "
			+ "nvl(t_act_ct2, 0) + "
			+ "nvl(T_act_ct3, 0) + "
			+ "nvl(cs000lineamaxtc, 0) + "
			+ "nvl(T_act_ct4, 0) + "
			+ "nvl(T_act_ct5, 0) + "
			+ "nvl(Margeno, 0) + "
			+ "nvl(Bcorid, 0) + "
			+ "nvl(Bcorii, 0) + "
			+ "nvl(Sbsrid, 0) + "
			+ "nvl(Sbsrii, 0) + "
			+ "nvl(Sbsrie, 0) + "
			+ "nvl(Sbsjud, 0) + "
			+ "nvl(Porcrid, 0) + "
			+ "nvl(Porcrii, 0) + "
			+ "nvl(Porcrie, 0) + "
			+ "nvl(Pper, 0) + "
			+ "nvl(cs000mtoprestamo, 0) + "
			+ "nvl(Paut, 0) + "
			+ "nvl(montovehicular, 0) + "
			+ "nvl(Phip, 0) + "
			+ "nvl(Pmiv, 0) + "
			+ "nvl(Cpte, 0) + "
			+ "nvl(montohipotecario, 0) + "
			+ "nvl(Pmas, 0) + "
			+ "nvl(Pcom, 0) + "
			+ "nvl(Dsct, 0) + "
			+ "nvl(Leas, 0) + "
			+ "nvl(Cloc, 0) + "
			+ "nvl(Pref, 0) + "
			+ "nvl(Lcta, 0) + "
			+ "nvl(Prom, 0) + "
			+ "nvl(Fcex, 0) + "
			+ "nvl(Aval, 0) + "
			+ "nvl(T_act_ct2, 0) + "
			+ "nvl(Vnac, 0) + "
			+ "nvl(Varc, 0) + "
			+ "nvl(Vcla, 0) + "
			+ "nvl(Vrep, 0) + "
			+ "nvl(Voro, 0) + "
			+ "nvl(Vpla, 0) + "
			+ "nvl(Vemp, 0) + "
			+ "nvl(Vctr, 0) + "
			+ "nvl(Mcla, 0) + "
			+ "nvl(Moro, 0) + "
			+ "nvl(T_act_ct3, 0) + "
			+ "nvl(Cs000lineamaxtc, 0) + "
			+ "nvl(Ccte, 0) + "
			+ "nvl(Cemp, 0) + "
			+ "nvl(Cvip, 0) + "
			+ "nvl(Ahsd, 0) + "
			+ "nvl(Ahor, 0) + "
			+ "nvl(Plzo, 0) + "
			+ "nvl(Sdep, 0) + "
			+ "nvl(Fmut, 0) + "
			+ "nvl(Cts, 0) + "
			+ "nvl(Ctsd, 0) + "
			+ "nvl(T_act_ct4, 0) + "
			+ "nvl(Colb, 0) + "
			+ "nvl(Svid, 0) + "
			+ "nvl(Sonc, 0) + "
			+ "nvl(Spro, 0) + "
			+ "nvl(Ph, 0) + "
			+ "nvl(Emph, 0) + "
			+ "nvl(Tdeb, 0) + "
			+ "nvl(Tvip, 0) + "
			+ "nvl(Pserv, 0) + "
			+ "nvl(Cext, 0) + "
			+ "nvl(T_act_ct5, 0) + "
			+ "nvl(Cs000mtoprestamo, 0) + "
			+ "nvl(tconsactv, 0) + "
			+ "nvl(Montosubrogados, 0) + "
			+ "nvl(Tsubactv, 0) + "
			+ "nvl(montohipotecario, 0) + "
			+ "nvl(Thipotactv, 0) + "
			+ "nvl(montovehicular, 0) + "
			+ "nvl(Tvehicactv, 0) + "
			+ "nvl(Tcuot36act, 0) + "
			+ "nvl(Cs000montocta48, 0) + "
			+ "nvl(Tcuot48act, 0) + "
			+ "nvl(Cs000montocta60, 0) + "
			+ "nvl(Tcuot60act, 0) + "
			+ "nvl(css000presmena5000, 0) + "
			+ "nvl(Cs000comisdesemen5000, 0) + "
			+ "nvl(Cs000pres5000a15000, 0) + "
			+ "nvl(C5000comdes15000act, 0) + "
			+ "nvl(Cs000presmaya15000, 0) + "
			+ "nvl(Comdes15000ac, 0) + "
			+ "nvl(Cs000linminadqtc, 0) + "
			+ "nvl(Cs000lineamaxtc, 0) + "
			+ "nvl(Cs000mixmonprest, 0) + "
			+ "nvl(Cs000mixlinasistc, 0) + "
			+ "nvl(Cs000prestcmena5000, 0) + "
			+ "nvl(Cs000prestc500015000, 0) + "
			+ "nvl(Cs000prestcmaya15000, 0) > 0 or length(nvl(Ctacteoferta,'') "
			+ "|| nvl(Atribctactepasv,'') "
			+ "|| nvl(Ctaahoferta,'') "
			+ "|| nvl(Atribctaahpasv,'') "
			+ "|| nvl(Ctapoferta,'') "
			+ "|| nvl(Atribctaplazpasv,'') "
			+ "|| nvl(Ctactsofert,'') "
			+ "|| nvl(Atribctspasv,'') "
			+ "|| nvl(Fmutuoofert,'') "
			+ "|| nvl(Atribfmutuopasv,'') "
			+ "|| nvl(Cobofserv,'') "
			+ "|| nvl(Svidofserv,'') "
			+ "|| nvl(Soncofserv,'') "
			+ "|| nvl(Svincofserv,'') "
			+ "|| nvl(Phofserv,'') "
			+ "|| nvl(Debofserv,'') "
			+ "|| nvl(Vipofserv,'') "
			+ "|| nvl(Ofcnetcan,'') "
			+ "|| nvl(Ofcempcan,'') "
			+ "|| nvl(Oflincocan,'') "
			+ "|| nvl(Ofb24can,'') "
			+ "|| nvl(Ofposcan,'') "
			+ "|| nvl(Cs000mixtipotc,'') "
			+ "|| nvl(Cs000tipodecredito,'') "
			+ "|| nvl(Cs000montocta36,'') "
			+ "|| nvl(Phofserv,'') "
			+ "|| nvl(Mphpasv,'') "
			+ "|| nvl(cobofserv,'') "
			+ "|| nvl(Ctactsofert,'') "
			+ "|| nvl(Fmutuoofert,'') "
			+ "|| nvl(Ctapoferta,'') "
			+ "|| nvl(Ctaahoferta,'') "
			+ "|| nvl(Ctacteoferta,'') "
			+ "|| nvl(cs000tipodecredito,'') "
			+ "|| nvl(intervpas,'') "
			+ "|| nvl(mofserv,'') "
			+ "|| nvl(mphpasv,'') "
			+ "|| nvl(Mofpasv,''))>0 )";
		}


		if(tipoOpcion == 6){
			if(condicional.length() > 0) {
				condicional = condicional + " AND ";
			}
			condicional = condicional + "NVL(FLAG_OFERTA, '-') IN('1', '2') ";
		}
		
		sql = "SELECT * FROM " + tableName + " o" + sql + condicional;		
		sql = sql + " ORDER BY " + (orden.length() == 0 ? "o.cod_cliente ASC" : orden);

		// Paginacion
		if(pos_ini != -1) {
			sql = "SELECT * FROM ( " 
				+ "SELECT rownum as rn, a.* FROM ( " 
				+ sql
				+ ") a" 
				+ ") WHERE rn BETWEEN " 
				+ pos_ini 
				+ " AND " 
				+ pos_fin;
		} else {
			if(pos_fin > 0) {
				sql = "SELECT a.* FROM ( " + sql + ") a" + " WHERE rownum < " + pos_fin;
			}
		}
		
		return sql;
	}

	public Cliente findTotalClientebyFilter(String cod_territorio
			, String cod_oficina
			, String cod_gestor
			, String nivel_vinculacion
			, String clasificacion
			, String margen
			, String etiqueta
			, String edad
			, String porcrie
			, String cod_empresa
			, String tipo_cliente
			, String cod_cliente
			, int tipoOpcion) {
		
		Cliente cliente = null;
		String sql = null;
		
		try {

			sql = findTotalClientebyFilter_sql(cod_territorio
					, cod_oficina
					, cod_gestor
					, nivel_vinculacion
					, clasificacion
					, margen
					, etiqueta
					, edad
					, porcrie
					, cod_empresa
					, tipo_cliente
					, cod_cliente
					, tipoOpcion);
			
			logger.info(sql);
			Connection con = getConnection();
			Statement s = con.createStatement();
			try {
				ResultSet rs = s.executeQuery(sql);

				// Filas
				while (rs.next()) {
					cliente = new Cliente();
					cliente.setCodigo(rs.getString("num_reg"));

					cliente.setT_act_ct2(rs.getLong("t_act_ct2"));
					cliente.setT_act_ct3(rs.getLong("t_act_ct3"));
					cliente.setT_act_ct4(rs.getLong("t_act_ct4"));
					cliente.setT_act_ct5(rs.getLong("t_act_ct5"));
					cliente.setT_act_ct6(rs.getString("t_act_ct6"));

					cliente.setBcorid(rs.getLong("bcorid"));
					cliente.setBcorii(rs.getLong("bcorii"));
					cliente.setBcorie(convertLong(rs,"bcorie"));
					cliente.setBcopas(convertLong(rs,"bcopas"));
					cliente.setBcovol(convertLong(rs,"bcovol"));

					cliente.setPper(convertLong(rs,"pper"));
					cliente.setPaut(convertLong(rs,"paut"));
					cliente.setPhip(convertLong(rs,"phip"));
					cliente.setPmiv(convertLong(rs,"pmiv"));
					cliente.setCpte(convertLong(rs,"cpte"));
					cliente.setPmas(convertLong(rs,"pmas"));
					cliente.setPcom(convertLong(rs,"pcom"));
					cliente.setDsct(convertLong(rs,"dsct"));
					cliente.setLeas(convertLong(rs,"leas"));
					cliente.setCloc(convertLong(rs,"cloc"));
					cliente.setPref(convertLong(rs,"pref"));
					cliente.setLcta(convertLong(rs,"lcta"));
					cliente.setProm(convertLong(rs,"prom"));
					cliente.setFcex(convertLong(rs,"fcex"));
					cliente.setAval(convertLong(rs,"aval"));
					cliente.setT_act2(convertLong(rs,"t_act2"));

					cliente.setVnac(convertLong(rs,"vnac"));
					cliente.setVarc(convertLong(rs,"varc"));
					cliente.setVcla(convertLong(rs,"vcla"));
					cliente.setVrep(convertLong(rs,"vrep"));
					cliente.setVoro(convertLong(rs,"voro"));
					cliente.setVpla(convertLong(rs,"vpla"));
					cliente.setVemp(convertLong(rs,"vemp"));
					cliente.setVctr(convertLong(rs,"vctr"));
					cliente.setMcla(convertLong(rs,"mcla"));
					cliente.setMoro(convertLong(rs,"moro"));
					cliente.setT_act3(convertLong(rs,"t_act3"));

					cliente.setCcte(convertLong(rs,"ccte"));
					cliente.setCemp(rs.getString("cemp"));
					cliente.setCvip(convertLong(rs,"cvip"));
					cliente.setAhsd(convertLong(rs,"ahsd"));
					cliente.setAhor(convertLong(rs,"ahor"));
					cliente.setPlzo(convertLong(rs,"plzo"));
					cliente.setSdep(convertLong(rs,"sdep"));
					cliente.setFmut(convertLong(rs,"fmut"));
					cliente.setCts(convertLong(rs,"cts"));
					cliente.setCtsd(convertLong(rs,"ctsd"));
					cliente.setT_act4(convertLong(rs,"t_act4"));

					cliente.setColb(convertLong(rs,"colb"));
					cliente.setCext(convertLong(rs,"cext"));
					cliente.setSvid(convertLong(rs,"svid"));
					cliente.setSonc(convertLong(rs,"sonc"));
					cliente.setSpro(convertLong(rs,"spro"));
					cliente.setPserv(convertLong(rs,"pserv"));
					cliente.setPh(convertLong(rs,"ph"));
					cliente.setEmph(convertLong(rs,"emph"));
					cliente.setTdeb(convertLong(rs,"tdeb"));
					cliente.setTvip(convertLong(rs,"tvip"));
					cliente.setT_act5(convertLong(rs,"t_act5"));

					cliente.setCnet(rs.getString("cnet"));
					cliente.setCemp(rs.getString("cemp"));
					cliente.setLinco(rs.getString("linco"));
					cliente.setB24(rs.getString("b24"));
					cliente.setPos(rs.getString("pos"));
					cliente.setT_act6(convertLong(rs,"t_act6"));

					// Campos Oferta
					cliente.setIntervpas(rs.getString("intervpas"));
					cliente.setMofactv(convertLong(rs,"mofactv"));
					cliente.setCs000lineamaxtc(convertLong(rs,"cs000lineamaxtc"));
					cliente.setMofpasv(rs.getString("mofpasv"));
					cliente.setMofserv(rs.getString("mofserv"));
					cliente.setMofcanal(rs.getString("mofcanal"));
					cliente.setMphpasv(rs.getString("mphpasv"));
					cliente.setCs000mtoprestamo(convertLong(rs,"cs000mtoprestamo"));
					cliente.setMontovehicular(convertLong(rs,"montovehicular"));
					// cliente.setMontohipotecario(convertLong(rs,"montohipotecario"));
					cliente.setCtacteoferta(rs.getString("ctacteoferta"));
					cliente.setCtaahoferta(rs.getString("ctaahoferta"));
					cliente.setCtapoferta(rs.getString("ctapoferta"));
					cliente.setFmutuoofert(rs.getString("fmutuoofert"));
					cliente.setCtactsofert(rs.getString("ctactsofert"));
					cliente.setTconsactv(rs.getBigDecimal("tconsactv"));
					cliente.setMontosubrogados(convertLong(rs,"montosubrogados"));
					cliente.setTsubactv(rs.getBigDecimal("tsubactv"));
					cliente.setThipotactv(convertBigDecimal(rs,"thipotactv"));
					cliente.setTvehicactv(convertBigDecimal(rs,"tvehicactv"));
					cliente.setCs000montocta36(rs.getString("cs000montocta36"));
					cliente.setTcuot36act(convertBigDecimal(rs,"tcuot36act"));
					cliente.setCs000montocta48(convertLong(rs,"cs000montocta48"));
					cliente.setTcuot48act(convertBigDecimal(rs,"tcuot48act"));
					cliente.setCs000montocta60(convertBigDecimal(rs,"cs000montocta60"));
					cliente.setTcuot60act(convertBigDecimal(rs,"tcuot60act"));
					cliente.setCs000presmena5000(convertBigDecimal(rs,"css000presmena5000"));
					cliente.setCs000comisdesemen5000(convertBigDecimal(rs,"cs000comisdesemen5000"));
					cliente.setCs000pres5000a15000(convertBigDecimal(rs,"cs000pres5000a15000"));
					cliente.setC5000comdes15000act(convertBigDecimal(rs,"c5000comdes15000act"));
					cliente.setCs000presmaya15000(convertBigDecimal(rs,"cs000presmaya15000"));
					cliente.setComdes15000ac(convertBigDecimal(rs,"comdes15000ac"));
					cliente.setCs000linminadqtc(convertLong(rs,"cs000linminadqtc"));
					cliente.setCs000tipodecredito(rs.getString("cs000tipodecredito"));
					cliente.setCs000mixmonprest(convertLong(rs,"cs000mixmonprest"));
					cliente.setCs000mixlinasistc(convertLong(rs,"cs000mixlinasistc"));
					cliente.setCs000mixtipotc(rs.getString("cs000mixtipotc"));
					cliente.setCs000prestcmena5000(convertBigDecimal(rs,"cs000prestcmena5000"));
					cliente.setCs000prestc500015000(convertBigDecimal(rs,"cs000prestc500015000"));
					cliente.setCs000prestcmaya15000(convertBigDecimal(rs,"cs000prestcmaya15000"));
					cliente.setAtribctactepasv(rs.getString("atribctactepasv"));
					cliente.setAtribctaahpasv(rs.getString("atribctaahpasv"));
					cliente.setAtribctaplazpasv(rs.getString("atribctaplazpasv"));
					cliente.setAtribctspasv(rs.getString("atribctspasv"));
					cliente.setAtribfmutuopasv(rs.getString("atribfmutuopasv"));
					cliente.setCobofserv(rs.getString("cobofserv"));
					cliente.setSvidofserv(rs.getString("svidofserv"));
					cliente.setSoncofserv(rs.getString("soncofserv"));
					cliente.setSvincofserv(rs.getString("svincofserv"));
					cliente.setPhofserv(rs.getString("phofserv"));
					cliente.setDebofserv(rs.getString("debofserv"));
					cliente.setVipofserv(rs.getString("vipofserv"));
					cliente.setOfcnetcan(rs.getString("ofcnetcan"));
					cliente.setOfcempcan(rs.getString("ofcempcan"));
					cliente.setOflincocan(rs.getString("oflincocan"));
					cliente.setOfb24can(rs.getString("ofb24can"));
					cliente.setOfposcan(rs.getString("ofposcan"));
				}

			} catch (SQLException e) {
				logger.error(e);
				logger.error("SQL: " + sql);
			}
			s.close();
			con.close();
		} catch (Exception e) {
			logger.error(e);
			logger.error("SQL: " + sql);
		}
		return cliente;
	}

	private String findTotalClientebyFilter_sql(String cod_territorio
			, String cod_oficina
			, String cod_gestor
			, String nivel_vinculacion
			, String clasificacion
			, String margen
			, String etiqueta
			, String edad
			, String porcrie
			, String cod_empresa
			, String tipo_cliente
			, String cod_cliente
			, int tipoOpcion) {
		
		String sql = "";
		Vector<String> parametros = armarParametros(cod_territorio,cod_oficina,cod_gestor,nivel_vinculacion,clasificacion,margen,etiqueta,edad,porcrie,cod_empresa,tipo_cliente,cod_cliente);

		for (int i = 0; i < parametros.size(); i++) {
			sql += " " + (String) parametros.elementAt(i);
			if (i < parametros.size() - 1)
				sql += " and";
		}
				
		String condicional="";
		if(tipoOpcion > 0){
			condicional=" ("
			+ "nvl(mofactv, 0) + "
			+ "nvl(t_act_ct2, 0) + "
			+ "nvl(T_act_ct3, 0) + "
			+ "nvl(cs000lineamaxtc, 0) + "
			+ "nvl(T_act_ct4, 0) + "
			+ "nvl(T_act_ct5, 0) + "
			+ "nvl(Margeno, 0) + "
			+ "nvl(Bcorid, 0) + "
			+ "nvl(Bcorii, 0) + "
			+ "nvl(Sbsrid, 0) + "
			+ "nvl(Sbsrii, 0) + "
			+ "nvl(Sbsrie, 0) + "
			+ "nvl(Sbsjud, 0) + "
			+ "nvl(Porcrid, 0) + "
			+ "nvl(Porcrii, 0) + "
			+ "nvl(Porcrie, 0) + "
			+ "nvl(Pper, 0) + "
			+ "nvl(cs000mtoprestamo, 0) + "
			+ "nvl(Paut, 0) + "
			+ "nvl(montovehicular, 0) + "
			+ "nvl(Phip, 0) + "
			+ "nvl(Pmiv, 0) + "
			+ "nvl(Cpte, 0) + "
			+ "nvl(montohipotecario, 0) + "
			+ "nvl(Pmas, 0) + "
			+ "nvl(Pcom, 0) + "
			+ "nvl(Dsct, 0) + "
			+ "nvl(Leas, 0) + "
			+ "nvl(Cloc, 0) + "
			+ "nvl(Pref, 0) + "
			+ "nvl(Lcta, 0) + "
			+ "nvl(Prom, 0) + "
			+ "nvl(Fcex, 0) + "
			+ "nvl(Aval, 0) + "
			+ "nvl(T_act_ct2, 0) + "
			+ "nvl(Vnac, 0) + "
			+ "nvl(Varc, 0) + "
			+ "nvl(Vcla, 0) + "
			+ "nvl(Vrep, 0) + "
			+ "nvl(Voro, 0) + "
			+ "nvl(Vpla, 0) + "
			+ "nvl(Vemp, 0) + "
			+ "nvl(Vctr, 0) + "
			+ "nvl(Mcla, 0) + "
			+ "nvl(Moro, 0) + "
			+ "nvl(T_act_ct3, 0) + "
			+ "nvl(Cs000lineamaxtc, 0) + "
			+ "nvl(Ccte, 0) + "
			+ "nvl(Cemp, 0) + "
			+ "nvl(Cvip, 0) + "
			+ "nvl(Ahsd, 0) + "
			+ "nvl(Ahor, 0) + "
			+ "nvl(Plzo, 0) + "
			+ "nvl(Sdep, 0) + "
			+ "nvl(Fmut, 0) + "
			+ "nvl(Cts, 0) + "
			+ "nvl(Ctsd, 0) + "
			+ "nvl(T_act_ct4, 0) + "
			+ "nvl(Colb, 0) + "
			+ "nvl(Svid, 0) + "
			+ "nvl(Sonc, 0) + "
			+ "nvl(Spro, 0) + "
			+ "nvl(Ph, 0) + "
			+ "nvl(Emph, 0) + "
			+ "nvl(Tdeb, 0) + "
			+ "nvl(Tvip, 0) + "
			+ "nvl(Pserv, 0) + "
			+ "nvl(Cext, 0) + "
			+ "nvl(T_act_ct5, 0) + "
			+ "nvl(Cs000mtoprestamo, 0) + "
			+ "nvl(tconsactv, 0) + "
			+ "nvl(Montosubrogados, 0) + "
			+ "nvl(Tsubactv, 0) + "
			+ "nvl(montohipotecario, 0) + "
			+ "nvl(Thipotactv, 0) + "
			+ "nvl(montovehicular, 0) + "
			+ "nvl(Tvehicactv, 0) + "
			+ "nvl(Tcuot36act, 0) + "
			+ "nvl(Cs000montocta48, 0) + "
			+ "nvl(Tcuot48act, 0) + "
			+ "nvl(Cs000montocta60, 0) + "
			+ "nvl(Tcuot60act, 0) + "
			+ "nvl(css000presmena5000, 0) + "
			+ "nvl(Cs000comisdesemen5000, 0) + "
			+ "nvl(Cs000pres5000a15000, 0) + "
			+ "nvl(C5000comdes15000act, 0) + "
			+ "nvl(Cs000presmaya15000, 0) + "
			+ "nvl(Comdes15000ac, 0) + "
			+ "nvl(Cs000linminadqtc, 0) + "
			+ "nvl(Cs000lineamaxtc, 0) + "
			+ "nvl(Cs000mixmonprest, 0) + "
			+ "nvl(Cs000mixlinasistc, 0) + "
			+ "nvl(Cs000prestcmena5000, 0) + "
			+ "nvl(Cs000prestc500015000, 0) + "
			+ "nvl(Cs000prestcmaya15000, 0) > 0 or length(nvl(Ctacteoferta,'') "
			+ "|| nvl(Atribctactepasv,'') "
			+ "|| nvl(Ctaahoferta,'') "
			+ "|| nvl(Atribctaahpasv,'') "
			+ "|| nvl(Ctapoferta,'') "
			+ "|| nvl(Atribctaplazpasv,'') "
			+ "|| nvl(Ctactsofert,'') "
			+ "|| nvl(Atribctspasv,'') "
			+ "|| nvl(Fmutuoofert,'') "
			+ "|| nvl(Atribfmutuopasv,'') "
			+ "|| nvl(Cobofserv,'') "
			+ "|| nvl(Svidofserv,'') "
			+ "|| nvl(Soncofserv,'') "
			+ "|| nvl(Svincofserv,'') "
			+ "|| nvl(Phofserv,'') "
			+ "|| nvl(Debofserv,'') "
			+ "|| nvl(Vipofserv,'') "
			+ "|| nvl(Ofcnetcan,'') "
			+ "|| nvl(Ofcempcan,'') "
			+ "|| nvl(Oflincocan,'') "
			+ "|| nvl(Ofb24can,'') "
			+ "|| nvl(Ofposcan,'') "
			+ "|| nvl(Cs000mixtipotc,'') "
			+ "|| nvl(Cs000tipodecredito,'') "
			+ "|| nvl(Cs000montocta36,'') "
			+ "|| nvl(Phofserv,'') "
			+ "|| nvl(Mphpasv,'') "
			+ "|| nvl(cobofserv,'') "
			+ "|| nvl(Ctactsofert,'') "
			+ "|| nvl(Fmutuoofert,'') "
			+ "|| nvl(Ctapoferta,'') "
			+ "|| nvl(Ctaahoferta,'') "
			+ "|| nvl(Ctacteoferta,'') "
			+ "|| nvl(cs000tipodecredito,'') "
			+ "|| nvl(intervpas,'') "
			+ "|| nvl(mofserv,'') "
			+ "|| nvl(mphpasv,'') "
			+ "|| nvl(Mofpasv,''))>0 )";
		}
		
		if(tipoOpcion == 6){
			if(sql.length() > 0) {
				sql = sql + " AND ";
			}
			sql = sql + "NVL(FLAG_OFERTA, '-') IN('1', '2') ";
		}
		
		if (sql.length() > 0)
			sql = " where " + condicional + (condicional.length() > 0 ? " and " : "") + sql;

		/*
		cliente.setCnet(convertNumero(rst.getString("Cnet")));
		cliente.setCemp(convertNumero(rst.getString("Cemp")));
		cliente.setLinco(convertNumero(rst.getString("Linco")));
		cliente.setB24(convertNumero(rst.getString("B24")));
		cliente.setPos(convertNumero(rst.getString("Pos")));
		cliente.setT_act_ct6(convertNumero(rst.getString("T_act_ct6")));
		*/
		
		sql = "select count(1) as num_reg, SUM(o.t_act_ct2) as t_act_ct2, SUM(o.t_act_ct3) as t_act_ct3, SUM(o.t_act_ct4) as t_act_ct4,"
				+ "SUM(o.t_act_ct5) as t_act_ct5, SUM(o.t_act_ct6) as t_act_ct6, SUM(o.bcorid) as bcorid, "
				+ "SUM(o.bcorii) as bcorii, SUM(o.bcorie) as bcorie, SUM(o.bcopas) as bcopas, "
				+ "SUM(o.bcovol) as bcovol, SUM(o.pper) as pper, SUM(o.paut) as paut, SUM(o.phip) as phip, "
				+ "SUM(o.pmiv) as pmiv, SUM(o.cpte) as cpte, SUM(o.pmas) as pmas, SUM(o.pcom) as pcom, "
				+ "SUM(o.dsct) as dsct, SUM(o.leas) as leas, SUM(o.cloc) as cloc, SUM(o.pref) as pref, "
				+ "SUM(o.lcta) as lcta, SUM(o.prom) as prom, SUM(o.fcex) as fcex, SUM(o.aval) as aval, "
				+ "SUM(o.t_act2) as t_act2, SUM(o.vnac) as vnac, SUM(o.varc) as varc, SUM(o.vcla) as vcla, "
				+ "SUM(o.vrep) as vrep, SUM(o.voro) as voro, SUM(o.vpla) as vpla, SUM(o.vemp) as vemp, "
				+ "SUM(o.vctr) as vctr, SUM(o.mcla) as mcla, SUM(o.moro) as moro, SUM(o.t_act3) as t_act3, "
				// + "SUM(o.ccte) as ccte, SUM(o.cemp) as cemp, SUM(o.cvip) as cvip, SUM(o.ahsd) as ahsd, "
				+ "SUM(o.ccte) as ccte, '' as cemp, SUM(o.cvip) as cvip, SUM(o.ahsd) as ahsd, "
				+ "SUM(o.ahor) as ahor, SUM(o.plzo) as plzo, SUM(o.sdep) as sdep, SUM(o.fmut) as fmut, "
				+ "SUM(o.cts) as cts, SUM(o.ctsd) as ctsd, SUM(o.t_act4) as t_act4, SUM(o.colb) as colb, "
				+ "SUM(o.cext) as cext, SUM(o.svid) as svid, SUM(o.sonc) as sonc, SUM(o.spro) as spro, "
				+ "SUM(o.pserv) as pserv, SUM(o.ph) as ph, SUM(o.emph) as emph, SUM(o.tdeb) as tdeb, "
				//+ "SUM(o.tvip) as tvip, SUM(o.t_act5) as t_act5, SUM(o.cnet) as cnet, SUM(o.cemp) as cemp, "
				+ "SUM(o.tvip) as tvip, SUM(o.t_act5) as t_act5, '' as cnet, '' as cemp, "
				//+ "SUM(o.linco) as linco, SUM(o.b24) as b24, SUM(o.pos) as pos, SUM(o.t_act6) as t_act6, "
				+ "'' as linco, '' as b24, '' as pos, '' as t_act6, "
				+ "'' as intervpas, SUM(o.mofactv) as mofactv, SUM(o.cs000lineamaxtc) as cs000lineamaxtc, '' as mofpasv, "
				+ "'' as mofserv, '' as mofcanal, '' as mphpasv, SUM(o.cs000mtoprestamo) as cs000mtoprestamo, "
				+ "SUM(o.montovehicular) as montovehicular, SUM(o.montohipotecario) as montohipotecario, '' as ctacteoferta, '' as ctaahoferta, "
				+ "'' as ctapoferta, '' as fmutuoofert, '' as ctactsofert, SUM(o.tconsactv) as tconsactv, "
				+ "SUM(o.montosubrogados) as montosubrogados, SUM(o.tsubactv) as tsubactv, SUM(o.thipotactv) as thipotactv, SUM(o.tvehicactv) as tvehicactv, "
				//+ "SUM(o.cs000montocta36) as cs000montocta36, SUM(o.tcuot36act) as tcuot36act, SUM(o.cs000montocta48) as cs000montocta48, SUM(o.tcuot48act) as tcuot48act, "
				+ "'' as cs000montocta36, SUM(o.tcuot36act) as tcuot36act, '' as cs000montocta48, SUM(o.tcuot48act) as tcuot48act, "
				+ "SUM(o.cs000montocta60) as cs000montocta60, SUM(o.tcuot60act) as tcuot60act, SUM(o.css000presmena5000) as css000presmena5000, SUM(o.cs000comisdesemen5000) as cs000comisdesemen5000, "
				+ "SUM(o.cs000pres5000a15000) as cs000pres5000a15000, SUM(o.c5000comdes15000act) as c5000comdes15000act, SUM(o.cs000presmaya15000) as cs000presmaya15000, SUM(o.comdes15000ac) as comdes15000ac, "
				+ "SUM(o.cs000linminadqtc) as cs000linminadqtc, '' as cs000tipodecredito, SUM(o.cs000mixmonprest) as cs000mixmonprest, SUM(o.cs000mixlinasistc) as cs000mixlinasistc, "
				+ "'' as cs000mixtipotc, SUM(o.cs000prestcmena5000) as cs000prestcmena5000, SUM(o.cs000prestc500015000) as cs000prestc500015000, SUM(o.cs000prestcmaya15000) as cs000prestcmaya15000, "
				+ "'' as atribctactepasv, '' as atribctaahpasv, '' as atribctaplazpasv, '' as atribctspasv, "
				+ "'' as atribfmutuopasv, '' as cobofserv, '' as svidofserv, '' as soncofserv, "
				+ "'' as svincofserv, '' as phofserv, '' as debofserv, '' as vipofserv, "
				+ "'' as ofcnetcan, '' as ofcempcan, '' as oflincocan, '' as ofb24can, "
				+ "'' as ofposcan " +

				"from " + tableName + " o" + sql;

		return sql;
	}

	public Vector<Empresa> findAllEmpresasbyFilter(String cod_territorio
			, String cod_oficina
			, String cod_gestor
			, String nivel_vinculacion
			, String clasificacion
			, String margen
			, String etiqueta
			, String edad
			, String porcrie
			, String tipo_cliente
			, String cod_cliente) {
		Vector<Empresa> res = null;

		String sql = null;
		try {
			Empresa beanEmpresa = null;
			Connection con = getConnection();

			sql = findAllEmpresasbyFilter_sql(cod_territorio, cod_oficina,
					cod_gestor, nivel_vinculacion, clasificacion, margen,
					etiqueta, edad, porcrie, tipo_cliente, cod_cliente);
			
			Statement s = con.createStatement();
			try {
				
				ResultSet rst = s.executeQuery(sql);

				//filas
				while (rst.next()) {
					if (res == null)
						res = new Vector<Empresa>(0, 1);
					beanEmpresa = new Empresa();
					beanEmpresa.setCod_empresa(rst.getString("COD_EMPRESA"));
					beanEmpresa.setDes_empresa(rst.getString("DES_EMPRESA"));
					res.add(beanEmpresa);
				}

			} catch (SQLException e) {
				logger.error(e);
				logger.error("SQL: " + sql);
			}
			s.close();
			con.close();
		} catch (Exception e) {
			logger.error(e);
			logger.error("SQL: " + sql);
		}
		return res;
	}

	private String findAllEmpresasbyFilter_sql(String cod_territorio
			, String cod_oficina
			, String cod_gestor
			, String nivel_vinculacion
			, String clasificacion
			, String margen
			, String etiqueta
			, String edad
			, String porcrie
			, String tipo_cliente
			, String cod_cliente) {
		String sql = "";

		
		Vector<String> parametros = armarParametros(cod_territorio,cod_oficina,cod_gestor,nivel_vinculacion,clasificacion,margen,etiqueta,edad,porcrie,"-1", tipo_cliente, cod_cliente);

		for (int i = 0; i < parametros.size(); i++) {
			sql += " " + (String) parametros.elementAt(i);
			if (i < parametros.size() - 1)
				sql += " AND";
		}
		if (sql.length() > 0)
			sql = " AND" + sql;

		if (sql.length() == 0) {
			sql = "SELECT * FROM iilc.tiilc_empresa WHERE cod_empresa NOT IN('00000000') ORDER BY des_empresa";
		} else {
			sql = "SELECT * FROM iilc.tiilc_empresa WHERE cod_empresa IN "
					+ "(SELECT o.cod_empresa FROM " + tableName + " o WHERE o.cod_empresa NOT IN('00000000') " + sql
					+ " GROUP BY o.cod_empresa) ORDER BY des_empresa";
		}
		
		return sql;
	}
	
	private Long convertLong(ResultSet resultSet, String column) {
		Long result = 0L;
		try {
			result = resultSet.getLong(column);
		} catch(NumberFormatException e) {
			logger.error(column);
			logger.error(e);
		} catch(SQLException e) {
			logger.error(column);
			logger.error(e);
		}
		
		return result;
	}
	
	private BigDecimal convertBigDecimal(ResultSet resultSet, String column) {
		BigDecimal result = BigDecimal.ZERO;
		try {
			result = resultSet.getBigDecimal(column);
		} catch(NumberFormatException e) {
			logger.error(column);
			logger.error(e);
		} catch(SQLException e) {
			logger.error(column);
			logger.error(e);
		}
		
		return result;
	}
	
    public EstadoCarga ultimoFechaCarga(){
		EstadoCarga bean = null;
		Connection con = null;
		ResultSet rst = null;
		Statement s = null;
    	try {
			String query = "select max(fecha_fin) fecha_fin from iilc.tiilc_adm_carga_archivo where id_registro > 3";
			
    		con = getConnection();
			s = con.createStatement();
			
			try {
				rst = s.executeQuery(query);
				while (rst.next()) {
					bean = new EstadoCarga();
					bean.setFechaFin(rst.getTimestamp("fecha_fin"));
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		} catch (Exception e) {
			logger.error(e);
		} finally {
			try {
				s.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}
		
		return bean;
    }
	
    public EstadoCarga ultimoEstadoCarga(){
		EstadoCarga bean = null;
		Connection con = null;
		ResultSet rst = null;
		Statement s = null;
    	try {
			String query = "SELECT * FROM iilc.tiilc_estado_carga WHERE fecha_ini IN (SELECT MAX(fecha_ini) FROM iilc.tiilc_estado_carga)";
			
    		con = getConnection();
			s = con.createStatement();
			
			try {
				rst = s.executeQuery(query);
				while (rst.next()) {
					bean = new EstadoCarga();
					bean.setFechaIni(rst.getTimestamp("fecha_ini"));
					bean.setFechaFin(rst.getTimestamp("fecha_fin"));
					bean.setEstado(rst.getLong("estado"));
					bean.setArchivoEncontrado(convertLong(rst,"archivo_encontrado"));
					bean.setTablasTruncadas(convertLong(rst,"tablas_truncadas"));
					bean.setFilasProcesadas(convertLong(rst,"filas_procesadas"));
					bean.setFilasCLeidas(convertLong(rst,"filas_c_leidas"));
					bean.setFilasCEscritas(convertLong(rst,"filas_c_escritas"));
					bean.setFilasGLeidas(convertLong(rst,"filas_g_leidas"));
					bean.setFilasGEscritas(convertLong(rst,"filas_g_escritas"));
					bean.setFilasOLeidas(convertLong(rst,"filas_o_leidas"));
					bean.setFilasOEscritas(convertLong(rst,"filas_o_escritas"));
					bean.setFilasTLeidas(convertLong(rst,"filas_t_leidas"));
					bean.setFilasTEscritas(convertLong(rst,"filas_t_escritas"));
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		} catch (Exception e) {
			logger.error(e);
		} finally {
			try {
				s.close();
			} catch (Throwable e) {}
			try {
				con.close();
			} catch (Throwable e) {}
		}
		
		return bean;
    }
	
	/**
	 * Construye segmento SQL para porcentaje
	 * @param porcrie
	 * @return
	 * (o.porcrie between 0 and 25 or o.porcrie between 51 and 75) 
	 */
	private String construirPorcentaje(String porcrie) {
		String[] codigos = porcrie.split(",");
		StringBuffer sql = new StringBuffer();
		Multitabla beanLocal;
		String codMult;
		String codEle;	
		
		for (int i = 0; i < codigos.length; i++) {
			codMult = codigos[i].substring(0, 3);
			codEle = codigos[i].substring(3, codigos[i].length());
			beanLocal = findMultitabla(codMult, codEle);
			if (beanLocal != null) {
				if (sql.length() > 0) sql.append(" or ");
				sql.append("o.porcrie between " + beanLocal.getValor2() + " and " + beanLocal.getValor3());
			}
		}

		if (sql.length() > 0) {
			sql.insert(0, " (");
			sql.append(") ");
		}
		return sql.toString();
	}

	/**
	 * Construye segmento SQL para clasificacion
	 * @param clasificacion
	 * @return
	 *  o.clasificacion in ('','','')
	 */
	private String construirClasificacion(String clasificacion) {
		String[] codigos = clasificacion.split(",");
		StringBuffer sql = new StringBuffer();
		Multitabla beanLocal;
		String codMult;
		String codEle;
		
		for (int i = 0; i < codigos.length; i++) {
			codMult = codigos[i].substring(0, 3);
			codEle = codigos[i].substring(3, codigos[i].length());
			beanLocal = findMultitabla(codMult, codEle);
			if (beanLocal != null) {
				if (sql.length() > 0)
					sql.append(",");
				sql.append("'" + beanLocal.getValor2() + "'");
			}
		}

		if (sql.length() > 0) {
			sql.insert(0, " o.clasificacion in (");
			sql.append(") ");
		}
		return sql.toString();
	}

	/**
	 * Construye un segmento SQL para nivel vinculacion
	 * @param nivel_vinculacion
	 * @return
	 *  o.vinculacion in ('','','')
	 */
	private String construirNivelVinculacion(String nivel_vinculacion) {
		String[] codigos = nivel_vinculacion.split(",");
		StringBuffer sql = new StringBuffer();
		Multitabla beanLocal;
		String codMult;
		String codEle;
		
		for (int i = 0; i < codigos.length; i++) {
			codMult = codigos[i].substring(0, 3);
			codEle = codigos[i].substring(3, codigos[i].length());
			beanLocal = findMultitabla(codMult, codEle);
			if (beanLocal != null) {
				if (sql.length() > 0)
					sql.append(",");
				sql.append("'" + beanLocal.getValor2() + "'");
			}
		}

		if (sql.length() > 0) {
			sql.insert(0, " o.vinculacion in (");
			sql.append(") ");
		}
		return sql.toString();
	}
	
	/**
	 * Construye un segmento SQL para edad
	 * @param edad
	 * @return
	 *  (o.edad between 18 and 25 or o.edad between 45 and 60) 
	 */
	private String construirEdad(String edad) {
		String[] codigos = edad.split(",");
		StringBuffer sql = new StringBuffer();
		Multitabla beanLocal;
		String codMult;
		String codEle;
		
		for (int i = 0; i < codigos.length; i++) {
			codMult = codigos[i].substring(0, 3);
			codEle = codigos[i].substring(3, codigos[i].length());
			beanLocal = findMultitabla(codMult, codEle);
			if (beanLocal != null) {
				if (sql.length() > 0)
					sql.append(" or ");
				sql.append("o.edad between " + beanLocal.getValor2() + " and " + beanLocal.getValor3());
			}
		}

		if (sql.length() > 0) {
			sql.insert(0, " (");
			sql.append(") ");
		}
		return sql.toString();
	}

	/**
	 * Construye un segmento SQL para etiqueta
	 * @param etiqueta
	 * @return
	 *  o.perfil in ('','','')
	 */
	private String construirEtiqueta(String etiqueta) {
		String[] codigos = etiqueta.split(",");
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		StringBuffer sql3 = new StringBuffer();
		StringBuffer temp = new StringBuffer();
		List<Multitabla> listaSegm;
		Multitabla beanLocal;
		String codMult;
		String codEle;
		int tipo;
		for (int i = 0; i < codigos.length; i++) {
			codMult = codigos[i].substring(0, 3);
			codEle = codigos[i].substring(3, codigos[i].length());
			beanLocal = findMultitabla(codMult, codEle);
			
			if (beanLocal != null) {
				listaSegm = findMultitablaSegmento("T05", codEle);
				temp = new StringBuffer();
				
				for(Multitabla o : listaSegm){
					if(temp.length()>0) temp.append(",");
					temp.append("'" + o.getValor1() + "'");
				}
				
				tipo = Integer.parseInt(beanLocal.getValor2());
				logger.info("Etiqueta: " + beanLocal.getValor1() + " //Segmentos(" + temp.toString() + ") //Tipo: " + tipo);
				
				switch(tipo) {
				case 0: // Libre
					if(sql.length()>0) sql.append(",");
					sql.append(temp.toString());
					break;
				case 1: // Personalizado
					if(sql2.length()>0) sql2.append(" OR ");
					sql2.append("( o.segment1 in(");
					sql2.append(temp.toString());
					sql2.append(") AND o.gestor_masa=0 )");
					break;
				case 2: // No Personalizado
					if(sql3.length()>0) sql3.append(" OR ");
					sql3.append("( o.segment1 in(");
					sql3.append(temp.toString());
					sql3.append(") AND o.gestor_masa=1 )");
					break;
				}
			}
		}
		
		if(sql.length()>0){
			sql.insert(0, "o.segment1 in (");
			sql.append(") ");
		}
		
		boolean sw = false;
		if(sql2.length()>0) {
			if(sql.length()>0) {
				sql.append(" OR (");
				sw = true;
			}
			sql.append(sql2.toString());
			if(sw) sql.append(" )");
		}
		
		sw = false;
		if(sql3.length()>0) {
			if(sql.length()>0) {
				sql.append(" OR (");
				sw = true;
			}
			sql.append(sql3.toString());
			if(sw) sql.append(" )");
		}
		
		if(sql.length()>0){
			sql.insert(0, "(");
			sql.append(") ");
		}
		
		return sql.toString();
	}
	
	/**
	 * Construye un segmento SQL para margen ordinario
	 * @param margen
	 * @return
	 *  (o.margeno between 0 and 5 or o.margeno between 50 and 75 or o.margeno between 150 and 200) 
	 */
	private String construirMargenesOrdinarios(String margen) {
		String[] codigos = margen.split(",");
		StringBuffer sql = new StringBuffer();
		Multitabla beanLocal;
		String codMult;
		String codEle;
		
		for (int i = 0; i < codigos.length; i++) {
			codMult = codigos[i].substring(0, 3);
			codEle = codigos[i].substring(3, codigos[i].length());
			beanLocal = findMultitabla(codMult, codEle);
			if (beanLocal != null) {
				if (sql.length() > 0)
					sql.append(" or ");
				sql.append("o.margeno between " + beanLocal.getValor2() + " and " + beanLocal.getValor3());
			}
		}

		if (sql.length() > 0) {
			sql.insert(0, " (");
			sql.append(") ");
		}
		return sql.toString();
	}


	private String detalleFiltroComplejo(String tipo, String[] codigos) {
		com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection conexion = new com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection();
		Vector<Multitabla> lista = null;
		String tipo2 = "";
		String res = "";
		if (tipo.equals("T04"))
			tipo2 = "T05";
		else
			tipo2 = "T08";

		lista = conexion.listaDetalleFiltroComplejo(tipo, tipo2, codigos);

		if (lista != null) {
			for (int i = 0; i < lista.size() - 1; i++) {
				Multitabla bean = lista.elementAt(i);
				Multitabla beanSig = lista.elementAt(i + 1);
				if (bean.getValor1().equals(beanSig.getValor1())) {
					bean.setValor2(bean.getValor2() + "," + beanSig.getValor2());
					lista.remove(i + 1);
					i--;
				}
			}

			for (int i = 0; i < lista.size(); i++) {
				if (i > 0)
					res += ", ";
				Multitabla bean = lista.elementAt(i);
				res += bean.getValor1() + " (" + bean.getValor2() + ")";
			}
		}

		return res;
	}

	private String detalleFiltroSimple(String tipo, String[] codigos) {
		com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection conexion = new com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection();
		Vector<Multitabla> lista = null;
		String res = "";
		lista = conexion.listaDetalleFiltroSimple(tipo, codigos);

		if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {
				Multitabla bean = lista.elementAt(i);
				if (!res.equals(""))
					res += ", ";
				res += bean.getValor1();
			}
		}

		return res;
	}

	private String detalleFiltroEmpresa(String codigo) {
		com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection cnx = new com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection();
		String res = "";
		String[] val = codigo.split(","); 

		for(int i = 0; i < val.length; i++){
			Empresa bean = cnx.datosEmpresa(val[i]);
			res += bean.getDes_empresa() + ",";
		}
		
		return res.substring(0, res.length() - 1);
	}

	public String[][] datosDetalleFiltro2(Consulta con) {
		String res[][] = new String[8][2];
		String cod;

		if (!con.getNivelVinculacion().equals("-1")) {
			cod = con.getNivelVinculacion().substring(0, 3);
			res[0][0] = "NIVEL DE VINCULACI&Oacute;N";
			res[0][1] = detalleFiltroComplejo(cod, con.getNivelVinculacion().replaceAll(cod, "").split(","));
			if(res[0][1] != null && res[0][1].length() > 450) {
				res[0][1] = res[0][1].substring(1, 448);
			}
		}
		if (!con.getClasificacion().equals("-1")) {
			cod = con.getClasificacion().substring(0, 3);
			res[1][0] = "CLASIFICACI&Oacute;N";
			res[1][1] = detalleFiltroSimple(cod, con.getClasificacion().replaceAll(cod, "").split(","));
			if(res[1][1] != null && res[1][1].length() > 450) {
				res[1][1] = res[1][1].substring(1, 448);
			}
		}
		if (!con.getMargenOrdinario().equals("-1")) {
			cod = con.getMargenOrdinario().substring(0, 3);
			res[2][0] = "MARGEN ORDINARIO";
			res[2][1] = detalleFiltroSimple(cod, con.getMargenOrdinario().replaceAll(cod, "").split(","));
			if(res[2][1] != null && res[2][1].length() > 450) {
				res[2][1] = res[2][1].substring(1, 448);
			}
		}
		if (!con.getEtiqueta().equals("-1")) {
			cod = con.getEtiqueta().substring(0, 3);
			res[3][0] = "ETIQUETA";
			res[3][1] = detalleFiltroComplejo(cod, con.getEtiqueta().replaceAll(cod, "").split(","));
			if(res[3][1] != null && res[3][1].length() > 450) {
				res[3][1] = res[3][1].substring(1, 448);
			}
		}
		if (!con.getEdad().equals("-1")) {
			cod = con.getEdad().substring(0, 3);
			res[4][0] = "EDAD";
			res[4][1] = detalleFiltroSimple(cod, con.getEdad().replaceAll(cod, "").split(","));
			if(res[4][1] != null && res[4][1].length() > 450) {
				res[4][1] = res[4][1].substring(1, 448);
			}
		}
		if (!con.getCuotaRiesgoTotal().equals("-1")) {
			cod = con.getCuotaRiesgoTotal().substring(0, 3);
			res[5][0] = "CUOTA RIESGO TOTAL";
			res[5][1] = detalleFiltroSimple(cod, con.getCuotaRiesgoTotal().replaceAll(cod, "").split(","));
			if(res[5][1] != null && res[5][1].length() > 450) {
				res[5][1] = res[5][1].substring(1, 448);
			}	
		}
		if (!con.getCodEmpresa().equals("-1")) {
			cod = con.getCodEmpresa();
			res[6][0] = "PAGO DE HABERES";
			res[6][1] = detalleFiltroEmpresa(cod);
			if(res[6][1] != null && res[6][1].length() > 450) {
				res[6][1] = res[6][1].substring(1, 448);
			}
		}
		if (!con.getTipoCliente().equals("-1")) {
			cod = con.getTipoCliente();
			res[7][0] = "TIPO DE CLIENTE";
			res[7][1] = detalleFiltroSimple("T10", con.getTipoCliente().split(","));
			if(res[7][1] != null && res[7][1].length() > 450) {
				res[7][1] = res[7][1].substring(1, 448);
			}
		}
		
		return res;
	}
	
	public String[][] datosDetalleFiltro(Consulta con) {
		String res[][] = new String[8][2];
		String cod;

		if (!con.getNivelVinculacion().equals("-1")) {
			cod = con.getNivelVinculacion().substring(0, 3);
			res[0][0] = "NIVEL DE VINCULACI&Oacute;N";
			res[0][1] = detalleFiltroComplejo(cod, con.getNivelVinculacion().replaceAll(cod, "").split(","));
		}
		if (!con.getClasificacion().equals("-1")) {
			cod = con.getClasificacion().substring(0, 3);
			res[1][0] = "CLASIFICACI&Oacute;N";
			res[1][1] = detalleFiltroSimple(cod, con.getClasificacion().replaceAll(cod, "").split(","));
		}
		if (!con.getMargenOrdinario().equals("-1")) {
			cod = con.getMargenOrdinario().substring(0, 3);
			res[2][0] = "MARGEN ORDINARIO";
			res[2][1] = detalleFiltroSimple(cod, con.getMargenOrdinario().replaceAll(cod, "").split(","));
		}
		if (!con.getEtiqueta().equals("-1")) {
			cod = con.getEtiqueta().substring(0, 3);
			res[3][0] = "ETIQUETA";
			res[3][1] = detalleFiltroComplejo(cod, con.getEtiqueta().replaceAll(cod, "").split(","));
		}
		if (!con.getEdad().equals("-1")) {
			cod = con.getEdad().substring(0, 3);
			res[4][0] = "EDAD";
			res[4][1] = detalleFiltroSimple(cod, con.getEdad().replaceAll(cod, "").split(","));
		}
		if (!con.getCuotaRiesgoTotal().equals("-1")) {
			cod = con.getCuotaRiesgoTotal().substring(0, 3);
			res[5][0] = "CUOTA RIESGO TOTAL";
			res[5][1] = detalleFiltroSimple(cod, con.getCuotaRiesgoTotal().replaceAll(cod, "").split(","));
		}
		if (!con.getCodEmpresa().equals("-1")) {
			cod = con.getCodEmpresa();
			res[6][0] = "PAGO DE HABERES";
			res[6][1] = detalleFiltroEmpresa(cod);
		}
		if (!con.getTipoCliente().equals("-1")) {
			cod = con.getTipoCliente();
			res[7][0] = "TIPO DE CLIENTE";
			res[7][1] = detalleFiltroSimple("T10", con.getTipoCliente().split(","));
		}
		
		return res;
	}	
}