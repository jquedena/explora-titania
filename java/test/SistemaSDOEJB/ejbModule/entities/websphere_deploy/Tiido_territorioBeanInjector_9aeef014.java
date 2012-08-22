package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_territorio
 */
public interface Tiido_territorioBeanInjector_9aeef014 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByCodTerritorio
	 */
	public void ejbFindByCodTerritorio(java.lang.String codTerritorio, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_territorio_fkByTiido_oficinaKey_Local
	 */
	public void findTiido_territorio_fkByTiido_oficinaKey_Local(entities.Tiido_oficinaKey key, javax.resource.cci.IndexedRecord record);
}
