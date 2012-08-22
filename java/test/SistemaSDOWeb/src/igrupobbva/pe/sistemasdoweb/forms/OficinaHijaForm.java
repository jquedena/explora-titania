package igrupobbva.pe.sistemasdoweb.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OficinaHijaForm extends ActionForm{	
	private String codigoOficinaHija;
	private String codigoOficinaPadre;
	private String descripcion;
	private String mostrarEditar;	
	private String method;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		codigoOficinaHija = "";
		codigoOficinaPadre = "";
		descripcion = "";		
	}
	
	/**
	 * @return Returns the codigoOficina.
	 */
	public String getCodigoOficinaPadre() {
		return codigoOficinaPadre;
	}
	/**
	 * @param codigoOficina The codigoOficina to set.
	 */
	public void setCodigoOficinaPadre(String codigoOficinaPadre) {
		this.codigoOficinaPadre = codigoOficinaPadre;
	}
	/**
	 * @return Returns the codigoOficinaHija.
	 */
	public String getCodigoOficinaHija() {
		return codigoOficinaHija;
	}
	/**
	 * @param codigoOficinaHija The codigoOficinaHija to set.
	 */
	public void setCodigoOficinaHija(String codigoOficinaHija) {
		this.codigoOficinaHija = codigoOficinaHija;
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
	 * @return Returns the method.
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method The method to set.
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * @return Returns the mostrarEditar.
	 */
	public String getMostrarEditar() {
		return mostrarEditar;
	}
	/**
	 * @param mostrarEditar The mostrarEditar to set.
	 */
	public void setMostrarEditar(String mostrarEditar) {
		this.mostrarEditar = mostrarEditar;
	}
}
