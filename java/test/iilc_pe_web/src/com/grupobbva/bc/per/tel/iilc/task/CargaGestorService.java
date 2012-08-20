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
public class CargaGestorService {

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
			
			Tiilc_adm_carga_archivo bean=iCargaDAO.obtenerCargaDelDia(Constantes.CODIGO_GESTOR, fecha); 
			if(bean!=null && bean.getId_estado()==1){ 
				iCargaDAO.lanzarCargaGestor(bean.getId_registro());  
				Thread.sleep(120000);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
		   
	
	}
 
}
