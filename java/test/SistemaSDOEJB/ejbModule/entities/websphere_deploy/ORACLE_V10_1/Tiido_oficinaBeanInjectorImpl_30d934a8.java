package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_oficinaBeanInjectorImpl_30d934a8
 */
public class Tiido_oficinaBeanInjectorImpl_30d934a8 implements entities.websphere_deploy.Tiido_oficinaBeanInjector_30d934a8 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_oficina_30d934a8 concreteBean=(entities.ConcreteTiido_oficina_30d934a8)cb;
		record.set(0,concreteBean.getCod_ofic());
		record.set(1,concreteBean.getNom_ofic());
		record.set(2,concreteBean.getUsu_regi());
		record.set(3,concreteBean.getFec_regi());
		record.set(4,concreteBean.getUsu_actu());
		record.set(5,concreteBean.getFec_actu());
		record.set(6,concreteBean.getEstado());
		record.set(7,concreteBean.getTiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_oficina_30d934a8 concreteBean=(entities.ConcreteTiido_oficina_30d934a8)cb;
		record.set(0,concreteBean.getCod_ofic());
		record.set(1,concreteBean.getNom_ofic());
		record.set(2,concreteBean.getUsu_regi());
		record.set(3,concreteBean.getFec_regi());
		record.set(4,concreteBean.getUsu_actu());
		record.set(5,concreteBean.getFec_actu());
		record.set(6,concreteBean.getEstado());
		record.set(7,concreteBean.getTiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_oficina_30d934a8 concreteBean=(entities.ConcreteTiido_oficina_30d934a8)cb;
		record.set(0,concreteBean.getCod_ofic());
		record.set(7,concreteBean.getTiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbFindListaByCodOficina
	 */
	public void ejbFindListaByCodOficina(java.lang.String codOficina, javax.resource.cci.IndexedRecord record) {
		record.set(0,codOficina);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_oficinaKey pkey=(entities.Tiido_oficinaKey)pkeyObject;
		record.set(0,pkey.cod_ofic);
		record.set(1,pkey.tiido_territorio_fk_cod_terr);
	}
	/**
	 * ejbFindAllOficinaByCodTerri
	 */
	public void ejbFindAllOficinaByCodTerri(java.lang.String codTerritorio, javax.resource.cci.IndexedRecord record) {
		record.set(0,codTerritorio);
	}
	/**
	 * ejbFindByCodOficina
	 */
	public void ejbFindByCodOficina(java.lang.String codOficina, javax.resource.cci.IndexedRecord record) {
		record.set(0,codOficina);
	}
	/**
	 * findTiido_oficinaByTiido_territorio_fkKey_Local
	 */
	public void findTiido_oficinaByTiido_territorio_fkKey_Local(entities.Tiido_territorioKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_terr);
	}
	/**
	 * findTiido_acc_oficina_fkByTiido_accionesKey_Local
	 */
	public void findTiido_acc_oficina_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_acci);
		record.set(1,fkey.tiido_acc_epigrafe_fk_cod_epigrafe);
		record.set(2,fkey.tiido_acc_epigrafe_fk_anho);
		record.set(3,fkey.tiido_acc_oficina_fk_cod_ofic);
		record.set(4,fkey.tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_cam_oficina_fkByTiido_campaniasKey_Local
	 */
	public void findTiido_cam_oficina_fkByTiido_campaniasKey_Local(entities.Tiido_campaniasKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_camp);
		record.set(1,fkey.anho);
		record.set(2,fkey.mes);
		record.set(3,fkey.tiido_cam_oficina_fk_cod_ofic);
		record.set(4,fkey.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_fir_oficina_fkByTiido_firmasKey_Local
	 */
	public void findTiido_fir_oficina_fkByTiido_firmasKey_Local(entities.Tiido_firmasKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_firma);
		record.set(1,fkey.tiido_fir_oficina_fk_cod_ofic);
		record.set(2,fkey.tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local
	 */
	public void findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local(entities.Tiido_maestro_planesKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.mes);
		record.set(1,fkey.anho);
		record.set(2,fkey.tiido_maepla_oficina_fk_cod_ofic);
		record.set(3,fkey.tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local
	 */
	public void findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_meta_gestor);
		record.set(1,fkey.tiido_metges_epigrafe_fk_cod_epigrafe);
		record.set(2,fkey.tiido_metges_epigrafe_fk_anho);
		record.set(3,fkey.tiido_metges_oficina_fk_cod_ofic);
		record.set(4,fkey.tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_pla_oficina_fkByTiido_planesKey_Local
	 */
	public void findTiido_pla_oficina_fkByTiido_planesKey_Local(entities.Tiido_planesKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.mes_plan);
		record.set(1,fkey.anho_plan);
		record.set(2,fkey.cod_epigrafe);
		record.set(3,fkey.tiido_pla_oficina_fk_cod_ofic);
		record.set(4,fkey.tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_oficina_30d934a8 concreteBean=(entities.ConcreteTiido_oficina_30d934a8)cb;
		record.set(0,concreteBean.getCod_ofic());
		record.set(1,concreteBean.getTiido_territorio_fk_cod_terr());
		record.set(2,concreteBean.getEstado());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_oficina_30d934a8 concreteBean=(entities.ConcreteTiido_oficina_30d934a8)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_ofic());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getNom_ofic());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getUsu_regi());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getFec_regi());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getUsu_actu());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getFec_actu());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(6,concreteBean.getEstado());
		}
		record.set(7,concreteBean.getTiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
