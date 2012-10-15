package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Bean implementation class for Enterprise Bean: Tiilc_empresa
 */
public abstract class Tiilc_empresaBean implements javax.ejb.EntityBean {
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey ejbCreate(
		java.lang.String cod_empresa) throws javax.ejb.CreateException {
		setCod_empresa(cod_empresa);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_empresa)
		throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: cod_empresa
	 */
	public abstract java.lang.String getCod_empresa();
	/**
	 * Set accessor for persistent attribute: cod_empresa
	 */
	public abstract void setCod_empresa(java.lang.String newCod_empresa);
	/**
	 * Get accessor for persistent attribute: des_empresa
	 */
	public abstract java.lang.String getDes_empresa();
	/**
	 * Set accessor for persistent attribute: des_empresa
	 */
	public abstract void setDes_empresa(java.lang.String newDes_empresa);
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey ejbCreate(
			java.lang.String cod_empresa,java.lang.String des_empresa) throws javax.ejb.CreateException {
			setCod_empresa(cod_empresa);
			setDes_empresa(des_empresa);
			return null;
		}
	public void ejbPostCreate(java.lang.String cod_empresa,java.lang.String des_empresa)
		throws javax.ejb.CreateException {
	}
}
