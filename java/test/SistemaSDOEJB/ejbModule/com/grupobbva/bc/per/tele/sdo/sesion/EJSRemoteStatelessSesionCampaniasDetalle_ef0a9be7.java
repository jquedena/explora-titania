package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionCampaniasDetalle_ef0a9be7
 */
public class EJSRemoteStatelessSesionCampaniasDetalle_ef0a9be7 extends EJSWrapper implements SesionCampaniasDetalle {
	/**
	 * EJSRemoteStatelessSesionCampaniasDetalle_ef0a9be7
	 */
	public EJSRemoteStatelessSesionCampaniasDetalle_ef0a9be7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * edicionCampaniaDetalle
	 */
	public boolean edicionCampaniaDetalle(java.lang.String codCampaniaDetalle, java.lang.String nomCampania, int nroClie, double compGest, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codCampaniaDetalle;
				_jacc_parms[1] = nomCampania;
				_jacc_parms[2] = new java.lang.Integer(nroClie);
				_jacc_parms[3] = new java.lang.Double(compGest);
				_jacc_parms[4] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.edicionCampaniaDetalle(codCampaniaDetalle, nomCampania, nroClie, compGest, usuario);
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
	 * eliminarCampaniaDetalle
	 */
	public boolean eliminarCampaniaDetalle(java.lang.String codCamp) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCamp;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarCampaniaDetalle(codCamp);
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
	 * nuevoCampaniaDetalle
	 */
	public boolean nuevoCampaniaDetalle(java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String codCampania, java.lang.String mes, java.lang.String anho, java.lang.String nomCampania, java.lang.String codGest, int nroClie, double compGest, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[10];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = codCampania;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = nomCampania;
				_jacc_parms[6] = codGest;
				_jacc_parms[7] = new java.lang.Integer(nroClie);
				_jacc_parms[8] = new java.lang.Double(compGest);
				_jacc_parms[9] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevoCampaniaDetalle(codTerritorio, codOficina, codCampania, mes, anho, nomCampania, codGest, nroClie, compGest, usuario);
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
	 * busCampaniaDetalle
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Campanias busCampaniaDetalle(java.lang.String codCampaniaDetalle) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Campanias _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCampaniaDetalle;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busCampaniaDetalle(codCampaniaDetalle);
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
	 * listaCampaniaDetalle
	 */
	public java.util.Vector listaCampaniaDetalle(java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String codCamp, java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = codCamp;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaCampaniaDetalle(codTerritorio, codOficina, codCamp, mes, anho);
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
	 * listaReportePPG
	 */
	public java.util.Vector listaReportePPG(java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaReportePPG(anho, mes);
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
	 * listaReportePlanificacion
	 */
	public java.util.Vector listaReportePlanificacion() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaReportePlanificacion();
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
	 * listaReporteSeguimiento1
	 */
	public java.util.Vector listaReporteSeguimiento1(java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaReporteSeguimiento1(anho, mes);
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
	 * listaReporteSeguimiento2
	 */
	public java.util.Vector listaReporteSeguimiento2(java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasDetalleBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaReporteSeguimiento2(anho, mes);
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
}
