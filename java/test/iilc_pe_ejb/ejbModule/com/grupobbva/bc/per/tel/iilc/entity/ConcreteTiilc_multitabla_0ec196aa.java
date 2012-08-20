package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_multitablaBeanCacheEntry_0ec196aa;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_multitabla
 */
public class ConcreteTiilc_multitabla_0ec196aa extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiilc_multitablaBeanCacheEntry_0ec196aa dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_multitabla_0ec196aa
	 */
	public ConcreteTiilc_multitabla_0ec196aa() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_multitablaBeanInjector_0ec196aa getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_multitablaBeanInjector_0ec196aa)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_multitablaBeanCacheEntry_0ec196aa) inRecord;
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindMultitabla_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey ejbFindMultitabla_Local(java.lang.String cod_mult, java.lang.String cod_ele) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindMultitabla");
		getInjector().ejbFindMultitabla(cod_mult, cod_ele, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey) instanceExtension.executeFind("FindMultitabla", record);
	}
	/**
	 * ejbFindRecord_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey ejbFindRecord_Local(java.lang.String codigo) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindRecord");
		getInjector().ejbFindRecord(codigo, record);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey) instanceExtension.executeFind("FindRecord", record);
	}
	/**
	 * ejbFindAllMultitabla_Local
	 */
	public java.util.Collection ejbFindAllMultitabla_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllMultitabla", null);
	}
	/**
	 * ejbFindAllRecord_Local
	 */
	public java.util.Collection ejbFindAllRecord_Local(java.lang.String cod_mult) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindAllRecord");
		getInjector().ejbFindAllRecord(cod_mult, record);
		return (java.util.Collection) instanceExtension.executeFind("FindAllRecord", record);
	}
	/**
	 * ejbFindMultitablaxValor2_Local
	 */
	public java.util.Collection ejbFindMultitablaxValor2_Local(java.lang.String valor2) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindMultitablaxValor2");
		getInjector().ejbFindMultitablaxValor2(valor2, record);
		return (java.util.Collection) instanceExtension.executeFind("FindMultitablaxValor2", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey ejbCreate(com.grupobbva.bc.per.tel.iilc.serializable.Multitabla multitabla) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_multitablaBeanCacheEntry_0ec196aa) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(multitabla);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tel.iilc.serializable.Multitabla multitabla) throws javax.ejb.CreateException {
		super.ejbPostCreate(multitabla);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey ejbCreate(java.lang.String cod_mult, java.lang.String cod_ele) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_multitablaBeanCacheEntry_0ec196aa) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_mult, cod_ele);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_mult, java.lang.String cod_ele) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_mult, cod_ele);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_multitablaKey();
		pk.cod_mult = getCod_mult();
		pk.cod_ele = getCod_ele();
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
	 * Get accessor for persistent attribute: cod_ele
	 */
	public java.lang.String getCod_ele() {
		return dataCacheEntry.getCod_ele();
	}
	/**
	 * Set accessor for persistent attribute: cod_ele
	 */
	public void setCod_ele(java.lang.String newCod_ele) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCod_ele(),newCod_ele);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCod_ele(newCod_ele);
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
