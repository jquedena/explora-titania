package com.grupobbva.bc.per.tele.sdo.sesion;
import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;
import java.util.Vector;
/**
 * Remote interface for Enterprise Bean: SesionPermisoPerfil
 */
public interface SesionPermisoPerfil extends javax.ejb.EJBObject {
	public PermisoPerfil findPermisoPerfilxTipAccxValorRCP(
		String codReg,
		String codCat,
		String path) throws java.rmi.RemoteException;
	public Vector findAllPermisoPerfil() throws java.rmi.RemoteException;
	public PermisoPerfil findPermisoPerfilById(
		String codPerfil,
		String tipoAcceso,
		String valorRCP) throws java.rmi.RemoteException;
	public boolean deletePermisoPerfil(
		String codPerfil,
		String tipoAcceso,
		String valorRCP) throws java.rmi.RemoteException;
	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil)
		throws java.rmi.RemoteException;
	public boolean updatePermisoPerfil(
		PermisoPerfil origPermisoPerfil,
		PermisoPerfil nuevoPermisoPerfil) throws java.rmi.RemoteException;
	public int registrarPermisoPerfil(PermisoPerfil permisoPerfil)
		throws java.rmi.RemoteException;
}
