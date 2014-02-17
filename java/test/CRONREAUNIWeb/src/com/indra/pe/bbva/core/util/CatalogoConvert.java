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
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;

/**
 *
 * @author Indra
 */
@FacesConverter("catalogoConvert")
public class CatalogoConvert implements Converter {
	private static Logger logger = Logger.getLogger(CatalogoConvert.class);
    
	@SuppressWarnings("static-access")
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long id = Long.valueOf(value);
        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                CatalogoParametroDto dto = null;
                AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
                
                for (CatalogoParametroDto p : aplicacionMBean.getListaCatalogos()) {
                    if (p.getId().equals(id)) {
                        dto = p;
                        break;
                    }
                }
                return dto;
            } catch (Exception exception) {
                logger.error("catch :: " + exception.getMessage());
                return null;
            }
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((CatalogoParametroDto) value).getId());
        }
    }
}
