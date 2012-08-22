package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_firmas
 */
public interface Tiido_firmasBeanInjector_7cbca68a extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindFirmByAnoMesCgesItem
	 */
	public void ejbFindFirmByAnoMesCgesItem(java.lang.String anho, java.lang.String mes, java.lang.String codGestor, java.lang.String item, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_firmasByTiido_fir_oficina_fkKey_Local
	 */
	public void findTiido_firmasByTiido_fir_oficina_fkKey_Local(entities.Tiido_oficinaKey key, javax.resource.cci.IndexedRecord record);
}
