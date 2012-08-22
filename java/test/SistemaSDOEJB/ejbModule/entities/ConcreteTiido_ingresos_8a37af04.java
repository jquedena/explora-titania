package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_ingresosBeanCacheEntry_8a37af04;

/**
 * Bean implementation class for Enterprise Bean: Tiido_ingresos
 */
public class ConcreteTiido_ingresos_8a37af04 extends entities.Tiido_ingresosBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiido_ingresosBeanCacheEntry_8a37af04 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_ingresos_8a37af04
	 */
	public ConcreteTiido_ingresos_8a37af04() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_ingresosBeanInjector_8a37af04 getInjector() {
		return (entities.websphere_deploy.Tiido_ingresosBeanInjector_8a37af04)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_ingresosBeanCacheEntry_8a37af04) inRecord;
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
	public entities.Tiido_ingresosKey ejbFindByPrimaryKey(entities.Tiido_ingresosKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_ingresosKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_ingresosKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_ingresosKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_ingresosKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_ingresosKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_ingresosKey ejbCreate(java.math.BigDecimal id_ingresos) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_ingresosBeanCacheEntry_8a37af04) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(id_ingresos);
		return (entities.Tiido_ingresosKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.math.BigDecimal id_ingresos) throws javax.ejb.CreateException {
		super.ejbPostCreate(id_ingresos);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_ingresosKey pk = new entities.Tiido_ingresosKey();
		pk.id_ingresos = getId_ingresos();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 8;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: id_ingresos
	 */
	public java.math.BigDecimal getId_ingresos() {
		return dataCacheEntry.getId_ingresos();
	}
	/**
	 * Set accessor for persistent attribute: id_ingresos
	 */
	public void setId_ingresos(java.math.BigDecimal newId_ingresos) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getId_ingresos(),newId_ingresos);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setId_ingresos(newId_ingresos);
	}
	/**
	 * Get accessor for persistent attribute: veces
	 */
	public java.lang.String getVeces() {
		return dataCacheEntry.getVeces();
	}
	/**
	 * Set accessor for persistent attribute: veces
	 */
	public void setVeces(java.lang.String newVeces) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getVeces(),newVeces);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setVeces(newVeces);
	}
	/**
	 * Get accessor for persistent attribute: valido_veces
	 */
	public java.lang.String getValido_veces() {
		return dataCacheEntry.getValido_veces();
	}
	/**
	 * Set accessor for persistent attribute: valido_veces
	 */
	public void setValido_veces(java.lang.String newValido_veces) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getValido_veces(),newValido_veces);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setValido_veces(newValido_veces);
	}
	/**
	 * Get accessor for persistent attribute: cod_usuario
	 */
	public java.lang.String getCod_usuario() {
		return dataCacheEntry.getCod_usuario();
	}
	/**
	 * Set accessor for persistent attribute: cod_usuario
	 */
	public void setCod_usuario(java.lang.String newCod_usuario) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getCod_usuario(),newCod_usuario);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setCod_usuario(newCod_usuario);
	}
	/**
	 * Get accessor for persistent attribute: cargo
	 */
	public java.lang.String getCargo() {
		return dataCacheEntry.getCargo();
	}
	/**
	 * Set accessor for persistent attribute: cargo
	 */
	public void setCargo(java.lang.String newCargo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getCargo(),newCargo);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setCargo(newCargo);
	}
	/**
	 * Get accessor for persistent attribute: nom_territorio
	 */
	public java.lang.String getNom_territorio() {
		return dataCacheEntry.getNom_territorio();
	}
	/**
	 * Set accessor for persistent attribute: nom_territorio
	 */
	public void setNom_territorio(java.lang.String newNom_territorio) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getNom_territorio(),newNom_territorio);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setNom_territorio(newNom_territorio);
	}
	/**
	 * Get accessor for persistent attribute: cod_oficina
	 */
	public java.lang.String getCod_oficina() {
		return dataCacheEntry.getCod_oficina();
	}
	/**
	 * Set accessor for persistent attribute: cod_oficina
	 */
	public void setCod_oficina(java.lang.String newCod_oficina) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getCod_oficina(),newCod_oficina);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setCod_oficina(newCod_oficina);
	}
	/**
	 * Get accessor for persistent attribute: fecha
	 */
	public java.lang.String getFecha() {
		return dataCacheEntry.getFecha();
	}
	/**
	 * Set accessor for persistent attribute: fecha
	 */
	public void setFecha(java.lang.String newFecha) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getFecha(),newFecha);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setFecha(newFecha);
	}
}
