package com.indra.pe.bbva.core.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.reauni.model.entidad.GestorDto;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;

@FacesConverter("gestorConvert")
public class GestorConvert implements Converter {
	private static Logger logger = Logger.getLogger(GestorConvert.class);
   
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
        String id = String.valueOf(value);
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            try {
                GestorDto dto = null;
                for (GestorDto p : aplicacionMBean.getListaGestores()) {
                    if (p.getCodGestor().equals(id)) {
                        dto = p;
                        break;
                    }
                }
                return dto;
            } catch (Exception e) {
            	logger.error("getAsObject", e);
                return null;
            }
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((GestorDto) value).getCodGestor());
        }
    }  
}
