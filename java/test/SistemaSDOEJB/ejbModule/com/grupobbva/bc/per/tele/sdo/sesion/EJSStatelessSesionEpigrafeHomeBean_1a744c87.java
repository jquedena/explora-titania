package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSesionEpigrafeHomeBean_1a744c87
 */
public class EJSStatelessSesionEpigrafeHomeBean_1a744c87 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSesionEpigrafeHomeBean_1a744c87
	 */
	public EJSStatelessSesionEpigrafeHomeBean_1a744c87() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesion.SesionEpigrafe create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesion.SesionEpigrafe result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesion.SesionEpigrafe) super.createWrapper(null);
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
