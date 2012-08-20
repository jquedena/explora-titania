package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_gestorHomeBean_e8600cef
 */
public class EJSCMPTiilc_gestorHomeBean_e8600cef extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_gestorHomeBean_e8600cef
	 */
	public EJSCMPTiilc_gestorHomeBean_e8600cef() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findAllGestorxOfxTexAr_Local
	 */
	public java.util.Collection findAllGestorxOfxTexAr_Local(java.lang.String cod_oficina, java.lang.String cod_territorio, java.lang.String cod_area) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllGestorxOfxTexAr_Local(cod_oficina, cod_territorio, cod_area);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal create_Local(java.lang.String cod_gestor, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal argTiilc_oficina_fk) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_gestor, argTiilc_oficina_fk);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_gestor, argTiilc_oficina_fk);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findGestorxRegGestor_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal findGestorxRegGestor_Local(java.lang.String reg_gestor) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef) beanO.getEnterpriseBean();
			pKey = bean.ejbFindGestorxRegGestor_Local(reg_gestor);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal)activateBean_Local(pKey);
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
	 * findAllGestor_Local
	 */
	public java.util.Collection findAllGestor_Local(java.lang.String cod_area) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllGestor_Local(cod_area);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal create_Local(java.lang.String cod_gestor, java.lang.String tiilc_oficina_fk_cod_oficina, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area, java.lang.String nom_gestor, java.lang.String reg_gestor, java.lang.String perfil_gestor) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area, nom_gestor, reg_gestor, perfil_gestor);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area, nom_gestor, reg_gestor, perfil_gestor);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal create_Local(java.lang.String cod_gestor, java.lang.String tiilc_oficina_fk_cod_oficina, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
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
	 * findTiilc_gestorByTiilc_oficina_fkKey_Local
	 */
	public java.util.Collection findTiilc_gestorByTiilc_oficina_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTiilc_gestorByTiilc_oficina_fkKey_Local(key);
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
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey();
		keyClass.cod_gestor = tmpEJB.getCod_gestor();
		keyClass.tiilc_oficina_fk_cod_oficina = tmpEJB.getTiilc_oficina_fk_cod_oficina();
		keyClass.tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio = tmpEJB.getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio();
		keyClass.tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area = tmpEJB.getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2, java.lang.String f3) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey();
		keyClass.cod_gestor = f0;
		keyClass.tiilc_oficina_fk_cod_oficina = f1;
		keyClass.tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio = f2;
		keyClass.tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area = f3;
		return keyClass;
	}
}
