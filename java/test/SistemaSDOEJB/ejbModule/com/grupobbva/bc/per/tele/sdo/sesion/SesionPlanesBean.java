package com.grupobbva.bc.per.tele.sdo.sesion;

import java.math.BigDecimal;
import java.math.MathContext;
import java.rmi.RemoteException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.jdbc.driver.OracleTypes;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe;
import com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio;
import com.grupobbva.bc.per.tele.sdo.serializable.Plan;
import com.grupobbva.bc.per.tele.sdo.serializable.PlanAnual;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
import com.grupobbva.bc.per.tele.sdo.util.Especial;
import com.ibm.etools.service.locator.ServiceLocatorManager;

import entities.Tiido_oficinaKey;
import entities.Tiido_oficinaLocal;
import entities.Tiido_planesKey;
import entities.Tiido_planesLocal;
import entities.Tiido_planesLocalHome;
import entities.Tiido_territorioKey;
/**
 * Bean implementation class for Enterprise Bean: SesionPlanes
 */
@SuppressWarnings({"unchecked", "unused"})
public class SesionPlanesBean implements javax.ejb.SessionBean {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(SesionPlanesBean.class);
	private final static String STATIC_Tiido_planesLocalHome_REF_NAME = "ejb/Tiido_planes";
	private final static Class<?> STATIC_Tiido_planesLocalHome_CLASS = Tiido_planesLocalHome.class;
	private final static String STATIC_SesionEpigrafeHome_REF_NAME = "ejb/SesionEpigrafe";
	private final static Class<?> STATIC_SesionEpigrafeHome_CLASS = SesionEpigrafeHome.class;
	private final static String STATIC_SesionMultitablaHome_REF_NAME = "ejb/SesionMultitabla_1";
	private final static Class<?> STATIC_SesionMultitablaHome_CLASS = SesionMultitablaHome.class;

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

