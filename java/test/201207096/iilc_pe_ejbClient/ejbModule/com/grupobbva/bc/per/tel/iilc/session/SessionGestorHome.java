package com.grupobbva.bc.per.tel.iilc.session;
/**
 * Home interface for Enterprise Bean: SessionGestor
 */
public interface SessionGestorHome extends javax.ejb.EJBHome {
    /**
     * Creates a default instance of Session Bean: SessionGestor
     */
    public com.grupobbva.bc.per.tel.iilc.session.SessionGestor create()
        throws javax.ejb.CreateException,
        java.rmi.RemoteException;
}
