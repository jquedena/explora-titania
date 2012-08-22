package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.sql.Date;

public class Equivalencia implements Serializable{

	private static final long serialVersionUID = 8867984931805237664L;
	private String codCargo;
	private String codPerfil;
	private String usuRegistro;
	private String usuActualizo;
	private Date fecRegistro;
	private Date fecActualizo;
	private String perfil;
	
	public String getCodCargo() {
		return codCargo;
	}
	
	public void setCodCargo(String codCargo) {
		this.codCargo = codCargo;
	}
	
	public String getCodPerfil() {
		return codPerfil;
	}
	
	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}
	
	public Date getFecActualizo() {
		return fecActualizo;
	}
	
	public void setFecActualizo(Date fecActualizo) {
		this.fecActualizo = fecActualizo;
	}
	
	public Date getFecRegistro() {
		return fecRegistro;
	}
	
	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}
	
	public String getUsuActualizo() {
		return usuActualizo;
	}
	
	public void setUsuActualizo(String usuActualizo) {
		this.usuActualizo = usuActualizo;
	}
	
	public String getUsuRegistro() {
		return usuRegistro;
	}
	
	public void setUsuRegistro(String usuRegistro) {
		this.usuRegistro = usuRegistro;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}	
}
