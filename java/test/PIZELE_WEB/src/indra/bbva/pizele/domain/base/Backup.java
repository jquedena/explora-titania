package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;

import java.io.Serializable;

public class Backup extends GenericBean implements Serializable 
{

	private static final long serialVersionUID = 8751245105532159742L;
	
	private String codigoGOF;
	private String codigoGestorSuplente;
	private String nombreGestorSuplente;
	private String apellidoPatergestorSuplente;
	private String apellidoMaternogestorSuplente;
	private String fechaVigente;
	
	
	public String getCodigoGOF() {
		return codigoGOF;
	}
	public void setCodigoGOF(String codigoGOF) {
		this.codigoGOF = codigoGOF;
	}
	public String getCodigoGestorSuplente() {
		return codigoGestorSuplente;
	}
	public void setCodigoGestorSuplente(String codigoGestorSuplente) {
		this.codigoGestorSuplente = codigoGestorSuplente;
	}
	public String getFechaVigente() {
		return fechaVigente;
	}
	public void setFechaVigente(String fechaVigente) {
		this.fechaVigente = fechaVigente;
	}
	public String getNombreGestorSuplente() {
		return nombreGestorSuplente;
	}
	public void setNombreGestorSuplente(String nombreGestorSuplente) {
		this.nombreGestorSuplente = nombreGestorSuplente;
	}
	public String getApellidoPatergestorSuplente() {
		return apellidoPatergestorSuplente;
	}
	public void setApellidoPatergestorSuplente(String apellidoPatergestorSuplente) {
		this.apellidoPatergestorSuplente = apellidoPatergestorSuplente;
	}
	public String getApellidoMaternogestorSuplente() {
		return apellidoMaternogestorSuplente;
	}
	public void setApellidoMaternogestorSuplente(
			String apellidoMaternogestorSuplente) {
		this.apellidoMaternogestorSuplente = apellidoMaternogestorSuplente;
	}
	
	
	
}
