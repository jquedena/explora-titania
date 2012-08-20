package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local Home interface for Enterprise Bean: Tiilc_oficina
 */
public interface Tiilc_oficinaLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_oficina
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal create(
		java.lang.String cod_oficina,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal argTiilc_territorio_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_oficina
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal create(
		java.lang.String cod_oficina,
		java.lang.String tiilc_territorio_fk_cod_territorio,
		java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_oficina
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllOficinaxCod_oficina(java.lang.String cod_oficina) throws javax.ejb.FinderException;
	public java.util.Collection findAllOficinaxTer(java.lang.String cod_territorio) throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal create(
	        java.lang.String cod_oficina,
	        java.lang.String tiilc_territorio_fk_cod_territorio,
	        java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area,
	        java.lang.String des_oficina) throws javax.ejb.CreateException;
}
