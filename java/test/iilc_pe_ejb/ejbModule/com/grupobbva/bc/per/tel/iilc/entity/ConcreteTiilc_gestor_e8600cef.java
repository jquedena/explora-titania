package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_gestorBeanCacheEntry_e8600cef;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_gestor
 */
public class ConcreteTiilc_gestor_e8600cef extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiilc_gestorBeanCacheEntry_e8600cef dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_gestor_e8600cef
	 */
	public ConcreteTiilc_gestor_e8600cef() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_gestorBeanInjector_e8600cef getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_gestorBeanInjector_e8600cef)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_gestorBeanCacheEntry_e8600cef) inRecord;
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
			tiilc_oficina_fkLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindGestorxRegGestor_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey ejbFindGestorxRegGestor_Local(java.lang.String reg_gestor) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindGestorxRegGestor");
		getInjector().ejbFindGestorxRegGestor(reg_gestor, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey) instanceExtension.executeFind("FindGestorxRegGestor", record);
	}
	/**
	 * ejbFindAllGestor_Local
	 */
	public java.util.Collection ejbFindAllGestor_Local(java.lang.String cod_area) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllGestor");
		getInjector().ejbFindAllGestor(cod_area, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllGestor", record);
	}
	/**
	 * ejbFindAllGestorxOfxTexAr_Local
	 */
	public java.util.Collection ejbFindAllGestorxOfxTexAr_Local(java.lang.String cod_oficina, java.lang.String cod_territorio, java.lang.String cod_area) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllGestorxOfxTexAr");
		getInjector().ejbFindAllGestorxOfxTexAr(cod_oficina, cod_territorio, cod_area, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllGestorxOfxTexAr", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey ejbCreate(java.lang.String cod_gestor, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal argTiilc_oficina_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_gestorBeanCacheEntry_e8600cef) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_gestor, argTiilc_oficina_fk);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_gestor, com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal argTiilc_oficina_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_gestor, argTiilc_oficina_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey ejbCreate(java.lang.String cod_gestor, java.lang.String tiilc_oficina_fk_cod_oficina, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_gestorBeanCacheEntry_e8600cef) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_gestor, java.lang.String tiilc_oficina_fk_cod_oficina, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey ejbCreate(java.lang.String cod_gestor, java.lang.String tiilc_oficina_fk_cod_oficina, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area, java.lang.String nom_gestor, java.lang.String reg_gestor, java.lang.String perfil_gestor) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_gestorBeanCacheEntry_e8600cef) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area, nom_gestor, reg_gestor, perfil_gestor);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_gestor, java.lang.String tiilc_oficina_fk_cod_oficina, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, java.lang.String tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area, java.lang.String nom_gestor, java.lang.String reg_gestor, java.lang.String perfil_gestor) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_gestor, tiilc_oficina_fk_cod_oficina, tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio, tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area, nom_gestor, reg_gestor, perfil_gestor);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_gestorKey();
		pk.cod_gestor = getCod_gestor();
		pk.tiilc_oficina_fk_cod_oficina = getTiilc_oficina_fk_cod_oficina();
		pk.tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio = getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio();
		pk.tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area = getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 8;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiilc_oficina_fk")) return getTiilc_oficina_fkLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiilc_oficina_fk")){
			com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanInternalLocalHome_9f94ea7f home = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_oficinaBeanInternalLocalHome_9f94ea7f)instanceExtension.getHomeForLink("tiilc_oficina_fk");
		  return home.findByPrimaryKeyForCMR((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey)key);
		}
		return null;
	}
	/**
	 * getTiilc_oficina_fk
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal getTiilc_oficina_fk() {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal)getTiilc_oficina_fkLink().getValue();
	}
	/**
	 * setTiilc_oficina_fk
	 */
	public void setTiilc_oficina_fk(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaLocal value) {
		getTiilc_oficina_fkLink().setValue(value);
	}
	/**
	 * getTiilc_oficina_fkKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey getTiilc_oficina_fkKey() {
		if (tiilc_oficina_fkLink == null) return dataCacheEntry.getTiilc_oficina_fkKey();
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey) tiilc_oficina_fkLink.getKey();
	}
	/**
	 * getTiilc_oficina_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiilc_oficina_fkLink() {
		if (tiilc_oficina_fkLink == null) 
		tiilc_oficina_fkLink = instanceExtension.createLink("tiilc_oficina_fk",dataCacheEntry.getTiilc_oficina_fkKey(),7);
		return tiilc_oficina_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiilc_oficina_fkLink;
	/**
	 * ejbFindTiilc_gestorByTiilc_oficina_fkKey_Local
	 */
	public java.util.Collection ejbFindTiilc_gestorByTiilc_oficina_fkKey_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiilc_oficina_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiilc_gestorByTiilc_oficina_fkKey_Local");
		getInjector().findTiilc_gestorByTiilc_oficina_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiilc_gestorByTiilc_oficina_fkKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiilc_oficina_fkLink != null) 
		dataCacheEntry.setTiilc_oficina_fkKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaKey) tiilc_oficina_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public java.lang.String getCod_gestor() {
		return dataCacheEntry.getCod_gestor();
	}
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public void setCod_gestor(java.lang.String newCod_gestor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_gestor(),newCod_gestor);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_gestor(newCod_gestor);
	}
	/**
	 * Get accessor for persistent attribute: nom_gestor
	 */
	public java.lang.String getNom_gestor() {
		return dataCacheEntry.getNom_gestor();
	}
	/**
	 * Set accessor for persistent attribute: nom_gestor
	 */
	public void setNom_gestor(java.lang.String newNom_gestor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getNom_gestor(),newNom_gestor);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setNom_gestor(newNom_gestor);
	}
	/**
	 * Get accessor for persistent attribute: reg_gestor
	 */
	public java.lang.String getReg_gestor() {
		return dataCacheEntry.getReg_gestor();
	}
	/**
	 * Set accessor for persistent attribute: reg_gestor
	 */
	public void setReg_gestor(java.lang.String newReg_gestor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getReg_gestor(),newReg_gestor);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setReg_gestor(newReg_gestor);
	}
	/**
	 * Get accessor for persistent attribute: perfil_gestor
	 */
	public java.lang.String getPerfil_gestor() {
		return dataCacheEntry.getPerfil_gestor();
	}
	/**
	 * Set accessor for persistent attribute: perfil_gestor
	 */
	public void setPerfil_gestor(java.lang.String newPerfil_gestor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getPerfil_gestor(),newPerfil_gestor);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setPerfil_gestor(newPerfil_gestor);
	}
	/**
	 * Get accessor for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public java.lang.String getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area() {
		return dataCacheEntry.getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area();
	}
	/**
	 * Set accessor for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area
	 */
	public void setTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area(java.lang.String newTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area(),newTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area(newTiilc_oficina_fk_tiilc_territorio_fk_tiilc_area_fk_cod_area);
	}
	/**
	 * Get accessor for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio
	 */
	public java.lang.String getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio() {
		return dataCacheEntry.getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio();
	}
	/**
	 * Set accessor for persistent attribute: tiilc_oficina_fk_tiilc_territorio_fk_cod_territorio
	 */
	public void setTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio(java.lang.String newTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio(),newTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio(newTiilc_oficina_fk_tiilc_territorio_fk_cod_territorio);
	}
	/**
	 * Get accessor for persistent attribute: tiilc_oficina_fk_cod_oficina
	 */
	public java.lang.String getTiilc_oficina_fk_cod_oficina() {
		return dataCacheEntry.getTiilc_oficina_fk_cod_oficina();
	}
	/**
	 * Set accessor for persistent attribute: tiilc_oficina_fk_cod_oficina
	 */
	public void setTiilc_oficina_fk_cod_oficina(java.lang.String newTiilc_oficina_fk_cod_oficina) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getTiilc_oficina_fk_cod_oficina(),newTiilc_oficina_fk_cod_oficina);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setTiilc_oficina_fk_cod_oficina(newTiilc_oficina_fk_cod_oficina);
	}
}
