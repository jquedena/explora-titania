package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiilc_clienteHomeBean_f5b4eb46
 */
public class EJSCMPTiilc_clienteHomeBean_f5b4eb46 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiilc_clienteHomeBean_f5b4eb46
	 */
	public EJSCMPTiilc_clienteHomeBean_f5b4eb46() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal create_Local(java.math.BigDecimal cod_cliente) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_cliente);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_cliente);
			super.afterPostCreate(beanO, ejsKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if(preCreateFlag && !createFailed)
				super.afterPostCreateCompletion(beanO);
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return result;
	}
	/**
	 * create_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal create_Local(java.math.BigDecimal cod_cliente, java.lang.String cod_oficina, java.lang.String cod_gestor, java.lang.String cod_territorio, java.math.BigDecimal mofactv, java.math.BigDecimal cs000lineamaxtc, java.math.BigDecimal cs000mtoprestamo, java.math.BigDecimal montovehicular, java.math.BigDecimal montohipotecario, java.math.BigDecimal tconsactv, java.math.BigDecimal montosubrogados, java.math.BigDecimal tsubactv, java.math.BigDecimal thipotactv, java.math.BigDecimal tvehicactv, java.lang.String cs000montocta36, java.math.BigDecimal tcuot36act, java.math.BigDecimal cs000montocta48, java.math.BigDecimal tcuot48act, java.math.BigDecimal cs000montocta60, java.math.BigDecimal tcuot60act, java.math.BigDecimal css000presmena5000, java.math.BigDecimal cs000comisdesemen5000, java.math.BigDecimal cs000pres5000a15000, java.math.BigDecimal c5000comdes15000act, java.math.BigDecimal cs000presmaya15000, java.math.BigDecimal comdes15000ac, java.math.BigDecimal cs000linminadqtc, java.math.BigDecimal cs000mixmonprest, java.math.BigDecimal cs000mixlinasistc, java.math.BigDecimal cs000prestcmena5000, java.math.BigDecimal cs000prestc500015000, java.math.BigDecimal cs000prestcmaya15000) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteBean bean = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(cod_cliente, cod_oficina, cod_gestor, cod_territorio, mofactv, cs000lineamaxtc, cs000mtoprestamo, montovehicular, montohipotecario, tconsactv, montosubrogados, tsubactv, thipotactv, tvehicactv, cs000montocta36, tcuot36act, cs000montocta48, tcuot48act, cs000montocta60, tcuot60act, css000presmena5000, cs000comisdesemen5000, cs000pres5000a15000, c5000comdes15000act, cs000presmaya15000, comdes15000ac, cs000linminadqtc, cs000mixmonprest, cs000mixlinasistc, cs000prestcmena5000, cs000prestc500015000, cs000prestcmaya15000);
			Object ejsKey = keyFromBean(bean);
			result = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(cod_cliente, cod_oficina, cod_gestor, cod_territorio, mofactv, cs000lineamaxtc, cs000mtoprestamo, montovehicular, montohipotecario, tconsactv, montosubrogados, tsubactv, thipotactv, tvehicactv, cs000montocta36, tcuot36act, cs000montocta48, tcuot48act, cs000montocta60, tcuot60act, css000presmena5000, cs000comisdesemen5000, cs000pres5000a15000, c5000comdes15000act, cs000presmaya15000, comdes15000ac, cs000linminadqtc, cs000mixmonprest, cs000mixlinasistc, cs000prestcmena5000, cs000prestc500015000, cs000prestcmaya15000);
			super.afterPostCreate(beanO, ejsKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if(preCreateFlag && !createFailed)
				super.afterPostCreateCompletion(beanO);
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return result;
	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal findByPrimaryKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_cliente_f5b4eb46 tmpEJB = (com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_cliente_f5b4eb46) generalEJB;
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey();
		keyClass.cod_cliente = tmpEJB.getCod_cliente();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey keyFromFields(java.math.BigDecimal f0) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey keyClass = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey();
		keyClass.cod_cliente = f0;
		return keyClass;
	}
}
