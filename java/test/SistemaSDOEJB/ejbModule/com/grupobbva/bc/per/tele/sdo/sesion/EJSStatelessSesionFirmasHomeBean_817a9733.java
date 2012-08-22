package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSesionFirmasHomeBean_817a9733
 */
public class EJSStatelessSesionFirmasHomeBean_817a9733 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSesionFirmasHomeBean_817a9733
	 */
	public EJSStatelessSesionFirmasHomeBean_817a9733() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesion.SesionFirmas create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesion.SesionFirmas result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesion.SesionFirmas) super.createWrapper(null);
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
