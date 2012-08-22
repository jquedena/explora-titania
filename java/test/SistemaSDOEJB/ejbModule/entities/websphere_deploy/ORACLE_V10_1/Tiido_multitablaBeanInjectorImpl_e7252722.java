package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_multitablaBeanInjectorImpl_e7252722
 */
public class Tiido_multitablaBeanInjectorImpl_e7252722 implements entities.websphere_deploy.Tiido_multitablaBeanInjector_e7252722 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_multitabla_e7252722 concreteBean=(entities.ConcreteTiido_multitabla_e7252722)cb;
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_elem());
		record.set(2,concreteBean.getValor1());
		record.set(3,concreteBean.getValor2());
		record.set(4,concreteBean.getValor3());
		record.set(5,concreteBean.getValor4());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_multitabla_e7252722 concreteBean=(entities.ConcreteTiido_multitabla_e7252722)cb;
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_elem());
		record.set(2,concreteBean.getValor1());
		record.set(3,concreteBean.getValor2());
		record.set(4,concreteBean.getValor3());
		record.set(5,concreteBean.getValor4());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_multitabla_e7252722 concreteBean=(entities.ConcreteTiido_multitabla_e7252722)cb;
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_elem());
	}
	/**
	 * ejbFindMultiByPrimaryKey
	 */
	public void ejbFindMultiByPrimaryKey(java.lang.String codMulti, java.lang.String codElem, javax.resource.cci.IndexedRecord record) {
		record.set(0,codMulti);
		record.set(1,codElem);
	}
	/**
	 * ejbFindByID
	 */
	public void ejbFindByID(java.lang.String id, javax.resource.cci.IndexedRecord record) {
		record.set(0,id);
		record.set(1,id);
		record.set(2,id);
	}
	/**
	 * ejbFindByMultiForPresup
	 */
	public void ejbFindByMultiForPresup(java.lang.String codMulti, java.lang.String Valor2, javax.resource.cci.IndexedRecord record) {
		record.set(0,codMulti);
		record.set(1,Valor2);
	}
	/**
	 * ejbFindByCodMulti
	 */
	public void ejbFindByCodMulti(java.lang.String codMulti, javax.resource.cci.IndexedRecord record) {
		record.set(0,codMulti);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_multitablaKey pkey=(entities.Tiido_multitablaKey)pkeyObject;
		record.set(0,pkey.cod_mult);
		record.set(1,pkey.cod_elem);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_multitabla_e7252722 concreteBean=(entities.ConcreteTiido_multitabla_e7252722)cb;
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_elem());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_multitabla_e7252722 concreteBean=(entities.ConcreteTiido_multitabla_e7252722)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_mult());
		record.set(1,concreteBean.getCod_elem());
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
