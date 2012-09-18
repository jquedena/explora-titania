package com.indra.pe.bbva.reauni.task.laucher;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.model.entidad.EjecucionProcesoDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.service.EjecucionProcesoBO;
import com.indra.pe.bbva.reauni.task.thread.AvisoNoRecepcionFiles;
import com.indra.pe.bbva.reauni.task.thread.AvisoProcesamientoCorreo;
import com.indra.pe.bbva.reauni.task.thread.AvisoRecepcionFiles;
import com.indra.pe.bbva.reauni.task.thread.AvisoSilencioAdministrativo;
import com.indra.pe.bbva.reauni.task.thread.RecargarObjetoCarpetasComerciales;
import com.indra.pe.bbva.reauni.task.thread.SilencioAdministrativo;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;
import com.indra.pe.bbva.reauni.view.helper.SessionHelper;

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
		
		/*SilencioAdministrativo*/
		{
			String exeSilencioAdministrativo = ApplicationHelper.obtenerParametroPorId(1061L).getValorCadena();
			if (exeSilencioAdministrativo != null) {
				if (horaActual.equalsIgnoreCase(exeSilencioAdministrativo)) {
					try {
						String nombreProceso = "TRX_SILENCIO_ADMINISTRATIVO";
						boolean validar = esValidoEjecucionProceso(nombreProceso, fechaEjecucion, horaEjecucion);
						if (validar) {						
							EjecucionProcesoDto ep = new EjecucionProcesoDto(nombreProceso, fechaEjecucion, horaEjecucion, calendario.getTime());
							insertarEjecucionProceso(ep);
							
							SilencioAdministrativo sa = new SilencioAdministrativo();
							sa.start();
						}						
					} catch (Exception e) {
						logger.error("ERROR AL LANZAR EL PROCESO SilencioAdministrativo :: ", e);
					}
				}
			} else {
				logger.error("Configuracion en parametros no válida para SilencioAdministrativo!");
			}
		}
		
		// LLAMAR A TAREAS
		String exeAvisoSilencioAdministrativo = ApplicationHelper.obtenerParametroPorId(1056L).getValorCadena();
		if (exeAvisoSilencioAdministrativo != null) {
			if (horaActual.equalsIgnoreCase(exeAvisoSilencioAdministrativo)) {
				try {
					String nombreProceso = "TRX_AVISO_SILENCIO_ADMINISTRATIVO";
					boolean validar = esValidoEjecucionProceso(nombreProceso, fechaEjecucion, horaEjecucion);
					if (validar) {						
						EjecucionProcesoDto ep = new EjecucionProcesoDto(nombreProceso, fechaEjecucion, horaEjecucion, calendario.getTime());
						insertarEjecucionProceso(ep);						
						AvisoSilencioAdministrativo av = new AvisoSilencioAdministrativo();
						av.start();
					}
					
				} catch (Exception e) {
					logger.error("ERROR AL LANZAR EL PROCESO AvisoSilencioAdministrativo :: ", e);
				}
			}
		} else {
			
			logger.error("Configuracion en parametros no válida para AvisoSilencioAdministrativo!");
		}

			String exeAvisoRecepcionFiles = ApplicationHelper.obtenerParametroPorId(1057L).getValorCadena();
			if (exeAvisoRecepcionFiles != null) {
				if (horaActual.equalsIgnoreCase(exeAvisoRecepcionFiles)) {
					if (SessionHelper.getModoDebug() || (dia<5 && sDia.equals(obtenerPrimerDiaHabil(sMes, anio+"")))) { 
						try {
							String nombreProceso = "TRX_AVISO_RECEPCION_FILES";
							boolean validar = esValidoEjecucionProceso(nombreProceso, fechaEjecucion, horaEjecucion);
							if (validar) {						
								EjecucionProcesoDto ep = new EjecucionProcesoDto(nombreProceso, fechaEjecucion, horaEjecucion, calendario.getTime());
								insertarEjecucionProceso(ep);						
								AvisoRecepcionFiles rec = new AvisoRecepcionFiles();
								rec.start();
							}
							
						} catch (Exception e) {
							logger.error("ERROR AL LANZAR EL PROCESO AvisoRecepcionFiles :: ", e);
						}	
					}
				}
			} else {
				logger.error("Configuracion en parametros no válida para AvisoRecepcionFiles!");
			}

			String exeAvisoNoRecepcionFiles = ApplicationHelper.obtenerParametroPorId(1058L).getValorCadena();
			if (exeAvisoNoRecepcionFiles != null) {
				if (horaActual.equalsIgnoreCase(exeAvisoNoRecepcionFiles)) {
					if (SessionHelper.getModoDebug() || (dia<5 && sDia.equals(obtenerPrimerDiaHabil(sMes, anio+"")))) {  
						try {
							String nombreProceso = "TRX_AVISO_NO_RECEPCION_FILES";
							boolean validar = esValidoEjecucionProceso(nombreProceso, fechaEjecucion, horaEjecucion);
							if (validar) {						
								EjecucionProcesoDto ep = new EjecucionProcesoDto(nombreProceso, fechaEjecucion, horaEjecucion, calendario.getTime());
								insertarEjecucionProceso(ep);						
								AvisoNoRecepcionFiles rec = new AvisoNoRecepcionFiles();
								rec.start();
							}
							
						} catch (Exception e) {
							logger.error("ERROR AL LANZAR EL PROCESO AvisoNoRecepcionFiles :: ", e);
						}
					}
				}
			} else {
				logger.error("Configuracion en parametros no válida para AvisoNoRecepcionFiles!");
			}

		String exeAvisoProcesamientoCorreo = ApplicationHelper.obtenerParametroPorId(1059L).getValorCadena();
		if (exeAvisoProcesamientoCorreo != null) {
			if (horaActual.equalsIgnoreCase(exeAvisoProcesamientoCorreo)) {
				try {
					String nombreProceso = "TRX_AVISO_PROCESAMIENTO_CORREO";
					boolean validar = esValidoEjecucionProceso(nombreProceso, fechaEjecucion, horaEjecucion);
					if (validar) {				
						Boolean esPrimerDiaHabil = Boolean.FALSE;
						if (dia<5 && sDia.equals(obtenerPrimerDiaHabil(sMes, anio+""))) {
							esPrimerDiaHabil = Boolean.TRUE;
						}else {
							esPrimerDiaHabil = Boolean.FALSE;
						}
						
						EjecucionProcesoDto ep = new EjecucionProcesoDto(nombreProceso, fechaEjecucion, horaEjecucion, calendario.getTime());
						insertarEjecucionProceso(ep);						
						AvisoProcesamientoCorreo rec = new AvisoProcesamientoCorreo(esPrimerDiaHabil);
						rec.start();
					}
					
				} catch (Exception e) {
					logger.error("ERROR AL LANZAR EL PROCESO AvisoProcesamientoCorreo :: ", e);
				}
			}
		} else {
			logger.error("Configuracion en parametros no válida para AvisoProcesamientoCorreo!");
		}

		String exeRecargarObjetoCarpetasComerciales = ApplicationHelper.obtenerParametroPorId(1063L).getValorCadena();
		if (exeRecargarObjetoCarpetasComerciales != null) {
			if (horaActual.equalsIgnoreCase(exeRecargarObjetoCarpetasComerciales)) {
				try {
					boolean validar = true;
					if (validar) {											
						RecargarObjetoCarpetasComerciales rec = new RecargarObjetoCarpetasComerciales();
						rec.start();
					}					
				} catch (Exception e) {
					logger.error("ERROR AL LANZAR EL PROCESO RecargarObjetoCarpetasComerciales :: ", e);
				}
			}
		} else {
			logger.error("Configuracion en parametros no válida para RecargarObjetoCarpetasComerciales!");
		}
	}
	
	public String obtenerPrimerDiaHabil (String mes, String anio) {
		DAOGenerico<SolicitudDto> daoTarea = (DAOGenerico<SolicitudDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		String sql = "SELECT REAUNI.FC_PRIMER_DIA_UTIL('"+mes+"','"+anio+"') FROM DUAL";
		String resultado = null;
		List lista_oficinas;
		try {
			lista_oficinas = daoTarea.ejecutarSQL(sql);
			for(Iterator iter=lista_oficinas.iterator();iter.hasNext();){
				StringTokenizer registro=new StringTokenizer(iter.next().toString(),"|");
				resultado = registro.nextToken();
				break;
			}
		} catch (DAOException e) {
			logger.error(e);
		}	
		
		return resultado.substring(0,2);		
	}

}
