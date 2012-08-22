package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_menuBeanInjectorImpl_3f2247da
 */
public class Tiido_menuBeanInjectorImpl_3f2247da implements entities.websphere_deploy.Tiido_menuBeanInjector_3f2247da {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_menu_3f2247da concreteBean=(entities.ConcreteTiido_menu_3f2247da)cb;
		record.set(0,concreteBean.getPadre());
		record.set(1,concreteBean.getLink());
		record.set(2,concreteBean.getHijo());
		record.set(3,concreteBean.getDescripcion());
		record.set(4,concreteBean.getCod_perfil());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_menu_3f2247da concreteBean=(entities.ConcreteTiido_menu_3f2247da)cb;
		record.set(0,concreteBean.getPadre());
		record.set(1,concreteBean.getLink());
		record.set(2,concreteBean.getHijo());
		record.set(3,concreteBean.getDescripcion());
		record.set(4,concreteBean.getCod_perfil());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_menu_3f2247da concreteBean=(entities.ConcreteTiido_menu_3f2247da)cb;
		record.set(0,concreteBean.getPadre());
	}
	/**
	 * ejbFindxCodPerfil
	 */
	public void ejbFindxCodPerfil(java.lang.String codPerfil, javax.resource.cci.IndexedRecord record) {
		record.set(0,codPerfil);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_menuKey pkey=(entities.Tiido_menuKey)pkeyObject;
		record.set(0,pkey.padre);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_menu_3f2247da concreteBean=(entities.ConcreteTiido_menu_3f2247da)cb;
		record.set(0,concreteBean.getPadre());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_menu_3f2247da concreteBean=(entities.ConcreteTiido_menu_3f2247da)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getPadre());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getLink());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getHijo());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getDescripcion());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getCod_perfil());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
