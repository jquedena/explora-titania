package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_cliente
 */
public class Tiilc_clienteKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_cliente
	 */
	public java.math.BigDecimal cod_cliente;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_cliente
	 */
	public Tiilc_clienteKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_cliente
	 */
	public Tiilc_clienteKey(java.math.BigDecimal cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey) otherKey;
			return ((this.cod_cliente.equals(o.cod_cliente)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_cliente.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_cliente
	 */
	public java.math.BigDecimal getCod_cliente() {
		return cod_cliente;
	}
	/**
	 * Set accessor for persistent attribute: cod_cliente
	 */
	public void setCod_cliente(java.math.BigDecimal newCod_cliente) {
		cod_cliente = newCod_cliente;
	}
}
