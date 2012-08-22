/*
 * Created on 24/01/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings({ "unchecked", "serial" })
public class ReporteIngreso implements Serializable{
	private String codUsuario;
	private String nombres;
	private String cargo;
	private String nomTerritorio;
	private String codOficina;
	private String codTerritorio;
	private String descOficina;
	private String etiquetaFechas;
	private ArrayList listaDatos;
	private String total;
	private int formato;
	
	public ReporteIngreso()  {
		
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getDescOficina() {
		return descOficina;
	}

	public void setDescOficina(String descOficina) {
		this.descOficina = descOficina;
	}

	public String getEtiquetaFechas() {
		return etiquetaFechas;
	}

	public void setEtiquetaFechas(String etiquetaFechas) {
		this.etiquetaFechas = etiquetaFechas;
	}

	public ArrayList getListaDatos() {
		return listaDatos;
	}

	public void setListaDatos(ArrayList listaDatos) {
		this.listaDatos = listaDatos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNomTerritorio() {
		return nomTerritorio;
	}

	public void setNomTerritorio(String nomTerritorio) {
		this.nomTerritorio = nomTerritorio;
	}

	public int getFormato() {
		return formato;
	}

	public void setFormato(int formato) {
		this.formato = formato;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCodTerritorio() {
		return codTerritorio;
	}

	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}
	
	
}
