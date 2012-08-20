package com.grupobbva.bc.per.tel.iilc.entity;

import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_multitabla
 */
public abstract class Tiilc_multitablaBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey ejbCreate(
		java.lang.String cod_mult,
		java.lang.String cod_ele) throws javax.ejb.CreateException {
		setCod_mult(cod_mult);
		setCod_ele(cod_ele);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_mult,
		java.lang.String cod_ele) throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: cod_mult
	 */
	public abstract java.lang.String getCod_mult();
	/**
	 * Set accessor for persistent attribute: cod_mult
	 */
	public abstract void setCod_mult(java.lang.String newCod_mult);
	/**
	 * Get accessor for persistent attribute: cod_ele
	 */
	public abstract java.lang.String getCod_ele();
	/**
	 * Set accessor for persistent attribute: cod_ele
	 */
	public abstract void setCod_ele(java.lang.String newCod_ele);
	/**
	 * Get accessor for persistent attribute: valor1
	 */
	public abstract java.lang.String getValor1();
	/**
	 * Set accessor for persistent attribute: valor1
	 */
	public abstract void setValor1(java.lang.String newValor1);
	/**
	 * Get accessor for persistent attribute: valor2
	 */
	public abstract java.lang.String getValor2();
	/**
	 * Set accessor for persistent attribute: valor2
	 */
	public abstract void setValor2(java.lang.String newValor2);
	/**
	 * Get accessor for persistent attribute: valor3
	 */
	public abstract java.lang.String getValor3();
	/**
	 * Set accessor for persistent attribute: valor3
	 */
	public abstract void setValor3(java.lang.String newValor3);
	/**
	 * Get accessor for persistent attribute: valor4
	 */
	public abstract java.lang.String getValor4();
	/**
	 * Set accessor for persistent attribute: valor4
	 */
	public abstract void setValor4(java.lang.String newValor4);
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey ejbCreate(
			Multitabla multitabla) throws javax.ejb.CreateException {
			setCod_mult(multitabla.getCod_mult());
			setCod_ele(multitabla.getCod_ele());
			setValor1(multitabla.getValor1());
			setValor2(multitabla.getValor2());
			setValor3(multitabla.getValor3());
			setValor4(multitabla.getValor4());
			return null;
		}
	public void ejbPostCreate(
		Multitabla multitabla) throws javax.ejb.CreateException {
	}
}
