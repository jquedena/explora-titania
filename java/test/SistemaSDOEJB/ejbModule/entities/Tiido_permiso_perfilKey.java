package entities;
/**
 * Key class for Entity Bean: Tiido_permiso_perfil
 */
public class Tiido_permiso_perfilKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_perfil
	 */
	public java.lang.String cod_perfil;
	/**
	 * Implementation field for persistent attribute: tip_acceso
	 */
	public java.lang.String tip_acceso;
	/**
	 * Implementation field for persistent attribute: valor_rcp
	 */
	public java.lang.String valor_rcp;
	/**
	 * Creates an empty key for Entity Bean: Tiido_permiso_perfil
	 */
	public Tiido_permiso_perfilKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_permiso_perfil
	 */
	public Tiido_permiso_perfilKey(
		java.lang.String cod_perfil,
		java.lang.String tip_acceso,
		java.lang.String valor_rcp) {
		this.cod_perfil = cod_perfil;
		this.tip_acceso = tip_acceso;
		this.valor_rcp = valor_rcp;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_permiso_perfilKey) {
			entities.Tiido_permiso_perfilKey o = (entities.Tiido_permiso_perfilKey) otherKey;
			return ((this.cod_perfil.equals(o.cod_perfil))
				&& (this.tip_acceso.equals(o.tip_acceso)) && (this.valor_rcp
				.equals(o.valor_rcp)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_perfil.hashCode() + tip_acceso.hashCode() + valor_rcp
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
	 * Get accessor for persistent attribute: tip_acceso
	 */
	public java.lang.String getTip_acceso() {
		return tip_acceso;
	}
	/**
	 * Set accessor for persistent attribute: tip_acceso
	 */
	public void setTip_acceso(java.lang.String newTip_acceso) {
		tip_acceso = newTip_acceso;
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
