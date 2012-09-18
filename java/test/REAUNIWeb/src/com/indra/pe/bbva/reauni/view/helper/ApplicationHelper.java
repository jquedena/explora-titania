package com.indra.pe.bbva.reauni.view.helper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;

@Controller("applicationHelper")
public class ApplicationHelper {
	
	private static Logger logger = Logger.getLogger(ApplicationHelper.class);
	
	public static CatalogoParametroDto obtenerCatalogoPorId(Long id) {
		CatalogoParametroDto c = null;
		AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
		for (CatalogoParametroDto cp : aplicacionMBean.getListaCatalogos()) {
			if (cp.getId().equals(id)){
				c = cp;
				break;
			}
                            
        }		
		return c;
	}
	
	public static ParametroDto obtenerParametroPorId(Long id) {
		ParametroDto c = null;
		ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
		
		try {
			c = parametroBO.obtenerParametro(id);
		} catch (ServiceException e) {
			c = null;			
			logger.error(e);
		}
	
		return c;
	}
	
	 
}
