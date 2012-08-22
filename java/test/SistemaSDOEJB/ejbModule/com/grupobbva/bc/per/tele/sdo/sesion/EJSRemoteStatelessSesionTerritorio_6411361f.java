package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionTerritorio_6411361f
 */
public class EJSRemoteStatelessSesionTerritorio_6411361f extends EJSWrapper implements SesionTerritorio {
	/**
	 * EJSRemoteStatelessSesionTerritorio_6411361f
	 */
	public EJSRemoteStatelessSesionTerritorio_6411361f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByCodTerritorio
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Territorio findByCodTerritorio(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Territorio _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findByCodTerritorio(codTerritorio);
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
	 * busAllTerritorio
	 */
	public java.util.Vector busAllTerritorio() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAllTerritorio();
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
	 * busAllTerritorioActivo
	 */
	public java.util.Vector busAllTerritorioActivo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAllTerritorioActivo();
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
	 * busTerritorioxCod
	 */
	public java.util.Vector busTerritorioxCod(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busTerritorioxCod(codTerritorio);
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
	 * busTerritorioxRegistroLDAP
	 */
	public java.util.Vector busTerritorioxRegistroLDAP(java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busTerritorioxRegistroLDAP(codGestor);
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
	 * eliminarTerritorio
	 */
	public java.util.Vector eliminarTerritorio(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarTerritorio(codTerritorio);
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
	 * findAllTerritorio
	 */
	public java.util.Vector findAllTerritorio() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllTerritorio();
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
	/**
	 * modificarTerritorio
	 */
	public java.util.Vector modificarTerritorio(java.lang.String codTerritorio, java.lang.String nomTerritorio, java.lang.String estado, java.lang.String mensaje, java.lang.String colorFondo, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = nomTerritorio;
				_jacc_parms[2] = estado;
				_jacc_parms[3] = mensaje;
				_jacc_parms[4] = colorFondo;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.modificarTerritorio(codTerritorio, nomTerritorio, estado, mensaje, colorFondo, usuario);
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
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * nuevoTerritorio
	 */
	public java.util.Vector nuevoTerritorio(java.lang.String codTerritorio, java.lang.String nomTerritorio, java.lang.String mensaje, java.lang.String colorFondo, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = nomTerritorio;
				_jacc_parms[2] = mensaje;
				_jacc_parms[3] = colorFondo;
				_jacc_parms[4] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevoTerritorio(codTerritorio, nomTerritorio, mensaje, colorFondo, usuario);
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
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * editarMensajeTerritorio
	 */
	public void editarMensajeTerritorio(java.lang.String codTerritorio, java.lang.String mensaje, java.lang.String colorFondo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = mensaje;
				_jacc_parms[2] = colorFondo;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionTerritorioBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			beanRef.editarMensajeTerritorio(codTerritorio, mensaje, colorFondo);
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
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