	public Plan findConsultaPlanesResumen(String mes, String anho,
			String codEpigrafe, String codOficina) {
		Plan plan = new Plan();
		Especial formatNumber = new Especial();
		SesionEpigrafe aSesionEpigrafe = createSesionEpigrafe();

		try {
			log.info("[SesionPlanesBean :: findConsultaPlanesResumen] Inicio");
			
			Tiido_planesLocal aTiido_planesLocal = find_Tiido_planesLocalHome_findConsultaPlanesResumen(
					mes, anho, codEpigrafe, codOficina);
			if (aTiido_planesLocal != null) {
				plan.setAjusEstiTerr(aTiido_planesLocal.getAjuste_estimado_terr());
				plan.setAjusPpto(aTiido_planesLocal.getAjus_ppto());
				plan.setAnho(aTiido_planesLocal.getAnho_plan());
				plan.setCodEpigrafe(aTiido_planesLocal.getCod_epigrafe());
				plan.setCodOficina(((Tiido_oficinaLocal)aTiido_planesLocal.getTiido_pla_oficina_fk()).getCod_ofic());
				plan.setCodTerritorio(aTiido_planesLocal
						.getTiido_pla_oficina_fk()
						.getTiido_territorio_fk().getCod_terr());
				plan.setDesvAjusPpto(aTiido_planesLocal.getDesv_ppto_ajus());
				plan.setDesvPpto(aTiido_planesLocal.getDesv_ppto());
				plan.setFactAjusGereOfic(aTiido_planesLocal.getFact_asig_gte_of());
				plan.setFactAjusSaldPunt(aTiido_planesLocal.getFac_aju_sal_pun());
				plan.setFactAjusTerri(aTiido_planesLocal.getFact_ajus_terri());
				plan.setHistBajas(aTiido_planesLocal.getHist_bajas());
				plan.setIndDor(aTiido_planesLocal.getInd_dor());
				plan.setMes(aTiido_planesLocal.getMes_plan());
				plan.setMesEval(aTiido_planesLocal.getMes_eval());
				plan.setMetaGereOficina(aTiido_planesLocal.getMet_ger_ofi());
				plan.setMetaMesSaldPunt(aTiido_planesLocal.getMet_messald_punt());
				plan.setMonto(aTiido_planesLocal.getMonto());

				// Nombre de Epigrafe
				try {
					Epigrafe anEpigrafe = aSesionEpigrafe.findByCodEpigAnho(
							codEpigrafe, anho);
					if (anEpigrafe != null) {
						plan.setNomEpigrafe(anEpigrafe.getNomEpigrafe());
					}
				} catch (RemoteException ex) {
					ex.printStackTrace();
				}

				plan.setNroMesesFalt(aTiido_planesLocal.getNro_meses_falt());
				plan.setPesoDor(aTiido_planesLocal.getPeso_dor());
				plan.setPorAlcanzado(aTiido_planesLocal.getPorc_alcanzado());
				plan.setPorcSaldMedDic(aTiido_planesLocal.getPorc_saldmedi_dic());
				plan.setPorcSaldMedJun(aTiido_planesLocal.getSaldmedi_junio());
				plan.setPrioridad(aTiido_planesLocal.getPrioridad());
				plan.setProyAjusMens(aTiido_planesLocal.getProy_ajuste_men());
				plan.setProyCrecMens(aTiido_planesLocal.getProy_crec_men());
				plan.setSaldDiciAnter(aTiido_planesLocal.getSald_dic_ante());
				plan.setSaldMediDici(aTiido_planesLocal.getSaldmedi_dic());
				plan.setSaldMediJunio(aTiido_planesLocal.getSaldmedi_junio());
				plan.setVarMes(aTiido_planesLocal.getVar_mes());
				BigDecimal metaGerente;
				/**
				 * if (plan.getMetaGereOficina() != null) { 
				 * metaGerente = new BigDecimal(formatNumber.formatoEntero(plan.getMetaGereOficina())); 
				 * } else {
				 * metaGerente = new BigDecimal("0"); 
				 * }
				 */

				if (plan.getFactAjusGereOfic() != null) {
					metaGerente = new BigDecimal(formatNumber.formatoEntero(plan.getFactAjusGereOfic()));
				} else {
					metaGerente = new BigDecimal("0");
				}

				BigDecimal facAjustTerritorial;
				if (plan.getFactAjusTerri() != null) {
					facAjustTerritorial = new BigDecimal(formatNumber.formatoEntero(plan.getFactAjusTerri()));
				} else {
					facAjustTerritorial = new BigDecimal("0");
				}

				BigDecimal restoOficina = new BigDecimal("0");
				restoOficina = facAjustTerritorial.subtract(metaGerente);
				plan.setRestoOficina(restoOficina);

				if (aTiido_planesLocal.getFact_ajus_terri() != null) {
					plan.setFactAjusTerri(new BigDecimal(formatNumber.formatoEntero(aTiido_planesLocal.getFact_ajus_terri())));
				} else {
					plan.setFactAjusTerri(new BigDecimal("0"));
				}
			}
			
			log.info("[SesionPlanesBean :: findConsultaPlanesResumen] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: findConsultaPlanesResumen] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return plan;
	}

	public Vector findConsultaPlanes(String codTerritorio, String codOficina,
			String anho, String mes, String presuReferencia) {

		Vector listaPlanes = new Vector();
		Tiido_planesLocal planesLocal = null;
		String mesAnterior = mes;
		String anhoAnterior = anho;
		Especial formatNumber = new Especial();
		SesionMultitabla aSesionMultitabla = null;
		SesionEpigrafe aSesionEpi = null;
		int primerMesPresupuesto = 99;
		
		log.info("[SesionPlanesBean :: findConsultaPlanes] Inicio");
		
		if (mes.equals("01")) {
			mesAnterior = "12";
			anhoAnterior = String.valueOf(Integer.parseInt(anho) - 1);
		} else {
			if (Integer.parseInt(mes) > 10) {
				mesAnterior = String.valueOf(Integer.parseInt(mes) - 1);
			} else {
				mesAnterior = "0" + String.valueOf(Integer.parseInt(mes) - 1);
			}
		}

		try {
			aSesionMultitabla = createSesionMultitabla();
			aSesionEpi = createSesionEpigrafe();
			primerMesPresupuesto = aSesionMultitabla.obtenerPrimerMesPresup();
			Collection aCollection = null;

			if (codOficina != null && codOficina.equals("%")) {
				if (!codOficina.equals("")) {
					aCollection = find_ConsultaPlanesxTerritorio(codTerritorio, codOficina, anho, mes);
				}
			} else {
				aCollection = find_Tiido_planesLocalHome_findConsultaPlanes(codOficina, anho, mes);

				if (aCollection != null && aCollection.size() > 0) {
					Vector listaPlan = new Vector(1, 0);
					Plan plan = null;
					Iterator it = aCollection.iterator();

					while (it.hasNext()) {
						planesLocal = (Tiido_planesLocal) it.next();
						
						if(aSesionEpi.existeEpigrafe(planesLocal.getCod_epigrafe(), anho)) {
							plan = new Plan();
							plan.setCodOficina(((Tiido_oficinaKey) planesLocal.getTiido_pla_oficina_fk().getPrimaryKey()).getCod_ofic());
							plan.setCodTerritorio(planesLocal.getTiido_pla_oficina_fk().getTiido_territorio_fk().getCod_terr());
							plan.setMes(planesLocal.getMes_plan());
							plan.setAnho(planesLocal.getAnho_plan());
							plan.setCodEpigrafe(planesLocal.getCod_epigrafe());
							plan.setNomEpigrafe(planesLocal.getNom_epigrafe());
							plan.setPesoDor(planesLocal.getPeso_dor());
							plan.setMonto(planesLocal.getMonto());
							plan.setPorAlcanzado(planesLocal.getPorc_alcanzado());
							plan.setDesvPpto(planesLocal.getDesv_ppto());
							plan.setNroMesesFalt(planesLocal.getNro_meses_falt());
							plan.setProyCrecMens(planesLocal.getProy_crec_men());
							plan.setAjusEstiTerr(planesLocal.getAjuste_estimado_terr());
							plan.setProyAjusMens(planesLocal.getProy_ajuste_men());
							plan.setSaldMediJunio(planesLocal.getSaldmedi_junio());
							plan.setPorcSaldMedJun(planesLocal.getSaldmedi_junio());
							plan.setSaldDiciAnter(planesLocal.getSald_dic_ante());
							plan.setSaldMediDici(planesLocal.getSaldmedi_dic());
							plan.setCodTerritorio(planesLocal.getTiido_pla_oficina_fk().getTiido_territorio_fk().getCod_terr());
							plan.setPorcSaldMedDic(planesLocal.getPorc_saldmedi_dic());
							plan.setFactAjusSaldPunt(planesLocal.getFac_aju_sal_pun());
							plan.setHistBajas(planesLocal.getHist_bajas());
							plan.setMetaMesSaldPunt(planesLocal.getMet_messald_punt());
							plan.setMetaGereOficina(planesLocal.getMet_ger_ofi());
							plan.setPrioridad(planesLocal.getPrioridad());
							plan.setMesEval(planesLocal.getMes_eval());
							plan.setIndDor(planesLocal.getInd_dor());
							plan.setAjusPpto(planesLocal.getAjus_ppto());
							plan.setDesvAjusPpto(planesLocal.getDesv_ppto_ajus());
							plan.setFactAjusTerri(planesLocal.getFact_ajus_terri());
							plan.setFactAjusGereOfic(planesLocal.getFact_asig_gte_of());						
							
							listaPlan.add(plan);
						}
					}
					aCollection = listaPlan;
				}
			}

			Plan nuevoPlan = null;
			Iterator planesIterator = aCollection.iterator();
			while (planesIterator.hasNext()) {
				Plan plan = new Plan();
				nuevoPlan = (Plan) planesIterator.next();
				
				// Para resumen
				plan.setNuevoFactAjusGereOfic(nuevoPlan.getFactAjusGereOfic());
				plan.setAjusEstiTerr(nuevoPlan.getAjusEstiTerr());

				if (nuevoPlan.getAjusPpto() != null) {
					plan.setAjusPpto(nuevoPlan.getAjusPpto());
				} else {
					plan.setAjusPpto(new BigDecimal("0"));
				}

				plan.setAnho(nuevoPlan.getAnho());
				plan.setCodEpigrafe(nuevoPlan.getCodEpigrafe());
				plan.setCodOficina(nuevoPlan.getCodOficina());
				plan.setCodTerritorio(nuevoPlan.getCodTerritorio());

				if (nuevoPlan.getDesvAjusPpto() != null) {
					plan.setDesvAjusPpto(nuevoPlan.getDesvAjusPpto());
				} else {
					plan.setDesvAjusPpto(new BigDecimal("0"));
				}
				plan.setDesvPpto(nuevoPlan.getDesvPpto());

				if (nuevoPlan.getFactAjusGereOfic() != null) {
					plan.setFactAjusGereOfic(nuevoPlan.getFactAjusGereOfic());
				} else {
					plan.setFactAjusGereOfic(new BigDecimal("0"));
				}

				plan.setFactAjusSaldPunt(nuevoPlan.getFactAjusSaldPunt().setScale(4, BigDecimal.ROUND_HALF_UP));

				if (nuevoPlan.getFactAjusTerri() != null) {
					plan.setFactAjusTerri(new BigDecimal(formatNumber.formatoEntero(nuevoPlan.getFactAjusTerri())));
				} else {
					plan.setFactAjusTerri(new BigDecimal("0"));
				}

				plan.setHistBajas(nuevoPlan.getHistBajas());
				plan.setIndDor(nuevoPlan.getIndDor());
				plan.setMes(nuevoPlan.getMes());
				plan.setMesEval(nuevoPlan.getMesEval());
				plan.setMetaGereOficina(nuevoPlan.getMetaGereOficina());
				plan.setMetaMesSaldPunt(nuevoPlan.getMetaMesSaldPunt());
				plan.setMonto(nuevoPlan.getMonto());
				plan.setNomEpigrafe(nuevoPlan.getNomEpigrafe());
				plan.setNroMesesFalt(nuevoPlan.getNroMesesFalt());
				plan.setPesoDor(nuevoPlan.getPesoDor());
				plan.setPorAlcanzado(nuevoPlan.getPorAlcanzado());
				plan.setPorcSaldMedDic(nuevoPlan.getPorcSaldMedDic());
				plan.setPorcSaldMedJun(nuevoPlan.getPorcSaldMedJun());
				plan.setPrioridad(nuevoPlan.getPrioridad());
				plan.setProyAjusMens(nuevoPlan.getProyAjusMens());
				plan.setProyCrecMens(nuevoPlan.getProyCrecMens());
				plan.setProyCrecMensVista(nuevoPlan.getProyCrecMens() != null ? nuevoPlan.getProyCrecMens().setScale(0, BigDecimal.ROUND_HALF_UP) : new BigDecimal(0.0));
				plan.setSaldDiciAnter(nuevoPlan.getSaldDiciAnter());
				plan.setSaldMediDici(nuevoPlan.getSaldMediDici().setScale(0, BigDecimal.ROUND_HALF_UP));
				plan.setSaldMediJunio(nuevoPlan.getSaldMediJunio().setScale(0, BigDecimal.ROUND_HALF_UP));
				SesionEpigrafe aSesionEpigrafe = createSesionEpigrafe();
				try {
					Epigrafe anEpigrafe = aSesionEpigrafe.findByCodEpigAnho(
							plan.getCodEpigrafe(), anho);
					if (anEpigrafe != null) {
						plan.setNomEpigrafe(anEpigrafe.getNomEpigrafe());
						plan.setIndClase(anEpigrafe.getIndClase());
						plan.setIndSubClase(anEpigrafe.getIndSubClase());
						plan.setOrden(anEpigrafe.getOrden());
						plan.setIndHijo(anEpigrafe.getIndHijo());
						plan.setIndAfecta(anEpigrafe.getIndAfecta());
						plan.setPorcentajeMax(anEpigrafe.getPorcentajeMax());
						plan.setPorcentajeMin(anEpigrafe.getPorcentajeMin());
					} else {
						plan.setIndAfecta("N");
					}
				} catch (RemoteException ex) {
					log.error("[SesionPlanesBean :: findConsultaPlanes] ");
					ConstantesUtil.mostrarMensajeExcepcion(ex);
				}
				
				// 201206053 - MantenimietoSDO
				/* Busqueda de el mes anterior */
				Plan aPlanLocal = find_TiidoPlan(mesAnterior, anhoAnterior, plan.getCodEpigrafe(), codOficina);
				plan.setMesMesSig(aPlanLocal != null ? aPlanLocal.getMesMesSig(): "");
				plan.setAnhoMesSig(aPlanLocal != null ? aPlanLocal.getAnhoMesSig(): "");
				plan.setCodEpiMesSig(aPlanLocal != null ? aPlanLocal.getCodEpiMesSig(): "");
				plan.setMontoMesSig(aPlanLocal != null ? aPlanLocal.getMontoMesSig(): new BigDecimal(0.0));
				/* Fin Busqueda */
				
				/* Para Actualizar el porcentaje de alcanzado */
				BigDecimal montoAux = new BigDecimal(formatNumber.formatoEntero(plan.getMonto()));

				// CAMBIO SOLICITADO SEGUN INCIDENCIA DEL 19/06/2009
				BigDecimal salMedDic = new BigDecimal(formatNumber.formatoEntero(plan.getSaldMediDici()));
				BigDecimal salMedJun = new BigDecimal(formatNumber.formatoEntero(plan.getSaldMediJunio()));
				BigDecimal metaGerente = new BigDecimal(formatNumber.formatoEntero(plan.getMetaGereOficina()));
				BigDecimal metaMesSaldPunt = new BigDecimal(formatNumber.formatoEntero(plan.getMetaMesSaldPunt()));

				BigDecimal facAjustTerritorial = null;

				if (plan.getFactAjusTerri() != null) {
					facAjustTerritorial = new BigDecimal(formatNumber.formatoEntero(plan.getFactAjusTerri()));
				} else {
					facAjustTerritorial = new BigDecimal("0");
				}
				
				// Variables a Calcular
				BigDecimal auxi = new BigDecimal("100");
				BigDecimal porcAlcanAux = BigDecimal.ZERO;
				BigDecimal porMetaGerente = BigDecimal.ZERO;
				BigDecimal restoOficina = BigDecimal.ZERO;
				BigDecimal porRestoOficina = BigDecimal.ZERO;
				BigDecimal ObjetivoMesAnterior = montoAux;
				BigDecimal ObjetivoFinalPeriodo = BigDecimal.ZERO;

				try {
					// 201206053 - Porcentaje de alcance
					/**
					 * Formula para Porcentaje de alcance segun petición 201206053 - MantenimietoSDO
					 * 		No Cartera Atrazada : Round((ObjetivoMesAnterior / ObjetivoFinalPeriodo) * 100, 0)  
					 *  	Si Cartera Atrazada : (100 - Round((ObjetivoMesAnterior / ObjetivoFinalPeriodo) * 100, 0)) + 100 
					 */
					if (presuReferencia.equals("12")) {
						if (!BigDecimal.ZERO.equals(salMedDic)) {
							ObjetivoFinalPeriodo = salMedDic;
						}
					} else {
						if (!BigDecimal.ZERO.equals(salMedDic)) {
							log.info("[SesionPlanesBean :: findConsultaPlanes] Monto:" + montoAux + " SALDO:" + salMedJun + " AUXI:" + auxi);
							ObjetivoFinalPeriodo = salMedJun;
						}
					}
					
					porcAlcanAux = ObjetivoMesAnterior.multiply(auxi).divide(ObjetivoFinalPeriodo, 0, BigDecimal.ROUND_HALF_UP);					
					if(plan.getNomEpigrafe().toLowerCase().indexOf("cartera atrasada") > -1) {
						porcAlcanAux = auxi.subtract(porcAlcanAux).add(auxi);
					}
					
					/* Parte resumen */
					if (!metaMesSaldPunt.equals(new BigDecimal("0"))) {
						log.info("[SesionPlanesBean :: findConsultaPlanes] MULTI:" + metaGerente + " DIVI:" + metaMesSaldPunt);
						
						porMetaGerente = metaGerente.multiply(auxi).divide(metaMesSaldPunt, 4);
					} else {
						porMetaGerente = new BigDecimal("0");
					}
					restoOficina = metaGerente.subtract(facAjustTerritorial);

					if (!facAjustTerritorial.equals(new BigDecimal("0"))) {
						log.info("[SesionPlanesBean :: findConsultaPlanes] MULTI:" + montoAux + " DIVI:" + facAjustTerritorial);
						
						porRestoOficina = metaGerente.subtract(facAjustTerritorial).multiply(auxi).divide(facAjustTerritorial, 4);
					} else {
						porRestoOficina = new BigDecimal("0");
					}

					plan.setPorAlcanzado(porcAlcanAux);
					plan.setPorMetaGerente(porMetaGerente);
					plan.setRestoOficina(restoOficina);
					plan.setMetaMesSaldPunt(plan.getMetaMesSaldPunt() != null ? plan.getMetaMesSaldPunt().setScale(0, BigDecimal.ROUND_HALF_UP) : new BigDecimal(0.0));

					if (plan.getMontoMesSig().doubleValue() != 0.0) {
						plan.setVarMes(plan.getMonto().subtract(plan.getMontoMesSig()).divide(plan.getMonto(), 5, BigDecimal.ROUND_HALF_UP).multiply(auxi).setScale(2, BigDecimal.ROUND_HALF_UP));
					} else {
						plan.setVarMes(new BigDecimal("0"));
					}

					int valorMes = Integer.parseInt(plan.getMesEval());
					if (valorMes < primerMesPresupuesto) {
						plan.setDesvPpto(plan.getSaldMediJunio().subtract(plan.getMonto()));
					} else {
						plan.setDesvPpto(plan.getSaldMediDici().subtract(plan.getMonto()));
					}
				} catch (Exception e) {
					log.error("[SesionPlanesBean :: findConsultaPlanes] ");
					ConstantesUtil.mostrarMensajeExcepcion(e);
				}
				// 201206053 - MantenimietoSDO
				listaPlanes.add(plan);
			}
			
			log.info("[PerfilAction :: inicioPerfil] TAMAï¿œO LISTA PLANES: " + listaPlanes.size());
			log.info("[PerfilAction :: inicioPerfil] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: findConsultaPlanes] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
		return listaPlanes;
	}
	

	public Vector findConsultarPlanesxMes(String codOficina, String anho) {
		Vector listaPlanes = new Vector();
		Tiido_planesLocal planesLocal = null;
		
		try {
			log.info("[SesionPlanesBean :: findConsultarPlanesxMes] Inicio");
			
			Collection aCollection = find_Tiido_planesLocalHome_findConsultarPlanesxMes(
					codOficina, anho);
			Iterator planesIterator = aCollection.iterator();
			while (planesIterator.hasNext()) {
				Plan plan = new Plan();
				planesLocal = (Tiido_planesLocal) planesIterator.next();
				plan.setCodEpigrafe(planesLocal.getCod_epigrafe());
				plan.setNomEpigrafe(planesLocal.getNom_epigrafe());
				plan.setMonto(planesLocal.getMonto());
				plan.setCodOficina(((Tiido_oficinaKey)planesLocal.getTiido_pla_oficina_fk()
						.getPrimaryKey()).getCod_ofic());
				plan.setMes(planesLocal.getMes_plan());
				listaPlanes.add(plan);
			}

			String anhoTemp = String.valueOf(Integer.parseInt(anho) - 1);
			Collection bCollection = find_Tiido_planesLocalHome_findConsultarPlanesxMes(
					codOficina, anhoTemp);
			Iterator planesIteratorTemp = bCollection.iterator();
			while (planesIteratorTemp.hasNext()) {
				Plan plan = new Plan();
				planesLocal = (Tiido_planesLocal) planesIteratorTemp.next();
				plan.setCodEpigrafe(planesLocal.getCod_epigrafe());
				plan.setNomEpigrafe(planesLocal.getNom_epigrafe());
				plan.setMonto(planesLocal.getMonto());
				plan.setCodOficina(((Tiido_oficinaKey)planesLocal.getTiido_pla_oficina_fk()
						.getPrimaryKey()).getCod_ofic());
				plan.setMes(planesLocal.getMes_plan());
				listaPlanes.add(plan);
			}
			
			log.info("[SesionPlanesBean :: findConsultarPlanesxMes] Fin");
			return listaPlanes;
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: findConsultarPlanesxMes] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
	}

	/** Begin: Modificado por Juan Quedena */
	public HashMap<String, Integer> findCantidadPersonal(String anho, String mes, String codOfi, String codTerr) {
		Context initialContext;
		DataSource datasource;
		Connection cnn;
		Statement stm;
		ResultSet rss;
		try {
			log.info("[SesionPlanesBean :: findCantidadPersonal] Inicio");
						
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: findCantidadPersonal] Abortado por valor Nulo");
				return null;
			}
			
			log.info("[SesionPlanesBean :: findCantidadPersonal] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				cnn = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: findCantidadPersonal] Abortado por valor Nulo");
				return null;
			}
						
			stm = cnn.createStatement();
			String sql = "select mes, anho, cod_terr, cod_ofic ";
			sql += ", sum(case when cod_perfil='GOF' then 1 else 0 end) GOF ";
			sql += ", sum(case when cod_perfil='GCO' then 1 else 0 end) GCO ";
			sql += ", sum(case when cod_perfil='GPE' then 1 else 0 end) GPE ";
			sql += ", sum(case when cod_perfil='GPT' then 1 else 0 end) GPT ";
			sql += "from ( ";
			sql += "select mes, anho, cod_gestor, cod_terr, cod_ofic, cod_perfil, count(*) "; 
			sql += "from tiido_metas_gestor ";
			sql += "where anho='" + anho + "' and mes='" + mes + "' and cod_ofic like '" + codOfi + "' and cod_terr='" + codTerr + "' ";
			sql += "group by mes, anho, cod_gestor, cod_terr, cod_ofic, cod_perfil ";
			sql += ") a group by mes, anho, cod_terr, cod_ofic";

			log.info("[SesionPlanesBean :: findCantidadPersonal] SQL: " + sql);
			rss = stm.executeQuery(sql);
			
			HashMap<String, Integer> map = new HashMap<String, Integer>(); 
			
			if (rss.next()) {
				map.put("GOF", rss.getBigDecimal("GOF").intValue());
				map.put("GCO", rss.getBigDecimal("GCO").intValue());
				map.put("GPE", rss.getBigDecimal("GPE").intValue());
				map.put("GPT", rss.getBigDecimal("GPT").intValue());
			}
			
			return map;
		} catch(Exception ex) {
			log.error(":(", ex);
			return null; 
		}
	}
	/** End: Modificado por Juan Quedena */
	
	
	/**
	 * LISTA LOS DATOS DE PLANES POR Aï¿œO Y UN DETERMINADO
	 * 
	 * @param anho
	 *            ==> El anho del plan a listar
	 * @param codOfi
	 *            ==> La oficina a listar del anho determinado
	 * @return Lista del plan anual
	 */
	public Vector findPlanAnual(String anho, String codOfi) {
		Vector res = null;
		ListabusAllTerritorio bean = null;
		SesionMultitabla aSesionMultitabla = null;
		int primerMesPresupuesto = 99;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String mesAbrevActual = null;
		int mesConsulta = 0;
		int anioConsulta = 0;
		HashMap mapEpigrafeMeta = null;
		BigDecimal meta = null;
		
		try {
			log.info("[SesionPlanesBean :: findPlanAnual] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: findPlanAnual] Fin");
				
				return null;
			}
			
			log.info("[SesionPlanesBean :: findPlanAnual] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: findPlanAnual] Fin");
				
				return null;
			}

			s = con.createStatement();

			aSesionMultitabla = createSesionMultitabla();
			primerMesPresupuesto = aSesionMultitabla.obtenerPrimerMesPresup();
			ConstantesUtil util = new ConstantesUtil(); 
			mesConsulta = Integer.parseInt(ConstantesUtil.getMesActual()); 
			anioConsulta = Integer.parseInt(ConstantesUtil.getAnioActual());
			String anioActual = ConstantesUtil.getAnioActual();
			
			mesAbrevActual  = util.litMes(mesConsulta);
			
			if(mesConsulta == 1) {
				// mesConsulta = 12;				
				anioConsulta = Integer.parseInt(anho.trim()); // anioConsulta - 1;
			} else {
				mesConsulta--;
			}
			
			if(mesAbrevActual  != null) {
				mesAbrevActual  = mesAbrevActual.substring(0, 4);
			}
			
			try {
				String _mes = ((mesConsulta <= 9) ? "0" : "") + String.valueOf(mesConsulta);  
				int _i = (anho.equalsIgnoreCase(anioActual) ? 0 : 1);
				String sql = "SELECT a.cod_epigrafe, "
						+ " NVL(ROUND(SUM(CASE WHEN a.mes_plan = '" + _mes + "' THEN a.MONTO END )), 0) AS Ener0, "
						+ " NVL(AVG(CASE WHEN a.mes_plan = '" + _mes + "' THEN a.saldmedi_junio END), 0) AS Ener_Meta0, "
						+ " NVL(ROUND(SUM(CASE WHEN a.mes_plan = '01' THEN a.MONTO END )), 0) AS Ener, "
						+ " NVL(AVG(CASE WHEN a.mes_plan = '01' THEN a.saldmedi_junio END), 0) AS Ener_Meta, "
						+ " NVL(ROUND(SUM(CASE WHEN a.mes_plan = '12' THEN a.MONTO END )), 0) AS Dici, "
						+ " NVL(AVG(CASE WHEN a.mes_plan = '12' THEN a.saldmedi_junio END), 0) AS Dici_Meta "
						+ " FROM iido.tiido_planes a WHERE cod_ofic = '"
						+ codOfi.trim()+ "' AND anho_plan = '" + (Integer.parseInt(anho.trim()) + _i) + "' " + " AND "
						+ " EXISTS(SELECT e.cod_epigrafe FROM tiido_epigrafe e where e.cod_epigrafe = a.cod_epigrafe AND e.anho = "
						+ (Integer.parseInt(anho.trim()) + _i)
						+ ") "
						+ " GROUP BY a.anho_plan, a.cod_ofic, a.cod_epigrafe "
						+ " ORDER BY a.anho_plan, a.cod_ofic, a.cod_epigrafe ";

				log.info("[SesionPlanesBean :: findPlanAnual] SQL: " + sql);
				rst = s.executeQuery(sql);
				HashMap eneroAnteriorAnio = new HashMap();
				HashMap eneroAnteriorAnioPorc = new HashMap();
				
				HashMap mesAnio = new HashMap();
				HashMap mesAnioPorc = new HashMap();
				
				HashMap<String, String> dicAnteriorAnio = new HashMap();
				HashMap<String, String> dicAnteriorAnioPorc = new HashMap();
				
				
				while (rst.next()) {
					eneroAnteriorAnio.put(rst.getString("cod_epigrafe"), rst.getString("Ener") != null ? rst.getString("Ener").toString() : "0");
					eneroAnteriorAnioPorc.put(rst.getString("cod_epigrafe"), rst.getString("Ener_Meta") != null ? rst.getString("Ener_Meta").toString() : "0");
					
					mesAnio.put(rst.getString("cod_epigrafe"), rst.getString("Ener0") != null ? rst.getString("Ener0").toString() : "0");
					mesAnioPorc.put(rst.getString("cod_epigrafe"), rst.getString("Ener_Meta0") != null ? rst.getString("Ener_Meta0").toString() : "0");
					
					dicAnteriorAnio.put(rst.getString("cod_epigrafe"), rst.getString("Dici") != null ? rst.getString("Dici").toString() : "0");
					dicAnteriorAnioPorc.put(rst.getString("cod_epigrafe"), rst.getString("Dici_Meta") != null ? rst.getString("Dici_Meta").toString() : "0");
				}
				
				
				 sql = 	"SELECT p.cod_epigrafe cod_epigrafe, ROUND(NVL(p.saldmedi_junio, 0), 0) meta " +
				 		"FROM tiido_planes p " +
						"WHERE p.cod_ofic = '" + codOfi + "' AND " + 	
						"p.anho_plan = " + (Integer.parseInt(anho.trim()) < anioConsulta ? (Integer.parseInt(anho.trim()) + 1) : anho.trim()) + " AND " + 	
						"p.mes_plan = " + (Integer.parseInt(anho.trim()) < anioConsulta ? 1 : mesConsulta) 
						+ (Integer.parseInt(anho.trim()) < anioConsulta ? "" : " AND p.mes_plan <> 1");
				 log.info("[SesionPlanesBean :: findPlanAnual] SQL: " + sql);
				 rst = s.executeQuery(sql);
				 mapEpigrafeMeta = new HashMap();
				 while (rst.next()) {
				 	mapEpigrafeMeta.put(rst.getString("cod_epigrafe"), new BigDecimal(rst.getString("meta")));
				 }				 

				sql = "SELECT a.cod_epigrafe, (select b.nom_epigrafe from IIDO.TIIDO_EPIGRAFE b Where b.cod_epigrafe = a.cod_epigrafe And b.anho = a.anho_plan) As nom_epigrafe, ";
				sql += " a.anho_plan, a.cod_ofic, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '12' THEN a.MONTO END)) AS Dici, ";
				sql += " AVG(CASE WHEN a.mes_plan = '12' THEN a.saldmedi_junio END) AS Dici_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '11' THEN a.MONTO END)) AS Novi, ";
				sql += " AVG(CASE WHEN a.mes_plan = '11' THEN a.saldmedi_junio END) AS Novi_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '10' THEN a.MONTO END))AS Octu,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '10' THEN a.saldmedi_junio END) AS Octu_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '09' THEN a.MONTO END)) AS Seti,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '09' THEN a.saldmedi_junio END) AS Seti_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '08' THEN a.MONTO END)) AS Agos,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '08' THEN a.saldmedi_junio END) AS Agos_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '07' THEN a.MONTO END)) AS Juli,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '07' THEN a.saldmedi_junio END) AS Juli_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '06' THEN a.MONTO END)) AS Juni,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '06' THEN a.saldmedi_junio END) AS Juni_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '05' THEN a.MONTO END)) AS Mayo,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '05' THEN a.saldmedi_junio END) AS Mayo_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '04' THEN a.MONTO END)) AS Abri,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '04' THEN a.saldmedi_junio END) AS Abri_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '03' THEN a.MONTO END)) AS Marz,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '03' THEN a.saldmedi_junio END) AS Marz_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '02' THEN a.MONTO END)) AS Febr,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '02' THEN a.saldmedi_junio END) AS Febr_Meta, ";
				sql += " ROUND(SUM(CASE WHEN a.mes_plan = '01' THEN a.MONTO END )) AS Ener,  ";
				sql += " AVG(CASE WHEN a.mes_plan = '01' THEN a.saldmedi_junio END) AS Ener_Meta , ";
				sql += " SUM(a.MONTO) As Total, AVG(a.PORC_ALCANZADO) As Porcentaje, ";
				sql += " (SELECT b.porcentaje_min FROM IIDO.TIIDO_EPIGRAFE b WHERE b.cod_epigrafe = a.cod_epigrafe And b.anho = a.anho_plan) porcentaje_min, ";
				sql += " (SELECT b.porcentaje_max FROM IIDO.TIIDO_EPIGRAFE b WHERE b.cod_epigrafe = a.cod_epigrafe And b.anho = a.anho_plan) porcentaje_max, ";
				sql += " (SELECT b.ind_hijo FROM IIDO.TIIDO_EPIGRAFE b WHERE b.cod_epigrafe = a.cod_epigrafe And b.anho = a.anho_plan) indhijo, ";
				sql += " MAX(prioridad) prioridad,";
				sql += " TO_CHAR(SYSDATE, 'MM') MES_ACTUAL,";
				sql += " NVL(MAX( (SELECT SUM(TOTAL) FROM IIDO.VIIDO_MIS B WHERE B.COD_EPI=A.COD_EPIGRAFE AND B.COD_OFICINA=A.COD_OFIC AND B.ANHO=A.ANHO_PLAN AND B.MES=TO_CHAR(SYSDATE, 'MM')) ), 0) TOTAL_ACTUAL ";
				sql += " From tiido_planes a Where cod_ofic = '" + codOfi.trim() + "' And anho_plan = '" + anho.trim() + "' ";
				// sql += " AND a.cod_epigrafe IN (SELECT DISTINCT p.cod_epigrafe FROM tiido_planes p WHERE p.cod_ofic = '" + codOfi + "' AND p.anho_plan = " + anioConsulta + " AND p.mes_plan = " + mesConsulta + ") ";
				sql += " AND A.COD_EPIGRAFE IN (SELECT DISTINCT P.COD_EPIGRAFE FROM TIIDO_EPIGRAFE P WHERE P.ANHO = " + anioConsulta + ") ";
				sql += " Group By a.anho_plan, a.cod_ofic, a.cod_epigrafe ";
				sql += " Order By a.anho_plan, a.cod_ofic, a.cod_epigrafe ";

				log.info("[SesionPlanesBean :: findPlanAnual] SQL: " + sql);
				rst = s.executeQuery(sql);
				double acum = 0.0;
				int cont = 0;
				
				while (rst.next()) {
					if (res == null)
						res = new Vector(0, 1);

					log.info("[SesionPlanesBean :: findPlanAnual] Ejecuto la consulta xD !!!");
					
					PlanAnual plan = new PlanAnual();
					meta = 	mapEpigrafeMeta.get(rst.getString(1)) != null ? (BigDecimal) mapEpigrafeMeta.get(rst.getString(1)) : new BigDecimal(0);					
					acum = 0.0;
					cont = 0;

					plan.setCodEpigrafe(rst.getString(1));
					plan.setNomEpigrafe(rst.getString(2));
					plan.setAnho(rst.getString(3));
					plan.setCodOficina(rst.getString(4));
					plan.setIndHijo(rst.getString("indhijo"));
					plan.setPrioridad(rst.getInt("prioridad"));

					/*if (rst.getString(33) != null) {
						plan.setTotalM(new BigDecimal(rst.getString(33)));
					} else {
						plan.setTotalM(new BigDecimal(0));
					}*/
					plan.setTotalM(meta.intValue() != 0 ?  meta : new BigDecimal(0));

					if (rst.getString(31) != null) {
						plan.setPorcentajeMin(new BigDecimal(rst.getString(31)));
					} else {
						plan.setPorcentajeMin(new BigDecimal(0));
					}

					if (rst.getString(32) != null) {
						plan.setPorcentajeMax(new BigDecimal(rst.getString(32)));
					} else {
						plan.setPorcentajeMax(new BigDecimal(0));
					}

					MathContext mathContext = new MathContext(2);
					
					// Diciembre
					if (!anho.equalsIgnoreCase(anioActual)) {
						plan.setDici(eneroAnteriorAnio.get(rst.getString(1)) != null ? new BigDecimal((String) eneroAnteriorAnio.get(rst.getString(1))): new BigDecimal(0));
						plan.setDiciP(calculoPorcentaje((String) eneroAnteriorAnio.get(rst.getString(1)), (String)eneroAnteriorAnioPorc.get(rst.getString(1))));
					} else {
						plan.setDici(BigDecimal.ZERO);
						plan.setDiciP(BigDecimal.ZERO);
					}
					// plan.setDici(dicAnteriorAnio.get(rst.getString(1)) != null ? new BigDecimal((String) dicAnteriorAnio.get(rst.getString(1))): new BigDecimal(0));
					// plan.setDiciP(calculoPorcentaje((String) dicAnteriorAnio.get(rst.getString(1)), (String) dicAnteriorAnioPorc.get(rst.getString(1))));
					
					// Noviembre
					plan.setNovi(rst.getString("Dici") != null ? new BigDecimal(rst.getString("Dici")): new BigDecimal(0));
					plan.setNoviP(calculoPorcentaje(rst.getString("Dici"), rst.getString("Dici_Meta")));
										
					// Octubre
					plan.setOctu(rst.getString("Novi") != null ? new BigDecimal(rst.getString("Novi")): new BigDecimal(0));
					plan.setOctuP(calculoPorcentaje(rst.getString("Novi"), rst.getString("Novi_Meta")));
					
					// Setiembre
					plan.setSeti(rst.getString("Octu") != null ? new BigDecimal(rst.getString("Octu")): new BigDecimal(0));
					plan.setSetiP(calculoPorcentaje(rst.getString("Octu"), rst.getString("Octu_Meta")));
					
					// Agosto
					plan.setAgos(rst.getString("Seti") != null ? new BigDecimal(rst.getString("Seti")): new BigDecimal(0));
					plan.setAgosP(calculoPorcentaje(rst.getString("Seti"), rst.getString("Seti_Meta")));
					
					// Julio
					plan.setJuli(rst.getString("Agos") != null ? new BigDecimal(rst.getString("Agos")): new BigDecimal(0));
					plan.setJuliP(calculoPorcentaje(rst.getString("Agos"), rst.getString("Agos_Meta")));
					
					// Junio
					plan.setJuni(rst.getString("Juli") != null ? new BigDecimal(rst.getString("Juli")): new BigDecimal(0));
					plan.setJuniP(calculoPorcentaje(rst.getString("Juli"), rst.getString("Juli_Meta")));
					
					// Mayo
					plan.setMayo(rst.getString("Juni") != null ? new BigDecimal(rst.getString("Juni")): new BigDecimal(0));
					plan.setMayoP(calculoPorcentaje(rst.getString("Juni"), rst.getString("Juni_Meta")));
					
					// Abril
					plan.setAbri(rst.getString("Mayo") != null ? new BigDecimal(rst.getString("Mayo")): new BigDecimal(0));
					plan.setAbriP(calculoPorcentaje(rst.getString("Mayo"), rst.getString("Mayo_Meta")));

					// Marzo
					plan.setMarz(rst.getString("Abri") != null ? new BigDecimal(rst.getString("Abri")): new BigDecimal(0));
					plan.setMarzP(calculoPorcentaje(rst.getString("Abri"), rst.getString("Abri_Meta")));
					
					// Febrero
					plan.setFebr(rst.getString("Marz") != null ? new BigDecimal(rst.getString("Marz")): new BigDecimal(0));
					plan.setFebrP(calculoPorcentaje(rst.getString("Marz"), rst.getString("Marz_Meta")));
					
					// Enero
					plan.setEner(rst.getString("Febr") != null ? new BigDecimal(rst.getString("Febr")): new BigDecimal(0));
					plan.setEnerP(calculoPorcentaje(rst.getString("Febr"), rst.getString("Febr_Meta")));
					
 					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("12")) {
						if(plan.getNovi().intValue() == 0){
							plan.setDiciP(BigDecimal.ZERO);
						}
						else {
							plan.setDiciP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getNovi(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("11")) {
						if(plan.getOctu().intValue() == 0){
							plan.setNoviP(BigDecimal.ZERO);
						}
						else {
							plan.setNoviP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getOctu(), mathContext));
						}
					}
					
					
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("10")) {
						if(plan.getSeti().intValue() == 0){
							plan.setOctuP(BigDecimal.ZERO);
						}
						else {
							plan.setOctuP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getSeti(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("09")) {
						if(plan.getAgos().intValue() == 0){
							plan.setSetiP(BigDecimal.ZERO);
						}
						else {
							plan.setSetiP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getAgos(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("08")) {
						if(plan.getJuli().intValue() == 0){
							plan.setAgosP(BigDecimal.ZERO);
						}
						else {
							plan.setAgosP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getJuli(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("07")) {
						if(plan.getJuni().intValue() == 0){
							plan.setJuliP(BigDecimal.ZERO);
						}
						else {
							plan.setJuliP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getJuni(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("06")) {
						if(plan.getMayo().intValue() == 0){
							plan.setJuniP(BigDecimal.ZERO);
						}
						else {
							plan.setJuniP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getMayo(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("05")) {
						if(plan.getAbri().intValue() == 0){
							plan.setMayoP(BigDecimal.ZERO);
						}
						else {
							plan.setMayoP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getAbri(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("04")) {
						if(plan.getAbri().intValue() == 0){
							plan.setMarzP(BigDecimal.ZERO);
						}
						else {
							plan.setAbriP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getMarz(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("03")) {
						if(plan.getFebr().intValue() == 0){
							plan.setMarzP(BigDecimal.ZERO);
						}
						else {
							plan.setMarzP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getFebr(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("02")) {
						if(plan.getEner().intValue() == 0){
							plan.setFebrP(BigDecimal.ZERO);
						}
						else {
							plan.setFebrP(rst.getBigDecimal("TOTAL_ACTUAL").divide(plan.getEner(), mathContext));
						}
					}
					if(rst.getString("MES_ACTUAL").equalsIgnoreCase("01")) {
						BigDecimal dicAnt;
						
						try {
							dicAnt = new BigDecimal(dicAnteriorAnio.get(rst.getString(1)));
						} catch (Exception e) {
							dicAnt = BigDecimal.ZERO; 
						}
						
						if(dicAnt.intValue() == 0){
							plan.setEnerP(BigDecimal.ZERO);
						}
						else {
							plan.setEnerP(rst.getBigDecimal("TOTAL_ACTUAL").divide(dicAnt, mathContext));
						}
					}
					
					// Porcentaje Total					
					//plan.setTotalP(calculoPorcentaje(rst.getString(mesAbrevActual), meta));
					if(Integer.parseInt(anho.trim()) < anioConsulta) {
						plan.setTotalP(calculoPorcentaje(rst.getString(mesAbrevActual), rst.getString(mesAbrevActual + "_Meta")));			
					} else {
						try {
							String epigrafe = rst.getString("cod_epigrafe");
							String eneAnt = mesAnio.get(epigrafe).toString();
							String eneAntPorc = mesAnioPorc.get(epigrafe).toString();
							plan.setTotalP(calculoPorcentaje(eneAnt, eneAntPorc));
						} catch (NullPointerException e) {
							plan.setTotalP(BigDecimal.ZERO);
						}
					}
					
					res.add(plan);
				}

			} catch (SQLException e) {
				log.error("[SesionPlanesBean :: findPlanAnual] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionPlanesBean :: findPlanAnual] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: findPlanAnual] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: findPlanAnual] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return res;
	}

	private BigDecimal calculoPorcentaje(String monto, BigDecimal meta) {
		BigDecimal resul = new BigDecimal(0);
		BigDecimal bgMonto = null;
		BigDecimal bgMeta = null;

		try {
			log.info("[SesionPlanesBean :: calculoPorcentaje] Inicio");
			
			if (monto == null) {
				bgMonto = new BigDecimal(0);
			} else {
				bgMonto = new BigDecimal(monto);
			}

			if (meta != null) {
				bgMeta = meta;
			} else {
				// throw new Exception("Denominador 0");
				resul = BigDecimal.ZERO;
				resul = resul.setScale(0, BigDecimal.ROUND_HALF_UP);
				return resul;
			}

			resul = bgMonto.multiply(new BigDecimal("100")).divide(bgMeta, 0, BigDecimal.ROUND_HALF_UP);
			resul = resul.setScale(0, BigDecimal.ROUND_HALF_UP);
			
			log.info("[SesionPlanesBean :: calculoPorcentaje] Fin");
		} catch (Exception e) {
			log.error("[PerfilAction :: calculoPorcentaje] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return resul;
	}
	
	private BigDecimal calculoPorcentaje(String monto, String meta) {
		BigDecimal resul = new BigDecimal(0);
		BigDecimal bgMonto = null;
		BigDecimal bgMeta = null;

		try {
			log.info("[SesionPlanesBean :: calculoPorcentaje] Inicio");
			
			if (monto == null) {
				bgMonto = new BigDecimal(0);
			} else {
				bgMonto = new BigDecimal(monto);
			}

			if (meta != null) {
				bgMeta =  new BigDecimal(meta);
			} else {
				// throw new Exception("Denominador 0");
				resul = BigDecimal.ZERO;
				resul = resul.setScale(0, BigDecimal.ROUND_HALF_UP);
				return resul;
			}
			
			resul = bgMonto.multiply(new BigDecimal("100")).divide(bgMeta, 0, BigDecimal.ROUND_HALF_UP);
			resul = resul.setScale(0, BigDecimal.ROUND_HALF_UP);
			
			log.info("[SesionPlanesBean :: calculoPorcentaje] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: calculoPorcentaje] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return resul;
	}
	
	/**
	 * ELIMINA LOS PLANES INGRESADOS MEDIANTE CARGA DE ARCHIVO
	 * 
	 * @return Borra true si es exitoso y false si no es exitoso
	 */
	/*
	 * public boolean borrarPlanIngresado() { Vector res = null;
	 * ListabusAllTerritorio bean = null; boolean fResult = false; Connection
	 * con = null; Context initialContext = null; Statement s = null; ResultSet
	 * rst = null;
	 * 
	 * try { Calendar calendario = Calendar.getInstance();
	 * 
	 * int mesA = calendario.get(Calendar.MONTH) + 1; int anhoA =
	 * calendario.get(Calendar.YEAR);
	 * 
	 * String cMesA = String.valueOf(mesA);
	 * 
	 * if (mesA < 10) { cMesA = "0" + cMesA; } // BORRAR //cMesA = "06";
	 * 
	 * con = null; initialContext = new InitialContext(); if (initialContext ==
	 * null) { return fResult; }
	 * log.info("ConstantesUtil.DATASOURCE_CONTEXT::: " +
	 * ConstantesUtil.DATASOURCE_CONTEXT); DataSource datasource = (DataSource)
	 * initialContext .lookup(ConstantesUtil.DATASOURCE_CONTEXT);
	 * 
	 * if (datasource != null) { con = datasource.getConnection(); } else {
	 * initialContext = null; return fResult; }
	 * 
	 * s = con.createStatement(); try { String sql = "Delete tiido_planes Where
	 * anho_plan = '" + anhoA + "' and mes_plan = '" + cMesA + "'";
	 * 
	 * log.info("sql::: " + sql); rst = s.executeQuery(sql); fResult =
	 * true; } catch (SQLException e1) { fResult = false; e1.printStackTrace(); } }
	 * catch (Exception e) { e.printStackTrace(); } finally { try { if(rst !=
	 * null) { rst.close(); }
	 * 
	 * if(s != null) { s.close(); }
	 * 
	 * if(con != null) { con.close(); }
	 * 
	 * if(initialContext != null) { initialContext.close(); } } catch (Exception
	 * e) { e.printStackTrace(); return false; } }
	 * 
	 * return fResult; }
	 */

	public boolean borrarPlanIngresado(String usuario) {
		boolean fResult = false;
		int mes = -1;
		int anio = -1;
		Connection con = null;
		Context initialContext = null;
		DataSource datasource = null;
		Statement s = null;
		String sql = null;
		ResultSet rst = null;

		try {
			log.info("[SesionPlanesBean :: borrarPlanIngresado] Inicio");
			
			mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
			anio = Calendar.getInstance().get(Calendar.YEAR);
			initialContext = new InitialContext();

			if (initialContext == null) {
				log.info("[SesionPlanesBean :: borrarPlanIngresado] Fin");
				
				return fResult;
			}
			
			log.info("[SesionPlanesBean :: borrarPlanIngresado] DATASOURCE_CONTEXT:" + ConstantesUtil.DATASOURCE_CONTEXT);

			datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: borrarPlanIngresado] Fin");
				
				return fResult;
			}

			s = con.createStatement();

			/*sql = "UPDATE iido.tiido_planes SET porc_alcanzado = 0, ajuste_estimado_terr = 0, "
					+ "porc_saldmedi_junio = 0, porc_saldmedi_dic = 0, ind_dor = '00', var_mes = NULL, desv_ppto = 0, "
					+ "proy_crec_men = 0, proy_ajuste_men = 0, met_messald_punt = 0, met_ger_ofi = 0, "
					+ "desv_ppto_ajus = NULL, fact_asig_gte_of = NULL, usu_actu = '" + usuario + "', fec_actu = SYSDATE " 
					+ "WHERE mes_plan = " + mes + " AND anho_plan = " + anio;*/
			sql = "Delete iido.tiido_planes Where anho_plan = '"+anio+"' and mes_plan = '"+ ConstantesUtil.dosCeros(mes)+"'";

			log.info("[SesionPlanesBean :: borrarPlanIngresado] SQL:" + sql);

			rst = s.executeQuery(sql);
			fResult = true;
			
			log.info("[SesionPlanesBean :: borrarPlanIngresado] Fin");
		} catch (SQLException e) {
			log.error("[SesionPlanesBean :: borrarPlanIngresado] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			fResult = false;
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: borrarPlanIngresado] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			fResult = false;
		} finally {
			try {
				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (SQLException e) {
				log.error("[SesionPlanesBean :: borrarPlanIngresado] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				fResult = false;
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: borrarPlanIngresado] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				fResult = false;
			}
		}

		return fResult;
	}

	public boolean updatePlan(Plan plan) {
		try {
			log.info("[SesionPlanesBean :: updatePlan] Inicio");
			
			Tiido_planesLocal aTiido_planesLocal = find_Tiido_planesLocalHome_findByPrimaryKey(new Tiido_planesKey(
					plan.getMes(), plan.getAnho(), plan.getCodEpigrafe(),
					new Tiido_oficinaKey(plan.getCodOficina(),
							new Tiido_territorioKey(plan.getCodTerritorio()))));

			// Actualizo la BD de Planes con los registros modificados
			if (aTiido_planesLocal != null) {
				aTiido_planesLocal.setAjus_ppto(plan.getAjusPpto());
				aTiido_planesLocal.setNro_meses_falt(plan.getNroMesesFalt());
				aTiido_planesLocal.setFac_aju_sal_pun(plan
						.getFactAjusSaldPunt());
				aTiido_planesLocal.setHist_bajas(plan.getHistBajas());
				aTiido_planesLocal.setFact_ajus_terri(plan.getFactAjusTerri());
				aTiido_planesLocal.setFact_asig_gte_of(plan
						.getFactAjusGereOfic());
				aTiido_planesLocal.setDesv_ppto_ajus(plan.getDesvAjusPpto());
				aTiido_planesLocal.setProy_crec_men(plan.getProyCrecMens());
				aTiido_planesLocal.setProy_ajuste_men(plan.getProyAjusMens());
				aTiido_planesLocal.setDesv_ppto(plan.getDesvPpto());
				aTiido_planesLocal.setMet_ger_ofi(plan.getMetaGereOficina());
				aTiido_planesLocal.setFact_ajus_terri(plan.getFactAjusTerri());
				aTiido_planesLocal.setPrioridad(plan.getPrioridad());
				aTiido_planesLocal.setMet_messald_punt(plan
						.getMetaMesSaldPunt());
				aTiido_planesLocal.setFec_actu(new java.util.Date());
				aTiido_planesLocal.setUsu_actu(plan.getUsuario());
			}
			
			log.info("[SesionPlanesBean :: updatePlan] Fin");
			
			return true;
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: updatePlan] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return false;
		}
	}

	public boolean createPlan(Plan plan) {
		try {
			log.info("[SesionPlanesBean :: createPlan] Inicio");
			
			Tiido_planesLocal aTiido_planesLocal = createTiido_planesLocal(plan);
			log.info("[SesionPlanesBean :: createPlan] Fin");
			if (aTiido_planesLocal != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: createPlan] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return false;
		}
	}

	public boolean createUpdatePlan(Plan plan) {
		Tiido_planesLocal aTiido_planesLocal = null;
		Tiido_planesKey pkPlanes = null;
		Tiido_oficinaKey pkOficina = null;
		Tiido_territorioKey pkTerritorio = null;
		boolean resp = false;

		try {
			log.info("[SesionPlanesBean :: createUpdatePlan] Inicio");
			
			pkTerritorio = new Tiido_territorioKey(plan.getCodTerritorio());
			pkOficina = new Tiido_oficinaKey(plan.getCodOficina(), pkTerritorio);
			pkPlanes = new Tiido_planesKey(plan.getMes(), plan.getAnho(), plan.getCodEpigrafe(), pkOficina);

			aTiido_planesLocal = find_Tiido_planesLocalHome_findByPrimaryKey(pkPlanes);
			if (aTiido_planesLocal != null) {
				aTiido_planesLocal.setNom_epigrafe(plan.getNomEpigrafe());
				aTiido_planesLocal.setPeso_dor(plan.getPesoDor());
				aTiido_planesLocal.setMonto(plan.getMonto());
				aTiido_planesLocal.setPorc_alcanzado(plan.getPorAlcanzado());
				aTiido_planesLocal.setProy_crec_men(plan.getProyCrecMens());
				aTiido_planesLocal.setAjuste_estimado_terr(plan.getAjusEstiTerr());
				aTiido_planesLocal.setProy_ajuste_men(plan.getProyAjusMens());
				aTiido_planesLocal.setSaldmedi_junio(plan.getSaldMediJunio());
				aTiido_planesLocal.setPorc_saldmedi_junio(plan.getPorcSaldMedJun());
				aTiido_planesLocal.setSald_dic_ante(plan.getSaldDiciAnter());
				aTiido_planesLocal.setSaldmedi_dic(plan.getSaldMediDici());
				aTiido_planesLocal.setPorc_saldmedi_dic(plan.getPorcSaldMedDic());
				aTiido_planesLocal.setFac_aju_sal_pun(plan.getFactAjusSaldPunt());
				aTiido_planesLocal.setHist_bajas(plan.getHistBajas());
				aTiido_planesLocal.setMet_messald_punt(plan.getMetaMesSaldPunt());
				aTiido_planesLocal.setMet_ger_ofi(plan.getMetaGereOficina());
				aTiido_planesLocal.setMes_eval(plan.getMesEval());
				aTiido_planesLocal.setInd_dor(plan.getIndDor());
				aTiido_planesLocal.setDesv_ppto(plan.getDesvPpto());
				aTiido_planesLocal.setFec_actu(new java.util.Date());
				aTiido_planesLocal.setUsu_actu(plan.getUsuario());
				
				resp = true;
			} else {				
				log.info("[SesionPlanesBean :: createUpdatePlan] CodTerritorio:" + plan.getCodTerritorio() + "-");
				aTiido_planesLocal = createTiido_planesLocal(plan);

				if (aTiido_planesLocal != null) {
					resp = true;
				} else {
					resp = false;
				}
			}
			
			log.info("[SesionPlanesBean :: createUpdatePlan] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: createUpdatePlan] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			resp = false;
		}

		return resp;
	}
	
	protected Collection find_Tiido_planesLocalHome_findConsultaPlanes(
			String codOficina, String anho, String mes) {
		
		try {
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanes] Inicio");
			
			Tiido_planesLocalHome aTiido_planesLocalHome = (Tiido_planesLocalHome) 
				ServiceLocatorManager.getLocalHome(STATIC_Tiido_planesLocalHome_REF_NAME, STATIC_Tiido_planesLocalHome_CLASS);
			
			if (aTiido_planesLocalHome != null) {
				log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanes] Fin");
				
				return aTiido_planesLocalHome.findConsultaPlanes(codOficina, anho, mes);
			}
			
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanes] Fin");
		} catch (javax.ejb.FinderException e) {
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanes] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	public Collection find_ConsultaPlanesxTerritorio(String codTerritorio,
			String codOficina, String anho, String mes) {
		Context initialContext = null;
		CallableStatement st = null;
		ResultSet rst = null;
		Connection cnt = null;
		String sql = "";
		Plan plan = null;
		Vector listaPlan = new Vector(1, 0);

		// 201206053 - Modificando Consulta
		try {
			log.info("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] Fin");
				return null;
			}
			
			DataSource datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (datasource != null) {
				cnt = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] Fin");
				return null;
			}

			try {
				/* sql = "select cod_epigrafe, nom_epigrafe, sum(peso_dor) peso_dor, sum(monto) monto, "
						+ "sum(porc_alcanzado) porc_alcanzado, sum(desv_ppto) desv_ppto, avg(nro_meses_falt) nro_meses_falt, "
						+ "sum(proy_crec_men) proy_crec_men, sum(ajuste_estimado_terr) ajuste_estimado_terr, "
						+ "sum(proy_ajuste_men) proy_ajuste_men, sum(saldmedi_junio) saldmedi_junio, "
						+ "sum(porc_saldmedi_junio) porc_saldmedi_junio, sum(sald_dic_ante) sald_dic_ante, "
						+ "sum(saldmedi_dic) saldmedi_dic, sum(porc_saldmedi_dic) porc_saldmedi_dic, "
						+ "sum(fac_aju_sal_pun) fac_aju_sal_pun, sum(hist_bajas) hist_bajas, "
						+ "sum(met_messald_punt) met_messald_punt, sum(met_ger_ofi) met_ger_ofi, "
						+ "'' prioridad, avg(mes_eval) mes_eval, sum(ind_dor) ind_dor, "
						+ "sum(var_mes) var_mes, sum(ajus_ppto) ajus_ppto, sum(desv_ppto_ajus) desv_ppto_ajus, "
						+ "sum(fact_ajus_terri) fact_ajus_terri, sum(fact_asig_gte_of) fact_asig_gte_of "
						+ "from iido.tiido_planes t "
						+ "where t.cod_terr='"
						+ codTerritorio
						+ "' and t.cod_ofic LIKE '"
						+ codOficina
						+ "' and "
						+ "t.anho_plan ='"
						+ anho
						+ "' and t.mes_plan ='"
						+ mes
						+ "' AND "
						+ " EXISTS(SELECT e.cod_epigrafe FROM tiido_epigrafe e where e.cod_epigrafe = t.cod_epigrafe AND e.anho = " + anho + ")"  
						+ "group by cod_epigrafe, nom_epigrafe"; */
				
				sql = "{call iido.pk_planes.proc_consulta_planes(?, ?, ?, ?, ?)}";
				log.info("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] SQL:" + sql);
				log.info("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] codTerritorio:" + codTerritorio);
				log.info("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] codOficina:" + codOficina);
				log.info("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] anho:" + anho);
				log.info("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] mes:" + mes);
				
	            st = cnt.prepareCall(sql);
	            st.setString("p_codTerritorio", codTerritorio);
	            st.setString("p_codOficina", codOficina);
	            st.setString("p_mes", anho);
	            st.setString("p_anho", mes);
	            st.registerOutParameter("sys_planes", OracleTypes.CURSOR);
	            
	            st.execute();
	            
	            rst = (ResultSet) st.getObject("sys_planes");
				
				while (rst.next()) {
					plan = new Plan();
					plan.setCodOficina("");
					plan.setCodTerritorio(codTerritorio);
					plan.setMes(mes);
					plan.setAnho(anho);
					plan.setCodEpigrafe(rst.getString("cod_epigrafe"));
					plan.setNomEpigrafe(rst.getString("nom_epigrafe"));
					plan.setPesoDor(rst.getBigDecimal("peso_dor"));
					plan.setMonto(rst.getBigDecimal("monto"));
					plan.setPorAlcanzado(rst.getBigDecimal("porc_alcanzado"));
					plan.setDesvPpto(rst.getBigDecimal("desv_ppto"));
					plan.setNroMesesFalt(rst.getBigDecimal("nro_meses_falt"));
					plan.setProyCrecMens(rst.getBigDecimal("proy_crec_men"));
					plan.setAjusEstiTerr(rst.getBigDecimal("ajuste_estimado_terr"));
					plan.setProyAjusMens(rst.getBigDecimal("proy_ajuste_men"));
					plan.setSaldMediJunio(rst.getBigDecimal("saldmedi_junio"));
					plan.setPorcSaldMedJun(rst.getBigDecimal("porc_saldmedi_junio"));
					plan.setSaldDiciAnter(rst.getBigDecimal("sald_dic_ante"));
					plan.setSaldMediDici(rst.getBigDecimal("saldmedi_dic"));
					plan.setCodTerritorio(codTerritorio);
					plan.setPorcSaldMedDic(rst.getBigDecimal("porc_saldmedi_dic"));
					plan.setFactAjusSaldPunt(rst.getBigDecimal("fac_aju_sal_pun"));
					plan.setHistBajas(rst.getBigDecimal("hist_bajas"));
					plan.setMetaMesSaldPunt(rst.getBigDecimal("met_messald_punt"));
					plan.setMetaGereOficina(rst.getBigDecimal("met_ger_ofi"));
					plan.setPrioridad(rst.getBigDecimal("prioridad"));
					plan.setMesEval(rst.getString("mes_eval"));
					plan.setIndDor(rst.getString("ind_dor"));
					plan.setVarMes(rst.getBigDecimal("var_mes"));
					plan.setAjusPpto(rst.getBigDecimal("ajus_ppto"));
					plan.setDesvAjusPpto(rst.getBigDecimal("desv_ppto_ajus"));
					plan.setFactAjusTerri(rst.getBigDecimal("fact_ajus_terri"));
					plan.setFactAjusGereOfic(rst.getBigDecimal("fact_asig_gte_of"));
					listaPlan.add(plan);
				}
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null)
					rst.close();
				if (st != null)
					st.close();
				if (cnt != null)
					cnt.close();
				if (initialContext != null)
					initialContext.close();
				
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: find_ConsultaPlanesxTerritorio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
		}
		return listaPlan;
	}

	protected SesionEpigrafe createSesionEpigrafe() {
		try {
			log.info("[SesionPlanesBean :: createSesionEpigrafe] Inicio");
			
			SesionEpigrafeHome aSesionEpigrafeHome = (SesionEpigrafeHome) ServiceLocatorManager
			.getRemoteHome(STATIC_SesionEpigrafeHome_REF_NAME,
					STATIC_SesionEpigrafeHome_CLASS);
			
			if (aSesionEpigrafeHome != null) {
				log.info("[SesionPlanesBean :: createSesionEpigrafe] Fin");
				
				return aSesionEpigrafeHome.create();
			}
			
			log.info("[SesionPlanesBean :: createSesionEpigrafe] Fin");
		} catch (javax.ejb.CreateException e) {
			log.error("[SesionPlanesBean :: createSesionEpigrafe] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (RemoteException e) {
			log.error("[SesionPlanesBean :: createSesionEpigrafe] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: createSesionEpigrafe] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	protected Collection find_Tiido_planesLocalHome_findConsultarPlanesxMes(
			String codOficina, String anho) {
		
		try {
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultarPlanesxMes] Inicio");
			
			Tiido_planesLocalHome aTiido_planesLocalHome = (Tiido_planesLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_planesLocalHome_REF_NAME,
					STATIC_Tiido_planesLocalHome_CLASS);
			
			if (aTiido_planesLocalHome != null) {
				log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultarPlanesxMes] Fin");
				
				return aTiido_planesLocalHome.findConsultarPlanesxMes(
						codOficina, anho);
			}
			
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultarPlanesxMes] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultarPlanesxMes] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	protected Tiido_planesLocal find_Tiido_planesLocalHome_findPlanByObject(
			String mes, String anho, String codEpigrafe, String codOficina) {
		
		try {
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findPlanByObject] Inicio");
			
			Tiido_planesLocalHome aTiido_planesLocalHome = (Tiido_planesLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_planesLocalHome_REF_NAME,
					STATIC_Tiido_planesLocalHome_CLASS);
			
			if (aTiido_planesLocalHome != null) {
				log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findPlanByObject] Fin");
				
				return aTiido_planesLocalHome.findPlanByObject(mes, anho,
						codEpigrafe, codOficina);
			}
			
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findPlanByObject] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: find_Tiido_planesLocalHome_findPlanByObject] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	public Plan find_TiidoPlan(String mes, String anho, String epigrafe,
			String codOficina) {
		Context initialContext = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Plan tiido = null;
		String sql = "";

		try {
			log.info("[SesionPlanesBean :: find_TiidoPlan] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: find_TiidoPlan] Fin");
				
				return null;
			}
			
			DataSource ds = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			if (ds != null) {
				cn = ds.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: find_TiidoPlan] Fin");
				
				return null;
			}

			st = cn.createStatement();
			try{
				sql = "select o.mes_plan mes_plan, o.anho_plan anho_plan, o.cod_epigrafe cod_epigrafe, " + 
				  "sum(o.monto) monto from Tiido_planes o where o.anho_plan ='"+anho+"' and " +
				  "o.mes_plan ='"+mes+"' and o.cod_ofic like '"+codOficina+"' and " +
				  "o.cod_epigrafe ='"+epigrafe+"' group by mes_plan, anho_plan, cod_epigrafe";
				
				log.info("[SesionPlanesBean :: find_TiidoPlan] SQL:" + sql);
				
				rs =st.executeQuery(sql);
				while(rs.next()){
					tiido =new Plan();
					tiido.setMesMesSig(rs.getString("mes_plan"));
					tiido.setAnhoMesSig(rs.getString("anho_plan"));
					tiido.setCodEpiMesSig(rs.getString("cod_epigrafe"));
					tiido.setMontoMesSig(rs.getBigDecimal("monto"));
				}
				
				log.info("[SesionPlanesBean :: find_TiidoPlan] Fin");
			}catch(Exception e){
				log.error("[SesionPlanesBean :: find_TiidoPlan] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
			
			log.info("[SesionPlanesBean :: find_TiidoPlan] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: find_TiidoPlan] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cn != null)
					cn.close();
				if (initialContext != null)
					initialContext.close();
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: find_TiidoPlan] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}
		return tiido;
	}

	protected Tiido_planesLocal find_Tiido_planesLocalHome_findConsultaPlanesResumen(
			String mes, String anho, String codEpigrafe, String codOficina) {
		try {
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanesResumen] Inicio");
			
			Tiido_planesLocalHome aTiido_planesLocalHome = (Tiido_planesLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_planesLocalHome_REF_NAME,
					STATIC_Tiido_planesLocalHome_CLASS);
			
			if (aTiido_planesLocalHome != null) {
				log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanesResumen] Fin");
				
				return aTiido_planesLocalHome.findConsultaPlanesResumen(mes,
						anho, codEpigrafe, codOficina);
			}
			
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanesResumen] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanesResumen] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	protected Tiido_planesLocal find_Tiido_planesLocalHome_findByPrimaryKey(
			Tiido_planesKey primaryKey) {
		try {
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findByPrimaryKey] Inicio");
			
			Tiido_planesLocalHome aTiido_planesLocalHome = (Tiido_planesLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_planesLocalHome_REF_NAME,
					STATIC_Tiido_planesLocalHome_CLASS);
			
			if (aTiido_planesLocalHome != null) {
				log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findByPrimaryKey] Fin");
				
				return aTiido_planesLocalHome.findByPrimaryKey(primaryKey);
			}
			
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findByPrimaryKey] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: find_Tiido_planesLocalHome_findByPrimaryKey] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	protected Tiido_planesLocal createTiido_planesLocal(Plan plan) {
		try {
			log.info("[SesionPlanesBean :: createTiido_planesLocal] Inicio");
			
			Tiido_planesLocalHome aTiido_planesLocalHome = (Tiido_planesLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_planesLocalHome_REF_NAME,
					STATIC_Tiido_planesLocalHome_CLASS);
			
			if (aTiido_planesLocalHome != null) {
				log.info("[SesionPlanesBean :: createTiido_planesLocal] Fin");
				
				return aTiido_planesLocalHome.create(plan);
			}
			
			log.info("[SesionPlanesBean :: createTiido_planesLocal] Fin");
		} catch (javax.ejb.CreateException e) {
			log.error("[SesionPlanesBean :: createTiido_planesLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: createTiido_planesLocal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	public boolean existeDataMesAnio(String mes, String anio) {
		boolean resp = false;
		int valor = 0;
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionPlanesBean :: existeDataMesAnio] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: existeDataMesAnio] Fin");
				
				return false;
			}

			log.info("[SesionPlanesBean :: existeDataMesAnio] DATASOURCE_CONTEXT:::" +  ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: existeDataMesAnio] Fin");
				
				return false;
			}

			s = con.createStatement();
			try {
				String sql = "SELECT COUNT(*) FROM tiido_planes WHERE TO_NUMBER(anho_plan)="
						+ anio + " and mes_plan='" + mes + "'";
				
				log.info("[SesionPlanesBean :: existeDataMesAnio] SQL:" + sql);
				
				rst = s.executeQuery(sql);
				if (rst.next()) {
					valor = rst.getInt(1);
					if (valor > 0) {
						resp = true;
					}
				}
			} catch (SQLException e) {
				log.error("[SesionPlanesBean :: existeDataMesAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}
			
			log.info("[SesionPlanesBean :: existeDataMesAnio] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: existeDataMesAnio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: existeDataMesAnio] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}

		return resp;
	}

	public Vector findEpigrafesinPlanes(String codOficina, String anho,
			String mes) {
		Vector listaEpigrafes = new Vector();
		String prioridad = "";
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;

		try {
			log.info("[SesionPlanesBean :: findEpigrafesinPlanes] Inicio");
			
			if (Integer.parseInt(mes) >= 10) {
				mes = String.valueOf(Integer.parseInt(mes));
			} else {
				mes = "0" + String.valueOf(Integer.parseInt(mes));
			}

			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: findEpigrafesinPlanes] Fin");
				
				return null;
			}
			
			log.info("[SesionPlanesBean :: findEpigrafesinPlanes] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: findEpigrafesinPlanes] Fin");
				
				return null;
			}
			s = con.createStatement();

			try {

				String sql = "select distinct cod_epigrafe, anho_plan, nom_epigrafe from tiido_planes where mes_plan='"
						+ mes.trim()
						+ "' and anho_plan='"
						+ anho.trim()
						+ "' and cod_ofic='" + codOficina.trim() + "'";
				
				log.info("[SesionPlanesBean :: findEpigrafesinPlanes] SQL:" + sql);
				
				rst = s.executeQuery(sql);
				SesionEpigrafe aSesionEpigrafe = createSesionEpigrafe();
				while (rst.next()) {
					Epigrafe bean = new Epigrafe();

					bean.setAnho(rst.getString(2));
					bean.setCodEpigrafe(rst.getString(1));

					prioridad = findConsultaPlanesPrioridad(mes, anho, bean.getCodEpigrafe(), codOficina);
					if (prioridad == null) {
						prioridad = "";
					}

					// if(!prioridad.equalsIgnoreCase("99") ) {
					bean.setNomEpigrafe(prioridad + " - " + rst.getString(3));
					// } else {
					//	bean.setNomEpigrafe(rst.getString(3));
					//}
					
					try {
						Epigrafe anEpigrafe = aSesionEpigrafe.findByCodEpigAnho(bean.getCodEpigrafe(), anho);
						if (anEpigrafe != null) {
							bean.setIndAfecta(anEpigrafe.getIndAfecta());
						} else {
							bean.setIndAfecta("N");
						}

					} catch (RemoteException ex) {
						ex.printStackTrace();
					}
					listaEpigrafes.add(bean);
				}
				
				
			} catch (SQLException e) {
				log.error("[SesionPlanesBean :: findEpigrafesinPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			}

			log.info("[SesionPlanesBean :: findEpigrafesinPlanes] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: findEpigrafesinPlanes] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: findEpigrafesinPlanes] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}

		return listaEpigrafes;
	}

	protected Tiido_planesLocal find_Tiido_planesLocalHome_findConsultaPlanesPrioridad(
			String mes, String anho, String codEpigrafe, String codOficina) {
		
		try {
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanesPrioridad] Inicio");
			
			Tiido_planesLocalHome aTiido_planesLocalHome = (Tiido_planesLocalHome) ServiceLocatorManager
			.getLocalHome(STATIC_Tiido_planesLocalHome_REF_NAME,
					STATIC_Tiido_planesLocalHome_CLASS);
			
			if (aTiido_planesLocalHome != null) {
				log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanesPrioridad] Fin");
				
				return aTiido_planesLocalHome.findConsultaPlanesPrioridad(mes,
						anho, codEpigrafe, codOficina);
			}
			
			log.info("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanesPrioridad] Fin");
		} catch (javax.ejb.FinderException fe) {
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: find_Tiido_planesLocalHome_findConsultaPlanesPrioridad] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	public String findConsultaPlanesPrioridad(String mes, String anho,
			String codEpigrafe, String codOficina) {
		Tiido_planesLocal aTiido_planesLocal = null;
		String prioridad = null;

		try {
			log.info("[SesionPlanesBean :: findConsultaPlanesPrioridad] Inicio");
			
			aTiido_planesLocal = find_Tiido_planesLocalHome_findConsultaPlanesPrioridad(
					mes, anho, codEpigrafe, codOficina);

			if (aTiido_planesLocal != null) {
				prioridad = String.valueOf(aTiido_planesLocal.getPrioridad()
						.intValue());
			}
			
			log.info("[SesionPlanesBean :: findConsultaPlanesPrioridad] Fin");
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: findConsultaPlanesPrioridad] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		return prioridad;
	}

	protected SesionMultitabla createSesionMultitabla() {
		try {
			log.info("[SesionPlanesBean :: existeMesesReferencia] Inicio");
			SesionMultitablaHome aSesionMultitablaHome = (SesionMultitablaHome) ServiceLocatorManager
			.getRemoteHome(STATIC_SesionMultitablaHome_REF_NAME,
					STATIC_SesionMultitablaHome_CLASS);
			
			if (aSesionMultitablaHome != null) {
				log.info("[SesionPlanesBean :: existeMesesReferencia] Fin");
				
				return aSesionMultitablaHome.create();
			}
			
			log.info("[SesionPlanesBean :: existeMesesReferencia] Fin");
		} catch (javax.ejb.CreateException e) {
			log.error("[SesionPlanesBean :: existeMesesReferencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (RemoteException e) {
			log.error("[SesionPlanesBean :: existeMesesReferencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: existeMesesReferencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return null;
	}

	private int existeMesesReferencia(int mes, int anio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		int resp = -1;
		String sql = null;

		try {
			log.info("[SesionPlanesBean :: existeMesesReferencia] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: existeMesesReferencia] Fin");
				
				return -1;
			}
			
			log.info("[SesionPlanesBean :: existeMesesReferencia] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: existeMesesReferencia] Fin");
				
				return -1;
			}
			s = con.createStatement();

			sql = "SELECT meses_referencia_id FROM tiido_meses_referencia WHERE mes = "
					+ mes + " AND anio = " + anio;
			log.info("[SesionPlanesBean :: existeMesesReferencia] SQL:" + sql);
			rst = s.executeQuery(sql);

			if (rst.next()) {
				resp = rst.getInt(1);
			}
			
			log.info("[SesionPlanesBean :: existeMesesReferencia] Fin");
		} catch (SQLException e) {
			log.error("[SesionPlanesBean :: existeMesesReferencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: existeMesesReferencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return -1;
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: existeMesesReferencia] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);

				return -1;
			}
		}

		return resp;
	}

	public boolean insertUpdateMesesReferencia(int mes, int anio, int sel_mes) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		String sql = null;
		int id = -1;

		try {
			log.info("[SesionPlanesBean :: insertUpdateMesesReferencia] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: insertUpdateMesesReferencia] Fin");
				
				return false;
			}
			
			log.info("[SesionPlanesBean :: insertUpdateMesesReferencia] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: insertUpdateMesesReferencia] Fin");
				
				return false;
			}

			s = con.createStatement();

			id = existeMesesReferencia(mes, anio);
			if (id > 0) {
				// Actualizar
				sql = "UPDATE tiido_meses_referencia SET sel_mes = " + sel_mes
						+ " WHERE meses_referencia_id = " + id;
			} else {
				// Insertar
				sql = "SELECT NVL(MAX(meses_referencia_id) + 1, 1) FROM tiido_meses_referencia";
				rst = s.executeQuery(sql);
				log.info("[SesionPlanesBean :: insertUpdateMesesReferencia] SQL:" + sql);

				if (rst.next()) {
					id = rst.getInt(1);
				}

				sql = "INSERT INTO tiido_meses_referencia (meses_referencia_id, mes, anio, sel_mes) VALUES "
						+ "("
						+ id
						+ ", "
						+ mes
						+ ", "
						+ anio
						+ ", "
						+ sel_mes
						+ ")";
			}
			log.info("[SesionPlanesBean :: insertUpdateMesesReferencia] SQL:" + sql);

			s.execute(sql);
			
			log.info("[SesionPlanesBean :: insertUpdateMesesReferencia] Fin");
		} catch (SQLException e) {
			log.error("[SesionPlanesBean :: insertUpdateMesesReferencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: insertUpdateMesesReferencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return false;
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: insertUpdateMesesReferencia] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return false;
			}
		}

		return true;
	}

	public int findMesesReferencia(int mes, int anio) {
		Connection con = null;
		Context initialContext = null;
		Statement s = null;
		ResultSet rst = null;
		int sel_mes = -1;
		String sql = null;

		try {
			log.info("[SesionPlanesBean :: findMesesReferencia] Inicio");
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: findMesesReferencia] Fin");
				
				return -1;
			}
			
			log.info("[SesionPlanesBean :: findMesesReferencia] DATASOURCE_CONTEXT:::" + ConstantesUtil.DATASOURCE_CONTEXT);
			
			DataSource datasource = (DataSource) initialContext
					.lookup(ConstantesUtil.DATASOURCE_CONTEXT);

			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: findMesesReferencia] Fin");
				
				return -1;
			}
			s = con.createStatement();

			sql = "SELECT sel_mes FROM tiido_meses_referencia WHERE mes = "
					+ mes + " AND anio = " + anio;
			
			log.info("[SesionPlanesBean :: findMesesReferencia] SQL:" + sql);
			rst = s.executeQuery(sql);

			if (rst.next()) {
				sel_mes = rst.getInt(1);
			}
			
			log.info("[SesionPlanesBean :: findMesesReferencia] Fin");
		} catch (SQLException e) {
			log.error("[SesionPlanesBean :: findMesesReferencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: findMesesReferencia] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return -1;
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}

				if (s != null) {
					s.close();
				}

				if (con != null) {
					con.close();
				}

				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: findMesesReferencia] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return -1;
			}
		}

		return sel_mes;
	}
	
