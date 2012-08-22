package igrupobbva.pe.sistemasdoweb.excel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ExportarExcelReporteServlet extends HttpServlet implements Servlet {
	private static Logger log = Logger.getLogger(ExportarExcelReporteServlet.class);
	
	public ExportarExcelReporteServlet() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		doPost(req,res);
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("[ExportarExcelReporteServlet :: doPost] Inicio");		
		
		Connection cnx = new Connection();
		String filePath = ((Multitabla)cnx.findByCodMulti("T11").elementAt(0)).getValor1();
		String filename = (String) request.getParameter("file");
			
		if (filePath == null && filename != null)
			filePath = "/" + filename;
		if (filename == null)
			filename = filePath;
		
		if (filePath != null) {
			InputStream in = null;
			OutputStream out = null;
			try {
				//in = getServletContext().getResourceAsStream(
				//		basePath + filePath);			
				//String path = getServletContext().getRealPath("/") + filename;		
				//path = path.replaceFirst("/SistemaSDOWeb/","").trim();
				String path = filePath + filename;
				if(new File(path).length()>0L){
					File archivo = new File(path);				
					in = new FileInputStream(archivo);
					
					if (in != null) {
						out = new BufferedOutputStream(response.getOutputStream());
						in = new BufferedInputStream(in);
						String contentType = "application/unknow";
						response.setContentType(contentType);
						response.setHeader("Content-Disposition",
								"attachment; filename=\"" + archivo.getName() + "\"");
						int c;
						while ((c = in.read()) != -1)
							out.write(c);
						return;
					}
				}
				else{
					String ERROR_NO_EXISTE_ARCHIVO = "Archivo no encontrado";
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.write("<html><head>"+
							"<script language=\"javascript\">" +
							"function mensaje(){" +
							"alert(\""+ERROR_NO_EXISTE_ARCHIVO+"\");" +
							"history.back();" +
							"}" +
							"</script></head>"+
							"<body onload=\"mensaje();\">" +
							"</body></html>");
				}
			 
				log.info("[ExportarExcelReporteServlet :: doPost] Fin");
			} catch(Exception e) {
				log.error("[ExportarExcelReporteServlet :: doPost] ");
				ConstantesUtil.mostrarMensajeExcepcion(e);
			} finally {
				if (in != null)
					try {
						in.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				if (out != null)
					try {
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}			
			
	}	
}