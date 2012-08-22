package entities;
/**
 * Local interface for Enterprise Bean: Tiido_metas_gestor
 */
public interface Tiido_metas_gestorLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: cod_meta_gestor
	 */
	public java.lang.String getCod_meta_gestor();
	/**
	 * Set accessor for persistent attribute: cod_meta_gestor
	 */
	public void setCod_meta_gestor(java.lang.String newCod_meta_gestor);
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public java.lang.String getCod_gestor();
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public void setCod_gestor(java.lang.String newCod_gestor);
	/**
	 * Get accessor for persistent attribute: mes
	 */
	public java.lang.String getMes();
	/**
	 * Set accessor for persistent attribute: mes
	 */
	public void setMes(java.lang.String newMes);
	/**
	 * Get accessor for persistent attribute: orden
	 */
	public java.lang.String getOrden();
	/**
	 * Set accessor for persistent attribute: orden
	 */
	public void setOrden(java.lang.String newOrden);
	/**
	 * Get accessor for persistent attribute: porc_asig
	 */
	public java.math.BigDecimal getPorc_asig();
	/**
	 * Set accessor for persistent attribute: porc_asig
	 */
	public void setPorc_asig(java.math.BigDecimal newPorc_asig);
	/**
	 * Get accessor for persistent attribute: nom_epigrafe
	 */
	public java.lang.String getNom_epigrafe();
	/**
	 * Set accessor for persistent attribute: nom_epigrafe
	 */
	public void setNom_epigrafe(java.lang.String newNom_epigrafe);
	/**
	 * Get accessor for persistent attribute: nom_gestor
	 */
	public java.lang.String getNom_gestor();
	/**
	 * Set accessor for persistent attribute: nom_gestor
	 */
	public void setNom_gestor(java.lang.String newNom_gestor);
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_epigrafeLocal getTiido_metges_epigrafe_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_metges_epigrafe_fk(
		entities.Tiido_epigrafeLocal aTiido_metges_epigrafe_fk);
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaLocal getTiido_metges_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_metges_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_metges_oficina_fk);
	/**
	 * Get accessor for persistent attribute: cod_perfil_gestor
	 */
	public java.lang.String getCod_perfil_gestor();
	/**
	 * Set accessor for persistent attribute: cod_perfil_gestor
	 */
	public void setCod_perfil_gestor(java.lang.String newCod_perfil_gestor);
	/**
	 * Get accessor for persistent attribute: estado
	 */
	public java.lang.String getEstado();
	/**
	 * Set accessor for persistent attribute: estado
	 */
	public void setEstado(java.lang.String newEstado);
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public java.util.Date getFec_actu();
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public void setFec_actu(java.util.Date newFec_actu);
	/**
	 * Get accessor for persistent attribute: usu_regi
	 */
	public java.lang.String getUsu_regi();
	/**
	 * Set accessor for persistent attribute: usu_regi
	 */
	public void setUsu_regi(java.lang.String newUsu_regi);
	/**
	 * Get accessor for persistent attribute: usu_actu
	 */
	public java.lang.String getUsu_actu();
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public void setUsu_actu(java.lang.String newUsu_actu);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public java.sql.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public void setFec_regi(java.sql.Date newFec_regi);
}
