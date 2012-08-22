package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_maestro_planes
 */
public abstract class Tiido_maestro_planesBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_maestro_planesKey ejbCreate(
		java.lang.String mes,
		java.lang.String anho,
		entities.Tiido_oficinaLocal argTiido_maepla_oficina_fk)
		throws javax.ejb.CreateException {
		setMes(mes);
		setAnho(anho);
		entities.Tiido_oficinaKey argTiido_maepla_oficina_fkPK = (entities.Tiido_oficinaKey) argTiido_maepla_oficina_fk
			.getPrimaryKey();
		setTiido_maepla_oficina_fk_cod_ofic(argTiido_maepla_oficina_fkPK.cod_ofic);
		setTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr(argTiido_maepla_oficina_fkPK.tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String mes,
		java.lang.String anho,
		entities.Tiido_oficinaLocal argTiido_maepla_oficina_fk)
		throws javax.ejb.CreateException {
		setTiido_maepla_oficina_fk(argTiido_maepla_oficina_fk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_maestro_planesKey ejbCreate(
		java.lang.String mes,
		java.lang.String anho,
		java.lang.String tiido_maepla_oficina_fk_cod_ofic,
		java.lang.String tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
		setMes(mes);
		setAnho(anho);
		setTiido_maepla_oficina_fk_cod_ofic(tiido_maepla_oficina_fk_cod_ofic);
		setTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr(tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String mes,
		java.lang.String anho,
		java.lang.String tiido_maepla_oficina_fk_cod_ofic,
		java.lang.String tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr)
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
	 * Get accessor for persistent attribute: mes
	 */
	public abstract java.lang.String getMes();
	/**
	 * Set accessor for persistent attribute: mes
	 */
	public abstract void setMes(java.lang.String newMes);
	/**
	 * Get accessor for persistent attribute: anho
	 */
	public abstract java.lang.String getAnho();
	/**
	 * Set accessor for persistent attribute: anho
	 */
	public abstract void setAnho(java.lang.String newAnho);
	/**
	 * Get accessor for persistent attribute: prioridad
	 */
	public abstract java.math.BigDecimal getPrioridad();
	/**
	 * Set accessor for persistent attribute: prioridad
	 */
	public abstract void setPrioridad(java.math.BigDecimal newPrioridad);
	/**
	 * Get accessor for persistent attribute: fec_grab
	 */
	public abstract java.sql.Date getFec_grab();
	/**
	 * Set accessor for persistent attribute: fec_grab
	 */
	public abstract void setFec_grab(java.sql.Date newFec_grab);
	/**
	 * This method was generated for supporting the relationship role named tiido_maepla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_oficinaLocal getTiido_maepla_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_maepla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_maepla_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_maepla_oficina_fk);
	/**
	 * Get accessor for persistent attribute: tiido_maepla_oficina_fk_cod_ofic
	 */
	public abstract java.lang.String getTiido_maepla_oficina_fk_cod_ofic();
	/**
	 * Set accessor for persistent attribute: tiido_maepla_oficina_fk_cod_ofic
	 */
	public abstract void setTiido_maepla_oficina_fk_cod_ofic(
		java.lang.String newTiido_maepla_oficina_fk_cod_ofic);
	/**
	 * Get accessor for persistent attribute: tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract java.lang.String getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr();
	/**
	 * Set accessor for persistent attribute: tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract void setTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr(
		java.lang.String newTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
}
