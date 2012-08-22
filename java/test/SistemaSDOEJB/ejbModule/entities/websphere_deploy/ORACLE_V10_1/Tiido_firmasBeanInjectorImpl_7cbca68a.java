package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_firmasBeanInjectorImpl_7cbca68a
 */
public class Tiido_firmasBeanInjectorImpl_7cbca68a implements entities.websphere_deploy.Tiido_firmasBeanInjector_7cbca68a {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_firmas_7cbca68a concreteBean=(entities.ConcreteTiido_firmas_7cbca68a)cb;
		record.set(0,concreteBean.getCod_firma());
		record.set(1,concreteBean.getAnho_firm());
		record.set(2,concreteBean.getMes_firm());
		record.set(3,concreteBean.getItem_firm());
		record.set(4,concreteBean.getCod_gestor());
		record.set(5,concreteBean.getDescripcion());
		record.set(6,concreteBean.getFec_firm());
		record.set(7,concreteBean.getTiido_fir_oficina_fk_cod_ofic());
		record.set(8,concreteBean.getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_firmas_7cbca68a concreteBean=(entities.ConcreteTiido_firmas_7cbca68a)cb;
		record.set(0,concreteBean.getCod_firma());
		record.set(1,concreteBean.getAnho_firm());
		record.set(2,concreteBean.getMes_firm());
		record.set(3,concreteBean.getItem_firm());
		record.set(4,concreteBean.getCod_gestor());
		record.set(5,concreteBean.getDescripcion());
		record.set(6,concreteBean.getFec_firm());
		record.set(7,concreteBean.getTiido_fir_oficina_fk_cod_ofic());
		record.set(8,concreteBean.getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_firmas_7cbca68a concreteBean=(entities.ConcreteTiido_firmas_7cbca68a)cb;
		record.set(0,concreteBean.getCod_firma());
		record.set(7,concreteBean.getTiido_fir_oficina_fk_cod_ofic());
		record.set(8,concreteBean.getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbFindFirmByAnoMesCgesItem
	 */
	public void ejbFindFirmByAnoMesCgesItem(java.lang.String anho, java.lang.String mes, java.lang.String codGestor, java.lang.String item, javax.resource.cci.IndexedRecord record) {
		record.set(0,anho);
		record.set(1,mes);
		record.set(2,codGestor);
		record.set(3,item);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_firmasKey pkey=(entities.Tiido_firmasKey)pkeyObject;
		record.set(0,pkey.cod_firma);
		record.set(1,pkey.tiido_fir_oficina_fk_cod_ofic);
		record.set(2,pkey.tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_firmasByTiido_fir_oficina_fkKey_Local
	 */
	public void findTiido_firmasByTiido_fir_oficina_fkKey_Local(entities.Tiido_oficinaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_ofic);
		record.set(1,fkey.tiido_territorio_fk_cod_terr);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_firmas_7cbca68a concreteBean=(entities.ConcreteTiido_firmas_7cbca68a)cb;
		record.set(0,concreteBean.getCod_firma());
		record.set(1,concreteBean.getTiido_fir_oficina_fk_cod_ofic());
		record.set(2,concreteBean.getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_firmas_7cbca68a concreteBean=(entities.ConcreteTiido_firmas_7cbca68a)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_firma());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getAnho_firm());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getMes_firm());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getItem_firm());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getCod_gestor());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getDescripcion());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getFec_firm());
		}
		record.set(7,concreteBean.getTiido_fir_oficina_fk_cod_ofic());
		record.set(8,concreteBean.getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
