package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_perfilHomeBean_52a28827
 */
public class EJSCMPTiilc_perfilHomeBean_52a28827 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_perfilHomeBean_52a28827
	 */
	public EJSCMPTiilc_perfilHomeBean_52a28827() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findPerfil_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal findPerfil_Local(java.lang.String cod_perfil) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827 bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827) beanO.getEnterpriseBean();
			pKey = bean.ejbFindPerfil_Local(cod_perfil);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal)activateBean_Local(pKey);
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
	 * findAllPerfil_Local
	 */
	public java.util.Collection findAllPerfil_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827 bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827) beanO.getEnterpriseBean();
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
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal create_Local(com.grupobbva.bc.per.tel.iilc.serializable.Perfil perfil) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(perfil);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(perfil);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal create_Local(java.lang.String cod_perfil) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_perfil);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal) super.postCreate_Local(beanO, ejsKey, true);
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
	 * findByPrimaryKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827 tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey();
		keyClass.cod_perfil = tmpEJB.getCod_perfil();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey keyFromFields(java.lang.String f0) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey();
		keyClass.cod_perfil = f0;
		return keyClass;
	}
}
