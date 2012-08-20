package com.grupobbva.bc.per.tel.iilc.beans;

import java.io.Serializable;

public class OficinaTerritorio implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codOficina;
	private String codTerritorio;
	private String codArea;
	private String desOficina;
	private String desTerritorio;

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public String getCodTerritorio() {
		return codTerritorio;
	}

	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}

	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getDesOficina() {
		return desOficina;
	}

	public void setDesOficina(String desOficina) {
		this.desOficina = desOficina;
	}

	public String getDesTerritorio() {
		return desTerritorio;
	}

	public void setDesTerritorio(String desTerritorio) {
		this.desTerritorio = desTerritorio;
	}
}
