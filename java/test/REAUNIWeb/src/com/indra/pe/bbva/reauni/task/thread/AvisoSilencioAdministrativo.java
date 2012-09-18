package com.indra.pe.bbva.reauni.task.thread;
 
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.mail.CorreoElectronico;
import com.indra.pe.bbva.reauni.mail.GestionCorreo;
import com.indra.pe.bbva.reauni.model.entidad.AvisoSilencioAdministrativoDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;

public class AvisoSilencioAdministrativo  extends Thread {
	private static Logger logger = Logger.getLogger(AvisoSilencioAdministrativo.class);
	
	private DAOGenerico<SolicitudDto> daoTarea;
	private DAOGenerico<AvisoSilencioAdministrativoDto> daoAviso;
  
	@Autowired
	private GestionCorreo gestionCorreo;
	
	@Override
	public void run() {
		try{
			
			// List lista_oficinas = getDaoTarea().ejecutarSQL("select * from reauni.vreauni_aviso_sil_adm") ;	
			List<AvisoSilencioAdministrativoDto> lista_oficinas = getDaoAviso().listarTodosDtos(AvisoSilencioAdministrativoDto.class);
			
			String solicitud="";
			String fecha_inicio="";
			String fecha_vencimiento="";
			
			if(lista_oficinas != null) {
				for(Iterator<AvisoSilencioAdministrativoDto> iter = lista_oficinas.iterator(); iter.hasNext();){
					StringTokenizer registro = new StringTokenizer( iter.next().getValor(),"|");
					solicitud=registro.nextToken();
					fecha_inicio=registro.nextToken();
					fecha_vencimiento=registro.nextToken();
					SolicitudDto solicitudDto=getDaoTarea().obtenerDtoPorId(SolicitudDto.class, Long.valueOf(solicitud));
	
					try {
						CorreoElectronico correoElectronico =  new CorreoElectronico();
						correoElectronico.enviar(getGestionCorreo().obtenerCorreoSilencioAdministrativo(solicitudDto, fecha_inicio, fecha_vencimiento));
					} catch(Exception e){
						logger.error("Enviando correo - AvisoSilencioAdministrativo ",e);
					}
				}
			}
			
		}catch(Exception e){
			logger.error("Error en AVISO DE SILENCIO ADMINISTRATIVO ",e);
		}		
	}

	@SuppressWarnings("unchecked")
	public DAOGenerico<AvisoSilencioAdministrativoDto> getDaoAviso() {
		if(daoAviso ==  null){
			daoAviso = (DAOGenerico<AvisoSilencioAdministrativoDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoAviso;
	}	

	@SuppressWarnings("unchecked")
	public DAOGenerico<SolicitudDto> getDaoTarea() {
		if(daoTarea ==  null){
			daoTarea = (DAOGenerico<SolicitudDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoTarea;
	}
	
	public GestionCorreo getGestionCorreo() {
		if(gestionCorreo ==  null){
			gestionCorreo = (GestionCorreo) WebServletContextListener.getApplicationContext().getBean("gestionCorreo");
		}
		return gestionCorreo;
	}
}
