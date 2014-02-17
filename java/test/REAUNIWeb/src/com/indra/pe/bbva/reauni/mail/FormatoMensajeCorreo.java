package com.indra.pe.bbva.reauni.mail;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;

@SuppressWarnings({"unused", "rawtypes"})
public class FormatoMensajeCorreo {
	
	private static Logger logger = Logger.getLogger(FormatoMensajeCorreo.class);
	public static SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
	public static DecimalFormat formatoNumero = new DecimalFormat("###,###,##0.00");
	
	public static File archivoNuevo(String ruta, String nombre) {
		File f = null;
		try {
			f = new File(ruta, nombre);
			f.createNewFile();
		} catch (Exception e) {
			logger.error("Error en utilitario ", e);
		}
		return f;
	}
	
	public static File formatoCorreoResumen(List<Object[]> lista, String cabecera, String fileName){
		try {
			String path = ApplicationHelper.obtenerParametroPorId(1065L).getValorCadena();
			String file = fileName.toUpperCase()+".xls";
			File my_file = archivoNuevo(path, file);
			WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(my_file);

			WritableFont fuenteCelda = null;
			WritableCellFormat formatoCelda = null;
			WritableSheet sheet = workbook.createSheet(fileName.toUpperCase(), 0);
			
			// Imprimiendo Titulos
			fuenteCelda = new WritableFont(WritableFont.createFont("Calibri"), 8, WritableFont.BOLD, false,UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.DARK_BLUE);
			formatoCelda.setAlignment(Alignment.CENTRE);
			formatoCelda.setVerticalAlignment(VerticalAlignment.TOP);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.NONE);

			StringTokenizer cabecera_array = new StringTokenizer(cabecera, "|");
			int columnas=0;
			while(cabecera_array.hasMoreTokens()){
				Label label;
				label = new Label(columnas, 0, cabecera_array.nextToken() , formatoCelda);
				sheet.addCell(label);
				columnas++;
			}
			
			CellView cv = new CellView();
			// Anchos de columnas
			for (int j = 0; j < columnas ; j++) {
				cv = sheet.getColumnView(j);
				cv.setAutosize(true);
				sheet.setColumnView(j, cv);
			}
			
			fuenteCelda = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.WHITE);
			formatoCelda.setAlignment(Alignment.GENERAL);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			int fila=1;
			if(lista != null) {
				Object[] registro = null;
				String value = null;
				int columnas_registro = 0;
				for(Iterator<Object[]> iter=lista.iterator();iter.hasNext();){
					registro = iter.next();
					for(columnas_registro = 0; columnas_registro < registro.length; columnas_registro++) {
						value = "";
						if(registro[columnas_registro] != null) {
							value = registro[columnas_registro].toString();
						}
						Label label;
						label = new Label(columnas_registro, fila, value, formatoCelda);
						sheet.addCell(label);
					}
					fila++;
				}
			}
			
