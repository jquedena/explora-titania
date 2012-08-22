package com.grupobbva.bc.per.tele.sdo.sesion;

import java.util.Vector;

/**
 * Remote interface for Enterprise Bean: SesionCampanias
 */
public interface SesionCampanias extends javax.ejb.EJBObject {
	public int codigoCampMax() throws java.rmi.RemoteException;
	public Vector eliminarCampania(String codCamp)
		throws java.rmi.RemoteException;
	public Vector mostrarEditarCampania(String codCamp)
		throws java.rmi.RemoteException;
	public Vector busAnhosAcciones() throws java.rmi.RemoteException;
	public Vector busAnhoMaxAcciones() throws java.rmi.RemoteException;
	public Vector mostrarEsfuerzoCampania(
		String codGest,
		String mes,
		String anho,
		String codOficina) throws java.rmi.RemoteException;
	public int metasGestor(
		String codGestor,
		int anio,
		int mes,
		String codEpigrafe) throws java.rmi.RemoteException;
	public int metasOficina(
		String codOficina,
		int anio,
		int mes,
		String codEpigrafe) throws java.rmi.RemoteException;
	public Vector nuevaCampania(
		int codCamp,
		String nomCamp,
		String codOficicina,
		String codTerritorio,
		String codGestor,
		String anho,
		String mes,
		String orden,
		String get,
		String usuario,
		String codEpigrafe) throws java.rmi.RemoteException;
	public Vector editarCampania(
		String anho,
		String mes,
		String nomCamp,
		String orden,
		String codCamp,
		String usuario,
		String codEpigrafe) throws java.rmi.RemoteException;
}
