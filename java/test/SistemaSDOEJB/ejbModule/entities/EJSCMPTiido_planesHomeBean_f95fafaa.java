package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_planesHomeBean_f95fafaa
 */
public class EJSCMPTiido_planesHomeBean_f95fafaa extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_planesHomeBean_f95fafaa
	 */
	public EJSCMPTiido_planesHomeBean_f95fafaa() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findConsultaPlanes_Local
	 */
	public java.util.Collection findConsultaPlanes_Local(java.lang.String codOficina, java.lang.String anho, java.lang.String mes) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_planes_f95fafaa bean = (entities.ConcreteTiido_planes_f95fafaa) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindConsultaPlanes_Local(codOficina, anho, mes);
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
	 * findConsultaPlanesPrioridad_Local
	 */
	public entities.Tiido_planesLocal findConsultaPlanesPrioridad_Local(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_planesLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_planesKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_planes_f95fafaa bean = (entities.ConcreteTiido_planes_f95fafaa) beanO.getEnterpriseBean();
			pKey = bean.ejbFindConsultaPlanesPrioridad_Local(mes, anho, codEpigrafe, codOficina);
			result = (entities.Tiido_planesLocal)activateBean_Local(pKey);
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
	public entities.Tiido_planesLocal findByPrimaryKey_Local(entities.Tiido_planesKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_planesLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findConsultarPlanesxMes_Local
	 */
	public java.util.Collection findConsultarPlanesxMes_Local(java.lang.String codOficina, java.lang.String anho) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_planes_f95fafaa bean = (entities.ConcreteTiido_planes_f95fafaa) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindConsultarPlanesxMes_Local(codOficina, anho);
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
	public entities.Tiido_planesLocal create_Local(java.lang.String mes_plan, java.lang.String anho_plan, java.lang.String cod_epigrafe, entities.Tiido_oficinaLocal argTiido_pla_oficina_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_planesLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_planesBean bean = (entities.Tiido_planesBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(mes_plan, anho_plan, cod_epigrafe, argTiido_pla_oficina_fk);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_planesLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(mes_plan, anho_plan, cod_epigrafe, argTiido_pla_oficina_fk);
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
	public entities.Tiido_planesLocal create_Local(java.lang.String mes_plan, java.lang.String anho_plan, java.lang.String cod_epigrafe, java.lang.String tiido_pla_oficina_fk_cod_ofic, java.lang.String tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_planesLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_planesBean bean = (entities.Tiido_planesBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(mes_plan, anho_plan, cod_epigrafe, tiido_pla_oficina_fk_cod_ofic, tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_planesLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(mes_plan, anho_plan, cod_epigrafe, tiido_pla_oficina_fk_cod_ofic, tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
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
	 * findConsultaPlanesResumen_Local
	 */
	public entities.Tiido_planesLocal findConsultaPlanesResumen_Local(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_planesLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_planesKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_planes_f95fafaa bean = (entities.ConcreteTiido_planes_f95fafaa) beanO.getEnterpriseBean();
			pKey = bean.ejbFindConsultaPlanesResumen_Local(mes, anho, codEpigrafe, codOficina);
			result = (entities.Tiido_planesLocal)activateBean_Local(pKey);
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
	public entities.Tiido_planesLocal create_Local(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_planesLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_planesBean bean = (entities.Tiido_planesBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(plan);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_planesLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(plan);
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
	 * findPlanByObject_Local
	 */
	public entities.Tiido_planesLocal findPlanByObject_Local(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws javax.ejb.FinderException, java.rmi.RemoteException {
		entities.Tiido_planesLocal result = null;
		EntityBeanO beanO = null;

		entities.Tiido_planesKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_planes_f95fafaa bean = (entities.ConcreteTiido_planes_f95fafaa) beanO.getEnterpriseBean();
			pKey = bean.ejbFindPlanByObject_Local(mes, anho, codEpigrafe, codOficina);
			result = (entities.Tiido_planesLocal)activateBean_Local(pKey);
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
	 * findTiido_planesByTiido_pla_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_planesByTiido_pla_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_planes_f95fafaa bean = (entities.ConcreteTiido_planes_f95fafaa) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiido_planesByTiido_pla_oficina_fkKey_Local(key);
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
		entities.ConcreteTiido_planes_f95fafaa tmpEJB = (entities.ConcreteTiido_planes_f95fafaa) generalEJB;
		entities.Tiido_planesKey keyClass = new entities.Tiido_planesKey();
		keyClass.mes_plan = tmpEJB.getMes_plan();
		keyClass.anho_plan = tmpEJB.getAnho_plan();
		keyClass.cod_epigrafe = tmpEJB.getCod_epigrafe();
		keyClass.tiido_pla_oficina_fk_cod_ofic = tmpEJB.getTiido_pla_oficina_fk_cod_ofic();
		keyClass.tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr = tmpEJB.getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_planesKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2, java.lang.String f3, java.lang.String f4) {
		entities.Tiido_planesKey keyClass = new entities.Tiido_planesKey();
		keyClass.mes_plan = f0;
		keyClass.anho_plan = f1;
		keyClass.cod_epigrafe = f2;
		keyClass.tiido_pla_oficina_fk_cod_ofic = f3;
		keyClass.tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr = f4;
		return keyClass;
	}
}
