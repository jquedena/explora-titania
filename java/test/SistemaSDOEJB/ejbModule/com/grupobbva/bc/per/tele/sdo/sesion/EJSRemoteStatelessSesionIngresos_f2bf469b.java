package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionIngresos_f2bf469b
 */
public class EJSRemoteStatelessSesionIngresos_f2bf469b extends EJSWrapper implements SesionIngresos {
	/**
	 * EJSRemoteStatelessSesionIngresos_f2bf469b
	 */
	public EJSRemoteStatelessSesionIngresos_f2bf469b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * busID_IngresoMax
	 */
	public int busID_IngresoMax() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busID_IngresoMax();
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
	 * listadoIngresoxDia
	 */
	public int listadoIngresoxDia(java.lang.String diaActual, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = diaActual;
				_jacc_parms[1] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listadoIngresoxDia(diaActual, codTerritorio);
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
	 * nuevoIngreso
	 */
	public int nuevoIngreso(java.lang.String id_ingresos, java.lang.String codUsuario, java.lang.String cargo, java.lang.String nomTerritorio, java.lang.String codOficina, java.lang.String nombres) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = id_ingresos;
				_jacc_parms[1] = codUsuario;
				_jacc_parms[2] = cargo;
				_jacc_parms[3] = nomTerritorio;
				_jacc_parms[4] = codOficina;
				_jacc_parms[5] = nombres;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevoIngreso(id_ingresos, codUsuario, cargo, nomTerritorio, codOficina, nombres);
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
	 * listarDiasMesesxAnio
	 */
	public java.util.ArrayList listarDiasMesesxAnio(int anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(anio);
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listarDiasMesesxAnio(anio);
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
	 * busAllIngreso
	 */
	public java.util.Vector busAllIngreso(java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAllIngreso(anho, mes);
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
	 * busIngresoxDIA
	 */
	public java.util.Vector busIngresoxDIA(java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxDIA(codTerritorioUsuario);
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
	 * busIngresoxOFICINAxAnho
	 */
	public java.util.Vector busIngresoxOFICINAxAnho(java.lang.String anho, java.lang.String codOficina, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxOFICINAxAnho(anho, codOficina, codTerritorioUsuario);
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
	 * busIngresoxOFICINAxMes
	 */
	public java.util.Vector busIngresoxOFICINAxMes(java.lang.String mes, java.lang.String codOficina, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxOFICINAxMes(mes, codOficina, codTerritorioUsuario);
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
	 * busIngresoxOficina
	 */
	public java.util.Vector busIngresoxOficina(java.lang.String anho, java.lang.String mes, java.lang.String dia, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = dia;
				_jacc_parms[3] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxOficina(anho, mes, dia, codTerritorioUsuario);
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
	 * busIngresoxTERRITORIOxAnho
	 */
	public java.util.Vector busIngresoxTERRITORIOxAnho(java.lang.String anho, java.lang.String nomTerritorio, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = nomTerritorio;
				_jacc_parms[2] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxTERRITORIOxAnho(anho, nomTerritorio, codTerritorioUsuario);
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
	 * busIngresoxTERRITORIOxMes
	 */
	public java.util.Vector busIngresoxTERRITORIOxMes(java.lang.String mes, java.lang.String nomTerritorio, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = nomTerritorio;
				_jacc_parms[2] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxTERRITORIOxMes(mes, nomTerritorio, codTerritorioUsuario);
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
	 * busIngresoxTerritorio
	 */
	public java.util.Vector busIngresoxTerritorio(java.lang.String anho, java.lang.String mes, java.lang.String dia, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = dia;
				_jacc_parms[3] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxTerritorio(anho, mes, dia, codTerritorioUsuario);
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
	 * busIngresoxUSUARIOxAnho
	 */
	public java.util.Vector busIngresoxUSUARIOxAnho(java.lang.String anho, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxUSUARIOxAnho(anho, codTerritorioUsuario);
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
	 * busIngresoxUSUARIOxMes
	 */
	public java.util.Vector busIngresoxUSUARIOxMes(java.lang.String mes, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxUSUARIOxMes(mes, codTerritorioUsuario);
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
	 * busIngresoxUsuario
	 */
	public java.util.Vector busIngresoxUsuario(java.lang.String anho, java.lang.String mes, java.lang.String dia, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = dia;
				_jacc_parms[3] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxUsuario(anho, mes, dia, codTerritorioUsuario);
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
	 * reportexOficina
	 */
	public java.util.Vector reportexOficina(int dia, int mes, int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(dia);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexOficina(dia, mes, anio, codTerritorio);
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
	 * reportexOficinaxAnio
	 */
	public java.util.Vector reportexOficinaxAnio(int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(anio);
				_jacc_parms[1] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexOficinaxAnio(anio, codTerritorio);
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
	 * reportexTerritorio
	 */
	public java.util.Vector reportexTerritorio(int dia, int mes, int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(dia);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexTerritorio(dia, mes, anio, codTerritorio);
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
	 * reportexTerritorioxAnio
	 */
	public java.util.Vector reportexTerritorioxAnio(int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(anio);
				_jacc_parms[1] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexTerritorioxAnio(anio, codTerritorio);
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
	 * reportexUsuario
	 */
	public java.util.Vector reportexUsuario(int dia, int mes, int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(dia);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexUsuario(dia, mes, anio, codTerritorio);
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
	 * reportexUsuarioxAnio
	 */
	public java.util.Vector reportexUsuarioxAnio(int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(anio);
				_jacc_parms[1] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexUsuarioxAnio(anio, codTerritorio);
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
	 * existeIngresoForm
	 */
	public long existeIngresoForm(int tipo, int mes, int anio, java.lang.String codUsuario, java.lang.String fecha, java.lang.String codGestorM, java.lang.String codOficinaM) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		long _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = new java.lang.Integer(tipo);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codUsuario;
				_jacc_parms[4] = fecha;
				_jacc_parms[5] = codGestorM;
				_jacc_parms[6] = codOficinaM;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.existeIngresoForm(tipo, mes, anio, codUsuario, fecha, codGestorM, codOficinaM);
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
	 * actualizarIngreso
	 */
	public void actualizarIngreso(int tipo, int idIngreso, java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(tipo);
				_jacc_parms[1] = new java.lang.Integer(idIngreso);
				_jacc_parms[2] = mes;
				_jacc_parms[3] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			beanRef.actualizarIngreso(tipo, idIngreso, mes, anio);
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
		return ;
	}
	/**
	 * actualizarIngresoFormEditUsuario
	 */
	public void actualizarIngresoFormEditUsuario(long id) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Long(id);
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			beanRef.actualizarIngresoFormEditUsuario(id);
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
		return ;
	}
	/**
	 * insertarIngresoForm
	 */
	public void insertarIngresoForm(int tipo, int mes, int anio, java.lang.String codUsuario, java.lang.String editUsuario, java.lang.String codGestor, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = new java.lang.Integer(tipo);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codUsuario;
				_jacc_parms[4] = editUsuario;
				_jacc_parms[5] = codGestor;
				_jacc_parms[6] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionIngresosBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			beanRef.insertarIngresoForm(tipo, mes, anio, codUsuario, editUsuario, codGestor, codOficina);
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
		return ;
	}
}
