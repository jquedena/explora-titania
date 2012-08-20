package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_territorioBeanInjectorImpl_f9e99662
 */
public class Tiilc_territorioBeanInjectorImpl_f9e99662 implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanInjector_f9e99662 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662)cb;
		record.set(0,concreteBean.getCod_territorio());
		record.set(1,concreteBean.getDes_territorio());
		record.set(2,concreteBean.getTiilc_area_fk_cod_area());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662)cb;
		record.set(0,concreteBean.getCod_territorio());
		record.set(1,concreteBean.getDes_territorio());
		record.set(2,concreteBean.getTiilc_area_fk_cod_area());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662)cb;
		record.set(0,concreteBean.getCod_territorio());
		record.set(2,concreteBean.getTiilc_area_fk_cod_area());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey pkey=(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey)pkeyObject;
		record.set(0,pkey.cod_territorio);
		record.set(1,pkey.tiilc_area_fk_cod_area);
	}
	/**
	 * ejbFindAllTerritorioxAr
	 */
	public void ejbFindAllTerritorioxAr(java.lang.String cod_area, javax.resource.cci.IndexedRecord record) {
		record.set(0,cod_area);
	}
	/**
	 * findTiilc_territorioByTiilc_area_fkKey_Local
	 */
	public void findTiilc_territorioByTiilc_area_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_area);
	}
	/**
	 * findTiilc_territorio_fkByTiilc_oficinaKey_Local
	 */
	public void findTiilc_territorio_fkByTiilc_oficinaKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_oficina);
		record.set(1,fkey.tiilc_territorio_fk_cod_territorio);
		record.set(2,fkey.tiilc_territorio_fk_tiilc_area_fk_cod_area);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662)cb;
		record.set(0,concreteBean.getCod_territorio());
		record.set(1,concreteBean.getTiilc_area_fk_cod_area());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_territorio_f9e99662)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_territorio());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getDes_territorio());
		}
		record.set(2,concreteBean.getTiilc_area_fk_cod_area());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
