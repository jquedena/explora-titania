package entities;
/**
 * Key class for Entity Bean: Tiido_campanias
 */
public class Tiido_campaniasKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_camp
	 */
	public java.lang.Integer cod_camp;
	/**
	 * Implementation field for persistent attribute: anho
	 */
	public java.lang.String anho;
	/**
	 * Implementation field for persistent attribute: mes
	 */
	public java.lang.String mes;
	/**
	 * Implementation field for persistent attribute: tiido_cam_oficina_fk_cod_ofic
	 */
	public java.lang.String tiido_cam_oficina_fk_cod_ofic;
	/**
	 * Implementation field for persistent attribute: tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr;
	/**
	 * Creates an empty key for Entity Bean: Tiido_campanias
	 */
	public Tiido_campaniasKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_campanias
	 */
	public Tiido_campaniasKey(
		java.lang.Integer cod_camp,
		java.lang.String anho,
		java.lang.String mes,
		entities.Tiido_oficinaKey argTiido_cam_oficina_fk) {
		this.cod_camp = cod_camp;
		this.anho = anho;
		this.mes = mes;
		privateSetTiido_cam_oficina_fkKey(argTiido_cam_oficina_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_campaniasKey) {
			entities.Tiido_campaniasKey o = (entities.Tiido_campaniasKey) otherKey;
			return ((this.cod_camp.equals(o.cod_camp))
				&& (this.anho.equals(o.anho))
				&& (this.mes.equals(o.mes))
				&& (this.tiido_cam_oficina_fk_cod_ofic
					.equals(o.tiido_cam_oficina_fk_cod_ofic)) && (this.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
				.equals(o.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_camp.hashCode()
			+ anho.hashCode()
			+ mes.hashCode()
			+ tiido_cam_oficina_fk_cod_ofic.hashCode() + tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_camp
	 */
	public java.lang.Integer getCod_camp() {
		return cod_camp;
	}
	/**
	 * Set accessor for persistent attribute: cod_camp
	 */
	public void setCod_camp(java.lang.Integer newCod_camp) {
		cod_camp = newCod_camp;
	}
	/**
	 * Get accessor for persistent attribute: anho
	 */
	public java.lang.String getAnho() {
		return anho;
	}
	/**
	 * Set accessor for persistent attribute: anho
	 */
	public void setAnho(java.lang.String newAnho) {
		anho = newAnho;
	}
	/**
	 * Get accessor for persistent attribute: mes
	 */
	public java.lang.String getMes() {
		return mes;
	}
	/**
	 * Set accessor for persistent attribute: mes
	 */
	public void setMes(java.lang.String newMes) {
		mes = newMes;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_cam_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaKey getTiido_cam_oficina_fkKey() {
		entities.Tiido_oficinaKey temp = new entities.Tiido_oficinaKey();
		boolean tiido_cam_oficina_fk_NULLTEST = true;
		tiido_cam_oficina_fk_NULLTEST &= (tiido_cam_oficina_fk_cod_ofic == null);
		temp.cod_ofic = tiido_cam_oficina_fk_cod_ofic;
		tiido_cam_oficina_fk_NULLTEST &= (tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr == null);
		temp.tiido_territorio_fk_cod_terr = tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr;
		if (tiido_cam_oficina_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_cam_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_cam_oficina_fkKey(
		entities.Tiido_oficinaKey inKey) {
		boolean tiido_cam_oficina_fk_NULLTEST = (inKey == null);
		tiido_cam_oficina_fk_cod_ofic = (tiido_cam_oficina_fk_NULLTEST)
			? null
			: inKey.cod_ofic;
		tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr = (tiido_cam_oficina_fk_NULLTEST)
			? null
			: inKey.tiido_territorio_fk_cod_terr;
	}
}
