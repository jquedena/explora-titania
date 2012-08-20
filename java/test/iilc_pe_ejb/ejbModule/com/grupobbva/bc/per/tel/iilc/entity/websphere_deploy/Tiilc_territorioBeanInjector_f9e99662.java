package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiilc_territorio
 */
public interface Tiilc_territorioBeanInjector_f9e99662 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindAllTerritorioxAr
	 */
	public void ejbFindAllTerritorioxAr(java.lang.String cod_area, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiilc_territorioByTiilc_area_fkKey_Local
	 */
	public void findTiilc_territorioByTiilc_area_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiilc_territorio_fkByTiilc_oficinaKey_Local
	 */
	public void findTiilc_territorio_fkByTiilc_oficinaKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key, javax.resource.cci.IndexedRecord record);
}
