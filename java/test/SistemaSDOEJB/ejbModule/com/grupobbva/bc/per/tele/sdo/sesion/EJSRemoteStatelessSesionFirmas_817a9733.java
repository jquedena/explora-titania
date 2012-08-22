package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionFirmas_817a9733
 */
public class EJSRemoteStatelessSesionFirmas_817a9733 extends EJSWrapper implements SesionFirmas {
	/**
	 * EJSRemoteStatelessSesionFirmas_817a9733
	 */
	public EJSRemoteStatelessSesionFirmas_817a9733() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findFirmByAnoMesCgesItem
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Firmas findFirmByAnoMesCgesItem(java.lang.String anho, java.lang.String mes, java.lang.String codGestor, java.lang.String item) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Firmas _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codGestor;
				_jacc_parms[3] = item;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionFirmasBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionFirmasBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findFirmByAnoMesCgesItem(anho, mes, codGestor, item);
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
