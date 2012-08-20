package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_areaHomeBean_fdd98ec5
 */
public class EJSCMPTiilc_areaHomeBean_fdd98ec5 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_areaHomeBean_fdd98ec5
	 */
	public EJSCMPTiilc_areaHomeBean_fdd98ec5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal create_Local(java.lang.String cod_area) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_area);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_area);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal create_Local(java.lang.String cod_area, java.lang.String des_area) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_area, des_area);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_area, des_area);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findTiilc_area_fkByTiilc_territorioKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal findTiilc_area_fkByTiilc_territorioKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5 bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiilc_area_fkByTiilc_territorioKey_Local(key);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal)activateBean_Local(pKey);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal findByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5 tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey();
		keyClass.cod_area = tmpEJB.getCod_area();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey keyFromFields(java.lang.String f0) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey();
		keyClass.cod_area = f0;
		return keyClass;
	}
}
