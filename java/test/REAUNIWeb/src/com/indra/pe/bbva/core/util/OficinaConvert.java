/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indra.pe.bbva.core.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;

/**
 *
 * @author Indra
 */
@FacesConverter("oficinaConvert")
public class OficinaConvert implements Converter {
	private static Logger logger = Logger.getLogger(OficinaConvert.class);
	
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
        String id = String.valueOf(value);
        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                OficinaDto dto = null;
                for (OficinaDto p : aplicacionMBean.getListaOficinas()) {
                    if (p.getCodOficina().equals(id)) {
                        dto = p;
                        break;
                    }
                }
                return dto;
            } catch (Exception exception) {
            	logger.error("getAsObject :: ",  exception);
                return null;
            }
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((OficinaDto) value).getCodOficina());
        }
    }
    
    
}
