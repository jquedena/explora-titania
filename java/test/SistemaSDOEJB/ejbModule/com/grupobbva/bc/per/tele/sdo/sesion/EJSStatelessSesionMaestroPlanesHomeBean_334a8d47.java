package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSesionMaestroPlanesHomeBean_334a8d47
 */
public class EJSStatelessSesionMaestroPlanesHomeBean_334a8d47 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSesionMaestroPlanesHomeBean_334a8d47
	 */
	public EJSStatelessSesionMaestroPlanesHomeBean_334a8d47() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanes create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanes result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanes) super.createWrapper(null);
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
