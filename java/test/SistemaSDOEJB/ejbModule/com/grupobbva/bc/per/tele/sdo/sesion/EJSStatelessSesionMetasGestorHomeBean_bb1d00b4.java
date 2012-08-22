package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSesionMetasGestorHomeBean_bb1d00b4
 */
public class EJSStatelessSesionMetasGestorHomeBean_bb1d00b4 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSesionMetasGestorHomeBean_bb1d00b4
	 */
	public EJSStatelessSesionMetasGestorHomeBean_bb1d00b4() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestor create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestor result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestor) super.createWrapper(null);
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
