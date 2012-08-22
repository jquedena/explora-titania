/*
 * Created on 24/02/2009
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
public class ReportePGOForm extends ActionForm{
	private String codOficina;
	private String anho;
	private String mes;
	private List listaOficina;
	private List listaAnhos;
	private List listaMeses;
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
	 * @return Returns the listaMeses.
	 */
	public List getListaMeses() {
		return listaMeses;
	}
	/**
	 * @param listaMeses The listaMeses to set.
	 */
	public void setListaMeses(List listaMeses) {
		this.listaMeses = listaMeses;
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
}
