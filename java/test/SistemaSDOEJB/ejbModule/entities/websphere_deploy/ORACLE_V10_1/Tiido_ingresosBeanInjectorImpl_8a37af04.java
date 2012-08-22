package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_ingresosBeanInjectorImpl_8a37af04
 */
public class Tiido_ingresosBeanInjectorImpl_8a37af04 implements entities.websphere_deploy.Tiido_ingresosBeanInjector_8a37af04 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_ingresos_8a37af04 concreteBean=(entities.ConcreteTiido_ingresos_8a37af04)cb;
		record.set(0,concreteBean.getId_ingresos());
		record.set(1,concreteBean.getVeces());
		record.set(2,concreteBean.getValido_veces());
		record.set(3,concreteBean.getCod_usuario());
		record.set(4,concreteBean.getCargo());
		record.set(5,concreteBean.getNom_territorio());
		record.set(6,concreteBean.getCod_oficina());
		record.set(7,concreteBean.getFecha());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_ingresos_8a37af04 concreteBean=(entities.ConcreteTiido_ingresos_8a37af04)cb;
		record.set(0,concreteBean.getId_ingresos());
		record.set(1,concreteBean.getVeces());
		record.set(2,concreteBean.getValido_veces());
		record.set(3,concreteBean.getCod_usuario());
		record.set(4,concreteBean.getCargo());
		record.set(5,concreteBean.getNom_territorio());
		record.set(6,concreteBean.getCod_oficina());
		record.set(7,concreteBean.getFecha());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_ingresos_8a37af04 concreteBean=(entities.ConcreteTiido_ingresos_8a37af04)cb;
		record.set(0,concreteBean.getId_ingresos());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_ingresosKey pkey=(entities.Tiido_ingresosKey)pkeyObject;
		record.set(0,pkey.id_ingresos);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_ingresos_8a37af04 concreteBean=(entities.ConcreteTiido_ingresos_8a37af04)cb;
		record.set(0,concreteBean.getId_ingresos());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_ingresos_8a37af04 concreteBean=(entities.ConcreteTiido_ingresos_8a37af04)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getId_ingresos());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getVeces());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getValido_veces());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getCod_usuario());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getCargo());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getNom_territorio());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getCod_oficina());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getFecha());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
