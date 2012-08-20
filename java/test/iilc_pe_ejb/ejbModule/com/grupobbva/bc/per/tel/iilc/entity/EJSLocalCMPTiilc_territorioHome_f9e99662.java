package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiilc_territorioHome_f9e99662
 */
public class EJSLocalCMPTiilc_territorioHome_f9e99662 extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocalHome, com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanInternalLocalHome_f9e99662 {
	/**
	 * EJSLocalCMPTiilc_territorioHome_f9e99662
	 */
	public EJSLocalCMPTiilc_territorioHome_f9e99662() {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal create(java.lang.String cod_territorio, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal argTiilc_area_fk) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_territorio;
				_jacc_parms[1] = argTiilc_area_fk;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_territorio, argTiilc_area_fk);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal create(java.lang.String cod_territorio, java.lang.String tiilc_area_fk_cod_area) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_territorio;
				_jacc_parms[1] = tiilc_area_fk_cod_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_territorio, tiilc_area_fk_cod_area);
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
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal create(java.lang.String cod_territorio, java.lang.String tiilc_area_fk_cod_area, java.lang.String des_territorio) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = cod_territorio;
				_jacc_parms[1] = tiilc_area_fk_cod_area;
				_jacc_parms[2] = des_territorio;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_territorio, tiilc_area_fk_cod_area, des_territorio);
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
	 * findByPrimaryKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal findByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
	 * findAllTerritorio
	 */
	public java.util.Collection findAllTerritorio() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllTerritorio_Local();
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
	 * findAllTerritorioxAr
	 */
	public java.util.Collection findAllTerritorioxAr(java.lang.String cod_area) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllTerritorioxAr_Local(cod_area);
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
	public void remove(java.lang.Object arg0) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = arg0;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
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
	 * findTiilc_territorioByTiilc_area_fkKey_Local
	 */
	public java.util.Collection findTiilc_territorioByTiilc_area_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiilc_territorioByTiilc_area_fkKey_Local(key);
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
	 * findTiilc_territorio_fkByTiilc_oficinaKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal findTiilc_territorio_fkByTiilc_oficinaKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiilc_territorio_fkByTiilc_oficinaKey_Local(key);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal findByPrimaryKeyForCMR(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_territorioHomeBean_f9e99662)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
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
