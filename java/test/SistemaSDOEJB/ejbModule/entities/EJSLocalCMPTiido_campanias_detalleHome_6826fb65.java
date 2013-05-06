package entities;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiido_campanias_detalleHome_6826fb65
 */
public class EJSLocalCMPTiido_campanias_detalleHome_6826fb65 extends EJSLocalWrapper implements entities.Tiido_campanias_detalleLocalHome, entities.websphere_deploy.Tiido_campanias_detalleBeanInternalLocalHome_6826fb65 {
	/**
	 * EJSLocalCMPTiido_campanias_detalleHome_6826fb65
	 */
	public EJSLocalCMPTiido_campanias_detalleHome_6826fb65() {
		super();	}
	/**
	 * create
	 */
	public entities.Tiido_campanias_detalleLocal create(java.lang.Integer cod_camp_deta, entities.Tiido_campaniasLocal argTiido_camdet_campanias_fk) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_campanias_detalleLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = cod_camp_deta;
				_jacc_parms[1] = argTiido_camdet_campanias_fk;
			}
	entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65 _EJS_beanRef = (entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_camp_deta, argTiido_camdet_campanias_fk);
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
	public entities.Tiido_campanias_detalleLocal create(java.lang.Integer cod_camp_deta, java.lang.Integer tiido_camdet_campanias_fk_cod_camp, java.lang.String tiido_camdet_campanias_fk_anho, java.lang.String tiido_camdet_campanias_fk_mes, java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic, java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_campanias_detalleLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = cod_camp_deta;
				_jacc_parms[1] = tiido_camdet_campanias_fk_cod_camp;
				_jacc_parms[2] = tiido_camdet_campanias_fk_anho;
				_jacc_parms[3] = tiido_camdet_campanias_fk_mes;
				_jacc_parms[4] = tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic;
				_jacc_parms[5] = tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr;
			}
	entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65 _EJS_beanRef = (entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_camp_deta, tiido_camdet_campanias_fk_cod_camp, tiido_camdet_campanias_fk_anho, tiido_camdet_campanias_fk_mes, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
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
	public entities.Tiido_campanias_detalleLocal findByPrimaryKey(entities.Tiido_campanias_detalleKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_campanias_detalleLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65 _EJS_beanRef = (entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
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
	entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65 _EJS_beanRef = (entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
	 * findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local
	 */
	public java.util.Collection findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local(entities.Tiido_campaniasKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65 _EJS_beanRef = (entities.EJSCMPTiido_campanias_detalleHomeBean_6826fb65)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local(key);
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
