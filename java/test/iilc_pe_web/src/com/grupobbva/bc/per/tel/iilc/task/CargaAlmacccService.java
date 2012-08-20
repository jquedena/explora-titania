package com.grupobbva.bc.per.tel.iilc.task;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.dao.ICargaDAO;
@Component
public class CargaAlmacccService {

	@Autowired
	private ICargaDAO iCargaDAO;

	@Autowired
	public void setICargaDAO(ICargaDAO cargaDAO) {
		iCargaDAO = cargaDAO;
	}
	
	
	Logger logger = Logger.getLogger(this.getClass());

	public void ejecutarCarga()
	{
		
		Calendar hoy = Calendar.getInstance();
		String fecha= Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+ Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+ hoy.get(Calendar.YEAR)
						+" "+Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+":" + Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
		
		try {
			Mensajero mensajero=new Mensajero();
			Tiilc_adm_carga_archivo bean=iCargaDAO.obtenerCargaDelDia(Constantes.CODIGO_ALMACCC, fecha); 
			if(bean!=null && bean.getId_estado() == Constantes.ID_ESTADO_CARGA_PENDIENTE){
				mensajero.enviarCorreo(Constantes.CODIGO_ALMACCC,Constantes.ESTADO_CARGA_INICIO, fecha);
				iCargaDAO.lanzarCargaAlmaccc(bean.getId_registro()); 
				bean=iCargaDAO.obtenerCargaPorID(bean.getId_registro());
				
				hoy = Calendar.getInstance();
				fecha= Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH)) + "-"
					+ Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1)) + "-" 
					+ hoy.get(Calendar.YEAR) + " "
					+ Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY)) + ":"
					+ Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
				
				if(bean.getArchivo_carga() == Constantes.ESTADO_ARCHIVO_CARGA_EXITO){
					mensajero.enviarCorreo(Constantes.CODIGO_ALMACCC,Constantes.ESTADO_CARGA_FIN, fecha);
				}else{
					mensajero.enviarCorreo(Constantes.CODIGO_ALMACCC,Constantes.ESTADO_CARGA_ERROR, fecha);
				}
				// Thread.sleep(120000); La carga dura mas de un minuto
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
		   
	
	}
}
