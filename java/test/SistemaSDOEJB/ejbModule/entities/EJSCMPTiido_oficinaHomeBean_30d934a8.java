package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_oficinaHomeBean_30d934a8
 */
public class EJSCMPTiido_oficinaHomeBean_30d934a8 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_oficinaHomeBean_30d934a8
	 */
	public EJSCMPTiido_oficinaHomeBean_30d934a8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findListaByCodOficina_Local
	 */
	public java.util.Collection findListaByCodOficina_Local(java.lang.String codOficina) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindListaByCodOficina_Local(codOficina);
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
	public entities.Tiido_oficinaLocal findByPrimaryKey_Local(entities.Tiido_oficinaKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_oficinaLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_oficinaLocal create_Local(java.lang.String cod_ofic, entities.Tiido_territorioLocal argTiido_territorio_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_oficinaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_oficinaBean bean = (entities.Tiido_oficinaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_ofic, argTiido_territorio_fk);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_oficinaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_ofic, argTiido_territorio_fk);
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
	 * findAllOficinaByCodTerri_Local
	 */
	public java.util.Collection findAllOficinaByCodTerri_Local(java.lang.String codTerritorio) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllOficinaByCodTerri_Local(codTerritorio);
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
	public entities.Tiido_oficinaLocal create_Local(java.lang.String cod_ofic, java.lang.String nom_ofic, java.lang.String tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_oficinaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_oficinaBean bean = (entities.Tiido_oficinaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_ofic, nom_ofic, tiido_territorio_fk_cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_oficinaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_ofic, nom_ofic, tiido_territorio_fk_cod_terr);
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
	public entities.Tiido_oficinaLocal create_Local(java.lang.String cod_ofic, java.lang.String tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_oficinaLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_oficinaBean bean = (entities.Tiido_oficinaBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_ofic, tiido_territorio_fk_cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_oficinaLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_ofic, tiido_territorio_fk_cod_terr);
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
	 * findByCodOficina_Local
	 */
	public entities.Tiido_oficinaLocal findByCodOficina_Local(java.lang.String codOficina) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_oficinaLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_oficinaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByCodOficina_Local(codOficina);
			result = (entities.Tiido_oficinaLocal)activateBean_Local(pKey);
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
	 * findTiido_oficinaByTiido_territorio_fkKey_Local
	 */
	public java.util.Collection findTiido_oficinaByTiido_territorio_fkKey_Local(entities.Tiido_territorioKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_oficinaByTiido_territorio_fkKey_Local(key);
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
	 * findTiido_acc_oficina_fkByTiido_accionesKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_acc_oficina_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_oficinaLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_oficinaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_acc_oficina_fkByTiido_accionesKey_Local(key);
			result = (entities.Tiido_oficinaLocal)activateBean_Local(pKey);
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
	 * findTiido_cam_oficina_fkByTiido_campaniasKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_cam_oficina_fkByTiido_campaniasKey_Local(entities.Tiido_campaniasKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_oficinaLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_oficinaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_cam_oficina_fkByTiido_campaniasKey_Local(key);
			result = (entities.Tiido_oficinaLocal)activateBean_Local(pKey);
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
	 * findTiido_fir_oficina_fkByTiido_firmasKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_fir_oficina_fkByTiido_firmasKey_Local(entities.Tiido_firmasKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_oficinaLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_oficinaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_fir_oficina_fkByTiido_firmasKey_Local(key);
			result = (entities.Tiido_oficinaLocal)activateBean_Local(pKey);
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
	 * findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local(entities.Tiido_maestro_planesKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_oficinaLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_oficinaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local(key);
			result = (entities.Tiido_oficinaLocal)activateBean_Local(pKey);
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
	 * findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_oficinaLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_oficinaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_metges_oficina_fkByTiido_metas_gestorKey_Local(key);
			result = (entities.Tiido_oficinaLocal)activateBean_Local(pKey);
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
	 * findTiido_pla_oficina_fkByTiido_planesKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_pla_oficina_fkByTiido_planesKey_Local(entities.Tiido_planesKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_oficinaLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_oficinaKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_oficina_30d934a8 bean = (entities.ConcreteTiido_oficina_30d934a8) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_pla_oficina_fkByTiido_planesKey_Local(key);
			result = (entities.Tiido_oficinaLocal)activateBean_Local(pKey);
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
	public entities.Tiido_oficinaLocal findByPrimaryKeyForCMR_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_oficinaLocal)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_oficina_30d934a8 tmpEJB = (entities.ConcreteTiido_oficina_30d934a8) generalEJB;
		entities.Tiido_oficinaKey keyClass = new entities.Tiido_oficinaKey();
		keyClass.cod_ofic = tmpEJB.getCod_ofic();
		keyClass.tiido_territorio_fk_cod_terr = tmpEJB.getTiido_territorio_fk_cod_terr();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_oficinaKey keyFromFields(java.lang.String f0, java.lang.String f1) {
		entities.Tiido_oficinaKey keyClass = new entities.Tiido_oficinaKey();
		keyClass.cod_ofic = f0;
		keyClass.tiido_territorio_fk_cod_terr = f1;
		return keyClass;
	}
}
