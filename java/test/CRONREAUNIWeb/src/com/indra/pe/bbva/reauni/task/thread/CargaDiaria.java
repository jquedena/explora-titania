package com.indra.pe.bbva.reauni.task.thread;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.reauni.model.entidad.TareaDto;

@SuppressWarnings({"unused", "unchecked"})
public class CargaDiaria extends Thread{
	
	private static Logger logger = Logger.getLogger(CargaDiaria.class);	
	
	private DAOGenerico<TareaDto> daoTarea;
	
	@Override
	public void run() {
		try{
			int i = getDaoTarea().executeProcedure("{call REAUNI.PCK_CARGA_ARCHIVOS.EJECUTAR_CARGA_DIARIA()}");
		}catch(Exception e){
			logger.error("Error en CargaDiaria ",e);
		}		
	}

	public DAOGenerico<TareaDto> getDaoTarea() {
		if(daoTarea ==  null){
			daoTarea = (DAOGenerico<TareaDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoTarea;
	}	
	
	

}
