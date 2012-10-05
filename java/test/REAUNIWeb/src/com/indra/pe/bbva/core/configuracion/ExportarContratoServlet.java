package com.indra.pe.bbva.core.configuracion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.util.DocumentoExcel;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.ContratoTemporalDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.view.mbean.SolicitudMBean;

public class ExportarContratoServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ExportarContratoServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletOutputStream out = resp.getOutputStream();
		
		resp.setContentType("application/vnd.ms-excel");
		resp.setHeader("Content-Disposition", "attachment; filename=Contratos.xls");
		resp.setBufferSize(1024);
		
		byte[] xls = escribir();
		out.write(xls);
		out.close();
	}
	
	public byte[] escribir() {
		try {
			SolicitudMBean s = (SolicitudMBean) WebServletContextListener.getApplicationContext().getBean("solicitudMBean");
			
			int indexRow = 2;
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/recursos/xls/Contratos.xls"));
			
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
}
