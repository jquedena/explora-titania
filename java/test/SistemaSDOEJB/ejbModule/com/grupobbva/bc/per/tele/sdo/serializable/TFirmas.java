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
public class TFirmas implements Serializable{
	
	String anho;
	String mes;
	String item;
	String codigoGestor;
	String codigoOficina;
	String descripcion;
	Date fecha;
	
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
	 * @return Returns the descripcion.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion The descripcion to set.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return Returns the fecha.
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha The fecha to set.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return Returns the item.
	 */
	public String getItem() {
		return item;
	}
	/**
	 * @param item The item to set.
	 */
	public void setItem(String item) {
		this.item = item;
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

}
