package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionPerfiles_5441b32a
 */
public class EJSRemoteStatelessSesionPerfiles_5441b32a extends EJSWrapper implements SesionPerfiles {
	/**
	 * EJSRemoteStatelessSesionPerfiles_5441b32a
	 */
	public EJSRemoteStatelessSesionPerfiles_5441b32a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * createPerfil
	 */
	public boolean createPerfil(com.grupobbva.bc.per.tele.sdo.serializable.Perfil perfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = perfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createPerfil(perfil);
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
	 * deletePerfil
	 */
	public boolean deletePerfil(java.lang.String cod_perfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_perfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deletePerfil(cod_perfil);
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
	 * updatePerfil
	 */
	public boolean updatePerfil(com.grupobbva.bc.per.tele.sdo.serializable.Perfil perfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = perfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updatePerfil(perfil);
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
	 * findPerfil
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Perfil findPerfil(java.lang.String cod_perfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Perfil _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_perfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findPerfil(cod_perfil);
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
	 * findAllPerfil
	 */
	public java.util.Vector findAllPerfil() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfilesBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllPerfil();
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
}
