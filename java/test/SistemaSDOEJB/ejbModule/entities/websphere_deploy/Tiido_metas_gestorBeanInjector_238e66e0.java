package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_metas_gestor
 */
public interface Tiido_metas_gestorBeanInjector_238e66e0 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindGestorByCodigo
	 */
	public void ejbFindGestorByCodigo(java.lang.String codGestor, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindMetGestorByPrimaryKey
	 */
	public void ejbFindMetGestorByPrimaryKey(java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String codGestor, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local
	 */
	public void findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(entities.Tiido_epigrafeKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local
	 */
	public void findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(entities.Tiido_oficinaKey key, javax.resource.cci.IndexedRecord record);
}
