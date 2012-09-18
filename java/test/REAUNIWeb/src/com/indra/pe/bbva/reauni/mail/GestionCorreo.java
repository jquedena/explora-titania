package com.indra.pe.bbva.reauni.mail;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.mail.CorreoElectronico;
import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaInvolucradoDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;
import com.indra.pe.bbva.reauni.view.helper.SessionHelper;

@SuppressWarnings({"rawtypes", "unused"})
@Service("gestionCorreo")
public class GestionCorreo {

	public static String CONTRATO_NO_RECEPCIONADOS = "ContratosNoRecepcionados.html";
	public static String CONTRATO_RECEPCIONADOS = "ContratosRecepcionados.html";
	public static String RECHAZO_APROBACION = "Solicitud.html";
	public static String SILENCIO_ADMINISTRATIVO = "SilencioAdministrativo.html";
	
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
		}
	}

	public Correo obtenerCorreoEvaluacion(SolicitudDto s) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto("EVALUAR SOLICITUD DE " + s.getTipoDto().getDescripcion() + " " + s.getCodigoSolicitud());
		beanCorreo.setMensaje(" Se pone en conocimiento la solicitud de " + s.getTipoDto().getDescripcion().toLowerCase() + " N� " + s.getCodigoSolicitud() + " para su respectiva evaluaci�n.<br><br>CC: GT/GR/JPN Involucrados.");
		beanCorreo.setFrom(s.getResponsableSolicitanteDesc());
		beanCorreo.setEmailFrom(s.getEmailSolicitante());
		beanCorreo.setListaTo(obtenerToEmailPorSolicitud(s));
		// beanCorreo.setListaCc(s.getEmailSolicitante());
		beanCorreo.setFileName("Solicitud.html");
		beanCorreo.setMensajeAdjunto(FormatoMensajeCorreo.formatoCorreoEvaluacion(s, false));

		return beanCorreo;
	}

	public Correo obtenerCorreoNoRecepcionFile(List<Object[]> contratos, Long dias, String email) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" Files Pendientes de Recepci�n ");
		beanCorreo.setMensaje(" Estimados,<br>"
		+ " Se les adjunta el reporte de todos los files de contratos que est�n pendientes"
		+ " de recepci�n por m�s de " + dias + " d�as.<br>"
		+ " Saludos Cordiales,<br> " + " DESARROLLO COMERCIAL");

		beanCorreo.setListaTo(email);
		beanCorreo.setFileName(GestionCorreo.CONTRATO_NO_RECEPCIONADOS);
		beanCorreo.setMensajeAdjuntoExcel(FormatoMensajeCorreo.formatoCorreoResumen(contratos, Constantes.CABECERA_REPORTE_GESTION_FILES, "RecepcionNoFiles"));
		if (ApplicationHelper.obtenerParametroPorId(1052L) != null) {
			String email_auditoria = ApplicationHelper.obtenerParametroPorId(1052L).getValorCadena();
			if (email_auditoria != null && !email_auditoria.equals("")) {
				beanCorreo.setListaCc(email_auditoria);// auditoria
			}
		} else {
			beanCorreo.setListaCc("");// auditoria
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
					+ " Se adjunta los reportes de la segmentaci�n de "
					+ dia
					+ ".<br>Ah� se detallan todos los contratos procesados con sus respectivos "
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
		beanCorreo.setAsunto(" Recepci�n de Files por Oficina");
		beanCorreo.setMensaje(" Estimados,<br> "
		+ " Se les adjunta el reporte de files de contratos recepcionados durante el mes de "
		+ Utilitarios.Fecha.obtenerDescripcionMes(Integer.parseInt(mes)) + ".<br>" + " Saludos Cordiales,<br>"
		+ " DESARROLLO COMERCIAL");
		
		beanCorreo.setListaTo(email);
		beanCorreo.setMensajeAdjuntoExcel(FormatoMensajeCorreo.formatoCorreoResumen(contratos, Constantes.CABECERA_REPORTE_GESTION_FILES, "RecepcionFiles"));
		if (ApplicationHelper.obtenerParametroPorId(1052L) != null) {
			String email_auditoria = ApplicationHelper.obtenerParametroPorId(1052L).getValorCadena();
			if (email_auditoria != null && !email_auditoria.equals("")) {
				beanCorreo.setListaCc(email_auditoria);// auditoria
			}
		} else {
			beanCorreo.setListaCc("");// auditoria
		}
		return beanCorreo;
	}

	public Correo obtenerCorreoRechazoAprobacion(SolicitudDto solicitudDto) {
		String estado = "";
		StringBuffer sbInvolucrados = new StringBuffer();

		for (OficinaSolicitudDto os : solicitudDto.getListaOficinasSolicitud()) {

			if (!os.getTipoOficinaDto().getId().equals(1033L)) {
				for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
					if (oi.getInvolucradoDto().getCargo().equals("CH1")
							|| oi.getInvolucradoDto().getCargo().equals("CH6")
							|| oi.getInvolucradoDto().getCargo().equals("OS8")) {
						if (!oi.getEstadoDto().getId().equals(1034L))
							sbInvolucrados.append(oi.getInvolucradoDto()
									.getCargo()
									+ " : "
									+ oi.getInvolucradoDto().getRegistro()
									+ "-"
									+ oi.getInvolucradoDto().getNombres()
									+ " "
									+ oi.getInvolucradoDto()
											.getApellidoPaterno()
									+ " "
									+ oi.getInvolucradoDto()
											.getApellidoMaterno()
									+ " ("
									+ oi.getEstadoDto().getDescripcion()
									+ ") <br>");
					}
				}

			}

		}

		Correo beanCorreo = new Correo();
		// "SOLICITUD APROBADA POR SILENCIO ADMINISTRATIVO"
		// solicitudDto.getTramiteSolicitudDto().getDescripcion()
		beanCorreo.setAsunto(" Rechazo/Aprobaci�n de Solicitud " + solicitudDto.getCodigoSolicitud());
		beanCorreo.setMensaje(" Estimados Sres,<br>"
				+ " Se les hace presente la siguiente solicitud que fue "
				+ solicitudDto.getTramiteSolicitudDto().getDescripcion()
				+ " por los siguientes involucrados: <br>"
				+ sbInvolucrados.toString());
		beanCorreo.setMensajeAdjunto(FormatoMensajeCorreo.formatoCorreoEvaluacion(solicitudDto));
		beanCorreo.setFileName(GestionCorreo.RECHAZO_APROBACION);
		beanCorreo.setListaTo(obtenerToEmailPorSolicitud(solicitudDto));
		beanCorreo.setListaCc(solicitudDto.getEmailSolicitante());
		return beanCorreo;
	}

	public Correo obtenerCorreoSilencioAdministrativo(
			SolicitudDto solicitudDto, String fecha_inicio, String fecha_fin) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" Silencio Administrativo en Evaluaci�n de Solicitud "
						+ solicitudDto.getCodigoSolicitud());
		beanCorreo.setMensaje(" Nuevamente se les hace presente la siguiente solicitud para su respectiva "
						+ " evaluaci�n debido a que se encuentra en  evaluaci�n desde "
						+ fecha_inicio
						+ " Caso contrario se proceder� a aplicar autom�ticamente El Silencio "
						+ " Administrativo el d�a " + fecha_fin);
		beanCorreo.setMensajeAdjunto(FormatoMensajeCorreo.formatoCorreoSilencioAdm(solicitudDto));
		beanCorreo.setFileName(GestionCorreo.SILENCIO_ADMINISTRATIVO);
		beanCorreo.setListaTo(obtenerToEmailPorSolicitud(solicitudDto));
		beanCorreo.setListaCc(solicitudDto.getEmailSolicitante());
		return beanCorreo;
	}

	public Correo obtenerCorreoSilencioAdministrativoBatch(
			SolicitudDto solicitudDto) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" Solicitud Aprobada por Silencio Administrativo "
				+ solicitudDto.getCodigoSolicitud());
		beanCorreo.setMensaje(" La solicitud ha sido aprobada por el proceso de Silencio Administrativo. ");
		beanCorreo.setMensajeAdjunto(FormatoMensajeCorreo.formatoCorreoSilencioAdm(solicitudDto));
		beanCorreo.setListaTo(obtenerToEmailPorSolicitud(solicitudDto));
		beanCorreo.setListaCc(solicitudDto.getEmailSolicitante());
		return beanCorreo;
	}

	/**
	 * Permitir� informar al solicitante que su contrato no pudo ser procesado.
	 * Esto se dar� en casos excepcionales cuando el usuario no pudo procesar el
	 * contrato y lo ha actualizado como observado en el sistema. En este
	 * momento el sistema enviar� autom�ticamente un correo seg�n lo siguiente
	 * 
	 * @param solicitudDto
	 * @param contratoDto
	 * @return
	 */
	public Correo obtenerCorreoContratosObservados(SolicitudDto solicitudDto,
			ContratoDto contratoDto) {
		Correo beanCorreo = new Correo();
		beanCorreo.setAsunto(" Contrato Observado "
				+ contratoDto.getCodigoContrato() + " ("
				+ solicitudDto.getCodigoSolicitud());
		beanCorreo.setMensaje(" Estimado Sr/Sra, <br> El contrato de la referencia no pudo ser procesado por el siguiente motivo : "
						+ contratoDto.getComentarioEstado()
						+ " <br><br><br>  Saludos Coordiales <br> OPERACIONES CENTRALIZADAS");
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

	/*private InternetAddress[] obtenerToEmailPorSolicitudInit(SolicitudDto solicitudDto) throws AddressException {

		List<String> correos = new ArrayList<String>();
		for (OficinaSolicitudDto os : solicitudDto.getListaOficinasSolicitud()) {
			if (os.getListaInvolucrados() != null) {
				for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
					String email = oi.getInvolucradoDto().getEmail();
					if (email != null)
						correos.add(email);
				}
			}

		}

		InternetAddress lista[] = new InternetAddress[correos.size()];
		int i = 0;
		for (String s : correos) {
			lista[i++] = new InternetAddress(s);
		}
		return lista;
	}*/

}
