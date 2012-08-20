package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_permiso_perfilBeanInjectorImpl_993509dc
 */
public class Tiilc_permiso_perfilBeanInjectorImpl_993509dc implements com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_permiso_perfilBeanInjector_993509dc {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getTipo_acceso());
		record.set(2,concreteBean.getValor_rcp());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc)cb;
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getTipo_acceso());
		record.set(2,concreteBean.getValor_rcp());
	}
	/**
	 * ejbFindPermisoPerfil
	 */
	public void ejbFindPermisoPerfil(java.lang.String cod_perfil, int tipo_acceso, java.lang.String valor_rcp, javax.resource.cci.IndexedRecord record) {
		record.set(0,cod_perfil);
		record.set(1,new Integer(tipo_acceso));
		record.set(2,valor_rcp);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey pkey=(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_permiso_perfilKey)pkeyObject;
		record.set(0,pkey.cod_perfil);
		record.set(1,pkey.tipo_acceso);
		record.set(2,pkey.valor_rcp);
	}
	/**
	 * ejbFindPermisoPerfilxTipAccxValorRCP
	 */
	public void ejbFindPermisoPerfilxTipAccxValorRCP(int tipo_acceso, java.lang.String valor_rcp, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(tipo_acceso));
		record.set(1,valor_rcp);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getTipo_acceso());
		record.set(2,concreteBean.getValor_rcp());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc concreteBean=(com.grupobbva.bc.per.tel.iilc.entity.ConcreteTiilc_permiso_perfil_993509dc)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
