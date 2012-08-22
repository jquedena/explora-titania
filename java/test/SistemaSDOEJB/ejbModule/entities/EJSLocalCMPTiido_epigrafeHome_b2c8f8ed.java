package entities;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiido_epigrafeHome_b2c8f8ed
 */
public class EJSLocalCMPTiido_epigrafeHome_b2c8f8ed extends EJSLocalWrapper implements entities.Tiido_epigrafeLocalHome, entities.websphere_deploy.Tiido_epigrafeBeanInternalLocalHome_b2c8f8ed {
	/**
	 * EJSLocalCMPTiido_epigrafeHome_b2c8f8ed
	 */
	public EJSLocalCMPTiido_epigrafeHome_b2c8f8ed() {
		super();	}
	/**
	 * create
	 */
	public entities.Tiido_epigrafeLocal create(com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe epigrafe) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_epigrafeLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = epigrafe;
			}
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(epigrafe);
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
	public entities.Tiido_epigrafeLocal create(java.lang.String cod_epigrafe, java.lang.String anho) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_epigrafeLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_epigrafe;
				_jacc_parms[1] = anho;
			}
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_epigrafe, anho);
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
	 * findByCodEpig
	 */
	public entities.Tiido_epigrafeLocal findByCodEpig(java.lang.String codEpigrafe) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_epigrafeLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codEpigrafe;
			}
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByCodEpig_Local(codEpigrafe);
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
	 * findByCodEpigAnho
	 */
	public entities.Tiido_epigrafeLocal findByCodEpigAnho(java.lang.String codEpigrafe, java.lang.String anho) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_epigrafeLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codEpigrafe;
				_jacc_parms[1] = anho;
			}
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByCodEpigAnho_Local(codEpigrafe, anho);
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
	 * findByPrimaryKey
	 */
	public entities.Tiido_epigrafeLocal findByPrimaryKey(entities.Tiido_epigrafeKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_epigrafeLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
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
	 * findEpiByAnho
	 */
	public java.util.Collection findEpiByAnho(java.lang.String anho) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = anho;
			}
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findEpiByAnho_Local(anho);
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
				container.postInvoke(this, 5, _EJS_s);
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
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 6, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * findTiido_acc_epigrafe_fkByTiido_accionesKey_Local
	 */
	public entities.Tiido_epigrafeLocal findTiido_acc_epigrafe_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_epigrafeLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_acc_epigrafe_fkByTiido_accionesKey_Local(key);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, -2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local
	 */
	public entities.Tiido_epigrafeLocal findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_epigrafeLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local(key);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, -2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKeyForCMR
	 */
	public entities.Tiido_epigrafeLocal findByPrimaryKeyForCMR(entities.Tiido_epigrafeKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_epigrafeLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed _EJS_beanRef = (entities.EJSCMPTiido_epigrafeHomeBean_b2c8f8ed)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByPrimaryKeyForCMR_Local(key);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, -2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
