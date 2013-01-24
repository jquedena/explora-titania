package pe.com.titania.jasper.export;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import pe.com.titania.jasper.Constante;

public class PptxExport {

	public static void export(JasperPrint jasperPrint, HttpServletResponse response) throws ServletException, IOException {
		if (jasperPrint == null) {
			throw new ServletException(Constante.EXPORT_NO_FOUND);
		}

		response.setContentType("application/vnd.openxmlformats-officedocument.presentationml.presentation");
		response.setHeader("Content-Disposition", "inline; filename=\"" + jasperPrint.getName() + ".pptx\"");

		JRPptxExporter exporter = new JRPptxExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

		OutputStream ouputStream = response.getOutputStream();
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
