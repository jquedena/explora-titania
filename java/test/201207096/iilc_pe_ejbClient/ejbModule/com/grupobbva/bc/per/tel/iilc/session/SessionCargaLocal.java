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
 * Local interface for Enterprise Bean: SessionCarga
 */
public interface SessionCargaLocal extends javax.ejb.EJBLocalObject {
	public boolean createCliente(Cliente cliente);
	public boolean createTotal(Total total);
	public boolean createArea(Area area);
	public boolean createOficina(Oficina oficina);
	public boolean createGestor(Gestor gestor);
	public boolean createMultitabla(Multitabla multitabla);
	public boolean createPerfil(Perfil perfil);
	public boolean createPermisoPerfil(PermisoPerfil permisoPerfil);
	public boolean createTerritorio(Territorio territorio)
		throws javax.ejb.CreateException;
    public boolean createEmpresa(Empresa empresa);
	public boolean deleteTerritorios();
	public boolean deleteAreas();
	public boolean deleteGestores();
	public boolean deleteClientes();
	public boolean deleteOficinas();
	public boolean deleteTotales();
	public boolean deleteEmpresas();
}
