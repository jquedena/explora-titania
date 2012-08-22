package entities;
/**
 * Bean implementation class for Enterprise Bean: Tiido_parametros
 */
public abstract class Tiido_parametrosBean implements javax.ejb.EntityBean {
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
	public entities.Tiido_parametrosKey ejbCreate(java.lang.String cod_parametro)
		throws javax.ejb.CreateException {
		setCod_parametro(cod_parametro);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_parametro)
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
	 * Get accessor for persistent attribute: cod_parametro
	 */
	public abstract java.lang.String getCod_parametro();
	/**
	 * Set accessor for persistent attribute: cod_parametro
	 */
	public abstract void setCod_parametro(java.lang.String newCod_parametro);
	/**
	 * Get accessor for persistent attribute: fec_acci
	 */
	public abstract java.sql.Date getFec_acci();
	/**
	 * Set accessor for persistent attribute: fec_acci
	 */
	public abstract void setFec_acci(java.sql.Date newFec_acci);
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
	 * Get accessor for persistent attribute: afec_acci
	 */
	public abstract java.lang.String getAfec_acci();
	/**
	 * Set accessor for persistent attribute: afec_acci
	 */
	public abstract void setAfec_acci(java.lang.String newAfec_acci);
	/**
	 * Get accessor for persistent attribute: afec_segu
	 */
	public abstract java.lang.String getAfec_segu();
	/**
	 * Set accessor for persistent attribute: afec_segu
	 */
	public abstract void setAfec_segu(java.lang.String newAfec_segu);
	/**
	 * Get accessor for persistent attribute: afec_plan
	 */
	public abstract java.lang.String getAfec_plan();
	/**
	 * Set accessor for persistent attribute: afec_plan
	 */
	public abstract void setAfec_plan(java.lang.String newAfec_plan);
	/**
	 * Get accessor for persistent attribute: fec_plan
	 */
	public abstract java.sql.Date getFec_plan();
	/**
	 * Set accessor for persistent attribute: fec_plan
	 */
	public abstract void setFec_plan(java.sql.Date newFec_plan);
	/**
	 * Get accessor for persistent attribute: tap_usu_regi
	 */
	public abstract java.lang.String getTap_usu_regi();
	/**
	 * Set accessor for persistent attribute: tap_usu_regi
	 */
	public abstract void setTap_usu_regi(java.lang.String newTap_usu_regi);
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
