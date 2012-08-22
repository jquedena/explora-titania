package com.grupobbva.bc.per.tele.sdo.sesionws;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.Accion;
import com.grupobbva.bc.per.tele.sdo.serializable.Campanias;
import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Firmas;
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
import com.grupobbva.bc.per.tele.sdo.sesion.SesionAcciones;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionCampanias;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalle;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionEpigrafe;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionEpigrafeHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalencias;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionFirmas;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionFirmasHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresos;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanes;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionMenu;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestor;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionMultitabla;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionMultitablaHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionOficina;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionParametros;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionParametrosHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfiles;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfil;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanes;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimiento;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorio;
import com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioHome;
import com.grupobbva.bc.per.tele.sdo.sesion.SessionUtil;
import com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilHome;
import com.ibm.etools.service.locator.ServiceLocatorManager;

/**
 * Bean implementation class for Enterprise Bean: SesionWS
 */
@SuppressWarnings({ "unchecked", "serial" })
public class SesionWSBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_SesionMenuHome_REF_NAME = "ejb/SesionMenu";
	private final static Class STATIC_SesionMenuHome_CLASS = SesionMenuHome.class;
	private final static String STATIC_SesionPerfilesHome_REF_NAME = "ejb/SesionPerfiles";
	private final static Class STATIC_SesionPerfilesHome_CLASS = SesionPerfilesHome.class;
	private final static String STATIC_SesionPermisoPerfilHome_REF_NAME = "ejb/SesionPermisoPerfil";
	private final static Class STATIC_SesionPermisoPerfilHome_CLASS = SesionPermisoPerfilHome.class;
	private final static String STATIC_SesionMultitablaHome_REF_NAME = "ejb/SesionMultitabla";
	private final static Class STATIC_SesionMultitablaHome_CLASS = SesionMultitablaHome.class;
	private final static String STATIC_SesionOficinaHome_REF_NAME = "ejb/SesionOficina";
	private final static Class STATIC_SesionOficinaHome_CLASS = SesionOficinaHome.class;
	private final static String STATIC_SesionParametrosHome_REF_NAME = "ejb/SesionParametros";
	private final static Class STATIC_SesionParametrosHome_CLASS = SesionParametrosHome.class;
	private final static String STATIC_SesionPlanesHome_REF_NAME = "ejb/SesionPlanes";
	private final static Class STATIC_SesionPlanesHome_CLASS = SesionPlanesHome.class;
	private final static String STATIC_SesionMaestroPlanesHome_REF_NAME = "ejb/SesionMaestroPlanes";
	private final static Class STATIC_SesionMaestroPlanesHome_CLASS = SesionMaestroPlanesHome.class;
	private final static String STATIC_SesionEquivalenciasHome_REF_NAME = "ejb/SesionEquivalencias";
	private final static Class STATIC_SesionEquivalenciasHome_CLASS = SesionEquivalenciasHome.class;
	private final static String STATIC_SesionTerritorioHome_REF_NAME = "ejb/SesionTerritorio";
	private final static Class STATIC_SesionTerritorioHome_CLASS = SesionTerritorioHome.class;
	private final static String STATIC_SesionEpigrafeHome_REF_NAME = "ejb/SesionEpigrafe";
	private final static Class STATIC_SesionEpigrafeHome_CLASS = SesionEpigrafeHome.class;
	private final static String STATIC_SesionMetasGestorHome_REF_NAME = "ejb/SesionMetasGestor";
	private final static Class STATIC_SesionMetasGestorHome_CLASS = SesionMetasGestorHome.class;
	private final static String STATIC_SessionUtilHome_REF_NAME = "ejb/SessionUtil";
	private final static Class STATIC_SessionUtilHome_CLASS = SessionUtilHome.class;
	private final static String STATIC_SesionFirmasHome_REF_NAME = "ejb/SesionFirmas";
	private final static Class STATIC_SesionFirmasHome_CLASS = SesionFirmasHome.class;
	private final static String STATIC_SesionAccionesHome_REF_NAME = "ejb/SesionAcciones";
	private final static Class STATIC_SesionAccionesHome_CLASS = SesionAccionesHome.class;
	private final static String STATIC_SesionCampaniasHome_REF_NAME = "ejb/SesionCampanias";
	private final static Class STATIC_SesionCampaniasHome_CLASS = SesionCampaniasHome.class;
	private final static String STATIC_SesionCampaniasDetalleHome_REF_NAME = "ejb/SesionCampaniasDetalle";
	private final static Class STATIC_SesionCampaniasDetalleHome_CLASS = SesionCampaniasDetalleHome.class;
	private final static String STATIC_SesionIngresosHome_REF_NAME = "ejb/SesionIngresos";
	private final static Class STATIC_SesionIngresosHome_CLASS = SesionIngresosHome.class;
	private final static String STATIC_SesionProgSeguimientoHome_REF_NAME = "ejb/SesionProgSeguimiento";
	private final static Class STATIC_SesionProgSeguimientoHome_CLASS = SesionProgSeguimientoHome.class;

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

	/***************************************************************************
	 * findxCodPerfil :: T. MENU
	 */
	public Vector findxCodPerfil(String codPerfil) {
		SesionMenu aSesionMenu = createSesionMenu();
		try {
			Vector aVector = aSesionMenu.findxCodPerfil(codPerfil);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findAllMenu() {
		SesionMenu aSesionMenu = createSesionMenu();
		try {
			Vector aVector = aSesionMenu.findAllMenu();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean createMenu(Menu menu) {
		SesionMenu aSesionMenu = createSesionMenu();
		try {
			boolean aboolean = aSesionMenu.createMenu(menu);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteMenu(String padre) {
		SesionMenu aSesionMenu = createSesionMenu();
		try {
			boolean aboolean = aSesionMenu.deleteMenu(padre);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Menu findxIdMenu(String padre) {
		SesionMenu aSesionMenu = createSesionMenu();
		try {
			Menu aMenu = aSesionMenu.findxIdMenu(padre);
			return aMenu;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean updateMenu(Menu menu) {
		SesionMenu aSesionMenu = createSesionMenu();
		try {
			boolean aboolean = aSesionMenu.updateMenu(menu);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/***************************************************************************
	 * findPermisoPerfilxTipAccxValorRCP :: T. PERMISO PERFIL
	 */

	public PermisoPerfil findPermisoPerfilxTipAccxValorRCP(String codReg,
			String codCat, String path) {
		SesionPermisoPerfil aSesionPermisoPerfil = createSesionPermisoPerfil();
		try {
			PermisoPerfil aPermisoPerfil = aSesionPermisoPerfil
					.findPermisoPerfilxTipAccxValorRCP(codReg, codCat, path);
			return aPermisoPerfil;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findAllPermisoPerfil() {
		SesionPermisoPerfil aSesionPermisoPerfil = createSesionPermisoPerfil();
		try {
			Vector aVector = aSesionPermisoPerfil.findAllPermisoPerfil();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil) {
		SesionPermisoPerfil aSesionPermisoPerfil = createSesionPermisoPerfil();

		try {
			boolean aboolean = aSesionPermisoPerfil
					.createPermisoPerfil(permisoPerfil);

			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deletePermisoPerfil(String codPerfil, String tipoAcceso,
			String valorRCP) {
		SesionPermisoPerfil aSesionPermisoPerfil = createSesionPermisoPerfil();
		try {
			boolean aboolean = aSesionPermisoPerfil.deletePermisoPerfil(
					codPerfil, tipoAcceso, valorRCP);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public PermisoPerfil findPermisoPerfilById(String codPerfil,
			String tipoAcceso, String valorRCP) {
		SesionPermisoPerfil aSesionPermisoPerfil = createSesionPermisoPerfil();
		try {
			PermisoPerfil aPermisoPerfil = aSesionPermisoPerfil
					.findPermisoPerfilById(codPerfil, tipoAcceso, valorRCP);
			return aPermisoPerfil;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public boolean updatePermisoPerfil(PermisoPerfil origPermisoPerfil,
			PermisoPerfil nuevoPermisoPerfil) {

		SesionPermisoPerfil aSesionPermisoPerfil = createSesionPermisoPerfil();

		try {
			boolean aboolean = aSesionPermisoPerfil.updatePermisoPerfil(
					origPermisoPerfil, nuevoPermisoPerfil);

			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/***************************************************************************
	 * findAllPerfil :: T. PERFIL
	 */

	public Vector findAllPerfil() {
		SesionPerfiles aSesionPerfiles = createSesionPerfiles();
		try {
			Vector aVector = aSesionPerfiles.findAllPerfil();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Perfil findPerfil(String cod_perfil) {
		SesionPerfiles aSesionPerfiles = createSesionPerfiles();
		try {
			Perfil aPerfil = aSesionPerfiles.findPerfil(cod_perfil);
			return aPerfil;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean updatePerfil(Perfil perfil) {
		SesionPerfiles aSesionPerfiles = createSesionPerfiles();
		try {
			boolean aboolean = aSesionPerfiles.updatePerfil(perfil);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deletePerfil(String cod_perfil) {
		SesionPerfiles aSesionPerfiles = createSesionPerfiles();
		try {
			boolean aboolean = aSesionPerfiles.deletePerfil(cod_perfil);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean createPerfil(Perfil perfil) {
		SesionPerfiles aSesionPerfiles = createSesionPerfiles();
		try {
			boolean aboolean = aSesionPerfiles.createPerfil(perfil);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/***************************************************************************
	 * findAllPerfil :: T. MULTITABLA
	 */
	public Vector findByCodMulti(String codMulti) {
		SesionMultitabla aSesionMultitabla = createSesionMultitabla();
		try {
			Vector aVector = aSesionMultitabla.findByCodMulti(codMulti);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findByMultiForPresup(String codMulti, String Valor2) {
		SesionMultitabla aSesionMultitabla = createSesionMultitabla();
		try {
			Vector aVector = aSesionMultitabla.findByMultiForPresup(codMulti,
					Valor2);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean updateCorporativa(Multitabla multitabla) {
		SesionMultitabla aSesionMultitabla = createSesionMultitabla();
		try {
			boolean aboolean = aSesionMultitabla.updateMultitabla(multitabla);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateElemMultitabla(Multitabla multitabla) {
		SesionMultitabla aSesionMultitabla = createSesionMultitabla();
		try {
			boolean aboolean = aSesionMultitabla
					.updateElemMultitabla(multitabla);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Multitabla findByID(String id) {
		SesionMultitabla aSesionMultitabla = createSesionMultitabla();
		try {
			Multitabla aMultitabla = aSesionMultitabla.findByID(id);
			return aMultitabla;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Multitabla findMultiByPrimaryKey(String codMulti, String codElem) {
		SesionMultitabla aSesionMultitabla = createSesionMultitabla();
		try {
			Multitabla aMultitabla = aSesionMultitabla.findMultiByPrimaryKey(
					codMulti, codElem);
			return aMultitabla;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/***************************************************************************
	 * findAllPerfil :: T. OFICINA
	 */

	public Vector findAllOficinaByCodTerri_MOD1(String codTerritorio,
			String anho, String mes) {

		SesionOficina aSesionOficina = createSesionOficina();
		try {
			return aSesionOficina.findAllOficinaByCodTerri_MOD1(codTerritorio,
					anho, mes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector findAllOficinaByCodTerri_MOD2(String codTerritorio) {

		SesionOficina aSesionOficina = createSesionOficina();
		try {
			return aSesionOficina.findAllOficinaByCodTerri_MOD2(codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector editarTerritoriosDeOficinas(String codOficina,
			String codTerritorio) {

		SesionOficina aSesionOficina = createSesionOficina();
		try {
			return aSesionOficina.editarTerritoriosDeOficinas(codOficina,
					codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	/***************************************************************************
	 * findAllPerfil :: T. OFICINA
	 */

	public Oficina findByCodOficina(String codOficina) {
		SesionOficina aSesionOficina = createSesionOficina();
		try {
			Oficina anOficina = aSesionOficina.findByCodOficina(codOficina);
			return anOficina;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean findByCodigoOficina(String codOficina) {
		SesionOficina aSesionOficina = createSesionOficina();
		try {
			boolean fExiste = aSesionOficina.findByCodigoOficina(codOficina);
			return fExiste;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Vector findAllOficinaByCodTerri(String codTerritorio) {
		SesionOficina aSesionOficina = createSesionOficina();
		try {
			Vector aVector = aSesionOficina
					.findAllOficinaByCodTerri(codTerritorio);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean findOficinaAndTerri(String codTerritorio, String codOfi) {
		SesionOficina aSesionOficina = createSesionOficina();
		try {
			boolean fExiste = aSesionOficina.findOficinaAndTerri(codTerritorio,
					codOfi);
			return fExiste;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Vector findListaByCodOficina(String codOficina) {
		SesionOficina aSesionOficina = createSesionOficina();
		try {
			Vector aVector = aSesionOficina.findListaByCodOficina(codOficina);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findAllOficinas() {
		SesionOficina aSesionOficina = createSesionOficina();
		try {
			Vector aVector = aSesionOficina.findAllOficinas();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// OSCAR CORTEZ

	public Vector busOficinaxTerritorio(String codTerritorio) {

		SesionOficina aSesionOficina = createSesionOficina();

		try {
			Vector aVector = aSesionOficina
					.busOficinaxTerritorio(codTerritorio);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Vector busOficinaxTerritorio(String codTerritorio, boolean showAll) {
		SesionOficina aSesionOficina = createSesionOficina();

		try {
			Vector aVector = aSesionOficina
					.busOficinaxTerritorio(codTerritorio, showAll);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector nuevaOficina(String codTerritorio, String codOficina,
			String nomOficina) {

		SesionOficina aSesionOficina = createSesionOficina();
		try {
			Vector aVector = aSesionOficina.nuevaOficina(codTerritorio,
					codOficina, nomOficina);
			return aVector;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
			return null;
		}

	}
	
	public int nuevaOficina(String codTerritorio, String codOficina, 
    		String nomOficina, String usuario) {

		SesionOficina aSesionOficina = createSesionOficina();
	
		try {
			return aSesionOficina.nuevaOficina(codTerritorio, codOficina, 
		    		nomOficina, usuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
			return -1;
		}

	}

	public Vector editarOficina(String codTerritorio, String codOficina,
			String nomOficina) {

		SesionOficina aSesionOficina = createSesionOficina();
		try {
			Vector aVector = aSesionOficina.editarOficina(codTerritorio,
					codOficina, nomOficina);
			return aVector;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

	/*public Vector eliminarOficina(String codOficina) {

		SesionOficina aSesionOficina = createSesionOficina();
		try {
			Vector aVector = aSesionOficina.eliminarOficina(codOficina);
			return aVector;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}*/
	
	public int eliminarOficina(String codOficina) {

		SesionOficina aSesionOficina = createSesionOficina();
		int  result=0;
		try {
			result = aSesionOficina.eliminarOficina(codOficina);			
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();			
		}
		return result;
	}

	/***************************************************************************
	 * findAllPerfil :: T. TERRITORIO
	 */
	public Vector busAllTerritorio() {

		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		try {
			return aSesionTerritorio.busAllTerritorio();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busAllTerritorioActivo() {

		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		try {
			return aSesionTerritorio.busAllTerritorioActivo();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector nuevoTerritorio(String codTerritorio, String nomTerritorio, 
			String mensaje, String colorFondo, String usuario) {
		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		
		try {
			return aSesionTerritorio.nuevoTerritorio(codTerritorio,
					nomTerritorio, mensaje, colorFondo, usuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public Vector modificarTerritorio(String codTerritorio, String nomTerritorio, String estado, 
			String mensaje, String colorFondo, String usuario) {

		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		
		try {
			return aSesionTerritorio.modificarTerritorio(codTerritorio,
					nomTerritorio, estado, mensaje, colorFondo, usuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector busTerritorioxCod(String codTerritorio) {

		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		try {
			return aSesionTerritorio.busTerritorioxCod(codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector eliminarTerritorio(String codTerritorio) {

		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		try {
			return aSesionTerritorio.eliminarTerritorio(codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Territorio findByCodTerritorio(String codTerritorio) {
		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		try {
			Territorio aTerritorio = aSesionTerritorio
					.findByCodTerritorio(codTerritorio);
			return aTerritorio;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findAllTerritorio() {
		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		try {
			Vector aVector = aSesionTerritorio.findAllTerritorio();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/** *************************************************************************** */

	/***************************************************************************
	 * findAllPerfil :: T. PARAMETROS
	 */

	public Vector findAllParametro() {
		SesionParametros aSesionParametros = createSesionParametros();
		try {
			Vector aVector = aSesionParametros.findAllParametro();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Parametro findParametroAll() {
		SesionParametros aSesionParametros = createSesionParametros();
		try {
			Parametro aParametro = aSesionParametros.findParametroAll();
			return aParametro;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/** *************************************************************************** */

	/***************************************************************************
	 * findAllPerfil :: T. MAESTROPLANES
	 */

	public MaestroPlan findUbicar(String mes, String anho, String codOficina,
			String codTerritorio) {
		SesionMaestroPlanes aSesionMaestroPlanes = createSesionMaestroPlanes();
		try {
			MaestroPlan aMaestroPlan = aSesionMaestroPlanes.findUbicar(mes,
					anho, codOficina, codTerritorio);
			return aMaestroPlan;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean createMaestrPlan(String anho, String mes, String codOfi,
			String codTerr) {

		SesionMaestroPlanes aSesionMaestroPlanes = createSesionMaestroPlanes();
		try {
			boolean aboolean = aSesionMaestroPlanes.createMaestroPlan(anho,
					mes, codOfi, codTerr);
			return aboolean;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
			return false;
		}
	}

	/** *************************************************************************** */
	/** Autor: G. Ureta * */
	/** Metodo: borrarMaestro * */
	/** Detalle: Meque Elimina los registros de la tabla Maestro Planes * */
	/** *************************************************************************** */
	public boolean borrarMaestro() {
		SesionMaestroPlanes aSesionMaestroPlanes = createSesionMaestroPlanes();
		try {
			boolean rptActualiza = aSesionMaestroPlanes.borrarMaestro();
			return rptActualiza;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/** *************************************************************************** */

	/***************************************************************************
	 * findAllPerfil :: T. EQUIVALENCIA
	 */

	public Equivalencia findEquivalenciaByCodCargo(String codCargo) {
		SesionEquivalencias aSesionEquivalencias = createSesionEquivalencias();
		try {
			Equivalencia anEquivalencia = aSesionEquivalencias.findEquivalenciaByCodCargo(codCargo);
			return anEquivalencia;
		} catch (RemoteException ex) {
			return null;
		}
	}

	/** *************************************************************************** */
	/** findAllEquivalencia :: T. EQUIVALENCIA * */
	/** Autor: G. Ureta * */

	public Vector findAllEquivalencias() {
		SesionEquivalencias aSesionEquivalencias = createSesionEquivalencias();

		try {
			Vector aVector = aSesionEquivalencias.findAllEquivalencias();
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/** *************************************************************************** */
	/** updateEquivalencia :: T. EQUIVALENCIA * */
	/** Autor: G. Ureta * */

	public boolean updateEquivalencia(Equivalencia equivalencia) {
		SesionEquivalencias aSesionEquivalencias = createSesionEquivalencias();

		try {
			boolean aboolean = aSesionEquivalencias
					.updateEquivalencia(equivalencia);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean createEquivalencia(Equivalencia equivalencia) {
		SesionEquivalencias aSesionEquivalencias = createSesionEquivalencias();

		try {
			boolean aboolean = aSesionEquivalencias
					.createEquivalencia(equivalencia);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteEquivalencia(String cod_cargo) {
		SesionEquivalencias aSesionEquivalencias = createSesionEquivalencias();

		try {
			boolean aboolean = aSesionEquivalencias
					.deleteEquivalencia(cod_cargo);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/** *************************************************************************** */
	/** Autor: G. Ureta * */
	/** Metodo: updatePlanes * */
	/** Detalle: Meque actualiza los registros de la tabla Planes * */
	/** *************************************************************************** */
	public boolean updatePlan(Plan plan) {
		SesionPlanes aSesionPlanes = createSesionPlanes();
		try {
			boolean rptActualiza = aSesionPlanes.updatePlan(plan);
			return rptActualiza;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/** *************************************************************************** */
	/** Autor: G. Ureta * */
	/** Metodo: borrarPlanIngresado * */
	/** Detalle: Meque Elimina los registros de la tabla Planes * */
	/** *************************************************************************** */
	public boolean borrarPlanIngresado(String usuario) {
		SesionPlanes aSesionPlanes = createSesionPlanes();
		try {
			boolean rptActualiza = aSesionPlanes.borrarPlanIngresado(usuario);
			return rptActualiza;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean createPlan(Plan plan) {

		SesionPlanes aSesionPlanes = createSesionPlanes();
		try {
			boolean aboolean = aSesionPlanes.createPlan(plan);
			return aboolean;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
			return false;
		}
	}

	public boolean createUpdatePlan(Plan plan) {

		SesionPlanes aSesionPlanes = createSesionPlanes();
		try {
			boolean aboolean = aSesionPlanes.createUpdatePlan(plan);
			return aboolean;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
			return false;
		}
	}

	/***************************************************************************
	 * findAllPerfil :: T. PLANES
	 */	
	public Vector findConsultaPlanes(String codTerritorio, String codOficina,
			String anho, String mes, String presuReferencia) {
		SesionPlanes aSesionPlanes = createSesionPlanes();
		try {
			Vector aVector = aSesionPlanes.findConsultaPlanes(codTerritorio,
					codOficina, anho, mes, presuReferencia);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findPlanAnual(String anho, String codOficina) {
		SesionPlanes aSesionPlanes = createSesionPlanes();
		try {
			Vector aVector = aSesionPlanes.findPlanAnual(anho, codOficina);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findConsultarPlanesxMes(String codOficina, String anho) {
		SesionPlanes aSesionPlanes = createSesionPlanes();
		try {
			Vector aVector = aSesionPlanes.findConsultarPlanesxMes(codOficina,
					anho);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Plan findConsultaPlanesResumen(String mes, String anho,
			String codEpigrafe, String codOficina) {
		SesionPlanes aSesionPlanes = createSesionPlanes();
		try {
			return aSesionPlanes.findConsultaPlanesResumen(mes, anho,
					codEpigrafe, codOficina);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/** *************************************************************************** */

	/***************************************************************************
	 * findAllPerfil :: T. EPIGRAFE
	 */
	public Vector findEpiByAnho(String anho) {
		SesionEpigrafe aSesionEpigrafe = createSesionEpigrafe();
		try {
			return aSesionEpigrafe.findEpiByAnho(anho);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findEpigrafeInf(String anho) {
		SesionEpigrafe aSesionEpigrafe = createSesionEpigrafe();
		try {
			return aSesionEpigrafe.findEpigrafeInf(anho);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Epigrafe findByCodEpigAnho(String codEpigrafe, String anho) {
		SesionEpigrafe aSesionEpigrafe = createSesionEpigrafe();
		try {
			return aSesionEpigrafe.findByCodEpigAnho(codEpigrafe, anho);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean createEpigrafe(Epigrafe epigrafe) {

		SesionEpigrafe aSesionEpigrafe = createSesionEpigrafe();
		try {
			boolean aboolean = aSesionEpigrafe.createEpigrafe(epigrafe);
			return aboolean;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
			return false;
		}
	}

	/** *************************************************************************** */
	/** Autor: G. Ureta * */
	/** Metodo: borrarPlanIngresado * */
	/** Detalle: Meque Elimina los registros de la tabla Epigrafe * */
	/** *************************************************************************** */
	public boolean borrarEpigrafe() {
		SesionEpigrafe aSesionEpigrafe = createSesionEpigrafe();
		try {
			boolean rptActualiza = aSesionEpigrafe.borrarEpigrafe();
			return rptActualiza;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/** *************************************************************************** */

	/***************************************************************************
	 * findAllPerfil :: T. METAS GESTOR
	 */
	public MetasGestor findMetGestorByPrimaryKey(String codEpigrafe,
			String anho, String codOficina, String mes, String codGestor) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.findMetGestorByPrimaryKey(codEpigrafe,
					anho, codOficina, mes, codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			//ex.printStackTrace();
			return null;
		}
	}

	public MetasGestor findGestorByCodigo(String codGestor) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.findGestorByCodigo(codGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public MetasGestor findGestorByCodMonthYear(String anho, String mes,
			String codOficina, String codGestor) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.findGestorByCodMonthYear(anho, mes,
					codOficina, codGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean createMetasGestor(MetasGestor metasGestor) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.createMetasGestor(metasGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateMetasGestor(MetasGestor metasGestor) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.updateMetasGestor(metasGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Vector nuevaMetaGestor(String codMetaGestor, String codTerritorio,
			String codOficina, String codEpigrafe, String anho,
			String codGestor, String codigoPerfil, String mes, Double porc_asig,
			String nom_epigrafe, String nom_gestor, String usuario) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		
		try {
			Vector aVector = aSesionMetasGestor.nuevaMetaGestor(codMetaGestor,
					codTerritorio, codOficina, codEpigrafe, anho, codGestor, codigoPerfil,
					mes, porc_asig, nom_epigrafe, nom_gestor, usuario);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/***************************************************************************
	 * findAllPerfil :: T. FIRMAS
	 */

	public Firmas findFirmByAnoMesCgesItem(String anho, String mes,
			String codGestor, String item) {
		SesionFirmas aSesionFirmas = createSesionFirmas();
		try {
			return aSesionFirmas.findFirmByAnoMesCgesItem(anho, mes, codGestor,
					item);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/***************************************************************************
	 * findAllPerfil :: T. UTILS
	 */
	public String getCorrelativo(String nomTabla, String nomCampo, String tamano) {
		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.getCorrelativo(nomTabla, nomCampo, tamano);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector consultarPLanesAccion(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.consultarPLanesAccion(codigoOficina, mes, anho,
					codigoGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector consultarCampaniasDetalles(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.consultarCampaniasDetalles(codigoOficina, mes,
					anho, codigoGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector consultarPlanesAccionesPPG(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.consultarPlanesAccionesPPG(codigoOficina, mes,
					anho, codigoGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector findAllOficinaConMetas(String codTerritorio, String mes,
			String anio) {
		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil
					.findAllOficinaConMetas(codTerritorio, mes, anio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Vector consultarCampaniasDetallesPGG(String codigoOficina,
			String mes, String anho, String codigoGestor) {
		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.consultarCampaniasDetallesPGG(codigoOficina,
					mes, anho, codigoGestor);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/** *************************************************************************** */

	protected SesionMenu createSesionMenu() {
		SesionMenuHome aSesionMenuHome = (SesionMenuHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionMenuHome_REF_NAME,
						STATIC_SesionMenuHome_CLASS);
		try {
			if (aSesionMenuHome != null)
				return aSesionMenuHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionPermisoPerfil createSesionPermisoPerfil() {
		SesionPermisoPerfilHome aSesionPermisoPerfilHome = (SesionPermisoPerfilHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionPermisoPerfilHome_REF_NAME,
						STATIC_SesionPermisoPerfilHome_CLASS);
		try {
			if (aSesionPermisoPerfilHome != null)
				return aSesionPermisoPerfilHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionPerfiles createSesionPerfiles() {
		SesionPerfilesHome aSesionPerfilesHome = (SesionPerfilesHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionPerfilesHome_REF_NAME,
						STATIC_SesionPerfilesHome_CLASS);
		try {
			if (aSesionPerfilesHome != null)
				return aSesionPerfilesHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionMultitabla createSesionMultitabla() {
		SesionMultitablaHome aSesionMultitablaHome = (SesionMultitablaHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionMultitablaHome_REF_NAME,
						STATIC_SesionMultitablaHome_CLASS);
		try {
			if (aSesionMultitablaHome != null)
				return aSesionMultitablaHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionOficina createSesionOficina() {
		SesionOficinaHome aSesionOficinaHome = (SesionOficinaHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionOficinaHome_REF_NAME,
						STATIC_SesionOficinaHome_CLASS);
		try {
			if (aSesionOficinaHome != null)
				return aSesionOficinaHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionParametros createSesionParametros() {
		SesionParametrosHome aSesionParametrosHome = (SesionParametrosHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionParametrosHome_REF_NAME,
						STATIC_SesionParametrosHome_CLASS);
		try {
			if (aSesionParametrosHome != null)
				return aSesionParametrosHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionPlanes createSesionPlanes() {
		SesionPlanesHome aSesionPlanesHome = (SesionPlanesHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionPlanesHome_REF_NAME,
						STATIC_SesionPlanesHome_CLASS);
		try {
			if (aSesionPlanesHome != null)
				return aSesionPlanesHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionMaestroPlanes createSesionMaestroPlanes() {
		SesionMaestroPlanesHome aSesionMaestroPlanesHome = (SesionMaestroPlanesHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionMaestroPlanesHome_REF_NAME,
						STATIC_SesionMaestroPlanesHome_CLASS);
		try {
			if (aSesionMaestroPlanesHome != null)
				return aSesionMaestroPlanesHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionEquivalencias createSesionEquivalencias() {
		SesionEquivalenciasHome aSesionEquivalenciasHome = (SesionEquivalenciasHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionEquivalenciasHome_REF_NAME,
						STATIC_SesionEquivalenciasHome_CLASS);
		try {
			if (aSesionEquivalenciasHome != null)
				return aSesionEquivalenciasHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionTerritorio createSesionTerritorio() {
		SesionTerritorioHome aSesionTerritorioHome = (SesionTerritorioHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionTerritorioHome_REF_NAME,
						STATIC_SesionTerritorioHome_CLASS);
		try {
			if (aSesionTerritorioHome != null)
				return aSesionTerritorioHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionEpigrafe createSesionEpigrafe() {
		SesionEpigrafeHome aSesionEpigrafeHome = (SesionEpigrafeHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionEpigrafeHome_REF_NAME,
						STATIC_SesionEpigrafeHome_CLASS);
		try {
			if (aSesionEpigrafeHome != null)
				return aSesionEpigrafeHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionMetasGestor createSesionMetasGestor() {
		SesionMetasGestorHome aSesionMetasGestorHome = (SesionMetasGestorHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionMetasGestorHome_REF_NAME,
						STATIC_SesionMetasGestorHome_CLASS);
		try {
			if (aSesionMetasGestorHome != null)
				return aSesionMetasGestorHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SessionUtil createSessionUtil() {
		SessionUtilHome aSessionUtilHome = (SessionUtilHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SessionUtilHome_REF_NAME,
						STATIC_SessionUtilHome_CLASS);
		try {
			if (aSessionUtilHome != null)
				return aSessionUtilHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionFirmas createSesionFirmas() {
		SesionFirmasHome aSesionFirmasHome = (SesionFirmasHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionFirmasHome_REF_NAME,
						STATIC_SesionFirmasHome_CLASS);
		try {
			if (aSesionFirmasHome != null)
				return aSesionFirmasHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	/**
	 * CODIGO GENERADO POR OSCAR
	 * 
	 * @author Stefanini
	 * 
	 * To change the template for this generated type comment go to Window -
	 * Preferences - Java - Code Style - Code Templates
	 */

	/***************************************************************************
	 * REPORTE PGO
	 */
	public Vector reportePGOResumen(String codTerritorio, Hashtable hash) {

		SesionMaestroPlanes aSesionMaestroPlanes = createSesionMaestroPlanes();
		try {
			return aSesionMaestroPlanes.reportePGOResumen(codTerritorio, hash);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector reportePGOResumenxAnioMes(String codTerritorio, String mes,
			String anio) {
		SesionMaestroPlanes aSesionMaestroPlanes = createSesionMaestroPlanes();

		try {
			return aSesionMaestroPlanes.reportePGOResumenxAnioMes(
					codTerritorio, mes, anio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Hashtable reportePGOResumen2(String codTerritorio, String mes,
			String anho) {

		SesionMaestroPlanes aSesionMaestroPlanes = createSesionMaestroPlanes();
		try {
			return aSesionMaestroPlanes.reportePGOResumen2(codTerritorio, mes,
					anho);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector reportePGO1(String codAnho, String codMes, String codOficina) {

		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.reportePGO1(codAnho, codMes, codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector reportePGOEsfuerzos(String codAnho, String codMes,
			String codOficina) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();

		try {
			return aSesionMetasGestor.reportePGOEsfuerzos(codAnho, codMes,
					codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	/***************************************************************************
	 * A�O ACCION
	 */
	public Vector busAllAnho() {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.busAllAnho();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busAnhosAcciones() {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {
			return aSesionCampanias.busAnhosAcciones();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}

	public Vector busAnhoMaxAcciones() {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {
			return aSesionCampanias.busAnhoMaxAcciones();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busAccionesPGG3(String codAnho, String codMes,
			String codGestor, String codEpigrafe) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.busAccionesPGG3(codAnho, codMes, codGestor,
					codEpigrafe);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector nuevaAccion(String cod_acci, String cod_epigrafe,
			String anho, String cod_terr, String cod_ofic, String nom_acci,
			String cod_gest, String mes_acci, String nro_clie,
			String comp_gest, String nro_gest_segu_1, String nro_conc_segu_1,
			String mon_segu_1, String nro_gest_segu_2, String nro_conc_segu_2,
			String mon_segu_2, String usuario) {

		SesionAcciones aSesionAcciones = createSesionAcciones();

		try {
			return aSesionAcciones.nuevaAccion(cod_acci, cod_epigrafe, anho,
					cod_terr, cod_ofic, nom_acci, cod_gest, mes_acci, nro_clie,
					comp_gest, nro_gest_segu_1, nro_conc_segu_1, mon_segu_1,
					nro_gest_segu_2, nro_conc_segu_2, mon_segu_2, usuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public int codigoAccion() {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.codigoAccion();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return 0;
	}

	public Vector eliminarAccion(String codAccion) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.eliminarAccion(codAccion);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busOficinaCodyNom(String codTerritorio) {

		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.busOficinaCodyNom(codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	/***************************************************************************
	 * REPORTE PGG ACCIONES
	 */

	public Vector busAllAnhos() {

		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.busAllAnhos();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busGestorxOficina(String codOficina) {

		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.busGestorxOficina(codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busEpigrafeAcciones2(String codGestor, String anho,
			String mes, String codOficina) {

		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		try {
			return aSesionMetasGestor.busEpigrafeAcciones2(codGestor, anho,
					mes, codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	/***************************************************************************
	 * CAMPA�AS
	 */
	public Vector nuevaCampania(int codCamp, String nomCamp,
			String codOficicina, String codTerritorio, String codGestor,
			String anho, String mes, String orden, String get, String usuario, String codEpigrafe) {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {
			return aSesionCampanias.nuevaCampania(codCamp, nomCamp,
					codOficicina, codTerritorio, codGestor, anho, mes, orden,
					get, usuario, codEpigrafe);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public Vector mostrarEsfuerzoCampania(String codGest, String mes,
			String anho, String codOficina) {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {
			return aSesionCampanias.mostrarEsfuerzoCampania(codGest, mes, anho,
					codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public int codigoCampMax() {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {

			return aSesionCampanias.codigoCampMax();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public Vector eliminarCampania(String codCamp) {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {
			return aSesionCampanias.eliminarCampania(codCamp);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector mostrarEditarCampania(String codCamp) {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {
			return aSesionCampanias.mostrarEditarCampania(codCamp);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector editarCampania(String anho, String mes, String nomCamp,
			String orden, String codCamp, String usuario, String codEpigrafe) {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {
			return aSesionCampanias.editarCampania(anho, mes, nomCamp, orden,
					codCamp, usuario, codEpigrafe);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public int metasOficina(String codOficina, int anio, int mes,
			String codEpigrafe) {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {
			return aSesionCampanias.metasOficina(codOficina, anio, mes,
					codEpigrafe);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public int metasGestor(String codGestor, int anio, int mes,
			String codEpigrafe) {

		SesionCampanias aSesionCampanias = createSesionCampanias();
		try {
			return aSesionCampanias.metasGestor(codGestor, anio, mes,
					codEpigrafe);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public Vector codOficinaMax(String codTerritorio) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.codOficinaMax(codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	/***************************************************************************
	 * REPORTES
	 */
	public Vector listaReportePlanificacion() {

		SesionCampaniasDetalle aSesionCampaniasDetalle = createSesionCampaniasDetalle();
		try {
			return aSesionCampaniasDetalle.listaReportePlanificacion();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector listaReportePPG(String anho, String mes) {

		SesionCampaniasDetalle aSesionCampaniasDetalle = createSesionCampaniasDetalle();
		try {
			return aSesionCampaniasDetalle.listaReportePPG(anho, mes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector listaReporteSeguimiento1(String anho, String mes) {

		SesionCampaniasDetalle aSesionCampaniasDetalle = createSesionCampaniasDetalle();
		try {
			return aSesionCampaniasDetalle.listaReporteSeguimiento1(anho, mes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector listaReporteSeguimiento2(String anho, String mes) {
		SesionCampaniasDetalle aSesionCampaniasDetalle = createSesionCampaniasDetalle();
		try {
			return aSesionCampaniasDetalle.listaReporteSeguimiento2(anho, mes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	/***************************************************************************
	 * INGRESOS
	 */

	public int nuevoIngreso(String id_ingresos, String codUsuario,
			String cargo, String nomTerritorio, String codOficina,
			String nombres) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.nuevoIngreso(id_ingresos, codUsuario, cargo,
					nomTerritorio, codOficina, nombres);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public Vector busIngresoxDIA(String codTerritorioUsuario) {

		SesionIngresos aSesionIngresos = createSesionIngresos();
		try {
			Vector resultIng = null;
			resultIng = aSesionIngresos.busIngresoxDIA(codTerritorioUsuario);
			return resultIng;
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public int busID_IngresoMax() {

		SesionIngresos aSesionIngresos = createSesionIngresos();
		try {
			return aSesionIngresos.busID_IngresoMax();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public Vector busIngresoxUSUARIOxMes(String mes, String codTerritorioUsuario) {

		SesionIngresos aSesionIngresos = createSesionIngresos();
		try {
			return aSesionIngresos.busIngresoxUSUARIOxMes(mes,
					codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busIngresoxUSUARIOxAnho(String anho,
			String codTerritorioUsuario) {

		SesionIngresos aSesionIngresos = createSesionIngresos();
		try {
			return aSesionIngresos.busIngresoxUSUARIOxAnho(anho,
					codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busIngresoxOFICINAxMes(String mes, String codOficina,
			String codTerritorioUsuario) {

		SesionIngresos aSesionIngresos = createSesionIngresos();
		try {
			return aSesionIngresos.busIngresoxOFICINAxMes(mes, codOficina,
					codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busIngresoxOFICINAxAnho(String anho, String codOficina,
			String codTerritorioUsuario) {

		SesionIngresos aSesionIngresos = createSesionIngresos();
		try {
			return aSesionIngresos.busIngresoxOFICINAxAnho(anho, codOficina,
					codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busIngresoxTERRITORIOxMes(String mes, String nomTerritorio,
			String codTerritorioUsuario) {

		SesionIngresos aSesionIngresos = createSesionIngresos();
		try {
			return aSesionIngresos.busIngresoxTERRITORIOxMes(mes,
					nomTerritorio, codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busIngresoxTERRITORIOxAnho(String anho, String nomTerritorio,
			String codTerritorioUsuario) {

		SesionIngresos aSesionIngresos = createSesionIngresos();
		try {
			return aSesionIngresos.busIngresoxTERRITORIOxAnho(anho,
					nomTerritorio, codTerritorioUsuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	/** ******************************** */

	protected SesionAcciones createSesionAcciones() {
		SesionAccionesHome aSesionAccionesHome = (SesionAccionesHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionAccionesHome_REF_NAME,
						STATIC_SesionAccionesHome_CLASS);
		try {
			if (aSesionAccionesHome != null)
				return aSesionAccionesHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionCampanias createSesionCampanias() {
		SesionCampaniasHome aSesionCampaniasHome = (SesionCampaniasHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionCampaniasHome_REF_NAME,
						STATIC_SesionCampaniasHome_CLASS);
		try {
			if (aSesionCampaniasHome != null)
				return aSesionCampaniasHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionCampaniasDetalle createSesionCampaniasDetalle() {
		SesionCampaniasDetalleHome aSesionCampaniasDetalleHome = (SesionCampaniasDetalleHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionCampaniasDetalleHome_REF_NAME,
						STATIC_SesionCampaniasDetalleHome_CLASS);
		try {
			if (aSesionCampaniasDetalleHome != null)
				return aSesionCampaniasDetalleHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	protected SesionIngresos createSesionIngresos() {
		SesionIngresosHome aSesionIngresosHome = (SesionIngresosHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionIngresosHome_REF_NAME,
						STATIC_SesionIngresosHome_CLASS);
		try {
			if (aSesionIngresosHome != null)
				return aSesionIngresosHome.create();
		} catch (javax.ejb.CreateException ce) {
			// Auto-generated catch block
			ce.printStackTrace();
		} catch (RemoteException re) {
			// Auto-generated catch block
			re.printStackTrace();
		}
		return null;
	}

	public Vector busTerritorioxRegistroLDAP(String codGestor) {

		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		try {
			return aSesionTerritorio.busTerritorioxRegistroLDAP(codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector pggSeguimiento1(String mes, String anho, String codOficina,
			String codGestor) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.pggSeguimiento1(mes, anho, codOficina,
					codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector pggSeguimiento1(String mes, String anho, String codOficina,
			String codGestor, ProgSeguimiento progSeguimiento) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.pggSeguimiento1(mes, anho, codOficina,
					codGestor, progSeguimiento);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector pggEsfuerzoAdicional1(String mes, String anho,
			String codOficina, String codGestor) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.pggEsfuerzoAdicional1(mes, anho, codOficina,
					codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector pggEsfuerzoAdicional1(String mes, String anho,
			String codOficina, String codGestor, ProgSeguimiento progSeguimiento) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.pggEsfuerzoAdicional1(mes, anho, codOficina,
					codGestor, progSeguimiento);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector pggSeguimiento2(String mes, String anho, String codOficina,
			String codGestor, ProgSeguimiento progSeguimiento) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.pggSeguimiento2(mes, anho, codOficina,
					codGestor, progSeguimiento);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector pggSeguimiento2(String mes, String anho, String codOficina,
			String codGestor) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.pggSeguimiento2(mes, anho, codOficina,
					codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector pggEsfuerzoAdicional2(String mes, String anho,
			String codOficina, String codGestor, ProgSeguimiento progSeguimiento) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.pggEsfuerzoAdicional2(mes, anho, codOficina,
					codGestor, progSeguimiento);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector pggEsfuerzoAdicional2(String mes, String anho,
			String codOficina, String codGestor) {

		SesionAcciones aSesionAcciones = createSesionAcciones();
		try {
			return aSesionAcciones.pggEsfuerzoAdicional2(mes, anho, codOficina,
					codGestor);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	// MEQUE ACTUALIZA LA TABLA E SEGUIMIENTOS
	public boolean actualizarSeguimiento1(String tipoSeguimiento,
			String numDato, String codigo1, String codigo2, String valor, String usuario) {
		SesionAcciones aSesionAcciones = createSesionAcciones();
		
		try {
			boolean aboolean = aSesionAcciones.actualizarSeguimiento1(
					tipoSeguimiento, numDato, codigo1, codigo2, valor, usuario);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean actualizarSeguimiento2(String tipoSeguimiento,
			String numDato, String codigo1, String codigo2, String valor, String usuario) {
		SesionAcciones aSesionAcciones = createSesionAcciones();
		
		try {
			boolean aboolean = aSesionAcciones.actualizarSeguimiento2(
					tipoSeguimiento, numDato, codigo1, codigo2, valor, usuario);
			return aboolean;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public int actualizarPorcentajeEpigrafe(Epigrafe datos) {

		SesionEpigrafe aSesionEpigrafe = createSesionEpigrafe();
		try {
			return aSesionEpigrafe.actualizarPorcentajeEpigrafe(datos);
		} catch (RemoteException ex) {
			//	 Auto-generated catch block
			ex.printStackTrace();
		}
		return 0;
	}

	public boolean existeDataPlanesMesAnio(String mes, String anio) {
		SesionPlanes aSesionPlanes = createSesionPlanes();

		try {
			return aSesionPlanes.existeDataMesAnio(mes, anio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean existeDataMaestroPlanesMesAnio(String mes, String anio) {
		SesionMaestroPlanes aSesionMaestroPlanes = createSesionMaestroPlanes();

		try {
			return aSesionMaestroPlanes.existeDataMesAnio(mes, anio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Vector findEpigrafesinPlanes(String codOficina, String anho,
			String mes) {
		SesionPlanes aSesionPlanes = createSesionPlanes();

		try {
			return aSesionPlanes.findEpigrafesinPlanes(codOficina, anho, mes);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean nuevoCampaniaDetalle(String codTerritorio,
			String codOficina, String codCampania, String mes, String anho,
			String nomCampania, String codGest, int nroClie, double compGest,
			String usuario) {
		SesionCampaniasDetalle aSesionCampaniasDetalle = createSesionCampaniasDetalle();
		
		try {
			return aSesionCampaniasDetalle.nuevoCampaniaDetalle(codTerritorio,
					codOficina, codCampania, mes, anho, nomCampania, codGest,
					nroClie, compGest, usuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

	public boolean edicionCampaniaDetalle(String codCampaniaDetalle,
			String nomCampania, int nroClie, double compGest, String usuario){
		SesionCampaniasDetalle aSesionCampaniasDetalle = createSesionCampaniasDetalle();
		
		try {
			return aSesionCampaniasDetalle.edicionCampaniaDetalle(
					codCampaniaDetalle, nomCampania, nroClie, compGest, usuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

	public Vector listaCampaniaDetalle(String codTerritorio, String codOficina,
			String codCamp, String mes, String anho) {
		SesionCampaniasDetalle aSesionCampaniasDetalle = createSesionCampaniasDetalle();

		try {
			return aSesionCampaniasDetalle.listaCampaniaDetalle(codTerritorio,
					codOficina, codCamp, mes, anho);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public boolean eliminarCampaniaDetalle(String codCamp) {
		SesionCampaniasDetalle aSesionCampaniasDetalle = createSesionCampaniasDetalle();

		try {
			return aSesionCampaniasDetalle.eliminarCampaniaDetalle(codCamp);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return false;
	}

	public Territorio findTerritorioByCodOficina(String codOficina) {
		SesionOficina aSesionOficina = createSesionOficina();

		try {
			return aSesionOficina.findTerritorioByCodOficina(codOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busGestorxOficinaxAnioxMes(String codOficina, String mes,
			String anio) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();

		try {
			return aSesionMetasGestor.busGestorxOficinaxAnioxMes(codOficina,
					mes, anio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public boolean edicionAccion(String codAccion, String descAccion,
			String numeroCliente, String compromisoGestor, String usuario) {
		SesionAcciones aSesionAcciones = createSesionAcciones();

		try {
			return aSesionAcciones.edicionAccion(codAccion, descAccion,
					numeroCliente, compromisoGestor, usuario);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		
		return false;
	}

	public Accion busAccion(String codAccion) {
		SesionAcciones aSesionAcciones = createSesionAcciones();

		try {
			return aSesionAcciones.busAccion(codAccion);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public Campanias busCampaniaDetalle(String codCampaniaDetalle) {
		SesionCampaniasDetalle aSesionCampaniasDetalle = createSesionCampaniasDetalle();

		try {
			return aSesionCampaniasDetalle
					.busCampaniaDetalle(codCampaniaDetalle);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public int xInsertarTAcciones(String codigoAccion, String nomberAccion,
			String codigoGestor, String mes, String anho, int nroClientes,
			int compromisoGestor, int nroGestorSeguimiento1,
			int nroConcSeguimiento1, int montoSeguimiento1,
			int nroGestorSeguimiento2, int nroConcSeguimiento2,
			int montoSeguimiento2, String codigoOficina, String codigoEpigrafe,
			Date fechaSeg1, Date fechaSeg2, Date fechaGrabacion,
			String codTerritorio) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTAcciones(codigoAccion, nomberAccion,
					codigoGestor, mes, anho, nroClientes, compromisoGestor,
					nroGestorSeguimiento1, nroConcSeguimiento1,
					montoSeguimiento1, nroGestorSeguimiento2,
					nroConcSeguimiento2, montoSeguimiento2, codigoOficina,
					codigoEpigrafe, fechaSeg1, fechaSeg2, fechaGrabacion,
					codTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public String xDameTerritorio(String codigoOficina) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xDameTerritorio(codigoOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public Vector xBusAllTablaAccionesAntiguo(String mes, String anho) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaAccionesAntiguo(mes, anho);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public Vector xBusAllTablaEpigrafesAntiguo() {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaEpigrafesAntiguo();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public int xInsertarTEpigrafes(String codigoepigrafe,
			String nombreepigrafe, String anho, String indicadorclase,
			String indicadorsubclase, String orden, String indicadorgrupo,
			String abreviatura, String indicadorhijo, String indicadorafecta) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTEpigrafes(codigoepigrafe,
					nombreepigrafe, anho, indicadorclase, indicadorsubclase,
					orden, indicadorgrupo, abreviatura, indicadorhijo,
					indicadorafecta);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public int xInsertarTTerritorio(String codigoTerritorio,
			String nombreTerritorio) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTTerritorio(codigoTerritorio,
					nombreTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public Vector xBusAllTablaTerritorioAntiguo() {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaTerritorioAntiguo();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public Vector xBusAllTablaOficinaAntiguo() {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaOficinaAntiguo();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public int xInsertarTOficina(String codigoTerritorio, String nombreOficina,
			String codigoOficina) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTOficina(codigoTerritorio,
					nombreOficina, codigoOficina);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return 0;
	}

	public Vector xBusAllTablaCampanhasAntiguo(String anho) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaCampanhasAntiguo(anho);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public int xInsertarTCampanhas(String codigoCampania, String anho,
			String mes, String nombreCampania, String codigoOficina,
			String codigoGestor, String orden, String gte, Date fechaGrabacion,
			String codigoTerritorio) {
		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTCampanhas(codigoCampania, anho, mes,
					nombreCampania, codigoOficina, codigoGestor, orden, gte,
					fechaGrabacion, codigoTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return 0;
	}

	public Vector xBusAllTablaCampanhasDetalleAntiguo() {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaCampanhasDetalleAntiguo();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public int xInsertarTCampanhasDetalle(String codigoCampanhaDetalle,
			String nombreCampanha, String codigoGestor, String mes,
			String anho, int nroClientes, int compromisoGestor,
			int nroGestorSeguimiento1, int nroConcSeguimiento1,
			int montoSeguimiento1, int nroGestorSeguimiento2,
			int nroConcSeguimiento2, int montoSeguimiento2,
			String codigoOficina, String codigoCampanha, Date fechaGrabacion,
			Date fechaSeg1, Date fechaSeg2, String codigoTerritorio) {
		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTCampanhasDetalle(
					codigoCampanhaDetalle, nombreCampanha, codigoGestor, mes,
					anho, nroClientes, compromisoGestor, nroGestorSeguimiento1,
					nroConcSeguimiento1, montoSeguimiento1,
					nroGestorSeguimiento2, nroConcSeguimiento2,
					montoSeguimiento2, codigoOficina, codigoCampanha,
					fechaGrabacion, fechaSeg1, fechaSeg2, codigoTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return 0;
	}

	public Vector xBusAllTablaEquivalencias() {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaEquivalencias();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public int xInsertarTEquivalencias(String codigoCargo, String codigoPerfil) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTEquivalencias(codigoCargo,
					codigoPerfil);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public Vector xBusAllTablaPerfiles() {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaPerfiles();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public int xInsertarTPerfiles(String codigoPerfil, String nombrePerfil) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTPerfiles(codigoPerfil, nombrePerfil);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public int xInsertarTFirmas(String anho, String mes, String item,
			String codigoGestor, String codigoOficina, String descripcion,
			Date fecha) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTFirmas(anho, mes, item, codigoGestor,
					codigoOficina, descripcion, fecha);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public Vector xBusAllTablaFirmas() {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaFirmas();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public Vector xBusAllTablaMaestroPlanes(String contadorMes) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaMaestroPlanes(contadorMes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public int xInsertarTMaestroPlanes(String codigoOficina, String mes,
			String anho, String codigoTerritorio, String prioridad,
			Date fechaGrabacion) {
		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTMaestroPlanes(codigoOficina, mes,
					anho, codigoTerritorio, prioridad, fechaGrabacion);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public Vector xBusAllTablaMetasGestor(String contadorMes) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaMetasGestor(contadorMes);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public int xInsertarTMetasGestor(String codigoMetaGestor,
			String codigoEpigrafe, String codigoOficina, String codigoGestor,
			String anho, String mes, String orden, Date fechaGrabacion,
			String porcAsignado, String nombreEpigrafe, String nombreGestor,
			String codigoTerritorio) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTMetasGestor(codigoMetaGestor,
					codigoEpigrafe, codigoOficina, codigoGestor, anho, mes,
					orden, fechaGrabacion, porcAsignado, nombreEpigrafe,
					nombreGestor, codigoTerritorio);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;

	}

	public Vector xBusAllTablaParametros() {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaParametros();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}

	public int xInsertarTParametros(Date fechaAccion, Date fechaSeguimiento1,
			Date fechaSeguimiento2, String afectaAccion,
			String afectaSeguimiento, String afectaPlanificacion,
			Date fechaPlanificacion) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTParametros(fechaAccion,
					fechaSeguimiento1, fechaSeguimiento2, afectaAccion,
					afectaSeguimiento, afectaPlanificacion, fechaPlanificacion);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public Vector xBusAllTablaPlanes(String mes, String anho) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xBusAllTablaPlanes(mes, anho);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

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

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.xInsertarTPlanes(codigoOficina, mes, anho,
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
			ex.printStackTrace();
		}

		return 0;
	}

	public int actualizarEstadoFlag(String flag) {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.actualizarEstadoFlag(flag);
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}

		return 0;
	}

	public String buscarEstadoFlag() {

		SessionUtil aSessionUtil = createSessionUtil();
		try {
			return aSessionUtil.buscarEstadoFlag();
		} catch (RemoteException ex) {
			// Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	public int obtenerPrimerMesPresup() {
		int valor = 99;
		SesionMultitabla aSesionMultitabla = createSesionMultitabla();

		try {
			return aSesionMultitabla.obtenerPrimerMesPresup();

		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return valor;
	}

	public Vector buscarUsuariosLDAP(String codOficina, String codEmpresa,
			int limiteOcurrencias) {
		SessionUtil aSessionUtil = createSessionUtil();

		try {
			return aSessionUtil.buscarUsuariosLDAP(codOficina, codEmpresa,
					limiteOcurrencias);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	protected SesionProgSeguimiento createSesionProgSeguimiento() {
		SesionProgSeguimientoHome aSesionProgSeguimientoHome = (SesionProgSeguimientoHome) ServiceLocatorManager
				.getRemoteHome(STATIC_SesionProgSeguimientoHome_REF_NAME,
						STATIC_SesionProgSeguimientoHome_CLASS);
		try {
			if (aSesionProgSeguimientoHome != null)
				return aSesionProgSeguimientoHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		} catch (RemoteException re) {
			re.printStackTrace();
		}

		return null;
	}

	public ProgSeguimiento findProgTerritorio(ProgSeguimiento progTerritorio) {
		SesionProgSeguimiento aSesionProgSeguimiento = createSesionProgSeguimiento();

		try {
			return aSesionProgSeguimiento.findProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public Vector findTodosProgTerritorio(ProgSeguimiento progTerritorio) {
		SesionProgSeguimiento aSesionProgSeguimiento = createSesionProgSeguimiento();

		try {
			return aSesionProgSeguimiento
					.findTodosProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public ProgSeguimiento findProgramacionSeguimiento(String mes, String anio,
			String codTerritorio) {
		SesionProgSeguimiento aSesionProgSeguimiento = createSesionProgSeguimiento();

		try {
			return aSesionProgSeguimiento.findProgramacionSeguimiento(mes,
					anio, codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public boolean crearProgTerritorio(ProgSeguimiento progTerritorio) {
		SesionProgSeguimiento aSesionProgSeguimiento = createSesionProgSeguimiento();

		try {
			return aSesionProgSeguimiento.crearProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean actualizarProgTerritorio(ProgSeguimiento progTerritorio) {
		SesionProgSeguimiento aSesionProgSeguimiento = createSesionProgSeguimiento();

		try {
			return aSesionProgSeguimiento
					.actualizarProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean eliminarProgTerritorio(ProgSeguimiento progTerritorio) {
		SesionProgSeguimiento aSesionProgSeguimiento = createSesionProgSeguimiento();

		try {
			return aSesionProgSeguimiento
					.eliminarProgTerritorio(progTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public void actualizarIngreso(int tipo, int idIngreso, String mes,
			String anio) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			aSesionIngresos.actualizarIngreso(tipo, idIngreso, mes, anio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return;
	}

	public Vector busIngresoxUsuario(String anho, String mes, String dia,
			String codTerritorioUsuario) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.busIngresoxUsuario(anho, mes, dia,
					codTerritorioUsuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busIngresoxOficina(String anho, String mes, String dia,
			String codTerritorioUsuario) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.busIngresoxOficina(anho, mes, dia,
					codTerritorioUsuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public Vector busIngresoxTerritorio(String anho, String mes, String dia,
			String codTerritorioUsuario) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.busIngresoxTerritorio(anho, mes, dia,
					codTerritorioUsuario);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean insertUpdateMesesReferencia(int mes, int anio, int sel_mes) {
		SesionPlanes aSesionPlanes = createSesionPlanes();

		try {
			return aSesionPlanes
					.insertUpdateMesesReferencia(mes, anio, sel_mes);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public int findMesesReferencia(int mes, int anio) {
		SesionPlanes aSesionPlanes = createSesionPlanes();

		try {
			return aSesionPlanes.findMesesReferencia(mes, anio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return -1;
	}
	
	public String testearBD() {
		SessionUtil aSessionUtil = null;

		try {
			aSessionUtil = createSessionUtil();
			
			return aSessionUtil.testearBD();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public OficinaHija findOficinaHija(OficinaHija oficinaHija) {
		SesionOficina aSesionOficina = createSesionOficina();
		
		try {
			return aSesionOficina.findOficinaHija(oficinaHija) ;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean crearOficinaHija(OficinaHija oficinaHija) {
		SesionOficina aSesionOficina = createSesionOficina();
		
		try {
			return aSesionOficina.crearOficinaHija(oficinaHija) ;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean actualizarOficinaHija(OficinaHija oficinaHija) {
		SesionOficina aSesionOficina = createSesionOficina();
		
		try {
			return aSesionOficina.actualizarOficinaHija(oficinaHija);
			
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminarOficinaHija(OficinaHija oficinaHija) {
		SesionOficina aSesionOficina = createSesionOficina();
		
		try {
			return aSesionOficina.eliminarOficinaHija(oficinaHija);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public Vector findTodosOficinaHija() {
		SesionOficina aSesionOficina = createSesionOficina();
		
		try {
			return aSesionOficina.findTodosOficinaHija();
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Vector findHijas(String codOficinaPadre) {
		SesionOficina aSesionOficina = createSesionOficina();
		
		try {
			return aSesionOficina.findHijas(codOficinaPadre);
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Vector distribuirGOF(Vector listaGestoresLDAP, String codEpigrafe, String anho,
			String codOficina, String mes) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		
		try {
			return aSesionMetasGestor.distribuirGOF(listaGestoresLDAP, codEpigrafe, anho,
					codOficina, mes);
		} catch (RemoteException ex) {
			return new Vector(0, 1);
		}
	}
	
	public void actualizarMetaGestoresPlanes(Vector listaEpigrafe, String anho,
			String codOficina, String mes, String codGestorGOF, String usuario) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		
		try {
			aSesionMetasGestor.actualizarMetaGestoresPlanes(listaEpigrafe, anho,
					codOficina, mes, codGestorGOF, usuario);
		} catch (RemoteException ex) {
			return;
		}
		return;
	}
	
	public HashMap buscarResumenMontos(Vector listaEpigrafe, String codTerritorio, String codOficina, String anho,
			String mes) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		
		try {
			return aSesionMetasGestor.buscarResumenMontos(listaEpigrafe, codTerritorio, codOficina, anho,
					mes);
		} catch (RemoteException ex) {
			return null;
		}
	}
	
	public BigDecimal buscarMontoGestor(String codGestor, String codEpigrafe, String anho,
			String codOficina, String mes) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		
		try {
			return aSesionMetasGestor.buscarMontoGestor(codGestor, codEpigrafe, anho,
					codOficina, mes);
		} catch (RemoteException ex) {
			return null;
		}
	}
	
	public Oficina findByCodOficinaHija(String codOficina) {
		SesionOficina aSesionOficina = createSesionOficina();
		try {
			Oficina anOficina = aSesionOficina.findByCodOficinaHija(codOficina);
			return anOficina;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void actualizarGestoresEliminadosLDAP(Vector listaGestoresLDAP, String codEpigrafe, String anho,
			String codOficina, String mes, String usuario) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		
		try {
			aSesionMetasGestor.actualizarGestoresEliminadosLDAP(listaGestoresLDAP, codEpigrafe, anho,
					codOficina, mes, usuario);
		} catch (RemoteException ex) {
			return;
		}
		return;
	}
	
	public void actualizarGestoresDistribuidosLDAP(String codEpigrafe, String anho,
			String codOficina, String mes, String usuario) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		
		try {
			aSesionMetasGestor.actualizarGestoresDistribuidosLDAP(codEpigrafe, anho,
					codOficina, mes, usuario);
		} catch (RemoteException ex) {
			return;
		}
		return;
	}
	
	public void actualizarCargoGestoresLDAP(Vector listaGestoresLDAP, String codEpigrafe, String anho,
			String codOficina, String mes, String usuario) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		
		try {
			aSesionMetasGestor.actualizarCargoGestoresLDAP(listaGestoresLDAP, codEpigrafe, anho,
					codOficina, mes, usuario);
		} catch (RemoteException ex) {
			return;
		}
	}
	
	public void editarMensajeTerritorio(String codTerritorio, String mensaje, String colorFondo) {
		SesionTerritorio aSesionTerritorio = createSesionTerritorio();
		
		try {
			aSesionTerritorio.editarMensajeTerritorio(codTerritorio, mensaje, colorFondo);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		
		return ;
	}
	

	public void eliminarMetaGestoresHijas(Vector listaGestores) {
		SesionMetasGestor aSesionMetasGestor = createSesionMetasGestor();
		
		try {
			aSesionMetasGestor.eliminarMetaGestoresHijas(listaGestores);
		} catch (RemoteException ex) {
			return;
		}
	}
	
	public Vector editarOficina(Oficina oficina) {

		SesionOficina aSesionOficina = createSesionOficina();
		try {
			Vector aVector = aSesionOficina.editarOficina(oficina);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	 public Vector reportexUsuario(int dia, int mes, int anio, String codTerritorio) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.reportexUsuario(dia, mes, anio, codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	 
	public Vector reportexOficina(int dia, int mes, int anio, String codTerritorio) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.reportexOficina(dia, mes, anio, codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public Vector reportexTerritorio(int dia, int mes, int anio, String codTerritorio) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.reportexTerritorio(dia, mes, anio, codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public Vector reportexUsuarioxAnio(int anio, String codTerritorio) { 
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.reportexUsuarioxAnio(anio, codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public ArrayList listarDiasMesesxAnio(int anio) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.listarDiasMesesxAnio(anio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public Vector reportexOficinaxAnio(int anio, String codTerritorio) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.reportexOficinaxAnio(anio, codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public Vector reportexTerritorioxAnio(int anio, String codTerritorio) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.reportexTerritorioxAnio(anio, codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public void insertarIngresoForm(int tipo, int mes, int anio, 
			String codUsuario, String editUsuario, String codGestor, String codOficina) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			aSesionIngresos.insertarIngresoForm(tipo, mes, anio, 
					codUsuario, editUsuario, codGestor, codOficina);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return;
	}
	
	public long existeIngresoForm(int tipo, int mes, int anio, String codUsuario, String fecha, String codGestorM, String codOficinaM) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			return aSesionIngresos.existeIngresoForm(tipo, mes, anio, codUsuario, fecha, codGestorM, codOficinaM) ;
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return 0;
	}
	
	public void actualizarIngresoFormEditUsuario(long id) {
		SesionIngresos aSesionIngresos = createSesionIngresos();

		try {
			aSesionIngresos.actualizarIngresoFormEditUsuario(id);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return;
	}
	
	public Vector exportarTablasTXT(int tabla, int mes, int anio) {
		SessionUtil aSesionUtil = createSessionUtil();

		try {
			return aSesionUtil.exportarTablasTXT(tabla, mes, anio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}

		return null;

	}
	
	public int registrarPermisoPerfil(PermisoPerfil permisoPerfil) {
		int result = 0;
		
		try {
			result = createSesionPermisoPerfil().registrarPermisoPerfil(
					permisoPerfil);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	public int listadoIngresoxDia(String diaActual, String codTerritorio) {
		SesionIngresos aSesionIngresos = createSesionIngresos();
		int result = 0;
		
		try {
			aSesionIngresos = createSesionIngresos();
			result = aSesionIngresos.listadoIngresoxDia(diaActual, codTerritorio);
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	/* Begin: Modificado Juan Quedena */

	public HashMap<String, Integer> findCantidadPersonal(String anho, String mes, String codOfi, String codTerr) {
		SesionPlanes aSesionPlanes = createSesionPlanes();
		try {
			HashMap<String, Integer> aVector = aSesionPlanes.findCantidadPersonal(anho, mes, codOfi, codTerr);
			return aVector;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public BigDecimal promedioMensual(String anho, String mes, String codOfi, String codTerr, String codEpi, String codGestor) {
		SesionMetasGestor aSesionMetas = createSesionMetasGestor();
		try {
			BigDecimal avg = aSesionMetas.promedioMensual(anho, mes, codOfi, codTerr, codEpi, codGestor);
			return avg;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Vector<Seguimiento> consultaSeguimientoAccionEsfuerzo(String codOfi, String mes, String anho, String codGestor) {
		SessionUtil aSesionUtil = createSessionUtil();
		try {
			Vector<Seguimiento> seguimientos = aSesionUtil.consultaSeguimientoAccionEsfuerzo(codOfi, mes, anho, codGestor);
			return seguimientos;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Vector<Seguimiento> consultaSeguimientoAccionEsfuerzoPGO(String codOfi, String mes, String anho) {
		SessionUtil aSesionUtil = createSessionUtil();
		try {
			Vector<Seguimiento> seguimientos = aSesionUtil.consultaSeguimientoAccionEsfuerzoPGO(codOfi, mes, anho);
			return seguimientos;
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}	
	