package com.grupobbva.bc.per.tele.sdo.sesion;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_equivalenciasKey;
import entities.Tiido_equivalenciasLocal;
import entities.Tiido_equivalenciasLocalHome;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionEquivalencias
 */
@SuppressWarnings({"serial", "unchecked", "unused"})
public class SesionEquivalenciasBean implements javax.ejb.SessionBean {
	
	private javax.ejb.SessionContext mySessionCtx;
	private static Logger log = Logger.getLogger(SesionEquivalenciasBean.class);
	private final static String STATIC_Tiido_equivalenciasLocalHome_REF_NAME = "ejb/Tiido_equivalencias";
	private final static Class STATIC_Tiido_equivalenciasLocalHome_CLASS = Tiido_equivalenciasLocalHome.class;

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

	public Equivalencia findEquivalenciaByCodCargo(String codCargo) {
		Equivalencia equivalencia = new Equivalencia();
		
		try {
			log.info("[SesionEquivalenciasBean :: findEquivalenciaByCodCargo] Inicio");
			
			Tiido_equivalenciasLocal aTiido_equivalenciasLocal = find_Tiido_equivalenciasLocalHome_findEquivalenciaByCodCargo(codCargo);
			if (aTiido_equivalenciasLocal != null) {
				equivalencia.setCodCargo(aTiido_equivalenciasLocal.getCod_car());
				equivalencia.setCodPerfil(aTiido_equivalenciasLocal.getCod_per());
			}
			
			log.info("[SesionEquivalenciasBean :: findEquivalenciaByCodCargo] Fin");
		} catch (Exception e) {
			log.error("[SesionEquivalenciasBean :: findEquivalenciaByCodCargo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return equivalencia;
	}

	public Vector findAllEquivalencias() {
		Vector listaEquivalencia = null;
		
		try {
			log.info("[SesionEquivalenciasBean :: findAllEquivalencias] Inicio");
			
			Collection aCollection = find_Tiido_equivalenciasLocalHome_findAllEquivalencias();
	
			if (aCollection != null && aCollection.size() > 0) {
				Iterator it = aCollection.iterator();
				listaEquivalencia = new Vector();
	
				while (it.hasNext()) {
					Tiido_equivalenciasLocal local = (Tiido_equivalenciasLocal) it
							.next();
	
					if (local != null) {
						Equivalencia obj = new Equivalencia();
						obj.setCodPerfil(local.getCod_per());
						obj.setCodCargo(local.getCod_car());
						listaEquivalencia.add(obj);
					}
				}
			}
			
			log.info("[SesionEquivalenciasBean :: findAllEquivalencias] Fin");
		} catch(Exception e) {
			log.error("[SesionEquivalenciasBean :: findAllEquivalencias] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);

		}
		
		return listaEquivalencia;
	}

	public boolean updateEquivalencia(Equivalencia equivalencia) {

		try {
			log.info("[SesionEquivalenciasBean :: updateEquivalencia] Inicio");
			
			Tiido_equivalenciasLocal aTiido_equivalenciasLocal = find_Tiido_equivalenciasLocalHome_findByPrimaryKey(new Tiido_equivalenciasKey(
					equivalencia.getCodCargo()));

			if (aTiido_equivalenciasLocal != null) {
				aTiido_equivalenciasLocal.setCod_per(equivalencia
						.getCodPerfil());
				
				log.info("[SesionEquivalenciasBean :: updateEquivalencia] Fin");
				return true;
			}
			
			log.info("[SesionEquivalenciasBean :: updateEquivalencia] Fin");
		} catch (Exception e) {
			log.error("[SesionEquivalenciasBean :: updateEquivalencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}

	public boolean deleteEquivalencia(String cod_cargo) {
		try {
			log.info("[SesionEquivalenciasBean :: deleteEquivalencia] Inicio");
			
			Tiido_equivalenciasLocal aTiido_equivalenciasLocal = find_Tiido_equivalenciasLocalHome_findByPrimaryKey(new Tiido_equivalenciasKey(
					cod_cargo));
			
			if (aTiido_equivalenciasLocal != null) {
				aTiido_equivalenciasLocal.remove();
				
				log.info("[SesionEquivalenciasBean :: deleteEquivalencia] Fin");
				return true;
			}
			
			log.info("[SesionEquivalenciasBean :: deleteEquivalencia] Fin");
		} catch (Exception e) {
			log.error("[SesionEquivalenciasBean :: deleteEquivalencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}

	public boolean createEquivalencia(Equivalencia equivalencia) {
		log.info("[SesionEquivalenciasBean :: createEquivalencia] Inicio");
		Tiido_equivalenciasLocal aTiido_equivalenciasLocal = createTiido_equivalenciasLocal(equivalencia);
		log.info("[SesionEquivalenciasBean :: createEquivalencia] Fin");
		
		return false;
	}
	
	protected Tiido_equivalenciasLocal find_Tiido_equivalenciasLocalHome_findEquivalenciaByCodCargo(String codCargo) {
		
		try {
			log.info("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findEquivalenciaByCodCargo] Inicio");
			
			Tiido_equivalenciasLocalHome aTiido_equivalenciasLocalHome = (Tiido_equivalenciasLocalHome) 
				ServiceLocatorManager.getLocalHome(STATIC_Tiido_equivalenciasLocalHome_REF_NAME, STATIC_Tiido_equivalenciasLocalHome_CLASS);
			
			if (aTiido_equivalenciasLocalHome != null) {
				log.info("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findEquivalenciaByCodCargo] Fin");
				
				return aTiido_equivalenciasLocalHome.findEquivalenciaByCodCargo(codCargo);
			}
			
			log.info("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findEquivalenciaByCodCargo] Fin");
		} catch (javax.ejb.FinderException fe) {
			ConstantesUtil.mostrarMensajeExcepcion(fe);
		} catch (Exception e) {
			log.error("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findEquivalenciaByCodCargo] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Collection find_Tiido_equivalenciasLocalHome_findAllEquivalencias() {
		try {
			log.info("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findAllEquivalencias] Inicio");
			
			Tiido_equivalenciasLocalHome aTiido_equivalenciasLocalHome = (Tiido_equivalenciasLocalHome) 
				ServiceLocatorManager.getLocalHome(STATIC_Tiido_equivalenciasLocalHome_REF_NAME, STATIC_Tiido_equivalenciasLocalHome_CLASS);
			
			if (aTiido_equivalenciasLocalHome != null) {
				log.info("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findAllEquivalencias] Fin");
				
				return aTiido_equivalenciasLocalHome.findAllEquivalencias();
			}
			
			log.info("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findAllEquivalencias] Fin");
		} catch (javax.ejb.FinderException fe) {
			ConstantesUtil.mostrarMensajeExcepcion(fe);
		} catch (Exception e) {
			log.error("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findAllEquivalencias] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} 
		
		return null;
	}
	protected Tiido_equivalenciasLocal find_Tiido_equivalenciasLocalHome_findByPrimaryKey(
			Tiido_equivalenciasKey primaryKey) {
		try {
			log.info("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findByPrimaryKey] Inicio");
			
			Tiido_equivalenciasLocalHome aTiido_equivalenciasLocalHome = (Tiido_equivalenciasLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_equivalenciasLocalHome_REF_NAME,
					STATIC_Tiido_equivalenciasLocalHome_CLASS);
			
			if (aTiido_equivalenciasLocalHome != null) {
				log.info("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findByPrimaryKey] Fin");
				
				return aTiido_equivalenciasLocalHome
						.findByPrimaryKey(primaryKey);
			}
			
			log.info("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionEquivalenciasBean :: find_Tiido_equivalenciasLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_equivalenciasLocal createTiido_equivalenciasLocal(
			Equivalencia Equivalencia) {
		
		try {
			log.info("[SesionEquivalenciasBean :: createTiido_equivalenciasLocal] Inicio");
			
			Tiido_equivalenciasLocalHome aTiido_equivalenciasLocalHome = (Tiido_equivalenciasLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_equivalenciasLocalHome_REF_NAME,
					STATIC_Tiido_equivalenciasLocalHome_CLASS);
			
			if (aTiido_equivalenciasLocalHome != null) {
				log.info("[SesionEquivalenciasBean :: createTiido_equivalenciasLocal] Fin");
				
				return aTiido_equivalenciasLocalHome.create(Equivalencia);
			}
			
			log.info("[SesionEquivalenciasBean :: createTiido_equivalenciasLocal] Fin");
		} catch (javax.ejb.CreateException ce) {
		} catch (Exception e) {
			log.error("[SesionEquivalenciasBean :: createTiido_equivalenciasLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
}
