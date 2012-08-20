package com.grupobbva.bc.per.tel.iilc.session;
import java.util.List;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.EstadoCarga;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
/**
 * Remote interface for Enterprise Bean: SessionSQL
 */
public interface SessionSQL extends javax.ejb.EJBObject {
	public Cliente findTotalClientebyFilter(
		String cod_territorio,
		String cod_oficina,
		String cod_gestor,
		String nivel_vinculacion,
		String clasificacion,
		String margen,
		String etiqueta,
		String edad,
		String porcrie,
		String cod_empresa) throws java.rmi.RemoteException;
	public EstadoCarga ultimoEstadoCarga() throws java.rmi.RemoteException;
	/**
	 * @param cod_territorio
	 * @param cod_oficina
	 * @param cod_gestor
	 * @param nivel_vinculacion
	 * @param clasificacion
	 * @param margen
	 * @param etiqueta
	 * @param edad
	 * @param porcrie
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Empresa> findAllEmpresasbyFilter(String cod_territorio,
			String cod_oficina, String cod_gestor, String nivel_vinculacion,
			String clasificacion, String margen, String etiqueta, String edad,
			String porcrie) throws java.rmi.RemoteException;
	/**
	 * @param pos_ini
	 * @param pos_fin
	 * @param cod_territorio
	 * @param cod_oficina
	 * @param cod_gestor
	 * @param nivel_vinculacion
	 * @param clasificacion
	 * @param margen
	 * @param etiqueta
	 * @param edad
	 * @param porcrie
	 * @param cod_empresa
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Cliente> findAllClientebyFilter(int pos_ini, int pos_fin,
			String cod_territorio, String cod_oficina, String cod_gestor,
			String nivel_vinculacion, String clasificacion, String margen,
			String etiqueta, String edad, String porcrie, String cod_empresa, boolean pestanaTodos)
			throws java.rmi.RemoteException;
	
	
	public List findAllCabeceras(String codigo)
			throws java.rmi.RemoteException;
	 
	
}
