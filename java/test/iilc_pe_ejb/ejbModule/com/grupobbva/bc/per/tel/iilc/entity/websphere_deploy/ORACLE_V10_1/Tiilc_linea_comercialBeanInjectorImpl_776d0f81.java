package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_linea_comercialBeanInjectorImpl_776d0f81
 */
public class Tiilc_linea_comercialBeanInjectorImpl_776d0f81 implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_linea_comercialBeanInjector_776d0f81 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81)cb;
		record.set(0,concreteBean.getCod_grupo());
		record.set(1,concreteBean.getCod_lincom());
		record.set(2,concreteBean.getDes_lincom());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81)cb;
		record.set(0,concreteBean.getCod_grupo());
		record.set(1,concreteBean.getCod_lincom());
		record.set(2,concreteBean.getDes_lincom());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81)cb;
		record.set(0,concreteBean.getCod_grupo());
		record.set(1,concreteBean.getCod_lincom());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey pkey=(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey)pkeyObject;
		record.set(0,pkey.cod_grupo);
		record.set(1,pkey.cod_lincom);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81)cb;
		record.set(0,concreteBean.getCod_grupo());
		record.set(1,concreteBean.getCod_lincom());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_linea_comercial_776d0f81)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_grupo());
		record.set(1,concreteBean.getCod_lincom());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getDes_lincom());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
