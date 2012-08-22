/*
 * Created on 12/01/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

public class Perfil implements Serializable{
	
	private static final long serialVersionUID = 8140303253817920398L;
	private String codPerfil;
	private String nomPerfil;
	private String perfil;
	private String usuRegi;
	private String fecRegi;
	private String usuActu;
	private String fecActu;
	public String getCodPerfil() {
		return codPerfil;
	}
	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}
	public String getNomPerfil() {
		return nomPerfil;
	}
	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getUsuRegi() {
		return usuRegi;
	}
	public void setUsuRegi(String usuRegi) {
		this.usuRegi = usuRegi;
	}
	public String getFecRegi() {
		return fecRegi;
	}
	public void setFecRegi(String fecRegi) {
		this.fecRegi = fecRegi;
	}
	public String getUsuActu() {
		return usuActu;
	}
	public void setUsuActu(String usuActu) {
		this.usuActu = usuActu;
	}
	public String getFecActu() {
		return fecActu;
	}
	public void setFecActu(String fecActu) {
		this.fecActu = fecActu;
	}
}
