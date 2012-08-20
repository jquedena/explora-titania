package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_total
 */
public class Tiilc_totalKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_total
	 */
	public java.math.BigDecimal cod_total;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_total
	 */
	public Tiilc_totalKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_total
	 */
	public Tiilc_totalKey(java.math.BigDecimal cod_total) {
		this.cod_total = cod_total;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey) otherKey;
			return ((this.cod_total.equals(o.cod_total)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_total.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_total
	 */
	public java.math.BigDecimal getCod_total() {
		return cod_total;
	}
	/**
	 * Set accessor for persistent attribute: cod_total
	 */
	public void setCod_total(java.math.BigDecimal newCod_total) {
		cod_total = newCod_total;
	}
}
