package entities;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiido_planesHome_f95fafaa
 */
public class EJSLocalCMPTiido_planesHome_f95fafaa extends EJSLocalWrapper implements entities.Tiido_planesLocalHome, entities.websphere_deploy.Tiido_planesBeanInternalLocalHome_f95fafaa {
	/**
	 * EJSLocalCMPTiido_planesHome_f95fafaa
	 */
	public EJSLocalCMPTiido_planesHome_f95fafaa() {
		super();	}
	/**
	 * create
	 */
	public entities.Tiido_planesLocal create(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = plan;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(plan);
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
	public entities.Tiido_planesLocal create(java.lang.String mes_plan, java.lang.String anho_plan, java.lang.String cod_epigrafe, entities.Tiido_oficinaLocal argTiido_pla_oficina_fk) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes_plan;
				_jacc_parms[1] = anho_plan;
				_jacc_parms[2] = cod_epigrafe;
				_jacc_parms[3] = argTiido_pla_oficina_fk;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(mes_plan, anho_plan, cod_epigrafe, argTiido_pla_oficina_fk);
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
	public entities.Tiido_planesLocal create(java.lang.String mes_plan, java.lang.String anho_plan, java.lang.String cod_epigrafe, java.lang.String tiido_pla_oficina_fk_cod_ofic, java.lang.String tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = mes_plan;
				_jacc_parms[1] = anho_plan;
				_jacc_parms[2] = cod_epigrafe;
				_jacc_parms[3] = tiido_pla_oficina_fk_cod_ofic;
				_jacc_parms[4] = tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(mes_plan, anho_plan, cod_epigrafe, tiido_pla_oficina_fk_cod_ofic, tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
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
	public entities.Tiido_planesLocal findByPrimaryKey(entities.Tiido_planesKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
	 * findConsultaPlanesPrioridad
	 */
	public entities.Tiido_planesLocal findConsultaPlanesPrioridad(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codEpigrafe;
				_jacc_parms[3] = codOficina;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findConsultaPlanesPrioridad_Local(mes, anho, codEpigrafe, codOficina);
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
	 * findConsultaPlanesResumen
	 */
	public entities.Tiido_planesLocal findConsultaPlanesResumen(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codEpigrafe;
				_jacc_parms[3] = codOficina;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findConsultaPlanesResumen_Local(mes, anho, codEpigrafe, codOficina);
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
	 * findPlanByObject
	 */
	public entities.Tiido_planesLocal findPlanByObject(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		entities.Tiido_planesLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codEpigrafe;
				_jacc_parms[3] = codOficina;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findPlanByObject_Local(mes, anho, codEpigrafe, codOficina);
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
	 * findConsultaPlanes
	 */
	public java.util.Collection findConsultaPlanes(java.lang.String codOficina, java.lang.String anho, java.lang.String mes) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = mes;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findConsultaPlanes_Local(codOficina, anho, mes);
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
	 * findConsultarPlanesxMes
	 */
	public java.util.Collection findConsultarPlanesxMes(java.lang.String codOficina, java.lang.String anho) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = anho;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findConsultarPlanesxMes_Local(codOficina, anho);
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
	 * remove
	 */
	public void remove(java.lang.Object primaryKey) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_beanRef.remove(primaryKey);
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
				container.postInvoke(this, 9, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * findTiido_planesByTiido_pla_oficina_fkKey_Local
	 */
	public java.util.Collection findTiido_planesByTiido_pla_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Collection _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = key;
			}
	entities.EJSCMPTiido_planesHomeBean_f95fafaa _EJS_beanRef = (entities.EJSCMPTiido_planesHomeBean_f95fafaa)container.preInvoke(this, -2, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.findTiido_planesByTiido_pla_oficina_fkKey_Local(key);
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
