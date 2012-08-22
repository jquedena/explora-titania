package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_oficinaBeanCacheEntry_30d934a8;

/**
 * Bean implementation class for Enterprise Bean: Tiido_oficina
 */
public class ConcreteTiido_oficina_30d934a8 extends entities.Tiido_oficinaBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiido_oficinaBeanCacheEntry_30d934a8 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_oficina_30d934a8
	 */
	public ConcreteTiido_oficina_30d934a8() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_oficinaBeanInjector_30d934a8 getInjector() {
		return (entities.websphere_deploy.Tiido_oficinaBeanInjector_30d934a8)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_oficinaBeanCacheEntry_30d934a8) inRecord;
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
			tiido_territorio_fkLink = null;
			tiido_accionesLink = null;
			tiido_campaniasLink = null;
			tiido_firmasLink = null;
			tiido_maestro_planesLink = null;
			tiido_metas_gestorLink = null;
			tiido_planesLink = null;
	}
	/**
	 * ejbFindByCodOficina_Local
	 */
	public entities.Tiido_oficinaKey ejbFindByCodOficina_Local(java.lang.String codOficina) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCodOficina");
		getInjector().ejbFindByCodOficina(codOficina, record);
		return (entities.Tiido_oficinaKey) instanceExtension.executeFind("FindByCodOficina", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_oficinaKey ejbFindByPrimaryKey(entities.Tiido_oficinaKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_oficinaKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllOficinaByCodTerri_Local
	 */
	public java.util.Collection ejbFindAllOficinaByCodTerri_Local(java.lang.String codTerritorio) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllOficinaByCodTerri");
		getInjector().ejbFindAllOficinaByCodTerri(codTerritorio, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllOficinaByCodTerri", record);
	}
	/**
	 * ejbFindListaByCodOficina_Local
	 */
	public java.util.Collection ejbFindListaByCodOficina_Local(java.lang.String codOficina) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindListaByCodOficina");
		getInjector().ejbFindListaByCodOficina(codOficina, record);
		return (java.util.Collection) instanceExtension.executeFind("FindListaByCodOficina", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_oficinaKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_oficinaKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_oficinaKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_oficinaKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_oficinaKey ejbCreate(java.lang.String cod_ofic, entities.Tiido_territorioLocal argTiido_territorio_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_oficinaBeanCacheEntry_30d934a8) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_ofic, argTiido_territorio_fk);
		return (entities.Tiido_oficinaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_ofic, entities.Tiido_territorioLocal argTiido_territorio_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_ofic, argTiido_territorio_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_oficinaKey ejbCreate(java.lang.String cod_ofic, java.lang.String tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_oficinaBeanCacheEntry_30d934a8) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_ofic, tiido_territorio_fk_cod_terr);
		return (entities.Tiido_oficinaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_ofic, java.lang.String tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_ofic, tiido_territorio_fk_cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_oficinaKey ejbCreate(java.lang.String cod_ofic, java.lang.String nom_ofic, java.lang.String tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_oficinaBeanCacheEntry_30d934a8) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_ofic, nom_ofic, tiido_territorio_fk_cod_terr);
		return (entities.Tiido_oficinaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_ofic, java.lang.String nom_ofic, java.lang.String tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_ofic, nom_ofic, tiido_territorio_fk_cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_oficinaKey pk = new entities.Tiido_oficinaKey();
		pk.cod_ofic = getCod_ofic();
		pk.tiido_territorio_fk_cod_terr = getTiido_territorio_fk_cod_terr();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 15;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiido_territorio_fk")) return getTiido_territorio_fkLink();
		if (name.equals("tiido_acciones")) return getTiido_accionesLink();
		if (name.equals("tiido_campanias")) return getTiido_campaniasLink();
		if (name.equals("tiido_firmas")) return getTiido_firmasLink();
		if (name.equals("tiido_maestro_planes")) return getTiido_maestro_planesLink();
		if (name.equals("tiido_metas_gestor")) return getTiido_metas_gestorLink();
		if (name.equals("tiido_planes")) return getTiido_planesLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_territorio_fk")){
			entities.websphere_deploy.Tiido_territorioBeanInternalLocalHome_9aeef014 home = (entities.websphere_deploy.Tiido_territorioBeanInternalLocalHome_9aeef014)instanceExtension.getHomeForLink("tiido_territorio_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_territorioKey)key);
		}
		if (name.equals("tiido_acciones")){
			entities.websphere_deploy.Tiido_accionesBeanInternalLocalHome_f77de715 home = (entities.websphere_deploy.Tiido_accionesBeanInternalLocalHome_f77de715)instanceExtension.getHomeForLink("tiido_acciones");
		  return home.findTiido_accionesByTiido_acc_oficina_fkKey_Local((entities.Tiido_oficinaKey)key);
		}
		if (name.equals("tiido_campanias")){
			entities.websphere_deploy.Tiido_campaniasBeanInternalLocalHome_97b3883c home = (entities.websphere_deploy.Tiido_campaniasBeanInternalLocalHome_97b3883c)instanceExtension.getHomeForLink("tiido_campanias");
		  return home.findTiido_campaniasByTiido_cam_oficina_fkKey_Local((entities.Tiido_oficinaKey)key);
		}
		if (name.equals("tiido_firmas")){
			entities.websphere_deploy.Tiido_firmasBeanInternalLocalHome_7cbca68a home = (entities.websphere_deploy.Tiido_firmasBeanInternalLocalHome_7cbca68a)instanceExtension.getHomeForLink("tiido_firmas");
		  return home.findTiido_firmasByTiido_fir_oficina_fkKey_Local((entities.Tiido_oficinaKey)key);
		}
		if (name.equals("tiido_maestro_planes")){
			entities.websphere_deploy.Tiido_maestro_planesBeanInternalLocalHome_83d95438 home = (entities.websphere_deploy.Tiido_maestro_planesBeanInternalLocalHome_83d95438)instanceExtension.getHomeForLink("tiido_maestro_planes");
		  return home.findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local((entities.Tiido_oficinaKey)key);
		}
		if (name.equals("tiido_metas_gestor")){
			entities.websphere_deploy.Tiido_metas_gestorBeanInternalLocalHome_238e66e0 home = (entities.websphere_deploy.Tiido_metas_gestorBeanInternalLocalHome_238e66e0)instanceExtension.getHomeForLink("tiido_metas_gestor");
		  return home.findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local((entities.Tiido_oficinaKey)key);
		}
		if (name.equals("tiido_planes")){
			entities.websphere_deploy.Tiido_planesBeanInternalLocalHome_f95fafaa home = (entities.websphere_deploy.Tiido_planesBeanInternalLocalHome_f95fafaa)instanceExtension.getHomeForLink("tiido_planes");
		  return home.findTiido_planesByTiido_pla_oficina_fkKey_Local((entities.Tiido_oficinaKey)key);
		}
		return null;
	}
	/**
	 * getTiido_territorio_fk
	 */
	public entities.Tiido_territorioLocal getTiido_territorio_fk() {
		return (entities.Tiido_territorioLocal)getTiido_territorio_fkLink().getValue();
	}
	/**
	 * setTiido_territorio_fk
	 */
	public void setTiido_territorio_fk(entities.Tiido_territorioLocal value) {
		getTiido_territorio_fkLink().setValue(value);
	}
	/**
	 * getTiido_territorio_fkKey
	 */
	public entities.Tiido_territorioKey getTiido_territorio_fkKey() {
		if (tiido_territorio_fkLink == null) return dataCacheEntry.getTiido_territorio_fkKey();
		return (entities.Tiido_territorioKey) tiido_territorio_fkLink.getKey();
	}
	/**
	 * getTiido_territorio_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_territorio_fkLink() {
		if (tiido_territorio_fkLink == null) 
		tiido_territorio_fkLink = instanceExtension.createLink("tiido_territorio_fk",dataCacheEntry.getTiido_territorio_fkKey(),8);
		return tiido_territorio_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_territorio_fkLink;
	/**
	 * ejbFindTiido_oficinaByTiido_territorio_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_oficinaByTiido_territorio_fkKey_Local(entities.Tiido_territorioKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_territorio_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_oficinaByTiido_territorio_fkKey_Local");
		getInjector().findTiido_oficinaByTiido_territorio_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_oficinaByTiido_territorio_fkKey_Local", record);
	}
	/**
	 * getTiido_acciones
	 */
	public java.util.Collection getTiido_acciones() {
		return (java.util.Collection)getTiido_accionesLink().getValue();
	}
	/**
	 * setTiido_acciones
	 */
	public void setTiido_acciones(java.util.Collection value) {
		getTiido_accionesLink().setValue(value);
	}
	/**
	 * getTiido_accionesLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_accionesLink() {
		if (tiido_accionesLink == null) 
		tiido_accionesLink = instanceExtension.createLink("tiido_acciones",null,9);
		return tiido_accionesLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_accionesLink;
	/**
	 * ejbFindTiido_acc_oficina_fkByTiido_accionesKey_Local
	 */
	public entities.Tiido_oficinaKey ejbFindTiido_acc_oficina_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_acciones",key);
		if (result!=null )  return (entities.Tiido_oficinaKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_acc_oficina_fkByTiido_accionesKey_Local");
		getInjector().findTiido_acc_oficina_fkByTiido_accionesKey_Local(key, record);
		return (entities.Tiido_oficinaKey) instanceExtension.executeFind("findTiido_acc_oficina_fkByTiido_accionesKey_Local", record);
	}
	/**
	 * getTiido_campanias
	 */
	public java.util.Collection getTiido_campanias() {
		return (java.util.Collection)getTiido_campaniasLink().getValue();
	}
	/**
	 * setTiido_campanias
	 */
	public void setTiido_campanias(java.util.Collection value) {
		getTiido_campaniasLink().setValue(value);
	}
	/**
	 * getTiido_campaniasLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_campaniasLink() {
		if (tiido_campaniasLink == null) 
		tiido_campaniasLink = instanceExtension.createLink("tiido_campanias",null,10);
		return tiido_campaniasLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_campaniasLink;
	/**
	 * ejbFindTiido_cam_oficina_fkByTiido_campaniasKey_Local
	 */
	public entities.Tiido_oficinaKey ejbFindTiido_cam_oficina_fkByTiido_campaniasKey_Local(entities.Tiido_campaniasKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_campanias",key);
		if (result!=null )  return (entities.Tiido_oficinaKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_cam_oficina_fkByTiido_campaniasKey_Local");
		getInjector().findTiido_cam_oficina_fkByTiido_campaniasKey_Local(key, record);
		return (entities.Tiido_oficinaKey) instanceExtension.executeFind("findTiido_cam_oficina_fkByTiido_campaniasKey_Local", record);
	}
	/**
	 * getTiido_firmas
	 */
	public java.util.Collection getTiido_firmas() {
		return (java.util.Collection)getTiido_firmasLink().getValue();
	}
	/**
	 * setTiido_firmas
	 */
	public void setTiido_firmas(java.util.Collection value) {
		getTiido_firmasLink().setValue(value);
	}
	/**
	 * getTiido_firmasLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_firmasLink() {
		if (tiido_firmasLink == null) 
		tiido_firmasLink = instanceExtension.createLink("tiido_firmas",null,11);
		return tiido_firmasLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_firmasLink;
	/**
	 * ejbFindTiido_fir_oficina_fkByTiido_firmasKey_Local
	 */
	public entities.Tiido_oficinaKey ejbFindTiido_fir_oficina_fkByTiido_firmasKey_Local(entities.Tiido_firmasKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_firmas",key);
		if (result!=null )  return (entities.Tiido_oficinaKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_fir_oficina_fkByTiido_firmasKey_Local");
		getInjector().findTiido_fir_oficina_fkByTiido_firmasKey_Local(key, record);
		return (entities.Tiido_oficinaKey) instanceExtension.executeFind("findTiido_fir_oficina_fkByTiido_firmasKey_Local", record);
	}
	/**
	 * getTiido_maestro_planes
	 */
	public java.util.Collection getTiido_maestro_planes() {
		return (java.util.Collection)getTiido_maestro_planesLink().getValue();
	}
	/**
	 * setTiido_maestro_planes
	 */
	public void setTiido_maestro_planes(java.util.Collection value) {
		getTiido_maestro_planesLink().setValue(value);
	}
	/**
	 * getTiido_maestro_planesLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_maestro_planesLink() {
		if (tiido_maestro_planesLink == null) 
		tiido_maestro_planesLink = instanceExtension.createLink("tiido_maestro_planes",null,12);
		return tiido_maestro_planesLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_maestro_planesLink;
	/**
	 * ejbFindTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local
	 */
	public entities.Tiido_oficinaKey ejbFindTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local(entities.Tiido_maestro_planesKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_maestro_planes",key);
		if (result!=null )  return (entities.Tiido_oficinaKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local");
		getInjector().findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local(key, record);
		return (entities.Tiido_oficinaKey) instanceExtension.executeFind("findTiido_maepla_oficina_fkByTiido_maestro_planesKey_Local", record);
	}
	/**
	 * getTiido_metas_gestor
	 */
	public java.util.Collection getTiido_metas_gestor() {
		return (java.util.Collection)getTiido_metas_gestorLink().getValue();
	}
	/**
	 * setTiido_metas_gestor
	 */
	public void setTiido_metas_gestor(java.util.Collection value) {
		getTiido_metas_gestorLink().setValue(value);
	}
	/**
	 * getTiido_metas_gestorLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_metas_gestorLink() {
		if (tiido_metas_gestorLink == null) 
		tiido_metas_gestorLink = instanceExtension.createLink("tiido_metas_gestor",null,13);
		return tiido_metas_gestorLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_metas_gestorLink;
	/**
	 * ejbFindTiido_metges_oficina_fkByTiido_metas_gestorKey_Local
	 */
	public entities.Tiido_oficinaKey ejbFindTiido_metges_oficina_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_metas_gestor",key);
		if (result!=null )  return (entities.Tiido_oficinaKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local");
		getInjector().findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local(key, record);
		return (entities.Tiido_oficinaKey) instanceExtension.executeFind("findTiido_metges_oficina_fkByTiido_metas_gestorKey_Local", record);
	}
	/**
	 * getTiido_planes
	 */
	public java.util.Collection getTiido_planes() {
		return (java.util.Collection)getTiido_planesLink().getValue();
	}
	/**
	 * setTiido_planes
	 */
	public void setTiido_planes(java.util.Collection value) {
		getTiido_planesLink().setValue(value);
	}
	/**
	 * getTiido_planesLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_planesLink() {
		if (tiido_planesLink == null) 
		tiido_planesLink = instanceExtension.createLink("tiido_planes",null,14);
		return tiido_planesLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_planesLink;
	/**
	 * ejbFindTiido_pla_oficina_fkByTiido_planesKey_Local
	 */
	public entities.Tiido_oficinaKey ejbFindTiido_pla_oficina_fkByTiido_planesKey_Local(entities.Tiido_planesKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_planes",key);
		if (result!=null )  return (entities.Tiido_oficinaKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_pla_oficina_fkByTiido_planesKey_Local");
		getInjector().findTiido_pla_oficina_fkByTiido_planesKey_Local(key, record);
		return (entities.Tiido_oficinaKey) instanceExtension.executeFind("findTiido_pla_oficina_fkByTiido_planesKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiido_territorio_fkLink != null) 
		dataCacheEntry.setTiido_territorio_fkKey((entities.Tiido_territorioKey) tiido_territorio_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_ofic
	 */
	public java.lang.String getCod_ofic() {
		return dataCacheEntry.getCod_ofic();
	}
	/**
	 * Set accessor for persistent attribute: cod_ofic
	 */
	public void setCod_ofic(java.lang.String newCod_ofic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_ofic(),newCod_ofic);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_ofic(newCod_ofic);
	}
	/**
	 * Get accessor for persistent attribute: nom_ofic
	 */
	public java.lang.String getNom_ofic() {
		return dataCacheEntry.getNom_ofic();
	}
	/**
	 * Set accessor for persistent attribute: nom_ofic
	 */
	public void setNom_ofic(java.lang.String newNom_ofic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getNom_ofic(),newNom_ofic);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setNom_ofic(newNom_ofic);
	}
	/**
	 * Get accessor for persistent attribute: usu_regi
	 */
	public java.lang.String getUsu_regi() {
		return dataCacheEntry.getUsu_regi();
	}
	/**
	 * Set accessor for persistent attribute: usu_regi
	 */
	public void setUsu_regi(java.lang.String newUsu_regi) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getUsu_regi(),newUsu_regi);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setUsu_regi(newUsu_regi);
	}
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public java.sql.Date getFec_regi() {
		return dataCacheEntry.getFec_regi();
	}
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public void setFec_regi(java.sql.Date newFec_regi) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getFec_regi(),newFec_regi);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setFec_regi(newFec_regi);
	}
	/**
	 * Get accessor for persistent attribute: usu_actu
	 */
	public java.lang.String getUsu_actu() {
		return dataCacheEntry.getUsu_actu();
	}
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public void setUsu_actu(java.lang.String newUsu_actu) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getUsu_actu(),newUsu_actu);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setUsu_actu(newUsu_actu);
	}
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public java.sql.Date getFec_actu() {
		return dataCacheEntry.getFec_actu();
	}
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public void setFec_actu(java.sql.Date newFec_actu) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getFec_actu(),newFec_actu);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setFec_actu(newFec_actu);
	}
	/**
	 * Get accessor for persistent attribute: tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_territorio_fk_cod_terr() {
		return dataCacheEntry.getTiido_territorio_fk_cod_terr();
	}
	/**
	 * Set accessor for persistent attribute: tiido_territorio_fk_cod_terr
	 */
	public void setTiido_territorio_fk_cod_terr(java.lang.String newTiido_territorio_fk_cod_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getTiido_territorio_fk_cod_terr(),newTiido_territorio_fk_cod_terr);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setTiido_territorio_fk_cod_terr(newTiido_territorio_fk_cod_terr);
	}
	/**
	 * Get accessor for persistent attribute: estado
	 */
	public java.lang.String getEstado() {
		return dataCacheEntry.getEstado();
	}
	/**
	 * Set accessor for persistent attribute: estado
	 */
	public void setEstado(java.lang.String newEstado) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getEstado(),newEstado);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setEstado(newEstado);
	}
}
