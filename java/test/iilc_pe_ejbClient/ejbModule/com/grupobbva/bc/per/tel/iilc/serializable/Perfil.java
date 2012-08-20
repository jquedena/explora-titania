/*
 * @author: Edgar Ivan Zavaleta Sierralta
 * codigo : Administrador
 * fecha  : 30/11/2007
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;

/**
 * @author: Edgar Ivan Zavaleta Sierralta
 * codigo : Administrador
 * fecha  : 30/11/2007
 */
public class Perfil implements Serializable{

	protected String cod_perfil;
	
	protected String des_perfil;
	
	protected String componente;
	
	public String getCod_perfil() {
		return cod_perfil;
	}
	public void setCod_perfil(String cod_perfil) {
		this.cod_perfil = cod_perfil;
	}
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	public String getDes_perfil() {
		return des_perfil;
	}
	public void setDes_perfil(String des_perfil) {
		this.des_perfil = des_perfil;
	}
}
