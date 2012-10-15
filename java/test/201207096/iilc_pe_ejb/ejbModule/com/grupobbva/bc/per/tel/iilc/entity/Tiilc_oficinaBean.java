package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Bean implementation class for Enterprise Bean: Tiilc_oficina
 */
public abstract class Tiilc_oficinaBean implements javax.ejb.EntityBean {
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey ejbCreate(
		java.lang.String cod_oficina,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal argTiilc_territorio_fk)
		throws javax.ejb.CreateException {
		setCod_oficina(cod_oficina);
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey argTiilc_territorio_fkPK = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey) argTiilc_territorio_fk
			.getPrimaryKey();
		setTiilc_territorio_fk_cod_territorio(argTiilc_territorio_fkPK.cod_territorio);
		setTiilc_territorio_fk_tiilc_area_fk_cod_area(argTiilc_territorio_fkPK.tiilc_area_fk_cod_area);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_oficina,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal argTiilc_territorio_fk)
		throws javax.ejb.CreateException {
		setTiilc_territorio_fk(argTiilc_territorio_fk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey ejbCreate(
		java.lang.String cod_oficina,
		java.lang.String tiilc_territorio_fk_cod_territorio,
		java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area)
		throws javax.ejb.CreateException {
		setCod_oficina(cod_oficina);
		setTiilc_territorio_fk_cod_territorio(tiilc_territorio_fk_cod_territorio);
		setTiilc_territorio_fk_tiilc_area_fk_cod_area(tiilc_territorio_fk_tiilc_area_fk_cod_area);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_oficina,
		java.lang.String tiilc_territorio_fk_cod_territorio,
		java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area)
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
	 * Get accessor for persistent attribute: cod_oficina
	 */
	public abstract java.lang.String getCod_oficina();
	/**
	 * Set accessor for persistent attribute: cod_oficina
	 */
	public abstract void setCod_oficina(java.lang.String newCod_oficina);
	/**
	 * Get accessor for persistent attribute: des_oficina
	 */
	public abstract java.lang.String getDes_oficina();
	/**
	 * Set accessor for persistent attribute: des_oficina
	 */
	public abstract void setDes_oficina(java.lang.String newDes_oficina);
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal getTiilc_territorio_fk();
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiilc_territorio_fk(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal aTiilc_territorio_fk);
	/**
	 * This method was generated for supporting the relationship role named tiilc_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiilc_gestor();
	/**
	 * This method was generated for supporting the relationship role named tiilc_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiilc_gestor(java.util.Collection aTiilc_gestor);
	/**
	 * Get accessor for persistent attribute: tiilc_territorio_fk_cod_territorio
	 */
	public abstract java.lang.String getTiilc_territorio_fk_cod_territorio();
	/**
	 * Set accessor for persistent attribute: tiilc_territorio_fk_cod_territorio
	 */
	public abstract void setTiilc_territorio_fk_cod_territorio(
		java.lang.String newTiilc_territorio_fk_cod_territorio);
	/**
	 * Get accessor for persistent attribute: tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public abstract java.lang.String getTiilc_territorio_fk_tiilc_area_fk_cod_area();
	/**
	 * Set accessor for persistent attribute: tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public abstract void setTiilc_territorio_fk_tiilc_area_fk_cod_area(
		java.lang.String newTiilc_territorio_fk_tiilc_area_fk_cod_area);
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey ejbCreate(
			java.lang.String cod_oficina,
			java.lang.String tiilc_territorio_fk_cod_territorio,
			java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area,
			java.lang.String des_oficina)
			throws javax.ejb.CreateException {
			setCod_oficina(cod_oficina);
			setTiilc_territorio_fk_cod_territorio(tiilc_territorio_fk_cod_territorio);
			setTiilc_territorio_fk_tiilc_area_fk_cod_area(tiilc_territorio_fk_tiilc_area_fk_cod_area);
			setDes_oficina(des_oficina);
			return null;
		}
	public void ejbPostCreate(
		java.lang.String cod_oficina,
		java.lang.String tiilc_territorio_fk_cod_territorio,
		java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area,
		java.lang.String des_oficina)
		throws javax.ejb.CreateException {
	}
}
