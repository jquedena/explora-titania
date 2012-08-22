package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Campanias implements Serializable{
	
	String codCamp;
	String nomCamp;
	String codOficicina;
	String codTerritorio;
	String codGestor;
	String anho;
	String mes;
	String orden;
	String get;
	String esfuerzo;
	String numeroCliente;
	String compGestor;
	String codEpigrafe;
	
	
	public String getCodEpigrafe() {
		return codEpigrafe;
	}
	public void setCodEpigrafe(String codEpigrafe) {
		this.codEpigrafe = codEpigrafe;
	}
	/**
	 * @return Returns the compGestor.
	 */
	public String getCompGestor() {
		return compGestor;
	}
	/**
	 * @param compGestor The compGestor to set.
	 */
	public void setCompGestor(String compGestor) {
		this.compGestor = compGestor;
	}
	/**
	 * @return Returns the numeroCliente.
	 */
	public String getNumeroCliente() {
		return numeroCliente;
	}
	/**
	 * @param numeroCliente The numeroCliente to set.
	 */
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
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
	 * @return Returns the codOficicina.
	 */
	public String getCodOficicina() {
		return codOficicina;
	}
	/**
	 * @param codOficicina The codOficicina to set.
	 */
	public void setCodOficicina(String codOficicina) {
		this.codOficicina = codOficicina;
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
	 * @return Returns the get.
	 */
	public String getGet() {
		return get;
	}
	/**
	 * @param get The get to set.
	 */
	public void setGet(String get) {
		this.get = get;
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
	 * @return Returns the nomCamp.
	 */
	public String getNomCamp() {
		return nomCamp;
	}
	/**
	 * @param nomCamp The nomCamp to set.
	 */
	public void setNomCamp(String nomCamp) {
		this.nomCamp = nomCamp;
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
}
