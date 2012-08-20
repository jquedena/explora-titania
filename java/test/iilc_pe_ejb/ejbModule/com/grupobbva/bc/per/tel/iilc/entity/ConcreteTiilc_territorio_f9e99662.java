package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanCacheEntry_f9e99662;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_territorio
 */
public class ConcreteTiilc_territorio_f9e99662 extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiilc_territorioBeanCacheEntry_f9e99662 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_territorio_f9e99662
	 */
	public ConcreteTiilc_territorio_f9e99662() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanInjector_f9e99662 getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanInjector_f9e99662)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanCacheEntry_f9e99662) inRecord;
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
			tiilc_area_fkLink = null;
			tiilc_oficinaLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllTerritorio_Local
	 */
	public java.util.Collection ejbFindAllTerritorio_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllTerritorio", null);
	}
	/**
	 * ejbFindAllTerritorioxAr_Local
	 */
	public java.util.Collection ejbFindAllTerritorioxAr_Local(java.lang.String cod_area) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllTerritorioxAr");
		getInjector().ejbFindAllTerritorioxAr(cod_area, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllTerritorioxAr", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey ejbCreate(java.lang.String cod_territorio, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal argTiilc_area_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_territorioBeanCacheEntry_f9e99662) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_territorio, argTiilc_area_fk);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_territorio, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal argTiilc_area_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_territorio, argTiilc_area_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey ejbCreate(java.lang.String cod_territorio, java.lang.String tiilc_area_fk_cod_area) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_territorioBeanCacheEntry_f9e99662) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_territorio, tiilc_area_fk_cod_area);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_territorio, java.lang.String tiilc_area_fk_cod_area) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_territorio, tiilc_area_fk_cod_area);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey ejbCreate(java.lang.String cod_territorio, java.lang.String tiilc_area_fk_cod_area, java.lang.String des_territorio) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_territorioBeanCacheEntry_f9e99662) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_territorio, tiilc_area_fk_cod_area, des_territorio);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_territorio, java.lang.String tiilc_area_fk_cod_area, java.lang.String des_territorio) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_territorio, tiilc_area_fk_cod_area, des_territorio);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey();
		pk.cod_territorio = getCod_territorio();
		pk.tiilc_area_fk_cod_area = getTiilc_area_fk_cod_area();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 5;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiilc_area_fk")) return getTiilc_area_fkLink();
		if (name.equals("tiilc_oficina")) return getTiilc_oficinaLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiilc_area_fk")){
			com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_areaBeanInternalLocalHome_fdd98ec5 home = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_areaBeanInternalLocalHome_fdd98ec5)instanceExtension.getHomeForLink("tiilc_area_fk");
		  return home.findByPrimaryKeyForCMR((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey)key);
		}
		if (name.equals("tiilc_oficina")){
			com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanInternalLocalHome_9f94ea7f home = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanInternalLocalHome_9f94ea7f)instanceExtension.getHomeForLink("tiilc_oficina");
		  return home.findTiilc_oficinaByTiilc_territorio_fkKey_Local((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey)key);
		}
		return null;
	}
	/**
	 * getTiilc_area_fk
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal getTiilc_area_fk() {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal)getTiilc_area_fkLink().getValue();
	}
	/**
	 * setTiilc_area_fk
	 */
	public void setTiilc_area_fk(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaLocal value) {
		getTiilc_area_fkLink().setValue(value);
	}
	/**
	 * getTiilc_area_fkKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey getTiilc_area_fkKey() {
		if (tiilc_area_fkLink == null) return dataCacheEntry.getTiilc_area_fkKey();
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey) tiilc_area_fkLink.getKey();
	}
	/**
	 * getTiilc_area_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiilc_area_fkLink() {
		if (tiilc_area_fkLink == null) 
		tiilc_area_fkLink = instanceExtension.createLink("tiilc_area_fk",dataCacheEntry.getTiilc_area_fkKey(),3);
		return tiilc_area_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiilc_area_fkLink;
	/**
	 * ejbFindTiilc_territorioByTiilc_area_fkKey_Local
	 */
	public java.util.Collection ejbFindTiilc_territorioByTiilc_area_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiilc_area_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiilc_territorioByTiilc_area_fkKey_Local");
		getInjector().findTiilc_territorioByTiilc_area_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiilc_territorioByTiilc_area_fkKey_Local", record);
	}
	/**
	 * getTiilc_oficina
	 */
	public java.util.Collection getTiilc_oficina() {
		return (java.util.Collection)getTiilc_oficinaLink().getValue();
	}
	/**
	 * setTiilc_oficina
	 */
	public void setTiilc_oficina(java.util.Collection value) {
		getTiilc_oficinaLink().setValue(value);
	}
	/**
	 * getTiilc_oficinaLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiilc_oficinaLink() {
		if (tiilc_oficinaLink == null) 
		tiilc_oficinaLink = instanceExtension.createLink("tiilc_oficina",null,4);
		return tiilc_oficinaLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiilc_oficinaLink;
	/**
	 * ejbFindTiilc_territorio_fkByTiilc_oficinaKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey ejbFindTiilc_territorio_fkByTiilc_oficinaKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiilc_oficina",key);
		if (result!=null )  return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiilc_territorio_fkByTiilc_oficinaKey_Local");
		getInjector().findTiilc_territorio_fkByTiilc_oficinaKey_Local(key, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey) instanceExtension.executeFind("findTiilc_territorio_fkByTiilc_oficinaKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiilc_area_fkLink != null) 
		dataCacheEntry.setTiilc_area_fkKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_areaKey) tiilc_area_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_territorio
	 */
	public java.lang.String getCod_territorio() {
		return dataCacheEntry.getCod_territorio();
	}
	/**
	 * Set accessor for persistent attribute: cod_territorio
	 */
	public void setCod_territorio(java.lang.String newCod_territorio) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_territorio(),newCod_territorio);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_territorio(newCod_territorio);
	}
	/**
	 * Get accessor for persistent attribute: des_territorio
	 */
	public java.lang.String getDes_territorio() {
		return dataCacheEntry.getDes_territorio();
	}
	/**
	 * Set accessor for persistent attribute: des_territorio
	 */
	public void setDes_territorio(java.lang.String newDes_territorio) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDes_territorio(),newDes_territorio);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDes_territorio(newDes_territorio);
	}
	/**
	 * Get accessor for persistent attribute: tiilc_area_fk_cod_area
	 */
	public java.lang.String getTiilc_area_fk_cod_area() {
		return dataCacheEntry.getTiilc_area_fk_cod_area();
	}
	/**
	 * Set accessor for persistent attribute: tiilc_area_fk_cod_area
	 */
	public void setTiilc_area_fk_cod_area(java.lang.String newTiilc_area_fk_cod_area) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getTiilc_area_fk_cod_area(),newTiilc_area_fk_cod_area);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setTiilc_area_fk_cod_area(newTiilc_area_fk_cod_area);
	}
}
