/*
 * Created on 13/12/2007
 */
package com.grupobbva.bc.per.tel.iilc.conexionEJB;
 
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.jdbc.driver.OracleTypes;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.serializable.Area;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
import com.grupobbva.bc.per.tel.iilc.serializable.Total;
import com.grupobbva.bc.per.tel.iilc.session.SessionServiceAccessBean;
import com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome;
import com.grupobbva.bc.per.tel.iilc.session.SessionServiceLocalHome;
import com.stefanini.pe.framework.collections.DataTable;
 

/**
 * @author P020795
 * 
 */
@SuppressWarnings({"unused", "unchecked"})
public class Connection {

	//private final static String STATIC_SessionServiceLocalHome_REF_NAME = "ejb/SessionService";

	//private final static Class STATIC_SessionServiceLocalHome_CLASS = SessionServiceLocalHome.class;

	SessionServiceAccessBean acceso = new SessionServiceAccessBean();
	
	SessionServiceHome sessionServiceHome = null;
	private final static String STATIC_SessionServiceLocalHome_REF_NAME = "ejb/SessionService";
	private final static Class STATIC_SessionServiceLocalHome_CLASS = SessionServiceLocalHome.class;
	private Logger logger = Logger.getLogger(Connection.class);
	
	public Cliente findCliente(int cod_cliente) {
		Cliente res = null;
		try {
			res = acceso.findCliente(cod_cliente);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Gestor> findAllGestorxOfxTe(String cod_area,
			String cod_territorio, String cod_oficina) {
		Vector<Gestor> res = null;
		try {
			res = acceso.findAllGestorxOfxTe(cod_area,
					cod_territorio, cod_oficina);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<String> findATOG(String cod_usuario) {
		Vector<String> res = null;
		try {
			res = acceso.findATOG(cod_usuario);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Multitabla> findAllRecord(String cod_mult) {
		Vector<Multitabla> res = null;
		try {
			res = acceso.findAllRecord(cod_mult);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	/*public Multitabla findRecord(String codigo) {
		Multitabla res = null;
		try {
			res = acceso.findRecord(codigo);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}*/

	public Vector<Multitabla> findMultitablaxValor2(String valor2) {
		Vector<Multitabla> res = null;
		try {
			res = acceso.findMultitablaxValor2(valor2);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Oficina> findAllOficinaxTe(String cod_area,
			String cod_territorio) {
		Vector<Oficina> res = null;
		try {
			res = acceso.findAllOficinaxTe(cod_area,
					cod_territorio);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public PermisoPerfil findComponente(String codReg, String codCat,
			String path) {
		PermisoPerfil res = null;
		try {
			res = acceso.findComponente(codReg, codCat, path);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Territorio> findAllTerritorio(String cod_area) {
		Vector<Territorio> res = null;
		try {
			res = acceso.findAllTerritorio(cod_area);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Total findTotal(String ind_registro, String cod_territorio,
			String cod_oficina, String cod_gestor) {
		Total res = null;
		try {
			res = acceso.findTotal(ind_registro,
					cod_territorio, cod_oficina, cod_gestor);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Multitabla> findAllMultitabla() {
		Vector<Multitabla> res = null;
		try {
			res = acceso.findAllMultitabla();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Perfil> findAllPerfil() {
		Vector<Perfil> res = null;
		try {
			res = acceso.findAllPerfil();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<PermisoPerfil> findAllPermisoPerfil() {
		Vector<PermisoPerfil> res = null;
		try {
			res = acceso.findAllPermisoPerfil();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createMultitabla(Multitabla multitabla) {
		boolean res = false;
		try {
			res = acceso.createMultitabla(multitabla);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createPerfil(Perfil perfil) {
		boolean res = false;
		try {
			res = acceso.createPerfil(perfil);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil) {
		boolean res = false;
		try {
			res = acceso.createPermisoPerfil(permisoPerfil);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createCliente(Cliente cliente) {
		boolean res = false;
		try {
			res = acceso.createCliente(cliente);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createEmpresa(Empresa empresa) {
		boolean res = false;
		try {
			res = acceso.createEmpresa(empresa);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createTotal(Total total) {
		boolean res = false;
		try {
			res = acceso.createTotal(total);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createArea(Area area) {
		boolean res = false;
		try {
			res = acceso.createArea(area);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createTerritorio(Territorio territorio) {
		boolean res = false;
		try {
			res = acceso.createTerritorio(territorio);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createOficina(Oficina oficina) {
		boolean res = false;
		try {
			res = acceso.createOficina(oficina);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean createGestor(Gestor gestor) {
		boolean res = false;
		try {
			res = acceso.createGestor(gestor);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteAllGestor(String cod_area) {
		boolean res = false;
		try {
			res = acceso.deleteAllGestor(cod_area);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}
	
	
 
	
	

	public Perfil findPerfil(String cod_perfil) {
		Perfil res = null;
		try {
			res = acceso.findPerfil(cod_perfil);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public PermisoPerfil findPermisoPerfil(String cod_perfil, int tipo_acceso,
			String valor_rcp) {
		PermisoPerfil res = null;
		try {
			res = acceso.findPermisoPerfil(cod_perfil,
					tipo_acceso, valor_rcp);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	/*public Multitabla findMultitabla(String cod_mult, String cod_ele) {
		Multitabla res = null;
		try {
			res = acceso.findMultitabla(cod_mult, cod_ele);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}*/

	public boolean updateMultitabla(Multitabla multitabla) {
		boolean res = false;
		try {
			res = acceso.updateMultitabla(multitabla);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean updatePerfil(Perfil perfil) {
		boolean res = false;
		try {
			res = acceso.updatePerfil(perfil);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteMultitabla(String cod_mult, String cod_ele) {
		boolean res = false;
		try {
			res = acceso.deleteMultitabla(cod_mult, cod_ele);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Multitabla> listaDetalleFiltroComplejo(String tipo, String tipo2,
			String[] codigos) {
		Vector<Multitabla> res = null;
		try {
			res = acceso.listaDetalleFiltroComplejo(tipo,
					tipo2, codigos);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Multitabla> listaDetalleFiltroSimple(String tipo, String[] codigos) {
		Vector<Multitabla> res = null;
		try {
			res = acceso.listaDetalleFiltroSimple(tipo, codigos);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deletePerfil(String cod_perfil) {
		boolean res = false;
		try {
			res = acceso.deletePerfil(cod_perfil);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deletePermisoPerfil(String cod_perfil, int tipo_acceso,
			String valor_rcp) {
		boolean res = false;
		try {
			res = acceso.deletePermisoPerfil(cod_perfil,
					tipo_acceso, valor_rcp);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteCliente(int cod_cliente) {
		boolean res = false;
		try {
			res = acceso.deleteCliente(cod_cliente);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Empresa> findAllEmpresa() {
		Vector<Empresa> res = null;
		try {
			res = acceso.findAllEmpresa();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public String findPerfilxRegistro(String registro) {
		String res = null;
		try {
			res = acceso.findPerfilxRegistro(registro);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public DataTable findEtiquetasSegmentos(DataTable tablaBase) {
		DataTable res = null;
		try {
			res = acceso.findEtiquetasSegmentos(tablaBase);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public String[] listaEtiquetasPorCodigo(String codigo) {
		String[] res = null;
		try {
			res = acceso.listaEtiquetasPorCodigo(codigo);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Multitabla> findEtiquetas() {
		Vector<Multitabla> res = null;
		try {
			res = acceso.findEtiquetas();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public int findCantidadSegmentos() {
		int res = 0;
		try {
			res = acceso.findCantidadSegmentos();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Gestor> findGestorxRegistro(String registro, String codTerritorio,
			String codOficina) {
		Vector<Gestor> res = null;
		try {
			res = acceso.findGestorxRegistro(registro,
					codTerritorio, codOficina);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Multitabla> findEtiSeg(String codMult, String codElem) {
		Vector<Multitabla> res = null;
		try {
			res = acceso.findEtiSeg(codMult, codElem);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Multitabla> findNV(String codMult, String codElem) {
		Vector<Multitabla> res = null;
		try {
			res = acceso.findNV(codMult, codElem);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Vector<Multitabla> findFamilias() {
		Vector<Multitabla> res = null;
		try {
			res = acceso.findFamilias();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteTotales() {
		boolean res = false;
		try {
			res = acceso.deleteTotales();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteClientes() {
		boolean res = false;
		try {
			res = acceso.deleteClientes();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteGestores() {
		boolean res = false;
		try {
			res = acceso.deleteGestores();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteOficinas() {
		boolean res = false;
		try {
			res = acceso.deleteOficinas();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteTerritorios() {
		boolean res = false;
		try {
			res = acceso.deleteTerritorios();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteAreas() {
		boolean res = false;
		try {
			res = acceso.deleteAreas();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public boolean deleteEmpresas() {
		boolean res = false;
		try {
			res = acceso.deleteEmpresas();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public int countCliente(int tipo) {
		/*int res = 0;
		try {
			res = acceso.countCliente();
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;*/
		return countCliente2("-1", "-1", "-1", tipo);
	}

	private int countCliente2(String cod_territorio, String cod_oficina, String cod_gestor, int tipo) {
		int res = 0;
		java.sql.Connection con = null;
		DataSource datasource = null;
		CallableStatement stmt = null;
		String sql = "begin ? := COUNT_CLIENTE2(?,?,?,?); end;";
		try {
			Context initialContext = new InitialContext();
			if (initialContext == null) {
				return 0;
			}
			datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
	
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				return 0;
			}
			
			try {
				stmt = con.prepareCall(sql);
				logger.info(sql);
				logger.info(cod_territorio);
				logger.info(cod_oficina);
				logger.info(cod_gestor);
				logger.info(tipo);
				
				stmt.registerOutParameter(1, OracleTypes.NUMBER);
				stmt.setString(2, cod_territorio);
				stmt.setString(3, cod_oficina);
				stmt.setString(4, cod_gestor);
				stmt.setInt(5, tipo);
				stmt.execute();
				res = stmt.getInt(1);
			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (Throwable e) {logger.error(e.getMessage());}
			try {
				con.close();
			} catch (Throwable e) {logger.error(e.getMessage());}
		}
		
		return res;
	}
	
	public int countClientebyTerritorio(String cod_territorio, int tipo) {
		/*int res = 0;
		try {
			res = acceso.countClientebyTerritorio(
					cod_territorio);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;*/
		return countCliente2(cod_territorio, "-1", "-1", tipo);
	}

	public int countClientebyOficina(String cod_territorio, String cod_oficina, int tipo) {
		/*int res = 0;
		try {
			res = acceso.countClientebyOficina(cod_territorio,
					cod_oficina);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;*/
		return countCliente2(cod_territorio, cod_oficina, "-1", tipo);
	}

	public int countClientebyGestor(String cod_territorio, String cod_oficina, String cod_gestor, int tipo) {
		/*int res = 0;
		try {
			res = acceso.countClientebyGestor(cod_territorio,
					cod_oficina, cod_gestor);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}*/
		return countCliente2(cod_territorio, cod_oficina, cod_gestor, tipo);
	}

	public Territorio datosTerritorio(String codigo) {
		Territorio res = null;
		try {
			res = acceso.datosTerritorio(codigo);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Oficina datosOficina(String codigo) {
		Oficina res = null;
		try {
			res = acceso.datosOficina(codigo);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Gestor datosGestor(String codigo) {
		Gestor res = null;
		try {
			res = acceso.datosGestor(codigo);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public Empresa datosEmpresa(String codigo) {
		Empresa res = null;
		try {
			res = acceso.datosEmpresa(codigo);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	public String findGestorMasaOficina(String cod_oficina) {
		String res = null;
		try {
			res = acceso.findGestorMasaOficina(cod_oficina);
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
		return res;
	}
}
