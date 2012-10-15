package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_area
 */
public class Tiilc_areaKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_area
	 */
	public java.lang.String cod_area;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_area
	 */
	public Tiilc_areaKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_area
	 */
	public Tiilc_areaKey(java.lang.String cod_area) {
		this.cod_area = cod_area;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey) otherKey;
			return ((this.cod_area.equals(o.cod_area)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_area.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_area
	 */
	public java.lang.String getCod_area() {
		return cod_area;
	}
	/**
	 * Set accessor for persistent attribute: cod_area
	 */
	public void setCod_area(java.lang.String newCod_area) {
		cod_area = newCod_area;
	}
}
