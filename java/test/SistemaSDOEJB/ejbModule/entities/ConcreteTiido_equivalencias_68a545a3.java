package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_equivalenciasBeanCacheEntry_68a545a3;

/**
 * Bean implementation class for Enterprise Bean: Tiido_equivalencias
 */
public class ConcreteTiido_equivalencias_68a545a3 extends entities.Tiido_equivalenciasBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiido_equivalenciasBeanCacheEntry_68a545a3 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_equivalencias_68a545a3
	 */
	public ConcreteTiido_equivalencias_68a545a3() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_equivalenciasBeanInjector_68a545a3 getInjector() {
		return (entities.websphere_deploy.Tiido_equivalenciasBeanInjector_68a545a3)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_equivalenciasBeanCacheEntry_68a545a3) inRecord;
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
	public entities.Tiido_equivalenciasKey ejbFindByPrimaryKey(entities.Tiido_equivalenciasKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_equivalenciasKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindEquivalenciaByCodCargo_Local
	 */
	public entities.Tiido_equivalenciasKey ejbFindEquivalenciaByCodCargo_Local(java.lang.String codCargo) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindEquivalenciaByCodCargo");
		getInjector().ejbFindEquivalenciaByCodCargo(codCargo, record);
		return (entities.Tiido_equivalenciasKey) instanceExtension.executeFind("FindEquivalenciaByCodCargo", record);
	}
	/**
	 * ejbFindAllEquivalencias_Local
	 */
	public java.util.Collection ejbFindAllEquivalencias_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllEquivalencias", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_equivalenciasKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_equivalenciasKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_equivalenciasKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_equivalenciasKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_equivalenciasKey ejbCreate(com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia Equivalencia) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_equivalenciasBeanCacheEntry_68a545a3) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(Equivalencia);
		return (entities.Tiido_equivalenciasKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia Equivalencia) throws javax.ejb.CreateException {
		super.ejbPostCreate(Equivalencia);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_equivalenciasKey ejbCreate(java.lang.String cod_car) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_equivalenciasBeanCacheEntry_68a545a3) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_car);
		return (entities.Tiido_equivalenciasKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_car) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_car);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_equivalenciasKey pk = new entities.Tiido_equivalenciasKey();
		pk.cod_car = getCod_car();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 6;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_car
	 */
	public java.lang.String getCod_car() {
		return dataCacheEntry.getCod_car();
	}
	/**
	 * Set accessor for persistent attribute: cod_car
	 */
	public void setCod_car(java.lang.String newCod_car) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_car(),newCod_car);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_car(newCod_car);
	}
	/**
	 * Get accessor for persistent attribute: cod_per
	 */
	public java.lang.String getCod_per() {
		return dataCacheEntry.getCod_per();
	}
	/**
	 * Set accessor for persistent attribute: cod_per
	 */
	public void setCod_per(java.lang.String newCod_per) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCod_per(),newCod_per);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCod_per(newCod_per);
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
}
