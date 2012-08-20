package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_gestorBeanInjectorImpl_e8600cef
 */
public class Tiilc_gestorBeanInjectorImpl_e8600cef implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_gestorBeanInjector_e8600cef {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef)cb;
		record.set(0,concreteBean.getCod_gestor());
		record.set(1,concreteBean.getNom_gestor());
		record.set(2,concreteBean.getReg_gestor());
		record.set(3,concreteBean.getPerfil_gestor());
		record.set(4,concreteBean.getTiilc_oficina_fk_cod_oficina());
		record.set(5,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio());
		record.set(6,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef)cb;
		record.set(0,concreteBean.getCod_gestor());
		record.set(1,concreteBean.getNom_gestor());
		record.set(2,concreteBean.getReg_gestor());
		record.set(3,concreteBean.getPerfil_gestor());
		record.set(4,concreteBean.getTiilc_oficina_fk_cod_oficina());
		record.set(5,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio());
		record.set(6,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef)cb;
		record.set(0,concreteBean.getCod_gestor());
		record.set(4,concreteBean.getTiilc_oficina_fk_cod_oficina());
		record.set(5,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio());
		record.set(6,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbFindAllGestorxOfxTexAr
	 */
	public void ejbFindAllGestorxOfxTexAr(java.lang.String cod_oficina, java.lang.String cod_territorio, java.lang.String cod_area, javax.resource.cci.IndexedRecord record) {
		record.set(1,cod_oficina);
		record.set(0,cod_territorio);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey pkey=(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey)pkeyObject;
		record.set(0,pkey.cod_gestor);
		record.set(1,pkey.tiilc_oficina_fk_cod_oficina);
		record.set(2,pkey.tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio);
		record.set(3,pkey.tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
	}
	/**
	 * ejbFindGestorxRegGestor
	 */
	public void ejbFindGestorxRegGestor(java.lang.String reg_gestor, javax.resource.cci.IndexedRecord record) {
		record.set(0,reg_gestor);
	}
	/**
	 * ejbFindAllGestor
	 */
	public void ejbFindAllGestor(java.lang.String cod_area, javax.resource.cci.IndexedRecord record) {
		record.set(0,cod_area);
	}
	/**
	 * findTiilc_gestorByTiilc_oficina_fkKey_Local
	 */
	public void findTiilc_gestorByTiilc_oficina_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_oficina);
		record.set(1,fkey.tiilc_territorio_fk_cod_territorio);
		record.set(2,fkey.tiilc_territorio_fk_tiilc_area_fk_cod_area);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef)cb;
		record.set(0,concreteBean.getCod_gestor());
		record.set(1,concreteBean.getTiilc_oficina_fk_cod_oficina());
		record.set(2,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio());
		record.set(3,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_gestor_e8600cef)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_gestor());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getNom_gestor());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getReg_gestor());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getPerfil_gestor());
		}
		record.set(4,concreteBean.getTiilc_oficina_fk_cod_oficina());
		record.set(5,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio());
		record.set(6,concreteBean.getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
