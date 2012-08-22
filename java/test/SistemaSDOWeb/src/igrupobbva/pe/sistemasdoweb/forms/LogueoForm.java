/**
 * Nombre	   : LogueoForm.java  
 * Version     : 1.0	
 * Creacion    : 19/11/2008
 * Autor       : Orlando Pihue Montoya.
 * Usuario     : P020912
 * Finalidad   : Unifica la llamada de todos los sessions de modo que este se llame en la parte web.
 *
 * Modificacion: << fecha de modificacion>>
 * Autor       : <<quien actualizo el archivo>>
 * Usuario     : <<codigo de usuario modificador>>
 * Detalle     : <<descripcion de la modificacion>>
 */
package igrupobbva.pe.sistemasdoweb.forms;

import org.apache.struts.action.ActionForm;

public class LogueoForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario = null;
	private String password = null;

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the usuario.1L
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            The usuario to set.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}