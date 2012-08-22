package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_perfilesBeanCacheEntry_8b3810c2;

/**
 * Bean implementation class for Enterprise Bean: Tiido_perfiles
 */
public class ConcreteTiido_perfiles_8b3810c2 extends entities.Tiido_perfilesBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiido_perfilesBeanCacheEntry_8b3810c2 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_perfiles_8b3810c2
	 */
	public ConcreteTiido_perfiles_8b3810c2() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_perfilesBeanInjector_8b3810c2 getInjector() {
		return (entities.websphere_deploy.Tiido_perfilesBeanInjector_8b3810c2)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_perfilesBeanCacheEntry_8b3810c2) inRecord;
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
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_perfilesKey ejbFindByPrimaryKey(entities.Tiido_perfilesKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_perfilesKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllPerfil_Local
	 */
	public java.util.Collection ejbFindAllPerfil_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllPerfil", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_perfilesKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_perfilesKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_perfilesKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_perfilesKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_perfilesKey ejbCreate(com.grupobbva.bc.per.tele.sdo.serializable.Perfil per) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_perfilesBeanCacheEntry_8b3810c2) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(per);
		return (entities.Tiido_perfilesKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tele.sdo.serializable.Perfil per) throws javax.ejb.CreateException {
		super.ejbPostCreate(per);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_perfilesKey ejbCreate(java.lang.String cod_perfil) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_perfilesBeanCacheEntry_8b3810c2) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_perfil);
		return (entities.Tiido_perfilesKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_perfil) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_perfil);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_perfilesKey pk = new entities.Tiido_perfilesKey();
		pk.cod_perfil = getCod_perfil();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 7;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_perfil
	 */
	public java.lang.String getCod_perfil() {
		return dataCacheEntry.getCod_perfil();
	}
	/**
	 * Set accessor for persistent attribute: cod_perfil
	 */
	public void setCod_perfil(java.lang.String newCod_perfil) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_perfil(),newCod_perfil);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_perfil(newCod_perfil);
	}
	/**
	 * Get accessor for persistent attribute: nom_perfil
	 */
	public java.lang.String getNom_perfil() {
		return dataCacheEntry.getNom_perfil();
	}
	/**
	 * Set accessor for persistent attribute: nom_perfil
	 */
	public void setNom_perfil(java.lang.String newNom_perfil) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getNom_perfil(),newNom_perfil);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setNom_perfil(newNom_perfil);
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
	 * Get accessor for persistent attribute: perfil
	 */
	public java.lang.String getPerfil() {
		return dataCacheEntry.getPerfil();
	}
	/**
	 * Set accessor for persistent attribute: perfil
	 */
	public void setPerfil(java.lang.String newPerfil) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getPerfil(),newPerfil);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setPerfil(newPerfil);
	}
}
