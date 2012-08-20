package com.grupobbva.bc.per.tel.iilc.session;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.grupobbva.bc.per.tel.iilc.serializable.EstadoCarga;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.ibm.etools.service.locator.ServiceLocatorManager;
/**
 * Bean implementation class for Enterprise Bean: SessionSQL
 */

@SuppressWarnings({"unused", "unchecked", "serial"})
public class SessionSQLBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiilc_multitablaLocalHome_REF_NAME = "ejb/Tiilc_multitabla";
	private final static Class STATIC_Tiilc_multitablaLocalHome_CLASS = Tiilc_multitablaLocalHome.class;

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
 
	public List findAllCabeceras(String codigo) {
		List<Multitabla> res = null;
		//Vector row = new Vector(1,0);
		
		String sql = null;
		try {
			Multitabla multitabla = null;
			Connection con = null;
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}
			DataSource datasource = (DataSource) initialContext
					.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			sql = findAllCabeceras_sql(codigo);
			Statement s = con.createStatement();
			try {
				ResultSet rst = s.executeQuery(sql);

				//filas
				while (rst.next()) {
					if (res == null)
						res = new ArrayList();
					
					multitabla = new Multitabla();
 
					multitabla.setCod_mult(rst.getString("COD_MULT"));
					multitabla.setCod_ele(rst.getString("COD_ELE"));
					multitabla.setValor1(rst.getString("VALOR1"));
					multitabla.setValor2(rst.getString("VALOR2"));
					multitabla.setValor3(rst.getString("VALOR3"));
					multitabla.setValor4(rst.getString("VALOR4"));

					res.add(multitabla);
				}

			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
			s.close();
			con.close();
			initialContext.close();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		return res;
	}
	
	public Vector<Cliente> findAllClientebyFilter(int pos_ini, int pos_fin,
			String cod_territorio, String cod_oficina, String cod_gestor,
			String nivel_vinculacion, String clasificacion, String margen,
			String etiqueta, String edad, String porcrie, String cod_empresa, boolean pestanaTodos) {
		
		return null;
	}

	
	private String findAllCabeceras_sql(String codigo) {
		String sql = "";
		sql = "select  * from iilc.TIILC_MULTITABLA where cod_mult like '"+codigo+"%' order by cod_mult,to_number(cod_ele)";
		return sql;
	}

	
	public String findAllClientebyFilter_sql(int pos_ini, int pos_fin,
			String cod_territorio, String cod_oficina, String cod_gestor,
			String nivel_vinculacion, String clasificacion, String margen,
			String etiqueta, String edad, String porcrie, String cod_empresa, boolean pestanaTodos) {
		String sql = "";
		
		Vector<String> parametros = armarParametros(cod_territorio,cod_oficina,cod_gestor,nivel_vinculacion,clasificacion,margen,etiqueta,edad,porcrie,cod_empresa);

		// Concatenar Parametros
		for (int i = 0; i < parametros.size(); i++) {
			sql += " " + (String) parametros.elementAt(i);
			if (i < parametros.size() - 1) {
				sql += " and";
			}
		}
		
		if (sql.length() > 0){
			sql = " where " + sql;
			
			if(!pestanaTodos){
				sql=sql+" and ";
			}
			
		}else if(!pestanaTodos){
			sql = " where ";
		}
		
		String condicional="";
		if(!pestanaTodos){
			condicional="  (mofactv+t_act_ct2+T_act_ct3+cs000lineamaxtc+T_act_ct4+T_act_ct5+Margeno+Bcorid+Bcorii+Sbsrid+Sbsrii+Sbsrie+Sbsjud+Porcrid+Porcrii+Porcrie+Pper+cs000mtoprestamo+ "+
			"Paut+montovehicular+Phip+Pmiv+Cpte+montohipotecario+Pmas+Pcom+Dsct+Leas+Cloc+Pref+Lcta+Prom+Fcex+Aval+T_act_ct2+Vnac+Varc+Vcla+Vrep+Voro+Vpla+Vemp+Vctr+Mcla+"+
			"Moro+T_act_ct3+Cs000lineamaxtc+Ccte+Cemp+Cvip+Ahsd+Ahor+Plzo+Sdep+Fmut+Cts+Ctsd+T_act_ct4+Colb+Svid+Sonc+Spro+Ph+Emph+Tdeb+Tvip+Pserv+Cext+T_act_ct5+Cs000mtoprestamo+"+
			"tconsactv+Montosubrogados+Tsubactv+montohipotecario+Thipotactv+montovehicular+Tvehicactv+Tcuot36act+Cs000montocta48+Tcuot48act+Cs000montocta60+Tcuot60act+"+
			"css000presmena5000+Cs000comisdesemen5000+Cs000pres5000a15000+C5000comdes15000act+Cs000presmaya15000+Comdes15000ac+Cs000linminadqtc+Cs000lineamaxtc+Cs000mixmonprest+"+
			"Cs000mixlinasistc+Cs000prestcmena5000+Cs000prestc500015000+Cs000prestcmaya15000 >0 or " +
			" length(nvl(Ctacteoferta,'')	 ||nvl(Atribctactepasv,'')	 ||nvl(Ctaahoferta,'')	 ||nvl(Atribctaahpasv,'')	 ||nvl(Ctapoferta,'')	 ||nvl(Atribctaplazpasv,'')	 ||" +
			"nvl(Ctactsofert,'')	 ||nvl(Atribctspasv,'')	 ||nvl(Fmutuoofert,'')	 ||nvl(Atribfmutuopasv,'')	 ||nvl(Cobofserv,'')	 ||nvl(Svidofserv,'')	 ||nvl(Soncofserv,'')	 ||" +
			"nvl(Svincofserv,'')	 ||nvl(Phofserv,'')	 ||nvl(Debofserv,'')	 ||nvl(Vipofserv,'')	 ||nvl(Ofcnetcan,'')	 ||nvl(Ofcempcan,'')	 ||nvl(Oflincocan,'')	 ||" +
			"nvl(Ofb24can,'')	 ||nvl(Ofposcan,'')	 ||nvl(Cs000mixtipotc,'')	 ||nvl(Cs000tipodecredito,'')	 ||nvl(Cs000montocta36,'') ||" +
			"nvl(Phofserv,'')	 ||nvl(Mphpasv,'')	||nvl(cobofserv,'')	 ||nvl(Ctactsofert,'')	 ||nvl(Fmutuoofert,'')	 ||nvl(Ctapoferta,'')	 ||" +
			"nvl(Ctaahoferta,'')	 ||nvl(Ctacteoferta,'')	 ||nvl(cs000tipodecredito,'')	 ||nvl(intervpas,'')	 ||nvl(mofserv,'')	 ||nvl(mphpasv,'')	 ||nvl(Mofpasv,''))>0 )" ; 
		}

		sql = "select * from iilc.tiilc_cliente o" + sql + condicional + " ORDER BY o.cod_cliente ASC";

		// Paginacion
		sql = "SELECT * from ( " 
			+ "select rownum as rn, a.* FROM ( " 
			+ sql
			+ ") a" 
			+ ") where rn between " 
			+ pos_ini 
			+ " and " 
			+ pos_fin;
		return sql;
	}

	public Cliente findTotalClientebyFilter(String cod_territorio,
			String cod_oficina, String cod_gestor, String nivel_vinculacion,
			String clasificacion, String margen, String etiqueta, String edad,
			String porcrie, String cod_empresa) {
		
		return null;
	}

	private String findTotalClientebyFilter_sql(String cod_territorio,
			String cod_oficina, String cod_gestor, String nivel_vinculacion,
			String clasificacion, String margen, String etiqueta, String edad,
			String porcrie, String cod_empresa) {
		String sql = "";

		
		Vector<String> parametros = armarParametros(cod_territorio,cod_oficina,cod_gestor,nivel_vinculacion,clasificacion,margen,etiqueta,edad,porcrie,cod_empresa);

		//concatenar parametros
		for (int i = 0; i < parametros.size(); i++) {
			sql += " " + (String) parametros.elementAt(i);
			if (i < parametros.size() - 1)
				sql += " and";
		}
		if (sql.length() > 0)
			sql = " where" + sql;

		sql = "select count(*) as num_reg, SUM(o.t_act_ct2) as t_act_ct2, SUM(o.t_act_ct3) as t_act_ct3, SUM(o.t_act_ct4) as t_act_ct4,"
				+ "SUM(o.t_act_ct5) as t_act_ct5, SUM(o.t_act_ct6) as t_act_ct6, SUM(o.bcorid) as bcorid, "
				+ "SUM(o.bcorii) as bcorii, SUM(o.bcorie) as bcorie, SUM(o.bcopas) as bcopas, "
				+ "SUM(o.bcovol) as bcovol, SUM(o.pper) as pper, SUM(o.paut) as paut, SUM(o.phip) as phip, "
				+ "SUM(o.pmiv) as pmiv, SUM(o.cpte) as cpte, SUM(o.pmas) as pmas, SUM(o.pcom) as pcom, "
				+ "SUM(o.dsct) as dsct, SUM(o.leas) as leas, SUM(o.cloc) as cloc, SUM(o.pref) as pref, "
				+ "SUM(o.lcta) as lcta, SUM(o.prom) as prom, SUM(o.fcex) as fcex, SUM(o.aval) as aval, "
				+ "SUM(o.t_act2) as t_act2, SUM(o.vnac) as vnac, SUM(o.varc) as varc, SUM(o.vcla) as vcla, "
				+ "SUM(o.vrep) as vrep, SUM(o.voro) as voro, SUM(o.vpla) as vpla, SUM(o.vemp) as vemp, "
				+ "SUM(o.vctr) as vctr, SUM(o.mcla) as mcla, SUM(o.moro) as moro, SUM(o.t_act3) as t_act3, "
				+ "SUM(o.ccte) as ccte, SUM(o.cemp) as cemp, SUM(o.cvip) as cvip, SUM(o.ahsd) as ahsd, "
				+ "SUM(o.ahor) as ahor, SUM(o.plzo) as plzo, SUM(o.sdep) as sdep, SUM(o.fmut) as fmut, "
				+ "SUM(o.cts) as cts, SUM(o.ctsd) as ctsd, SUM(o.t_act4) as t_act4, SUM(o.colb) as colb, "
				+ "SUM(o.cext) as cext, SUM(o.svid) as svid, SUM(o.sonc) as sonc, SUM(o.spro) as spro, "
				+ "SUM(o.pserv) as pserv, SUM(o.ph) as ph, SUM(o.emph) as emph, SUM(o.tdeb) as tdeb, "
				+ "SUM(o.tvip) as tvip, SUM(o.t_act5) as t_act5, SUM(o.cnet) as cnet, SUM(o.cemp) as cemp, "
				+ "SUM(o.linco) as linco, SUM(o.b24) as b24, SUM(o.pos) as pos, SUM(o.t_act6) as t_act6, "
				+

				"'' as intervpas, SUM(o.mofactv) as mofactv, SUM(o.cs000lineamaxtc) as cs000lineamaxtc, '' as mofpasv, "
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

				"from iilc.Tiilc_cliente o" + sql;

		return sql;
	}

	public Vector<Empresa> findAllEmpresasbyFilter(String cod_territorio,
			String cod_oficina, String cod_gestor, String nivel_vinculacion,
			String clasificacion, String margen,
			String etiqueta, String edad, String porcrie) {
		Vector<Empresa> res = null;
		//Vector row = new Vector(1,0);

		String sql = null;
		try {
			Empresa beanEmpresa = null;
			Connection con = null;
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return null;
			}
			DataSource datasource = (DataSource) initialContext
					.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return null;
			}

			sql = findAllEmpresasbyFilter_sql(cod_territorio, cod_oficina,
					cod_gestor, nivel_vinculacion, clasificacion, margen,
					etiqueta, edad, porcrie);
			
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

			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
			s.close();
			con.close();
			initialContext.close();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		return res;
	}

	private String findAllEmpresasbyFilter_sql(String cod_territorio,
			String cod_oficina, String cod_gestor, String nivel_vinculacion,
			String clasificacion, String margen,
			String etiqueta, String edad, String porcrie) {
		String sql = "";

		
		Vector<String> parametros = armarParametros(cod_territorio,cod_oficina,cod_gestor,nivel_vinculacion,clasificacion,margen,etiqueta,edad,porcrie,"-1");

		//concatenar parametros
		for (int i = 0; i < parametros.size(); i++) {
			sql += " " + (String) parametros.elementAt(i);
			if (i < parametros.size() - 1)
				sql += " and";
		}
		if (sql.length() > 0)
			sql = " where" + sql;

		sql = "select * from iilc.tiilc_empresa where cod_empresa in "
				+ "(select o.cod_empresa from iilc.tiilc_cliente o " + sql
				+ ") ORDER BY des_empresa";

		return sql;
	}
	
    public EstadoCarga ultimoEstadoCarga(){
		EstadoCarga bean = null;
		Connection con = null;
		DataSource datasource = null;
		ResultSet rst = null;
		Statement s = null;
    	try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return bean;
			}
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return bean;
			}

			String query = "select * from iilc.tiilc_estado_carga where fecha_ini in (select max(fecha_ini) from iilc.tiilc_estado_carga)";
			s = con.createStatement();
			try {
				rst = s.executeQuery(query);
				while (rst.next()) {
					bean = new EstadoCarga();
					bean.setFechaIni(rst.getTimestamp("fecha_ini"));
					bean.setFechaFin(rst.getTimestamp("fecha_fin"));
					bean.setEstado(rst.getLong("estado"));
					bean.setArchivoEncontrado(rst.getLong("archivo_encontrado"));
					bean.setTablasTruncadas(rst.getLong("tablas_truncadas"));
					bean.setFilasProcesadas(rst.getLong("filas_procesadas"));
					bean.setFilasCLeidas(rst.getLong("filas_c_leidas"));
					bean.setFilasCEscritas(rst.getLong("filas_c_escritas"));
					bean.setFilasGLeidas(rst.getLong("filas_g_leidas"));
					bean.setFilasGEscritas(rst.getLong("filas_g_escritas"));
					bean.setFilasOLeidas(rst.getLong("filas_o_leidas"));
					bean.setFilasOEscritas(rst.getLong("filas_o_escritas"));
					bean.setFilasTLeidas(rst.getLong("filas_t_leidas"));
					bean.setFilasTEscritas(rst.getLong("filas_t_escritas"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
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
	
	private Vector<String> armarParametros(String cod_territorio,String cod_oficina, String cod_gestor, 
									String nivel_vinculacion, String clasificacion, String margen,
									String etiqueta, String edad, String porcrie, String cod_empresa){
		Vector<String> parametros = new Vector<String>(0, 1);

		if (!cod_territorio.equals("-1"))
			parametros.add("o.cod_territorio = '" + cod_territorio + "'");
		if (!cod_oficina.equals("-1"))
			parametros.add("o.cod_oficina = '" + cod_oficina + "'");
		if (!cod_gestor.equals("-1"))
			parametros.add("o.cod_gestor = '" + cod_gestor + "'");

		//niveles vinculacion
		if (!nivel_vinculacion.equals("-1"))
			parametros.add(construirNivelVinculacion(nivel_vinculacion));

		//clasificacion
		if (!clasificacion.equals("-1"))
			parametros.add(construirClasificacion(clasificacion));

		//margen ordinario
		if (!margen.equals("-1"))
			parametros.add(construirMargenesOrdinarios(margen));

		//etiqueta
		if (!etiqueta.equals("-1")) {
			parametros.add(construirEtiqueta(etiqueta));
		}

		//edad
		if (!edad.equals("-1")) {
			parametros.add(construirEdad(edad));
		}

		//porcentaje margen ordinario
		if (!porcrie.equals("-1")) {
			parametros.add(construirPorcentaje(porcrie));
		}
		
		//pago de haberes
		if(!cod_empresa.equals("-1"))
			parametros.add("o.cod_empresa = '" + cod_empresa + "'");
		
		return parametros;
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

		for (int i = 0; i < codigos.length; i++) {
			Tiilc_multitablaLocal beanLocal = find_Tiilc_multitablaLocalHome_findRecord(codigos[i]);
			if (beanLocal != null) {
				if (sql.length() > 0)
					sql.append(" or ");
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

		for (int i = 0; i < codigos.length; i++) {
			Tiilc_multitablaLocal beanLocal = find_Tiilc_multitablaLocalHome_findRecord(codigos[i]);
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

		for (int i = 0; i < codigos.length; i++) {
			Tiilc_multitablaLocal beanLocal = find_Tiilc_multitablaLocalHome_findRecord(codigos[i]);
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

		for (int i = 0; i < codigos.length; i++) {
			Tiilc_multitablaLocal beanLocal = find_Tiilc_multitablaLocalHome_findRecord(codigos[i]);
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

		for (int i = 0; i < codigos.length; i++) {
			// ALZ (2010.10.28) Ya no filtra por grupo de segmentos, sino directamente por campo perfil
			/*
			Collection aCollection = find_Tiilc_multitablaLocalHome_findMultitablaxValor2(codigos[i].substring(3,codigos[i].length()));
			Iterator it = aCollection.iterator();
			
			while(it.hasNext()){
				Tiilc_multitablaLocal beanLocal = (Tiilc_multitablaLocal)it.next();
				if(sql.length()>0) sql.append(",");
				sql.append("'" + beanLocal.getValor1() + "'");
			}
			*/
			Tiilc_multitablaLocal beanLocal = find_Tiilc_multitablaLocalHome_findRecord(codigos[i]);
			if (beanLocal != null) {
				if(sql.length()>0) sql.append(",");
				sql.append("'" + beanLocal.getValor1() + "'");
			}
		}
		
		if(sql.length()>0){
			//sql.insert(0," o.segment1 in (");
			sql.insert(0," o.perfil in (");
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

		for (int i = 0; i < codigos.length; i++) {
			Tiilc_multitablaLocal beanLocal = find_Tiilc_multitablaLocalHome_findRecord(codigos[i]);
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
	
	protected Tiilc_multitablaLocal find_Tiilc_multitablaLocalHome_findRecord(
			String codigo) {
		Tiilc_multitablaLocalHome aTiilc_multitablaLocalHome = (Tiilc_multitablaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiilc_multitablaLocalHome_REF_NAME,
						STATIC_Tiilc_multitablaLocalHome_CLASS);
		try {
			if (aTiilc_multitablaLocalHome != null)
				return aTiilc_multitablaLocalHome.findRecord(codigo);
		} catch (javax.ejb.FinderException fe) {
			fe.printStackTrace();
		}
		return null;
	}
}