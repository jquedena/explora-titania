package entities;

import java.sql.Date;

import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;

/**
 * Bean implementation class for Enterprise Bean: Tiido_perfiles
 */
public abstract class Tiido_perfilesBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_perfilesKey ejbCreate(java.lang.String cod_perfil)
		throws javax.ejb.CreateException {
		setCod_perfil(cod_perfil);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_perfil)
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
	 * Get accessor for persistent attribute: cod_perfil
	 */
	public abstract java.lang.String getCod_perfil();
	/**
	 * Set accessor for persistent attribute: cod_perfil
	 */
	public abstract void setCod_perfil(java.lang.String newCod_perfil);
	/**
	 * Get accessor for persistent attribute: nom_perfil
	 */
	public abstract java.lang.String getNom_perfil();
	/**
	 * Set accessor for persistent attribute: nom_perfil
	 */
	public abstract void setNom_perfil(java.lang.String newNom_perfil);
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
	public entities.Tiido_perfilesKey ejbCreate(Perfil per)
	throws javax.ejb.CreateException {
	setCod_perfil(per.getCodPerfil());
	setFec_actu(Date.valueOf(per.getFecActu()));
	setFec_regi(Date.valueOf(per.getFecRegi()));
	setNom_perfil(per.getNomPerfil());
	setUsu_actu(per.getUsuActu());
	setUsu_regi(per.getUsuRegi());
	return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(Perfil per)
		throws javax.ejb.CreateException {
	}

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
	 * Get accessor for persistent attribute: perfil
	 */
	public abstract java.lang.String getPerfil();
	/**
	 * Set accessor for persistent attribute: perfil
	 */
	public abstract void setPerfil(java.lang.String newPerfil);
}
