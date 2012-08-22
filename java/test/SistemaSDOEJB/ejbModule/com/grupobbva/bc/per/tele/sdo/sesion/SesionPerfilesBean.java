package com.grupobbva.bc.per.tele.sdo.sesion;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_perfilesKey;
import entities.Tiido_perfilesLocal;
import entities.Tiido_perfilesLocalHome;

import org.apache.log4j.Logger;

@SuppressWarnings({"unchecked", "unused"})
public class SesionPerfilesBean implements javax.ejb.SessionBean {

	private static final long serialVersionUID = 1L;
	private static final String STATIC_Tiido_perfilesLocalHome_REF_NAME = "ejb/Tiido_perfiles";
	private static final Class STATIC_Tiido_perfilesLocalHome_CLASS = Tiido_perfilesLocalHome.class;
	private static Logger log = Logger.getLogger(SesionPerfilesBean.class);
	private javax.ejb.SessionContext mySessionCtx;

	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}

	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}

	public void ejbCreate() throws javax.ejb.CreateException {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
	}

	public Perfil findPerfil(String cod_perfil) {
		Perfil perfil = null;
		
		try {
			log.info("[SesionPerfilesBean :: findPerfil] Inicio");
			
			Tiido_perfilesLocal aTiido_perfilesLocal = find_Tiido_perfilesLocalHome_findByPrimaryKey(new Tiido_perfilesKey(cod_perfil));
			if (aTiido_perfilesLocal != null) {
				perfil = new Perfil();
				perfil.setCodPerfil(aTiido_perfilesLocal.getCod_perfil());
				perfil.setNomPerfil(aTiido_perfilesLocal.getNom_perfil());
				perfil.setPerfil(aTiido_perfilesLocal.getPerfil());
			}
			
			log.info("[SesionPerfilesBean :: findPerfil] Fin");
		} catch (Exception e) {
			log.error("[SesionPerfilesBean :: findPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return perfil;
	}

	public boolean updatePerfil(Perfil perfil) {
		try {
			log.info("[SesionPerfilesBean :: updatePerfil] Inicio");
			
			Tiido_perfilesLocal aTiido_perfilesLocal = find_Tiido_perfilesLocalHome_findByPrimaryKey(new Tiido_perfilesKey(perfil.getCodPerfil()));
			if (aTiido_perfilesLocal != null) {
				aTiido_perfilesLocal.setNom_perfil(perfil.getNomPerfil());
				aTiido_perfilesLocal.setPerfil(perfil.getPerfil());
				log.info("[SesionPerfilesBean :: updatePerfil] Fin");
				return true;
			}
			
			log.info("[SesionPerfilesBean :: updatePerfil] Fin");
		} catch (Exception e) {
			log.error("[SesionPerfilesBean :: updatePerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}

	public Vector findAllPerfil() {
		Vector listaPerfil = null;
		
		try {
			log.info("[SesionPerfilesBean :: findAllPerfil] Inicio");
			Collection aCollection = find_Tiido_perfilesLocalHome_findAllPerfil();
			
			if (aCollection != null && aCollection.size() > 0) {
				Iterator it = aCollection.iterator();
				listaPerfil = new Vector();
	
				while (it.hasNext()) {
					Tiido_perfilesLocal local = (Tiido_perfilesLocal) it.next();
	
					if (local != null) {
						Perfil perfil = new Perfil();
						perfil.setCodPerfil(local.getCod_perfil());
						perfil.setNomPerfil(local.getNom_perfil());
						perfil.setPerfil(local.getPerfil());
						listaPerfil.add(perfil);
					}
				}
			}
			
			log.info("[SesionPerfilesBean :: findAllPerfil] Fin");
		} catch(Exception e) {
			log.error("[SesionPerfilesBean :: findAllPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaPerfil;
	}

	public boolean deletePerfil(String cod_perfil) {
		try {
			log.info("[SesionPerfilesBean :: deletePerfil] Inicio");
			
			Tiido_perfilesLocal aTiido_perfilesLocal = find_Tiido_perfilesLocalHome_findByPrimaryKey(new Tiido_perfilesKey(cod_perfil));
			if (aTiido_perfilesLocal != null) {
				aTiido_perfilesLocal.remove();
				
				log.info("[SesionPerfilesBean :: deletePerfil] Fin");
				return true;
			}
			
			log.info("[SesionPerfilesBean :: deletePerfil] Fin");
		} catch (Exception e) {
			log.error("[SesionPerfilesBean :: deletePerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}

	public boolean createPerfil(Perfil perfil) {
		log.info("[SesionPerfilesBean :: createPerfil] Inicio");
		Tiido_perfilesLocal aTiido_perfilesLocal = createTiido_perfilesLocal(perfil);
		log.info("[SesionPerfilesBean :: createPerfil] Fin");
		return false;
	}
	protected Tiido_perfilesLocal find_Tiido_perfilesLocalHome_findByPrimaryKey(
			Tiido_perfilesKey primaryKey) {
		try {
			log.info("[SesionPerfilesBean :: find_Tiido_perfilesLocalHome_findByPrimaryKey] Inicio");
			
			Tiido_perfilesLocalHome aTiido_perfilesLocalHome = (Tiido_perfilesLocalHome) ServiceLocatorManager.getLocalHome(STATIC_Tiido_perfilesLocalHome_REF_NAME, STATIC_Tiido_perfilesLocalHome_CLASS);
			
			if (aTiido_perfilesLocalHome != null) {
				log.info("[SesionPerfilesBean :: find_Tiido_perfilesLocalHome_findByPrimaryKey] Fin");
				return aTiido_perfilesLocalHome.findByPrimaryKey(primaryKey);
			}
			
			log.info("[SesionPerfilesBean :: find_Tiido_perfilesLocalHome_findByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPerfilesBean :: find_Tiido_perfilesLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Collection find_Tiido_perfilesLocalHome_findAllPerfil() {
		try {
			log.info("[SesionPerfilesBean :: find_Tiido_perfilesLocalHome_findAllPerfil] Inicio");
			
			Tiido_perfilesLocalHome aTiido_perfilesLocalHome = (Tiido_perfilesLocalHome) ServiceLocatorManager.getLocalHome(STATIC_Tiido_perfilesLocalHome_REF_NAME, STATIC_Tiido_perfilesLocalHome_CLASS);
			
			if (aTiido_perfilesLocalHome != null) {
				log.info("[SesionPerfilesBean :: find_Tiido_perfilesLocalHome_findAllPerfil] Fin");
				
				return aTiido_perfilesLocalHome.findAllPerfil();
			}
			
			log.info("[SesionPerfilesBean :: find_Tiido_perfilesLocalHome_findAllPerfil] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPerfilesBean :: find_Tiido_perfilesLocalHome_findAllPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_perfilesLocal createTiido_perfilesLocal(Perfil per) {
		try {
			log.info("[SesionPerfilesBean :: createTiido_perfilesLocal] Inicio");
			
			Tiido_perfilesLocalHome aTiido_perfilesLocalHome = (Tiido_perfilesLocalHome) ServiceLocatorManager.getLocalHome(STATIC_Tiido_perfilesLocalHome_REF_NAME, STATIC_Tiido_perfilesLocalHome_CLASS);
			
			if (aTiido_perfilesLocalHome != null) {
				log.info("[SesionPerfilesBean :: createTiido_perfilesLocal] Fin");
				return aTiido_perfilesLocalHome.create(per);
			}
			
			log.info("[SesionPerfilesBean :: createTiido_perfilesLocal] Fin");
		} catch (javax.ejb.CreateException ce) {
		} catch (Exception e) {
			log.error("[SesionPerfilesBean :: createTiido_perfilesLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
}
