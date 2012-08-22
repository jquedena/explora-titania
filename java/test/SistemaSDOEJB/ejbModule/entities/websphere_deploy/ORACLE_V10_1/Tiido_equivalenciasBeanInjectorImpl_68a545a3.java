package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_equivalenciasBeanInjectorImpl_68a545a3
 */
public class Tiido_equivalenciasBeanInjectorImpl_68a545a3 implements entities.websphere_deploy.Tiido_equivalenciasBeanInjector_68a545a3 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_equivalencias_68a545a3 concreteBean=(entities.ConcreteTiido_equivalencias_68a545a3)cb;
		record.set(0,concreteBean.getCod_car());
		record.set(1,concreteBean.getCod_per());
		record.set(2,concreteBean.getUsu_regi());
		record.set(3,concreteBean.getFec_regi());
		record.set(4,concreteBean.getUsu_actu());
		record.set(5,concreteBean.getFec_actu());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_equivalencias_68a545a3 concreteBean=(entities.ConcreteTiido_equivalencias_68a545a3)cb;
		record.set(0,concreteBean.getCod_car());
		record.set(1,concreteBean.getCod_per());
		record.set(2,concreteBean.getUsu_regi());
		record.set(3,concreteBean.getFec_regi());
		record.set(4,concreteBean.getUsu_actu());
		record.set(5,concreteBean.getFec_actu());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_equivalencias_68a545a3 concreteBean=(entities.ConcreteTiido_equivalencias_68a545a3)cb;
		record.set(0,concreteBean.getCod_car());
	}
	/**
	 * ejbFindEquivalenciaByCodCargo
	 */
	public void ejbFindEquivalenciaByCodCargo(java.lang.String codCargo, javax.resource.cci.IndexedRecord record) {
		record.set(0,codCargo);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_equivalenciasKey pkey=(entities.Tiido_equivalenciasKey)pkeyObject;
		record.set(0,pkey.cod_car);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_equivalencias_68a545a3 concreteBean=(entities.ConcreteTiido_equivalencias_68a545a3)cb;
		record.set(0,concreteBean.getCod_car());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_equivalencias_68a545a3 concreteBean=(entities.ConcreteTiido_equivalencias_68a545a3)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_car());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getCod_per());
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
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
