package entities;
/**
 * Local interface for Enterprise Bean: Tiido_oficina
 */
public interface Tiido_oficinaLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: cod_ofic
	 */
	public java.lang.String getCod_ofic();
	/**
	 * Set accessor for persistent attribute: cod_ofic
	 */
	public void setCod_ofic(java.lang.String newCod_ofic);
	/**
	 * Get accessor for persistent attribute: nom_ofic
	 */
	public java.lang.String getNom_ofic();
	/**
	 * Set accessor for persistent attribute: nom_ofic
	 */
	public void setNom_ofic(java.lang.String newNom_ofic);
	/**
	 * Get accessor for persistent attribute: usu_regi
	 */
	public java.lang.String getUsu_regi();
	/**
	 * Set accessor for persistent attribute: usu_regi
	 */
	public void setUsu_regi(java.lang.String newUsu_regi);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public java.sql.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public void setFec_regi(java.sql.Date newFec_regi);
	/**
	 * Get accessor for persistent attribute: usu_actu
	 */
	public java.lang.String getUsu_actu();
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public void setUsu_actu(java.lang.String newUsu_actu);
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public java.sql.Date getFec_actu();
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public void setFec_actu(java.sql.Date newFec_actu);
	/**
	 * This method was generated for supporting the relationship role named tiido_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_territorioLocal getTiido_territorio_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_territorio_fk(
		entities.Tiido_territorioLocal aTiido_territorio_fk);
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
	 * This method was generated for supporting the relationship role named tiido_campanias.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiido_campanias();
	/**
	 * This method was generated for supporting the relationship role named tiido_campanias.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_campanias(java.util.Collection aTiido_campanias);
	/**
	 * This method was generated for supporting the relationship role named tiido_firmas.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiido_firmas();
	/**
	 * This method was generated for supporting the relationship role named tiido_firmas.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_firmas(java.util.Collection aTiido_firmas);
	/**
	 * This method was generated for supporting the relationship role named tiido_maestro_planes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiido_maestro_planes();
	/**
	 * This method was generated for supporting the relationship role named tiido_maestro_planes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_maestro_planes(
		java.util.Collection aTiido_maestro_planes);
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
	 * This method was generated for supporting the relationship role named tiido_planes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiido_planes();
	/**
	 * This method was generated for supporting the relationship role named tiido_planes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_planes(java.util.Collection aTiido_planes);
	/**
	 * Get accessor for persistent attribute: tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_territorio_fk_cod_terr();
	/**
	 * Set accessor for persistent attribute: tiido_territorio_fk_cod_terr
	 */
	public void setTiido_territorio_fk_cod_terr(
		java.lang.String newTiido_territorio_fk_cod_terr);
	/**
	 * Get accessor for persistent attribute: estado
	 */
	public java.lang.String getEstado();
	/**
	 * Set accessor for persistent attribute: estado
	 */
	public void setEstado(java.lang.String newEstado);
}
