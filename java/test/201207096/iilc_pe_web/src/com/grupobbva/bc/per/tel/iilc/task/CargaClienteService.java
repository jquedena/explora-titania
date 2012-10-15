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
public class CargaClienteService {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ICargaDAO iCargaDAO;

	@Autowired
	public void setICargaDAO(ICargaDAO cargaDAO) {
		iCargaDAO = cargaDAO;
	}
	
	public void ejecutarCarga() {
		
		Mensajero mensajero=new Mensajero();
		Calendar hoy = Calendar.getInstance();
		String fecha= Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+ Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+ hoy.get(Calendar.YEAR)
						+" "+Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+":" + Utilitario.dosCeros(hoy.get(Calendar.MINUTE));

		try {
			Tiilc_adm_carga_archivo bean=iCargaDAO.obtenerCargaDelDia(Constantes.CODIGO_LCONDUCC, fecha);
			
			if(bean!=null && bean.getId_estado()==Constantes.ID_ESTADO_CARGA_PENDIENTE){ 
				mensajero.enviarCorreo(Constantes.CODIGO_LCONDUCC,Constantes.ESTADO_CARGA_INICIO, fecha);
				
				iCargaDAO.lanzarCargaCliente(bean.getId_registro());
				bean=iCargaDAO.obtenerCargaPorID(bean.getId_registro());
				Thread.sleep(120000);
				
				hoy = Calendar.getInstance();
				fecha= Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"-"+ Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"-"+ hoy.get(Calendar.YEAR)
					+" "+Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+":" + Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
				
				if(bean.getArchivo_carga() == Constantes.ESTADO_ARCHIVO_CARGA_EXITO){
					iCargaDAO.actualizarCargaArchivo((int) bean.getId_registro(),Constantes.ID_ESTADO_CARGA_FIN);
					mensajero.enviarCorreo(Constantes.CODIGO_LCONDUCC,Constantes.ESTADO_CARGA_FIN, fecha);
				}else{
					iCargaDAO.actualizarCargaArchivo((int) bean.getId_registro(), Constantes.ID_ESTADO_CARGA_ERROR);
					mensajero.enviarCorreo(Constantes.CODIGO_LCONDUCC,Constantes.ESTADO_CARGA_ERROR, fecha);
				}
			}
			
		} catch (Exception e) {
			mensajero.enviarCorreo(Constantes.CODIGO_LCONDUCC,Constantes.ESTADO_CARGA_ERROR, fecha);
			logger.error("Error en proceso de carga LCONDUCC : " + e.getMessage());
		} 
	}
}
