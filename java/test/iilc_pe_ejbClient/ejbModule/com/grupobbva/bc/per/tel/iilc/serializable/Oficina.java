/**
 * @author: Maria Paula Tomaylla Tunque
 * codigo : P020795
 * fecha  : 26/11/2007
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;

public class Oficina implements Serializable{
	
	protected String cod_oficina;
	protected String cod_territorio;
	protected String cod_area;
	protected String des_oficina;
	
	public String getCod_area() {
		return cod_area;
	}
	public void setCod_area(String cod_area) {
		this.cod_area = cod_area;
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
	public String getDes_oficina() {
		return des_oficina;
	}
	public void setDes_oficina(String des_oficina) {
		this.des_oficina = des_oficina;
	}
}
