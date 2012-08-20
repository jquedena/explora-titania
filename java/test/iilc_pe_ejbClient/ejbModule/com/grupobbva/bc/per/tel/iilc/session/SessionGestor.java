package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
/**
 * Remote interface for Enterprise Bean: SessionGestor
 */
public interface SessionGestor extends javax.ejb.EJBObject {
    public boolean deleteAllGestor(String cod_area)
		throws java.rmi.RemoteException;
	//	OSCAR CORTEZ - Gestor x Registro
	public Vector findGestorxRegistro(
		String registro,
		String codTerritorio,
		String codOficina) throws java.rmi.RemoteException;
	public Gestor datosGestor(String codigo) throws java.rmi.RemoteException;
	/**
	 * @param cod_usuario
	 * @return
	 * @throws FinderException
	 * @throws java.rmi.RemoteException
	 */
	public Vector<String> findATOG(String cod_usuario) throws FinderException,
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
