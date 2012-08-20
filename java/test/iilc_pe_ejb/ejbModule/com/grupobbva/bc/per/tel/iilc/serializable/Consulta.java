/*
 * Created on 24/11/2010
 */
package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;

public class Consulta implements Serializable {

	private static final long serialVersionUID = 6840981964054885764L;
	protected String codPerfil;
	protected String codGestorConsulta;
	protected String territorio;
	protected String oficina;
	protected String gestor;
	protected String nivelVinculacion;
	protected String clasificacion;
	protected String margenOrdinario;
	protected String etiqueta;
	protected String edad;
	protected String cuotaRiesgoTotal;
	protected String codEmpresa;
	protected String tipoCliente;
	protected long pagActual;
	protected long numPags;
	protected long tipoDetalle;
	
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	public String getCodGestorConsulta() {
		return codGestorConsulta;
	}
	public void setCodGestorConsulta(String codGestorConsulta) {
		this.codGestorConsulta = codGestorConsulta;
	}
	public String getCodPerfil() {
		return codPerfil;
	}
	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}
	public String getCuotaRiesgoTotal() {
		return cuotaRiesgoTotal;
	}
	public void setCuotaRiesgoTotal(String cuotaRiesgoTotal) {
		this.cuotaRiesgoTotal = cuotaRiesgoTotal;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public String getGestor() {
		return gestor;
	}
	public void setGestor(String gestor) {
		this.gestor = gestor;
	}
	public String getMargenOrdinario() {
		return margenOrdinario;
	}
	public void setMargenOrdinario(String margenOrdinario) {
		this.margenOrdinario = margenOrdinario;
	}
	public String getNivelVinculacion() {
		return nivelVinculacion;
	}
	public void setNivelVinculacion(String nivelVinculacion) {
		this.nivelVinculacion = nivelVinculacion;
	}
	public long getNumPags() {
		return numPags;
	}
	public void setNumPags(long numPags) {
		this.numPags = numPags;
	}
	public String getOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	public long getPagActual() {
		return pagActual;
	}
	public void setPagActual(long pagActual) {
		this.pagActual = pagActual;
	}
	public String getTerritorio() {
		return territorio;
	}
	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}
	public long getTipoDetalle() {
		return tipoDetalle;
	}
	public void setTipoDetalle(long tipoDetalle) {
		this.tipoDetalle = tipoDetalle;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}	
}
