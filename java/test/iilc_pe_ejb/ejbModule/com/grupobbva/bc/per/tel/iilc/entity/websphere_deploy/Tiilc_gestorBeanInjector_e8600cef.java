package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiilc_gestor
 */
public interface Tiilc_gestorBeanInjector_e8600cef extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindGestorxRegGestor
	 */
	public void ejbFindGestorxRegGestor(java.lang.String reg_gestor, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindAllGestor
	 */
	public void ejbFindAllGestor(java.lang.String cod_area, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindAllGestorxOfxTexAr
	 */
	public void ejbFindAllGestorxOfxTexAr(java.lang.String cod_oficina, java.lang.String cod_territorio, java.lang.String cod_area, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiilc_gestorByTiilc_oficina_fkKey_Local
	 */
	public void findTiilc_gestorByTiilc_oficina_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key, javax.resource.cci.IndexedRecord record);
}
