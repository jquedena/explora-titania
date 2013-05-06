package entities;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiido_firmasHome_7cbca68a
 */
public class EJSLocalCMPTiido_firmasHome_7cbca68a extends EJSLocalWrapper implements entities.Tiido_firmasLocalHome, entities.websphere_deploy.Tiido_firmasBeanInternalLocalHome_7cbca68a {
	/**
	 * EJSLocalCMPTiido_firmasHome_7cbca68a
	 */
	public EJSLocalCMPTiido_firmasHome_7cbca68a() {
		super();	}
	/**
	 * create
	 */
	public entities.Tiido_firmasLocal create(java.lang.String cod_firma, entities.Tiido_oficinaLocal argTiido_fir_oficina_fk) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_firmasLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_firma;
				_jacc_parms[1] = argTiido_fir_oficina_fk;
			}
	entities.EJSCMPTiido_firmasHomeBean_7cbca68a _EJS_beanRef = (entities.EJSCMPTiido_firmasHomeBean_7cbca68a)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_firma, argTiido_fir_oficina_fk);
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
	public entities.Tiido_firmasLocal create(java.lang.String cod_firma, java.lang.String tiido_fir_oficina_fk_cod_ofic, java.lang.String tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_firmasLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = cod_firma;
				_jacc_parms[1] = tiido_fir_oficina_fk_cod_ofic;
				_jacc_parms[2] = tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr;
			}
	entities.EJSCMPTiido_firmasHomeBean_7cbca68a _EJS_beanRef = (entities.EJSCMPTiido_firmasHomeBean_7cbca68a)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_firma, tiido_fir_oficina_fk_cod_ofic, tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
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
	 * findByPrimaryKey
	 */
	public entities.Tiido_firmasLocal findByPrimaryKey(entities.Tiido_firmasKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_firmasLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_firmasHomeBean_7cbca68a _EJS_beanRef = (entities.EJSCMPTiido_firmasHomeBean_7cbca68a)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
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
	 * findFirmByAnoMesCgesItem
	 */
	public entities.Tiido_firmasLocal findFirmByAnoMesCgesItem(java.lang.String anho, java.lang.String mes, java.lang.String codGestor, java.lang.String item) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_firmasLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codGestor;
				_jacc_parms[3] = item;
			}
	entities.EJSCMPTiido_firmasHomeBean_7cbca68a _EJS_beanRef = (entities.EJSCMPTiido_firmasHomeBean_7cbca68a)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findFirmByAnoMesCgesItem_Local(anho, mes, codGestor, item);
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
	entities.EJSCMPTiido_firmasHomeBean_7cbca68a _EJS_beanRef = (entities.EJSCMPTiido_firmasHomeBean_7cbca68a)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
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
	 * findTiido_firmasByTiido_fir_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_firmasByTiido_fir_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_firmasHomeBean_7cbca68a _EJS_beanRef = (entities.EJSCMPTiido_firmasHomeBean_7cbca68a)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_firmasByTiido_fir_oficina_fkKey_Local(key);
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
