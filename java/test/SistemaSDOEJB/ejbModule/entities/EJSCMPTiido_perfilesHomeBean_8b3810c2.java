package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_perfilesHomeBean_8b3810c2
 */
public class EJSCMPTiido_perfilesHomeBean_8b3810c2 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_perfilesHomeBean_8b3810c2
	 */
	public EJSCMPTiido_perfilesHomeBean_8b3810c2() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findAllPerfil_Local
	 */
	public java.util.Collection findAllPerfil_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_perfiles_8b3810c2 bean = (entities.ConcreteTiido_perfiles_8b3810c2) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllPerfil_Local();
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
	 * findByPrimaryKey_Local
	 */
	public entities.Tiido_perfilesLocal findByPrimaryKey_Local(entities.Tiido_perfilesKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_perfilesLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_perfilesLocal create_Local(com.grupobbva.bc.per.tele.sdo.serializable.Perfil per) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_perfilesLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_perfilesBean bean = (entities.Tiido_perfilesBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(per);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_perfilesLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(per);
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
	 * create_Local
	 */
	public entities.Tiido_perfilesLocal create_Local(java.lang.String cod_perfil) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_perfilesLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_perfilesBean bean = (entities.Tiido_perfilesBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_perfil);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_perfilesLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_perfil);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_perfiles_8b3810c2 tmpEJB = (entities.ConcreteTiido_perfiles_8b3810c2) generalEJB;
		entities.Tiido_perfilesKey keyClass = new entities.Tiido_perfilesKey();
		keyClass.cod_perfil = tmpEJB.getCod_perfil();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_perfilesKey keyFromFields(java.lang.String f0) {
		entities.Tiido_perfilesKey keyClass = new entities.Tiido_perfilesKey();
		keyClass.cod_perfil = f0;
		return keyClass;
	}
}
