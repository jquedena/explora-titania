package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class AdministracionCargaVinculacion implements Serializable {

	private long id_registro;
	private int tipo;
	private Date fecha_inicio;
	private String fecha_inicio_casteada;
	private int id_estado;
	private Date fecha_fin;
	private String fecha_fin_casteada;
	private int archivo_carga;
	private long filas_leidas=0L;
	private long filas_procesadas=0L;
	private long filas_no_procesadas=0L;
	private int procesando;
	private String usureg;
	private Date fecreg;
	private String usumod;
	private Date fecmod;
	private String fecha;
	private String estadoDescripcion; 
	private String archivo_cargaDescripcion;
	private String fechaInicioReal;
	
	public String getFecha_inicio_casteada() {
		return fecha_inicio_casteada;
	}
	public void setFecha_inicio_casteada(String fecha_inicio_casteada) {
		this.fecha_inicio_casteada = fecha_inicio_casteada;
	}
	public String getFecha_fin_casteada() {
		return fecha_fin_casteada;
	}
	public void setFecha_fin_casteada(String fecha_fin_casteada) {
		this.fecha_fin_casteada = fecha_fin_casteada;
	}
	public long getId_registro() {
		return id_registro;
	}
	public void setId_registro(long id_registro) {
		this.id_registro = id_registro;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public int getId_estado() {
		return id_estado;
	}
	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getArchivo_carga() {
		return archivo_carga;
	}
	public void setArchivo_carga(int archivo_carga) {
		this.archivo_carga = archivo_carga;
	}
	public long getFilas_leidas() {
		return filas_leidas;
	}
	public void setFilas_leidas(long filas_leidas) {
		this.filas_leidas = filas_leidas;
	}
	public long getFilas_procesadas() {
		return filas_procesadas;
	}
	public void setFilas_procesadas(long filas_procesadas) {
		this.filas_procesadas = filas_procesadas;
	}
	public long getFilas_no_procesadas() {
		return filas_no_procesadas;
	}
	public void setFilas_no_procesadas(long filas_no_procesadas) {
		this.filas_no_procesadas = filas_no_procesadas;
	}
	public int getProcesando() {
		return procesando;
	}
	public void setProcesando(int procesando) {
		this.procesando = procesando;
	}
	public String getUsureg() {
		return usureg;
	}
	public void setUsureg(String usureg) {
		this.usureg = usureg;
	}
	public Date getFecreg() {
		return fecreg;
	}
	public void setFecreg(Date fecreg) {
		this.fecreg = fecreg;
	}
	public String getUsumod() {
		return usumod;
	}
	public void setUsumod(String usumod) {
		this.usumod = usumod;
	}
	public Date getFecmod() {
		return fecmod;
	}
	public void setFecmod(Date fecmod) {
		this.fecmod = fecmod;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstadoDescripcion() {
		return estadoDescripcion;
	}
	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}
	public String getArchivo_cargaDescripcion() {
		return archivo_cargaDescripcion;
	}
	public void setArchivo_cargaDescripcion(String archivo_cargaDescripcion) {
		this.archivo_cargaDescripcion = archivo_cargaDescripcion;
	}
	public String getFechaInicioReal() {
		return fechaInicioReal;
	}
	public void setFechaInicioReal(String fechaInicioReal) {
		this.fechaInicioReal = fechaInicioReal;
	}

}
