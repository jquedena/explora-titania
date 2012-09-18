package com.indra.pe.bbva.core.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Controller;

@Controller("genericMBean")
public class GenericMBean {
	
	public GenericMBean() {
	}
	
	public static void showMessage(String msjResumen) {
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, msjResumen, null);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public static void showMessage(String msjResumen, String msjDetalle) {
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, msjResumen, msjDetalle);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public static void showWarning(String msjResumen) {
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, msjResumen, null);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public static void showWarning(String msjResumen, String msjDetalle) {
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, msjResumen, msjDetalle);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public static void showError(String msjResumen) {
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, msjResumen, null);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public static void showError(String msjResumen, String msjDetalle) {
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, msjResumen, msjDetalle);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public static void showFatal(String msjResumen) {
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_FATAL, msjResumen, null);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

    public static void showFatal(String msjResumen, String msjDetalle) {
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_FATAL, msjResumen, msjDetalle);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }

}
