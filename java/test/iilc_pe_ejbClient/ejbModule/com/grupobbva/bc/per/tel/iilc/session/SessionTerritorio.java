package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
/**
 * Remote interface for Enterprise Bean: SessionTerritorio
 */
public interface SessionTerritorio extends javax.ejb.EJBObject {
    public Territorio datosTerritorio(String codigo)
		throws java.rmi.RemoteException;

	/**
	 * @param cod_area
	 * @return
	 * @throws FinderException
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Territorio> findAllTerritorio(String cod_area)
			throws FinderException, java.rmi.RemoteException;
}
