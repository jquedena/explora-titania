package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_totalBeanCacheEntry_40ed895e;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_total
 */
public class ConcreteTiilc_total_40ed895e extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiilc_totalBeanCacheEntry_40ed895e dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_total_40ed895e
	 */
	public ConcreteTiilc_total_40ed895e() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_totalBeanInjector_40ed895e getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_totalBeanInjector_40ed895e)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_totalBeanCacheEntry_40ed895e) inRecord;
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindTotalxGexOfxTe_Local
	 */
	public java.util.Collection ejbFindTotalxGexOfxTe_Local(java.lang.String ind_registro, java.lang.String cod_territorio, java.lang.String cod_oficina, java.lang.String cod_gestor) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindTotalxGexOfxTe");
		getInjector().ejbFindTotalxGexOfxTe(ind_registro, cod_territorio, cod_oficina, cod_gestor, record);
		return (java.util.Collection) instanceExtension.executeFind("FindTotalxGexOfxTe", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey ejbCreate(com.grupobbva.bc.per.tel.iilc.serializable.Total total) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_totalBeanCacheEntry_40ed895e) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(total);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tel.iilc.serializable.Total total) throws javax.ejb.CreateException {
		super.ejbPostCreate(total);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey ejbCreate(java.math.BigDecimal cod_total) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_totalBeanCacheEntry_40ed895e) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_total);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.math.BigDecimal cod_total) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_total);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey();
		pk.cod_total = getCod_total();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 136;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_total
	 */
	public java.math.BigDecimal getCod_total() {
		return dataCacheEntry.getCod_total();
	}
	/**
	 * Set accessor for persistent attribute: cod_total
	 */
	public void setCod_total(java.math.BigDecimal newCod_total) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_total(),newCod_total);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_total(newCod_total);
	}
	/**
	 * Get accessor for persistent attribute: cod_territorio
	 */
	public java.lang.String getCod_territorio() {
		return dataCacheEntry.getCod_territorio();
	}
	/**
	 * Set accessor for persistent attribute: cod_territorio
	 */
	public void setCod_territorio(java.lang.String newCod_territorio) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCod_territorio(),newCod_territorio);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCod_territorio(newCod_territorio);
	}
	/**
	 * Get accessor for persistent attribute: ind_registro
	 */
	public java.lang.String getInd_registro() {
		return dataCacheEntry.getInd_registro();
	}
	/**
	 * Set accessor for persistent attribute: ind_registro
	 */
	public void setInd_registro(java.lang.String newInd_registro) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getInd_registro(),newInd_registro);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setInd_registro(newInd_registro);
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
			instanceExtension.markDirty(3,getCod_oficina(),newCod_oficina);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setCod_oficina(newCod_oficina);
	}
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public java.lang.String getCod_gestor() {
		return dataCacheEntry.getCod_gestor();
	}
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public void setCod_gestor(java.lang.String newCod_gestor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getCod_gestor(),newCod_gestor);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setCod_gestor(newCod_gestor);
	}
	/**
	 * Get accessor for persistent attribute: clixgest
	 */
	public java.math.BigDecimal getClixgest() {
		return dataCacheEntry.getClixgest();
	}
	/**
	 * Set accessor for persistent attribute: clixgest
	 */
	public void setClixgest(java.math.BigDecimal newClixgest) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getClixgest(),newClixgest);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setClixgest(newClixgest);
	}
	/**
	 * Get accessor for persistent attribute: seg_10100
	 */
	public java.math.BigDecimal getSeg_10100() {
		return dataCacheEntry.getSeg_10100();
	}
	/**
	 * Set accessor for persistent attribute: seg_10100
	 */
	public void setSeg_10100(java.math.BigDecimal newSeg_10100) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getSeg_10100(),newSeg_10100);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setSeg_10100(newSeg_10100);
	}
	/**
	 * Get accessor for persistent attribute: seg_10200
	 */
	public java.math.BigDecimal getSeg_10200() {
		return dataCacheEntry.getSeg_10200();
	}
	/**
	 * Set accessor for persistent attribute: seg_10200
	 */
	public void setSeg_10200(java.math.BigDecimal newSeg_10200) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getSeg_10200(),newSeg_10200);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setSeg_10200(newSeg_10200);
	}
	/**
	 * Get accessor for persistent attribute: seg_20100
	 */
	public java.math.BigDecimal getSeg_20100() {
		return dataCacheEntry.getSeg_20100();
	}
	/**
	 * Set accessor for persistent attribute: seg_20100
	 */
	public void setSeg_20100(java.math.BigDecimal newSeg_20100) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getSeg_20100(),newSeg_20100);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setSeg_20100(newSeg_20100);
	}
	/**
	 * Get accessor for persistent attribute: seg_20200
	 */
	public java.math.BigDecimal getSeg_20200() {
		return dataCacheEntry.getSeg_20200();
	}
	/**
	 * Set accessor for persistent attribute: seg_20200
	 */
	public void setSeg_20200(java.math.BigDecimal newSeg_20200) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getSeg_20200(),newSeg_20200);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setSeg_20200(newSeg_20200);
	}
	/**
	 * Get accessor for persistent attribute: seg_20300
	 */
	public java.math.BigDecimal getSeg_20300() {
		return dataCacheEntry.getSeg_20300();
	}
	/**
	 * Set accessor for persistent attribute: seg_20300
	 */
	public void setSeg_20300(java.math.BigDecimal newSeg_20300) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getSeg_20300(),newSeg_20300);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setSeg_20300(newSeg_20300);
	}
	/**
	 * Get accessor for persistent attribute: seg_20400
	 */
	public java.math.BigDecimal getSeg_20400() {
		return dataCacheEntry.getSeg_20400();
	}
	/**
	 * Set accessor for persistent attribute: seg_20400
	 */
	public void setSeg_20400(java.math.BigDecimal newSeg_20400) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getSeg_20400(),newSeg_20400);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setSeg_20400(newSeg_20400);
	}
	/**
	 * Get accessor for persistent attribute: seg_20500
	 */
	public java.math.BigDecimal getSeg_20500() {
		return dataCacheEntry.getSeg_20500();
	}
	/**
	 * Set accessor for persistent attribute: seg_20500
	 */
	public void setSeg_20500(java.math.BigDecimal newSeg_20500) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getSeg_20500(),newSeg_20500);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setSeg_20500(newSeg_20500);
	}
	/**
	 * Get accessor for persistent attribute: seg_20600
	 */
	public java.math.BigDecimal getSeg_20600() {
		return dataCacheEntry.getSeg_20600();
	}
	/**
	 * Set accessor for persistent attribute: seg_20600
	 */
	public void setSeg_20600(java.math.BigDecimal newSeg_20600) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getSeg_20600(),newSeg_20600);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setSeg_20600(newSeg_20600);
	}
	/**
	 * Get accessor for persistent attribute: seg_30100
	 */
	public java.math.BigDecimal getSeg_30100() {
		return dataCacheEntry.getSeg_30100();
	}
	/**
	 * Set accessor for persistent attribute: seg_30100
	 */
	public void setSeg_30100(java.math.BigDecimal newSeg_30100) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getSeg_30100(),newSeg_30100);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setSeg_30100(newSeg_30100);
	}
	/**
	 * Get accessor for persistent attribute: seg_30200
	 */
	public java.math.BigDecimal getSeg_30200() {
		return dataCacheEntry.getSeg_30200();
	}
	/**
	 * Set accessor for persistent attribute: seg_30200
	 */
	public void setSeg_30200(java.math.BigDecimal newSeg_30200) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getSeg_30200(),newSeg_30200);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setSeg_30200(newSeg_30200);
	}
	/**
	 * Get accessor for persistent attribute: seg_30300
	 */
	public java.math.BigDecimal getSeg_30300() {
		return dataCacheEntry.getSeg_30300();
	}
	/**
	 * Set accessor for persistent attribute: seg_30300
	 */
	public void setSeg_30300(java.math.BigDecimal newSeg_30300) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(16,getSeg_30300(),newSeg_30300);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setSeg_30300(newSeg_30300);
	}
	/**
	 * Get accessor for persistent attribute: seg_30400
	 */
	public java.math.BigDecimal getSeg_30400() {
		return dataCacheEntry.getSeg_30400();
	}
	/**
	 * Set accessor for persistent attribute: seg_30400
	 */
	public void setSeg_30400(java.math.BigDecimal newSeg_30400) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getSeg_30400(),newSeg_30400);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setSeg_30400(newSeg_30400);
	}
	/**
	 * Get accessor for persistent attribute: seg_40100
	 */
	public java.math.BigDecimal getSeg_40100() {
		return dataCacheEntry.getSeg_40100();
	}
	/**
	 * Set accessor for persistent attribute: seg_40100
	 */
	public void setSeg_40100(java.math.BigDecimal newSeg_40100) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getSeg_40100(),newSeg_40100);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setSeg_40100(newSeg_40100);
	}
	/**
	 * Get accessor for persistent attribute: seg_40200
	 */
	public java.math.BigDecimal getSeg_40200() {
		return dataCacheEntry.getSeg_40200();
	}
	/**
	 * Set accessor for persistent attribute: seg_40200
	 */
	public void setSeg_40200(java.math.BigDecimal newSeg_40200) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getSeg_40200(),newSeg_40200);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setSeg_40200(newSeg_40200);
	}
	/**
	 * Get accessor for persistent attribute: seg_40300
	 */
	public java.math.BigDecimal getSeg_40300() {
		return dataCacheEntry.getSeg_40300();
	}
	/**
	 * Set accessor for persistent attribute: seg_40300
	 */
	public void setSeg_40300(java.math.BigDecimal newSeg_40300) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getSeg_40300(),newSeg_40300);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setSeg_40300(newSeg_40300);
	}
	/**
	 * Get accessor for persistent attribute: seg_40400
	 */
	public java.math.BigDecimal getSeg_40400() {
		return dataCacheEntry.getSeg_40400();
	}
	/**
	 * Set accessor for persistent attribute: seg_40400
	 */
	public void setSeg_40400(java.math.BigDecimal newSeg_40400) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(21,getSeg_40400(),newSeg_40400);
		else
			instanceExtension.markDirty(21);
		dataCacheEntry.setSeg_40400(newSeg_40400);
	}
	/**
	 * Get accessor for persistent attribute: seg_50100
	 */
	public java.math.BigDecimal getSeg_50100() {
		return dataCacheEntry.getSeg_50100();
	}
	/**
	 * Set accessor for persistent attribute: seg_50100
	 */
	public void setSeg_50100(java.math.BigDecimal newSeg_50100) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(22,getSeg_50100(),newSeg_50100);
		else
			instanceExtension.markDirty(22);
		dataCacheEntry.setSeg_50100(newSeg_50100);
	}
	/**
	 * Get accessor for persistent attribute: seg_50200
	 */
	public java.math.BigDecimal getSeg_50200() {
		return dataCacheEntry.getSeg_50200();
	}
	/**
	 * Set accessor for persistent attribute: seg_50200
	 */
	public void setSeg_50200(java.math.BigDecimal newSeg_50200) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(23,getSeg_50200(),newSeg_50200);
		else
			instanceExtension.markDirty(23);
		dataCacheEntry.setSeg_50200(newSeg_50200);
	}
	/**
	 * Get accessor for persistent attribute: seg_50300
	 */
	public java.math.BigDecimal getSeg_50300() {
		return dataCacheEntry.getSeg_50300();
	}
	/**
	 * Set accessor for persistent attribute: seg_50300
	 */
	public void setSeg_50300(java.math.BigDecimal newSeg_50300) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(24,getSeg_50300(),newSeg_50300);
		else
			instanceExtension.markDirty(24);
		dataCacheEntry.setSeg_50300(newSeg_50300);
	}
	/**
	 * Get accessor for persistent attribute: seg_50400
	 */
	public java.math.BigDecimal getSeg_50400() {
		return dataCacheEntry.getSeg_50400();
	}
	/**
	 * Set accessor for persistent attribute: seg_50400
	 */
	public void setSeg_50400(java.math.BigDecimal newSeg_50400) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(25,getSeg_50400(),newSeg_50400);
		else
			instanceExtension.markDirty(25);
		dataCacheEntry.setSeg_50400(newSeg_50400);
	}
	/**
	 * Get accessor for persistent attribute: seg_60100
	 */
	public java.math.BigDecimal getSeg_60100() {
		return dataCacheEntry.getSeg_60100();
	}
	/**
	 * Set accessor for persistent attribute: seg_60100
	 */
	public void setSeg_60100(java.math.BigDecimal newSeg_60100) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(26,getSeg_60100(),newSeg_60100);
		else
			instanceExtension.markDirty(26);
		dataCacheEntry.setSeg_60100(newSeg_60100);
	}
	/**
	 * Get accessor for persistent attribute: seg_60200
	 */
	public java.math.BigDecimal getSeg_60200() {
		return dataCacheEntry.getSeg_60200();
	}
	/**
	 * Set accessor for persistent attribute: seg_60200
	 */
	public void setSeg_60200(java.math.BigDecimal newSeg_60200) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(27,getSeg_60200(),newSeg_60200);
		else
			instanceExtension.markDirty(27);
		dataCacheEntry.setSeg_60200(newSeg_60200);
	}
	/**
	 * Get accessor for persistent attribute: seg_60300
	 */
	public java.math.BigDecimal getSeg_60300() {
		return dataCacheEntry.getSeg_60300();
	}
	/**
	 * Set accessor for persistent attribute: seg_60300
	 */
	public void setSeg_60300(java.math.BigDecimal newSeg_60300) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(28,getSeg_60300(),newSeg_60300);
		else
			instanceExtension.markDirty(28);
		dataCacheEntry.setSeg_60300(newSeg_60300);
	}
	/**
	 * Get accessor for persistent attribute: seg_60400
	 */
	public java.math.BigDecimal getSeg_60400() {
		return dataCacheEntry.getSeg_60400();
	}
	/**
	 * Set accessor for persistent attribute: seg_60400
	 */
	public void setSeg_60400(java.math.BigDecimal newSeg_60400) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(29,getSeg_60400(),newSeg_60400);
		else
			instanceExtension.markDirty(29);
		dataCacheEntry.setSeg_60400(newSeg_60400);
	}
	/**
	 * Get accessor for persistent attribute: seg_80100
	 */
	public java.math.BigDecimal getSeg_80100() {
		return dataCacheEntry.getSeg_80100();
	}
	/**
	 * Set accessor for persistent attribute: seg_80100
	 */
	public void setSeg_80100(java.math.BigDecimal newSeg_80100) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(30,getSeg_80100(),newSeg_80100);
		else
			instanceExtension.markDirty(30);
		dataCacheEntry.setSeg_80100(newSeg_80100);
	}
	/**
	 * Get accessor for persistent attribute: seg_80200
	 */
	public java.math.BigDecimal getSeg_80200() {
		return dataCacheEntry.getSeg_80200();
	}
	/**
	 * Set accessor for persistent attribute: seg_80200
	 */
	public void setSeg_80200(java.math.BigDecimal newSeg_80200) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(31,getSeg_80200(),newSeg_80200);
		else
			instanceExtension.markDirty(31);
		dataCacheEntry.setSeg_80200(newSeg_80200);
	}
	/**
	 * Get accessor for persistent attribute: seg_80300
	 */
	public java.math.BigDecimal getSeg_80300() {
		return dataCacheEntry.getSeg_80300();
	}
	/**
	 * Set accessor for persistent attribute: seg_80300
	 */
	public void setSeg_80300(java.math.BigDecimal newSeg_80300) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(32,getSeg_80300(),newSeg_80300);
		else
			instanceExtension.markDirty(32);
		dataCacheEntry.setSeg_80300(newSeg_80300);
	}
	/**
	 * Get accessor for persistent attribute: seg_80400
	 */
	public java.math.BigDecimal getSeg_80400() {
		return dataCacheEntry.getSeg_80400();
	}
	/**
	 * Set accessor for persistent attribute: seg_80400
	 */
	public void setSeg_80400(java.math.BigDecimal newSeg_80400) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(33,getSeg_80400(),newSeg_80400);
		else
			instanceExtension.markDirty(33);
		dataCacheEntry.setSeg_80400(newSeg_80400);
	}
	/**
	 * Get accessor for persistent attribute: seg_80500
	 */
	public java.math.BigDecimal getSeg_80500() {
		return dataCacheEntry.getSeg_80500();
	}
	/**
	 * Set accessor for persistent attribute: seg_80500
	 */
	public void setSeg_80500(java.math.BigDecimal newSeg_80500) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(34,getSeg_80500(),newSeg_80500);
		else
			instanceExtension.markDirty(34);
		dataCacheEntry.setSeg_80500(newSeg_80500);
	}
	/**
	 * Get accessor for persistent attribute: seg_80600
	 */
	public java.math.BigDecimal getSeg_80600() {
		return dataCacheEntry.getSeg_80600();
	}
	/**
	 * Set accessor for persistent attribute: seg_80600
	 */
	public void setSeg_80600(java.math.BigDecimal newSeg_80600) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(35,getSeg_80600(),newSeg_80600);
		else
			instanceExtension.markDirty(35);
		dataCacheEntry.setSeg_80600(newSeg_80600);
	}
	/**
	 * Get accessor for persistent attribute: seg_80700
	 */
	public java.math.BigDecimal getSeg_80700() {
		return dataCacheEntry.getSeg_80700();
	}
	/**
	 * Set accessor for persistent attribute: seg_80700
	 */
	public void setSeg_80700(java.math.BigDecimal newSeg_80700) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(36,getSeg_80700(),newSeg_80700);
		else
			instanceExtension.markDirty(36);
		dataCacheEntry.setSeg_80700(newSeg_80700);
	}
	/**
	 * Get accessor for persistent attribute: seg_90200
	 */
	public java.math.BigDecimal getSeg_90200() {
		return dataCacheEntry.getSeg_90200();
	}
	/**
	 * Set accessor for persistent attribute: seg_90200
	 */
	public void setSeg_90200(java.math.BigDecimal newSeg_90200) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(37,getSeg_90200(),newSeg_90200);
		else
			instanceExtension.markDirty(37);
		dataCacheEntry.setSeg_90200(newSeg_90200);
	}
	/**
	 * Get accessor for persistent attribute: seg_99900
	 */
	public java.math.BigDecimal getSeg_99900() {
		return dataCacheEntry.getSeg_99900();
	}
	/**
	 * Set accessor for persistent attribute: seg_99900
	 */
	public void setSeg_99900(java.math.BigDecimal newSeg_99900) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(38,getSeg_99900(),newSeg_99900);
		else
			instanceExtension.markDirty(38);
		dataCacheEntry.setSeg_99900(newSeg_99900);
	}
	/**
	 * Get accessor for persistent attribute: desvin
	 */
	public java.math.BigDecimal getDesvin() {
		return dataCacheEntry.getDesvin();
	}
	/**
	 * Set accessor for persistent attribute: desvin
	 */
	public void setDesvin(java.math.BigDecimal newDesvin) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(39,getDesvin(),newDesvin);
		else
			instanceExtension.markDirty(39);
		dataCacheEntry.setDesvin(newDesvin);
	}
	/**
	 * Get accessor for persistent attribute: pocovin
	 */
	public java.math.BigDecimal getPocovin() {
		return dataCacheEntry.getPocovin();
	}
	/**
	 * Set accessor for persistent attribute: pocovin
	 */
	public void setPocovin(java.math.BigDecimal newPocovin) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(40,getPocovin(),newPocovin);
		else
			instanceExtension.markDirty(40);
		dataCacheEntry.setPocovin(newPocovin);
	}
	/**
	 * Get accessor for persistent attribute: vin
	 */
	public java.math.BigDecimal getVin() {
		return dataCacheEntry.getVin();
	}
	/**
	 * Set accessor for persistent attribute: vin
	 */
	public void setVin(java.math.BigDecimal newVin) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(41,getVin(),newVin);
		else
			instanceExtension.markDirty(41);
		dataCacheEntry.setVin(newVin);
	}
	/**
	 * Get accessor for persistent attribute: muyvin
	 */
	public java.math.BigDecimal getMuyvin() {
		return dataCacheEntry.getMuyvin();
	}
	/**
	 * Set accessor for persistent attribute: muyvin
	 */
	public void setMuyvin(java.math.BigDecimal newMuyvin) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(42,getMuyvin(),newMuyvin);
		else
			instanceExtension.markDirty(42);
		dataCacheEntry.setMuyvin(newMuyvin);
	}
	/**
	 * Get accessor for persistent attribute: natdesvin
	 */
	public java.math.BigDecimal getNatdesvin() {
		return dataCacheEntry.getNatdesvin();
	}
	/**
	 * Set accessor for persistent attribute: natdesvin
	 */
	public void setNatdesvin(java.math.BigDecimal newNatdesvin) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(43,getNatdesvin(),newNatdesvin);
		else
			instanceExtension.markDirty(43);
		dataCacheEntry.setNatdesvin(newNatdesvin);
	}
	/**
	 * Get accessor for persistent attribute: natvin
	 */
	public java.math.BigDecimal getNatvin() {
		return dataCacheEntry.getNatvin();
	}
	/**
	 * Set accessor for persistent attribute: natvin
	 */
	public void setNatvin(java.math.BigDecimal newNatvin) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(44,getNatvin(),newNatvin);
		else
			instanceExtension.markDirty(44);
		dataCacheEntry.setNatvin(newNatvin);
	}
	/**
	 * Get accessor for persistent attribute: jurvin
	 */
	public java.math.BigDecimal getJurvin() {
		return dataCacheEntry.getJurvin();
	}
	/**
	 * Set accessor for persistent attribute: jurvin
	 */
	public void setJurvin(java.math.BigDecimal newJurvin) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(45,getJurvin(),newJurvin);
		else
			instanceExtension.markDirty(45);
		dataCacheEntry.setJurvin(newJurvin);
	}
	/**
	 * Get accessor for persistent attribute: ahor_t
	 */
	public java.math.BigDecimal getAhor_t() {
		return dataCacheEntry.getAhor_t();
	}
	/**
	 * Set accessor for persistent attribute: ahor_t
	 */
	public void setAhor_t(java.math.BigDecimal newAhor_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(46,getAhor_t(),newAhor_t);
		else
			instanceExtension.markDirty(46);
		dataCacheEntry.setAhor_t(newAhor_t);
	}
	/**
	 * Get accessor for persistent attribute: ahsd_t
	 */
	public java.math.BigDecimal getAhsd_t() {
		return dataCacheEntry.getAhsd_t();
	}
	/**
	 * Set accessor for persistent attribute: ahsd_t
	 */
	public void setAhsd_t(java.math.BigDecimal newAhsd_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(47,getAhsd_t(),newAhsd_t);
		else
			instanceExtension.markDirty(47);
		dataCacheEntry.setAhsd_t(newAhsd_t);
	}
	/**
	 * Get accessor for persistent attribute: aval_t
	 */
	public java.math.BigDecimal getAval_t() {
		return dataCacheEntry.getAval_t();
	}
	/**
	 * Set accessor for persistent attribute: aval_t
	 */
	public void setAval_t(java.math.BigDecimal newAval_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(48,getAval_t(),newAval_t);
		else
			instanceExtension.markDirty(48);
		dataCacheEntry.setAval_t(newAval_t);
	}
	/**
	 * Get accessor for persistent attribute: b24_t
	 */
	public java.math.BigDecimal getB24_t() {
		return dataCacheEntry.getB24_t();
	}
	/**
	 * Set accessor for persistent attribute: b24_t
	 */
	public void setB24_t(java.math.BigDecimal newB24_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(49,getB24_t(),newB24_t);
		else
			instanceExtension.markDirty(49);
		dataCacheEntry.setB24_t(newB24_t);
	}
	/**
	 * Get accessor for persistent attribute: ccte_t
	 */
	public java.math.BigDecimal getCcte_t() {
		return dataCacheEntry.getCcte_t();
	}
	/**
	 * Set accessor for persistent attribute: ccte_t
	 */
	public void setCcte_t(java.math.BigDecimal newCcte_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(50,getCcte_t(),newCcte_t);
		else
			instanceExtension.markDirty(50);
		dataCacheEntry.setCcte_t(newCcte_t);
	}
	/**
	 * Get accessor for persistent attribute: cext_t
	 */
	public java.math.BigDecimal getCext_t() {
		return dataCacheEntry.getCext_t();
	}
	/**
	 * Set accessor for persistent attribute: cext_t
	 */
	public void setCext_t(java.math.BigDecimal newCext_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(51,getCext_t(),newCext_t);
		else
			instanceExtension.markDirty(51);
		dataCacheEntry.setCext_t(newCext_t);
	}
	/**
	 * Get accessor for persistent attribute: cloc_t
	 */
	public java.math.BigDecimal getCloc_t() {
		return dataCacheEntry.getCloc_t();
	}
	/**
	 * Set accessor for persistent attribute: cloc_t
	 */
	public void setCloc_t(java.math.BigDecimal newCloc_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(52,getCloc_t(),newCloc_t);
		else
			instanceExtension.markDirty(52);
		dataCacheEntry.setCloc_t(newCloc_t);
	}
	/**
	 * Get accessor for persistent attribute: colb_t
	 */
	public java.math.BigDecimal getColb_t() {
		return dataCacheEntry.getColb_t();
	}
	/**
	 * Set accessor for persistent attribute: colb_t
	 */
	public void setColb_t(java.math.BigDecimal newColb_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(53,getColb_t(),newColb_t);
		else
			instanceExtension.markDirty(53);
		dataCacheEntry.setColb_t(newColb_t);
	}
	/**
	 * Get accessor for persistent attribute: cpte_t
	 */
	public java.math.BigDecimal getCpte_t() {
		return dataCacheEntry.getCpte_t();
	}
	/**
	 * Set accessor for persistent attribute: cpte_t
	 */
	public void setCpte_t(java.math.BigDecimal newCpte_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(54,getCpte_t(),newCpte_t);
		else
			instanceExtension.markDirty(54);
		dataCacheEntry.setCpte_t(newCpte_t);
	}
	/**
	 * Get accessor for persistent attribute: cts_t
	 */
	public java.math.BigDecimal getCts_t() {
		return dataCacheEntry.getCts_t();
	}
	/**
	 * Set accessor for persistent attribute: cts_t
	 */
	public void setCts_t(java.math.BigDecimal newCts_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(55,getCts_t(),newCts_t);
		else
			instanceExtension.markDirty(55);
		dataCacheEntry.setCts_t(newCts_t);
	}
	/**
	 * Get accessor for persistent attribute: ctsd_t
	 */
	public java.math.BigDecimal getCtsd_t() {
		return dataCacheEntry.getCtsd_t();
	}
	/**
	 * Set accessor for persistent attribute: ctsd_t
	 */
	public void setCtsd_t(java.math.BigDecimal newCtsd_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(56,getCtsd_t(),newCtsd_t);
		else
			instanceExtension.markDirty(56);
		dataCacheEntry.setCtsd_t(newCtsd_t);
	}
	/**
	 * Get accessor for persistent attribute: vip_t
	 */
	public java.math.BigDecimal getVip_t() {
		return dataCacheEntry.getVip_t();
	}
	/**
	 * Set accessor for persistent attribute: vip_t
	 */
	public void setVip_t(java.math.BigDecimal newVip_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(57,getVip_t(),newVip_t);
		else
			instanceExtension.markDirty(57);
		dataCacheEntry.setVip_t(newVip_t);
	}
	/**
	 * Get accessor for persistent attribute: dsct_t
	 */
	public java.math.BigDecimal getDsct_t() {
		return dataCacheEntry.getDsct_t();
	}
	/**
	 * Set accessor for persistent attribute: dsct_t
	 */
	public void setDsct_t(java.math.BigDecimal newDsct_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(58,getDsct_t(),newDsct_t);
		else
			instanceExtension.markDirty(58);
		dataCacheEntry.setDsct_t(newDsct_t);
	}
	/**
	 * Get accessor for persistent attribute: fcex_t
	 */
	public java.math.BigDecimal getFcex_t() {
		return dataCacheEntry.getFcex_t();
	}
	/**
	 * Set accessor for persistent attribute: fcex_t
	 */
	public void setFcex_t(java.math.BigDecimal newFcex_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(59,getFcex_t(),newFcex_t);
		else
			instanceExtension.markDirty(59);
		dataCacheEntry.setFcex_t(newFcex_t);
	}
	/**
	 * Get accessor for persistent attribute: fmut_t
	 */
	public java.math.BigDecimal getFmut_t() {
		return dataCacheEntry.getFmut_t();
	}
	/**
	 * Set accessor for persistent attribute: fmut_t
	 */
	public void setFmut_t(java.math.BigDecimal newFmut_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(60,getFmut_t(),newFmut_t);
		else
			instanceExtension.markDirty(60);
		dataCacheEntry.setFmut_t(newFmut_t);
	}
	/**
	 * Get accessor for persistent attribute: lcta_t
	 */
	public java.math.BigDecimal getLcta_t() {
		return dataCacheEntry.getLcta_t();
	}
	/**
	 * Set accessor for persistent attribute: lcta_t
	 */
	public void setLcta_t(java.math.BigDecimal newLcta_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(61,getLcta_t(),newLcta_t);
		else
			instanceExtension.markDirty(61);
		dataCacheEntry.setLcta_t(newLcta_t);
	}
	/**
	 * Get accessor for persistent attribute: leas_t
	 */
	public java.math.BigDecimal getLeas_t() {
		return dataCacheEntry.getLeas_t();
	}
	/**
	 * Set accessor for persistent attribute: leas_t
	 */
	public void setLeas_t(java.math.BigDecimal newLeas_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(62,getLeas_t(),newLeas_t);
		else
			instanceExtension.markDirty(62);
		dataCacheEntry.setLeas_t(newLeas_t);
	}
	/**
	 * Get accessor for persistent attribute: mcla_t
	 */
	public java.math.BigDecimal getMcla_t() {
		return dataCacheEntry.getMcla_t();
	}
	/**
	 * Set accessor for persistent attribute: mcla_t
	 */
	public void setMcla_t(java.math.BigDecimal newMcla_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(63,getMcla_t(),newMcla_t);
		else
			instanceExtension.markDirty(63);
		dataCacheEntry.setMcla_t(newMcla_t);
	}
	/**
	 * Get accessor for persistent attribute: moro_t
	 */
	public java.math.BigDecimal getMoro_t() {
		return dataCacheEntry.getMoro_t();
	}
	/**
	 * Set accessor for persistent attribute: moro_t
	 */
	public void setMoro_t(java.math.BigDecimal newMoro_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(64,getMoro_t(),newMoro_t);
		else
			instanceExtension.markDirty(64);
		dataCacheEntry.setMoro_t(newMoro_t);
	}
	/**
	 * Get accessor for persistent attribute: mp_t
	 */
	public java.math.BigDecimal getMp_t() {
		return dataCacheEntry.getMp_t();
	}
	/**
	 * Set accessor for persistent attribute: mp_t
	 */
	public void setMp_t(java.math.BigDecimal newMp_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(65,getMp_t(),newMp_t);
		else
			instanceExtension.markDirty(65);
		dataCacheEntry.setMp_t(newMp_t);
	}
	/**
	 * Get accessor for persistent attribute: paut_t
	 */
	public java.math.BigDecimal getPaut_t() {
		return dataCacheEntry.getPaut_t();
	}
	/**
	 * Set accessor for persistent attribute: paut_t
	 */
	public void setPaut_t(java.math.BigDecimal newPaut_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(66,getPaut_t(),newPaut_t);
		else
			instanceExtension.markDirty(66);
		dataCacheEntry.setPaut_t(newPaut_t);
	}
	/**
	 * Get accessor for persistent attribute: pcom_t
	 */
	public java.math.BigDecimal getPcom_t() {
		return dataCacheEntry.getPcom_t();
	}
	/**
	 * Set accessor for persistent attribute: pcom_t
	 */
	public void setPcom_t(java.math.BigDecimal newPcom_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(67,getPcom_t(),newPcom_t);
		else
			instanceExtension.markDirty(67);
		dataCacheEntry.setPcom_t(newPcom_t);
	}
	/**
	 * Get accessor for persistent attribute: per_t
	 */
	public java.math.BigDecimal getPer_t() {
		return dataCacheEntry.getPer_t();
	}
	/**
	 * Set accessor for persistent attribute: per_t
	 */
	public void setPer_t(java.math.BigDecimal newPer_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(68,getPer_t(),newPer_t);
		else
			instanceExtension.markDirty(68);
		dataCacheEntry.setPer_t(newPer_t);
	}
	/**
	 * Get accessor for persistent attribute: ph_t
	 */
	public java.math.BigDecimal getPh_t() {
		return dataCacheEntry.getPh_t();
	}
	/**
	 * Set accessor for persistent attribute: ph_t
	 */
	public void setPh_t(java.math.BigDecimal newPh_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(69,getPh_t(),newPh_t);
		else
			instanceExtension.markDirty(69);
		dataCacheEntry.setPh_t(newPh_t);
	}
	/**
	 * Get accessor for persistent attribute: phip_t
	 */
	public java.math.BigDecimal getPhip_t() {
		return dataCacheEntry.getPhip_t();
	}
	/**
	 * Set accessor for persistent attribute: phip_t
	 */
	public void setPhip_t(java.math.BigDecimal newPhip_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(70,getPhip_t(),newPhip_t);
		else
			instanceExtension.markDirty(70);
		dataCacheEntry.setPhip_t(newPhip_t);
	}
	/**
	 * Get accessor for persistent attribute: plzo_t
	 */
	public java.math.BigDecimal getPlzo_t() {
		return dataCacheEntry.getPlzo_t();
	}
	/**
	 * Set accessor for persistent attribute: plzo_t
	 */
	public void setPlzo_t(java.math.BigDecimal newPlzo_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(71,getPlzo_t(),newPlzo_t);
		else
			instanceExtension.markDirty(71);
		dataCacheEntry.setPlzo_t(newPlzo_t);
	}
	/**
	 * Get accessor for persistent attribute: pmas_t
	 */
	public java.math.BigDecimal getPmas_t() {
		return dataCacheEntry.getPmas_t();
	}
	/**
	 * Set accessor for persistent attribute: pmas_t
	 */
	public void setPmas_t(java.math.BigDecimal newPmas_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(72,getPmas_t(),newPmas_t);
		else
			instanceExtension.markDirty(72);
		dataCacheEntry.setPmas_t(newPmas_t);
	}
	/**
	 * Get accessor for persistent attribute: pmiv_t
	 */
	public java.math.BigDecimal getPmiv_t() {
		return dataCacheEntry.getPmiv_t();
	}
	/**
	 * Set accessor for persistent attribute: pmiv_t
	 */
	public void setPmiv_t(java.math.BigDecimal newPmiv_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(73,getPmiv_t(),newPmiv_t);
		else
			instanceExtension.markDirty(73);
		dataCacheEntry.setPmiv_t(newPmiv_t);
	}
	/**
	 * Get accessor for persistent attribute: pper_t
	 */
	public java.math.BigDecimal getPper_t() {
		return dataCacheEntry.getPper_t();
	}
	/**
	 * Set accessor for persistent attribute: pper_t
	 */
	public void setPper_t(java.math.BigDecimal newPper_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(74,getPper_t(),newPper_t);
		else
			instanceExtension.markDirty(74);
		dataCacheEntry.setPper_t(newPper_t);
	}
	/**
	 * Get accessor for persistent attribute: ppper_t
	 */
	public java.math.BigDecimal getPpper_t() {
		return dataCacheEntry.getPpper_t();
	}
	/**
	 * Set accessor for persistent attribute: ppper_t
	 */
	public void setPpper_t(java.math.BigDecimal newPpper_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(75,getPpper_t(),newPpper_t);
		else
			instanceExtension.markDirty(75);
		dataCacheEntry.setPpper_t(newPpper_t);
	}
	/**
	 * Get accessor for persistent attribute: pref_t
	 */
	public java.math.BigDecimal getPref_t() {
		return dataCacheEntry.getPref_t();
	}
	/**
	 * Set accessor for persistent attribute: pref_t
	 */
	public void setPref_t(java.math.BigDecimal newPref_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(76,getPref_t(),newPref_t);
		else
			instanceExtension.markDirty(76);
		dataCacheEntry.setPref_t(newPref_t);
	}
	/**
	 * Get accessor for persistent attribute: prom_t
	 */
	public java.math.BigDecimal getProm_t() {
		return dataCacheEntry.getProm_t();
	}
	/**
	 * Set accessor for persistent attribute: prom_t
	 */
	public void setProm_t(java.math.BigDecimal newProm_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(77,getProm_t(),newProm_t);
		else
			instanceExtension.markDirty(77);
		dataCacheEntry.setProm_t(newProm_t);
	}
	/**
	 * Get accessor for persistent attribute: pser_t
	 */
	public java.math.BigDecimal getPser_t() {
		return dataCacheEntry.getPser_t();
	}
	/**
	 * Set accessor for persistent attribute: pser_t
	 */
	public void setPser_t(java.math.BigDecimal newPser_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(78,getPser_t(),newPser_t);
		else
			instanceExtension.markDirty(78);
		dataCacheEntry.setPser_t(newPser_t);
	}
	/**
	 * Get accessor for persistent attribute: pserv_t
	 */
	public java.math.BigDecimal getPserv_t() {
		return dataCacheEntry.getPserv_t();
	}
	/**
	 * Set accessor for persistent attribute: pserv_t
	 */
	public void setPserv_t(java.math.BigDecimal newPserv_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(79,getPserv_t(),newPserv_t);
		else
			instanceExtension.markDirty(79);
		dataCacheEntry.setPserv_t(newPserv_t);
	}
	/**
	 * Get accessor for persistent attribute: dep_t
	 */
	public java.math.BigDecimal getDep_t() {
		return dataCacheEntry.getDep_t();
	}
	/**
	 * Set accessor for persistent attribute: dep_t
	 */
	public void setDep_t(java.math.BigDecimal newDep_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(80,getDep_t(),newDep_t);
		else
			instanceExtension.markDirty(80);
		dataCacheEntry.setDep_t(newDep_t);
	}
	/**
	 * Get accessor for persistent attribute: sdep_t
	 */
	public java.math.BigDecimal getSdep_t() {
		return dataCacheEntry.getSdep_t();
	}
	/**
	 * Set accessor for persistent attribute: sdep_t
	 */
	public void setSdep_t(java.math.BigDecimal newSdep_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(81,getSdep_t(),newSdep_t);
		else
			instanceExtension.markDirty(81);
		dataCacheEntry.setSdep_t(newSdep_t);
	}
	/**
	 * Get accessor for persistent attribute: sext_t
	 */
	public java.math.BigDecimal getSext_t() {
		return dataCacheEntry.getSext_t();
	}
	/**
	 * Set accessor for persistent attribute: sext_t
	 */
	public void setSext_t(java.math.BigDecimal newSext_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(82,getSext_t(),newSext_t);
		else
			instanceExtension.markDirty(82);
		dataCacheEntry.setSext_t(newSext_t);
	}
	/**
	 * Get accessor for persistent attribute: sonc_t
	 */
	public java.math.BigDecimal getSonc_t() {
		return dataCacheEntry.getSonc_t();
	}
	/**
	 * Set accessor for persistent attribute: sonc_t
	 */
	public void setSonc_t(java.math.BigDecimal newSonc_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(83,getSonc_t(),newSonc_t);
		else
			instanceExtension.markDirty(83);
		dataCacheEntry.setSonc_t(newSonc_t);
	}
	/**
	 * Get accessor for persistent attribute: spro_t
	 */
	public java.math.BigDecimal getSpro_t() {
		return dataCacheEntry.getSpro_t();
	}
	/**
	 * Set accessor for persistent attribute: spro_t
	 */
	public void setSpro_t(java.math.BigDecimal newSpro_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(84,getSpro_t(),newSpro_t);
		else
			instanceExtension.markDirty(84);
		dataCacheEntry.setSpro_t(newSpro_t);
	}
	/**
	 * Get accessor for persistent attribute: vid_t
	 */
	public java.math.BigDecimal getVid_t() {
		return dataCacheEntry.getVid_t();
	}
	/**
	 * Set accessor for persistent attribute: vid_t
	 */
	public void setVid_t(java.math.BigDecimal newVid_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(85,getVid_t(),newVid_t);
		else
			instanceExtension.markDirty(85);
		dataCacheEntry.setVid_t(newVid_t);
	}
	/**
	 * Get accessor for persistent attribute: svid_t
	 */
	public java.math.BigDecimal getSvid_t() {
		return dataCacheEntry.getSvid_t();
	}
	/**
	 * Set accessor for persistent attribute: svid_t
	 */
	public void setSvid_t(java.math.BigDecimal newSvid_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(86,getSvid_t(),newSvid_t);
		else
			instanceExtension.markDirty(86);
		dataCacheEntry.setSvid_t(newSvid_t);
	}
	/**
	 * Get accessor for persistent attribute: tde_t
	 */
	public java.math.BigDecimal getTde_t() {
		return dataCacheEntry.getTde_t();
	}
	/**
	 * Set accessor for persistent attribute: tde_t
	 */
	public void setTde_t(java.math.BigDecimal newTde_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(87,getTde_t(),newTde_t);
		else
			instanceExtension.markDirty(87);
		dataCacheEntry.setTde_t(newTde_t);
	}
	/**
	 * Get accessor for persistent attribute: svip_t
	 */
	public java.math.BigDecimal getSvip_t() {
		return dataCacheEntry.getSvip_t();
	}
	/**
	 * Set accessor for persistent attribute: svip_t
	 */
	public void setSvip_t(java.math.BigDecimal newSvip_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(88,getSvip_t(),newSvip_t);
		else
			instanceExtension.markDirty(88);
		dataCacheEntry.setSvip_t(newSvip_t);
	}
	/**
	 * Get accessor for persistent attribute: tvip_t
	 */
	public java.math.BigDecimal getTvip_t() {
		return dataCacheEntry.getTvip_t();
	}
	/**
	 * Set accessor for persistent attribute: tvip_t
	 */
	public void setTvip_t(java.math.BigDecimal newTvip_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(89,getTvip_t(),newTvip_t);
		else
			instanceExtension.markDirty(89);
		dataCacheEntry.setTvip_t(newTvip_t);
	}
	/**
	 * Get accessor for persistent attribute: varc_t
	 */
	public java.math.BigDecimal getVarc_t() {
		return dataCacheEntry.getVarc_t();
	}
	/**
	 * Set accessor for persistent attribute: varc_t
	 */
	public void setVarc_t(java.math.BigDecimal newVarc_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(90,getVarc_t(),newVarc_t);
		else
			instanceExtension.markDirty(90);
		dataCacheEntry.setVarc_t(newVarc_t);
	}
	/**
	 * Get accessor for persistent attribute: vcla_t
	 */
	public java.math.BigDecimal getVcla_t() {
		return dataCacheEntry.getVcla_t();
	}
	/**
	 * Set accessor for persistent attribute: vcla_t
	 */
	public void setVcla_t(java.math.BigDecimal newVcla_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(91,getVcla_t(),newVcla_t);
		else
			instanceExtension.markDirty(91);
		dataCacheEntry.setVcla_t(newVcla_t);
	}
	/**
	 * Get accessor for persistent attribute: vctr_t
	 */
	public java.math.BigDecimal getVctr_t() {
		return dataCacheEntry.getVctr_t();
	}
	/**
	 * Set accessor for persistent attribute: vctr_t
	 */
	public void setVctr_t(java.math.BigDecimal newVctr_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(92,getVctr_t(),newVctr_t);
		else
			instanceExtension.markDirty(92);
		dataCacheEntry.setVctr_t(newVctr_t);
	}
	/**
	 * Get accessor for persistent attribute: vemp_t
	 */
	public java.math.BigDecimal getVemp_t() {
		return dataCacheEntry.getVemp_t();
	}
	/**
	 * Set accessor for persistent attribute: vemp_t
	 */
	public void setVemp_t(java.math.BigDecimal newVemp_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(93,getVemp_t(),newVemp_t);
		else
			instanceExtension.markDirty(93);
		dataCacheEntry.setVemp_t(newVemp_t);
	}
	/**
	 * Get accessor for persistent attribute: vnac_t
	 */
	public java.math.BigDecimal getVnac_t() {
		return dataCacheEntry.getVnac_t();
	}
	/**
	 * Set accessor for persistent attribute: vnac_t
	 */
	public void setVnac_t(java.math.BigDecimal newVnac_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(94,getVnac_t(),newVnac_t);
		else
			instanceExtension.markDirty(94);
		dataCacheEntry.setVnac_t(newVnac_t);
	}
	/**
	 * Get accessor for persistent attribute: voro_t
	 */
	public java.math.BigDecimal getVoro_t() {
		return dataCacheEntry.getVoro_t();
	}
	/**
	 * Set accessor for persistent attribute: voro_t
	 */
	public void setVoro_t(java.math.BigDecimal newVoro_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(95,getVoro_t(),newVoro_t);
		else
			instanceExtension.markDirty(95);
		dataCacheEntry.setVoro_t(newVoro_t);
	}
	/**
	 * Get accessor for persistent attribute: vpla_t
	 */
	public java.math.BigDecimal getVpla_t() {
		return dataCacheEntry.getVpla_t();
	}
	/**
	 * Set accessor for persistent attribute: vpla_t
	 */
	public void setVpla_t(java.math.BigDecimal newVpla_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(96,getVpla_t(),newVpla_t);
		else
			instanceExtension.markDirty(96);
		dataCacheEntry.setVpla_t(newVpla_t);
	}
	/**
	 * Get accessor for persistent attribute: vpola_t
	 */
	public java.math.BigDecimal getVpola_t() {
		return dataCacheEntry.getVpola_t();
	}
	/**
	 * Set accessor for persistent attribute: vpola_t
	 */
	public void setVpola_t(java.math.BigDecimal newVpola_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(97,getVpola_t(),newVpola_t);
		else
			instanceExtension.markDirty(97);
		dataCacheEntry.setVpola_t(newVpola_t);
	}
	/**
	 * Get accessor for persistent attribute: vrep_t
	 */
	public java.math.BigDecimal getVrep_t() {
		return dataCacheEntry.getVrep_t();
	}
	/**
	 * Set accessor for persistent attribute: vrep_t
	 */
	public void setVrep_t(java.math.BigDecimal newVrep_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(98,getVrep_t(),newVrep_t);
		else
			instanceExtension.markDirty(98);
		dataCacheEntry.setVrep_t(newVrep_t);
	}
	/**
	 * Get accessor for persistent attribute: tdeb_t
	 */
	public java.math.BigDecimal getTdeb_t() {
		return dataCacheEntry.getTdeb_t();
	}
	/**
	 * Set accessor for persistent attribute: tdeb_t
	 */
	public void setTdeb_t(java.math.BigDecimal newTdeb_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(99,getTdeb_t(),newTdeb_t);
		else
			instanceExtension.markDirty(99);
		dataCacheEntry.setTdeb_t(newTdeb_t);
	}
	/**
	 * Get accessor for persistent attribute: cnet_t
	 */
	public java.math.BigDecimal getCnet_t() {
		return dataCacheEntry.getCnet_t();
	}
	/**
	 * Set accessor for persistent attribute: cnet_t
	 */
	public void setCnet_t(java.math.BigDecimal newCnet_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(100,getCnet_t(),newCnet_t);
		else
			instanceExtension.markDirty(100);
		dataCacheEntry.setCnet_t(newCnet_t);
	}
	/**
	 * Get accessor for persistent attribute: linco_t
	 */
	public java.math.BigDecimal getLinco_t() {
		return dataCacheEntry.getLinco_t();
	}
	/**
	 * Set accessor for persistent attribute: linco_t
	 */
	public void setLinco_t(java.math.BigDecimal newLinco_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(101,getLinco_t(),newLinco_t);
		else
			instanceExtension.markDirty(101);
		dataCacheEntry.setLinco_t(newLinco_t);
	}
	/**
	 * Get accessor for persistent attribute: pos_t
	 */
	public java.math.BigDecimal getPos_t() {
		return dataCacheEntry.getPos_t();
	}
	/**
	 * Set accessor for persistent attribute: pos_t
	 */
	public void setPos_t(java.math.BigDecimal newPos_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(102,getPos_t(),newPos_t);
		else
			instanceExtension.markDirty(102);
		dataCacheEntry.setPos_t(newPos_t);
	}
	/**
	 * Get accessor for persistent attribute: emph_t
	 */
	public java.math.BigDecimal getEmph_t() {
		return dataCacheEntry.getEmph_t();
	}
	/**
	 * Set accessor for persistent attribute: emph_t
	 */
	public void setEmph_t(java.math.BigDecimal newEmph_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(103,getEmph_t(),newEmph_t);
		else
			instanceExtension.markDirty(103);
		dataCacheEntry.setEmph_t(newEmph_t);
	}
	/**
	 * Get accessor for persistent attribute: riesgo_d_t
	 */
	public java.math.BigDecimal getRiesgo_d_t() {
		return dataCacheEntry.getRiesgo_d_t();
	}
	/**
	 * Set accessor for persistent attribute: riesgo_d_t
	 */
	public void setRiesgo_d_t(java.math.BigDecimal newRiesgo_d_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(104,getRiesgo_d_t(),newRiesgo_d_t);
		else
			instanceExtension.markDirty(104);
		dataCacheEntry.setRiesgo_d_t(newRiesgo_d_t);
	}
	/**
	 * Get accessor for persistent attribute: riesgo_i_t
	 */
	public java.math.BigDecimal getRiesgo_i_t() {
		return dataCacheEntry.getRiesgo_i_t();
	}
	/**
	 * Set accessor for persistent attribute: riesgo_i_t
	 */
	public void setRiesgo_i_t(java.math.BigDecimal newRiesgo_i_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(105,getRiesgo_i_t(),newRiesgo_i_t);
		else
			instanceExtension.markDirty(105);
		dataCacheEntry.setRiesgo_i_t(newRiesgo_i_t);
	}
	/**
	 * Get accessor for persistent attribute: riesgo_t
	 */
	public java.math.BigDecimal getRiesgo_t() {
		return dataCacheEntry.getRiesgo_t();
	}
	/**
	 * Set accessor for persistent attribute: riesgo_t
	 */
	public void setRiesgo_t(java.math.BigDecimal newRiesgo_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(106,getRiesgo_t(),newRiesgo_t);
		else
			instanceExtension.markDirty(106);
		dataCacheEntry.setRiesgo_t(newRiesgo_t);
	}
	/**
	 * Get accessor for persistent attribute: pasivo_t
	 */
	public java.math.BigDecimal getPasivo_t() {
		return dataCacheEntry.getPasivo_t();
	}
	/**
	 * Set accessor for persistent attribute: pasivo_t
	 */
	public void setPasivo_t(java.math.BigDecimal newPasivo_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(107,getPasivo_t(),newPasivo_t);
		else
			instanceExtension.markDirty(107);
		dataCacheEntry.setPasivo_t(newPasivo_t);
	}
	/**
	 * Get accessor for persistent attribute: volumen_t
	 */
	public java.math.BigDecimal getVolumen_t() {
		return dataCacheEntry.getVolumen_t();
	}
	/**
	 * Set accessor for persistent attribute: volumen_t
	 */
	public void setVolumen_t(java.math.BigDecimal newVolumen_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(108,getVolumen_t(),newVolumen_t);
		else
			instanceExtension.markDirty(108);
		dataCacheEntry.setVolumen_t(newVolumen_t);
	}
	/**
	 * Get accessor for persistent attribute: sum_t_act
	 */
	public java.math.BigDecimal getSum_t_act() {
		return dataCacheEntry.getSum_t_act();
	}
	/**
	 * Set accessor for persistent attribute: sum_t_act
	 */
	public void setSum_t_act(java.math.BigDecimal newSum_t_act) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(109,getSum_t_act(),newSum_t_act);
		else
			instanceExtension.markDirty(109);
		dataCacheEntry.setSum_t_act(newSum_t_act);
	}
	/**
	 * Get accessor for persistent attribute: sum_t_act1
	 */
	public java.math.BigDecimal getSum_t_act1() {
		return dataCacheEntry.getSum_t_act1();
	}
	/**
	 * Set accessor for persistent attribute: sum_t_act1
	 */
	public void setSum_t_act1(java.math.BigDecimal newSum_t_act1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(110,getSum_t_act1(),newSum_t_act1);
		else
			instanceExtension.markDirty(110);
		dataCacheEntry.setSum_t_act1(newSum_t_act1);
	}
	/**
	 * Get accessor for persistent attribute: sum_t_act2
	 */
	public java.math.BigDecimal getSum_t_act2() {
		return dataCacheEntry.getSum_t_act2();
	}
	/**
	 * Set accessor for persistent attribute: sum_t_act2
	 */
	public void setSum_t_act2(java.math.BigDecimal newSum_t_act2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(111,getSum_t_act2(),newSum_t_act2);
		else
			instanceExtension.markDirty(111);
		dataCacheEntry.setSum_t_act2(newSum_t_act2);
	}
	/**
	 * Get accessor for persistent attribute: sum_t_act3
	 */
	public java.math.BigDecimal getSum_t_act3() {
		return dataCacheEntry.getSum_t_act3();
	}
	/**
	 * Set accessor for persistent attribute: sum_t_act3
	 */
	public void setSum_t_act3(java.math.BigDecimal newSum_t_act3) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(112,getSum_t_act3(),newSum_t_act3);
		else
			instanceExtension.markDirty(112);
		dataCacheEntry.setSum_t_act3(newSum_t_act3);
	}
	/**
	 * Get accessor for persistent attribute: sum_t_act4
	 */
	public java.math.BigDecimal getSum_t_act4() {
		return dataCacheEntry.getSum_t_act4();
	}
	/**
	 * Set accessor for persistent attribute: sum_t_act4
	 */
	public void setSum_t_act4(java.math.BigDecimal newSum_t_act4) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(113,getSum_t_act4(),newSum_t_act4);
		else
			instanceExtension.markDirty(113);
		dataCacheEntry.setSum_t_act4(newSum_t_act4);
	}
	/**
	 * Get accessor for persistent attribute: sum_t_act5
	 */
	public java.math.BigDecimal getSum_t_act5() {
		return dataCacheEntry.getSum_t_act5();
	}
	/**
	 * Set accessor for persistent attribute: sum_t_act5
	 */
	public void setSum_t_act5(java.math.BigDecimal newSum_t_act5) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(114,getSum_t_act5(),newSum_t_act5);
		else
			instanceExtension.markDirty(114);
		dataCacheEntry.setSum_t_act5(newSum_t_act5);
	}
	/**
	 * Get accessor for persistent attribute: sum_t_act6
	 */
	public java.math.BigDecimal getSum_t_act6() {
		return dataCacheEntry.getSum_t_act6();
	}
	/**
	 * Set accessor for persistent attribute: sum_t_act6
	 */
	public void setSum_t_act6(java.math.BigDecimal newSum_t_act6) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(115,getSum_t_act6(),newSum_t_act6);
		else
			instanceExtension.markDirty(115);
		dataCacheEntry.setSum_t_act6(newSum_t_act6);
	}
	/**
	 * Get accessor for persistent attribute: sum_act_cto
	 */
	public java.math.BigDecimal getSum_act_cto() {
		return dataCacheEntry.getSum_act_cto();
	}
	/**
	 * Set accessor for persistent attribute: sum_act_cto
	 */
	public void setSum_act_cto(java.math.BigDecimal newSum_act_cto) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(116,getSum_act_cto(),newSum_act_cto);
		else
			instanceExtension.markDirty(116);
		dataCacheEntry.setSum_act_cto(newSum_act_cto);
	}
	/**
	 * Get accessor for persistent attribute: sum_act_ct1
	 */
	public java.math.BigDecimal getSum_act_ct1() {
		return dataCacheEntry.getSum_act_ct1();
	}
	/**
	 * Set accessor for persistent attribute: sum_act_ct1
	 */
	public void setSum_act_ct1(java.math.BigDecimal newSum_act_ct1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(117,getSum_act_ct1(),newSum_act_ct1);
		else
			instanceExtension.markDirty(117);
		dataCacheEntry.setSum_act_ct1(newSum_act_ct1);
	}
	/**
	 * Get accessor for persistent attribute: sum_act_ct2
	 */
	public java.math.BigDecimal getSum_act_ct2() {
		return dataCacheEntry.getSum_act_ct2();
	}
	/**
	 * Set accessor for persistent attribute: sum_act_ct2
	 */
	public void setSum_act_ct2(java.math.BigDecimal newSum_act_ct2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(118,getSum_act_ct2(),newSum_act_ct2);
		else
			instanceExtension.markDirty(118);
		dataCacheEntry.setSum_act_ct2(newSum_act_ct2);
	}
	/**
	 * Get accessor for persistent attribute: sum_act_ct3
	 */
	public java.math.BigDecimal getSum_act_ct3() {
		return dataCacheEntry.getSum_act_ct3();
	}
	/**
	 * Set accessor for persistent attribute: sum_act_ct3
	 */
	public void setSum_act_ct3(java.math.BigDecimal newSum_act_ct3) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(119,getSum_act_ct3(),newSum_act_ct3);
		else
			instanceExtension.markDirty(119);
		dataCacheEntry.setSum_act_ct3(newSum_act_ct3);
	}
	/**
	 * Get accessor for persistent attribute: sum_act_ct4
	 */
	public java.math.BigDecimal getSum_act_ct4() {
		return dataCacheEntry.getSum_act_ct4();
	}
	/**
	 * Set accessor for persistent attribute: sum_act_ct4
	 */
	public void setSum_act_ct4(java.math.BigDecimal newSum_act_ct4) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(120,getSum_act_ct4(),newSum_act_ct4);
		else
			instanceExtension.markDirty(120);
		dataCacheEntry.setSum_act_ct4(newSum_act_ct4);
	}
	/**
	 * Get accessor for persistent attribute: sum_act_ct5
	 */
	public java.math.BigDecimal getSum_act_ct5() {
		return dataCacheEntry.getSum_act_ct5();
	}
	/**
	 * Set accessor for persistent attribute: sum_act_ct5
	 */
	public void setSum_act_ct5(java.math.BigDecimal newSum_act_ct5) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(121,getSum_act_ct5(),newSum_act_ct5);
		else
			instanceExtension.markDirty(121);
		dataCacheEntry.setSum_act_ct5(newSum_act_ct5);
	}
	/**
	 * Get accessor for persistent attribute: sum_act_ct6
	 */
	public java.math.BigDecimal getSum_act_ct6() {
		return dataCacheEntry.getSum_act_ct6();
	}
	/**
	 * Set accessor for persistent attribute: sum_act_ct6
	 */
	public void setSum_act_ct6(java.math.BigDecimal newSum_act_ct6) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(122,getSum_act_ct6(),newSum_act_ct6);
		else
			instanceExtension.markDirty(122);
		dataCacheEntry.setSum_act_ct6(newSum_act_ct6);
	}
	/**
	 * Get accessor for persistent attribute: cemp_t
	 */
	public java.math.BigDecimal getCemp_t() {
		return dataCacheEntry.getCemp_t();
	}
	/**
	 * Set accessor for persistent attribute: cemp_t
	 */
	public void setCemp_t(java.math.BigDecimal newCemp_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(123,getCemp_t(),newCemp_t);
		else
			instanceExtension.markDirty(123);
		dataCacheEntry.setCemp_t(newCemp_t);
	}
	/**
	 * Get accessor for persistent attribute: cvip_t
	 */
	public java.math.BigDecimal getCvip_t() {
		return dataCacheEntry.getCvip_t();
	}
	/**
	 * Set accessor for persistent attribute: cvip_t
	 */
	public void setCvip_t(java.math.BigDecimal newCvip_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(124,getCvip_t(),newCvip_t);
		else
			instanceExtension.markDirty(124);
		dataCacheEntry.setCvip_t(newCvip_t);
	}
	/**
	 * Get accessor for persistent attribute: icalicte00
	 */
	public java.math.BigDecimal getIcalicte00() {
		return dataCacheEntry.getIcalicte00();
	}
	/**
	 * Set accessor for persistent attribute: icalicte00
	 */
	public void setIcalicte00(java.math.BigDecimal newIcalicte00) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(125,getIcalicte00(),newIcalicte00);
		else
			instanceExtension.markDirty(125);
		dataCacheEntry.setIcalicte00(newIcalicte00);
	}
	/**
	 * Get accessor for persistent attribute: icalicte10
	 */
	public java.math.BigDecimal getIcalicte10() {
		return dataCacheEntry.getIcalicte10();
	}
	/**
	 * Set accessor for persistent attribute: icalicte10
	 */
	public void setIcalicte10(java.math.BigDecimal newIcalicte10) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(126,getIcalicte10(),newIcalicte10);
		else
			instanceExtension.markDirty(126);
		dataCacheEntry.setIcalicte10(newIcalicte10);
	}
	/**
	 * Get accessor for persistent attribute: icalicte20
	 */
	public java.math.BigDecimal getIcalicte20() {
		return dataCacheEntry.getIcalicte20();
	}
	/**
	 * Set accessor for persistent attribute: icalicte20
	 */
	public void setIcalicte20(java.math.BigDecimal newIcalicte20) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(127,getIcalicte20(),newIcalicte20);
		else
			instanceExtension.markDirty(127);
		dataCacheEntry.setIcalicte20(newIcalicte20);
	}
	/**
	 * Get accessor for persistent attribute: icalicte30
	 */
	public java.math.BigDecimal getIcalicte30() {
		return dataCacheEntry.getIcalicte30();
	}
	/**
	 * Set accessor for persistent attribute: icalicte30
	 */
	public void setIcalicte30(java.math.BigDecimal newIcalicte30) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(128,getIcalicte30(),newIcalicte30);
		else
			instanceExtension.markDirty(128);
		dataCacheEntry.setIcalicte30(newIcalicte30);
	}
	/**
	 * Get accessor for persistent attribute: icalicte40
	 */
	public java.math.BigDecimal getIcalicte40() {
		return dataCacheEntry.getIcalicte40();
	}
	/**
	 * Set accessor for persistent attribute: icalicte40
	 */
	public void setIcalicte40(java.math.BigDecimal newIcalicte40) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(129,getIcalicte40(),newIcalicte40);
		else
			instanceExtension.markDirty(129);
		dataCacheEntry.setIcalicte40(newIcalicte40);
	}
	/**
	 * Get accessor for persistent attribute: mofactv_t
	 */
	public java.math.BigDecimal getMofactv_t() {
		return dataCacheEntry.getMofactv_t();
	}
	/**
	 * Set accessor for persistent attribute: mofactv_t
	 */
	public void setMofactv_t(java.math.BigDecimal newMofactv_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(130,getMofactv_t(),newMofactv_t);
		else
			instanceExtension.markDirty(130);
		dataCacheEntry.setMofactv_t(newMofactv_t);
	}
	/**
	 * Get accessor for persistent attribute: cs000lineamaxtc_t
	 */
	public java.math.BigDecimal getCs000lineamaxtc_t() {
		return dataCacheEntry.getCs000lineamaxtc_t();
	}
	/**
	 * Set accessor for persistent attribute: cs000lineamaxtc_t
	 */
	public void setCs000lineamaxtc_t(java.math.BigDecimal newCs000lineamaxtc_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(131,getCs000lineamaxtc_t(),newCs000lineamaxtc_t);
		else
			instanceExtension.markDirty(131);
		dataCacheEntry.setCs000lineamaxtc_t(newCs000lineamaxtc_t);
	}
	/**
	 * Get accessor for persistent attribute: cs000mtoprestamo_t
	 */
	public java.math.BigDecimal getCs000mtoprestamo_t() {
		return dataCacheEntry.getCs000mtoprestamo_t();
	}
	/**
	 * Set accessor for persistent attribute: cs000mtoprestamo_t
	 */
	public void setCs000mtoprestamo_t(java.math.BigDecimal newCs000mtoprestamo_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(132,getCs000mtoprestamo_t(),newCs000mtoprestamo_t);
		else
			instanceExtension.markDirty(132);
		dataCacheEntry.setCs000mtoprestamo_t(newCs000mtoprestamo_t);
	}
	/**
	 * Get accessor for persistent attribute: montovehicular_t
	 */
	public java.math.BigDecimal getMontovehicular_t() {
		return dataCacheEntry.getMontovehicular_t();
	}
	/**
	 * Set accessor for persistent attribute: montovehicular_t
	 */
	public void setMontovehicular_t(java.math.BigDecimal newMontovehicular_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(133,getMontovehicular_t(),newMontovehicular_t);
		else
			instanceExtension.markDirty(133);
		dataCacheEntry.setMontovehicular_t(newMontovehicular_t);
	}
	/**
	 * Get accessor for persistent attribute: montohipotecario_t
	 */
	public java.math.BigDecimal getMontohipotecario_t() {
		return dataCacheEntry.getMontohipotecario_t();
	}
	/**
	 * Set accessor for persistent attribute: montohipotecario_t
	 */
	public void setMontohipotecario_t(java.math.BigDecimal newMontohipotecario_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(134,getMontohipotecario_t(),newMontohipotecario_t);
		else
			instanceExtension.markDirty(134);
		dataCacheEntry.setMontohipotecario_t(newMontohipotecario_t);
	}
	/**
	 * Get accessor for persistent attribute: montosubrogados_t
	 */
	public java.math.BigDecimal getMontosubrogados_t() {
		return dataCacheEntry.getMontosubrogados_t();
	}
	/**
	 * Set accessor for persistent attribute: montosubrogados_t
	 */
	public void setMontosubrogados_t(java.math.BigDecimal newMontosubrogados_t) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(135,getMontosubrogados_t(),newMontosubrogados_t);
		else
			instanceExtension.markDirty(135);
		dataCacheEntry.setMontosubrogados_t(newMontosubrogados_t);
	}
}
