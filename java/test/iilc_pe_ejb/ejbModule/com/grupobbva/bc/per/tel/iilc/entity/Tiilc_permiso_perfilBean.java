package com.grupobbva.bc.per.tel.iilc.entity;

import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_permiso_perfil
 */
public abstract class Tiilc_permiso_perfilBean implements javax.ejb.EntityBean {
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey ejbCreate(
		java.lang.String cod_perfil,
		java.math.BigDecimal tipo_acceso,
		java.lang.String valor_rcp) throws javax.ejb.CreateException {
		setCod_perfil(cod_perfil);
		setTipo_acceso(tipo_acceso);
		setValor_rcp(valor_rcp);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String cod_perfil,
		java.math.BigDecimal tipo_acceso,
		java.lang.String valor_rcp) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: tipo_acceso
	 */
	public abstract java.math.BigDecimal getTipo_acceso();
	/**
	 * Set accessor for persistent attribute: tipo_acceso
	 */
	public abstract void setTipo_acceso(java.math.BigDecimal newTipo_acceso);
	/**
	 * Get accessor for persistent attribute: valor_rcp
	 */
	public abstract java.lang.String getValor_rcp();
	/**
	 * Set accessor for persistent attribute: valor_rcp
	 */
	public abstract void setValor_rcp(java.lang.String newValor_rcp);
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey ejbCreate(
			PermisoPerfil permisoPerfil) throws javax.ejb.CreateException {
			setCod_perfil(permisoPerfil.getCod_perfil());
			setTipo_acceso(permisoPerfil.getTipo_acceso());
			setValor_rcp(permisoPerfil.getValor_rcp());
			return null;
		}
	public void ejbPostCreate(
			PermisoPerfil permisoPerfil) throws javax.ejb.CreateException {
	}
}
