package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_perfilBeanCacheEntry_52a28827;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_perfil
 */
public class ConcreteTiilc_perfil_52a28827 extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilBean implements javax.ejb.EntityBean, ConcreteBean {
	static final long serialVersionUID = 61;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
		instanceExtension.setEntityContext(ctx);
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		super.unsetEntityContext();
		instanceExtension.unsetEntityContext();
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
			super.ejbActivate();
			instanceExtension.ejbActivate();
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
		instanceExtension.ejbLoad();
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
		super.ejbPassivate();
		instanceExtension.ejbPassivate();
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
		super.ejbRemove();
		instanceExtension.ejbRemove();
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
		super.ejbStore();
		instanceExtension.ejbStore();
	}
	private ConcreteBeanInstanceExtension instanceExtension;
	private Tiilc_perfilBeanCacheEntry_52a28827 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_perfil_52a28827
	 */
	public ConcreteTiilc_perfil_52a28827() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_perfilBeanInjector_52a28827 getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_perfilBeanInjector_52a28827)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_perfilBeanCacheEntry_52a28827) inRecord;
		super.ejbLoad();
	}
	/**
	 * resetCMP
	 */
	public void resetCMP() {
			dataCacheEntry = null;
	}
	/**
	 * resetCMR
	 */
	public void resetCMR() {
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindPerfil_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey ejbFindPerfil_Local(java.lang.String cod_perfil) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindPerfil");
		getInjector().ejbFindPerfil(cod_perfil, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey) instanceExtension.executeFind("FindPerfil", record);
	}
	/**
	 * ejbFindAllPerfil_Local
	 */
	public java.util.Collection ejbFindAllPerfil_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllPerfil", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey ejbCreate(com.grupobbva.bc.per.tel.iilc.serializable.Perfil perfil) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_perfilBeanCacheEntry_52a28827) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(perfil);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tel.iilc.serializable.Perfil perfil) throws javax.ejb.CreateException {
		super.ejbPostCreate(perfil);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey ejbCreate(java.lang.String cod_perfil) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_perfilBeanCacheEntry_52a28827) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_perfil);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_perfil) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_perfil);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_perfilKey();
		pk.cod_perfil = getCod_perfil();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 3;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_perfil
	 */
	public java.lang.String getCod_perfil() {
		return dataCacheEntry.getCod_perfil();
	}
	/**
	 * Set accessor for persistent attribute: cod_perfil
	 */
	public void setCod_perfil(java.lang.String newCod_perfil) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_perfil(),newCod_perfil);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_perfil(newCod_perfil);
	}
	/**
	 * Get accessor for persistent attribute: des_perfil
	 */
	public java.lang.String getDes_perfil() {
		return dataCacheEntry.getDes_perfil();
	}
	/**
	 * Set accessor for persistent attribute: des_perfil
	 */
	public void setDes_perfil(java.lang.String newDes_perfil) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDes_perfil(),newDes_perfil);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDes_perfil(newDes_perfil);
	}
	/**
	 * Get accessor for persistent attribute: componente
	 */
	public java.lang.String getComponente() {
		return dataCacheEntry.getComponente();
	}
	/**
	 * Set accessor for persistent attribute: componente
	 */
	public void setComponente(java.lang.String newComponente) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getComponente(),newComponente);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setComponente(newComponente);
	}
}
