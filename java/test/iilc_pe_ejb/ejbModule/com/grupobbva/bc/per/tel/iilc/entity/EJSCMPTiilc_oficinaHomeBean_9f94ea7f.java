package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_oficinaHomeBean_9f94ea7f
 */
public class EJSCMPTiilc_oficinaHomeBean_9f94ea7f extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_oficinaHomeBean_9f94ea7f
	 */
	public EJSCMPTiilc_oficinaHomeBean_9f94ea7f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findAllOficinaxTer_Local
	 */
	public java.util.Collection findAllOficinaxTer_Local(java.lang.String cod_territorio) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllOficinaxTer_Local(cod_territorio);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal create_Local(java.lang.String cod_oficina, java.lang.String tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal create_Local(java.lang.String cod_oficina, java.lang.String tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area, java.lang.String des_oficina) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area, des_oficina);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area, des_oficina);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal create_Local(java.lang.String cod_oficina, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal argTiilc_territorio_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_oficina, argTiilc_territorio_fk);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_oficina, argTiilc_territorio_fk);
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
	 * findAllOficinaxCod_oficina_Local
	 */
	public java.util.Collection findAllOficinaxCod_oficina_Local(java.lang.String cod_oficina) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllOficinaxCod_oficina_Local(cod_oficina);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findTiilc_oficinaByTiilc_territorio_fkKey_Local
	 */
	public java.util.Collection findTiilc_oficinaByTiilc_territorio_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiilc_oficinaByTiilc_territorio_fkKey_Local(key);
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
	 * findTiilc_oficina_fkByTiilc_gestorKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal findTiilc_oficina_fkByTiilc_gestorKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiilc_oficina_fkByTiilc_gestorKey_Local(key);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal)activateBean_Local(pKey);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal findByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey();
		keyClass.cod_oficina = tmpEJB.getCod_oficina();
		keyClass.tiilc_territorio_fk_cod_territorio = tmpEJB.getTiilc_territorio_fk_cod_territorio();
		keyClass.tiilc_territorio_fk_tiilc_area_fk_cod_area = tmpEJB.getTiilc_territorio_fk_tiilc_area_fk_cod_area();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey();
		keyClass.cod_oficina = f0;
		keyClass.tiilc_territorio_fk_cod_territorio = f1;
		keyClass.tiilc_territorio_fk_tiilc_area_fk_cod_area = f2;
		return keyClass;
	}
}
