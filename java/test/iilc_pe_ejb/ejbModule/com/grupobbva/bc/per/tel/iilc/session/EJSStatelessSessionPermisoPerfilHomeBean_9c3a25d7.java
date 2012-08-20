package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSessionPermisoPerfilHomeBean_9c3a25d7
 */
public class EJSStatelessSessionPermisoPerfilHomeBean_9c3a25d7 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSessionPermisoPerfilHomeBean_9c3a25d7
	 */
	public EJSStatelessSessionPermisoPerfilHomeBean_9c3a25d7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.session.SessionPermisoPerfil create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tel.iilc.session.SessionPermisoPerfil result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tel.iilc.session.SessionPermisoPerfil) super.createWrapper(null);
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
	public com.grupobbva.bc.per.tel.iilc.session.SessionPermisoPerfilLocal create_Local() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tel.iilc.session.SessionPermisoPerfilLocal result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	result = (com.grupobbva.bc.per.tel.iilc.session.SessionPermisoPerfilLocal) super.createWrapper_Local(null);
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
