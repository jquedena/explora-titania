package entities;
/**
 * Key class for Entity Bean: Tiido_parametros
 */
public class Tiido_parametrosKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_parametro
	 */
	public java.lang.String cod_parametro;
	/**
	 * Creates an empty key for Entity Bean: Tiido_parametros
	 */
	public Tiido_parametrosKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_parametros
	 */
	public Tiido_parametrosKey(java.lang.String cod_parametro) {
		this.cod_parametro = cod_parametro;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_parametrosKey) {
			entities.Tiido_parametrosKey o = (entities.Tiido_parametrosKey) otherKey;
			return ((this.cod_parametro.equals(o.cod_parametro)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_parametro.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_parametro
	 */
	public java.lang.String getCod_parametro() {
		return cod_parametro;
	}
	/**
	 * Set accessor for persistent attribute: cod_parametro
	 */
	public void setCod_parametro(java.lang.String newCod_parametro) {
		cod_parametro = newCod_parametro;
	}
}
