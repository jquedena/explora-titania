package com.grupobbva.bc.per.tel.iilc.session;
import com.grupobbva.bc.per.tel.iilc.serializable.Area;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
import com.grupobbva.bc.per.tel.iilc.serializable.Total;
/**
 * Remote interface for Enterprise Bean: SessionCarga
 */
public interface SessionCarga extends javax.ejb.EJBObject {
	public boolean createCliente(Cliente cliente)
		throws java.rmi.RemoteException;
	public boolean createTotal(Total total) throws java.rmi.RemoteException;
	public boolean createArea(Area area) throws java.rmi.RemoteException;
	public boolean createOficina(Oficina oficina)
		throws java.rmi.RemoteException;
	public boolean createGestor(Gestor gestor) throws java.rmi.RemoteException;
	public boolean createMultitabla(Multitabla multitabla)
		throws java.rmi.RemoteException;
	public boolean createPerfil(Perfil perfil) throws java.rmi.RemoteException;
	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil)
		throws java.rmi.RemoteException;
	public boolean createTerritorio(Territorio territorio)
		throws javax.ejb.CreateException,
		java.rmi.RemoteException;
    public boolean createEmpresa(Empresa empresa)
        throws java.rmi.RemoteException;
	public boolean deleteTerritorios() throws java.rmi.RemoteException;
	public boolean deleteAreas() throws java.rmi.RemoteException;
	public boolean deleteGestores() throws java.rmi.RemoteException;
	public boolean deleteClientes() throws java.rmi.RemoteException;
	public boolean deleteOficinas() throws java.rmi.RemoteException;
	public boolean deleteTotales() throws java.rmi.RemoteException;
	public boolean deleteEmpresas() throws java.rmi.RemoteException;
}
