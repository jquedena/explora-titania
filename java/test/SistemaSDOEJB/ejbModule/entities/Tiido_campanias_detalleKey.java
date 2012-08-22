package entities;
/**
 * Key class for Entity Bean: Tiido_campanias_detalle
 */
public class Tiido_campanias_detalleKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_camp_deta
	 */
	public java.lang.Integer cod_camp_deta;
	/**
	 * Implementation field for persistent attribute: tiido_camdet_campanias_fk_cod_camp
	 */
	public java.lang.Integer tiido_camdet_campanias_fk_cod_camp;
	/**
	 * Implementation field for persistent attribute: tiido_camdet_campanias_fk_anho
	 */
	public java.lang.String tiido_camdet_campanias_fk_anho;
	/**
	 * Implementation field for persistent attribute: tiido_camdet_campanias_fk_mes
	 */
	public java.lang.String tiido_camdet_campanias_fk_mes;
	/**
	 * Implementation field for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic
	 */
	public java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic;
	/**
	 * Implementation field for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr;
	/**
	 * Creates an empty key for Entity Bean: Tiido_campanias_detalle
	 */
	public Tiido_campanias_detalleKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_campanias_detalle
	 */
	public Tiido_campanias_detalleKey(
		java.lang.Integer cod_camp_deta,
		entities.Tiido_campaniasKey argTiido_camdet_campanias_fk) {
		this.cod_camp_deta = cod_camp_deta;
		privateSetTiido_camdet_campanias_fkKey(argTiido_camdet_campanias_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_campanias_detalleKey) {
			entities.Tiido_campanias_detalleKey o = (entities.Tiido_campanias_detalleKey) otherKey;
			return ((this.cod_camp_deta.equals(o.cod_camp_deta))
				&& (this.tiido_camdet_campanias_fk_cod_camp
					.equals(o.tiido_camdet_campanias_fk_cod_camp))
				&& (this.tiido_camdet_campanias_fk_anho
					.equals(o.tiido_camdet_campanias_fk_anho))
				&& (this.tiido_camdet_campanias_fk_mes
					.equals(o.tiido_camdet_campanias_fk_mes))
				&& (this.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic
					.equals(o.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic)) && (this.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
				.equals(o.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_camp_deta.hashCode()
			+ tiido_camdet_campanias_fk_cod_camp.hashCode()
			+ tiido_camdet_campanias_fk_anho.hashCode()
			+ tiido_camdet_campanias_fk_mes.hashCode()
			+ tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic
				.hashCode() + tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_camp_deta
	 */
	public java.lang.Integer getCod_camp_deta() {
		return cod_camp_deta;
	}
	/**
	 * Set accessor for persistent attribute: cod_camp_deta
	 */
	public void setCod_camp_deta(java.lang.Integer newCod_camp_deta) {
		cod_camp_deta = newCod_camp_deta;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_camdet_campanias_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_campaniasKey getTiido_camdet_campanias_fkKey() {
		entities.Tiido_campaniasKey temp = new entities.Tiido_campaniasKey();
		boolean tiido_camdet_campanias_fk_NULLTEST = true;
		tiido_camdet_campanias_fk_NULLTEST &= (tiido_camdet_campanias_fk_cod_camp == null);
		temp.cod_camp = tiido_camdet_campanias_fk_cod_camp;
		tiido_camdet_campanias_fk_NULLTEST &= (tiido_camdet_campanias_fk_anho == null);
		temp.anho = tiido_camdet_campanias_fk_anho;
		tiido_camdet_campanias_fk_NULLTEST &= (tiido_camdet_campanias_fk_mes == null);
		temp.mes = tiido_camdet_campanias_fk_mes;
		tiido_camdet_campanias_fk_NULLTEST &= (tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic == null);
		temp.tiido_cam_oficina_fk_cod_ofic = tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic;
		tiido_camdet_campanias_fk_NULLTEST &= (tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr == null);
		temp.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr = tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr;
		if (tiido_camdet_campanias_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_camdet_campanias_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_camdet_campanias_fkKey(
		entities.Tiido_campaniasKey inKey) {
		boolean tiido_camdet_campanias_fk_NULLTEST = (inKey == null);
		tiido_camdet_campanias_fk_cod_camp = (tiido_camdet_campanias_fk_NULLTEST)
			? null
			: inKey.cod_camp;
		tiido_camdet_campanias_fk_anho = (tiido_camdet_campanias_fk_NULLTEST)
			? null
			: inKey.anho;
		tiido_camdet_campanias_fk_mes = (tiido_camdet_campanias_fk_NULLTEST)
			? null
			: inKey.mes;
		tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic = (tiido_camdet_campanias_fk_NULLTEST)
			? null
			: inKey.tiido_cam_oficina_fk_cod_ofic;
		tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr = (tiido_camdet_campanias_fk_NULLTEST)
			? null
			: inKey.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr;
	}
}
