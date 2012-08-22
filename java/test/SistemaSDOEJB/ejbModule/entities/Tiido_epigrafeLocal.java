package entities;
/**
 * Local interface for Enterprise Bean: Tiido_epigrafe
 */
public interface Tiido_epigrafeLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: cod_epigrafe
	 */
	public java.lang.String getCod_epigrafe();
	/**
	 * Set accessor for persistent attribute: cod_epigrafe
	 */
	public void setCod_epigrafe(java.lang.String newCod_epigrafe);
	/**
	 * Get accessor for persistent attribute: anho
	 */
	public java.lang.String getAnho();
	/**
	 * Set accessor for persistent attribute: anho
	 */
	public void setAnho(java.lang.String newAnho);
	/**
	 * Get accessor for persistent attribute: nom_epigrafe
	 */
	public java.lang.String getNom_epigrafe();
	/**
	 * Set accessor for persistent attribute: nom_epigrafe
	 */
	public void setNom_epigrafe(java.lang.String newNom_epigrafe);
	/**
	 * Get accessor for persistent attribute: ind_clase
	 */
	public java.lang.String getInd_clase();
	/**
	 * Set accessor for persistent attribute: ind_clase
	 */
	public void setInd_clase(java.lang.String newInd_clase);
	/**
	 * Get accessor for persistent attribute: ind_sub_clase
	 */
	public java.lang.String getInd_sub_clase();
	/**
	 * Set accessor for persistent attribute: ind_sub_clase
	 */
	public void setInd_sub_clase(java.lang.String newInd_sub_clase);
	/**
	 * Get accessor for persistent attribute: orden
	 */
	public java.lang.String getOrden();
	/**
	 * Set accessor for persistent attribute: orden
	 */
	public void setOrden(java.lang.String newOrden);
	/**
	 * Get accessor for persistent attribute: ind_grupo
	 */
	public java.lang.String getInd_grupo();
	/**
	 * Set accessor for persistent attribute: ind_grupo
	 */
	public void setInd_grupo(java.lang.String newInd_grupo);
	/**
	 * Get accessor for persistent attribute: abreviatura
	 */
	public java.lang.String getAbreviatura();
	/**
	 * Set accessor for persistent attribute: abreviatura
	 */
	public void setAbreviatura(java.lang.String newAbreviatura);
	/**
	 * Get accessor for persistent attribute: ind_hijo
	 */
	public java.lang.String getInd_hijo();
	/**
	 * Set accessor for persistent attribute: ind_hijo
	 */
	public void setInd_hijo(java.lang.String newInd_hijo);
	/**
	 * Get accessor for persistent attribute: ind_afecta
	 */
	public java.lang.String getInd_afecta();
	/**
	 * Set accessor for persistent attribute: ind_afecta
	 */
	public void setInd_afecta(java.lang.String newInd_afecta);
	/**
	 * This method was generated for supporting the relationship role named tiido_acciones.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiido_acciones();
	/**
	 * This method was generated for supporting the relationship role named tiido_acciones.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_acciones(java.util.Collection aTiido_acciones);
	/**
	 * This method was generated for supporting the relationship role named tiido_metas_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiido_metas_gestor();
	/**
	 * This method was generated for supporting the relationship role named tiido_metas_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_metas_gestor(java.util.Collection aTiido_metas_gestor);
	/**
	 * Get accessor for persistent attribute: porcentaje_max
	 */
	public java.math.BigDecimal getPorcentaje_max();
	/**
	 * Set accessor for persistent attribute: porcentaje_max
	 */
	public void setPorcentaje_max(java.math.BigDecimal newPorcentaje_max);
	/**
	 * Get accessor for persistent attribute: porcentaje_min
	 */
	public java.math.BigDecimal getPorcentaje_min();
	/**
	 * Set accessor for persistent attribute: porcentaje_min
	 */
	public void setPorcentaje_min(java.math.BigDecimal newPorcentaje_min);
}
