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
 * Local interface for Enterprise Bean: SessionService
 */
public interface SessionServiceLocal extends javax.ejb.EJBLocalObject {
	public boolean createCliente(Cliente cliente);
	public boolean createTotal(Total total);
	public Cliente findCliente(int cod_cliente) throws FinderException;
	public Vector findAllRecord(String cod_mult) throws FinderException;
	public Multitabla findRecord(String codigo) throws FinderException;
	public Vector findMultitablaxValor2(String valor2) throws FinderException;
	public Total findTotal(
		String ind_registro,
		String cod_territorio,
		String cod_oficina,
		String cod_gestor) throws FinderException;
	public PermisoPerfil findComponente(
		String codReg,
		String codCat,
		String path) throws FinderException;
	public boolean createArea(Area area);
	public boolean createOficina(Oficina oficina);
	public boolean createGestor(Gestor gestor);
	public Vector findAllMultitabla();
	public Vector findAllPerfil();
	public Vector findAllPermisoPerfil();
	public boolean createMultitabla(Multitabla multitabla);
	public boolean createPerfil(Perfil perfil);
	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil);
	public Perfil findPerfil(String cod_perfil);
	public PermisoPerfil findPermisoPerfil(
		String cod_perfil,
		int tipo_acceso,
		String valor_rcp);
	public Multitabla findMultitabla(String cod_mult, String cod_ele);
	public boolean deleteMultitabla(String cod_mult, String cod_ele);
	public boolean deletePerfil(String cod_perfil);
	public boolean updateMultitabla(Multitabla multitabla);
	public boolean updatePerfil(Perfil perfil);
	public boolean deletePermisoPerfil(
		String cod_perfil,
		int tipo_acceso,
		String valor_rcp);
	public boolean createTerritorio(Territorio territorio)
		throws javax.ejb.CreateException;
	public boolean deleteAllGestor(String cod_area);
	public boolean deleteCliente(int cod_cliente);
    public Vector findAllEmpresa();
    public boolean createEmpresa(Empresa empresa);
	public String findPerfilxRegistro(String registro);
	public Vector findEtiquetas();
	public DataTable findEtiquetasSegmentos(DataTable tablaBase);
	public int findCantidadSegmentos();
	public Vector findGestorxRegistro(
		String registro,
		String codTerritorio,
		String codOficina);
	public Vector findEtiSeg(String codMult, String codElem);
	public Vector findNV(String codMult, String codElem);
	public Vector findFamilias();
	public String[] listaEtiquetasPorCodigo(String codigo);
	public Vector listaDetalleFiltroSimple(String tipo, String[] codigos);
	public Vector listaDetalleFiltroComplejo(
		String tipo,
		String tipo2,
		String[] codigos);
	public boolean deleteTotales();
	public boolean deleteClientes();
	public boolean deleteGestores();
	public boolean deleteOficinas();
	public boolean deleteTerritorios();
	public boolean deleteAreas();
	public boolean deleteEmpresas();
	public int countCliente();
	public int countClientebyTerritorio(String cod_territorio);
	public int countClientebyOficina(String cod_territorio, String cod_oficina);
	public int countClientebyGestor(
		String cod_territorio,
		String cod_oficina,
		String cod_gestor);
	public Territorio datosTerritorio(String codigo);
	public Gestor datosGestor(String codigo);
	public Oficina datosOficina(String codigo);
	public Empresa datosEmpresa(String codigo);
	/**
	 * @param cod_area
	 * @return
	 * @throws FinderException
	 */
	public Vector<Territorio> findAllTerritorio(String cod_area)
			throws FinderException;
	/**
	 * @param cod_usuario
	 * @return
	 * @throws FinderException
	 */
	public Vector<String> findATOG(String cod_usuario) throws FinderException;
	/**
	 * @param cod_area
	 * @param cod_territorio
	 * @return
	 * @throws FinderException
	 */
	public Vector<Oficina> findAllOficinaxTe(String cod_area,
			String cod_territorio) throws FinderException;
	/**
	 * @param cod_oficina
	 * @return
	 */
	public String findGestorMasaOficina(String cod_oficina);
	/**
	 * @param cod_area
	 * @param cod_territorio
	 * @param cod_oficina
	 * @return
	 * @throws FinderException
	 */
	public Vector<Gestor> findAllGestorxOfxTe(String cod_area,
			String cod_territorio, String cod_oficina) throws FinderException;
}
