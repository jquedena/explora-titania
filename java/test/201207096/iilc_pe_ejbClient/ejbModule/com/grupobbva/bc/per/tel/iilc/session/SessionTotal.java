package com.grupobbva.bc.per.tel.iilc.session;

import javax.ejb.FinderException;

import com.grupobbva.bc.per.tel.iilc.serializable.Total;

/**
 * Remote interface for Enterprise Bean: SessionTotal
 */
public interface SessionTotal extends javax.ejb.EJBObject {
    public Total findTotal(String ind_registro, String cod_territorio, String cod_oficina, String cod_gestor)
    throws FinderException,
    java.rmi.RemoteException;
}
