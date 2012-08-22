package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionPermisoPerfil_00215134
 */
public class EJSRemoteStatelessSesionPermisoPerfil_00215134 extends EJSWrapper implements SesionPermisoPerfil {
	/**
	 * EJSRemoteStatelessSesionPermisoPerfil_00215134
	 */
	public EJSRemoteStatelessSesionPermisoPerfil_00215134() throws java.rmi.RemoteException {
		super();	}
	/**
	 * createPermisoPerfil
	 */
	public boolean createPermisoPerfil(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil permisoPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = permisoPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createPermisoPerfil(permisoPerfil);
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
	 * deletePermisoPerfil
	 */
	public boolean deletePermisoPerfil(java.lang.String codPerfil, java.lang.String tipoAcceso, java.lang.String valorRCP) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codPerfil;
				_jacc_parms[1] = tipoAcceso;
				_jacc_parms[2] = valorRCP;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deletePermisoPerfil(codPerfil, tipoAcceso, valorRCP);
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
	 * updatePermisoPerfil
	 */
	public boolean updatePermisoPerfil(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil origPermisoPerfil, com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil nuevoPermisoPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = origPermisoPerfil;
				_jacc_parms[1] = nuevoPermisoPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updatePermisoPerfil(origPermisoPerfil, nuevoPermisoPerfil);
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
	 * findPermisoPerfilById
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil findPermisoPerfilById(java.lang.String codPerfil, java.lang.String tipoAcceso, java.lang.String valorRCP) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codPerfil;
				_jacc_parms[1] = tipoAcceso;
				_jacc_parms[2] = valorRCP;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findPermisoPerfilById(codPerfil, tipoAcceso, valorRCP);
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
	 * findPermisoPerfilxTipAccxValorRCP
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil findPermisoPerfilxTipAccxValorRCP(java.lang.String codReg, java.lang.String codCat, java.lang.String path) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codReg;
				_jacc_parms[1] = codCat;
				_jacc_parms[2] = path;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findPermisoPerfilxTipAccxValorRCP(codReg, codCat, path);
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
	 * registrarPermisoPerfil
	 */
	public int registrarPermisoPerfil(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil permisoPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = permisoPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.registrarPermisoPerfil(permisoPerfil);
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
	/**
	 * findAllPermisoPerfil
	 */
	public java.util.Vector findAllPermisoPerfil() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPermisoPerfilBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllPermisoPerfil();
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
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
