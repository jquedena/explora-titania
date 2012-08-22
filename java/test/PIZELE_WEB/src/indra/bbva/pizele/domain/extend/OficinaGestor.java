package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

public class OficinaGestor implements Serializable 
{
	
	private static final long serialVersionUID = 1356245105532159742L;
	
	private String codigo;
	private String descripcion;
	
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
	
}
