package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

public class InformeParametro implements Serializable
{

	private static final long serialVersionUID = 8751245105532159741L;
	
	private String  codigoTerritorio;
	private String descTerritorio;
	private String codigoOficina;
	private String descOficina;
	private String codigoGestor;
	private String nombreGestor;
	private Long idAnio;
	private Long idMes;
	private String descMes;
	
	public String getCodigoTerritorio() {
		return codigoTerritorio;
	}
	public void setCodigoTerritorio(String codigoTerritorio) {
		this.codigoTerritorio = codigoTerritorio;
	}
	public String getDescTerritorio() {
		return descTerritorio;
	}
	public void setDescTerritorio(String descTerritorio) {
		this.descTerritorio = descTerritorio;
	}
	public String getCodigoOficina() {
		return codigoOficina;
	}
	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}
	public String getDescOficina() {
		return descOficina;
	}
	public void setDescOficina(String descOficina) {
		this.descOficina = descOficina;
	}
	public String getCodigoGestor() {
		return codigoGestor;
	}
	public void setCodigoGestor(String codigoGestor) {
		this.codigoGestor = codigoGestor;
	}
	public String getNombreGestor() {
		return nombreGestor;
	}
	public void setNombreGestor(String nombreGestor) {
		this.nombreGestor = nombreGestor;
	}
	public Long getIdAnio() {
		return idAnio;
	}
	public void setIdAnio(Long idAnio) {
		this.idAnio = idAnio;
	}
	public Long getIdMes() {
		return idMes;
	}
	public void setIdMes(Long idMes) {
		this.idMes = idMes;
	}
	public String getDescMes() {
		return descMes;
	}
	public void setDescMes(String descMes) {
		this.descMes = descMes;
	}
	
	
	
	
}
