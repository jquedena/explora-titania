package com.indra.pe.bbva.reauni.task.thread;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.reauni.model.entidad.TareaDto;

public class SilencioAdministrativo extends Thread{
	
	private static Logger logger = Logger.getLogger(SilencioAdministrativo.class);
	
	
	private DAOGenerico<TareaDto> daoTarea;
	
	@Override
	public void run() {
		try{
			int i = getDaoTarea().executeProcedure("{call reauni.sp_proceso_silencio_adm()}");			
		}catch(Exception e){
			logger.error("Error en REAUNI.SP_PROCESO_SILENCIO_ADM ",e);
		}		
	}

	public DAOGenerico<TareaDto> getDaoTarea() {
		if(daoTarea ==  null){
			daoTarea = (DAOGenerico<TareaDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoTarea;
	}	
	
	

}
