package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_multitablaHomeBean_0ec196aa
 */
public class EJSCMPTiilc_multitablaHomeBean_0ec196aa extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_multitablaHomeBean_0ec196aa
	 */
	public EJSCMPTiilc_multitablaHomeBean_0ec196aa() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal create_Local(com.grupobbva.bc.per.tel.iilc.serializable.Multitabla multitabla) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(multitabla);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(multitabla);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findAllRecord_Local
	 */
	public java.util.Collection findAllRecord_Local(java.lang.String cod_mult) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllRecord_Local(cod_mult);
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
	 * findRecord_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal findRecord_Local(java.lang.String codigo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa) beanO.getEnterpriseBean();
			pKey = bean.ejbFindRecord_Local(codigo);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal)activateBean_Local(pKey);
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
	 * findMultitablaxValor2_Local
	 */
	public java.util.Collection findMultitablaxValor2_Local(java.lang.String valor2) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindMultitablaxValor2_Local(valor2);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal create_Local(java.lang.String cod_mult, java.lang.String cod_ele) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_mult, cod_ele);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_mult, cod_ele);
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
	 * findAllMultitabla_Local
	 */
	public java.util.Collection findAllMultitabla_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllMultitabla_Local();
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
	 * findMultitabla_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal findMultitabla_Local(java.lang.String cod_mult, java.lang.String cod_ele) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa) beanO.getEnterpriseBean();
			pKey = bean.ejbFindMultitabla_Local(cod_mult, cod_ele);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal)activateBean_Local(pKey);
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
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey();
		keyClass.cod_mult = tmpEJB.getCod_mult();
		keyClass.cod_ele = tmpEJB.getCod_ele();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey();
		keyClass.cod_mult = f0;
		keyClass.cod_ele = f1;
		return keyClass;
	}
}
