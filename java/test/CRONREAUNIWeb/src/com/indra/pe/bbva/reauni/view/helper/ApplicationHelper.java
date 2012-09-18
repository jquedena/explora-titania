package com.indra.pe.bbva.reauni.view.helper;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;


public class ApplicationHelper {

	private static Logger logger = Logger.getLogger(ApplicationHelper.class);
	private static Boolean modoDebug = null; 
	private static String emailDebug = null;	
	
	public static Boolean getModoDebug() {
		if(modoDebug == null) {
			try {
				modoDebug = ApplicationHelper.obtenerParametroPorId(1077L).getValorBoolean();
			} catch(Exception e) {
				modoDebug = Boolean.FALSE;
			}
		}
		return modoDebug;
	}

	public static String getEmailDebug() {
		if(emailDebug == null) {
			try {
				emailDebug = ApplicationHelper.obtenerParametroPorId(1078L).getValorCadena();
			} catch(Exception e) {
				emailDebug = "";
			}
		}
		return emailDebug;
	}
	
	public static CatalogoParametroDto obtenerCatalogoPorId(Long id) {
		CatalogoParametroDto c = null;
		// AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
		for (CatalogoParametroDto cp : AplicacionMBean.getListaCatalogos()) {
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
			logger.error("", e);
		}
	
		return c;
	}
	 
}
