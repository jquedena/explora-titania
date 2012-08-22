package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_metas_gestorBeanCacheEntry_238e66e0;

/**
 * Bean implementation class for Enterprise Bean: Tiido_metas_gestor
 */
public class ConcreteTiido_metas_gestor_238e66e0 extends entities.Tiido_metas_gestorBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiido_metas_gestorBeanCacheEntry_238e66e0 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_metas_gestor_238e66e0
	 */
	public ConcreteTiido_metas_gestor_238e66e0() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_metas_gestorBeanInjector_238e66e0 getInjector() {
		return (entities.websphere_deploy.Tiido_metas_gestorBeanInjector_238e66e0)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_metas_gestorBeanCacheEntry_238e66e0) inRecord;
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
			tiido_metges_epigrafe_fkLink = null;
			tiido_metges_oficina_fkLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_metas_gestorKey ejbFindByPrimaryKey(entities.Tiido_metas_gestorKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_metas_gestorKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindGestorByCodigo_Local
	 */
	public entities.Tiido_metas_gestorKey ejbFindGestorByCodigo_Local(java.lang.String codGestor) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindGestorByCodigo");
		getInjector().ejbFindGestorByCodigo(codGestor, record);
		return (entities.Tiido_metas_gestorKey) instanceExtension.executeFind("FindGestorByCodigo", record);
	}
	/**
	 * ejbFindMetGestorByPrimaryKey_Local
	 */
	public entities.Tiido_metas_gestorKey ejbFindMetGestorByPrimaryKey_Local(java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String codGestor) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindMetGestorByPrimaryKey");
		getInjector().ejbFindMetGestorByPrimaryKey(codEpigrafe, anho, codOficina, mes, codGestor, record);
		return (entities.Tiido_metas_gestorKey) instanceExtension.executeFind("FindMetGestorByPrimaryKey", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_metas_gestorKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_metas_gestorKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_metas_gestorKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_metas_gestorKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_metas_gestorKey ejbCreate(com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor metasGestor, entities.Tiido_epigrafeLocal epigrafeLocal, entities.Tiido_oficinaLocal oficinaLocal) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_metas_gestorBeanCacheEntry_238e66e0) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(metasGestor, epigrafeLocal, oficinaLocal);
		return (entities.Tiido_metas_gestorKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor metasGestor, entities.Tiido_epigrafeLocal epigrafeLocal, entities.Tiido_oficinaLocal oficinaLocal) throws javax.ejb.CreateException {
		super.ejbPostCreate(metasGestor, epigrafeLocal, oficinaLocal);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_metas_gestorKey ejbCreate(java.lang.String cod_meta_gestor, entities.Tiido_epigrafeLocal argTiido_metges_epigrafe_fk, entities.Tiido_oficinaLocal argTiido_metges_oficina_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_metas_gestorBeanCacheEntry_238e66e0) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_meta_gestor, argTiido_metges_epigrafe_fk, argTiido_metges_oficina_fk);
		return (entities.Tiido_metas_gestorKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_meta_gestor, entities.Tiido_epigrafeLocal argTiido_metges_epigrafe_fk, entities.Tiido_oficinaLocal argTiido_metges_oficina_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_meta_gestor, argTiido_metges_epigrafe_fk, argTiido_metges_oficina_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_metas_gestorKey ejbCreate(java.lang.String cod_meta_gestor, java.lang.String tiido_metges_epigrafe_fk_cod_epigrafe, java.lang.String tiido_metges_epigrafe_fk_anho, java.lang.String tiido_metges_oficina_fk_cod_ofic, java.lang.String tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_metas_gestorBeanCacheEntry_238e66e0) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_meta_gestor, tiido_metges_epigrafe_fk_cod_epigrafe, tiido_metges_epigrafe_fk_anho, tiido_metges_oficina_fk_cod_ofic, tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
		return (entities.Tiido_metas_gestorKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_meta_gestor, java.lang.String tiido_metges_epigrafe_fk_cod_epigrafe, java.lang.String tiido_metges_epigrafe_fk_anho, java.lang.String tiido_metges_oficina_fk_cod_ofic, java.lang.String tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_meta_gestor, tiido_metges_epigrafe_fk_cod_epigrafe, tiido_metges_epigrafe_fk_anho, tiido_metges_oficina_fk_cod_ofic, tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_metas_gestorKey pk = new entities.Tiido_metas_gestorKey();
		pk.cod_meta_gestor = getCod_meta_gestor();
		pk.tiido_metges_epigrafe_fk_cod_epigrafe = getTiido_metges_epigrafe_fk_cod_epigrafe();
		pk.tiido_metges_epigrafe_fk_anho = getTiido_metges_epigrafe_fk_anho();
		pk.tiido_metges_oficina_fk_cod_ofic = getTiido_metges_oficina_fk_cod_ofic();
		pk.tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr = getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 19;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiido_metges_epigrafe_fk")) return getTiido_metges_epigrafe_fkLink();
		if (name.equals("tiido_metges_oficina_fk")) return getTiido_metges_oficina_fkLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_metges_epigrafe_fk")){
			entities.websphere_deploy.Tiido_epigrafeBeanInternalLocalHome_b2c8f8ed home = (entities.websphere_deploy.Tiido_epigrafeBeanInternalLocalHome_b2c8f8ed)instanceExtension.getHomeForLink("tiido_metges_epigrafe_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_epigrafeKey)key);
		}
		if (name.equals("tiido_metges_oficina_fk")){
			entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8 home = (entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8)instanceExtension.getHomeForLink("tiido_metges_oficina_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_oficinaKey)key);
		}
		return null;
	}
	/**
	 * getTiido_metges_epigrafe_fk
	 */
	public entities.Tiido_epigrafeLocal getTiido_metges_epigrafe_fk() {
		return (entities.Tiido_epigrafeLocal)getTiido_metges_epigrafe_fkLink().getValue();
	}
	/**
	 * setTiido_metges_epigrafe_fk
	 */
	public void setTiido_metges_epigrafe_fk(entities.Tiido_epigrafeLocal value) {
		getTiido_metges_epigrafe_fkLink().setValue(value);
	}
	/**
	 * getTiido_metges_epigrafe_fkKey
	 */
	public entities.Tiido_epigrafeKey getTiido_metges_epigrafe_fkKey() {
		if (tiido_metges_epigrafe_fkLink == null) return dataCacheEntry.getTiido_metges_epigrafe_fkKey();
		return (entities.Tiido_epigrafeKey) tiido_metges_epigrafe_fkLink.getKey();
	}
	/**
	 * getTiido_metges_epigrafe_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_metges_epigrafe_fkLink() {
		if (tiido_metges_epigrafe_fkLink == null) 
		tiido_metges_epigrafe_fkLink = instanceExtension.createLink("tiido_metges_epigrafe_fk",dataCacheEntry.getTiido_metges_epigrafe_fkKey(),17);
		return tiido_metges_epigrafe_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_metges_epigrafe_fkLink;
	/**
	 * ejbFindTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(entities.Tiido_epigrafeKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_metges_epigrafe_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local");
		getInjector().findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local", record);
	}
	/**
	 * getTiido_metges_oficina_fk
	 */
	public entities.Tiido_oficinaLocal getTiido_metges_oficina_fk() {
		return (entities.Tiido_oficinaLocal)getTiido_metges_oficina_fkLink().getValue();
	}
	/**
	 * setTiido_metges_oficina_fk
	 */
	public void setTiido_metges_oficina_fk(entities.Tiido_oficinaLocal value) {
		getTiido_metges_oficina_fkLink().setValue(value);
	}
	/**
	 * getTiido_metges_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_metges_oficina_fkKey() {
		if (tiido_metges_oficina_fkLink == null) return dataCacheEntry.getTiido_metges_oficina_fkKey();
		return (entities.Tiido_oficinaKey) tiido_metges_oficina_fkLink.getKey();
	}
	/**
	 * getTiido_metges_oficina_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_metges_oficina_fkLink() {
		if (tiido_metges_oficina_fkLink == null) 
		tiido_metges_oficina_fkLink = instanceExtension.createLink("tiido_metges_oficina_fk",dataCacheEntry.getTiido_metges_oficina_fkKey(),18);
		return tiido_metges_oficina_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_metges_oficina_fkLink;
	/**
	 * ejbFindTiido_metas_gestorByTiido_metges_oficina_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_metges_oficina_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local");
		getInjector().findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiido_metges_epigrafe_fkLink != null) 
		dataCacheEntry.setTiido_metges_epigrafe_fkKey((entities.Tiido_epigrafeKey) tiido_metges_epigrafe_fkLink.getKey());
		if (tiido_metges_oficina_fkLink != null) 
		dataCacheEntry.setTiido_metges_oficina_fkKey((entities.Tiido_oficinaKey) tiido_metges_oficina_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_meta_gestor
	 */
	public java.lang.String getCod_meta_gestor() {
		return dataCacheEntry.getCod_meta_gestor();
	}
	/**
	 * Set accessor for persistent attribute: cod_meta_gestor
	 */
	public void setCod_meta_gestor(java.lang.String newCod_meta_gestor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_meta_gestor(),newCod_meta_gestor);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_meta_gestor(newCod_meta_gestor);
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
			instanceExtension.markDirty(1,getCod_gestor(),newCod_gestor);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCod_gestor(newCod_gestor);
	}
	/**
	 * Get accessor for persistent attribute: mes
	 */
	public java.lang.String getMes() {
		return dataCacheEntry.getMes();
	}
	/**
	 * Set accessor for persistent attribute: mes
	 */
	public void setMes(java.lang.String newMes) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getMes(),newMes);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setMes(newMes);
	}
	/**
	 * Get accessor for persistent attribute: orden
	 */
	public java.lang.String getOrden() {
		return dataCacheEntry.getOrden();
	}
	/**
	 * Set accessor for persistent attribute: orden
	 */
	public void setOrden(java.lang.String newOrden) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getOrden(),newOrden);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setOrden(newOrden);
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
			instanceExtension.markDirty(4,getFec_regi(),newFec_regi);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setFec_regi(newFec_regi);
	}
	/**
	 * Get accessor for persistent attribute: porc_asig
	 */
	public java.math.BigDecimal getPorc_asig() {
		return dataCacheEntry.getPorc_asig();
	}
	/**
	 * Set accessor for persistent attribute: porc_asig
	 */
	public void setPorc_asig(java.math.BigDecimal newPorc_asig) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getPorc_asig(),newPorc_asig);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setPorc_asig(newPorc_asig);
	}
	/**
	 * Get accessor for persistent attribute: nom_epigrafe
	 */
	public java.lang.String getNom_epigrafe() {
		return dataCacheEntry.getNom_epigrafe();
	}
	/**
	 * Set accessor for persistent attribute: nom_epigrafe
	 */
	public void setNom_epigrafe(java.lang.String newNom_epigrafe) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getNom_epigrafe(),newNom_epigrafe);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setNom_epigrafe(newNom_epigrafe);
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
			instanceExtension.markDirty(7,getNom_gestor(),newNom_gestor);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setNom_gestor(newNom_gestor);
	}
	/**
	 * Get accessor for persistent attribute: tiido_metges_epigrafe_fk_cod_epigrafe
	 */
	public java.lang.String getTiido_metges_epigrafe_fk_cod_epigrafe() {
		return dataCacheEntry.getTiido_metges_epigrafe_fk_cod_epigrafe();
	}
	/**
	 * Set accessor for persistent attribute: tiido_metges_epigrafe_fk_cod_epigrafe
	 */
	public void setTiido_metges_epigrafe_fk_cod_epigrafe(java.lang.String newTiido_metges_epigrafe_fk_cod_epigrafe) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getTiido_metges_epigrafe_fk_cod_epigrafe(),newTiido_metges_epigrafe_fk_cod_epigrafe);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setTiido_metges_epigrafe_fk_cod_epigrafe(newTiido_metges_epigrafe_fk_cod_epigrafe);
	}
	/**
	 * Get accessor for persistent attribute: tiido_metges_epigrafe_fk_anho
	 */
	public java.lang.String getTiido_metges_epigrafe_fk_anho() {
		return dataCacheEntry.getTiido_metges_epigrafe_fk_anho();
	}
	/**
	 * Set accessor for persistent attribute: tiido_metges_epigrafe_fk_anho
	 */
	public void setTiido_metges_epigrafe_fk_anho(java.lang.String newTiido_metges_epigrafe_fk_anho) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getTiido_metges_epigrafe_fk_anho(),newTiido_metges_epigrafe_fk_anho);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setTiido_metges_epigrafe_fk_anho(newTiido_metges_epigrafe_fk_anho);
	}
	/**
	 * Get accessor for persistent attribute: tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr() {
		return dataCacheEntry.getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr();
	}
	/**
	 * Set accessor for persistent attribute: tiido_metges_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr(java.lang.String newTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr(),newTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr(newTiido_metges_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * Get accessor for persistent attribute: tiido_metges_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_metges_oficina_fk_cod_ofic() {
		return dataCacheEntry.getTiido_metges_oficina_fk_cod_ofic();
	}
	/**
	 * Set accessor for persistent attribute: tiido_metges_oficina_fk_cod_ofic
	 */
	public void setTiido_metges_oficina_fk_cod_ofic(java.lang.String newTiido_metges_oficina_fk_cod_ofic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getTiido_metges_oficina_fk_cod_ofic(),newTiido_metges_oficina_fk_cod_ofic);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setTiido_metges_oficina_fk_cod_ofic(newTiido_metges_oficina_fk_cod_ofic);
	}
	/**
	 * Get accessor for persistent attribute: cod_perfil_gestor
	 */
	public java.lang.String getCod_perfil_gestor() {
		return dataCacheEntry.getCod_perfil_gestor();
	}
	/**
	 * Set accessor for persistent attribute: cod_perfil_gestor
	 */
	public void setCod_perfil_gestor(java.lang.String newCod_perfil_gestor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getCod_perfil_gestor(),newCod_perfil_gestor);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setCod_perfil_gestor(newCod_perfil_gestor);
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
			instanceExtension.markDirty(13,getEstado(),newEstado);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setEstado(newEstado);
	}
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public java.util.Date getFec_actu() {
		return dataCacheEntry.getFec_actu();
	}
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public void setFec_actu(java.util.Date newFec_actu) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getFec_actu(),newFec_actu);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setFec_actu(newFec_actu);
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
			instanceExtension.markDirty(15,getUsu_regi(),newUsu_regi);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setUsu_regi(newUsu_regi);
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
			instanceExtension.markDirty(16,getUsu_actu(),newUsu_actu);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setUsu_actu(newUsu_actu);
	}
}
