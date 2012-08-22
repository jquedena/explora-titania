package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_permiso_perfilHomeBean_edfb184d
 */
public class EJSCMPTiido_permiso_perfilHomeBean_edfb184d extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_permiso_perfilHomeBean_edfb184d
	 */
	public EJSCMPTiido_permiso_perfilHomeBean_edfb184d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public entities.Tiido_permiso_perfilLocal findByPrimaryKey_Local(entities.Tiido_permiso_perfilKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_permiso_perfilLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * findPermisoPerfilxTipAccxValorRCP_Local
	 */
	public java.util.Collection findPermisoPerfilxTipAccxValorRCP_Local(java.lang.String tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_permiso_perfil_edfb184d bean = (entities.ConcreteTiido_permiso_perfil_edfb184d) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindPermisoPerfilxTipAccxValorRCP_Local(tipo_acceso, valor_rcp);
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
	public entities.Tiido_permiso_perfilLocal create_Local(java.lang.String cod_perfil, java.lang.String tip_acceso, java.lang.String valor_rcp) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_permiso_perfilLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_permiso_perfilBean bean = (entities.Tiido_permiso_perfilBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_perfil, tip_acceso, valor_rcp);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_permiso_perfilLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_perfil, tip_acceso, valor_rcp);
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
	 * findAllPermisoPerfil_Local
	 */
	public java.util.Collection findAllPermisoPerfil_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			entities.ConcreteTiido_permiso_perfil_edfb184d bean = (entities.ConcreteTiido_permiso_perfil_edfb184d) beanO.getEnterpriseBean();
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
	 * create_Local
	 */
	public entities.Tiido_permiso_perfilLocal create_Local(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil permisoPerfil) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_permiso_perfilLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_permiso_perfilBean bean = (entities.Tiido_permiso_perfilBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(permisoPerfil);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_permiso_perfilLocal) super.postCreate_Local(beanO, ejsKey, true);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_permiso_perfil_edfb184d tmpEJB = (entities.ConcreteTiido_permiso_perfil_edfb184d) generalEJB;
		entities.Tiido_permiso_perfilKey keyClass = new entities.Tiido_permiso_perfilKey();
		keyClass.cod_perfil = tmpEJB.getCod_perfil();
		keyClass.tip_acceso = tmpEJB.getTip_acceso();
		keyClass.valor_rcp = tmpEJB.getValor_rcp();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_permiso_perfilKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2) {
		entities.Tiido_permiso_perfilKey keyClass = new entities.Tiido_permiso_perfilKey();
		keyClass.cod_perfil = f0;
		keyClass.tip_acceso = f1;
		keyClass.valor_rcp = f2;
		return keyClass;
	}
}
