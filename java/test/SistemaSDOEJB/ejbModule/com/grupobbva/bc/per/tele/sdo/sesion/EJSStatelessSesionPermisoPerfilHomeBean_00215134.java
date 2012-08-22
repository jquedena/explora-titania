package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessSesionPermisoPerfilHomeBean_00215134
 */
public class EJSStatelessSesionPermisoPerfilHomeBean_00215134 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSStatelessSesionPermisoPerfilHomeBean_00215134
	 */
	public EJSStatelessSesionPermisoPerfilHomeBean_00215134() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfil create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfil result = null;
boolean createFailed = false;
try {
	result = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfil) super.createWrapper(null);
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
