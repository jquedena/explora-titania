package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSessionSQL_d285af8b
 */
public class EJSRemoteStatelessSessionSQL_d285af8b extends EJSWrapper implements SessionSQL {
	/**
	 * EJSRemoteStatelessSessionSQL_d285af8b
	 */
	public EJSRemoteStatelessSessionSQL_d285af8b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findTotalClientebyFilter
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Cliente findTotalClientebyFilter(java.lang.String cod_territorio, java.lang.String cod_oficina, java.lang.String cod_gestor, java.lang.String nivel_vinculacion, java.lang.String clasificacion, java.lang.String margen, java.lang.String etiqueta, java.lang.String edad, java.lang.String porcrie, java.lang.String cod_empresa) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.serializable.Cliente _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[10];
				_jacc_parms[0] = cod_territorio;
				_jacc_parms[1] = cod_oficina;
				_jacc_parms[2] = cod_gestor;
				_jacc_parms[3] = nivel_vinculacion;
				_jacc_parms[4] = clasificacion;
				_jacc_parms[5] = margen;
				_jacc_parms[6] = etiqueta;
				_jacc_parms[7] = edad;
				_jacc_parms[8] = porcrie;
				_jacc_parms[9] = cod_empresa;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findTotalClientebyFilter(cod_territorio, cod_oficina, cod_gestor, nivel_vinculacion, clasificacion, margen, etiqueta, edad, porcrie, cod_empresa);
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
	 * ultimoEstadoCarga
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.EstadoCarga ultimoEstadoCarga() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.serializable.EstadoCarga _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.ultimoEstadoCarga();
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
	 * findAllCabeceras
	 */
	public java.util.List findAllCabeceras(java.lang.String codigo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.List _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codigo;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllCabeceras(codigo);
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
	 * findAllClientebyFilter
	 */
	public java.util.Vector findAllClientebyFilter(int pos_ini, int pos_fin, java.lang.String cod_territorio, java.lang.String cod_oficina, java.lang.String cod_gestor, java.lang.String nivel_vinculacion, java.lang.String clasificacion, java.lang.String margen, java.lang.String etiqueta, java.lang.String edad, java.lang.String porcrie, java.lang.String cod_empresa, boolean pestanaTodos) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[13];
				_jacc_parms[0] = new java.lang.Integer(pos_ini);
				_jacc_parms[1] = new java.lang.Integer(pos_fin);
				_jacc_parms[2] = cod_territorio;
				_jacc_parms[3] = cod_oficina;
				_jacc_parms[4] = cod_gestor;
				_jacc_parms[5] = nivel_vinculacion;
				_jacc_parms[6] = clasificacion;
				_jacc_parms[7] = margen;
				_jacc_parms[8] = etiqueta;
				_jacc_parms[9] = edad;
				_jacc_parms[10] = porcrie;
				_jacc_parms[11] = cod_empresa;
				_jacc_parms[12] = new java.lang.Boolean(pestanaTodos);
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllClientebyFilter(pos_ini, pos_fin, cod_territorio, cod_oficina, cod_gestor, nivel_vinculacion, clasificacion, margen, etiqueta, edad, porcrie, cod_empresa, pestanaTodos);
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
	 * findAllEmpresasbyFilter
	 */
	public java.util.Vector findAllEmpresasbyFilter(java.lang.String cod_territorio, java.lang.String cod_oficina, java.lang.String cod_gestor, java.lang.String nivel_vinculacion, java.lang.String clasificacion, java.lang.String margen, java.lang.String etiqueta, java.lang.String edad, java.lang.String porcrie) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[9];
				_jacc_parms[0] = cod_territorio;
				_jacc_parms[1] = cod_oficina;
				_jacc_parms[2] = cod_gestor;
				_jacc_parms[3] = nivel_vinculacion;
				_jacc_parms[4] = clasificacion;
				_jacc_parms[5] = margen;
				_jacc_parms[6] = etiqueta;
				_jacc_parms[7] = edad;
				_jacc_parms[8] = porcrie;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionSQLBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllEmpresasbyFilter(cod_territorio, cod_oficina, cod_gestor, nivel_vinculacion, clasificacion, margen, etiqueta, edad, porcrie);
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
}
