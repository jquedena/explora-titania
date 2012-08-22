package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_campanias_detalle
 */
public abstract class Tiido_campanias_detalleBean
	implements
		javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_campanias_detalleKey ejbCreate(
		java.lang.Integer cod_camp_deta,
		entities.Tiido_campaniasLocal argTiido_camdet_campanias_fk)
		throws javax.ejb.CreateException {
		setCod_camp_deta(cod_camp_deta);
		entities.Tiido_campaniasKey argTiido_camdet_campanias_fkPK = (entities.Tiido_campaniasKey) argTiido_camdet_campanias_fk
			.getPrimaryKey();
		setTiido_camdet_campanias_fk_cod_camp(argTiido_camdet_campanias_fkPK.cod_camp);
		setTiido_camdet_campanias_fk_anho(argTiido_camdet_campanias_fkPK.anho);
		setTiido_camdet_campanias_fk_mes(argTiido_camdet_campanias_fkPK.mes);
		setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic(argTiido_camdet_campanias_fkPK.tiido_cam_oficina_fk_cod_ofic);
		setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(argTiido_camdet_campanias_fkPK.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.Integer cod_camp_deta,
		entities.Tiido_campaniasLocal argTiido_camdet_campanias_fk)
		throws javax.ejb.CreateException {
		setTiido_camdet_campanias_fk(argTiido_camdet_campanias_fk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_campanias_detalleKey ejbCreate(
		java.lang.Integer cod_camp_deta,
		java.lang.Integer tiido_camdet_campanias_fk_cod_camp,
		java.lang.String tiido_camdet_campanias_fk_anho,
		java.lang.String tiido_camdet_campanias_fk_mes,
		java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic,
		java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
		setCod_camp_deta(cod_camp_deta);
		setTiido_camdet_campanias_fk_cod_camp(tiido_camdet_campanias_fk_cod_camp);
		setTiido_camdet_campanias_fk_anho(tiido_camdet_campanias_fk_anho);
		setTiido_camdet_campanias_fk_mes(tiido_camdet_campanias_fk_mes);
		setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic(tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic);
		setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.Integer cod_camp_deta,
		java.lang.Integer tiido_camdet_campanias_fk_cod_camp,
		java.lang.String tiido_camdet_campanias_fk_anho,
		java.lang.String tiido_camdet_campanias_fk_mes,
		java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic,
		java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Set accessor for persistent attribute: cod_camp_deta
	 */
	public abstract void setCod_camp_deta(java.lang.Integer newCod_camp_deta);
	/**
	 * Get accessor for persistent attribute: nom_camp
	 */
	public abstract java.lang.String getNom_camp();
	/**
	 * Set accessor for persistent attribute: nom_camp
	 */
	public abstract void setNom_camp(java.lang.String newNom_camp);
	/**
	 * Get accessor for persistent attribute: cod_gest
	 */
	public abstract java.lang.String getCod_gest();
	/**
	 * Set accessor for persistent attribute: cod_gest
	 */
	public abstract void setCod_gest(java.lang.String newCod_gest);
	/**
	 * Get accessor for persistent attribute: nro_clie
	 */
	public abstract java.math.BigDecimal getNro_clie();
	/**
	 * Set accessor for persistent attribute: nro_clie
	 */
	public abstract void setNro_clie(java.math.BigDecimal newNro_clie);
	/**
	 * Get accessor for persistent attribute: comp_gest
	 */
	public abstract java.math.BigDecimal getComp_gest();
	/**
	 * Set accessor for persistent attribute: comp_gest
	 */
	public abstract void setComp_gest(java.math.BigDecimal newComp_gest);
	/**
	 * Get accessor for persistent attribute: nro_gest_segu_1
	 */
	public abstract java.math.BigDecimal getNro_gest_segu_1();
	/**
	 * Set accessor for persistent attribute: nro_gest_segu_1
	 */
	public abstract void setNro_gest_segu_1(
		java.math.BigDecimal newNro_gest_segu_1);
	/**
	 * Get accessor for persistent attribute: nro_conc_segu_1
	 */
	public abstract java.math.BigDecimal getNro_conc_segu_1();
	/**
	 * Set accessor for persistent attribute: nro_conc_segu_1
	 */
	public abstract void setNro_conc_segu_1(
		java.math.BigDecimal newNro_conc_segu_1);
	/**
	 * Get accessor for persistent attribute: mont_segu_1
	 */
	public abstract java.math.BigDecimal getMont_segu_1();
	/**
	 * Set accessor for persistent attribute: mont_segu_1
	 */
	public abstract void setMont_segu_1(java.math.BigDecimal newMont_segu_1);
	/**
	 * Get accessor for persistent attribute: nro_gest_segu_2
	 */
	public abstract java.math.BigDecimal getNro_gest_segu_2();
	/**
	 * Set accessor for persistent attribute: nro_gest_segu_2
	 */
	public abstract void setNro_gest_segu_2(
		java.math.BigDecimal newNro_gest_segu_2);
	/**
	 * Get accessor for persistent attribute: nro_conc_segu_2
	 */
	public abstract java.math.BigDecimal getNro_conc_segu_2();
	/**
	 * Set accessor for persistent attribute: nro_conc_segu_2
	 */
	public abstract void setNro_conc_segu_2(
		java.math.BigDecimal newNro_conc_segu_2);
	/**
	 * Get accessor for persistent attribute: mont_segu_2
	 */
	public abstract java.math.BigDecimal getMont_segu_2();
	/**
	 * Set accessor for persistent attribute: mont_segu_2
	 */
	public abstract void setMont_segu_2(java.math.BigDecimal newMont_segu_2);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public abstract java.sql.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public abstract void setFec_regi(java.sql.Date newFec_regi);
	/**
	 * Get accessor for persistent attribute: fec_segu_1
	 */
	public abstract java.sql.Date getFec_segu_1();
	/**
	 * Set accessor for persistent attribute: fec_segu_1
	 */
	public abstract void setFec_segu_1(java.sql.Date newFec_segu_1);
	/**
	 * Get accessor for persistent attribute: fec_segu_2
	 */
	public abstract java.sql.Date getFec_segu_2();
	/**
	 * Set accessor for persistent attribute: fec_segu_2
	 */
	public abstract void setFec_segu_2(java.sql.Date newFec_segu_2);
	/**
	 * Get accessor for persistent attribute: usu_regi
	 */
	public abstract java.lang.String getUsu_regi();
	/**
	 * Set accessor for persistent attribute: usu_regi
	 */
	public abstract void setUsu_regi(java.lang.String newUsu_regi);
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public abstract java.sql.Date getFec_actu();
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public abstract void setFec_actu(java.sql.Date newFec_actu);
	/**
	 * Get accessor for persistent attribute: usu_actu
	 */
	public abstract java.lang.String getUsu_actu();
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public abstract void setUsu_actu(java.lang.String newUsu_actu);
	/**
	 * This method was generated for supporting the relationship role named tiido_camdet_campanias_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_campaniasLocal getTiido_camdet_campanias_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_camdet_campanias_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_camdet_campanias_fk(
		entities.Tiido_campaniasLocal aTiido_camdet_campanias_fk);
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_cod_camp
	 */
	public abstract java.lang.Integer getTiido_camdet_campanias_fk_cod_camp();
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_cod_camp
	 */
	public abstract void setTiido_camdet_campanias_fk_cod_camp(
		java.lang.Integer newTiido_camdet_campanias_fk_cod_camp);
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_anho
	 */
	public abstract java.lang.String getTiido_camdet_campanias_fk_anho();
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_anho
	 */
	public abstract void setTiido_camdet_campanias_fk_anho(
		java.lang.String newTiido_camdet_campanias_fk_anho);
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_mes
	 */
	public abstract java.lang.String getTiido_camdet_campanias_fk_mes();
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_mes
	 */
	public abstract void setTiido_camdet_campanias_fk_mes(
		java.lang.String newTiido_camdet_campanias_fk_mes);
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic
	 */
	public abstract java.lang.String getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic();
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic
	 */
	public abstract void setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic(
		java.lang.String newTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic);
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract java.lang.String getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr();
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract void setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(
		java.lang.String newTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
	/**
	 * Get accessor for persistent attribute: cod_camp_deta
	 */
	public abstract java.lang.Integer getCod_camp_deta();
}
