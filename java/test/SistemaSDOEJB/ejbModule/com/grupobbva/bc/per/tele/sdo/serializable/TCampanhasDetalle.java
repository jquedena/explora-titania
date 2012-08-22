/*
 * Created on 16-ene-2010
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ocortez
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TCampanhasDetalle implements Serializable{
	
	String codigoCampanhaDetalle;
	String nombreCampanha;
	String codigoGestor;
	String mes;
	String anho;
	int nroClientes;
	int compromisoGestor;
	int nroGestorSeguimiento1;
	int nroConcSeguimiento1;
	int montoSeguimiento1;
	int nroGestorSeguimiento2;
	int nroConcSeguimiento2;
	int montoSeguimiento2;
	String codigoOficina;
	String codigoCampanha;
	Date fechaGrabacion;
	Date fechaSeg1;
	Date fechaSeg2;	
	
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
	 * @return Returns the codigoCampanha.
	 */
	public String getCodigoCampanha() {
		return codigoCampanha;
	}
	/**
	 * @param codigoCampanha The codigoCampanha to set.
	 */
	public void setCodigoCampanha(String codigoCampanha) {
		this.codigoCampanha = codigoCampanha;
	}
	/**
	 * @return Returns the codigoCampanhaDetalle.
	 */
	public String getCodigoCampanhaDetalle() {
		return codigoCampanhaDetalle;
	}
	/**
	 * @param codigoCampanhaDetalle The codigoCampanhaDetalle to set.
	 */
	public void setCodigoCampanhaDetalle(String codigoCampanhaDetalle) {
		this.codigoCampanhaDetalle = codigoCampanhaDetalle;
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
	 * @return Returns the compromisoGestor.
	 */
	public int getCompromisoGestor() {
		return compromisoGestor;
	}
	/**
	 * @param compromisoGestor The compromisoGestor to set.
	 */
	public void setCompromisoGestor(int compromisoGestor) {
		this.compromisoGestor = compromisoGestor;
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
	/**
	 * @return Returns the fechaSeg1.
	 */
	public Date getFechaSeg1() {
		return fechaSeg1;
	}
	/**
	 * @param fechaSeg1 The fechaSeg1 to set.
	 */
	public void setFechaSeg1(Date fechaSeg1) {
		this.fechaSeg1 = fechaSeg1;
	}
	/**
	 * @return Returns the fechaSeg2.
	 */
	public Date getFechaSeg2() {
		return fechaSeg2;
	}
	/**
	 * @param fechaSeg2 The fechaSeg2 to set.
	 */
	public void setFechaSeg2(Date fechaSeg2) {
		this.fechaSeg2 = fechaSeg2;
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
	public int getMontoSeguimiento1() {
		return montoSeguimiento1;
	}
	/**
	 * @param montoSeguimiento1 The montoSeguimiento1 to set.
	 */
	public void setMontoSeguimiento1(int montoSeguimiento1) {
		this.montoSeguimiento1 = montoSeguimiento1;
	}
	/**
	 * @return Returns the montoSeguimiento2.
	 */
	public int getMontoSeguimiento2() {
		return montoSeguimiento2;
	}
	/**
	 * @param montoSeguimiento2 The montoSeguimiento2 to set.
	 */
	public void setMontoSeguimiento2(int montoSeguimiento2) {
		this.montoSeguimiento2 = montoSeguimiento2;
	}
	/**
	 * @return Returns the nombreCampanha.
	 */
	public String getNombreCampanha() {
		return nombreCampanha;
	}
	/**
	 * @param nombreCampanha The nombreCampanha to set.
	 */
	public void setNombreCampanha(String nombreCampanha) {
		this.nombreCampanha = nombreCampanha;
	}
	/**
	 * @return Returns the nroClientes.
	 */
	public int getNroClientes() {
		return nroClientes;
	}
	/**
	 * @param nroClientes The nroClientes to set.
	 */
	public void setNroClientes(int nroClientes) {
		this.nroClientes = nroClientes;
	}
	/**
	 * @return Returns the nroConcSeguimiento1.
	 */
	public int getNroConcSeguimiento1() {
		return nroConcSeguimiento1;
	}
	/**
	 * @param nroConcSeguimiento1 The nroConcSeguimiento1 to set.
	 */
	public void setNroConcSeguimiento1(int nroConcSeguimiento1) {
		this.nroConcSeguimiento1 = nroConcSeguimiento1;
	}
	/**
	 * @return Returns the nroConcSeguimiento2.
	 */
	public int getNroConcSeguimiento2() {
		return nroConcSeguimiento2;
	}
	/**
	 * @param nroConcSeguimiento2 The nroConcSeguimiento2 to set.
	 */
	public void setNroConcSeguimiento2(int nroConcSeguimiento2) {
		this.nroConcSeguimiento2 = nroConcSeguimiento2;
	}
	/**
	 * @return Returns the nroGestorSeguimiento1.
	 */
	public int getNroGestorSeguimiento1() {
		return nroGestorSeguimiento1;
	}
	/**
	 * @param nroGestorSeguimiento1 The nroGestorSeguimiento1 to set.
	 */
	public void setNroGestorSeguimiento1(int nroGestorSeguimiento1) {
		this.nroGestorSeguimiento1 = nroGestorSeguimiento1;
	}
	/**
	 * @return Returns the nroGestorSeguimiento2.
	 */
	public int getNroGestorSeguimiento2() {
		return nroGestorSeguimiento2;
	}
	/**
	 * @param nroGestorSeguimiento2 The nroGestorSeguimiento2 to set.
	 */
	public void setNroGestorSeguimiento2(int nroGestorSeguimiento2) {
		this.nroGestorSeguimiento2 = nroGestorSeguimiento2;
	}
}
