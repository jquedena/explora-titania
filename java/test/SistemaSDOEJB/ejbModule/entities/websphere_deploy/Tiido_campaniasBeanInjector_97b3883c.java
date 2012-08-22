package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_campanias
 */
public interface Tiido_campaniasBeanInjector_97b3883c extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * findTiido_campaniasByTiido_cam_oficina_fkKey_Local
	 */
	public void findTiido_campaniasByTiido_cam_oficina_fkKey_Local(entities.Tiido_oficinaKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local
	 */
	public void findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local(entities.Tiido_campanias_detalleKey key, javax.resource.cci.IndexedRecord record);
}
