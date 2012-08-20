package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiilc_gestorHome_e8600cef
 */
public class EJSLocalCMPTiilc_gestorHome_e8600cef extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocalHome, com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_gestorBeanInternalLocalHome_e8600cef {
	/**
	 * EJSLocalCMPTiilc_gestorHome_e8600cef
	 */
	public EJSLocalCMPTiilc_gestorHome_e8600cef() {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal create(java.lang.String cod_gestor, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal argTiilc_oficina_fk) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_gestor;
				_jacc_parms[1] = argTiilc_oficina_fk;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_gestor, argTiilc_oficina_fk);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal create(java.lang.String cod_gestor, java.lang.String tiilc_oficina_fk_cod_oficina, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = cod_gestor;
				_jacc_parms[1] = tiilc_oficina_fk_cod_oficina;
				_jacc_parms[2] = tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio;
				_jacc_parms[3] = tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal create(java.lang.String cod_gestor, java.lang.String tiilc_oficina_fk_cod_oficina, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area, java.lang.String nom_gestor, java.lang.String reg_gestor, java.lang.String perfil_gestor) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = cod_gestor;
				_jacc_parms[1] = tiilc_oficina_fk_cod_oficina;
				_jacc_parms[2] = tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio;
				_jacc_parms[3] = tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area;
				_jacc_parms[4] = nom_gestor;
				_jacc_parms[5] = reg_gestor;
				_jacc_parms[6] = perfil_gestor;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area, nom_gestor, reg_gestor, perfil_gestor);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByPrimaryKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal findByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByPrimaryKey_Local(primaryKey);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findGestorxRegGestor
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal findGestorxRegGestor(java.lang.String reg_gestor) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = reg_gestor;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findGestorxRegGestor_Local(reg_gestor);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findAllGestor
	 */
	public java.util.Collection findAllGestor(java.lang.String cod_area) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllGestor_Local(cod_area);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findAllGestorxOfxTexAr
	 */
	public java.util.Collection findAllGestorxOfxTexAr(java.lang.String cod_oficina, java.lang.String cod_territorio, java.lang.String cod_area) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = cod_oficina;
				_jacc_parms[1] = cod_territorio;
				_jacc_parms[2] = cod_area;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllGestorxOfxTexAr_Local(cod_oficina, cod_territorio, cod_area);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = arg0;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_beanRef.remove(arg0);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.EJBException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
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
		return ;
	}
	/**
	 * findTiilc_gestorByTiilc_oficina_fkKey_Local
	 */
	public java.util.Collection findTiilc_gestorByTiilc_oficina_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_gestorHomeBean_e8600cef)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiilc_gestorByTiilc_oficina_fkKey_Local(key);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, -2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
