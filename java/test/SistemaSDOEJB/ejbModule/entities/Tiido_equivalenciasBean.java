package entities;

import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;

/**
 * Bean implementation class for Enterprise Bean: Tiido_equivalencias
 */
public abstract class Tiido_equivalenciasBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_equivalenciasKey ejbCreate(java.lang.String cod_car)
		throws javax.ejb.CreateException {
		setCod_car(cod_car);
		return null;
	}
	
	/**
	 * ejbCreate
	 */
	public entities.Tiido_equivalenciasKey ejbCreate(Equivalencia equivalencia)
		throws javax.ejb.CreateException {
		this.setCod_car(equivalencia.getCodCargo());
		this.setCod_per(equivalencia.getCodPerfil());
		this.setFec_actu(equivalencia.getFecActualizo());
		this.setFec_regi(equivalencia.getFecRegistro());
		this.setUsu_actu(equivalencia.getUsuActualizo());
		this.setUsu_regi(equivalencia.getUsuRegistro());
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_car)
		throws javax.ejb.CreateException {
	}
	
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(Equivalencia equivalencia)
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
	 * Get accessor for persistent attribute: cod_car
	 */
	public abstract java.lang.String getCod_car();
	/**
	 * Set accessor for persistent attribute: cod_car
	 */
	public abstract void setCod_car(java.lang.String newCod_car);
	/**
	 * Get accessor for persistent attribute: cod_per
	 */
	public abstract java.lang.String getCod_per();
	/**
	 * Set accessor for persistent attribute: cod_per
	 */
	public abstract void setCod_per(java.lang.String newCod_per);
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
}
