package com.grupobbva.bc.per.tele.sdo.sesionws;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSesionWSHomeBean_2449ed74
 */
public class EJSStatelessSesionWSHomeBean_2449ed74 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSesionWSHomeBean_2449ed74
	 */
	public EJSStatelessSesionWSHomeBean_2449ed74() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesionws.SesionWS create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesionws.SesionWS result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWS) super.createWrapper(null);
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
