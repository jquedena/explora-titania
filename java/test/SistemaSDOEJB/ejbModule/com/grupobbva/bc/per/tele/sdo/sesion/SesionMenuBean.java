package com.grupobbva.bc.per.tele.sdo.sesion;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import com.grupobbva.bc.per.tele.sdo.serializable.Menu;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_menuKey;
import entities.Tiido_menuLocal;
import entities.Tiido_menuLocalHome;

import org.apache.log4j.Logger;

/**
 * Bean implementation class for Enterprise Bean: SesionMenu
 */
public class SesionMenuBean implements javax.ejb.SessionBean {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(SesionMenuBean.class);
	private javax.ejb.SessionContext mySessionCtx;
	private final static String STATIC_Tiido_menuLocalHome_REF_NAME = "ejb/Tiido_menu";
	private final static Class<?> STATIC_Tiido_menuLocalHome_CLASS = Tiido_menuLocalHome.class;

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

	@SuppressWarnings("unchecked")
	public Vector findAllMenu() {
		Vector listaMenu = new Vector();
		Tiido_menuLocal menuLocal = null;
		
		try {
			log.info("[SesionMenuBean :: findAllMenu] Inicio");
			
			Collection aCollection = find_Tiido_menuLocalHome_findAllMenu();
			Iterator menuIterator = aCollection.iterator();
			while (menuIterator.hasNext()) {
				Menu menu = new Menu();
				menuLocal = (Tiido_menuLocal) menuIterator.next();
				menu.setPadre(menuLocal.getPadre());
				menu.setHijo(menuLocal.getHijo());
				menu.setDescripcion(menuLocal.getDescripcion());
				menu.setLink(String.valueOf(menuLocal.getLink()));
				menu.setCodPerfil(String.valueOf(menuLocal.getCod_perfil()));
				listaMenu.add(menu);
			}
			
			log.info("[SesionMenuBean :: findAllMenu] Fin");
		} catch (Exception e) {
			log.error("[SesionMenuBean :: findAllMenu] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
		
		return listaMenu;
	}

	public boolean createMenu(Menu menu) {
		try {
			log.info("[SesionMenuBean :: createMenu] Inicio");
			
			@SuppressWarnings("unused")
			Tiido_menuLocal aTiido_menuLocal = createTiido_menuLocal(menu);
			
			log.info("[SesionMenuBean :: createMenu] Fin");
			return true;
		} catch (Exception e) {
			log.error("[SesionMenuBean :: createMenu] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}

	public boolean deleteMenu(String padre) {
		try {
			log.info("[SesionMenuBean :: deleteMenu] Inicio");
			
			Tiido_menuLocal aTiido_menuLocal = find_Tiido_menuLocalHome_findByPrimaryKey(new Tiido_menuKey(
					padre));
			if (aTiido_menuLocal != null) {
				aTiido_menuLocal.remove();
				return true;
			}
			
			log.info("[SesionMenuBean :: deleteMenu] Fin");
		} catch (Exception e) {
			log.error("[SesionMenuBean :: deleteMenu] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}
	
	public boolean updateMenu(Menu menu) {
		try {
			log.info("[SesionMenuBean :: updateMenu] Inicio");
			
			Tiido_menuLocal aTiido_menuLocal = find_Tiido_menuLocalHome_findByPrimaryKey(new Tiido_menuKey(menu.getPadre()));
			if(aTiido_menuLocal!=null)
			{
				aTiido_menuLocal.setHijo(menu.getHijo());
				aTiido_menuLocal.setDescripcion(menu.getDescripcion());
				aTiido_menuLocal.setLink(menu.getLink());
				aTiido_menuLocal.setCod_perfil(menu.getCodPerfil());
				return true;
			}
			
			log.info("[SesionMenuBean :: updateMenu] Fin");
		}catch(Exception e){			
			log.error("[SesionMenuBean :: updateMenu] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return false;
	}

	public Menu findxIdMenu(String padre) {
		Menu menu = new Menu();
		
		try{
			log.info("[SesionMenuBean :: findxIdMenu] Inicio");
			
			Tiido_menuLocal aTiido_menuLocal = find_Tiido_menuLocalHome_findByPrimaryKey(new Tiido_menuKey(padre));
			if(aTiido_menuLocal!=null){
				menu.setPadre(String.valueOf(aTiido_menuLocal.getPadre()));
				menu.setHijo(String.valueOf(aTiido_menuLocal.getHijo()));
				menu.setDescripcion(String.valueOf(aTiido_menuLocal.getDescripcion()));
				menu.setLink(String.valueOf(aTiido_menuLocal.getLink()));
				menu.setCodPerfil(String.valueOf(aTiido_menuLocal.getCod_perfil()));
			}
			
			log.info("[SesionMenuBean :: findxIdMenu] Fin");
		}catch(Exception e){
			log.error("[SesionMenuBean :: findxIdMenu] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return menu;		
	}
	

	@SuppressWarnings("unchecked")
	public Vector findxCodPerfil(String codPerfil) {
		codPerfil = "%" + codPerfil + "%";
		Vector listaMenu = new Vector();
		Tiido_menuLocal menuLocal = null;
		
		try{	
			log.info("[SesionMenuBean :: findxCodPerfil] Inicio");
			
			Collection aCollection = find_Tiido_menuLocalHome_findxCodPerfil(codPerfil);
			Iterator menuIterator = aCollection.iterator();
			while(menuIterator.hasNext()){
				Menu menu = new Menu();
				menuLocal = (Tiido_menuLocal) menuIterator.next();
				menu.setPadre(menuLocal.getPadre());
				menu.setHijo(menuLocal.getHijo());
				menu.setDescripcion(menuLocal.getDescripcion());
				menu.setLink(menuLocal.getLink());
				listaMenu.add(menu);
			}
			
			log.info("[SesionMenuBean :: findxCodPerfil] Fin");
		} catch(Exception e){
			log.error("[SesionMenuBean :: findxCodPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaMenu;		
	}
	
	@SuppressWarnings("unchecked")
	protected Collection find_Tiido_menuLocalHome_findxCodPerfil(
			String codPerfil) {
		log.info("[SesionMenuBean :: find_Tiido_menuLocalHome_findxCodPerfil] Inicio");
		
		Tiido_menuLocalHome aTiido_menuLocalHome = (Tiido_menuLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiido_menuLocalHome_REF_NAME,
						STATIC_Tiido_menuLocalHome_CLASS);
		try {
			if (aTiido_menuLocalHome != null) {
				log.info("[SesionMenuBean :: find_Tiido_menuLocalHome_findxCodPerfil] Fin");
				
				return aTiido_menuLocalHome.findxCodPerfil(codPerfil);
			}
		} catch (javax.ejb.FinderException fe) {
			
		} catch (Exception e) {
			log.error("[SesionMenuBean :: find_Tiido_menuLocalHome_findxCodPerfil] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	
	protected Tiido_menuLocal find_Tiido_menuLocalHome_findByPrimaryKey(
			Tiido_menuKey primaryKey) {
		
		log.info("[SesionMenuBean :: find_Tiido_menuLocalHome_findByPrimaryKey] Inicio");
		
		Tiido_menuLocalHome aTiido_menuLocalHome = (Tiido_menuLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiido_menuLocalHome_REF_NAME,
						STATIC_Tiido_menuLocalHome_CLASS);
		try {
			if (aTiido_menuLocalHome != null) {
				log.info("[SesionMenuBean :: find_Tiido_menuLocalHome_findByPrimaryKey] Fin");
				
				return aTiido_menuLocalHome.findByPrimaryKey(primaryKey);
			}
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionMenuBean :: find_Tiido_menuLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected Collection find_Tiido_menuLocalHome_findAllMenu() {
		log.info("[SesionMenuBean :: find_Tiido_menuLocalHome_findAllMenu] Inicio");
		
		Tiido_menuLocalHome aTiido_menuLocalHome = (Tiido_menuLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiido_menuLocalHome_REF_NAME,
						STATIC_Tiido_menuLocalHome_CLASS);
		try {
			if (aTiido_menuLocalHome != null) {
				log.info("[SesionMenuBean :: find_Tiido_menuLocalHome_findAllMenu] Fin");
				
				return aTiido_menuLocalHome.findAllMenu();
			}
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionMenuBean :: find_Tiido_menuLocalHome_findAllMenu] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
	protected Tiido_menuLocal createTiido_menuLocal(Menu mp) {
		log.info("[SesionMenuBean :: createTiido_menuLocal] Inicio");
		
		Tiido_menuLocalHome aTiido_menuLocalHome = (Tiido_menuLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_Tiido_menuLocalHome_REF_NAME,
						STATIC_Tiido_menuLocalHome_CLASS);
		try {
			if (aTiido_menuLocalHome != null) {
				log.info("[SesionMenuBean :: createTiido_menuLocal] Fin");
				
				return aTiido_menuLocalHome.create(mp);
			}
		} catch (javax.ejb.CreateException ce) {
		} catch (Exception e) {
			log.error("[SesionMenuBean :: createTiido_menuLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}
}
