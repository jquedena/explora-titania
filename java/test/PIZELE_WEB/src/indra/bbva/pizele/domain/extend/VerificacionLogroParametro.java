package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

public class VerificacionLogroParametro implements Serializable
{

	private static final long serialVersionUID = 8751245105532159742L;
	
	private String  codigoTerritorio;
	private String descTerritorio;
	private String codigoOficina;
	private String descOficina;
	private String codigoGestor;
	private String nombreGestor;
	private String  fechaDesde;
	private String  fechaHasta;
	
	public String getCodigoTerritorio() {
		return codigoTerritorio;
	}
	public void setCodigoTerritorio(String codigoTerritorio) {
		this.codigoTerritorio = codigoTerritorio;
	}
	public String getCodigoOficina() {
		return codigoOficina;
	}
	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}
	public String getCodigoGestor() {
		return codigoGestor;
	}
	public void setCodigoGestor(String codigoGestor) {
		this.codigoGestor = codigoGestor;
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
	public String getDescTerritorio() {
		return descTerritorio;
	}
	public void setDescTerritorio(String descTerritorio) {
		this.descTerritorio = descTerritorio;
	}
	public String getDescOficina() {
		return descOficina;
	}
	public void setDescOficina(String descOficina) {
		this.descOficina = descOficina;
	}
	public String getNombreGestor() {
		return nombreGestor;
	}
	public void setNombreGestor(String nombreGestor) {
		this.nombreGestor = nombreGestor;
	}
	
}
