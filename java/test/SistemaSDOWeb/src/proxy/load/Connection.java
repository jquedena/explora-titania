package proxy.load;

import igrupobbva.pe.sistemasdoweb.util.UtilListas;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.driver.OracleTypes;

import org.apache.log4j.Logger;

import pe.com.bbva.model.dao.ObjetivoDAO;
import pe.com.bbva.model.dao.PerfilDAO;

import com.grupobbva.bc.per.tele.ldap.conexion.Conexion;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeCriterioBusqueda;
import com.grupobbva.bc.per.tele.sdo.serializable.Accion;
import com.grupobbva.bc.per.tele.sdo.serializable.Campanias;
import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Firmas;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.MaestroPlan;
import com.grupobbva.bc.per.tele.sdo.serializable.Menu;
import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
import com.grupobbva.bc.per.tele.sdo.serializable.Parametro;
import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;
import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tele.sdo.serializable.Plan;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
import com.grupobbva.bc.per.tele.sdo.serializable.Seguimiento;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import com.grupobbva.bc.per.tele.sdo.serializable.UsuarioLDAP;
import com.grupobbva.bc.per.tele.sdo.sesionws.SesionWS;
import com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSHome;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

@SuppressWarnings( {"unchecked", "unused"})
public class Connection {

	public final static SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
	
