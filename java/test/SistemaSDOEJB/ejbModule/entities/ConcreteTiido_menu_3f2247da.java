package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_menuBeanCacheEntry_3f2247da;

/**
 * Bean implementation class for Enterprise Bean: Tiido_menu
 */
public class ConcreteTiido_menu_3f2247da extends entities.Tiido_menuBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiido_menuBeanCacheEntry_3f2247da dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_menu_3f2247da
	 */
	public ConcreteTiido_menu_3f2247da() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_menuBeanInjector_3f2247da getInjector() {
		return (entities.websphere_deploy.Tiido_menuBeanInjector_3f2247da)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_menuBeanCacheEntry_3f2247da) inRecord;
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
	public entities.Tiido_menuKey ejbFindByPrimaryKey(entities.Tiido_menuKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_menuKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAllMenu_Local
	 */
	public java.util.Collection ejbFindAllMenu_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllMenu", null);
	}
	/**
	 * ejbFindxCodPerfil_Local
	 */
	public java.util.Collection ejbFindxCodPerfil_Local(java.lang.String codPerfil) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindxCodPerfil");
		getInjector().ejbFindxCodPerfil(codPerfil, record);
		return (java.util.Collection) instanceExtension.executeFind("FindxCodPerfil", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_menuKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_menuKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_menuKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_menuKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_menuKey ejbCreate(com.grupobbva.bc.per.tele.sdo.serializable.Menu mp) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_menuBeanCacheEntry_3f2247da) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(mp);
		return (entities.Tiido_menuKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tele.sdo.serializable.Menu mp) throws javax.ejb.CreateException {
		super.ejbPostCreate(mp);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_menuKey ejbCreate(java.lang.String padre) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_menuBeanCacheEntry_3f2247da) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(padre);
		return (entities.Tiido_menuKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String padre) throws javax.ejb.CreateException {
		super.ejbPostCreate(padre);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_menuKey pk = new entities.Tiido_menuKey();
		pk.padre = getPadre();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 5;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: padre
	 */
	public java.lang.String getPadre() {
		return dataCacheEntry.getPadre();
	}
	/**
	 * Set accessor for persistent attribute: padre
	 */
	public void setPadre(java.lang.String newPadre) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getPadre(),newPadre);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setPadre(newPadre);
	}
	/**
	 * Get accessor for persistent attribute: link
	 */
	public java.lang.String getLink() {
		return dataCacheEntry.getLink();
	}
	/**
	 * Set accessor for persistent attribute: link
	 */
	public void setLink(java.lang.String newLink) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getLink(),newLink);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setLink(newLink);
	}
	/**
	 * Get accessor for persistent attribute: hijo
	 */
	public java.lang.String getHijo() {
		return dataCacheEntry.getHijo();
	}
	/**
	 * Set accessor for persistent attribute: hijo
	 */
	public void setHijo(java.lang.String newHijo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getHijo(),newHijo);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setHijo(newHijo);
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
			instanceExtension.markDirty(3,getDescripcion(),newDescripcion);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setDescripcion(newDescripcion);
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
			instanceExtension.markDirty(4,getCod_perfil(),newCod_perfil);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setCod_perfil(newCod_perfil);
	}
}
