/*
 * Created on 26/02/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CampaniasGeneral implements Serializable{
	private String nombreCampaniaDetalle;
	private String codigoGestor;
    private String mes;
	private String anho;	
	private BigDecimal nroClientes;
	private BigDecimal compromisoGestor;	
	private BigDecimal nroGestorSeguimiento1;
	private BigDecimal nroConcSeguimiento1;
	private BigDecimal montoSeguimiento1;
	private BigDecimal nroGestorSeguimiento2;
    private BigDecimal nroConcSeguimiento2;
	private BigDecimal montoSeguimiento2;	
	private String codigoCampaniaDetalle;
	private String codigoOficina;
	private String codigoCampania;
	private String nombreCampania;
	private String orden;
	private String codigoPerfil;
	private String nombreGestor;
	
	private BigDecimal totalNroGestor;
	/**
	 * @return Returns the totalMonto.
	 */
	public BigDecimal getTotalMonto() {
		return totalMonto;
	}
	/**
	 * @param totalMonto The totalMonto to set.
	 */
	public void setTotalMonto(BigDecimal totalMonto) {
		this.totalMonto = totalMonto;
	}
	/**
	 * @return Returns the totalNroConc.
	 */
	public BigDecimal getTotalNroConc() {
		return totalNroConc;
	}
	/**
	 * @param totalNroConc The totalNroConc to set.
	 */
	public void setTotalNroConc(BigDecimal totalNroConc) {
		this.totalNroConc = totalNroConc;
	}
	/**
	 * @return Returns the totalNroGestor.
	 */
	public BigDecimal getTotalNroGestor() {
		return totalNroGestor;
	}
	/**
	 * @param totalNroGestor The totalNroGestor to set.
	 */
	public void setTotalNroGestor(BigDecimal totalNroGestor) {
		this.totalNroGestor = totalNroGestor;
	}
	private BigDecimal totalNroConc;
	private BigDecimal totalMonto;
	
	Date fechaGrabacion;
	Date FEC_REGI;
	/**
	 * @return Returns the fEC_REGI.
	 */
	public Date getFEC_REGI() {
		return FEC_REGI;
	}
	/**
	 * @param fec_regi The fEC_REGI to set.
	 */
	public void setFEC_REGI(Date fec_regi) {
		FEC_REGI = fec_regi;
	}
	/**
	 * @return Returns the fEC_segu_1.
	 */
	public Date getFEC_segu_1() {
		return FEC_segu_1;
	}
	/**
	 * @param fec_segu_1 The fEC_segu_1 to set.
	 */
	public void setFEC_segu_1(Date fec_segu_1) {
		FEC_segu_1 = fec_segu_1;
	}
	/**
	 * @return Returns the fEC_segu_2.
	 */
	public Date getFEC_segu_2() {
		return FEC_segu_2;
	}
	/**
	 * @param fec_segu_2 The fEC_segu_2 to set.
	 */
	public void setFEC_segu_2(Date fec_segu_2) {
		FEC_segu_2 = fec_segu_2;
	}
	/**
	 * @return Returns the fechaGrabacion.
	 */
	public Date getFechaGrabacion() {
		return fechaGrabacion;
	}
	/**
	 * @param fechaGrabacion The fechaGrabacion to set.
	 */
	public void setFechaGrabacion(Date fechaGrabacion) {
		this.fechaGrabacion = fechaGrabacion;
	}
	Date FEC_segu_1;
	Date FEC_segu_2;
	
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
	 * @return Returns the codigoCampania.
	 */
	public String getCodigoCampania() {
		return codigoCampania;
	}
	/**
	 * @param codigoCampania The codigoCampania to set.
	 */
	public void setCodigoCampania(String codigoCampania) {
		this.codigoCampania = codigoCampania;
	}
	/**
	 * @return Returns the codigoCampaniaDetalle.
	 */
	public String getCodigoCampaniaDetalle() {
		return codigoCampaniaDetalle;
	}
	/**
	 * @param codigoCampaniaDetalle The codigoCampaniaDetalle to set.
	 */
	public void setCodigoCampaniaDetalle(String codigoCampaniaDetalle) {
		this.codigoCampaniaDetalle = codigoCampaniaDetalle;
	}
	/**
	 * @return Returns the codigoGestor.
	 */
	public String getCodigoGestor() {
		return codigoGestor;
	}
	/**
	 * @param codigoGestor The codigoGestor to set.
	 */
	public void setCodigoGestor(String codigoGestor) {
		this.codigoGestor = codigoGestor;
	}
	/**
	 * @return Returns the codigoOficina.
	 */
	public String getCodigoOficina() {
		return codigoOficina;
	}
	/**
	 * @param codigoOficina The codigoOficina to set.
	 */
	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}
	/**
	 * @return Returns the codigoPerfil.
	 */
	public String getCodigoPerfil() {
		return codigoPerfil;
	}
	/**
	 * @param codigoPerfil The codigoPerfil to set.
	 */
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	/**
	 * @return Returns the compromisoGestor.
	 */
	public BigDecimal getCompromisoGestor() {
		return compromisoGestor;
	}
	/**
	 * @param compromisoGestor The compromisoGestor to set.
	 */
	public void setCompromisoGestor(BigDecimal compromisoGestor) {
		this.compromisoGestor = compromisoGestor;
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
	 * @return Returns the montoSeguimiento1.
	 */
	public BigDecimal getMontoSeguimiento1() {
		return montoSeguimiento1;
	}
	/**
	 * @param montoSeguimiento1 The montoSeguimiento1 to set.
	 */
	public void setMontoSeguimiento1(BigDecimal montoSeguimiento1) {
		this.montoSeguimiento1 = montoSeguimiento1;
	}
	/**
	 * @return Returns the montoSeguimiento2.
	 */
	public BigDecimal getMontoSeguimiento2() {
		return montoSeguimiento2;
	}
	/**
	 * @param montoSeguimiento2 The montoSeguimiento2 to set.
	 */
	public void setMontoSeguimiento2(BigDecimal montoSeguimiento2) {
		this.montoSeguimiento2 = montoSeguimiento2;
	}
	/**
	 * @return Returns the nombreCampania.
	 */
	public String getNombreCampania() {
		return nombreCampania;
	}
	/**
	 * @param nombreCampania The nombreCampania to set.
	 */
	public void setNombreCampania(String nombreCampania) {
		this.nombreCampania = nombreCampania;
	}
	/**
	 * @return Returns the nombreCampaniaDetalle.
	 */
	public String getNombreCampaniaDetalle() {
		return nombreCampaniaDetalle;
	}
	/**
	 * @param nombreCampaniaDetalle The nombreCampaniaDetalle to set.
	 */
	public void setNombreCampaniaDetalle(String nombreCampaniaDetalle) {
		this.nombreCampaniaDetalle = nombreCampaniaDetalle;
	}
	/**
	 * @return Returns the nombreGestor.
	 */
	public String getNombreGestor() {
		return nombreGestor;
	}
	/**
	 * @param nombreGestor The nombreGestor to set.
	 */
	public void setNombreGestor(String nombreGestor) {
		this.nombreGestor = nombreGestor;
	}
	/**
	 * @return Returns the nroClientes.
	 */
	public BigDecimal getNroClientes() {
		return nroClientes;
	}
	/**
	 * @param nroClientes The nroClientes to set.
	 */
	public void setNroClientes(BigDecimal nroClientes) {
		this.nroClientes = nroClientes;
	}
	/**
	 * @return Returns the nroConcSeguimiento1.
	 */
	public BigDecimal getNroConcSeguimiento1() {
		return nroConcSeguimiento1;
	}
	/**
	 * @param nroConcSeguimiento1 The nroConcSeguimiento1 to set.
	 */
	public void setNroConcSeguimiento1(BigDecimal nroConcSeguimiento1) {
		this.nroConcSeguimiento1 = nroConcSeguimiento1;
	}
	/**
	 * @return Returns the nroConcSeguimiento2.
	 */
	public BigDecimal getNroConcSeguimiento2() {
		return nroConcSeguimiento2;
	}
	/**
	 * @param nroConcSeguimiento2 The nroConcSeguimiento2 to set.
	 */
	public void setNroConcSeguimiento2(BigDecimal nroConcSeguimiento2) {
		this.nroConcSeguimiento2 = nroConcSeguimiento2;
	}
	/**
	 * @return Returns the nroGestorSeguimiento1.
	 */
	public BigDecimal getNroGestorSeguimiento1() {
		return nroGestorSeguimiento1;
	}
	/**
	 * @param nroGestorSeguimiento1 The nroGestorSeguimiento1 to set.
	 */
	public void setNroGestorSeguimiento1(BigDecimal nroGestorSeguimiento1) {
		this.nroGestorSeguimiento1 = nroGestorSeguimiento1;
	}
	/**
	 * @return Returns the nroGestorSeguimiento2.
	 */
	public BigDecimal getNroGestorSeguimiento2() {
		return nroGestorSeguimiento2;
	}
	/**
	 * @param nroGestorSeguimiento2 The nroGestorSeguimiento2 to set.
	 */
	public void setNroGestorSeguimiento2(BigDecimal nroGestorSeguimiento2) {
		this.nroGestorSeguimiento2 = nroGestorSeguimiento2;
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
}
