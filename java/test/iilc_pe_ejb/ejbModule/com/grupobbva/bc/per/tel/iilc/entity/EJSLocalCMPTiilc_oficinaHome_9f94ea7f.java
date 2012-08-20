package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiilc_oficinaHome_9f94ea7f
 */
public class EJSLocalCMPTiilc_oficinaHome_9f94ea7f extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocalHome, com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanInternalLocalHome_9f94ea7f {
	/**
	 * EJSLocalCMPTiilc_oficinaHome_9f94ea7f
	 */
	public EJSLocalCMPTiilc_oficinaHome_9f94ea7f() {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal create(java.lang.String cod_oficina, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal argTiilc_territorio_fk) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_oficina;
				_jacc_parms[1] = argTiilc_territorio_fk;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_oficina, argTiilc_territorio_fk);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal create(java.lang.String cod_oficina, java.lang.String tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = cod_oficina;
				_jacc_parms[1] = tiilc_territorio_fk_cod_territorio;
				_jacc_parms[2] = tiilc_territorio_fk_tiilc_area_fk_cod_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal create(java.lang.String cod_oficina, java.lang.String tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area, java.lang.String des_oficina) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = cod_oficina;
				_jacc_parms[1] = tiilc_territorio_fk_cod_territorio;
				_jacc_parms[2] = tiilc_territorio_fk_tiilc_area_fk_cod_area;
				_jacc_parms[3] = des_oficina;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area, des_oficina);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal findByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
	 * findAllOficinaxCod_oficina
	 */
	public java.util.Collection findAllOficinaxCod_oficina(java.lang.String cod_oficina) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_oficina;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllOficinaxCod_oficina_Local(cod_oficina);
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
	 * findAllOficinaxTer
	 */
	public java.util.Collection findAllOficinaxTer(java.lang.String cod_territorio) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_territorio;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllOficinaxTer_Local(cod_territorio);
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
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
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
	 * findTiilc_oficinaByTiilc_territorio_fkKey_Local
	 */
	public java.util.Collection findTiilc_oficinaByTiilc_territorio_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiilc_oficinaByTiilc_territorio_fkKey_Local(key);
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
	 * findTiilc_oficina_fkByTiilc_gestorKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal findTiilc_oficina_fkByTiilc_gestorKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiilc_oficina_fkByTiilc_gestorKey_Local(key);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal findByPrimaryKeyForCMR(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_oficinaHomeBean_9f94ea7f)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
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
