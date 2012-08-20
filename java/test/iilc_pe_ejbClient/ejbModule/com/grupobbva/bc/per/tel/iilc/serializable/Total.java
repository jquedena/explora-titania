/**
 * @author: Edgar Ivan Zavaleta Sierralta
 * codigo : Administrador
 * fecha  : 26/11/2007
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;

public class Total implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String cod_total;
	protected String ind_registro;  
	
	protected String cod_territorio;  
	protected String cod_oficina;	 
	protected String cod_gestor;
	
	protected long margeno;
									
	protected long clixgest;		
	protected long seg_10100;	   
	protected long seg_10200;	   
	protected long seg_20100;	   
	protected long seg_20200;	   
	protected long seg_20300;	   
	protected long seg_20400;	   
	protected long seg_20500;	   
	protected long seg_20600;	   
	protected long seg_30100;	   
	protected long seg_30200;	   
	protected long seg_30300;	   
	protected long seg_30400;	   
	protected long seg_40100;	   
	protected long seg_40200;	   
	protected long seg_40300;	   
	protected long seg_40400;	   
	protected long seg_50100;	   
	protected long seg_50200;	   
	protected long seg_50300;	   
	protected long seg_50400;	   
	protected long seg_60100;	   
	protected long seg_60200;	   
	protected long seg_60300;	   
	protected long seg_60400;	   
	protected long seg_80100;	   
	protected long seg_80200;	   
	protected long seg_80300;	   
	protected long seg_80400;	   
	protected long seg_80500;	   
	protected long seg_80600;	   
	protected long seg_80700;	   
	protected long seg_90200;	   
	protected long seg_99900;	   
									
									
	protected long desvin;		  
	protected long pocovin;		 
	protected long vin;			 
	protected long muyvin;		  
	protected long natdesvin;	   
	protected long natvin;		  
	protected long jurvin;		  
									
	protected long icalicte00;	  
	protected long icalicte10;	  
	protected long icalicte20;	  
	protected long icalicte30;	  
	protected long icalicte40;	  
									
	protected long ahor_t;		  
	protected long ahsd_t;		  
	protected long aval_t;		  
	protected long b24_t;		   
	protected long ccte_t;		  
	protected long cext_t;		  
	protected long cloc_t;		  
	protected long colb_t;		  
	protected long cpte_t;		  
	protected long cts_t;		   
	protected long ctsd_t;		  
	protected long vip_t;		   
						
	protected long cvip_t;		  
	protected long dsct_t;		  
	protected long fcex_t;		  
	protected long fmut_t;		  
	protected long lcta_t;		  
	protected long leas_t;		  
	protected long mcla_t;		  
	protected long moro_t;		  
	protected long mp_t;			
	protected long paut_t;		  
	protected long pcom_t;		  
	protected long per_t;		   
	protected long ph_t;			
	protected long phip_t;		  
	protected long plzo_t;   
	
	protected long pmas_t;		  
	protected long pmiv_t;		  
	protected long pper_t;		  
	protected long ppper_t;		 
	protected long pref_t;		  
	protected long prom_t;		  
	protected long pser_t;		  
	protected long pserv_t;		 
	protected long dep_t;		   
	protected long sdep_t;		  
	protected long sext_t;		  
	protected long sonc_t;		  
	protected long spro_t;		  
	protected long vid_t;		   
	protected long svid_t;		  
	protected long tde_t;		   
	protected long svip_t;		  
	protected long tvip_t;		  
	protected long varc_t;		  
	protected long vcla_t;		  
	protected long vctr_t;		  
	protected long vemp_t;		  
	protected long vnac_t;		  
	protected long voro_t;		  
	protected long vpla_t;		  
	protected long vpola_t;		 
	protected long vrep_t;		  
	protected long tdeb_t;		  
	protected long cnet_t;		  
	protected long cemp_t;		
	protected long linco_t;		 
	protected long pos_t;		   
	protected long emph_t;		  
	protected long riesgo_d_t;	  
	protected long riesgo_i_t;	  
	protected long riesgo_t;		
	protected long pasivo_t;		
	protected long volumen_t;	   
	protected long sum_t_act;	   
	protected long sum_t_act1;	  
	protected long sum_t_act2;	  
	protected long sum_t_act3;	  
	protected long sum_t_act4;	  
	protected long sum_t_act5;	  
	protected long sum_t_act6;	  
	protected long sum_act_ctO;	 
	protected long sum_act_ct1;	 
	protected long sum_act_ct2;	 
	protected long sum_act_ct3;	 
	protected long sum_act_ct4;	 
	protected long sum_act_ct5;	 
	protected long sum_act_ct6;	 
	
	// ALZ (2010.11.23) CAMPOS NUEVOS (PETICION 2010-11-117)
	protected long mofactv_t;
	protected long cs000lineamaxtc_t;
	protected long cs000mtoprestamo_t;
	protected long montovehicular_t;
	protected long montohipotecario_t;
	protected long montosubrogados_t;
	
	public long getAhor_t() {
		return ahor_t;
	}
	public void setAhor_t(long ahor_t) {
		this.ahor_t = ahor_t;
	}
	public long getAhsd_t() {
		return ahsd_t;
	}
	public void setAhsd_t(long ahsd_t) {
		this.ahsd_t = ahsd_t;
	}
	public long getAval_t() {
		return aval_t;
	}
	public void setAval_t(long aval_t) {
		this.aval_t = aval_t;
	}
	public long getB24_t() {
		return b24_t;
	}
	public void setB24_t(long b24_t) {
		this.b24_t = b24_t;
	}
	public long getCcte_t() {
		return ccte_t;
	}
	public void setCcte_t(long ccte_t) {
		this.ccte_t = ccte_t;
	}
	public long getCemp_t() {
		return cemp_t;
	}
	public void setCemp_t(long cemp_t) {
		this.cemp_t = cemp_t;
	}
	public long getCext_t() {
		return cext_t;
	}
	public void setCext_t(long cext_t) {
		this.cext_t = cext_t;
	}
	public long getClixgest() {
		return clixgest;
	}
	public void setClixgest(long clixgest) {
		this.clixgest = clixgest;
	}
	public long getCloc_t() {
		return cloc_t;
	}
	public void setCloc_t(long cloc_t) {
		this.cloc_t = cloc_t;
	}
	public long getCnet_t() {
		return cnet_t;
	}
	public void setCnet_t(long cnet_t) {
		this.cnet_t = cnet_t;
	}
	public String getCod_gestor() {
		return cod_gestor;
	}
	public void setCod_gestor(String cod_gestor) {
		this.cod_gestor = cod_gestor;
	}
	public String getCod_oficina() {
		return cod_oficina;
	}
	public void setCod_oficina(String cod_oficina) {
		this.cod_oficina = cod_oficina;
	}
	public String getCod_territorio() {
		return cod_territorio;
	}
	public void setCod_territorio(String cod_territorio) {
		this.cod_territorio = cod_territorio;
	}
	public String getCod_total() {
		return cod_total;
	}
	public void setCod_total(String cod_total) {
		this.cod_total = cod_total;
	}
	public long getColb_t() {
		return colb_t;
	}
	public void setColb_t(long colb_t) {
		this.colb_t = colb_t;
	}
	public long getCpte_t() {
		return cpte_t;
	}
	public void setCpte_t(long cpte_t) {
		this.cpte_t = cpte_t;
	}
	public long getCs000lineamaxtc_t() {
		return cs000lineamaxtc_t;
	}
	public void setCs000lineamaxtc_t(long cs000lineamaxtc_t) {
		this.cs000lineamaxtc_t = cs000lineamaxtc_t;
	}
	public long getCs000mtoprestamo_t() {
		return cs000mtoprestamo_t;
	}
	public void setCs000mtoprestamo_t(long cs000mtoprestamo_t) {
		this.cs000mtoprestamo_t = cs000mtoprestamo_t;
	}
	public long getCts_t() {
		return cts_t;
	}
	public void setCts_t(long cts_t) {
		this.cts_t = cts_t;
	}
	public long getCtsd_t() {
		return ctsd_t;
	}
	public void setCtsd_t(long ctsd_t) {
		this.ctsd_t = ctsd_t;
	}
	public long getCvip_t() {
		return cvip_t;
	}
	public void setCvip_t(long cvip_t) {
		this.cvip_t = cvip_t;
	}
	public long getDep_t() {
		return dep_t;
	}
	public void setDep_t(long dep_t) {
		this.dep_t = dep_t;
	}
	public long getDesvin() {
		return desvin;
	}
	public void setDesvin(long desvin) {
		this.desvin = desvin;
	}
	public long getDsct_t() {
		return dsct_t;
	}
	public void setDsct_t(long dsct_t) {
		this.dsct_t = dsct_t;
	}
	public long getEmph_t() {
		return emph_t;
	}
	public void setEmph_t(long emph_t) {
		this.emph_t = emph_t;
	}
	public long getFcex_t() {
		return fcex_t;
	}
	public void setFcex_t(long fcex_t) {
		this.fcex_t = fcex_t;
	}
	public long getFmut_t() {
		return fmut_t;
	}
	public void setFmut_t(long fmut_t) {
		this.fmut_t = fmut_t;
	}
	public long getIcalicte00() {
		return icalicte00;
	}
	public void setIcalicte00(long icalicte00) {
		this.icalicte00 = icalicte00;
	}
	public long getIcalicte10() {
		return icalicte10;
	}
	public void setIcalicte10(long icalicte10) {
		this.icalicte10 = icalicte10;
	}
	public long getIcalicte20() {
		return icalicte20;
	}
	public void setIcalicte20(long icalicte20) {
		this.icalicte20 = icalicte20;
	}
	public long getIcalicte30() {
		return icalicte30;
	}
	public void setIcalicte30(long icalicte30) {
		this.icalicte30 = icalicte30;
	}
	public long getIcalicte40() {
		return icalicte40;
	}
	public void setIcalicte40(long icalicte40) {
		this.icalicte40 = icalicte40;
	}
	public String getInd_registro() {
		return ind_registro;
	}
	public void setInd_registro(String ind_registro) {
		this.ind_registro = ind_registro;
	}
	public long getJurvin() {
		return jurvin;
	}
	public void setJurvin(long jurvin) {
		this.jurvin = jurvin;
	}
	public long getLcta_t() {
		return lcta_t;
	}
	public void setLcta_t(long lcta_t) {
		this.lcta_t = lcta_t;
	}
	public long getLeas_t() {
		return leas_t;
	}
	public void setLeas_t(long leas_t) {
		this.leas_t = leas_t;
	}
	public long getLinco_t() {
		return linco_t;
	}
	public void setLinco_t(long linco_t) {
		this.linco_t = linco_t;
	}
	public long getMargeno() {
		return margeno;
	}
	public void setMargeno(long margeno) {
		this.margeno = margeno;
	}
	public long getMcla_t() {
		return mcla_t;
	}
	public void setMcla_t(long mcla_t) {
		this.mcla_t = mcla_t;
	}
	public long getMofactv_t() {
		return mofactv_t;
	}
	public void setMofactv_t(long mofactv_t) {
		this.mofactv_t = mofactv_t;
	}
	public long getMontohipotecario_t() {
		return montohipotecario_t;
	}
	public void setMontohipotecario_t(long montohipotecario_t) {
		this.montohipotecario_t = montohipotecario_t;
	}
	public long getMontosubrogados_t() {
		return montosubrogados_t;
	}
	public void setMontosubrogados_t(long montosubrogados_t) {
		this.montosubrogados_t = montosubrogados_t;
	}
	public long getMontovehicular_t() {
		return montovehicular_t;
	}
	public void setMontovehicular_t(long montovehicular_t) {
		this.montovehicular_t = montovehicular_t;
	}
	public long getMoro_t() {
		return moro_t;
	}
	public void setMoro_t(long moro_t) {
		this.moro_t = moro_t;
	}
	public long getMp_t() {
		return mp_t;
	}
	public void setMp_t(long mp_t) {
		this.mp_t = mp_t;
	}
	public long getMuyvin() {
		return muyvin;
	}
	public void setMuyvin(long muyvin) {
		this.muyvin = muyvin;
	}
	public long getNatdesvin() {
		return natdesvin;
	}
	public void setNatdesvin(long natdesvin) {
		this.natdesvin = natdesvin;
	}
	public long getNatvin() {
		return natvin;
	}
	public void setNatvin(long natvin) {
		this.natvin = natvin;
	}
	public long getPasivo_t() {
		return pasivo_t;
	}
	public void setPasivo_t(long pasivo_t) {
		this.pasivo_t = pasivo_t;
	}
	public long getPaut_t() {
		return paut_t;
	}
	public void setPaut_t(long paut_t) {
		this.paut_t = paut_t;
	}
	public long getPcom_t() {
		return pcom_t;
	}
	public void setPcom_t(long pcom_t) {
		this.pcom_t = pcom_t;
	}
	public long getPer_t() {
		return per_t;
	}
	public void setPer_t(long per_t) {
		this.per_t = per_t;
	}
	public long getPh_t() {
		return ph_t;
	}
	public void setPh_t(long ph_t) {
		this.ph_t = ph_t;
	}
	public long getPhip_t() {
		return phip_t;
	}
	public void setPhip_t(long phip_t) {
		this.phip_t = phip_t;
	}
	public long getPlzo_t() {
		return plzo_t;
	}
	public void setPlzo_t(long plzo_t) {
		this.plzo_t = plzo_t;
	}
	public long getPmas_t() {
		return pmas_t;
	}
	public void setPmas_t(long pmas_t) {
		this.pmas_t = pmas_t;
	}
	public long getPmiv_t() {
		return pmiv_t;
	}
	public void setPmiv_t(long pmiv_t) {
		this.pmiv_t = pmiv_t;
	}
	public long getPocovin() {
		return pocovin;
	}
	public void setPocovin(long pocovin) {
		this.pocovin = pocovin;
	}
	public long getPos_t() {
		return pos_t;
	}
	public void setPos_t(long pos_t) {
		this.pos_t = pos_t;
	}
	public long getPper_t() {
		return pper_t;
	}
	public void setPper_t(long pper_t) {
		this.pper_t = pper_t;
	}
	public long getPpper_t() {
		return ppper_t;
	}
	public void setPpper_t(long ppper_t) {
		this.ppper_t = ppper_t;
	}
	public long getPref_t() {
		return pref_t;
	}
	public void setPref_t(long pref_t) {
		this.pref_t = pref_t;
	}
	public long getProm_t() {
		return prom_t;
	}
	public void setProm_t(long prom_t) {
		this.prom_t = prom_t;
	}
	public long getPser_t() {
		return pser_t;
	}
	public void setPser_t(long pser_t) {
		this.pser_t = pser_t;
	}
	public long getPserv_t() {
		return pserv_t;
	}
	public void setPserv_t(long pserv_t) {
		this.pserv_t = pserv_t;
	}
	public long getRiesgo_d_t() {
		return riesgo_d_t;
	}
	public void setRiesgo_d_t(long riesgo_d_t) {
		this.riesgo_d_t = riesgo_d_t;
	}
	public long getRiesgo_i_t() {
		return riesgo_i_t;
	}
	public void setRiesgo_i_t(long riesgo_i_t) {
		this.riesgo_i_t = riesgo_i_t;
	}
	public long getRiesgo_t() {
		return riesgo_t;
	}
	public void setRiesgo_t(long riesgo_t) {
		this.riesgo_t = riesgo_t;
	}
	public long getSdep_t() {
		return sdep_t;
	}
	public void setSdep_t(long sdep_t) {
		this.sdep_t = sdep_t;
	}
	public long getSeg_10100() {
		return seg_10100;
	}
	public void setSeg_10100(long seg_10100) {
		this.seg_10100 = seg_10100;
	}
	public long getSeg_10200() {
		return seg_10200;
	}
	public void setSeg_10200(long seg_10200) {
		this.seg_10200 = seg_10200;
	}
	public long getSeg_20100() {
		return seg_20100;
	}
	public void setSeg_20100(long seg_20100) {
		this.seg_20100 = seg_20100;
	}
	public long getSeg_20200() {
		return seg_20200;
	}
	public void setSeg_20200(long seg_20200) {
		this.seg_20200 = seg_20200;
	}
	public long getSeg_20300() {
		return seg_20300;
	}
	public void setSeg_20300(long seg_20300) {
		this.seg_20300 = seg_20300;
	}
	public long getSeg_20400() {
		return seg_20400;
	}
	public void setSeg_20400(long seg_20400) {
		this.seg_20400 = seg_20400;
	}
	public long getSeg_20500() {
		return seg_20500;
	}
	public void setSeg_20500(long seg_20500) {
		this.seg_20500 = seg_20500;
	}
	public long getSeg_20600() {
		return seg_20600;
	}
	public void setSeg_20600(long seg_20600) {
		this.seg_20600 = seg_20600;
	}
	public long getSeg_30100() {
		return seg_30100;
	}
	public void setSeg_30100(long seg_30100) {
		this.seg_30100 = seg_30100;
	}
	public long getSeg_30200() {
		return seg_30200;
	}
	public void setSeg_30200(long seg_30200) {
		this.seg_30200 = seg_30200;
	}
	public long getSeg_30300() {
		return seg_30300;
	}
	public void setSeg_30300(long seg_30300) {
		this.seg_30300 = seg_30300;
	}
	public long getSeg_30400() {
		return seg_30400;
	}
	public void setSeg_30400(long seg_30400) {
		this.seg_30400 = seg_30400;
	}
	public long getSeg_40100() {
		return seg_40100;
	}
	public void setSeg_40100(long seg_40100) {
		this.seg_40100 = seg_40100;
	}
	public long getSeg_40200() {
		return seg_40200;
	}
	public void setSeg_40200(long seg_40200) {
		this.seg_40200 = seg_40200;
	}
	public long getSeg_40300() {
		return seg_40300;
	}
	public void setSeg_40300(long seg_40300) {
		this.seg_40300 = seg_40300;
	}
	public long getSeg_40400() {
		return seg_40400;
	}
	public void setSeg_40400(long seg_40400) {
		this.seg_40400 = seg_40400;
	}
	public long getSeg_50100() {
		return seg_50100;
	}
	public void setSeg_50100(long seg_50100) {
		this.seg_50100 = seg_50100;
	}
	public long getSeg_50200() {
		return seg_50200;
	}
	public void setSeg_50200(long seg_50200) {
		this.seg_50200 = seg_50200;
	}
	public long getSeg_50300() {
		return seg_50300;
	}
	public void setSeg_50300(long seg_50300) {
		this.seg_50300 = seg_50300;
	}
	public long getSeg_50400() {
		return seg_50400;
	}
	public void setSeg_50400(long seg_50400) {
		this.seg_50400 = seg_50400;
	}
	public long getSeg_60100() {
		return seg_60100;
	}
	public void setSeg_60100(long seg_60100) {
		this.seg_60100 = seg_60100;
	}
	public long getSeg_60200() {
		return seg_60200;
	}
	public void setSeg_60200(long seg_60200) {
		this.seg_60200 = seg_60200;
	}
	public long getSeg_60300() {
		return seg_60300;
	}
	public void setSeg_60300(long seg_60300) {
		this.seg_60300 = seg_60300;
	}
	public long getSeg_60400() {
		return seg_60400;
	}
	public void setSeg_60400(long seg_60400) {
		this.seg_60400 = seg_60400;
	}
	public long getSeg_80100() {
		return seg_80100;
	}
	public void setSeg_80100(long seg_80100) {
		this.seg_80100 = seg_80100;
	}
	public long getSeg_80200() {
		return seg_80200;
	}
	public void setSeg_80200(long seg_80200) {
		this.seg_80200 = seg_80200;
	}
	public long getSeg_80300() {
		return seg_80300;
	}
	public void setSeg_80300(long seg_80300) {
		this.seg_80300 = seg_80300;
	}
	public long getSeg_80400() {
		return seg_80400;
	}
	public void setSeg_80400(long seg_80400) {
		this.seg_80400 = seg_80400;
	}
	public long getSeg_80500() {
		return seg_80500;
	}
	public void setSeg_80500(long seg_80500) {
		this.seg_80500 = seg_80500;
	}
	public long getSeg_80600() {
		return seg_80600;
	}
	public void setSeg_80600(long seg_80600) {
		this.seg_80600 = seg_80600;
	}
	public long getSeg_80700() {
		return seg_80700;
	}
	public void setSeg_80700(long seg_80700) {
		this.seg_80700 = seg_80700;
	}
	public long getSeg_90200() {
		return seg_90200;
	}
	public void setSeg_90200(long seg_90200) {
		this.seg_90200 = seg_90200;
	}
	public long getSeg_99900() {
		return seg_99900;
	}
	public void setSeg_99900(long seg_99900) {
		this.seg_99900 = seg_99900;
	}
	public long getSext_t() {
		return sext_t;
	}
	public void setSext_t(long sext_t) {
		this.sext_t = sext_t;
	}
	public long getSonc_t() {
		return sonc_t;
	}
	public void setSonc_t(long sonc_t) {
		this.sonc_t = sonc_t;
	}
	public long getSpro_t() {
		return spro_t;
	}
	public void setSpro_t(long spro_t) {
		this.spro_t = spro_t;
	}
	public long getSum_act_ct1() {
		return sum_act_ct1;
	}
	public void setSum_act_ct1(long sum_act_ct1) {
		this.sum_act_ct1 = sum_act_ct1;
	}
	public long getSum_act_ct2() {
		return sum_act_ct2;
	}
	public void setSum_act_ct2(long sum_act_ct2) {
		this.sum_act_ct2 = sum_act_ct2;
	}
	public long getSum_act_ct3() {
		return sum_act_ct3;
	}
	public void setSum_act_ct3(long sum_act_ct3) {
		this.sum_act_ct3 = sum_act_ct3;
	}
	public long getSum_act_ct4() {
		return sum_act_ct4;
	}
	public void setSum_act_ct4(long sum_act_ct4) {
		this.sum_act_ct4 = sum_act_ct4;
	}
	public long getSum_act_ct5() {
		return sum_act_ct5;
	}
	public void setSum_act_ct5(long sum_act_ct5) {
		this.sum_act_ct5 = sum_act_ct5;
	}
	public long getSum_act_ct6() {
		return sum_act_ct6;
	}
	public void setSum_act_ct6(long sum_act_ct6) {
		this.sum_act_ct6 = sum_act_ct6;
	}
	public long getSum_act_ctO() {
		return sum_act_ctO;
	}
	public void setSum_act_ctO(long sum_act_ctO) {
		this.sum_act_ctO = sum_act_ctO;
	}
	public long getSum_t_act() {
		return sum_t_act;
	}
	public void setSum_t_act(long sum_t_act) {
		this.sum_t_act = sum_t_act;
	}
	public long getSum_t_act1() {
		return sum_t_act1;
	}
	public void setSum_t_act1(long sum_t_act1) {
		this.sum_t_act1 = sum_t_act1;
	}
	public long getSum_t_act2() {
		return sum_t_act2;
	}
	public void setSum_t_act2(long sum_t_act2) {
		this.sum_t_act2 = sum_t_act2;
	}
	public long getSum_t_act3() {
		return sum_t_act3;
	}
	public void setSum_t_act3(long sum_t_act3) {
		this.sum_t_act3 = sum_t_act3;
	}
	public long getSum_t_act4() {
		return sum_t_act4;
	}
	public void setSum_t_act4(long sum_t_act4) {
		this.sum_t_act4 = sum_t_act4;
	}
	public long getSum_t_act5() {
		return sum_t_act5;
	}
	public void setSum_t_act5(long sum_t_act5) {
		this.sum_t_act5 = sum_t_act5;
	}
	public long getSum_t_act6() {
		return sum_t_act6;
	}
	public void setSum_t_act6(long sum_t_act6) {
		this.sum_t_act6 = sum_t_act6;
	}
	public long getSvid_t() {
		return svid_t;
	}
	public void setSvid_t(long svid_t) {
		this.svid_t = svid_t;
	}
	public long getSvip_t() {
		return svip_t;
	}
	public void setSvip_t(long svip_t) {
		this.svip_t = svip_t;
	}
	public long getTde_t() {
		return tde_t;
	}
	public void setTde_t(long tde_t) {
		this.tde_t = tde_t;
	}
	public long getTdeb_t() {
		return tdeb_t;
	}
	public void setTdeb_t(long tdeb_t) {
		this.tdeb_t = tdeb_t;
	}
	public long getTvip_t() {
		return tvip_t;
	}
	public void setTvip_t(long tvip_t) {
		this.tvip_t = tvip_t;
	}
	public long getVarc_t() {
		return varc_t;
	}
	public void setVarc_t(long varc_t) {
		this.varc_t = varc_t;
	}
	public long getVcla_t() {
		return vcla_t;
	}
	public void setVcla_t(long vcla_t) {
		this.vcla_t = vcla_t;
	}
	public long getVctr_t() {
		return vctr_t;
	}
	public void setVctr_t(long vctr_t) {
		this.vctr_t = vctr_t;
	}
	public long getVemp_t() {
		return vemp_t;
	}
	public void setVemp_t(long vemp_t) {
		this.vemp_t = vemp_t;
	}
	public long getVid_t() {
		return vid_t;
	}
	public void setVid_t(long vid_t) {
		this.vid_t = vid_t;
	}
	public long getVin() {
		return vin;
	}
	public void setVin(long vin) {
		this.vin = vin;
	}
	public long getVip_t() {
		return vip_t;
	}
	public void setVip_t(long vip_t) {
		this.vip_t = vip_t;
	}
	public long getVnac_t() {
		return vnac_t;
	}
	public void setVnac_t(long vnac_t) {
		this.vnac_t = vnac_t;
	}
	public long getVolumen_t() {
		return volumen_t;
	}
	public void setVolumen_t(long volumen_t) {
		this.volumen_t = volumen_t;
	}
	public long getVoro_t() {
		return voro_t;
	}
	public void setVoro_t(long voro_t) {
		this.voro_t = voro_t;
	}
	public long getVpla_t() {
		return vpla_t;
	}
	public void setVpla_t(long vpla_t) {
		this.vpla_t = vpla_t;
	}
	public long getVpola_t() {
		return vpola_t;
	}
	public void setVpola_t(long vpola_t) {
		this.vpola_t = vpola_t;
	}
	public long getVrep_t() {
		return vrep_t;
	}
	public void setVrep_t(long vrep_t) {
		this.vrep_t = vrep_t;
	}
}
