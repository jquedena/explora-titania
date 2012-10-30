package com.indra.pe.bbva.reauni.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/descargaReporte")
public class DescargaReporte extends HttpServlet {

	private static Logger logger = Logger.getLogger(DescargaReporte.class);
	private static final long serialVersionUID = 1L;

	public DescargaReporte() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		descarga(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		descarga(request, response);
	}

	public void descarga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tipo = (String) request.getSession().getAttribute("tipo");
		String anio = (String) request.getSession().getAttribute("año");
		String mes = (String) request.getSession().getAttribute("mes");
		String ruta = (String) request.getSession().getAttribute("exportacion_ruta");
		String archivo = tipo + "_" + anio + "" + mes + ".xls";

		java.io.File file = new java.io.File(ruta + archivo);

		if (file.exists()) {
			response.setContentType ("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=" + archivo);
			byte[] bFile = new byte[(int) file.length()];
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
	    	    fileInputStream.read(bFile);
	    	    fileInputStream.close();
	    	    
				ServletOutputStream fileOuputStream = response.getOutputStream();
				fileOuputStream.write(bFile);
				fileOuputStream.close();
			} catch (Exception e) {
				logger.error("Error en utilitario " + e.getMessage());
			}
		} else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('No se encontro el reporte'); window.close();</script>");
		}
	}
}