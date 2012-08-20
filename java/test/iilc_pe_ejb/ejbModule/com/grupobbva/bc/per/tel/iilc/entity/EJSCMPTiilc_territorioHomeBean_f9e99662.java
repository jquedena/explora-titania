package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_territorioHomeBean_f9e99662
 */
public class EJSCMPTiilc_territorioHomeBean_f9e99662 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_territorioHomeBean_f9e99662
	 */
	public EJSCMPTiilc_territorioHomeBean_f9e99662() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal create_Local(java.lang.String cod_territorio, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal argTiilc_area_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_territorio, argTiilc_area_fk);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_territorio, argTiilc_area_fk);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal create_Local(java.lang.String cod_territorio, java.lang.String tiilc_area_fk_cod_area, java.lang.String des_territorio) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_territorio, tiilc_area_fk_cod_area, des_territorio);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_territorio, tiilc_area_fk_cod_area, des_territorio);
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
	 * findAllTerritorioxAr_Local
	 */
	public java.util.Collection findAllTerritorioxAr_Local(java.lang.String cod_area) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllTerritorioxAr_Local(cod_area);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal create_Local(java.lang.String cod_territorio, java.lang.String tiilc_area_fk_cod_area) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_territorio, tiilc_area_fk_cod_area);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_territorio, tiilc_area_fk_cod_area);
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
	 * findAllTerritorio_Local
	 */
	public java.util.Collection findAllTerritorio_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662) beanO.getEnterpriseBean();
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
	 * findTiilc_territorioByTiilc_area_fkKey_Local
	 */
	public java.util.Collection findTiilc_territorioByTiilc_area_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiilc_territorioByTiilc_area_fkKey_Local(key);
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
	 * findTiilc_territorio_fkByTiilc_oficinaKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal findTiilc_territorio_fkByTiilc_oficinaKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiilc_territorio_fkByTiilc_oficinaKey_Local(key);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal)activateBean_Local(pKey);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal findByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey();
		keyClass.cod_territorio = tmpEJB.getCod_territorio();
		keyClass.tiilc_area_fk_cod_area = tmpEJB.getTiilc_area_fk_cod_area();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey();
		keyClass.cod_territorio = f0;
		keyClass.tiilc_area_fk_cod_area = f1;
		return keyClass;
	}
}
