package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_epigrafeHomeBean_b2c8f8ed
 */
public class EJSCMPTiido_epigrafeHomeBean_b2c8f8ed extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_epigrafeHomeBean_b2c8f8ed
	 */
	public EJSCMPTiido_epigrafeHomeBean_b2c8f8ed() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByCodEpigAnho_Local
	 */
	public entities.Tiido_epigrafeLocal findByCodEpigAnho_Local(java.lang.String codEpigrafe, java.lang.String anho) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_epigrafeLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_epigrafeKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_epigrafe_b2c8f8ed bean = (entities.ConcreteTiido_epigrafe_b2c8f8ed) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByCodEpigAnho_Local(codEpigrafe, anho);
			result = (entities.Tiido_epigrafeLocal)activateBean_Local(pKey);
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
	public entities.Tiido_epigrafeLocal findByPrimaryKey_Local(entities.Tiido_epigrafeKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_epigrafeLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_epigrafeLocal create_Local(java.lang.String cod_epigrafe, java.lang.String anho) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_epigrafeLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_epigrafeBean bean = (entities.Tiido_epigrafeBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_epigrafe, anho);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_epigrafeLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_epigrafe, anho);
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
	public entities.Tiido_epigrafeLocal create_Local(com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe epigrafe) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_epigrafeLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_epigrafeBean bean = (entities.Tiido_epigrafeBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(epigrafe);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_epigrafeLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(epigrafe);
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
	 * findEpiByAnho_Local
	 */
	public java.util.Collection findEpiByAnho_Local(java.lang.String anho) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_epigrafe_b2c8f8ed bean = (entities.ConcreteTiido_epigrafe_b2c8f8ed) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindEpiByAnho_Local(anho);
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
	 * findByCodEpig_Local
	 */
	public entities.Tiido_epigrafeLocal findByCodEpig_Local(java.lang.String codEpigrafe) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_epigrafeLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_epigrafeKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_epigrafe_b2c8f8ed bean = (entities.ConcreteTiido_epigrafe_b2c8f8ed) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByCodEpig_Local(codEpigrafe);
			result = (entities.Tiido_epigrafeLocal)activateBean_Local(pKey);
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
	 * findTiido_acc_epigrafe_fkByTiido_accionesKey_Local
	 */
	public entities.Tiido_epigrafeLocal findTiido_acc_epigrafe_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_epigrafeLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_epigrafeKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_epigrafe_b2c8f8ed bean = (entities.ConcreteTiido_epigrafe_b2c8f8ed) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_acc_epigrafe_fkByTiido_accionesKey_Local(key);
			result = (entities.Tiido_epigrafeLocal)activateBean_Local(pKey);
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
	 * findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local
	 */
	public entities.Tiido_epigrafeLocal findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_epigrafeLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_epigrafeKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_epigrafe_b2c8f8ed bean = (entities.ConcreteTiido_epigrafe_b2c8f8ed) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local(key);
			result = (entities.Tiido_epigrafeLocal)activateBean_Local(pKey);
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
	public entities.Tiido_epigrafeLocal findByPrimaryKeyForCMR_Local(entities.Tiido_epigrafeKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_epigrafeLocal)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_epigrafe_b2c8f8ed tmpEJB = (entities.ConcreteTiido_epigrafe_b2c8f8ed) generalEJB;
		entities.Tiido_epigrafeKey keyClass = new entities.Tiido_epigrafeKey();
		keyClass.cod_epigrafe = tmpEJB.getCod_epigrafe();
		keyClass.anho = tmpEJB.getAnho();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_epigrafeKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		entities.Tiido_epigrafeKey keyClass = new entities.Tiido_epigrafeKey();
		keyClass.cod_epigrafe = f0;
		keyClass.anho = f1;
		return keyClass;
	}
}
