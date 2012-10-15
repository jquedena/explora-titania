package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
/**
 * Local interface for Enterprise Bean: SessionCliente
 */
public interface SessionClienteLocal extends javax.ejb.EJBLocalObject {
	public Cliente findCliente(int cod_cliente) throws FinderException;
	public boolean deleteCliente(int cod_cliente);
	public int countClientebyGestor(
		String cod_territorio,
		String cod_oficina,
		String cod_gestor);
	public int countCliente();
	public int countClientebyTerritorio(String cod_territorio);
	public int countClientebyOficina(String cod_territorio, String cod_oficina);
}
