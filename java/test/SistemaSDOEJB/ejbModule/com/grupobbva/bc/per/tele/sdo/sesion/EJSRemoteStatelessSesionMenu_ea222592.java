package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionMenu_ea222592
 */
public class EJSRemoteStatelessSesionMenu_ea222592 extends EJSWrapper implements SesionMenu {
	/**
	 * EJSRemoteStatelessSesionMenu_ea222592
	 */
	public EJSRemoteStatelessSesionMenu_ea222592() throws java.rmi.RemoteException {
		super();	}
	/**
	 * createMenu
	 */
	public boolean createMenu(com.grupobbva.bc.per.tele.sdo.serializable.Menu menu) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = menu;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createMenu(menu);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * deleteMenu
	 */
	public boolean deleteMenu(java.lang.String padre) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = padre;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deleteMenu(padre);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updateMenu
	 */
	public boolean updateMenu(com.grupobbva.bc.per.tele.sdo.serializable.Menu menu) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = menu;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateMenu(menu);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findxIdMenu
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Menu findxIdMenu(java.lang.String padre) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Menu _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = padre;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findxIdMenu(padre);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllMenu
	 */
	public java.util.Vector findAllMenu() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllMenu();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findxCodPerfil
	 */
	public java.util.Vector findxCodPerfil(java.lang.String codPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMenuBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findxCodPerfil(codPerfil);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
