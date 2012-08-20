package com.grupobbva.bc.per.tel.iilc.session;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.FinderException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocal;
import com.grupobbva.bc.per.tel.iilc.entity.Tiilc_totalLocalHome;
import com.grupobbva.bc.per.tel.iilc.serializable.Total;

/**
 * Bean implementation class for Enterprise Bean: SessionTotal
 */

@SuppressWarnings({"unchecked"})
public class SessionTotalBean implements javax.ejb.SessionBean {

	private static final long serialVersionUID = 1L;
	private javax.ejb.SessionContext mySessionCtx;
    /**
     * getSessionContext
     */
    public javax.ejb.SessionContext getSessionContext() {
        return mySessionCtx;
    }
    /**
     * setSessionContext
     */
    public void setSessionContext(javax.ejb.SessionContext ctx) {
        mySessionCtx = ctx;
    }
    /**
     * ejbCreate
     */
    public void ejbCreate() throws javax.ejb.CreateException {
    }
    /**
     * ejbActivate
     */
    public void ejbActivate() {
    }
    /**
     * ejbPassivate
     */
    public void ejbPassivate() {
    }
    /**
     * ejbRemove
     */
    public void ejbRemove() {
    }
    
    public Total findTotal(String ind_registro, String cod_territorio, String cod_oficina, String cod_gestor) throws FinderException {
    	Total total = new Total();
        InitialContext contexto;
		Tiilc_totalLocalHome totalLocalHome = null;
		Collection totalCollection = null;
		Iterator totalIterator = null;
		Object obj = null;
		try {

			contexto = new InitialContext(System.getProperties());
			obj = (Object) contexto.lookup(Constantes.EJB_TOTAL);
			totalLocalHome = (Tiilc_totalLocalHome) javax.rmi.PortableRemoteObject
					.narrow(obj, Tiilc_totalLocalHome.class);
			totalCollection = totalLocalHome.findTotalxGexOfxTe(ind_registro, cod_territorio,cod_oficina, cod_gestor);
			totalIterator = totalCollection.iterator();
			
			while (totalIterator.hasNext()){
				Tiilc_totalLocal totalLocal = (Tiilc_totalLocal) totalIterator.next();
				total.setSum_act_ct2(total.getSum_act_ct2() + totalLocal.getSum_act_ct2().longValue());         
                total.setSum_act_ct3(total.getSum_act_ct3() + totalLocal.getSum_act_ct3().longValue());         
                total.setSum_act_ct4(total.getSum_act_ct4() + totalLocal.getSum_act_ct4().longValue());         
                total.setSum_act_ct5(total.getSum_act_ct5() + totalLocal.getSum_act_ct5().longValue());         
                total.setSum_act_ct6(total.getSum_act_ct6() + totalLocal.getSum_act_ct6().longValue());             
                
                
                total.setRiesgo_d_t(total.getRiesgo_d_t() + totalLocal.getRiesgo_d_t().longValue());               
                total.setRiesgo_i_t(total.getRiesgo_i_t() + totalLocal.getRiesgo_i_t().longValue());               
                total.setRiesgo_t(total.getRiesgo_t() + totalLocal.getRiesgo_t().longValue());                   
                total.setPasivo_t(total.getPasivo_t() + totalLocal.getPasivo_t().longValue());                   
                total.setVolumen_t(total.getVolumen_t() + totalLocal.getVolumen_t().longValue());                 
                                                                                                                                                       
                total.setPper_t(total.getPper_t() + totalLocal.getPper_t().longValue());                         
                total.setPaut_t(total.getPaut_t() + totalLocal.getPaut_t().longValue());                         
                total.setPhip_t(total.getPhip_t() + totalLocal.getPhip_t().longValue());                         
                total.setPmiv_t(total.getPmiv_t() + totalLocal.getPmiv_t().longValue());                         
                total.setCpte_t(total.getCpte_t() + totalLocal.getCpte_t().longValue());                         
                total.setPmas_t(total.getPmas_t() + totalLocal.getPmas_t().longValue());                         
                total.setPcom_t(total.getPcom_t() + totalLocal.getPcom_t().longValue());                         
                total.setDsct_t(total.getDsct_t() + totalLocal.getDsct_t().longValue());                         
                total.setLeas_t(total.getLeas_t() + totalLocal.getLeas_t().longValue());                         
                total.setCloc_t(total.getCloc_t() + totalLocal.getCloc_t().longValue());                         
                total.setPref_t(total.getPref_t() + totalLocal.getPref_t().longValue());                         
                total.setLcta_t(total.getLcta_t() + totalLocal.getLcta_t().longValue());                         
                total.setProm_t(total.getProm_t() + totalLocal.getProm_t().longValue());                         
                total.setFcex_t(total.getFcex_t() + totalLocal.getFcex_t().longValue());                         
                total.setAval_t(total.getAval_t() + totalLocal.getAval_t().longValue());                         
                total.setSum_t_act2(total.getSum_t_act2() + totalLocal.getSum_t_act2().longValue());              
                
                total.setVnac_t(total.getVnac_t() + totalLocal.getVnac_t().longValue());                         
                total.setVarc_t(total.getVarc_t() + totalLocal.getVarc_t().longValue());                         
                total.setVcla_t(total.getVcla_t() + totalLocal.getVcla_t().longValue());                         
                total.setVrep_t(total.getVrep_t() + totalLocal.getVrep_t().longValue());                         
                total.setVoro_t(total.getVoro_t() + totalLocal.getVoro_t().longValue());                         
                total.setVpla_t(total.getVpla_t() + totalLocal.getVpla_t().longValue());                         
                total.setVemp_t(total.getVemp_t() + totalLocal.getVemp_t().longValue());                         
                total.setVctr_t(total.getVctr_t() + totalLocal.getVctr_t().longValue());                         
                total.setMcla_t(total.getMcla_t() + totalLocal.getMcla_t().longValue());                         
                total.setMoro_t(total.getMoro_t() + totalLocal.getMoro_t().longValue());                         
                total.setSum_t_act3(total.getSum_t_act3() + totalLocal.getSum_t_act3().longValue());             
                
                total.setCcte_t(total.getCcte_t() + totalLocal.getCcte_t().longValue());                         
                total.setCemp_t(total.getCemp_t() + totalLocal.getCemp_t().longValue());                         
                total.setCvip_t(total.getCvip_t() + totalLocal.getCvip_t().longValue());                         
                total.setAhsd_t(total.getAhsd_t() + totalLocal.getAhsd_t().longValue());                         
                total.setAhor_t(total.getAhor_t() + totalLocal.getAhor_t().longValue());                         
                total.setPlzo_t(total.getPlzo_t() + totalLocal.getPlzo_t().longValue());                         
                total.setSdep_t(total.getSdep_t() + totalLocal.getSdep_t().longValue());                         
                total.setFmut_t(total.getFmut_t() + totalLocal.getFmut_t().longValue());                         
                total.setCts_t(total.getCts_t() + totalLocal.getCts_t().longValue());                            
                total.setCtsd_t(total.getCtsd_t() + totalLocal.getCtsd_t().longValue());                         
                total.setSum_t_act4(total.getSum_t_act4() + totalLocal.getSum_t_act4().longValue());             
                
                total.setColb_t(total.getColb_t() + totalLocal.getColb_t().longValue());                         
                total.setCext_t(total.getCext_t() + totalLocal.getCext_t().longValue());                         
                total.setSvid_t(total.getSvid_t() + totalLocal.getSvid_t().longValue());                         
                total.setSonc_t(total.getSonc_t() + totalLocal.getSonc_t().longValue());                         
                total.setSpro_t(total.getSpro_t() + totalLocal.getSpro_t().longValue());                         
                total.setPserv_t(total.getPserv_t() + totalLocal.getPserv_t().longValue());                      
                total.setPh_t(total.getPh_t() + totalLocal.getPh_t().longValue());                               
                total.setEmph_t(total.getEmph_t() + totalLocal.getEmph_t().longValue());                         
                total.setTdeb_t(total.getTdeb_t() + totalLocal.getTdeb_t().longValue());                         
                total.setTvip_t(total.getTvip_t() + totalLocal.getTvip_t().longValue());                         
                total.setSum_t_act5(total.getSum_t_act5() + totalLocal.getSum_t_act5().longValue());               
                
                total.setCnet_t(total.getCnet_t() + totalLocal.getCnet_t().longValue());                         
                total.setLinco_t(total.getLinco_t() + totalLocal.getLinco_t().longValue());                       
                total.setB24_t(total.getB24_t() + totalLocal.getB24_t().longValue());                            
                total.setPos_t(total.getPos_t() + totalLocal.getPos_t().longValue());                            
                total.setSum_t_act6(total.getSum_t_act6() + totalLocal.getSum_t_act6().longValue());  	   
                
                // ALZ (2010.11.29) Nuevos campos totalizadores (PETICION 2010-11-117)
                total.setMofactv_t(total.getMofactv_t()+totalLocal.getMofactv_t().longValue());
				total.setCs000lineamaxtc_t(total.getCs000lineamaxtc_t()+totalLocal.getCs000lineamaxtc_t().longValue());
				total.setCs000mtoprestamo_t(total.getCs000mtoprestamo_t()+totalLocal.getCs000mtoprestamo_t().longValue());
				total.setMontovehicular_t(total.getMontovehicular_t()+totalLocal.getMontovehicular_t().longValue());
				total.setMontohipotecario_t(total.getMontohipotecario_t()+totalLocal.getMontohipotecario_t().longValue());
				total.setMontosubrogados_t(total.getMontosubrogados_t()+totalLocal.getMontosubrogados_t().longValue());
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.err.println("Error al probar ejb de entidad: Naming Exception" + e.getMessage());
		}

		return total;

	}
    
    
}
