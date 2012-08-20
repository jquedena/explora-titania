package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local interface for Enterprise Bean: Tiilc_territorio
 */
public interface Tiilc_territorioLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: cod_territorio
	 */
	public java.lang.String getCod_territorio();
	/**
	 * Set accessor for persistent attribute: cod_territorio
	 */
	public void setCod_territorio(java.lang.String newCod_territorio);
	/**
	 * Get accessor for persistent attribute: des_territorio
	 */
	public java.lang.String getDes_territorio();
	/**
	 * Set accessor for persistent attribute: des_territorio
	 */
	public void setDes_territorio(java.lang.String newDes_territorio);
	/**
	 * This method was generated for supporting the relationship role named tiilc_area_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal getTiilc_area_fk();
	/**
	 * This method was generated for supporting the relationship role named tiilc_area_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiilc_area_fk(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal aTiilc_area_fk);
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiilc_oficina();
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiilc_oficina(java.util.Collection aTiilc_oficina);
}
