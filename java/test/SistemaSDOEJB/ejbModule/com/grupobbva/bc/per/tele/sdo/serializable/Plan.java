/*
 * Created on 23/01/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Plan implements Serializable{

	private String codOficina;
	private String codTerritorio;
	private String mes;
	private String anho;
	private String codEpigrafe;
	private String nomEpigrafe;
	private BigDecimal pesoDor;
	private BigDecimal monto;
	private BigDecimal porAlcanzado;
	private BigDecimal desvPpto;
	private BigDecimal nroMesesFalt;
	private BigDecimal proyCrecMens;
	private BigDecimal proyCrecMensVista;
	private BigDecimal AjusEstiTerr;
	private BigDecimal proyAjusMens;
	private BigDecimal saldMediJunio;
	private BigDecimal porcSaldMedJun;
	private BigDecimal saldDiciAnter;
	private BigDecimal saldMediDici;
	private BigDecimal porcSaldMedDic;
	private BigDecimal factAjusSaldPunt;
	private BigDecimal factAjusSaldPuntVista;
	private BigDecimal histBajas;
	private BigDecimal metaMesSaldPunt;
	private BigDecimal metaGereOficina;
	private BigDecimal prioridad;
	private String mesEval;
	private String indDor;
	private BigDecimal varMes;
	private BigDecimal ajusPpto;
	private BigDecimal desvAjusPpto;
	private BigDecimal factAjusTerri;
	private BigDecimal factAjusGereOfic;
	
	/*
	 * atributos de epigrafes*/
	private String indClase;
	private String indSubClase;
	private String orden;
	private String indHijo;
	private String indAfecta;
	private BigDecimal porcentajeMax;
	private BigDecimal porcentajeMin;
	private String usuario;
	
	private BigDecimal nuevoFactAjusGereOfic;
	/**
	 * @return Returns the porcentajeMax.
	 */
	public BigDecimal getPorcentajeMax() {
		return porcentajeMax;
	}
	/**
	 * @param porcentajeMax The porcentajeMax to set.
	 */
	public void setPorcentajeMax(BigDecimal porcentajeMax) {
		this.porcentajeMax = porcentajeMax;
	}
	/**
	 * @return Returns the porcentajeMin.
	 */
	public BigDecimal getPorcentajeMin() {
		return porcentajeMin;
	}
	/**
	 * @param porcentajeMin The porcentajeMin to set.
	 */
	public void setPorcentajeMin(BigDecimal porcentajeMin) {
		this.porcentajeMin = porcentajeMin;
	}

	/*
	 * atributos de mes siguiente*/
	private String codEpiMesSig;
	private BigDecimal montoMesSig;
	private String mesMesSig;
	private String anhoMesSig;
	
	/*
	 * atributos de resumen*/
	private BigDecimal porMetaGerente;
	private BigDecimal restoOficina;
	private BigDecimal porRestoOficina;
	/**
	 * @return Returns the porMetaGerente.
	 */
	public BigDecimal getPorMetaGerente() {
		return porMetaGerente;
	}
	/**
	 * @param porMetaGerente The porMetaGerente to set.
	 */
	public void setPorMetaGerente(BigDecimal porMetaGerente) {
		this.porMetaGerente = porMetaGerente;
	}
	/**
	 * @return Returns the porRestoOficina.
	 */
	public BigDecimal getPorRestoOficina() {
		return porRestoOficina;
	}
	/**
	 * @param porRestoOficina The porRestoOficina to set.
	 */
	public void setPorRestoOficina(BigDecimal porRestoOficina) {
		this.porRestoOficina = porRestoOficina;
	}	
	
	/**
	 * @return Returns the restoOficina.
	 */
	public BigDecimal getRestoOficina() {
		return restoOficina;
	}
	/**
	 * @param restoOficina The restoOficina to set.
	 */
	public void setRestoOficina(BigDecimal restoOficina) {
		this.restoOficina = restoOficina;
	}
	/**
	 * @return Returns the anhoMesSig.
	 */
	public String getAnhoMesSig() {
		return anhoMesSig;
	}
	/**
	 * @param anhoMesSig The anhoMesSig to set.
	 */
	public void setAnhoMesSig(String anhoMesSig) {
		this.anhoMesSig = anhoMesSig;
	}
	/**
	 * @return Returns the codEpiMesSig.
	 */
	public String getCodEpiMesSig() {
		return codEpiMesSig;
	}
	/**
	 * @param codEpiMesSig The codEpiMesSig to set.
	 */
	public void setCodEpiMesSig(String codEpiMesSig) {
		this.codEpiMesSig = codEpiMesSig;
	}
	/**
	 * @return Returns the mesMesSig.
	 */
	public String getMesMesSig() {
		return mesMesSig;
	}
	/**
	 * @param mesMesSig The mesMesSig to set.
	 */
	public void setMesMesSig(String mesMesSig) {
		this.mesMesSig = mesMesSig;
	}
	/**
	 * @return Returns the montoMesSig.
	 */
	public BigDecimal getMontoMesSig() {
		return montoMesSig;
	}
	/**
	 * @param montoMesSig The montoMesSig to set.
	 */
	public void setMontoMesSig(BigDecimal montoMesSig) {
		this.montoMesSig = montoMesSig;
	}
	
	/**
	 * @return Returns the indAfecta.
	 */
	public String getIndAfecta() {
		return indAfecta;
	}
	/**
	 * @param indAfecta The indAfecta to set.
	 */
	public void setIndAfecta(String indAfecta) {
		this.indAfecta = indAfecta;
	}
	/**
	 * @return Returns the indClase.
	 */
	public String getIndClase() {
		return indClase;
	}
	/**
	 * @param indClase The indClase to set.
	 */
	public void setIndClase(String indClase) {
		this.indClase = indClase;
	}
	/**
	 * @return Returns the indHijo.
	 */
	public String getIndHijo() {
		return indHijo;
	}
	/**
	 * @param indHijo The indHijo to set.
	 */
	public void setIndHijo(String indHijo) {
		this.indHijo = indHijo;
	}
	/**
	 * @return Returns the indSubClase.
	 */
	public String getIndSubClase() {
		return indSubClase;
	}
	/**
	 * @param indSubClase The indSubClase to set.
	 */
	public void setIndSubClase(String indSubClase) {
		this.indSubClase = indSubClase;
	}
	/**
	 * @return Returns the orden.
	 */
	public String getOrden() {
		return orden;
	}
	/**
	 * @param orden The orden to set.
	 */
	public void setOrden(String orden) {
		this.orden = orden;
	}
	/**
	 * @return Returns the ajusEstiTerr.
	 */
	public BigDecimal getAjusEstiTerr() {
		return AjusEstiTerr;
	}
	/**
	 * @param ajusEstiTerr The ajusEstiTerr to set.
	 */
	public void setAjusEstiTerr(BigDecimal ajusEstiTerr) {
		AjusEstiTerr = ajusEstiTerr;
	}
	/**
	 * @return Returns the ajusPpto.
	 */
	public BigDecimal getAjusPpto() {
		return ajusPpto;
	}
	/**
	 * @param ajusPpto The ajusPpto to set.
	 */
	public void setAjusPpto(BigDecimal ajusPpto) {
		this.ajusPpto = ajusPpto;
	}
	/**
	 * @return Returns the anho.
	 */
	public String getAnho() {
		return anho;
	}
	/**
	 * @param anho The anho to set.
	 */
	public void setAnho(String anho) {
		this.anho = anho;
	}
	/**
	 * @return Returns the codEpigrafe.
	 */
	public String getCodEpigrafe() {
		return codEpigrafe;
	}
	/**
	 * @param codEpigrafe The codEpigrafe to set.
	 */
	public void setCodEpigrafe(String codEpigrafe) {
		this.codEpigrafe = codEpigrafe;
	}
	/**
	 * @return Returns the codOficina.
	 */
	public String getCodOficina() {
		return codOficina;
	}
	/**
	 * @param codOficina The codOficina to set.
	 */
	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}
	/**
	 * @return Returns the codTerritorio.
	 */
	public String getCodTerritorio() {
		return codTerritorio;
	}
	/**
	 * @param codTerritorio The codTerritorio to set.
	 */
	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}
	/**
	 * @return Returns the desvAjusPpto.
	 */
	public BigDecimal getDesvAjusPpto() {
		return desvAjusPpto;
	}
	/**
	 * @param desvAjusPpto The desvAjusPpto to set.
	 */
	public void setDesvAjusPpto(BigDecimal desvAjusPpto) {
		this.desvAjusPpto = desvAjusPpto;
	}
	/**
	 * @return Returns the desvPpto.
	 */
	public BigDecimal getDesvPpto() {
		return desvPpto;
	}
	/**
	 * @param desvPpto The desvPpto to set.
	 */
	public void setDesvPpto(BigDecimal desvPpto) {
		this.desvPpto = desvPpto;
	}
	/**
	 * @return Returns the factAjusGereOfic.
	 */
	public BigDecimal getFactAjusGereOfic() {
		return factAjusGereOfic;
	}
	/**
	 * @param factAjusGereOfic The factAjusGereOfic to set.
	 */
	public void setFactAjusGereOfic(BigDecimal factAjusGereOfic) {
		this.factAjusGereOfic = factAjusGereOfic;
	}
	/**
	 * @return Returns the factAjusSaldPunt.
	 */
	public BigDecimal getFactAjusSaldPunt() {
		return factAjusSaldPunt;
	}
	/**
	 * @param factAjusSaldPunt The factAjusSaldPunt to set.
	 */
	public void setFactAjusSaldPunt(BigDecimal factAjusSaldPunt) {
		this.factAjusSaldPunt = factAjusSaldPunt;
	}
	/**
	 * @return Returns the factAjusTerri.
	 */
	public BigDecimal getFactAjusTerri() {
		return factAjusTerri;
	}
	/**
	 * @param factAjusTerri The factAjusTerri to set.
	 */
	public void setFactAjusTerri(BigDecimal factAjusTerri) {
		this.factAjusTerri = factAjusTerri;
	}
	/**
	 * @return Returns the histBajas.
	 */
	public BigDecimal getHistBajas() {
		return histBajas;
	}
	/**
	 * @param histBajas The histBajas to set.
	 */
	public void setHistBajas(BigDecimal histBajas) {
		this.histBajas = histBajas;
	}
	/**
	 * @return Returns the indDor.
	 */
	public String getIndDor() {
		return indDor;
	}
	/**
	 * @param indDor The indDor to set.
	 */
	public void setIndDor(String indDor) {
		this.indDor = indDor;
	}
	/**
	 * @return Returns the mes.
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes The mes to set.
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}
	/**
	 * @return Returns the mesEval.
	 */
	public String getMesEval() {
		return mesEval;
	}
	/**
	 * @param mesEval The mesEval to set.
	 */
	public void setMesEval(String mesEval) {
		this.mesEval = mesEval;
	}
	/**
	 * @return Returns the metaGereOficina.
	 */
	public BigDecimal getMetaGereOficina() {
		return metaGereOficina;
	}
	/**
	 * @param metaGereOficina The metaGereOficina to set.
	 */
	public void setMetaGereOficina(BigDecimal metaGereOficina) {
		this.metaGereOficina = metaGereOficina;
	}
	/**
	 * @return Returns the metaMesSaldPunt.
	 */
	public BigDecimal getMetaMesSaldPunt() {
		return metaMesSaldPunt;
	}
	/**
	 * @param metaMesSaldPunt The metaMesSaldPunt to set.
	 */
	public void setMetaMesSaldPunt(BigDecimal metaMesSaldPunt) {
		this.metaMesSaldPunt = metaMesSaldPunt;
	}
	/**
	 * @return Returns the monto.
	 */
	public BigDecimal getMonto() {
		return monto;
	}
	/**
	 * @param monto The monto to set.
	 */
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	/**
	 * @return Returns the nomEpigrafe.
	 */
	public String getNomEpigrafe() {
		return nomEpigrafe;
	}
	/**
	 * @param nomEpigrafe The nomEpigrafe to set.
	 */
	public void setNomEpigrafe(String nomEpigrafe) {
		this.nomEpigrafe = nomEpigrafe;
	}
	/**
	 * @return Returns the nroMesesFalt.
	 */
	public BigDecimal getNroMesesFalt() {
		return nroMesesFalt;
	}
	/**
	 * @param nroMesesFalt The nroMesesFalt to set.
	 */
	public void setNroMesesFalt(BigDecimal nroMesesFalt) {
		this.nroMesesFalt = nroMesesFalt;
	}
	/**
	 * @return Returns the pesoDor.
	 */
	public BigDecimal getPesoDor() {
		return pesoDor;
	}
	/**
	 * @param pesoDor The pesoDor to set.
	 */
	public void setPesoDor(BigDecimal pesoDor) {
		this.pesoDor = pesoDor;
	}
	/**
	 * @return Returns the porAlcanzado.
	 */
	public BigDecimal getPorAlcanzado() {
		return porAlcanzado;
	}
	/**
	 * @param porAlcanzado The porAlcanzado to set.
	 */
	public void setPorAlcanzado(BigDecimal porAlcanzado) {
		this.porAlcanzado = porAlcanzado;
	}
	/**
	 * @return Returns the porcSaldMedDic.
	 */
	public BigDecimal getPorcSaldMedDic() {
		return porcSaldMedDic;
	}
	/**
	 * @param porcSaldMedDic The porcSaldMedDic to set.
	 */
	public void setPorcSaldMedDic(BigDecimal porcSaldMedDic) {
		this.porcSaldMedDic = porcSaldMedDic;
	}
	/**
	 * @return Returns the porcSaldMedJun.
	 */
	public BigDecimal getPorcSaldMedJun() {
		return porcSaldMedJun;
	}
	/**
	 * @param porcSaldMedJun The porcSaldMedJun to set.
	 */
	public void setPorcSaldMedJun(BigDecimal porcSaldMedJun) {
		this.porcSaldMedJun = porcSaldMedJun;
	}
	/**
	 * @return Returns the prioridad.
	 */
	public BigDecimal getPrioridad() {
		return prioridad;
	}
	/**
	 * @param prioridad The prioridad to set.
	 */
	public void setPrioridad(BigDecimal prioridad) {
		this.prioridad = prioridad;
	}
	/**
	 * @return Returns the proyAjusMens.
	 */
	public BigDecimal getProyAjusMens() {
		return proyAjusMens;
	}
	/**
	 * @param proyAjusMens The proyAjusMens to set.
	 */
	public void setProyAjusMens(BigDecimal proyAjusMens) {
		this.proyAjusMens = proyAjusMens;
	}
	/**
	 * @return Returns the proyCrecMens.
	 */
	public BigDecimal getProyCrecMens() {
		return proyCrecMens;
	}
	/**
	 * @param proyCrecMens The proyCrecMens to set.
	 */
	public void setProyCrecMens(BigDecimal proyCrecMens) {
		this.proyCrecMens = proyCrecMens;
	}
	/**
	 * @return Returns the saldDiciAnter.
	 */
	public BigDecimal getSaldDiciAnter() {
		return saldDiciAnter;
	}
	/**
	 * @param saldDiciAnter The saldDiciAnter to set.
	 */
	public void setSaldDiciAnter(BigDecimal saldDiciAnter) {
		this.saldDiciAnter = saldDiciAnter;
	}
	/**
	 * @return Returns the saldMediDici.
	 */
	public BigDecimal getSaldMediDici() {
		return saldMediDici;
	}
	/**
	 * @param saldMediDici The saldMediDici to set.
	 */
	public void setSaldMediDici(BigDecimal saldMediDici) {
		this.saldMediDici = saldMediDici;
	}
	/**
	 * @return Returns the saldMediJunio.
	 */
	public BigDecimal getSaldMediJunio() {
		return saldMediJunio;
	}
	/**
	 * @param saldMediJunio The saldMediJunio to set.
	 */
	public void setSaldMediJunio(BigDecimal saldMediJunio) {
		this.saldMediJunio = saldMediJunio;
	}
	/**
	 * @return Returns the varMes.
	 */
	public BigDecimal getVarMes() {
		return varMes;
	}
	/**
	 * @param varMes The varMes to set.
	 */
	public void setVarMes(BigDecimal varMes) {
		this.varMes = varMes;
	}
	
	
	/**
	 * @return Returns the proyCrecMensVista.
	 */
	public BigDecimal getProyCrecMensVista() {
		return proyCrecMensVista;
	}
	/**
	 * @param proyCrecMensVista The proyCrecMensVista to set.
	 */
	public void setProyCrecMensVista(BigDecimal proyCrecMensVista) {
		this.proyCrecMensVista = proyCrecMensVista;
	}
	/**
	 * @return Returns the factAjusSaldPuntVista.
	 */
	public BigDecimal getFactAjusSaldPuntVista() {
		return factAjusSaldPuntVista;
	}
	/**
	 * @param factAjusSaldPuntVista The factAjusSaldPuntVista to set.
	 */
	public void setFactAjusSaldPuntVista(BigDecimal factAjusSaldPuntVista) {
		this.factAjusSaldPuntVista = factAjusSaldPuntVista;
	}
	/**
	 * @return Returns the nuevoFactAjusGereOfic.
	 */
	public BigDecimal getNuevoFactAjusGereOfic() {
		return nuevoFactAjusGereOfic;
	}
	/**
	 * @param nuevoFactAjusGereOfic The nuevoFactAjusGereOfic to set.
	 */
	public void setNuevoFactAjusGereOfic(BigDecimal nuevoFactAjusGereOfic) {
		this.nuevoFactAjusGereOfic = nuevoFactAjusGereOfic;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
