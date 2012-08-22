package indra.bbva.pizele.domain.base;

import java.io.Serializable;

public class Gestor implements Serializable {

	private static final long serialVersionUID = 8751245105532159742L;

	private String codigoRegistro;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String cargo;
	private String perfil;
	private String oficinaHija;

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

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

	public String getNombreCompleto() {
		return this.getNombre() + " " + this.getApellidoPaterno() + " " + this.getApellidoMaterno() + " " + this.getOficinaHija();
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getOficinaHija() {
		return oficinaHija;
	}

	public void setOficinaHija(String oficinaHija) {
		this.oficinaHija = oficinaHija;
	}

}
