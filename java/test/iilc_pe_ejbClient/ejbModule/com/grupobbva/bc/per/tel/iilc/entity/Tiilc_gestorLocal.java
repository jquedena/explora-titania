package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local interface for Enterprise Bean: Tiilc_gestor
 */
public interface Tiilc_gestorLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public java.lang.String getCod_gestor();
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public void setCod_gestor(java.lang.String newCod_gestor);
	/**
	 * Get accessor for persistent attribute: nom_gestor
	 */
	public java.lang.String getNom_gestor();
	/**
	 * Set accessor for persistent attribute: nom_gestor
	 */
	public void setNom_gestor(java.lang.String newNom_gestor);
	/**
	 * Get accessor for persistent attribute: reg_gestor
	 */
	public java.lang.String getReg_gestor();
	/**
	 * Set accessor for persistent attribute: reg_gestor
	 */
	public void setReg_gestor(java.lang.String newReg_gestor);
	/**
	 * Get accessor for persistent attribute: perfil_gestor
	 */
	public java.lang.String getPerfil_gestor();
	/**
	 * Set accessor for persistent attribute: perfil_gestor
	 */
	public void setPerfil_gestor(java.lang.String newPerfil_gestor);
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal getTiilc_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiilc_oficina_fk(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal aTiilc_oficina_fk);
}
