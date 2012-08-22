package com.grupobbva.bc.per.tele.sdo.sesion;
import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;
/**
 * Remote interface for Enterprise Bean: SesionEquivalencias
 */
public interface SesionEquivalencias extends javax.ejb.EJBObject {
	public Equivalencia findEquivalenciaByCodCargo(String codCargo)
		throws java.rmi.RemoteException;
	public Vector findAllEquivalencias() throws java.rmi.RemoteException;
	public boolean updateEquivalencia(Equivalencia equivalencia) throws java.rmi.RemoteException;
	public boolean deleteEquivalencia(String cod_cargo)
	throws java.rmi.RemoteException;
	public boolean createEquivalencia(Equivalencia equivalencia) throws java.rmi.RemoteException;
}
