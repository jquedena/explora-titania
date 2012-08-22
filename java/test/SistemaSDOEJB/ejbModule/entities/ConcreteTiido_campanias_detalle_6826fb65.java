package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_campanias_detalleBeanCacheEntry_6826fb65;

/**
 * Bean implementation class for Enterprise Bean: Tiido_campanias_detalle
 */
public class ConcreteTiido_campanias_detalle_6826fb65 extends entities.Tiido_campanias_detalleBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiido_campanias_detalleBeanCacheEntry_6826fb65 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_campanias_detalle_6826fb65
	 */
	public ConcreteTiido_campanias_detalle_6826fb65() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_campanias_detalleBeanInjector_6826fb65 getInjector() {
		return (entities.websphere_deploy.Tiido_campanias_detalleBeanInjector_6826fb65)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_campanias_detalleBeanCacheEntry_6826fb65) inRecord;
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
			tiido_camdet_campanias_fkLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_campanias_detalleKey ejbFindByPrimaryKey(entities.Tiido_campanias_detalleKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_campanias_detalleKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_campanias_detalleKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_campanias_detalleKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_campanias_detalleKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_campanias_detalleKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_campanias_detalleKey ejbCreate(java.lang.Integer cod_camp_deta, entities.Tiido_campaniasLocal argTiido_camdet_campanias_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_campanias_detalleBeanCacheEntry_6826fb65) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_camp_deta, argTiido_camdet_campanias_fk);
		return (entities.Tiido_campanias_detalleKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer cod_camp_deta, entities.Tiido_campaniasLocal argTiido_camdet_campanias_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_camp_deta, argTiido_camdet_campanias_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_campanias_detalleKey ejbCreate(java.lang.Integer cod_camp_deta, java.lang.Integer tiido_camdet_campanias_fk_cod_camp, java.lang.String tiido_camdet_campanias_fk_anho, java.lang.String tiido_camdet_campanias_fk_mes, java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic, java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_campanias_detalleBeanCacheEntry_6826fb65) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_camp_deta, tiido_camdet_campanias_fk_cod_camp, tiido_camdet_campanias_fk_anho, tiido_camdet_campanias_fk_mes, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
		return (entities.Tiido_campanias_detalleKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer cod_camp_deta, java.lang.Integer tiido_camdet_campanias_fk_cod_camp, java.lang.String tiido_camdet_campanias_fk_anho, java.lang.String tiido_camdet_campanias_fk_mes, java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic, java.lang.String tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_camp_deta, tiido_camdet_campanias_fk_cod_camp, tiido_camdet_campanias_fk_anho, tiido_camdet_campanias_fk_mes, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic, tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_campanias_detalleKey pk = new entities.Tiido_campanias_detalleKey();
		pk.cod_camp_deta = getCod_camp_deta();
		pk.tiido_camdet_campanias_fk_cod_camp = getTiido_camdet_campanias_fk_cod_camp();
		pk.tiido_camdet_campanias_fk_anho = getTiido_camdet_campanias_fk_anho();
		pk.tiido_camdet_campanias_fk_mes = getTiido_camdet_campanias_fk_mes();
		pk.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic = getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic();
		pk.tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr = getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 23;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiido_camdet_campanias_fk")) return getTiido_camdet_campanias_fkLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_camdet_campanias_fk")){
			entities.websphere_deploy.Tiido_campaniasBeanInternalLocalHome_97b3883c home = (entities.websphere_deploy.Tiido_campaniasBeanInternalLocalHome_97b3883c)instanceExtension.getHomeForLink("tiido_camdet_campanias_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_campaniasKey)key);
		}
		return null;
	}
	/**
	 * getTiido_camdet_campanias_fk
	 */
	public entities.Tiido_campaniasLocal getTiido_camdet_campanias_fk() {
		return (entities.Tiido_campaniasLocal)getTiido_camdet_campanias_fkLink().getValue();
	}
	/**
	 * setTiido_camdet_campanias_fk
	 */
	public void setTiido_camdet_campanias_fk(entities.Tiido_campaniasLocal value) {
		getTiido_camdet_campanias_fkLink().setValue(value);
	}
	/**
	 * getTiido_camdet_campanias_fkKey
	 */
	public entities.Tiido_campaniasKey getTiido_camdet_campanias_fkKey() {
		if (tiido_camdet_campanias_fkLink == null) return dataCacheEntry.getTiido_camdet_campanias_fkKey();
		return (entities.Tiido_campaniasKey) tiido_camdet_campanias_fkLink.getKey();
	}
	/**
	 * getTiido_camdet_campanias_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_camdet_campanias_fkLink() {
		if (tiido_camdet_campanias_fkLink == null) 
		tiido_camdet_campanias_fkLink = instanceExtension.createLink("tiido_camdet_campanias_fk",dataCacheEntry.getTiido_camdet_campanias_fkKey(),22);
		return tiido_camdet_campanias_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_camdet_campanias_fkLink;
	/**
	 * ejbFindTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local(entities.Tiido_campaniasKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_camdet_campanias_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local");
		getInjector().findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiido_camdet_campanias_fkLink != null) 
		dataCacheEntry.setTiido_camdet_campanias_fkKey((entities.Tiido_campaniasKey) tiido_camdet_campanias_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_camp_deta
	 */
	public java.lang.Integer getCod_camp_deta() {
		return dataCacheEntry.getCod_camp_deta();
	}
	/**
	 * Set accessor for persistent attribute: cod_camp_deta
	 */
	public void setCod_camp_deta(java.lang.Integer newCod_camp_deta) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_camp_deta(),newCod_camp_deta);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_camp_deta(newCod_camp_deta);
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
			instanceExtension.markDirty(1,getNom_camp(),newNom_camp);
		else
			instanceExtension.markDirty(1);
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
			instanceExtension.markDirty(2,getCod_gest(),newCod_gest);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setCod_gest(newCod_gest);
	}
	/**
	 * Get accessor for persistent attribute: nro_clie
	 */
	public java.math.BigDecimal getNro_clie() {
		return dataCacheEntry.getNro_clie();
	}
	/**
	 * Set accessor for persistent attribute: nro_clie
	 */
	public void setNro_clie(java.math.BigDecimal newNro_clie) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getNro_clie(),newNro_clie);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setNro_clie(newNro_clie);
	}
	/**
	 * Get accessor for persistent attribute: comp_gest
	 */
	public java.math.BigDecimal getComp_gest() {
		return dataCacheEntry.getComp_gest();
	}
	/**
	 * Set accessor for persistent attribute: comp_gest
	 */
	public void setComp_gest(java.math.BigDecimal newComp_gest) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getComp_gest(),newComp_gest);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setComp_gest(newComp_gest);
	}
	/**
	 * Get accessor for persistent attribute: nro_gest_segu_1
	 */
	public java.math.BigDecimal getNro_gest_segu_1() {
		return dataCacheEntry.getNro_gest_segu_1();
	}
	/**
	 * Set accessor for persistent attribute: nro_gest_segu_1
	 */
	public void setNro_gest_segu_1(java.math.BigDecimal newNro_gest_segu_1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getNro_gest_segu_1(),newNro_gest_segu_1);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setNro_gest_segu_1(newNro_gest_segu_1);
	}
	/**
	 * Get accessor for persistent attribute: nro_conc_segu_1
	 */
	public java.math.BigDecimal getNro_conc_segu_1() {
		return dataCacheEntry.getNro_conc_segu_1();
	}
	/**
	 * Set accessor for persistent attribute: nro_conc_segu_1
	 */
	public void setNro_conc_segu_1(java.math.BigDecimal newNro_conc_segu_1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getNro_conc_segu_1(),newNro_conc_segu_1);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setNro_conc_segu_1(newNro_conc_segu_1);
	}
	/**
	 * Get accessor for persistent attribute: mont_segu_1
	 */
	public java.math.BigDecimal getMont_segu_1() {
		return dataCacheEntry.getMont_segu_1();
	}
	/**
	 * Set accessor for persistent attribute: mont_segu_1
	 */
	public void setMont_segu_1(java.math.BigDecimal newMont_segu_1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getMont_segu_1(),newMont_segu_1);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setMont_segu_1(newMont_segu_1);
	}
	/**
	 * Get accessor for persistent attribute: nro_gest_segu_2
	 */
	public java.math.BigDecimal getNro_gest_segu_2() {
		return dataCacheEntry.getNro_gest_segu_2();
	}
	/**
	 * Set accessor for persistent attribute: nro_gest_segu_2
	 */
	public void setNro_gest_segu_2(java.math.BigDecimal newNro_gest_segu_2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getNro_gest_segu_2(),newNro_gest_segu_2);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setNro_gest_segu_2(newNro_gest_segu_2);
	}
	/**
	 * Get accessor for persistent attribute: nro_conc_segu_2
	 */
	public java.math.BigDecimal getNro_conc_segu_2() {
		return dataCacheEntry.getNro_conc_segu_2();
	}
	/**
	 * Set accessor for persistent attribute: nro_conc_segu_2
	 */
	public void setNro_conc_segu_2(java.math.BigDecimal newNro_conc_segu_2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getNro_conc_segu_2(),newNro_conc_segu_2);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setNro_conc_segu_2(newNro_conc_segu_2);
	}
	/**
	 * Get accessor for persistent attribute: mont_segu_2
	 */
	public java.math.BigDecimal getMont_segu_2() {
		return dataCacheEntry.getMont_segu_2();
	}
	/**
	 * Set accessor for persistent attribute: mont_segu_2
	 */
	public void setMont_segu_2(java.math.BigDecimal newMont_segu_2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getMont_segu_2(),newMont_segu_2);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setMont_segu_2(newMont_segu_2);
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
			instanceExtension.markDirty(11,getFec_regi(),newFec_regi);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setFec_regi(newFec_regi);
	}
	/**
	 * Get accessor for persistent attribute: fec_segu_1
	 */
	public java.sql.Date getFec_segu_1() {
		return dataCacheEntry.getFec_segu_1();
	}
	/**
	 * Set accessor for persistent attribute: fec_segu_1
	 */
	public void setFec_segu_1(java.sql.Date newFec_segu_1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getFec_segu_1(),newFec_segu_1);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setFec_segu_1(newFec_segu_1);
	}
	/**
	 * Get accessor for persistent attribute: fec_segu_2
	 */
	public java.sql.Date getFec_segu_2() {
		return dataCacheEntry.getFec_segu_2();
	}
	/**
	 * Set accessor for persistent attribute: fec_segu_2
	 */
	public void setFec_segu_2(java.sql.Date newFec_segu_2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getFec_segu_2(),newFec_segu_2);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setFec_segu_2(newFec_segu_2);
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
			instanceExtension.markDirty(14,getUsu_regi(),newUsu_regi);
		else
			instanceExtension.markDirty(14);
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
			instanceExtension.markDirty(15,getFec_actu(),newFec_actu);
		else
			instanceExtension.markDirty(15);
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
			instanceExtension.markDirty(16,getUsu_actu(),newUsu_actu);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setUsu_actu(newUsu_actu);
	}
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr() {
		return dataCacheEntry.getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr();
	}
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(java.lang.String newTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(),newTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr(newTiido_camdet_campanias_fk_tiido_cam_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic() {
		return dataCacheEntry.getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic();
	}
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic
	 */
	public void setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic(java.lang.String newTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic(),newTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic(newTiido_camdet_campanias_fk_tiido_cam_oficina_fk_cod_ofic);
	}
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_cod_camp
	 */
	public java.lang.Integer getTiido_camdet_campanias_fk_cod_camp() {
		return dataCacheEntry.getTiido_camdet_campanias_fk_cod_camp();
	}
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_cod_camp
	 */
	public void setTiido_camdet_campanias_fk_cod_camp(java.lang.Integer newTiido_camdet_campanias_fk_cod_camp) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getTiido_camdet_campanias_fk_cod_camp(),newTiido_camdet_campanias_fk_cod_camp);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setTiido_camdet_campanias_fk_cod_camp(newTiido_camdet_campanias_fk_cod_camp);
	}
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_anho
	 */
	public java.lang.String getTiido_camdet_campanias_fk_anho() {
		return dataCacheEntry.getTiido_camdet_campanias_fk_anho();
	}
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_anho
	 */
	public void setTiido_camdet_campanias_fk_anho(java.lang.String newTiido_camdet_campanias_fk_anho) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getTiido_camdet_campanias_fk_anho(),newTiido_camdet_campanias_fk_anho);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setTiido_camdet_campanias_fk_anho(newTiido_camdet_campanias_fk_anho);
	}
	/**
	 * Get accessor for persistent attribute: tiido_camdet_campanias_fk_mes
	 */
	public java.lang.String getTiido_camdet_campanias_fk_mes() {
		return dataCacheEntry.getTiido_camdet_campanias_fk_mes();
	}
	/**
	 * Set accessor for persistent attribute: tiido_camdet_campanias_fk_mes
	 */
	public void setTiido_camdet_campanias_fk_mes(java.lang.String newTiido_camdet_campanias_fk_mes) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(21,getTiido_camdet_campanias_fk_mes(),newTiido_camdet_campanias_fk_mes);
		else
			instanceExtension.markDirty(21);
		dataCacheEntry.setTiido_camdet_campanias_fk_mes(newTiido_camdet_campanias_fk_mes);
	}
}
