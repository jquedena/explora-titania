package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.math.BigDecimal;

public class PlanResumen implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal prioridad;
	private String codEpigrafe;
	private String nomEpigrafe;
	private BigDecimal factPlanificacion;
	private BigDecimal ajusteTerrPlanificacion;
	private BigDecimal factAsigGOFPlanificacion;
	private BigDecimal totalAsignadoObjetivos;
	private BigDecimal GOFObjetivos;
	private BigDecimal porcGOFObjetivos;
	private BigDecimal GCOObjetivos;
	private BigDecimal porcGCOObjetivos;
	private BigDecimal GPEObjetivos;
	private BigDecimal porcGPEObjetivos;
	private BigDecimal GPTObjetivos;
	private BigDecimal porcGPTObjetivos;
	
	private BigDecimal porcentajeMax;
	private BigDecimal porcentajeMin;
	private BigDecimal porAlcanzado;
	private String indAfecta;
	private String indHijo;
	
	public String getIndHijo() {
		return indHijo;
	}
	public void setIndHijo(String indHijo) {
		this.indHijo = indHijo;
	}
	
	public long getPorcGOFObjetivosEntero(){
		if(this.porcGOFObjetivos!=null)
			return porcGOFObjetivos.longValue();
		else
			return 0;
	}
	public long getPorcGCOObjetivosEntero(){
		if(this.porcGCOObjetivos!=null)
			return porcGCOObjetivos.longValue();
		else
			return 0;
	}
	public long getPorcGPEObjetivosEntero(){
		if(this.porcGPEObjetivos!=null)
			return porcGPEObjetivos.longValue();
		else
			return 0;
	}
	public long getPorcGPTObjetivosEntero(){
		if(this.porcGPTObjetivos!=null)
			return porcGPTObjetivos.longValue();
		else
			return 0;
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
	/**
	 * @return Returns the ajusteTerrPlanificacion.
	 */
	public BigDecimal getAjusteTerrPlanificacion() {
		return ajusteTerrPlanificacion;
	}
	/**
	 * @param ajusteTerrPlanificacion The ajusteTerrPlanificacion to set.
	 */
	public void setAjusteTerrPlanificacion(BigDecimal ajusteTerrPlanificacion) {
		this.ajusteTerrPlanificacion = ajusteTerrPlanificacion;
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
	 * @return Returns the factAsigGOFPlanificacion.
	 */
	public BigDecimal getFactAsigGOFPlanificacion() {
		return factAsigGOFPlanificacion;
	}
	/**
	 * @param factAsigGOFPlanificacion The factAsigGOFPlanificacion to set.
	 */
	public void setFactAsigGOFPlanificacion(BigDecimal factAsigGOFPlanificacion) {
		this.factAsigGOFPlanificacion = factAsigGOFPlanificacion;
	}
	/**
	 * @return Returns the factPlanificacion.
	 */
	public BigDecimal getFactPlanificacion() {
		return factPlanificacion;
	}
	/**
	 * @param factPlanificacion The factPlanificacion to set.
	 */
	public void setFactPlanificacion(BigDecimal factPlanificacion) {
		this.factPlanificacion = factPlanificacion;
	}
	/**
	 * @return Returns the gCOObjetivos.
	 */
	public BigDecimal getGCOObjetivos() {
		return GCOObjetivos;
	}
	/**
	 * @param objetivos The gCOObjetivos to set.
	 */
	public void setGCOObjetivos(BigDecimal objetivos) {
		GCOObjetivos = objetivos;
	}
	/**
	 * @return Returns the gOFObjetivos.
	 */
	public BigDecimal getGOFObjetivos() {
		return GOFObjetivos;
	}
	/**
	 * @param objetivos The gOFObjetivos to set.
	 */
	public void setGOFObjetivos(BigDecimal objetivos) {
		GOFObjetivos = objetivos;
	}
	/**
	 * @return Returns the gPEObjetivos.
	 */
	public BigDecimal getGPEObjetivos() {
		return GPEObjetivos;
	}
	/**
	 * @param objetivos The gPEObjetivos to set.
	 */
	public void setGPEObjetivos(BigDecimal objetivos) {
		GPEObjetivos = objetivos;
	}
	/**
	 * @return Returns the gPTObjetivos.
	 */
	public BigDecimal getGPTObjetivos() {
		return GPTObjetivos;
	}
	/**
	 * @param objetivos The gPTObjetivos to set.
	 */
	public void setGPTObjetivos(BigDecimal objetivos) {
		GPTObjetivos = objetivos;
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
	 * @return Returns the porcGCOObjetivos.
	 */
	public BigDecimal getPorcGCOObjetivos() {
		return porcGCOObjetivos;
	}
	/**
	 * @param porcGCOObjetivos The porcGCOObjetivos to set.
	 */
	public void setPorcGCOObjetivos(BigDecimal porcGCOObjetivos) {
		this.porcGCOObjetivos = porcGCOObjetivos;
	}
	/**
	 * @return Returns the porcGOFObjetivos.
	 */
	public BigDecimal getPorcGOFObjetivos() {
		return porcGOFObjetivos;
	}
	/**
	 * @param porcGOFObjetivos The porcGOFObjetivos to set.
	 */
	public void setPorcGOFObjetivos(BigDecimal porcGOFObjetivos) {
		this.porcGOFObjetivos = porcGOFObjetivos;
	}
	/**
	 * @return Returns the porcGPEObjetivos.
	 */
	public BigDecimal getPorcGPEObjetivos() {
		return porcGPEObjetivos;
	}
	/**
	 * @param porcGPEObjetivos The porcGPEObjetivos to set.
	 */
	public void setPorcGPEObjetivos(BigDecimal porcGPEObjetivos) {
		this.porcGPEObjetivos = porcGPEObjetivos;
	}
	/**
	 * @return Returns the porcGPTObjetivos.
	 */
	public BigDecimal getPorcGPTObjetivos() {
		return porcGPTObjetivos;
	}
	/**
	 * @param porcGPTObjetivos The porcGPTObjetivos to set.
	 */
	public void setPorcGPTObjetivos(BigDecimal porcGPTObjetivos) {
		this.porcGPTObjetivos = porcGPTObjetivos;
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
