package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiilc_area_fdd98ec5
 */
public class EJSLocalCMPTiilc_area_fdd98ec5 extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal {
	/**
	 * EJSLocalCMPTiilc_area_fdd98ec5
	 */
	public EJSLocalCMPTiilc_area_fdd98ec5() {
		super();	}
	/**
	 * getCod_area
	 */
	public java.lang.String getCod_area() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCod_area();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 0, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDes_area
	 */
	public java.lang.String getDes_area() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDes_area();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 1, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTiilc_territorio
	 */
	public java.util.Collection getTiilc_territorio() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getTiilc_territorio();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * setCod_area
	 */
	public void setCod_area(java.lang.String newCod_area) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCod_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			beanRef.setCod_area(newCod_area);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 3, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDes_area
	 */
	public void setDes_area(java.lang.String newDes_area) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDes_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			beanRef.setDes_area(newDes_area);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 4, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTiilc_territorio
	 */
	public void setTiilc_territorio(java.util.Collection aTiilc_territorio) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = aTiilc_territorio;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			beanRef.setTiilc_territorio(aTiilc_territorio);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 5, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
