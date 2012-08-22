package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_metas_gestorBeanInjectorImpl_238e66e0
 */
public class Tiido_metas_gestorBeanInjectorImpl_238e66e0 implements entities.websphere_deploy.Tiido_metas_gestorBeanInjector_238e66e0 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_metas_gestor_238e66e0 concreteBean=(entities.ConcreteTiido_metas_gestor_238e66e0)cb;
		record.set(0,concreteBean.getCod_meta_gestor());
		record.set(1,concreteBean.getCod_gestor());
		record.set(2,concreteBean.getMes());
		record.set(3,concreteBean.getOrden());
		record.set(4,concreteBean.getFec_regi());
		record.set(5,concreteBean.getPorc_asig());
		record.set(6,concreteBean.getNom_epigrafe());
		record.set(7,concreteBean.getNom_gestor());
		record.set(8,concreteBean.getCod_perfil_gestor());
		record.set(9,concreteBean.getEstado());
		record.set(10,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_actu()));
		record.set(11,concreteBean.getUsu_regi());
		record.set(12,concreteBean.getUsu_actu());
		record.set(13,concreteBean.getTiido_metges_epigrafe_fk_cod_epigrafe());
		record.set(14,concreteBean.getTiido_metges_epigrafe_fk_anho());
		record.set(15,concreteBean.getTiido_metges_oficina_fk_cod_ofic());
		record.set(16,concreteBean.getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_metas_gestor_238e66e0 concreteBean=(entities.ConcreteTiido_metas_gestor_238e66e0)cb;
		record.set(0,concreteBean.getCod_meta_gestor());
		record.set(1,concreteBean.getCod_gestor());
		record.set(2,concreteBean.getMes());
		record.set(3,concreteBean.getOrden());
		record.set(4,concreteBean.getFec_regi());
		record.set(5,concreteBean.getPorc_asig());
		record.set(6,concreteBean.getNom_epigrafe());
		record.set(7,concreteBean.getNom_gestor());
		record.set(8,concreteBean.getCod_perfil_gestor());
		record.set(9,concreteBean.getEstado());
		record.set(10,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_actu()));
		record.set(11,concreteBean.getUsu_regi());
		record.set(12,concreteBean.getUsu_actu());
		record.set(13,concreteBean.getTiido_metges_epigrafe_fk_cod_epigrafe());
		record.set(14,concreteBean.getTiido_metges_epigrafe_fk_anho());
		record.set(15,concreteBean.getTiido_metges_oficina_fk_cod_ofic());
		record.set(16,concreteBean.getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_metas_gestor_238e66e0 concreteBean=(entities.ConcreteTiido_metas_gestor_238e66e0)cb;
		record.set(0,concreteBean.getCod_meta_gestor());
		record.set(13,concreteBean.getTiido_metges_epigrafe_fk_cod_epigrafe());
		record.set(14,concreteBean.getTiido_metges_epigrafe_fk_anho());
		record.set(15,concreteBean.getTiido_metges_oficina_fk_cod_ofic());
		record.set(16,concreteBean.getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbFindMetGestorByPrimaryKey
	 */
	public void ejbFindMetGestorByPrimaryKey(java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String codGestor, javax.resource.cci.IndexedRecord record) {
		record.set(0,codEpigrafe);
		record.set(1,anho);
		record.set(2,codOficina);
		record.set(3,mes);
		record.set(4,codGestor);
	}
	/**
	 * ejbFindGestorByCodigo
	 */
	public void ejbFindGestorByCodigo(java.lang.String codGestor, javax.resource.cci.IndexedRecord record) {
		record.set(0,codGestor);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_metas_gestorKey pkey=(entities.Tiido_metas_gestorKey)pkeyObject;
		record.set(0,pkey.cod_meta_gestor);
		record.set(1,pkey.tiido_metges_epigrafe_fk_cod_epigrafe);
		record.set(2,pkey.tiido_metges_epigrafe_fk_anho);
		record.set(3,pkey.tiido_metges_oficina_fk_cod_ofic);
		record.set(4,pkey.tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local
	 */
	public void findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(entities.Tiido_epigrafeKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_epigrafe);
		record.set(1,fkey.anho);
	}
	/**
	 * findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local
	 */
	public void findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(entities.Tiido_oficinaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_ofic);
		record.set(1,fkey.tiido_territorio_fk_cod_terr);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_metas_gestor_238e66e0 concreteBean=(entities.ConcreteTiido_metas_gestor_238e66e0)cb;
		record.set(0,concreteBean.getCod_meta_gestor());
		record.set(1,concreteBean.getTiido_metges_epigrafe_fk_cod_epigrafe());
		record.set(2,concreteBean.getTiido_metges_epigrafe_fk_anho());
		record.set(3,concreteBean.getTiido_metges_oficina_fk_cod_ofic());
		record.set(4,concreteBean.getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr());
		record.set(5,concreteBean.getCod_perfil_gestor());
		record.set(6,concreteBean.getEstado());
		record.set(7,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_actu()));
		record.set(8,concreteBean.getUsu_regi());
		record.set(9,concreteBean.getUsu_actu());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_metas_gestor_238e66e0 concreteBean=(entities.ConcreteTiido_metas_gestor_238e66e0)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_meta_gestor());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getCod_gestor());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getMes());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getOrden());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getFec_regi());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getPorc_asig());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getNom_epigrafe());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getNom_gestor());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(8,concreteBean.getCod_perfil_gestor());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(9,concreteBean.getEstado());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(10,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_actu()));
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(11,concreteBean.getUsu_regi());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(12,concreteBean.getUsu_actu());
		}
		record.set(13,concreteBean.getTiido_metges_epigrafe_fk_cod_epigrafe());
		record.set(14,concreteBean.getTiido_metges_epigrafe_fk_anho());
		record.set(15,concreteBean.getTiido_metges_oficina_fk_cod_ofic());
		record.set(16,concreteBean.getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
