package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_empresaBeanCacheEntry_d572bb0f;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_empresa
 */
public class ConcreteTiilc_empresa_d572bb0f extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiilc_empresaBeanCacheEntry_d572bb0f dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_empresa_d572bb0f
	 */
	public ConcreteTiilc_empresa_d572bb0f() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_empresaBeanInjector_d572bb0f getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_empresaBeanInjector_d572bb0f)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_empresaBeanCacheEntry_d572bb0f) inRecord;
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindEmpresaxCodigo_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey ejbFindEmpresaxCodigo_Local(java.lang.String cod_empresa) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindEmpresaxCodigo");
		getInjector().ejbFindEmpresaxCodigo(cod_empresa, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey) instanceExtension.executeFind("FindEmpresaxCodigo", record);
	}
	/**
	 * ejbFindAllEmpresa_Local
	 */
	public java.util.Collection ejbFindAllEmpresa_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllEmpresa", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey ejbCreate(java.lang.String cod_empresa) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_empresaBeanCacheEntry_d572bb0f) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_empresa);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_empresa) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_empresa);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey ejbCreate(java.lang.String cod_empresa, java.lang.String des_empresa) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_empresaBeanCacheEntry_d572bb0f) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_empresa, des_empresa);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_empresa, java.lang.String des_empresa) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_empresa, des_empresa);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_empresaKey();
		pk.cod_empresa = getCod_empresa();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 2;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_empresa
	 */
	public java.lang.String getCod_empresa() {
		return dataCacheEntry.getCod_empresa();
	}
	/**
	 * Set accessor for persistent attribute: cod_empresa
	 */
	public void setCod_empresa(java.lang.String newCod_empresa) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_empresa(),newCod_empresa);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_empresa(newCod_empresa);
	}
	/**
	 * Get accessor for persistent attribute: des_empresa
	 */
	public java.lang.String getDes_empresa() {
		return dataCacheEntry.getDes_empresa();
	}
	/**
	 * Set accessor for persistent attribute: des_empresa
	 */
	public void setDes_empresa(java.lang.String newDes_empresa) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDes_empresa(),newDes_empresa);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDes_empresa(newDes_empresa);
	}
}
