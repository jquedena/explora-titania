package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local Home interface for Enterprise Bean: Tiilc_empresa
 */
public interface Tiilc_empresaLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_empresa
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal create(
		java.lang.String cod_empresa) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_empresa
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllEmpresa() throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal findEmpresaxCodigo(java.lang.String cod_empresa) throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaLocal create(
	        java.lang.String cod_empresa,
	        java.lang.String des_empresa) throws javax.ejb.CreateException;
}
