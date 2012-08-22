package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_menuHomeBean_3f2247da
 */
public class EJSCMPTiido_menuHomeBean_3f2247da extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_menuHomeBean_3f2247da
	 */
	public EJSCMPTiido_menuHomeBean_3f2247da() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findxCodPerfil_Local
	 */
	public java.util.Collection findxCodPerfil_Local(java.lang.String codPerfil) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_menu_3f2247da bean = (entities.ConcreteTiido_menu_3f2247da) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindxCodPerfil_Local(codPerfil);
			result = super.getCMP20Collection_Local(pKeys);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_menuLocal create_Local(com.grupobbva.bc.per.tele.sdo.serializable.Menu mp) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_menuLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_menuBean bean = (entities.Tiido_menuBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(mp);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_menuLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(mp);
			super.afterPostCreate(beanO, ejsKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if(preCreateFlag && !createFailed)
				super.afterPostCreateCompletion(beanO);
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return result;
	}
	/**
	 * findAllMenu_Local
	 */
	public java.util.Collection findAllMenu_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_menu_3f2247da bean = (entities.ConcreteTiido_menu_3f2247da) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllMenu_Local();
			result = super.getCMP20Collection_Local(pKeys);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_menuLocal create_Local(java.lang.String padre) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_menuLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_menuBean bean = (entities.Tiido_menuBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(padre);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_menuLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(padre);
			super.afterPostCreate(beanO, ejsKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if(preCreateFlag && !createFailed)
				super.afterPostCreateCompletion(beanO);
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return result;
	}
	/**
	 * findByPrimaryKey_Local
	 */
	public entities.Tiido_menuLocal findByPrimaryKey_Local(entities.Tiido_menuKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_menuLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_menu_3f2247da tmpEJB = (entities.ConcreteTiido_menu_3f2247da) generalEJB;
		entities.Tiido_menuKey keyClass = new entities.Tiido_menuKey();
		keyClass.padre = tmpEJB.getPadre();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_menuKey keyFromFields(java.lang.String f0) {
		entities.Tiido_menuKey keyClass = new entities.Tiido_menuKey();
		keyClass.padre = f0;
		return keyClass;
	}
}
