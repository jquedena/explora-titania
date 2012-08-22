package indra.bbva.pizele.common;

import java.io.Serializable;

public class SelectItem implements Serializable
{
	
	private static final long serialVersionUID = 1241256105532159742L;
	
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
