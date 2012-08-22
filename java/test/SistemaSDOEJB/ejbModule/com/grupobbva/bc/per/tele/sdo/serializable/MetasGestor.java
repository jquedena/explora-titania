/*
 * Created on 16-feb-2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author Administrador
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings("serial")
public class MetasGestor implements Serializable{

	private String codMetaGestor;
	private Oficina Oficina;
	private String codEpigrafe;
	private String anho;
	private String codGestor;
	private String mes;
	private Date fecRegistro;
	private BigDecimal porcAsignado;
	private String nomEpigrafe;
	private String nomGestor;
	private String orden;
	private String codPerfil;
	private String estado;
	private String usuario;
	
	
	/**
	 * @return Returns the oficina.
	 */
	public Oficina getOficina() {
		return Oficina;
	}
	/**
	 * @param oficina The oficina to set.
	 */
	public void setOficina(Oficina oficina) {
		Oficina = oficina;
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
	 * @return Returns the codMetaGestor.
	 */
	public String getCodMetaGestor() {
		return codMetaGestor;
	}
	/**
	 * @param codMetaGestor The codMetaGestor to set.
	 */
	public void setCodMetaGestor(String codMetaGestor) {
		this.codMetaGestor = codMetaGestor;
	}
	/**
	 * @return Returns the fecRegistro.
	 */
	public Date getFecRegistro() {
		return fecRegistro;
	}
	/**
	 * @param fecRegistro The fecRegistro to set.
	 */
	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
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
	 * @return Returns the estado.
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado The estado to set.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
