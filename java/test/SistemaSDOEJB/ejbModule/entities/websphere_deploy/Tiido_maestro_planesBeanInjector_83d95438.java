package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_maestro_planes
 */
public interface Tiido_maestro_planesBeanInjector_83d95438 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindUbicar
	 */
	public void ejbFindUbicar(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local
	 */
	public void findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local(entities.Tiido_oficinaKey key, javax.resource.cci.IndexedRecord record);
}
