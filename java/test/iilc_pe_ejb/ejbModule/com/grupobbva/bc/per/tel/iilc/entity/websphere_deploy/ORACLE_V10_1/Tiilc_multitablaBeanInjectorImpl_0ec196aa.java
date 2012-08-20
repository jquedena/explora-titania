package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_multitablaBeanInjectorImpl_0ec196aa
 */
public class Tiilc_multitablaBeanInjectorImpl_0ec196aa implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_multitablaBeanInjector_0ec196aa {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa)cb;
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_ele());
		record.set(2,concreteBean.getValor1());
		record.set(3,concreteBean.getValor2());
		record.set(4,concreteBean.getValor3());
		record.set(5,concreteBean.getValor4());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa)cb;
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_ele());
		record.set(2,concreteBean.getValor1());
		record.set(3,concreteBean.getValor2());
		record.set(4,concreteBean.getValor3());
		record.set(5,concreteBean.getValor4());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa)cb;
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_ele());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey pkey=(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey)pkeyObject;
		record.set(0,pkey.cod_mult);
		record.set(1,pkey.cod_ele);
	}
	/**
	 * ejbFindAllRecord
	 */
	public void ejbFindAllRecord(java.lang.String cod_mult, javax.resource.cci.IndexedRecord record) {
		record.set(0,cod_mult);
	}
	/**
	 * ejbFindRecord
	 */
	public void ejbFindRecord(java.lang.String codigo, javax.resource.cci.IndexedRecord record) {
		record.set(0,codigo);
		record.set(1,codigo);
		record.set(2,codigo);
	}
	/**
	 * ejbFindMultitablaxValor2
	 */
	public void ejbFindMultitablaxValor2(java.lang.String valor2, javax.resource.cci.IndexedRecord record) {
		record.set(0,valor2);
	}
	/**
	 * ejbFindMultitabla
	 */
	public void ejbFindMultitabla(java.lang.String cod_mult, java.lang.String cod_ele, javax.resource.cci.IndexedRecord record) {
		record.set(0,cod_mult);
		record.set(1,cod_ele);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa)cb;
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_ele());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_multitabla_0ec196aa)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_ele());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getValor1());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getValor2());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getValor3());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getValor4());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
