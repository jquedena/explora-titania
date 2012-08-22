package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSesionEquivalenciasHomeBean_4e5b84d6
 */
public class EJSStatelessSesionEquivalenciasHomeBean_4e5b84d6 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSesionEquivalenciasHomeBean_4e5b84d6
	 */
	public EJSStatelessSesionEquivalenciasHomeBean_4e5b84d6() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalencias create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalencias result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalencias) super.createWrapper(null);
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
