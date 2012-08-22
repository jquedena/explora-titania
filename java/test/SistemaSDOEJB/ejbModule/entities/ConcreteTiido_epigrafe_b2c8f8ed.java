package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_epigrafeBeanCacheEntry_b2c8f8ed;

/**
 * Bean implementation class for Enterprise Bean: Tiido_epigrafe
 */
public class ConcreteTiido_epigrafe_b2c8f8ed extends entities.Tiido_epigrafeBean implements javax.ejb.EntityBean, ConcreteBeanWithLink {
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
	private Tiido_epigrafeBeanCacheEntry_b2c8f8ed dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_epigrafe_b2c8f8ed
	 */
	public ConcreteTiido_epigrafe_b2c8f8ed() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_epigrafeBeanInjector_b2c8f8ed getInjector() {
		return (entities.websphere_deploy.Tiido_epigrafeBeanInjector_b2c8f8ed)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_epigrafeBeanCacheEntry_b2c8f8ed) inRecord;
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
			tiido_accionesLink = null;
			tiido_metas_gestorLink = null;
	}
	/**
	 * ejbFindByCodEpig_Local
	 */
	public entities.Tiido_epigrafeKey ejbFindByCodEpig_Local(java.lang.String codEpigrafe) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCodEpig");
		getInjector().ejbFindByCodEpig(codEpigrafe, record);
		return (entities.Tiido_epigrafeKey) instanceExtension.executeFind("FindByCodEpig", record);
	}
	/**
	 * ejbFindByCodEpigAnho_Local
	 */
	public entities.Tiido_epigrafeKey ejbFindByCodEpigAnho_Local(java.lang.String codEpigrafe, java.lang.String anho) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCodEpigAnho");
		getInjector().ejbFindByCodEpigAnho(codEpigrafe, anho, record);
		return (entities.Tiido_epigrafeKey) instanceExtension.executeFind("FindByCodEpigAnho", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_epigrafeKey ejbFindByPrimaryKey(entities.Tiido_epigrafeKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_epigrafeKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindEpiByAnho_Local
	 */
	public java.util.Collection ejbFindEpiByAnho_Local(java.lang.String anho) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindEpiByAnho");
		getInjector().ejbFindEpiByAnho(anho, record);
		return (java.util.Collection) instanceExtension.executeFind("FindEpiByAnho", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_epigrafeKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_epigrafeKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_epigrafeKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_epigrafeKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_epigrafeKey ejbCreate(com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe epigrafe) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_epigrafeBeanCacheEntry_b2c8f8ed) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(epigrafe);
		return (entities.Tiido_epigrafeKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe epigrafe) throws javax.ejb.CreateException {
		super.ejbPostCreate(epigrafe);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_epigrafeKey ejbCreate(java.lang.String cod_epigrafe, java.lang.String anho) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_epigrafeBeanCacheEntry_b2c8f8ed) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_epigrafe, anho);
		return (entities.Tiido_epigrafeKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_epigrafe, java.lang.String anho) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_epigrafe, anho);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_epigrafeKey pk = new entities.Tiido_epigrafeKey();
		pk.cod_epigrafe = getCod_epigrafe();
		pk.anho = getAnho();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 14;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiido_acciones")) return getTiido_accionesLink();
		if (name.equals("tiido_metas_gestor")) return getTiido_metas_gestorLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_acciones")){
			entities.websphere_deploy.Tiido_accionesBeanInternalLocalHome_f77de715 home = (entities.websphere_deploy.Tiido_accionesBeanInternalLocalHome_f77de715)instanceExtension.getHomeForLink("tiido_acciones");
		  return home.findTiido_accionesByTiido_acc_epigrafe_fkKey_Local((entities.Tiido_epigrafeKey)key);
		}
		if (name.equals("tiido_metas_gestor")){
			entities.websphere_deploy.Tiido_metas_gestorBeanInternalLocalHome_238e66e0 home = (entities.websphere_deploy.Tiido_metas_gestorBeanInternalLocalHome_238e66e0)instanceExtension.getHomeForLink("tiido_metas_gestor");
		  return home.findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local((entities.Tiido_epigrafeKey)key);
		}
		return null;
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
		tiido_accionesLink = instanceExtension.createLink("tiido_acciones",null,12);
		return tiido_accionesLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_accionesLink;
	/**
	 * ejbFindTiido_acc_epigrafe_fkByTiido_accionesKey_Local
	 */
	public entities.Tiido_epigrafeKey ejbFindTiido_acc_epigrafe_fkByTiido_accionesKey_Local(entities.Tiido_accionesKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_acciones",key);
		if (result!=null )  return (entities.Tiido_epigrafeKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_acc_epigrafe_fkByTiido_accionesKey_Local");
		getInjector().findTiido_acc_epigrafe_fkByTiido_accionesKey_Local(key, record);
		return (entities.Tiido_epigrafeKey) instanceExtension.executeFind("findTiido_acc_epigrafe_fkByTiido_accionesKey_Local", record);
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
	 * ejbFindTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local
	 */
	public entities.Tiido_epigrafeKey ejbFindTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local(entities.Tiido_metas_gestorKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_metas_gestor",key);
		if (result!=null )  return (entities.Tiido_epigrafeKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local");
		getInjector().findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local(key, record);
		return (entities.Tiido_epigrafeKey) instanceExtension.executeFind("findTiido_metges_epigrafe_fkByTiido_metas_gestorKey_Local", record);
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_epigrafe
	 */
	public java.lang.String getCod_epigrafe() {
		return dataCacheEntry.getCod_epigrafe();
	}
	/**
	 * Set accessor for persistent attribute: cod_epigrafe
	 */
	public void setCod_epigrafe(java.lang.String newCod_epigrafe) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_epigrafe(),newCod_epigrafe);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_epigrafe(newCod_epigrafe);
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
			instanceExtension.markDirty(2,getNom_epigrafe(),newNom_epigrafe);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setNom_epigrafe(newNom_epigrafe);
	}
	/**
	 * Get accessor for persistent attribute: ind_clase
	 */
	public java.lang.String getInd_clase() {
		return dataCacheEntry.getInd_clase();
	}
	/**
	 * Set accessor for persistent attribute: ind_clase
	 */
	public void setInd_clase(java.lang.String newInd_clase) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getInd_clase(),newInd_clase);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setInd_clase(newInd_clase);
	}
	/**
	 * Get accessor for persistent attribute: ind_sub_clase
	 */
	public java.lang.String getInd_sub_clase() {
		return dataCacheEntry.getInd_sub_clase();
	}
	/**
	 * Set accessor for persistent attribute: ind_sub_clase
	 */
	public void setInd_sub_clase(java.lang.String newInd_sub_clase) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getInd_sub_clase(),newInd_sub_clase);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setInd_sub_clase(newInd_sub_clase);
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
	 * Get accessor for persistent attribute: ind_grupo
	 */
	public java.lang.String getInd_grupo() {
		return dataCacheEntry.getInd_grupo();
	}
	/**
	 * Set accessor for persistent attribute: ind_grupo
	 */
	public void setInd_grupo(java.lang.String newInd_grupo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getInd_grupo(),newInd_grupo);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setInd_grupo(newInd_grupo);
	}
	/**
	 * Get accessor for persistent attribute: abreviatura
	 */
	public java.lang.String getAbreviatura() {
		return dataCacheEntry.getAbreviatura();
	}
	/**
	 * Set accessor for persistent attribute: abreviatura
	 */
	public void setAbreviatura(java.lang.String newAbreviatura) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getAbreviatura(),newAbreviatura);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setAbreviatura(newAbreviatura);
	}
	/**
	 * Get accessor for persistent attribute: ind_hijo
	 */
	public java.lang.String getInd_hijo() {
		return dataCacheEntry.getInd_hijo();
	}
	/**
	 * Set accessor for persistent attribute: ind_hijo
	 */
	public void setInd_hijo(java.lang.String newInd_hijo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getInd_hijo(),newInd_hijo);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setInd_hijo(newInd_hijo);
	}
	/**
	 * Get accessor for persistent attribute: ind_afecta
	 */
	public java.lang.String getInd_afecta() {
		return dataCacheEntry.getInd_afecta();
	}
	/**
	 * Set accessor for persistent attribute: ind_afecta
	 */
	public void setInd_afecta(java.lang.String newInd_afecta) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getInd_afecta(),newInd_afecta);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setInd_afecta(newInd_afecta);
	}
	/**
	 * Get accessor for persistent attribute: porcentaje_max
	 */
	public java.math.BigDecimal getPorcentaje_max() {
		return dataCacheEntry.getPorcentaje_max();
	}
	/**
	 * Set accessor for persistent attribute: porcentaje_max
	 */
	public void setPorcentaje_max(java.math.BigDecimal newPorcentaje_max) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getPorcentaje_max(),newPorcentaje_max);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setPorcentaje_max(newPorcentaje_max);
	}
	/**
	 * Get accessor for persistent attribute: porcentaje_min
	 */
	public java.math.BigDecimal getPorcentaje_min() {
		return dataCacheEntry.getPorcentaje_min();
	}
	/**
	 * Set accessor for persistent attribute: porcentaje_min
	 */
	public void setPorcentaje_min(java.math.BigDecimal newPorcentaje_min) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getPorcentaje_min(),newPorcentaje_min);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setPorcentaje_min(newPorcentaje_min);
	}
}
