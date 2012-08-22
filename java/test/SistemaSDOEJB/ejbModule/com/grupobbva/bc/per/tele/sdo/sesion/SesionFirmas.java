package com.grupobbva.bc.per.tele.sdo.sesion;
import com.grupobbva.bc.per.tele.sdo.serializable.Firmas;
/**
 * Remote interface for Enterprise Bean: SesionFirmas
 */
public interface SesionFirmas extends javax.ejb.EJBObject {
	public Firmas findFirmByAnoMesCgesItem(
		String anho,
		String mes,
		String codGestor,
		String item) throws java.rmi.RemoteException;
}
