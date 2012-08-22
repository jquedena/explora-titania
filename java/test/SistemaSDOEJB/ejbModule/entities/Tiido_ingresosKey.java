package entities;
/**
 * Key class for Entity Bean: Tiido_ingresos
 */
public class Tiido_ingresosKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: id_ingresos
	 */
	public java.math.BigDecimal id_ingresos;
	/**
	 * Creates an empty key for Entity Bean: Tiido_ingresos
	 */
	public Tiido_ingresosKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_ingresos
	 */
	public Tiido_ingresosKey(java.math.BigDecimal id_ingresos) {
		this.id_ingresos = id_ingresos;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_ingresosKey) {
			entities.Tiido_ingresosKey o = (entities.Tiido_ingresosKey) otherKey;
			return ((this.id_ingresos.equals(o.id_ingresos)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (id_ingresos.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: id_ingresos
	 */
	public java.math.BigDecimal getId_ingresos() {
		return id_ingresos;
	}
	/**
	 * Set accessor for persistent attribute: id_ingresos
	 */
	public void setId_ingresos(java.math.BigDecimal newId_ingresos) {
		id_ingresos = newId_ingresos;
	}
}
