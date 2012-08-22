package com.grupobbva.bc.per.tele.sdo.sesionws;
/**
 * Home interface for Enterprise Bean: SesionWS
 */
public interface SesionWSHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: SesionWS
	 */
	public com.grupobbva.bc.per.tele.sdo.sesionws.SesionWS create()
		throws javax.ejb.CreateException,
		java.rmi.RemoteException;
}
