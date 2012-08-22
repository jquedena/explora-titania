package entities;
/**
 * Key class for Entity Bean: Tiido_firmas
 */
public class Tiido_firmasKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_firma
	 */
	public java.lang.String cod_firma;
	/**
	 * Implementation field for persistent attribute: tiido_fir_oficina_fk_cod_ofic
	 */
	public java.lang.String tiido_fir_oficina_fk_cod_ofic;
	/**
	 * Implementation field for persistent attribute: tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr;
	/**
	 * Creates an empty key for Entity Bean: Tiido_firmas
	 */
	public Tiido_firmasKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_firmas
	 */
	public Tiido_firmasKey(
		java.lang.String cod_firma,
		entities.Tiido_oficinaKey argTiido_fir_oficina_fk) {
		this.cod_firma = cod_firma;
		privateSetTiido_fir_oficina_fkKey(argTiido_fir_oficina_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_firmasKey) {
			entities.Tiido_firmasKey o = (entities.Tiido_firmasKey) otherKey;
			return ((this.cod_firma.equals(o.cod_firma))
				&& (this.tiido_fir_oficina_fk_cod_ofic
					.equals(o.tiido_fir_oficina_fk_cod_ofic)) && (this.tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr
				.equals(o.tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_firma.hashCode() + tiido_fir_oficina_fk_cod_ofic.hashCode() + tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_firma
	 */
	public java.lang.String getCod_firma() {
		return cod_firma;
	}
	/**
	 * Set accessor for persistent attribute: cod_firma
	 */
	public void setCod_firma(java.lang.String newCod_firma) {
		cod_firma = newCod_firma;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_fir_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaKey getTiido_fir_oficina_fkKey() {
		entities.Tiido_oficinaKey temp = new entities.Tiido_oficinaKey();
		boolean tiido_fir_oficina_fk_NULLTEST = true;
		tiido_fir_oficina_fk_NULLTEST &= (tiido_fir_oficina_fk_cod_ofic == null);
		temp.cod_ofic = tiido_fir_oficina_fk_cod_ofic;
		tiido_fir_oficina_fk_NULLTEST &= (tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr == null);
		temp.tiido_territorio_fk_cod_terr = tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr;
		if (tiido_fir_oficina_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_fir_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_fir_oficina_fkKey(
		entities.Tiido_oficinaKey inKey) {
		boolean tiido_fir_oficina_fk_NULLTEST = (inKey == null);
		tiido_fir_oficina_fk_cod_ofic = (tiido_fir_oficina_fk_NULLTEST)
			? null
			: inKey.cod_ofic;
		tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr = (tiido_fir_oficina_fk_NULLTEST)
			? null
			: inKey.tiido_territorio_fk_cod_terr;
	}
}
