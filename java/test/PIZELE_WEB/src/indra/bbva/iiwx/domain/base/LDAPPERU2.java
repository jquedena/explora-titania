package indra.bbva.iiwx.domain.base;

import java.io.Serializable;

public class LDAPPERU2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codofi;
	private String codusu;
	private String nombre; 
	private String apepat; 
	private String apemat;
	private String cargo;
	private String perfil;
	
	public String getCodofi() {
		return codofi;
	}
	public void setCodofi(String codofi) {
		this.codofi = codofi;
	}
	
	public String getCodusu() {
		return codusu;
	}
	public void setCodusu(String codusu) {
		this.codusu = codusu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApepat() {
		return apepat;
	}
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}
	public String getApemat() {
		return apemat;
	}
	public void setApemat(String apemat) {
		this.apemat = apemat;
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
	
	public String getNombreCompleto()
	{
		return this.getNombre() + " " + this.getApepat() + " " + this.getApemat();
	}
	
}