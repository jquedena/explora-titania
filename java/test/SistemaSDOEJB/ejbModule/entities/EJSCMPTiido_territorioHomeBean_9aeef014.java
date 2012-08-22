package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_territorioHomeBean_9aeef014
 */
public class EJSCMPTiido_territorioHomeBean_9aeef014 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_territorioHomeBean_9aeef014
	 */
	public EJSCMPTiido_territorioHomeBean_9aeef014() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public entities.Tiido_territorioLocal findByPrimaryKey_Local(entities.Tiido_territorioKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_territorioLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_territorioLocal create_Local(java.lang.String cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_territorioLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_territorioBean bean = (entities.Tiido_territorioBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_territorioLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_terr);
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
	 * findByCodTerritorio_Local
	 */
	public entities.Tiido_territorioLocal findByCodTerritorio_Local(java.lang.String codTerritorio) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_territorioLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_territorioKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_territorio_9aeef014 bean = (entities.ConcreteTiido_territorio_9aeef014) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByCodTerritorio_Local(codTerritorio);
			result = (entities.Tiido_territorioLocal)activateBean_Local(pKey);
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
	 * findAllTerritorio_Local
	 */
	public java.util.Collection findAllTerritorio_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_territorio_9aeef014 bean = (entities.ConcreteTiido_territorio_9aeef014) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllTerritorio_Local();
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
	 * findTiido_territorio_fkByTiido_oficinaKey_Local
	 */
	public entities.Tiido_territorioLocal findTiido_territorio_fkByTiido_oficinaKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_territorioLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_territorioKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_territorio_9aeef014 bean = (entities.ConcreteTiido_territorio_9aeef014) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_territorio_fkByTiido_oficinaKey_Local(key);
			result = (entities.Tiido_territorioLocal)activateBean_Local(pKey);
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
	 * findByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_territorioLocal findByPrimaryKeyForCMR_Local(entities.Tiido_territorioKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_territorioLocal)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_territorio_9aeef014 tmpEJB = (entities.ConcreteTiido_territorio_9aeef014) generalEJB;
		entities.Tiido_territorioKey keyClass = new entities.Tiido_territorioKey();
		keyClass.cod_terr = tmpEJB.getCod_terr();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_territorioKey keyFromFields(java.lang.String f0) {
		entities.Tiido_territorioKey keyClass = new entities.Tiido_territorioKey();
		keyClass.cod_terr = f0;
		return keyClass;
	}
}
