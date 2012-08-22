package entities;
/**
 * Key class for Entity Bean: Tiido_planes
 */
public class Tiido_planesKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: mes_plan
	 */
	public java.lang.String mes_plan;
	/**
	 * Implementation field for persistent attribute: anho_plan
	 */
	public java.lang.String anho_plan;
	/**
	 * Implementation field for persistent attribute: cod_epigrafe
	 */
	public java.lang.String cod_epigrafe;
	/**
	 * Implementation field for persistent attribute: tiido_pla_oficina_fk_cod_ofic
	 */
	public java.lang.String tiido_pla_oficina_fk_cod_ofic;
	/**
	 * Implementation field for persistent attribute: tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr;
	/**
	 * Creates an empty key for Entity Bean: Tiido_planes
	 */
	public Tiido_planesKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_planes
	 */
	public Tiido_planesKey(
		java.lang.String mes_plan,
		java.lang.String anho_plan,
		java.lang.String cod_epigrafe,
		entities.Tiido_oficinaKey argTiido_pla_oficina_fk) {
		this.mes_plan = mes_plan;
		this.anho_plan = anho_plan;
		this.cod_epigrafe = cod_epigrafe;
		privateSetTiido_pla_oficina_fkKey(argTiido_pla_oficina_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_planesKey) {
			entities.Tiido_planesKey o = (entities.Tiido_planesKey) otherKey;
			return ((this.mes_plan.equals(o.mes_plan))
				&& (this.anho_plan.equals(o.anho_plan))
				&& (this.cod_epigrafe.equals(o.cod_epigrafe))
				&& (this.tiido_pla_oficina_fk_cod_ofic
					.equals(o.tiido_pla_oficina_fk_cod_ofic)) && (this.tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr
				.equals(o.tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (mes_plan.hashCode()
			+ anho_plan.hashCode()
			+ cod_epigrafe.hashCode()
			+ tiido_pla_oficina_fk_cod_ofic.hashCode() + tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: mes_plan
	 */
	public java.lang.String getMes_plan() {
		return mes_plan;
	}
	/**
	 * Set accessor for persistent attribute: mes_plan
	 */
	public void setMes_plan(java.lang.String newMes_plan) {
		mes_plan = newMes_plan;
	}
	/**
	 * Get accessor for persistent attribute: anho_plan
	 */
	public java.lang.String getAnho_plan() {
		return anho_plan;
	}
	/**
	 * Set accessor for persistent attribute: anho_plan
	 */
	public void setAnho_plan(java.lang.String newAnho_plan) {
		anho_plan = newAnho_plan;
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
	 * This method was generated for supporting the relationship role named tiido_pla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaKey getTiido_pla_oficina_fkKey() {
		entities.Tiido_oficinaKey temp = new entities.Tiido_oficinaKey();
		boolean tiido_pla_oficina_fk_NULLTEST = true;
		tiido_pla_oficina_fk_NULLTEST &= (tiido_pla_oficina_fk_cod_ofic == null);
		temp.cod_ofic = tiido_pla_oficina_fk_cod_ofic;
		tiido_pla_oficina_fk_NULLTEST &= (tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr == null);
		temp.tiido_territorio_fk_cod_terr = tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr;
		if (tiido_pla_oficina_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_pla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_pla_oficina_fkKey(
		entities.Tiido_oficinaKey inKey) {
		boolean tiido_pla_oficina_fk_NULLTEST = (inKey == null);
		tiido_pla_oficina_fk_cod_ofic = (tiido_pla_oficina_fk_NULLTEST)
			? null
			: inKey.cod_ofic;
		tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr = (tiido_pla_oficina_fk_NULLTEST)
			? null
			: inKey.tiido_territorio_fk_cod_terr;
	}
}
