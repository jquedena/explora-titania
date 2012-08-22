package com.grupobbva.bc.per.tele.sdo.sesion;
import java.util.Vector;
import com.grupobbva.bc.per.tele.sdo.serializable.Parametro;
/**
 * Remote interface for Enterprise Bean: SesionParametros
 */
public interface SesionParametros extends javax.ejb.EJBObject {
	public Vector findAllParametro() throws java.rmi.RemoteException;
	public Parametro findParametroAll() throws java.rmi.RemoteException;
}
