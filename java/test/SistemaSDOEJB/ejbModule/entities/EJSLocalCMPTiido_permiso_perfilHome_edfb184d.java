package entities;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiido_permiso_perfilHome_edfb184d
 */
public class EJSLocalCMPTiido_permiso_perfilHome_edfb184d extends EJSLocalWrapper implements entities.Tiido_permiso_perfilLocalHome, entities.websphere_deploy.Tiido_permiso_perfilBeanInternalLocalHome_edfb184d {
	/**
	 * EJSLocalCMPTiido_permiso_perfilHome_edfb184d
	 */
	public EJSLocalCMPTiido_permiso_perfilHome_edfb184d() {
		super();	}
	/**
	 * create
	 */
	public entities.Tiido_permiso_perfilLocal create(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil permisoPerfil) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_permiso_perfilLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = permisoPerfil;
			}
	entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d _EJS_beanRef = (entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(permisoPerfil);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 0, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * create
	 */
	public entities.Tiido_permiso_perfilLocal create(java.lang.String cod_perfil, java.lang.String tip_acceso, java.lang.String valor_rcp) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_permiso_perfilLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = cod_perfil;
				_jacc_parms[1] = tip_acceso;
				_jacc_parms[2] = valor_rcp;
			}
	entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d _EJS_beanRef = (entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_perfil, tip_acceso, valor_rcp);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 1, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public entities.Tiido_permiso_perfilLocal findByPrimaryKey(entities.Tiido_permiso_perfilKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_permiso_perfilLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d _EJS_beanRef = (entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByPrimaryKey_Local(primaryKey);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllPermisoPerfil
	 */
	public java.util.Collection findAllPermisoPerfil() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d _EJS_beanRef = (entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllPermisoPerfil_Local();
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 3, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPermisoPerfilxTipAccxValorRCP
	 */
	public java.util.Collection findPermisoPerfilxTipAccxValorRCP(java.lang.String tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = tipo_acceso;
				_jacc_parms[1] = valor_rcp;
			}
	entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d _EJS_beanRef = (entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findPermisoPerfilxTipAccxValorRCP_Local(tipo_acceso, valor_rcp);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 4, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = arg0;
			}
	entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d _EJS_beanRef = (entities.EJSCMPTiido_permiso_perfilHomeBean_edfb184d)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_beanRef.remove(arg0);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.EJBException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 5, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
