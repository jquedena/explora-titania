package igrupobbva.pe.sistemasdoweb.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class SimpleLoadForm extends ActionForm {
	private FormFile fileInput;

	public FormFile getFileInput() {
		return fileInput;
	}

	public void setFileInput(FormFile fileInput) {
		this.fileInput = fileInput;
	}
	
}
