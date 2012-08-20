/**
 * @author: Maria Paula Tomaylla Tunque
 * codigo : P020795
 * fecha  : 26/11/2007
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;

public class Gestor implements Serializable{
	
	protected String cod_gestor;
	protected String cod_oficina;
	protected String cod_territorio;
	protected String cod_area;
	protected String nom_gestor;
	protected String reg_gestor;
	protected String perfil_gestor;
   
	public String getPerfil_gestor() {
		return perfil_gestor;
	}
	public void setPerfil_gestor(String perfil_gestor) {
		this.perfil_gestor = perfil_gestor;
	}
	public String getCod_area() {
		return cod_area;
	}
	public void setCod_area(String cod_area) {
		this.cod_area = cod_area;
	}
	public String getCod_gestor() {
		return cod_gestor;
	}
	public void setCod_gestor(String cod_gestor) {
		this.cod_gestor = cod_gestor;
	}
	public String getCod_oficina() {
		return cod_oficina;
	}
	public void setCod_oficina(String cod_oficina) {
		this.cod_oficina = cod_oficina;
	}
	public String getCod_territorio() {
		return cod_territorio;
	}
	public void setCod_territorio(String cod_territorio) {
		this.cod_territorio = cod_territorio;
	}
	public String getNom_gestor() {
		return nom_gestor;
	}
	public void setNom_gestor(String nom_gestor) {
		this.nom_gestor = nom_gestor;
	}
	public String getReg_gestor() {
		return reg_gestor;
	}
	public void setReg_gestor(String reg_gestor) {
		this.reg_gestor = reg_gestor;
	}
}
