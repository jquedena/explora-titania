package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_multitabla
 */
public class Tiilc_multitablaKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_mult
	 */
	public java.lang.String cod_mult;
	/**
	 * Implementation field for persistent attribute: cod_ele
	 */
	public java.lang.String cod_ele;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_multitabla
	 */
	public Tiilc_multitablaKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_multitabla
	 */
	public Tiilc_multitablaKey(
		java.lang.String cod_mult,
		java.lang.String cod_ele) {
		this.cod_mult = cod_mult;
		this.cod_ele = cod_ele;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey) otherKey;
			return ((this.cod_mult.equals(o.cod_mult)) && (this.cod_ele
				.equals(o.cod_ele)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_mult.hashCode() + cod_ele.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_mult
	 */
	public java.lang.String getCod_mult() {
		return cod_mult;
	}
	/**
	 * Set accessor for persistent attribute: cod_mult
	 */
	public void setCod_mult(java.lang.String newCod_mult) {
		cod_mult = newCod_mult;
	}
	/**
	 * Get accessor for persistent attribute: cod_ele
	 */
	public java.lang.String getCod_ele() {
		return cod_ele;
	}
	/**
	 * Set accessor for persistent attribute: cod_ele
	 */
	public void setCod_ele(java.lang.String newCod_ele) {
		cod_ele = newCod_ele;
	}
}
