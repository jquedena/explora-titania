package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Bean implementation class for Enterprise Bean: Tiilc_territorio
 */
public abstract class Tiilc_territorioBean implements javax.ejb.EntityBean {
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey ejbCreate(
		java.lang.String cod_territorio,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal argTiilc_area_fk)
		throws javax.ejb.CreateException {
		setCod_territorio(cod_territorio);
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey argTiilc_area_fkPK = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey) argTiilc_area_fk
			.getPrimaryKey();
		setTiilc_area_fk_cod_area(argTiilc_area_fkPK.cod_area);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_territorio,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal argTiilc_area_fk)
		throws javax.ejb.CreateException {
		setTiilc_area_fk(argTiilc_area_fk);
	}
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey ejbCreate(
			java.lang.String cod_territorio,
			java.lang.String tiilc_area_fk_cod_area,
			java.lang.String des_territorio)
			throws javax.ejb.CreateException {
			setCod_territorio(cod_territorio);
			setTiilc_area_fk_cod_area(tiilc_area_fk_cod_area);
			setDes_territorio(des_territorio);
			return null;
		}
	public void ejbPostCreate(
		java.lang.String cod_territorio,
		java.lang.String tiilc_area_fk_cod_area,
		java.lang.String des_territorio)
		throws javax.ejb.CreateException {
	}
	
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey ejbCreate(
		java.lang.String cod_territorio,
		java.lang.String tiilc_area_fk_cod_area)
		throws javax.ejb.CreateException {
		setCod_territorio(cod_territorio);
		setTiilc_area_fk_cod_area(tiilc_area_fk_cod_area);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_territorio,
		java.lang.String tiilc_area_fk_cod_area)
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
	 * Get accessor for persistent attribute: cod_territorio
	 */
	public abstract java.lang.String getCod_territorio();
	/**
	 * Set accessor for persistent attribute: cod_territorio
	 */
	public abstract void setCod_territorio(java.lang.String newCod_territorio);
	/**
	 * Get accessor for persistent attribute: des_territorio
	 */
	public abstract java.lang.String getDes_territorio();
	/**
	 * Set accessor for persistent attribute: des_territorio
	 */
	public abstract void setDes_territorio(java.lang.String newDes_territorio);
	/**
	 * This method was generated for supporting the relationship role named tiilc_area_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal getTiilc_area_fk();
	/**
	 * This method was generated for supporting the relationship role named tiilc_area_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiilc_area_fk(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal aTiilc_area_fk);
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiilc_oficina();
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiilc_oficina(java.util.Collection aTiilc_oficina);
	/**
	 * Get accessor for persistent attribute: tiilc_area_fk_cod_area
	 */
	public abstract java.lang.String getTiilc_area_fk_cod_area();
	/**
	 * Set accessor for persistent attribute: tiilc_area_fk_cod_area
	 */
	public abstract void setTiilc_area_fk_cod_area(
		java.lang.String newTiilc_area_fk_cod_area);
}
