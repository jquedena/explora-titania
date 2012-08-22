/**
 * Nombre	   : ResultCargaForm.java  
 * Version     : 1.0	
 * Creacion    : 10/07/2009
 * Autor       : Godofredo Ureta Rafael.
 * Usuario     : 
 * Finalidad   : Contendra el resultado de la carga de data desde un archivo de texto a la BD de PLANIFICACION.
 *
 * Modificacion: << fecha de modificacion>>
 * Autor       : <<quien actualizo el archivo>>
 * Usuario     : <<codigo de usuario modificador>>
 * Detalle     : <<descripcion de la modificacion>>
 */
package igrupobbva.pe.sistemasdoweb.forms;

import org.apache.struts.action.ActionForm;

public class ResultCargaForm extends ActionForm

{
	private String codigo = null;
	private String descripcion = null;
	private String oficinas = null;

	/**
	 * @return Returns the codigo.
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo The codigo to set.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return Returns the oficinas.
	 */
	public String getOficinas() {
		return oficinas;
	}
	/**
	 * @param oficinas The oficinas to set.
	 */
	public void setOficinas(String oficinas) {
		this.oficinas = oficinas;
	}
}