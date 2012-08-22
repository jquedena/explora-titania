package entities;
/**
 * Local interface for Enterprise Bean: Tiido_maestro_planes
 */
public interface Tiido_maestro_planesLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: mes
	 */
	public java.lang.String getMes();
	/**
	 * Set accessor for persistent attribute: mes
	 */
	public void setMes(java.lang.String newMes);
	/**
	 * Get accessor for persistent attribute: anho
	 */
	public java.lang.String getAnho();
	/**
	 * Set accessor for persistent attribute: anho
	 */
	public void setAnho(java.lang.String newAnho);
	/**
	 * Get accessor for persistent attribute: prioridad
	 */
	public java.math.BigDecimal getPrioridad();
	/**
	 * Set accessor for persistent attribute: prioridad
	 */
	public void setPrioridad(java.math.BigDecimal newPrioridad);
	/**
	 * Get accessor for persistent attribute: fec_grab
	 */
	public java.sql.Date getFec_grab();
	/**
	 * Set accessor for persistent attribute: fec_grab
	 */
	public void setFec_grab(java.sql.Date newFec_grab);
	/**
	 * This method was generated for supporting the relationship role named tiido_maepla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaLocal getTiido_maepla_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_maepla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_maepla_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_maepla_oficina_fk);
}
