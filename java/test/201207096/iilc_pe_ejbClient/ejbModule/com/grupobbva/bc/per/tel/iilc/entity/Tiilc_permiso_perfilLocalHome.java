package com.grupobbva.bc.per.tel.iilc.entity;

import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;

/**
 * Local Home interface for Enterprise Bean: Tiilc_permiso_perfil
 */
public interface Tiilc_permiso_perfilLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_permiso_perfil
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal create(
		java.lang.String cod_perfil,
		java.math.BigDecimal tipo_acceso,
		java.lang.String valor_rcp) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_permiso_perfil
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey primaryKey)
		throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal findPermisoPerfilxTipAccxValorRCP(int tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.FinderException;
	public java.util.Collection findAllPermisoPerfil() throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal findPermisoPerfil(java.lang.String cod_perfil, int tipo_acceso, java.lang.String valor_rcp) throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilLocal create(
	        PermisoPerfil permisoPerfil) throws javax.ejb.CreateException;
}
