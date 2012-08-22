package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_accionesBeanCacheEntry_f77de715;

/**
 * Bean implementation class for Enterprise Bean: Tiido_acciones
 */
public class ConcreteTiido_acciones_f77de715 extends entities.Tiido_accionesBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiido_accionesBeanCacheEntry_f77de715 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_acciones_f77de715
	 */
	public ConcreteTiido_acciones_f77de715() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_accionesBeanInjector_f77de715 getInjector() {
		return (entities.websphere_deploy.Tiido_accionesBeanInjector_f77de715)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_accionesBeanCacheEntry_f77de715) inRecord;
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
			tiido_acc_epigrafe_fkLink = null;
			tiido_acc_oficina_fkLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_accionesKey ejbFindByPrimaryKey(entities.Tiido_accionesKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_accionesKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_accionesKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_accionesKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_accionesKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_accionesKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_accionesKey ejbCreate(java.lang.Integer cod_acci, entities.Tiido_epigrafeLocal argTiido_acc_epigrafe_fk, entities.Tiido_oficinaLocal argTiido_acc_oficina_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_accionesBeanCacheEntry_f77de715) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_acci, argTiido_acc_epigrafe_fk, argTiido_acc_oficina_fk);
		return (entities.Tiido_accionesKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer cod_acci, entities.Tiido_epigrafeLocal argTiido_acc_epigrafe_fk, entities.Tiido_oficinaLocal argTiido_acc_oficina_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_acci, argTiido_acc_epigrafe_fk, argTiido_acc_oficina_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_accionesKey ejbCreate(java.lang.Integer cod_acci, java.lang.String tiido_acc_epigrafe_fk_cod_epigrafe, java.lang.String tiido_acc_epigrafe_fk_anho, java.lang.String tiido_acc_oficina_fk_cod_ofic, java.lang.String tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_accionesBeanCacheEntry_f77de715) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_acci, tiido_acc_epigrafe_fk_cod_epigrafe, tiido_acc_epigrafe_fk_anho, tiido_acc_oficina_fk_cod_ofic, tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
		return (entities.Tiido_accionesKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer cod_acci, java.lang.String tiido_acc_epigrafe_fk_cod_epigrafe, java.lang.String tiido_acc_epigrafe_fk_anho, java.lang.String tiido_acc_oficina_fk_cod_ofic, java.lang.String tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_acci, tiido_acc_epigrafe_fk_cod_epigrafe, tiido_acc_epigrafe_fk_anho, tiido_acc_oficina_fk_cod_ofic, tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_accionesKey pk = new entities.Tiido_accionesKey();
		pk.cod_acci = getCod_acci();
		pk.tiido_acc_epigrafe_fk_cod_epigrafe = getTiido_acc_epigrafe_fk_cod_epigrafe();
		pk.tiido_acc_epigrafe_fk_anho = getTiido_acc_epigrafe_fk_anho();
		pk.tiido_acc_oficina_fk_cod_ofic = getTiido_acc_oficina_fk_cod_ofic();
		pk.tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr = getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 24;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiido_acc_epigrafe_fk")) return getTiido_acc_epigrafe_fkLink();
		if (name.equals("tiido_acc_oficina_fk")) return getTiido_acc_oficina_fkLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_acc_epigrafe_fk")){
			entities.websphere_deploy.Tiido_epigrafeBeanInternalLocalHome_b2c8f8ed home = (entities.websphere_deploy.Tiido_epigrafeBeanInternalLocalHome_b2c8f8ed)instanceExtension.getHomeForLink("tiido_acc_epigrafe_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_epigrafeKey)key);
		}
		if (name.equals("tiido_acc_oficina_fk")){
			entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8 home = (entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8)instanceExtension.getHomeForLink("tiido_acc_oficina_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_oficinaKey)key);
		}
		return null;
	}
	/**
	 * getTiido_acc_epigrafe_fk
	 */
	public entities.Tiido_epigrafeLocal getTiido_acc_epigrafe_fk() {
		return (entities.Tiido_epigrafeLocal)getTiido_acc_epigrafe_fkLink().getValue();
	}
	/**
	 * setTiido_acc_epigrafe_fk
	 */
	public void setTiido_acc_epigrafe_fk(entities.Tiido_epigrafeLocal value) {
		getTiido_acc_epigrafe_fkLink().setValue(value);
	}
	/**
	 * getTiido_acc_epigrafe_fkKey
	 */
	public entities.Tiido_epigrafeKey getTiido_acc_epigrafe_fkKey() {
		if (tiido_acc_epigrafe_fkLink == null) return dataCacheEntry.getTiido_acc_epigrafe_fkKey();
		return (entities.Tiido_epigrafeKey) tiido_acc_epigrafe_fkLink.getKey();
	}
	/**
	 * getTiido_acc_epigrafe_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_acc_epigrafe_fkLink() {
		if (tiido_acc_epigrafe_fkLink == null) 
		tiido_acc_epigrafe_fkLink = instanceExtension.createLink("tiido_acc_epigrafe_fk",dataCacheEntry.getTiido_acc_epigrafe_fkKey(),22);
		return tiido_acc_epigrafe_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_acc_epigrafe_fkLink;
	/**
	 * ejbFindTiido_accionesByTiido_acc_epigrafe_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_accionesByTiido_acc_epigrafe_fkKey_Local(entities.Tiido_epigrafeKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_acc_epigrafe_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_accionesByTiido_acc_epigrafe_fkKey_Local");
		getInjector().findTiido_accionesByTiido_acc_epigrafe_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_accionesByTiido_acc_epigrafe_fkKey_Local", record);
	}
	/**
	 * getTiido_acc_oficina_fk
	 */
	public entities.Tiido_oficinaLocal getTiido_acc_oficina_fk() {
		return (entities.Tiido_oficinaLocal)getTiido_acc_oficina_fkLink().getValue();
	}
	/**
	 * setTiido_acc_oficina_fk
	 */
	public void setTiido_acc_oficina_fk(entities.Tiido_oficinaLocal value) {
		getTiido_acc_oficina_fkLink().setValue(value);
	}
	/**
	 * getTiido_acc_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_acc_oficina_fkKey() {
		if (tiido_acc_oficina_fkLink == null) return dataCacheEntry.getTiido_acc_oficina_fkKey();
		return (entities.Tiido_oficinaKey) tiido_acc_oficina_fkLink.getKey();
	}
	/**
	 * getTiido_acc_oficina_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_acc_oficina_fkLink() {
		if (tiido_acc_oficina_fkLink == null) 
		tiido_acc_oficina_fkLink = instanceExtension.createLink("tiido_acc_oficina_fk",dataCacheEntry.getTiido_acc_oficina_fkKey(),23);
		return tiido_acc_oficina_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_acc_oficina_fkLink;
	/**
	 * ejbFindTiido_accionesByTiido_acc_oficina_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_accionesByTiido_acc_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_acc_oficina_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_accionesByTiido_acc_oficina_fkKey_Local");
		getInjector().findTiido_accionesByTiido_acc_oficina_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_accionesByTiido_acc_oficina_fkKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiido_acc_epigrafe_fkLink != null) 
		dataCacheEntry.setTiido_acc_epigrafe_fkKey((entities.Tiido_epigrafeKey) tiido_acc_epigrafe_fkLink.getKey());
		if (tiido_acc_oficina_fkLink != null) 
		dataCacheEntry.setTiido_acc_oficina_fkKey((entities.Tiido_oficinaKey) tiido_acc_oficina_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_acci
	 */
	public java.lang.Integer getCod_acci() {
		return dataCacheEntry.getCod_acci();
	}
	/**
	 * Set accessor for persistent attribute: cod_acci
	 */
	public void setCod_acci(java.lang.Integer newCod_acci) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_acci(),newCod_acci);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_acci(newCod_acci);
	}
	/**
	 * Get accessor for persistent attribute: nom_acci
	 */
	public java.lang.String getNom_acci() {
		return dataCacheEntry.getNom_acci();
	}
	/**
	 * Set accessor for persistent attribute: nom_acci
	 */
	public void setNom_acci(java.lang.String newNom_acci) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getNom_acci(),newNom_acci);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setNom_acci(newNom_acci);
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
	 * Get accessor for persistent attribute: mes_acci
	 */
	public java.lang.String getMes_acci() {
		return dataCacheEntry.getMes_acci();
	}
	/**
	 * Set accessor for persistent attribute: mes_acci
	 */
	public void setMes_acci(java.lang.String newMes_acci) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getMes_acci(),newMes_acci);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setMes_acci(newMes_acci);
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
			instanceExtension.markDirty(4,getNro_clie(),newNro_clie);
		else
			instanceExtension.markDirty(4);
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
			instanceExtension.markDirty(5,getComp_gest(),newComp_gest);
		else
			instanceExtension.markDirty(5);
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
			instanceExtension.markDirty(6,getNro_gest_segu_1(),newNro_gest_segu_1);
		else
			instanceExtension.markDirty(6);
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
			instanceExtension.markDirty(7,getNro_conc_segu_1(),newNro_conc_segu_1);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setNro_conc_segu_1(newNro_conc_segu_1);
	}
	/**
	 * Get accessor for persistent attribute: mon_segu_1
	 */
	public java.math.BigDecimal getMon_segu_1() {
		return dataCacheEntry.getMon_segu_1();
	}
	/**
	 * Set accessor for persistent attribute: mon_segu_1
	 */
	public void setMon_segu_1(java.math.BigDecimal newMon_segu_1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getMon_segu_1(),newMon_segu_1);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setMon_segu_1(newMon_segu_1);
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
			instanceExtension.markDirty(9,getNro_gest_segu_2(),newNro_gest_segu_2);
		else
			instanceExtension.markDirty(9);
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
			instanceExtension.markDirty(10,getNro_conc_segu_2(),newNro_conc_segu_2);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setNro_conc_segu_2(newNro_conc_segu_2);
	}
	/**
	 * Get accessor for persistent attribute: mon_segu_2
	 */
	public java.math.BigDecimal getMon_segu_2() {
		return dataCacheEntry.getMon_segu_2();
	}
	/**
	 * Set accessor for persistent attribute: mon_segu_2
	 */
	public void setMon_segu_2(java.math.BigDecimal newMon_segu_2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getMon_segu_2(),newMon_segu_2);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setMon_segu_2(newMon_segu_2);
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
			instanceExtension.markDirty(15,getUsu_actu(),newUsu_actu);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setUsu_actu(newUsu_actu);
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
			instanceExtension.markDirty(16,getFec_regi(),newFec_regi);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setFec_regi(newFec_regi);
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
			instanceExtension.markDirty(17,getFec_actu(),newFec_actu);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setFec_actu(newFec_actu);
	}
	/**
	 * Get accessor for persistent attribute: tiido_acc_epigrafe_fk_cod_epigrafe
	 */
	public java.lang.String getTiido_acc_epigrafe_fk_cod_epigrafe() {
		return dataCacheEntry.getTiido_acc_epigrafe_fk_cod_epigrafe();
	}
	/**
	 * Set accessor for persistent attribute: tiido_acc_epigrafe_fk_cod_epigrafe
	 */
	public void setTiido_acc_epigrafe_fk_cod_epigrafe(java.lang.String newTiido_acc_epigrafe_fk_cod_epigrafe) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getTiido_acc_epigrafe_fk_cod_epigrafe(),newTiido_acc_epigrafe_fk_cod_epigrafe);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setTiido_acc_epigrafe_fk_cod_epigrafe(newTiido_acc_epigrafe_fk_cod_epigrafe);
	}
	/**
	 * Get accessor for persistent attribute: tiido_acc_epigrafe_fk_anho
	 */
	public java.lang.String getTiido_acc_epigrafe_fk_anho() {
		return dataCacheEntry.getTiido_acc_epigrafe_fk_anho();
	}
	/**
	 * Set accessor for persistent attribute: tiido_acc_epigrafe_fk_anho
	 */
	public void setTiido_acc_epigrafe_fk_anho(java.lang.String newTiido_acc_epigrafe_fk_anho) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getTiido_acc_epigrafe_fk_anho(),newTiido_acc_epigrafe_fk_anho);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setTiido_acc_epigrafe_fk_anho(newTiido_acc_epigrafe_fk_anho);
	}
	/**
	 * Get accessor for persistent attribute: tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr() {
		return dataCacheEntry.getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr();
	}
	/**
	 * Set accessor for persistent attribute: tiido_acc_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr(java.lang.String newTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr(),newTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr(newTiido_acc_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * Get accessor for persistent attribute: tiido_acc_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_acc_oficina_fk_cod_ofic() {
		return dataCacheEntry.getTiido_acc_oficina_fk_cod_ofic();
	}
	/**
	 * Set accessor for persistent attribute: tiido_acc_oficina_fk_cod_ofic
	 */
	public void setTiido_acc_oficina_fk_cod_ofic(java.lang.String newTiido_acc_oficina_fk_cod_ofic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(21,getTiido_acc_oficina_fk_cod_ofic(),newTiido_acc_oficina_fk_cod_ofic);
		else
			instanceExtension.markDirty(21);
		dataCacheEntry.setTiido_acc_oficina_fk_cod_ofic(newTiido_acc_oficina_fk_cod_ofic);
	}
}
