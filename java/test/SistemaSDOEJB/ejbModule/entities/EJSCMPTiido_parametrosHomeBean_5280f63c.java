package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_parametrosHomeBean_5280f63c
 */
public class EJSCMPTiido_parametrosHomeBean_5280f63c extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_parametrosHomeBean_5280f63c
	 */
	public EJSCMPTiido_parametrosHomeBean_5280f63c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findParametroAll_Local
	 */
	public entities.Tiido_parametrosLocal findParametroAll_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_parametrosLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_parametrosKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_parametros_5280f63c bean = (entities.ConcreteTiido_parametros_5280f63c) beanO.getEnterpriseBean();
			pKey = bean.ejbFindParametroAll_Local();
			result = (entities.Tiido_parametrosLocal)activateBean_Local(pKey);
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
	 * findAllParametros_Local
	 */
	public java.util.Collection findAllParametros_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_parametros_5280f63c bean = (entities.ConcreteTiido_parametros_5280f63c) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllParametros_Local();
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
	public entities.Tiido_parametrosLocal findByPrimaryKey_Local(entities.Tiido_parametrosKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_parametrosLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_parametrosLocal create_Local(java.lang.String cod_parametro) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_parametrosLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_parametrosBean bean = (entities.Tiido_parametrosBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_parametro);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_parametrosLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_parametro);
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
		entities.ConcreteTiido_parametros_5280f63c tmpEJB = (entities.ConcreteTiido_parametros_5280f63c) generalEJB;
		entities.Tiido_parametrosKey keyClass = new entities.Tiido_parametrosKey();
		keyClass.cod_parametro = tmpEJB.getCod_parametro();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_parametrosKey keyFromFields(java.lang.String f0) {
		entities.Tiido_parametrosKey keyClass = new entities.Tiido_parametrosKey();
		keyClass.cod_parametro = f0;
		return keyClass;
	}
}
