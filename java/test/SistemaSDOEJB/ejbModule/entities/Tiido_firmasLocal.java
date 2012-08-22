package entities;
/**
 * Local interface for Enterprise Bean: Tiido_firmas
 */
public interface Tiido_firmasLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: cod_firma
	 */
	public java.lang.String getCod_firma();
	/**
	 * Set accessor for persistent attribute: cod_firma
	 */
	public void setCod_firma(java.lang.String newCod_firma);
	/**
	 * Get accessor for persistent attribute: anho_firm
	 */
	public java.lang.String getAnho_firm();
	/**
	 * Set accessor for persistent attribute: anho_firm
	 */
	public void setAnho_firm(java.lang.String newAnho_firm);
	/**
	 * Get accessor for persistent attribute: mes_firm
	 */
	public java.lang.String getMes_firm();
	/**
	 * Set accessor for persistent attribute: mes_firm
	 */
	public void setMes_firm(java.lang.String newMes_firm);
	/**
	 * Get accessor for persistent attribute: item_firm
	 */
	public java.lang.String getItem_firm();
	/**
	 * Set accessor for persistent attribute: item_firm
	 */
	public void setItem_firm(java.lang.String newItem_firm);
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public java.lang.String getCod_gestor();
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public void setCod_gestor(java.lang.String newCod_gestor);
	/**
	 * Get accessor for persistent attribute: descripcion
	 */
	public java.lang.String getDescripcion();
	/**
	 * Set accessor for persistent attribute: descripcion
	 */
	public void setDescripcion(java.lang.String newDescripcion);
	/**
	 * Get accessor for persistent attribute: fec_firm
	 */
	public java.sql.Date getFec_firm();
	/**
	 * Set accessor for persistent attribute: fec_firm
	 */
	public void setFec_firm(java.sql.Date newFec_firm);
	/**
	 * This method was generated for supporting the relationship role named tiido_fir_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaLocal getTiido_fir_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_fir_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_fir_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_fir_oficina_fk);
}
