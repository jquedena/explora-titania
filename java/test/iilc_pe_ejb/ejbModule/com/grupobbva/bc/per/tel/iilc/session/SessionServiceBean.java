package com.grupobbva.bc.per.tel.iilc.session;

import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;

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
import com.ibm.etools.service.locator.ServiceLocatorManager;
import com.stefanini.pe.framework.collections.DataTable;

@SuppressWarnings("unchecked")
public class SessionServiceBean implements javax.ejb.SessionBean {

	private static final long serialVersionUID = 1L;
	private final static String STATIC_SessionCargaLocalHome_REF_NAME = "ejb/SessionCarga";
	private final static Class STATIC_SessionCargaLocalHome_CLASS = SessionCargaLocalHome.class;
	private final static String STATIC_SessionClienteLocalHome_REF_NAME = "ejb/SessionCliente";
	private final static Class STATIC_SessionClienteLocalHome_CLASS = SessionClienteLocalHome.class;
	private final static String STATIC_SessionGestorLocalHome_REF_NAME = "ejb/SessionGestor";
	private final static Class STATIC_SessionGestorLocalHome_CLASS = SessionGestorLocalHome.class;
	private final static String STATIC_SessionMultitablaLocalHome_REF_NAME = "ejb/SessionMultitabla";
	private final static Class STATIC_SessionMultitablaLocalHome_CLASS = SessionMultitablaLocalHome.class;
	private final static String STATIC_SessionOficinaLocalHome_REF_NAME = "ejb/SessionOficina";
	private final static Class STATIC_SessionOficinaLocalHome_CLASS = SessionOficinaLocalHome.class;
	private final static String STATIC_SessionPermisoPerfilLocalHome_REF_NAME = "ejb/SessionPermisoPerfil";
	private final static Class STATIC_SessionPermisoPerfilLocalHome_CLASS = SessionPermisoPerfilLocalHome.class;
	private final static String STATIC_SessionTerritorioLocalHome_REF_NAME = "ejb/SessionTerritorio";
	private final static Class STATIC_SessionTerritorioLocalHome_CLASS = SessionTerritorioLocalHome.class;
	private final static String STATIC_SessionTotalLocalHome_REF_NAME = "ejb/SessionTotal";
	private final static Class STATIC_SessionTotalLocalHome_CLASS = SessionTotalLocalHome.class;
	private final static String STATIC_SessionEmpresaLocalHome_REF_NAME = "ejb/SessionEmpresa";
	private final static Class STATIC_SessionEmpresaLocalHome_CLASS = SessionEmpresaLocalHome.class;

	private javax.ejb.SessionContext mySessionCtx;
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

	public boolean createCliente(Cliente cliente) {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		return aSessionCargaLocal.createCliente(cliente);
	}

	public boolean createTotal(Total total) {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		return aSessionCargaLocal.createTotal(total);
	}

	public boolean createArea(Area area) {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		return aSessionCargaLocal.createArea(area);
	}

	public boolean createTerritorio(Territorio territorio)
			throws javax.ejb.CreateException {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		try {
			return aSessionCargaLocal.createTerritorio(territorio);
		} catch (CreateException e) {
		}
		return false;
	}

	public boolean createOficina(Oficina oficina) {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		return aSessionCargaLocal.createOficina(oficina);
	}

	public boolean createGestor(Gestor gestor) {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		return aSessionCargaLocal.createGestor(gestor);
	}
	
    public boolean createMultitabla(Multitabla multitabla) {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		return aSessionCargaLocal.createMultitabla(multitabla);
	}

	public boolean createPerfil(Perfil perfil) {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		return aSessionCargaLocal.createPerfil(perfil);
	}

