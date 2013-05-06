package entities;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiido_maestro_planesHome_83d95438
 */
public class EJSLocalCMPTiido_maestro_planesHome_83d95438 extends EJSLocalWrapper implements entities.Tiido_maestro_planesLocalHome, entities.websphere_deploy.Tiido_maestro_planesBeanInternalLocalHome_83d95438 {
	/**
	 * EJSLocalCMPTiido_maestro_planesHome_83d95438
	 */
	public EJSLocalCMPTiido_maestro_planesHome_83d95438() {
		super();	}
	/**
	 * create
	 */
	public entities.Tiido_maestro_planesLocal create(java.lang.String mes, java.lang.String anho, entities.Tiido_oficinaLocal argTiido_maepla_oficina_fk) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_maestro_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = argTiido_maepla_oficina_fk;
			}
	entities.EJSCMPTiido_maestro_planesHomeBean_83d95438 _EJS_beanRef = (entities.EJSCMPTiido_maestro_planesHomeBean_83d95438)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(mes, anho, argTiido_maepla_oficina_fk);
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
	public entities.Tiido_maestro_planesLocal create(java.lang.String mes, java.lang.String anho, java.lang.String tiido_maepla_oficina_fk_cod_ofic, java.lang.String tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_maestro_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = tiido_maepla_oficina_fk_cod_ofic;
				_jacc_parms[3] = tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr;
			}
	entities.EJSCMPTiido_maestro_planesHomeBean_83d95438 _EJS_beanRef = (entities.EJSCMPTiido_maestro_planesHomeBean_83d95438)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(mes, anho, tiido_maepla_oficina_fk_cod_ofic, tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
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
	public entities.Tiido_maestro_planesLocal findByPrimaryKey(entities.Tiido_maestro_planesKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_maestro_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_maestro_planesHomeBean_83d95438 _EJS_beanRef = (entities.EJSCMPTiido_maestro_planesHomeBean_83d95438)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
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
	 * findUbicar
	 */
	public entities.Tiido_maestro_planesLocal findUbicar(java.lang.String mes, java.lang.String anho, java.lang.String codOficina) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_maestro_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
			}
	entities.EJSCMPTiido_maestro_planesHomeBean_83d95438 _EJS_beanRef = (entities.EJSCMPTiido_maestro_planesHomeBean_83d95438)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findUbicar_Local(mes, anho, codOficina);
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
	entities.EJSCMPTiido_maestro_planesHomeBean_83d95438 _EJS_beanRef = (entities.EJSCMPTiido_maestro_planesHomeBean_83d95438)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
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
	 * findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_maestro_planesHomeBean_83d95438 _EJS_beanRef = (entities.EJSCMPTiido_maestro_planesHomeBean_83d95438)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local(key);
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
