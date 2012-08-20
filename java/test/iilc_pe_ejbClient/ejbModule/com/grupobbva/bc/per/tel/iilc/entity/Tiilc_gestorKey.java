package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Key class for Entity Bean: Tiilc_gestor
 */
public class Tiilc_gestorKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: cod_gestor
	 */
	public java.lang.String cod_gestor;
	/**
	 * Implementation field for persistent attribute: tiilc_oficina_fk_cod_oficina
	 */
	public java.lang.String tiilc_oficina_fk_cod_oficina;
	/**
	 * Implementation field for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio
	 */
	public java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio;
	/**
	 * Implementation field for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area;
	/**
	 * Creates an empty key for Entity Bean: Tiilc_gestor
	 */
	public Tiilc_gestorKey() {
	}
	/**
	 * Creates a key for Entity Bean: Tiilc_gestor
	 */
	public Tiilc_gestorKey(
		java.lang.String cod_gestor,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey argTiilc_oficina_fk) {
		this.cod_gestor = cod_gestor;
		privateSetTiilc_oficina_fkKey(argTiilc_oficina_fk);
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey) {
			com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey o = (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey) otherKey;
			return ((this.cod_gestor.equals(o.cod_gestor))
				&& (this.tiilc_oficina_fk_cod_oficina
					.equals(o.tiilc_oficina_fk_cod_oficina))
				&& (this.tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio
					.equals(o.tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio)) && (this.tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area
				.equals(o.tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (cod_gestor.hashCode()
			+ tiilc_oficina_fk_cod_oficina.hashCode()
			+ tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio.hashCode() + tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public java.lang.String getCod_gestor() {
		return cod_gestor;
	}
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public void setCod_gestor(java.lang.String newCod_gestor) {
		cod_gestor = newCod_gestor;
	}
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey getTiilc_oficina_fkKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey temp = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey();
		boolean tiilc_oficina_fk_NULLTEST = true;
		tiilc_oficina_fk_NULLTEST &= (tiilc_oficina_fk_cod_oficina == null);
		temp.cod_oficina = tiilc_oficina_fk_cod_oficina;
		tiilc_oficina_fk_NULLTEST &= (tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio == null);
		temp.tiilc_territorio_fk_cod_territorio = tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio;
		tiilc_oficina_fk_NULLTEST &= (tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area == null);
		temp.tiilc_territorio_fk_tiilc_area_fk_cod_area = tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area;
		if (tiilc_oficina_fk_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named tiilc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetTiilc_oficina_fkKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey inKey) {
		boolean tiilc_oficina_fk_NULLTEST = (inKey == null);
		tiilc_oficina_fk_cod_oficina = (tiilc_oficina_fk_NULLTEST)
			? null
			: inKey.cod_oficina;
		tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio = (tiilc_oficina_fk_NULLTEST)
			? null
			: inKey.tiilc_territorio_fk_cod_territorio;
		tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area = (tiilc_oficina_fk_NULLTEST)
			? null
			: inKey.tiilc_territorio_fk_tiilc_area_fk_cod_area;
	}
}
