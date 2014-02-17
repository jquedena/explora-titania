package com.indra.pe.bbva.core.configuracion;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.util.DocumentoExcel;
import com.indra.pe.bbva.reauni.mail.FormatoMensajeCorreo;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.ContratoTemporalDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.view.mbean.ConsultaContratoFileMBean;
import com.indra.pe.bbva.reauni.view.mbean.ConsultaMBean;
import com.indra.pe.bbva.reauni.view.mbean.ReporteMBean;
import com.indra.pe.bbva.reauni.view.mbean.SolicitudMBean;

public class ExportarContratoServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ExportarContratoServlet.class);
	private String fileName = "Contratos.xls";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletOutputStream out = resp.getOutputStream();
		
		byte[] file = null;
		
		if(req.getParameter("tipo").compareToIgnoreCase("0") == 0) {
			fileName = "Contratos.xls";
			file = escribirContratoSolicitud();
		} else if(req.getParameter("tipo").compareToIgnoreCase("1") == 0) {
			file = escribirReporte();
		} else if(req.getParameter("tipo").compareToIgnoreCase("2") == 0) {
			fileName = "GestionFiles.xls";
			file = escribirGestionFiles();
		} else if(req.getParameter("tipo").compareToIgnoreCase("3") == 0) {
			fileName = "OperacionesCentralizadas.xls";
			file = escribirOperacionesCentralizadas();
		}
		
		resp.setContentType("application/vnd.ms-excel");
		resp.setBufferSize(1024);
		resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		
		out.write(file);
		out.close();
	}
	
	public byte[] escribirReporte() {
		ReporteMBean s = (ReporteMBean) WebServletContextListener.getApplicationContext().getBean("reporteMBean");
		String tipo = s.getTipo_reporte();
		String anio = s.getAnio_reporte();
		String mes = s.getMes_reporte();
		String ruta = s.getRuta();
		fileName = tipo + "_" + anio + "" + mes + ".xls";

		java.io.File file = new java.io.File(ruta + fileName);
		byte[] bFile = new byte[1];
		
		if (file.exists()) {
			bFile = new byte[(int) file.length()];
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
	    	    fileInputStream.read(bFile);
	    	    fileInputStream.close();
			} catch (Exception e) {
				logger.error("Error en utilitario " + e.getMessage());
			}
		}
		
		return bFile;
	}
	
	public byte[] escribirContratoSolicitud() {
		try {
			SolicitudMBean s = (SolicitudMBean) WebServletContextListener.getApplicationContext().getBean("solicitudMBean");
			
			int indexRow = 2;
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/recursos/xls/Contratos.xls"));
			
			doc.getWb().setSheetName(0, fileName);
			doc.setBarraTitulo(0, 0, 10, "CONTRATOS A " + s.getDto().getTipoDto().getDescripcion());
			doc.setBarraTitulo(1, 0, "CONTRATO");
			doc.setBarraTitulo(1, 1, "TERRITORIO");
			doc.setBarraTitulo(1, 2, "OFICINA");
			doc.setBarraTitulo(1, 3, "PRODUCTO");
			doc.setBarraTitulo(1, 4, "ACTIVO");
			doc.setBarraTitulo(1, 5, "PASIVO");
			doc.setBarraTitulo(1, 6, "MORA");
			doc.setBarraTitulo(1, 7, "VENCIDO");
			doc.setBarraTitulo(1, 8, "FECHA CREACIÓN");
			doc.setBarraTitulo(1, 9, "SITUACIÓN");
			doc.setBarraTitulo(1, 10, "TIPO PRESTAMO");
			
			for(OficinaSolicitudDto o : s.getDto().getListaOficinasSolicitud()) {
				if(o.getTipoOficinaDto().getId().compareTo(1031L) == 0) {
					for(ContratoDto c : o.getListaContratos()) {
						doc.setContentValue(indexRow, 0, c.getCodigoContrato());
						doc.setContentValue(indexRow, 1, o.getOficinaDto().getTerritorioDto().getCodTerritorio() + "-" + o.getOficinaDto().getTerritorioDto().getDesTerritorio());
						doc.setContentValue(indexRow, 2, o.getOficinaDto().getCodOficina() + "-" + o.getOficinaDto().getDesOficina());
						doc.setContentValue(indexRow, 3, c.getProductoDto().getCodProd() + "-" + c.getProductoDto().getDescProd());
						doc.setContentValue(indexRow, 4, c.getSaldoD());
						doc.setContentValue(indexRow, 5, c.getSaldoA());
						doc.setContentValue(indexRow, 6, c.getSalMora());
						doc.setContentValue(indexRow, 7, c.getSaldoVen());
						doc.setContentValue(indexRow, 8, c.getFechaApertura());
						doc.setContentValue(indexRow, 9, c.getDescripcionSituacion());
						doc.setContentValue(indexRow, 10, c.getTipoPrestamoDto().getDescripcion());
						indexRow++;
					}
				}
			}
						
			if(s.getDto().getTramiteSolicitudDto().getId().compareTo(1015L) == 0) {
				indexRow++;
				doc.setBarraTitulo(indexRow, 0, 10, "CONTRATOS DISPONIBLES");
				
				indexRow++;
				doc.setBarraTitulo(indexRow, 0, "CONTRATO");
				doc.setBarraTitulo(indexRow, 1, "TERRITORIO");
				doc.setBarraTitulo(indexRow, 2, "OFICINA");
				doc.setBarraTitulo(indexRow, 3, "PRODUCTO");
				doc.setBarraTitulo(indexRow, 4, "ACTIVO");
				doc.setBarraTitulo(indexRow, 5, "PASIVO");
				doc.setBarraTitulo(indexRow, 6, "MORA");
				doc.setBarraTitulo(indexRow, 7, "VENCIDO");
				doc.setBarraTitulo(indexRow, 8, "FECHA CREACIÓN");
				doc.setBarraTitulo(indexRow, 9, "SITUACIÓN");
				doc.setBarraTitulo(indexRow, 10, "TIPO PRESTAMO");
				
				indexRow++;
				for(ContratoTemporalDto o : s.getListaContratosTemporal()) {
					doc.setContentValue(indexRow, 0, o.getCodigoContrato());
					doc.setContentValue(indexRow, 1, o.getOficinaDto().getTerritorioDto().getCodTerritorio() + "-" + o.getOficinaDto().getTerritorioDto().getDesTerritorio());
					doc.setContentValue(indexRow, 2, o.getOficinaDto().getCodOficina() + "-" + o.getOficinaDto().getDesOficina());
					doc.setContentValue(indexRow, 3, o.getProductoDto().getCodProd() + "-" + o.getProductoDto().getDescProd());
					doc.setContentValue(indexRow, 4, o.getSaldoD());
					doc.setContentValue(indexRow, 5, o.getSaldoA());
					doc.setContentValue(indexRow, 6, o.getSalMora());
					doc.setContentValue(indexRow, 7, o.getSaldoVen());
					doc.setContentValue(indexRow, 8, o.getFechaApertura());
					doc.setContentValue(indexRow, 9, o.getDescripcionSituacion());
					doc.setContentValue(indexRow, 10, o.getTipoPrestamoDto().getDescripcion());
					indexRow++;
				}
			}
			
			return doc.getExcelToByteArray();                      
		}
		catch(Exception ex) {
			logger.error("Exportando contratos", ex);
			return null;
		}
	}

	public byte[] escribirGestionFiles() {
		try {
			ConsultaContratoFileMBean s = (ConsultaContratoFileMBean) WebServletContextListener.getApplicationContext().getBean("consultaContratoFileMBean");
			
			int indexRow = 1;
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/recursos/xls/Contratos.xls"));
			
			doc.getWb().setSheetName(0, fileName);
			doc.setBarraTitulo(0, 0, "ESTADO");
			doc.setBarraTitulo(0, 1, "TIPO SOLICITUD");
			doc.setBarraTitulo(0, 2, "CÓDIGO CLIENTE");
			doc.setBarraTitulo(0, 3, "FECHA DE REGISTRO");
			doc.setBarraTitulo(0, 4, "EST. SEGMENTACIÓN");
			doc.setBarraTitulo(0, 5, "CONTRATO");
			doc.setBarraTitulo(0, 6, "OFICINA PRINCIPAL");
			doc.setBarraTitulo(0, 7, "GESTOR PRINCIPAL");
			doc.setBarraTitulo(0, 8, "OFICINA RECEPTOR");
			doc.setBarraTitulo(0, 9, "GESTOR RECEPTOR");
			doc.setBarraTitulo(0, 10, "PRODUCTO");
			doc.setBarraTitulo(0, 11, "TIPO DE PRESTAMO");
			doc.setBarraTitulo(0, 12, "TOTAL PASIVO (S/.)");
			doc.setBarraTitulo(0, 13, "TOTAL ACTIVO (S/.)");
			doc.setBarraTitulo(0, 14, "FECHA APERTURA");
			doc.setBarraTitulo(0, 15, "SITUACIÓN");
			
			if(s != null) {
				for(ContratoDto c : s.getListaContratos()) {
					doc.setContentValue(indexRow, 0, (c.getEstadoFile() ? "RECEPCIONADO" : "NO RECEPCIONADO"));
					doc.setContentValue(indexRow, 1, c.getOficinaSolicitudDto().getSolicitudDto().getTipoDto().getDescripcion());
					doc.setContentValue(indexRow, 2, c.getOficinaSolicitudDto().getSolicitudDto().getCodigoCliente());
					doc.setContentValue(indexRow, 3, FormatoMensajeCorreo.formatoFecha.format(c.getOficinaSolicitudDto().getSolicitudDto().getFechaCreacion()));
					doc.setContentValue(indexRow, 4, c.getEstadoDto().getDescripcion());
					doc.setContentValue(indexRow, 5, c.getCodigoContrato());
					doc.setContentValue(indexRow, 6, c.getOficinaSolicitudDto().getSolicitudDto().getOficinaPrincipalCliente() + "-" + c.getOficinaSolicitudDto().getSolicitudDto().getOficinaPrincipalClienteDesc());
					doc.setContentValue(indexRow, 7, c.getOficinaSolicitudDto().getSolicitudDto().getGestorPrincipalCliente() + "-" + c.getOficinaSolicitudDto().getSolicitudDto().getGestorPrincipalClienteDesc());
					doc.setContentValue(indexRow, 8, c.getOficinaSolicitudDto().getSolicitudDto().getOficinaReceptorDto().getCodOficina() + "-" + c.getOficinaSolicitudDto().getSolicitudDto().getOficinaReceptorDto().getDesOficina());
					doc.setContentValue(indexRow, 9, c.getOficinaSolicitudDto().getSolicitudDto().getCarteraReceptor() + "-" + c.getOficinaSolicitudDto().getSolicitudDto().getGestorReceptorDto().getNomGestor());
					doc.setContentValue(indexRow, 10, c.getProductoDto().getCodProd() + "-" + c.getProductoDto().getDescProd());
					doc.setContentValue(indexRow, 11, c.getTipoPrestamoDto().getDescripcion());
					doc.setContentValue(indexRow, 12, c.getTotalPasivo());
					doc.setContentValue(indexRow, 13, c.getTotalActivo());
					doc.setContentValue(indexRow, 14, c.getFechaApertura());
					doc.setContentValue(indexRow, 15, c.getDescripcionSituacion());
					indexRow++;
				}
			}
			
			return doc.getExcelToByteArray();
		} catch(Exception ex) {
			logger.error("Exportando gestion de files", ex);
			return null;
		}
	}
	
	public byte[] escribirOperacionesCentralizadas() {
		try {
			ConsultaMBean s = (ConsultaMBean) WebServletContextListener.getApplicationContext().getBean("consultaMBean");
			
			int indexRow = 1;
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/recursos/xls/Contratos.xls"));
			  
			doc.getWb().setSheetName(0, fileName);
			doc.setBarraTitulo(0, 0, "ESTADO PROCESAMIENTO");
			doc.setBarraTitulo(0, 1, "COMENTARIO");
			doc.setBarraTitulo(0, 2, "CÓDIGO CLIENTE");
			doc.setBarraTitulo(0, 3, "CONTRATO");
			doc.setBarraTitulo(0, 4, "TERRITORIO CEDENTE");
			doc.setBarraTitulo(0, 5, "OFICINA CEDENTE ");
			doc.setBarraTitulo(0, 6, "OFICINA RECEPTORA");
			doc.setBarraTitulo(0, 7, "GESTOR RECEPTOR");
			doc.setBarraTitulo(0, 8, "PRODUCTO");
			doc.setBarraTitulo(0, 9, "TOTAL PASIVO (S/.)");
			doc.setBarraTitulo(0, 10, "TOTAL ACTIVO (S/.)");
			doc.setBarraTitulo(0, 11, "FECHA APERTURA");
			doc.setBarraTitulo(0, 12, "SITUACIÓN");
			doc.setBarraTitulo(0, 13, "FECHA REGISTRO");
			
			if(s != null) {
				for(ContratoDto c : s.getListaContratos()) {
					doc.setContentValue(indexRow, 0, c.getEstadoDto().getDescripcion());
					doc.setContentValue(indexRow, 1, c.getComentarioEstado());
					doc.setContentValue(indexRow, 2, c.getOficinaSolicitudDto().getSolicitudDto().getCodigoCliente());
					doc.setContentValue(indexRow, 3, c.getCodigoContrato());
					doc.setContentValue(indexRow, 4, c.getOficinaSolicitudDto().getOficinaDto().getTerritorioDto().getCodTerritorio() + "-" + c.getOficinaSolicitudDto().getOficinaDto().getTerritorioDto().getDesTerritorio());
					doc.setContentValue(indexRow, 5, c.getOficinaSolicitudDto().getOficinaDto().getCodOficina() + "-" + c.getOficinaSolicitudDto().getOficinaDto().getDesOficina());
					doc.setContentValue(indexRow, 6, c.getOficinaSolicitudDto().getSolicitudDto().getOficinaReceptorDto().getCodOficina() + "-" + c.getOficinaSolicitudDto().getSolicitudDto().getOficinaReceptorDto().getDesOficina());
					doc.setContentValue(indexRow, 7, c.getOficinaSolicitudDto().getSolicitudDto().getCarteraReceptor() + "-" + c.getOficinaSolicitudDto().getSolicitudDto().getGestorReceptorDto().getNomGestor());
					doc.setContentValue(indexRow, 8, c.getProductoDto().getCodProd() + "-" + c.getProductoDto().getDescProd());
					doc.setContentValue(indexRow, 9, c.getTotalPasivo());
					doc.setContentValue(indexRow, 10, c.getTotalActivo());
					doc.setContentValue(indexRow, 11, c.getFechaApertura());
					doc.setContentValue(indexRow, 12, c.getDescripcionSituacion());
					doc.setContentValue(indexRow, 13, FormatoMensajeCorreo.formatoFecha.format(c.getOficinaSolicitudDto().getSolicitudDto().getFechaCreacion()));
					indexRow++;
				}
			}
			
			return doc.getExcelToByteArray();
		} catch(Exception ex) {
			logger.error("Exportando gestion de files", ex);
			return null;
		}
	}
}
