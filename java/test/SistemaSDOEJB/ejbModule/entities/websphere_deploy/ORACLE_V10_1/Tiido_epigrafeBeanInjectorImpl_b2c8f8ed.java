package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_epigrafeBeanInjectorImpl_b2c8f8ed
 */
public class Tiido_epigrafeBeanInjectorImpl_b2c8f8ed implements entities.websphere_deploy.Tiido_epigrafeBeanInjector_b2c8f8ed {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_epigrafe_b2c8f8ed concreteBean=(entities.ConcreteTiido_epigrafe_b2c8f8ed)cb;
		record.set(0,concreteBean.getCod_epigrafe());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getNom_epigrafe());
		record.set(3,concreteBean.getInd_clase());
		record.set(4,concreteBean.getInd_sub_clase());
		record.set(5,concreteBean.getOrden());
		record.set(6,concreteBean.getInd_grupo());
		record.set(7,concreteBean.getAbreviatura());
		record.set(8,concreteBean.getInd_hijo());
		record.set(9,concreteBean.getInd_afecta());
		record.set(10,concreteBean.getPorcentaje_max());
		record.set(11,concreteBean.getPorcentaje_min());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_epigrafe_b2c8f8ed concreteBean=(entities.ConcreteTiido_epigrafe_b2c8f8ed)cb;
		record.set(0,concreteBean.getCod_epigrafe());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getNom_epigrafe());
		record.set(3,concreteBean.getInd_clase());
		record.set(4,concreteBean.getInd_sub_clase());
		record.set(5,concreteBean.getOrden());
		record.set(6,concreteBean.getInd_grupo());
		record.set(7,concreteBean.getAbreviatura());
		record.set(8,concreteBean.getInd_hijo());
		record.set(9,concreteBean.getInd_afecta());
		record.set(10,concreteBean.getPorcentaje_max());
		record.set(11,concreteBean.getPorcentaje_min());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_epigrafe_b2c8f8ed concreteBean=(entities.ConcreteTiido_epigrafe_b2c8f8ed)cb;
		record.set(0,concreteBean.getCod_epigrafe());
		record.set(1,concreteBean.getAnho());
	}
	/**
	 * ejbFindByCodEpigAnho
	 */
	public void ejbFindByCodEpigAnho(java.lang.String codEpigrafe, java.lang.String anho, javax.resource.cci.IndexedRecord record) {
		record.set(0,codEpigrafe);
		record.set(1,anho);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_epigrafeKey pkey=(entities.Tiido_epigrafeKey)pkeyObject;
		record.set(0,pkey.cod_epigrafe);
		record.set(1,pkey.anho);
	}
	/**
	 * ejbFindEpiByAnho
	 */
	public void ejbFindEpiByAnho(java.lang.String anho, javax.resource.cci.IndexedRecord record) {
		record.set(0,anho);
	}
	/**
	 * ejbFindByCodEpig
	 */
	public void ejbFindByCodEpig(java.lang.String codEpigrafe, javax.resource.cci.IndexedRecord record) {
		record.set(0,codEpigrafe);
	}
	/**
	 * findTiido_acc_epigrafe_fkByTiido_accionesKey_Local
	 */
	public void findTiido_acc_epigrafe_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_acci);
		record.set(1,fkey.tiido_acc_epigrafe_fk_cod_epigrafe);
		record.set(2,fkey.tiido_acc_epigrafe_fk_anho);
		record.set(3,fkey.tiido_acc_oficina_fk_cod_ofic);
		record.set(4,fkey.tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local
	 */
	public void findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_meta_gestor);
		record.set(1,fkey.tiido_metges_epigrafe_fk_cod_epigrafe);
		record.set(2,fkey.tiido_metges_epigrafe_fk_anho);
		record.set(3,fkey.tiido_metges_oficina_fk_cod_ofic);
		record.set(4,fkey.tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_epigrafe_b2c8f8ed concreteBean=(entities.ConcreteTiido_epigrafe_b2c8f8ed)cb;
		record.set(0,concreteBean.getCod_epigrafe());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getPorcentaje_max());
		record.set(3,concreteBean.getPorcentaje_min());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_epigrafe_b2c8f8ed concreteBean=(entities.ConcreteTiido_epigrafe_b2c8f8ed)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_epigrafe());
		record.set(1,concreteBean.getAnho());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getNom_epigrafe());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getInd_clase());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getInd_sub_clase());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getOrden());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getInd_grupo());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getAbreviatura());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getInd_hijo());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getInd_afecta());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getPorcentaje_max());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getPorcentaje_min());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
