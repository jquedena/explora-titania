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
import com.indra.pe.bbva.reauni.model.entidad.TerritorioDto;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;

/**
 *
 * @author Indra
 */
@FacesConverter("territorioConvert")
public class TerritorioConvert implements Converter {
	private static Logger logger = Logger.getLogger(TerritorioConvert.class);
	
	
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
        String id = String.valueOf(value);
        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                TerritorioDto territorioDto = null;
                for (TerritorioDto p : aplicacionMBean.getListaTerritorios()) {
                    if (p.getCodTerritorio().equals(id)) {
                        territorioDto = p;
                        break;
                    }
                }
                return territorioDto;
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
            return String.valueOf(((TerritorioDto) value).getCodTerritorio());
        }
    }
    
    
}
