package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_territorioBeanInjectorImpl_9aeef014
 */
public class Tiido_territorioBeanInjectorImpl_9aeef014 implements entities.websphere_deploy.Tiido_territorioBeanInjector_9aeef014 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_territorio_9aeef014 concreteBean=(entities.ConcreteTiido_territorio_9aeef014)cb;
		record.set(0,concreteBean.getCod_terr());
		record.set(1,concreteBean.getNom_terr());
		record.set(2,concreteBean.getUsu_regi());
		record.set(3,concreteBean.getFec_regi());
		record.set(4,concreteBean.getUsu_actu());
		record.set(5,concreteBean.getFec_actu());
		record.set(6,concreteBean.getEstado());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_territorio_9aeef014 concreteBean=(entities.ConcreteTiido_territorio_9aeef014)cb;
		record.set(0,concreteBean.getCod_terr());
		record.set(1,concreteBean.getNom_terr());
		record.set(2,concreteBean.getUsu_regi());
		record.set(3,concreteBean.getFec_regi());
		record.set(4,concreteBean.getUsu_actu());
		record.set(5,concreteBean.getFec_actu());
		record.set(6,concreteBean.getEstado());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_territorio_9aeef014 concreteBean=(entities.ConcreteTiido_territorio_9aeef014)cb;
		record.set(0,concreteBean.getCod_terr());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_territorioKey pkey=(entities.Tiido_territorioKey)pkeyObject;
		record.set(0,pkey.cod_terr);
	}
	/**
	 * ejbFindByCodTerritorio
	 */
	public void ejbFindByCodTerritorio(java.lang.String codTerritorio, javax.resource.cci.IndexedRecord record) {
		record.set(0,codTerritorio);
	}
	/**
	 * findTiido_territorio_fkByTiido_oficinaKey_Local
	 */
	public void findTiido_territorio_fkByTiido_oficinaKey_Local(entities.Tiido_oficinaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_ofic);
		record.set(1,fkey.tiido_territorio_fk_cod_terr);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_territorio_9aeef014 concreteBean=(entities.ConcreteTiido_territorio_9aeef014)cb;
		record.set(0,concreteBean.getCod_terr());
		record.set(1,concreteBean.getEstado());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_territorio_9aeef014 concreteBean=(entities.ConcreteTiido_territorio_9aeef014)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_terr());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getNom_terr());
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
			record.set(6,concreteBean.getEstado());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
