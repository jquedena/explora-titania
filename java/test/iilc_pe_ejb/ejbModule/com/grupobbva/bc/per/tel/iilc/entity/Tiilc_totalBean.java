package com.grupobbva.bc.per.tel.iilc.entity;

import java.math.BigDecimal;

import com.grupobbva.bc.per.tel.iilc.serializable.Total;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_total
 */
public abstract class Tiilc_totalBean implements javax.ejb.EntityBean {

	private static final long serialVersionUID = 1L;
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
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey ejbCreate(
		java.math.BigDecimal cod_total) throws javax.ejb.CreateException {
		setCod_total(cod_total);
		return null;
	}
	
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.math.BigDecimal cod_total)
		throws javax.ejb.CreateException {
	}
	
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalKey ejbCreate(Total total) throws javax.ejb.CreateException {
        setCod_total(new BigDecimal(0));
        setInd_registro(total.getInd_registro());
        setCod_territorio(total.getCod_territorio());
        setCod_oficina(total.getCod_oficina());
        setCod_gestor(total.getCod_gestor());
        setClixgest(new BigDecimal(total.getClixgest()));
        setSeg_10100(new BigDecimal(total.getSeg_10100()));
        setSeg_10200(new BigDecimal(total.getSeg_10200()));
        setSeg_20100(new BigDecimal(total.getSeg_20100()));
        setSeg_20200(new BigDecimal(total.getSeg_20200()));
        setSeg_20300(new BigDecimal(total.getSeg_20300()));
        setSeg_20400(new BigDecimal(total.getSeg_20400()));
        setSeg_20500(new BigDecimal(total.getSeg_20500()));
        setSeg_20600(new BigDecimal(total.getSeg_20600()));
        setSeg_30100(new BigDecimal(total.getSeg_30100()));
        setSeg_30200(new BigDecimal(total.getSeg_30200()));
        setSeg_30300(new BigDecimal(total.getSeg_30300()));
        setSeg_30400(new BigDecimal(total.getSeg_30400()));
        setSeg_40100(new BigDecimal(total.getSeg_40100()));
        setSeg_40200(new BigDecimal(total.getSeg_40200()));
        setSeg_40300(new BigDecimal(total.getSeg_40300()));
        setSeg_40400(new BigDecimal(total.getSeg_40400()));
        setSeg_50100(new BigDecimal(total.getSeg_50100()));
        setSeg_50200(new BigDecimal(total.getSeg_50200()));
        setSeg_50300(new BigDecimal(total.getSeg_50300()));
        setSeg_50400(new BigDecimal(total.getSeg_50400()));
        setSeg_60100(new BigDecimal(total.getSeg_60100()));
        setSeg_60200(new BigDecimal(total.getSeg_60200()));
        setSeg_60300(new BigDecimal(total.getSeg_60300()));
        setSeg_60400(new BigDecimal(total.getSeg_60400()));
        setSeg_80100(new BigDecimal(total.getSeg_80100()));
        setSeg_80200(new BigDecimal(total.getSeg_80200()));
        setSeg_80300(new BigDecimal(total.getSeg_80300()));
        setSeg_80400(new BigDecimal(total.getSeg_80400()));
        setSeg_80500(new BigDecimal(total.getSeg_80500()));
        setSeg_80600(new BigDecimal(total.getSeg_80600()));
        setSeg_80700(new BigDecimal(total.getSeg_80700()));
        setSeg_90200(new BigDecimal(total.getSeg_90200()));
        setSeg_99900(new BigDecimal(total.getSeg_99900()));
        setDesvin(new BigDecimal(total.getDesvin()));
        setPocovin(new BigDecimal(total.getPocovin()));
        setVin(new BigDecimal(total.getVin()));
        setMuyvin(new BigDecimal(total.getMuyvin()));
        setNatdesvin(new BigDecimal(total.getNatdesvin()));
        setNatvin(new BigDecimal(total.getNatvin()));
        setJurvin(new BigDecimal(total.getJurvin()));
        setIcalicte00(new BigDecimal(total.getIcalicte00()));
        setIcalicte10(new BigDecimal(total.getIcalicte10()));
        setIcalicte20(new BigDecimal(total.getIcalicte20()));
        setIcalicte30(new BigDecimal(total.getIcalicte30()));
        setIcalicte40(new BigDecimal(total.getIcalicte40()));
        setAhor_t(new BigDecimal(total.getAhor_t()));
        setAhsd_t(new BigDecimal(total.getAhsd_t()));
        setAval_t(new BigDecimal(total.getAval_t()));
        setB24_t(new BigDecimal(total.getB24_t()));
        setCcte_t(new BigDecimal(total.getCcte_t()));
        setCext_t(new BigDecimal(total.getCext_t()));
        setCloc_t(new BigDecimal(total.getCloc_t()));
        setColb_t(new BigDecimal(total.getColb_t()));
        setCpte_t(new BigDecimal(total.getCpte_t()));
        setCts_t(new BigDecimal(total.getCts_t()));
        setCtsd_t(new BigDecimal(total.getCtsd_t()));
        setVip_t(new BigDecimal(total.getVip_t()));
        setCvip_t(new BigDecimal(total.getCvip_t()));
        setDsct_t(new BigDecimal(total.getDsct_t()));
        setFcex_t(new BigDecimal(total.getFcex_t()));
        setFmut_t(new BigDecimal(total.getFmut_t()));
        setLcta_t(new BigDecimal(total.getLcta_t()));
        setLeas_t(new BigDecimal(total.getLeas_t()));
        setMcla_t(new BigDecimal(total.getMcla_t()));
        setMoro_t(new BigDecimal(total.getMoro_t()));
        setMp_t(new BigDecimal(total.getMp_t()));
        setPaut_t(new BigDecimal(total.getPaut_t()));
        setPcom_t(new BigDecimal(total.getPcom_t()));
        setPer_t(new BigDecimal(total.getPer_t()));
        setPh_t(new BigDecimal(total.getPh_t()));
        setPhip_t(new BigDecimal(total.getPhip_t()));
        setPlzo_t(new BigDecimal(total.getPlzo_t()));
        setPmas_t(new BigDecimal(total.getPmas_t()));
        setPmiv_t(new BigDecimal(total.getPmiv_t()));
        setPper_t(new BigDecimal(total.getPper_t()));
        setPpper_t(new BigDecimal(total.getPpper_t()));
        setPref_t(new BigDecimal(total.getPref_t()));
        setProm_t(new BigDecimal(total.getProm_t()));
        setPser_t(new BigDecimal(total.getPser_t()));
        setPserv_t(new BigDecimal(total.getPserv_t()));
        setDep_t(new BigDecimal(total.getDep_t()));
        setSdep_t(new BigDecimal(total.getSdep_t()));
        setSext_t(new BigDecimal(total.getSext_t()));
        setSonc_t(new BigDecimal(total.getSonc_t()));
        setSpro_t(new BigDecimal(total.getSpro_t()));
        setVid_t(new BigDecimal(total.getVid_t()));
        setSvid_t(new BigDecimal(total.getSvid_t()));
        setTde_t(new BigDecimal(total.getTde_t()));
        setSvip_t(new BigDecimal(total.getSvip_t()));
        setTvip_t(new BigDecimal(total.getTvip_t()));
        setVarc_t(new BigDecimal(total.getVarc_t()));
        setVcla_t(new BigDecimal(total.getVcla_t()));
        setVctr_t(new BigDecimal(total.getVctr_t()));
        setVemp_t(new BigDecimal(total.getVemp_t()));
        setVnac_t(new BigDecimal(total.getVnac_t()));
        setVoro_t(new BigDecimal(total.getVoro_t()));
        setVpla_t(new BigDecimal(total.getVpla_t()));
        setVpola_t(new BigDecimal(total.getVpola_t()));
        setVrep_t(new BigDecimal(total.getVrep_t()));
        setTdeb_t(new BigDecimal(total.getTdeb_t()));
        setCnet_t(new BigDecimal(total.getCnet_t()));
        setCemp_t(new BigDecimal(total.getCemp_t()));
        setLinco_t(new BigDecimal(total.getLinco_t()));
        setPos_t(new BigDecimal(total.getPos_t()));
        setEmph_t(new BigDecimal(total.getEmph_t()));
        setRiesgo_d_t(new BigDecimal(total.getRiesgo_d_t()));
        setRiesgo_i_t(new BigDecimal(total.getRiesgo_i_t()));
        setRiesgo_t(new BigDecimal(total.getRiesgo_t()));
        setPasivo_t(new BigDecimal(total.getPasivo_t()));
        setVolumen_t(new BigDecimal(total.getVolumen_t()));
        setSum_t_act(new BigDecimal(total.getSum_t_act()));
        setSum_t_act1(new BigDecimal(total.getSum_t_act1()));
        setSum_t_act2(new BigDecimal(total.getSum_t_act2()));
        setSum_t_act3(new BigDecimal(total.getSum_t_act3()));
        setSum_t_act4(new BigDecimal(total.getSum_t_act4()));
        setSum_t_act5(new BigDecimal(total.getSum_t_act5()));
        setSum_t_act6(new BigDecimal(total.getSum_t_act6()));
        setSum_act_cto(new BigDecimal(total.getSum_act_ctO()));
        setSum_act_ct1(new BigDecimal(total.getSum_act_ct1()));
        setSum_act_ct2(new BigDecimal(total.getSum_act_ct2()));
        setSum_act_ct3(new BigDecimal(total.getSum_act_ct3()));
        setSum_act_ct4(new BigDecimal(total.getSum_act_ct4()));
        setSum_act_ct5(new BigDecimal(total.getSum_act_ct5()));
        setSum_act_ct6(new BigDecimal(total.getSum_act_ct6())); 
        
        // ALZ (2010.11.29) CAMPOS NUEVOS (PETICION 2010-11-117)
        setMofactv_t(new BigDecimal(total.getMofactv_t()));
        setCs000lineamaxtc_t(new BigDecimal(total.getCs000lineamaxtc_t()));
		setCs000mtoprestamo_t(new BigDecimal(total.getCs000mtoprestamo_t()));
		setMontovehicular_t(new BigDecimal(total.getMontovehicular_t()));
		//setMontohipotecario_t(new BigDecimal(total.getMontohipotecario_t()));
		setMontosubrogados_t(new BigDecimal(total.getMontosubrogados_t()));
        return null;
    }
	
	public void ejbPostCreate(Total total)throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: cod_total
	 */
	public abstract java.math.BigDecimal getCod_total();
	/**
	 * Set accessor for persistent attribute: cod_total
	 */
	public abstract void setCod_total(java.math.BigDecimal newCod_total);
	/**
	 * Get accessor for persistent attribute: cod_territorio
	 */
	public abstract java.lang.String getCod_territorio();
	/**
	 * Set accessor for persistent attribute: cod_territorio
	 */
	public abstract void setCod_territorio(java.lang.String newCod_territorio);
	/**
	 * Get accessor for persistent attribute: ind_registro
	 */
	public abstract java.lang.String getInd_registro();
	/**
	 * Set accessor for persistent attribute: ind_registro
	 */
	public abstract void setInd_registro(java.lang.String newInd_registro);
	/**
	 * Get accessor for persistent attribute: cod_oficina
	 */
	public abstract java.lang.String getCod_oficina();
	/**
	 * Set accessor for persistent attribute: cod_oficina
	 */
	public abstract void setCod_oficina(java.lang.String newCod_oficina);
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public abstract java.lang.String getCod_gestor();
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public abstract void setCod_gestor(java.lang.String newCod_gestor);
	/**
	 * Get accessor for persistent attribute: clixgest
	 */
	public abstract java.math.BigDecimal getClixgest();
	/**
	 * Set accessor for persistent attribute: clixgest
	 */
	public abstract void setClixgest(java.math.BigDecimal newClixgest);
	/**
	 * Get accessor for persistent attribute: seg_10100
	 */
	public abstract java.math.BigDecimal getSeg_10100();
	/**
	 * Set accessor for persistent attribute: seg_10100
	 */
	public abstract void setSeg_10100(java.math.BigDecimal newSeg_10100);
	/**
	 * Get accessor for persistent attribute: seg_10200
	 */
	public abstract java.math.BigDecimal getSeg_10200();
	/**
	 * Set accessor for persistent attribute: seg_10200
	 */
	public abstract void setSeg_10200(java.math.BigDecimal newSeg_10200);
	/**
	 * Get accessor for persistent attribute: seg_20100
	 */
	public abstract java.math.BigDecimal getSeg_20100();
	/**
	 * Set accessor for persistent attribute: seg_20100
	 */
	public abstract void setSeg_20100(java.math.BigDecimal newSeg_20100);
	/**
	 * Get accessor for persistent attribute: seg_20200
	 */
	public abstract java.math.BigDecimal getSeg_20200();
	/**
	 * Set accessor for persistent attribute: seg_20200
	 */
	public abstract void setSeg_20200(java.math.BigDecimal newSeg_20200);
	/**
	 * Get accessor for persistent attribute: seg_20300
	 */
	public abstract java.math.BigDecimal getSeg_20300();
	/**
	 * Set accessor for persistent attribute: seg_20300
	 */
	public abstract void setSeg_20300(java.math.BigDecimal newSeg_20300);
	/**
	 * Get accessor for persistent attribute: seg_20400
	 */
	public abstract java.math.BigDecimal getSeg_20400();
	/**
	 * Set accessor for persistent attribute: seg_20400
	 */
	public abstract void setSeg_20400(java.math.BigDecimal newSeg_20400);
	/**
	 * Get accessor for persistent attribute: seg_20500
	 */
	public abstract java.math.BigDecimal getSeg_20500();
	/**
	 * Set accessor for persistent attribute: seg_20500
	 */
	public abstract void setSeg_20500(java.math.BigDecimal newSeg_20500);
	/**
	 * Get accessor for persistent attribute: seg_20600
	 */
	public abstract java.math.BigDecimal getSeg_20600();
	/**
	 * Set accessor for persistent attribute: seg_20600
	 */
	public abstract void setSeg_20600(java.math.BigDecimal newSeg_20600);
	/**
	 * Get accessor for persistent attribute: seg_30100
	 */
	public abstract java.math.BigDecimal getSeg_30100();
	/**
	 * Set accessor for persistent attribute: seg_30100
	 */
	public abstract void setSeg_30100(java.math.BigDecimal newSeg_30100);
	/**
	 * Get accessor for persistent attribute: seg_30200
	 */
	public abstract java.math.BigDecimal getSeg_30200();
	/**
	 * Set accessor for persistent attribute: seg_30200
	 */
	public abstract void setSeg_30200(java.math.BigDecimal newSeg_30200);
	/**
	 * Get accessor for persistent attribute: seg_30300
	 */
	public abstract java.math.BigDecimal getSeg_30300();
	/**
	 * Set accessor for persistent attribute: seg_30300
	 */
	public abstract void setSeg_30300(java.math.BigDecimal newSeg_30300);
	/**
	 * Get accessor for persistent attribute: seg_30400
	 */
	public abstract java.math.BigDecimal getSeg_30400();
	/**
	 * Set accessor for persistent attribute: seg_30400
	 */
	public abstract void setSeg_30400(java.math.BigDecimal newSeg_30400);
	/**
	 * Get accessor for persistent attribute: seg_40100
	 */
	public abstract java.math.BigDecimal getSeg_40100();
	/**
	 * Set accessor for persistent attribute: seg_40100
	 */
	public abstract void setSeg_40100(java.math.BigDecimal newSeg_40100);
	/**
	 * Get accessor for persistent attribute: seg_40200
	 */
	public abstract java.math.BigDecimal getSeg_40200();
	/**
	 * Set accessor for persistent attribute: seg_40200
	 */
	public abstract void setSeg_40200(java.math.BigDecimal newSeg_40200);
	/**
	 * Get accessor for persistent attribute: seg_40300
	 */
	public abstract java.math.BigDecimal getSeg_40300();
	/**
	 * Set accessor for persistent attribute: seg_40300
	 */
	public abstract void setSeg_40300(java.math.BigDecimal newSeg_40300);
	/**
	 * Get accessor for persistent attribute: seg_40400
	 */
	public abstract java.math.BigDecimal getSeg_40400();
	/**
	 * Set accessor for persistent attribute: seg_40400
	 */
	public abstract void setSeg_40400(java.math.BigDecimal newSeg_40400);
	/**
	 * Get accessor for persistent attribute: seg_50100
	 */
	public abstract java.math.BigDecimal getSeg_50100();
	/**
	 * Set accessor for persistent attribute: seg_50100
	 */
	public abstract void setSeg_50100(java.math.BigDecimal newSeg_50100);
	/**
	 * Get accessor for persistent attribute: seg_50200
	 */
	public abstract java.math.BigDecimal getSeg_50200();
	/**
	 * Set accessor for persistent attribute: seg_50200
	 */
	public abstract void setSeg_50200(java.math.BigDecimal newSeg_50200);
	/**
	 * Get accessor for persistent attribute: seg_50300
	 */
	public abstract java.math.BigDecimal getSeg_50300();
	/**
	 * Set accessor for persistent attribute: seg_50300
	 */
	public abstract void setSeg_50300(java.math.BigDecimal newSeg_50300);
	/**
	 * Get accessor for persistent attribute: seg_50400
	 */
	public abstract java.math.BigDecimal getSeg_50400();
	/**
	 * Set accessor for persistent attribute: seg_50400
	 */
	public abstract void setSeg_50400(java.math.BigDecimal newSeg_50400);
	/**
	 * Get accessor for persistent attribute: seg_60100
	 */
	public abstract java.math.BigDecimal getSeg_60100();
	/**
	 * Set accessor for persistent attribute: seg_60100
	 */
	public abstract void setSeg_60100(java.math.BigDecimal newSeg_60100);
	/**
	 * Get accessor for persistent attribute: seg_60200
	 */
	public abstract java.math.BigDecimal getSeg_60200();
	/**
	 * Set accessor for persistent attribute: seg_60200
	 */
	public abstract void setSeg_60200(java.math.BigDecimal newSeg_60200);
	/**
	 * Get accessor for persistent attribute: seg_60300
	 */
	public abstract java.math.BigDecimal getSeg_60300();
	/**
	 * Set accessor for persistent attribute: seg_60300
	 */
	public abstract void setSeg_60300(java.math.BigDecimal newSeg_60300);
	/**
	 * Get accessor for persistent attribute: seg_60400
	 */
	public abstract java.math.BigDecimal getSeg_60400();
	/**
	 * Set accessor for persistent attribute: seg_60400
	 */
	public abstract void setSeg_60400(java.math.BigDecimal newSeg_60400);
	/**
	 * Get accessor for persistent attribute: seg_80100
	 */
	public abstract java.math.BigDecimal getSeg_80100();
	/**
	 * Set accessor for persistent attribute: seg_80100
	 */
	public abstract void setSeg_80100(java.math.BigDecimal newSeg_80100);
	/**
	 * Get accessor for persistent attribute: seg_80200
	 */
	public abstract java.math.BigDecimal getSeg_80200();
	/**
	 * Set accessor for persistent attribute: seg_80200
	 */
	public abstract void setSeg_80200(java.math.BigDecimal newSeg_80200);
	/**
	 * Get accessor for persistent attribute: seg_80300
	 */
	public abstract java.math.BigDecimal getSeg_80300();
	/**
	 * Set accessor for persistent attribute: seg_80300
	 */
	public abstract void setSeg_80300(java.math.BigDecimal newSeg_80300);
	/**
	 * Get accessor for persistent attribute: seg_80400
	 */
	public abstract java.math.BigDecimal getSeg_80400();
	/**
	 * Set accessor for persistent attribute: seg_80400
	 */
	public abstract void setSeg_80400(java.math.BigDecimal newSeg_80400);
	/**
	 * Get accessor for persistent attribute: seg_80500
	 */
	public abstract java.math.BigDecimal getSeg_80500();
	/**
	 * Set accessor for persistent attribute: seg_80500
	 */
	public abstract void setSeg_80500(java.math.BigDecimal newSeg_80500);
	/**
	 * Get accessor for persistent attribute: seg_80600
	 */
	public abstract java.math.BigDecimal getSeg_80600();
	/**
	 * Set accessor for persistent attribute: seg_80600
	 */
	public abstract void setSeg_80600(java.math.BigDecimal newSeg_80600);
	/**
	 * Get accessor for persistent attribute: seg_80700
	 */
	public abstract java.math.BigDecimal getSeg_80700();
	/**
	 * Set accessor for persistent attribute: seg_80700
	 */
	public abstract void setSeg_80700(java.math.BigDecimal newSeg_80700);
	/**
	 * Get accessor for persistent attribute: seg_90200
	 */
	public abstract java.math.BigDecimal getSeg_90200();
	/**
	 * Set accessor for persistent attribute: seg_90200
	 */
	public abstract void setSeg_90200(java.math.BigDecimal newSeg_90200);
	/**
	 * Get accessor for persistent attribute: seg_99900
	 */
	public abstract java.math.BigDecimal getSeg_99900();
	/**
	 * Set accessor for persistent attribute: seg_99900
	 */
	public abstract void setSeg_99900(java.math.BigDecimal newSeg_99900);
	/**
	 * Get accessor for persistent attribute: desvin
	 */
	public abstract java.math.BigDecimal getDesvin();
	/**
	 * Set accessor for persistent attribute: desvin
	 */
	public abstract void setDesvin(java.math.BigDecimal newDesvin);
	/**
	 * Get accessor for persistent attribute: pocovin
	 */
	public abstract java.math.BigDecimal getPocovin();
	/**
	 * Set accessor for persistent attribute: pocovin
	 */
	public abstract void setPocovin(java.math.BigDecimal newPocovin);
	/**
	 * Get accessor for persistent attribute: vin
	 */
	public abstract java.math.BigDecimal getVin();
	/**
	 * Set accessor for persistent attribute: vin
	 */
	public abstract void setVin(java.math.BigDecimal newVin);
	/**
	 * Get accessor for persistent attribute: muyvin
	 */
	public abstract java.math.BigDecimal getMuyvin();
	/**
	 * Set accessor for persistent attribute: muyvin
	 */
	public abstract void setMuyvin(java.math.BigDecimal newMuyvin);
	/**
	 * Get accessor for persistent attribute: natdesvin
	 */
	public abstract java.math.BigDecimal getNatdesvin();
	/**
	 * Set accessor for persistent attribute: natdesvin
	 */
	public abstract void setNatdesvin(java.math.BigDecimal newNatdesvin);
	/**
	 * Get accessor for persistent attribute: natvin
	 */
	public abstract java.math.BigDecimal getNatvin();
	/**
	 * Set accessor for persistent attribute: natvin
	 */
	public abstract void setNatvin(java.math.BigDecimal newNatvin);
	/**
	 * Get accessor for persistent attribute: jurvin
	 */
	public abstract java.math.BigDecimal getJurvin();
	/**
	 * Set accessor for persistent attribute: jurvin
	 */
	public abstract void setJurvin(java.math.BigDecimal newJurvin);
	/**
	 * Get accessor for persistent attribute: ahor_t
	 */
	public abstract java.math.BigDecimal getAhor_t();
	/**
	 * Set accessor for persistent attribute: ahor_t
	 */
	public abstract void setAhor_t(java.math.BigDecimal newAhor_t);
	/**
	 * Get accessor for persistent attribute: ahsd_t
	 */
	public abstract java.math.BigDecimal getAhsd_t();
	/**
	 * Set accessor for persistent attribute: ahsd_t
	 */
	public abstract void setAhsd_t(java.math.BigDecimal newAhsd_t);
	/**
	 * Get accessor for persistent attribute: aval_t
	 */
	public abstract java.math.BigDecimal getAval_t();
	/**
	 * Set accessor for persistent attribute: aval_t
	 */
	public abstract void setAval_t(java.math.BigDecimal newAval_t);
	/**
	 * Get accessor for persistent attribute: b24_t
	 */
	public abstract java.math.BigDecimal getB24_t();
	/**
	 * Set accessor for persistent attribute: b24_t
	 */
	public abstract void setB24_t(java.math.BigDecimal newB24_t);
	/**
	 * Get accessor for persistent attribute: ccte_t
	 */
	public abstract java.math.BigDecimal getCcte_t();
	/**
	 * Set accessor for persistent attribute: ccte_t
	 */
	public abstract void setCcte_t(java.math.BigDecimal newCcte_t);
	/**
	 * Get accessor for persistent attribute: cext_t
	 */
	public abstract java.math.BigDecimal getCext_t();
	/**
	 * Set accessor for persistent attribute: cext_t
	 */
	public abstract void setCext_t(java.math.BigDecimal newCext_t);
	/**
	 * Get accessor for persistent attribute: cloc_t
	 */
	public abstract java.math.BigDecimal getCloc_t();
	/**
	 * Set accessor for persistent attribute: cloc_t
	 */
	public abstract void setCloc_t(java.math.BigDecimal newCloc_t);
	/**
	 * Get accessor for persistent attribute: colb_t
	 */
	public abstract java.math.BigDecimal getColb_t();
	/**
	 * Set accessor for persistent attribute: colb_t
	 */
	public abstract void setColb_t(java.math.BigDecimal newColb_t);
	/**
	 * Get accessor for persistent attribute: cpte_t
	 */
	public abstract java.math.BigDecimal getCpte_t();
	/**
	 * Set accessor for persistent attribute: cpte_t
	 */
	public abstract void setCpte_t(java.math.BigDecimal newCpte_t);
	/**
	 * Get accessor for persistent attribute: cts_t
	 */
	public abstract java.math.BigDecimal getCts_t();
	/**
	 * Set accessor for persistent attribute: cts_t
	 */
	public abstract void setCts_t(java.math.BigDecimal newCts_t);
	/**
	 * Get accessor for persistent attribute: ctsd_t
	 */
	public abstract java.math.BigDecimal getCtsd_t();
	/**
	 * Set accessor for persistent attribute: ctsd_t
	 */
	public abstract void setCtsd_t(java.math.BigDecimal newCtsd_t);
	/**
	 * Get accessor for persistent attribute: vip_t
	 */
	public abstract java.math.BigDecimal getVip_t();
	/**
	 * Set accessor for persistent attribute: vip_t
	 */
	public abstract void setVip_t(java.math.BigDecimal newVip_t);
	/**
	 * Get accessor for persistent attribute: dsct_t
	 */
	public abstract java.math.BigDecimal getDsct_t();
	/**
	 * Set accessor for persistent attribute: dsct_t
	 */
	public abstract void setDsct_t(java.math.BigDecimal newDsct_t);
	/**
	 * Get accessor for persistent attribute: fcex_t
	 */
	public abstract java.math.BigDecimal getFcex_t();
	/**
	 * Set accessor for persistent attribute: fcex_t
	 */
	public abstract void setFcex_t(java.math.BigDecimal newFcex_t);
	/**
	 * Get accessor for persistent attribute: fmut_t
	 */
	public abstract java.math.BigDecimal getFmut_t();
	/**
	 * Set accessor for persistent attribute: fmut_t
	 */
	public abstract void setFmut_t(java.math.BigDecimal newFmut_t);
	/**
	 * Get accessor for persistent attribute: lcta_t
	 */
	public abstract java.math.BigDecimal getLcta_t();
	/**
	 * Set accessor for persistent attribute: lcta_t
	 */
	public abstract void setLcta_t(java.math.BigDecimal newLcta_t);
	/**
	 * Get accessor for persistent attribute: leas_t
	 */
	public abstract java.math.BigDecimal getLeas_t();
	/**
	 * Set accessor for persistent attribute: leas_t
	 */
	public abstract void setLeas_t(java.math.BigDecimal newLeas_t);
	/**
	 * Get accessor for persistent attribute: mcla_t
	 */
	public abstract java.math.BigDecimal getMcla_t();
	/**
	 * Set accessor for persistent attribute: mcla_t
	 */
	public abstract void setMcla_t(java.math.BigDecimal newMcla_t);
	/**
	 * Get accessor for persistent attribute: moro_t
	 */
	public abstract java.math.BigDecimal getMoro_t();
	/**
	 * Set accessor for persistent attribute: moro_t
	 */
	public abstract void setMoro_t(java.math.BigDecimal newMoro_t);
	/**
	 * Get accessor for persistent attribute: mp_t
	 */
	public abstract java.math.BigDecimal getMp_t();
	/**
	 * Set accessor for persistent attribute: mp_t
	 */
	public abstract void setMp_t(java.math.BigDecimal newMp_t);
	/**
	 * Get accessor for persistent attribute: paut_t
	 */
	public abstract java.math.BigDecimal getPaut_t();
	/**
	 * Set accessor for persistent attribute: paut_t
	 */
	public abstract void setPaut_t(java.math.BigDecimal newPaut_t);
	/**
	 * Get accessor for persistent attribute: pcom_t
	 */
	public abstract java.math.BigDecimal getPcom_t();
	/**
	 * Set accessor for persistent attribute: pcom_t
	 */
	public abstract void setPcom_t(java.math.BigDecimal newPcom_t);
	/**
	 * Get accessor for persistent attribute: per_t
	 */
	public abstract java.math.BigDecimal getPer_t();
	/**
	 * Set accessor for persistent attribute: per_t
	 */
	public abstract void setPer_t(java.math.BigDecimal newPer_t);
	/**
	 * Get accessor for persistent attribute: ph_t
	 */
	public abstract java.math.BigDecimal getPh_t();
	/**
	 * Set accessor for persistent attribute: ph_t
	 */
	public abstract void setPh_t(java.math.BigDecimal newPh_t);
	/**
	 * Get accessor for persistent attribute: phip_t
	 */
	public abstract java.math.BigDecimal getPhip_t();
	/**
	 * Set accessor for persistent attribute: phip_t
	 */
	public abstract void setPhip_t(java.math.BigDecimal newPhip_t);
	/**
	 * Get accessor for persistent attribute: plzo_t
	 */
	public abstract java.math.BigDecimal getPlzo_t();
	/**
	 * Set accessor for persistent attribute: plzo_t
	 */
	public abstract void setPlzo_t(java.math.BigDecimal newPlzo_t);
	/**
	 * Get accessor for persistent attribute: pmas_t
	 */
	public abstract java.math.BigDecimal getPmas_t();
	/**
	 * Set accessor for persistent attribute: pmas_t
	 */
	public abstract void setPmas_t(java.math.BigDecimal newPmas_t);
	/**
	 * Get accessor for persistent attribute: pmiv_t
	 */
	public abstract java.math.BigDecimal getPmiv_t();
	/**
	 * Set accessor for persistent attribute: pmiv_t
	 */
	public abstract void setPmiv_t(java.math.BigDecimal newPmiv_t);
	/**
	 * Get accessor for persistent attribute: pper_t
	 */
	public abstract java.math.BigDecimal getPper_t();
	/**
	 * Set accessor for persistent attribute: pper_t
	 */
	public abstract void setPper_t(java.math.BigDecimal newPper_t);
	/**
	 * Get accessor for persistent attribute: ppper_t
	 */
	public abstract java.math.BigDecimal getPpper_t();
	/**
	 * Set accessor for persistent attribute: ppper_t
	 */
	public abstract void setPpper_t(java.math.BigDecimal newPpper_t);
	/**
	 * Get accessor for persistent attribute: pref_t
	 */
	public abstract java.math.BigDecimal getPref_t();
	/**
	 * Set accessor for persistent attribute: pref_t
	 */
	public abstract void setPref_t(java.math.BigDecimal newPref_t);
	/**
	 * Get accessor for persistent attribute: prom_t
	 */
	public abstract java.math.BigDecimal getProm_t();
	/**
	 * Set accessor for persistent attribute: prom_t
	 */
	public abstract void setProm_t(java.math.BigDecimal newProm_t);
	/**
	 * Get accessor for persistent attribute: pser_t
	 */
	public abstract java.math.BigDecimal getPser_t();
	/**
	 * Set accessor for persistent attribute: pser_t
	 */
	public abstract void setPser_t(java.math.BigDecimal newPser_t);
	/**
	 * Get accessor for persistent attribute: pserv_t
	 */
	public abstract java.math.BigDecimal getPserv_t();
	/**
	 * Set accessor for persistent attribute: pserv_t
	 */
	public abstract void setPserv_t(java.math.BigDecimal newPserv_t);
	/**
	 * Get accessor for persistent attribute: dep_t
	 */
	public abstract java.math.BigDecimal getDep_t();
	/**
	 * Set accessor for persistent attribute: dep_t
	 */
	public abstract void setDep_t(java.math.BigDecimal newDep_t);
	/**
	 * Get accessor for persistent attribute: sdep_t
	 */
	public abstract java.math.BigDecimal getSdep_t();
	/**
	 * Set accessor for persistent attribute: sdep_t
	 */
	public abstract void setSdep_t(java.math.BigDecimal newSdep_t);
	/**
	 * Get accessor for persistent attribute: sext_t
	 */
	public abstract java.math.BigDecimal getSext_t();
	/**
	 * Set accessor for persistent attribute: sext_t
	 */
	public abstract void setSext_t(java.math.BigDecimal newSext_t);
	/**
	 * Get accessor for persistent attribute: sonc_t
	 */
	public abstract java.math.BigDecimal getSonc_t();
	/**
	 * Set accessor for persistent attribute: sonc_t
	 */
	public abstract void setSonc_t(java.math.BigDecimal newSonc_t);
	/**
	 * Get accessor for persistent attribute: spro_t
	 */
	public abstract java.math.BigDecimal getSpro_t();
	/**
	 * Set accessor for persistent attribute: spro_t
	 */
	public abstract void setSpro_t(java.math.BigDecimal newSpro_t);
	/**
	 * Get accessor for persistent attribute: vid_t
	 */
	public abstract java.math.BigDecimal getVid_t();
	/**
	 * Set accessor for persistent attribute: vid_t
	 */
	public abstract void setVid_t(java.math.BigDecimal newVid_t);
	/**
	 * Get accessor for persistent attribute: svid_t
	 */
	public abstract java.math.BigDecimal getSvid_t();
	/**
	 * Set accessor for persistent attribute: svid_t
	 */
	public abstract void setSvid_t(java.math.BigDecimal newSvid_t);
	/**
	 * Get accessor for persistent attribute: tde_t
	 */
	public abstract java.math.BigDecimal getTde_t();
	/**
	 * Set accessor for persistent attribute: tde_t
	 */
	public abstract void setTde_t(java.math.BigDecimal newTde_t);
	/**
	 * Get accessor for persistent attribute: svip_t
	 */
	public abstract java.math.BigDecimal getSvip_t();
	/**
	 * Set accessor for persistent attribute: svip_t
	 */
	public abstract void setSvip_t(java.math.BigDecimal newSvip_t);
	/**
	 * Get accessor for persistent attribute: tvip_t
	 */
	public abstract java.math.BigDecimal getTvip_t();
	/**
	 * Set accessor for persistent attribute: tvip_t
	 */
	public abstract void setTvip_t(java.math.BigDecimal newTvip_t);
	/**
	 * Get accessor for persistent attribute: varc_t
	 */
	public abstract java.math.BigDecimal getVarc_t();
	/**
	 * Set accessor for persistent attribute: varc_t
	 */
	public abstract void setVarc_t(java.math.BigDecimal newVarc_t);
	/**
	 * Get accessor for persistent attribute: vcla_t
	 */
	public abstract java.math.BigDecimal getVcla_t();
	/**
	 * Set accessor for persistent attribute: vcla_t
	 */
	public abstract void setVcla_t(java.math.BigDecimal newVcla_t);
	/**
	 * Get accessor for persistent attribute: vctr_t
	 */
	public abstract java.math.BigDecimal getVctr_t();
	/**
	 * Set accessor for persistent attribute: vctr_t
	 */
	public abstract void setVctr_t(java.math.BigDecimal newVctr_t);
	/**
	 * Get accessor for persistent attribute: vemp_t
	 */
	public abstract java.math.BigDecimal getVemp_t();
	/**
	 * Set accessor for persistent attribute: vemp_t
	 */
	public abstract void setVemp_t(java.math.BigDecimal newVemp_t);
	/**
	 * Get accessor for persistent attribute: vnac_t
	 */
	public abstract java.math.BigDecimal getVnac_t();
	/**
	 * Set accessor for persistent attribute: vnac_t
	 */
	public abstract void setVnac_t(java.math.BigDecimal newVnac_t);
	/**
	 * Get accessor for persistent attribute: voro_t
	 */
	public abstract java.math.BigDecimal getVoro_t();
	/**
	 * Set accessor for persistent attribute: voro_t
	 */
	public abstract void setVoro_t(java.math.BigDecimal newVoro_t);
	/**
	 * Get accessor for persistent attribute: vpla_t
	 */
	public abstract java.math.BigDecimal getVpla_t();
	/**
	 * Set accessor for persistent attribute: vpla_t
	 */
	public abstract void setVpla_t(java.math.BigDecimal newVpla_t);
	/**
	 * Get accessor for persistent attribute: vpola_t
	 */
	public abstract java.math.BigDecimal getVpola_t();
	/**
	 * Set accessor for persistent attribute: vpola_t
	 */
	public abstract void setVpola_t(java.math.BigDecimal newVpola_t);
	/**
	 * Get accessor for persistent attribute: vrep_t
	 */
	public abstract java.math.BigDecimal getVrep_t();
	/**
	 * Set accessor for persistent attribute: vrep_t
	 */
	public abstract void setVrep_t(java.math.BigDecimal newVrep_t);
	/**
	 * Get accessor for persistent attribute: tdeb_t
	 */
	public abstract java.math.BigDecimal getTdeb_t();
	/**
	 * Set accessor for persistent attribute: tdeb_t
	 */
	public abstract void setTdeb_t(java.math.BigDecimal newTdeb_t);
	/**
	 * Get accessor for persistent attribute: cnet_t
	 */
	public abstract java.math.BigDecimal getCnet_t();
	/**
	 * Set accessor for persistent attribute: cnet_t
	 */
	public abstract void setCnet_t(java.math.BigDecimal newCnet_t);
	/**
	 * Get accessor for persistent attribute: linco_t
	 */
	public abstract java.math.BigDecimal getLinco_t();
	/**
	 * Set accessor for persistent attribute: linco_t
	 */
	public abstract void setLinco_t(java.math.BigDecimal newLinco_t);
	/**
	 * Get accessor for persistent attribute: pos_t
	 */
	public abstract java.math.BigDecimal getPos_t();
	/**
	 * Set accessor for persistent attribute: pos_t
	 */
	public abstract void setPos_t(java.math.BigDecimal newPos_t);
	/**
	 * Get accessor for persistent attribute: emph_t
	 */
	public abstract java.math.BigDecimal getEmph_t();
	/**
	 * Set accessor for persistent attribute: emph_t
	 */
	public abstract void setEmph_t(java.math.BigDecimal newEmph_t);
	/**
	 * Get accessor for persistent attribute: riesgo_d_t
	 */
	public abstract java.math.BigDecimal getRiesgo_d_t();
	/**
	 * Set accessor for persistent attribute: riesgo_d_t
	 */
	public abstract void setRiesgo_d_t(java.math.BigDecimal newRiesgo_d_t);
	/**
	 * Get accessor for persistent attribute: riesgo_i_t
	 */
	public abstract java.math.BigDecimal getRiesgo_i_t();
	/**
	 * Set accessor for persistent attribute: riesgo_i_t
	 */
	public abstract void setRiesgo_i_t(java.math.BigDecimal newRiesgo_i_t);
	/**
	 * Get accessor for persistent attribute: riesgo_t
	 */
	public abstract java.math.BigDecimal getRiesgo_t();
	/**
	 * Set accessor for persistent attribute: riesgo_t
	 */
	public abstract void setRiesgo_t(java.math.BigDecimal newRiesgo_t);
	/**
	 * Get accessor for persistent attribute: pasivo_t
	 */
	public abstract java.math.BigDecimal getPasivo_t();
	/**
	 * Set accessor for persistent attribute: pasivo_t
	 */
	public abstract void setPasivo_t(java.math.BigDecimal newPasivo_t);
	/**
	 * Get accessor for persistent attribute: volumen_t
	 */
	public abstract java.math.BigDecimal getVolumen_t();
	/**
	 * Set accessor for persistent attribute: volumen_t
	 */
	public abstract void setVolumen_t(java.math.BigDecimal newVolumen_t);
	/**
	 * Get accessor for persistent attribute: sum_t_act
	 */
	public abstract java.math.BigDecimal getSum_t_act();
	/**
	 * Set accessor for persistent attribute: sum_t_act
	 */
	public abstract void setSum_t_act(java.math.BigDecimal newSum_t_act);
	/**
	 * Get accessor for persistent attribute: sum_t_act1
	 */
	public abstract java.math.BigDecimal getSum_t_act1();
	/**
	 * Set accessor for persistent attribute: sum_t_act1
	 */
	public abstract void setSum_t_act1(java.math.BigDecimal newSum_t_act1);
	/**
	 * Get accessor for persistent attribute: sum_t_act2
	 */
	public abstract java.math.BigDecimal getSum_t_act2();
	/**
	 * Set accessor for persistent attribute: sum_t_act2
	 */
	public abstract void setSum_t_act2(java.math.BigDecimal newSum_t_act2);
	/**
	 * Get accessor for persistent attribute: sum_t_act3
	 */
	public abstract java.math.BigDecimal getSum_t_act3();
	/**
	 * Set accessor for persistent attribute: sum_t_act3
	 */
	public abstract void setSum_t_act3(java.math.BigDecimal newSum_t_act3);
	/**
	 * Get accessor for persistent attribute: sum_t_act4
	 */
	public abstract java.math.BigDecimal getSum_t_act4();
	/**
	 * Set accessor for persistent attribute: sum_t_act4
	 */
	public abstract void setSum_t_act4(java.math.BigDecimal newSum_t_act4);
	/**
	 * Get accessor for persistent attribute: sum_t_act5
	 */
	public abstract java.math.BigDecimal getSum_t_act5();
	/**
	 * Set accessor for persistent attribute: sum_t_act5
	 */
	public abstract void setSum_t_act5(java.math.BigDecimal newSum_t_act5);
	/**
	 * Get accessor for persistent attribute: sum_t_act6
	 */
	public abstract java.math.BigDecimal getSum_t_act6();
	/**
	 * Set accessor for persistent attribute: sum_t_act6
	 */
	public abstract void setSum_t_act6(java.math.BigDecimal newSum_t_act6);
	/**
	 * Get accessor for persistent attribute: sum_act_cto
	 */
	public abstract java.math.BigDecimal getSum_act_cto();
	/**
	 * Set accessor for persistent attribute: sum_act_cto
	 */
	public abstract void setSum_act_cto(java.math.BigDecimal newSum_act_cto);
	/**
	 * Get accessor for persistent attribute: sum_act_ct1
	 */
	public abstract java.math.BigDecimal getSum_act_ct1();
	/**
	 * Set accessor for persistent attribute: sum_act_ct1
	 */
	public abstract void setSum_act_ct1(java.math.BigDecimal newSum_act_ct1);
	/**
	 * Get accessor for persistent attribute: sum_act_ct2
	 */
	public abstract java.math.BigDecimal getSum_act_ct2();
	/**
	 * Set accessor for persistent attribute: sum_act_ct2
	 */
	public abstract void setSum_act_ct2(java.math.BigDecimal newSum_act_ct2);
	/**
	 * Get accessor for persistent attribute: sum_act_ct3
	 */
	public abstract java.math.BigDecimal getSum_act_ct3();
	/**
	 * Set accessor for persistent attribute: sum_act_ct3
	 */
	public abstract void setSum_act_ct3(java.math.BigDecimal newSum_act_ct3);
	/**
	 * Get accessor for persistent attribute: sum_act_ct4
	 */
	public abstract java.math.BigDecimal getSum_act_ct4();
	/**
	 * Set accessor for persistent attribute: sum_act_ct4
	 */
	public abstract void setSum_act_ct4(java.math.BigDecimal newSum_act_ct4);
	/**
	 * Get accessor for persistent attribute: sum_act_ct5
	 */
	public abstract java.math.BigDecimal getSum_act_ct5();
	/**
	 * Set accessor for persistent attribute: sum_act_ct5
	 */
	public abstract void setSum_act_ct5(java.math.BigDecimal newSum_act_ct5);
	/**
	 * Get accessor for persistent attribute: sum_act_ct6
	 */
	public abstract java.math.BigDecimal getSum_act_ct6();
	/**
	 * Set accessor for persistent attribute: sum_act_ct6
	 */
	public abstract void setSum_act_ct6(java.math.BigDecimal newSum_act_ct6);
	/**
	 * Get accessor for persistent attribute: cemp_t
	 */
	public abstract java.math.BigDecimal getCemp_t();
	/**
	 * Set accessor for persistent attribute: cemp_t
	 */
	public abstract void setCemp_t(java.math.BigDecimal newCemp_t);
	/**
	 * Get accessor for persistent attribute: cvip_t
	 */
	public abstract java.math.BigDecimal getCvip_t();
	/**
	 * Set accessor for persistent attribute: cvip_t
	 */
	public abstract void setCvip_t(java.math.BigDecimal newCvip_t);
	/**
	 * Get accessor for persistent attribute: icalicte00
	 */
	public abstract java.math.BigDecimal getIcalicte00();
	/**
	 * Set accessor for persistent attribute: icalicte00
	 */
	public abstract void setIcalicte00(java.math.BigDecimal newIcalicte00);
	/**
	 * Get accessor for persistent attribute: icalicte10
	 */
	public abstract java.math.BigDecimal getIcalicte10();
	/**
	 * Set accessor for persistent attribute: icalicte10
	 */
	public abstract void setIcalicte10(java.math.BigDecimal newIcalicte10);
	/**
	 * Get accessor for persistent attribute: icalicte20
	 */
	public abstract java.math.BigDecimal getIcalicte20();
	/**
	 * Set accessor for persistent attribute: icalicte20
	 */
	public abstract void setIcalicte20(java.math.BigDecimal newIcalicte20);
	/**
	 * Get accessor for persistent attribute: icalicte30
	 */
	public abstract java.math.BigDecimal getIcalicte30();
	/**
	 * Set accessor for persistent attribute: icalicte30
	 */
	public abstract void setIcalicte30(java.math.BigDecimal newIcalicte30);
	/**
	 * Get accessor for persistent attribute: icalicte40
	 */
	public abstract java.math.BigDecimal getIcalicte40();
	/**
	 * Set accessor for persistent attribute: icalicte40
	 */
	public abstract void setIcalicte40(java.math.BigDecimal newIcalicte40);
	/**
	 * Get accessor for persistent attribute: mofactv_t
	 */
	public abstract java.math.BigDecimal getMofactv_t();
	/**
	 * Set accessor for persistent attribute: mofactv_t
	 */
	public abstract void setMofactv_t(java.math.BigDecimal newMofactv_t);
	/**
	 * Get accessor for persistent attribute: cs000lineamaxtc_t
	 */
	public abstract java.math.BigDecimal getCs000lineamaxtc_t();
	/**
	 * Set accessor for persistent attribute: cs000lineamaxtc_t
	 */
	public abstract void setCs000lineamaxtc_t(
		java.math.BigDecimal newCs000lineamaxtc_t);
	/**
	 * Get accessor for persistent attribute: cs000mtoprestamo_t
	 */
	public abstract java.math.BigDecimal getCs000mtoprestamo_t();
	/**
	 * Set accessor for persistent attribute: cs000mtoprestamo_t
	 */
	public abstract void setCs000mtoprestamo_t(
		java.math.BigDecimal newCs000mtoprestamo_t);
	/**
	 * Get accessor for persistent attribute: montovehicular_t
	 */
	public abstract java.math.BigDecimal getMontovehicular_t();
	/**
	 * Set accessor for persistent attribute: montovehicular_t
	 */
	public abstract void setMontovehicular_t(
		java.math.BigDecimal newMontovehicular_t);
	/**
	 * Get accessor for persistent attribute: montohipotecario_t
	 */
	public abstract java.math.BigDecimal getMontohipotecario_t();
	/**
	 * Set accessor for persistent attribute: montohipotecario_t
	 */
	public abstract void setMontohipotecario_t(
		java.math.BigDecimal newMontohipotecario_t);
	/**
	 * Get accessor for persistent attribute: montosubrogados_t
	 */
	public abstract java.math.BigDecimal getMontosubrogados_t();
	/**
	 * Set accessor for persistent attribute: montosubrogados_t
	 */
	public abstract void setMontosubrogados_t(
		java.math.BigDecimal newMontosubrogados_t);
}
