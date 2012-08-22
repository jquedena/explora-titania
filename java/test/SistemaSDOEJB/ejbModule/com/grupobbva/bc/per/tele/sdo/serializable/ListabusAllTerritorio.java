/*
 * Created on 31-mar-2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

/**
 * @author Oscar Cortez
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ListabusAllTerritorio implements Serializable{
	String CodTerritorio;
	String NomTerritorio;
	String Estado;
	String mensaje;
	String colorFondo;
	

	/**
	 * @return Returns the nomTerritorio.
	 */
	public String getNomTerritorio() {
		return NomTerritorio;
	}
	/**
	 * @param nomTerritorio The nomTerritorio to set.
	 */
	public void setNomTerritorio(String nomTerritorio) {
		NomTerritorio = nomTerritorio;
	}	
	/**
	 * @return Returns the estado.
	 */
	public String getEstado() {
		return Estado;
	}
	/**
	 * @param estado The estado to set.
	 */
	public void setEstado(String estado) {
		Estado = estado;
	}
	/**
	 * @return Returns the codTerritorio.
	 */
	public String getCodTerritorio() {
		return CodTerritorio;
	}
	/**
	 * @param codTerritorio The codTerritorio to set.
	 */
	public void setCodTerritorio(String codTerritorio) {
		CodTerritorio = codTerritorio;
	}
	/**
	 * @return Returns the mensaje.
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje The mensaje to set.
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return Returns the colorFondo.
	 */
	public String getColorFondo() {
		return colorFondo;
	}
	/**
	 * @param colorFondo The colorFondo to set.
	 */
	public void setColorFondo(String colorFondo) {
		this.colorFondo = colorFondo;
	}
	
}