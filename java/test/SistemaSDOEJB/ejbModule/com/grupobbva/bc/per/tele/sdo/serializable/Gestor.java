package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class Gestor implements Serializable{

	private String codigoGestor;
	private String passwordGestor;
	private String nombreGestor;
	private String codigoPerfil;
	private String perfilMostrar;
	private String codigoOficina;
	private String codigoTerritorio;
	private String estadoGestor;
	private String nombreOficina;	
	private MetasGestor metaGestor;
	private BigDecimal porcAsignado;
	private BigDecimal promedio6m;
	private int totalGestores;
	private int SumtotalGestores;
	private int SumtotalIngresos;
	private int SumtotalPendientes;
	private String nombreTerritorio;
	private Object ingresos;
	private int pendientes;
	private int totalIngresos;
	private int totalpendientes;
	private String perfilGrupo;

	public Gestor () {
		codigoGestor     = "";
		passwordGestor   = "";
		nombreGestor     = "";
		codigoPerfil     = "";
		codigoOficina    = "";
		codigoTerritorio = "";
		estadoGestor     = "";
		nombreOficina    = "";
	}
	
	public String getPerfilMostrar() {
		return perfilMostrar;
	}
	public void setPerfilMostrar(String perfilMostrar) {
		this.perfilMostrar = perfilMostrar;
	}
	
	public BigDecimal getPromedio6m() {
		return promedio6m;
	}
	public void setPromedio6m(BigDecimal promedio6m) {
		this.promedio6m = promedio6m;
	}

	public int getSumtotalIngresos() {
		return SumtotalIngresos;
	}

	public void setSumtotalIngresos(int sumtotalIngresos) {
		SumtotalIngresos = sumtotalIngresos;
	}

	public int getSumtotalPendientes() {
		return SumtotalPendientes;
	}

	public void setSumtotalPendientes(int sumtotalPendientes) {
		SumtotalPendientes = sumtotalPendientes;
	}

	public Object getIngresos() {
		return ingresos;
	}

	public void setIngresos(Object ingresos) {
		this.ingresos = ingresos;
	}

	public String getNombreTerritorio() {
		return nombreTerritorio;
	}

	public void setNombreTerritorio(String nombreTerritorio) {
		this.nombreTerritorio = nombreTerritorio;
	}

	public int getPendientes() {
		return pendientes;
	}

	public void setPendientes(int pendientes) {
		this.pendientes = pendientes;
	}

	public int getSumtotalGestores() {
		return SumtotalGestores;
	}

	public void setSumtotalGestores(int sumtotalGestores) {
		SumtotalGestores = sumtotalGestores;
	}

	public int getTotalGestores() {
		return totalGestores;
	}

	public void setTotalGestores(int totalGestores) {
		this.totalGestores = totalGestores;
	}

	public int getTotalIngresos() {
		return totalIngresos;
	}

	public void setTotalIngresos(int totalIngresos) {
		this.totalIngresos = totalIngresos;
	}

	public int getTotalpendientes() {
		return totalpendientes;
	}

	public void setTotalpendientes(int totalpendientes) {
		this.totalpendientes = totalpendientes;
	}

	public BigDecimal getPorcAsignado() {
		return porcAsignado;
	}

	public void setPorcAsignado(BigDecimal porcAsignado) {
		this.porcAsignado = porcAsignado;
	}

	public MetasGestor getMetaGestor() {
		return metaGestor;
	}

	public void setMetaGestor(MetasGestor metaGestor) {
		this.metaGestor = metaGestor;
	}

	public String getCodigoGestor() {
		return codigoGestor;
	}

	public void setCodigoGestor(String codigoGestor) {
		this.codigoGestor = codigoGestor;
	}

	public String getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	public String getCodigoTerritorio() {
		return codigoTerritorio;
	}

	public void setCodigoTerritorio(String codigoTerritorio) {
		this.codigoTerritorio = codigoTerritorio;
	}

	public String getEstadoGestor() {
		return estadoGestor;
	}

	public void setEstadoGestor(String estadoGestor) {
		this.estadoGestor = estadoGestor;
	}
	
	public String getNombreGestor() {
		return nombreGestor;
	}
	
	public void setNombreGestor(String nombreGestor) {
		this.nombreGestor = nombreGestor;
	}
	
	public String getNombreOficina() {
		return nombreOficina;
	}
	
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}
	
	public String getPasswordGestor() {
		return passwordGestor;
	}
	
	public void setPasswordGestor(String passwordGestor) {
		this.passwordGestor = passwordGestor;
	}
	
	public String getPerfilGrupo() {
		return perfilGrupo;
	}

	public void setPerfilGrupo(String perfilGrupo) {
		this.perfilGrupo = perfilGrupo;
	}

}