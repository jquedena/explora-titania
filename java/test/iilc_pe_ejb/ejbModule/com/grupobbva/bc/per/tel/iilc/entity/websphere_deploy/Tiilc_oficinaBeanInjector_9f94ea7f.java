package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiilc_oficina
 */
public interface Tiilc_oficinaBeanInjector_9f94ea7f extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindAllOficinaxCod_oficina
	 */
	public void ejbFindAllOficinaxCod_oficina(java.lang.String cod_oficina, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindAllOficinaxTer
	 */
	public void ejbFindAllOficinaxTer(java.lang.String cod_territorio, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiilc_oficinaByTiilc_territorio_fkKey_Local
	 */
	public void findTiilc_oficinaByTiilc_territorio_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiilc_oficina_fkByTiilc_gestorKey_Local
	 */
	public void findTiilc_oficina_fkByTiilc_gestorKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey key, javax.resource.cci.IndexedRecord record);
}
