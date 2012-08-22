package indra.bbva.pizele.domain.extend;

import indra.bbva.pizele.domain.base.InformeUso;

import java.io.Serializable;

public class InformeUsoDetalle extends InformeUso implements Serializable{
	
	private static final long serialVersionUID = 8751245105532159742L;

	private String nombreTerr;
	private String nombreOficina;


	public String getNombreTerr() {
		return nombreTerr;
	}
	public void setNombreTerr(String nombreTerr) {
		this.nombreTerr = nombreTerr;
	}
	public String getNombreOficina() {
		return nombreOficina;
	}
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}
	
}
