package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_empresaHomeBean_d572bb0f
 */
public class EJSCMPTiilc_empresaHomeBean_d572bb0f extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_empresaHomeBean_d572bb0f
	 */
	public EJSCMPTiilc_empresaHomeBean_d572bb0f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findAllEmpresa_Local
	 */
	public java.util.Collection findAllEmpresa_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllEmpresa_Local();
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal create_Local(java.lang.String cod_empresa) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_empresa);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_empresa);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal create_Local(java.lang.String cod_empresa, java.lang.String des_empresa) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_empresa, des_empresa);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_empresa, des_empresa);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findEmpresaxCodigo_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal findEmpresaxCodigo_Local(java.lang.String cod_empresa) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f) beanO.getEnterpriseBean();
			pKey = bean.ejbFindEmpresaxCodigo_Local(cod_empresa);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal)activateBean_Local(pKey);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey();
		keyClass.cod_empresa = tmpEJB.getCod_empresa();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey keyFromFields(java.lang.String f0) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey();
		keyClass.cod_empresa = f0;
		return keyClass;
	}
}
