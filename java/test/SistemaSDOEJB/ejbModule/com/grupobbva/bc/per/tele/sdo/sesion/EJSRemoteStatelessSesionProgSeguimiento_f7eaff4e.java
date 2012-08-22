package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionProgSeguimiento_f7eaff4e
 */
public class EJSRemoteStatelessSesionProgSeguimiento_f7eaff4e extends EJSWrapper implements SesionProgSeguimiento {
	/**
	 * EJSRemoteStatelessSesionProgSeguimiento_f7eaff4e
	 */
	public EJSRemoteStatelessSesionProgSeguimiento_f7eaff4e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * actualizarProgTerritorio
	 */
	public boolean actualizarProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.actualizarProgTerritorio(progTerritorio);
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
	 * crearProgTerritorio
	 */
	public boolean crearProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.crearProgTerritorio(progTerritorio);
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
	 * eliminarProgTerritorio
	 */
	public boolean eliminarProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarProgTerritorio(progTerritorio);
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
	 * findProgTerritorio
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento findProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findProgTerritorio(progTerritorio);
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
	 * findProgramacionSeguimiento
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento findProgramacionSeguimiento(java.lang.String mes, java.lang.String anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anio;
				_jacc_parms[2] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findProgramacionSeguimiento(mes, anio, codTerritorio);
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
	 * findTodosProgTerritorio
	 */
	public java.util.Vector findTodosProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionProgSeguimientoBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findTodosProgTerritorio(progTerritorio);
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
