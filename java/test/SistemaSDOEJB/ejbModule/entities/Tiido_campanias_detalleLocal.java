package entities;
/**
 * Local interface for Enterprise Bean: Tiido_campanias_detalle
 */
public interface Tiido_campanias_detalleLocal extends javax.ejb.EJBLocalObject {
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
	 * Get accessor for persistent attribute: nro_clie
	 */
	public java.math.BigDecimal getNro_clie();
	/**
	 * Set accessor for persistent attribute: nro_clie
	 */
	public void setNro_clie(java.math.BigDecimal newNro_clie);
	/**
	 * Get accessor for persistent attribute: comp_gest
	 */
	public java.math.BigDecimal getComp_gest();
	/**
	 * Set accessor for persistent attribute: comp_gest
	 */
	public void setComp_gest(java.math.BigDecimal newComp_gest);
	/**
	 * Get accessor for persistent attribute: nro_gest_segu_1
	 */
	public java.math.BigDecimal getNro_gest_segu_1();
	/**
	 * Set accessor for persistent attribute: nro_gest_segu_1
	 */
	public void setNro_gest_segu_1(java.math.BigDecimal newNro_gest_segu_1);
	/**
	 * Get accessor for persistent attribute: nro_conc_segu_1
	 */
	public java.math.BigDecimal getNro_conc_segu_1();
	/**
	 * Set accessor for persistent attribute: nro_conc_segu_1
	 */
	public void setNro_conc_segu_1(java.math.BigDecimal newNro_conc_segu_1);
	/**
	 * Get accessor for persistent attribute: mont_segu_1
	 */
	public java.math.BigDecimal getMont_segu_1();
	/**
	 * Set accessor for persistent attribute: mont_segu_1
	 */
	public void setMont_segu_1(java.math.BigDecimal newMont_segu_1);
	/**
	 * Get accessor for persistent attribute: nro_gest_segu_2
	 */
	public java.math.BigDecimal getNro_gest_segu_2();
	/**
	 * Set accessor for persistent attribute: nro_gest_segu_2
	 */
	public void setNro_gest_segu_2(java.math.BigDecimal newNro_gest_segu_2);
	/**
	 * Get accessor for persistent attribute: nro_conc_segu_2
	 */
	public java.math.BigDecimal getNro_conc_segu_2();
	/**
	 * Set accessor for persistent attribute: nro_conc_segu_2
	 */
	public void setNro_conc_segu_2(java.math.BigDecimal newNro_conc_segu_2);
	/**
	 * Get accessor for persistent attribute: mont_segu_2
	 */
	public java.math.BigDecimal getMont_segu_2();
	/**
	 * Set accessor for persistent attribute: mont_segu_2
	 */
	public void setMont_segu_2(java.math.BigDecimal newMont_segu_2);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public java.sql.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public void setFec_regi(java.sql.Date newFec_regi);
	/**
	 * Get accessor for persistent attribute: fec_segu_1
	 */
	public java.sql.Date getFec_segu_1();
	/**
	 * Set accessor for persistent attribute: fec_segu_1
	 */
	public void setFec_segu_1(java.sql.Date newFec_segu_1);
	/**
	 * Get accessor for persistent attribute: fec_segu_2
	 */
	public java.sql.Date getFec_segu_2();
	/**
	 * Set accessor for persistent attribute: fec_segu_2
	 */
	public void setFec_segu_2(java.sql.Date newFec_segu_2);
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
	 * This method was generated for supporting the relationship role named tiido_camdet_campanias_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_campaniasLocal getTiido_camdet_campanias_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_camdet_campanias_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_camdet_campanias_fk(
		entities.Tiido_campaniasLocal aTiido_camdet_campanias_fk);
	/**
	 * Set accessor for persistent attribute: cod_camp_deta
	 */
	public void setCod_camp_deta(java.lang.Integer newCod_camp_deta);
}
