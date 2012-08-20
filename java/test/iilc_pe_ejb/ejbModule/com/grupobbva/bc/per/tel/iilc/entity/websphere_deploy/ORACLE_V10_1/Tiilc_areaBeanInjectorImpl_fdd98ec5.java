package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_areaBeanInjectorImpl_fdd98ec5
 */
public class Tiilc_areaBeanInjectorImpl_fdd98ec5 implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_areaBeanInjector_fdd98ec5 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5)cb;
		record.set(0,concreteBean.getCod_area());
		record.set(1,concreteBean.getDes_area());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5)cb;
		record.set(0,concreteBean.getCod_area());
		record.set(1,concreteBean.getDes_area());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5)cb;
		record.set(0,concreteBean.getCod_area());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey pkey=(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey)pkeyObject;
		record.set(0,pkey.cod_area);
	}
	/**
	 * findTiilc_area_fkByTiilc_territorioKey_Local
	 */
	public void findTiilc_area_fkByTiilc_territorioKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_territorio);
		record.set(1,fkey.tiilc_area_fk_cod_area);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5)cb;
		record.set(0,concreteBean.getCod_area());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_area_fdd98ec5)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_area());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getDes_area());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
