package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionCampanias_28d49697
 */
public class EJSRemoteStatelessSesionCampanias_28d49697 extends EJSWrapper implements SesionCampanias {
	/**
	 * EJSRemoteStatelessSesionCampanias_28d49697
	 */
	public EJSRemoteStatelessSesionCampanias_28d49697() throws java.rmi.RemoteException {
		super();	}
	/**
	 * codigoCampMax
	 */
	public int codigoCampMax() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.codigoCampMax();
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
	 * metasGestor
	 */
	public int metasGestor(java.lang.String codGestor, int anio, int mes, java.lang.String codEpigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codGestor;
				_jacc_parms[1] = new java.lang.Integer(anio);
				_jacc_parms[2] = new java.lang.Integer(mes);
				_jacc_parms[3] = codEpigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.metasGestor(codGestor, anio, mes, codEpigrafe);
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
	 * metasOficina
	 */
	public int metasOficina(java.lang.String codOficina, int anio, int mes, java.lang.String codEpigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = new java.lang.Integer(anio);
				_jacc_parms[2] = new java.lang.Integer(mes);
				_jacc_parms[3] = codEpigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.metasOficina(codOficina, anio, mes, codEpigrafe);
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
	 * busAnhoMaxAcciones
	 */
	public java.util.Vector busAnhoMaxAcciones() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAnhoMaxAcciones();
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
	 * busAnhosAcciones
	 */
	public java.util.Vector busAnhosAcciones() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAnhosAcciones();
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
	 * editarCampania
	 */
	public java.util.Vector editarCampania(java.lang.String anho, java.lang.String mes, java.lang.String nomCamp, java.lang.String orden, java.lang.String codCamp, java.lang.String usuario, java.lang.String codEpigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = nomCamp;
				_jacc_parms[3] = orden;
				_jacc_parms[4] = codCamp;
				_jacc_parms[5] = usuario;
				_jacc_parms[6] = codEpigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editarCampania(anho, mes, nomCamp, orden, codCamp, usuario, codEpigrafe);
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
	 * eliminarCampania
	 */
	public java.util.Vector eliminarCampania(java.lang.String codCamp) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCamp;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarCampania(codCamp);
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
	 * mostrarEditarCampania
	 */
	public java.util.Vector mostrarEditarCampania(java.lang.String codCamp) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCamp;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.mostrarEditarCampania(codCamp);
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
	 * mostrarEsfuerzoCampania
	 */
	public java.util.Vector mostrarEsfuerzoCampania(java.lang.String codGest, java.lang.String mes, java.lang.String anho, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codGest;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.mostrarEsfuerzoCampania(codGest, mes, anho, codOficina);
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
	 * nuevaCampania
	 */
	public java.util.Vector nuevaCampania(int codCamp, java.lang.String nomCamp, java.lang.String codOficicina, java.lang.String codTerritorio, java.lang.String codGestor, java.lang.String anho, java.lang.String mes, java.lang.String orden, java.lang.String get, java.lang.String usuario, java.lang.String codEpigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[11];
				_jacc_parms[0] = new java.lang.Integer(codCamp);
				_jacc_parms[1] = nomCamp;
				_jacc_parms[2] = codOficicina;
				_jacc_parms[3] = codTerritorio;
				_jacc_parms[4] = codGestor;
				_jacc_parms[5] = anho;
				_jacc_parms[6] = mes;
				_jacc_parms[7] = orden;
				_jacc_parms[8] = get;
				_jacc_parms[9] = usuario;
				_jacc_parms[10] = codEpigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionCampaniasBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevaCampania(codCamp, nomCamp, codOficicina, codTerritorio, codGestor, anho, mes, orden, get, usuario, codEpigrafe);
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
}
