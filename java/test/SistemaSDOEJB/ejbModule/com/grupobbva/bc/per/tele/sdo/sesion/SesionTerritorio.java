package com.grupobbva.bc.per.tele.sdo.sesion;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import java.util.Vector;
/**
 * Remote interface for Enterprise Bean: SesionTerritorio
 */
public interface SesionTerritorio extends javax.ejb.EJBObject {
	public Territorio findByCodTerritorio(String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector findAllTerritorio() throws java.rmi.RemoteException;
	
	//	OSCAR CORTEZ - BUSCAR TODOS LOS TERRITORIOS
	public Vector busAllTerritorio() throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - MODIFICAR TERRITORIOS

	//	OSCAR CORTEZ - BUSCAR TERRITORIO X CODIGO
	public Vector busTerritorioxCod(String codTerritorio)
		throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - BUSCAR TERRITORIO X CODIGO

	//	OSCAR CORTEZ - ELIMINAR TERRITORIO
	public Vector eliminarTerritorio(String codTerritorio)
		throws java.rmi.RemoteException;
	
	
	//FIN - OSCAR CORTEZ - ELIMINAR TERRITORIO

	//INICIO - OSCAR CORTEZ - busTerritorioxRegistroLDAP
	public Vector busTerritorioxRegistroLDAP(String codGestor)
		throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - BUSCAR TODOS LOS TERRITORIOS

	public Vector busAllTerritorioActivo() throws java.rmi.RemoteException;
	public void editarMensajeTerritorio(
		String codTerritorio,
		String mensaje,
		String colorFondo) throws java.rmi.RemoteException;
	//	OSCAR CORTEZ - CREAR NUEVOS TERRITORIOS
	public Vector nuevoTerritorio(
		String codTerritorio,
		String nomTerritorio,
		String mensaje,
		String colorFondo,
		String usuario) throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - CREAR NUEVOS TERRITORIOS

	//	OSCAR CORTEZ - MODIFICAR TERRITORIOS
	public Vector modificarTerritorio(
		String codTerritorio,
		String nomTerritorio,
		String estado,
		String mensaje,
		String colorFondo,
		String usuario) throws java.rmi.RemoteException;
}
