package entities;
/**
 * Key class for Entity Bean: Tiido_multitabla
 */
public class Tiido_multitablaKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_mult
	 */
	public java.lang.String cod_mult;
	/**
	 * Implementation field for persistent attribute: cod_elem
	 */
	public java.lang.String cod_elem;
	/**
	 * Creates an empty key for Entity Bean: Tiido_multitabla
	 */
	public Tiido_multitablaKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_multitabla
	 */
	public Tiido_multitablaKey(
		java.lang.String cod_mult,
		java.lang.String cod_elem) {
		this.cod_mult = cod_mult;
		this.cod_elem = cod_elem;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_multitablaKey) {
			entities.Tiido_multitablaKey o = (entities.Tiido_multitablaKey) otherKey;
			return ((this.cod_mult.equals(o.cod_mult)) && (this.cod_elem
				.equals(o.cod_elem)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_mult.hashCode() + cod_elem.hashCode());
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
	 * Get accessor for persistent attribute: cod_elem
	 */
	public java.lang.String getCod_elem() {
		return cod_elem;
	}
	/**
	 * Set accessor for persistent attribute: cod_elem
	 */
	public void setCod_elem(java.lang.String newCod_elem) {
		cod_elem = newCod_elem;
	}
}
