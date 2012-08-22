/*
 * Created on 13/02/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ObjetivosForm extends ActionForm{
	private String anho;
	private String mes;
	private String codOficina;
	private String codEpigrafe;
	private String epigrafe;
	private String prioridad;
	private String gestores;
	private String indMostrarEpigrafe;
	private String indMostrarGerente;
	private List listaOficina;
	private List listaEpigrafes;
	private List listaAnhos;
	private String restoOficina;
	private String montoTotal;
	
	/**
	 * @return Returns the restoOficina.
	 */
	public String getRestoOficina() {
		return restoOficina;
	}
	/**
	 * @param restoOficina The restoOficina to set.
	 */
	public void setRestoOficina(String restoOficina) {
		this.restoOficina = restoOficina;
	}
	/**
	 * @return Returns the codEpigrafe.
	 */
	public String getCodEpigrafe() {
		return codEpigrafe;
	}
	/**
	 * @param codEpigrafe The codEpigrafe to set.
	 */
	public void setCodEpigrafe(String codEpigrafe) {
		this.codEpigrafe = codEpigrafe;
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
	 * @return Returns the listaEpigrafes.
	 */
	public List getListaEpigrafes() {
		return listaEpigrafes;
	}
	/**
	 * @param listaEpigrafes The listaEpigrafes to set.
	 */
	public void setListaEpigrafes(List listaEpigrafes) {
		this.listaEpigrafes = listaEpigrafes;
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
	 * @return Returns the epigrafe.
	 */
	public String getEpigrafe() {
		return epigrafe;
	}
	/**
	 * @param epigrafe The epigrafe to set.
	 */
	public void setEpigrafe(String epigrafe) {
		this.epigrafe = epigrafe;
	}
	/**
	 * @return Returns the gestores.
	 */
	public String getGestores() {
		return gestores;
	}
	/**
	 * @param gestores The gestores to set.
	 */
	public void setGestores(String gestores) {
		this.gestores = gestores;
	}
	/**
	 * @return Returns the indMostrarEpigrafe.
	 */
	public String getIndMostrarEpigrafe() {
		return indMostrarEpigrafe;
	}
	/**
	 * @param indMostrarEpigrafe The indMostrarEpigrafe to set.
	 */
	public void setIndMostrarEpigrafe(String indMostrarEpigrafe) {
		this.indMostrarEpigrafe = indMostrarEpigrafe;
	}
	/**
	 * @return Returns the indMostrarGerente.
	 */
	public String getIndMostrarGerente() {
		return indMostrarGerente;
	}
	/**
	 * @param indMostrarGerente The indMostrarGerente to set.
	 */
	public void setIndMostrarGerente(String indMostrarGerente) {
		this.indMostrarGerente = indMostrarGerente;
	}
	/**
	 * @return Returns the mes.
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes The mes to set.
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}
	/**
	 * @return Returns the prioridad.
	 */
	public String getPrioridad() {
		return prioridad;
	}
	/**
	 * @param prioridad The prioridad to set.
	 */
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	/**
	 * @return Returns the montoTotal.
	 */
	public String getMontoTotal() {
		return montoTotal;
	}
	/**
	 * @param montoTotal The montoTotal to set.
	 */
	public void setMontoTotal(String montoTotal) {
		this.montoTotal = montoTotal;
	}
}
