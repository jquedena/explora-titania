package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionMetasGestor_bb1d00b4
 */
public class EJSRemoteStatelessSesionMetasGestor_bb1d00b4 extends EJSWrapper implements SesionMetasGestor {
	/**
	 * EJSRemoteStatelessSesionMetasGestor_bb1d00b4
	 */
	public EJSRemoteStatelessSesionMetasGestor_bb1d00b4() throws java.rmi.RemoteException {
		super();	}
	/**
	 * createMetasGestor
	 */
	public boolean createMetasGestor(com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor metasGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = metasGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createMetasGestor(metasGestor);
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
	 * updateMetasGestor
	 */
	public boolean updateMetasGestor(com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor metasGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = metasGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateMetasGestor(metasGestor);
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
	 * findGestorByCodMonthYear
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor findGestorByCodMonthYear(java.lang.String anho, java.lang.String mes, java.lang.String codOficina, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findGestorByCodMonthYear(anho, mes, codOficina, codGestor);
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
	 * findGestorByCodigo
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor findGestorByCodigo(java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findGestorByCodigo(codGestor);
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
	 * findMetGestorByPrimaryKey
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor findMetGestorByPrimaryKey(java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codEpigrafe;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findMetGestorByPrimaryKey(codEpigrafe, anho, codOficina, mes, codGestor);
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
	 * buscarMontoGestor
	 */
	public java.math.BigDecimal buscarMontoGestor(java.lang.String codGestor, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codGestor;
				_jacc_parms[1] = codEpigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
				_jacc_parms[4] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.buscarMontoGestor(codGestor, codEpigrafe, anho, codOficina, mes);
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
	 * promedioMensual
	 */
	public java.math.BigDecimal promedioMensual(java.lang.String anho, java.lang.String mes, java.lang.String codOfi, java.lang.String codTerr, java.lang.String codEpi, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codOfi;
				_jacc_parms[3] = codTerr;
				_jacc_parms[4] = codEpi;
				_jacc_parms[5] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.promedioMensual(anho, mes, codOfi, codTerr, codEpi, codGestor);
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
	 * buscarResumenMontos
	 */
	public java.util.HashMap buscarResumenMontos(java.util.Vector listaEpigrafe, java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.HashMap _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = listaEpigrafe;
				_jacc_parms[1] = codTerritorio;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = anho;
				_jacc_parms[4] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.buscarResumenMontos(listaEpigrafe, codTerritorio, codOficina, anho, mes);
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
	 * busAllAnhos
	 */
	public java.util.Vector busAllAnhos() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAllAnhos();
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
	 * busEpigrafeAcciones2
	 */
	public java.util.Vector busEpigrafeAcciones2(java.lang.String codGestor, java.lang.String anho, java.lang.String mes, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codGestor;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = mes;
				_jacc_parms[3] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busEpigrafeAcciones2(codGestor, anho, mes, codOficina);
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
	 * busGestorxOficina
	 */
	public java.util.Vector busGestorxOficina(java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busGestorxOficina(codOficina);
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
	 * busGestorxOficinaxAnioxMes
	 */
	public java.util.Vector busGestorxOficinaxAnioxMes(java.lang.String codOficina, java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busGestorxOficinaxAnioxMes(codOficina, mes, anio);
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
	 * busOficinaCodyNom
	 */
	public java.util.Vector busOficinaCodyNom(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busOficinaCodyNom(codTerritorio);
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
	 * distribuirGOF
	 */
	public java.util.Vector distribuirGOF(java.util.Vector listaGestoresLDAP, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = listaGestoresLDAP;
				_jacc_parms[1] = codEpigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
				_jacc_parms[4] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.distribuirGOF(listaGestoresLDAP, codEpigrafe, anho, codOficina, mes);
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
	 * nuevaMetaGestor
	 */
	public java.util.Vector nuevaMetaGestor(java.lang.String codMetaGestor, java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codGestor, java.lang.String codigoPerfil, java.lang.String mes, java.lang.Double porc_asig, java.lang.String nom_epigrafe, java.lang.String nom_gestor, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[12];
				_jacc_parms[0] = codMetaGestor;
				_jacc_parms[1] = codTerritorio;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codEpigrafe;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = codGestor;
				_jacc_parms[6] = codigoPerfil;
				_jacc_parms[7] = mes;
				_jacc_parms[8] = porc_asig;
				_jacc_parms[9] = nom_epigrafe;
				_jacc_parms[10] = nom_gestor;
				_jacc_parms[11] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevaMetaGestor(codMetaGestor, codTerritorio, codOficina, codEpigrafe, anho, codGestor, codigoPerfil, mes, porc_asig, nom_epigrafe, nom_gestor, usuario);
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
	 * reportePGO1
	 */
	public java.util.Vector reportePGO1(java.lang.String codAnho, java.lang.String codMes, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codAnho;
				_jacc_parms[1] = codMes;
				_jacc_parms[2] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGO1(codAnho, codMes, codOficina);
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
	 * reportePGOEsfuerzos
	 */
	public java.util.Vector reportePGOEsfuerzos(java.lang.String codAnho, java.lang.String codMes, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codAnho;
				_jacc_parms[1] = codMes;
				_jacc_parms[2] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGOEsfuerzos(codAnho, codMes, codOficina);
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
	 * actualizarCargoGestoresLDAP
	 */
	public void actualizarCargoGestoresLDAP(java.util.Vector listaGestoresLDAP, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = listaGestoresLDAP;
				_jacc_parms[1] = codEpigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
				_jacc_parms[4] = mes;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			beanRef.actualizarCargoGestoresLDAP(listaGestoresLDAP, codEpigrafe, anho, codOficina, mes, usuario);
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
		return ;
	}
	/**
	 * actualizarGestoresDistribuidosLDAP
	 */
	public void actualizarGestoresDistribuidosLDAP(java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codEpigrafe;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			beanRef.actualizarGestoresDistribuidosLDAP(codEpigrafe, anho, codOficina, mes, usuario);
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
		return ;
	}
	/**
	 * actualizarGestoresEliminadosLDAP
	 */
	public void actualizarGestoresEliminadosLDAP(java.util.Vector listaGestoresLDAP, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = listaGestoresLDAP;
				_jacc_parms[1] = codEpigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
				_jacc_parms[4] = mes;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			beanRef.actualizarGestoresEliminadosLDAP(listaGestoresLDAP, codEpigrafe, anho, codOficina, mes, usuario);
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
		return ;
	}
	/**
	 * actualizarMetaGestoresPlanes
	 */
	public void actualizarMetaGestoresPlanes(java.util.Vector listaEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String codGestorGOF, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = listaEpigrafe;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = codGestorGOF;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			beanRef.actualizarMetaGestoresPlanes(listaEpigrafe, anho, codOficina, mes, codGestorGOF, usuario);
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
		return ;
	}
	/**
	 * eliminarMetaGestoresHijas
	 */
	public void eliminarMetaGestoresHijas(java.util.Vector listaGestores) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = listaGestores;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionMetasGestorBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			beanRef.eliminarMetaGestoresHijas(listaGestores);
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
		return ;
	}
}
