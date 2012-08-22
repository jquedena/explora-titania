package com.grupobbva.bc.per.tele.sdo.sesion;

import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;
import java.util.Vector;

@SuppressWarnings("unchecked")
public interface SesionPerfiles extends javax.ejb.EJBObject {
	public Perfil findPerfil(String cod_perfil) throws java.rmi.RemoteException;
	public boolean updatePerfil(Perfil perfil) throws java.rmi.RemoteException;
	public Vector findAllPerfil() throws java.rmi.RemoteException;
	public boolean deletePerfil(String cod_perfil)
		throws java.rmi.RemoteException;
	public boolean createPerfil(Perfil perfil) throws java.rmi.RemoteException;
}
