package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local Home interface for Enterprise Bean: Tiilc_linea_comercial
 */
public interface Tiilc_linea_comercialLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_linea_comercial
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal create(
		java.lang.String cod_grupo,
		java.lang.String cod_lincom) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_linea_comercial
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey primaryKey)
		throws javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_linea_comercial
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialLocal create(
		java.lang.String cod_grupo,
		java.lang.String cod_lincom,
		java.lang.String des_lincom) throws javax.ejb.CreateException;
}
