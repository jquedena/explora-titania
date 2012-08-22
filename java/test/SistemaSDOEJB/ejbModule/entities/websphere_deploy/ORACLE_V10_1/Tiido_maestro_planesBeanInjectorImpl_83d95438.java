package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_maestro_planesBeanInjectorImpl_83d95438
 */
public class Tiido_maestro_planesBeanInjectorImpl_83d95438 implements entities.websphere_deploy.Tiido_maestro_planesBeanInjector_83d95438 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_maestro_planes_83d95438 concreteBean=(entities.ConcreteTiido_maestro_planes_83d95438)cb;
		record.set(0,concreteBean.getMes());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getPrioridad());
		record.set(3,concreteBean.getFec_grab());
		record.set(4,concreteBean.getTiido_maepla_oficina_fk_cod_ofic());
		record.set(5,concreteBean.getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_maestro_planes_83d95438 concreteBean=(entities.ConcreteTiido_maestro_planes_83d95438)cb;
		record.set(0,concreteBean.getMes());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getPrioridad());
		record.set(3,concreteBean.getFec_grab());
		record.set(4,concreteBean.getTiido_maepla_oficina_fk_cod_ofic());
		record.set(5,concreteBean.getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_maestro_planes_83d95438 concreteBean=(entities.ConcreteTiido_maestro_planes_83d95438)cb;
		record.set(0,concreteBean.getMes());
		record.set(1,concreteBean.getAnho());
		record.set(4,concreteBean.getTiido_maepla_oficina_fk_cod_ofic());
		record.set(5,concreteBean.getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_maestro_planesKey pkey=(entities.Tiido_maestro_planesKey)pkeyObject;
		record.set(0,pkey.mes);
		record.set(1,pkey.anho);
		record.set(2,pkey.tiido_maepla_oficina_fk_cod_ofic);
		record.set(3,pkey.tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * ejbFindUbicar
	 */
	public void ejbFindUbicar(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, javax.resource.cci.IndexedRecord record) {
		record.set(0,mes);
		record.set(1,anho);
		record.set(2,codOficina);
	}
	/**
	 * findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local
	 */
	public void findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local(entities.Tiido_oficinaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_ofic);
		record.set(1,fkey.tiido_territorio_fk_cod_terr);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_maestro_planes_83d95438 concreteBean=(entities.ConcreteTiido_maestro_planes_83d95438)cb;
		record.set(0,concreteBean.getMes());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getTiido_maepla_oficina_fk_cod_ofic());
		record.set(3,concreteBean.getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_maestro_planes_83d95438 concreteBean=(entities.ConcreteTiido_maestro_planes_83d95438)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getMes());
		record.set(1,concreteBean.getAnho());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getPrioridad());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getFec_grab());
		}
		record.set(4,concreteBean.getTiido_maepla_oficina_fk_cod_ofic());
		record.set(5,concreteBean.getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
