package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Bean implementation class for Enterprise Bean: Tiilc_linea_comercial
 */
public abstract class Tiilc_linea_comercialBean implements javax.ejb.EntityBean {
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey ejbCreate(
		java.lang.String cod_grupo,
		java.lang.String cod_lincom) throws javax.ejb.CreateException {
		setCod_grupo(cod_grupo);
		setCod_lincom(cod_lincom);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_grupo,
		java.lang.String cod_lincom) throws javax.ejb.CreateException {
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
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey ejbCreate(
		java.lang.String cod_grupo,
		java.lang.String cod_lincom,
		java.lang.String des_lincom) throws javax.ejb.CreateException {
		setCod_grupo(cod_grupo);
		setCod_lincom(cod_lincom);
		setDes_lincom(des_lincom);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_grupo,
		java.lang.String cod_lincom,
		java.lang.String des_lincom) throws javax.ejb.CreateException {
	}
	/**
	 * Get accessor for persistent attribute: cod_grupo
	 */
	public abstract java.lang.String getCod_grupo();
	/**
	 * Set accessor for persistent attribute: cod_grupo
	 */
	public abstract void setCod_grupo(java.lang.String newCod_grupo);
	/**
	 * Get accessor for persistent attribute: cod_lincom
	 */
	public abstract java.lang.String getCod_lincom();
	/**
	 * Set accessor for persistent attribute: cod_lincom
	 */
	public abstract void setCod_lincom(java.lang.String newCod_lincom);
	/**
	 * Get accessor for persistent attribute: des_lincom
	 */
	public abstract java.lang.String getDes_lincom();
	/**
	 * Set accessor for persistent attribute: des_lincom
	 */
	public abstract void setDes_lincom(java.lang.String newDes_lincom);
}
