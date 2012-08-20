package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSessionGestorHomeBean_e1f7791e
 */
public class EJSStatelessSessionGestorHomeBean_e1f7791e extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSessionGestorHomeBean_e1f7791e
	 */
	public EJSStatelessSessionGestorHomeBean_e1f7791e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.session.SessionGestor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tel.iilc.session.SessionGestor result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tel.iilc.session.SessionGestor) super.createWrapper(null);
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
	public com.grupobbva.bc.per.tel.iilc.session.SessionGestorLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tel.iilc.session.SessionGestorLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.grupobbva.bc.per.tel.iilc.session.SessionGestorLocal) super.createWrapper_Local(null);
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
