/*
 * Created on 23/11/2010
 */
package com.grupobbva.bc.per.tel.iilc.serializable.json;

import java.io.Serializable;

import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

/**
 * @author leharz
 */
public class Respuesta implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String datosDetalleFiltros[][];
	protected long pagActual;
	protected long numPags;
	protected long numRegistros;
	protected long tipoDetalle;
	protected Multitabla cabeceras[];
	protected String datos[][];
	protected String mensaje;
	protected String codigoOficina;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public long getTipoDetalle() {
		return tipoDetalle;
	}
	public void setTipoDetalle(long tipoDetalle) {
		this.tipoDetalle = tipoDetalle;
	}
	public Multitabla[] getCabeceras() {
		return cabeceras;
	}
	public void setCabeceras(Multitabla[] cabeceras) {
		this.cabeceras = cabeceras;
	}
	public String[][] getDatos() {
		return datos;
	}
	public void setDatos(String[][] datos) {
		this.datos = datos;
	}
	public String[][] getDatosDetalleFiltros() {
		return datosDetalleFiltros;
	}
	public void setDatosDetalleFiltros(String[][] datosDetalleFiltros) {
		this.datosDetalleFiltros = datosDetalleFiltros;
	}
	public long getNumPags() {
		return numPags;
	}
	public void setNumPags(long numPags) {
		this.numPags = numPags;
	}
	public long getPagActual() {
		return pagActual;
	}
	public void setPagActual(long pagActual) {
		this.pagActual = pagActual;
	}
	public String getCodigoOficina() {
		return codigoOficina;
	}
	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}
	public long getNumRegistros() {
		return numRegistros;
	}
	public void setNumRegistros(long numRegistros) {
		this.numRegistros = numRegistros;
	}
}
