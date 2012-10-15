package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Bean implementation class for Enterprise Bean: Tiilc_gestor
 */
public abstract class Tiilc_gestorBean implements javax.ejb.EntityBean {
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey ejbCreate(
		java.lang.String cod_gestor,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal argTiilc_oficina_fk)
		throws javax.ejb.CreateException {
		setCod_gestor(cod_gestor);
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey argTiilc_oficina_fkPK = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey) argTiilc_oficina_fk
			.getPrimaryKey();
		setTiilc_oficina_fk_cod_oficina(argTiilc_oficina_fkPK.cod_oficina);
		setTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio(argTiilc_oficina_fkPK.tiilc_territorio_fk_cod_territorio);
		setTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area(argTiilc_oficina_fkPK.tiilc_territorio_fk_tiilc_area_fk_cod_area);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_gestor,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal argTiilc_oficina_fk)
		throws javax.ejb.CreateException {
		setTiilc_oficina_fk(argTiilc_oficina_fk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey ejbCreate(
		java.lang.String cod_gestor,
		java.lang.String tiilc_oficina_fk_cod_oficina,
		java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio,
		java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area)
		throws javax.ejb.CreateException {
		setCod_gestor(cod_gestor);
		setTiilc_oficina_fk_cod_oficina(tiilc_oficina_fk_cod_oficina);
		setTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio(tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio);
		setTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area(tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_gestor,
		java.lang.String tiilc_oficina_fk_cod_oficina,
		java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio,
		java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area)
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
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public abstract java.lang.String getCod_gestor();
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public abstract void setCod_gestor(java.lang.String newCod_gestor);
	/**
	 * Get accessor for persistent attribute: nom_gestor
	 */
	public abstract java.lang.String getNom_gestor();
	/**
	 * Set accessor for persistent attribute: nom_gestor
	 */
	public abstract void setNom_gestor(java.lang.String newNom_gestor);
	/**
	 * Get accessor for persistent attribute: reg_gestor
	 */
	public abstract java.lang.String getReg_gestor();
	/**
	 * Set accessor for persistent attribute: reg_gestor
	 */
	public abstract void setReg_gestor(java.lang.String newReg_gestor);
	/**
	 * Get accessor for persistent attribute: perfil_gestor
	 */
	public abstract java.lang.String getPerfil_gestor();
	/**
	 * Set accessor for persistent attribute: perfil_gestor
	 */
	public abstract void setPerfil_gestor(java.lang.String newPerfil_gestor);
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal getTiilc_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiilc_oficina_fk(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal aTiilc_oficina_fk);
	/**
	 * Get accessor for persistent attribute: tiilc_oficina_fk_cod_oficina
	 */
	public abstract java.lang.String getTiilc_oficina_fk_cod_oficina();
	/**
	 * Set accessor for persistent attribute: tiilc_oficina_fk_cod_oficina
	 */
	public abstract void setTiilc_oficina_fk_cod_oficina(
		java.lang.String newTiilc_oficina_fk_cod_oficina);
	/**
	 * Get accessor for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio
	 */
	public abstract java.lang.String getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio();
	/**
	 * Set accessor for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio
	 */
	public abstract void setTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio(
		java.lang.String newTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio);
	/**
	 * Get accessor for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public abstract java.lang.String getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area();
	/**
	 * Set accessor for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public abstract void setTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area(
		java.lang.String newTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey ejbCreate(
			java.lang.String cod_gestor,
			java.lang.String tiilc_oficina_fk_cod_oficina,
			java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio,
			java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area,
			java.lang.String nom_gestor,
			java.lang.String reg_gestor,
			java.lang.String perfil_gestor)
			throws javax.ejb.CreateException {
			setCod_gestor(cod_gestor);
			setTiilc_oficina_fk_cod_oficina(tiilc_oficina_fk_cod_oficina);
			setTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio(tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio);
			setTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area(tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
			setNom_gestor(nom_gestor);
			setReg_gestor(reg_gestor);
			setPerfil_gestor(perfil_gestor);
			return null;
		}
	public void ejbPostCreate(
		java.lang.String cod_gestor,
		java.lang.String tiilc_oficina_fk_cod_oficina,
		java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio,
		java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area,
		java.lang.String nom_gestor,
		java.lang.String reg_gestor,
		java.lang.String perfil_gestor)
		throws javax.ejb.CreateException {
	}
}
