package pe.com.titania.jasper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

import org.apache.log4j.Logger;

import pe.com.titania.jasper.Constante;

public class CompileFileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Enumeration<String> parameterNames = request.getParameterNames();
		String parameterName;
		String value;
		String source;
		String dest;
		List<String> parameterCompile = new ArrayList<String>();
		
		while(parameterNames.hasMoreElements()) {
			parameterName = parameterNames.nextElement();
			value = request.getParameter(parameterName) == null ? "off" : request.getParameter(parameterName);
			source = Constante.PATH_JRXML + parameterName + ".jrxml";
			dest = Constante.PATH_JASPER + parameterName + ".jasper";
			
			if(value.equalsIgnoreCase("on")) {
				try {
					JasperCompileManager.compileReportToFile(source, dest);
					parameterCompile.add("Se compilo correctamente el archivo: " + parameterName + ".jrxml");
				} catch (JRException e) {
					parameterCompile.add("No se pudo compilar archivo: " + parameterName + ".jrxml, error presentado " + e.getMessage());
					logger.error("No se pudo compilar archivo: " + parameterName + ".jrxml", e);
				}
			}
		}

		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + Constante.TITLE + "</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<b>Estado:</b>");
		out.println("<br/><br/>");
		
		Iterator<String> listStatus = parameterCompile.iterator();
		String status;
		while(listStatus.hasNext()) {
			status = listStatus.next();
			out.println(status);
			out.println("<hr/></br>");
		}
		
		out.println("<a href='admin.jsp'>Regresar</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
