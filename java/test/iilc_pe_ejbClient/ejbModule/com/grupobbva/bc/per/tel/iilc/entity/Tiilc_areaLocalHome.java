package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local Home interface for Enterprise Bean: Tiilc_area
 */
public interface Tiilc_areaLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_area
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal create(
		java.lang.String cod_area) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_area
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey primaryKey)
		throws javax.ejb.FinderException;
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal create(
	        java.lang.String cod_area,
	        java.lang.String des_area) throws javax.ejb.CreateException;
}
