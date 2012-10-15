package com.grupobbva.bc.per.tel.iilc.beans;

public class Menu {
	private String etiqueta;
	private String href;
	
	public Menu(String etiqueta, String href) {
		this.etiqueta = etiqueta;
		this.href = href;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
