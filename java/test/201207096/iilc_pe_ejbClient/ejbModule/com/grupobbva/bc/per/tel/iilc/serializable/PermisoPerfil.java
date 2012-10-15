/*
 * @author: Edgar Ivan Zavaleta Sierralta
 * codigo : Administrador
 * fecha  : 30/11/2007
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Edgar Ivan Zavaleta Sierralta
 * codigo : Administrador
 * fecha  : 30/11/2007
 */
public class PermisoPerfil implements Serializable{

	protected String cod_perfil;
	
	protected BigDecimal tipo_acceso;
	
	protected String valor_rcp;
	
	protected Perfil perfil;
	
	public String getCod_perfil() {
		return cod_perfil;
	}
	public void setCod_perfil(String cod_perfil) {
		this.cod_perfil = cod_perfil;
	}
	public BigDecimal getTipo_acceso() {
		return tipo_acceso;
	}
	public void setTipo_acceso(BigDecimal tipo_acceso) {
		this.tipo_acceso = tipo_acceso;
	}
	public String getValor_rcp() {
		return valor_rcp;
	}
	public void setValor_rcp(String valor_rcp) {
		this.valor_rcp = valor_rcp;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
