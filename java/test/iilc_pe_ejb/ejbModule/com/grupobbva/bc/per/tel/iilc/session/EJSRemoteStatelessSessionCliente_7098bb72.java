package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSessionCliente_7098bb72
 */
public class EJSRemoteStatelessSessionCliente_7098bb72 extends EJSWrapper implements SessionCliente {
	/**
	 * EJSRemoteStatelessSessionCliente_7098bb72
	 */
	public EJSRemoteStatelessSessionCliente_7098bb72() throws java.rmi.RemoteException {
		super();	}
	/**
	 * deleteCliente
	 */
	public boolean deleteCliente(int cod_cliente) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(cod_cliente);
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deleteCliente(cod_cliente);
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
	 * findCliente
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Cliente findCliente(int cod_cliente) throws javax.ejb.FinderException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.serializable.Cliente _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(cod_cliente);
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findCliente(cod_cliente);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * countCliente
	 */
	public int countCliente() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.countCliente();
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
	 * countClientebyGestor
	 */
	public int countClientebyGestor(java.lang.String cod_territorio, java.lang.String cod_oficina, java.lang.String cod_gestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = cod_territorio;
				_jacc_parms[1] = cod_oficina;
				_jacc_parms[2] = cod_gestor;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.countClientebyGestor(cod_territorio, cod_oficina, cod_gestor);
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
	 * countClientebyOficina
	 */
	public int countClientebyOficina(java.lang.String cod_territorio, java.lang.String cod_oficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_territorio;
				_jacc_parms[1] = cod_oficina;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.countClientebyOficina(cod_territorio, cod_oficina);
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
	 * countClientebyTerritorio
	 */
	public int countClientebyTerritorio(java.lang.String cod_territorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_territorio;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionClienteBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.countClientebyTerritorio(cod_territorio);
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
