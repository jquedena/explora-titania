package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalStatelessSessionOficina_8fa6dbea
 */
public class EJSLocalStatelessSessionOficina_8fa6dbea extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.session.SessionOficinaLocal {
	/**
	 * EJSLocalStatelessSessionOficina_8fa6dbea
	 */
	public EJSLocalStatelessSessionOficina_8fa6dbea() {
		super();	}
	/**
	 * datosOficina
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Oficina datosOficina(java.lang.String codigo) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.serializable.Oficina _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codigo;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionOficinaBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionOficinaBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.datosOficina(codigo);
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
	 * findAllOficinaxTe
	 */
	public java.util.Vector findAllOficinaxTe(java.lang.String cod_area, java.lang.String cod_territorio) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_area;
				_jacc_parms[1] = cod_territorio;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionOficinaBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionOficinaBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllOficinaxTe(cod_area, cod_territorio);
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
	 * findAllOficinaxTerr
	 */
	public java.util.Vector findAllOficinaxTerr(java.lang.String cod_territorio) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_territorio;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionOficinaBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionOficinaBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllOficinaxTerr(cod_territorio);
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
}
