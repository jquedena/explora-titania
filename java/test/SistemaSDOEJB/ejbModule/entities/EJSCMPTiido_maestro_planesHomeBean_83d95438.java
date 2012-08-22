package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_maestro_planesHomeBean_83d95438
 */
public class EJSCMPTiido_maestro_planesHomeBean_83d95438 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_maestro_planesHomeBean_83d95438
	 */
	public EJSCMPTiido_maestro_planesHomeBean_83d95438() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public entities.Tiido_maestro_planesLocal findByPrimaryKey_Local(entities.Tiido_maestro_planesKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_maestro_planesLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public entities.Tiido_maestro_planesLocal create_Local(java.lang.String mes, java.lang.String anho, entities.Tiido_oficinaLocal argTiido_maepla_oficina_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_maestro_planesLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_maestro_planesBean bean = (entities.Tiido_maestro_planesBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(mes, anho, argTiido_maepla_oficina_fk);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_maestro_planesLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(mes, anho, argTiido_maepla_oficina_fk);
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
	public entities.Tiido_maestro_planesLocal create_Local(java.lang.String mes, java.lang.String anho, java.lang.String tiido_maepla_oficina_fk_cod_ofic, java.lang.String tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_maestro_planesLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_maestro_planesBean bean = (entities.Tiido_maestro_planesBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(mes, anho, tiido_maepla_oficina_fk_cod_ofic, tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_maestro_planesLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(mes, anho, tiido_maepla_oficina_fk_cod_ofic, tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
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
	 * findUbicar_Local
	 */
	public entities.Tiido_maestro_planesLocal findUbicar_Local(java.lang.String mes, java.lang.String anho, java.lang.String codOficina) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_maestro_planesLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_maestro_planesKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_maestro_planes_83d95438 bean = (entities.ConcreteTiido_maestro_planes_83d95438) beanO.getEnterpriseBean();
			pKey = bean.ejbFindUbicar_Local(mes, anho, codOficina);
			result = (entities.Tiido_maestro_planesLocal)activateBean_Local(pKey);
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
	 * findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_maestro_planes_83d95438 bean = (entities.ConcreteTiido_maestro_planes_83d95438) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local(key);
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
		entities.ConcreteTiido_maestro_planes_83d95438 tmpEJB = (entities.ConcreteTiido_maestro_planes_83d95438) generalEJB;
		entities.Tiido_maestro_planesKey keyClass = new entities.Tiido_maestro_planesKey();
		keyClass.mes = tmpEJB.getMes();
		keyClass.anho = tmpEJB.getAnho();
		keyClass.tiido_maepla_oficina_fk_cod_ofic = tmpEJB.getTiido_maepla_oficina_fk_cod_ofic();
		keyClass.tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr = tmpEJB.getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_maestro_planesKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2, java.lang.String f3) {
		entities.Tiido_maestro_planesKey keyClass = new entities.Tiido_maestro_planesKey();
		keyClass.mes = f0;
		keyClass.anho = f1;
		keyClass.tiido_maepla_oficina_fk_cod_ofic = f2;
		keyClass.tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr = f3;
		return keyClass;
	}
}
