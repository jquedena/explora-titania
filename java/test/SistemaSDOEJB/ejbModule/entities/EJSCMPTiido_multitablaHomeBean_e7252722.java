package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_multitablaHomeBean_e7252722
 */
public class EJSCMPTiido_multitablaHomeBean_e7252722 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_multitablaHomeBean_e7252722
	 */
	public EJSCMPTiido_multitablaHomeBean_e7252722() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findMultiByPrimaryKey_Local
	 */
	public entities.Tiido_multitablaLocal findMultiByPrimaryKey_Local(java.lang.String codMulti, java.lang.String codElem) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_multitablaLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_multitablaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_multitabla_e7252722 bean = (entities.ConcreteTiido_multitabla_e7252722) beanO.getEnterpriseBean();
			pKey = bean.ejbFindMultiByPrimaryKey_Local(codMulti, codElem);
			result = (entities.Tiido_multitablaLocal)activateBean_Local(pKey);
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
	 * findByID_Local
	 */
	public entities.Tiido_multitablaLocal findByID_Local(java.lang.String id) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_multitablaLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_multitablaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_multitabla_e7252722 bean = (entities.ConcreteTiido_multitabla_e7252722) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByID_Local(id);
			result = (entities.Tiido_multitablaLocal)activateBean_Local(pKey);
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
	public entities.Tiido_multitablaLocal create_Local(java.lang.String cod_mult, java.lang.String cod_elem) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_multitablaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_multitablaBean bean = (entities.Tiido_multitablaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_mult, cod_elem);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_multitablaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_mult, cod_elem);
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
	 * findByMultiForPresup_Local
	 */
	public java.util.Collection findByMultiForPresup_Local(java.lang.String codMulti, java.lang.String Valor2) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_multitabla_e7252722 bean = (entities.ConcreteTiido_multitabla_e7252722) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByMultiForPresup_Local(codMulti, Valor2);
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
	 * findByCodMulti_Local
	 */
	public java.util.Collection findByCodMulti_Local(java.lang.String codMulti) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_multitabla_e7252722 bean = (entities.ConcreteTiido_multitabla_e7252722) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindByCodMulti_Local(codMulti);
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
	public entities.Tiido_multitablaLocal findByPrimaryKey_Local(entities.Tiido_multitablaKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_multitablaLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_multitabla_e7252722 tmpEJB = (entities.ConcreteTiido_multitabla_e7252722) generalEJB;
		entities.Tiido_multitablaKey keyClass = new entities.Tiido_multitablaKey();
		keyClass.cod_mult = tmpEJB.getCod_mult();
		keyClass.cod_elem = tmpEJB.getCod_elem();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_multitablaKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		entities.Tiido_multitablaKey keyClass = new entities.Tiido_multitablaKey();
		keyClass.cod_mult = f0;
		keyClass.cod_elem = f1;
		return keyClass;
	}
}
