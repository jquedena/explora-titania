package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_permiso_perfil
 */
public class Tiilc_permiso_perfilKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_perfil
	 */
	public java.lang.String cod_perfil;
	/**
	 * Implementation field for persistent attribute: tipo_acceso
	 */
	public java.math.BigDecimal tipo_acceso;
	/**
	 * Implementation field for persistent attribute: valor_rcp
	 */
	public java.lang.String valor_rcp;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_permiso_perfil
	 */
	public Tiilc_permiso_perfilKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_permiso_perfil
	 */
	public Tiilc_permiso_perfilKey(
		java.lang.String cod_perfil,
		java.math.BigDecimal tipo_acceso,
		java.lang.String valor_rcp) {
		this.cod_perfil = cod_perfil;
		this.tipo_acceso = tipo_acceso;
		this.valor_rcp = valor_rcp;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey) otherKey;
			return ((this.cod_perfil.equals(o.cod_perfil))
				&& (this.tipo_acceso.equals(o.tipo_acceso)) && (this.valor_rcp
				.equals(o.valor_rcp)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_perfil.hashCode() + tipo_acceso.hashCode() + valor_rcp
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_perfil
	 */
	public java.lang.String getCod_perfil() {
		return cod_perfil;
	}
	/**
	 * Set accessor for persistent attribute: cod_perfil
	 */
	public void setCod_perfil(java.lang.String newCod_perfil) {
		cod_perfil = newCod_perfil;
	}
	/**
	 * Get accessor for persistent attribute: tipo_acceso
	 */
	public java.math.BigDecimal getTipo_acceso() {
		return tipo_acceso;
	}
	/**
	 * Set accessor for persistent attribute: tipo_acceso
	 */
	public void setTipo_acceso(java.math.BigDecimal newTipo_acceso) {
		tipo_acceso = newTipo_acceso;
	}
	/**
	 * Get accessor for persistent attribute: valor_rcp
	 */
	public java.lang.String getValor_rcp() {
		return valor_rcp;
	}
	/**
	 * Set accessor for persistent attribute: valor_rcp
	 */
	public void setValor_rcp(java.lang.String newValor_rcp) {
		valor_rcp = newValor_rcp;
	}
}
