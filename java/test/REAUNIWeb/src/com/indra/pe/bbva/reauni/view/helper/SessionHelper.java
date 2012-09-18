package com.indra.pe.bbva.reauni.view.helper;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;
import com.indra.pe.bbva.reauni.service.AccesoFechaCorteBO;
import com.indra.pe.bbva.reauni.service.FechaCorteBO;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

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
	
	public static void validarFechaCorte() {
		AccesoFechaCorteBO accesoFechaCorteBO = (AccesoFechaCorteBO) WebServletContextListener.getApplicationContext().getBean("accesoFechaCorteBO");
		FechaCorteBO fechaCorteBO = (FechaCorteBO) WebServletContextListener.getApplicationContext().getBean("fechaCorteBO");
		Calendar c = Calendar.getInstance();
		FechaCorteDto fc;
		try {
			fc = fechaCorteBO.obtenerFechaCorte(c.getTime(),0L);
			SessionMBean sessionMBean = (SessionMBean) WebServletContextListener.getApplicationContext().getBean("sessionMBean");

			if (fc == null) {
				sessionMBean.setFechaCorte(Boolean.TRUE);
				sessionMBean.setMensajeFechaCorte("");
			} else {
				BigDecimal v = null;

				try {
					v = accesoFechaCorteBO.validarFechaCorte(sessionMBean.getRegistro(), fc);
				} catch (ServiceException e) {
				}

				if (v != null) {
					if (v.intValue() > 0) {
						sessionMBean.setFechaCorte(Boolean.TRUE);
						sessionMBean.setMensajeFechaCorte("EL USUARIO TIENE FECHA DE CORTE,PERO AUN PUEDE CREAR " + v + " SOLICITUDES");
					} else {
						sessionMBean.setFechaCorte(Boolean.FALSE);
						sessionMBean.setMensajeFechaCorte("EL USUARIO NO PUEDE GENERAR MÁS SOLICITUDES PORQUE TIENE FECHA DE CORTE; Y YA GENERÓ TODAS LAS SOLICITUDES QUE PUEDE GENERAR EN DICHA FECHA DE CORTE");
					}
				} else {
					sessionMBean.setFechaCorte(Boolean.FALSE);
					sessionMBean.setMensajeFechaCorte("EL USUARIO NO PUEDE GENERAR SOLICITUDES; PORQUE NO TIENE ACCESO A FECHA DE CORTE ("+fc.getNombreActividad()+" : "+ fc.getFechaInicio()+" A "+fc.getFechaFin()+")");
				}
			}
		} catch (DAOException e) {
			logger.error("SessionHelper", e);
		}

	}

}
