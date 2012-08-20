package com.grupobbva.bc.per.tel.iilc.session;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
/**
 * Remote interface for Enterprise Bean: SessionEmpresa
 */
public interface SessionEmpresa extends javax.ejb.EJBObject {
	public Empresa datosEmpresa(String codigo) throws java.rmi.RemoteException;
}
