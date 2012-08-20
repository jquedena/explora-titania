package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_empresaBeanInjectorImpl_d572bb0f
 */
public class Tiilc_empresaBeanInjectorImpl_d572bb0f implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_empresaBeanInjector_d572bb0f {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f)cb;
		record.set(0,concreteBean.getCod_empresa());
		record.set(1,concreteBean.getDes_empresa());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f)cb;
		record.set(0,concreteBean.getCod_empresa());
		record.set(1,concreteBean.getDes_empresa());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f)cb;
		record.set(0,concreteBean.getCod_empresa());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey pkey=(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey)pkeyObject;
		record.set(0,pkey.cod_empresa);
	}
	/**
	 * ejbFindEmpresaxCodigo
	 */
	public void ejbFindEmpresaxCodigo(java.lang.String cod_empresa, javax.resource.cci.IndexedRecord record) {
		record.set(0,cod_empresa);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f)cb;
		record.set(0,concreteBean.getCod_empresa());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_empresa_d572bb0f)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_empresa());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getDes_empresa());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
