package entities;
/**
 * Key class for Entity Bean: Tiido_menu
 */
public class Tiido_menuKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: padre
	 */
	public java.lang.String padre;
	/**
	 * Creates an empty key for Entity Bean: Tiido_menu
	 */
	public Tiido_menuKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_menu
	 */
	public Tiido_menuKey(java.lang.String padre) {
		this.padre = padre;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_menuKey) {
			entities.Tiido_menuKey o = (entities.Tiido_menuKey) otherKey;
			return ((this.padre.equals(o.padre)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (padre.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: padre
	 */
	public java.lang.String getPadre() {
		return padre;
	}
	/**
	 * Set accessor for persistent attribute: padre
	 */
	public void setPadre(java.lang.String newPadre) {
		padre = newPadre;
	}
}
