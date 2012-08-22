package indra.bbva.pizele.domain.extend;

import java.io.Serializable;

import indra.bbva.pizele.domain.base.Backup;

public class BackupDetalle extends Backup implements Serializable 
{

	private static final long serialVersionUID = 8751245105532159742L;
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public String getNombreCompleto()
	{
		return this.getNombre() + " " + this.getApellidoPaterno() + " " + this.getApellidoMaterno();
	}
	
}
