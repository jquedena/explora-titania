package com.indra.pe.bbva.reauni.view.helper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller("sessionHelper")
public class SessionHelper {
	
	private static Logger logger = Logger.getLogger(SessionHelper.class);
	private static Boolean modoDebug = null; 
	private static String emailDebug = null;	
	
	public static Boolean getModoDebug() {
		if(modoDebug == null) {
			try {
				modoDebug = ApplicationHelper.obtenerParametroPorId(1077L).getValorBoolean();
			} catch(Exception e) {
				logger.error("Error al obtener el parametro DEBUG", e);
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
				logger.error("Error al obtener el parametro DEBUG", e);
				emailDebug = "";
			}
		}
		return emailDebug;
	}
}
