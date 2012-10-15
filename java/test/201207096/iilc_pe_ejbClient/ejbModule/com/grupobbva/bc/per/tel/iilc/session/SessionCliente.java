package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
/**
 * Remote interface for Enterprise Bean: SessionCliente
 */
public interface SessionCliente extends javax.ejb.EJBObject {
    public Cliente findCliente(int cod_cliente)
        throws FinderException,
        java.rmi.RemoteException;
	public boolean deleteCliente(int cod_cliente)
		throws java.rmi.RemoteException;
	public int countClientebyGestor(
		String cod_territorio,
		String cod_oficina,
		String cod_gestor) throws java.rmi.RemoteException;
	public int countCliente() throws java.rmi.RemoteException;
	public int countClientebyTerritorio(String cod_territorio)
		throws java.rmi.RemoteException;
	public int countClientebyOficina(String cod_territorio, String cod_oficina)
		throws java.rmi.RemoteException;
}
