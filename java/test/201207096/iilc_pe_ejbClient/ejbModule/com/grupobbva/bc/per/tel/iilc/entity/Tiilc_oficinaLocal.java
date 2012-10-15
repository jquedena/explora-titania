package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local interface for Enterprise Bean: Tiilc_oficina
 */
public interface Tiilc_oficinaLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: cod_oficina
	 */
	public java.lang.String getCod_oficina();
	/**
	 * Set accessor for persistent attribute: cod_oficina
	 */
	public void setCod_oficina(java.lang.String newCod_oficina);
	/**
	 * Get accessor for persistent attribute: des_oficina
	 */
	public java.lang.String getDes_oficina();
	/**
	 * Set accessor for persistent attribute: des_oficina
	 */
	public void setDes_oficina(java.lang.String newDes_oficina);
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal getTiilc_territorio_fk();
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiilc_territorio_fk(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal aTiilc_territorio_fk);
	/**
	 * This method was generated for supporting the relationship role named tiilc_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiilc_gestor();
	/**
	 * This method was generated for supporting the relationship role named tiilc_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiilc_gestor(java.util.Collection aTiilc_gestor);
}
