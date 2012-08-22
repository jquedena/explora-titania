package igrupobbva.pe.sistemasdoweb.forms;

import org.apache.struts.action.ActionForm;

public class PermisoPerfilForm extends ActionForm
{
    private String codPerfil;    
    private String tipoAcceso;    
    private String valorRCP;
    private String usuario;
    private String listaCodPerfil;	
    private String listaTipoAcceso;
    private String listaValorRCP;
    
	/**
	 * @return Returns the listaCodPerfil.
	 */
	public String getListaCodPerfil() {
		return listaCodPerfil;
	}
	/**
	 * @param listaCodPerfil The listaCodPerfil to set.
	 */
	public void setListaCodPerfil(String listaCodPerfil) {
		this.listaCodPerfil = listaCodPerfil;
	}
	/**
	 * @return Returns the listaTipoAcceso.
	 */
	public String getListaTipoAcceso() {
		return listaTipoAcceso;
	}
	/**
	 * @param listaTipoAcceso The listaTipoAcceso to set.
	 */
	public void setListaTipoAcceso(String listaTipoAcceso) {
		this.listaTipoAcceso = listaTipoAcceso;
	}
	/**
	 * @return Returns the listaValorRCP.
	 */
	public String getListaValorRCP() {
		return listaValorRCP;
	}
	/**
	 * @param listaValorRCP The listaValorRCP to set.
	 */
	public void setListaValorRCP(String listaValorRCP) {
		this.listaValorRCP = listaValorRCP;
	}
	/**
	 * @return Returns the codPerfil.
	 */
	public String getCodPerfil() {
		return codPerfil;
	}
	/**
	 * @param codPerfil The codPerfil to set.
	 */
	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}
	/**
	 * @return Returns the tipoAcceso.
	 */
	public String getTipoAcceso() {
		return tipoAcceso;
	}
	/**
	 * @param tipoAcceso The tipoAcceso to set.
	 */
	public void setTipoAcceso(String tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}
	/**
	 * @return Returns the usuario.
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario The usuario to set.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return Returns the valorRCP.
	 */
	public String getValorRCP() {
		return valorRCP;
	}
	/**
	 * @param valorRCP The valorRCP to set.
	 */
	public void setValorRCP(String valorRCP) {
		this.valorRCP = valorRCP;
	}
}
