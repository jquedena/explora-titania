package com.grupobbva.bc.per.tel.iilc.session;
import java.util.Vector;

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
import com.stefanini.pe.framework.collections.DataTable;
/**
 * Remote interface for Enterprise Bean: SessionService
 */
public interface SessionService extends javax.ejb.EJBObject {
	public boolean createCliente(Cliente cliente) throws java.rmi.RemoteException;
	public boolean createTotal(Total total) throws java.rmi.RemoteException;
	public Cliente findCliente(int cod_cliente)
		throws FinderException,
		java.rmi.RemoteException;
	public Vector findAllRecord(String cod_mult)
		throws FinderException,
		java.rmi.RemoteException;
	public Multitabla findRecord(String codigo)
		throws FinderException,
		java.rmi.RemoteException;
	public Vector findMultitablaxValor2(String valor2)
		throws FinderException,
		java.rmi.RemoteException;
	public Total findTotal(
		String ind_registro,
		String cod_territorio,
		String cod_oficina,
		String cod_gestor) throws FinderException, java.rmi.RemoteException;
	public PermisoPerfil findComponente(
		String codReg,
		String codCat,
		String path) throws FinderException, java.rmi.RemoteException;
	public boolean createArea(Area area) throws java.rmi.RemoteException;
	public boolean createOficina(Oficina oficina)
		throws java.rmi.RemoteException;
	public boolean createGestor(Gestor gestor) throws java.rmi.RemoteException;
	public Vector findAllMultitabla() throws java.rmi.RemoteException;
	public Vector findAllPerfil() throws java.rmi.RemoteException;
	public Vector findAllPermisoPerfil() throws java.rmi.RemoteException;
	public boolean createMultitabla(Multitabla multitabla)
		throws java.rmi.RemoteException;
	public boolean createPerfil(Perfil perfil) throws java.rmi.RemoteException;
	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil)
		throws java.rmi.RemoteException;
	public Perfil findPerfil(String cod_perfil) throws java.rmi.RemoteException;
	public PermisoPerfil findPermisoPerfil(
		String cod_perfil,
		int tipo_acceso,
		String valor_rcp) throws java.rmi.RemoteException;
	public Multitabla findMultitabla(String cod_mult, String cod_ele)
		throws java.rmi.RemoteException;
	public boolean deleteMultitabla(String cod_mult, String cod_ele)
		throws java.rmi.RemoteException;
	public boolean deletePerfil(String cod_perfil)
		throws java.rmi.RemoteException;
	public boolean deletePermisoPerfil(
		String cod_perfil,
		int tipo_acceso,
		String valor_rcp) throws java.rmi.RemoteException;
	public boolean updateMultitabla(Multitabla multitabla)
		throws java.rmi.RemoteException;
	public boolean updatePerfil(Perfil perfil) throws java.rmi.RemoteException;
	public boolean createTerritorio(Territorio territorio)
		throws javax.ejb.CreateException,
		java.rmi.RemoteException;
	public boolean deleteAllGestor(String cod_area)
		throws java.rmi.RemoteException;
	public boolean deleteCliente(int cod_cliente)
		throws java.rmi.RemoteException;
    public Vector findAllEmpresa() throws java.rmi.RemoteException;
    public boolean createEmpresa(Empresa empresa)
        throws java.rmi.RemoteException;
	public String findPerfilxRegistro(String registro)
		throws java.rmi.RemoteException;
	public Vector findEtiquetas() throws java.rmi.RemoteException;
	public DataTable findEtiquetasSegmentos(DataTable tablaBase)
		throws java.rmi.RemoteException;
	public int findCantidadSegmentos() throws java.rmi.RemoteException;
	public Vector findGestorxRegistro(
		String registro,
		String codTerritorio,
		String codOficina) throws java.rmi.RemoteException;
	public Vector findEtiSeg(String codMult, String codElem)
		throws java.rmi.RemoteException;
	public Vector findNV(String codMult, String codElem)
		throws java.rmi.RemoteException;
	public Vector findFamilias() throws java.rmi.RemoteException;
	public String[] listaEtiquetasPorCodigo(String codigo)
		throws java.rmi.RemoteException;
	public Vector listaDetalleFiltroSimple(String tipo, String[] codigos)
		throws java.rmi.RemoteException;
	public Vector listaDetalleFiltroComplejo(
		String tipo,
		String tipo2,
		String[] codigos) throws java.rmi.RemoteException;
	public boolean deleteTotales() throws java.rmi.RemoteException;
	public boolean deleteClientes() throws java.rmi.RemoteException;
	public boolean deleteGestores() throws java.rmi.RemoteException;
	public boolean deleteOficinas() throws java.rmi.RemoteException;
	public boolean deleteTerritorios() throws java.rmi.RemoteException;
	public boolean deleteAreas() throws java.rmi.RemoteException;
	public boolean deleteEmpresas() throws java.rmi.RemoteException;
	public int countCliente() throws java.rmi.RemoteException;
	public int countClientebyTerritorio(String cod_territorio)
		throws java.rmi.RemoteException;
	public int countClientebyOficina(String cod_territorio, String cod_oficina)
		throws java.rmi.RemoteException;
	public int countClientebyGestor(
		String cod_territorio,
		String cod_oficina,
		String cod_gestor) throws java.rmi.RemoteException;
	public Territorio datosTerritorio(String codigo)
		throws java.rmi.RemoteException;
	public Gestor datosGestor(String codigo) throws java.rmi.RemoteException;
	public Oficina datosOficina(String codigo) throws java.rmi.RemoteException;
	public Empresa datosEmpresa(String codigo) throws java.rmi.RemoteException;
	/**
	 * @param cod_area
	 * @return
	 * @throws FinderException
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Territorio> findAllTerritorio(String cod_area)
			throws FinderException, java.rmi.RemoteException;
	/**
	 * @param cod_usuario
	 * @return
	 * @throws FinderException
	 * @throws java.rmi.RemoteException
	 */
	public Vector<String> findATOG(String cod_usuario) throws FinderException,
			java.rmi.RemoteException;
	/**
	 * @param cod_area
	 * @param cod_territorio
	 * @return
	 * @throws FinderException
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Oficina> findAllOficinaxTe(String cod_area,
			String cod_territorio) throws FinderException,
			java.rmi.RemoteException;
	/**
	 * @param cod_oficina
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public String findGestorMasaOficina(String cod_oficina)
			throws java.rmi.RemoteException;
	/**
	 * @param cod_area
	 * @param cod_territorio
	 * @param cod_oficina
	 * @return
	 * @throws FinderException
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Gestor> findAllGestorxOfxTe(String cod_area,
			String cod_territorio, String cod_oficina) throws FinderException,
			java.rmi.RemoteException;
}
