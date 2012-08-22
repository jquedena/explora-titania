package com.grupobbva.bc.per.tele.sdo.sesion;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
import java.util.Vector;
/**
 * Remote interface for Enterprise Bean: SesionProgSeguimiento
 */
public interface SesionProgSeguimiento extends javax.ejb.EJBObject {
	public ProgSeguimiento findProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public boolean crearProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public boolean actualizarProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public boolean eliminarProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public Vector findTodosProgTerritorio(ProgSeguimiento progTerritorio)
		throws java.rmi.RemoteException;
	public ProgSeguimiento findProgramacionSeguimiento(
		String mes,
		String anio,
		String codTerritorio) throws java.rmi.RemoteException;
}
