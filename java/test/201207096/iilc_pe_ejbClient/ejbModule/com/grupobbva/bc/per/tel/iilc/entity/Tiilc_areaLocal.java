package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local interface for Enterprise Bean: Tiilc_area
 */
public interface Tiilc_areaLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: cod_area
	 */
	public java.lang.String getCod_area();
	/**
	 * Set accessor for persistent attribute: cod_area
	 */
	public void setCod_area(java.lang.String newCod_area);
	/**
	 * Get accessor for persistent attribute: des_area
	 */
	public java.lang.String getDes_area();
	/**
	 * Set accessor for persistent attribute: des_area
	 */
	public void setDes_area(java.lang.String newDes_area);
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiilc_territorio();
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiilc_territorio(java.util.Collection aTiilc_territorio);
}
