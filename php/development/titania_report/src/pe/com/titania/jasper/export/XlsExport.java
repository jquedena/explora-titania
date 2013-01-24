package pe.com.titania.jasper.export;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import pe.com.titania.jasper.Constante;

public class XlsExport {

	public static void export(JasperPrint jasperPrint, HttpServletResponse response) throws ServletException, IOException {
		if (jasperPrint == null) {
			throw new ServletException(Constante.EXPORT_NO_FOUND);
		}

		response.setContentType("application/xls");
		response.setHeader("Content-Disposition", "inline; filename=\"" + jasperPrint.getName() + ".xls\"");

		
		OutputStream ouputStream = response.getOutputStream();
		JRXlsAbstractExporter exporter = new JExcelApiExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
		exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
		exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);

		try {
			exporter.exportReport();
		} catch (JRException e) {
			throw new ServletException(e);
		} finally {
			if (ouputStream != null) {
				try {
					ouputStream.close();
				} catch (IOException ex) {
				}
			}
		}
	}
}
