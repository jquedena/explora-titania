package entities;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiido_oficinaHome_30d934a8
 */
public class EJSLocalCMPTiido_oficinaHome_30d934a8 extends EJSLocalWrapper implements entities.Tiido_oficinaLocalHome, entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8 {
	/**
	 * EJSLocalCMPTiido_oficinaHome_30d934a8
	 */
	public EJSLocalCMPTiido_oficinaHome_30d934a8() {
		super();	}
	/**
	 * create
	 */
	public entities.Tiido_oficinaLocal create(java.lang.String cod_ofic, entities.Tiido_territorioLocal argTiido_territorio_fk) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_ofic;
				_jacc_parms[1] = argTiido_territorio_fk;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_ofic, argTiido_territorio_fk);
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
	public entities.Tiido_oficinaLocal create(java.lang.String cod_ofic, java.lang.String tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_ofic;
				_jacc_parms[1] = tiido_territorio_fk_cod_terr;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_ofic, tiido_territorio_fk_cod_terr);
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
	public entities.Tiido_oficinaLocal create(java.lang.String cod_ofic, java.lang.String nom_ofic, java.lang.String tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = cod_ofic;
				_jacc_parms[1] = nom_ofic;
				_jacc_parms[2] = tiido_territorio_fk_cod_terr;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_ofic, nom_ofic, tiido_territorio_fk_cod_terr);
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
	 * findByCodOficina
	 */
	public entities.Tiido_oficinaLocal findByCodOficina(java.lang.String codOficina) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByCodOficina_Local(codOficina);
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
	 * findByPrimaryKey
	 */
	public entities.Tiido_oficinaLocal findByPrimaryKey(entities.Tiido_oficinaKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
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
	 * findAllOficinaByCodTerri
	 */
	public java.util.Collection findAllOficinaByCodTerri(java.lang.String codTerritorio) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findAllOficinaByCodTerri_Local(codTerritorio);
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
	 * findListaByCodOficina
	 */
	public java.util.Collection findListaByCodOficina(java.lang.String codOficina) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findListaByCodOficina_Local(codOficina);
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
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
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
	 * findTiido_oficinaByTiido_territorio_fkKey_Local
	 */
	public java.util.Collection findTiido_oficinaByTiido_territorio_fkKey_Local(entities.Tiido_territorioKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_oficinaByTiido_territorio_fkKey_Local(key);
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
	/**
	 * findTiido_acc_oficina_fkByTiido_accionesKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_acc_oficina_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_acc_oficina_fkByTiido_accionesKey_Local(key);
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
	/**
	 * findTiido_cam_oficina_fkByTiido_campaniasKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_cam_oficina_fkByTiido_campaniasKey_Local(entities.Tiido_campaniasKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_cam_oficina_fkByTiido_campaniasKey_Local(key);
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
	/**
	 * findTiido_fir_oficina_fkByTiido_firmasKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_fir_oficina_fkByTiido_firmasKey_Local(entities.Tiido_firmasKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_fir_oficina_fkByTiido_firmasKey_Local(key);
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
	/**
	 * findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local(entities.Tiido_maestro_planesKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local(key);
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
	/**
	 * findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local(key);
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
	/**
	 * findTiido_pla_oficina_fkByTiido_planesKey_Local
	 */
	public entities.Tiido_oficinaLocal findTiido_pla_oficina_fkByTiido_planesKey_Local(entities.Tiido_planesKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_pla_oficina_fkByTiido_planesKey_Local(key);
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
	/**
	 * findByPrimaryKeyForCMR
	 */
	public entities.Tiido_oficinaLocal findByPrimaryKeyForCMR(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_oficinaLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_oficinaHomeBean_30d934a8 _EJS_beanRef = (entities.EJSCMPTiido_oficinaHomeBean_30d934a8)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findByPrimaryKeyForCMR_Local(key);
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
