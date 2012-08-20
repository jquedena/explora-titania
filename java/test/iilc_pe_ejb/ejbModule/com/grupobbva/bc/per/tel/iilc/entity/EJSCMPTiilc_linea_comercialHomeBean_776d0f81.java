package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_linea_comercialHomeBean_776d0f81
 */
public class EJSCMPTiilc_linea_comercialHomeBean_776d0f81 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_linea_comercialHomeBean_776d0f81
	 */
	public EJSCMPTiilc_linea_comercialHomeBean_776d0f81() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal create_Local(java.lang.String cod_grupo, java.lang.String cod_lincom, java.lang.String des_lincom) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_grupo, cod_lincom, des_lincom);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_grupo, cod_lincom, des_lincom);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal create_Local(java.lang.String cod_grupo, java.lang.String cod_lincom) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_grupo, cod_lincom);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_grupo, cod_lincom);
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
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81 tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey();
		keyClass.cod_grupo = tmpEJB.getCod_grupo();
		keyClass.cod_lincom = tmpEJB.getCod_lincom();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey();
		keyClass.cod_grupo = f0;
		keyClass.cod_lincom = f1;
		return keyClass;
	}
}
