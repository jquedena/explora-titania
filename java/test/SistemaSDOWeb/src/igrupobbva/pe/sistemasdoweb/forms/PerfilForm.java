package igrupobbva.pe.sistemasdoweb.forms;

import org.apache.struts.action.ActionForm;

public class PerfilForm extends ActionForm{

	private static final long serialVersionUID = 5567280238159604950L;
	private String codPerfil;
    private String nomPerfil;
    private String usuRegi;
	private String fecRegi;
	private String usuActu;
	private String fecActu;
	private String componente;
	private String perfil;
    
	public String getFecActu() {
		return fecActu;
	}
	
	public void setFecActu(String fecActu) {
		this.fecActu = fecActu;
	}
	
	public String getFecRegi() {
		return fecRegi;
	}
	
	public void setFecRegi(String fecRegi) {
		this.fecRegi = fecRegi;
	}
	
	public String getUsuActu() {
		return usuActu;
	}
	
	public void setUsuActu(String usuActu) {
		this.usuActu = usuActu;
	}
	
	public String getUsuRegi() {
		return usuRegi;
	}

	public void setUsuRegi(String usuRegi) {
		this.usuRegi = usuRegi;
	}

	public String getNomPerfil() {
		return nomPerfil;
	}

	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}

	public String getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}