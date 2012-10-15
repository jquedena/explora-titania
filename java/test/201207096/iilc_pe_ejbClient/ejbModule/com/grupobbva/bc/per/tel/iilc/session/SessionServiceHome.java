package com.grupobbva.bc.per.tel.iilc.session;
/**
 * Home interface for Enterprise Bean: SessionService
 */
public interface SessionServiceHome extends javax.ejb.EJBHome {
    /**
     * Creates a default instance of Session Bean: SessionService
     */
    public com.grupobbva.bc.per.tel.iilc.session.SessionService create()
        throws javax.ejb.CreateException,
        java.rmi.RemoteException;
}
