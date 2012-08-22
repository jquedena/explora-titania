package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_firmas
 */
public abstract class Tiido_firmasBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_firmasKey ejbCreate(
		java.lang.String cod_firma,
		entities.Tiido_oficinaLocal argTiido_fir_oficina_fk)
		throws javax.ejb.CreateException {
		setCod_firma(cod_firma);
		entities.Tiido_oficinaKey argTiido_fir_oficina_fkPK = (entities.Tiido_oficinaKey) argTiido_fir_oficina_fk
			.getPrimaryKey();
		setTiido_fir_oficina_fk_cod_ofic(argTiido_fir_oficina_fkPK.cod_ofic);
		setTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr(argTiido_fir_oficina_fkPK.tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_firma,
		entities.Tiido_oficinaLocal argTiido_fir_oficina_fk)
		throws javax.ejb.CreateException {
		setTiido_fir_oficina_fk(argTiido_fir_oficina_fk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_firmasKey ejbCreate(
		java.lang.String cod_firma,
		java.lang.String tiido_fir_oficina_fk_cod_ofic,
		java.lang.String tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
		setCod_firma(cod_firma);
		setTiido_fir_oficina_fk_cod_ofic(tiido_fir_oficina_fk_cod_ofic);
		setTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr(tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_firma,
		java.lang.String tiido_fir_oficina_fk_cod_ofic,
		java.lang.String tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr)
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
	 * Get accessor for persistent attribute: cod_firma
	 */
	public abstract java.lang.String getCod_firma();
	/**
	 * Set accessor for persistent attribute: cod_firma
	 */
	public abstract void setCod_firma(java.lang.String newCod_firma);
	/**
	 * Get accessor for persistent attribute: anho_firm
	 */
	public abstract java.lang.String getAnho_firm();
	/**
	 * Set accessor for persistent attribute: anho_firm
	 */
	public abstract void setAnho_firm(java.lang.String newAnho_firm);
	/**
	 * Get accessor for persistent attribute: mes_firm
	 */
	public abstract java.lang.String getMes_firm();
	/**
	 * Set accessor for persistent attribute: mes_firm
	 */
	public abstract void setMes_firm(java.lang.String newMes_firm);
	/**
	 * Get accessor for persistent attribute: item_firm
	 */
	public abstract java.lang.String getItem_firm();
	/**
	 * Set accessor for persistent attribute: item_firm
	 */
	public abstract void setItem_firm(java.lang.String newItem_firm);
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public abstract java.lang.String getCod_gestor();
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public abstract void setCod_gestor(java.lang.String newCod_gestor);
	/**
	 * Get accessor for persistent attribute: descripcion
	 */
	public abstract java.lang.String getDescripcion();
	/**
	 * Set accessor for persistent attribute: descripcion
	 */
	public abstract void setDescripcion(java.lang.String newDescripcion);
	/**
	 * Get accessor for persistent attribute: fec_firm
	 */
	public abstract java.sql.Date getFec_firm();
	/**
	 * Set accessor for persistent attribute: fec_firm
	 */
	public abstract void setFec_firm(java.sql.Date newFec_firm);
	/**
	 * This method was generated for supporting the relationship role named tiido_fir_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_oficinaLocal getTiido_fir_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_fir_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_fir_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_fir_oficina_fk);
	/**
	 * Get accessor for persistent attribute: tiido_fir_oficina_fk_cod_ofic
	 */
	public abstract java.lang.String getTiido_fir_oficina_fk_cod_ofic();
	/**
	 * Set accessor for persistent attribute: tiido_fir_oficina_fk_cod_ofic
	 */
	public abstract void setTiido_fir_oficina_fk_cod_ofic(
		java.lang.String newTiido_fir_oficina_fk_cod_ofic);
	/**
	 * Get accessor for persistent attribute: tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract java.lang.String getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr();
	/**
	 * Set accessor for persistent attribute: tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract void setTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr(
		java.lang.String newTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
}
