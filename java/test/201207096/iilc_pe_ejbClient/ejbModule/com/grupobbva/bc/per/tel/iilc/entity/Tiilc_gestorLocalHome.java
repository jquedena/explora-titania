package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local Home interface for Enterprise Bean: Tiilc_gestor
 */
public interface Tiilc_gestorLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_gestor
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal create(
		java.lang.String cod_gestor,
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal argTiilc_oficina_fk)
		throws javax.ejb.CreateException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_gestor
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal create(
		java.lang.String cod_gestor,
		java.lang.String tiilc_oficina_fk_cod_oficina,
		java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio,
		java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_gestor
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllGestorxOfxTexAr(java.lang.String cod_oficina, java.lang.String cod_territorio, java.lang.String cod_area) throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal findGestorxRegGestor(java.lang.String reg_gestor) throws javax.ejb.FinderException;
	public java.util.Collection findAllGestor(java.lang.String cod_area) throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorLocal create(
	        java.lang.String cod_gestor,
	        java.lang.String tiilc_oficina_fk_cod_oficina,
	        java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio,
	        java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area,
	        java.lang.String nom_gestor,
	        java.lang.String reg_gestor,
			java.lang.String perfil_gestor) throws javax.ejb.CreateException;
}
