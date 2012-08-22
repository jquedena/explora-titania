package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionPlanes_262c7ae3
 */
public class EJSRemoteStatelessSesionPlanes_262c7ae3 extends EJSWrapper implements SesionPlanes {
	/**
	 * EJSRemoteStatelessSesionPlanes_262c7ae3
	 */
	public EJSRemoteStatelessSesionPlanes_262c7ae3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * borrarPlanIngresado
	 */
	public boolean borrarPlanIngresado(java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.borrarPlanIngresado(usuario);
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
	 * createPlan
	 */
	public boolean createPlan(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = plan;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createPlan(plan);
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
	 * createUpdatePlan
	 */
	public boolean createUpdatePlan(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = plan;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createUpdatePlan(plan);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * insertUpdateMesesReferencia
	 */
	public boolean insertUpdateMesesReferencia(int mes, int anio, int sel_mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = new java.lang.Integer(mes);
				_jacc_parms[1] = new java.lang.Integer(anio);
				_jacc_parms[2] = new java.lang.Integer(sel_mes);
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.insertUpdateMesesReferencia(mes, anio, sel_mes);
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
	 * updatePlan
	 */
	public boolean updatePlan(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = plan;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updatePlan(plan);
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
	 * findConsultaPlanesResumen
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Plan findConsultaPlanesResumen(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Plan _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codEpigrafe;
				_jacc_parms[3] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findConsultaPlanesResumen(mes, anho, codEpigrafe, codOficina);
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
	 * findMesesReferencia
	 */
	public int findMesesReferencia(int mes, int anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(mes);
				_jacc_parms[1] = new java.lang.Integer(anio);
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findMesesReferencia(mes, anio);
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
	 * findCantidadPersonal
	 */
	public java.util.HashMap findCantidadPersonal(java.lang.String anho, java.lang.String mes, java.lang.String codOfi, java.lang.String codTerr) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.HashMap _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codOfi;
				_jacc_parms[3] = codTerr;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findCantidadPersonal(anho, mes, codOfi, codTerr);
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
	 * getListaMeses
	 */
	public java.util.HashMap getListaMeses(int year) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.HashMap _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(year);
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getListaMeses(year);
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
	 * findConsultaPlanes
	 */
	public java.util.Vector findConsultaPlanes(java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String anho, java.lang.String mes, java.lang.String presuReferencia) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = presuReferencia;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findConsultaPlanes(codTerritorio, codOficina, anho, mes, presuReferencia);
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
	 * findConsultarPlanesxMes
	 */
	public java.util.Vector findConsultarPlanesxMes(java.lang.String codOficina, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findConsultarPlanesxMes(codOficina, anho);
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
	 * findEpigrafesinPlanes
	 */
	public java.util.Vector findEpigrafesinPlanes(java.lang.String codOficina, java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findEpigrafesinPlanes(codOficina, anho, mes);
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
	 * findPlanAnual
	 */
	public java.util.Vector findPlanAnual(java.lang.String anho, java.lang.String codOfi) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = codOfi;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionPlanesBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findPlanAnual(anho, codOfi);
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
}
