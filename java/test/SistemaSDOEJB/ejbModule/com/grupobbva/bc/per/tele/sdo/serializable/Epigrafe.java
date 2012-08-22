/*
 * Created on 24/01/2009
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
public class Epigrafe implements Serializable, Comparable{
	private String codEpigrafe;
	private String anho;
	private String nomEpigrafe;
	private String indClase;
	private String indSubClase;
	private String orden;
	private String indGrupo;
	private String abreviatura;
	private String indHijo;
	private String indAfecta;
	private BigDecimal porcAsignado;
	/**
	 * @return Returns the listaCodOficina.
	 */
	public String getListaCodOficina() {
		return listaCodOficina;
	}
	/**
	 * @param listaCodOficina The listaCodOficina to set.
	 */
	public void setListaCodOficina(String listaCodOficina) {
		this.listaCodOficina = listaCodOficina;
	}
	private BigDecimal porcentajeMax;
	private BigDecimal porcentajeMin;
	private String listaCodOficina;

	/**
	 * @return Returns the abreviatura.
	 */
	public String getAbreviatura() {
		return abreviatura;
	}
	/**
	 * @param abreviatura The abreviatura to set.
	 */
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
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
	 * @return Returns the indGrupo.
	 */
	public String getIndGrupo() {
		return indGrupo;
	}
	/**
	 * @param indGrupo The indGrupo to set.
	 */
	public void setIndGrupo(String indGrupo) {
		this.indGrupo = indGrupo;
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
	
	public int compareTo(Object o) {
		Epigrafe epi = (Epigrafe)o;
		
        if(epi.getNomEpigrafe().compareTo(this.nomEpigrafe) > 0)
            return -1;
        else if(this.nomEpigrafe.equals(epi.getNomEpigrafe()))
            return 0;
        else
            return 1;
}
	/**
	 * @return Returns the porcAsignado.
	 */
	public BigDecimal getPorcAsignado() {
		return porcAsignado;
	}
	/**
	 * @param porcAsignado The porcAsignado to set.
	 */
	public void setPorcAsignado(BigDecimal porcAsignado) {
		this.porcAsignado = porcAsignado;
	}
}
