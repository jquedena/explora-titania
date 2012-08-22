/*
 * Created on 15-ene-2010
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

/**
 * @author ocortez
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TOficina implements Serializable{
	
	String codigoOficina;
	String nombreOficina;
	String codigoTerritorio;	

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
	 * @return Returns the codigoTerritorio.
	 */
	public String getCodigoTerritorio() {
		return codigoTerritorio;
	}
	/**
	 * @param codigoTerritorio The codigoTerritorio to set.
	 */
	public void setCodigoTerritorio(String codigoTerritorio) {
		this.codigoTerritorio = codigoTerritorio;
	}
	/**
	 * @return Returns the nombreOficina.
	 */
	public String getNombreOficina() {
		return nombreOficina;
	}
	/**
	 * @param nombreOficina The nombreOficina to set.
	 */
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}
}
