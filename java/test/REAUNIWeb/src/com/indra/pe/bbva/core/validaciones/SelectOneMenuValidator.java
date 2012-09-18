package com.indra.pe.bbva.core.validaciones;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class SelectOneMenuValidator implements Validator {
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		 Long itemSeleccionado = (Long)value;
		 if(itemSeleccionado == -1L){
			 throw new ValidatorException(new FacesMessage("seleccione un registro"));                   
		 }
	}

}
