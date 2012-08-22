package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_campanias_detalleHomeBean_6826fb65
 */
public class EJSCMPTiido_campanias_detalleHomeBean_6826fb65 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_campanias_detalleHomeBean_6826fb65
	 */
	public EJSCMPTiido_campanias_detalleHomeBean_6826fb65() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public entities.Tiido_campanias_detalleLocal create_Local(java.lang.Integer cod_camp_deta, entities.Tiido_campaniasLocal argTiido_camdet_campanias_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_campanias_detalleLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_campanias_detalleBean bean = (entities.Tiido_campanias_detalleBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_camp_deta, argTiido_camdet_campanias_fk);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_campanias_detalleLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_camp_deta, argTiido_camdet_campanias_fk);
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
	public entities.Tiido_campanias_detalleLocal findByPrimaryKey_Local(entities.Tiido_campanias_detalleKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_campanias_detalleLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_campanias_detalleLocal create_Local(java.lang.Integer cod_camp_deta, java.lang.Integer tiido_camdet_campanias_fk_cod_camp, java.lang.String tiido_camdet_campanias_fk_anho, java.lang.String tiido_camdet_campanias_fk_mes, java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic, java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_campanias_detalleLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_campanias_detalleBean bean = (entities.Tiido_campanias_detalleBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_camp_deta, tiido_camdet_campanias_fk_cod_camp, tiido_camdet_campanias_fk_anho, tiido_camdet_campanias_fk_mes, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_campanias_detalleLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_camp_deta, tiido_camdet_campanias_fk_cod_camp, tiido_camdet_campanias_fk_anho, tiido_camdet_campanias_fk_mes, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
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
	 * findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local
	 */
	public java.util.Collection findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local(entities.Tiido_campaniasKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_campanias_detalle_6826fb65 bean = (entities.ConcreteTiido_campanias_detalle_6826fb65) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local(key);
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
		entities.ConcreteTiido_campanias_detalle_6826fb65 tmpEJB = (entities.ConcreteTiido_campanias_detalle_6826fb65) generalEJB;
		entities.Tiido_campanias_detalleKey keyClass = new entities.Tiido_campanias_detalleKey();
		keyClass.cod_camp_deta = tmpEJB.getCod_camp_deta();
		keyClass.tiido_camdet_campanias_fk_cod_camp = tmpEJB.getTiido_camdet_campanias_fk_cod_camp();
		keyClass.tiido_camdet_campanias_fk_anho = tmpEJB.getTiido_camdet_campanias_fk_anho();
		keyClass.tiido_camdet_campanias_fk_mes = tmpEJB.getTiido_camdet_campanias_fk_mes();
		keyClass.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic = tmpEJB.getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic();
		keyClass.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr = tmpEJB.getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_campanias_detalleKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1, java.lang.String f2, java.lang.String f3, java.lang.String f4, java.lang.String f5) {
		entities.Tiido_campanias_detalleKey keyClass = new entities.Tiido_campanias_detalleKey();
		keyClass.cod_camp_deta = f0;
		keyClass.tiido_camdet_campanias_fk_cod_camp = f1;
		keyClass.tiido_camdet_campanias_fk_anho = f2;
		keyClass.tiido_camdet_campanias_fk_mes = f3;
		keyClass.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic = f4;
		keyClass.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr = f5;
		return keyClass;
	}
}
