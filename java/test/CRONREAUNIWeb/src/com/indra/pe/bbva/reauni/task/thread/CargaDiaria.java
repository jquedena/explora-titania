package com.indra.pe.bbva.reauni.task.thread;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.service.impl.ProcedimientoServiceImpl;
import com.indra.pe.bbva.reauni.task.laucher.GestionadorTareas;

public class CargaDiaria extends Thread{
	
	private static Logger logger = Logger.getLogger(CargaDiaria.class);
	
	@Override
	public void run() {
		ProcedimientoServiceImpl proc = (ProcedimientoServiceImpl) WebServletContextListener.getApplicationContext().getBean("procedimientoService");
		try {
			proc.ejecutarProcesoCargaArchivo();
		} catch (DAOException e) {
			logger.error("Error en CargaDiaria ", e);
			GestionadorTareas.enviarCorreo("CargaDiaria", e);
		}
	}
}
