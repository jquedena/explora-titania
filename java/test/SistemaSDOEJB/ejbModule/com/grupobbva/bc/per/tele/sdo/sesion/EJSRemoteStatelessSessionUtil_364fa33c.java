package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSessionUtil_364fa33c
 */
public class EJSRemoteStatelessSessionUtil_364fa33c extends EJSWrapper implements SessionUtil {
	/**
	 * EJSRemoteStatelessSessionUtil_364fa33c
	 */
	public EJSRemoteStatelessSessionUtil_364fa33c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * actualizarEstadoFlag
	 */
	public int actualizarEstadoFlag(java.lang.String flag) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = flag;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.actualizarEstadoFlag(flag);
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
	 * xInsertarTAcciones
	 */
	public int xInsertarTAcciones(java.lang.String codigoAccion, java.lang.String nomberAccion, java.lang.String codigoGestor, java.lang.String mes, java.lang.String anho, int nroClientes, int compromisoGestor, int nroGestorSeguimiento1, int nroConcSeguimiento1, int montoSeguimiento1, int nroGestorSeguimiento2, int nroConcSeguimiento2, int montoSeguimiento2, java.lang.String codigoOficina, java.lang.String codigoEpigrafe, java.util.Date fechaSeg1, java.util.Date fechaSeg2, java.util.Date fechaGrabacion, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[19];
				_jacc_parms[0] = codigoAccion;
				_jacc_parms[1] = nomberAccion;
				_jacc_parms[2] = codigoGestor;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = new java.lang.Integer(nroClientes);
				_jacc_parms[6] = new java.lang.Integer(compromisoGestor);
				_jacc_parms[7] = new java.lang.Integer(nroGestorSeguimiento1);
				_jacc_parms[8] = new java.lang.Integer(nroConcSeguimiento1);
				_jacc_parms[9] = new java.lang.Integer(montoSeguimiento1);
				_jacc_parms[10] = new java.lang.Integer(nroGestorSeguimiento2);
				_jacc_parms[11] = new java.lang.Integer(nroConcSeguimiento2);
				_jacc_parms[12] = new java.lang.Integer(montoSeguimiento2);
				_jacc_parms[13] = codigoOficina;
				_jacc_parms[14] = codigoEpigrafe;
				_jacc_parms[15] = fechaSeg1;
				_jacc_parms[16] = fechaSeg2;
				_jacc_parms[17] = fechaGrabacion;
				_jacc_parms[18] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTAcciones(codigoAccion, nomberAccion, codigoGestor, mes, anho, nroClientes, compromisoGestor, nroGestorSeguimiento1, nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2, montoSeguimiento2, codigoOficina, codigoEpigrafe, fechaSeg1, fechaSeg2, fechaGrabacion, codTerritorio);
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
	 * xInsertarTCampanhas
	 */
	public int xInsertarTCampanhas(java.lang.String codigoCampania, java.lang.String anho, java.lang.String mes, java.lang.String nombreCampania, java.lang.String codigoOficina, java.lang.String codigoGestor, java.lang.String orden, java.lang.String gte, java.util.Date fechaGrabacion, java.lang.String codigoTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[10];
				_jacc_parms[0] = codigoCampania;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = mes;
				_jacc_parms[3] = nombreCampania;
				_jacc_parms[4] = codigoOficina;
				_jacc_parms[5] = codigoGestor;
				_jacc_parms[6] = orden;
				_jacc_parms[7] = gte;
				_jacc_parms[8] = fechaGrabacion;
				_jacc_parms[9] = codigoTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTCampanhas(codigoCampania, anho, mes, nombreCampania, codigoOficina, codigoGestor, orden, gte, fechaGrabacion, codigoTerritorio);
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
	 * xInsertarTCampanhasDetalle
	 */
	public int xInsertarTCampanhasDetalle(java.lang.String codigoCampanhaDetalle, java.lang.String nombreCampanha, java.lang.String codigoGestor, java.lang.String mes, java.lang.String anho, int nroClientes, int compromisoGestor, int nroGestorSeguimiento1, int nroConcSeguimiento1, int montoSeguimiento1, int nroGestorSeguimiento2, int nroConcSeguimiento2, int montoSeguimiento2, java.lang.String codigoOficina, java.lang.String codigoCampanha, java.util.Date fechaGrabacion, java.util.Date fechaSeg1, java.util.Date fechaSeg2, java.lang.String codigoTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[19];
				_jacc_parms[0] = codigoCampanhaDetalle;
				_jacc_parms[1] = nombreCampanha;
				_jacc_parms[2] = codigoGestor;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = new java.lang.Integer(nroClientes);
				_jacc_parms[6] = new java.lang.Integer(compromisoGestor);
				_jacc_parms[7] = new java.lang.Integer(nroGestorSeguimiento1);
				_jacc_parms[8] = new java.lang.Integer(nroConcSeguimiento1);
				_jacc_parms[9] = new java.lang.Integer(montoSeguimiento1);
				_jacc_parms[10] = new java.lang.Integer(nroGestorSeguimiento2);
				_jacc_parms[11] = new java.lang.Integer(nroConcSeguimiento2);
				_jacc_parms[12] = new java.lang.Integer(montoSeguimiento2);
				_jacc_parms[13] = codigoOficina;
				_jacc_parms[14] = codigoCampanha;
				_jacc_parms[15] = fechaGrabacion;
				_jacc_parms[16] = fechaSeg1;
				_jacc_parms[17] = fechaSeg2;
				_jacc_parms[18] = codigoTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTCampanhasDetalle(codigoCampanhaDetalle, nombreCampanha, codigoGestor, mes, anho, nroClientes, compromisoGestor, nroGestorSeguimiento1, nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2, montoSeguimiento2, codigoOficina, codigoCampanha, fechaGrabacion, fechaSeg1, fechaSeg2, codigoTerritorio);
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
	 * xInsertarTEpigrafes
	 */
	public int xInsertarTEpigrafes(java.lang.String codigoepigrafe, java.lang.String nombreepigrafe, java.lang.String anho, java.lang.String indicadorclase, java.lang.String indicadorsubclase, java.lang.String orden, java.lang.String indicadorgrupo, java.lang.String abreviatura, java.lang.String indicadorhijo, java.lang.String indicadorafecta) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[10];
				_jacc_parms[0] = codigoepigrafe;
				_jacc_parms[1] = nombreepigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = indicadorclase;
				_jacc_parms[4] = indicadorsubclase;
				_jacc_parms[5] = orden;
				_jacc_parms[6] = indicadorgrupo;
				_jacc_parms[7] = abreviatura;
				_jacc_parms[8] = indicadorhijo;
				_jacc_parms[9] = indicadorafecta;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTEpigrafes(codigoepigrafe, nombreepigrafe, anho, indicadorclase, indicadorsubclase, orden, indicadorgrupo, abreviatura, indicadorhijo, indicadorafecta);
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
	 * xInsertarTEquivalencias
	 */
	public int xInsertarTEquivalencias(java.lang.String codigoCargo, java.lang.String codigoPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codigoCargo;
				_jacc_parms[1] = codigoPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTEquivalencias(codigoCargo, codigoPerfil);
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
	 * xInsertarTFirmas
	 */
	public int xInsertarTFirmas(java.lang.String anho, java.lang.String mes, java.lang.String item, java.lang.String codigoGestor, java.lang.String codigoOficina, java.lang.String descripcion, java.util.Date fecha) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = item;
				_jacc_parms[3] = codigoGestor;
				_jacc_parms[4] = codigoOficina;
				_jacc_parms[5] = descripcion;
				_jacc_parms[6] = fecha;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTFirmas(anho, mes, item, codigoGestor, codigoOficina, descripcion, fecha);
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
	 * xInsertarTMaestroPlanes
	 */
	public int xInsertarTMaestroPlanes(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoTerritorio, java.lang.String prioridad, java.util.Date fechaGrabacion) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoTerritorio;
				_jacc_parms[4] = prioridad;
				_jacc_parms[5] = fechaGrabacion;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTMaestroPlanes(codigoOficina, mes, anho, codigoTerritorio, prioridad, fechaGrabacion);
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
	 * xInsertarTMetasGestor
	 */
	public int xInsertarTMetasGestor(java.lang.String codigoMetaGestor, java.lang.String codigoEpigrafe, java.lang.String codigoOficina, java.lang.String codigoGestor, java.lang.String anho, java.lang.String mes, java.lang.String orden, java.util.Date fechaGrabacion, java.lang.String porcAsignado, java.lang.String nombreEpigrafe, java.lang.String nombreGestor, java.lang.String codigoTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[12];
				_jacc_parms[0] = codigoMetaGestor;
				_jacc_parms[1] = codigoEpigrafe;
				_jacc_parms[2] = codigoOficina;
				_jacc_parms[3] = codigoGestor;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = mes;
				_jacc_parms[6] = orden;
				_jacc_parms[7] = fechaGrabacion;
				_jacc_parms[8] = porcAsignado;
				_jacc_parms[9] = nombreEpigrafe;
				_jacc_parms[10] = nombreGestor;
				_jacc_parms[11] = codigoTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTMetasGestor(codigoMetaGestor, codigoEpigrafe, codigoOficina, codigoGestor, anho, mes, orden, fechaGrabacion, porcAsignado, nombreEpigrafe, nombreGestor, codigoTerritorio);
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
	 * xInsertarTOficina
	 */
	public int xInsertarTOficina(java.lang.String codigoTerritorio, java.lang.String nombreOficina, java.lang.String codigoOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codigoTerritorio;
				_jacc_parms[1] = nombreOficina;
				_jacc_parms[2] = codigoOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTOficina(codigoTerritorio, nombreOficina, codigoOficina);
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
		return _EJS_result;
	}
	/**
	 * xInsertarTParametros
	 */
	public int xInsertarTParametros(java.util.Date fechaAccion, java.util.Date fechaSeguimiento1, java.util.Date fechaSeguimiento2, java.lang.String afectaAccion, java.lang.String afectaSeguimiento, java.lang.String afectaPlanificacion, java.util.Date fechaPlanificacion) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = fechaAccion;
				_jacc_parms[1] = fechaSeguimiento1;
				_jacc_parms[2] = fechaSeguimiento2;
				_jacc_parms[3] = afectaAccion;
				_jacc_parms[4] = afectaSeguimiento;
				_jacc_parms[5] = afectaPlanificacion;
				_jacc_parms[6] = fechaPlanificacion;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTParametros(fechaAccion, fechaSeguimiento1, fechaSeguimiento2, afectaAccion, afectaSeguimiento, afectaPlanificacion, fechaPlanificacion);
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
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTPerfiles
	 */
	public int xInsertarTPerfiles(java.lang.String codigoPerfil, java.lang.String nombrePerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codigoPerfil;
				_jacc_parms[1] = nombrePerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTPerfiles(codigoPerfil, nombrePerfil);
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
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTPlanes
	 */
	public int xInsertarTPlanes(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoEpigrafe, java.lang.String nombreEpigrafe, int pesodor, int monto, int porcAlcanzado, int desvpPto, int nroMesesFalt, int proyCrecMensual, int ajusteEstimadoTerr, int proyAjusteMensual, int saldoMedioJunio, int porcSaldoMedioJunio, int saldoDiciembreAnterior, int saldoMedioDiciembre, java.lang.String codigoTerritorio, int porcSaldoMedioDiciembre, int factorAjusteSaldoPuntual, int historicoBajas, int metaMesSaldoPuntual, int metaGerenteOficina, int prioridad, java.lang.String mesEvaluacion, java.lang.String indicadorDor, int varMes, int ajustePspto, int desvPsptoAjustado, int factAjustTerritorial, int factAsignGteOf) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[31];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoEpigrafe;
				_jacc_parms[4] = nombreEpigrafe;
				_jacc_parms[5] = new java.lang.Integer(pesodor);
				_jacc_parms[6] = new java.lang.Integer(monto);
				_jacc_parms[7] = new java.lang.Integer(porcAlcanzado);
				_jacc_parms[8] = new java.lang.Integer(desvpPto);
				_jacc_parms[9] = new java.lang.Integer(nroMesesFalt);
				_jacc_parms[10] = new java.lang.Integer(proyCrecMensual);
				_jacc_parms[11] = new java.lang.Integer(ajusteEstimadoTerr);
				_jacc_parms[12] = new java.lang.Integer(proyAjusteMensual);
				_jacc_parms[13] = new java.lang.Integer(saldoMedioJunio);
				_jacc_parms[14] = new java.lang.Integer(porcSaldoMedioJunio);
				_jacc_parms[15] = new java.lang.Integer(saldoDiciembreAnterior);
				_jacc_parms[16] = new java.lang.Integer(saldoMedioDiciembre);
				_jacc_parms[17] = codigoTerritorio;
				_jacc_parms[18] = new java.lang.Integer(porcSaldoMedioDiciembre);
				_jacc_parms[19] = new java.lang.Integer(factorAjusteSaldoPuntual);
				_jacc_parms[20] = new java.lang.Integer(historicoBajas);
				_jacc_parms[21] = new java.lang.Integer(metaMesSaldoPuntual);
				_jacc_parms[22] = new java.lang.Integer(metaGerenteOficina);
				_jacc_parms[23] = new java.lang.Integer(prioridad);
				_jacc_parms[24] = mesEvaluacion;
				_jacc_parms[25] = indicadorDor;
				_jacc_parms[26] = new java.lang.Integer(varMes);
				_jacc_parms[27] = new java.lang.Integer(ajustePspto);
				_jacc_parms[28] = new java.lang.Integer(desvPsptoAjustado);
				_jacc_parms[29] = new java.lang.Integer(factAjustTerritorial);
				_jacc_parms[30] = new java.lang.Integer(factAsignGteOf);
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTPlanes(codigoOficina, mes, anho, codigoEpigrafe, nombreEpigrafe, pesodor, monto, porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual, ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio, porcSaldoMedioJunio, saldoDiciembreAnterior, saldoMedioDiciembre, codigoTerritorio, porcSaldoMedioDiciembre, factorAjusteSaldoPuntual, historicoBajas, metaMesSaldoPuntual, metaGerenteOficina, prioridad, mesEvaluacion, indicadorDor, varMes, ajustePspto, desvPsptoAjustado, factAjustTerritorial, factAsignGteOf);
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
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTTerritorio
	 */
	public int xInsertarTTerritorio(java.lang.String codigoTerritorio, java.lang.String nombreTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codigoTerritorio;
				_jacc_parms[1] = nombreTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTTerritorio(codigoTerritorio, nombreTerritorio);
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
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * buscarEstadoFlag
	 */
	public java.lang.String buscarEstadoFlag() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.buscarEstadoFlag();
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
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCorrelativo
	 */
	public java.lang.String getCorrelativo(java.lang.String nomTabla, java.lang.String nomCampo, java.lang.String tamano) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = nomTabla;
				_jacc_parms[1] = nomCampo;
				_jacc_parms[2] = tamano;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCorrelativo(nomTabla, nomCampo, tamano);
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
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * testearBD
	 */
	public java.lang.String testearBD() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.testearBD();
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
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xDameTerritorio
	 */
	public java.lang.String xDameTerritorio(java.lang.String codigoOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codigoOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xDameTerritorio(codigoOficina);
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
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * buscarUsuariosLDAP
	 */
	public java.util.Vector buscarUsuariosLDAP(java.lang.String codOficina, java.lang.String codEmpresa, int limiteOcurrencias) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = codEmpresa;
				_jacc_parms[2] = new java.lang.Integer(limiteOcurrencias);
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.buscarUsuariosLDAP(codOficina, codEmpresa, limiteOcurrencias);
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
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultaSeguimientoAccionEsfuerzo
	 */
	public java.util.Vector consultaSeguimientoAccionEsfuerzo(java.lang.String codOfi, java.lang.String mes, java.lang.String anho, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codOfi;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultaSeguimientoAccionEsfuerzo(codOfi, mes, anho, codGestor);
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
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultaSeguimientoAccionEsfuerzoPGO
	 */
	public java.util.Vector consultaSeguimientoAccionEsfuerzoPGO(java.lang.String codOfi, java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codOfi;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultaSeguimientoAccionEsfuerzoPGO(codOfi, mes, anho);
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
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultarCampaniasDetalles
	 */
	public java.util.Vector consultarCampaniasDetalles(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultarCampaniasDetalles(codigoOficina, mes, anho, codigoGestor);
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
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultarCampaniasDetallesPGG
	 */
	public java.util.Vector consultarCampaniasDetallesPGG(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultarCampaniasDetallesPGG(codigoOficina, mes, anho, codigoGestor);
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
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultarPLanesAccion
	 */
	public java.util.Vector consultarPLanesAccion(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultarPLanesAccion(codigoOficina, mes, anho, codigoGestor);
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
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultarPlanesAccionesPPG
	 */
	public java.util.Vector consultarPlanesAccionesPPG(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultarPlanesAccionesPPG(codigoOficina, mes, anho, codigoGestor);
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
				container.postInvoke(this, 24, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * exportarTablasTXT
	 */
	public java.util.Vector exportarTablasTXT(int tabla, int mes, int anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = new java.lang.Integer(tabla);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.exportarTablasTXT(tabla, mes, anio);
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
				container.postInvoke(this, 25, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllOficinaConMetas
	 */
	public java.util.Vector findAllOficinaConMetas(java.lang.String codTerritorio, java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
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
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllOficinaConMetas(codTerritorio, mes, anio);
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
				container.postInvoke(this, 26, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaAccionesAntiguo
	 */
	public java.util.Vector xBusAllTablaAccionesAntiguo(java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 27, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaAccionesAntiguo(mes, anho);
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
				container.postInvoke(this, 27, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaCampanhasAntiguo
	 */
	public java.util.Vector xBusAllTablaCampanhasAntiguo(java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 28, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaCampanhasAntiguo(anho);
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
				container.postInvoke(this, 28, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaCampanhasDetalleAntiguo
	 */
	public java.util.Vector xBusAllTablaCampanhasDetalleAntiguo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 29, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaCampanhasDetalleAntiguo();
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
				container.postInvoke(this, 29, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaEpigrafesAntiguo
	 */
	public java.util.Vector xBusAllTablaEpigrafesAntiguo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 30, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaEpigrafesAntiguo();
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
				container.postInvoke(this, 30, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaEquivalencias
	 */
	public java.util.Vector xBusAllTablaEquivalencias() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 31, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaEquivalencias();
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
				container.postInvoke(this, 31, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaFirmas
	 */
	public java.util.Vector xBusAllTablaFirmas() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 32, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaFirmas();
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
				container.postInvoke(this, 32, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaMaestroPlanes
	 */
	public java.util.Vector xBusAllTablaMaestroPlanes(java.lang.String contadorMes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contadorMes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 33, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaMaestroPlanes(contadorMes);
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
				container.postInvoke(this, 33, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaMetasGestor
	 */
	public java.util.Vector xBusAllTablaMetasGestor(java.lang.String contadorMes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contadorMes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 34, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaMetasGestor(contadorMes);
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
				container.postInvoke(this, 34, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaOficinaAntiguo
	 */
	public java.util.Vector xBusAllTablaOficinaAntiguo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 35, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaOficinaAntiguo();
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
				container.postInvoke(this, 35, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaParametros
	 */
	public java.util.Vector xBusAllTablaParametros() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 36, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaParametros();
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
				container.postInvoke(this, 36, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaPerfiles
	 */
	public java.util.Vector xBusAllTablaPerfiles() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 37, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaPerfiles();
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
				container.postInvoke(this, 37, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaPlanes
	 */
	public java.util.Vector xBusAllTablaPlanes(java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 38, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaPlanes(mes, anho);
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
				container.postInvoke(this, 38, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaTerritorioAntiguo
	 */
	public java.util.Vector xBusAllTablaTerritorioAntiguo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SessionUtilBean)container.preInvoke(this, 39, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaTerritorioAntiguo();
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
				container.postInvoke(this, 39, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
