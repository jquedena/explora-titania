package com.grupobbva.bc.per.tel.iilc.entity;

import com.grupobbva.bc.per.tel.iilc.serializable.Total;

/**
 * Local Home interface for Enterprise Bean: Tiilc_total
 */
public interface Tiilc_totalLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_total
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal create(
		java.math.BigDecimal cod_total) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_total
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findTotalxGexOfxTe(java.lang.String ind_registro, java.lang.String cod_territorio, java.lang.String cod_oficina, java.lang.String cod_gestor) throws javax.ejb.FinderException;
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal create(
	        Total total) throws javax.ejb.CreateException;
}
