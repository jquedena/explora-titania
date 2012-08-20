package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.etools.ejb.client.runtime.*;

/**
 * SessionServiceFactory
 * @generated
 */
public class SessionServiceFactory extends AbstractEJBFactory {

	/**
	 * SessionServiceFactory
	 * @generated
	 */
	public SessionServiceFactory() {
		super();
	}

	/**
	 * _acquireSessionServiceHome
	 * @generated
	 */
	protected com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome _acquireSessionServiceHome()
		throws java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome) _acquireEJBHome();
	}

	/**
	 * acquireSessionServiceHome
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome acquireSessionServiceHome()
		throws javax.naming.NamingException {
		return (com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome) acquireEJBHome();
	}

	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionServiceHome";
	}

	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome.class;
	}

	/**
	 * resetSessionServiceHome
	 * @generated
	 */
	public void resetSessionServiceHome() {
		resetEJBHome();
	}

	/**
	 * setSessionServiceHome
	 * @generated
	 */
	public void setSessionServiceHome(
		com.grupobbva.bc.per.tel.iilc.session.SessionServiceHome home) {
		setEJBHome(home);
	}

	/**
	 * create
	 * @generated
	 */
	public com.grupobbva.bc.per.tel.iilc.session.SessionService create()
		throws javax.ejb.CreateException,
		java.rmi.RemoteException {
		return _acquireSessionServiceHome().create();
	}
}
