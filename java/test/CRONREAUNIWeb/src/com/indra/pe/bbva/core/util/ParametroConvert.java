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
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;

/**
 *
 * @author Indra
 */
@FacesConverter("parametroConvert")
public class ParametroConvert implements Converter {
	private static Logger logger = Logger.getLogger(ParametroConvert.class);
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	//AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
        Long id = Long.valueOf(value);
        if (value.trim().equals("")) {
            return null;
        } else {
            try {
            	ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
                ParametroDto parametroDto = parametroBO.obtenerParametro(id);
//                for (ParametroDto p : aplicacionMBean.getListaParametros()) {
//                    if (p.getId().equals(id)) {
//                        parametroDto = p;
//                        break;
//                    }
//                }
                return parametroDto;
            } catch (Exception exception) {
            	logger.error("CONVERT PARAMETRO", exception);
                return null;
            }
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((ParametroDto) value).getId());
        }
    }
    
    
}
