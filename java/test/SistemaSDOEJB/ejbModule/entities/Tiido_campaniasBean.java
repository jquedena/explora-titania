package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_campanias
 */
public abstract class Tiido_campaniasBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_campaniasKey ejbCreate(
		java.lang.Integer cod_camp,
		java.lang.String anho,
		java.lang.String mes,
		entities.Tiido_oficinaLocal argTiido_cam_oficina_fk)
		throws javax.ejb.CreateException {
		setCod_camp(cod_camp);
		setAnho(anho);
		setMes(mes);
		entities.Tiido_oficinaKey argTiido_cam_oficina_fkPK = (entities.Tiido_oficinaKey) argTiido_cam_oficina_fk
			.getPrimaryKey();
		setTiido_cam_oficina_fk_cod_ofic(argTiido_cam_oficina_fkPK.cod_ofic);
		setTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(argTiido_cam_oficina_fkPK.tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.Integer cod_camp,
		java.lang.String anho,
		java.lang.String mes,
		entities.Tiido_oficinaLocal argTiido_cam_oficina_fk)
		throws javax.ejb.CreateException {
		setTiido_cam_oficina_fk(argTiido_cam_oficina_fk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_campaniasKey ejbCreate(
		java.lang.Integer cod_camp,
		java.lang.String anho,
		java.lang.String mes,
		java.lang.String tiido_cam_oficina_fk_cod_ofic,
		java.lang.String tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
		setCod_camp(cod_camp);
		setAnho(anho);
		setMes(mes);
		setTiido_cam_oficina_fk_cod_ofic(tiido_cam_oficina_fk_cod_ofic);
		setTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.Integer cod_camp,
		java.lang.String anho,
		java.lang.String mes,
		java.lang.String tiido_cam_oficina_fk_cod_ofic,
		java.lang.String tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr)
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
	 * Get accessor for persistent attribute: cod_camp
	 */
	public abstract java.lang.Integer getCod_camp();
	/**
	 * Set accessor for persistent attribute: cod_camp
	 */
	public abstract void setCod_camp(java.lang.Integer newCod_camp);
	/**
	 * Get accessor for persistent attribute: anho
	 */
	public abstract java.lang.String getAnho();
	/**
	 * Set accessor for persistent attribute: anho
	 */
	public abstract void setAnho(java.lang.String newAnho);
	/**
	 * Get accessor for persistent attribute: mes
	 */
	public abstract java.lang.String getMes();
	/**
	 * Set accessor for persistent attribute: mes
	 */
	public abstract void setMes(java.lang.String newMes);
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
	 * Get accessor for persistent attribute: orden
	 */
	public abstract java.lang.String getOrden();
	/**
	 * Set accessor for persistent attribute: orden
	 */
	public abstract void setOrden(java.lang.String newOrden);
	/**
	 * Get accessor for persistent attribute: gte
	 */
	public abstract java.lang.String getGte();
	/**
	 * Set accessor for persistent attribute: gte
	 */
	public abstract void setGte(java.lang.String newGte);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public abstract java.sql.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public abstract void setFec_regi(java.sql.Date newFec_regi);
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
	 * This method was generated for supporting the relationship role named tiido_cam_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_oficinaLocal getTiido_cam_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_cam_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_cam_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_cam_oficina_fk);
	/**
	 * This method was generated for supporting the relationship role named tiido_campanias_detalle.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_campanias_detalle();
	/**
	 * This method was generated for supporting the relationship role named tiido_campanias_detalle.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_campanias_detalle(
		java.util.Collection aTiido_campanias_detalle);
	/**
	 * Get accessor for persistent attribute: tiido_cam_oficina_fk_cod_ofic
	 */
	public abstract java.lang.String getTiido_cam_oficina_fk_cod_ofic();
	/**
	 * Set accessor for persistent attribute: tiido_cam_oficina_fk_cod_ofic
	 */
	public abstract void setTiido_cam_oficina_fk_cod_ofic(
		java.lang.String newTiido_cam_oficina_fk_cod_ofic);
	/**
	 * Get accessor for persistent attribute: tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract java.lang.String getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr();
	/**
	 * Set accessor for persistent attribute: tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract void setTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(
		java.lang.String newTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
}
