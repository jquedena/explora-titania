/*
 * Created on 15-abr-2009
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
public class UsuarioLDAP implements Serializable{
	private String UID;
	private String nombreCompleto;
	private String codigoCargo;
	private String codigoOficina;
	
	
	/**
	 * @return Returns the codigoCargo.
	 */
	public String getCodigoCargo() {
		return codigoCargo;
	}
	/**
	 * @param codigoCargo The codigoCargo to set.
	 */
	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	/**
	 * @return Returns the nombreCompleto.
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	/**
	 * @param nombreCompleto The nombreCompleto to set.
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	/**
	 * @return Returns the uID.
	 */
	public String getUID() {
		return UID;
	}
	/**
	 * @param uid The uID to set.
	 */
	public void setUID(String uid) {
		UID = uid;
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
}
