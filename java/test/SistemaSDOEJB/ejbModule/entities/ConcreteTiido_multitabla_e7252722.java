package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_multitablaBeanCacheEntry_e7252722;

/**
 * Bean implementation class for Enterprise Bean: Tiido_multitabla
 */
public class ConcreteTiido_multitabla_e7252722 extends entities.Tiido_multitablaBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiido_multitablaBeanCacheEntry_e7252722 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_multitabla_e7252722
	 */
	public ConcreteTiido_multitabla_e7252722() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_multitablaBeanInjector_e7252722 getInjector() {
		return (entities.websphere_deploy.Tiido_multitablaBeanInjector_e7252722)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_multitablaBeanCacheEntry_e7252722) inRecord;
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
	 * ejbFindByID_Local
	 */
	public entities.Tiido_multitablaKey ejbFindByID_Local(java.lang.String id) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByID");
		getInjector().ejbFindByID(id, record);
		return (entities.Tiido_multitablaKey) instanceExtension.executeFind("FindByID", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_multitablaKey ejbFindByPrimaryKey(entities.Tiido_multitablaKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_multitablaKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindMultiByPrimaryKey_Local
	 */
	public entities.Tiido_multitablaKey ejbFindMultiByPrimaryKey_Local(java.lang.String codMulti, java.lang.String codElem) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindMultiByPrimaryKey");
		getInjector().ejbFindMultiByPrimaryKey(codMulti, codElem, record);
		return (entities.Tiido_multitablaKey) instanceExtension.executeFind("FindMultiByPrimaryKey", record);
	}
	/**
	 * ejbFindByCodMulti_Local
	 */
	public java.util.Collection ejbFindByCodMulti_Local(java.lang.String codMulti) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByCodMulti");
		getInjector().ejbFindByCodMulti(codMulti, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByCodMulti", record);
	}
	/**
	 * ejbFindByMultiForPresup_Local
	 */
	public java.util.Collection ejbFindByMultiForPresup_Local(java.lang.String codMulti, java.lang.String Valor2) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByMultiForPresup");
		getInjector().ejbFindByMultiForPresup(codMulti, Valor2, record);
		return (java.util.Collection) instanceExtension.executeFind("FindByMultiForPresup", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_multitablaKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_multitablaKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_multitablaKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_multitablaKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_multitablaKey ejbCreate(java.lang.String cod_mult, java.lang.String cod_elem) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_multitablaBeanCacheEntry_e7252722) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_mult, cod_elem);
		return (entities.Tiido_multitablaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_mult, java.lang.String cod_elem) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_mult, cod_elem);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_multitablaKey pk = new entities.Tiido_multitablaKey();
		pk.cod_mult = getCod_mult();
		pk.cod_elem = getCod_elem();
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
	 * Get accessor for persistent attribute: cod_mult
	 */
	public java.lang.String getCod_mult() {
		return dataCacheEntry.getCod_mult();
	}
	/**
	 * Set accessor for persistent attribute: cod_mult
	 */
	public void setCod_mult(java.lang.String newCod_mult) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_mult(),newCod_mult);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_mult(newCod_mult);
	}
	/**
	 * Get accessor for persistent attribute: cod_elem
	 */
	public java.lang.String getCod_elem() {
		return dataCacheEntry.getCod_elem();
	}
	/**
	 * Set accessor for persistent attribute: cod_elem
	 */
	public void setCod_elem(java.lang.String newCod_elem) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCod_elem(),newCod_elem);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCod_elem(newCod_elem);
	}
	/**
	 * Get accessor for persistent attribute: valor1
	 */
	public java.lang.String getValor1() {
		return dataCacheEntry.getValor1();
	}
	/**
	 * Set accessor for persistent attribute: valor1
	 */
	public void setValor1(java.lang.String newValor1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getValor1(),newValor1);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setValor1(newValor1);
	}
	/**
	 * Get accessor for persistent attribute: valor2
	 */
	public java.lang.String getValor2() {
		return dataCacheEntry.getValor2();
	}
	/**
	 * Set accessor for persistent attribute: valor2
	 */
	public void setValor2(java.lang.String newValor2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getValor2(),newValor2);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setValor2(newValor2);
	}
	/**
	 * Get accessor for persistent attribute: valor3
	 */
	public java.lang.String getValor3() {
		return dataCacheEntry.getValor3();
	}
	/**
	 * Set accessor for persistent attribute: valor3
	 */
	public void setValor3(java.lang.String newValor3) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getValor3(),newValor3);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setValor3(newValor3);
	}
	/**
	 * Get accessor for persistent attribute: valor4
	 */
	public java.lang.String getValor4() {
		return dataCacheEntry.getValor4();
	}
	/**
	 * Set accessor for persistent attribute: valor4
	 */
	public void setValor4(java.lang.String newValor4) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getValor4(),newValor4);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setValor4(newValor4);
	}
}
