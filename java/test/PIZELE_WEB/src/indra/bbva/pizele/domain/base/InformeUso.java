package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;


import java.io.Serializable;
import java.util.List;

public class InformeUso extends GenericBean implements Serializable{
	
	private static final long serialVersionUID = 8751245105532159742L;

	private String  cod_gestor;
	private String  codterr;
	private String nombreTerritorio;
	private String  codigoOficina; 
	private String nombreOficina;
	private String  codigoGestorGerente;
	private String  nombreGestorGerente;
	private String  apellidoPaterGestorGerente;
	private String  apellidoMaterGestorGerente;
	private String  fechaDesde;
	private String  fechaHasta;
	private Gerente beanGerente;
	private String total;
	private String porcentanje;	
	private int porcentajeMeta;
	private int porcentajeLogro;


	public Gerente getBeanGerente() {
		return beanGerente;
	}
	public void setBeanGerente(Gerente beanGerente) {
		this.beanGerente = beanGerente;
	}
	public String getCod_gestor() {
		return cod_gestor;
	}
	public void setCod_gestor(String cod_gestor) {
		this.cod_gestor = cod_gestor;
	}

	public String getCodterr() {
		return codterr;
	}
	public void setCodterr(String codterr) {
		this.codterr = codterr;
	}
	public String getCodigoOficina() {
		return codigoOficina;
	}
	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public String getCodigoGestorGerente() {
		return codigoGestorGerente;
	}
	public void setCodigoGestorGerente(String codigoGestorGerente) {
		this.codigoGestorGerente = codigoGestorGerente;
	}
	public String getNombreGestorGerente() {
		return nombreGestorGerente;
	}
	public void setNombreGestorGerente(String nombreGestorGerente) {
		this.nombreGestorGerente = nombreGestorGerente;
	}
	public String getApellidoPaterGestorGerente() {
		return apellidoPaterGestorGerente;
	}
	public void setApellidoPaterGestorGerente(String apellidoPaterGestorGerente) {
		this.apellidoPaterGestorGerente = apellidoPaterGestorGerente;
	}
	public String getApellidoMaterGestorGerente() {
		return apellidoMaterGestorGerente;
	}
	public void setApellidoMaterGestorGerente(String apellidoMaterGestorGerente) {
		this.apellidoMaterGestorGerente = apellidoMaterGestorGerente;
	}

	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getPorcentanje() {
		return porcentanje;
	}
	public void setPorcentanje(String porcentanje) {
		this.porcentanje = porcentanje;
	}
	public int getConsecucion() {
		return (this.getPorcentajeMeta() + this.getPorcentajeLogro())*2;
	}
	public String getNombreTerritorio() {
		return nombreTerritorio;
	}
	public void setNombreTerritorio(String nombreTerritorio) {
		this.nombreTerritorio = nombreTerritorio;
	}
	public String getNombreOficina() {
		return nombreOficina;
	}
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}
	public int getPorcentajeMeta() {
		return porcentajeMeta;
	}
	public void setPorcentajeMeta(int porcentajeMeta) {
		this.porcentajeMeta = porcentajeMeta;
	}
	public int getPorcentajeLogro() {
		return porcentajeLogro;
	}
	public void setPorcentajeLogro(int porcentajeLogro) {
		this.porcentajeLogro = porcentajeLogro;
	}
	
}
