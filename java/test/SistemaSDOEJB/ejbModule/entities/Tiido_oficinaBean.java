package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_oficina
 */
public abstract class Tiido_oficinaBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_oficinaKey ejbCreate(
		java.lang.String cod_ofic,
		entities.Tiido_territorioLocal argTiido_territorio_fk)
		throws javax.ejb.CreateException {
		setCod_ofic(cod_ofic);
		entities.Tiido_territorioKey argTiido_territorio_fkPK = (entities.Tiido_territorioKey) argTiido_territorio_fk
			.getPrimaryKey();
		setTiido_territorio_fk_cod_terr(argTiido_territorio_fkPK.cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_ofic,
		entities.Tiido_territorioLocal argTiido_territorio_fk)
		throws javax.ejb.CreateException {
		setTiido_territorio_fk(argTiido_territorio_fk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_oficinaKey ejbCreate(
		java.lang.String cod_ofic,
		java.lang.String tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
		setCod_ofic(cod_ofic);
		setTiido_territorio_fk_cod_terr(tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_ofic,
		java.lang.String tiido_territorio_fk_cod_terr)
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
	 * Get accessor for persistent attribute: cod_ofic
	 */
	public abstract java.lang.String getCod_ofic();
	/**
	 * Set accessor for persistent attribute: cod_ofic
	 */
	public abstract void setCod_ofic(java.lang.String newCod_ofic);
	/**
	 * Get accessor for persistent attribute: nom_ofic
	 */
	public abstract java.lang.String getNom_ofic();
	/**
	 * Set accessor for persistent attribute: nom_ofic
	 */
	public abstract void setNom_ofic(java.lang.String newNom_ofic);
	/**
	 * Get accessor for persistent attribute: usu_regi
	 */
	public abstract java.lang.String getUsu_regi();
	/**
	 * Set accessor for persistent attribute: usu_regi
	 */
	public abstract void setUsu_regi(java.lang.String newUsu_regi);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public abstract java.sql.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public abstract void setFec_regi(java.sql.Date newFec_regi);
	/**
	 * Get accessor for persistent attribute: usu_actu
	 */
	public abstract java.lang.String getUsu_actu();
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public abstract void setUsu_actu(java.lang.String newUsu_actu);
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public abstract java.sql.Date getFec_actu();
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public abstract void setFec_actu(java.sql.Date newFec_actu);
	/**
	 * This method was generated for supporting the relationship role named tiido_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_territorioLocal getTiido_territorio_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_territorio_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_territorio_fk(
		entities.Tiido_territorioLocal aTiido_territorio_fk);
	/**
	 * This method was generated for supporting the relationship role named tiido_acciones.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_acciones();
	/**
	 * This method was generated for supporting the relationship role named tiido_acciones.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_acciones(java.util.Collection aTiido_acciones);
	/**
	 * This method was generated for supporting the relationship role named tiido_campanias.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_campanias();
	/**
	 * This method was generated for supporting the relationship role named tiido_campanias.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_campanias(
		java.util.Collection aTiido_campanias);
	/**
	 * This method was generated for supporting the relationship role named tiido_firmas.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_firmas();
	/**
	 * This method was generated for supporting the relationship role named tiido_firmas.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_firmas(java.util.Collection aTiido_firmas);
	/**
	 * This method was generated for supporting the relationship role named tiido_maestro_planes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_maestro_planes();
	/**
	 * This method was generated for supporting the relationship role named tiido_maestro_planes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_maestro_planes(
		java.util.Collection aTiido_maestro_planes);
	/**
	 * This method was generated for supporting the relationship role named tiido_metas_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_metas_gestor();
	/**
	 * This method was generated for supporting the relationship role named tiido_metas_gestor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_metas_gestor(
		java.util.Collection aTiido_metas_gestor);
	/**
	 * This method was generated for supporting the relationship role named tiido_planes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_planes();
	/**
	 * This method was generated for supporting the relationship role named tiido_planes.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_planes(java.util.Collection aTiido_planes);
	/**
	 * Get accessor for persistent attribute: tiido_territorio_fk_cod_terr
	 */
	public abstract java.lang.String getTiido_territorio_fk_cod_terr();
	/**
	 * Set accessor for persistent attribute: tiido_territorio_fk_cod_terr
	 */
	public abstract void setTiido_territorio_fk_cod_terr(
		java.lang.String newTiido_territorio_fk_cod_terr);
	
	/**
	 * ejbCreate
	 */
	public entities.Tiido_oficinaKey ejbCreate(
		java.lang.String cod_ofic,
		java.lang.String nom_ofic,
		java.lang.String tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
		setCod_ofic(cod_ofic);
		setNom_ofic(nom_ofic);
		setTiido_territorio_fk_cod_terr(tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_ofic,
		java.lang.String nom_ofic,
		java.lang.String tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
	}
	/**
	 * Get accessor for persistent attribute: estado
	 */
	public abstract java.lang.String getEstado();
	/**
	 * Set accessor for persistent attribute: estado
	 */
	public abstract void setEstado(java.lang.String newEstado);
}
