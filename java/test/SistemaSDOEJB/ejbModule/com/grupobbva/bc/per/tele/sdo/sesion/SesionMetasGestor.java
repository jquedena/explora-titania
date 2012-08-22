package com.grupobbva.bc.per.tele.sdo.sesion;
import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import java.util.HashMap;
import java.math.BigDecimal;
/**
 * Remote interface for Enterprise Bean: SesionMetasGestor
 */
@SuppressWarnings("unchecked")
public interface SesionMetasGestor extends javax.ejb.EJBObject {
	public MetasGestor findMetGestorByPrimaryKey(
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String codGestor) throws java.rmi.RemoteException;
	public boolean updateMetasGestor(MetasGestor metasGestor)
		throws java.rmi.RemoteException;
	public boolean createMetasGestor(MetasGestor metasGestor)
		throws java.rmi.RemoteException;
	
//	OSCAR CORTEZ - BUSCAR CODIGO Y NOMBRE DE OFICINA
	public Vector busOficinaCodyNom(String codTerritorio)
		throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - BUSCAR TODOS LOS ANHOS

	//OSCAR CORTEZ - BUSCAR GESTOR X OFICINA
	public Vector busGestorxOficina(String codOficina)
		throws java.rmi.RemoteException;
	//	OSCAR CORTEZ - BUSCAR TODOS LOS ANHOS
	public Vector busAllAnhos() throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - BUSCAR CODIGO Y NOMBRE DE OFICINA

	//	OSCAR CORTEZ - BUSCAR EPIGREAFE
	public Vector busEpigrafeAcciones2(
		String codGestor,
		String anho,
		String mes,
		String codOficina) throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - BUSCAR EPIGREAFE

	//	OSCAR CORTEZ - REPORTE PGO
	public Vector reportePGO1(String codAnho, String codMes, String codOficina)
		throws java.rmi.RemoteException;
	
	//FIN - OSCAR CORTEZ - BUSCAR GESTOR X OFICINA

	public Vector busGestorxOficinaxAnioxMes(
		String codOficina,
		String mes,
		String anio) throws java.rmi.RemoteException;
	public Vector reportePGOEsfuerzos(
		String codAnho,
		String codMes,
		String codOficina) throws java.rmi.RemoteException;
	public MetasGestor findGestorByCodigo(String codGestor)
		throws java.rmi.RemoteException;

	public MetasGestor findGestorByCodMonthYear(
		String anho,
		String mes,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	public Vector distribuirGOF(
		Vector listaGestoresLDAP,
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes) throws java.rmi.RemoteException;
	public HashMap buscarResumenMontos(
		Vector listaEpigrafe,
		String codTerritorio,
		String codOficina,
		String anho,
		String mes) throws java.rmi.RemoteException;
	public BigDecimal buscarMontoGestor(
		String codGestor,
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes) throws java.rmi.RemoteException;
	public void eliminarMetaGestoresHijas(Vector listaGestores)
		throws java.rmi.RemoteException;
	public void actualizarMetaGestoresPlanes(
		Vector listaEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String codGestorGOF,
		String usuario) throws java.rmi.RemoteException;
	public void actualizarCargoGestoresLDAP(
		Vector listaGestoresLDAP,
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String usuario) throws java.rmi.RemoteException;
	public void actualizarGestoresDistribuidosLDAP(
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String usuario) throws java.rmi.RemoteException;
	public void actualizarGestoresEliminadosLDAP(
		Vector listaGestoresLDAP,
		String codEpigrafe,
		String anho,
		String codOficina,
		String mes,
		String usuario) throws java.rmi.RemoteException;
	public Vector nuevaMetaGestor(
		String codMetaGestor,
		String codTerritorio,
		String codOficina,
		String codEpigrafe,
		String anho,
		String codGestor,
		String codigoPerfil,
		String mes,
		Double porc_asig,
		String nom_epigrafe,
		String nom_gestor,
		String usuario) throws java.rmi.RemoteException;
	
	public BigDecimal promedioMensual(String anho, String mes, String codOfi, String codTerr, String codEpi, String codGestor) throws java.rmi.RemoteException; 
}
