package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_totalHomeBean_40ed895e
 */
public class EJSCMPTiilc_totalHomeBean_40ed895e extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_totalHomeBean_40ed895e
	 */
	public EJSCMPTiilc_totalHomeBean_40ed895e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findTotalxGexOfxTe_Local
	 */
	public java.util.Collection findTotalxGexOfxTe_Local(java.lang.String ind_registro, java.lang.String cod_territorio, java.lang.String cod_oficina, java.lang.String cod_gestor) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_total_40ed895e bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_total_40ed895e) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTotalxGexOfxTe_Local(ind_registro, cod_territorio, cod_oficina, cod_gestor);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal create_Local(java.math.BigDecimal cod_total) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_total);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_total);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal create_Local(com.grupobbva.bc.per.tel.iilc.serializable.Total total) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(total);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(total);
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
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_total_40ed895e tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_total_40ed895e) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey();
		keyClass.cod_total = tmpEJB.getCod_total();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey keyFromFields(java.math.BigDecimal f0) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey();
		keyClass.cod_total = f0;
		return keyClass;
	}
}
