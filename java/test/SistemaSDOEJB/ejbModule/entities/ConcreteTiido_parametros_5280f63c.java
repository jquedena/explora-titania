package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_parametrosBeanCacheEntry_5280f63c;

/**
 * Bean implementation class for Enterprise Bean: Tiido_parametros
 */
public class ConcreteTiido_parametros_5280f63c extends entities.Tiido_parametrosBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private Tiido_parametrosBeanCacheEntry_5280f63c dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_parametros_5280f63c
	 */
	public ConcreteTiido_parametros_5280f63c() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_parametrosBeanInjector_5280f63c getInjector() {
		return (entities.websphere_deploy.Tiido_parametrosBeanInjector_5280f63c)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_parametrosBeanCacheEntry_5280f63c) inRecord;
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
	public entities.Tiido_parametrosKey ejbFindByPrimaryKey(entities.Tiido_parametrosKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_parametrosKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindParametroAll_Local
	 */
	public entities.Tiido_parametrosKey ejbFindParametroAll_Local() throws javax.ejb.FinderException {
		return (entities.Tiido_parametrosKey) instanceExtension.executeFind("FindParametroAll", null);
	}
	/**
	 * ejbFindAllParametros_Local
	 */
	public java.util.Collection ejbFindAllParametros_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAllParametros", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_parametrosKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_parametrosKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_parametrosKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_parametrosKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_parametrosKey ejbCreate(java.lang.String cod_parametro) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_parametrosBeanCacheEntry_5280f63c) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_parametro);
		return (entities.Tiido_parametrosKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String cod_parametro) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_parametro);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_parametrosKey pk = new entities.Tiido_parametrosKey();
		pk.cod_parametro = getCod_parametro();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 12;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_parametro
	 */
	public java.lang.String getCod_parametro() {
		return dataCacheEntry.getCod_parametro();
	}
	/**
	 * Set accessor for persistent attribute: cod_parametro
	 */
	public void setCod_parametro(java.lang.String newCod_parametro) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_parametro(),newCod_parametro);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_parametro(newCod_parametro);
	}
	/**
	 * Get accessor for persistent attribute: fec_acci
	 */
	public java.sql.Date getFec_acci() {
		return dataCacheEntry.getFec_acci();
	}
	/**
	 * Set accessor for persistent attribute: fec_acci
	 */
	public void setFec_acci(java.sql.Date newFec_acci) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getFec_acci(),newFec_acci);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setFec_acci(newFec_acci);
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
			instanceExtension.markDirty(2,getFec_segu_1(),newFec_segu_1);
		else
			instanceExtension.markDirty(2);
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
			instanceExtension.markDirty(3,getFec_segu_2(),newFec_segu_2);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setFec_segu_2(newFec_segu_2);
	}
	/**
	 * Get accessor for persistent attribute: afec_acci
	 */
	public java.lang.String getAfec_acci() {
		return dataCacheEntry.getAfec_acci();
	}
	/**
	 * Set accessor for persistent attribute: afec_acci
	 */
	public void setAfec_acci(java.lang.String newAfec_acci) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getAfec_acci(),newAfec_acci);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setAfec_acci(newAfec_acci);
	}
	/**
	 * Get accessor for persistent attribute: afec_segu
	 */
	public java.lang.String getAfec_segu() {
		return dataCacheEntry.getAfec_segu();
	}
	/**
	 * Set accessor for persistent attribute: afec_segu
	 */
	public void setAfec_segu(java.lang.String newAfec_segu) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getAfec_segu(),newAfec_segu);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setAfec_segu(newAfec_segu);
	}
	/**
	 * Get accessor for persistent attribute: afec_plan
	 */
	public java.lang.String getAfec_plan() {
		return dataCacheEntry.getAfec_plan();
	}
	/**
	 * Set accessor for persistent attribute: afec_plan
	 */
	public void setAfec_plan(java.lang.String newAfec_plan) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getAfec_plan(),newAfec_plan);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setAfec_plan(newAfec_plan);
	}
	/**
	 * Get accessor for persistent attribute: fec_plan
	 */
	public java.sql.Date getFec_plan() {
		return dataCacheEntry.getFec_plan();
	}
	/**
	 * Set accessor for persistent attribute: fec_plan
	 */
	public void setFec_plan(java.sql.Date newFec_plan) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getFec_plan(),newFec_plan);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setFec_plan(newFec_plan);
	}
	/**
	 * Get accessor for persistent attribute: tap_usu_regi
	 */
	public java.lang.String getTap_usu_regi() {
		return dataCacheEntry.getTap_usu_regi();
	}
	/**
	 * Set accessor for persistent attribute: tap_usu_regi
	 */
	public void setTap_usu_regi(java.lang.String newTap_usu_regi) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getTap_usu_regi(),newTap_usu_regi);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setTap_usu_regi(newTap_usu_regi);
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
			instanceExtension.markDirty(9,getFec_regi(),newFec_regi);
		else
			instanceExtension.markDirty(9);
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
			instanceExtension.markDirty(10,getUsu_actu(),newUsu_actu);
		else
			instanceExtension.markDirty(10);
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
			instanceExtension.markDirty(11,getFec_actu(),newFec_actu);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setFec_actu(newFec_actu);
	}
}
