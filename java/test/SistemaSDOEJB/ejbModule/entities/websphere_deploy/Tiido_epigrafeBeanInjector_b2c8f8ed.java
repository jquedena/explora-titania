package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_epigrafe
 */
public interface Tiido_epigrafeBeanInjector_b2c8f8ed extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByCodEpig
	 */
	public void ejbFindByCodEpig(java.lang.String codEpigrafe, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByCodEpigAnho
	 */
	public void ejbFindByCodEpigAnho(java.lang.String codEpigrafe, java.lang.String anho, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindEpiByAnho
	 */
	public void ejbFindEpiByAnho(java.lang.String anho, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_acc_epigrafe_fkByTiido_accionesKey_Local
	 */
	public void findTiido_acc_epigrafe_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local
	 */
	public void findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key, javax.resource.cci.IndexedRecord record);
}
