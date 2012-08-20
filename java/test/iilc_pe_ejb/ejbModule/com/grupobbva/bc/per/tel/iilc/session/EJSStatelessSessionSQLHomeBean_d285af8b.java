package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSessionSQLHomeBean_d285af8b
 */
public class EJSStatelessSessionSQLHomeBean_d285af8b extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSessionSQLHomeBean_d285af8b
	 */
	public EJSStatelessSessionSQLHomeBean_d285af8b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.session.SessionSQL create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tel.iilc.session.SessionSQL result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tel.iilc.session.SessionSQL) super.createWrapper(null);
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
