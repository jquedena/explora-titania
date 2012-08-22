package indra.bbva.pizele.domain.base;

import java.io.Serializable;

public class Oficina implements Serializable 
{

	private static final long serialVersionUID = 8741573105532159742L;
	
	private String codigo;
	private String descripcion;
	private String codigoTerritorio;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigoTerritorio() {
		return codigoTerritorio;
	}
	public void setCodigoTerritorio(String codigoTerritorio) {
		this.codigoTerritorio = codigoTerritorio;
	}
		
}
