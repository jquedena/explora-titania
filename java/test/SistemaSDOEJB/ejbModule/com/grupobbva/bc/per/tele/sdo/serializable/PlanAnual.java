/*
 * Created on 08/06/2009
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
public class PlanAnual implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codOficina;
	private String anho;
	private String codEpigrafe;
	private String nomEpigrafe;
	private BigDecimal ener;
	private BigDecimal enerP;
	private BigDecimal febr;
	private BigDecimal febrP;
	private BigDecimal marz;
	private BigDecimal marzP;
	private BigDecimal abri;
	private BigDecimal abriP;
	private BigDecimal mayo;
	private BigDecimal mayoP;
	private BigDecimal juni;
	private BigDecimal juniP;
	private BigDecimal juli;
	private BigDecimal juliP;
	private BigDecimal agos;
	private BigDecimal agosP;
	private BigDecimal seti;
	private BigDecimal setiP;
	private BigDecimal octu;
	private BigDecimal octuP;
	private BigDecimal novi;
	private BigDecimal noviP;
	private BigDecimal dici;
	private BigDecimal diciP;
	private BigDecimal totalM;
	private BigDecimal totalP;
	private BigDecimal porcentajeMax;
	private BigDecimal porcentajeMin;
	private BigDecimal mesActualM;
	private BigDecimal mesActualP;
	private BigDecimal mesActual;
	private String indHijo;
	private int prioridad;
	
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public BigDecimal getMesActualM() {
		return mesActualM;
	}
	public void setMesActualM(BigDecimal mesActualM) {
		this.mesActualM = mesActualM;
	}
	public BigDecimal getMesActualP() {
		return mesActualP;
	}
	public void setMesActualP(BigDecimal mesActualP) {
		this.mesActualP = mesActualP;
	}
	public BigDecimal getMesActual() {
		return mesActual;
	}
	public void setMesActual(BigDecimal mesActual) {
		this.mesActual = mesActual;
	}
	public String getIndHijo() {
		return indHijo;
	}
	public void setIndHijo(String indHijo) {
		this.indHijo = indHijo;
	}
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
	
	
	/**
	 * @return Returns the abri.
	 */
	public BigDecimal getAbri() {
		return abri;
	}
	/**
	 * @param abri The abri to set.
	 */
	public void setAbri(BigDecimal abri) {
		this.abri = abri;
	}
	/**
	 * @return Returns the abriP.
	 */
	public BigDecimal getAbriP() {
		return abriP;
	}
	/**
	 * @param abriP The abriP to set.
	 */
	public void setAbriP(BigDecimal abriP) {
		this.abriP = abriP;
	}
	/**
	 * @return Returns the agos.
	 */
	public BigDecimal getAgos() {
		return agos;
	}
	/**
	 * @param agos The agos to set.
	 */
	public void setAgos(BigDecimal agos) {
		this.agos = agos;
	}
	/**
	 * @return Returns the agosP.
	 */
	public BigDecimal getAgosP() {
		return agosP;
	}
	/**
	 * @param agosP The agosP to set.
	 */
	public void setAgosP(BigDecimal agosP) {
		this.agosP = agosP;
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
	 * @return Returns the dici.
	 */
	public BigDecimal getDici() {
		return dici;
	}
	/**
	 * @param dici The dici to set.
	 */
	public void setDici(BigDecimal dici) {
		this.dici = dici;
	}
	/**
	 * @return Returns the diciP.
	 */
	public BigDecimal getDiciP() {
		return diciP;
	}
	/**
	 * @param diciP The diciP to set.
	 */
	public void setDiciP(BigDecimal diciP) {
		this.diciP = diciP;
	}
	/**
	 * @return Returns the ener.
	 */
	public BigDecimal getEner() {
		return ener;
	}
	/**
	 * @param ener The ener to set.
	 */
	public void setEner(BigDecimal ener) {
		this.ener = ener;
	}
	/**
	 * @return Returns the enerP.
	 */
	public BigDecimal getEnerP() {
		return enerP;
	}
	/**
	 * @param enerP The enerP to set.
	 */
	public void setEnerP(BigDecimal enerP) {
		this.enerP = enerP;
	}
	/**
	 * @return Returns the febr.
	 */
	public BigDecimal getFebr() {
		return febr;
	}
	/**
	 * @param febr The febr to set.
	 */
	public void setFebr(BigDecimal febr) {
		this.febr = febr;
	}
	/**
	 * @return Returns the febrP.
	 */
	public BigDecimal getFebrP() {
		return febrP;
	}
	/**
	 * @param febrP The febrP to set.
	 */
	public void setFebrP(BigDecimal febrP) {
		this.febrP = febrP;
	}
	/**
	 * @return Returns the juli.
	 */
	public BigDecimal getJuli() {
		return juli;
	}
	/**
	 * @param juli The juli to set.
	 */
	public void setJuli(BigDecimal juli) {
		this.juli = juli;
	}
	/**
	 * @return Returns the juliP.
	 */
	public BigDecimal getJuliP() {
		return juliP;
	}
	/**
	 * @param juliP The juliP to set.
	 */
	public void setJuliP(BigDecimal juliP) {
		this.juliP = juliP;
	}
	/**
	 * @return Returns the juni.
	 */
	public BigDecimal getJuni() {
		return juni;
	}
	/**
	 * @param juni The juni to set.
	 */
	public void setJuni(BigDecimal juni) {
		this.juni = juni;
	}
	/**
	 * @return Returns the juniP.
	 */
	public BigDecimal getJuniP() {
		return juniP;
	}
	/**
	 * @param juniP The juniP to set.
	 */
	public void setJuniP(BigDecimal juniP) {
		this.juniP = juniP;
	}
	/**
	 * @return Returns the marz.
	 */
	public BigDecimal getMarz() {
		return marz;
	}
	/**
	 * @param marz The marz to set.
	 */
	public void setMarz(BigDecimal marz) {
		this.marz = marz;
	}
	/**
	 * @return Returns the marzP.
	 */
	public BigDecimal getMarzP() {
		return marzP;
	}
	/**
	 * @param marzP The marzP to set.
	 */
	public void setMarzP(BigDecimal marzP) {
		this.marzP = marzP;
	}
	/**
	 * @return Returns the mayo.
	 */
	public BigDecimal getMayo() {
		return mayo;
	}
	/**
	 * @param mayo The mayo to set.
	 */
	public void setMayo(BigDecimal mayo) {
		this.mayo = mayo;
	}
	/**
	 * @return Returns the mayoP.
	 */
	public BigDecimal getMayoP() {
		return mayoP;
	}
	/**
	 * @param mayoP The mayoP to set.
	 */
	public void setMayoP(BigDecimal mayoP) {
		this.mayoP = mayoP;
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
	 * @return Returns the novi.
	 */
	public BigDecimal getNovi() {
		return novi;
	}
	/**
	 * @param novi The novi to set.
	 */
	public void setNovi(BigDecimal novi) {
		this.novi = novi;
	}
	/**
	 * @return Returns the noviP.
	 */
	public BigDecimal getNoviP() {
		return noviP;
	}
	/**
	 * @param noviP The noviP to set.
	 */
	public void setNoviP(BigDecimal noviP) {
		this.noviP = noviP;
	}
	/**
	 * @return Returns the octu.
	 */
	public BigDecimal getOctu() {
		return octu;
	}
	/**
	 * @param octu The octu to set.
	 */
	public void setOctu(BigDecimal octu) {
		this.octu = octu;
	}
	/**
	 * @return Returns the octuP.
	 */
	public BigDecimal getOctuP() {
		return octuP;
	}
	/**
	 * @param octuP The octuP to set.
	 */
	public void setOctuP(BigDecimal octuP) {
		this.octuP = octuP;
	}
	/**
	 * @return Returns the seti.
	 */
	public BigDecimal getSeti() {
		return seti;
	}
	/**
	 * @param seti The seti to set.
	 */
	public void setSeti(BigDecimal seti) {
		this.seti = seti;
	}
	/**
	 * @return Returns the setiP.
	 */
	public BigDecimal getSetiP() {
		return setiP;
	}
	/**
	 * @param setiP The setiP to set.
	 */
	public void setSetiP(BigDecimal setiP) {
		this.setiP = setiP;
	}
	/**
	 * @return Returns the totalM.
	 */
	public BigDecimal getTotalM() {
		return totalM;
	}
	/**
	 * @param totalM The totalM to set.
	 */
	public void setTotalM(BigDecimal totalM) {
		this.totalM = totalM;
	}
	/**
	 * @return Returns the totalP.
	 */
	public BigDecimal getTotalP() {
		return totalP;
	}
	/**
	 * @param totalP The totalP to set.
	 */
	public void setTotalP(BigDecimal totalP) {
		this.totalP = totalP;
	}
}
