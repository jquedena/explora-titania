/*
 * Created on 10/04/2008
 */
package com.grupobbva.bc.per.tel.iilc.serializable;
import java.io.Serializable;

/**
 * @author P060049 Edgar Zavaleta Sierralta
 */
public class Empresa implements Serializable{
	
	protected String cod_empresa;
	protected String des_empresa;
	
	public String getCod_empresa() {
		return cod_empresa;
	}
	public void setCod_empresa(String cod_empresa) {
		this.cod_empresa = cod_empresa;
	}
	public String getDes_empresa() {
		return des_empresa;
	}
	public void setDes_empresa(String des_empresa) {
		this.des_empresa = des_empresa;
	}
}
