package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Bean implementation class for Enterprise Bean: Tiilc_area
 */
public abstract class Tiilc_areaBean implements javax.ejb.EntityBean {
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey ejbCreate(
		java.lang.String cod_area) throws javax.ejb.CreateException {
		setCod_area(cod_area);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_area)
		throws javax.ejb.CreateException {
	}
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey ejbCreate(
			java.lang.String cod_area, 
			java.lang.String des_area) throws javax.ejb.CreateException {
			setCod_area(cod_area);
			setDes_area(des_area);
			return null;
		}
	public void ejbPostCreate(java.lang.String cod_area, java.lang.String des_area)
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
	 * Get accessor for persistent attribute: cod_area
	 */
	public abstract java.lang.String getCod_area();
	/**
	 * Set accessor for persistent attribute: cod_area
	 */
	public abstract void setCod_area(java.lang.String newCod_area);
	/**
	 * Get accessor for persistent attribute: des_area
	 */
	public abstract java.lang.String getDes_area();
	/**
	 * Set accessor for persistent attribute: des_area
	 */
	public abstract void setDes_area(java.lang.String newDes_area);
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiilc_territorio();
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiilc_territorio(
		java.util.Collection aTiilc_territorio);
}
