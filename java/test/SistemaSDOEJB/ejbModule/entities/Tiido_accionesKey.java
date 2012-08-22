package entities;
/**
 * Key class for Entity Bean: Tiido_acciones
 */
public class Tiido_accionesKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_acci
	 */
	public java.lang.Integer cod_acci;
	/**
	 * Implementation field for persistent attribute: tiido_acc_epigrafe_fk_cod_epigrafe
	 */
	public java.lang.String tiido_acc_epigrafe_fk_cod_epigrafe;
	/**
	 * Implementation field for persistent attribute: tiido_acc_epigrafe_fk_anho
	 */
	public java.lang.String tiido_acc_epigrafe_fk_anho;
	/**
	 * Implementation field for persistent attribute: tiido_acc_oficina_fk_cod_ofic
	 */
	public java.lang.String tiido_acc_oficina_fk_cod_ofic;
	/**
	 * Implementation field for persistent attribute: tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr;
	/**
	 * Creates an empty key for Entity Bean: Tiido_acciones
	 */
	public Tiido_accionesKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_acciones
	 */
	public Tiido_accionesKey(
		java.lang.Integer cod_acci,
		entities.Tiido_epigrafeKey argTiido_acc_epigrafe_fk,
		entities.Tiido_oficinaKey argTiido_acc_oficina_fk) {
		this.cod_acci = cod_acci;
		privateSetTiido_acc_epigrafe_fkKey(argTiido_acc_epigrafe_fk);
		privateSetTiido_acc_oficina_fkKey(argTiido_acc_oficina_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_accionesKey) {
			entities.Tiido_accionesKey o = (entities.Tiido_accionesKey) otherKey;
			return ((this.cod_acci.equals(o.cod_acci))
				&& (this.tiido_acc_epigrafe_fk_cod_epigrafe
					.equals(o.tiido_acc_epigrafe_fk_cod_epigrafe))
				&& (this.tiido_acc_epigrafe_fk_anho
					.equals(o.tiido_acc_epigrafe_fk_anho))
				&& (this.tiido_acc_oficina_fk_cod_ofic
					.equals(o.tiido_acc_oficina_fk_cod_ofic)) && (this.tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr
				.equals(o.tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_acci.hashCode()
			+ tiido_acc_epigrafe_fk_cod_epigrafe.hashCode()
			+ tiido_acc_epigrafe_fk_anho.hashCode()
			+ tiido_acc_oficina_fk_cod_ofic.hashCode() + tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_acci
	 */
	public java.lang.Integer getCod_acci() {
		return cod_acci;
	}
	/**
	 * Set accessor for persistent attribute: cod_acci
	 */
	public void setCod_acci(java.lang.Integer newCod_acci) {
		cod_acci = newCod_acci;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_acc_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_epigrafeKey getTiido_acc_epigrafe_fkKey() {
		entities.Tiido_epigrafeKey temp = new entities.Tiido_epigrafeKey();
		boolean tiido_acc_epigrafe_fk_NULLTEST = true;
		tiido_acc_epigrafe_fk_NULLTEST &= (tiido_acc_epigrafe_fk_cod_epigrafe == null);
		temp.cod_epigrafe = tiido_acc_epigrafe_fk_cod_epigrafe;
		tiido_acc_epigrafe_fk_NULLTEST &= (tiido_acc_epigrafe_fk_anho == null);
		temp.anho = tiido_acc_epigrafe_fk_anho;
		if (tiido_acc_epigrafe_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_acc_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_acc_epigrafe_fkKey(
		entities.Tiido_epigrafeKey inKey) {
		boolean tiido_acc_epigrafe_fk_NULLTEST = (inKey == null);
		tiido_acc_epigrafe_fk_cod_epigrafe = (tiido_acc_epigrafe_fk_NULLTEST)
			? null
			: inKey.cod_epigrafe;
		tiido_acc_epigrafe_fk_anho = (tiido_acc_epigrafe_fk_NULLTEST)
			? null
			: inKey.anho;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_acc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaKey getTiido_acc_oficina_fkKey() {
		entities.Tiido_oficinaKey temp = new entities.Tiido_oficinaKey();
		boolean tiido_acc_oficina_fk_NULLTEST = true;
		tiido_acc_oficina_fk_NULLTEST &= (tiido_acc_oficina_fk_cod_ofic == null);
		temp.cod_ofic = tiido_acc_oficina_fk_cod_ofic;
		tiido_acc_oficina_fk_NULLTEST &= (tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr == null);
		temp.tiido_territorio_fk_cod_terr = tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr;
		if (tiido_acc_oficina_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_acc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_acc_oficina_fkKey(
		entities.Tiido_oficinaKey inKey) {
		boolean tiido_acc_oficina_fk_NULLTEST = (inKey == null);
		tiido_acc_oficina_fk_cod_ofic = (tiido_acc_oficina_fk_NULLTEST)
			? null
			: inKey.cod_ofic;
		tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr = (tiido_acc_oficina_fk_NULLTEST)
			? null
			: inKey.tiido_territorio_fk_cod_terr;
	}
}
