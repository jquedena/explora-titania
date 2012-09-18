package com.indra.pe.bbva.reauni.task.laucher;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.model.entidad.EjecucionProcesoDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.service.EjecucionProcesoBO;
import com.indra.pe.bbva.reauni.task.thread.CargaDiaria;
import com.indra.pe.bbva.reauni.task.thread.EvaluaContratosObservados;
import com.indra.pe.bbva.reauni.task.thread.GeneracionReporte;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;

@SuppressWarnings({"unchecked", "rawtypes"})
public class GestionadorTareas {

	private static Logger logger = Logger.getLogger(GestionadorTareas.class);
	
	private boolean esValidoEjecucionProceso (String nombreProceso,String fechaEjecucion, String horaEjecucion) {
		boolean retorno = false;		
		EjecucionProcesoBO ejecucionProcesoBO = (EjecucionProcesoBO) WebServletContextListener.getApplicationContext().getBean("ejecucionProcesoBO");
		List<EjecucionProcesoDto> lista = ejecucionProcesoBO.obtenerEjecuciones(nombreProceso, fechaEjecucion,horaEjecucion);
		
		if (lista!=null && lista.size()>0) {
			retorno = false;
		}else {
			retorno = true;
		}		
		return retorno;
	}
	
	private void insertarEjecucionProceso (EjecucionProcesoDto ejecucionProcesoDto) {
		EjecucionProcesoBO ejecucionProcesoBO = (EjecucionProcesoBO) WebServletContextListener.getApplicationContext().getBean("ejecucionProcesoBO");
		ejecucionProcesoBO.insertar(ejecucionProcesoDto);
	}

	public void configuracion() {
		Calendar calendario = Calendar.getInstance();
		int hora = calendario.get(Calendar.HOUR_OF_DAY);
		int min = calendario.get(Calendar.MINUTE);
		int seg = calendario.get(Calendar.SECOND);
		String hAct = String.valueOf(hora);
		String mAct = String.valueOf(min);
		String sAct = String.valueOf(seg);
		if (hora < 10) {
			hAct = "0" + String.valueOf(hAct);
		}
		if (min < 10) {
			mAct = "0" + String.valueOf(mAct);
		}
		if (seg < 10) {
			sAct = "0" + String.valueOf(sAct);
		}
		
		String horaActual = hAct + ":" + mAct;
		
		int dia=calendario.get(Calendar.DAY_OF_MONTH);
		int mes=calendario.get(Calendar.MONTH)+1;
		int anio=calendario.get(Calendar.YEAR);
		String sDia = String.valueOf(dia);
		String sMes = String.valueOf(mes);
		if (dia<10) sDia="0"+dia;
		if (mes<10) sMes="0"+mes;
		String fechaEjecucion = sDia+"/"+sMes+"/"+anio;
		String horaEjecucion = hAct + ":" + mAct;
		
		/* CargaDiaria */
		String exeCargaDiaria = ApplicationHelper.obtenerParametroPorId(1060L).getValorCadena();
		
		if (exeCargaDiaria != null) {
			if (horaActual.equalsIgnoreCase(exeCargaDiaria)) {
				try {
					String nombreProceso = "TRX_CARGA_DIARIA_ARCHIVOS_MIS";
					boolean validar = esValidoEjecucionProceso(nombreProceso, fechaEjecucion, horaEjecucion);
					if (validar) {						
						EjecucionProcesoDto ep = new EjecucionProcesoDto(nombreProceso, fechaEjecucion, horaEjecucion, calendario.getTime());
						insertarEjecucionProceso(ep);						
						CargaDiaria cargaDiaria = new CargaDiaria();
						cargaDiaria.start();
					}
				} catch (Exception e) {
					logger.error("ERROR AL LANZAR EL PROCESO CargaDiaria :: ", e);
				}
			}
		} else {
			logger.error("Configuracion en parametros no válida para CargaDiaria!");
		}
		
		/*EvaluaContratosObservados*/
		{
			String exeEvaluaContratosObservados = ApplicationHelper.obtenerParametroPorId(1062L).getValorCadena();
			if (exeEvaluaContratosObservados != null) {
				if (horaActual.equalsIgnoreCase(exeEvaluaContratosObservados)) {
					try {
						String nombreProceso = "TRX_EVALUACION_CONTRATOS_OBS";
						boolean validar = esValidoEjecucionProceso(nombreProceso, fechaEjecucion, horaEjecucion);
						if (validar) {
							EjecucionProcesoDto ep = new EjecucionProcesoDto(nombreProceso, fechaEjecucion, horaEjecucion, calendario.getTime());
							insertarEjecucionProceso(ep);
							
							EvaluaContratosObservados sa = new EvaluaContratosObservados();
							sa.start();
						}
						
					} catch (Exception e) {
						logger.error("ERROR AL LANZAR EL PROCESO EvaluaContratosObservados :: ", e);
					}
				}
			} else {
				logger.error("Configuracion en parametros no válida para EvaluaContratosObservados!");
			}
		}
		
		/*Generacion de REportes*/
		{
			String exeGeneracionReportes = ApplicationHelper.obtenerParametroPorId(1066L).getValorCadena();
			if (exeGeneracionReportes != null) {
				if (horaActual.equalsIgnoreCase(exeGeneracionReportes)) {				
					if (ApplicationHelper.getModoDebug() || (dia<5 && sDia.equals(obtenerPrimerDiaHabil(sMes, anio + "")))) {
						try {
							String nombreProceso = "TRX_GENERACION_REPORTES";
							boolean validar = esValidoEjecucionProceso(nombreProceso, fechaEjecucion, horaEjecucion);
							if (validar) {
								EjecucionProcesoDto ep = new EjecucionProcesoDto(nombreProceso, fechaEjecucion, horaEjecucion, calendario.getTime());
								insertarEjecucionProceso(ep);							
								GeneracionReporte sa = new GeneracionReporte();
								sa.start();
							}
							
						} catch (Exception e) {
							logger.error("ERROR AL LANZAR EL PROCESO GeneracionReporte :: ", e);
						}
					}
				}
			} else {
				logger.error("Configuracion en parametros no válida para GeneracionReporte!");
			}
		}
	}
	
	public String obtenerPrimerDiaHabil (String mes, String anio) {
		DAOGenerico<SolicitudDto> daoTarea = (DAOGenerico<SolicitudDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		String sql = "SELECT TO_CHAR(REAUNI.FC_PRIMER_DIA_UTIL('"+mes+"','"+anio+"'), 'DD') FROM DUAL";
		String resultado = null;
		List lista_oficinas;
		try {
			lista_oficinas = daoTarea.ejecutarSQL(sql);
			if(lista_oficinas != null && lista_oficinas.size() > 0) {
				resultado = lista_oficinas.get(0).toString();
			}
		} catch (DAOException e) {
			logger.error("obtenerPrimerDiaHabil", e);
		}	
		
		return resultado;
		
	}
}