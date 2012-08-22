package com.grupobbva.bc.per.tele.sdo.sesion;
import java.util.Vector;
import com.grupobbva.bc.per.tele.sdo.serializable.Menu;
/**
 * Remote interface for Enterprise Bean: SesionMenu
 */
public interface SesionMenu extends javax.ejb.EJBObject {
	public Vector findxCodPerfil(String codPerfil)
		throws java.rmi.RemoteException;
	public Menu findxIdMenu(String padre) throws java.rmi.RemoteException;
	public boolean updateMenu(Menu menu) throws java.rmi.RemoteException;
	public boolean deleteMenu(String padre) throws java.rmi.RemoteException;
	public boolean createMenu(Menu menu) throws java.rmi.RemoteException;
	public Vector findAllMenu() throws java.rmi.RemoteException;
}
