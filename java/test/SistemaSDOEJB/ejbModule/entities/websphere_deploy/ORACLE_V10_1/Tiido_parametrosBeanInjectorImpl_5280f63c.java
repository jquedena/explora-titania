package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_parametrosBeanInjectorImpl_5280f63c
 */
public class Tiido_parametrosBeanInjectorImpl_5280f63c implements entities.websphere_deploy.Tiido_parametrosBeanInjector_5280f63c {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_parametros_5280f63c concreteBean=(entities.ConcreteTiido_parametros_5280f63c)cb;
		record.set(0,concreteBean.getCod_parametro());
		record.set(1,concreteBean.getFec_acci());
		record.set(2,concreteBean.getFec_segu_1());
		record.set(3,concreteBean.getFec_segu_2());
		record.set(4,concreteBean.getAfec_acci());
		record.set(5,concreteBean.getAfec_segu());
		record.set(6,concreteBean.getAfec_plan());
		record.set(7,concreteBean.getFec_plan());
		record.set(8,concreteBean.getTap_usu_regi());
		record.set(9,concreteBean.getFec_regi());
		record.set(10,concreteBean.getUsu_actu());
		record.set(11,concreteBean.getFec_actu());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_parametros_5280f63c concreteBean=(entities.ConcreteTiido_parametros_5280f63c)cb;
		record.set(0,concreteBean.getCod_parametro());
		record.set(1,concreteBean.getFec_acci());
		record.set(2,concreteBean.getFec_segu_1());
		record.set(3,concreteBean.getFec_segu_2());
		record.set(4,concreteBean.getAfec_acci());
		record.set(5,concreteBean.getAfec_segu());
		record.set(6,concreteBean.getAfec_plan());
		record.set(7,concreteBean.getFec_plan());
		record.set(8,concreteBean.getTap_usu_regi());
		record.set(9,concreteBean.getFec_regi());
		record.set(10,concreteBean.getUsu_actu());
		record.set(11,concreteBean.getFec_actu());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_parametros_5280f63c concreteBean=(entities.ConcreteTiido_parametros_5280f63c)cb;
		record.set(0,concreteBean.getCod_parametro());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_parametrosKey pkey=(entities.Tiido_parametrosKey)pkeyObject;
		record.set(0,pkey.cod_parametro);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_parametros_5280f63c concreteBean=(entities.ConcreteTiido_parametros_5280f63c)cb;
		record.set(0,concreteBean.getCod_parametro());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_parametros_5280f63c concreteBean=(entities.ConcreteTiido_parametros_5280f63c)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_parametro());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getFec_acci());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getFec_segu_1());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getFec_segu_2());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getAfec_acci());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getAfec_segu());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getAfec_plan());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getFec_plan());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getTap_usu_regi());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getFec_regi());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getUsu_actu());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getFec_actu());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
