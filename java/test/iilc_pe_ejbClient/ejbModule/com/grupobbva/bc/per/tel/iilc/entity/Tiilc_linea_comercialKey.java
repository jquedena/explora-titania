package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_linea_comercial
 */
public class Tiilc_linea_comercialKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_grupo
	 */
	public java.lang.String cod_grupo;
	/**
	 * Implementation field for persistent attribute: cod_lincom
	 */
	public java.lang.String cod_lincom;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_linea_comercial
	 */
	public Tiilc_linea_comercialKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_linea_comercial
	 */
	public Tiilc_linea_comercialKey(
		java.lang.String cod_grupo,
		java.lang.String cod_lincom) {
		this.cod_grupo = cod_grupo;
		this.cod_lincom = cod_lincom;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey) otherKey;
			return ((this.cod_grupo.equals(o.cod_grupo)) && (this.cod_lincom
				.equals(o.cod_lincom)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_grupo.hashCode() + cod_lincom.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_grupo
	 */
	public java.lang.String getCod_grupo() {
		return cod_grupo;
	}
	/**
	 * Set accessor for persistent attribute: cod_grupo
	 */
	public void setCod_grupo(java.lang.String newCod_grupo) {
		cod_grupo = newCod_grupo;
	}
	/**
	 * Get accessor for persistent attribute: cod_lincom
	 */
	public java.lang.String getCod_lincom() {
		return cod_lincom;
	}
	/**
	 * Set accessor for persistent attribute: cod_lincom
	 */
	public void setCod_lincom(java.lang.String newCod_lincom) {
		cod_lincom = newCod_lincom;
	}
}
