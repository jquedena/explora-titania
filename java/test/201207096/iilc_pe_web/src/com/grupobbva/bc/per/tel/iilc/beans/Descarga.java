package com.grupobbva.bc.per.tel.iilc.beans;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Descarga {

	private static SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
	private int id;
	private Timestamp fecha;
	private String registro;
	private String archivo;
	private String descripcion;
	private int estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String getHora() {
		return formatter.format(this.fecha);
	}
}
