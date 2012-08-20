package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSessionEmpresaHomeBean_8beb6ed6
 */
public class EJSStatelessSessionEmpresaHomeBean_8beb6ed6 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSessionEmpresaHomeBean_8beb6ed6
	 */
	public EJSStatelessSessionEmpresaHomeBean_8beb6ed6() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.session.SessionEmpresa create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tel.iilc.session.SessionEmpresa result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tel.iilc.session.SessionEmpresa) super.createWrapper(null);
}
catch (javax.ejb.CreateException ex) {
	createFailed = true;
	throw ex;
} catch (java.rmi.RemoteException ex) {
	createFailed = true;
	throw ex;
} catch (Throwable ex) {
	createFailed = true;
	throw new CreateFailureException(ex);
} finally {
	if (createFailed) {
		super.createFailure(beanO);
	}
}
return result;	}
	/**
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.session.SessionEmpresaLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tel.iilc.session.SessionEmpresaLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.grupobbva.bc.per.tel.iilc.session.SessionEmpresaLocal) super.createWrapper_Local(null);
}
catch (javax.ejb.CreateException ex) {
	createFailed = true;
	throw ex;
} catch (java.rmi.RemoteException ex) {
	createFailed = true;
	throw ex;
} catch (Throwable ex) {
	createFailed = true;
	throw new CreateFailureException(ex);
} finally {
	if (createFailed) {
		super.createFailure(beanO);
	}
}
return result;	}
}
