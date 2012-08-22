package entities;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import entities.websphere_deploy.Tiido_planesBeanCacheEntry_f95fafaa;

/**
 * Bean implementation class for Enterprise Bean: Tiido_planes
 */
public class ConcreteTiido_planes_f95fafaa extends entities.Tiido_planesBean implements javax.ejb.EntityBean, ConcreteBeanWithLink, ConcreteBeanWithForwardLink {
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
	private Tiido_planesBeanCacheEntry_f95fafaa dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiido_planes_f95fafaa
	 */
	public ConcreteTiido_planes_f95fafaa() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private entities.websphere_deploy.Tiido_planesBeanInjector_f95fafaa getInjector() {
		return (entities.websphere_deploy.Tiido_planesBeanInjector_f95fafaa)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (entities.websphere_deploy.Tiido_planesBeanCacheEntry_f95fafaa) inRecord;
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
			tiido_pla_oficina_fkLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public entities.Tiido_planesKey ejbFindByPrimaryKey(entities.Tiido_planesKey primaryKey) throws javax.ejb.FinderException {
		return (entities.Tiido_planesKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindConsultaPlanesPrioridad_Local
	 */
	public entities.Tiido_planesKey ejbFindConsultaPlanesPrioridad_Local(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindConsultaPlanesPrioridad");
		getInjector().ejbFindConsultaPlanesPrioridad(mes, anho, codEpigrafe, codOficina, record);
		return (entities.Tiido_planesKey) instanceExtension.executeFind("FindConsultaPlanesPrioridad", record);
	}
	/**
	 * ejbFindConsultaPlanesResumen_Local
	 */
	public entities.Tiido_planesKey ejbFindConsultaPlanesResumen_Local(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindConsultaPlanesResumen");
		getInjector().ejbFindConsultaPlanesResumen(mes, anho, codEpigrafe, codOficina, record);
		return (entities.Tiido_planesKey) instanceExtension.executeFind("FindConsultaPlanesResumen", record);
	}
	/**
	 * ejbFindPlanByObject_Local
	 */
	public entities.Tiido_planesKey ejbFindPlanByObject_Local(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindPlanByObject");
		getInjector().ejbFindPlanByObject(mes, anho, codEpigrafe, codOficina, record);
		return (entities.Tiido_planesKey) instanceExtension.executeFind("FindPlanByObject", record);
	}
	/**
	 * ejbFindConsultaPlanes_Local
	 */
	public java.util.Collection ejbFindConsultaPlanes_Local(java.lang.String codOficina, java.lang.String anho, java.lang.String mes) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindConsultaPlanes");
		getInjector().ejbFindConsultaPlanes(codOficina, anho, mes, record);
		return (java.util.Collection) instanceExtension.executeFind("FindConsultaPlanes", record);
	}
	/**
	 * ejbFindConsultarPlanesxMes_Local
	 */
	public java.util.Collection ejbFindConsultarPlanesxMes_Local(java.lang.String codOficina, java.lang.String anho) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindConsultarPlanesxMes");
		getInjector().ejbFindConsultarPlanesxMes(codOficina, anho, record);
		return (java.util.Collection) instanceExtension.executeFind("FindConsultarPlanesxMes", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((entities.Tiido_planesKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public entities.Tiido_planesKey ejbFindByPrimaryKeyForCMR_Local(entities.Tiido_planesKey pk) throws javax.ejb.FinderException {
		return (entities.Tiido_planesKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_planesKey ejbCreate(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_planesBeanCacheEntry_f95fafaa) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(plan);
		return (entities.Tiido_planesKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws javax.ejb.CreateException {
		super.ejbPostCreate(plan);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_planesKey ejbCreate(java.lang.String mes_plan, java.lang.String anho_plan, java.lang.String cod_epigrafe, entities.Tiido_oficinaLocal argTiido_pla_oficina_fk) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_planesBeanCacheEntry_f95fafaa) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(mes_plan, anho_plan, cod_epigrafe, argTiido_pla_oficina_fk);
		return (entities.Tiido_planesKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String mes_plan, java.lang.String anho_plan, java.lang.String cod_epigrafe, entities.Tiido_oficinaLocal argTiido_pla_oficina_fk) throws javax.ejb.CreateException {
		super.ejbPostCreate(mes_plan, anho_plan, cod_epigrafe, argTiido_pla_oficina_fk);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_planesKey ejbCreate(java.lang.String mes_plan, java.lang.String anho_plan, java.lang.String cod_epigrafe, java.lang.String tiido_pla_oficina_fk_cod_ofic, java.lang.String tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiido_planesBeanCacheEntry_f95fafaa) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(mes_plan, anho_plan, cod_epigrafe, tiido_pla_oficina_fk_cod_ofic, tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
		return (entities.Tiido_planesKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String mes_plan, java.lang.String anho_plan, java.lang.String cod_epigrafe, java.lang.String tiido_pla_oficina_fk_cod_ofic, java.lang.String tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr) throws javax.ejb.CreateException {
		super.ejbPostCreate(mes_plan, anho_plan, cod_epigrafe, tiido_pla_oficina_fk_cod_ofic, tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		entities.Tiido_planesKey pk = new entities.Tiido_planesKey();
		pk.mes_plan = getMes_plan();
		pk.anho_plan = getAnho_plan();
		pk.cod_epigrafe = getCod_epigrafe();
		pk.tiido_pla_oficina_fk_cod_ofic = getTiido_pla_oficina_fk_cod_ofic();
		pk.tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr = getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 37;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("tiido_pla_oficina_fk")) return getTiido_pla_oficina_fkLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("tiido_pla_oficina_fk")){
			entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8 home = (entities.websphere_deploy.Tiido_oficinaBeanInternalLocalHome_30d934a8)instanceExtension.getHomeForLink("tiido_pla_oficina_fk");
		  return home.findByPrimaryKeyForCMR((entities.Tiido_oficinaKey)key);
		}
		return null;
	}
	/**
	 * getTiido_pla_oficina_fk
	 */
	public entities.Tiido_oficinaLocal getTiido_pla_oficina_fk() {
		return (entities.Tiido_oficinaLocal)getTiido_pla_oficina_fkLink().getValue();
	}
	/**
	 * setTiido_pla_oficina_fk
	 */
	public void setTiido_pla_oficina_fk(entities.Tiido_oficinaLocal value) {
		getTiido_pla_oficina_fkLink().setValue(value);
	}
	/**
	 * getTiido_pla_oficina_fkKey
	 */
	public entities.Tiido_oficinaKey getTiido_pla_oficina_fkKey() {
		if (tiido_pla_oficina_fkLink == null) return dataCacheEntry.getTiido_pla_oficina_fkKey();
		return (entities.Tiido_oficinaKey) tiido_pla_oficina_fkLink.getKey();
	}
	/**
	 * getTiido_pla_oficina_fkLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTiido_pla_oficina_fkLink() {
		if (tiido_pla_oficina_fkLink == null) 
		tiido_pla_oficina_fkLink = instanceExtension.createLink("tiido_pla_oficina_fk",dataCacheEntry.getTiido_pla_oficina_fkKey(),36);
		return tiido_pla_oficina_fkLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink tiido_pla_oficina_fkLink;
	/**
	 * ejbFindTiido_planesByTiido_pla_oficina_fkKey_Local
	 */
	public java.util.Collection ejbFindTiido_planesByTiido_pla_oficina_fkKey_Local(entities.Tiido_oficinaKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("tiido_pla_oficina_fk",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTiido_planesByTiido_pla_oficina_fkKey_Local");
		getInjector().findTiido_planesByTiido_pla_oficina_fkKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTiido_planesByTiido_pla_oficina_fkKey_Local", record);
	}
	/**
	 * refreshForeignKey
	 */
	public void refreshForeignKey() {
		if (tiido_pla_oficina_fkLink != null) 
		dataCacheEntry.setTiido_pla_oficina_fkKey((entities.Tiido_oficinaKey) tiido_pla_oficina_fkLink.getKey());
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: mes_plan
	 */
	public java.lang.String getMes_plan() {
		return dataCacheEntry.getMes_plan();
	}
	/**
	 * Set accessor for persistent attribute: mes_plan
	 */
	public void setMes_plan(java.lang.String newMes_plan) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getMes_plan(),newMes_plan);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setMes_plan(newMes_plan);
	}
	/**
	 * Get accessor for persistent attribute: anho_plan
	 */
	public java.lang.String getAnho_plan() {
		return dataCacheEntry.getAnho_plan();
	}
	/**
	 * Set accessor for persistent attribute: anho_plan
	 */
	public void setAnho_plan(java.lang.String newAnho_plan) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getAnho_plan(),newAnho_plan);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setAnho_plan(newAnho_plan);
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
			instanceExtension.markDirty(2,getCod_epigrafe(),newCod_epigrafe);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setCod_epigrafe(newCod_epigrafe);
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
			instanceExtension.markDirty(3,getNom_epigrafe(),newNom_epigrafe);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setNom_epigrafe(newNom_epigrafe);
	}
	/**
	 * Get accessor for persistent attribute: peso_dor
	 */
	public java.math.BigDecimal getPeso_dor() {
		return dataCacheEntry.getPeso_dor();
	}
	/**
	 * Set accessor for persistent attribute: peso_dor
	 */
	public void setPeso_dor(java.math.BigDecimal newPeso_dor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getPeso_dor(),newPeso_dor);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setPeso_dor(newPeso_dor);
	}
	/**
	 * Get accessor for persistent attribute: monto
	 */
	public java.math.BigDecimal getMonto() {
		return dataCacheEntry.getMonto();
	}
	/**
	 * Set accessor for persistent attribute: monto
	 */
	public void setMonto(java.math.BigDecimal newMonto) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getMonto(),newMonto);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setMonto(newMonto);
	}
	/**
	 * Get accessor for persistent attribute: porc_alcanzado
	 */
	public java.math.BigDecimal getPorc_alcanzado() {
		return dataCacheEntry.getPorc_alcanzado();
	}
	/**
	 * Set accessor for persistent attribute: porc_alcanzado
	 */
	public void setPorc_alcanzado(java.math.BigDecimal newPorc_alcanzado) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getPorc_alcanzado(),newPorc_alcanzado);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setPorc_alcanzado(newPorc_alcanzado);
	}
	/**
	 * Get accessor for persistent attribute: desv_ppto
	 */
	public java.math.BigDecimal getDesv_ppto() {
		return dataCacheEntry.getDesv_ppto();
	}
	/**
	 * Set accessor for persistent attribute: desv_ppto
	 */
	public void setDesv_ppto(java.math.BigDecimal newDesv_ppto) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getDesv_ppto(),newDesv_ppto);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setDesv_ppto(newDesv_ppto);
	}
	/**
	 * Get accessor for persistent attribute: nro_meses_falt
	 */
	public java.math.BigDecimal getNro_meses_falt() {
		return dataCacheEntry.getNro_meses_falt();
	}
	/**
	 * Set accessor for persistent attribute: nro_meses_falt
	 */
	public void setNro_meses_falt(java.math.BigDecimal newNro_meses_falt) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getNro_meses_falt(),newNro_meses_falt);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setNro_meses_falt(newNro_meses_falt);
	}
	/**
	 * Get accessor for persistent attribute: proy_crec_men
	 */
	public java.math.BigDecimal getProy_crec_men() {
		return dataCacheEntry.getProy_crec_men();
	}
	/**
	 * Set accessor for persistent attribute: proy_crec_men
	 */
	public void setProy_crec_men(java.math.BigDecimal newProy_crec_men) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getProy_crec_men(),newProy_crec_men);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setProy_crec_men(newProy_crec_men);
	}
	/**
	 * Get accessor for persistent attribute: ajuste_estimado_terr
	 */
	public java.math.BigDecimal getAjuste_estimado_terr() {
		return dataCacheEntry.getAjuste_estimado_terr();
	}
	/**
	 * Set accessor for persistent attribute: ajuste_estimado_terr
	 */
	public void setAjuste_estimado_terr(java.math.BigDecimal newAjuste_estimado_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getAjuste_estimado_terr(),newAjuste_estimado_terr);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setAjuste_estimado_terr(newAjuste_estimado_terr);
	}
	/**
	 * Get accessor for persistent attribute: proy_ajuste_men
	 */
	public java.math.BigDecimal getProy_ajuste_men() {
		return dataCacheEntry.getProy_ajuste_men();
	}
	/**
	 * Set accessor for persistent attribute: proy_ajuste_men
	 */
	public void setProy_ajuste_men(java.math.BigDecimal newProy_ajuste_men) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getProy_ajuste_men(),newProy_ajuste_men);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setProy_ajuste_men(newProy_ajuste_men);
	}
	/**
	 * Get accessor for persistent attribute: saldmedi_junio
	 */
	public java.math.BigDecimal getSaldmedi_junio() {
		return dataCacheEntry.getSaldmedi_junio();
	}
	/**
	 * Set accessor for persistent attribute: saldmedi_junio
	 */
	public void setSaldmedi_junio(java.math.BigDecimal newSaldmedi_junio) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getSaldmedi_junio(),newSaldmedi_junio);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setSaldmedi_junio(newSaldmedi_junio);
	}
	/**
	 * Get accessor for persistent attribute: porc_saldmedi_junio
	 */
	public java.math.BigDecimal getPorc_saldmedi_junio() {
		return dataCacheEntry.getPorc_saldmedi_junio();
	}
	/**
	 * Set accessor for persistent attribute: porc_saldmedi_junio
	 */
	public void setPorc_saldmedi_junio(java.math.BigDecimal newPorc_saldmedi_junio) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getPorc_saldmedi_junio(),newPorc_saldmedi_junio);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setPorc_saldmedi_junio(newPorc_saldmedi_junio);
	}
	/**
	 * Get accessor for persistent attribute: sald_dic_ante
	 */
	public java.math.BigDecimal getSald_dic_ante() {
		return dataCacheEntry.getSald_dic_ante();
	}
	/**
	 * Set accessor for persistent attribute: sald_dic_ante
	 */
	public void setSald_dic_ante(java.math.BigDecimal newSald_dic_ante) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getSald_dic_ante(),newSald_dic_ante);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setSald_dic_ante(newSald_dic_ante);
	}
	/**
	 * Get accessor for persistent attribute: saldmedi_dic
	 */
	public java.math.BigDecimal getSaldmedi_dic() {
		return dataCacheEntry.getSaldmedi_dic();
	}
	/**
	 * Set accessor for persistent attribute: saldmedi_dic
	 */
	public void setSaldmedi_dic(java.math.BigDecimal newSaldmedi_dic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getSaldmedi_dic(),newSaldmedi_dic);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setSaldmedi_dic(newSaldmedi_dic);
	}
	/**
	 * Get accessor for persistent attribute: cod_terri
	 */
	public java.lang.String getCod_terri() {
		return dataCacheEntry.getCod_terri();
	}
	/**
	 * Set accessor for persistent attribute: cod_terri
	 */
	public void setCod_terri(java.lang.String newCod_terri) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(16,getCod_terri(),newCod_terri);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setCod_terri(newCod_terri);
	}
	/**
	 * Get accessor for persistent attribute: porc_saldmedi_dic
	 */
	public java.math.BigDecimal getPorc_saldmedi_dic() {
		return dataCacheEntry.getPorc_saldmedi_dic();
	}
	/**
	 * Set accessor for persistent attribute: porc_saldmedi_dic
	 */
	public void setPorc_saldmedi_dic(java.math.BigDecimal newPorc_saldmedi_dic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getPorc_saldmedi_dic(),newPorc_saldmedi_dic);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setPorc_saldmedi_dic(newPorc_saldmedi_dic);
	}
	/**
	 * Get accessor for persistent attribute: fac_aju_sal_pun
	 */
	public java.math.BigDecimal getFac_aju_sal_pun() {
		return dataCacheEntry.getFac_aju_sal_pun();
	}
	/**
	 * Set accessor for persistent attribute: fac_aju_sal_pun
	 */
	public void setFac_aju_sal_pun(java.math.BigDecimal newFac_aju_sal_pun) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getFac_aju_sal_pun(),newFac_aju_sal_pun);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setFac_aju_sal_pun(newFac_aju_sal_pun);
	}
	/**
	 * Get accessor for persistent attribute: hist_bajas
	 */
	public java.math.BigDecimal getHist_bajas() {
		return dataCacheEntry.getHist_bajas();
	}
	/**
	 * Set accessor for persistent attribute: hist_bajas
	 */
	public void setHist_bajas(java.math.BigDecimal newHist_bajas) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getHist_bajas(),newHist_bajas);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setHist_bajas(newHist_bajas);
	}
	/**
	 * Get accessor for persistent attribute: met_messald_punt
	 */
	public java.math.BigDecimal getMet_messald_punt() {
		return dataCacheEntry.getMet_messald_punt();
	}
	/**
	 * Set accessor for persistent attribute: met_messald_punt
	 */
	public void setMet_messald_punt(java.math.BigDecimal newMet_messald_punt) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getMet_messald_punt(),newMet_messald_punt);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setMet_messald_punt(newMet_messald_punt);
	}
	/**
	 * Get accessor for persistent attribute: met_ger_ofi
	 */
	public java.math.BigDecimal getMet_ger_ofi() {
		return dataCacheEntry.getMet_ger_ofi();
	}
	/**
	 * Set accessor for persistent attribute: met_ger_ofi
	 */
	public void setMet_ger_ofi(java.math.BigDecimal newMet_ger_ofi) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(21,getMet_ger_ofi(),newMet_ger_ofi);
		else
			instanceExtension.markDirty(21);
		dataCacheEntry.setMet_ger_ofi(newMet_ger_ofi);
	}
	/**
	 * Get accessor for persistent attribute: prioridad
	 */
	public java.math.BigDecimal getPrioridad() {
		return dataCacheEntry.getPrioridad();
	}
	/**
	 * Set accessor for persistent attribute: prioridad
	 */
	public void setPrioridad(java.math.BigDecimal newPrioridad) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(22,getPrioridad(),newPrioridad);
		else
			instanceExtension.markDirty(22);
		dataCacheEntry.setPrioridad(newPrioridad);
	}
	/**
	 * Get accessor for persistent attribute: mes_eval
	 */
	public java.lang.String getMes_eval() {
		return dataCacheEntry.getMes_eval();
	}
	/**
	 * Set accessor for persistent attribute: mes_eval
	 */
	public void setMes_eval(java.lang.String newMes_eval) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(23,getMes_eval(),newMes_eval);
		else
			instanceExtension.markDirty(23);
		dataCacheEntry.setMes_eval(newMes_eval);
	}
	/**
	 * Get accessor for persistent attribute: ind_dor
	 */
	public java.lang.String getInd_dor() {
		return dataCacheEntry.getInd_dor();
	}
	/**
	 * Set accessor for persistent attribute: ind_dor
	 */
	public void setInd_dor(java.lang.String newInd_dor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(24,getInd_dor(),newInd_dor);
		else
			instanceExtension.markDirty(24);
		dataCacheEntry.setInd_dor(newInd_dor);
	}
	/**
	 * Get accessor for persistent attribute: var_mes
	 */
	public java.math.BigDecimal getVar_mes() {
		return dataCacheEntry.getVar_mes();
	}
	/**
	 * Set accessor for persistent attribute: var_mes
	 */
	public void setVar_mes(java.math.BigDecimal newVar_mes) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(25,getVar_mes(),newVar_mes);
		else
			instanceExtension.markDirty(25);
		dataCacheEntry.setVar_mes(newVar_mes);
	}
	/**
	 * Get accessor for persistent attribute: ajus_ppto
	 */
	public java.math.BigDecimal getAjus_ppto() {
		return dataCacheEntry.getAjus_ppto();
	}
	/**
	 * Set accessor for persistent attribute: ajus_ppto
	 */
	public void setAjus_ppto(java.math.BigDecimal newAjus_ppto) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(26,getAjus_ppto(),newAjus_ppto);
		else
			instanceExtension.markDirty(26);
		dataCacheEntry.setAjus_ppto(newAjus_ppto);
	}
	/**
	 * Get accessor for persistent attribute: desv_ppto_ajus
	 */
	public java.math.BigDecimal getDesv_ppto_ajus() {
		return dataCacheEntry.getDesv_ppto_ajus();
	}
	/**
	 * Set accessor for persistent attribute: desv_ppto_ajus
	 */
	public void setDesv_ppto_ajus(java.math.BigDecimal newDesv_ppto_ajus) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(27,getDesv_ppto_ajus(),newDesv_ppto_ajus);
		else
			instanceExtension.markDirty(27);
		dataCacheEntry.setDesv_ppto_ajus(newDesv_ppto_ajus);
	}
	/**
	 * Get accessor for persistent attribute: fact_ajus_terri
	 */
	public java.math.BigDecimal getFact_ajus_terri() {
		return dataCacheEntry.getFact_ajus_terri();
	}
	/**
	 * Set accessor for persistent attribute: fact_ajus_terri
	 */
	public void setFact_ajus_terri(java.math.BigDecimal newFact_ajus_terri) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(28,getFact_ajus_terri(),newFact_ajus_terri);
		else
			instanceExtension.markDirty(28);
		dataCacheEntry.setFact_ajus_terri(newFact_ajus_terri);
	}
	/**
	 * Get accessor for persistent attribute: fact_asig_gte_of
	 */
	public java.math.BigDecimal getFact_asig_gte_of() {
		return dataCacheEntry.getFact_asig_gte_of();
	}
	/**
	 * Set accessor for persistent attribute: fact_asig_gte_of
	 */
	public void setFact_asig_gte_of(java.math.BigDecimal newFact_asig_gte_of) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(29,getFact_asig_gte_of(),newFact_asig_gte_of);
		else
			instanceExtension.markDirty(29);
		dataCacheEntry.setFact_asig_gte_of(newFact_asig_gte_of);
	}
	/**
	 * Get accessor for persistent attribute: tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public java.lang.String getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr() {
		return dataCacheEntry.getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr();
	}
	/**
	 * Set accessor for persistent attribute: tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public void setTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr(java.lang.String newTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(30,getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr(),newTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
		else
			instanceExtension.markDirty(30);
		dataCacheEntry.setTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr(newTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * Get accessor for persistent attribute: tiido_pla_oficina_fk_cod_ofic
	 */
	public java.lang.String getTiido_pla_oficina_fk_cod_ofic() {
		return dataCacheEntry.getTiido_pla_oficina_fk_cod_ofic();
	}
	/**
	 * Set accessor for persistent attribute: tiido_pla_oficina_fk_cod_ofic
	 */
	public void setTiido_pla_oficina_fk_cod_ofic(java.lang.String newTiido_pla_oficina_fk_cod_ofic) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(31,getTiido_pla_oficina_fk_cod_ofic(),newTiido_pla_oficina_fk_cod_ofic);
		else
			instanceExtension.markDirty(31);
		dataCacheEntry.setTiido_pla_oficina_fk_cod_ofic(newTiido_pla_oficina_fk_cod_ofic);
	}
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public java.util.Date getFec_actu() {
		return dataCacheEntry.getFec_actu();
	}
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public void setFec_actu(java.util.Date newFec_actu) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(32,getFec_actu(),newFec_actu);
		else
			instanceExtension.markDirty(32);
		dataCacheEntry.setFec_actu(newFec_actu);
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
			instanceExtension.markDirty(33,getUsu_regi(),newUsu_regi);
		else
			instanceExtension.markDirty(33);
		dataCacheEntry.setUsu_regi(newUsu_regi);
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
			instanceExtension.markDirty(34,getUsu_actu(),newUsu_actu);
		else
			instanceExtension.markDirty(34);
		dataCacheEntry.setUsu_actu(newUsu_actu);
	}
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public java.util.Date getFec_regi() {
		return dataCacheEntry.getFec_regi();
	}
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public void setFec_regi(java.util.Date newFec_regi) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(35,getFec_regi(),newFec_regi);
		else
			instanceExtension.markDirty(35);
		dataCacheEntry.setFec_regi(newFec_regi);
	}
}
