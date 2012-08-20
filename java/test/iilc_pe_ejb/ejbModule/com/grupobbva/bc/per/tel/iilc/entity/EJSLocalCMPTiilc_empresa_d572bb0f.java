package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiilc_empresa_d572bb0f
 */
public class EJSLocalCMPTiilc_empresa_d572bb0f extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal {
	/**
	 * EJSLocalCMPTiilc_empresa_d572bb0f
	 */
	public EJSLocalCMPTiilc_empresa_d572bb0f() {
		super();	}
	/**
	 * getCod_empresa
	 */
	public java.lang.String getCod_empresa() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCod_empresa();
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
	 * getDes_empresa
	 */
	public java.lang.String getDes_empresa() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDes_empresa();
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
	 * setCod_empresa
	 */
	public void setCod_empresa(java.lang.String newCod_empresa) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCod_empresa;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			beanRef.setCod_empresa(newCod_empresa);
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
		return ;
	}
	/**
	 * setDes_empresa
	 */
	public void setDes_empresa(java.lang.String newDes_empresa) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDes_empresa;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.setDes_empresa(newDes_empresa);
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
}
