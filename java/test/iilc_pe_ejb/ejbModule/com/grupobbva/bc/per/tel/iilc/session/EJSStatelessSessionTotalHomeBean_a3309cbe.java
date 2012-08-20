package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSessionTotalHomeBean_a3309cbe
 */
public class EJSStatelessSessionTotalHomeBean_a3309cbe extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSessionTotalHomeBean_a3309cbe
	 */
	public EJSStatelessSessionTotalHomeBean_a3309cbe() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.session.SessionTotal create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tel.iilc.session.SessionTotal result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tel.iilc.session.SessionTotal) super.createWrapper(null);
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
	public com.grupobbva.bc.per.tel.iilc.session.SessionTotalLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tel.iilc.session.SessionTotalLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.grupobbva.bc.per.tel.iilc.session.SessionTotalLocal) super.createWrapper_Local(null);
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
