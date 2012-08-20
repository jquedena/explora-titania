package com.grupobbva.bc.per.tel.iilc.session;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSessionTotal_a3309cbe
 */
public class EJSRemoteStatelessSessionTotal_a3309cbe extends EJSWrapper implements SessionTotal {
	/**
	 * EJSRemoteStatelessSessionTotal_a3309cbe
	 */
	public EJSRemoteStatelessSessionTotal_a3309cbe() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findTotal
	 */
	public com.grupobbva.bc.per.tel.iilc.serializable.Total findTotal(java.lang.String ind_registro, java.lang.String cod_territorio, java.lang.String cod_oficina, java.lang.String cod_gestor) throws javax.ejb.FinderException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.serializable.Total _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = ind_registro;
				_jacc_parms[1] = cod_territorio;
				_jacc_parms[2] = cod_oficina;
				_jacc_parms[3] = cod_gestor;
			}
	com.grupobbva.bc.per.tel.iilc.session.SessionTotalBean beanRef = (com.grupobbva.bc.per.tel.iilc.session.SessionTotalBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findTotal(ind_registro, cod_territorio, cod_oficina, cod_gestor);
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
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
