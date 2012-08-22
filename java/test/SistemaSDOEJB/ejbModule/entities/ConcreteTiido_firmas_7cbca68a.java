package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_firmasBeanCacheEntry_7cbca68a;

/**
 * Bean implementation class for Enterprise Bean: Tiido_firmas
 */
public class ConcreteTiido_firmas_7cbca68a extends entities.Tiido_firmasBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiido_firmasBeanCacheEntry_7cbca68a dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_firmas_7cbca68a
	 */
	public ConcreteTiido_firmas_7cbca68a() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_firmasBeanInjector_7cbca68a getInjector() {
		return (entities.websphere_deploy.Tiido_firmasBeanInjector_7cbca68a)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_firmasBeanCacheEntry_7cbca68a) inRecord;
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
			tiido_fir_oficina_fkLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_firmasKey ejbFindByPrimaryKey(entities.Tiido_firmasKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_firmasKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindFirmByAnoMesCgesItem_Local
	 */
	public entities.Tiido_firmasKey ejbFindFirmByAnoMesCgesItem_Local(java.lang.String anho, java.lang.String mes, java.lang.String codGestor, java.lang.String item) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindFirmByAnoMesCgesItem");
		getInjector().ejbFindFirmByAnoMesCgesItem(anho, mes, codGestor, item, record);
		return (entities.Tiido_firmasKey) instanceExtension.executeFind("FindFirmByAnoMesCgesItem", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_firmasKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_firmasKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_firmasKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_firmasKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_firmasKey ejbCreate(java.lang.String cod_firma, entities.Tiido_oficinaLocal argTiido_fir_oficina_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_firmasBeanCacheEntry_7cbca68a) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_firma, argTiido_fir_oficina_fk);
		return (entities.Tiido_firmasKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_firma, entities.Tiido_oficinaLocal argTiido_fir_oficina_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_firma, argTiido_fir_oficina_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_firmasKey ejbCreate(java.lang.String cod_firma, java.lang.String tiido_fir_oficina_fk_cod_ofic, java.lang.String tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_firmasBeanCacheEntry_7cbca68a) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_firma, tiido_fir_oficina_fk_cod_ofic, tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
		return (entities.Tiido_firmasKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_firma, java.lang.String tiido_fir_oficina_fk_cod_ofic, java.lang.String tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_firma, tiido_fir_oficina_fk_cod_ofic, tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_firmasKey pk = new entities.Tiido_firmasKey();
		pk.cod_firma = getCod_firma();
		pk.tiido_fir_oficina_fk_cod_ofic = getTiido_fir_oficina_fk_cod_ofic();
		pk.tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr = getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 10;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiido_fir_oficina_fk")) return getTiido_fir_oficina_fkLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_fir_oficina_fk")){
			entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8 home = (entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8)instanceExtension.getHomeForLink("tiido_fir_oficina_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_oficinaKey)key);
		}
		return null;
	}
	/**
	 * getTiido_fir_oficina_fk
	 */
	public entities.Tiido_oficinaLocal getTiido_fir_oficina_fk() {
		return (entities.Tiido_oficinaLocal)getTiido_fir_oficina_fkLink().getValue();
	}
	/**
	 * setTiido_fir_oficina_fk
	 */
	public void setTiido_fir_oficina_fk(entities.Tiido_oficinaLocal value) {
		getTiido_fir_oficina_fkLink().setValue(value);
	}
	/**
	 * getTiido_fir_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_fir_oficina_fkKey() {
		if (tiido_fir_oficina_fkLink == null) return dataCacheEntry.getTiido_fir_oficina_fkKey();
		return (entities.Tiido_oficinaKey) tiido_fir_oficina_fkLink.getKey();
	}
	/**
	 * getTiido_fir_oficina_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_fir_oficina_fkLink() {
		if (tiido_fir_oficina_fkLink == null) 
		tiido_fir_oficina_fkLink = instanceExtension.createLink("tiido_fir_oficina_fk",dataCacheEntry.getTiido_fir_oficina_fkKey(),9);
		return tiido_fir_oficina_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_fir_oficina_fkLink;
	/**
	 * ejbFindTiido_firmasByTiido_fir_oficina_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_firmasByTiido_fir_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_fir_oficina_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_firmasByTiido_fir_oficina_fkKey_Local");
		getInjector().findTiido_firmasByTiido_fir_oficina_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_firmasByTiido_fir_oficina_fkKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiido_fir_oficina_fkLink != null) 
		dataCacheEntry.setTiido_fir_oficina_fkKey((entities.Tiido_oficinaKey) tiido_fir_oficina_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_firma
	 */
	public java.lang.String getCod_firma() {
		return dataCacheEntry.getCod_firma();
	}
	/**
	 * Set accessor for persistent attribute: cod_firma
	 */
	public void setCod_firma(java.lang.String newCod_firma) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_firma(),newCod_firma);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_firma(newCod_firma);
	}
	/**
	 * Get accessor for persistent attribute: anho_firm
	 */
	public java.lang.String getAnho_firm() {
		return dataCacheEntry.getAnho_firm();
	}
	/**
	 * Set accessor for persistent attribute: anho_firm
	 */
	public void setAnho_firm(java.lang.String newAnho_firm) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getAnho_firm(),newAnho_firm);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setAnho_firm(newAnho_firm);
	}
	/**
	 * Get accessor for persistent attribute: mes_firm
	 */
	public java.lang.String getMes_firm() {
		return dataCacheEntry.getMes_firm();
	}
	/**
	 * Set accessor for persistent attribute: mes_firm
	 */
	public void setMes_firm(java.lang.String newMes_firm) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getMes_firm(),newMes_firm);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setMes_firm(newMes_firm);
	}
	/**
	 * Get accessor for persistent attribute: item_firm
	 */
	public java.lang.String getItem_firm() {
		return dataCacheEntry.getItem_firm();
	}
	/**
	 * Set accessor for persistent attribute: item_firm
	 */
	public void setItem_firm(java.lang.String newItem_firm) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getItem_firm(),newItem_firm);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setItem_firm(newItem_firm);
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
			instanceExtension.markDirty(4,getCod_gestor(),newCod_gestor);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setCod_gestor(newCod_gestor);
	}
	/**
	 * Get accessor for persistent attribute: descripcion
	 */
	public java.lang.String getDescripcion() {
		return dataCacheEntry.getDescripcion();
	}
	/**
	 * Set accessor for persistent attribute: descripcion
	 */
	public void setDescripcion(java.lang.String newDescripcion) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getDescripcion(),newDescripcion);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setDescripcion(newDescripcion);
	}
	/**
	 * Get accessor for persistent attribute: fec_firm
	 */
	public java.sql.Date getFec_firm() {
		return dataCacheEntry.getFec_firm();
	}
	/**
	 * Set accessor for persistent attribute: fec_firm
	 */
	public void setFec_firm(java.sql.Date newFec_firm) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getFec_firm(),newFec_firm);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setFec_firm(newFec_firm);
	}
	/**
	 * Get accessor for persistent attribute: tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr() {
		return dataCacheEntry.getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr();
	}
	/**
	 * Set accessor for persistent attribute: tiido_fir_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr(java.lang.String newTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr(),newTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr(newTiido_fir_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * Get accessor for persistent attribute: tiido_fir_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_fir_oficina_fk_cod_ofic() {
		return dataCacheEntry.getTiido_fir_oficina_fk_cod_ofic();
	}
	/**
	 * Set accessor for persistent attribute: tiido_fir_oficina_fk_cod_ofic
	 */
	public void setTiido_fir_oficina_fk_cod_ofic(java.lang.String newTiido_fir_oficina_fk_cod_ofic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getTiido_fir_oficina_fk_cod_ofic(),newTiido_fir_oficina_fk_cod_ofic);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setTiido_fir_oficina_fk_cod_ofic(newTiido_fir_oficina_fk_cod_ofic);
	}
}
