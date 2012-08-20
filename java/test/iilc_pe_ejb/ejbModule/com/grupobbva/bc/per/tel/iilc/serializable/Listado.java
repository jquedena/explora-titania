/**
 * @author: Maria Paula Tomaylla
 * codigo : P020795
 * fecha  : 29/11/2007
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;
import java.util.Collection;

public class Listado implements Serializable{

	protected Collection listadoConduccion;
	
	public Collection getListadoConduccion() {
		return listadoConduccion;
	}
	public void setListadoConduccion(Collection listadoConduccion) {
		this.listadoConduccion = listadoConduccion;
	}
}
