package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_linea_comercialBeanCacheEntry_776d0f81;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_linea_comercial
 */
public class ConcreteTiilc_linea_comercial_776d0f81 extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiilc_linea_comercialBeanCacheEntry_776d0f81 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_linea_comercial_776d0f81
	 */
	public ConcreteTiilc_linea_comercial_776d0f81() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_linea_comercialBeanInjector_776d0f81 getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_linea_comercialBeanInjector_776d0f81)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_linea_comercialBeanCacheEntry_776d0f81) inRecord;
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey ejbCreate(java.lang.String cod_grupo, java.lang.String cod_lincom) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_linea_comercialBeanCacheEntry_776d0f81) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_grupo, cod_lincom);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_grupo, java.lang.String cod_lincom) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_grupo, cod_lincom);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey ejbCreate(java.lang.String cod_grupo, java.lang.String cod_lincom, java.lang.String des_lincom) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_linea_comercialBeanCacheEntry_776d0f81) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_grupo, cod_lincom, des_lincom);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_grupo, java.lang.String cod_lincom, java.lang.String des_lincom) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_grupo, cod_lincom, des_lincom);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_linea_comercialKey();
		pk.cod_grupo = getCod_grupo();
		pk.cod_lincom = getCod_lincom();
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
	 * Get accessor for persistent attribute: cod_grupo
	 */
	public java.lang.String getCod_grupo() {
		return dataCacheEntry.getCod_grupo();
	}
	/**
	 * Set accessor for persistent attribute: cod_grupo
	 */
	public void setCod_grupo(java.lang.String newCod_grupo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_grupo(),newCod_grupo);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_grupo(newCod_grupo);
	}
	/**
	 * Get accessor for persistent attribute: cod_lincom
	 */
	public java.lang.String getCod_lincom() {
		return dataCacheEntry.getCod_lincom();
	}
	/**
	 * Set accessor for persistent attribute: cod_lincom
	 */
	public void setCod_lincom(java.lang.String newCod_lincom) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCod_lincom(),newCod_lincom);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCod_lincom(newCod_lincom);
	}
	/**
	 * Get accessor for persistent attribute: des_lincom
	 */
	public java.lang.String getDes_lincom() {
		return dataCacheEntry.getDes_lincom();
	}
	/**
	 * Set accessor for persistent attribute: des_lincom
	 */
	public void setDes_lincom(java.lang.String newDes_lincom) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getDes_lincom(),newDes_lincom);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setDes_lincom(newDes_lincom);
	}
}
