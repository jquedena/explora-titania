package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_territorio
 */
public abstract class Tiido_territorioBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_territorioKey ejbCreate(java.lang.String cod_terr)
		throws javax.ejb.CreateException {
		setCod_terr(cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_terr)
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
	 * Get accessor for persistent attribute: cod_terr
	 */
	public abstract java.lang.String getCod_terr();
	/**
	 * Set accessor for persistent attribute: cod_terr
	 */
	public abstract void setCod_terr(java.lang.String newCod_terr);
	/**
	 * Get accessor for persistent attribute: nom_terr
	 */
	public abstract java.lang.String getNom_terr();
	/**
	 * Set accessor for persistent attribute: nom_terr
	 */
	public abstract void setNom_terr(java.lang.String newNom_terr);
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
	 * This method was generated for supporting the relationship role named tiido_oficina.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTiido_oficina();
	/**
	 * This method was generated for supporting the relationship role named tiido_oficina.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_oficina(java.util.Collection aTiido_oficina);
	/**
	 * Get accessor for persistent attribute: estado
	 */
	public abstract java.lang.String getEstado();
	/**
	 * Set accessor for persistent attribute: estado
	 */
	public abstract void setEstado(java.lang.String newEstado);
}
