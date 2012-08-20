package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiilc_empresaHome_d572bb0f
 */
public class EJSLocalCMPTiilc_empresaHome_d572bb0f extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocalHome, com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_empresaBeanInternalLocalHome_d572bb0f {
	/**
	 * EJSLocalCMPTiilc_empresaHome_d572bb0f
	 */
	public EJSLocalCMPTiilc_empresaHome_d572bb0f() {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal create(java.lang.String cod_empresa) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_empresa;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_empresa);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal create(java.lang.String cod_empresa, java.lang.String des_empresa) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_empresa;
				_jacc_parms[1] = des_empresa;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_empresa, des_empresa);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal findByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
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
	 * findEmpresaxCodigo
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal findEmpresaxCodigo(java.lang.String cod_empresa) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_empresa;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findEmpresaxCodigo_Local(cod_empresa);
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
	 * findAllEmpresa
	 */
	public java.util.Collection findAllEmpresa() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllEmpresa_Local();
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
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_empresaHomeBean_d572bb0f)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
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
