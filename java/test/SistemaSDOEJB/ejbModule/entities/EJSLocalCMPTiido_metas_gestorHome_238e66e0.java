package entities;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiido_metas_gestorHome_238e66e0
 */
public class EJSLocalCMPTiido_metas_gestorHome_238e66e0 extends EJSLocalWrapper implements entities.Tiido_metas_gestorLocalHome, entities.websphere_deploy.Tiido_metas_gestorBeanInternalLocalHome_238e66e0 {
	/**
	 * EJSLocalCMPTiido_metas_gestorHome_238e66e0
	 */
	public EJSLocalCMPTiido_metas_gestorHome_238e66e0() {
		super();	}
	/**
	 * create
	 */
	public entities.Tiido_metas_gestorLocal create(com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor metasGestor, entities.Tiido_epigrafeLocal epigrafeLocal, entities.Tiido_oficinaLocal oficinaLocal) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_metas_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = metasGestor;
				_jacc_parms[1] = epigrafeLocal;
				_jacc_parms[2] = oficinaLocal;
			}
	entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0 _EJS_beanRef = (entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(metasGestor, epigrafeLocal, oficinaLocal);
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
	public entities.Tiido_metas_gestorLocal create(java.lang.String cod_meta_gestor, entities.Tiido_epigrafeLocal argTiido_metges_epigrafe_fk, entities.Tiido_oficinaLocal argTiido_metges_oficina_fk) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_metas_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = cod_meta_gestor;
				_jacc_parms[1] = argTiido_metges_epigrafe_fk;
				_jacc_parms[2] = argTiido_metges_oficina_fk;
			}
	entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0 _EJS_beanRef = (entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_meta_gestor, argTiido_metges_epigrafe_fk, argTiido_metges_oficina_fk);
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
	public entities.Tiido_metas_gestorLocal create(java.lang.String cod_meta_gestor, java.lang.String tiido_metges_epigrafe_fk_cod_epigrafe, java.lang.String tiido_metges_epigrafe_fk_anho, java.lang.String tiido_metges_oficina_fk_cod_ofic, java.lang.String tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_metas_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = cod_meta_gestor;
				_jacc_parms[1] = tiido_metges_epigrafe_fk_cod_epigrafe;
				_jacc_parms[2] = tiido_metges_epigrafe_fk_anho;
				_jacc_parms[3] = tiido_metges_oficina_fk_cod_ofic;
				_jacc_parms[4] = tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr;
			}
	entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0 _EJS_beanRef = (entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_meta_gestor, tiido_metges_epigrafe_fk_cod_epigrafe, tiido_metges_epigrafe_fk_anho, tiido_metges_oficina_fk_cod_ofic, tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
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
	public entities.Tiido_metas_gestorLocal findByPrimaryKey(entities.Tiido_metas_gestorKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_metas_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0 _EJS_beanRef = (entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
	 * findGestorByCodigo
	 */
	public entities.Tiido_metas_gestorLocal findGestorByCodigo(java.lang.String codGestor) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_metas_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codGestor;
			}
	entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0 _EJS_beanRef = (entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findGestorByCodigo_Local(codGestor);
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
	 * findMetGestorByPrimaryKey
	 */
	public entities.Tiido_metas_gestorLocal findMetGestorByPrimaryKey(java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String codGestor) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_metas_gestorLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codEpigrafe;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = codGestor;
			}
	entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0 _EJS_beanRef = (entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findMetGestorByPrimaryKey_Local(codEpigrafe, anho, codOficina, mes, codGestor);
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
	entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0 _EJS_beanRef = (entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 6, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local
	 */
	public java.util.Collection findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(entities.Tiido_epigrafeKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0 _EJS_beanRef = (entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(key);
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
	 * findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0 _EJS_beanRef = (entities.EJSCMPTiido_metas_gestorHomeBean_238e66e0)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(key);
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
