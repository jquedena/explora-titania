package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_firmasHomeBean_7cbca68a
 */
public class EJSCMPTiido_firmasHomeBean_7cbca68a extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_firmasHomeBean_7cbca68a
	 */
	public EJSCMPTiido_firmasHomeBean_7cbca68a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public entities.Tiido_firmasLocal create_Local(java.lang.String cod_firma, entities.Tiido_oficinaLocal argTiido_fir_oficina_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_firmasLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_firmasBean bean = (entities.Tiido_firmasBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_firma, argTiido_fir_oficina_fk);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_firmasLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_firma, argTiido_fir_oficina_fk);
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
	public entities.Tiido_firmasLocal create_Local(java.lang.String cod_firma, java.lang.String tiido_fir_oficina_fk_cod_ofic, java.lang.String tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_firmasLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_firmasBean bean = (entities.Tiido_firmasBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_firma, tiido_fir_oficina_fk_cod_ofic, tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_firmasLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_firma, tiido_fir_oficina_fk_cod_ofic, tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
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
	 * findFirmByAnoMesCgesItem_Local
	 */
	public entities.Tiido_firmasLocal findFirmByAnoMesCgesItem_Local(java.lang.String anho, java.lang.String mes, java.lang.String codGestor, java.lang.String item) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_firmasLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_firmasKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_firmas_7cbca68a bean = (entities.ConcreteTiido_firmas_7cbca68a) beanO.getEnterpriseBean();
			pKey = bean.ejbFindFirmByAnoMesCgesItem_Local(anho, mes, codGestor, item);
			result = (entities.Tiido_firmasLocal)activateBean_Local(pKey);
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
	public entities.Tiido_firmasLocal findByPrimaryKey_Local(entities.Tiido_firmasKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_firmasLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findTiido_firmasByTiido_fir_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_firmasByTiido_fir_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_firmas_7cbca68a bean = (entities.ConcreteTiido_firmas_7cbca68a) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_firmasByTiido_fir_oficina_fkKey_Local(key);
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
		entities.ConcreteTiido_firmas_7cbca68a tmpEJB = (entities.ConcreteTiido_firmas_7cbca68a) generalEJB;
		entities.Tiido_firmasKey keyClass = new entities.Tiido_firmasKey();
		keyClass.cod_firma = tmpEJB.getCod_firma();
		keyClass.tiido_fir_oficina_fk_cod_ofic = tmpEJB.getTiido_fir_oficina_fk_cod_ofic();
		keyClass.tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr = tmpEJB.getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_firmasKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2) {
		entities.Tiido_firmasKey keyClass = new entities.Tiido_firmasKey();
		keyClass.cod_firma = f0;
		keyClass.tiido_fir_oficina_fk_cod_ofic = f1;
		keyClass.tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr = f2;
		return keyClass;
	}
}
