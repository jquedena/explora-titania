package com.grupobbva.bc.per.tel.iilc.session;

import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

/**
 * SessionServiceAccessBean
 * @generated
 */
public class SessionServiceAccessBean extends AbstractSessionAccessBean {

	/**
	 * @generated
	 */
	private SessionService __ejbRef;

	/**
	 * SessionServiceAccessBean
	 * @generated
	 */
	public SessionServiceAccessBean() {
		super();
	}

	/**
	 * SessionServiceAccessBean
	 * @generated
	 */
	public SessionServiceAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}

	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionServiceHome";
	}

	/**
	 * ejbHome
	 * @generated
	 */
	private com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome ejbHome()
		throws java.rmi.RemoteException,
		javax.naming.NamingException {
		return (com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome) PortableRemoteObject
			.narrow(
				getHome(),
				com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome.class);
	}

	/**
	 * ejbRef
	 * @generated
	 */
	private com.grupobbva.bc.per.tel.iilc.session.SessionService ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef = (com.grupobbva.bc.per.tel.iilc.session.SessionService) PortableRemoteObject
				.narrow(
					ejbRef,
					com.grupobbva.bc.per.tel.iilc.session.SessionService.class);

		return __ejbRef;
	}

	/**
	 * instantiateEJB
	 * @generated
	 */
	protected void instantiateEJB()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		if (ejbRef() != null)
			return;

		ejbRef = ejbHome().create();
	}

	/**
	 * findPermisoPerfil
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil findPermisoPerfil(
		java.lang.String cod_perfil,
		int tipo_acceso,
		java.lang.String valor_rcp)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findPermisoPerfil(cod_perfil, tipo_acceso, valor_rcp);
	}

	/**
	 * findAllEmpresa
	 * @generated
	 */
	public java.util.Vector findAllEmpresa()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findAllEmpresa();
	}

	/**
	 * listaDetalleFiltroComplejo
	 * @generated
	 */
	public java.util.Vector listaDetalleFiltroComplejo(
		java.lang.String tipo,
		java.lang.String tipo2,
		java.lang.String[] codigos)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().listaDetalleFiltroComplejo(tipo, tipo2, codigos);
	}

	/**
	 * deleteTerritorios
	 * @generated
	 */
	public boolean deleteTerritorios()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteTerritorios();
	}

	/**
	 * deleteClientes
	 * @generated
	 */
	public boolean deleteClientes()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteClientes();
	}

	/**
	 * createEmpresa
	 * @generated
	 */
	public boolean createEmpresa(
		com.grupobbva.bc.per.tel.iilc.serializable.Empresa empresa)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createEmpresa(empresa);
	}

	/**
	 * deleteTotales
	 * @generated
	 */
	public boolean deleteTotales()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteTotales();
	}

	/**
	 * findGestorMasaOficina
	 * @generated
	 */
	public java.lang.String findGestorMasaOficina(java.lang.String cod_oficina)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findGestorMasaOficina(cod_oficina);
	}

	/**
	 * datosEmpresa
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Empresa datosEmpresa(
		java.lang.String codigo)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().datosEmpresa(codigo);
	}

	/**
	 * datosOficina
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Oficina datosOficina(
		java.lang.String codigo)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().datosOficina(codigo);
	}

	/**
	 * findGestorxRegistro
	 * @generated
	 */
	public java.util.Vector findGestorxRegistro(
		java.lang.String registro,
		java.lang.String codTerritorio,
		java.lang.String codOficina)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef()
			.findGestorxRegistro(registro, codTerritorio, codOficina);
	}

	/**
	 * createMultitabla
	 * @generated
	 */
	public boolean createMultitabla(
		com.grupobbva.bc.per.tel.iilc.serializable.Multitabla multitabla)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createMultitabla(multitabla);
	}

	/**
	 * findEtiSeg
	 * @generated
	 */
	public java.util.Vector findEtiSeg(
		java.lang.String codMult,
		java.lang.String codElem)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findEtiSeg(codMult, codElem);
	}

	/**
	 * findAllPerfil
	 * @generated
	 */
	public java.util.Vector findAllPerfil()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findAllPerfil();
	}

	/**
	 * findAllRecord
	 * @generated
	 */
	public java.util.Vector findAllRecord(java.lang.String cod_mult)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findAllRecord(cod_mult);
	}

	/**
	 * deleteEmpresas
	 * @generated
	 */
	public boolean deleteEmpresas()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteEmpresas();
	}

	/**
	 * createArea
	 * @generated
	 */
	public boolean createArea(
		com.grupobbva.bc.per.tel.iilc.serializable.Area area)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createArea(area);
	}

	/**
	 * deleteGestores
	 * @generated
	 */
	public boolean deleteGestores()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteGestores();
	}

	/**
	 * findCantidadSegmentos
	 * @generated
	 */
	public int findCantidadSegmentos()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findCantidadSegmentos();
	}

	/**
	 * findFamilias
	 * @generated
	 */
	public java.util.Vector findFamilias()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findFamilias();
	}

	/**
	 * findNV
	 * @generated
	 */
	public java.util.Vector findNV(
		java.lang.String codMult,
		java.lang.String codElem)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findNV(codMult, codElem);
	}

	/**
	 * findRecord
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Multitabla findRecord(
		java.lang.String codigo)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findRecord(codigo);
	}

	/**
	 * createCliente
	 * @generated
	 */
	public boolean createCliente(
		com.grupobbva.bc.per.tel.iilc.serializable.Cliente cliente)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createCliente(cliente);
	}

	/**
	 * findEtiquetas
	 * @generated
	 */
	public java.util.Vector findEtiquetas()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findEtiquetas();
	}

	/**
	 * createTerritorio
	 * @generated
	 */
	public boolean createTerritorio(
		com.grupobbva.bc.per.tel.iilc.serializable.Territorio territorio)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createTerritorio(territorio);
	}

	/**
	 * findEtiquetasSegmentos
	 * @generated
	 */
	public com.stefanini.pe.framework.collections.DataTable findEtiquetasSegmentos(
		com.stefanini.pe.framework.collections.DataTable tablaBase)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findEtiquetasSegmentos(tablaBase);
	}

	/**
	 * countCliente
	 * @generated
	 */
	public int countCliente()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().countCliente();
	}

	/**
	 * updatePerfil
	 * @generated
	 */
	public boolean updatePerfil(
		com.grupobbva.bc.per.tel.iilc.serializable.Perfil perfil)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().updatePerfil(perfil);
	}

	/**
	 * createGestor
	 * @generated
	 */
	public boolean createGestor(
		com.grupobbva.bc.per.tel.iilc.serializable.Gestor gestor)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createGestor(gestor);
	}

	/**
	 * deleteAllGestor
	 * @generated
	 */
	public boolean deleteAllGestor(java.lang.String cod_area)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteAllGestor(cod_area);
	}
	

	

	/**
	 * listaDetalleFiltroSimple
	 * @generated
	 */
	public java.util.Vector listaDetalleFiltroSimple(
		java.lang.String tipo,
		java.lang.String[] codigos)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().listaDetalleFiltroSimple(tipo, codigos);
	}

	/**
	 * findMultitablaxValor2
	 * @generated
	 */
	public java.util.Vector findMultitablaxValor2(java.lang.String valor2)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findMultitablaxValor2(valor2);
	}

	/**
	 * findAllPermisoPerfil
	 * @generated
	 */
	public java.util.Vector findAllPermisoPerfil()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findAllPermisoPerfil();
	}

	/**
	 * findAllMultitabla
	 * @generated
	 */
	public java.util.Vector findAllMultitabla()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findAllMultitabla();
	}

	/**
	 * findTotal
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Total findTotal(
		java.lang.String ind_registro,
		java.lang.String cod_territorio,
		java.lang.String cod_oficina,
		java.lang.String cod_gestor)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findTotal(
			ind_registro,
			cod_territorio,
			cod_oficina,
			cod_gestor);
	}

	/**
	 * countClientebyOficina
	 * @generated
	 */
	public int countClientebyOficina(
		java.lang.String cod_territorio,
		java.lang.String cod_oficina)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().countClientebyOficina(cod_territorio, cod_oficina);
	}

	/**
	 * findAllGestorxOfxTe
	 * @generated
	 */
	public java.util.Vector findAllGestorxOfxTe(
		java.lang.String cod_area,
		java.lang.String cod_territorio,
		java.lang.String cod_oficina)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findAllGestorxOfxTe(
			cod_area,
			cod_territorio,
			cod_oficina);
	}

	/**
	 * findATOG
	 * @generated
	 */
	public java.util.Vector findATOG(java.lang.String cod_usuario)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findATOG(cod_usuario);
	}

	/**
	 * findPerfilxRegistro
	 * @generated
	 */
	public java.lang.String findPerfilxRegistro(java.lang.String registro)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findPerfilxRegistro(registro);
	}

	/**
	 * countClientebyTerritorio
	 * @generated
	 */
	public int countClientebyTerritorio(java.lang.String cod_territorio)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().countClientebyTerritorio(cod_territorio);
	}

	/**
	 * createPermisoPerfil
	 * @generated
	 */
	public boolean createPermisoPerfil(
		com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil permisoPerfil)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createPermisoPerfil(permisoPerfil);
	}

	/**
	 * createOficina
	 * @generated
	 */
	public boolean createOficina(
		com.grupobbva.bc.per.tel.iilc.serializable.Oficina oficina)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createOficina(oficina);
	}

	/**
	 * deleteMultitabla
	 * @generated
	 */
	public boolean deleteMultitabla(
		java.lang.String cod_mult,
		java.lang.String cod_ele)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteMultitabla(cod_mult, cod_ele);
	}

	/**
	 * listaEtiquetasPorCodigo
	 * @generated
	 */
	public java.lang.String[] listaEtiquetasPorCodigo(java.lang.String codigo)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().listaEtiquetasPorCodigo(codigo);
	}

	/**
	 * deletePerfil
	 * @generated
	 */
	public boolean deletePerfil(java.lang.String cod_perfil)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deletePerfil(cod_perfil);
	}

	/**
	 * deleteCliente
	 * @generated
	 */
	public boolean deleteCliente(int cod_cliente)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteCliente(cod_cliente);
	}

	/**
	 * deleteOficinas
	 * @generated
	 */
	public boolean deleteOficinas()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteOficinas();
	}

	/**
	 * createPerfil
	 * @generated
	 */
	public boolean createPerfil(
		com.grupobbva.bc.per.tel.iilc.serializable.Perfil perfil)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createPerfil(perfil);
	}

	/**
	 * deleteAreas
	 * @generated
	 */
	public boolean deleteAreas()
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deleteAreas();
	}

	/**
	 * findAllOficinaxTe
	 * @generated
	 */
	public java.util.Vector findAllOficinaxTe(
		java.lang.String cod_area,
		java.lang.String cod_territorio)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findAllOficinaxTe(cod_area, cod_territorio);
	}

	/**
	 * countClientebyGestor
	 * @generated
	 */
	public int countClientebyGestor(
		java.lang.String cod_territorio,
		java.lang.String cod_oficina,
		java.lang.String cod_gestor)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().countClientebyGestor(
			cod_territorio,
			cod_oficina,
			cod_gestor);
	}

	/**
	 * findPerfil
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Perfil findPerfil(
		java.lang.String cod_perfil)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findPerfil(cod_perfil);
	}

	/**
	 * findCliente
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Cliente findCliente(
		int cod_cliente)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findCliente(cod_cliente);
	}

	/**
	 * updateMultitabla
	 * @generated
	 */
	public boolean updateMultitabla(
		com.grupobbva.bc.per.tel.iilc.serializable.Multitabla multitabla)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().updateMultitabla(multitabla);
	}

	/**
	 * createTotal
	 * @generated
	 */
	public boolean createTotal(
		com.grupobbva.bc.per.tel.iilc.serializable.Total total)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().createTotal(total);
	}

	/**
	 * findAllTerritorio
	 * @generated
	 */
	public java.util.Vector findAllTerritorio(java.lang.String cod_area)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findAllTerritorio(cod_area);
	}

	/**
	 * deletePermisoPerfil
	 * @generated
	 */
	public boolean deletePermisoPerfil(
		java.lang.String cod_perfil,
		int tipo_acceso,
		java.lang.String valor_rcp)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().deletePermisoPerfil(cod_perfil, tipo_acceso, valor_rcp);
	}

	/**
	 * datosGestor
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Gestor datosGestor(
		java.lang.String codigo)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().datosGestor(codigo);
	}

	/**
	 * findMultitabla
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Multitabla findMultitabla(
		java.lang.String cod_mult,
		java.lang.String cod_ele)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findMultitabla(cod_mult, cod_ele);
	}

	/**
	 * datosTerritorio
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Territorio datosTerritorio(
		java.lang.String codigo)
		throws javax.naming.NamingException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().datosTerritorio(codigo);
	}

	/**
	 * findComponente
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil findComponente(
		java.lang.String codReg,
		java.lang.String codCat,
		java.lang.String path)
		throws javax.naming.NamingException,
		javax.ejb.FinderException,
		javax.ejb.CreateException,
		java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().findComponente(codReg, codCat, path);
	}
}
