/*
 * Created on 28/02/2011
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author leharz
 */
public class EstadoCarga implements Serializable {
	protected Timestamp fechaIni;
	protected Timestamp fechaFin;
	protected long estado;
	protected long archivoEncontrado;
	protected long tablasTruncadas;
	protected long filasProcesadas;
	protected long filasCLeidas;
	protected long filasCEscritas;
	protected long filasGLeidas;
	protected long filasGEscritas;
	protected long filasOLeidas;
	protected long filasOEscritas;
	protected long filasTLeidas;
	protected long filasTEscritas;
	
	public long getTablasTruncadas() {
		return tablasTruncadas;
	}
	public void setTablasTruncadas(long tablasTruncadas) {
		this.tablasTruncadas = tablasTruncadas;
	}
	public long getArchivoEncontrado() {
		return archivoEncontrado;
	}
	public void setArchivoEncontrado(long archivoEncontrado) {
		this.archivoEncontrado = archivoEncontrado;
	}
	public long getEstado() {
		return estado;
	}
	public void setEstado(long estado) {
		this.estado = estado;
	}
	public Timestamp getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Timestamp getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Timestamp fechaIni) {
		this.fechaIni = fechaIni;
	}
	public long getFilasCEscritas() {
		return filasCEscritas;
	}
	public void setFilasCEscritas(long filasCEscritas) {
		this.filasCEscritas = filasCEscritas;
	}
	public long getFilasCLeidas() {
		return filasCLeidas;
	}
	public void setFilasCLeidas(long filasCLeidas) {
		this.filasCLeidas = filasCLeidas;
	}
	public long getFilasGEscritas() {
		return filasGEscritas;
	}
	public void setFilasGEscritas(long filasGEscritas) {
		this.filasGEscritas = filasGEscritas;
	}
	public long getFilasGLeidas() {
		return filasGLeidas;
	}
	public void setFilasGLeidas(long filasGLeidas) {
		this.filasGLeidas = filasGLeidas;
	}
	public long getFilasOEscritas() {
		return filasOEscritas;
	}
	public void setFilasOEscritas(long filasOEscritas) {
		this.filasOEscritas = filasOEscritas;
	}
	public long getFilasOLeidas() {
		return filasOLeidas;
	}
	public void setFilasOLeidas(long filasOLeidas) {
		this.filasOLeidas = filasOLeidas;
	}
	public long getFilasProcesadas() {
		return filasProcesadas;
	}
	public void setFilasProcesadas(long filasProcesadas) {
		this.filasProcesadas = filasProcesadas;
	}
	public long getFilasTEscritas() {
		return filasTEscritas;
	}
	public void setFilasTEscritas(long filasTEscritas) {
		this.filasTEscritas = filasTEscritas;
	}
	public long getFilasTLeidas() {
		return filasTLeidas;
	}
	public void setFilasTLeidas(long filasTLeidas) {
		this.filasTLeidas = filasTLeidas;
	}
}
