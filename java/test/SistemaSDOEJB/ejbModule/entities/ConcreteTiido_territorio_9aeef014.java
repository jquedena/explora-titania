package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_territorioBeanCacheEntry_9aeef014;

/**
 * Bean implementation class for Enterprise Bean: Tiido_territorio
 */
public class ConcreteTiido_territorio_9aeef014 extends entities.Tiido_territorioBean implements javax.ejb.EntityBean, ConcreteBeanWithLink {
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
	private Tiido_territorioBeanCacheEntry_9aeef014 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_territorio_9aeef014
	 */
	public ConcreteTiido_territorio_9aeef014() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_territorioBeanInjector_9aeef014 getInjector() {
		return (entities.websphere_deploy.Tiido_territorioBeanInjector_9aeef014)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_territorioBeanCacheEntry_9aeef014) inRecord;
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
			tiido_oficinaLink = null;
	}
	/**
	 * ejbFindByCodTerritorio_Local
	 */
	public entities.Tiido_territorioKey ejbFindByCodTerritorio_Local(java.lang.String codTerritorio) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCodTerritorio");
		getInjector().ejbFindByCodTerritorio(codTerritorio, record);
		return (entities.Tiido_territorioKey) instanceExtension.executeFind("FindByCodTerritorio", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_territorioKey ejbFindByPrimaryKey(entities.Tiido_territorioKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_territorioKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllTerritorio_Local
	 */
	public java.util.Collection ejbFindAllTerritorio_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllTerritorio", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_territorioKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_territorioKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_territorioKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_territorioKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_territorioKey ejbCreate(java.lang.String cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_territorioBeanCacheEntry_9aeef014) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_terr);
		return (entities.Tiido_territorioKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_territorioKey pk = new entities.Tiido_territorioKey();
		pk.cod_terr = getCod_terr();
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
		if (name.equals("tiido_oficina")) return getTiido_oficinaLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_oficina")){
			entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8 home = (entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8)instanceExtension.getHomeForLink("tiido_oficina");
		  return home.findTiido_oficinaByTiido_territorio_fkKey_Local((entities.Tiido_territorioKey)key);
		}
		return null;
	}
	/**
	 * getTiido_oficina
	 */
	public java.util.Collection getTiido_oficina() {
		return (java.util.Collection)getTiido_oficinaLink().getValue();
	}
	/**
	 * setTiido_oficina
	 */
	public void setTiido_oficina(java.util.Collection value) {
		getTiido_oficinaLink().setValue(value);
	}
	/**
	 * getTiido_oficinaLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_oficinaLink() {
		if (tiido_oficinaLink == null) 
		tiido_oficinaLink = instanceExtension.createLink("tiido_oficina",null,7);
		return tiido_oficinaLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_oficinaLink;
	/**
	 * ejbFindTiido_territorio_fkByTiido_oficinaKey_Local
	 */
	public entities.Tiido_territorioKey ejbFindTiido_territorio_fkByTiido_oficinaKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_oficina",key);
		if (result!=null )  return (entities.Tiido_territorioKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_territorio_fkByTiido_oficinaKey_Local");
		getInjector().findTiido_territorio_fkByTiido_oficinaKey_Local(key, record);
		return (entities.Tiido_territorioKey) instanceExtension.executeFind("findTiido_territorio_fkByTiido_oficinaKey_Local", record);
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_terr
	 */
	public java.lang.String getCod_terr() {
		return dataCacheEntry.getCod_terr();
	}
	/**
	 * Set accessor for persistent attribute: cod_terr
	 */
	public void setCod_terr(java.lang.String newCod_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_terr(),newCod_terr);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_terr(newCod_terr);
	}
	/**
	 * Get accessor for persistent attribute: nom_terr
	 */
	public java.lang.String getNom_terr() {
		return dataCacheEntry.getNom_terr();
	}
	/**
	 * Set accessor for persistent attribute: nom_terr
	 */
	public void setNom_terr(java.lang.String newNom_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getNom_terr(),newNom_terr);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setNom_terr(newNom_terr);
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
			instanceExtension.markDirty(6,getEstado(),newEstado);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setEstado(newEstado);
	}
}
