package com.indra.pe.bbva.reauni.mail;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.mail.CorreoElectronico;
import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.EstadoSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaInvolucradoDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;
import com.indra.pe.bbva.reauni.view.helper.SessionHelper;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

@SuppressWarnings({"rawtypes", "unused"})
@Service("gestionCorreo")
public class GestionCorreo {

	private static Logger logger = Logger.getLogger(GestionCorreo.class);
	public static String CONTRATO_NO_RECEPCIONADOS = "ContratosNoRecepcionados.html";
	public static String CONTRATO_RECEPCIONADOS = "ContratosRecepcionados.html";
	public static String RECHAZO_APROBACION = "Solicitud.html";
	public static String SILENCIO_ADMINISTRATIVO = "SilencioAdministrativo.html";
	
	private DAOGenerico<SolicitudDto> daoTarea;
	
	@SuppressWarnings("unchecked")
	public DAOGenerico<SolicitudDto> getDaoTarea() {
		if(daoTarea ==  null){
			daoTarea = (DAOGenerico<SolicitudDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoTarea;
	}
	
	public GestionCorreo() {
	}

	public void lanzarTipoCorreo(SolicitudDto solicitudDto,	TipoCorreoEnum vTipoCorreoEnum, ContratoDto contratoDto) throws Exception {
		CorreoElectronico correoElectronico;
		switch (vTipoCorreoEnum) {

		case EVALUACION:
			correoElectronico = new CorreoElectronico();
			correoElectronico.enviar(obtenerCorreoEvaluacion(solicitudDto));
			break;

		case CONTRATO_OBSERVADO:
			correoElectronico = new CorreoElectronico();
			correoElectronico.enviar(obtenerCorreoContratosObservados(solicitudDto, contratoDto));
			break;

		case RECHAZO_APROBACION:
			correoElectronico = new CorreoElectronico();
			correoElectronico.enviar(obtenerCorreoRechazoAprobacion(solicitudDto));
			break;
		case GESTION_FILE:
			correoElectronico = new CorreoElectronico();
			correoElectronico.enviar(obtenerCorreoGestionFileCourier(solicitudDto));
			break;
		case ANULACION_GESTION_FILE:
			if(getFechaAprobacionRechazo(solicitudDto).length() > 0) {
				correoElectronico = new CorreoElectronico();
				correoElectronico.enviar(obtenerCorreoAnulacionGestionFileCourier(solicitudDto));
			}
			break;
		}
	}

	public Correo obtenerCorreoEvaluacion(SolicitudDto s) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto("EVALUAR SOLICITUD DE " + s.getTipoDto().getDescripcion() + " " + s.getCodigoSolicitud());
		beanCorreo.setMensaje(" Se pone en conocimiento la solicitud de " + s.getTipoDto().getDescripcion().toLowerCase() + " N° " + s.getCodigoSolicitud() + " para su respectiva evaluación.<br><br>CC: GT/GR/JPN Involucrados.");
		beanCorreo.setFrom(s.getResponsableSolicitanteDesc());
		beanCorreo.setEmailFrom(s.getEmailSolicitante());
		beanCorreo.setListaTo(obtenerToEmailPorSolicitud(s));
		beanCorreo.setFileName("Solicitud.html");
		beanCorreo.setMensajeAdjunto(FormatoMensajeCorreo.formatoCorreoEvaluacion(s, false));

		return beanCorreo;
	}

	public Correo obtenerCorreoAnulacionGestionFileCourier(SolicitudDto s) {		
		String email = "";
		if (ApplicationHelper.obtenerParametroPorId(1082L) != null) {
			email = ApplicationHelper.obtenerParametroPorId(1082L).getValorCadena();
		}
				
		Correo beanCorreo = new Correo();
		beanCorreo.setListaTo(email);
		beanCorreo.setAsunto(" Gestión de Files – Solicitud N° " + s.getCodigoSolicitud() + " Anulada ");
		beanCorreo.setMensaje(" Estimados,<br>"
		+ " La solicitud N° " + s.getCodigoSolicitud() + " fue anulada el " + getFechaAnulacion(s)
		+ " por el solicitante, por lo cual se les pide cancelar el traslado de file.<br>"
		+ " Saludos Cordiales,<br> " + " DESARROLLO COMERCIAL");
		
		return beanCorreo;
	}
	
	@SuppressWarnings("unchecked")
	public Correo obtenerCorreoGestionFileCourier(SolicitudDto s) {

		String email = "";
		if (ApplicationHelper.obtenerParametroPorId(1082L) != null) {
			email = ApplicationHelper.obtenerParametroPorId(1082L).getValorCadena();
		}
		
		String _GOF = "";
		List<OficinaInvolucradoDto> listaInvolucrado;
		List<OficinaSolicitudDto> listaOficinaSolicitud = s.getListaOficinasSolicitud();
		for(OficinaSolicitudDto o : listaOficinaSolicitud) {
			if(o.getTipoOficina().compareTo(1032L) == 0) {
				listaInvolucrado = o.getListaInvolucrados();
				for(OficinaInvolucradoDto inv : listaInvolucrado) {
					if(inv.getCargo().equalsIgnoreCase("B21")) {
						_GOF = inv.getInvolucradoDto().getNombres() + " " + inv.getInvolucradoDto().getApellidoPaterno() + " " + inv.getInvolucradoDto().getApellidoMaterno(); 
						break;
					}
				}
				break;
			}
		}
		
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" Gestión de Files – Solicitud N° " + s.getCodigoSolicitud() + " Aprobada ");
		beanCorreo.setMensaje(" Estimados,<br>"
		+ " La solicitud N° " + s.getCodigoSolicitud() + " fue aprobada el " + getFechaAprobacionRechazo(s)
		+ " por los involucrados, por lo cual se les adjunta  todos los contratos de la misma para gestionar la recepción de files con el gestor " 
		+ s.getGestorReceptorDto().getNomGestor() + " o en su defecto con el GOF "
		+ _GOF
		+ " de la oficina receptora.<br>"
		+ " Saludos Cordiales,<br> " + " DESARROLLO COMERCIAL");

		beanCorreo.setListaTo(email);
		beanCorreo.setFileName("Contratos");
		String sql = "SELECT t.id, t.des_oficina, t.des_oficina_receptor, t.nom_gestor, t.producto, "
			+ "t.codigo_contrato, t.fecha_apertura, t.saldod, t.saldoa, t.tipo_prestamo, t.situacion "
			+ "FROM reauni.vreauni_envio_gestion_files t WHERE id = '" + s.getId() + "'";

		List listaContratos = null;
		try {
			listaContratos = getDaoTarea().ejecutarSQL(sql);
			getDaoTarea().executeProcedure("update reauni.treauni_oficina_solicitud set fecha_envio_gestion_file=sysdate where solicitud = '" + s.getId() + "' and envio_gestion_file=1 and fecha_envio_gestion_file is null");
			beanCorreo.setMensajeAdjuntoExcel(FormatoMensajeCorreo.formatoCorreoResumen(listaContratos, Constantes.CABECERA_REPORTE_GESTION_FILES, "Contratos"));
		} catch (DAOException e) {
			logger.error("Generando lista de contratos para la Gestion de Files", e);
		}

		return beanCorreo;
	}
	
