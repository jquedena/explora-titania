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
public class TCampanhas implements Serializable{
	
	String codigoCampania;
	String anho;
	String mes;
	String nombreCampania;
	String codigoOficina;
	String codigoGestor;
	String orden;
	String gte;
	Date fechaGrabacion;
	
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
	 * @return Returns the gte.
	 */
	public String getGte() {
		return gte;
	}
	/**
	 * @param gte The gte to set.
	 */
	public void setGte(String gte) {
		this.gte = gte;
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
}
