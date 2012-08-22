package com.grupobbva.bc.per.tele.sdo.sesion;

import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.Accion;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
/**
 * Remote interface for Enterprise Bean: SesionAcciones
 */
public interface SesionAcciones extends javax.ejb.EJBObject {
	public Vector busAllAnho() throws java.rmi.RemoteException;
	public Vector busAccionesPGG3(
		String codAnho,
		String codMes,
		String codGestor,
		String codEpigrafe) throws java.rmi.RemoteException;
	public int codigoAccion() throws java.rmi.RemoteException;
	public Vector eliminarAccion(String codAccion)
		throws java.rmi.RemoteException;
	public Vector codOficinaMax(String codTerritorio)
		throws java.rmi.RemoteException;
	public Vector pggSeguimiento1(
		String mes,
		String anho,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	public Vector pggEsfuerzoAdicional1(
		String mes,
		String anho,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	public Vector pggSeguimiento2(
		String mes,
		String anho,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	public Vector pggEsfuerzoAdicional2(
		String mes,
		String anho,
		String codOficina,
		String codGestor) throws java.rmi.RemoteException;
	public Accion busAccion(String codAccion) throws java.rmi.RemoteException;
	public Vector pggSeguimiento1(
		String mes,
		String anho,
		String codOficina,
		String codGestor,
		ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException;
	public Vector pggEsfuerzoAdicional1(
		String mes,
		String anho,
		String codOficina,
		String codGestor,
		ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException;
	public Vector pggSeguimiento2(
		String mes,
		String anho,
		String codOficina,
		String codGestor,
		ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException;
	public Vector pggEsfuerzoAdicional2(
		String mes,
		String anho,
		String codOficina,
		String codGestor,
		ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException;
	public Vector nuevaAccion(
		String cod_acci,
		String cod_epigrafe,
		String anho,
		String cod_terr,
		String cod_ofic,
		String nom_acci,
		String cod_gest,
		String mes_acci,
		String nro_clie,
		String comp_gest,
		String nro_gest_segu_1,
		String nro_conc_segu_1,
		String mon_segu_1,
		String nro_gest_segu_2,
		String nro_conc_segu_2,
		String mon_segu_2,
		String usuario) throws java.rmi.RemoteException;
	public boolean actualizarSeguimiento1(
		String tipoSeguimiento,
		String numDato,
		String codigo1,
		String codigo2,
		String valor,
		String usuario) throws java.rmi.RemoteException;
	public boolean actualizarSeguimiento2(
		String tipoSeguimiento,
		String numDato,
		String codigo1,
		String codigo2,
		String valor,
		String usuario) throws java.rmi.RemoteException;
	public boolean edicionAccion(
		String codAccion,
		String descAccion,
		String numeroCliente,
		String compromisoGestor,
		String usuario) throws java.rmi.RemoteException;
}
