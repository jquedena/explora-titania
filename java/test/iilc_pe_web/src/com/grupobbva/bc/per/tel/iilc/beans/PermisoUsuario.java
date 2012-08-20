package com.grupobbva.bc.per.tel.iilc.beans;

import java.io.Serializable;
import java.sql.Date;

public class PermisoUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idUsuario;
	private String codUsuario;
	private String codOficina;
	private String codArea;
	private String codTerritorio;
	private String usuReg;
	private String checked;
	private Date fecReg;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getCodTerritorio() {
		return codTerritorio;
	}

	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}

	public String getUsuReg() {
		return usuReg;
	}

	public void setUsuReg(String usuReg) {
		this.usuReg = usuReg;
	}
	
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Date getFecReg() {
		return fecReg;
	}

	public void setFecReg(Date fecReg) {
		this.fecReg = fecReg;
	}

}
