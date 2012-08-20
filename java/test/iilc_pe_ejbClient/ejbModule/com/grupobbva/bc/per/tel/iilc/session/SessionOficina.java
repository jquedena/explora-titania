package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
/**
 * Remote interface for Enterprise Bean: SessionOficina
 */
public interface SessionOficina extends javax.ejb.EJBObject {
    public Vector findAllOficinaxTe(String cod_area, String cod_territorio)
        throws FinderException,
        java.rmi.RemoteException;
	public Oficina datosOficina(String codigo) throws java.rmi.RemoteException;
	/**
	 * @param cod_territorio
	 * @return
	 * @throws FinderException
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Oficina> findAllOficinaxTerr(String cod_territorio)
			throws FinderException, java.rmi.RemoteException;
}
