package entities;
/**
 * Local interface for Enterprise Bean: Tiido_territorio
 */
public interface Tiido_territorioLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: cod_terr
	 */
	public java.lang.String getCod_terr();
	/**
	 * Set accessor for persistent attribute: cod_terr
	 */
	public void setCod_terr(java.lang.String newCod_terr);
	/**
	 * Get accessor for persistent attribute: nom_terr
	 */
	public java.lang.String getNom_terr();
	/**
	 * Set accessor for persistent attribute: nom_terr
	 */
	public void setNom_terr(java.lang.String newNom_terr);
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
	 * This method was generated for supporting the relationship role named tiido_oficina.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTiido_oficina();
	/**
	 * This method was generated for supporting the relationship role named tiido_oficina.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTiido_oficina(java.util.Collection aTiido_oficina);
	/**
	 * Get accessor for persistent attribute: estado
	 */
	public java.lang.String getEstado();
	/**
	 * Set accessor for persistent attribute: estado
	 */
	public void setEstado(java.lang.String newEstado);
}
