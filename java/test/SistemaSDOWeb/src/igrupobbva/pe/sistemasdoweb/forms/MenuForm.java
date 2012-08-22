package igrupobbva.pe.sistemasdoweb.forms;

import org.apache.struts.action.ActionForm;

public class MenuForm extends ActionForm{

    private String codPerfil;    
    private String padre;    
    private String hijo;
    private String link;    
    private String descripcion;
    private String newLink;
    
   
	
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
	 * @return Returns the hijo.
	 */
	public String getHijo() {
		return hijo;
	}
	/**
	 * @param hijo The hijo to set.
	 */
	public void setHijo(String hijo) {
		this.hijo = hijo;
	}
	/**
	 * @return Returns the link.
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link The link to set.
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return Returns the padre.
	 */
	public String getPadre() {
		return padre;
	}
	/**
	 * @param padre The padre to set.
	 */
	public void setPadre(String padre) {
		this.padre = padre;
	}
	/**
	 * @return Returns the newLink.
	 */
	public String getNewLink() {
		return newLink;
	}
	/**
	 * @param newLink The newLink to set.
	 */
	public void setNewLink(String newLink) {
		this.newLink = newLink;
	}
}
