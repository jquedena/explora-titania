package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionMaestroPlanes_334a8d47
 */
public class EJSRemoteStatelessSesionMaestroPlanes_334a8d47 extends EJSWrapper implements SesionMaestroPlanes {
	/**
	 * EJSRemoteStatelessSesionMaestroPlanes_334a8d47
	 */
	public EJSRemoteStatelessSesionMaestroPlanes_334a8d47() throws java.rmi.RemoteException {
		super();	}
	/**
	 * borrarMaestro
	 */
	public boolean borrarMaestro() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.borrarMaestro();
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
	 * createMaestroPlan
	 */
	public boolean createMaestroPlan(java.lang.String anho, java.lang.String mes, java.lang.String codOfi, java.lang.String codTerr) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codOfi;
				_jacc_parms[3] = codTerr;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createMaestroPlan(anho, mes, codOfi, codTerr);
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
	 * existeDataMesAnio
	 */
	public boolean existeDataMesAnio(java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.existeDataMesAnio(mes, anio);
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
	 * findUbicar
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.MaestroPlan findUbicar(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.MaestroPlan _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findUbicar(mes, anho, codOficina, codTerritorio);
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
	 * reportePGOResumen2
	 */
	public java.util.Hashtable reportePGOResumen2(java.lang.String codTerritorio, java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Hashtable _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGOResumen2(codTerritorio, mes, anho);
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
	 * reportePGOResumen
	 */
	public java.util.Vector reportePGOResumen(java.lang.String codTerritorio, java.util.Hashtable hash) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = hash;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGOResumen(codTerritorio, hash);
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
	 * reportePGOResumenxAnioMes
	 */
	public java.util.Vector reportePGOResumenxAnioMes(java.lang.String codTerritorio, java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMaestroPlanesBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGOResumenxAnioMes(codTerritorio, mes, anio);
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
