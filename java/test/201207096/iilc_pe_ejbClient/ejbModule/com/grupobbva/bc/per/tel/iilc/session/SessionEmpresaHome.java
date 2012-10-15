package com.grupobbva.bc.per.tel.iilc.session;
/**
 * Home interface for Enterprise Bean: SessionEmpresa
 */
public interface SessionEmpresaHome extends javax.ejb.EJBHome {
    /**
     * Creates a default instance of Session Bean: SessionEmpresa
     */
    public com.grupobbva.bc.per.tel.iilc.session.SessionEmpresa create()
        throws javax.ejb.CreateException,
        java.rmi.RemoteException;
}
