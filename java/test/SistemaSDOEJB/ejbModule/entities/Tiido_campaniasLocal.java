package entities;
/**
 * Local interface for Enterprise Bean: Tiido_campanias
 */
public interface Tiido_campaniasLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: anho
	 */
	public java.lang.String getAnho();
	/**
	 * Set accessor for persistent attribute: anho
	 */
	public void setAnho(java.lang.String newAnho);
	/**
	 * Get accessor for persistent attribute: mes
	 */
	public java.lang.String getMes();
	/**
	 * Set accessor for persistent attribute: mes
	 */
	public void setMes(java.lang.String newMes);
	/**
	 * Get accessor for persistent attribute: nom_camp
	 */
	public java.lang.String getNom_camp();
	/**
	 * Set accessor for persistent attribute: nom_camp
	 */
	public void setNom_camp(java.lang.String newNom_camp);
	/**
	 * Get accessor for persistent attribute: cod_gest
	 */
	public java.lang.String getCod_gest();
	/**
	 * Set accessor for persistent attribute: cod_gest
	 */
	public void setCod_gest(java.lang.String newCod_gest);
	/**
	 * Get accessor for persistent attribute: orden
	 */
	public java.lang.String getOrden();
	/**
	 * Set accessor for persistent attribute: orden
	 */
	public void setOrden(java.lang.String newOrden);
	/**
	 * Get accessor for persistent attribute: gte
	 */
	public java.lang.String getGte();
	/**
	 * Set accessor for persistent attribute: gte
	 */
	public void setGte(java.lang.String newGte);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public java.sql.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public void setFec_regi(java.sql.Date newFec_regi);
	/**
	 * Get accessor for persistent attribute: usu_regi
	 */
	public java.lang.String getUsu_regi();
	/**
	 * Set accessor for persistent attribute: usu_regi
	 */
	public void setUsu_regi(java.lang.String newUsu_regi);
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public java.sql.Date getFec_actu();
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public void setFec_actu(java.sql.Date newFec_actu);
	/**
	 * Get accessor for persistent attribute: usu_actu
	 */
	public java.lang.String getUsu_actu();
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public void setUsu_actu(java.lang.String newUsu_actu);
	/**
	 * This method was generated for supporting the relationship role named tiido_cam_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaLocal getTiido_cam_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_cam_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_cam_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_cam_oficina_fk);
	/**
	 * This method was generated for supporting the relationship role named tiido_campanias_detalle.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiido_campanias_detalle();
	/**
	 * This method was generated for supporting the relationship role named tiido_campanias_detalle.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_campanias_detalle(
		java.util.Collection aTiido_campanias_detalle);
	/**
	 * Get accessor for persistent attribute: cod_camp
	 */
	public java.lang.Integer getCod_camp();
	/**
	 * Set accessor for persistent attribute: cod_camp
	 */
	public void setCod_camp(java.lang.Integer newCod_camp);
}
