package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_permiso_perfilHomeBean_993509dc
 */
public class EJSCMPTiilc_permiso_perfilHomeBean_993509dc extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_permiso_perfilHomeBean_993509dc
	 */
	public EJSCMPTiilc_permiso_perfilHomeBean_993509dc() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findPermisoPerfil_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal findPermisoPerfil_Local(java.lang.String cod_perfil, int tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindPermisoPerfil_Local(cod_perfil, tipo_acceso, valor_rcp);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal)activateBean_Local(pKey);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findAllPermisoPerfil_Local
	 */
	public java.util.Collection findAllPermisoPerfil_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAllPermisoPerfil_Local();
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
	 * findPermisoPerfilxTipAccxValorRCP_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal findPermisoPerfilxTipAccxValorRCP_Local(int tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal result = null;
		EntityBeanO beanO = null;

		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc bean = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc) beanO.getEnterpriseBean();
			pKey = bean.ejbFindPermisoPerfilxTipAccxValorRCP_Local(tipo_acceso, valor_rcp);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal)activateBean_Local(pKey);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal create_Local(com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil permisoPerfil) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(permisoPerfil);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(permisoPerfil);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal create_Local(java.lang.String cod_perfil, java.math.BigDecimal tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_perfil, tipo_acceso, valor_rcp);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_perfil, tipo_acceso, valor_rcp);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey();
		keyClass.cod_perfil = tmpEJB.getCod_perfil();
		keyClass.tipo_acceso = tmpEJB.getTipo_acceso();
		keyClass.valor_rcp = tmpEJB.getValor_rcp();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey keyFromFields(java.lang.String f0, java.math.BigDecimal f1, java.lang.String f2) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey();
		keyClass.cod_perfil = f0;
		keyClass.tipo_acceso = f1;
		keyClass.valor_rcp = f2;
		return keyClass;
	}
}
