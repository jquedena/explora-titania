package entities;
/**
 * Key class for Entity Bean: Tiido_maestro_planes
 */
public class Tiido_maestro_planesKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: mes
	 */
	public java.lang.String mes;
	/**
	 * Implementation field for persistent attribute: anho
	 */
	public java.lang.String anho;
	/**
	 * Implementation field for persistent attribute: tiido_maepla_oficina_fk_cod_ofic
	 */
	public java.lang.String tiido_maepla_oficina_fk_cod_ofic;
	/**
	 * Implementation field for persistent attribute: tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr;
	/**
	 * Creates an empty key for Entity Bean: Tiido_maestro_planes
	 */
	public Tiido_maestro_planesKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiido_maestro_planes
	 */
	public Tiido_maestro_planesKey(
		java.lang.String mes,
		java.lang.String anho,
		entities.Tiido_oficinaKey argTiido_maepla_oficina_fk) {
		this.mes = mes;
		this.anho = anho;
		privateSetTiido_maepla_oficina_fkKey(argTiido_maepla_oficina_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof entities.Tiido_maestro_planesKey) {
			entities.Tiido_maestro_planesKey o = (entities.Tiido_maestro_planesKey) otherKey;
			return ((this.mes.equals(o.mes))
				&& (this.anho.equals(o.anho))
				&& (this.tiido_maepla_oficina_fk_cod_ofic
					.equals(o.tiido_maepla_oficina_fk_cod_ofic)) && (this.tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr
				.equals(o.tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (mes.hashCode()
			+ anho.hashCode()
			+ tiido_maepla_oficina_fk_cod_ofic.hashCode() + tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: mes
	 */
	public java.lang.String getMes() {
		return mes;
	}
	/**
	 * Set accessor for persistent attribute: mes
	 */
	public void setMes(java.lang.String newMes) {
		mes = newMes;
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
	/**
	 * This method was generated for supporting the relationship role named tiido_maepla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public entities.Tiido_oficinaKey getTiido_maepla_oficina_fkKey() {
		entities.Tiido_oficinaKey temp = new entities.Tiido_oficinaKey();
		boolean tiido_maepla_oficina_fk_NULLTEST = true;
		tiido_maepla_oficina_fk_NULLTEST &= (tiido_maepla_oficina_fk_cod_ofic == null);
		temp.cod_ofic = tiido_maepla_oficina_fk_cod_ofic;
		tiido_maepla_oficina_fk_NULLTEST &= (tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr == null);
		temp.tiido_territorio_fk_cod_terr = tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr;
		if (tiido_maepla_oficina_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiido_maepla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiido_maepla_oficina_fkKey(
		entities.Tiido_oficinaKey inKey) {
		boolean tiido_maepla_oficina_fk_NULLTEST = (inKey == null);
		tiido_maepla_oficina_fk_cod_ofic = (tiido_maepla_oficina_fk_NULLTEST)
			? null
			: inKey.cod_ofic;
		tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr = (tiido_maepla_oficina_fk_NULLTEST)
			? null
			: inKey.tiido_territorio_fk_cod_terr;
	}
}
