package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSessionUtilHomeBean_364fa33c
 */
public class EJSStatelessSessionUtilHomeBean_364fa33c extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSessionUtilHomeBean_364fa33c
	 */
	public EJSStatelessSessionUtilHomeBean_364fa33c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesion.SessionUtil create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesion.SessionUtil result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtil) super.createWrapper(null);
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
