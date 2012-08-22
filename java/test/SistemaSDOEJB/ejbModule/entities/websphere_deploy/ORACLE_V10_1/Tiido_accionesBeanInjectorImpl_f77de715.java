package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_accionesBeanInjectorImpl_f77de715
 */
public class Tiido_accionesBeanInjectorImpl_f77de715 implements entities.websphere_deploy.Tiido_accionesBeanInjector_f77de715 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_acciones_f77de715 concreteBean=(entities.ConcreteTiido_acciones_f77de715)cb;
		record.set(0,concreteBean.getCod_acci());
		record.set(1,concreteBean.getNom_acci());
		record.set(2,concreteBean.getCod_gest());
		record.set(3,concreteBean.getMes_acci());
		record.set(4,concreteBean.getNro_clie());
		record.set(5,concreteBean.getComp_gest());
		record.set(6,concreteBean.getNro_gest_segu_1());
		record.set(7,concreteBean.getNro_conc_segu_1());
		record.set(8,concreteBean.getMon_segu_1());
		record.set(9,concreteBean.getNro_gest_segu_2());
		record.set(10,concreteBean.getNro_conc_segu_2());
		record.set(11,concreteBean.getMon_segu_2());
		record.set(12,concreteBean.getFec_segu_1());
		record.set(13,concreteBean.getFec_segu_2());
		record.set(14,concreteBean.getUsu_regi());
		record.set(15,concreteBean.getUsu_actu());
		record.set(16,concreteBean.getFec_regi());
		record.set(17,concreteBean.getFec_actu());
		record.set(18,concreteBean.getTiido_acc_epigrafe_fk_cod_epigrafe());
		record.set(19,concreteBean.getTiido_acc_epigrafe_fk_anho());
		record.set(20,concreteBean.getTiido_acc_oficina_fk_cod_ofic());
		record.set(21,concreteBean.getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_acciones_f77de715 concreteBean=(entities.ConcreteTiido_acciones_f77de715)cb;
		record.set(0,concreteBean.getCod_acci());
		record.set(1,concreteBean.getNom_acci());
		record.set(2,concreteBean.getCod_gest());
		record.set(3,concreteBean.getMes_acci());
		record.set(4,concreteBean.getNro_clie());
		record.set(5,concreteBean.getComp_gest());
		record.set(6,concreteBean.getNro_gest_segu_1());
		record.set(7,concreteBean.getNro_conc_segu_1());
		record.set(8,concreteBean.getMon_segu_1());
		record.set(9,concreteBean.getNro_gest_segu_2());
		record.set(10,concreteBean.getNro_conc_segu_2());
		record.set(11,concreteBean.getMon_segu_2());
		record.set(12,concreteBean.getFec_segu_1());
		record.set(13,concreteBean.getFec_segu_2());
		record.set(14,concreteBean.getUsu_regi());
		record.set(15,concreteBean.getUsu_actu());
		record.set(16,concreteBean.getFec_regi());
		record.set(17,concreteBean.getFec_actu());
		record.set(18,concreteBean.getTiido_acc_epigrafe_fk_cod_epigrafe());
		record.set(19,concreteBean.getTiido_acc_epigrafe_fk_anho());
		record.set(20,concreteBean.getTiido_acc_oficina_fk_cod_ofic());
		record.set(21,concreteBean.getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_acciones_f77de715 concreteBean=(entities.ConcreteTiido_acciones_f77de715)cb;
		record.set(0,concreteBean.getCod_acci());
		record.set(18,concreteBean.getTiido_acc_epigrafe_fk_cod_epigrafe());
		record.set(19,concreteBean.getTiido_acc_epigrafe_fk_anho());
		record.set(20,concreteBean.getTiido_acc_oficina_fk_cod_ofic());
		record.set(21,concreteBean.getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_accionesKey pkey=(entities.Tiido_accionesKey)pkeyObject;
		record.set(0,pkey.cod_acci);
		record.set(1,pkey.tiido_acc_epigrafe_fk_cod_epigrafe);
		record.set(2,pkey.tiido_acc_epigrafe_fk_anho);
		record.set(3,pkey.tiido_acc_oficina_fk_cod_ofic);
		record.set(4,pkey.tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_accionesByTiido_acc_epigrafe_fkKey_Local
	 */
	public void findTiido_accionesByTiido_acc_epigrafe_fkKey_Local(entities.Tiido_epigrafeKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_epigrafe);
		record.set(1,fkey.anho);
	}
	/**
	 * findTiido_accionesByTiido_acc_oficina_fkKey_Local
	 */
	public void findTiido_accionesByTiido_acc_oficina_fkKey_Local(entities.Tiido_oficinaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_ofic);
		record.set(1,fkey.tiido_territorio_fk_cod_terr);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_acciones_f77de715 concreteBean=(entities.ConcreteTiido_acciones_f77de715)cb;
		record.set(0,concreteBean.getCod_acci());
		record.set(1,concreteBean.getTiido_acc_epigrafe_fk_cod_epigrafe());
		record.set(2,concreteBean.getTiido_acc_epigrafe_fk_anho());
		record.set(3,concreteBean.getTiido_acc_oficina_fk_cod_ofic());
		record.set(4,concreteBean.getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_acciones_f77de715 concreteBean=(entities.ConcreteTiido_acciones_f77de715)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_acci());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getNom_acci());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getCod_gest());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getMes_acci());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getNro_clie());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getComp_gest());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getNro_gest_segu_1());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getNro_conc_segu_1());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getMon_segu_1());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getNro_gest_segu_2());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getNro_conc_segu_2());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getMon_segu_2());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getFec_segu_1());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,concreteBean.getFec_segu_2());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,concreteBean.getUsu_regi());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(15,concreteBean.getUsu_actu());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(16,concreteBean.getFec_regi());
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(17,concreteBean.getFec_actu());
		}
		record.set(18,concreteBean.getTiido_acc_epigrafe_fk_cod_epigrafe());
		record.set(19,concreteBean.getTiido_acc_epigrafe_fk_anho());
		record.set(20,concreteBean.getTiido_acc_oficina_fk_cod_ofic());
		record.set(21,concreteBean.getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
