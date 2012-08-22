package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_campaniasBeanInjectorImpl_97b3883c
 */
public class Tiido_campaniasBeanInjectorImpl_97b3883c implements entities.websphere_deploy.Tiido_campaniasBeanInjector_97b3883c {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_campanias_97b3883c concreteBean=(entities.ConcreteTiido_campanias_97b3883c)cb;
		record.set(0,concreteBean.getCod_camp());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getMes());
		record.set(3,concreteBean.getNom_camp());
		record.set(4,concreteBean.getCod_gest());
		record.set(5,concreteBean.getOrden());
		record.set(6,concreteBean.getGte());
		record.set(7,concreteBean.getFec_regi());
		record.set(8,concreteBean.getUsu_regi());
		record.set(9,concreteBean.getFec_actu());
		record.set(10,concreteBean.getUsu_actu());
		record.set(11,concreteBean.getTiido_cam_oficina_fk_cod_ofic());
		record.set(12,concreteBean.getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_campanias_97b3883c concreteBean=(entities.ConcreteTiido_campanias_97b3883c)cb;
		record.set(0,concreteBean.getCod_camp());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getMes());
		record.set(3,concreteBean.getNom_camp());
		record.set(4,concreteBean.getCod_gest());
		record.set(5,concreteBean.getOrden());
		record.set(6,concreteBean.getGte());
		record.set(7,concreteBean.getFec_regi());
		record.set(8,concreteBean.getUsu_regi());
		record.set(9,concreteBean.getFec_actu());
		record.set(10,concreteBean.getUsu_actu());
		record.set(11,concreteBean.getTiido_cam_oficina_fk_cod_ofic());
		record.set(12,concreteBean.getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_campanias_97b3883c concreteBean=(entities.ConcreteTiido_campanias_97b3883c)cb;
		record.set(0,concreteBean.getCod_camp());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getMes());
		record.set(11,concreteBean.getTiido_cam_oficina_fk_cod_ofic());
		record.set(12,concreteBean.getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_campaniasKey pkey=(entities.Tiido_campaniasKey)pkeyObject;
		record.set(0,pkey.cod_camp);
		record.set(1,pkey.anho);
		record.set(2,pkey.mes);
		record.set(3,pkey.tiido_cam_oficina_fk_cod_ofic);
		record.set(4,pkey.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_campaniasByTiido_cam_oficina_fkKey_Local
	 */
	public void findTiido_campaniasByTiido_cam_oficina_fkKey_Local(entities.Tiido_oficinaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_ofic);
		record.set(1,fkey.tiido_territorio_fk_cod_terr);
	}
	/**
	 * findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local
	 */
	public void findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local(entities.Tiido_campanias_detalleKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_camp_deta);
		record.set(1,fkey.tiido_camdet_campanias_fk_cod_camp);
		record.set(2,fkey.tiido_camdet_campanias_fk_anho);
		record.set(3,fkey.tiido_camdet_campanias_fk_mes);
		record.set(4,fkey.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic);
		record.set(5,fkey.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_campanias_97b3883c concreteBean=(entities.ConcreteTiido_campanias_97b3883c)cb;
		record.set(0,concreteBean.getCod_camp());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getMes());
		record.set(3,concreteBean.getTiido_cam_oficina_fk_cod_ofic());
		record.set(4,concreteBean.getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_campanias_97b3883c concreteBean=(entities.ConcreteTiido_campanias_97b3883c)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_camp());
		record.set(1,concreteBean.getAnho());
		record.set(2,concreteBean.getMes());
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getNom_camp());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getCod_gest());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getOrden());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getGte());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getFec_regi());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getUsu_regi());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getFec_actu());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getUsu_actu());
		}
		record.set(11,concreteBean.getTiido_cam_oficina_fk_cod_ofic());
		record.set(12,concreteBean.getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
