package com.grupobbva.bc.per.tele.sdo.sesion;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.Parametro;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_parametrosLocal;
import entities.Tiido_parametrosLocalHome;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionParametros
 */
public class SesionParametrosBean implements javax.ejb.SessionBean {
	private static Logger log = Logger.getLogger(SesionParametrosBean.class);
	
	private javax.ejb.SessionContext mySessionCtx;

	private final static String STATIC_Tiido_parametrosLocalHome_REF_NAME = "ejb/Tiido_parametros";

	private final static Class STATIC_Tiido_parametrosLocalHome_CLASS = Tiido_parametrosLocalHome.class;

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

	public Vector findAllParametro() {
		Vector listaParametro = new Vector();
		Tiido_parametrosLocal parametroLocal = null;
		
		try {
			log.info("[SesionParametrosBean :: findAllParametro] Inicio");
			
			Collection aCollection = find_Tiido_parametrosLocalHome_findAllParametros();
			Iterator parametroIterator = aCollection.iterator();
			while (parametroIterator.hasNext()) {
				Parametro parametro = new Parametro();
				parametroLocal = (Tiido_parametrosLocal) parametroIterator
						.next();
				parametro.setAfectaAccion(parametroLocal.getAfec_acci());
				parametro.setAfectaPlan(parametroLocal.getAfec_plan());
				parametro.setAfectaSeguimiento(parametroLocal.getAfec_segu());
				parametro.setCodParametro(parametroLocal.getCod_parametro());
				parametro.setFecAccion(parametroLocal.getFec_acci());
				parametro.setFecPlan(parametroLocal.getFec_plan());
				parametro.setFecSeguimiento1(parametroLocal.getFec_segu_1());
				parametro.setFecSeguimiento2(parametroLocal.getFec_segu_2());
				listaParametro.add(parametro);
			}
			
			log.info("[SesionParametrosBean :: findAllParametro] Fin");
		} catch (Exception e) {
			log.error("[SesionParametrosBean :: findAllParametro] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
		return listaParametro;
	}

	public Parametro findParametroAll() {
		Parametro parametro = new Parametro();
		
		try {
			log.info("[SesionParametrosBean :: findParametroAll] Inicio");
			
			Tiido_parametrosLocal aTiido_parametrosLocal = find_Tiido_parametrosLocalHome_findParametroAll();
			if(aTiido_parametrosLocal!=null){
				parametro.setAfectaAccion(aTiido_parametrosLocal.getAfec_acci());
				parametro.setAfectaPlan(aTiido_parametrosLocal.getAfec_plan());
				parametro.setAfectaSeguimiento(aTiido_parametrosLocal.getAfec_segu());
				parametro.setCodParametro(aTiido_parametrosLocal.getCod_parametro());
				parametro.setFecAccion(aTiido_parametrosLocal.getFec_acci());
				parametro.setFecPlan(aTiido_parametrosLocal.getFec_plan());
				parametro.setFecSeguimiento1(aTiido_parametrosLocal.getFec_segu_1());
				parametro.setFecSeguimiento2(aTiido_parametrosLocal.getFec_segu_2());
			}
			
			log.info("[SesionParametrosBean :: findParametroAll] Fin");
		}catch(Exception e){
			log.error("[SesionParametrosBean :: findParametroAll] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		return parametro;		
	}
	
	protected Collection find_Tiido_parametrosLocalHome_findAllParametros() {
		log.info("[SesionParametrosBean :: find_Tiido_parametrosLocalHome_findAllParametros] Inicio");
		
		Tiido_parametrosLocalHome aTiido_parametrosLocalHome = (Tiido_parametrosLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiido_parametrosLocalHome_REF_NAME,
						STATIC_Tiido_parametrosLocalHome_CLASS);
		try {
			if (aTiido_parametrosLocalHome != null) {
				log.info("[SesionParametrosBean :: find_Tiido_parametrosLocalHome_findAllParametros] Fin");
				
				return aTiido_parametrosLocalHome.findAllParametros();
			}
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionParametrosBean :: find_Tiido_parametrosLocalHome_findAllParametros] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		 
		return null;
	}
	protected Tiido_parametrosLocal find_Tiido_parametrosLocalHome_findParametroAll() {
		log.info("[SesionParametrosBean :: find_Tiido_parametrosLocalHome_findParametroAll] Inicio");
		
		Tiido_parametrosLocalHome aTiido_parametrosLocalHome = (Tiido_parametrosLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiido_parametrosLocalHome_REF_NAME,
						STATIC_Tiido_parametrosLocalHome_CLASS);
		try {
			if (aTiido_parametrosLocalHome != null) {
				log.info("[SesionParametrosBean :: find_Tiido_parametrosLocalHome_findParametroAll] Fin");
				
				return aTiido_parametrosLocalHome.findParametroAll();
			}
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionParametrosBean :: find_Tiido_parametrosLocalHome_findParametroAll] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		return null;
	}
}
