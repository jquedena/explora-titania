package pe.com.titania.jasper.export;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import pe.com.titania.jasper.Constante;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRRtfExporter;

public class RtfExport {

	public static void export(JasperPrint jasperPrint, HttpServletResponse response) throws ServletException, IOException {
		if (jasperPrint == null) {
			throw new ServletException(Constante.EXPORT_NO_FOUND);
		}
		
		response.setContentType("application/rtf");
		response.setHeader("Content-Disposition", "inline; filename=\"" + jasperPrint.getName() + ".rtf\"");

		OutputStream ouputStream = response.getOutputStream();
		JRRtfExporter exporter = new JRRtfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);

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
