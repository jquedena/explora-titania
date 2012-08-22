/*
 * Created on 23/01/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.forms;

import java.util.List;
import java.util.Vector;

import org.apache.struts.action.ActionForm;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PlaneacionForm extends ActionForm{

	private String codOficina;
	private String oficina;
	private String codNomOficina;
	private String preReferencia;
	private String mesPlanificacion;
	private String anho;
	private String mesAnterMostrar;
	private String indMostrar;
	private List LisAjusPpto;
	private List listaEpigrafe;
	private org.apache.struts.upload.FormFile fileInput = null;
	private String codTerritorio;
	private List listaPlanes;
	private List listaterritorio;
	private List listaOficina;
	private List listaAnhos;
	private List listaPresup;
	

	/**
	 * @return Returns the fileInput.
	 */
	public org.apache.struts.upload.FormFile getFileInput() {
		return fileInput;
	}
	
	/**
	 * @param fileInput The fileInput to set.
	 */
	public void setFileInput(org.apache.struts.upload.FormFile fileInput) {
		this.fileInput = fileInput;
	}
	
	/**
	 * @return Returns the listaEpigrafe.
	 */
	public List getListaEpigrafe() {
		return listaEpigrafe;
	}
	/**
	 * @param listaEpigrafe The listaEpigrafe to set.
	 */
	public void setListaEpigrafe(List listaEpigrafe) {
		this.listaEpigrafe = listaEpigrafe;
	}
	/**
	 * @return Returns the lisAjusPpto.
	 */
	public List getLisAjusPpto() {
		return LisAjusPpto;
	}
	/**
	 * @param lisAjusPpto The lisAjusPpto to set.
	 */
	public void setLisAjusPpto(List lisAjusPpto) {
		LisAjusPpto = lisAjusPpto;
	}
	/**
	 * @return Returns the indMostrar.
	 */
	public String getIndMostrar() {
		return indMostrar;
	}
	/**
	 * @param indMostrar The indMostrar to set.
	 */
	public void setIndMostrar(String indMostrar) {
		this.indMostrar = indMostrar;
	}
	/**
	 * @return Returns the listaAnhos.
	 */
	public List getListaAnhos() {
		return listaAnhos;
	}
	/**
	 * @param listaAnhos The listaAnhos to set.
	 */
	public void setListaAnhos(List listaAnhos) {
		this.listaAnhos = listaAnhos;
	}
	/**
	 * @return Returns the listaOficina.
	 */
	public List getListaOficina() {
		return listaOficina;
	}
	/**
	 * @param listaOficina The listaOficina to set.
	 */
	public void setListaOficina(List listaOficina) {
		this.listaOficina = listaOficina;
	}
	/**
	 * @return Returns the listaPlanes.
	 */
	public List getListaPlanes() {
		return listaPlanes;
	}
	/**
	 * @param listaPlanes The listaPlanes to set.
	 */
	public void setListaPlanes(List listaPlanes) {
		this.listaPlanes = listaPlanes==null?new Vector(0,1):listaPlanes;
	}
	/**
	 * @return Returns the listaPresup.
	 */
	public List getListaPresup() {
		return listaPresup;
	}
	/**
	 * @param listaPresup The listaPresup to set.
	 */
	public void setListaPresup(List listaPresup) {
		this.listaPresup = listaPresup;
	}
	/**
	 * @return Returns the oficina.
	 */
	public String getOficina() {
		return oficina;
	}
	/**
	 * @param oficina The oficina to set.
	 */
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	/**
	 * @return Returns the mesAnterMostrar.
	 */
	public String getMesAnterMostrar() {
		return mesAnterMostrar;
	}
	/**
	 * @param mesAnterMostrar The mesAnterMostrar to set.
	 */
	public void setMesAnterMostrar(String mesAnterMostrar) {
		this.mesAnterMostrar = mesAnterMostrar;
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
	 * @return Returns the codNomOficina.
	 */
	public String getCodNomOficina() {
		return codNomOficina;
	}
	/**
	 * @param codNomOficina The codNomOficina to set.
	 */
	public void setCodNomOficina(String codNomOficina) {
		this.codNomOficina = codNomOficina;
	}
	/**
	 * @return Returns the codOficina.
	 */
	public String getCodOficina() {
		return codOficina;
	}
	/**
	 * @param codOficina The codOficina to set.
	 */
	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}
	
	/**
	 * @return Returns the mesPlanificacion.
	 */
	public String getMesPlanificacion() {
		return mesPlanificacion;
	}
	/**
	 * @param mesPlanificacion The mesPlanificacion to set.
	 */
	public void setMesPlanificacion(String mesPlanificacion) {
		this.mesPlanificacion = mesPlanificacion;
	}
	/**
	 * @return Returns the preReferencia.
	 */
	public String getPreReferencia() {
		return preReferencia;
	}
	/**
	 * @param preReferencia The preReferencia to set.
	 */
	public void setPreReferencia(String preReferencia) {
		this.preReferencia = preReferencia;
	}
	/**
	 * @return Returns the codTerritorio.
	 */
	public String getCodTerritorio() {
		return codTerritorio;
	}
	/**
	 * @param codTerritorio The codTerritorio to set.
	 */
	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}
	/**
	 * @return Returns the listaterritorio.
	 */
	public List getListaterritorio() {
		return listaterritorio;
	}
	/**
	 * @param listaterritorio The listaterritorio to set.
	 */
	public void setListaterritorio(List listaterritorio) {
		this.listaterritorio = listaterritorio;
	}
}
