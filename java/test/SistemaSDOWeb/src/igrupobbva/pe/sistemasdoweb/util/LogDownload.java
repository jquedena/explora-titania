package igrupobbva.pe.sistemasdoweb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogDownload
 */
public class LogDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LogDownload.class);
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		generaLog(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		generaLog(request, response);
	}

	protected void generaLog(HttpServletRequest request,
			HttpServletResponse response) {
		
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		PrintWriter out = null;
		
		response.setContentType("text/plain");
		
		try {
			log.info("[LogDownload] Inicio");
			out = response.getWriter();
			file = new File(request.getParameter("file"));
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				out.println(line);
			}
			log.info("[LogDownload] Fin");
		} catch (Exception e) {
			log.error(e);
		} finally {
			out.close();
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
