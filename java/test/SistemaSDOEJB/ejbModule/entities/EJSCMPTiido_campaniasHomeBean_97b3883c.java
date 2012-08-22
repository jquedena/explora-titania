package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_campaniasHomeBean_97b3883c
 */
public class EJSCMPTiido_campaniasHomeBean_97b3883c extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_campaniasHomeBean_97b3883c
	 */
	public EJSCMPTiido_campaniasHomeBean_97b3883c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public entities.Tiido_campaniasLocal findByPrimaryKey_Local(entities.Tiido_campaniasKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_campaniasLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_campaniasLocal create_Local(java.lang.Integer cod_camp, java.lang.String anho, java.lang.String mes, entities.Tiido_oficinaLocal argTiido_cam_oficina_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_campaniasLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_campaniasBean bean = (entities.Tiido_campaniasBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_camp, anho, mes, argTiido_cam_oficina_fk);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_campaniasLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_camp, anho, mes, argTiido_cam_oficina_fk);
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
	public entities.Tiido_campaniasLocal create_Local(java.lang.Integer cod_camp, java.lang.String anho, java.lang.String mes, java.lang.String tiido_cam_oficina_fk_cod_ofic, java.lang.String tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_campaniasLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_campaniasBean bean = (entities.Tiido_campaniasBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_camp, anho, mes, tiido_cam_oficina_fk_cod_ofic, tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_campaniasLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_camp, anho, mes, tiido_cam_oficina_fk_cod_ofic, tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
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
	 * findTiido_campaniasByTiido_cam_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_campaniasByTiido_cam_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_campanias_97b3883c bean = (entities.ConcreteTiido_campanias_97b3883c) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_campaniasByTiido_cam_oficina_fkKey_Local(key);
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
	 * findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local
	 */
	public entities.Tiido_campaniasLocal findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local(entities.Tiido_campanias_detalleKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_campaniasLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_campaniasKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_campanias_97b3883c bean = (entities.ConcreteTiido_campanias_97b3883c) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local(key);
			result = (entities.Tiido_campaniasLocal)activateBean_Local(pKey);
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
	public entities.Tiido_campaniasLocal findByPrimaryKeyForCMR_Local(entities.Tiido_campaniasKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_campaniasLocal)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_campanias_97b3883c tmpEJB = (entities.ConcreteTiido_campanias_97b3883c) generalEJB;
		entities.Tiido_campaniasKey keyClass = new entities.Tiido_campaniasKey();
		keyClass.cod_camp = tmpEJB.getCod_camp();
		keyClass.anho = tmpEJB.getAnho();
		keyClass.mes = tmpEJB.getMes();
		keyClass.tiido_cam_oficina_fk_cod_ofic = tmpEJB.getTiido_cam_oficina_fk_cod_ofic();
		keyClass.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr = tmpEJB.getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_campaniasKey keyFromFields(java.lang.Integer f0, java.lang.String f1, java.lang.String f2, java.lang.String f3, java.lang.String f4) {
		entities.Tiido_campaniasKey keyClass = new entities.Tiido_campaniasKey();
		keyClass.cod_camp = f0;
		keyClass.anho = f1;
		keyClass.mes = f2;
		keyClass.tiido_cam_oficina_fk_cod_ofic = f3;
		keyClass.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr = f4;
		return keyClass;
	}
}
