package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_equivalenciasHomeBean_68a545a3
 */
public class EJSCMPTiido_equivalenciasHomeBean_68a545a3 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_equivalenciasHomeBean_68a545a3
	 */
	public EJSCMPTiido_equivalenciasHomeBean_68a545a3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findEquivalenciaByCodCargo_Local
	 */
	public entities.Tiido_equivalenciasLocal findEquivalenciaByCodCargo_Local(java.lang.String codCargo) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_equivalenciasLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_equivalenciasKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_equivalencias_68a545a3 bean = (entities.ConcreteTiido_equivalencias_68a545a3) beanO.getEnterpriseBean();
			pKey = bean.ejbFindEquivalenciaByCodCargo_Local(codCargo);
			result = (entities.Tiido_equivalenciasLocal)activateBean_Local(pKey);
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
	public entities.Tiido_equivalenciasLocal create_Local(com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia Equivalencia) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_equivalenciasLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_equivalenciasBean bean = (entities.Tiido_equivalenciasBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(Equivalencia);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_equivalenciasLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(Equivalencia);
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
	public entities.Tiido_equivalenciasLocal create_Local(java.lang.String cod_car) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_equivalenciasLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_equivalenciasBean bean = (entities.Tiido_equivalenciasBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_car);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_equivalenciasLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_car);
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
	public entities.Tiido_equivalenciasLocal findByPrimaryKey_Local(entities.Tiido_equivalenciasKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_equivalenciasLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findAllEquivalencias_Local
	 */
	public java.util.Collection findAllEquivalencias_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_equivalencias_68a545a3 bean = (entities.ConcreteTiido_equivalencias_68a545a3) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllEquivalencias_Local();
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_equivalencias_68a545a3 tmpEJB = (entities.ConcreteTiido_equivalencias_68a545a3) generalEJB;
		entities.Tiido_equivalenciasKey keyClass = new entities.Tiido_equivalenciasKey();
		keyClass.cod_car = tmpEJB.getCod_car();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_equivalenciasKey keyFromFields(java.lang.String f0) {
		entities.Tiido_equivalenciasKey keyClass = new entities.Tiido_equivalenciasKey();
		keyClass.cod_car = f0;
		return keyClass;
	}
}
