/**
 * @author: Maria Paula Tomaylla Tunque
 * codigo : P020795
 * fecha  : 26/11/2007
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;

public class Area implements Serializable{
	
	private String cod_area;
	private String des_area;
   
	public String getCod_area() {
		return cod_area;
	}
	public void setCod_area(String cod_area) {
		this.cod_area = cod_area;
	}
	public String getDes_area() {
		return des_area;
	}
	public void setDes_area(String des_area) {
		this.des_area = des_area;
	}
}
