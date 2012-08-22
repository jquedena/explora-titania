/*
 * Created on 26/02/2009
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
public class PlanesAcciones implements Serializable{
	private String codigoEpigrafe;
	private String nombreEpigrafe;
	private BigDecimal prioridad;
	private String codigoOficina;
	private String mes;
	private String anho;
	private BigDecimal metaMesSaldoPuntual;

	private String nombreAccion;
	private String codigoGestor;
	private BigDecimal nroClientes;
	private BigDecimal compromisoGestor;
	private BigDecimal nroGestorSeguimiento1;
	private BigDecimal nroConcSeguimiento1;
	private BigDecimal montoSeguimiento1;
	private BigDecimal nroGestorSeguimiento2;
	private BigDecimal nroConcSeguimiento2;
	private BigDecimal montoSeguimiento2;
	private String codigoAcciones;
	private String codigoPerfil;
	private String nombreGestor;
	private String indicadorAfecta;
	private BigDecimal metaGerenteOficina;
	private BigDecimal asignado;
	
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
	 * @return Returns the asignado.
	 */
	public BigDecimal getAsignado() {
		return asignado;
	}
	/**
	 * @param asignado The asignado to set.
	 */
	public void setAsignado(BigDecimal asignado) {
		this.asignado = asignado;
	}
	/**
	 * @return Returns the codigoAcciones.
	 */
	public String getCodigoAcciones() {
		return codigoAcciones;
	}
	/**
	 * @param codigoAcciones The codigoAcciones to set.
	 */
	public void setCodigoAcciones(String codigoAcciones) {
		this.codigoAcciones = codigoAcciones;
	}
	/**
	 * @return Returns the codigoEpigrafe.
	 */
	public String getCodigoEpigrafe() {
		return codigoEpigrafe;
	}
	/**
	 * @param codigoEpigrafe The codigoEpigrafe to set.
	 */
	public void setCodigoEpigrafe(String codigoEpigrafe) {
		this.codigoEpigrafe = codigoEpigrafe;
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
	 * @return Returns the indicadorAfecta.
	 */
	public String getIndicadorAfecta() {
		return indicadorAfecta;
	}
	/**
	 * @param indicadorAfecta The indicadorAfecta to set.
	 */
	public void setIndicadorAfecta(String indicadorAfecta) {
		this.indicadorAfecta = indicadorAfecta;
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
	 * @return Returns the metaGerenteOficina.
	 */
	public BigDecimal getMetaGerenteOficina() {
		return metaGerenteOficina;
	}
	/**
	 * @param metaGerenteOficina The metaGerenteOficina to set.
	 */
	public void setMetaGerenteOficina(BigDecimal metaGerenteOficina) {
		this.metaGerenteOficina = metaGerenteOficina;
	}
	/**
	 * @return Returns the metaMesSaldoPuntual.
	 */
	public BigDecimal getMetaMesSaldoPuntual() {
		return metaMesSaldoPuntual;
	}
	/**
	 * @param metaMesSaldoPuntual The metaMesSaldoPuntual to set.
	 */
	public void setMetaMesSaldoPuntual(BigDecimal metaMesSaldoPuntual) {
		this.metaMesSaldoPuntual = metaMesSaldoPuntual;
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
	 * @return Returns the nombreAccion.
	 */
	public String getNombreAccion() {
		return nombreAccion;
	}
	/**
	 * @param nombreAccion The nombreAccion to set.
	 */
	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}
	/**
	 * @return Returns the nombreEpigrafe.
	 */
	public String getNombreEpigrafe() {
		return nombreEpigrafe;
	}
	/**
	 * @param nombreEpigrafe The nombreEpigrafe to set.
	 */
	public void setNombreEpigrafe(String nombreEpigrafe) {
		this.nombreEpigrafe = nombreEpigrafe;
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
}
