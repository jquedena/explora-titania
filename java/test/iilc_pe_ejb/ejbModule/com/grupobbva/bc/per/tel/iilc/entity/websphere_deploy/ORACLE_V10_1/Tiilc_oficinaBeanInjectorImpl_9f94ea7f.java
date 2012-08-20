package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_oficinaBeanInjectorImpl_9f94ea7f
 */
public class Tiilc_oficinaBeanInjectorImpl_9f94ea7f implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanInjector_9f94ea7f {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f)cb;
		record.set(0,concreteBean.getCod_oficina());
		record.set(1,concreteBean.getDes_oficina());
		record.set(2,concreteBean.getTiilc_territorio_fk_cod_territorio());
		record.set(3,concreteBean.getTiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f)cb;
		record.set(0,concreteBean.getCod_oficina());
		record.set(1,concreteBean.getDes_oficina());
		record.set(2,concreteBean.getTiilc_territorio_fk_cod_territorio());
		record.set(3,concreteBean.getTiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f)cb;
		record.set(0,concreteBean.getCod_oficina());
		record.set(2,concreteBean.getTiilc_territorio_fk_cod_territorio());
		record.set(3,concreteBean.getTiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbFindAllOficinaxTer
	 */
	public void ejbFindAllOficinaxTer(java.lang.String cod_territorio, javax.resource.cci.IndexedRecord record) {
		record.set(0,cod_territorio);
	}
	/**
	 * ejbFindAllOficinaxCod_oficina
	 */
	public void ejbFindAllOficinaxCod_oficina(java.lang.String cod_oficina, javax.resource.cci.IndexedRecord record) {
		record.set(0,cod_oficina);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey pkey=(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey)pkeyObject;
		record.set(0,pkey.cod_oficina);
		record.set(1,pkey.tiilc_territorio_fk_cod_territorio);
		record.set(2,pkey.tiilc_territorio_fk_tiilc_area_fk_cod_area);
	}
	/**
	 * findTiilc_oficinaByTiilc_territorio_fkKey_Local
	 */
	public void findTiilc_oficinaByTiilc_territorio_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_territorio);
		record.set(1,fkey.tiilc_area_fk_cod_area);
	}
	/**
	 * findTiilc_oficina_fkByTiilc_gestorKey_Local
	 */
	public void findTiilc_oficina_fkByTiilc_gestorKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_gestor);
		record.set(1,fkey.tiilc_oficina_fk_cod_oficina);
		record.set(2,fkey.tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio);
		record.set(3,fkey.tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f)cb;
		record.set(0,concreteBean.getCod_oficina());
		record.set(1,concreteBean.getTiilc_territorio_fk_cod_territorio());
		record.set(2,concreteBean.getTiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_oficina_9f94ea7f)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_oficina());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getDes_oficina());
		}
		record.set(2,concreteBean.getTiilc_territorio_fk_cod_territorio());
		record.set(3,concreteBean.getTiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
