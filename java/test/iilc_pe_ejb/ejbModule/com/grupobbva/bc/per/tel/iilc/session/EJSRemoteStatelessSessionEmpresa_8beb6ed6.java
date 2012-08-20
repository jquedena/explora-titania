package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSessionEmpresa_8beb6ed6
 */
public class EJSRemoteStatelessSessionEmpresa_8beb6ed6 extends EJSWrapper implements SessionEmpresa {
	/**
	 * EJSRemoteStatelessSessionEmpresa_8beb6ed6
	 */
	public EJSRemoteStatelessSessionEmpresa_8beb6ed6() throws java.rmi.RemoteException {
		super();	}
	/**
	 * datosEmpresa
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Empresa datosEmpresa(java.lang.String codigo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.serializable.Empresa _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codigo;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionEmpresaBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionEmpresaBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.datosEmpresa(codigo);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
