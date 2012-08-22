package indra.bbva.pizele.common;

import java.io.Serializable;

public class Resultado implements Serializable
{

	private static final long serialVersionUID = 1241256105532159742L;
	
	private String resultado;
	private String mensaje;
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
		
}
