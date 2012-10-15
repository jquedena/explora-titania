package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Local Home interface for Enterprise Bean: Tiilc_cliente
 */
public interface Tiilc_clienteLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_cliente
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal create(
		java.math.BigDecimal cod_cliente) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Tiilc_cliente
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal findByPrimaryKey(
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey primaryKey)
		throws javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: Tiilc_cliente
	 */

	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteLocal create(
		java.math.BigDecimal cod_cliente,
		java.lang.String cod_oficina,
		java.lang.String cod_gestor,
		java.lang.String cod_territorio,
		java.math.BigDecimal mofactv,
		java.math.BigDecimal cs000lineamaxtc,
		java.math.BigDecimal cs000mtoprestamo,
		java.math.BigDecimal montovehicular,
		java.math.BigDecimal montohipotecario,
		java.math.BigDecimal tconsactv,
		java.math.BigDecimal montosubrogados,
		java.math.BigDecimal tsubactv,
		java.math.BigDecimal thipotactv,
		java.math.BigDecimal tvehicactv,
		java.lang.String cs000montocta36,
		java.math.BigDecimal tcuot36act,
		java.math.BigDecimal cs000montocta48,
		java.math.BigDecimal tcuot48act,
		java.math.BigDecimal cs000montocta60,
		java.math.BigDecimal tcuot60act,
		java.math.BigDecimal css000presmena5000,
		java.math.BigDecimal cs000comisdesemen5000,
		java.math.BigDecimal cs000pres5000a15000,
		java.math.BigDecimal c5000comdes15000act,
		java.math.BigDecimal cs000presmaya15000,
		java.math.BigDecimal comdes15000ac,
		java.math.BigDecimal cs000linminadqtc,
		java.math.BigDecimal cs000mixmonprest,
		java.math.BigDecimal cs000mixlinasistc,
		java.math.BigDecimal cs000prestcmena5000,
		java.math.BigDecimal cs000prestc500015000,
		java.math.BigDecimal cs000prestcmaya15000)
		throws javax.ejb.CreateException;
}
