package com.grupobbva.bc.per.tele.sdo.sesion;
import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import java.util.Vector;
/**
 * Remote interface for Enterprise Bean: SesionEpigrafe
 */
public interface SesionEpigrafe extends javax.ejb.EJBObject {
	public Epigrafe findByCodEpigAnho(String codEpigrafe, String anho)
		throws java.rmi.RemoteException;
	public Vector findEpiByAnho(String anho) throws java.rmi.RemoteException;
	/**
	 * Auto: Godofredo Ureta
	 * Fecha: 02/06/2009
	 * @param epigrafe
	 * @return Boolena, True si todo se genero bien, y False si no tuvo exito
	 */
	public boolean createEpigrafe(Epigrafe epigrafe)
		throws java.rmi.RemoteException;
	/**
	 * ELIMINA LOS EPIGRAFES INGRESADOS MEDIANTE CARGA DE ARCHIVO
	 * @return Borra true si es exitoso y false si no es exitoso
	 */
	public boolean borrarEpigrafe() throws java.rmi.RemoteException;
	/**
	 * Auto: Godofredo Ureta
	 * Fecha: 09/07/2009
	 * @param anho
	 * @return Vector, con toda la lista de epigrafes con sus respectivos valores.
	 */
	public Vector findEpigrafeInf(String anho) throws java.rmi.RemoteException;
	public int actualizarPorcentajeEpigrafe(Epigrafe datos)
		throws java.rmi.RemoteException;
	public boolean existeEpigrafe(String codEpigrafe, String anho)
		throws java.rmi.RemoteException;
}
