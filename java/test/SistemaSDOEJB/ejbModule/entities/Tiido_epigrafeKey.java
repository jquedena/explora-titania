package entities;
/**
 * Key class for Entity Bean: Tiido_epigrafe
 */
public class Tiido_epigrafeKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_epigrafe
	 */
	public java.lang.String cod_epigrafe;
	/**
	 * Implementation field for persistent attribute: anho
	 */
	public java.lang.String anho;
	/**
	 * Creates an empty key for Entity Bean: Tiido_epigrafe
	 */
	public Tiido_epigrafeKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_epigrafe
	 */
	public Tiido_epigrafeKey(
		java.lang.String cod_epigrafe,
		java.lang.String anho) {
		this.cod_epigrafe = cod_epigrafe;
		this.anho = anho;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_epigrafeKey) {
			entities.Tiido_epigrafeKey o = (entities.Tiido_epigrafeKey) otherKey;
			return ((this.cod_epigrafe.equals(o.cod_epigrafe)) && (this.anho
				.equals(o.anho)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_epigrafe.hashCode() + anho.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_epigrafe
	 */
	public java.lang.String getCod_epigrafe() {
		return cod_epigrafe;
	}
	/**
	 * Set accessor for persistent attribute: cod_epigrafe
	 */
	public void setCod_epigrafe(java.lang.String newCod_epigrafe) {
		cod_epigrafe = newCod_epigrafe;
	}
	/**
	 * Get accessor for persistent attribute: anho
	 */
	public java.lang.String getAnho() {
		return anho;
	}
	/**
	 * Set accessor for persistent attribute: anho
	 */
	public void setAnho(java.lang.String newAnho) {
		anho = newAnho;
	}
}
