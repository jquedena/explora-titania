package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_empresa
 */
public class Tiilc_empresaKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_empresa
	 */
	public java.lang.String cod_empresa;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_empresa
	 */
	public Tiilc_empresaKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_empresa
	 */
	public Tiilc_empresaKey(java.lang.String cod_empresa) {
		this.cod_empresa = cod_empresa;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey) otherKey;
			return ((this.cod_empresa.equals(o.cod_empresa)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_empresa.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_empresa
	 */
	public java.lang.String getCod_empresa() {
		return cod_empresa;
	}
	/**
	 * Set accessor for persistent attribute: cod_empresa
	 */
	public void setCod_empresa(java.lang.String newCod_empresa) {
		cod_empresa = newCod_empresa;
	}
}
