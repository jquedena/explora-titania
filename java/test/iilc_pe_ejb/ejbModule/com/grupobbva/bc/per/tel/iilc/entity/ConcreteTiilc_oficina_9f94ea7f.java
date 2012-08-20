package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanCacheEntry_9f94ea7f;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_oficina
 */
public class ConcreteTiilc_oficina_9f94ea7f extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiilc_oficinaBeanCacheEntry_9f94ea7f dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_oficina_9f94ea7f
	 */
	public ConcreteTiilc_oficina_9f94ea7f() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanInjector_9f94ea7f getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanInjector_9f94ea7f)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanCacheEntry_9f94ea7f) inRecord;
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
			tiilc_territorio_fkLink = null;
			tiilc_gestorLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllOficinaxCod_oficina_Local
	 */
	public java.util.Collection ejbFindAllOficinaxCod_oficina_Local(java.lang.String cod_oficina) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllOficinaxCod_oficina");
		getInjector().ejbFindAllOficinaxCod_oficina(cod_oficina, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllOficinaxCod_oficina", record);
	}
	/**
	 * ejbFindAllOficinaxTer_Local
	 */
	public java.util.Collection ejbFindAllOficinaxTer_Local(java.lang.String cod_territorio) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllOficinaxTer");
		getInjector().ejbFindAllOficinaxTer(cod_territorio, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllOficinaxTer", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey ejbCreate(java.lang.String cod_oficina, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal argTiilc_territorio_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_oficinaBeanCacheEntry_9f94ea7f) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_oficina, argTiilc_territorio_fk);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_oficina, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal argTiilc_territorio_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_oficina, argTiilc_territorio_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey ejbCreate(java.lang.String cod_oficina, java.lang.String tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_oficinaBeanCacheEntry_9f94ea7f) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_oficina, java.lang.String tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey ejbCreate(java.lang.String cod_oficina, java.lang.String tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area, java.lang.String des_oficina) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_oficinaBeanCacheEntry_9f94ea7f) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area, des_oficina);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_oficina, java.lang.String tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_territorio_fk_tiilc_area_fk_cod_area, java.lang.String des_oficina) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_oficina, tiilc_territorio_fk_cod_territorio, tiilc_territorio_fk_tiilc_area_fk_cod_area, des_oficina);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey();
		pk.cod_oficina = getCod_oficina();
		pk.tiilc_territorio_fk_cod_territorio = getTiilc_territorio_fk_cod_territorio();
		pk.tiilc_territorio_fk_tiilc_area_fk_cod_area = getTiilc_territorio_fk_tiilc_area_fk_cod_area();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 6;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiilc_territorio_fk")) return getTiilc_territorio_fkLink();
		if (name.equals("tiilc_gestor")) return getTiilc_gestorLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiilc_territorio_fk")){
			com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanInternalLocalHome_f9e99662 home = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_territorioBeanInternalLocalHome_f9e99662)instanceExtension.getHomeForLink("tiilc_territorio_fk");
		  return home.findByPrimaryKeyForCMR((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey)key);
		}
		if (name.equals("tiilc_gestor")){
			com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_gestorBeanInternalLocalHome_e8600cef home = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_gestorBeanInternalLocalHome_e8600cef)instanceExtension.getHomeForLink("tiilc_gestor");
		  return home.findTiilc_gestorByTiilc_oficina_fkKey_Local((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey)key);
		}
		return null;
	}
	/**
	 * getTiilc_territorio_fk
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal getTiilc_territorio_fk() {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal)getTiilc_territorio_fkLink().getValue();
	}
	/**
	 * setTiilc_territorio_fk
	 */
	public void setTiilc_territorio_fk(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioLocal value) {
		getTiilc_territorio_fkLink().setValue(value);
	}
	/**
	 * getTiilc_territorio_fkKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey getTiilc_territorio_fkKey() {
		if (tiilc_territorio_fkLink == null) return dataCacheEntry.getTiilc_territorio_fkKey();
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey) tiilc_territorio_fkLink.getKey();
	}
	/**
	 * getTiilc_territorio_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiilc_territorio_fkLink() {
		if (tiilc_territorio_fkLink == null) 
		tiilc_territorio_fkLink = instanceExtension.createLink("tiilc_territorio_fk",dataCacheEntry.getTiilc_territorio_fkKey(),4);
		return tiilc_territorio_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiilc_territorio_fkLink;
	/**
	 * ejbFindTiilc_oficinaByTiilc_territorio_fkKey_Local
	 */
	public java.util.Collection ejbFindTiilc_oficinaByTiilc_territorio_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiilc_territorio_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiilc_oficinaByTiilc_territorio_fkKey_Local");
		getInjector().findTiilc_oficinaByTiilc_territorio_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiilc_oficinaByTiilc_territorio_fkKey_Local", record);
	}
	/**
	 * getTiilc_gestor
	 */
	public java.util.Collection getTiilc_gestor() {
		return (java.util.Collection)getTiilc_gestorLink().getValue();
	}
	/**
	 * setTiilc_gestor
	 */
	public void setTiilc_gestor(java.util.Collection value) {
		getTiilc_gestorLink().setValue(value);
	}
	/**
	 * getTiilc_gestorLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiilc_gestorLink() {
		if (tiilc_gestorLink == null) 
		tiilc_gestorLink = instanceExtension.createLink("tiilc_gestor",null,5);
		return tiilc_gestorLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiilc_gestorLink;
	/**
	 * ejbFindTiilc_oficina_fkByTiilc_gestorKey_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey ejbFindTiilc_oficina_fkByTiilc_gestorKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiilc_gestor",key);
		if (result!=null )  return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiilc_oficina_fkByTiilc_gestorKey_Local");
		getInjector().findTiilc_oficina_fkByTiilc_gestorKey_Local(key, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey) instanceExtension.executeFind("findTiilc_oficina_fkByTiilc_gestorKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiilc_territorio_fkLink != null) 
		dataCacheEntry.setTiilc_territorio_fkKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_territorioKey) tiilc_territorio_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_oficina
	 */
	public java.lang.String getCod_oficina() {
		return dataCacheEntry.getCod_oficina();
	}
	/**
	 * Set accessor for persistent attribute: cod_oficina
	 */
	public void setCod_oficina(java.lang.String newCod_oficina) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_oficina(),newCod_oficina);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_oficina(newCod_oficina);
	}
	/**
	 * Get accessor for persistent attribute: des_oficina
	 */
	public java.lang.String getDes_oficina() {
		return dataCacheEntry.getDes_oficina();
	}
	/**
	 * Set accessor for persistent attribute: des_oficina
	 */
	public void setDes_oficina(java.lang.String newDes_oficina) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getDes_oficina(),newDes_oficina);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setDes_oficina(newDes_oficina);
	}
	/**
	 * Get accessor for persistent attribute: tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public java.lang.String getTiilc_territorio_fk_tiilc_area_fk_cod_area() {
		return dataCacheEntry.getTiilc_territorio_fk_tiilc_area_fk_cod_area();
	}
	/**
	 * Set accessor for persistent attribute: tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public void setTiilc_territorio_fk_tiilc_area_fk_cod_area(java.lang.String newTiilc_territorio_fk_tiilc_area_fk_cod_area) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getTiilc_territorio_fk_tiilc_area_fk_cod_area(),newTiilc_territorio_fk_tiilc_area_fk_cod_area);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setTiilc_territorio_fk_tiilc_area_fk_cod_area(newTiilc_territorio_fk_tiilc_area_fk_cod_area);
	}
	/**
	 * Get accessor for persistent attribute: tiilc_territorio_fk_cod_territorio
	 */
	public java.lang.String getTiilc_territorio_fk_cod_territorio() {
		return dataCacheEntry.getTiilc_territorio_fk_cod_territorio();
	}
	/**
	 * Set accessor for persistent attribute: tiilc_territorio_fk_cod_territorio
	 */
	public void setTiilc_territorio_fk_cod_territorio(java.lang.String newTiilc_territorio_fk_cod_territorio) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getTiilc_territorio_fk_cod_territorio(),newTiilc_territorio_fk_cod_territorio);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setTiilc_territorio_fk_cod_territorio(newTiilc_territorio_fk_cod_territorio);
	}
}
