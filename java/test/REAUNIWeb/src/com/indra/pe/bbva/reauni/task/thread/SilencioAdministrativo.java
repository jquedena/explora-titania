package com.indra.pe.bbva.reauni.task.thread;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.mail.CorreoElectronico;
import com.indra.pe.bbva.reauni.mail.GestionCorreo;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;

@SuppressWarnings({"unused", "unchecked"})
public class SilencioAdministrativo extends Thread{
	
	private static Logger logger = Logger.getLogger(SilencioAdministrativo.class);
	
	
	private DAOGenerico<SolicitudDto> daoTarea;
	
	@Override
	public void run() {
		try{ 
			int i = getDaoTarea().executeProcedure("{call reauni.sp_proceso_silencio_adm()}");			
			
			//LUEGO DE EJECUTADO EL PROCESO DE SILENCIO ADMINISTRATIVO SE ENVÍA CORREO A TODAS LAS SOLICITUDES CUYO ESTADO APROBADO HA SIDO POR EL SILENCIO ADMINISTRATIVO
			String sql = "select e from SolicitudDto e where e.fechaAprobacionSilencio > ? and e.aprobadaPorSilencio = ?";	
			
			List<Object> listaParametros =  new ArrayList<Object>();
			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR, 0);
            c.set(Calendar.MINUTE,0);
            c.set(Calendar.SECOND,0);
			listaParametros.add(c.getTime());
			listaParametros.add(Boolean.TRUE);
			
			
			List<SolicitudDto> lista = getDaoTarea().ejecutarQuery(sql, listaParametros);
			GestionCorreo gestionCorreo = (GestionCorreo) WebServletContextListener.getApplicationContext().getBean("gestionCorreo");
			
			if(lista != null) {
				for (SolicitudDto s : lista) {
					try {
						CorreoElectronico correoElectronico =  new CorreoElectronico();
						correoElectronico.enviar(gestionCorreo.obtenerCorreoSilencioAdministrativoBatch(s));
					}catch(Exception e){
						logger.error("Enviando correo - SilencioAdministrativo ",e);
					}
				}
			}
		}catch(Exception e){
			logger.error("Error en REAUNI.SP_PROCESO_SILENCIO_ADM ",e);
		}		
	}

	public DAOGenerico<SolicitudDto> getDaoTarea() {
		if(daoTarea ==  null){
			daoTarea = (DAOGenerico<SolicitudDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoTarea;
	}	
}
