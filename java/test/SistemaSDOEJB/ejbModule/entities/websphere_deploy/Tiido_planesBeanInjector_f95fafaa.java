package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_planes
 */
public interface Tiido_planesBeanInjector_f95fafaa extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindConsultaPlanesPrioridad
	 */
	public void ejbFindConsultaPlanesPrioridad(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindConsultaPlanesResumen
	 */
	public void ejbFindConsultaPlanesResumen(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindPlanByObject
	 */
	public void ejbFindPlanByObject(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindConsultaPlanes
	 */
	public void ejbFindConsultaPlanes(java.lang.String codOficina, java.lang.String anho, java.lang.String mes, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindConsultarPlanesxMes
	 */
	public void ejbFindConsultarPlanesxMes(java.lang.String codOficina, java.lang.String anho, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_planesByTiido_pla_oficina_fkKey_Local
	 */
	public void findTiido_planesByTiido_pla_oficina_fkKey_Local(entities.Tiido_oficinaKey key, javax.resource.cci.IndexedRecord record);
}
