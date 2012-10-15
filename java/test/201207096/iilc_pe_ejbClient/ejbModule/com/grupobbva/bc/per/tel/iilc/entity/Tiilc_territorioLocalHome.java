package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local Home interface for Enterprise Bean: Tiilc_territorio
 */
public interface Tiilc_territorioLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_territorio
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal create(
		java.lang.String cod_territorio,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal argTiilc_area_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_territorio
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal create(
		java.lang.String cod_territorio,
		java.lang.String tiilc_area_fk_cod_area)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_territorio
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllTerritorioxAr(java.lang.String cod_area) throws javax.ejb.FinderException;
	public java.util.Collection findAllTerritorio() throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal create(
	        java.lang.String cod_territorio,
	        java.lang.String tiilc_area_fk_cod_area,
	        java.lang.String des_territorio) throws javax.ejb.CreateException;
}
