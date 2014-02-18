package com.indra.pe.bbva.reauni.task.thread;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.reauni.service.ReporteService;
import com.indra.pe.bbva.reauni.task.laucher.GestionadorTareas;

public class GeneracionReporte extends Thread {

	private static Logger logger = Logger.getLogger(GeneracionReporte.class);
	
	@Override
	public void run() {
		try {
			ReporteService reporteService = (ReporteService) WebServletContextListener.getApplicationContext().getBean("reporteService");
			reporteService.guardarReporteRepositorio();
		} catch (Exception e) {
			logger.error("Error en GeneracionReporte ", e);
			GestionadorTareas.enviarCorreo("GeneracionReporte", e);
		}
	}
}
