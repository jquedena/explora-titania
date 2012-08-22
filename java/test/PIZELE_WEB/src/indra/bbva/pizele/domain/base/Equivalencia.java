package indra.bbva.pizele.domain.base;

import java.io.Serializable;

public class Equivalencia implements Serializable 
{

	private static final long serialVersionUID = 8751245105532159742L;
	
	private String codigoCargo;
	private String codigoPerfil;
	
	public String getCodigoCargo() {
		return codigoCargo;
	}
	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	public String getCodigoPerfil() {
		return codigoPerfil;
	}
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	
}