	public boolean createEmpresa(Empresa empresa) {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		return aSessionCargaLocal.createEmpresa(empresa);
	}

	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil) {
		SessionCargaLocal aSessionCargaLocal = createSessionCargaLocal();
		return aSessionCargaLocal.createPermisoPerfil(permisoPerfil);
	}

	public Perfil findPerfil(String cod_perfil) {
		SessionPermisoPerfilLocal aSessionPermisoPerfilLocal = createSessionPermisoPerfilLocal();
		return aSessionPermisoPerfilLocal.findPerfil(cod_perfil);
	}

	public PermisoPerfil findPermisoPerfil(String cod_perfil, int tipo_acceso,
			String valor_rcp) {
		SessionPermisoPerfilLocal aSessionPermisoPerfilLocal = createSessionPermisoPerfilLocal();
		return aSessionPermisoPerfilLocal.findPermisoPerfil(cod_perfil,
				tipo_acceso, valor_rcp);
	}

	public Multitabla findMultitabla(String cod_mult, String cod_ele) {
		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.findMultitabla(cod_mult, cod_ele);
	}

	public Cliente findCliente(int cod_cliente) throws FinderException {
		SessionClienteLocal aSessionClienteLocal = createSessionClienteLocal();
		try {
			Object anObject = aSessionClienteLocal.findCliente(cod_cliente);
			return (Cliente) anObject;
		} catch (EJBException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	protected SessionClienteLocal createSessionClienteLocal() {
		SessionClienteLocalHome aSessionClienteLocalHome = (SessionClienteLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionClienteLocalHome_REF_NAME,
						STATIC_SessionClienteLocalHome_CLASS);
		try {
			if (aSessionClienteLocalHome != null)
				return aSessionClienteLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	public Vector<Gestor> findAllGestorxOfxTe(String cod_area, String cod_territorio,
			String cod_oficina) throws FinderException {
		SessionGestorLocal aSessionGestorLocal = createSessionGestorLocal();
		try {
			Vector<Gestor> aVector = aSessionGestorLocal.findAllGestorxOfxTe(cod_area,
					cod_territorio, cod_oficina);
			return aVector;
		} catch (FinderException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector<String> findATOG(String cod_usuario) throws FinderException {
		SessionGestorLocal aSessionGestorLocal = createSessionGestorLocal();
		try {
			Vector<String> aVector = aSessionGestorLocal.findATOG(cod_usuario);
			return aVector;
		} catch (FinderException ex) {
			System.err
					.println("SessionService: Error findATOG, no se encontro la secuencia ATOG de "
							+ cod_usuario);
		}
		return null;
	}

	public Vector findAllEmpresa() {
		SessionEmpresaLocal aSessionEmpresaLocal = createSessionEmpresaLocal();
		return aSessionEmpresaLocal.findAllEmpresa();
	}

	protected SessionGestorLocal createSessionGestorLocal() {
		SessionGestorLocalHome aSessionGestorLocalHome = (SessionGestorLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionGestorLocalHome_REF_NAME,
						STATIC_SessionGestorLocalHome_CLASS);
		try {
			if (aSessionGestorLocalHome != null)
				return aSessionGestorLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	public Vector findAllRecord(String cod_mult) throws FinderException {
		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		try {
			Vector aVector = aSessionMultitablaLocal.findAllRecord(cod_mult);
			return aVector;
		} catch (FinderException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Multitabla findRecord(String codigo) throws FinderException {
		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		try {
			Multitabla aMultitabla = aSessionMultitablaLocal.findRecord(codigo);
			return aMultitabla;
		} catch (FinderException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Vector findMultitablaxValor2(String valor2) throws FinderException {
		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		try {
			Vector aVector = aSessionMultitablaLocal
					.findMultitablaxValor2(valor2);
			return aVector;
		} catch (FinderException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	protected SessionMultitablaLocal createSessionMultitablaLocal() {
		SessionMultitablaLocalHome aSessionMultitablaLocalHome = (SessionMultitablaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionMultitablaLocalHome_REF_NAME,
						STATIC_SessionMultitablaLocalHome_CLASS);
		try {
			if (aSessionMultitablaLocalHome != null)
				return aSessionMultitablaLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	public Vector<Oficina> findAllOficinaxTe(String cod_area, String cod_territorio)
			throws FinderException {
		SessionOficinaLocal aSessionOficinaLocal = createSessionOficinaLocal();
		try {
			//Vector aVector = aSessionOficinaLocal.findAllOficinaxTe(cod_area,cod_territorio);
			Vector<Oficina> aVector = aSessionOficinaLocal
					.findAllOficinaxTerr(cod_territorio);

			return aVector;
		} catch (FinderException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	protected SessionOficinaLocal createSessionOficinaLocal() {
		SessionOficinaLocalHome aSessionOficinaLocalHome = (SessionOficinaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionOficinaLocalHome_REF_NAME,
						STATIC_SessionOficinaLocalHome_CLASS);
		try {
			if (aSessionOficinaLocalHome != null)
				return aSessionOficinaLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	protected SessionPermisoPerfilLocal createSessionPermisoPerfilLocal() {
		SessionPermisoPerfilLocalHome aSessionPermisoPerfilLocalHome = (SessionPermisoPerfilLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionPermisoPerfilLocalHome_REF_NAME,
						STATIC_SessionPermisoPerfilLocalHome_CLASS);
		try {
			if (aSessionPermisoPerfilLocalHome != null)
				return aSessionPermisoPerfilLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	public Vector<Territorio> findAllTerritorio(String cod_area) throws FinderException {
		SessionTerritorioLocal aSessionTerritorioLocal = createSessionTerritorioLocal();
		try {
			Vector<Territorio> aVector = aSessionTerritorioLocal.findAllTerritorio(cod_area);
			return aVector;
		} catch (FinderException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	protected SessionTerritorioLocal createSessionTerritorioLocal() {
		SessionTerritorioLocalHome aSessionTerritorioLocalHome = (SessionTerritorioLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionTerritorioLocalHome_REF_NAME,
						STATIC_SessionTerritorioLocalHome_CLASS);
		try {
			if (aSessionTerritorioLocalHome != null)
				return aSessionTerritorioLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	public Total findTotal(String ind_registro, String cod_territorio,
			String cod_oficina, String cod_gestor) throws FinderException {
		SessionTotalLocal aSessionTotalLocal = createSessionTotalLocal();
		try {
			Total aTotal = aSessionTotalLocal.findTotal(ind_registro,
					cod_territorio, cod_oficina, cod_gestor);
			return aTotal;
		} catch (FinderException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	protected SessionTotalLocal createSessionTotalLocal() {
		SessionTotalLocalHome aSessionTotalLocalHome = (SessionTotalLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionTotalLocalHome_REF_NAME,
						STATIC_SessionTotalLocalHome_CLASS);
		try {
			if (aSessionTotalLocalHome != null)
				return aSessionTotalLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	public PermisoPerfil findComponente(String codReg, String codCat,
			String path) throws FinderException {

		SessionPermisoPerfilLocal aSessionPermisoPerfilLocal = createSessionPermisoPerfilLocal();

		try {
			PermisoPerfil aPermisoPerfil = aSessionPermisoPerfilLocal
					.findComponente(codReg, codCat, path);
			return aPermisoPerfil;
		} catch (FinderException ex) {
			ex.printStackTrace();
		}
		return null;

	}

	protected SessionCargaLocal createSessionCargaLocal() {
		SessionCargaLocalHome aSessionCargaLocalHome = (SessionCargaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionCargaLocalHome_REF_NAME,
						STATIC_SessionCargaLocalHome_CLASS);
		try {
			if (aSessionCargaLocalHome != null)
				return aSessionCargaLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	public Vector findAllMultitabla() {
		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		try {
			Vector aVector = aSessionMultitablaLocal.findAllMultitabla();
			return aVector;
		} catch (FinderException ex) {
			System.err.println("Error SessionService: findAllMultitabla");
		}
		return null;
	}

	public Vector findAllPerfil() {
		SessionPermisoPerfilLocal aSessionPermisoPerfilLocal = createSessionPermisoPerfilLocal();
		try {
			Vector aVector = aSessionPermisoPerfilLocal.findAllPerfil();
			return aVector;
		} catch (FinderException ex) {
			System.err.println("Error SessionService: findAllPerfil");
		}
		return null;
	}

	public Vector findAllPermisoPerfil() {
		SessionPermisoPerfilLocal aSessionPermisoPerfilLocal = createSessionPermisoPerfilLocal();
		try {
			Vector aVector = aSessionPermisoPerfilLocal.findAllPermisoPerfil();
			return aVector;
		} catch (FinderException ex) {
			System.err.println("Error SessionService: findAllPermisoPerfil");
		}
		return null;
	}

	public boolean updateMultitabla(Multitabla multitabla) {
		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.updateMultitabla(multitabla);
	}

	public boolean updatePerfil(Perfil perfil) {
		SessionPermisoPerfilLocal aSessionPermisoPerfilLocal = createSessionPermisoPerfilLocal();
		return aSessionPermisoPerfilLocal.updatePerfil(perfil);
	}

	public boolean deleteMultitabla(String cod_mult, String cod_ele) {
		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.deleteMultitabla(cod_mult, cod_ele);
	}

	public Vector listaDetalleFiltroComplejo(String tipo, String tipo2, String[] codigos){
		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.listaDetalleFiltroComplejo(tipo, tipo2, codigos);
	}

	public Vector listaDetalleFiltroSimple(String tipo, String[] codigos){
		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.listaDetalleFiltroSimple(tipo, codigos);
	}

	public boolean deletePerfil(String cod_perfil) {
		SessionPermisoPerfilLocal aSessionPermisoPerfilLocal = createSessionPermisoPerfilLocal();
		return aSessionPermisoPerfilLocal.deletePerfil(cod_perfil);
	}

	public boolean deletePermisoPerfil(String cod_perfil, int tipo_acceso,
			String valor_rcp) {
		SessionPermisoPerfilLocal aSessionPermisoPerfilLocal = createSessionPermisoPerfilLocal();
		return aSessionPermisoPerfilLocal.deletePermisoPerfil(cod_perfil,
				tipo_acceso, valor_rcp);
	}

	public boolean deleteCliente(int cod_cliente) {
		SessionClienteLocal aSessionClienteLocal = createSessionClienteLocal();
		return aSessionClienteLocal.deleteCliente(cod_cliente);
	}

	public boolean deleteAllGestor(String cod_area) {
		SessionGestorLocal aSessionGestorLocal = createSessionGestorLocal();
		return aSessionGestorLocal.deleteAllGestor(cod_area);
	}

	protected SessionEmpresaLocal createSessionEmpresaLocal() {
		SessionEmpresaLocalHome aSessionEmpresaLocalHome = (SessionEmpresaLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionEmpresaLocalHome_REF_NAME,
						STATIC_SessionEmpresaLocalHome_CLASS);
		try {
			if (aSessionEmpresaLocalHome != null)
				return aSessionEmpresaLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}

	public String findPerfilxRegistro(String registro) {
		SessionPermisoPerfilLocal aSessionPermisoPerfilLocal = createSessionPermisoPerfilLocal();
		return aSessionPermisoPerfilLocal.findPerfilxRegistro(registro);
	}

	public DataTable findEtiquetasSegmentos(DataTable tablaBase) {

		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.findEtiquetasSegmentos(tablaBase);

	}
	
	public String[] listaEtiquetasPorCodigo(String codigo) {

		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.listaEtiquetasPorCodigo(codigo);

	}

	public Vector findEtiquetas() {

		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.findEtiquetas();

	}

	public int findCantidadSegmentos() {

		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.findCantidadSegmentos();

	}

	public Vector findGestorxRegistro(String registro, String codTerritorio,
			String codOficina) {

		SessionGestorLocal aSessionGestorLocal = createSessionGestorLocal();
		return aSessionGestorLocal.findGestorxRegistro(registro, codTerritorio,
				codOficina);

	}

	public Vector findEtiSeg(String codMult, String codElem) {

		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.findEtiSeg(codMult, codElem);

	}

	public Vector findNV(String codMult, String codElem) {

		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.findNV(codMult, codElem);

	}

	public Vector findFamilias() {

		SessionMultitablaLocal aSessionMultitablaLocal = createSessionMultitablaLocal();
		return aSessionMultitablaLocal.findFamilias();
	}
	
	public boolean deleteTotales(){
		SessionCargaLocal aSessionLocal = createSessionCargaLocal();
		return aSessionLocal.deleteTotales();
	}
    
    public boolean deleteClientes(){
		SessionCargaLocal aSessionLocal = createSessionCargaLocal();
		return aSessionLocal.deleteClientes();
	}
    
    public boolean deleteGestores(){
		SessionCargaLocal aSessionLocal = createSessionCargaLocal();
		return aSessionLocal.deleteGestores();
	}
    
    public boolean deleteOficinas(){
		SessionCargaLocal aSessionLocal = createSessionCargaLocal();
		return aSessionLocal.deleteOficinas();
	}
	
	public boolean deleteTerritorios(){
		SessionCargaLocal aSessionLocal = createSessionCargaLocal();
		return aSessionLocal.deleteTerritorios();
	}
	
	public boolean deleteAreas(){
		SessionCargaLocal aSessionLocal = createSessionCargaLocal();
		return aSessionLocal.deleteAreas();
	}
	
	public boolean deleteEmpresas(){
		SessionCargaLocal aSessionLocal = createSessionCargaLocal();
		return aSessionLocal.deleteEmpresas();
	}
	

	
	public int countCliente(){
		SessionClienteLocal aSessionLocal = createSessionClienteLocal();
		return aSessionLocal.countCliente();
	}
	
    public int countClientebyTerritorio(String cod_territorio){
		SessionClienteLocal aSessionLocal = createSessionClienteLocal();
		return aSessionLocal.countClientebyTerritorio(cod_territorio);
	}
    
    public int countClientebyOficina(String cod_territorio, String cod_oficina){
		SessionClienteLocal aSessionLocal = createSessionClienteLocal();
		return aSessionLocal.countClientebyOficina(cod_territorio,cod_oficina);
	}
    
	public int countClientebyGestor(String cod_territorio, String cod_oficina, String cod_gestor) {
		SessionClienteLocal aSessionLocal = createSessionClienteLocal();
		return aSessionLocal.countClientebyGestor(cod_territorio,cod_oficina,cod_gestor);
	}
	
	public Territorio datosTerritorio(String codigo) {
		SessionTerritorioLocal aSessionLocal = createSessionTerritorioLocal();
		return aSessionLocal.datosTerritorio(codigo);
	}
	
	public Oficina datosOficina(String codigo) {
		SessionOficinaLocal aSessionLocal = createSessionOficinaLocal();
		return aSessionLocal.datosOficina(codigo);
	}
	
	public Gestor datosGestor(String codigo) {
		SessionGestorLocal aSessionLocal = createSessionGestorLocal();
		return aSessionLocal.datosGestor(codigo);
	}
	
	public Empresa datosEmpresa(String codigo) {
		SessionEmpresaLocal aSessionLocal = createSessionEmpresaLocal();
		return aSessionLocal.datosEmpresa(codigo);
	}
	
	public String findGestorMasaOficina(String cod_oficina){
		SessionGestorLocal aSessionLocal = createSessionGestorLocal();
		return aSessionLocal.findGestorMasaOficina(cod_oficina);
	}
}
