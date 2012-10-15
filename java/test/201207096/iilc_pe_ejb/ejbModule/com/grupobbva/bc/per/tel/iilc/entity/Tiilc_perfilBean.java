package com.grupobbva.bc.per.tel.iilc.entity;

import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_perfil
 */
public abstract class Tiilc_perfilBean implements javax.ejb.EntityBean {
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey ejbCreate(
		java.lang.String cod_perfil) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: des_perfil
	 */
	public abstract java.lang.String getDes_perfil();
	/**
	 * Set accessor for persistent attribute: des_perfil
	 */
	public abstract void setDes_perfil(java.lang.String newDes_perfil);
	/**
	 * Get accessor for persistent attribute: componente
	 */
	public abstract java.lang.String getComponente();
	/**
	 * Set accessor for persistent attribute: componente
	 */
	public abstract void setComponente(java.lang.String newComponente);
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey ejbCreate(
			Perfil perfil) throws javax.ejb.CreateException {
			setCod_perfil(perfil.getCod_perfil());
			setDes_perfil(perfil.getDes_perfil());
			setComponente(perfil.getComponente());
			return null;
		}
	public void ejbPostCreate(Perfil perfil)
		throws javax.ejb.CreateException {
	}
}
