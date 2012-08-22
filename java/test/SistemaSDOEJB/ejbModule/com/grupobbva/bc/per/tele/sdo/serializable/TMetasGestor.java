/*
 * Created on 18-ene-2010
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
public class TMetasGestor implements Serializable{
	
	String codigoMetaGestor;
	String codigoEpigrafe;
	String codigoOficina;
	String codigoGestor;
	String anho;
	String mes;
	String orden;
	Date fecgaGrabacion;
	String porcAsignado;
	String nombreEpigrafe;
	String nombreGestor;
	
	
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
	 * @return Returns the codigoMetaGestor.
	 */
	public String getCodigoMetaGestor() {
		return codigoMetaGestor;
	}
	/**
	 * @param codigoMetaGestor The codigoMetaGestor to set.
	 */
	public void setCodigoMetaGestor(String codigoMetaGestor) {
		this.codigoMetaGestor = codigoMetaGestor;
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
	 * @return Returns the fecgaGrabacion.
	 */
	public Date getFecgaGrabacion() {
		return fecgaGrabacion;
	}
	/**
	 * @param fecgaGrabacion The fecgaGrabacion to set.
	 */
	public void setFecgaGrabacion(Date fecgaGrabacion) {
		this.fecgaGrabacion = fecgaGrabacion;
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
	 * @return Returns the porcAsignado.
	 */
	public String getPorcAsignado() {
		return porcAsignado;
	}
	/**
	 * @param porcAsignado The porcAsignado to set.
	 */
	public void setPorcAsignado(String porcAsignado) {
		this.porcAsignado = porcAsignado;
	}

}