	public HashMap getListaMeses(int year){
		HashMap mapaDatos = null;
		Vector datos = null;
		Context initialContext = null;
		DataSource datasource = null;
		Connection con = null;
		Statement s = null;
		ResultSet rst = null;
		
		try {
			
			initialContext = new InitialContext();
			if (initialContext == null) {
				log.info("[SesionPlanesBean :: findPlanAnual] Fin");
				
				return null;
			}
			
			datasource = (DataSource) initialContext.lookup(ConstantesUtil.DATASOURCE_CONTEXT);
			
			if (datasource != null) {
				con = datasource.getConnection();
			} else {
				initialContext = null;
				log.info("[SesionPlanesBean :: getListaMeses] Fin");
				
				return null;
			}
			
			s = con.createStatement();
			
			String sql = " select m.mes, m.sel_mes " +
						 " from IIDO.TIIDO_MESES_REFERENCIA m "+
						 " where m.anio = " + String.valueOf(year) +
						 " order by m.mes ";
			
			log.info("query: " + sql);
			
			rst = s.executeQuery(sql);
			
			mapaDatos = new HashMap();
			
			while (rst.next()) {			
				mapaDatos.put(rst.getString("mes"), rst.getString("sel_mes"));
			}
		
		} catch (SQLException e) {
			log.error("[SesionPlanesBean :: getListaMeses] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[SesionPlanesBean :: getListaMeses] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
	
				if (s != null) {
					s.close();
				}
	
				if (con != null) {
					con.close();
				}
	
				if (initialContext != null) {
					initialContext.close();
				}
			} catch (Exception e) {
				log.error("[SesionPlanesBean :: getListaMeses] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
				
				return null;
			}
		}
		
		return mapaDatos;
	}
}