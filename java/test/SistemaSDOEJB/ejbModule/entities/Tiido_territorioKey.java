package entities;
/**
 * Key class for Entity Bean: Tiido_territorio
 */
public class Tiido_territorioKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_terr
	 */
	public java.lang.String cod_terr;
	/**
	 * Creates an empty key for Entity Bean: Tiido_territorio
	 */
	public Tiido_territorioKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_territorio
	 */
	public Tiido_territorioKey(java.lang.String cod_terr) {
		this.cod_terr = cod_terr;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_territorioKey) {
			entities.Tiido_territorioKey o = (entities.Tiido_territorioKey) otherKey;
			return ((this.cod_terr.equals(o.cod_terr)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_terr.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_terr
	 */
	public java.lang.String getCod_terr() {
		return cod_terr;
	}
	/**
	 * Set accessor for persistent attribute: cod_terr
	 */
	public void setCod_terr(java.lang.String newCod_terr) {
		cod_terr = newCod_terr;
	}
}
