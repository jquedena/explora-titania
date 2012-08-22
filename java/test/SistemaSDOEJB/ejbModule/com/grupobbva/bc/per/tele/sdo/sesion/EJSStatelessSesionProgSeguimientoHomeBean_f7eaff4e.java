package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSesionProgSeguimientoHomeBean_f7eaff4e
 */
public class EJSStatelessSesionProgSeguimientoHomeBean_f7eaff4e extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSesionProgSeguimientoHomeBean_f7eaff4e
	 */
	public EJSStatelessSesionProgSeguimientoHomeBean_f7eaff4e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimiento create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimiento result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimiento) super.createWrapper(null);
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
