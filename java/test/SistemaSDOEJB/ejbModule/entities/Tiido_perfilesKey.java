package entities;
/**
 * Key class for Entity Bean: Tiido_perfiles
 */
public class Tiido_perfilesKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_perfil
	 */
	public java.lang.String cod_perfil;
	/**
	 * Creates an empty key for Entity Bean: Tiido_perfiles
	 */
	public Tiido_perfilesKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_perfiles
	 */
	public Tiido_perfilesKey(java.lang.String cod_perfil) {
		this.cod_perfil = cod_perfil;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_perfilesKey) {
			entities.Tiido_perfilesKey o = (entities.Tiido_perfilesKey) otherKey;
			return ((this.cod_perfil.equals(o.cod_perfil)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_perfil.hashCode());
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
}
