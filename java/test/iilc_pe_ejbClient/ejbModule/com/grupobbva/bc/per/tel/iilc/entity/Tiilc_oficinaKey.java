package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_oficina
 */
public class Tiilc_oficinaKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_oficina
	 */
	public java.lang.String cod_oficina;
	/**
	 * Implementation field for persistent attribute: tiilc_territorio_fk_cod_territorio
	 */
	public java.lang.String tiilc_territorio_fk_cod_territorio;
	/**
	 * Implementation field for persistent attribute: tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_oficina
	 */
	public Tiilc_oficinaKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_oficina
	 */
	public Tiilc_oficinaKey(
		java.lang.String cod_oficina,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey argTiilc_territorio_fk) {
		this.cod_oficina = cod_oficina;
		privateSetTiilc_territorio_fkKey(argTiilc_territorio_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey) otherKey;
			return ((this.cod_oficina.equals(o.cod_oficina))
				&& (this.tiilc_territorio_fk_cod_territorio
					.equals(o.tiilc_territorio_fk_cod_territorio)) && (this.tiilc_territorio_fk_tiilc_area_fk_cod_area
				.equals(o.tiilc_territorio_fk_tiilc_area_fk_cod_area)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_oficina.hashCode()
			+ tiilc_territorio_fk_cod_territorio.hashCode() + tiilc_territorio_fk_tiilc_area_fk_cod_area
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_oficina
	 */
	public java.lang.String getCod_oficina() {
		return cod_oficina;
	}
	/**
	 * Set accessor for persistent attribute: cod_oficina
	 */
	public void setCod_oficina(java.lang.String newCod_oficina) {
		cod_oficina = newCod_oficina;
	}
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey getTiilc_territorio_fkKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey temp = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey();
		boolean tiilc_territorio_fk_NULLTEST = true;
		tiilc_territorio_fk_NULLTEST &= (tiilc_territorio_fk_cod_territorio == null);
		temp.cod_territorio = tiilc_territorio_fk_cod_territorio;
		tiilc_territorio_fk_NULLTEST &= (tiilc_territorio_fk_tiilc_area_fk_cod_area == null);
		temp.tiilc_area_fk_cod_area = tiilc_territorio_fk_tiilc_area_fk_cod_area;
		if (tiilc_territorio_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiilc_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiilc_territorio_fkKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey inKey) {
		boolean tiilc_territorio_fk_NULLTEST = (inKey == null);
		tiilc_territorio_fk_cod_territorio = (tiilc_territorio_fk_NULLTEST)
			? null
			: inKey.cod_territorio;
		tiilc_territorio_fk_tiilc_area_fk_cod_area = (tiilc_territorio_fk_NULLTEST)
			? null
			: inKey.tiilc_area_fk_cod_area;
	}
}
