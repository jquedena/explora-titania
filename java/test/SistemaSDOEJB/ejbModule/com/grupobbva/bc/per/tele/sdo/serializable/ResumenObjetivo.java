package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResumenObjetivo implements Serializable {
	private String codEpigrafe;	
	private BigDecimal totalAsignadoObjetivos;
	private BigDecimal GOF;
	private BigDecimal porcGOF;
	private BigDecimal GCO;
	private BigDecimal porcGCO;
	private BigDecimal GPE;
	private BigDecimal porcGPE;
	private BigDecimal GPT;
	private BigDecimal porcGPT;
	
	
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
	 * @return Returns the gCO.
	 */
	public BigDecimal getGCO() {
		return GCO;
	}
	/**
	 * @param gco The gCO to set.
	 */
	public void setGCO(BigDecimal gco) {
		GCO = gco;
	}
	/**
	 * @return Returns the gOF.
	 */
	public BigDecimal getGOF() {
		return GOF;
	}
	/**
	 * @param gof The gOF to set.
	 */
	public void setGOF(BigDecimal gof) {
		GOF = gof;
	}
	/**
	 * @return Returns the gPE.
	 */
	public BigDecimal getGPE() {
		return GPE;
	}
	/**
	 * @param gpe The gPE to set.
	 */
	public void setGPE(BigDecimal gpe) {
		GPE = gpe;
	}
	/**
	 * @return Returns the gPT.
	 */
	public BigDecimal getGPT() {
		return GPT;
	}
	/**
	 * @param gpt The gPT to set.
	 */
	public void setGPT(BigDecimal gpt) {
		GPT = gpt;
	}
	/**
	 * @return Returns the porcGCO.
	 */
	public BigDecimal getPorcGCO() {
		return porcGCO;
	}
	/**
	 * @param porcGCO The porcGCO to set.
	 */
	public void setPorcGCO(BigDecimal porcGCO) {
		this.porcGCO = porcGCO;
	}
	/**
	 * @return Returns the porcGOF.
	 */
	public BigDecimal getPorcGOF() {
		return porcGOF;
	}
	/**
	 * @param porcGOF The porcGOF to set.
	 */
	public void setPorcGOF(BigDecimal porcGOF) {
		this.porcGOF = porcGOF;
	}
	/**
	 * @return Returns the porcGPE.
	 */
	public BigDecimal getPorcGPE() {
		return porcGPE;
	}
	/**
	 * @param porcGPE The porcGPE to set.
	 */
	public void setPorcGPE(BigDecimal porcGPE) {
		this.porcGPE = porcGPE;
	}
	/**
	 * @return Returns the porcGPT.
	 */
	public BigDecimal getPorcGPT() {
		return porcGPT;
	}
	/**
	 * @param porcGPT The porcGPT to set.
	 */
	public void setPorcGPT(BigDecimal porcGPT) {
		this.porcGPT = porcGPT;
	}
	/**
	 * @return Returns the totalAsignadoObjetivos.
	 */
	public BigDecimal getTotalAsignadoObjetivos() {
		return totalAsignadoObjetivos;
	}
	/**
	 * @param totalAsignadoObjetivos The totalAsignadoObjetivos to set.
	 */
	public void setTotalAsignadoObjetivos(BigDecimal totalAsignadoObjetivos) {
		this.totalAsignadoObjetivos = totalAsignadoObjetivos;
	}
}
