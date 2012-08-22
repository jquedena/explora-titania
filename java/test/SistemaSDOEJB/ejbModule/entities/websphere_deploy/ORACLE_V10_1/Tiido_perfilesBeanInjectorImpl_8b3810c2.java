package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_perfilesBeanInjectorImpl_8b3810c2
 */
public class Tiido_perfilesBeanInjectorImpl_8b3810c2 implements entities.websphere_deploy.Tiido_perfilesBeanInjector_8b3810c2 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_perfiles_8b3810c2 concreteBean=(entities.ConcreteTiido_perfiles_8b3810c2)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getNom_perfil());
		record.set(2,concreteBean.getUsu_regi());
		record.set(3,concreteBean.getFec_regi());
		record.set(4,concreteBean.getUsu_actu());
		record.set(5,concreteBean.getFec_actu());
		record.set(6,concreteBean.getPerfil());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_perfiles_8b3810c2 concreteBean=(entities.ConcreteTiido_perfiles_8b3810c2)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getNom_perfil());
		record.set(2,concreteBean.getUsu_regi());
		record.set(3,concreteBean.getFec_regi());
		record.set(4,concreteBean.getUsu_actu());
		record.set(5,concreteBean.getFec_actu());
		record.set(6,concreteBean.getPerfil());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_perfiles_8b3810c2 concreteBean=(entities.ConcreteTiido_perfiles_8b3810c2)cb;
		record.set(0,concreteBean.getCod_perfil());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_perfilesKey pkey=(entities.Tiido_perfilesKey)pkeyObject;
		record.set(0,pkey.cod_perfil);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_perfiles_8b3810c2 concreteBean=(entities.ConcreteTiido_perfiles_8b3810c2)cb;
		record.set(0,concreteBean.getCod_perfil());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_perfiles_8b3810c2 concreteBean=(entities.ConcreteTiido_perfiles_8b3810c2)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_perfil());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getNom_perfil());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getUsu_regi());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getFec_regi());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getUsu_actu());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getFec_actu());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getPerfil());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
