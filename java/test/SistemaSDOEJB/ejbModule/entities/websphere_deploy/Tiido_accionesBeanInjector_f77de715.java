package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_acciones
 */
public interface Tiido_accionesBeanInjector_f77de715 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * findTiido_accionesByTiido_acc_epigrafe_fkKey_Local
	 */
	public void findTiido_accionesByTiido_acc_epigrafe_fkKey_Local(entities.Tiido_epigrafeKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_accionesByTiido_acc_oficina_fkKey_Local
	 */
	public void findTiido_accionesByTiido_acc_oficina_fkKey_Local(entities.Tiido_oficinaKey key, javax.resource.cci.IndexedRecord record);
}
