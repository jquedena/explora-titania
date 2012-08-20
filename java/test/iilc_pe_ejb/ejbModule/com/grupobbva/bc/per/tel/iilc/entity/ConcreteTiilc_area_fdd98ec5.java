package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_areaBeanCacheEntry_fdd98ec5;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_area
 */
public class ConcreteTiilc_area_fdd98ec5 extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaBean implements javax.ejb.EntityBean, ConcreteBeanWithLink {
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
	private Tiilc_areaBeanCacheEntry_fdd98ec5 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_area_fdd98ec5
	 */
	public ConcreteTiilc_area_fdd98ec5() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_areaBeanInjector_fdd98ec5 getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_areaBeanInjector_fdd98ec5)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_areaBeanCacheEntry_fdd98ec5) inRecord;
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
			tiilc_territorioLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey ejbCreate(java.lang.String cod_area) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_areaBeanCacheEntry_fdd98ec5) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_area);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_area) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_area);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey ejbCreate(java.lang.String cod_area, java.lang.String des_area) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_areaBeanCacheEntry_fdd98ec5) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_area, des_area);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_area, java.lang.String des_area) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_area, des_area);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey();
		pk.cod_area = getCod_area();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 3;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiilc_territorio")) return getTiilc_territorioLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiilc_territorio")){
			com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanInternalLocalHome_f9e99662 home = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanInternalLocalHome_f9e99662)instanceExtension.getHomeForLink("tiilc_territorio");
		  return home.findTiilc_territorioByTiilc_area_fkKey_Local((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey)key);
		}
		return null;
	}
	/**
	 * getTiilc_territorio
	 */
	public java.util.Collection getTiilc_territorio() {
		return (java.util.Collection)getTiilc_territorioLink().getValue();
	}
	/**
	 * setTiilc_territorio
	 */
	public void setTiilc_territorio(java.util.Collection value) {
		getTiilc_territorioLink().setValue(value);
	}
	/**
	 * getTiilc_territorioLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiilc_territorioLink() {
		if (tiilc_territorioLink == null) 
		tiilc_territorioLink = instanceExtension.createLink("tiilc_territorio",null,2);
		return tiilc_territorioLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiilc_territorioLink;
	/**
	 * ejbFindTiilc_area_fkByTiilc_territorioKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey ejbFindTiilc_area_fkByTiilc_territorioKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiilc_territorio",key);
		if (result!=null )  return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiilc_area_fkByTiilc_territorioKey_Local");
		getInjector().findTiilc_area_fkByTiilc_territorioKey_Local(key, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey) instanceExtension.executeFind("findTiilc_area_fkByTiilc_territorioKey_Local", record);
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_area
	 */
	public java.lang.String getCod_area() {
		return dataCacheEntry.getCod_area();
	}
	/**
	 * Set accessor for persistent attribute: cod_area
	 */
	public void setCod_area(java.lang.String newCod_area) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_area(),newCod_area);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_area(newCod_area);
	}
	/**
	 * Get accessor for persistent attribute: des_area
	 */
	public java.lang.String getDes_area() {
		return dataCacheEntry.getDes_area();
	}
	/**
	 * Set accessor for persistent attribute: des_area
	 */
	public void setDes_area(java.lang.String newDes_area) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDes_area(),newDes_area);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDes_area(newDes_area);
	}
}
