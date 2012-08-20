package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTiilc_clienteHome_f5b4eb46
 */
public class EJSLocalCMPTiilc_clienteHome_f5b4eb46 extends EJSLocalWrapper implements com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocalHome, com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_clienteBeanInternalLocalHome_f5b4eb46 {
	/**
	 * EJSLocalCMPTiilc_clienteHome_f5b4eb46
	 */
	public EJSLocalCMPTiilc_clienteHome_f5b4eb46() {
		super();	}
	/**
	 * create
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal create(java.math.BigDecimal cod_cliente) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_cliente;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_clienteHomeBean_f5b4eb46 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_clienteHomeBean_f5b4eb46)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_cliente);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal create(java.math.BigDecimal cod_cliente, java.lang.String cod_oficina, java.lang.String cod_gestor, java.lang.String cod_territorio, java.math.BigDecimal mofactv, java.math.BigDecimal cs000lineamaxtc, java.math.BigDecimal cs000mtoprestamo, java.math.BigDecimal montovehicular, java.math.BigDecimal montohipotecario, java.math.BigDecimal tconsactv, java.math.BigDecimal montosubrogados, java.math.BigDecimal tsubactv, java.math.BigDecimal thipotactv, java.math.BigDecimal tvehicactv, java.lang.String cs000montocta36, java.math.BigDecimal tcuot36act, java.math.BigDecimal cs000montocta48, java.math.BigDecimal tcuot48act, java.math.BigDecimal cs000montocta60, java.math.BigDecimal tcuot60act, java.math.BigDecimal css000presmena5000, java.math.BigDecimal cs000comisdesemen5000, java.math.BigDecimal cs000pres5000a15000, java.math.BigDecimal c5000comdes15000act, java.math.BigDecimal cs000presmaya15000, java.math.BigDecimal comdes15000ac, java.math.BigDecimal cs000linminadqtc, java.math.BigDecimal cs000mixmonprest, java.math.BigDecimal cs000mixlinasistc, java.math.BigDecimal cs000prestcmena5000, java.math.BigDecimal cs000prestc500015000, java.math.BigDecimal cs000prestcmaya15000) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[32];
				_jacc_parms[0] = cod_cliente;
				_jacc_parms[1] = cod_oficina;
				_jacc_parms[2] = cod_gestor;
				_jacc_parms[3] = cod_territorio;
				_jacc_parms[4] = mofactv;
				_jacc_parms[5] = cs000lineamaxtc;
				_jacc_parms[6] = cs000mtoprestamo;
				_jacc_parms[7] = montovehicular;
				_jacc_parms[8] = montohipotecario;
				_jacc_parms[9] = tconsactv;
				_jacc_parms[10] = montosubrogados;
				_jacc_parms[11] = tsubactv;
				_jacc_parms[12] = thipotactv;
				_jacc_parms[13] = tvehicactv;
				_jacc_parms[14] = cs000montocta36;
				_jacc_parms[15] = tcuot36act;
				_jacc_parms[16] = cs000montocta48;
				_jacc_parms[17] = tcuot48act;
				_jacc_parms[18] = cs000montocta60;
				_jacc_parms[19] = tcuot60act;
				_jacc_parms[20] = css000presmena5000;
				_jacc_parms[21] = cs000comisdesemen5000;
				_jacc_parms[22] = cs000pres5000a15000;
				_jacc_parms[23] = c5000comdes15000act;
				_jacc_parms[24] = cs000presmaya15000;
				_jacc_parms[25] = comdes15000ac;
				_jacc_parms[26] = cs000linminadqtc;
				_jacc_parms[27] = cs000mixmonprest;
				_jacc_parms[28] = cs000mixlinasistc;
				_jacc_parms[29] = cs000prestcmena5000;
				_jacc_parms[30] = cs000prestc500015000;
				_jacc_parms[31] = cs000prestcmaya15000;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_clienteHomeBean_f5b4eb46 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_clienteHomeBean_f5b4eb46)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = _EJS_beanRef.create_Local(cod_cliente, cod_oficina, cod_gestor, cod_territorio, mofactv, cs000lineamaxtc, cs000mtoprestamo, montovehicular, montohipotecario, tconsactv, montosubrogados, tsubactv, thipotactv, tvehicactv, cs000montocta36, tcuot36act, cs000montocta48, tcuot48act, cs000montocta60, tcuot60act, css000presmena5000, cs000comisdesemen5000, cs000pres5000a15000, c5000comdes15000act, cs000presmaya15000, comdes15000ac, cs000linminadqtc, cs000mixmonprest, cs000mixlinasistc, cs000prestcmena5000, cs000prestc500015000, cs000prestcmaya15000);
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal findByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal _EJS_result = null;
		try {
			if ( container.doesJaccNeedsEJBArguments(this) )
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = primaryKey;
			}
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_clienteHomeBean_f5b4eb46 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_clienteHomeBean_f5b4eb46)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
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
	com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_clienteHomeBean_f5b4eb46 _EJS_beanRef = (com.grupobbva.bc.per.tel.iilc.entity.EJSCMPTiilc_clienteHomeBean_f5b4eb46)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
}
