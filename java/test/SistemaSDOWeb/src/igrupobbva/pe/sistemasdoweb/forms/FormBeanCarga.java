/*
 * Created on 17-jun-2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author ocortez
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FormBeanCarga extends ActionForm{

	private org.apache.struts.upload.FormFile fileInput = null;

	/**
	 * @return Returns the inputfile.
	 */
	public org.apache.struts.upload.FormFile getFileInput() {
		return fileInput;
	}

	/**
	 * @param inputfile
	 *            The inputfile to set.
	 */
	public void setFileInput(org.apache.struts.upload.FormFile fileInput) {
		this.fileInput = fileInput;
	}

	/**
	 * Constructor
	 */
	public FormBeanCarga() {

	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.

		fileInput = null;

	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		// if ((field == null) || (field.length() == 0)) {
		//   errors.add("field", new
		// org.apache.struts.action.ActionError("error.field.required"));
		// }
		return errors;

	}
	
}
