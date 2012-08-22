package com.grupobbva.bc.per.tele.sdo.sesion;

import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.Campanias;
/**
 * Remote interface for Enterprise Bean: SesionCampaniasDetalle
 */
public interface SesionCampaniasDetalle extends javax.ejb.EJBObject {
	//OSCAR CORTEZ - LISTAR REPORTE - PLANIFICACION
	public Vector listaReportePlanificacion() throws java.rmi.RemoteException;
	//OSCAR CORTEZ - FIN - LISTAR REPORTE / PLANIFICACION

	//OSCAR CORTEZ - LISTAR REPORTE - PPG
	public Vector listaReportePPG(String anho, String mes)
		throws java.rmi.RemoteException;
	//OSCAR CORTEZ - FIN - LISTAR REPORTE / PPG

	//OSCAR CORTEZ - LISTAR REPORTE - SEGUIMIENTO 1
	public Vector listaReporteSeguimiento1(String anho, String mes)
		throws java.rmi.RemoteException;
	//OSCAR CORTEZ - FIN - LISTAR REPORTE / SEGUIMIENTO 1

	//OSCAR CORTEZ - LISTAR REPORTE - SEGUIMIENTO 2
	public Vector listaReporteSeguimiento2(String anho, String mes)
		throws java.rmi.RemoteException;
	public Vector listaCampaniaDetalle(
		String codTerritorio,
		String codOficina,
		String codCamp,
		String mes,
		String anho) throws java.rmi.RemoteException;
	public boolean eliminarCampaniaDetalle(String codCamp)
		throws java.rmi.RemoteException;
	public Campanias busCampaniaDetalle(String codCampaniaDetalle)
		throws java.rmi.RemoteException;
	//OSCAR CORTEZ - FIN - LISTAR REPORTE / SEGUIMIENTO 2

	public boolean nuevoCampaniaDetalle(
		String codTerritorio,
		String codOficina,
		String codCampania,
		String mes,
		String anho,
		String nomCampania,
		String codGest,
		int nroClie,
		double compGest,
		String usuario) throws java.rmi.RemoteException;
	public boolean edicionCampaniaDetalle(
		String codCampaniaDetalle,
		String nomCampania,
		int nroClie,
		double compGest,
		String usuario) throws java.rmi.RemoteException;
}
