package com.grupobbva.bc.per.tel.iilc.entity;

import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;

/**
 * Local Home interface for Enterprise Bean: Tiilc_perfil
 */
public interface Tiilc_perfilLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_perfil
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal create(
		java.lang.String cod_perfil) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_perfil
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllPerfil() throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal findPerfil(java.lang.String cod_perfil) throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilLocal create(
	        Perfil perfil) throws javax.ejb.CreateException;
}
