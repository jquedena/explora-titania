package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_permiso_perfilBeanInjectorImpl_edfb184d
 */
public class Tiido_permiso_perfilBeanInjectorImpl_edfb184d implements entities.websphere_deploy.Tiido_permiso_perfilBeanInjector_edfb184d {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_permiso_perfil_edfb184d concreteBean=(entities.ConcreteTiido_permiso_perfil_edfb184d)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getTip_acceso());
		record.set(2,concreteBean.getValor_rcp());
		record.set(3,concreteBean.getUsuario());
		record.set(4,concreteBean.getUsu_regi());
		record.set(5,concreteBean.getFec_regi());
		record.set(6,concreteBean.getUsu_actu());
		record.set(7,concreteBean.getFec_actu());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_permiso_perfil_edfb184d concreteBean=(entities.ConcreteTiido_permiso_perfil_edfb184d)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getTip_acceso());
		record.set(2,concreteBean.getValor_rcp());
		record.set(3,concreteBean.getUsuario());
		record.set(4,concreteBean.getUsu_regi());
		record.set(5,concreteBean.getFec_regi());
		record.set(6,concreteBean.getUsu_actu());
		record.set(7,concreteBean.getFec_actu());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_permiso_perfil_edfb184d concreteBean=(entities.ConcreteTiido_permiso_perfil_edfb184d)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getTip_acceso());
		record.set(2,concreteBean.getValor_rcp());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_permiso_perfilKey pkey=(entities.Tiido_permiso_perfilKey)pkeyObject;
		record.set(0,pkey.cod_perfil);
		record.set(1,pkey.tip_acceso);
		record.set(2,pkey.valor_rcp);
	}
	/**
	 * ejbFindPermisoPerfilxTipAccxValorRCP
	 */
	public void ejbFindPermisoPerfilxTipAccxValorRCP(java.lang.String tipo_acceso, java.lang.String valor_rcp, javax.resource.cci.IndexedRecord record) {
		record.set(0,tipo_acceso);
		record.set(1,valor_rcp);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_permiso_perfil_edfb184d concreteBean=(entities.ConcreteTiido_permiso_perfil_edfb184d)cb;
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getTip_acceso());
		record.set(2,concreteBean.getValor_rcp());
		record.set(3,concreteBean.getUsuario());
		record.set(4,concreteBean.getUsu_regi());
		record.set(5,concreteBean.getFec_regi());
		record.set(6,concreteBean.getUsu_actu());
		record.set(7,concreteBean.getFec_actu());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_permiso_perfil_edfb184d concreteBean=(entities.ConcreteTiido_permiso_perfil_edfb184d)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCod_perfil());
		record.set(1,concreteBean.getTip_acceso());
		record.set(2,concreteBean.getValor_rcp());
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getUsuario());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getUsu_regi());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getFec_regi());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getUsu_actu());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getFec_actu());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
