package com.grupobbva.bc.per.tele.sdo.sesion;

import com.grupobbva.bc.per.tele.sdo.serializable.Firmas;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_firmasLocal;
import entities.Tiido_firmasLocalHome;
import entities.Tiido_oficinaKey;
/**
 * Bean implementation class for Enterprise Bean: SesionFirmas
 */
public class SesionFirmasBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiido_firmasLocalHome_REF_NAME = "ejb/Tiido_firmas";
	private final static Class STATIC_Tiido_firmasLocalHome_CLASS = Tiido_firmasLocalHome.class;
	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}

	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}

	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}

	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}

	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}

	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}

	public Firmas findFirmByAnoMesCgesItem(String anho, String mes, String codGestor,String item) {
		Firmas firmas = new Firmas();
		try {
			Tiido_firmasLocal aTiido_firmasLocal = find_Tiido_firmasLocalHome_findFirmByAnoMesCgesItem(
					anho, mes, codGestor, item);
			if(aTiido_firmasLocal!=null){
				firmas.setAnhoFirma(aTiido_firmasLocal.getAnho_firm());
				firmas.setCodFirma(aTiido_firmasLocal.getCod_firma());
				firmas.setCodGestor(aTiido_firmasLocal.getCod_gestor());
				firmas.setDescripcion(aTiido_firmasLocal.getDescripcion());
				firmas.setFecFirma(aTiido_firmasLocal.getFec_firm());
				firmas.setItemFirma(aTiido_firmasLocal.getItem_firm());
				firmas.setMesFirma(aTiido_firmasLocal.getMes_firm());
				firmas.getOficina().setCodOfic(((Tiido_oficinaKey)aTiido_firmasLocal.getTiido_fir_oficina_fk().getPrimaryKey()).getCod_ofic());
			}
		}catch(Exception e){}
		return firmas;
	}
	
	protected Tiido_firmasLocal find_Tiido_firmasLocalHome_findFirmByAnoMesCgesItem(
			String anho, String mes, String codGestor, String item) {
		Tiido_firmasLocalHome aTiido_firmasLocalHome = (Tiido_firmasLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiido_firmasLocalHome_REF_NAME,
						STATIC_Tiido_firmasLocalHome_CLASS);
		try {
			if (aTiido_firmasLocalHome != null)
				return aTiido_firmasLocalHome.findFirmByAnoMesCgesItem(anho,
						mes, codGestor, item);
		} catch (javax.ejb.FinderException fe) {
			fe.printStackTrace();
		}
		return null;
	}
}
