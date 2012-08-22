package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_campaniasBeanCacheEntry_97b3883c;

/**
 * Bean implementation class for Enterprise Bean: Tiido_campanias
 */
public class ConcreteTiido_campanias_97b3883c extends entities.Tiido_campaniasBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiido_campaniasBeanCacheEntry_97b3883c dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_campanias_97b3883c
	 */
	public ConcreteTiido_campanias_97b3883c() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_campaniasBeanInjector_97b3883c getInjector() {
		return (entities.websphere_deploy.Tiido_campaniasBeanInjector_97b3883c)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_campaniasBeanCacheEntry_97b3883c) inRecord;
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
			tiido_cam_oficina_fkLink = null;
			tiido_campanias_detalleLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_campaniasKey ejbFindByPrimaryKey(entities.Tiido_campaniasKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_campaniasKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_campaniasKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_campaniasKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_campaniasKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_campaniasKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_campaniasKey ejbCreate(java.lang.Integer cod_camp, java.lang.String anho, java.lang.String mes, entities.Tiido_oficinaLocal argTiido_cam_oficina_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_campaniasBeanCacheEntry_97b3883c) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_camp, anho, mes, argTiido_cam_oficina_fk);
		return (entities.Tiido_campaniasKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer cod_camp, java.lang.String anho, java.lang.String mes, entities.Tiido_oficinaLocal argTiido_cam_oficina_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_camp, anho, mes, argTiido_cam_oficina_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_campaniasKey ejbCreate(java.lang.Integer cod_camp, java.lang.String anho, java.lang.String mes, java.lang.String tiido_cam_oficina_fk_cod_ofic, java.lang.String tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_campaniasBeanCacheEntry_97b3883c) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_camp, anho, mes, tiido_cam_oficina_fk_cod_ofic, tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
		return (entities.Tiido_campaniasKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer cod_camp, java.lang.String anho, java.lang.String mes, java.lang.String tiido_cam_oficina_fk_cod_ofic, java.lang.String tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_camp, anho, mes, tiido_cam_oficina_fk_cod_ofic, tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_campaniasKey pk = new entities.Tiido_campaniasKey();
		pk.cod_camp = getCod_camp();
		pk.anho = getAnho();
		pk.mes = getMes();
		pk.tiido_cam_oficina_fk_cod_ofic = getTiido_cam_oficina_fk_cod_ofic();
		pk.tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr = getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr();
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
		if (name.equals("tiido_cam_oficina_fk")) return getTiido_cam_oficina_fkLink();
		if (name.equals("tiido_campanias_detalle")) return getTiido_campanias_detalleLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_cam_oficina_fk")){
			entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8 home = (entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8)instanceExtension.getHomeForLink("tiido_cam_oficina_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_oficinaKey)key);
		}
		if (name.equals("tiido_campanias_detalle")){
			entities.websphere_deploy.Tiido_campanias_detalleBeanInternalLocalHome_6826fb65 home = (entities.websphere_deploy.Tiido_campanias_detalleBeanInternalLocalHome_6826fb65)instanceExtension.getHomeForLink("tiido_campanias_detalle");
		  return home.findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local((entities.Tiido_campaniasKey)key);
		}
		return null;
	}
	/**
	 * getTiido_cam_oficina_fk
	 */
	public entities.Tiido_oficinaLocal getTiido_cam_oficina_fk() {
		return (entities.Tiido_oficinaLocal)getTiido_cam_oficina_fkLink().getValue();
	}
	/**
	 * setTiido_cam_oficina_fk
	 */
	public void setTiido_cam_oficina_fk(entities.Tiido_oficinaLocal value) {
		getTiido_cam_oficina_fkLink().setValue(value);
	}
	/**
	 * getTiido_cam_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_cam_oficina_fkKey() {
		if (tiido_cam_oficina_fkLink == null) return dataCacheEntry.getTiido_cam_oficina_fkKey();
		return (entities.Tiido_oficinaKey) tiido_cam_oficina_fkLink.getKey();
	}
	/**
	 * getTiido_cam_oficina_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_cam_oficina_fkLink() {
		if (tiido_cam_oficina_fkLink == null) 
		tiido_cam_oficina_fkLink = instanceExtension.createLink("tiido_cam_oficina_fk",dataCacheEntry.getTiido_cam_oficina_fkKey(),13);
		return tiido_cam_oficina_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_cam_oficina_fkLink;
	/**
	 * ejbFindTiido_campaniasByTiido_cam_oficina_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_campaniasByTiido_cam_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_cam_oficina_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_campaniasByTiido_cam_oficina_fkKey_Local");
		getInjector().findTiido_campaniasByTiido_cam_oficina_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_campaniasByTiido_cam_oficina_fkKey_Local", record);
	}
	/**
	 * getTiido_campanias_detalle
	 */
	public java.util.Collection getTiido_campanias_detalle() {
		return (java.util.Collection)getTiido_campanias_detalleLink().getValue();
	}
	/**
	 * setTiido_campanias_detalle
	 */
	public void setTiido_campanias_detalle(java.util.Collection value) {
		getTiido_campanias_detalleLink().setValue(value);
	}
	/**
	 * getTiido_campanias_detalleLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_campanias_detalleLink() {
		if (tiido_campanias_detalleLink == null) 
		tiido_campanias_detalleLink = instanceExtension.createLink("tiido_campanias_detalle",null,14);
		return tiido_campanias_detalleLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_campanias_detalleLink;
	/**
	 * ejbFindTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local
	 */
	public entities.Tiido_campaniasKey ejbFindTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local(entities.Tiido_campanias_detalleKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_campanias_detalle",key);
		if (result!=null )  return (entities.Tiido_campaniasKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local");
		getInjector().findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local(key, record);
		return (entities.Tiido_campaniasKey) instanceExtension.executeFind("findTiido_camdet_campanias_fkByTiido_campanias_detalleKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiido_cam_oficina_fkLink != null) 
		dataCacheEntry.setTiido_cam_oficina_fkKey((entities.Tiido_oficinaKey) tiido_cam_oficina_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_camp
	 */
	public java.lang.Integer getCod_camp() {
		return dataCacheEntry.getCod_camp();
	}
	/**
	 * Set accessor for persistent attribute: cod_camp
	 */
	public void setCod_camp(java.lang.Integer newCod_camp) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_camp(),newCod_camp);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_camp(newCod_camp);
	}
	/**
	 * Get accessor for persistent attribute: anho
	 */
	public java.lang.String getAnho() {
		return dataCacheEntry.getAnho();
	}
	/**
	 * Set accessor for persistent attribute: anho
	 */
	public void setAnho(java.lang.String newAnho) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getAnho(),newAnho);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setAnho(newAnho);
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
	 * Get accessor for persistent attribute: nom_camp
	 */
	public java.lang.String getNom_camp() {
		return dataCacheEntry.getNom_camp();
	}
	/**
	 * Set accessor for persistent attribute: nom_camp
	 */
	public void setNom_camp(java.lang.String newNom_camp) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getNom_camp(),newNom_camp);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setNom_camp(newNom_camp);
	}
	/**
	 * Get accessor for persistent attribute: cod_gest
	 */
	public java.lang.String getCod_gest() {
		return dataCacheEntry.getCod_gest();
	}
	/**
	 * Set accessor for persistent attribute: cod_gest
	 */
	public void setCod_gest(java.lang.String newCod_gest) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getCod_gest(),newCod_gest);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setCod_gest(newCod_gest);
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
			instanceExtension.markDirty(5,getOrden(),newOrden);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setOrden(newOrden);
	}
	/**
	 * Get accessor for persistent attribute: gte
	 */
	public java.lang.String getGte() {
		return dataCacheEntry.getGte();
	}
	/**
	 * Set accessor for persistent attribute: gte
	 */
	public void setGte(java.lang.String newGte) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getGte(),newGte);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setGte(newGte);
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
			instanceExtension.markDirty(7,getFec_regi(),newFec_regi);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setFec_regi(newFec_regi);
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
			instanceExtension.markDirty(8,getUsu_regi(),newUsu_regi);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setUsu_regi(newUsu_regi);
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
			instanceExtension.markDirty(9,getFec_actu(),newFec_actu);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setFec_actu(newFec_actu);
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
			instanceExtension.markDirty(10,getUsu_actu(),newUsu_actu);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setUsu_actu(newUsu_actu);
	}
	/**
	 * Get accessor for persistent attribute: tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr() {
		return dataCacheEntry.getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr();
	}
	/**
	 * Set accessor for persistent attribute: tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(java.lang.String newTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(),newTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(newTiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * Get accessor for persistent attribute: tiido_cam_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_cam_oficina_fk_cod_ofic() {
		return dataCacheEntry.getTiido_cam_oficina_fk_cod_ofic();
	}
	/**
	 * Set accessor for persistent attribute: tiido_cam_oficina_fk_cod_ofic
	 */
	public void setTiido_cam_oficina_fk_cod_ofic(java.lang.String newTiido_cam_oficina_fk_cod_ofic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getTiido_cam_oficina_fk_cod_ofic(),newTiido_cam_oficina_fk_cod_ofic);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setTiido_cam_oficina_fk_cod_ofic(newTiido_cam_oficina_fk_cod_ofic);
	}
}
