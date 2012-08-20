package com.grupobbva.bc.per.tel.iilc.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.dao.ICargaDAO;

@Component
public class CargaColectivoPHService {

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
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = formatter.format(hoy.getTime());
		String fechaHHMM = Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH)) + "-"
			+ Utilitario.dosCeros((hoy.get(Calendar.MONTH) + 1)) + "-"
			+ hoy.get(Calendar.YEAR) + " "
			+ Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY)) + ":"
			+ Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
		
		try {
			Tiilc_adm_carga_archivo bean = iCargaDAO.obtenerHoraCarga("10", fechaHHMM);
			
			if(bean != null) {
				String fecha_dia = iCargaDAO.sp_calcular_dia(); 
				int id_Colectivo_ph = Integer.parseInt(Constantes.CODIGO_PH); // Codigo definido en el script de insert
				bean = iCargaDAO.obtenerCargaPorID(id_Colectivo_ph);
				if(fecha.equals(fecha_dia) && bean.getId_estado() == Constantes.ID_ESTADO_CARGA_PENDIENTE){
					iCargaDAO.lanzarCargaColectivo(id_Colectivo_ph);  
					Thread.sleep(120000);
					iCargaDAO.actualizarCargaArchivo(id_Colectivo_ph, Constantes.ID_ESTADO_CARGA_PENDIENTE);
				}
			}
		} catch (Exception e) {
			logger.error("ejecutarCarga", e);
		} 
	}
}
