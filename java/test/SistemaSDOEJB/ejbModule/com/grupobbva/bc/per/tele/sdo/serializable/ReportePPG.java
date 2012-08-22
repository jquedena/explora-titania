package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

public class ReportePPG implements Serializable {

	private static final long serialVersionUID = -8522675582304895170L;
	String anho;
	String codOficina;
	String nomOficina;
	String nomGestor;
	String codGestor;
	String prioridad;
	String nomEpigrafe;
	String codEpigrafe;
	String mes;
	String esfuerzo;
	int codCampMax;
	String codCamp;
	String codPerfil;
	String indAfecta;
	
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
	 * @return Returns the codPerfil.
	 */
	public String getCodPerfil() {
		return codPerfil;
	}
	/**
	 * @param codPerfil The codPerfil to set.
	 */
	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
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
	 * @return Returns the prioridad.
	 */
	public String getPrioridad() {
		return prioridad;
	}
	/**
	 * @param prioridad The prioridad to set.
	 */
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
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
	 * @return Returns the nomGestor.
	 */
	public String getNomGestor() {
		return nomGestor;
	}
	/**
	 * @param nomGestor The nomGestor to set.
	 */
	public void setNomGestor(String nomGestor) {
		this.nomGestor = nomGestor;
	}
	/**
	 * @return Returns the nomOficina.
	 */
	public String getNomOficina() {
		return nomOficina;
	}
	/**
	 * @param nomOficina The nomOficina to set.
	 */
	public void setNomOficina(String nomOficina) {
		this.nomOficina = nomOficina;
	}


	/**
	 * @return Returns the codGestor.
	 */
	public String getCodGestor() {
		return codGestor;
	}
	/**
	 * @param codGestor The codGestor to set.
	 */
	public void setCodGestor(String codGestor) {
		this.codGestor = codGestor;
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
	 * @return Returns the esfuerzo.
	 */
	public String getEsfuerzo() {
		return esfuerzo;
	}
	/**
	 * @param esfuerzo The esfuerzo to set.
	 */
	public void setEsfuerzo(String esfuerzo) {
		this.esfuerzo = esfuerzo;
	}

	/**
	 * @return Returns the codCampMax.
	 */
	public int getCodCampMax() {
		return codCampMax;
	}
	/**
	 * @param codCampMax The codCampMax to set.
	 */
	public void setCodCampMax(int codCampMax) {
		this.codCampMax = codCampMax;
	}
	/**
	 * @return Returns the codCamp.
	 */
	public String getCodCamp() {
		return codCamp;
	}
	/**
	 * @param codCamp The codCamp to set.
	 */
	public void setCodCamp(String codCamp) {
		this.codCamp = codCamp;
	}
}
