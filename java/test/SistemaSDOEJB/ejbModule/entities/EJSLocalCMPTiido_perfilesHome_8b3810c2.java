package entities;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiido_perfilesHome_8b3810c2
 */
public class EJSLocalCMPTiido_perfilesHome_8b3810c2 extends EJSLocalWrapper implements entities.Tiido_perfilesLocalHome, entities.websphere_deploy.Tiido_perfilesBeanInternalLocalHome_8b3810c2 {
	/**
	 * EJSLocalCMPTiido_perfilesHome_8b3810c2
	 */
	public EJSLocalCMPTiido_perfilesHome_8b3810c2() {
		super();	}
	/**
	 * create
	 */
	public entities.Tiido_perfilesLocal create(com.grupobbva.bc.per.tele.sdo.serializable.Perfil per) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_perfilesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = per;
			}
	entities.EJSCMPTiido_perfilesHomeBean_8b3810c2 _EJS_beanRef = (entities.EJSCMPTiido_perfilesHomeBean_8b3810c2)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(per);
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
	public entities.Tiido_perfilesLocal create(java.lang.String cod_perfil) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_perfilesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_perfil;
			}
	entities.EJSCMPTiido_perfilesHomeBean_8b3810c2 _EJS_beanRef = (entities.EJSCMPTiido_perfilesHomeBean_8b3810c2)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_perfil);
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
	public entities.Tiido_perfilesLocal findByPrimaryKey(entities.Tiido_perfilesKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_perfilesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_perfilesHomeBean_8b3810c2 _EJS_beanRef = (entities.EJSCMPTiido_perfilesHomeBean_8b3810c2)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
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
	 * findAllPerfil
	 */
	public java.util.Collection findAllPerfil() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	entities.EJSCMPTiido_perfilesHomeBean_8b3810c2 _EJS_beanRef = (entities.EJSCMPTiido_perfilesHomeBean_8b3810c2)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllPerfil_Local();
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
	 * remove
	 */
	public void remove(java.lang.Object primaryKey) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_perfilesHomeBean_8b3810c2 _EJS_beanRef = (entities.EJSCMPTiido_perfilesHomeBean_8b3810c2)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_beanRef.remove(primaryKey);
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
				container.postInvoke(this, 4, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
