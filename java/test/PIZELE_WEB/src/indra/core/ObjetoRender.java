package indra.core;

public class ObjetoRender 
{

	private String contenido;

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return this.getContenido();
	}
		
}
