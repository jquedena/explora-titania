package entities;
/**
 * Key class for Entity Bean: Tiido_equivalencias
 */
public class Tiido_equivalenciasKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_car
	 */
	public java.lang.String cod_car;
	/**
	 * Creates an empty key for Entity Bean: Tiido_equivalencias
	 */
	public Tiido_equivalenciasKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_equivalencias
	 */
	public Tiido_equivalenciasKey(java.lang.String cod_car) {
		this.cod_car = cod_car;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_equivalenciasKey) {
			entities.Tiido_equivalenciasKey o = (entities.Tiido_equivalenciasKey) otherKey;
			return ((this.cod_car.equals(o.cod_car)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_car.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_car
	 */
	public java.lang.String getCod_car() {
		return cod_car;
	}
	/**
	 * Set accessor for persistent attribute: cod_car
	 */
	public void setCod_car(java.lang.String newCod_car) {
		cod_car = newCod_car;
	}
}
