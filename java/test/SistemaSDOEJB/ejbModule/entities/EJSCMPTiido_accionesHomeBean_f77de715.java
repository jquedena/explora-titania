package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_accionesHomeBean_f77de715
 */
public class EJSCMPTiido_accionesHomeBean_f77de715 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_accionesHomeBean_f77de715
	 */
	public EJSCMPTiido_accionesHomeBean_f77de715() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public entities.Tiido_accionesLocal findByPrimaryKey_Local(entities.Tiido_accionesKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_accionesLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_accionesLocal create_Local(java.lang.Integer cod_acci, entities.Tiido_epigrafeLocal argTiido_acc_epigrafe_fk, entities.Tiido_oficinaLocal argTiido_acc_oficina_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_accionesLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_accionesBean bean = (entities.Tiido_accionesBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_acci, argTiido_acc_epigrafe_fk, argTiido_acc_oficina_fk);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_accionesLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_acci, argTiido_acc_epigrafe_fk, argTiido_acc_oficina_fk);
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
	public entities.Tiido_accionesLocal create_Local(java.lang.Integer cod_acci, java.lang.String tiido_acc_epigrafe_fk_cod_epigrafe, java.lang.String tiido_acc_epigrafe_fk_anho, java.lang.String tiido_acc_oficina_fk_cod_ofic, java.lang.String tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_accionesLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_accionesBean bean = (entities.Tiido_accionesBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_acci, tiido_acc_epigrafe_fk_cod_epigrafe, tiido_acc_epigrafe_fk_anho, tiido_acc_oficina_fk_cod_ofic, tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_accionesLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_acci, tiido_acc_epigrafe_fk_cod_epigrafe, tiido_acc_epigrafe_fk_anho, tiido_acc_oficina_fk_cod_ofic, tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
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
	 * findTiido_accionesByTiido_acc_epigrafe_fkKey_Local
	 */
	public java.util.Collection findTiido_accionesByTiido_acc_epigrafe_fkKey_Local(entities.Tiido_epigrafeKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_acciones_f77de715 bean = (entities.ConcreteTiido_acciones_f77de715) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_accionesByTiido_acc_epigrafe_fkKey_Local(key);
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
	 * findTiido_accionesByTiido_acc_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_accionesByTiido_acc_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_acciones_f77de715 bean = (entities.ConcreteTiido_acciones_f77de715) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_accionesByTiido_acc_oficina_fkKey_Local(key);
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
		entities.ConcreteTiido_acciones_f77de715 tmpEJB = (entities.ConcreteTiido_acciones_f77de715) generalEJB;
		entities.Tiido_accionesKey keyClass = new entities.Tiido_accionesKey();
		keyClass.cod_acci = tmpEJB.getCod_acci();
		keyClass.tiido_acc_epigrafe_fk_cod_epigrafe = tmpEJB.getTiido_acc_epigrafe_fk_cod_epigrafe();
		keyClass.tiido_acc_epigrafe_fk_anho = tmpEJB.getTiido_acc_epigrafe_fk_anho();
		keyClass.tiido_acc_oficina_fk_cod_ofic = tmpEJB.getTiido_acc_oficina_fk_cod_ofic();
		keyClass.tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr = tmpEJB.getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_accionesKey keyFromFields(java.lang.Integer f0, java.lang.String f1, java.lang.String f2, java.lang.String f3, java.lang.String f4) {
		entities.Tiido_accionesKey keyClass = new entities.Tiido_accionesKey();
		keyClass.cod_acci = f0;
		keyClass.tiido_acc_epigrafe_fk_cod_epigrafe = f1;
		keyClass.tiido_acc_epigrafe_fk_anho = f2;
		keyClass.tiido_acc_oficina_fk_cod_ofic = f3;
		keyClass.tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr = f4;
		return keyClass;
	}
}
