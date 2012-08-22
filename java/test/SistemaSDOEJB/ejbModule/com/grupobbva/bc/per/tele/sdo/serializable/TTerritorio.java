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
public class TTerritorio implements Serializable {
	
	String codigoTerritorio;
	String nombreTerritorio;

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
	 * @return Returns the nombreTerritorio.
	 */
	public String getNombreTerritorio() {
		return nombreTerritorio;
	}
	/**
	 * @param nombreTerritorio The nombreTerritorio to set.
	 */
	public void setNombreTerritorio(String nombreTerritorio) {
		this.nombreTerritorio = nombreTerritorio;
	}
}
