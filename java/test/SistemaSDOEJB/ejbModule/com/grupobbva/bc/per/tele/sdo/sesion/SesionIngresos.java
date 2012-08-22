package com.grupobbva.bc.per.tele.sdo.sesion;

import java.util.ArrayList;
import java.util.Vector;
/**
 * Remote interface for Enterprise Bean: SesionIngresos
 */

@SuppressWarnings("unchecked")
public interface SesionIngresos extends javax.ejb.EJBObject {
//	OSCAR CORTEZ - BUSCAR INGRESOS
	public Vector busAllIngreso(String anho, String mes)
		throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSCAR x TERRITORIO

	public int busID_IngresoMax() throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - NUEVO INGRESO

	//OSCAR CORTEZ - BUSCAR DEL DIA
	public Vector busIngresoxDIA(String codTerritorioUsuario)
		throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSCAR x OFICINA x MES

	//	OSCAR CORTEZ - BUSCAR x OFICINA x A�O
	public Vector busIngresoxOFICINAxAnho(
		String anho,
		String codOficina,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSCAR x USUARIO x A�O

	//OSCAR CORTEZ - BUSCAR x OFICINA x MES
	public Vector busIngresoxOFICINAxMes(
		String mes,
		String codOficina,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSCAR INGRESOS DEL DIA

	//OSCAR CORTEZ - BUSCAR x USUARIO x MES
	public Vector busIngresoxUSUARIOxMes(String mes, String codTerritorioUsuario)
		throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSCAR x USUARIO x MES

	//	OSCAR CORTEZ - BUSCAR x USUARIO x A�O
	public Vector busIngresoxUSUARIOxAnho(
		String anho,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSCAR x OFICINA x A�O

	//	OSCAR CORTEZ - BUSCAR x TERRITORIO x MES
	public Vector busIngresoxTERRITORIOxMes(
		String mes,
		String nomTerritorio,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSCAR x TERRITORIO x MES

	// OSCAR CORTEZ - BUSCAR x TERRITORIO x A�O
	public Vector busIngresoxTERRITORIOxAnho(
		String anho,
		String nomTerritorio,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public Vector busIngresoxUsuario(
		String anho,
		String mes,
		String dia,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	//	FIN - OSCAR CORTEZ - BUSCAR INGRESOS

	//OSCAR CORTEZ - NUEVO INGRESO

	public int nuevoIngreso(
		String id_ingresos,
		String codUsuario,
		String cargo,
		String nomTerritorio,
		String codOficina,
		String nombres) throws java.rmi.RemoteException;
	public void actualizarIngreso(
		int tipo,
		int idIngreso,
		String mes,
		String anio) throws java.rmi.RemoteException;
	public Vector busIngresoxOficina(
		String anho,
		String mes,
		String dia,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public Vector busIngresoxTerritorio(
		String anho,
		String mes,
		String dia,
		String codTerritorioUsuario) throws java.rmi.RemoteException;
	public void actualizarIngresoFormEditUsuario(long id)
		throws java.rmi.RemoteException;
	public long existeIngresoForm(
		int tipo,
		int mes,
		int anio,
		String codUsuario,
		String fecha, String codGestorM, String codOficinaM) throws java.rmi.RemoteException;
	public void insertarIngresoForm(
		int tipo,
		int mes,
		int anio,
		String codUsuario,
		String editUsuario,
		String codGestor,
		String codOficina) throws java.rmi.RemoteException;
	public ArrayList listarDiasMesesxAnio(int anio)
		throws java.rmi.RemoteException;
	public Vector reportexOficina(
		int dia,
		int mes,
		int anio,
		String codTerritorio) throws java.rmi.RemoteException;
	public Vector reportexOficinaxAnio(int anio, String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector reportexTerritorio(
		int dia,
		int mes,
		int anio,
		String codTerritorio) throws java.rmi.RemoteException;
	public Vector reportexTerritorioxAnio(int anio, String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector reportexUsuario(
		int dia,
		int mes,
		int anio,
		String codTerritorio) throws java.rmi.RemoteException;
	public Vector reportexUsuarioxAnio(int anio, String codTerritorio)
		throws java.rmi.RemoteException;
	public int listadoIngresoxDia(String diaActual, String codTerritorio)
		throws java.rmi.RemoteException;
}
