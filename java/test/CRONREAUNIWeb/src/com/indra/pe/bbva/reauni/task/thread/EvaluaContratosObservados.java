package com.indra.pe.bbva.reauni.task.thread;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.service.impl.ProcedimientoServiceImpl;
import com.indra.pe.bbva.reauni.task.laucher.GestionadorTareas;

public class EvaluaContratosObservados extends Thread{
	
	private static Logger logger = Logger.getLogger(EvaluaContratosObservados.class);

	@Override
	public void run() {
		ProcedimientoServiceImpl proc = (ProcedimientoServiceImpl) WebServletContextListener.getApplicationContext().getBean("procedimientoService");
		try {
			proc.ejecutarProcesoEvaluacionContrato();
		} catch (DAOException e) {
			logger.error("Error en EvaluaContratosObservados ", e);
			GestionadorTareas.enviarCorreo("EvaluaContratosObservados", e);
		}
	}
}
