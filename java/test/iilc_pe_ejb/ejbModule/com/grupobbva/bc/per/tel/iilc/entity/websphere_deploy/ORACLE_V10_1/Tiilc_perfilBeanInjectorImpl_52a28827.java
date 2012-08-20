package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_perfilBeanInjectorImpl_52a28827
 */
public class Tiilc_perfilBeanInjectorImpl_52a28827 implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_perfilBeanInjector_52a28827 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getDes_perfil());
		record.set(2,concreteBean.getComponente());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getDes_perfil());
		record.set(2,concreteBean.getComponente());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827)cb;
		record.set(0,concreteBean.getCod_perfil());
	}
	/**
	 * ejbFindPerfil
	 */
	public void ejbFindPerfil(java.lang.String cod_perfil, javax.resource.cci.IndexedRecord record) {
		record.set(0,cod_perfil);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey pkey=(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey)pkeyObject;
		record.set(0,pkey.cod_perfil);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827)cb;
		record.set(0,concreteBean.getCod_perfil());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827 concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_perfil_52a28827)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_perfil());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getDes_perfil());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getComponente());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
