package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_metas_gestorHomeBean_238e66e0
 */
public class EJSCMPTiido_metas_gestorHomeBean_238e66e0 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_metas_gestorHomeBean_238e66e0
	 */
	public EJSCMPTiido_metas_gestorHomeBean_238e66e0() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findMetGestorByPrimaryKey_Local
	 */
	public entities.Tiido_metas_gestorLocal findMetGestorByPrimaryKey_Local(java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String codGestor) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_metas_gestorLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_metas_gestorKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_metas_gestor_238e66e0 bean = (entities.ConcreteTiido_metas_gestor_238e66e0) beanO.getEnterpriseBean();
			pKey = bean.ejbFindMetGestorByPrimaryKey_Local(codEpigrafe, anho, codOficina, mes, codGestor);
			result = (entities.Tiido_metas_gestorLocal)activateBean_Local(pKey);
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
	public entities.Tiido_metas_gestorLocal create_Local(java.lang.String cod_meta_gestor, entities.Tiido_epigrafeLocal argTiido_metges_epigrafe_fk, entities.Tiido_oficinaLocal argTiido_metges_oficina_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_metas_gestorLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_metas_gestorBean bean = (entities.Tiido_metas_gestorBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_meta_gestor, argTiido_metges_epigrafe_fk, argTiido_metges_oficina_fk);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_metas_gestorLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_meta_gestor, argTiido_metges_epigrafe_fk, argTiido_metges_oficina_fk);
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
	 * findGestorByCodigo_Local
	 */
	public entities.Tiido_metas_gestorLocal findGestorByCodigo_Local(java.lang.String codGestor) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_metas_gestorLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_metas_gestorKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_metas_gestor_238e66e0 bean = (entities.ConcreteTiido_metas_gestor_238e66e0) beanO.getEnterpriseBean();
			pKey = bean.ejbFindGestorByCodigo_Local(codGestor);
			result = (entities.Tiido_metas_gestorLocal)activateBean_Local(pKey);
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
	public entities.Tiido_metas_gestorLocal create_Local(java.lang.String cod_meta_gestor, java.lang.String tiido_metges_epigrafe_fk_cod_epigrafe, java.lang.String tiido_metges_epigrafe_fk_anho, java.lang.String tiido_metges_oficina_fk_cod_ofic, java.lang.String tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_metas_gestorLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_metas_gestorBean bean = (entities.Tiido_metas_gestorBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_meta_gestor, tiido_metges_epigrafe_fk_cod_epigrafe, tiido_metges_epigrafe_fk_anho, tiido_metges_oficina_fk_cod_ofic, tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_metas_gestorLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_meta_gestor, tiido_metges_epigrafe_fk_cod_epigrafe, tiido_metges_epigrafe_fk_anho, tiido_metges_oficina_fk_cod_ofic, tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
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
	public entities.Tiido_metas_gestorLocal create_Local(com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor metasGestor, entities.Tiido_epigrafeLocal epigrafeLocal, entities.Tiido_oficinaLocal oficinaLocal) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_metas_gestorLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_metas_gestorBean bean = (entities.Tiido_metas_gestorBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(metasGestor, epigrafeLocal, oficinaLocal);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_metas_gestorLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(metasGestor, epigrafeLocal, oficinaLocal);
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
	public entities.Tiido_metas_gestorLocal findByPrimaryKey_Local(entities.Tiido_metas_gestorKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_metas_gestorLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local
	 */
	public java.util.Collection findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(entities.Tiido_epigrafeKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_metas_gestor_238e66e0 bean = (entities.ConcreteTiido_metas_gestor_238e66e0) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(key);
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
	 * findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_metas_gestor_238e66e0 bean = (entities.ConcreteTiido_metas_gestor_238e66e0) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(key);
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
		entities.ConcreteTiido_metas_gestor_238e66e0 tmpEJB = (entities.ConcreteTiido_metas_gestor_238e66e0) generalEJB;
		entities.Tiido_metas_gestorKey keyClass = new entities.Tiido_metas_gestorKey();
		keyClass.cod_meta_gestor = tmpEJB.getCod_meta_gestor();
		keyClass.tiido_metges_epigrafe_fk_cod_epigrafe = tmpEJB.getTiido_metges_epigrafe_fk_cod_epigrafe();
		keyClass.tiido_metges_epigrafe_fk_anho = tmpEJB.getTiido_metges_epigrafe_fk_anho();
		keyClass.tiido_metges_oficina_fk_cod_ofic = tmpEJB.getTiido_metges_oficina_fk_cod_ofic();
		keyClass.tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr = tmpEJB.getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_metas_gestorKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2, java.lang.String f3, java.lang.String f4) {
		entities.Tiido_metas_gestorKey keyClass = new entities.Tiido_metas_gestorKey();
		keyClass.cod_meta_gestor = f0;
		keyClass.tiido_metges_epigrafe_fk_cod_epigrafe = f1;
		keyClass.tiido_metges_epigrafe_fk_anho = f2;
		keyClass.tiido_metges_oficina_fk_cod_ofic = f3;
		keyClass.tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr = f4;
		return keyClass;
	}
}
