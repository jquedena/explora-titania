package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionEquivalencias_4e5b84d6
 */
public class EJSRemoteStatelessSesionEquivalencias_4e5b84d6 extends EJSWrapper implements SesionEquivalencias {
	/**
	 * EJSRemoteStatelessSesionEquivalencias_4e5b84d6
	 */
	public EJSRemoteStatelessSesionEquivalencias_4e5b84d6() throws java.rmi.RemoteException {
		super();	}
	/**
	 * createEquivalencia
	 */
	public boolean createEquivalencia(com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia equivalencia) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = equivalencia;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createEquivalencia(equivalencia);
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
	 * deleteEquivalencia
	 */
	public boolean deleteEquivalencia(java.lang.String cod_cargo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_cargo;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deleteEquivalencia(cod_cargo);
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
	 * updateEquivalencia
	 */
	public boolean updateEquivalencia(com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia equivalencia) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = equivalencia;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateEquivalencia(equivalencia);
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
	 * findEquivalenciaByCodCargo
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia findEquivalenciaByCodCargo(java.lang.String codCargo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCargo;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findEquivalenciaByCodCargo(codCargo);
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
	 * findAllEquivalencias
	 */
	public java.util.Vector findAllEquivalencias() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionEquivalenciasBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllEquivalencias();
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