			workbook.write();
			workbook.close();
			return my_file;
		} catch (Exception e) {
			logger.error("Generando excel... " , e);
			return null;
		}
	}
	
	public static File formatoCorreoResumen(String tipo, List lista, String cabecera){
		try {
			String path = ApplicationHelper.obtenerParametroPorId(1065L).getValorCadena();
			Calendar hoy = Calendar.getInstance();
			String file = tipo.toUpperCase()+".xls";
			File my_file = archivoNuevo(path, file);
			WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(my_file);

			WritableFont fuenteCelda = null;
			WritableCellFormat formatoCelda = null;
			WritableSheet sheet = workbook.createSheet(tipo.toUpperCase(), 0);
			
			// Imprimiendo Titulos
			fuenteCelda = new WritableFont(WritableFont.createFont("Calibri"), 8, WritableFont.BOLD, false,UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.DARK_BLUE);
			formatoCelda.setAlignment(Alignment.CENTRE);
			formatoCelda.setVerticalAlignment(VerticalAlignment.TOP);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.NONE);

			StringTokenizer cabecera_array = new StringTokenizer(cabecera, "|");
			int columnas=0;
			while(cabecera_array.hasMoreTokens()){
				Label label;
				label = new Label(columnas, 0, cabecera_array.nextToken() , formatoCelda);
				sheet.addCell(label);
				columnas++;
			}
			
			CellView cv = new CellView();
			// Anchos de columnas
			for (int j = 0; j < columnas ; j++) {
				cv = sheet.getColumnView(j);
				cv.setAutosize(true);
				sheet.setColumnView(j, cv);
			}
			
			fuenteCelda = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.WHITE);
			formatoCelda.setAlignment(Alignment.GENERAL);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			int fila=1;
			if(lista != null) {
				for(Iterator iter=lista.iterator();iter.hasNext();){
					String registro=(String)iter.next();
					StringTokenizer registro_array=new StringTokenizer(registro,"|");
					int columnas_registro=0;
					while(registro_array.hasMoreTokens()){
						Label label;
						label = new Label(columnas_registro, fila, registro_array.nextToken() , formatoCelda);
						sheet.addCell(label);
						columnas_registro++;
					}
					fila++;
				}
			}
			
			workbook.write();
			workbook.close();
			return my_file;
		} catch (Exception e) {
			logger.error("Generando excel... " , e);
			return null;
		}
	}	
	
	public static String formatoCorreoEvaluacion(SolicitudDto s){
		return FormatoMensajeCorreo.formatoCorreoEvaluacion(s, true);
	}
	
	public static String formatoCorreoEvaluacion(SolicitudDto s, boolean gestionFile){
		
		String ajusteBonificacion = "";
		String ajusteBonificacionDesc = "";
		
		if (s.getTipoDto().getId().equals(1006L)) { //unificacion / bonificacion
			ajusteBonificacion = "Bonificaci&oacute;n";
			if (s.getBonificacionNoExcede7Dias()) {
				ajusteBonificacionDesc += ApplicationHelper.obtenerParametroPorId(1048L).getValorCadena().toUpperCase().replaceAll("Ó", "&Oacute;")+ "<br/>";
			}
			if (s.getBonificacion2()) {
				ajusteBonificacionDesc += ApplicationHelper.obtenerParametroPorId(1076L).getValorCadena().toUpperCase().replaceAll("Ó", "&Oacute;") + "<br/>";
			}
			if (s.getBonificacionOtros()){
				ajusteBonificacionDesc += "OTROS :" +s.getBonificacionComentarios();
			}
			if(!s.getMostrarDeclaracionJurada()) {
				ajusteBonificacionDesc += "NO SE SELECCION&Oacute;.";
			}
		}else if (s.getTipoDto().getId().equals(1007L)){ //reunificacion / ajustes
			ajusteBonificacion = "Ajustes";
			if (s.getAjusteFormaGrupo()) {
				ajusteBonificacionDesc += ApplicationHelper.obtenerParametroPorId(1050L).getValorCadena().toUpperCase().replaceAll("Ó", "&Oacute;") + "<br/>";
			}
			if (s.getAjusteVentaUltimo()){
				ajusteBonificacionDesc += ApplicationHelper.obtenerParametroPorId(1073L).getValorCadena().toUpperCase() .replaceAll("Ó", "&Oacute;")+ "<br/>";
			}
			if (s.getAjusteOtros()){
				ajusteBonificacionDesc += "OTROS : "+s.getAjusteComentarios();
			}
			if(!s.getMostrarDeclaracionJurada()) {
				ajusteBonificacionDesc += "NO SE SELECCION&Oacute;.";
			}
		}
		
		String motivo = "";
		
		if (s.getMotivoTrasladoDto().getId().equals(1026L)) { // Si es otros
			motivo = s.getMotivoComentarios();
		}else {
			motivo = s.getMotivoTrasladoDto().getDescripcion();
		}
		
		StringBuffer mensaje = new StringBuffer();
		mensaje.append("<html>");
		mensaje.append("<head>");
		mensaje.append("	<style>");
		mensaje.append("		* {");
		mensaje.append("			font-size: 100%;");
		mensaje.append("			font-family: Tahoma, Lucida Grande, Lucida Sans, Arial, sans-serif;");
		mensaje.append("			letter-spacing: .03em;");
		mensaje.append("		}");
		mensaje.append("		body {");
		mensaje.append("			font-size: 0.7em;");
		mensaje.append("			overflow: auto;");
		mensaje.append("			padding: 4px;");
		mensaje.append("			margin: 4px;");
		mensaje.append("		}");
		mensaje.append("		  table.dataTable tr td");
		mensaje.append("		, table.dataTable tr th");
		mensaje.append("		, table.dataTable tr td.last");
		mensaje.append("		, table.dataTable tr th.last");
		mensaje.append("		, table.dataTable tr.last td");
		mensaje.append("		, table.dataTable tr.last th {");
		mensaje.append("			border-left:1px solid #000;");
		mensaje.append("			border-top:1px solid #000;");
		mensaje.append("			padding:2px;");
		mensaje.append("			margin:2px;");
		mensaje.append("		}");
		mensaje.append("		  table.dataTable tr td.last");
		mensaje.append("		, table.dataTable tr th.last {");
		mensaje.append("			border-right:1px solid #000;");
		mensaje.append("		}");
		mensaje.append("		  table.dataTable tr.last td");
		mensaje.append("		, table.dataTable tr.last th {");
		mensaje.append("			border-bottom:1px solid #000;");
		mensaje.append("		}");
		mensaje.append("	</style>");
		mensaje.append("</head>");
		mensaje.append("<body style='{font-size: 0.7em;overflow: auto;padding: 4px;margin: 4px;}'>");
		mensaje.append("<hr/>");
		mensaje.append("<b style='font-size: 115%;'><center>SOLICITUD DE ");
		mensaje.append(s.getTipoDto().getDescripcion().toUpperCase());
		mensaje.append("</center></b>");
		mensaje.append("<hr/>");
		mensaje.append("<br>");
		mensaje.append("<table>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Tipo&nbsp;Sol.</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>" + s.getTipoDto().getDescripcion() + "</b></td>");
		mensaje.append("		<td>Cod.Solicitud</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>" + s.getCodigoSolicitud() + "</b></td>");
		mensaje.append("		<td>Fecha&nbsp;Registro</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>" + FormatoMensajeCorreo.formatoFecha.format(s.getFechaCreacion()) + "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Cod.Cliente</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>" + s.getCodigoCliente() + "</b></td>");
		mensaje.append("		<td>Nombre</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>" + s.getNombreCliente() + "</b></td>");
		mensaje.append("		<td>Segmento</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>" + s.getSegmentoCliente()+ "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Estado&nbsp;Trámite</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>" + s.getListaEstados().get(s.getListaEstados().size()-1).getEstadoDto().getDescripcion() + "</b></td>");
		mensaje.append("		<td>Desde</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>" + FormatoMensajeCorreo.formatoFecha.format(s.getFechaModificacion()) + "</b></td>");
		mensaje.append("		<td colspan=2>&nbsp;</td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Centro&nbsp;Solicitante</td>");
		mensaje.append("		<td colspan=5>&nbsp;:&nbsp;&nbsp;<b>" + s.getOficinaSolicitante() + "-" + s.getOficinaSolicitanteDesc() + "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Resp.Solicitante</td>");
		mensaje.append("		<td colspan=5>&nbsp;:&nbsp;&nbsp;<b>" + s.getResponsableSolicitante() + "-" + s.getResponsableSolicitanteDesc() + "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Total&nbsp;Activo</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>S/." + FormatoMensajeCorreo.formatoNumero.format(s.getTotalActivo()) + "</b></td>");
		mensaje.append("		<td>Total&nbsp;Pasivo</td>");
		mensaje.append("		<td>&nbsp;:&nbsp;&nbsp;<b>S/." + FormatoMensajeCorreo.formatoNumero.format(s.getTotalPasivo()) + "</b></td>");
		mensaje.append("		<td colspan=2>&nbsp;</td>");
		mensaje.append("	</tr>");
		mensaje.append("</table>");
		mensaje.append("<br/>");
		mensaje.append("<hr/>");
		mensaje.append("<b style='font-size: 115%;'>INGRESO DE DATOS:</b>");
		mensaje.append("<hr/>");
		mensaje.append("<table>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Oficina Propietaria</td><td>&nbsp;:&nbsp;&nbsp;<b>" + s.getOficinaPrincipalCliente() + "-" + s.getOficinaPrincipalClienteDesc() + "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Territorio(*)</td><td>&nbsp;:&nbsp;&nbsp;<b>" + s.getTerritorioReceptorDto().getCodTerritorio() + "-" + s.getTerritorioReceptorDto().getDesTerritorio() + "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Oficina Receptora de los Contratos(*)</td><td>&nbsp;:&nbsp;&nbsp;<b>" + s.getOficinaReceptorDto().getCodOficina() + "-" + s.getOficinaReceptorDto().getDesOficina() + "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Gestor Receptor(*)</td><td>&nbsp;:&nbsp;&nbsp;<b>" + s.getGestorReceptorDto().getCodGestor() + " " + s.getGestorReceptorDto().getNomGestor() + " " + s.getGestorReceptorDto().getRegGestor()+ "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>" + ajusteBonificacion + "</td><td>&nbsp;:&nbsp;&nbsp;<b>" + ajusteBonificacionDesc + "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("	<tr>");
		mensaje.append("		<td>Motivo del Traslado</td><td>&nbsp;:&nbsp;&nbsp;<b>" + motivo + "</b></td>");
		mensaje.append("	</tr>");
		mensaje.append("</table>");
		mensaje.append("<br/>");
		mensaje.append("<hr/>");
		mensaje.append("<b style='font-size: 115%;'>CONTRATOS A SEGMENTAR:</b>");
		mensaje.append("<hr/>");
		mensaje.append("<table class='dataTable' cellpadding=0 cellspacing=0>");
		mensaje.append("	<tr>");
		if(gestionFile) {
			mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>EST. SEG.</th>");
			mensaje.append("		<th>EST. FILE</th>");
		}
		mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>OF.CEDE.</th>");
		mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>OF.RECE.</th>");
		mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>GES.RECE</th>");
		mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>C.PROD.</th>");
		mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>CONTRATO</th>");
		mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>F.APER.</th>");
		mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>TOTAL ACTIVO</th>");
		mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>TOTAL PASIVO</th>");
		mensaje.append("		<th style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>TIP. PRESTAMO</th> ");
		mensaje.append("		<th class='last' style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;border-right:1px solid #000;'>DET. SITUACION</th> ");
		mensaje.append("	</tr>");
		
		BigDecimal totalActivo = BigDecimal.ZERO;
		BigDecimal totalPasivo = BigDecimal.ZERO;
		
		for (OficinaSolicitudDto row : s.getListaOficinasSolicitud()) {
			if (row.getTipoOficinaDto().getId().equals(1031L) && (row.getListaContratos()!=null && row.getListaContratos().size()!=0) ) {
				for (ContratoDto col : row.getListaContratos()) {
					mensaje.append("<tr>");
					if(gestionFile) {
						mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>" + col.getEstadoDto().getDescripcion() + "</td>");
						mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>" + (col.getEstadoFile() ? "PROCESADO" : "PENDIENTE") + "</td>");
					}
					mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>" + row.getOficinaDto().getCodOficina() + " " + row.getOficinaDto().getDesOficina() + "</td>");
					mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>" + s.getOficinaReceptorDto().getCodOficina() + "-" + s.getOficinaReceptorDto().getDesOficina() + "</td>");
					mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>" + s.getGestorReceptorDto().getCodGestor() + "-" + s.getGestorReceptorDto().getNomGestor() + "</td>");
					mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>" + col.getProductoDto().getCodProd() + "-" + col.getProductoDto().getDescProd() + "</td>");
					mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>" + col.getCodigoContrato() + "</td>");
					mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;' align='center'>" + col.getFechaApertura() + "</td>");
					mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;' align='right'>S/." + FormatoMensajeCorreo.formatoNumero.format(col.getTotalActivo()) + "</td>");
					mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;' align='right'>S/." + FormatoMensajeCorreo.formatoNumero.format(col.getTotalPasivo()) + "</td>");
					mensaje.append("<td style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>&nbsp;" + col.getTipoPrestamoDto().getDescripcion() + "</td>");
					mensaje.append("<td class='last' style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;border-right:1px solid #000;'>" + col.getDescripcionSituacion() + "</td>");
					mensaje.append("</tr>");
					totalActivo=totalActivo.add(col.getTotalActivo());
					totalPasivo=totalPasivo.add(col.getTotalPasivo());
				}
			}
		}
		mensaje.append("<tr>");
		if(gestionFile) {
			mensaje.append("<td style='border-left: 0px;border-top:1px solid #000;padding:2px;margin:2px;'>&nbsp;</td>");
			mensaje.append("<td style='border-left: 0px;border-top:1px solid #000;padding:2px;margin:2px;'>&nbsp;</td>");
		}
		mensaje.append("<td style='border-left: 0px;border-top:1px solid #000;padding:2px;margin:2px;' colspan=5>&nbsp;</td>");
		mensaje.append("<td style='border-bottom:1px solid #000;border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'><b>Total</b></td>");
		mensaje.append("<td style='border-bottom:1px solid #000;border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;' align='right'><b>S/." + FormatoMensajeCorreo.formatoNumero.format(totalActivo) + "</b></td>");
		mensaje.append("<td style='border-bottom:1px solid #000;border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;' align='right'><b>S/." + FormatoMensajeCorreo.formatoNumero.format(totalPasivo) + "</b></td>");
		mensaje.append("<td colspan=2 style='border-left:1px solid #000;border-top:1px solid #000;padding:2px;margin:2px;'>&nbsp;</td>");
		mensaje.append("</tr>");
		
		mensaje.append("</table>");
		mensaje.append("</body>");
		mensaje.append("</html>");
		
		return mensaje.toString();
	}
	
	public static String formatoCorreoSilencioAdm(SolicitudDto solicitudDto){
		return FormatoMensajeCorreo.formatoCorreoEvaluacion(solicitudDto);
	}
	
	public static String adjuntoCorreoEvaluacion (SolicitudDto solicitudDto) {
		StringBuffer sb = new StringBuffer();
		sb.append("=======================================================================================================\n");
		sb.append("  									Solicitud de Reasignación/Unifiación						   \n");
		sb.append("												     												   \n");
		return sb.toString();	
	}
}