	private static Logger logger = Logger.getLogger(Connection.class.getName());
	private final static Class STATIC_SessionServiceHome_CLASS = SesionWSHome.class;
	private final static String STATIC_SesionWSHome_REF_NAME = "ejb/SesionWS";	
	private final static Class STATIC_SesionWSHome_CLASS = SesionWSHome.class;
	private InitialContext contextoJNDI;
	private SesionWS sesionWS = null;
	private SesionWS aSesionWS = createSesionWS();
	private SesionWSHome sesionWSHome = null;
	private java.sql.Connection connection = null;
	
	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			logger.error("closeConnection", e);
		}
		connection = null;
	}
	
	private java.sql.Connection getConnection() {
		if(connection == null){
			Context initialContext = null;
			DataSource datasource = null;
			try {
				
				initialContext = new InitialContext();
				if (initialContext == null) {
					logger.info("getConnection :: Fin initialContext");
				} else {
					datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
					
					if (datasource != null) {
						connection = datasource.getConnection();
					} else {
						initialContext = null;
						logger.info("getConnection :: Fin datasource");
					}
				}
				
				initialContext.close();
			} catch(Exception e) {
				logger.error("getConnection", e);
			}
		}
		
		return connection;
	}
		
	private SesionWSHome instanciarInterfazHome(InitialContext contexto) {
		SesionWSHome tramitesHome = null;

		try {
			tramitesHome = (SesionWSHome) contexto
					.lookup("ejb/com/grupobbva/bc/per/tele/sdo/sesionws/SesionWSHome");			
		} catch (NamingException e) {

			logger.error("Connection", e);
			System.out
					.println("[Error al instaciarInterfazHome - ConexionEJB ]");
		}
		return tramitesHome;
	}

	/******************************************************************************
	 * REOPRTES 
	 */
	public Vector listaReportePlanificacion() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.listaReportePlanificacion();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector listaReportePPG(String anhoA, String mesA) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.listaReportePPG(anhoA, mesA);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public Vector listaReporteSeguimiento1(String anhoA, String mesA) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.listaReporteSeguimiento1(anhoA, mesA);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector listaReporteSeguimiento2(String anhoA, String mesA) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.listaReporteSeguimiento2(anhoA, mesA);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	/*****************************************************************************
	 * findxCodPerfil : MENU
	 /****************************************************************************/

	/**
	 public Vector findxCodPerfil(String codPerfil) {
	 SesionWS aSessionws = createSesionWS();
	 try {
	 return aSessionws.findxCodPerfil(codPerfil);
	 } catch (RemoteException ex) {
	 // Auto-generated catch block
	 ex.printStackTrace();
	 }
	 return null;
	 }

	 public Vector findAllMenu() {
	 SesionWS aSessionws = createSesionWS();
	 try {
	 return aSessionws.findAllMenu();
	 } catch (RemoteException ex) {
	 // Auto-generated catch block
	 ex.printStackTrace();
	 }
	 return null;
	 }

	 public boolean deleteMenu(String padre) {
	 SesionWS aSessionws = createSesionWS();
	 try {
	 return aSessionws.deleteMenu(padre);
	 } catch (RemoteException ex) {
	 // Auto-generated catch block
	 ex.printStackTrace();
	 }
	 return false;
	 }

	 public Menu findxIdMenu(String padre) {
	 SesionWS aSessionws = createSesionWS();
	 try {
	 return aSessionws.findxIdMenu(padre);
	 } catch (RemoteException ex) {
	 // Auto-generated catch block
	 ex.printStackTrace();
	 }
	 return null;
	 }

	 public boolean updateMenu(Menu menu) {
	 SesionWS aSessionws = createSesionWS();
	 try {
	 return aSessionws.updateMenu(menu);
	 } catch (RemoteException ex) {
	 // Auto-generated catch block
	 ex.printStackTrace();
	 }
	 return false;
	 }
	 */
	/******************************************************************************
	 * findPermisoPerfilxTipAccxValorRCP :: PERMISO PERFIL 
	 /******************************************************************************/

	public PermisoPerfil findPermisoPerfilxTipAccxValorRCP(String codReg,
			String codCat, String path) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.findPermisoPerfilxTipAccxValorRCP(codReg, codCat,
					path);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public Vector findAllPerfil() {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.findAllPerfil();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 public boolean createMenu(Menu menu) {
	 SesionWS aSessionws = createSesionWS();
	 try {
	 return aSessionws.createMenu(menu);
	 } catch (RemoteException ex) {
	 // Auto-generated catch block
	 ex.printStackTrace();
	 }
	 return false;
	 }
	 */

	public Vector findAllPermisoPerfil() {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.findAllPermisoPerfil();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.createPermisoPerfil(permisoPerfil);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return false;

	}

	public boolean deletePermisoPerfil(String codPerfil, String tipoAcceso,
			String valorRCP) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.deletePermisoPerfil(codPerfil, tipoAcceso,
					valorRCP);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return false;

	}

	public PermisoPerfil findPermisoPerfilById(String codPerfil,
			String tipoAcceso, String valorRCP) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.findPermisoPerfilById(codPerfil, tipoAcceso,
					valorRCP);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public boolean updatePermisoPerfil(PermisoPerfil origPermisoPerfil,
			PermisoPerfil nuevoPermisoPerfil) {
		SesionWS aSessionws = createSesionWS();
		try {
			boolean aboolean = aSessionws.updatePermisoPerfil(
					origPermisoPerfil, nuevoPermisoPerfil);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return false;
	}

	/******************************************************************************
	 * findPerfil :: PERFIL 
	 /******************************************************************************/

	public Perfil findPerfil(String cod_perfil) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.findPerfil(cod_perfil);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	// 201206053 - updatePerfil - Modificado
	public boolean updatePerfil(Perfil perfil) {
		PerfilDAO perfilDAO = new PerfilDAO();
		return perfilDAO.actualizarPerfil(perfil);
	}

	public boolean deletePerfil(String codPerfil) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.deletePerfil(codPerfil);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return false;
	}

	// 201206053 - createPerfil - Modificado
	public boolean createPerfil(Perfil perfil) {
		PerfilDAO perfilDAO = new PerfilDAO();
		return perfilDAO.crearPerfil(perfil);
	}

	/******************************************************************************
	 * findAllPerfil :: T. COORPORATIVA 
	 */
	public Vector findByCodMulti(String codMult) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.findByCodMulti(codMult);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector findByMultiForPresup(String codMulti, String Valor2) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findByMultiForPresup(codMulti, Valor2);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean updateCorporativa(Multitabla multitabla) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.updateCorporativa(multitabla);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean updateElemMultiTabla(Multitabla multitabla){
		SesionWS aSessionws =createSesionWS();
		try{
			return aSessionws.updateElemMultitabla(multitabla);
		}catch(RemoteException ex){
			ex.printStackTrace();
		}
		
		return false;
	}

	public Multitabla findByID(String id) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.findByID(id);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Multitabla findMultiByPrimaryKey(String codMulti, String codElem) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findMultiByPrimaryKey(codMulti, codElem);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector findAllOficinaByCodTerri_MOD1(String codTerritorio,
			String anho, String mes) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findAllOficinaByCodTerri_MOD1(codTerritorio, anho,
					mes);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector findAllOficinaByCodTerri_MOD2(String codTerritorio) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findAllOficinaByCodTerri_MOD2(codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public Vector editarTerritoriosDeOficinas(String codOficina,
			String codTerritorio) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.editarTerritoriosDeOficinas(codOficina,
					codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public Vector findAllOficinaByCodTerri(String codTerritorio) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findAllOficinaByCodTerri(codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector findAllOficinas() {
		SesionWS aSesionWS = createSesionWS();
		try {
			Vector aVector = aSesionWS.findAllOficinas();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector findListaByCodOficina(String codOficina) {
		SesionWS aSesionWS = createSesionWS();
		try {
			Vector aVector = aSesionWS.findListaByCodOficina(codOficina);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Oficina findByCodOficina(String codOficina) {
		SesionWS aSesionWS = createSesionWS();
		try {
			Oficina anOficina = aSesionWS.findByCodOficina(codOficina);
			return anOficina;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean findByCodigoOficina(String codOficina) {
		SesionWS aSesionWS = createSesionWS();
		try {
			boolean fExiste = aSesionWS.findByCodigoOficina(codOficina);
			return fExiste;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean findOficinaAndTerri(String codTerri, String codOficina) {
		SesionWS aSesionWS = createSesionWS();
		try {
			boolean fExiste = aSesionWS.findOficinaAndTerri(codTerri,
					codOficina);
			return fExiste;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	// OSCAR CORTEZ
	public Vector busOficinaxTerritorio(String codTerritorio,boolean showAll) {

		SesionWS aSessionws = createSesionWS();
		try {
			Vector aVector = aSessionws.busOficinaxTerritorio(codTerritorio,showAll);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public int nuevaOficina(String codTerritorio, String codOficina,
			String nomOficina, String usuario) {

		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.nuevaOficina(codTerritorio, codOficina,
					nomOficina, usuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return -1;
		}

	}

	public Vector nuevaMetaGestor(String codMetaGestor, String codTerritorio,
			String codOficina, String codEpigrafe, String anho,
			String codGestor, String codigoPerfil, String mes, Double porc_asig,
			String nom_epigrafe, String nom_gestor, String usuario) {

		SesionWS aSessionws = createSesionWS();
		try {
			Vector aVector = aSessionws.nuevaMetaGestor(codMetaGestor,
					codTerritorio, codOficina, codEpigrafe, anho, codGestor, codigoPerfil,
					mes, porc_asig, nom_epigrafe, nom_gestor, usuario);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Vector editarOficina(Oficina oficina) {

		SesionWS aSessionws = createSesionWS();
		try {
			Vector aVector = aSessionws.editarOficina(oficina);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public int eliminarOficina(String codOficina)
    {
        int result = 0;
        SesionWS aSessionws = createSesionWS();
        try
        {
            result = aSessionws.eliminarOficina(codOficina);
        }
        catch (RemoteException ex)
        {
            ex.printStackTrace();

        }
        return result;
    }

	/******************************************************************************
	 * findAllPerfil :: T. Parametro
	 */
	public Vector findAllParametro() {
		SesionWS aSesionWS = createSesionWS();
		try {
			Vector aVector = aSesionWS.findAllParametro();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Parametro findParametroAll() {
		SesionWS aSesionWS = createSesionWS();
		try {
			Parametro aParametro = aSesionWS.findParametroAll();
			return aParametro;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/******************************************************************************
	 * findAllPerfil :: T. Maestro Planes
	 */

	public MaestroPlan findUbicar(String mes, String anho, String codOficina,
			String codTerritorio) {
		SesionWS aSesionWS = createSesionWS();
		try {
			MaestroPlan aMaestroPlan = aSesionWS.findUbicar(mes, anho,
					codOficina, codTerritorio);
			return aMaestroPlan;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean createMaestroPlan(String anho, String mes, String codOfi,
			String codTerr) {
		SesionWS aSesionMaestro = createSesionWS();
		try {
			boolean rptCrea = aSesionMaestro.createMaestrPlan(anho, mes,
					codOfi, codTerr);
			return rptCrea;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean existeDataPlanesMesAnio(String mes, String anio) {
		SesionWS aSesionMaestro = createSesionWS();

		try {
			return aSesionMaestro.existeDataPlanesMesAnio(mes, anio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean existeDataMaestroPlanesMesAnio(String mes, String anio) {
		SesionWS aSesionMaestro = createSesionWS();

		try {
			return aSesionMaestro.existeDataMaestroPlanesMesAnio(mes, anio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/******************************************************************************/
	/** Autor: G. Ureta **/
	/** Metodo: borrarEpigrafe **/
	/** Detalle: Meque Elimina los registros de la tabla Epigrafe **/
	/******************************************************************************/
	public boolean borrarMaestro() {
		SesionWS aSesionMaestro = createSesionWS();
		try {
			boolean rptActualiza = aSesionMaestro.borrarMaestro();
			return rptActualiza;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// 201206053 - findAllEquivalencias Modificar
	public Vector findAllEquivalencias() {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.findAllEquivalencias();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// 201206053 - findEquivalenciaByCodCargo Modificando
	public Equivalencia findEquivalenciaByCodCargo(String codCargo) {
		PerfilDAO perfilDAO = new PerfilDAO();
		return perfilDAO.findEquivalenciaByCodCargo(codCargo);
	}

	// 201206053 - updateEquivalencia Modificar
	public boolean updateEquivalencia(Equivalencia equivalencia) {
		SesionWS aSessionws = createSesionWS();
		try {
			boolean aboolean = aSessionws.updateEquivalencia(equivalencia);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	// 201206053 - createEquivalencia Modificar
	public boolean createEquivalencia(Equivalencia equivalencia) {
		SesionWS aSessionws = createSesionWS();
		try {
			boolean aboolean = aSessionws.createEquivalencia(equivalencia);
			return aboolean;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return false;
	}

	// 201206053 - deleteEquivalencia Modificar
	public boolean deleteEquivalencia(String codCargo) {
		SesionWS aSessionws = createSesionWS();
		try {
			return aSessionws.deleteEquivalencia(codCargo);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return false;
	}

	/******************************************************************************
	 * findAllPerfil :: T. Territorio
	 */

	public Vector busAllTerritorio() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busAllTerritorio();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busAllTerritorioActivo() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busAllTerritorioActivo();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector nuevoTerritorio(String codTerritorio, String nomTerritorio, 
			String mensaje, String colorFondo, String usuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.nuevoTerritorio(codTerritorio, nomTerritorio, 
					mensaje, colorFondo, usuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	public Vector modificarTerritorio(String codTerritorio,
			String nomTerritorio, String estado, String mensaje, 
			String colorFondo, String usuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.modificarTerritorio(codTerritorio, nomTerritorio,
					estado, mensaje, colorFondo, usuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busTerritorioxCod(String codTerritorio) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busTerritorioxCod(codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector eliminarTerritorio(String codTerritorio) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.eliminarTerritorio(codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;

	}

	public Territorio findByCodTerritorio(String codTerritorio) {
		SesionWS aSesionWS = createSesionWS();
		try {
			Territorio aTerritorio = aSesionWS
					.findByCodTerritorio(codTerritorio);
			return aTerritorio;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector findAllTerritorio() {
		SesionWS aSesionWS = createSesionWS();
		try {
			Vector aVector = aSesionWS.findAllTerritorio();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector busTerritorioxRegistroLDAP(String codGestor) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busTerritorioxRegistroLDAP(codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}
	
	/******************************************************************************
	 * findAllPerfil :: T. Planes
	 */
	public Vector findConsultaPlanes(String codTerritorio, String codOficina, String anho, String mes, String presuReferencia) {
		SesionWS aSesionWS = createSesionWS();
		try {
			Vector aVector = aSesionWS.findConsultaPlanes(codTerritorio, codOficina, anho, mes, presuReferencia);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector findConsultarPlanesxMes(String codOficina, String anho) {
		SesionWS aSesionWS = createSesionWS();
		try {
			Vector aVector = aSesionWS
					.findConsultarPlanesxMes(codOficina, anho);
			return aVector;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public Plan findConsultaPlanesResumen(String mes, String anho,
			String codEpigrafe, String codOficina) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findConsultaPlanesResumen(mes, anho, codEpigrafe,
					codOficina);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findPlanAnual(String anho, String codOficina) {

		SesionWS aSesionWS = createSesionWS();
		try {
			Vector aVector = aSesionWS.findPlanAnual(anho, codOficina);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/******************************************************************************
	 * findAllPerfil :: T. Epigrafe
	 */
	public Vector findEpiByAnho(String anho) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findEpiByAnho(anho);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findEpigrafeInf(String anho) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findEpigrafeInf(anho);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Epigrafe findByCodEpigAnho(String codEpigrafe, String anho) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findByCodEpigAnho(codEpigrafe, anho);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean createEpigrafe(Epigrafe epigrafe) {
		SesionWS aSesionEpigrafe = createSesionWS();
		try {
			boolean rptCrea = aSesionEpigrafe.createEpigrafe(epigrafe);
			return rptCrea;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/******************************************************************************/
	/** Autor: G. Ureta **/
	/** Metodo: borrarEpigrafe **/
	/** Detalle: Meque Elimina los registros de la tabla Epigrafe **/
	/******************************************************************************/
	public boolean borrarEpigrafe() {
		SesionWS aSesionEpigrafe = createSesionWS();
		try {
			boolean rptActualiza = aSesionEpigrafe.borrarEpigrafe();
			return rptActualiza;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/******************************************************************************
	 * findAllPerfil :: T. Mtas Gestor
	 */
	public MetasGestor findGestorByCodigo(String codGestor){
		SesionWS aSesionWS =createSesionWS();
		try{
			return aSesionWS.findGestorByCodigo(codGestor);
		}catch(RemoteException ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public MetasGestor findGestorByCodMonthYear(String anho, String mes, String codOficina, String codGestor){
		SesionWS aSesionWS =createSesionWS();
		try{
			return aSesionWS.findGestorByCodMonthYear(anho, mes, codOficina, codGestor);
		}catch(RemoteException ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public MetasGestor findMetGestorByPrimaryKey(String codEpigrafe,
			String anho, String codOficina, String mes, String codGestor) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findMetGestorByPrimaryKey(codEpigrafe, anho,
					codOficina, mes, codGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean createMetasGestor(MetasGestor metasGestor) {
		ObjetivoDAO dao = new ObjetivoDAO();
		String[] result = dao.registrar(metasGestor);
		if(result[1].length() > 0 && result[1].equalsIgnoreCase("-")) logger.error(result[0] + "-" + result[1]);
		return (result[0] != null && result[0].length() > 0);
		
		/*SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.createMetasGestor(metasGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}*/
	}

	public boolean updateMetasGestor(MetasGestor metasGestor) {
		return createMetasGestor(metasGestor);
		/*SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.updateMetasGestor(metasGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}*/
	}

	/******************************************************************************
	 * findAllPerfil :: T. Mtas Gestor
	 */

	public Firmas findFirmByAnoMesCgesItem(String anho, String mes,
			String codGestor, String item) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findFirmByAnoMesCgesItem(anho, mes, codGestor,
					item);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/******************************************************************************
	 * findAllPerfil :: T. Utils
	 */

	public String getCorrelativo(String nomTabla, String nomCampo, String tamano) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.getCorrelativo(nomTabla, nomCampo, tamano);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector consultarPLanesAccion(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.consultarPLanesAccion(codigoOficina, mes, anho,
					codigoGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector consultarCampaniasDetalles(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.consultarCampaniasDetalles(codigoOficina, mes,
					anho, codigoGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector consultarPlanesAccionesPPG(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.consultarPlanesAccionesPPG(codigoOficina, mes,
					anho, codigoGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/******************************************************************************/
	/** Autor: G. Ureta **/
	/** Metodo: updatePlanes **/
	/** Detalle: Meque actualiza los registros de la tabla Planes **/
	/******************************************************************************/
	public boolean updatePlan(Plan plan) {
		SesionWS aSesionPlanes = createSesionWS();
		try {
			boolean rptActualiza = aSesionPlanes.updatePlan(plan);
			return rptActualiza;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/******************************************************************************/
	/** Autor: G. Ureta **/
	/** Metodo: borrarPlanIngresado **/
	/** Detalle: Meque actualiza los registros de la tabla Planes **/
	/******************************************************************************/
	public boolean borrarPlanIngresado(String usuario) {
		SesionWS aSesionPlanes = createSesionWS();
		try {
			boolean rptActualiza = aSesionPlanes.borrarPlanIngresado(usuario);
			return rptActualiza;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean createPlan(Plan plan) {
		SesionWS aSesionPlanes = createSesionWS();
		try {
			boolean rptCrea = aSesionPlanes.createPlan(plan);
			return rptCrea;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean createUpdatePlan(Plan plan) {
		SesionWS aSesionPlanes = createSesionWS();
		
		try {
			boolean rptCrea = aSesionPlanes.createUpdatePlan(plan);
			return rptCrea;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Vector consultarCampaniasDetallesPGG(String codigoOficina,
			String mes, String anho, String codigoGestor) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.consultarCampaniasDetallesPGG(codigoOficina, mes,
					anho, codigoGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/******************************************************************************


	 /**END****************************************************************************/



	protected SesionWS createSesionWS() {
		SesionWSHome aSesionWSHome = (SesionWSHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionWSHome_REF_NAME,
						STATIC_SesionWSHome_CLASS);
		try {
			if (aSesionWSHome != null)
				return aSesionWSHome.create();
		} catch (javax.ejb.CreateException e) {
			// Auto-generated catch block
			logger.error("Connection", e);
		} catch (RemoteException e) {
			// Auto-generated catch block
			logger.error("Connection", e);
		}
		return null;
	}

	/**
	 * CODIGO GENERADO POR OSCAR
	 * @author Stefanini
	 *
	 * To change the template for this generated type comment go to
	 * Window - Preferences - Java - Code Style - Code Templates
	 */
	/******************************************************************************
	 * ACCIONES 
	 */
	public Vector busAllAnho() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busAllAnho();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector busAnhosAcciones() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busAnhosAcciones();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector busAnhoMaxAcciones() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busAnhoMaxAcciones();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector busAccionesPGG3(String codAnho, String codMes,
			String codGestor, String codEpigrafe) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busAccionesPGG3(codAnho, codMes, codGestor,
					codEpigrafe);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector nuevaAccion(String cod_acci, String cod_epigrafe,
			String anho, String cod_terr, String cod_ofic, String nom_acci,
			String cod_gest, String mes_acci, String nro_clie,
			String comp_gest, String nro_gest_segu_1, String nro_conc_segu_1,
			String mon_segu_1, String nro_gest_segu_2, String nro_conc_segu_2,
			String mon_segu_2, String usuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.nuevaAccion(cod_acci, cod_epigrafe, anho,
					cod_terr, cod_ofic, nom_acci, cod_gest, mes_acci, nro_clie,
					comp_gest, nro_gest_segu_1, nro_conc_segu_1, mon_segu_1,
					nro_gest_segu_2, nro_conc_segu_2, mon_segu_2, usuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return null;
	}

	public int codigoAccion() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.codigoAccion();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return 0;
	}

	public Vector eliminarAccion(String codAccion) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.eliminarAccion(codAccion);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector codOficinaMax(String codTerritorio) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.codOficinaMax(codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	/******************************************************************************
	 * REPORTE PGO RESUMEN 
	 */
	public Vector reportePGOResumen(String codTerritorio, Hashtable hash) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.reportePGOResumen(codTerritorio, hash);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Hashtable reportePGOResumen2(String codTerritorio, String mes,
			String anho) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.reportePGOResumen2(codTerritorio, mes, anho);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector reportePGO1(String codAnho, String codMes, String codOficina) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.reportePGO1(codAnho, codMes, codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector reportePGOEsfuerzos(String codAnho, String codMes,
			String codOficina) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.reportePGOEsfuerzos(codAnho, codMes, codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector busOficinaCodyNom(String codTerritorio) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busOficinaCodyNom(codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	/******************************************************************************
	 * REPORTE PGG RESUMEN 
	 */
	public Vector busAllAnhos() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busAllAnhos();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector busGestorxOficina(String codOficina) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busGestorxOficina(codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector busEpigrafeAcciones2(String codGestor, String anho,
			String mes, String codOficina) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busEpigrafeAcciones2(codGestor, anho, mes,
					codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	/******************************************************************************
	 * CAMPAï¿œAS
	 */
	public Vector nuevaCampania(int codCamp, String nomCamp,
			String codOficicina, String codTerritorio, String codGestor,
			String anho, String mes, String orden, String get, String usuario, String codEpigrafe) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.nuevaCampania(codCamp, nomCamp, codOficicina,
					codTerritorio, codGestor, anho, mes, orden, get, usuario, codEpigrafe);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector mostrarEsfuerzoCampania(String codGest, String mes,
			String anho, String codOficina) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.mostrarEsfuerzoCampania(codGest, mes, anho,
					codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public int codigoCampMax() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.codigoCampMax();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return 0;
	}

	public Vector eliminarCampania(String codCamp) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.eliminarCampania(codCamp);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector mostrarEditarCampania(String codCamp) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.mostrarEditarCampania(codCamp);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector editarCampania(String anho, String mes, String nomCamp,
			String orden, String codCamp, String usuario, String codEpigrafe) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.editarCampania(anho, mes, nomCamp, orden, codCamp, usuario, codEpigrafe);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public int metasOficina(String codOficina, int anio, int mes,
			String codEpigrafe) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.metasOficina(codOficina, anio, mes, codEpigrafe);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return 0;
	}

	public int metasGestor(String codGestor, int anio, int mes,
			String codEpigrafe) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.metasGestor(codGestor, anio, mes, codEpigrafe);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return 0;
	}

	/******************************************************************************
	 * INGRESOS 
	 */

	public int nuevoIngreso(String id_ingresos, String codUsuario,
			String cargo, String nomTerritorio, String codOficina, String nombres) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.nuevoIngreso(id_ingresos, codUsuario, cargo,
					nomTerritorio, codOficina, nombres);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return 0;
	}

	public Vector busIngresoxDIA(String codTerritorioUsuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			Vector resultIngreso = null;
			resultIngreso = aSesionWS.busIngresoxDIA(codTerritorioUsuario);
			return resultIngreso;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public int busID_IngresoMax() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busID_IngresoMax();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return 0;
	}

	public Vector busIngresoxUSUARIOxMes(String mes, String codTerritorioUsuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busIngresoxUSUARIOxMes(mes, codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector busIngresoxUSUARIOxAnho(String anho, String codTerritorioUsuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busIngresoxUSUARIOxAnho(anho, codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector busIngresoxOFICINAxMes(String mes, String codOficina, String codTerritorioUsuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busIngresoxOFICINAxMes(mes, codOficina, codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector busIngresoxOFICINAxAnho(String anho, String codOficina, String codTerritorioUsuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busIngresoxOFICINAxAnho(anho, codOficina, codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		
		return null;
	}

	public Vector busIngresoxTERRITORIOxMes(String mes, String nomTerritorio, String codTerritorioUsuario) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.busIngresoxTERRITORIOxMes(mes, nomTerritorio, codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		
		return null;
	}

	public Vector busIngresoxTERRITORIOxAnho(String anho, String nomTerritorio, String codTerritorioUsuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busIngresoxTERRITORIOxAnho(anho, nomTerritorio, codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	/******************************************************************************
	 * MENU 
	 /***************************************************************************
	 */
	public Vector findxCodPerfil(String codPerfil) {

		SesionWS aSessionService = createSesionWS();
		try {
			return aSessionService.findxCodPerfil(codPerfil);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return null;

	}

	public Vector findAllMenu() {

		SesionWS aSessionService = createSesionWS();
		try {
			return aSessionService.findAllMenu();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return null;
	}

	public boolean createMenu(Menu menu) {
		SesionWS aSessionService = createSesionWS();
		try {
			return aSessionService.createMenu(menu);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return false;
	}

	public boolean deleteMenu(java.math.BigDecimal padre) {
		SesionWS aSessionService = createSesionWS();
		try {
			return aSessionService.deleteMenu(padre.toString());
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return false;
	}

	public Menu findxIdMenu(java.math.BigDecimal padre) {
		SesionWS aSessionService = createSesionWS();
		try {
			return aSessionService.findxIdMenu(padre.toString());
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return null;
	}

	public boolean updateMenu(Menu menu) {
		SesionWS aSessionService = createSesionWS();
		try {
			return aSessionService.updateMenu(menu);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return false;
	}

	public Vector findAllOficinaConMetas(String codTerritorio, String mes,
			String anio) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.findAllOficinaConMetas(codTerritorio, mes, anio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
			return null;
		}
	}

	public Vector pggSeguimiento1(String mes, String anho, String codOficina,
			String codGestor) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.pggSeguimiento1(mes, anho, codOficina, codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}
	
	public Vector pggSeguimiento1(String mes, String anho, String codOficina,
			String codGestor, ProgSeguimiento progSeguimiento) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.pggSeguimiento1(mes, anho, codOficina, codGestor, progSeguimiento);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}

		return null;
	}
	
	public ProgSeguimiento findProgramacionSeguimiento(String mes, String anio, String codTerritorio) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.findProgramacionSeguimiento(mes, anio, codTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}

		return null;
	}


	public Vector pggEsfuerzoAdicional1(String mes, String anho,
			String codOficina, String codGestor, ProgSeguimiento progSeguimiento) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.pggEsfuerzoAdicional1(mes, anho, codOficina,
					codGestor, progSeguimiento);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}
	
	public Vector pggEsfuerzoAdicional1(String mes, String anho,
			String codOficina, String codGestor) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.pggEsfuerzoAdicional1(mes, anho, codOficina,
					codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector pggSeguimiento2(String mes, String anho, String codOficina,
			String codGestor, ProgSeguimiento progSeguimiento) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.pggSeguimiento2(mes, anho, codOficina, codGestor, progSeguimiento);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}
	
	public Vector pggSeguimiento2(String mes, String anho, String codOficina,
			String codGestor) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.pggSeguimiento2(mes, anho, codOficina, codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector pggEsfuerzoAdicional2(String mes, String anho,
			String codOficina, String codGestor) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.pggEsfuerzoAdicional2(mes, anho, codOficina,
					codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}
	
	public Vector pggEsfuerzoAdicional2(String mes, String anho,
			String codOficina, String codGestor, ProgSeguimiento progSeguimiento) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.pggEsfuerzoAdicional2(mes, anho, codOficina,
					codGestor, progSeguimiento);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public boolean actualizarSeguimiento1(String tipoSeguimiento,
			String numDato, String codigo1, String codigo2, String valor, 
			String usuario) {
		SesionWS aSesionWS = createSesionWS();

		try {
			boolean aboolean = aSesionWS.actualizarSeguimiento1(
					tipoSeguimiento, numDato, codigo1, codigo2, valor, usuario);
			return aboolean;
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
			return false;
		}
	}

	public boolean actualizarSeguimiento2(String tipoSeguimiento,
			String numDato, String codigo1, String codigo2, String valor,
			String usuario) {
		SesionWS aSesionWS = createSesionWS();

		try {
			boolean aboolean = aSesionWS.actualizarSeguimiento2(
					tipoSeguimiento, numDato, codigo1, codigo2, valor, usuario);
			return aboolean;
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
			return false;
		}
	}

	public int actualizarPorcentajeEpigrafe(Epigrafe datos) {
		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.actualizarPorcentajeEpigrafe(datos);
		} catch (RemoteException ex) {
			//		 Auto-generated catch block
			logger.error("Connection", ex);
		}
		return 0;
	}

	public Vector findEpigrafesinPlanes(String codOficina, String anho,
			String mes) {
		SesionWS aSesionWS = createSesionWS();

		try {
			return aSesionWS.findEpigrafesinPlanes(codOficina, anho, mes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public boolean nuevoCampaniaDetalle(String codTerritorio,
			String codOficina, String codCampania, String mes, String anho,
			String nomCampania, String codGest, int nroClie, double compGest,
			String usuario) {

		SesionWS aSesionWS = createSesionWS();

		try {
			return aSesionWS.nuevoCampaniaDetalle(codTerritorio, codOficina,
					codCampania, mes, anho, nomCampania, codGest, nroClie,
					compGest, usuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return false;
	}

	public boolean edicionCampaniaDetalle(String codCampaniaDetalle,
			String nomCampania, int nroClie, double compGest, String usuario) {
		SesionWS aSesionWS = createSesionWS();

		try {
			return aSesionWS.edicionCampaniaDetalle(codCampaniaDetalle,
					nomCampania, nroClie, compGest, usuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return false;
	}

	public Vector listaCampaniaDetalle(String codTerritorio, String codOficina,
			String codCamp, String mes, String anho) {
		SesionWS aSesionWS = createSesionWS();

		try {
			return aSesionWS.listaCampaniaDetalle(codTerritorio, codOficina,
					codCamp, mes, anho);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public boolean eliminarCampaniaDetalle(String codCamp) {
		SesionWS aSesionWS = createSesionWS();

		try {
			return aSesionWS.eliminarCampaniaDetalle(codCamp);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return false;
	}

	public Territorio findTerritorioByCodOficina(String codOficina) {
		SesionWS aSesionWS = createSesionWS();

		try {
			return aSesionWS.findTerritorioByCodOficina(codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Vector reportePGOResumenxAnioMes(String codTerritorio, String mes,
			String anio) {
		SesionWS aSesionWS = createSesionWS();

		try {
			return aSesionWS
					.reportePGOResumenxAnioMes(codTerritorio, mes, anio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public boolean edicionAccion(String codAccion, String descAccion,
			String numeroCliente, String compromisoGestor, String usuario) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.edicionAccion(codAccion, descAccion,
					numeroCliente, compromisoGestor, usuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return false;
	}

	public Accion busAccion(String codAccion) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.busAccion(codAccion);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return null;
	}

	public Vector busGestorxOficinaxAnioxMes(String codOficina, String mes,
			String anio) {
		SesionWS aSesionWS = createSesionWS();

		try {
			return aSesionWS.busGestorxOficinaxAnioxMes(codOficina, mes, anio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public Campanias busCampaniaDetalle(String codCampaniaDetalle) {
		SesionWS aSesionWS = createSesionWS();

		try {
			return aSesionWS.busCampaniaDetalle(codCampaniaDetalle);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}
	
	public String xDameTerritorio(String codigoOficina) {

		String osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xDameTerritorio(codigoOficina);
				} else {
					System.out.println("Error [ConexionEJB]  : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB] : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	public int xInsertarTAcciones(String codigoAccion, String nomberAccion,
			String codigoGestor, String mes, String anho, int nroClientes,
			int compromisoGestor, int nroGestorSeguimiento1,
			int nroConcSeguimiento1, int montoSeguimiento1,
			int nroGestorSeguimiento2, int nroConcSeguimiento2,
			int montoSeguimiento2, String codigoOficina, String codigoEpigrafe,
			Date fechaSeg1, Date fechaSeg2, Date fechaGrabacion,
			String codTerritorio) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTAcciones(codigoAccion, nomberAccion,
							codigoGestor, mes, anho, nroClientes,
							compromisoGestor, nroGestorSeguimiento1,
							nroConcSeguimiento1, montoSeguimiento1,
							nroGestorSeguimiento2, nroConcSeguimiento2,
							montoSeguimiento2, codigoOficina, codigoEpigrafe,
							fechaSeg1, fechaSeg2, fechaGrabacion,
							codTerritorio);
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	public Vector xBusAllTablaAccionesAntiguo(String mes, String anho) {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaAccionesAntiguo(mes, anho);
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	public Vector xBusAllTablaEpigrafesAntiguo() {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaEpigrafesAntiguo();
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	public int xInsertarTEpigrafes(String codigoepigrafe,
			String nombreepigrafe, String anho, String indicadorclase,
			String indicadorsubclase, String orden, String indicadorgrupo,
			String abreviatura, String indicadorhijo, String indicadorafecta) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTEpigrafes(codigoepigrafe,
							nombreepigrafe, anho, indicadorclase,
							indicadorsubclase, orden, indicadorgrupo,
							abreviatura, indicadorhijo, indicadorafecta);
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}
	
	public Vector xBusAllTablaTerritorioAntiguo() {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaTerritorioAntiguo();
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}
	
	public int xInsertarTTerritorio(String codigoTerritorio,
			String nombreTerritorio) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTTerritorio(codigoTerritorio, nombreTerritorio);
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error");
		}

		return osc;
	}

	public Vector xBusAllTablaOficinaAntiguo() {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaOficinaAntiguo();
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error");
		}

		return osc;
	}
	
	public int xInsertarTOficina(String codigoTerritorio, String nombreOficina,
			String codigoOficina) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTOficina(codigoTerritorio, nombreOficina, codigoOficina);
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}
	
	public Vector xBusAllTablaCampanhasAntiguo(String anho) {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaCampanhasAntiguo(anho);
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}
	
	public int xInsertarTCampanhas(String codigoCampania, String anho,
			String mes, String nombreCampania, String codigoOficina,
			String codigoGestor, String orden, String gte, Date fechaGrabacion,
			String codigoTerritorio) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTCampanhas(codigoCampania, anho,
							mes, nombreCampania, codigoOficina,
							codigoGestor, orden, gte, fechaGrabacion,
							codigoTerritorio);
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}
	
	public Vector xBusAllTablaCampanhasDetalleAntiguo() {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaCampanhasDetalleAntiguo();
				} else {
					System.out.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	public int xInsertarTCampanhasDetalle(String codigoCampanhaDetalle,
			String nombreCampanha, String codigoGestor, String mes,
			String anho, int nroClientes, int compromisoGestor,
			int nroGestorSeguimiento1, int nroConcSeguimiento1,
			int montoSeguimiento1, int nroGestorSeguimiento2,
			int nroConcSeguimiento2, int montoSeguimiento2,
			String codigoOficina, String codigoCampanha, Date fechaGrabacion,
			Date fechaSeg1, Date fechaSeg2, String codigoTerritorio) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTCampanhasDetalle(codigoCampanhaDetalle,
							nombreCampanha, codigoGestor, mes,
							anho, nroClientes, compromisoGestor,
							nroGestorSeguimiento1, nroConcSeguimiento1,
							montoSeguimiento1, nroGestorSeguimiento2,
							nroConcSeguimiento2, montoSeguimiento2,
							codigoOficina, codigoCampanha, fechaGrabacion,
							fechaSeg1, fechaSeg2, codigoTerritorio);
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}
	
	public Vector xBusAllTablaEquivalencias() {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaEquivalencias();
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}
	
	public int xInsertarTEquivalencias(String codigoCargo, String codigoPerfil) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTEquivalencias(codigoCargo, codigoPerfil);
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	/*public Vector xBusAllTablaPerfiles() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xBusAllTablaPerfiles();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return null;
	}*/
	
	public Vector xBusAllTablaPerfiles() {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaPerfiles();
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}
	
	public int xInsertarTPerfiles(String codigoPerfil, String nombrePerfil) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTPerfiles(codigoPerfil, nombrePerfil);
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	public Vector xBusAllTablaFirmas() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xBusAllTablaFirmas();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return null;
	}

	public int xInsertarTFirmas(String anho, String mes, String item,
			String codigoGestor, String codigoOficina, String descripcion,
			Date fecha) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xInsertarTFirmas(anho, mes, item, codigoGestor,
					codigoOficina, descripcion, fecha);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return 0;
	}

	/*public Vector xBusAllTablaMaestroPlanes(String contadorMes) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xBusAllTablaMaestroPlanes(contadorMes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}*/
	public Vector xBusAllTablaMaestroPlanes(String contadorMes) {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaMaestroPlanes(contadorMes);
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	/*public int xInsertarTMaestroPlanes(String codigoOficina, String mes,
			String anho, String codigoTerritorio, String prioridad,
			Date fechaGrabacion) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xInsertarTMaestroPlanes(codigoOficina, mes, anho,
					codigoTerritorio, prioridad, fechaGrabacion);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return 0;
	}*/
	public int xInsertarTMaestroPlanes(String codigoOficina, String mes,
			String anho, String codigoTerritorio, String prioridad,
			Date fechaGrabacion) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTMaestroPlanes(codigoOficina, mes,
							anho, codigoTerritorio, prioridad,
							fechaGrabacion);
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	/*public Vector xBusAllTablaMetasGestor(String contadorMes) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xBusAllTablaMetasGestor(contadorMes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}*/
	public Vector xBusAllTablaMetasGestor(String contadorMes) {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaMetasGestor(contadorMes);
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

/*	public int xInsertarTMetasGestor(String codigoMetaGestor,
			String codigoEpigrafe, String codigoOficina, String codigoGestor,
			String anho, String mes, String orden, Date fechaGrabacion,
			String porcAsignado, String nombreEpigrafe, String nombreGestor,
			String codigoTerritorio) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xInsertarTMetasGestor(codigoMetaGestor,
					codigoEpigrafe, codigoOficina, codigoGestor, anho, mes,
					orden, fechaGrabacion, porcAsignado, nombreEpigrafe,
					nombreGestor, codigoTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return 0;
	}*/
	
	public int xInsertarTMetasGestor(String codigoMetaGestor,
			String codigoEpigrafe, String codigoOficina, String codigoGestor,
			String anho, String mes, String orden, Date fechaGrabacion,
			String porcAsignado, String nombreEpigrafe, String nombreGestor,
			String codigoTerritorio) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTMetasGestor(codigoMetaGestor,
							codigoEpigrafe, codigoOficina, codigoGestor,
							anho, mes, orden, fechaGrabacion,
							porcAsignado, nombreEpigrafe, nombreGestor,
							codigoTerritorio);
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	public Vector xBusAllTablaParametros() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xBusAllTablaParametros();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return null;
	}

	public int xInsertarTParametros(Date fechaAccion, Date fechaSeguimiento1,
			Date fechaSeguimiento2, String afectaAccion,
			String afectaSeguimiento, String afectaPlanificacion,
			Date fechaPlanificacion) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xInsertarTParametros(fechaAccion,
					fechaSeguimiento1, fechaSeguimiento2, afectaAccion,
					afectaSeguimiento, afectaPlanificacion, fechaPlanificacion);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return 0;
	}

/*	public Vector xBusAllTablaPlanes(String mes) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xBusAllTablaPlanes(mes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return null;
	}*/
	public Vector xBusAllTablaPlanes(String mes, String anho) {

		Vector osc=null;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xBusAllTablaPlanes(mes, anho);
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}

	/*public int xInsertarTPlanes(String codigoOficina, String mes, String anho,
			String codigoEpigrafe, String nombreEpigrafe, int pesodor,
			int monto, int porcAlcanzado, int desvpPto, int nroMesesFalt,
			int proyCrecMensual, int ajusteEstimadoTerr, int proyAjusteMensual,
			int saldoMedioJunio, int porcSaldoMedioJunio,
			int saldoDiciembreAnterior, int saldoMedioDiciembre,
			String codigoTerritorio, int porcSaldoMedioDiciembre,
			int factorAjusteSaldoPuntual, int historicoBajas,
			int metaMesSaldoPuntual, int metaGerenteOficina, int prioridad,
			String mesEvaluacion, String indicadorDor, int varMes,
			int ajustePspto, int desvPsptoAjustado, int factAjustTerritorial,
			int factAsignGteOf) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.xInsertarTPlanes(codigoOficina, mes, anho,
					codigoEpigrafe, nombreEpigrafe, pesodor, monto,
					porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
					ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
					porcSaldoMedioJunio, saldoDiciembreAnterior,
					saldoMedioDiciembre, codigoTerritorio,
					porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
					historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
					prioridad, mesEvaluacion, indicadorDor, varMes,
					ajustePspto, desvPsptoAjustado, factAjustTerritorial,
					factAsignGteOf);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}

		return 0;
	}*/
	
	public int xInsertarTPlanes(String codigoOficina, String mes, String anho,
			String codigoEpigrafe, String nombreEpigrafe, int pesodor,
			int monto, int porcAlcanzado, int desvpPto, int nroMesesFalt,
			int proyCrecMensual, int ajusteEstimadoTerr, int proyAjusteMensual,
			int saldoMedioJunio, int porcSaldoMedioJunio,
			int saldoDiciembreAnterior, int saldoMedioDiciembre,
			String codigoTerritorio, int porcSaldoMedioDiciembre,
			int factorAjusteSaldoPuntual, int historicoBajas,
			int metaMesSaldoPuntual, int metaGerenteOficina, int prioridad,
			String mesEvaluacion, String indicadorDor, int varMes,
			int ajustePspto, int desvPsptoAjustado, int factAjustTerritorial,
			int factAsignGteOf) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor,
							monto, porcAlcanzado, desvpPto, nroMesesFalt,
							proyCrecMensual, ajusteEstimadoTerr, proyAjusteMensual,
							saldoMedioJunio, porcSaldoMedioJunio,
							saldoDiciembreAnterior, saldoMedioDiciembre,
							codigoTerritorio, porcSaldoMedioDiciembre,
							factorAjusteSaldoPuntual, historicoBajas,
							metaMesSaldoPuntual, metaGerenteOficina, prioridad,
							mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB]   : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB]   : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error   ");
		}

		return osc;
	}
	/*public int actualizarEstadoFlag(String  flag) {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.actualizarEstadoFlag(flag);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		return 0;
	}*/
	public int actualizarEstadoFlag(String flag) {

		int osc=0;
		
		try {
			contextoJNDI = new InitialContext(System.getProperties());
			sesionWSHome = instanciarInterfazHome(contextoJNDI);

			if (sesionWSHome != null) {
				sesionWS = sesionWSHome.create();
				if (sesionWS != null) {
					osc = sesionWS.actualizarEstadoFlag(flag);
					//res = true;
				} else {
					System.out
							.println("Error [ConexionEJB] : sesionSesionGeneral null ");
				}
			} else {
				System.out
						.println("Error [ConexionEJB] : sesionSesionGeneralHome null ");
			}
		} catch (Exception e) {
			logger.error("Connection", e);
			System.err.println("Error");
		}

		return osc;
	}

	/*public String buscarEstadoFlag() {

		SesionWS aSesionWS = createSesionWS();
		try {
			return aSesionWS.buscarEstadoFlag();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}		
		return null;
	}*/
	public String buscarEstadoFlag() {
	String osc=null;
	
	try {
		contextoJNDI = new InitialContext(System.getProperties());
		sesionWSHome = instanciarInterfazHome(contextoJNDI);

		if (sesionWSHome != null) {
			sesionWS = sesionWSHome.create();
			if (sesionWS != null) {
				osc = sesionWS.buscarEstadoFlag();
				//res = true;
			} else {
				System.out
						.println("Error [ConexionEJB] : sesionSesionGeneral null ");
			}
		} else {
			System.out
					.println("Error [ConexionEJB] : sesionSesionGeneralHome null ");
		}
	} catch (Exception e) {
		logger.error("Connection", e);
		System.err.println("Error");
	}

	return osc;
	}
	
	public int obtenerPrimerMesPresup() {
		SesionWS aSesionWS = createSesionWS();
		int valor = 99;
		
		try {
			return aSesionWS.obtenerPrimerMesPresup();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			logger.error("Connection", ex);
		}
		
		return valor;
	}
	
	public Vector buscarUsuariosLDAP(String codOficina, String codEmpresa, int limiteOcurrencias){
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.buscarUsuariosLDAP(codOficina, codEmpresa, limiteOcurrencias);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}

		return null;
	}
	
	public ProgSeguimiento findProgTerritorio(ProgSeguimiento progTerritorio) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.findProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}

		return null;
	}
	
	public Vector findTodosProgTerritorio(ProgSeguimiento progTerritorio) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.findTodosProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}

		return null;
	}
	
	public boolean crearProgTerritorio(ProgSeguimiento progTerritorio) {	
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.crearProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return false;
	}
	
	public boolean actualizarProgTerritorio(ProgSeguimiento progTerritorio) {	
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.actualizarProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return false;
	}
	
	public boolean eliminarProgTerritorio(ProgSeguimiento progTerritorio) {	
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.eliminarProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return false;
	}
	
	public void actualizarIngreso(int tipo, int idIngreso, String mes, String anio) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			aSesionWS.actualizarIngreso(tipo, idIngreso, mes, anio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return;
	}
	
	public Vector busIngresoxUsuario(String anho, String mes, String dia, String codTerritorioUsuario) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.busIngresoxUsuario(anho, mes, dia, codTerritorioUsuario);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return null; 
	}	
	
	public Vector busIngresoxOficina(String anho, String mes, String dia, String codTerritorioUsuario) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.busIngresoxOficina(anho, mes, dia, codTerritorioUsuario);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return null; 
	}	
	
	public Vector busIngresoxTerritorio(String anho, String mes, String dia, String codTerritorioUsuario) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.busIngresoxTerritorio(anho, mes, dia, codTerritorioUsuario);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return null; 
	}
	
	public boolean insertUpdateMesesReferencia(int mes, int anio, int sel_mes) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.insertUpdateMesesReferencia(mes, anio, sel_mes);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return false; 
	}
	
	public int findMesesReferencia(int mes, int anio) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.findMesesReferencia(mes, anio);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return -1; 
	}
	
	public String testearBD() {
		SesionWS aSesionWS = null;			  
		

		try {
			aSesionWS = createSesionWS();	
			
			return aSesionWS.testearBD();
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;
	}
	
	public OficinaHija findOficinaHija(OficinaHija oficinaHija) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.findOficinaHija(oficinaHija);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return null; 
	}
	
	public boolean crearOficinaHija(OficinaHija oficinaHija) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.crearOficinaHija(oficinaHija);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return false; 
	}
	
	public boolean actualizarOficinaHija(OficinaHija oficinaHija) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.actualizarOficinaHija(oficinaHija);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return false; 
	}
	
	public boolean eliminarOficinaHija(OficinaHija oficinaHija) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.eliminarOficinaHija(oficinaHija);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return false; 
	}
	
	public Vector findTodosOficinaHija() {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.findTodosOficinaHija();
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return null; 
	}
	
	public Vector findHijas(String codOficinaPadre)  {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.findHijas(codOficinaPadre);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return null; 
	}
	
	public Vector distribuirGOF(Vector listaGestoresLDAP, String codEpigrafe, String anho,
			String codOficina, String mes)  {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.distribuirGOF(listaGestoresLDAP, codEpigrafe, anho,
					codOficina, mes);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return new Vector(0, 1); 
	}
	
	public void actualizarMetaGestoresPlanes(Vector listaEpigrafe, String anho,
			String codOficina, String mes, String codGestorGOF, String usuario) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			aSesionWS.actualizarMetaGestoresPlanes(listaEpigrafe, anho,
					codOficina, mes, codGestorGOF, usuario);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return; 
	}
	
	public HashMap buscarResumenMontos(Vector listaEpigrafe, String codTerritorio, String codOficina, String anho,
			String mes) { 
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.buscarResumenMontos(listaEpigrafe, codTerritorio, codOficina, anho,
					mes);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return null; 
	}
	
	public BigDecimal buscarMontoGestor(String codGestor, String codEpigrafe, String anho,
			String codOficina, String mes) {
		SesionWS aSesionWS = createSesionWS();			  
		
		try {
			return aSesionWS.buscarMontoGestor(codGestor, codEpigrafe, anho,
					codOficina, mes);
		} catch (RemoteException ex) {			
			logger.error("Connection", ex);
		}
		
		return null; 
	}
	
	public Oficina findByCodOficinaHija(String codOficina) {
		SesionWS aSesionWS = createSesionWS();
		try {
			Oficina anOficina = aSesionWS.findByCodOficinaHija(codOficina);
			return anOficina;
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;
	}
	
	public void actualizarGestoresEliminadosLDAP(Vector listaGestoresLDAP, String codEpigrafe, String anho,
			String codOficina, String mes, String usuario) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			aSesionWS.actualizarGestoresEliminadosLDAP(listaGestoresLDAP, codEpigrafe, anho,
					codOficina, mes, usuario);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return;		
	}
	
	public void actualizarGestoresDistribuidosLDAP(String codEpigrafe, String anho,
			String codOficina, String mes, String usuario) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			aSesionWS.actualizarGestoresDistribuidosLDAP(codEpigrafe, anho,
					codOficina, mes, usuario);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return;
	}
	
	public void actualizarCargoGestoresLDAP(Vector listaGestoresLDAP, String codEpigrafe, String anho,
			String codOficina, String mes, String usuario) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			aSesionWS.actualizarCargoGestoresLDAP(listaGestoresLDAP, codEpigrafe, anho,
					codOficina, mes, usuario);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return;		
	}
	
	public void editarMensajeTerritorio(String codTerritorio, String mensaje, String colorFondo) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			aSesionWS.editarMensajeTerritorio(codTerritorio, mensaje, colorFondo);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return;		
	}
	

	public void eliminarMetaGestoresHijas(Vector listaGestores) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			aSesionWS.eliminarMetaGestoresHijas(listaGestores);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return;		
	}
	
	public Vector reportexUsuario(int dia, int mes, int anio, String codTerritorio) {		
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.reportexUsuario(dia, mes, anio, codTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;		
	}
	
	public Vector reportexOficina(int dia, int mes, int anio, String codTerritorio) {		
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.reportexOficina(dia, mes, anio, codTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;		
	}
	
	public Vector reportexTerritorio(int dia, int mes, int anio, String codTerritorio) {		
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.reportexTerritorio(dia, mes, anio, codTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;		
	}
	
	public Vector reportexUsuarioxAnio(int anio, String codTerritorio) { 		
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.reportexUsuarioxAnio(anio, codTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;		
	}
	
	public ArrayList listarDiasMesesxAnio(int anio) {		
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.listarDiasMesesxAnio(anio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;		
	}
	
	public Vector reportexOficinaxAnio(int anio, String codTerritorio) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.reportexOficinaxAnio(anio, codTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;
	}

	public Vector reportexTerritorioxAnio(int anio, String codTerritorio) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.reportexTerritorioxAnio(anio, codTerritorio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;
	}
	
	public void insertarIngresoForm(int tipo, int mes, int anio, 
			String codUsuario, String editUsuario, String codGestor, String codOficina) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			aSesionWS.insertarIngresoForm(tipo, mes, anio, 
					codUsuario, editUsuario, codGestor, codOficina);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return ;
	}
	
	public void actualizarIngresoFormEditUsuario(long id) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			aSesionWS.actualizarIngresoFormEditUsuario(id);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return;
	}
	
	public long existeIngresoForm(int tipo, int mes, int anio, String codUsuario, String fecha, String codGestorM, String codOficinaM) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.existeIngresoForm(tipo, mes, anio, codUsuario, fecha, codGestorM, codOficinaM);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return 0;
	}
	
	public Vector exportarTablasTXT(int tabla, int mes, int anio) {
		SesionWS aSesionWS = createSesionWS();
		
		try {
			return aSesionWS.exportarTablasTXT(tabla, mes, anio);
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		
		return null;
	}
	
	public int registrarPermisoPerfil(PermisoPerfil permisoPerfil) {
		int result=0;
		try {
			result= createSesionWS().registrarPermisoPerfil(permisoPerfil);
		} catch (Exception e) {
			logger.error("Connection", e);
		}
		
		return result;
	}
	
	public int listadoIngresoxDia(String diaActual, String codTerritorio) {
		SesionWS aSesionWS = null;
		int result = 0;
		
		try {
			aSesionWS = createSesionWS();
			result = aSesionWS.listadoIngresoxDia(diaActual, codTerritorio);
		} catch (Exception e) {
			logger.error("Connection", e);
		}
		
		return result;
	}
	

	
	/** Begin: Modificado por Juan Quedena */
	public Map<String, Integer> findCantidadPersonal(String anho, String mes, String codOfi, String codTerr) {
		Map<String, Integer> aVector = new HashMap<String, Integer>();

		Vector vistaGestores = new Vector();
		String condicion = "GOF";
		// Connection con = new Connection();

		try {
			logger.info("Contando los perfiles");
						
			UsuarioLDAP usuarioEncontrado;
			Gestor gestor;
			Equivalencia equivalencia;
			Oficina oficina;
			int conteo;
			IILDPeCriterioBusqueda cb;
			UtilListas util = new UtilListas();
			List<String[]> listaOficina = this.listaCodigoOficina(codOfi, codTerr);
			int ix;
			String cod_oficina;
			
			for(ix = 0;  ix < listaOficina.size(); ix++) {
				cod_oficina = listaOficina.get(ix)[1];
				logger.info("Extrayendo Gestores de la oficina :" + cod_oficina);
				cb = new IILDPeCriterioBusqueda();
				cb.setCodigoOficina(cod_oficina);
				cb.setCodigoEmpresa(util.getOficinaBanco());
				cb.setLimiteOcurrencias(5);
				Vector vectorGestores = this.buscarUsuariosLDAP(cod_oficina, util.getOficinaBanco(), 100);
				
				condicion = "GOF";
				
				if (vectorGestores != null) {
					for (int j = 0; j < 5; j++) {
						switch (j) {
						case 1:
							condicion = "GPE";
							break;
						case 2:
							condicion = "GCO";
							break;
						case 3:
							condicion = "GPT";
							break;
						case 4:
							condicion = "EEM";
							break;
						}
						
						for (int i = 0; i < vectorGestores.size(); i++) {
							usuarioEncontrado = (UsuarioLDAP) vectorGestores.elementAt(i);
							gestor = new Gestor();
							gestor.setCodigoGestor(usuarioEncontrado.getUID());
							gestor.setNombreGestor(usuarioEncontrado.getNombreCompleto());
							equivalencia = this.findEquivalenciaByCodCargo(usuarioEncontrado.getCodigoCargo());

							if (equivalencia != null) {
								if (equivalencia.getCodPerfil() != null) {
									if (equivalencia.getCodPerfil().equals(condicion)) {
										
										// 201206053 - Contando Perfiles por oficina
										if(!aVector.containsKey(condicion)){
											aVector.put(condicion, 0);
										}
										
										gestor.setCodigoPerfil(equivalencia.getCodPerfil());
										oficina = this.findByCodOficina(usuarioEncontrado.getCodigoOficina());
										
										if(oficina != null){
											if(oficina.getCodOfic()!=null){
												gestor.setCodigoTerritorio(oficina.getTerr().getCodTerr());
												gestor.setCodigoOficina(oficina.getCodOfic());
												
												conteo = aVector.get(condicion).intValue();
												conteo++;
												aVector.put(condicion, conteo);
											}else{ // Verificar si es una oficina hija
												oficina = this.findByCodOficina(listaOficina.get(ix)[0]);
												if(oficina.getCodOfic()!=null){
													gestor.setCodigoTerritorio(oficina.getTerr().getCodTerr());
													gestor.setCodigoOficina(oficina.getCodOfic());
													
													conteo = aVector.get(condicion).intValue();
													conteo++;
													aVector.put(condicion, conteo);
												}else {
													logger.info("No se puede ubicar la Oficina Hija : "+ usuarioEncontrado.getCodigoOficina());
													logger.info("No se puede ubicar la Oficina Primaria : "+ listaOficina.get(ix)[0]);
												}
											}
										}
										
										vistaGestores.add(gestor);
									}
								}
							}
						}
					}
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			ConstantesUtil.mostrarMensajeExcepcion(e);
			aVector = null;
		}		

		return aVector;
	}
	
	public BigDecimal promedioMensual(String anho, String mes, String codOfi, String codTerr, String codEpi, String codGestor) {
		SesionWS aSesionWS = createSesionWS();
		try {
			BigDecimal avg = aSesionWS.promedioMensual(anho, mes, codOfi, codTerr, codEpi, codGestor);
			return avg;
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		return null;
	}
	
	public Vector<Seguimiento> consultaSeguimientoAccionEsfuerzo(String codOfi, String mes, String anho, String codGestor) {
		SesionWS aSesionWS = createSesionWS();
		try {
			 Vector<Seguimiento> seguimiento = aSesionWS.consultaSeguimientoAccionEsfuerzo(codOfi, mes, anho, codGestor);
			return seguimiento;
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		return null;
	}
	
	public Vector<Seguimiento> consultaSeguimientoAccionEsfuerzoPGO(String codOfi, String mes, String anho) {
		SesionWS aSesionWS = createSesionWS();
		try {
			 Vector<Seguimiento> seguimiento = aSesionWS.consultaSeguimientoAccionEsfuerzoPGO(codOfi, mes, anho);
			return seguimiento;
		} catch (RemoteException ex) {
			logger.error("Connection", ex);
		}
		return null;
	}
	
	public HashMap getListaMeses(int year){
		HashMap mapaDatos = null;
		Vector datos = null;
		Context initialContext = null;
		DataSource datasource = null;
		java.sql.Connection con = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				logger.info("[SesionPlanesBean :: findPlanAnual] Fin initialContext");
				return null;
			}
			
			datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				logger.info("[SesionPlanesBean :: getListaMeses] Fin datasource");
				return null;
			}
			
			String sql = " select m.mes, m.sel_mes " +
						 " from IIDO.TIIDO_MESES_REFERENCIA m "+
						 " where m.anio = " + String.valueOf(year) +
						 " order by m.mes ";			
			logger.info("query: " + sql);

			s = con.createStatement();
			rst = s.executeQuery(sql);
			mapaDatos = new HashMap();
			
			while (rst.next()) {			
				mapaDatos.put(rst.getString("mes"), rst.getString("sel_mes"));
			}
		
		} catch (SQLException e) {
			logger.error("[SesionPlanesBean :: getListaMeses] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			logger.error("[SesionPlanesBean :: getListaMeses] ");
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
				logger.error("[SesionPlanesBean :: getListaMeses] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}
		
		return mapaDatos;
	}
	
	public Vector<Avance> avance(String year, String mes, String codTerritorio, String codOficina, String codGestor){
		Vector<Avance> datos = null;
		Context initialContext = null;
		DataSource datasource = null;
		java.sql.Connection con = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				logger.info("[Connection :: avance] Fin initialContext");
				return null;
			}
			
			datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				logger.info("[Connection :: avance] Fin datasource");
				return null;
			}
			
			String sql = " select * from iido.viido_avance where " 
				+ " anho=" + year		
				+ " and mes_acci='" + mes + "'"
				+ " and cod_terr like '" + codTerritorio + "'"
				+ " and cod_ofic like '" + codOficina + "'"
				+ " and cod_gest like '" + codGestor + "'"
				+ " order by cod_terr, cod_ofic, cod_gest";
			logger.info("query: " + sql);

			s = con.createStatement();
			rst = s.executeQuery(sql);
			datos = new Vector<Avance>();
			Avance row; 
			
			while (rst.next()) {
				row = new Avance();
				row.setCodEpigrafe(rst.getString("codepigrafe"));
				row.setNomEpigrafe(rst.getString("nomepigrafe"));
				row.setCodOfic(rst.getString("cod_ofic"));
				row.setNomOfic(rst.getString("nom_ofic"));
				row.setCodTerr(rst.getString("cod_terr"));
				row.setNomTerr(rst.getString("nom_terr"));
				row.setMes(rst.getString("mes_acci"));
				row.setAnho(rst.getString("anho"));
				row.setPrioridad(rst.getString("prioridad"));
				row.setMetGerOfi(rst.getBigDecimal("met_ger_ofi"));
				row.setCodGest(rst.getString("cod_gest"));
				row.setNomGestor(rst.getString("nom_gestor"));
				row.setTotalMIS(rst.getBigDecimal("total"));
				row.setMonSegu1(rst.getBigDecimal("mon_segu_1"));
				row.setMonSegu2(rst.getBigDecimal("mon_segu_2"));
				row.setPorcentajeMin(rst.getBigDecimal("porcentaje_min"));
				row.setPorcentajeMax(rst.getBigDecimal("porcentaje_max"));
				
				datos.add(row);
			}
		
		} catch (SQLException e) {
			logger.error("[Connection :: avance]");
			logger.error(e);
		} catch (Exception e) {
			logger.error("[Connection :: avance]");
			logger.error(e);
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
				logger.error("[Connection :: avance]");
				logger.error(e);
				
				return null;
			}
		}
		
		return datos;
	}
	
	public int validaPeriodo(String periodo){
		Context initialContext = null;
		DataSource datasource = null;
		java.sql.Connection cnn = null;
		CallableStatement stm = null;
		int result = -1;
		try {
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				logger.info("[Connection :: validaPeriodo] Fin initialContext");
				return -1;
			}
			
			datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			
			if (datasource != null) {
				cnn = datasource.getConnection();
			} else {
				initialContext = null;
				logger.info("[Connection :: validaPeriodo] Fin datasource");
				return -1;
			}
			
			String sql = "{call iido.pkg_carga_datos.sp_valida_carga_periodo(?, ?, ?)}";			
			logger.info("query: " + sql);

			if(periodo != null) {
				stm = cnn.prepareCall(sql);
				stm.setString("periodo", periodo);
				stm.registerOutParameter("exitCode", Types.INTEGER);
				stm.registerOutParameter("errMsg", Types.VARCHAR);
				stm.execute();
			} else {
				logger.error("El año es nulo...!");
			}
			
			result = stm.getInt("exitCode");
			logger.info("[Connection :: validaPeriodo] " + stm.getString("errMsg"));
			
		} catch (SQLException e) {
			logger.error("[Connection :: validaPeriodo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			logger.error("[Connection :: validaPeriodo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
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
				logger.error("[Connection :: validaPeriodo] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return -1;
			}
		}
		
		return result;
	}

	public static final String IMAGEN_PRINCIPAL = "1";
	public static final String IMAGEN_PREVIA = "2";
	
	public int actualizaImagen(String nombre, String tipo){
		Context initialContext = null;
		DataSource datasource = null;
		java.sql.Connection cnn = null;
		Statement stm = null;
		int result = -1;
		try {
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				logger.info("Fin initialContext");
				return -1;
			}
			
			datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			
			if (datasource != null) {
				cnn = datasource.getConnection();
			} else {
				initialContext = null;
				logger.info("Fin datasource");
				return -1;
			}
			
			String sql = "UPDATE iido.tiido_multitabla SET valor1='" + nombre + "' WHERE cod_mult='T18' and cod_elem='" + tipo + "'";			
			logger.info("query: " + sql);

			stm = cnn.createStatement();
			stm.execute(sql);
			result = 1;
			
		} catch (SQLException e) {
			logger.error("actualizaImagen: error");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			logger.error("actualizaImagen: error");
			ConstantesUtil.mostrarMensajeExcepcion(e);
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
				logger.error("actualizaImagen: error");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return -1;
			}
		}
		
		return result;
	}
	
	public String nombreImagen(String tipo){
		Context initialContext = null;
		DataSource datasource = null;
		java.sql.Connection cnn = null;
		Statement stm = null;
		String result = "";
		try {
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				logger.info("Fin initialContext");
				return "";
			}
			
			datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			
			if (datasource != null) {
				cnn = datasource.getConnection();
			} else {
				initialContext = null;
				logger.info("Fin datasource");
				return "";
			}
			
			String sql = "SELECT valor1 FROM iido.tiido_multitabla WHERE cod_mult='T18' and cod_elem='" + tipo + "'";			
			logger.info("query: " + sql);

			stm = cnn.createStatement();
			ResultSet rst = stm.executeQuery(sql);
			
			if(rst.next()) {
				result = rst.getString("valor1");
			}
			
		} catch (SQLException e) {
			logger.error("nombreImagen: error");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			logger.error("nombreImagen: error");
			ConstantesUtil.mostrarMensajeExcepcion(e);
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
				logger.error("nombreImagen: error");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return "";
			}
		}
		
		return result;
	}
	
	public List<String[]> listaCodigoOficina(String codOficina, String codTerritorio){
		Context initialContext = null;
		DataSource datasource = null;
		java.sql.Connection cnn = null;
		Statement stm = null;
		List<String[]> result = new ArrayList<String[]>();
		String[] row = null;
		try {
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				logger.info("Fin initialContext");
				return result;
			}
			
			datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			
			if (datasource != null) {
				cnn = datasource.getConnection();
			} else {
				initialContext = null;
				logger.info("Fin datasource");
				return result;
			}
			
			String sql = "select cod_ofic, cod_ofic id_primaria from iido.tiido_oficina where cod_terr='" + codTerritorio + "' and cod_ofic like '" + codOficina + "'";
			sql += " union all select oficina_hija_id cod_ofic, oficina_id id_primaria from iido.tiido_oficina_hija where oficina_id in (select cod_ofic from iido.tiido_oficina where cod_terr='" + codTerritorio + "' and cod_ofic like '" + codOficina + "')";
			logger.info("query: " + sql);

			stm = cnn.createStatement();
			ResultSet rst = stm.executeQuery(sql);
			
			while(rst.next()) {
				row = new String[2];
				row[0] = rst.getString("id_primaria");
				row[1] = rst.getString("cod_ofic");
				result.add(row);
			}
			
		} catch (SQLException e) {
			logger.error("listaCodigoOficina: error");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			logger.error("listaCodigoOficina: error");
			ConstantesUtil.mostrarMensajeExcepcion(e);
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
				logger.error("listaCodigoOficina: error");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return result;
			}
		}
		
		return result;
	}
	
	/** End: Modificado por Juan Quedena */
}	