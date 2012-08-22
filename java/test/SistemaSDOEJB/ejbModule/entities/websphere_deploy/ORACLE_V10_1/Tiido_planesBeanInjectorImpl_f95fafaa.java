package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_planesBeanInjectorImpl_f95fafaa
 */
public class Tiido_planesBeanInjectorImpl_f95fafaa implements entities.websphere_deploy.Tiido_planesBeanInjector_f95fafaa {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_planes_f95fafaa concreteBean=(entities.ConcreteTiido_planes_f95fafaa)cb;
		record.set(0,concreteBean.getMes_plan());
		record.set(1,concreteBean.getAnho_plan());
		record.set(2,concreteBean.getCod_epigrafe());
		record.set(3,concreteBean.getNom_epigrafe());
		record.set(4,concreteBean.getPeso_dor());
		record.set(5,concreteBean.getMonto());
		record.set(6,concreteBean.getPorc_alcanzado());
		record.set(7,concreteBean.getDesv_ppto());
		record.set(8,concreteBean.getNro_meses_falt());
		record.set(9,concreteBean.getProy_crec_men());
		record.set(10,concreteBean.getAjuste_estimado_terr());
		record.set(11,concreteBean.getProy_ajuste_men());
		record.set(12,concreteBean.getSaldmedi_junio());
		record.set(13,concreteBean.getPorc_saldmedi_junio());
		record.set(14,concreteBean.getSald_dic_ante());
		record.set(15,concreteBean.getSaldmedi_dic());
		record.set(16,concreteBean.getCod_terri());
		record.set(17,concreteBean.getPorc_saldmedi_dic());
		record.set(18,concreteBean.getFac_aju_sal_pun());
		record.set(19,concreteBean.getHist_bajas());
		record.set(20,concreteBean.getMet_messald_punt());
		record.set(21,concreteBean.getMet_ger_ofi());
		record.set(22,concreteBean.getPrioridad());
		record.set(23,concreteBean.getMes_eval());
		record.set(24,concreteBean.getInd_dor());
		record.set(25,concreteBean.getVar_mes());
		record.set(26,concreteBean.getAjus_ppto());
		record.set(27,concreteBean.getDesv_ppto_ajus());
		record.set(28,concreteBean.getFact_ajus_terri());
		record.set(29,concreteBean.getFact_asig_gte_of());
		record.set(30,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_actu()));
		record.set(31,concreteBean.getUsu_regi());
		record.set(32,concreteBean.getUsu_actu());
		record.set(33,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_regi()));
		record.set(34,concreteBean.getTiido_pla_oficina_fk_cod_ofic());
		record.set(35,concreteBean.getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_planes_f95fafaa concreteBean=(entities.ConcreteTiido_planes_f95fafaa)cb;
		record.set(0,concreteBean.getMes_plan());
		record.set(1,concreteBean.getAnho_plan());
		record.set(2,concreteBean.getCod_epigrafe());
		record.set(3,concreteBean.getNom_epigrafe());
		record.set(4,concreteBean.getPeso_dor());
		record.set(5,concreteBean.getMonto());
		record.set(6,concreteBean.getPorc_alcanzado());
		record.set(7,concreteBean.getDesv_ppto());
		record.set(8,concreteBean.getNro_meses_falt());
		record.set(9,concreteBean.getProy_crec_men());
		record.set(10,concreteBean.getAjuste_estimado_terr());
		record.set(11,concreteBean.getProy_ajuste_men());
		record.set(12,concreteBean.getSaldmedi_junio());
		record.set(13,concreteBean.getPorc_saldmedi_junio());
		record.set(14,concreteBean.getSald_dic_ante());
		record.set(15,concreteBean.getSaldmedi_dic());
		record.set(16,concreteBean.getCod_terri());
		record.set(17,concreteBean.getPorc_saldmedi_dic());
		record.set(18,concreteBean.getFac_aju_sal_pun());
		record.set(19,concreteBean.getHist_bajas());
		record.set(20,concreteBean.getMet_messald_punt());
		record.set(21,concreteBean.getMet_ger_ofi());
		record.set(22,concreteBean.getPrioridad());
		record.set(23,concreteBean.getMes_eval());
		record.set(24,concreteBean.getInd_dor());
		record.set(25,concreteBean.getVar_mes());
		record.set(26,concreteBean.getAjus_ppto());
		record.set(27,concreteBean.getDesv_ppto_ajus());
		record.set(28,concreteBean.getFact_ajus_terri());
		record.set(29,concreteBean.getFact_asig_gte_of());
		record.set(30,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_actu()));
		record.set(31,concreteBean.getUsu_regi());
		record.set(32,concreteBean.getUsu_actu());
		record.set(33,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_regi()));
		record.set(34,concreteBean.getTiido_pla_oficina_fk_cod_ofic());
		record.set(35,concreteBean.getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_planes_f95fafaa concreteBean=(entities.ConcreteTiido_planes_f95fafaa)cb;
		record.set(0,concreteBean.getMes_plan());
		record.set(1,concreteBean.getAnho_plan());
		record.set(2,concreteBean.getCod_epigrafe());
		record.set(34,concreteBean.getTiido_pla_oficina_fk_cod_ofic());
		record.set(35,concreteBean.getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbFindConsultaPlanes
	 */
	public void ejbFindConsultaPlanes(java.lang.String codOficina, java.lang.String anho, java.lang.String mes, javax.resource.cci.IndexedRecord record) {
		record.set(0,codOficina);
		record.set(1,anho);
		record.set(2,mes);
	}
	/**
	 * ejbFindConsultaPlanesPrioridad
	 */
	public void ejbFindConsultaPlanesPrioridad(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina, javax.resource.cci.IndexedRecord record) {
		record.set(0,mes);
		record.set(1,anho);
		record.set(2,codEpigrafe);
		record.set(3,codOficina);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		entities.Tiido_planesKey pkey=(entities.Tiido_planesKey)pkeyObject;
		record.set(0,pkey.mes_plan);
		record.set(1,pkey.anho_plan);
		record.set(2,pkey.cod_epigrafe);
		record.set(3,pkey.tiido_pla_oficina_fk_cod_ofic);
		record.set(4,pkey.tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
	}
	/**
	 * ejbFindConsultarPlanesxMes
	 */
	public void ejbFindConsultarPlanesxMes(java.lang.String codOficina, java.lang.String anho, javax.resource.cci.IndexedRecord record) {
		record.set(0,codOficina);
		record.set(1,anho);
	}
	/**
	 * ejbFindConsultaPlanesResumen
	 */
	public void ejbFindConsultaPlanesResumen(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina, javax.resource.cci.IndexedRecord record) {
		record.set(0,mes);
		record.set(1,anho);
		record.set(2,codEpigrafe);
		record.set(3,codOficina);
	}
	/**
	 * ejbFindPlanByObject
	 */
	public void ejbFindPlanByObject(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina, javax.resource.cci.IndexedRecord record) {
		record.set(0,mes);
		record.set(1,anho);
		record.set(2,codEpigrafe);
		record.set(3,codOficina);
	}
	/**
	 * findTiido_planesByTiido_pla_oficina_fkKey_Local
	 */
	public void findTiido_planesByTiido_pla_oficina_fkKey_Local(entities.Tiido_oficinaKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey.cod_ofic);
		record.set(1,fkey.tiido_territorio_fk_cod_terr);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_planes_f95fafaa concreteBean=(entities.ConcreteTiido_planes_f95fafaa)cb;
		record.set(0,concreteBean.getMes_plan());
		record.set(1,concreteBean.getAnho_plan());
		record.set(2,concreteBean.getCod_epigrafe());
		record.set(3,concreteBean.getTiido_pla_oficina_fk_cod_ofic());
		record.set(4,concreteBean.getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr());
		record.set(5,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_actu()));
		record.set(6,concreteBean.getUsu_regi());
		record.set(7,concreteBean.getUsu_actu());
		record.set(8,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_regi()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		entities.ConcreteTiido_planes_f95fafaa concreteBean=(entities.ConcreteTiido_planes_f95fafaa)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getMes_plan());
		record.set(1,concreteBean.getAnho_plan());
		record.set(2,concreteBean.getCod_epigrafe());
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getNom_epigrafe());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getPeso_dor());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getMonto());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getPorc_alcanzado());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getDesv_ppto());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getNro_meses_falt());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getProy_crec_men());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getAjuste_estimado_terr());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getProy_ajuste_men());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getSaldmedi_junio());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,concreteBean.getPorc_saldmedi_junio());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,concreteBean.getSald_dic_ante());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(15,concreteBean.getSaldmedi_dic());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(16,concreteBean.getCod_terri());
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(17,concreteBean.getPorc_saldmedi_dic());
		}
		if(instanceExtension.isDirty(18))
		{
			record.set(18,concreteBean.getFac_aju_sal_pun());
		}
		if(instanceExtension.isDirty(19))
		{
			record.set(19,concreteBean.getHist_bajas());
		}
		if(instanceExtension.isDirty(20))
		{
			record.set(20,concreteBean.getMet_messald_punt());
		}
		if(instanceExtension.isDirty(21))
		{
			record.set(21,concreteBean.getMet_ger_ofi());
		}
		if(instanceExtension.isDirty(22))
		{
			record.set(22,concreteBean.getPrioridad());
		}
		if(instanceExtension.isDirty(23))
		{
			record.set(23,concreteBean.getMes_eval());
		}
		if(instanceExtension.isDirty(24))
		{
			record.set(24,concreteBean.getInd_dor());
		}
		if(instanceExtension.isDirty(25))
		{
			record.set(25,concreteBean.getVar_mes());
		}
		if(instanceExtension.isDirty(26))
		{
			record.set(26,concreteBean.getAjus_ppto());
		}
		if(instanceExtension.isDirty(27))
		{
			record.set(27,concreteBean.getDesv_ppto_ajus());
		}
		if(instanceExtension.isDirty(28))
		{
			record.set(28,concreteBean.getFact_ajus_terri());
		}
		if(instanceExtension.isDirty(29))
		{
			record.set(29,concreteBean.getFact_asig_gte_of());
		}
		if(instanceExtension.isDirty(32))
		{
			record.set(30,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_actu()));
		}
		if(instanceExtension.isDirty(33))
		{
			record.set(31,concreteBean.getUsu_regi());
		}
		if(instanceExtension.isDirty(34))
		{
			record.set(32,concreteBean.getUsu_actu());
		}
		if(instanceExtension.isDirty(35))
		{
			record.set(33,com.ibm.vap.converters.VapTimestampToUtilDateConverter.singleton().dataFrom(concreteBean.getFec_regi()));
		}
		record.set(34,concreteBean.getTiido_pla_oficina_fk_cod_ofic());
		record.set(35,concreteBean.getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
