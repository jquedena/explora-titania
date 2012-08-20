package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiilc_total_40ed895e
 */
public class EJSLocalCMPTiilc_total_40ed895e extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal {
	/**
	 * EJSLocalCMPTiilc_total_40ed895e
	 */
	public EJSLocalCMPTiilc_total_40ed895e() {
		super();	}
	/**
	 * getCod_gestor
	 */
	public java.lang.String getCod_gestor() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCod_gestor();
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
	 * getCod_oficina
	 */
	public java.lang.String getCod_oficina() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCod_oficina();
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
	 * getCod_territorio
	 */
	public java.lang.String getCod_territorio() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCod_territorio();
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
	 * getInd_registro
	 */
	public java.lang.String getInd_registro() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getInd_registro();
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
		return _EJS_result;
	}
	/**
	 * getAhor_t
	 */
	public java.math.BigDecimal getAhor_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAhor_t();
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
		return _EJS_result;
	}
	/**
	 * getAhsd_t
	 */
	public java.math.BigDecimal getAhsd_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAhsd_t();
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
		return _EJS_result;
	}
	/**
	 * getAval_t
	 */
	public java.math.BigDecimal getAval_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getAval_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 6, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getB24_t
	 */
	public java.math.BigDecimal getB24_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getB24_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 7, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCcte_t
	 */
	public java.math.BigDecimal getCcte_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCcte_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 8, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCemp_t
	 */
	public java.math.BigDecimal getCemp_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCemp_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 9, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCext_t
	 */
	public java.math.BigDecimal getCext_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCext_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 10, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getClixgest
	 */
	public java.math.BigDecimal getClixgest() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getClixgest();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 11, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCloc_t
	 */
	public java.math.BigDecimal getCloc_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCloc_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 12, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCnet_t
	 */
	public java.math.BigDecimal getCnet_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCnet_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 13, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCod_total
	 */
	public java.math.BigDecimal getCod_total() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCod_total();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 14, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getColb_t
	 */
	public java.math.BigDecimal getColb_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getColb_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 15, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCpte_t
	 */
	public java.math.BigDecimal getCpte_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCpte_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 16, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCs000lineamaxtc_t
	 */
	public java.math.BigDecimal getCs000lineamaxtc_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCs000lineamaxtc_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 17, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCs000mtoprestamo_t
	 */
	public java.math.BigDecimal getCs000mtoprestamo_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCs000mtoprestamo_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 18, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCts_t
	 */
	public java.math.BigDecimal getCts_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCts_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 19, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCtsd_t
	 */
	public java.math.BigDecimal getCtsd_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCtsd_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 20, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCvip_t
	 */
	public java.math.BigDecimal getCvip_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCvip_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 21, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDep_t
	 */
	public java.math.BigDecimal getDep_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDep_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 22, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDesvin
	 */
	public java.math.BigDecimal getDesvin() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDesvin();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 23, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDsct_t
	 */
	public java.math.BigDecimal getDsct_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getDsct_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 24, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEmph_t
	 */
	public java.math.BigDecimal getEmph_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getEmph_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 25, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getFcex_t
	 */
	public java.math.BigDecimal getFcex_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getFcex_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 26, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getFmut_t
	 */
	public java.math.BigDecimal getFmut_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 27, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getFmut_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 27, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getIcalicte00
	 */
	public java.math.BigDecimal getIcalicte00() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 28, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getIcalicte00();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 28, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getIcalicte10
	 */
	public java.math.BigDecimal getIcalicte10() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 29, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getIcalicte10();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 29, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getIcalicte20
	 */
	public java.math.BigDecimal getIcalicte20() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 30, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getIcalicte20();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 30, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getIcalicte30
	 */
	public java.math.BigDecimal getIcalicte30() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 31, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getIcalicte30();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 31, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getIcalicte40
	 */
	public java.math.BigDecimal getIcalicte40() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 32, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getIcalicte40();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 32, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getJurvin
	 */
	public java.math.BigDecimal getJurvin() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 33, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getJurvin();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 33, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLcta_t
	 */
	public java.math.BigDecimal getLcta_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 34, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getLcta_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 34, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeas_t
	 */
	public java.math.BigDecimal getLeas_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 35, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getLeas_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 35, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLinco_t
	 */
	public java.math.BigDecimal getLinco_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 36, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getLinco_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 36, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getMcla_t
	 */
	public java.math.BigDecimal getMcla_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 37, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getMcla_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 37, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getMofactv_t
	 */
	public java.math.BigDecimal getMofactv_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 38, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getMofactv_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 38, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getMontohipotecario_t
	 */
	public java.math.BigDecimal getMontohipotecario_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 39, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getMontohipotecario_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 39, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getMontosubrogados_t
	 */
	public java.math.BigDecimal getMontosubrogados_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 40, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getMontosubrogados_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 40, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getMontovehicular_t
	 */
	public java.math.BigDecimal getMontovehicular_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 41, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getMontovehicular_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 41, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getMoro_t
	 */
	public java.math.BigDecimal getMoro_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 42, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getMoro_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 42, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getMp_t
	 */
	public java.math.BigDecimal getMp_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 43, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getMp_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 43, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getMuyvin
	 */
	public java.math.BigDecimal getMuyvin() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 44, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getMuyvin();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 44, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getNatdesvin
	 */
	public java.math.BigDecimal getNatdesvin() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 45, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getNatdesvin();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 45, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getNatvin
	 */
	public java.math.BigDecimal getNatvin() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 46, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getNatvin();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 46, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPasivo_t
	 */
	public java.math.BigDecimal getPasivo_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 47, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPasivo_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 47, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPaut_t
	 */
	public java.math.BigDecimal getPaut_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 48, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPaut_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 48, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPcom_t
	 */
	public java.math.BigDecimal getPcom_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 49, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPcom_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 49, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPer_t
	 */
	public java.math.BigDecimal getPer_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 50, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPer_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 50, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPh_t
	 */
	public java.math.BigDecimal getPh_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 51, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPh_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 51, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPhip_t
	 */
	public java.math.BigDecimal getPhip_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 52, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPhip_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 52, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPlzo_t
	 */
	public java.math.BigDecimal getPlzo_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 53, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPlzo_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 53, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPmas_t
	 */
	public java.math.BigDecimal getPmas_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 54, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPmas_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 54, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPmiv_t
	 */
	public java.math.BigDecimal getPmiv_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 55, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPmiv_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 55, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPocovin
	 */
	public java.math.BigDecimal getPocovin() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 56, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPocovin();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 56, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPos_t
	 */
	public java.math.BigDecimal getPos_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 57, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPos_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 57, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPper_t
	 */
	public java.math.BigDecimal getPper_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 58, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPper_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 58, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPpper_t
	 */
	public java.math.BigDecimal getPpper_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 59, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPpper_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 59, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPref_t
	 */
	public java.math.BigDecimal getPref_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 60, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPref_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 60, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProm_t
	 */
	public java.math.BigDecimal getProm_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 61, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getProm_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 61, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPser_t
	 */
	public java.math.BigDecimal getPser_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 62, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPser_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 62, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPserv_t
	 */
	public java.math.BigDecimal getPserv_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 63, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getPserv_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 63, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRiesgo_d_t
	 */
	public java.math.BigDecimal getRiesgo_d_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 64, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRiesgo_d_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 64, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRiesgo_i_t
	 */
	public java.math.BigDecimal getRiesgo_i_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 65, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRiesgo_i_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 65, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRiesgo_t
	 */
	public java.math.BigDecimal getRiesgo_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 66, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getRiesgo_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 66, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSdep_t
	 */
	public java.math.BigDecimal getSdep_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 67, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSdep_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 67, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_10100
	 */
	public java.math.BigDecimal getSeg_10100() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 68, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_10100();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 68, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_10200
	 */
	public java.math.BigDecimal getSeg_10200() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 69, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_10200();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 69, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_20100
	 */
	public java.math.BigDecimal getSeg_20100() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 70, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_20100();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 70, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_20200
	 */
	public java.math.BigDecimal getSeg_20200() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 71, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_20200();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 71, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_20300
	 */
	public java.math.BigDecimal getSeg_20300() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 72, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_20300();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 72, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_20400
	 */
	public java.math.BigDecimal getSeg_20400() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 73, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_20400();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 73, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_20500
	 */
	public java.math.BigDecimal getSeg_20500() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 74, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_20500();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 74, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_20600
	 */
	public java.math.BigDecimal getSeg_20600() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 75, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_20600();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 75, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_30100
	 */
	public java.math.BigDecimal getSeg_30100() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 76, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_30100();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 76, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_30200
	 */
	public java.math.BigDecimal getSeg_30200() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 77, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_30200();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 77, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_30300
	 */
	public java.math.BigDecimal getSeg_30300() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 78, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_30300();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 78, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_30400
	 */
	public java.math.BigDecimal getSeg_30400() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 79, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_30400();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 79, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_40100
	 */
	public java.math.BigDecimal getSeg_40100() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 80, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_40100();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 80, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_40200
	 */
	public java.math.BigDecimal getSeg_40200() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 81, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_40200();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 81, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_40300
	 */
	public java.math.BigDecimal getSeg_40300() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 82, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_40300();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 82, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_40400
	 */
	public java.math.BigDecimal getSeg_40400() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 83, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_40400();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 83, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_50100
	 */
	public java.math.BigDecimal getSeg_50100() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 84, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_50100();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 84, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_50200
	 */
	public java.math.BigDecimal getSeg_50200() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 85, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_50200();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 85, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_50300
	 */
	public java.math.BigDecimal getSeg_50300() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 86, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_50300();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 86, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_50400
	 */
	public java.math.BigDecimal getSeg_50400() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 87, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_50400();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 87, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_60100
	 */
	public java.math.BigDecimal getSeg_60100() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 88, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_60100();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 88, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_60200
	 */
	public java.math.BigDecimal getSeg_60200() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 89, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_60200();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 89, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_60300
	 */
	public java.math.BigDecimal getSeg_60300() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 90, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_60300();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 90, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_60400
	 */
	public java.math.BigDecimal getSeg_60400() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 91, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_60400();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 91, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_80100
	 */
	public java.math.BigDecimal getSeg_80100() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 92, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_80100();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 92, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_80200
	 */
	public java.math.BigDecimal getSeg_80200() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 93, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_80200();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 93, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_80300
	 */
	public java.math.BigDecimal getSeg_80300() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 94, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_80300();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 94, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_80400
	 */
	public java.math.BigDecimal getSeg_80400() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 95, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_80400();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 95, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_80500
	 */
	public java.math.BigDecimal getSeg_80500() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 96, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_80500();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 96, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_80600
	 */
	public java.math.BigDecimal getSeg_80600() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 97, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_80600();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 97, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_80700
	 */
	public java.math.BigDecimal getSeg_80700() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 98, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_80700();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 98, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_90200
	 */
	public java.math.BigDecimal getSeg_90200() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 99, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_90200();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 99, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSeg_99900
	 */
	public java.math.BigDecimal getSeg_99900() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 100, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSeg_99900();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 100, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSext_t
	 */
	public java.math.BigDecimal getSext_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 101, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSext_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 101, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSonc_t
	 */
	public java.math.BigDecimal getSonc_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 102, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSonc_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 102, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSpro_t
	 */
	public java.math.BigDecimal getSpro_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 103, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSpro_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 103, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_act_ct1
	 */
	public java.math.BigDecimal getSum_act_ct1() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 104, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_act_ct1();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 104, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_act_ct2
	 */
	public java.math.BigDecimal getSum_act_ct2() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 105, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_act_ct2();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 105, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_act_ct3
	 */
	public java.math.BigDecimal getSum_act_ct3() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 106, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_act_ct3();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 106, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_act_ct4
	 */
	public java.math.BigDecimal getSum_act_ct4() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 107, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_act_ct4();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 107, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_act_ct5
	 */
	public java.math.BigDecimal getSum_act_ct5() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 108, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_act_ct5();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 108, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_act_ct6
	 */
	public java.math.BigDecimal getSum_act_ct6() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 109, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_act_ct6();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 109, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_act_cto
	 */
	public java.math.BigDecimal getSum_act_cto() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 110, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_act_cto();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 110, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_t_act
	 */
	public java.math.BigDecimal getSum_t_act() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 111, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_t_act();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 111, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_t_act1
	 */
	public java.math.BigDecimal getSum_t_act1() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 112, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_t_act1();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 112, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_t_act2
	 */
	public java.math.BigDecimal getSum_t_act2() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 113, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_t_act2();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 113, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_t_act3
	 */
	public java.math.BigDecimal getSum_t_act3() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 114, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_t_act3();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 114, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_t_act4
	 */
	public java.math.BigDecimal getSum_t_act4() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 115, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_t_act4();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 115, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_t_act5
	 */
	public java.math.BigDecimal getSum_t_act5() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 116, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_t_act5();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 116, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSum_t_act6
	 */
	public java.math.BigDecimal getSum_t_act6() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 117, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSum_t_act6();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 117, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSvid_t
	 */
	public java.math.BigDecimal getSvid_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 118, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSvid_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 118, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSvip_t
	 */
	public java.math.BigDecimal getSvip_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 119, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getSvip_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 119, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTde_t
	 */
	public java.math.BigDecimal getTde_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 120, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getTde_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 120, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTdeb_t
	 */
	public java.math.BigDecimal getTdeb_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 121, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getTdeb_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 121, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTvip_t
	 */
	public java.math.BigDecimal getTvip_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 122, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getTvip_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 122, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVarc_t
	 */
	public java.math.BigDecimal getVarc_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 123, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVarc_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 123, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVcla_t
	 */
	public java.math.BigDecimal getVcla_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 124, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVcla_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 124, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVctr_t
	 */
	public java.math.BigDecimal getVctr_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 125, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVctr_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 125, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVemp_t
	 */
	public java.math.BigDecimal getVemp_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 126, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVemp_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 126, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVid_t
	 */
	public java.math.BigDecimal getVid_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 127, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVid_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 127, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVin
	 */
	public java.math.BigDecimal getVin() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 128, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVin();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 128, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVip_t
	 */
	public java.math.BigDecimal getVip_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 129, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVip_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 129, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVnac_t
	 */
	public java.math.BigDecimal getVnac_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 130, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVnac_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 130, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVolumen_t
	 */
	public java.math.BigDecimal getVolumen_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 131, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVolumen_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 131, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVoro_t
	 */
	public java.math.BigDecimal getVoro_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 132, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVoro_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 132, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVpla_t
	 */
	public java.math.BigDecimal getVpla_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 133, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVpla_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 133, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVpola_t
	 */
	public java.math.BigDecimal getVpola_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 134, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVpola_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 134, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVrep_t
	 */
	public java.math.BigDecimal getVrep_t() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 135, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getVrep_t();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 135, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * setAhor_t
	 */
	public void setAhor_t(java.math.BigDecimal newAhor_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newAhor_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 136, _EJS_s, _jacc_parms);
			beanRef.setAhor_t(newAhor_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 136, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAhsd_t
	 */
	public void setAhsd_t(java.math.BigDecimal newAhsd_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newAhsd_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 137, _EJS_s, _jacc_parms);
			beanRef.setAhsd_t(newAhsd_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 137, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAval_t
	 */
	public void setAval_t(java.math.BigDecimal newAval_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newAval_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 138, _EJS_s, _jacc_parms);
			beanRef.setAval_t(newAval_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 138, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setB24_t
	 */
	public void setB24_t(java.math.BigDecimal newB24_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newB24_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 139, _EJS_s, _jacc_parms);
			beanRef.setB24_t(newB24_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 139, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCcte_t
	 */
	public void setCcte_t(java.math.BigDecimal newCcte_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCcte_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 140, _EJS_s, _jacc_parms);
			beanRef.setCcte_t(newCcte_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 140, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCemp_t
	 */
	public void setCemp_t(java.math.BigDecimal newCemp_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCemp_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 141, _EJS_s, _jacc_parms);
			beanRef.setCemp_t(newCemp_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 141, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCext_t
	 */
	public void setCext_t(java.math.BigDecimal newCext_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCext_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 142, _EJS_s, _jacc_parms);
			beanRef.setCext_t(newCext_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 142, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setClixgest
	 */
	public void setClixgest(java.math.BigDecimal newClixgest) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newClixgest;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 143, _EJS_s, _jacc_parms);
			beanRef.setClixgest(newClixgest);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 143, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCloc_t
	 */
	public void setCloc_t(java.math.BigDecimal newCloc_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCloc_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 144, _EJS_s, _jacc_parms);
			beanRef.setCloc_t(newCloc_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 144, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCnet_t
	 */
	public void setCnet_t(java.math.BigDecimal newCnet_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCnet_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 145, _EJS_s, _jacc_parms);
			beanRef.setCnet_t(newCnet_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 145, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCod_gestor
	 */
	public void setCod_gestor(java.lang.String newCod_gestor) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCod_gestor;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 146, _EJS_s, _jacc_parms);
			beanRef.setCod_gestor(newCod_gestor);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 146, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCod_oficina
	 */
	public void setCod_oficina(java.lang.String newCod_oficina) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCod_oficina;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 147, _EJS_s, _jacc_parms);
			beanRef.setCod_oficina(newCod_oficina);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 147, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCod_territorio
	 */
	public void setCod_territorio(java.lang.String newCod_territorio) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCod_territorio;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 148, _EJS_s, _jacc_parms);
			beanRef.setCod_territorio(newCod_territorio);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 148, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCod_total
	 */
	public void setCod_total(java.math.BigDecimal newCod_total) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCod_total;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 149, _EJS_s, _jacc_parms);
			beanRef.setCod_total(newCod_total);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 149, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setColb_t
	 */
	public void setColb_t(java.math.BigDecimal newColb_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newColb_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 150, _EJS_s, _jacc_parms);
			beanRef.setColb_t(newColb_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 150, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCpte_t
	 */
	public void setCpte_t(java.math.BigDecimal newCpte_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCpte_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 151, _EJS_s, _jacc_parms);
			beanRef.setCpte_t(newCpte_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 151, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCs000lineamaxtc_t
	 */
	public void setCs000lineamaxtc_t(java.math.BigDecimal newCs000lineamaxtc_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCs000lineamaxtc_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 152, _EJS_s, _jacc_parms);
			beanRef.setCs000lineamaxtc_t(newCs000lineamaxtc_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 152, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCs000mtoprestamo_t
	 */
	public void setCs000mtoprestamo_t(java.math.BigDecimal newCs000mtoprestamo_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCs000mtoprestamo_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 153, _EJS_s, _jacc_parms);
			beanRef.setCs000mtoprestamo_t(newCs000mtoprestamo_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 153, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCts_t
	 */
	public void setCts_t(java.math.BigDecimal newCts_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCts_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 154, _EJS_s, _jacc_parms);
			beanRef.setCts_t(newCts_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 154, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCtsd_t
	 */
	public void setCtsd_t(java.math.BigDecimal newCtsd_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCtsd_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 155, _EJS_s, _jacc_parms);
			beanRef.setCtsd_t(newCtsd_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 155, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCvip_t
	 */
	public void setCvip_t(java.math.BigDecimal newCvip_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newCvip_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 156, _EJS_s, _jacc_parms);
			beanRef.setCvip_t(newCvip_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 156, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDep_t
	 */
	public void setDep_t(java.math.BigDecimal newDep_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDep_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 157, _EJS_s, _jacc_parms);
			beanRef.setDep_t(newDep_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 157, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDesvin
	 */
	public void setDesvin(java.math.BigDecimal newDesvin) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDesvin;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 158, _EJS_s, _jacc_parms);
			beanRef.setDesvin(newDesvin);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 158, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDsct_t
	 */
	public void setDsct_t(java.math.BigDecimal newDsct_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newDsct_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 159, _EJS_s, _jacc_parms);
			beanRef.setDsct_t(newDsct_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 159, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setEmph_t
	 */
	public void setEmph_t(java.math.BigDecimal newEmph_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newEmph_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 160, _EJS_s, _jacc_parms);
			beanRef.setEmph_t(newEmph_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 160, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setFcex_t
	 */
	public void setFcex_t(java.math.BigDecimal newFcex_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newFcex_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 161, _EJS_s, _jacc_parms);
			beanRef.setFcex_t(newFcex_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 161, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setFmut_t
	 */
	public void setFmut_t(java.math.BigDecimal newFmut_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newFmut_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 162, _EJS_s, _jacc_parms);
			beanRef.setFmut_t(newFmut_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 162, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIcalicte00
	 */
	public void setIcalicte00(java.math.BigDecimal newIcalicte00) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newIcalicte00;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 163, _EJS_s, _jacc_parms);
			beanRef.setIcalicte00(newIcalicte00);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 163, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIcalicte10
	 */
	public void setIcalicte10(java.math.BigDecimal newIcalicte10) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newIcalicte10;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 164, _EJS_s, _jacc_parms);
			beanRef.setIcalicte10(newIcalicte10);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 164, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIcalicte20
	 */
	public void setIcalicte20(java.math.BigDecimal newIcalicte20) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newIcalicte20;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 165, _EJS_s, _jacc_parms);
			beanRef.setIcalicte20(newIcalicte20);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 165, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIcalicte30
	 */
	public void setIcalicte30(java.math.BigDecimal newIcalicte30) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newIcalicte30;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 166, _EJS_s, _jacc_parms);
			beanRef.setIcalicte30(newIcalicte30);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 166, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIcalicte40
	 */
	public void setIcalicte40(java.math.BigDecimal newIcalicte40) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newIcalicte40;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 167, _EJS_s, _jacc_parms);
			beanRef.setIcalicte40(newIcalicte40);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 167, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setInd_registro
	 */
	public void setInd_registro(java.lang.String newInd_registro) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newInd_registro;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 168, _EJS_s, _jacc_parms);
			beanRef.setInd_registro(newInd_registro);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 168, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setJurvin
	 */
	public void setJurvin(java.math.BigDecimal newJurvin) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newJurvin;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 169, _EJS_s, _jacc_parms);
			beanRef.setJurvin(newJurvin);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 169, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLcta_t
	 */
	public void setLcta_t(java.math.BigDecimal newLcta_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newLcta_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 170, _EJS_s, _jacc_parms);
			beanRef.setLcta_t(newLcta_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 170, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLeas_t
	 */
	public void setLeas_t(java.math.BigDecimal newLeas_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newLeas_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 171, _EJS_s, _jacc_parms);
			beanRef.setLeas_t(newLeas_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 171, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLinco_t
	 */
	public void setLinco_t(java.math.BigDecimal newLinco_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newLinco_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 172, _EJS_s, _jacc_parms);
			beanRef.setLinco_t(newLinco_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 172, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMcla_t
	 */
	public void setMcla_t(java.math.BigDecimal newMcla_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newMcla_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 173, _EJS_s, _jacc_parms);
			beanRef.setMcla_t(newMcla_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 173, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMofactv_t
	 */
	public void setMofactv_t(java.math.BigDecimal newMofactv_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newMofactv_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 174, _EJS_s, _jacc_parms);
			beanRef.setMofactv_t(newMofactv_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 174, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMontohipotecario_t
	 */
	public void setMontohipotecario_t(java.math.BigDecimal newMontohipotecario_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newMontohipotecario_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 175, _EJS_s, _jacc_parms);
			beanRef.setMontohipotecario_t(newMontohipotecario_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 175, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMontosubrogados_t
	 */
	public void setMontosubrogados_t(java.math.BigDecimal newMontosubrogados_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newMontosubrogados_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 176, _EJS_s, _jacc_parms);
			beanRef.setMontosubrogados_t(newMontosubrogados_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 176, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMontovehicular_t
	 */
	public void setMontovehicular_t(java.math.BigDecimal newMontovehicular_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newMontovehicular_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 177, _EJS_s, _jacc_parms);
			beanRef.setMontovehicular_t(newMontovehicular_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 177, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMoro_t
	 */
	public void setMoro_t(java.math.BigDecimal newMoro_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newMoro_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 178, _EJS_s, _jacc_parms);
			beanRef.setMoro_t(newMoro_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 178, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMp_t
	 */
	public void setMp_t(java.math.BigDecimal newMp_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newMp_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 179, _EJS_s, _jacc_parms);
			beanRef.setMp_t(newMp_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 179, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMuyvin
	 */
	public void setMuyvin(java.math.BigDecimal newMuyvin) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newMuyvin;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 180, _EJS_s, _jacc_parms);
			beanRef.setMuyvin(newMuyvin);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 180, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setNatdesvin
	 */
	public void setNatdesvin(java.math.BigDecimal newNatdesvin) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newNatdesvin;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 181, _EJS_s, _jacc_parms);
			beanRef.setNatdesvin(newNatdesvin);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 181, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setNatvin
	 */
	public void setNatvin(java.math.BigDecimal newNatvin) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newNatvin;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 182, _EJS_s, _jacc_parms);
			beanRef.setNatvin(newNatvin);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 182, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPasivo_t
	 */
	public void setPasivo_t(java.math.BigDecimal newPasivo_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPasivo_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 183, _EJS_s, _jacc_parms);
			beanRef.setPasivo_t(newPasivo_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 183, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPaut_t
	 */
	public void setPaut_t(java.math.BigDecimal newPaut_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPaut_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 184, _EJS_s, _jacc_parms);
			beanRef.setPaut_t(newPaut_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 184, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPcom_t
	 */
	public void setPcom_t(java.math.BigDecimal newPcom_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPcom_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 185, _EJS_s, _jacc_parms);
			beanRef.setPcom_t(newPcom_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 185, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPer_t
	 */
	public void setPer_t(java.math.BigDecimal newPer_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPer_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 186, _EJS_s, _jacc_parms);
			beanRef.setPer_t(newPer_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 186, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPh_t
	 */
	public void setPh_t(java.math.BigDecimal newPh_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPh_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 187, _EJS_s, _jacc_parms);
			beanRef.setPh_t(newPh_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 187, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPhip_t
	 */
	public void setPhip_t(java.math.BigDecimal newPhip_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPhip_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 188, _EJS_s, _jacc_parms);
			beanRef.setPhip_t(newPhip_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 188, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPlzo_t
	 */
	public void setPlzo_t(java.math.BigDecimal newPlzo_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPlzo_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 189, _EJS_s, _jacc_parms);
			beanRef.setPlzo_t(newPlzo_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 189, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPmas_t
	 */
	public void setPmas_t(java.math.BigDecimal newPmas_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPmas_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 190, _EJS_s, _jacc_parms);
			beanRef.setPmas_t(newPmas_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 190, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPmiv_t
	 */
	public void setPmiv_t(java.math.BigDecimal newPmiv_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPmiv_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 191, _EJS_s, _jacc_parms);
			beanRef.setPmiv_t(newPmiv_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 191, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPocovin
	 */
	public void setPocovin(java.math.BigDecimal newPocovin) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPocovin;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 192, _EJS_s, _jacc_parms);
			beanRef.setPocovin(newPocovin);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 192, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPos_t
	 */
	public void setPos_t(java.math.BigDecimal newPos_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPos_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 193, _EJS_s, _jacc_parms);
			beanRef.setPos_t(newPos_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 193, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPper_t
	 */
	public void setPper_t(java.math.BigDecimal newPper_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPper_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 194, _EJS_s, _jacc_parms);
			beanRef.setPper_t(newPper_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 194, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPpper_t
	 */
	public void setPpper_t(java.math.BigDecimal newPpper_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPpper_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 195, _EJS_s, _jacc_parms);
			beanRef.setPpper_t(newPpper_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 195, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPref_t
	 */
	public void setPref_t(java.math.BigDecimal newPref_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPref_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 196, _EJS_s, _jacc_parms);
			beanRef.setPref_t(newPref_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 196, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setProm_t
	 */
	public void setProm_t(java.math.BigDecimal newProm_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newProm_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 197, _EJS_s, _jacc_parms);
			beanRef.setProm_t(newProm_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 197, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPser_t
	 */
	public void setPser_t(java.math.BigDecimal newPser_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPser_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 198, _EJS_s, _jacc_parms);
			beanRef.setPser_t(newPser_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 198, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPserv_t
	 */
	public void setPserv_t(java.math.BigDecimal newPserv_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newPserv_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 199, _EJS_s, _jacc_parms);
			beanRef.setPserv_t(newPserv_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 199, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRiesgo_d_t
	 */
	public void setRiesgo_d_t(java.math.BigDecimal newRiesgo_d_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRiesgo_d_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 200, _EJS_s, _jacc_parms);
			beanRef.setRiesgo_d_t(newRiesgo_d_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 200, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRiesgo_i_t
	 */
	public void setRiesgo_i_t(java.math.BigDecimal newRiesgo_i_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRiesgo_i_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 201, _EJS_s, _jacc_parms);
			beanRef.setRiesgo_i_t(newRiesgo_i_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 201, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRiesgo_t
	 */
	public void setRiesgo_t(java.math.BigDecimal newRiesgo_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newRiesgo_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 202, _EJS_s, _jacc_parms);
			beanRef.setRiesgo_t(newRiesgo_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 202, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSdep_t
	 */
	public void setSdep_t(java.math.BigDecimal newSdep_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSdep_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 203, _EJS_s, _jacc_parms);
			beanRef.setSdep_t(newSdep_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 203, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_10100
	 */
	public void setSeg_10100(java.math.BigDecimal newSeg_10100) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_10100;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 204, _EJS_s, _jacc_parms);
			beanRef.setSeg_10100(newSeg_10100);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 204, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_10200
	 */
	public void setSeg_10200(java.math.BigDecimal newSeg_10200) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_10200;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 205, _EJS_s, _jacc_parms);
			beanRef.setSeg_10200(newSeg_10200);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 205, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_20100
	 */
	public void setSeg_20100(java.math.BigDecimal newSeg_20100) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_20100;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 206, _EJS_s, _jacc_parms);
			beanRef.setSeg_20100(newSeg_20100);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 206, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_20200
	 */
	public void setSeg_20200(java.math.BigDecimal newSeg_20200) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_20200;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 207, _EJS_s, _jacc_parms);
			beanRef.setSeg_20200(newSeg_20200);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 207, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_20300
	 */
	public void setSeg_20300(java.math.BigDecimal newSeg_20300) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_20300;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 208, _EJS_s, _jacc_parms);
			beanRef.setSeg_20300(newSeg_20300);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 208, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_20400
	 */
	public void setSeg_20400(java.math.BigDecimal newSeg_20400) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_20400;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 209, _EJS_s, _jacc_parms);
			beanRef.setSeg_20400(newSeg_20400);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 209, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_20500
	 */
	public void setSeg_20500(java.math.BigDecimal newSeg_20500) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_20500;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 210, _EJS_s, _jacc_parms);
			beanRef.setSeg_20500(newSeg_20500);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 210, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_20600
	 */
	public void setSeg_20600(java.math.BigDecimal newSeg_20600) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_20600;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 211, _EJS_s, _jacc_parms);
			beanRef.setSeg_20600(newSeg_20600);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 211, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_30100
	 */
	public void setSeg_30100(java.math.BigDecimal newSeg_30100) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_30100;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 212, _EJS_s, _jacc_parms);
			beanRef.setSeg_30100(newSeg_30100);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 212, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_30200
	 */
	public void setSeg_30200(java.math.BigDecimal newSeg_30200) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_30200;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 213, _EJS_s, _jacc_parms);
			beanRef.setSeg_30200(newSeg_30200);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 213, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_30300
	 */
	public void setSeg_30300(java.math.BigDecimal newSeg_30300) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_30300;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 214, _EJS_s, _jacc_parms);
			beanRef.setSeg_30300(newSeg_30300);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 214, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_30400
	 */
	public void setSeg_30400(java.math.BigDecimal newSeg_30400) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_30400;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 215, _EJS_s, _jacc_parms);
			beanRef.setSeg_30400(newSeg_30400);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 215, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_40100
	 */
	public void setSeg_40100(java.math.BigDecimal newSeg_40100) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_40100;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 216, _EJS_s, _jacc_parms);
			beanRef.setSeg_40100(newSeg_40100);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 216, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_40200
	 */
	public void setSeg_40200(java.math.BigDecimal newSeg_40200) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_40200;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 217, _EJS_s, _jacc_parms);
			beanRef.setSeg_40200(newSeg_40200);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 217, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_40300
	 */
	public void setSeg_40300(java.math.BigDecimal newSeg_40300) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_40300;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 218, _EJS_s, _jacc_parms);
			beanRef.setSeg_40300(newSeg_40300);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 218, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_40400
	 */
	public void setSeg_40400(java.math.BigDecimal newSeg_40400) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_40400;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 219, _EJS_s, _jacc_parms);
			beanRef.setSeg_40400(newSeg_40400);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 219, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_50100
	 */
	public void setSeg_50100(java.math.BigDecimal newSeg_50100) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_50100;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 220, _EJS_s, _jacc_parms);
			beanRef.setSeg_50100(newSeg_50100);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 220, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_50200
	 */
	public void setSeg_50200(java.math.BigDecimal newSeg_50200) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_50200;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 221, _EJS_s, _jacc_parms);
			beanRef.setSeg_50200(newSeg_50200);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 221, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_50300
	 */
	public void setSeg_50300(java.math.BigDecimal newSeg_50300) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_50300;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 222, _EJS_s, _jacc_parms);
			beanRef.setSeg_50300(newSeg_50300);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 222, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_50400
	 */
	public void setSeg_50400(java.math.BigDecimal newSeg_50400) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_50400;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 223, _EJS_s, _jacc_parms);
			beanRef.setSeg_50400(newSeg_50400);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 223, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_60100
	 */
	public void setSeg_60100(java.math.BigDecimal newSeg_60100) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_60100;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 224, _EJS_s, _jacc_parms);
			beanRef.setSeg_60100(newSeg_60100);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 224, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_60200
	 */
	public void setSeg_60200(java.math.BigDecimal newSeg_60200) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_60200;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 225, _EJS_s, _jacc_parms);
			beanRef.setSeg_60200(newSeg_60200);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 225, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_60300
	 */
	public void setSeg_60300(java.math.BigDecimal newSeg_60300) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_60300;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 226, _EJS_s, _jacc_parms);
			beanRef.setSeg_60300(newSeg_60300);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 226, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_60400
	 */
	public void setSeg_60400(java.math.BigDecimal newSeg_60400) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_60400;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 227, _EJS_s, _jacc_parms);
			beanRef.setSeg_60400(newSeg_60400);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 227, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_80100
	 */
	public void setSeg_80100(java.math.BigDecimal newSeg_80100) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_80100;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 228, _EJS_s, _jacc_parms);
			beanRef.setSeg_80100(newSeg_80100);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 228, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_80200
	 */
	public void setSeg_80200(java.math.BigDecimal newSeg_80200) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_80200;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 229, _EJS_s, _jacc_parms);
			beanRef.setSeg_80200(newSeg_80200);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 229, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_80300
	 */
	public void setSeg_80300(java.math.BigDecimal newSeg_80300) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_80300;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 230, _EJS_s, _jacc_parms);
			beanRef.setSeg_80300(newSeg_80300);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 230, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_80400
	 */
	public void setSeg_80400(java.math.BigDecimal newSeg_80400) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_80400;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 231, _EJS_s, _jacc_parms);
			beanRef.setSeg_80400(newSeg_80400);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 231, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_80500
	 */
	public void setSeg_80500(java.math.BigDecimal newSeg_80500) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_80500;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 232, _EJS_s, _jacc_parms);
			beanRef.setSeg_80500(newSeg_80500);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 232, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_80600
	 */
	public void setSeg_80600(java.math.BigDecimal newSeg_80600) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_80600;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 233, _EJS_s, _jacc_parms);
			beanRef.setSeg_80600(newSeg_80600);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 233, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_80700
	 */
	public void setSeg_80700(java.math.BigDecimal newSeg_80700) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_80700;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 234, _EJS_s, _jacc_parms);
			beanRef.setSeg_80700(newSeg_80700);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 234, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_90200
	 */
	public void setSeg_90200(java.math.BigDecimal newSeg_90200) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_90200;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 235, _EJS_s, _jacc_parms);
			beanRef.setSeg_90200(newSeg_90200);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 235, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSeg_99900
	 */
	public void setSeg_99900(java.math.BigDecimal newSeg_99900) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSeg_99900;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 236, _EJS_s, _jacc_parms);
			beanRef.setSeg_99900(newSeg_99900);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 236, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSext_t
	 */
	public void setSext_t(java.math.BigDecimal newSext_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSext_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 237, _EJS_s, _jacc_parms);
			beanRef.setSext_t(newSext_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 237, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSonc_t
	 */
	public void setSonc_t(java.math.BigDecimal newSonc_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSonc_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 238, _EJS_s, _jacc_parms);
			beanRef.setSonc_t(newSonc_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 238, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSpro_t
	 */
	public void setSpro_t(java.math.BigDecimal newSpro_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSpro_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 239, _EJS_s, _jacc_parms);
			beanRef.setSpro_t(newSpro_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 239, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_act_ct1
	 */
	public void setSum_act_ct1(java.math.BigDecimal newSum_act_ct1) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_act_ct1;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 240, _EJS_s, _jacc_parms);
			beanRef.setSum_act_ct1(newSum_act_ct1);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 240, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_act_ct2
	 */
	public void setSum_act_ct2(java.math.BigDecimal newSum_act_ct2) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_act_ct2;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 241, _EJS_s, _jacc_parms);
			beanRef.setSum_act_ct2(newSum_act_ct2);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 241, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_act_ct3
	 */
	public void setSum_act_ct3(java.math.BigDecimal newSum_act_ct3) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_act_ct3;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 242, _EJS_s, _jacc_parms);
			beanRef.setSum_act_ct3(newSum_act_ct3);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 242, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_act_ct4
	 */
	public void setSum_act_ct4(java.math.BigDecimal newSum_act_ct4) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_act_ct4;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 243, _EJS_s, _jacc_parms);
			beanRef.setSum_act_ct4(newSum_act_ct4);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 243, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_act_ct5
	 */
	public void setSum_act_ct5(java.math.BigDecimal newSum_act_ct5) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_act_ct5;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 244, _EJS_s, _jacc_parms);
			beanRef.setSum_act_ct5(newSum_act_ct5);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 244, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_act_ct6
	 */
	public void setSum_act_ct6(java.math.BigDecimal newSum_act_ct6) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_act_ct6;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 245, _EJS_s, _jacc_parms);
			beanRef.setSum_act_ct6(newSum_act_ct6);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 245, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_act_cto
	 */
	public void setSum_act_cto(java.math.BigDecimal newSum_act_cto) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_act_cto;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 246, _EJS_s, _jacc_parms);
			beanRef.setSum_act_cto(newSum_act_cto);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 246, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_t_act
	 */
	public void setSum_t_act(java.math.BigDecimal newSum_t_act) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_t_act;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 247, _EJS_s, _jacc_parms);
			beanRef.setSum_t_act(newSum_t_act);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 247, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_t_act1
	 */
	public void setSum_t_act1(java.math.BigDecimal newSum_t_act1) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_t_act1;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 248, _EJS_s, _jacc_parms);
			beanRef.setSum_t_act1(newSum_t_act1);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 248, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_t_act2
	 */
	public void setSum_t_act2(java.math.BigDecimal newSum_t_act2) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_t_act2;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 249, _EJS_s, _jacc_parms);
			beanRef.setSum_t_act2(newSum_t_act2);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 249, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_t_act3
	 */
	public void setSum_t_act3(java.math.BigDecimal newSum_t_act3) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_t_act3;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 250, _EJS_s, _jacc_parms);
			beanRef.setSum_t_act3(newSum_t_act3);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 250, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_t_act4
	 */
	public void setSum_t_act4(java.math.BigDecimal newSum_t_act4) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_t_act4;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 251, _EJS_s, _jacc_parms);
			beanRef.setSum_t_act4(newSum_t_act4);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 251, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_t_act5
	 */
	public void setSum_t_act5(java.math.BigDecimal newSum_t_act5) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_t_act5;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 252, _EJS_s, _jacc_parms);
			beanRef.setSum_t_act5(newSum_t_act5);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 252, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSum_t_act6
	 */
	public void setSum_t_act6(java.math.BigDecimal newSum_t_act6) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSum_t_act6;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 253, _EJS_s, _jacc_parms);
			beanRef.setSum_t_act6(newSum_t_act6);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 253, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSvid_t
	 */
	public void setSvid_t(java.math.BigDecimal newSvid_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSvid_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 254, _EJS_s, _jacc_parms);
			beanRef.setSvid_t(newSvid_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 254, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSvip_t
	 */
	public void setSvip_t(java.math.BigDecimal newSvip_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newSvip_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 255, _EJS_s, _jacc_parms);
			beanRef.setSvip_t(newSvip_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 255, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTde_t
	 */
	public void setTde_t(java.math.BigDecimal newTde_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newTde_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 256, _EJS_s, _jacc_parms);
			beanRef.setTde_t(newTde_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 256, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTdeb_t
	 */
	public void setTdeb_t(java.math.BigDecimal newTdeb_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newTdeb_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 257, _EJS_s, _jacc_parms);
			beanRef.setTdeb_t(newTdeb_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 257, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTvip_t
	 */
	public void setTvip_t(java.math.BigDecimal newTvip_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newTvip_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 258, _EJS_s, _jacc_parms);
			beanRef.setTvip_t(newTvip_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 258, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVarc_t
	 */
	public void setVarc_t(java.math.BigDecimal newVarc_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVarc_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 259, _EJS_s, _jacc_parms);
			beanRef.setVarc_t(newVarc_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 259, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVcla_t
	 */
	public void setVcla_t(java.math.BigDecimal newVcla_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVcla_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 260, _EJS_s, _jacc_parms);
			beanRef.setVcla_t(newVcla_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 260, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVctr_t
	 */
	public void setVctr_t(java.math.BigDecimal newVctr_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVctr_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 261, _EJS_s, _jacc_parms);
			beanRef.setVctr_t(newVctr_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 261, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVemp_t
	 */
	public void setVemp_t(java.math.BigDecimal newVemp_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVemp_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 262, _EJS_s, _jacc_parms);
			beanRef.setVemp_t(newVemp_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 262, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVid_t
	 */
	public void setVid_t(java.math.BigDecimal newVid_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVid_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 263, _EJS_s, _jacc_parms);
			beanRef.setVid_t(newVid_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 263, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVin
	 */
	public void setVin(java.math.BigDecimal newVin) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVin;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 264, _EJS_s, _jacc_parms);
			beanRef.setVin(newVin);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 264, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVip_t
	 */
	public void setVip_t(java.math.BigDecimal newVip_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVip_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 265, _EJS_s, _jacc_parms);
			beanRef.setVip_t(newVip_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 265, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVnac_t
	 */
	public void setVnac_t(java.math.BigDecimal newVnac_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVnac_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 266, _EJS_s, _jacc_parms);
			beanRef.setVnac_t(newVnac_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 266, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVolumen_t
	 */
	public void setVolumen_t(java.math.BigDecimal newVolumen_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVolumen_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 267, _EJS_s, _jacc_parms);
			beanRef.setVolumen_t(newVolumen_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 267, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVoro_t
	 */
	public void setVoro_t(java.math.BigDecimal newVoro_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVoro_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 268, _EJS_s, _jacc_parms);
			beanRef.setVoro_t(newVoro_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 268, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVpla_t
	 */
	public void setVpla_t(java.math.BigDecimal newVpla_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVpla_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 269, _EJS_s, _jacc_parms);
			beanRef.setVpla_t(newVpla_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 269, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVpola_t
	 */
	public void setVpola_t(java.math.BigDecimal newVpola_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVpola_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 270, _EJS_s, _jacc_parms);
			beanRef.setVpola_t(newVpola_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 270, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVrep_t
	 */
	public void setVrep_t(java.math.BigDecimal newVrep_t) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = newVrep_t;
			}
	com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean beanRef = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean)container.preInvoke(this, 271, _EJS_s, _jacc_parms);
			beanRef.setVrep_t(newVrep_t);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 271, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
