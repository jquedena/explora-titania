package entities;
/**
 * Key class for Entity Bean: Tiido_metas_gestor
 */
public class Tiido_metas_gestorKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_meta_gestor
	 */
	public java.lang.String cod_meta_gestor;
	/**
	 * Implementation field for persistent attribute: tiido_metges_epigrafe_fk_cod_epigrafe
	 */
	public java.lang.String tiido_metges_epigrafe_fk_cod_epigrafe;
	/**
	 * Implementation field for persistent attribute: tiido_metges_epigrafe_fk_anho
	 */
	public java.lang.String tiido_metges_epigrafe_fk_anho;
	/**
	 * Implementation field for persistent attribute: tiido_metges_oficina_fk_cod_ofic
	 */
	public java.lang.String tiido_metges_oficina_fk_cod_ofic;
	/**
	 * Implementation field for persistent attribute: tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr;
	/**
	 * Creates an empty key for Entity Bean: Tiido_metas_gestor
	 */
	public Tiido_metas_gestorKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_metas_gestor
	 */
	public Tiido_metas_gestorKey(
		java.lang.String cod_meta_gestor,
		entities.Tiido_epigrafeKey argTiido_metges_epigrafe_fk,
		entities.Tiido_oficinaKey argTiido_metges_oficina_fk) {
		this.cod_meta_gestor = cod_meta_gestor;
		privateSetTiido_metges_epigrafe_fkKey(argTiido_metges_epigrafe_fk);
		privateSetTiido_metges_oficina_fkKey(argTiido_metges_oficina_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_metas_gestorKey) {
			entities.Tiido_metas_gestorKey o = (entities.Tiido_metas_gestorKey) otherKey;
			return ((this.cod_meta_gestor.equals(o.cod_meta_gestor))
				&& (this.tiido_metges_epigrafe_fk_cod_epigrafe
					.equals(o.tiido_metges_epigrafe_fk_cod_epigrafe))
				&& (this.tiido_metges_epigrafe_fk_anho
					.equals(o.tiido_metges_epigrafe_fk_anho))
				&& (this.tiido_metges_oficina_fk_cod_ofic
					.equals(o.tiido_metges_oficina_fk_cod_ofic)) && (this.tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr
				.equals(o.tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_meta_gestor.hashCode()
			+ tiido_metges_epigrafe_fk_cod_epigrafe.hashCode()
			+ tiido_metges_epigrafe_fk_anho.hashCode()
			+ tiido_metges_oficina_fk_cod_ofic.hashCode() + tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_meta_gestor
	 */
	public java.lang.String getCod_meta_gestor() {
		return cod_meta_gestor;
	}
	/**
	 * Set accessor for persistent attribute: cod_meta_gestor
	 */
	public void setCod_meta_gestor(java.lang.String newCod_meta_gestor) {
		cod_meta_gestor = newCod_meta_gestor;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_epigrafeKey getTiido_metges_epigrafe_fkKey() {
		entities.Tiido_epigrafeKey temp = new entities.Tiido_epigrafeKey();
		boolean tiido_metges_epigrafe_fk_NULLTEST = true;
		tiido_metges_epigrafe_fk_NULLTEST &= (tiido_metges_epigrafe_fk_cod_epigrafe == null);
		temp.cod_epigrafe = tiido_metges_epigrafe_fk_cod_epigrafe;
		tiido_metges_epigrafe_fk_NULLTEST &= (tiido_metges_epigrafe_fk_anho == null);
		temp.anho = tiido_metges_epigrafe_fk_anho;
		if (tiido_metges_epigrafe_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_metges_epigrafe_fkKey(
		entities.Tiido_epigrafeKey inKey) {
		boolean tiido_metges_epigrafe_fk_NULLTEST = (inKey == null);
		tiido_metges_epigrafe_fk_cod_epigrafe = (tiido_metges_epigrafe_fk_NULLTEST)
			? null
			: inKey.cod_epigrafe;
		tiido_metges_epigrafe_fk_anho = (tiido_metges_epigrafe_fk_NULLTEST)
			? null
			: inKey.anho;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaKey getTiido_metges_oficina_fkKey() {
		entities.Tiido_oficinaKey temp = new entities.Tiido_oficinaKey();
		boolean tiido_metges_oficina_fk_NULLTEST = true;
		tiido_metges_oficina_fk_NULLTEST &= (tiido_metges_oficina_fk_cod_ofic == null);
		temp.cod_ofic = tiido_metges_oficina_fk_cod_ofic;
		tiido_metges_oficina_fk_NULLTEST &= (tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr == null);
		temp.tiido_territorio_fk_cod_terr = tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr;
		if (tiido_metges_oficina_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_metges_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_metges_oficina_fkKey(
		entities.Tiido_oficinaKey inKey) {
		boolean tiido_metges_oficina_fk_NULLTEST = (inKey == null);
		tiido_metges_oficina_fk_cod_ofic = (tiido_metges_oficina_fk_NULLTEST)
			? null
			: inKey.cod_ofic;
		tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr = (tiido_metges_oficina_fk_NULLTEST)
			? null
			: inKey.tiido_territorio_fk_cod_terr;
	}
}
