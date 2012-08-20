package com.grupobbva.bc.per.tel.iilc.beans;

import java.io.Serializable;
import java.util.Date;

public class Tiilc_adm_carga_archivo implements Serializable  {

	private static final long serialVersionUID = 2425704446487728763L;
	private long id_registro;
	private int tipo;
	private Date fecha_inicio;
	private int id_estado;
	private Date fecha_fin;
	private int archivo_carga;
	private long filas_leidas;
	private long filas_procesadas;
	private long filas_no_procesadas;
	private Integer procesando;
	private String usureg;
	private Date fecreg;
	private String usumod;
	private Date fecmod;
	private Date fecha_inicio_real;
	
	private String fecha_inicio_str;
	private String fecha_fin_str;
	private String fecha_formateada;
	private String estado_descripcion;
	private String fecha_inicio_real_str;
	
	
	
	public String getEstado_descripcion() {
		return estado_descripcion;
	}
	public void setEstado_descripcion(String estado_descripcion) {
		this.estado_descripcion = estado_descripcion;
	}
	public String getFecha_inicio_real_str() {
		return fecha_inicio_real_str;
	}
	public void setFecha_inicio_real_str(String fecha_inicio_real_str) {
		this.fecha_inicio_real_str = fecha_inicio_real_str;
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
	public Integer getProcesando() {
		return procesando;
	}
	public void setProcesando(Integer procesando) {
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
	public Date getFecha_inicio_real() {
		return fecha_inicio_real;
	}
	public void setFecha_inicio_real(Date fecha_inicio_real) {
		this.fecha_inicio_real = fecha_inicio_real;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getFecha_inicio_str() {
		return fecha_inicio_str;
	}
	public void setFecha_inicio_str(String fecha_inicio_str) {
		this.fecha_inicio_str = fecha_inicio_str;
	}
	public String getFecha_fin_str() {
		return fecha_fin_str;
	}
	public void setFecha_fin_str(String fecha_fin_str) {
		this.fecha_fin_str = fecha_fin_str;
	}
	public String getFecha_formateada() {
		return fecha_formateada;
	}
	public void setFecha_formateada(String fecha_formateada) {
		this.fecha_formateada = fecha_formateada;
	}
 
	
	
	
}
