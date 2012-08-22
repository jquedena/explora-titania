package igrupobbva.pe.sistemasdoweb.actions;

public class ValorDefecto {

	private boolean cargarPorDefecto;
	private String anho;
	private String mes;
	private String oficina;
	
	public String getAnho() {
		return anho;
	}
	public void setAnho(String anho) {
		this.anho = anho;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	public boolean isCargarPorDefecto() {
		return cargarPorDefecto;
	}
	public void setCargarPorDefecto(boolean cargarPorDefecto) {
		this.cargarPorDefecto = cargarPorDefecto;
	}
}