package pe.com.titania.jasper.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import pe.com.titania.jasper.Constante;
import pe.com.titania.jasper.export.CsvExport;
import pe.com.titania.jasper.export.DocxExport;
import pe.com.titania.jasper.export.PdfExport;
import pe.com.titania.jasper.export.PptxExport;
import pe.com.titania.jasper.export.RtfExport;
import pe.com.titania.jasper.export.XlsExport;

@WebServlet(description = "Genera reporte con jasper", urlPatterns = { "/index.jsp" })
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typeFile = request.getParameter("tipo");
		String reportFileName = request.getParameter("reporte");
		String parametersReport = request.getParameter("opt");
	    
		if(typeFile == null) typeFile = "pdf";
		if(reportFileName == null) reportFileName = "";
		if(parametersReport == null) parametersReport = "";
		
		if (reportFileName.trim().length() == 0)
			throw new JRRuntimeException("No se ha indicado el nombre del reporte");

		
		reportFileName = Constante.PATH_JASPER + reportFileName + ".jasper";
		File reportFile = new File(reportFileName);
	    if (!reportFile.exists())
			throw new JRRuntimeException("El archivo " + reportFileName + " no se encuentra. Asegurese de que se haya compilado primero.");

		Map<String, Object> parameters = new HashMap<String, Object>();
		String name;
		String value;
		Object element;
		StringTokenizer parametersToken;
		StringTokenizer elementsToken;
		int count;
		
		if(parametersReport.length()>0){
			parametersToken = new StringTokenizer(parametersReport, "|");
			count = parametersToken.countTokens();
			for(int i = 0;i < count; i++){
				element = parametersToken.nextElement();
				elementsToken = new StringTokenizer(element.toString(), "^");
				if(elementsToken.countTokens() == 1){
					name = elementsToken.nextToken();
					parameters.put(name, "");
				}else{
					name = elementsToken.nextToken();
					value = elementsToken.nextToken();
					parameters.put(name, value);
				}
			}
		}
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			logger.error("service::ClassNotFoundException", e);
		}
		
		// String url = "jdbc:postgresql://192.168.2.38:5432/titania_test";
		String url = "jdbc:postgresql://127.0.0.1:5432/titania_test";
		String user = "desarrollo";
		String password = "perutest7";
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			logger.error("service::SQLException", e);
		}
		
		JasperPrint jasperPrint = null;
		try {
			jasperPrint = JasperFillManager.fillReport(reportFileName, parameters, connection);
		} catch (JRException e) {
			logger.error("service::JRException", e);
		}
		
		if(typeFile.equalsIgnoreCase("pdf")) {
			PdfExport.export(jasperPrint, response);
		} else if(typeFile.equalsIgnoreCase("xls")) {
			XlsExport.export(jasperPrint, response);
		} else if(typeFile.equalsIgnoreCase("rtf")) {
			RtfExport.export(jasperPrint, response);
		} else if(typeFile.equalsIgnoreCase("docx")) {
			DocxExport.export(jasperPrint, response);
		} else if(typeFile.equalsIgnoreCase("pptx")) {
			PptxExport.export(jasperPrint, response);
		} else if(typeFile.equalsIgnoreCase("csv")) {
			CsvExport.export(jasperPrint, response);
		}
	}

}
