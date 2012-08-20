package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_territorio
 */
public class Tiilc_territorioKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_territorio
	 */
	public java.lang.String cod_territorio;
	/**
	 * Implementation field for persistent attribute: tiilc_area_fk_cod_area
	 */
	public java.lang.String tiilc_area_fk_cod_area;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_territorio
	 */
	public Tiilc_territorioKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_territorio
	 */
	public Tiilc_territorioKey(
		java.lang.String cod_territorio,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey argTiilc_area_fk) {
		this.cod_territorio = cod_territorio;
		privateSetTiilc_area_fkKey(argTiilc_area_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey) otherKey;
			return ((this.cod_territorio.equals(o.cod_territorio)) && (this.tiilc_area_fk_cod_area
				.equals(o.tiilc_area_fk_cod_area)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_territorio.hashCode() + tiilc_area_fk_cod_area.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_territorio
	 */
	public java.lang.String getCod_territorio() {
		return cod_territorio;
	}
	/**
	 * Set accessor for persistent attribute: cod_territorio
	 */
	public void setCod_territorio(java.lang.String newCod_territorio) {
		cod_territorio = newCod_territorio;
	}
	/**
	 * This method was generated for supporting the relationship role named tiilc_area_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey getTiilc_area_fkKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey temp = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey();
		boolean tiilc_area_fk_NULLTEST = true;
		tiilc_area_fk_NULLTEST &= (tiilc_area_fk_cod_area == null);
		temp.cod_area = tiilc_area_fk_cod_area;
		if (tiilc_area_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiilc_area_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiilc_area_fkKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey inKey) {
		boolean tiilc_area_fk_NULLTEST = (inKey == null);
		tiilc_area_fk_cod_area = (tiilc_area_fk_NULLTEST)
			? null
			: inKey.cod_area;
	}
}
