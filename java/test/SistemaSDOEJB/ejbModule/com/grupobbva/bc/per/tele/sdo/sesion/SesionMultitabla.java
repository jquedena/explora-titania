package com.grupobbva.bc.per.tele.sdo.sesion;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import java.util.Vector;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
/**
 * Remote interface for Enterprise Bean: SesionMultitabla
 */
public interface SesionMultitabla extends javax.ejb.EJBObject {
	public boolean updateMultitabla(Multitabla multi)
		throws java.rmi.RemoteException;
	public Multitabla findByID(String codMulti, String codElem)
		throws java.rmi.RemoteException;
	public Multitabla findMultiByPrimaryKey(String codMulti, String codElem)
		throws java.rmi.RemoteException;
	public Multitabla findByID(String id) throws java.rmi.RemoteException;
	public Vector findByCodMulti(String codMulti)
		throws java.rmi.RemoteException;
	public Vector findByMultiForPresup(String codMulti, String Valor2)
		throws java.rmi.RemoteException;
	public int obtenerPrimerMesPresup() throws java.rmi.RemoteException;
	public ProgSeguimiento obtenerProgramacionSeguimientoDefault(
		String mes,
		String anio) throws java.rmi.RemoteException;
	public boolean updateElemMultitabla(Multitabla multi)
		throws java.rmi.RemoteException;
}
