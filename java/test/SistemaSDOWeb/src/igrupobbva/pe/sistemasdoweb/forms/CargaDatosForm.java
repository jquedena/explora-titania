/*
 * Created on 09/03/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CargaDatosForm extends ActionForm{
	
	private FormFile fileInput;
	
	/**
	 * @return Returns the fileInput.
	 */
	public FormFile getFileInput() {
		return fileInput;
	}
	/**
	 * @param fileInput The fileInput to set.
	 */
	public void setFileInput(FormFile fileInput) {
		this.fileInput = fileInput;
	}
}