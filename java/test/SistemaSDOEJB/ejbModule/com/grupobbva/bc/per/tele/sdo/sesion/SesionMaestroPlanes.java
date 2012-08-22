package com.grupobbva.bc.per.tele.sdo.sesion;
import java.util.Hashtable;
import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.MaestroPlan;
/**
 * Remote interface for Enterprise Bean: SesionMaestroPlanes
 */
public interface SesionMaestroPlanes extends javax.ejb.EJBObject {
	public MaestroPlan findUbicar(
		String mes,
		String anho,
		String codOficina,
		String codTerritorio) throws java.rmi.RemoteException;
	
	//	OSCAR CORTEZ - PGO RESUMEN SDO
	public Hashtable reportePGOResumen2(
		String codTerritorio,
		String mes,
		String anho) throws java.rmi.RemoteException;
	//	OSCAR CORTEZ - PGO RESUMEN LDAP
	public Vector reportePGOResumen(String codTerritorio, Hashtable hash)
		throws java.rmi.RemoteException;
	public boolean createMaestroPlan(
		String anho,
		String mes,
		String codOfi,
		String codTerr) throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - PGO RESUMEN SDO

	/**
	 * ELIMINA LOS PLANES INGRESADOS MEDIANTE CARGA DE ARCHIVO
	 * @return Borra true si es exitoso y false si no es exitoso
	 */
	public boolean borrarMaestro() throws java.rmi.RemoteException;
	public boolean existeDataMesAnio(String mes, String anio)
		throws java.rmi.RemoteException;
	public Vector reportePGOResumenxAnioMes(
		String codTerritorio,
		String mes,
		String anio) throws java.rmi.RemoteException;
}
