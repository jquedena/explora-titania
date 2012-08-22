package igrupobbva.pe.sistemasdoweb.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class BienvenidaForm extends ActionForm{

	private FormFile fileInput =null; 
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
