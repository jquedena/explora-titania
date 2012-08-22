package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_acciones
 */
public abstract class Tiido_accionesBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_accionesKey ejbCreate(
		java.lang.Integer cod_acci,
		entities.Tiido_epigrafeLocal argTiido_acc_epigrafe_fk,
		entities.Tiido_oficinaLocal argTiido_acc_oficina_fk)
		throws javax.ejb.CreateException {
		setCod_acci(cod_acci);
		entities.Tiido_epigrafeKey argTiido_acc_epigrafe_fkPK = (entities.Tiido_epigrafeKey) argTiido_acc_epigrafe_fk
			.getPrimaryKey();
		setTiido_acc_epigrafe_fk_cod_epigrafe(argTiido_acc_epigrafe_fkPK.cod_epigrafe);
		setTiido_acc_epigrafe_fk_anho(argTiido_acc_epigrafe_fkPK.anho);
		entities.Tiido_oficinaKey argTiido_acc_oficina_fkPK = (entities.Tiido_oficinaKey) argTiido_acc_oficina_fk
			.getPrimaryKey();
		setTiido_acc_oficina_fk_cod_ofic(argTiido_acc_oficina_fkPK.cod_ofic);
		setTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr(argTiido_acc_oficina_fkPK.tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.Integer cod_acci,
		entities.Tiido_epigrafeLocal argTiido_acc_epigrafe_fk,
		entities.Tiido_oficinaLocal argTiido_acc_oficina_fk)
		throws javax.ejb.CreateException {
		setTiido_acc_epigrafe_fk(argTiido_acc_epigrafe_fk);
		setTiido_acc_oficina_fk(argTiido_acc_oficina_fk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_accionesKey ejbCreate(
		java.lang.Integer cod_acci,
		java.lang.String tiido_acc_epigrafe_fk_cod_epigrafe,
		java.lang.String tiido_acc_epigrafe_fk_anho,
		java.lang.String tiido_acc_oficina_fk_cod_ofic,
		java.lang.String tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
		setCod_acci(cod_acci);
		setTiido_acc_epigrafe_fk_cod_epigrafe(tiido_acc_epigrafe_fk_cod_epigrafe);
		setTiido_acc_epigrafe_fk_anho(tiido_acc_epigrafe_fk_anho);
		setTiido_acc_oficina_fk_cod_ofic(tiido_acc_oficina_fk_cod_ofic);
		setTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr(tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.Integer cod_acci,
		java.lang.String tiido_acc_epigrafe_fk_cod_epigrafe,
		java.lang.String tiido_acc_epigrafe_fk_anho,
		java.lang.String tiido_acc_oficina_fk_cod_ofic,
		java.lang.String tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr)
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
	 * Set accessor for persistent attribute: cod_acci
	 */
	public abstract void setCod_acci(java.lang.Integer newCod_acci);
	/**
	 * Get accessor for persistent attribute: nom_acci
	 */
	public abstract java.lang.String getNom_acci();
	/**
	 * Set accessor for persistent attribute: nom_acci
	 */
	public abstract void setNom_acci(java.lang.String newNom_acci);
	/**
	 * Get accessor for persistent attribute: cod_gest
	 */
	public abstract java.lang.String getCod_gest();
	/**
	 * Set accessor for persistent attribute: cod_gest
	 */
	public abstract void setCod_gest(java.lang.String newCod_gest);
	/**
	 * Get accessor for persistent attribute: mes_acci
	 */
	public abstract java.lang.String getMes_acci();
	/**
	 * Set accessor for persistent attribute: mes_acci
	 */
	public abstract void setMes_acci(java.lang.String newMes_acci);
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
	 * Get accessor for persistent attribute: mon_segu_1
	 */
	public abstract java.math.BigDecimal getMon_segu_1();
	/**
	 * Set accessor for persistent attribute: mon_segu_1
	 */
	public abstract void setMon_segu_1(java.math.BigDecimal newMon_segu_1);
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
	 * Get accessor for persistent attribute: mon_segu_2
	 */
	public abstract java.math.BigDecimal getMon_segu_2();
	/**
	 * Set accessor for persistent attribute: mon_segu_2
	 */
	public abstract void setMon_segu_2(java.math.BigDecimal newMon_segu_2);
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
	 * Get accessor for persistent attribute: usu_actu
	 */
	public abstract java.lang.String getUsu_actu();
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public abstract void setUsu_actu(java.lang.String newUsu_actu);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public abstract java.sql.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public abstract void setFec_regi(java.sql.Date newFec_regi);
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public abstract java.sql.Date getFec_actu();
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public abstract void setFec_actu(java.sql.Date newFec_actu);
	/**
	 * This method was generated for supporting the relationship role named tiido_acc_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_epigrafeLocal getTiido_acc_epigrafe_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_acc_epigrafe_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_acc_epigrafe_fk(
		entities.Tiido_epigrafeLocal aTiido_acc_epigrafe_fk);
	/**
	 * This method was generated for supporting the relationship role named tiido_acc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_oficinaLocal getTiido_acc_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_acc_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_acc_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_acc_oficina_fk);
	/**
	 * Get accessor for persistent attribute: tiido_acc_epigrafe_fk_cod_epigrafe
	 */
	public abstract java.lang.String getTiido_acc_epigrafe_fk_cod_epigrafe();
	/**
	 * Set accessor for persistent attribute: tiido_acc_epigrafe_fk_cod_epigrafe
	 */
	public abstract void setTiido_acc_epigrafe_fk_cod_epigrafe(
		java.lang.String newTiido_acc_epigrafe_fk_cod_epigrafe);
	/**
	 * Get accessor for persistent attribute: tiido_acc_epigrafe_fk_anho
	 */
	public abstract java.lang.String getTiido_acc_epigrafe_fk_anho();
	/**
	 * Set accessor for persistent attribute: tiido_acc_epigrafe_fk_anho
	 */
	public abstract void setTiido_acc_epigrafe_fk_anho(
		java.lang.String newTiido_acc_epigrafe_fk_anho);
	/**
	 * Get accessor for persistent attribute: tiido_acc_oficina_fk_cod_ofic
	 */
	public abstract java.lang.String getTiido_acc_oficina_fk_cod_ofic();
	/**
	 * Set accessor for persistent attribute: tiido_acc_oficina_fk_cod_ofic
	 */
	public abstract void setTiido_acc_oficina_fk_cod_ofic(
		java.lang.String newTiido_acc_oficina_fk_cod_ofic);
	/**
	 * Get accessor for persistent attribute: tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract java.lang.String getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr();
	/**
	 * Set accessor for persistent attribute: tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract void setTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr(
		java.lang.String newTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
	/**
	 * Get accessor for persistent attribute: cod_acci
	 */
	public abstract java.lang.Integer getCod_acci();
}
