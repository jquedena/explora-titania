package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiilc_multitabla
 */
public interface Tiilc_multitablaBeanInjector_0ec196aa extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindMultitabla
	 */
	public void ejbFindMultitabla(java.lang.String cod_mult, java.lang.String cod_ele, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindRecord
	 */
	public void ejbFindRecord(java.lang.String codigo, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindAllRecord
	 */
	public void ejbFindAllRecord(java.lang.String cod_mult, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindMultitablaxValor2
	 */
	public void ejbFindMultitablaxValor2(java.lang.String valor2, javax.resource.cci.IndexedRecord record);
}
