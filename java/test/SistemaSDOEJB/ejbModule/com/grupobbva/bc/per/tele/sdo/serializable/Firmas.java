/*
 * Created on 24/02/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Firmas implements Serializable{

	private String codFirma;
	private Oficina Oficina;
	private String anhoFirma;
	private String mesFirma;
	private String itemFirma;
	private String codGestor;
	private String descripcion;
	private Date fecFirma;
	/**
	 * @return Returns the anhoFirma.
	 */
	public String getAnhoFirma() {
		return anhoFirma;
	}
	/**
	 * @param anhoFirma The anhoFirma to set.
	 */
	public void setAnhoFirma(String anhoFirma) {
		this.anhoFirma = anhoFirma;
	}
	/**
	 * @return Returns the codFirma.
	 */
	public String getCodFirma() {
		return codFirma;
	}
	/**
	 * @param codFirma The codFirma to set.
	 */
	public void setCodFirma(String codFirma) {
		this.codFirma = codFirma;
	}
	/**
	 * @return Returns the codGestor.
	 */
	public String getCodGestor() {
		return codGestor;
	}
	/**
	 * @param codGestor The codGestor to set.
	 */
	public void setCodGestor(String codGestor) {
		this.codGestor = codGestor;
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
	 * @return Returns the fecFirma.
	 */
	public Date getFecFirma() {
		return fecFirma;
	}
	/**
	 * @param fecFirma The fecFirma to set.
	 */
	public void setFecFirma(Date fecFirma) {
		this.fecFirma = fecFirma;
	}
	/**
	 * @return Returns the itemFirma.
	 */
	public String getItemFirma() {
		return itemFirma;
	}
	/**
	 * @param itemFirma The itemFirma to set.
	 */
	public void setItemFirma(String itemFirma) {
		this.itemFirma = itemFirma;
	}
	/**
	 * @return Returns the mesFirma.
	 */
	public String getMesFirma() {
		return mesFirma;
	}
	/**
	 * @param mesFirma The mesFirma to set.
	 */
	public void setMesFirma(String mesFirma) {
		this.mesFirma = mesFirma;
	}
	/**
	 * @return Returns the oficina.
	 */
	public Oficina getOficina() {
		return Oficina;
	}
	/**
	 * @param oficina The oficina to set.
	 */
	public void setOficina(Oficina oficina) {
		Oficina = oficina;
	}
}
