package com.grupobbva.bc.per.tel.iilc.entity;

import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

/**
 * Local Home interface for Enterprise Bean: Tiilc_multitabla
 */
public interface Tiilc_multitablaLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_multitabla
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal create(
		java.lang.String cod_mult,
		java.lang.String cod_ele) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_multitabla
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllRecord(java.lang.String cod_mult) throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal findRecord(java.lang.String codigo) throws javax.ejb.FinderException;
	public java.util.Collection findMultitablaxValor2(java.lang.String valor2) throws javax.ejb.FinderException;
	public java.util.Collection findAllMultitabla() throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal findMultitabla(java.lang.String cod_mult, java.lang.String cod_ele) throws javax.ejb.FinderException;
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaLocal create(
	        Multitabla multitabla) throws javax.ejb.CreateException;
}
