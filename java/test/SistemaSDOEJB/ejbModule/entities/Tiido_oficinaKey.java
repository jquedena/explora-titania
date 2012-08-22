package entities;
/**
 * Key class for Entity Bean: Tiido_oficina
 */
public class Tiido_oficinaKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_ofic
	 */
	public java.lang.String cod_ofic;
	/**
	 * Implementation field for persistent attribute: tiido_territorio_fk_cod_terr
	 */
	public java.lang.String tiido_territorio_fk_cod_terr;
	/**
	 * Creates an empty key for Entity Bean: Tiido_oficina
	 */
	public Tiido_oficinaKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_oficina
	 */
	public Tiido_oficinaKey(
		java.lang.String cod_ofic,
		entities.Tiido_territorioKey argTiido_territorio_fk) {
		this.cod_ofic = cod_ofic;
		privateSetTiido_territorio_fkKey(argTiido_territorio_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_oficinaKey) {
			entities.Tiido_oficinaKey o = (entities.Tiido_oficinaKey) otherKey;
			return ((this.cod_ofic.equals(o.cod_ofic)) && (this.tiido_territorio_fk_cod_terr
				.equals(o.tiido_territorio_fk_cod_terr)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_ofic.hashCode() + tiido_territorio_fk_cod_terr.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_ofic
	 */
	public java.lang.String getCod_ofic() {
		return cod_ofic;
	}
	/**
	 * Set accessor for persistent attribute: cod_ofic
	 */
	public void setCod_ofic(java.lang.String newCod_ofic) {
		cod_ofic = newCod_ofic;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_territorioKey getTiido_territorio_fkKey() {
		entities.Tiido_territorioKey temp = new entities.Tiido_territorioKey();
		boolean tiido_territorio_fk_NULLTEST = true;
		tiido_territorio_fk_NULLTEST &= (tiido_territorio_fk_cod_terr == null);
		temp.cod_terr = tiido_territorio_fk_cod_terr;
		if (tiido_territorio_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_territorio_fkKey(
		entities.Tiido_territorioKey inKey) {
		boolean tiido_territorio_fk_NULLTEST = (inKey == null);
		tiido_territorio_fk_cod_terr = (tiido_territorio_fk_NULLTEST)
			? null
			: inKey.cod_terr;
	}
}