	public Correo obtenerCorreoNoRecepcionFile(List<Object[]> contratos, Long dias, String email) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" Files Pendientes de Recepción ");
		beanCorreo.setMensaje(" Estimados,<br>"
		+ " Se les adjunta el reporte de todos los files de contratos que están pendientes"
		+ " de recepción por más de " + dias + " días.<br>"
		+ " Saludos Cordiales,<br> " + " DESARROLLO COMERCIAL");

		beanCorreo.setListaTo(email);
		beanCorreo.setFileName(GestionCorreo.CONTRATO_NO_RECEPCIONADOS);
		beanCorreo.setMensajeAdjuntoExcel(FormatoMensajeCorreo.formatoCorreoResumen(contratos, Constantes.CABECERA_REPORTE_GESTION_FILES, "RecepcionNoFiles"));
		if (ApplicationHelper.obtenerParametroPorId(1052L) != null) {
			String email_auditoria = ApplicationHelper.obtenerParametroPorId(1052L).getValorCadena();
			if (email_auditoria != null && !email_auditoria.equals("")) {
				beanCorreo.setListaCc(email_auditoria); // auditoria
			}
		} else {
			beanCorreo.setListaCc(""); // auditoria
		}
		return beanCorreo;
	}

	public Correo obtenerCorreoProcesamientoCorreo(String listaCorreos
			, String dia
			, List lista_unificacion
			, List lista_reasignacion) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto("Contratos Procesados de " + dia + " ");
		beanCorreo.setMensaje("Estimados Sres,<br>"
					+ " Se adjunta los reportes de la segmentación de "
					+ dia
					+ ".<br>Ahí se detallan todos los contratos procesados con sus respectivos "
					+ " datos para los fines que crean pertinentes.<br>"
					+ " Saludos Cordiales,<br>" + " DESARROLLO COMERCIAL ");

		beanCorreo.setListaTo(listaCorreos);
		beanCorreo.setMensajeAdjuntoExcel(FormatoMensajeCorreo.formatoCorreoResumen("unificacion", lista_unificacion, Constantes.CABECERA_REPORTE_UNIFICACION));
		beanCorreo.setMensajeAdjuntoExcel2(FormatoMensajeCorreo.formatoCorreoResumen("reasignacion", lista_reasignacion, Constantes.CABECERA_REPORTE_REASIGNACION));

		// Envio de email a auditoria si es que existiera registrada en la bd
		String listaCC = "";
		String email;
		
		if (ApplicationHelper.obtenerParametroPorId(1052L) != null) {
			email = ApplicationHelper.obtenerParametroPorId(1052L).getValorCadena();
			if (email != null && !email.equals("")) {
				listaCC += email; // Auditoria
			}
		}
		if (ApplicationHelper.obtenerParametroPorId(1055L) != null) {
			email = ApplicationHelper.obtenerParametroPorId(1055L).getValorCadena();
			if (email != null && !email.equals("")) {
				if(listaCC.length() > 0) listaCC += ","; 
				listaCC += email; // Operaciones
			}
		}
		
		beanCorreo.setListaCc(listaCC);
		
		return beanCorreo;
	}

	public Correo obtenerCorreoRecepcionFile(List<Object[]> contratos, String mes, String email) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" Recepción de Files por Oficina");
		beanCorreo.setMensaje(" Estimados,<br> "
		+ " Se les adjunta el reporte de files de contratos recepcionados durante el mes de "
		+ Utilitarios.Fecha.obtenerDescripcionMes(Integer.parseInt(mes)) + ".<br>" + " Saludos Cordiales,<br>"
		+ " DESARROLLO COMERCIAL");
		
		beanCorreo.setListaTo(email);
		beanCorreo.setMensajeAdjuntoExcel(FormatoMensajeCorreo.formatoCorreoResumen(contratos, Constantes.CABECERA_REPORTE_GESTION_FILES, "RecepcionFiles"));
		if (ApplicationHelper.obtenerParametroPorId(1052L) != null) {
			String email_auditoria = ApplicationHelper.obtenerParametroPorId(1052L).getValorCadena();
			if (email_auditoria != null && !email_auditoria.equals("")) {
				beanCorreo.setListaCc(email_auditoria); // auditoria
			}
		} else {
			beanCorreo.setListaCc(""); // auditoria
		}
		return beanCorreo;
	}

	public Correo obtenerCorreoRechazoAprobacion(SolicitudDto solicitudDto) {
		int temp = 0;
		String codTerr = "";
		String codOfic = "";
		StringBuffer aux1 = new StringBuffer();
		StringBuffer aux2 = new StringBuffer();
		Map<String, String> listaTerritorios = new LinkedHashMap<String, String>();
		Map<String, String> listaOficina = new LinkedHashMap<String, String>();
		Map<String, String> listaInvolucrados = new LinkedHashMap<String, String>();
		

		for (OficinaSolicitudDto os : solicitudDto.getListaOficinasSolicitud()) {
			if (os.getTipoOficinaDto().getId().compareTo(1031L) == 0 || os.getTipoOficinaDto().getId().compareTo(1032L) == 0) {
				for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
					if (oi.getEstadoDto().getId().compareTo(1034L) != 0) {
						aux1 = new StringBuffer();
						aux1.append(oi.getPerfil());
						aux1.append(" : ");
						aux1.append(oi.getInvolucradoDto().getRegistro());
						aux1.append(" - ");
						aux1.append(oi.getNombreCompleto());
						aux1.append("(");
						aux1.append(oi.getEstadoDto().getDescripcion());
						if(oi.getEstadoDto().getId().compareTo(1030L) == 0) {
							aux1.append(",");
							aux1.append(oi.getComentario().toUpperCase());
						}
						aux1.append(")");
						
						aux2 = new StringBuffer();
						if(oi.getPerfil().equalsIgnoreCase("GTE") || oi.getPerfil().equalsIgnoreCase("GR")) {
							aux2.append(os.getOficinaDto().getTerritorioDto().getCodTerritorio());
						} else {
							if(os.getTipoOficinaDto().getId().compareTo(1032L) == 0) {
								aux2.append(os.getOficinaDto().getTerritorioDto().getCodTerritorio());
							} else {
								aux2.append(os.getOficinaDto().getCodOficina());
							}
						}
						aux2.append("_");
						aux2.append(os.getTipoOficinaDto().getId());
						aux2.append("_");
						aux2.append(oi.getOrden());
						listaInvolucrados.put(aux2.toString(), aux1.toString());
						
						// Hasta encontrarle un mejor lugar
						codTerr = os.getOficinaDto().getTerritorioDto().getCodTerritorio();
						aux2 = new StringBuffer();
						aux2.append(os.getTipoOficinaDto().getId());
						aux2.append("_");
						aux2.append(codTerr);
						listaTerritorios.put(aux2.toString(), os.getOficinaDto().getTerritorioDto().getDesTerritorio());
						
						aux2 = new StringBuffer();
						aux2.append(os.getTipoOficinaDto().getId());
						aux2.append("_");
						aux2.append(codTerr);
						aux2.append("_");
						aux2.append(os.getOficinaDto().getCodOficina());
						listaOficina.put(aux2.toString(), os.getOficinaDto().getDesOficina());	
					}
				}
			}
		}

		listaTerritorios = Utilitarios.General.orderForKeysDesc(listaTerritorios);
		listaOficina = Utilitarios.General.orderForKeys(listaOficina);
		listaInvolucrados = Utilitarios.General.orderForKeys(listaInvolucrados);
		
		// logger.info(listaTerritorios);
		// logger.info(listaOficina);
		// logger.info(listaInvolucrados);
		
		aux1 = new StringBuffer();
		temp = 0;
		for(Map.Entry<String, String> k0 : listaTerritorios.entrySet()) {
			if(k0.getKey().indexOf("1032") > -1) {
				aux1.append("Oficina Receptora:  <br>");
			} else {
				if(temp == 0) {
					aux1.append("Oficinas Cedentes: <br>");
					temp = 1;
				}
			}
			aux1.append("<b>");
			aux1.append(k0.getValue());
			aux1.append("</b>");

			if(temp == 1) {
				aux1.append("<br>"); // &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			}
			
			codTerr = k0.getKey().substring(5);
			
			if(k0.getKey().indexOf("1031") > -1) {
				for(Map.Entry<String, String> k2 : listaInvolucrados.entrySet()) {
					if(k2.getKey().indexOf(codTerr + "_1031") > -1) {
						// aux1.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						aux1.append("<b>");
						aux1.append(k2.getValue());
						aux1.append("</b><br>");
					}
				}
			}
			
			for(Map.Entry<String, String> k1 : listaOficina.entrySet()) {
				if((k1.getKey().indexOf(codTerr) > -1) && ((temp == 0 && k1.getKey().indexOf("1032") > -1) || temp == 1)) {
					if(temp == 0) {
						aux1.append(" - ");
					}
					aux1.append("<b>");
					aux1.append(k1.getValue());
					
					codOfic = k1.getKey().substring(10);
					for(Map.Entry<String, String> k2 : listaInvolucrados.entrySet()) {
						if(k2.getKey().indexOf(codOfic) > -1) {
							aux1.append(" : ");
							aux1.append(k2.getValue());
						}
					}
					
					aux1.append("</b><br>");
				}
			}
			
			if(k0.getKey().indexOf("1032") > -1) {
				for(Map.Entry<String, String> k2 : listaInvolucrados.entrySet()) {
					if(k2.getKey().indexOf(codTerr + "_1032") > -1) {
						// aux1.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						aux1.append("<b>");
						aux1.append(k2.getValue());
						aux1.append("</b><br>");
					}
				}
			}
			
			aux1.append("<br><br>");
		}
		
		
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" " + solicitudDto.getTramiteSolicitudDto().getDescripcionCorta() + " DE SOLICITUD N° " + solicitudDto.getCodigoSolicitud());
		beanCorreo.setMensaje(" Estimados Sres,<br>"
				+ " La solicitud N ° "
				+ solicitudDto.getCodigoSolicitud()
				+ " fue "
				+ solicitudDto.getTramiteSolicitudDto().getDescripcion().toLowerCase()
				+ " el "
				+ getFechaAprobacionRechazo(solicitudDto)
				+ " por: <br>"
				+ aux1.toString());
		beanCorreo.setMensajeAdjunto(FormatoMensajeCorreo.formatoCorreoEvaluacion(solicitudDto));
		beanCorreo.setFileName(GestionCorreo.RECHAZO_APROBACION);
		beanCorreo.setListaTo(obtenerToEmailPorSolicitud(solicitudDto));
		beanCorreo.setListaCc(solicitudDto.getEmailSolicitante());
		return beanCorreo;
	}

	public Correo obtenerCorreoSilencioAdministrativo(
			SolicitudDto solicitudDto, String fecha_inicio, String fecha_fin) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" Silencio Administrativo en Evaluación de Solicitud N° "
						+ solicitudDto.getCodigoSolicitud());
		beanCorreo.setMensaje(" Nuevamente se les hace presente la siguiente solicitud para su respectiva "
						+ " evaluación debido a que se encuentra en  evaluación desde "
						+ fecha_inicio
						+ " Caso contrario se procederá a aplicar automáticamente El Silencio "
						+ " Administrativo el día " + fecha_fin);
		beanCorreo.setMensajeAdjunto(FormatoMensajeCorreo.formatoCorreoSilencioAdm(solicitudDto));
		beanCorreo.setFileName(GestionCorreo.SILENCIO_ADMINISTRATIVO);
		beanCorreo.setListaTo(obtenerToEmailPorSolicitud(solicitudDto));
		beanCorreo.setListaCc(solicitudDto.getEmailSolicitante());
		return beanCorreo;
	}

	private String getFechaAprobacionRechazo(SolicitudDto s) {
		String fecha = "";
		for(EstadoSolicitudDto e : s.getListaEstados()) {
			if(e.getEstadoDto().getId().compareTo(1017L) == 0 || e.getEstadoDto().getId().compareTo(1018L) == 0) {
				fecha = FormatoMensajeCorreo.formatoFecha.format(e.getFecha());
				break;
			}
		}
		return fecha;
	}
	
	private String getFechaAnulacion(SolicitudDto s) {
		String fecha = "";
		for(EstadoSolicitudDto e : s.getListaEstados()) {
			if(e.getEstadoDto().getId().compareTo(1022L) == 0) {
				fecha = FormatoMensajeCorreo.formatoFecha.format(e.getFecha());
				break;
			}
		}
		return fecha;
	}
	
	public Correo obtenerCorreoSilencioAdministrativoBatch(SolicitudDto s) {		
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto("SOLICITUD APROBADA POR SILENCIO ADMINISTRATIVO N° " + s.getCodigoSolicitud());
		beanCorreo.setMensaje("Estimados,<br/>La solicitud N° " + s.getCodigoSolicitud()+ " fue aprobada el " + getFechaAprobacionRechazo(s) + " por Silencio Administrativo. ");
		beanCorreo.setMensajeAdjunto(FormatoMensajeCorreo.formatoCorreoSilencioAdm(s));
		beanCorreo.setListaTo(obtenerToEmailPorSolicitud(s));
		beanCorreo.setListaCc(s.getEmailSolicitante());
		return beanCorreo;
	}

	/**
	 * Permitirá informar al solicitante que su contrato no pudo ser procesado.
	 * Esto se dará en casos excepcionales cuando el usuario no pudo procesar el
	 * contrato y lo ha actualizado como observado en el sistema. En este
	 * momento el sistema enviará automáticamente un correo según lo siguiente
	 * 
	 * @param solicitudDto
	 * @param contratoDto
	 * @return
	 */
	public Correo obtenerCorreoContratosObservados(SolicitudDto solicitudDto,
			ContratoDto contratoDto) {
		SessionMBean sessionMBean = (SessionMBean) WebServletContextListener.getApplicationContext().getBean("sessionMBean");
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" Contrato Observado "
				+ contratoDto.getCodigoContrato() + " ("
				+ solicitudDto.getCodigoSolicitud());
		beanCorreo.setMensaje(" Estimado Sr/Sra, <br> El contrato de la referencia no pudo ser procesado por el siguiente motivo : "
						+ contratoDto.getComentarioEstado()
						+ " <br><br><br>  Saludos Coordiales <br> OPERACIONES CENTRALIZADAS");
		beanCorreo.setEmailFrom(sessionMBean.getEmail());
		beanCorreo.setListaTo(solicitudDto.getEmailSolicitante());
		String email_operaciones = ApplicationHelper.obtenerParametroPorId(1055L).getValorCadena();
		if (email_operaciones != null && !email_operaciones.equals("")) {
			beanCorreo.setListaCc(email_operaciones);
		}
		beanCorreo.setListaCc("");
		return beanCorreo;
	}

	private String obtenerToEmailPorSolicitud(SolicitudDto solicitudDto) {
		if(SessionHelper.getModoDebug()) {
			return SessionHelper.getEmailDebug();
		}
		
		StringBuffer toEmail = new StringBuffer();

		for (OficinaSolicitudDto os : solicitudDto.getListaOficinasSolicitud()) {
			if (os.getListaInvolucrados() != null) {
				for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
					String email = oi.getInvolucradoDto().getEmail();
					if (email != null)
						toEmail.append(email + ",");
				}
			}
		}
		return toEmail.toString();
	}

	private String obtenerToEmailOficinasReceptorasCedentesPorSolicitud(SolicitudDto solicitudDto) {
		if(SessionHelper.getModoDebug()) {
			return SessionHelper.getEmailDebug();
		}
		
		StringBuffer toEmail = new StringBuffer();

		for (OficinaSolicitudDto os : solicitudDto.getListaOficinasSolicitud()) {
			if ((Constantes.TIPO_OFICINA_CEDENTE.equals(os.getTipoOficinaDto().getId()) ||
					Constantes.TIPO_OFICINA_RECEPTORA.equals(os.getTipoOficinaDto().getId()))
					&& os.getListaInvolucrados() != null) {
				for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
					String email = oi.getInvolucradoDto().getEmail();
					if (email != null)
						toEmail.append(email + ",");
				}
			}
		}
		
		return toEmail.toString();
	}
}
