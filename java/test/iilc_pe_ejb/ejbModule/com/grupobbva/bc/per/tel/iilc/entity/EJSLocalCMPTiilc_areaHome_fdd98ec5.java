package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiilc_areaHome_fdd98ec5
 */
public class EJSLocalCMPTiilc_areaHome_fdd98ec5 extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocalHome, com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_areaBeanInternalLocalHome_fdd98ec5 {
	/**
	 * EJSLocalCMPTiilc_areaHome_fdd98ec5
	 */
	public EJSLocalCMPTiilc_areaHome_fdd98ec5() {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal create(java.lang.String cod_area) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_area);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal create(java.lang.String cod_area, java.lang.String des_area) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_area;
				_jacc_parms[1] = des_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_area, des_area);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal findByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
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
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 3, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * findTiilc_area_fkByTiilc_territorioKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal findTiilc_area_fkByTiilc_territorioKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiilc_area_fkByTiilc_territorioKey_Local(key);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal findByPrimaryKeyForCMR(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_areaHomeBean_fdd98ec5)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
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
