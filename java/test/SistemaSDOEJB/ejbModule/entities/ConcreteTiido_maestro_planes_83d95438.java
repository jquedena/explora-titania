package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_maestro_planesBeanCacheEntry_83d95438;

/**
 * Bean implementation class for Enterprise Bean: Tiido_maestro_planes
 */
public class ConcreteTiido_maestro_planes_83d95438 extends entities.Tiido_maestro_planesBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiido_maestro_planesBeanCacheEntry_83d95438 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_maestro_planes_83d95438
	 */
	public ConcreteTiido_maestro_planes_83d95438() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_maestro_planesBeanInjector_83d95438 getInjector() {
		return (entities.websphere_deploy.Tiido_maestro_planesBeanInjector_83d95438)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_maestro_planesBeanCacheEntry_83d95438) inRecord;
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
			tiido_maepla_oficina_fkLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_maestro_planesKey ejbFindByPrimaryKey(entities.Tiido_maestro_planesKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_maestro_planesKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindUbicar_Local
	 */
	public entities.Tiido_maestro_planesKey ejbFindUbicar_Local(java.lang.String mes, java.lang.String anho, java.lang.String codOficina) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindUbicar");
		getInjector().ejbFindUbicar(mes, anho, codOficina, record);
		return (entities.Tiido_maestro_planesKey) instanceExtension.executeFind("FindUbicar", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_maestro_planesKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_maestro_planesKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_maestro_planesKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_maestro_planesKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_maestro_planesKey ejbCreate(java.lang.String mes, java.lang.String anho, entities.Tiido_oficinaLocal argTiido_maepla_oficina_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_maestro_planesBeanCacheEntry_83d95438) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(mes, anho, argTiido_maepla_oficina_fk);
		return (entities.Tiido_maestro_planesKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String mes, java.lang.String anho, entities.Tiido_oficinaLocal argTiido_maepla_oficina_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(mes, anho, argTiido_maepla_oficina_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_maestro_planesKey ejbCreate(java.lang.String mes, java.lang.String anho, java.lang.String tiido_maepla_oficina_fk_cod_ofic, java.lang.String tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_maestro_planesBeanCacheEntry_83d95438) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(mes, anho, tiido_maepla_oficina_fk_cod_ofic, tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
		return (entities.Tiido_maestro_planesKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String mes, java.lang.String anho, java.lang.String tiido_maepla_oficina_fk_cod_ofic, java.lang.String tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(mes, anho, tiido_maepla_oficina_fk_cod_ofic, tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_maestro_planesKey pk = new entities.Tiido_maestro_planesKey();
		pk.mes = getMes();
		pk.anho = getAnho();
		pk.tiido_maepla_oficina_fk_cod_ofic = getTiido_maepla_oficina_fk_cod_ofic();
		pk.tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr = getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 7;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiido_maepla_oficina_fk")) return getTiido_maepla_oficina_fkLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_maepla_oficina_fk")){
			entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8 home = (entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8)instanceExtension.getHomeForLink("tiido_maepla_oficina_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_oficinaKey)key);
		}
		return null;
	}
	/**
	 * getTiido_maepla_oficina_fk
	 */
	public entities.Tiido_oficinaLocal getTiido_maepla_oficina_fk() {
		return (entities.Tiido_oficinaLocal)getTiido_maepla_oficina_fkLink().getValue();
	}
	/**
	 * setTiido_maepla_oficina_fk
	 */
	public void setTiido_maepla_oficina_fk(entities.Tiido_oficinaLocal value) {
		getTiido_maepla_oficina_fkLink().setValue(value);
	}
	/**
	 * getTiido_maepla_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_maepla_oficina_fkKey() {
		if (tiido_maepla_oficina_fkLink == null) return dataCacheEntry.getTiido_maepla_oficina_fkKey();
		return (entities.Tiido_oficinaKey) tiido_maepla_oficina_fkLink.getKey();
	}
	/**
	 * getTiido_maepla_oficina_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_maepla_oficina_fkLink() {
		if (tiido_maepla_oficina_fkLink == null) 
		tiido_maepla_oficina_fkLink = instanceExtension.createLink("tiido_maepla_oficina_fk",dataCacheEntry.getTiido_maepla_oficina_fkKey(),6);
		return tiido_maepla_oficina_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_maepla_oficina_fkLink;
	/**
	 * ejbFindTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_maepla_oficina_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local");
		getInjector().findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_maestro_planesByTiido_maepla_oficina_fkKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiido_maepla_oficina_fkLink != null) 
		dataCacheEntry.setTiido_maepla_oficina_fkKey((entities.Tiido_oficinaKey) tiido_maepla_oficina_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
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
			instanceExtension.markDirty(0,getMes(),newMes);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setMes(newMes);
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
	 * Get accessor for persistent attribute: prioridad
	 */
	public java.math.BigDecimal getPrioridad() {
		return dataCacheEntry.getPrioridad();
	}
	/**
	 * Set accessor for persistent attribute: prioridad
	 */
	public void setPrioridad(java.math.BigDecimal newPrioridad) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getPrioridad(),newPrioridad);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setPrioridad(newPrioridad);
	}
	/**
	 * Get accessor for persistent attribute: fec_grab
	 */
	public java.sql.Date getFec_grab() {
		return dataCacheEntry.getFec_grab();
	}
	/**
	 * Set accessor for persistent attribute: fec_grab
	 */
	public void setFec_grab(java.sql.Date newFec_grab) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getFec_grab(),newFec_grab);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setFec_grab(newFec_grab);
	}
	/**
	 * Get accessor for persistent attribute: tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr() {
		return dataCacheEntry.getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr();
	}
	/**
	 * Set accessor for persistent attribute: tiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr(java.lang.String newTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr(),newTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr(newTiido_maepla_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * Get accessor for persistent attribute: tiido_maepla_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_maepla_oficina_fk_cod_ofic() {
		return dataCacheEntry.getTiido_maepla_oficina_fk_cod_ofic();
	}
	/**
	 * Set accessor for persistent attribute: tiido_maepla_oficina_fk_cod_ofic
	 */
	public void setTiido_maepla_oficina_fk_cod_ofic(java.lang.String newTiido_maepla_oficina_fk_cod_ofic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getTiido_maepla_oficina_fk_cod_ofic(),newTiido_maepla_oficina_fk_cod_ofic);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setTiido_maepla_oficina_fk_cod_ofic(newTiido_maepla_oficina_fk_cod_ofic);
	}
}
