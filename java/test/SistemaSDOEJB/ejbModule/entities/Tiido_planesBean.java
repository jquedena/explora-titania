package entities;

import com.grupobbva.bc.per.tele.sdo.serializable.Plan;

/**
 * Bean implementation class for Enterprise Bean: Tiido_planes
 */
@SuppressWarnings("serial")
public abstract class Tiido_planesBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_planesKey ejbCreate(
		java.lang.String mes_plan,
		java.lang.String anho_plan,
		java.lang.String cod_epigrafe,
		entities.Tiido_oficinaLocal argTiido_pla_oficina_fk)
		throws javax.ejb.CreateException {
		setMes_plan(mes_plan);
		setAnho_plan(anho_plan);
		setCod_epigrafe(cod_epigrafe);
		entities.Tiido_oficinaKey argTiido_pla_oficina_fkPK = (entities.Tiido_oficinaKey) argTiido_pla_oficina_fk
			.getPrimaryKey();
		setTiido_pla_oficina_fk_cod_ofic(argTiido_pla_oficina_fkPK.cod_ofic);
		setTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr(argTiido_pla_oficina_fkPK.tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String mes_plan,
		java.lang.String anho_plan,
		java.lang.String cod_epigrafe,
		entities.Tiido_oficinaLocal argTiido_pla_oficina_fk)
		throws javax.ejb.CreateException {
		setTiido_pla_oficina_fk(argTiido_pla_oficina_fk);
	}
	/**
	 * ejbCreate
	 */
	public entities.Tiido_planesKey ejbCreate(
		java.lang.String mes_plan,
		java.lang.String anho_plan,
		java.lang.String cod_epigrafe,
		java.lang.String tiido_pla_oficina_fk_cod_ofic,
		java.lang.String tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
		setMes_plan(mes_plan);
		setAnho_plan(anho_plan);
		setCod_epigrafe(cod_epigrafe);
		setTiido_pla_oficina_fk_cod_ofic(tiido_pla_oficina_fk_cod_ofic);
		setTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr(tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String mes_plan,
		java.lang.String anho_plan,
		java.lang.String cod_epigrafe,
		java.lang.String tiido_pla_oficina_fk_cod_ofic,
		java.lang.String tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr)
		throws javax.ejb.CreateException {
	}

	/**
	 * ejbCreate
	 */
	public entities.Tiido_planesKey ejbCreate(Plan plan)
		throws javax.ejb.CreateException {
		setCod_epigrafe(plan.getCodEpigrafe());
		setNom_epigrafe(plan.getNomEpigrafe());
		setPeso_dor(plan.getPesoDor());
		//cod_ofic 
		setMes_plan(plan.getMes());
		setAnho_plan(plan.getAnho());
		setMonto(plan.getMonto());
		setPorc_alcanzado(plan.getPorAlcanzado());
		setDesv_ppto(plan.getDesvPpto());
		setNro_meses_falt(plan.getNroMesesFalt());
		setProy_crec_men(plan.getProyCrecMens());
		setAjuste_estimado_terr(plan.getAjusEstiTerr());
		setProy_ajuste_men(plan.getProyAjusMens());
		setSaldmedi_junio(plan.getSaldMediJunio());
		setPorc_saldmedi_junio(plan.getPorcSaldMedJun());
		setSald_dic_ante(plan.getSaldDiciAnter());
		setSaldmedi_dic(plan.getSaldMediDici());
		setCod_terri(plan.getCodTerritorio());
		setPorc_saldmedi_dic(plan.getPorcSaldMedDic());
		setFac_aju_sal_pun(plan.getFactAjusSaldPunt());
		setHist_bajas(plan.getHistBajas());
		setMet_messald_punt(plan.getMetaMesSaldPunt());
		setMet_ger_ofi(plan.getMetaGereOficina());
		setPrioridad(plan.getPrioridad());
		setMes_eval(plan.getMesEval());
		setInd_dor(plan.getIndDor());
		setUsu_regi(plan.getUsuario());
		setFec_regi(new java.util.Date());
		
		plan.getCodOficina();
		setTiido_pla_oficina_fk_cod_ofic(plan.getCodOficina());
		setTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr(plan.getCodTerritorio());
		
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(Plan plan)
		throws javax.ejb.CreateException {
	}
	
	
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: mes_plan
	 */
	public abstract java.lang.String getMes_plan();
	/**
	 * Set accessor for persistent attribute: mes_plan
	 */
	public abstract void setMes_plan(java.lang.String newMes_plan);
	/**
	 * Get accessor for persistent attribute: anho_plan
	 */
	public abstract java.lang.String getAnho_plan();
	/**
	 * Set accessor for persistent attribute: anho_plan
	 */
	public abstract void setAnho_plan(java.lang.String newAnho_plan);
	/**
	 * Get accessor for persistent attribute: cod_epigrafe
	 */
	public abstract java.lang.String getCod_epigrafe();
	/**
	 * Set accessor for persistent attribute: cod_epigrafe
	 */
	public abstract void setCod_epigrafe(java.lang.String newCod_epigrafe);
	/**
	 * Get accessor for persistent attribute: nom_epigrafe
	 */
	public abstract java.lang.String getNom_epigrafe();
	/**
	 * Set accessor for persistent attribute: nom_epigrafe
	 */
	public abstract void setNom_epigrafe(java.lang.String newNom_epigrafe);
	/**
	 * Get accessor for persistent attribute: peso_dor
	 */
	public abstract java.math.BigDecimal getPeso_dor();
	/**
	 * Set accessor for persistent attribute: peso_dor
	 */
	public abstract void setPeso_dor(java.math.BigDecimal newPeso_dor);
	/**
	 * Get accessor for persistent attribute: monto
	 */
	public abstract java.math.BigDecimal getMonto();
	/**
	 * Set accessor for persistent attribute: monto
	 */
	public abstract void setMonto(java.math.BigDecimal newMonto);
	/**
	 * Get accessor for persistent attribute: porc_alcanzado
	 */
	public abstract java.math.BigDecimal getPorc_alcanzado();
	/**
	 * Set accessor for persistent attribute: porc_alcanzado
	 */
	public abstract void setPorc_alcanzado(
		java.math.BigDecimal newPorc_alcanzado);
	/**
	 * Get accessor for persistent attribute: desv_ppto
	 */
	public abstract java.math.BigDecimal getDesv_ppto();
	/**
	 * Set accessor for persistent attribute: desv_ppto
	 */
	public abstract void setDesv_ppto(java.math.BigDecimal newDesv_ppto);
	/**
	 * Get accessor for persistent attribute: nro_meses_falt
	 */
	public abstract java.math.BigDecimal getNro_meses_falt();
	/**
	 * Set accessor for persistent attribute: nro_meses_falt
	 */
	public abstract void setNro_meses_falt(
		java.math.BigDecimal newNro_meses_falt);
	/**
	 * Get accessor for persistent attribute: proy_crec_men
	 */
	public abstract java.math.BigDecimal getProy_crec_men();
	/**
	 * Set accessor for persistent attribute: proy_crec_men
	 */
	public abstract void setProy_crec_men(java.math.BigDecimal newProy_crec_men);
	/**
	 * Get accessor for persistent attribute: ajuste_estimado_terr
	 */
	public abstract java.math.BigDecimal getAjuste_estimado_terr();
	/**
	 * Set accessor for persistent attribute: ajuste_estimado_terr
	 */
	public abstract void setAjuste_estimado_terr(
		java.math.BigDecimal newAjuste_estimado_terr);
	/**
	 * Get accessor for persistent attribute: proy_ajuste_men
	 */
	public abstract java.math.BigDecimal getProy_ajuste_men();
	/**
	 * Set accessor for persistent attribute: proy_ajuste_men
	 */
	public abstract void setProy_ajuste_men(
		java.math.BigDecimal newProy_ajuste_men);
	/**
	 * Get accessor for persistent attribute: saldmedi_junio
	 */
	public abstract java.math.BigDecimal getSaldmedi_junio();
	/**
	 * Set accessor for persistent attribute: saldmedi_junio
	 */
	public abstract void setSaldmedi_junio(
		java.math.BigDecimal newSaldmedi_junio);
	/**
	 * Get accessor for persistent attribute: porc_saldmedi_junio
	 */
	public abstract java.math.BigDecimal getPorc_saldmedi_junio();
	/**
	 * Set accessor for persistent attribute: porc_saldmedi_junio
	 */
	public abstract void setPorc_saldmedi_junio(
		java.math.BigDecimal newPorc_saldmedi_junio);
	/**
	 * Get accessor for persistent attribute: sald_dic_ante
	 */
	public abstract java.math.BigDecimal getSald_dic_ante();
	/**
	 * Set accessor for persistent attribute: sald_dic_ante
	 */
	public abstract void setSald_dic_ante(java.math.BigDecimal newSald_dic_ante);
	/**
	 * Get accessor for persistent attribute: saldmedi_dic
	 */
	public abstract java.math.BigDecimal getSaldmedi_dic();
	/**
	 * Set accessor for persistent attribute: saldmedi_dic
	 */
	public abstract void setSaldmedi_dic(java.math.BigDecimal newSaldmedi_dic);
	/**
	 * Get accessor for persistent attribute: cod_terri
	 */
	public abstract java.lang.String getCod_terri();
	/**
	 * Set accessor for persistent attribute: cod_terri
	 */
	public abstract void setCod_terri(java.lang.String newCod_terri);
	/**
	 * Get accessor for persistent attribute: porc_saldmedi_dic
	 */
	public abstract java.math.BigDecimal getPorc_saldmedi_dic();
	/**
	 * Set accessor for persistent attribute: porc_saldmedi_dic
	 */
	public abstract void setPorc_saldmedi_dic(
		java.math.BigDecimal newPorc_saldmedi_dic);
	/**
	 * Get accessor for persistent attribute: fac_aju_sal_pun
	 */
	public abstract java.math.BigDecimal getFac_aju_sal_pun();
	/**
	 * Set accessor for persistent attribute: fac_aju_sal_pun
	 */
	public abstract void setFac_aju_sal_pun(
		java.math.BigDecimal newFac_aju_sal_pun);
	/**
	 * Get accessor for persistent attribute: hist_bajas
	 */
	public abstract java.math.BigDecimal getHist_bajas();
	/**
	 * Set accessor for persistent attribute: hist_bajas
	 */
	public abstract void setHist_bajas(java.math.BigDecimal newHist_bajas);
	/**
	 * Get accessor for persistent attribute: met_messald_punt
	 */
	public abstract java.math.BigDecimal getMet_messald_punt();
	/**
	 * Set accessor for persistent attribute: met_messald_punt
	 */
	public abstract void setMet_messald_punt(
		java.math.BigDecimal newMet_messald_punt);
	/**
	 * Get accessor for persistent attribute: met_ger_ofi
	 */
	public abstract java.math.BigDecimal getMet_ger_ofi();
	/**
	 * Set accessor for persistent attribute: met_ger_ofi
	 */
	public abstract void setMet_ger_ofi(java.math.BigDecimal newMet_ger_ofi);
	/**
	 * Get accessor for persistent attribute: prioridad
	 */
	public abstract java.math.BigDecimal getPrioridad();
	/**
	 * Set accessor for persistent attribute: prioridad
	 */
	public abstract void setPrioridad(java.math.BigDecimal newPrioridad);
	/**
	 * Get accessor for persistent attribute: mes_eval
	 */
	public abstract java.lang.String getMes_eval();
	/**
	 * Set accessor for persistent attribute: mes_eval
	 */
	public abstract void setMes_eval(java.lang.String newMes_eval);
	/**
	 * Get accessor for persistent attribute: ind_dor
	 */
	public abstract java.lang.String getInd_dor();
	/**
	 * Set accessor for persistent attribute: ind_dor
	 */
	public abstract void setInd_dor(java.lang.String newInd_dor);
	/**
	 * Get accessor for persistent attribute: var_mes
	 */
	public abstract java.math.BigDecimal getVar_mes();
	/**
	 * Set accessor for persistent attribute: var_mes
	 */
	public abstract void setVar_mes(java.math.BigDecimal newVar_mes);
	/**
	 * Get accessor for persistent attribute: ajus_ppto
	 */
	public abstract java.math.BigDecimal getAjus_ppto();
	/**
	 * Set accessor for persistent attribute: ajus_ppto
	 */
	public abstract void setAjus_ppto(java.math.BigDecimal newAjus_ppto);
	/**
	 * Get accessor for persistent attribute: desv_ppto_ajus
	 */
	public abstract java.math.BigDecimal getDesv_ppto_ajus();
	/**
	 * Set accessor for persistent attribute: desv_ppto_ajus
	 */
	public abstract void setDesv_ppto_ajus(
		java.math.BigDecimal newDesv_ppto_ajus);
	/**
	 * Get accessor for persistent attribute: fact_ajus_terri
	 */
	public abstract java.math.BigDecimal getFact_ajus_terri();
	/**
	 * Set accessor for persistent attribute: fact_ajus_terri
	 */
	public abstract void setFact_ajus_terri(
		java.math.BigDecimal newFact_ajus_terri);
	/**
	 * Get accessor for persistent attribute: fact_asig_gte_of
	 */
	public abstract java.math.BigDecimal getFact_asig_gte_of();
	/**
	 * Set accessor for persistent attribute: fact_asig_gte_of
	 */
	public abstract void setFact_asig_gte_of(
		java.math.BigDecimal newFact_asig_gte_of);
	/**
	 * This method was generated for supporting the relationship role named tiido_pla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract entities.Tiido_oficinaLocal getTiido_pla_oficina_fk();
	/**
	 * This method was generated for supporting the relationship role named tiido_pla_oficina_fk.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTiido_pla_oficina_fk(
		entities.Tiido_oficinaLocal aTiido_pla_oficina_fk);
	/**
	 * Get accessor for persistent attribute: tiido_pla_oficina_fk_cod_ofic
	 */
	public abstract java.lang.String getTiido_pla_oficina_fk_cod_ofic();
	/**
	 * Set accessor for persistent attribute: tiido_pla_oficina_fk_cod_ofic
	 */
	public abstract void setTiido_pla_oficina_fk_cod_ofic(
		java.lang.String newTiido_pla_oficina_fk_cod_ofic);
	/**
	 * Get accessor for persistent attribute: tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract java.lang.String getTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr();
	/**
	 * Set accessor for persistent attribute: tiido_pla_oficina_fk_tiido_territorio_fk_cod_terr
	 */
	public abstract void setTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr(
		java.lang.String newTiido_pla_oficina_fk_tiido_territorio_fk_cod_terr);
	/**
	 * Get accessor for persistent attribute: fec_actu
	 */
	public abstract java.util.Date getFec_actu();
	/**
	 * Set accessor for persistent attribute: fec_actu
	 */
	public abstract void setFec_actu(java.util.Date newFec_actu);
	/**
	 * Get accessor for persistent attribute: usu_regi
	 */
	public abstract java.lang.String getUsu_regi();
	/**
	 * Set accessor for persistent attribute: usu_regi
	 */
	public abstract void setUsu_regi(java.lang.String newUsu_regi);
	/**
	 * Get accessor for persistent attribute: usu_actu
	 */
	public abstract java.lang.String getUsu_actu();
	/**
	 * Set accessor for persistent attribute: usu_actu
	 */
	public abstract void setUsu_actu(java.lang.String newUsu_actu);
	/**
	 * Get accessor for persistent attribute: fec_regi
	 */
	public abstract java.util.Date getFec_regi();
	/**
	 * Set accessor for persistent attribute: fec_regi
	 */
	public abstract void setFec_regi(java.util.Date newFec_regi);
}
