package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

public class ExportacionTabla implements Serializable {
	private String id;
	private String descripcion;
	
	public ExportacionTabla() {
		
	}
	
	
	/**
	 * @return Returns the descripcion.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion The descripcion to set.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}
}
