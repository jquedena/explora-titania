/*
 * Created on 20/01/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OficinaHija implements Serializable {
	private String codigoOficinaHija;	
	private String nombreOficinaHija;
	private String codigoOficinaPadre;
	private String nombreOficinaPadre;
	private String usuario;

	public OficinaHija() {
		
	}
	/**
	 * @return Returns the codigoOficinaHija.
	 */
	public String getCodigoOficinaHija() {
		return codigoOficinaHija;
	}
	/**
	 * @param codigoOficinaHija The codigoOficinaHija to set.
	 */
	public void setCodigoOficinaHija(String codigoOficinaHija) {
		this.codigoOficinaHija = codigoOficinaHija;
	}
	/**
	 * @return Returns the codigoOficinaPadre.
	 */
	public String getCodigoOficinaPadre() {
		return codigoOficinaPadre;
	}
	/**
	 * @param codigoOficinaPadre The codigoOficinaPadre to set.
	 */
	public void setCodigoOficinaPadre(String codigoOficinaPadre) {
		this.codigoOficinaPadre = codigoOficinaPadre;
	}
	/**
	 * @return Returns the nombreOficinaHija.
	 */
	public String getNombreOficinaHija() {
		return nombreOficinaHija;
	}
	/**
	 * @param nombreOficinaHija The nombreOficinaHija to set.
	 */
	public void setNombreOficinaHija(String nombreOficinaHija) {
		this.nombreOficinaHija = nombreOficinaHija;
	}
	/**
	 * @return Returns the nombreOficinaPadre.
	 */
	public String getNombreOficinaPadre() {
		return nombreOficinaPadre;
	}
	/**
	 * @param nombreOficinaPadre The nombreOficinaPadre to set.
	 */
	public void setNombreOficinaPadre(String nombreOficinaPadre) {
		this.nombreOficinaPadre = nombreOficinaPadre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
