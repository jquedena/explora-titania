/*
 * Created on 15-ene-2010
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

/**
 * @author ocortez
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TEpigrafes implements Serializable {
	
	String codigoepigrafe;
	String nombreepigrafe;
	String anho;
	String indicadorclase;
	String indicadorsubclase;
	String orden;
	String indicadorgrupo;
	String abreviatura;
	String indicadorhijo;
	String indicadorafecta;

	/**
	 * @return Returns the abreviatura.
	 */
	public String getAbreviatura() {
		return abreviatura;
	}
	/**
	 * @param abreviatura The abreviatura to set.
	 */
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	/**
	 * @return Returns the anho.
	 */
	public String getAnho() {
		return anho;
	}
	/**
	 * @param anho The anho to set.
	 */
	public void setAnho(String anho) {
		this.anho = anho;
	}
	/**
	 * @return Returns the codigoepigrafe.
	 */
	public String getCodigoepigrafe() {
		return codigoepigrafe;
	}
	/**
	 * @param codigoepigrafe The codigoepigrafe to set.
	 */
	public void setCodigoepigrafe(String codigoepigrafe) {
		this.codigoepigrafe = codigoepigrafe;
	}
	/**
	 * @return Returns the indicadorafecta.
	 */
	public String getIndicadorafecta() {
		return indicadorafecta;
	}
	/**
	 * @param indicadorafecta The indicadorafecta to set.
	 */
	public void setIndicadorafecta(String indicadorafecta) {
		this.indicadorafecta = indicadorafecta;
	}
	/**
	 * @return Returns the indicadorclase.
	 */
	public String getIndicadorclase() {
		return indicadorclase;
	}
	/**
	 * @param indicadorclase The indicadorclase to set.
	 */
	public void setIndicadorclase(String indicadorclase) {
		this.indicadorclase = indicadorclase;
	}
	/**
	 * @return Returns the indicadorgrupo.
	 */
	public String getIndicadorgrupo() {
		return indicadorgrupo;
	}
	/**
	 * @param indicadorgrupo The indicadorgrupo to set.
	 */
	public void setIndicadorgrupo(String indicadorgrupo) {
		this.indicadorgrupo = indicadorgrupo;
	}
	/**
	 * @return Returns the indicadorhijo.
	 */
	public String getIndicadorhijo() {
		return indicadorhijo;
	}
	/**
	 * @param indicadorhijo The indicadorhijo to set.
	 */
	public void setIndicadorhijo(String indicadorhijo) {
		this.indicadorhijo = indicadorhijo;
	}
	/**
	 * @return Returns the indicadorsubclase.
	 */
	public String getIndicadorsubclase() {
		return indicadorsubclase;
	}
	/**
	 * @param indicadorsubclase The indicadorsubclase to set.
	 */
	public void setIndicadorsubclase(String indicadorsubclase) {
		this.indicadorsubclase = indicadorsubclase;
	}
	/**
	 * @return Returns the nombreepigrafe.
	 */
	public String getNombreepigrafe() {
		return nombreepigrafe;
	}
	/**
	 * @param nombreepigrafe The nombreepigrafe to set.
	 */
	public void setNombreepigrafe(String nombreepigrafe) {
		this.nombreepigrafe = nombreepigrafe;
	}
	/**
	 * @return Returns the orden.
	 */
	public String getOrden() {
		return orden;
	}
	/**
	 * @param orden The orden to set.
	 */
	public void setOrden(String orden) {
		this.orden = orden;
	}
}
