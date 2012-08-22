package igrupobbva.pe.sistemasdoweb.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;

@SuppressWarnings({"unchecked", "serial"})
public class ReportePPGForm extends ActionForm{

	private String codTerritorio;
	private String codOficina;
	private String anho;
	private String mes;
	private String codGestor;
	private List listaOficina;
	private List listaAnhos;
	private List listaMeses;
	private String codEpigrafe;
	
	public String getCodTerritorio() {
		return codTerritorio;
	}
	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}
	
	public String getCodEpigrafe() {
		return codEpigrafe;
	}
	public void setCodEpigrafe(String codEpigrafe) {
		this.codEpigrafe = codEpigrafe;
	}

	public String getCodGestor() {
		return codGestor;
	}

	public void setCodGestor(String codGestor) {
		this.codGestor = codGestor;
	}

	public String getAnho() {
		return anho;
	}

	public void setAnho(String anho) {
		this.anho = anho;
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public List getListaAnhos() {
		return listaAnhos;
	}

	public void setListaAnhos(List listaAnhos) {
		this.listaAnhos = listaAnhos;
	}

	public List getListaMeses() {
		return listaMeses;
	}

	public void setListaMeses(List listaMeses) {
		this.listaMeses = listaMeses;
	}

	public List getListaOficina() {
		return listaOficina;
	}

	public void setListaOficina(List listaOficina) {
		this.listaOficina = listaOficina;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
}
