package com.grupobbva.bc.per.tel.iilc.session;
import java.util.Vector;

import javax.ejb.FinderException;

import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;
/**
 * Remote interface for Enterprise Bean: SessionPermisoPerfil
 */
public interface SessionPermisoPerfil extends javax.ejb.EJBObject {
	public PermisoPerfil findComponente(
		String codReg,
		String codCat,
		String path) throws FinderException, java.rmi.RemoteException;
	public Vector findAllPerfil()
		throws FinderException,
		java.rmi.RemoteException;
	public Vector findAllPermisoPerfil()
		throws FinderException,
		java.rmi.RemoteException;
	public Perfil findPerfil(String cod_perfil) throws java.rmi.RemoteException;
	public PermisoPerfil findPermisoPerfil(
		String cod_perfil,
		int tipo_acceso,
		String valor_rcp) throws java.rmi.RemoteException;
	public boolean deletePerfil(String cod_perfil)
		throws java.rmi.RemoteException;
	public boolean updatePerfil(Perfil perfil) throws java.rmi.RemoteException;
	public boolean deletePermisoPerfil(
		String cod_perfil,
		int tipo_acceso,
		String valor_rcp) throws java.rmi.RemoteException;
	public String findPerfilxRegistro(String registro)
		throws java.rmi.RemoteException;
}
