/**
 * @author: Maria Paula Tomaylla Tunque
 * codigo : P020795
 * fecha  : 26/11/2007
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;

public class Multitabla implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String cod_mult;
	protected String cod_ele;
	
	protected String valor1;
	protected String valor2;
	protected String valor3;
	protected String valor4;
	
	public String getCod_ele() {
		return cod_ele;
	}
	public void setCod_ele(String cod_ele) {
		this.cod_ele = cod_ele;
	}
	public String getCod_mult() {
		return cod_mult;
	}
	public void setCod_mult(String cod_mult) {
		this.cod_mult = cod_mult;
	}
	public String getValor1() {
		return valor1;
	}
	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}
	public String getValor2() {
		return valor2;
	}
	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}
	public String getValor3() {
		return valor3;
	}
	public void setValor3(String valor3) {
		this.valor3 = valor3;
	}
	public String getValor4() {
		return valor4;
	}
	public void setValor4(String valor4) {
		this.valor4 = valor4;
	}
}
