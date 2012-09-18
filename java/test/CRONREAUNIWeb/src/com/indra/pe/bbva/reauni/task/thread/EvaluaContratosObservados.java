package com.indra.pe.bbva.reauni.task.thread;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.reauni.model.entidad.TareaDto;

public class EvaluaContratosObservados extends Thread{
	
	private static Logger logger = Logger.getLogger(EvaluaContratosObservados.class);
	
	
	private DAOGenerico<TareaDto> daoTarea;
	
	@Override
	public void run() {
		try{
			int i = getDaoTarea().executeProcedure("{call reauni.sp_proceso_evalua_contrato()}");			
			logger.info("CRON REAUNI - SE EJECUTA PROCESO REAUNI.SP_PROCESO_EVALUA_CONTRATO..................");
		}catch(Exception e){
			logger.error("Error en REAUNI.SP_PROCESO_EVALUA_CONTRATO ",e);
		}		
	}

	public DAOGenerico<TareaDto> getDaoTarea() {
		if(daoTarea ==  null){
			daoTarea = (DAOGenerico<TareaDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoTarea;
	}	
	
	

}
