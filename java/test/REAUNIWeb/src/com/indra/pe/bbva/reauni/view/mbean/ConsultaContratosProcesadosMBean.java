package com.indra.pe.bbva.reauni.view.mbean;


import java.util.Date;

import org.apache.log4j.Logger;
import org.primefaces.event.DateSelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.task.thread.ContratoProcesadoCorreo;
import com.indra.pe.bbva.reauni.util.Constantes;

@Controller("consultaContratosProcesadosMBean")
@Scope("session")
public class ConsultaContratosProcesadosMBean extends GenericMBean{
	
	private static Logger logger = Logger.getLogger(ConsultaContratosProcesadosMBean.class);
	private Date fechaInicio;
	private Date fechaFin;
	
	public ConsultaContratosProcesadosMBean() {
		fechaInicio = new Date();
		fechaFin = new Date();
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		ConsultaContratosProcesadosMBean.logger = logger;
	}
	
	public String index() {
		return Constantes.UrlNavegacion.URL_LISTA_CONTRATO_PROCESADO;
	}

	public void enviar() {
		Date temp;
		if(fechaInicio.compareTo(fechaFin) == 1) {
			temp = fechaFin;
			fechaFin = fechaInicio;
			fechaInicio = temp;
		}
		ContratoProcesadoCorreo correo = new ContratoProcesadoCorreo(fechaInicio, fechaFin);
		correo.start();
	}
	
	public void listenerAsignarFechaInicio(DateSelectEvent event) {
        this.setFechaInicio(event.getDate());
    }
	
	public void listenerAsignarFechaHasta(DateSelectEvent event) {  
        this.setFechaFin(event.getDate());  
    }
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
}
