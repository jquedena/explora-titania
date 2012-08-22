package entities.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: Tiido_oficina
 */
public interface Tiido_oficinaBeanInjector_30d934a8 extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByCodOficina
	 */
	public void ejbFindByCodOficina(java.lang.String codOficina, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindAllOficinaByCodTerri
	 */
	public void ejbFindAllOficinaByCodTerri(java.lang.String codTerritorio, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindListaByCodOficina
	 */
	public void ejbFindListaByCodOficina(java.lang.String codOficina, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_oficinaByTiido_territorio_fkKey_Local
	 */
	public void findTiido_oficinaByTiido_territorio_fkKey_Local(entities.Tiido_territorioKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_acc_oficina_fkByTiido_accionesKey_Local
	 */
	public void findTiido_acc_oficina_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_cam_oficina_fkByTiido_campaniasKey_Local
	 */
	public void findTiido_cam_oficina_fkByTiido_campaniasKey_Local(entities.Tiido_campaniasKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_fir_oficina_fkByTiido_firmasKey_Local
	 */
	public void findTiido_fir_oficina_fkByTiido_firmasKey_Local(entities.Tiido_firmasKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local
	 */
	public void findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local(entities.Tiido_maestro_planesKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local
	 */
	public void findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTiido_pla_oficina_fkByTiido_planesKey_Local
	 */
	public void findTiido_pla_oficina_fkByTiido_planesKey_Local(entities.Tiido_planesKey key, javax.resource.cci.IndexedRecord record);
}
