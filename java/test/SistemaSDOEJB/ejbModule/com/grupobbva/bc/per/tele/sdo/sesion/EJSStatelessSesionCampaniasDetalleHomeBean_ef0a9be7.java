package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSesionCampaniasDetalleHomeBean_ef0a9be7
 */
public class EJSStatelessSesionCampaniasDetalleHomeBean_ef0a9be7 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSesionCampaniasDetalleHomeBean_ef0a9be7
	 */
	public EJSStatelessSesionCampaniasDetalleHomeBean_ef0a9be7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalle create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalle result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalle) super.createWrapper(null);
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
