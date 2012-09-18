package com.indra.pe.bbva.reauni.util;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class DescargaReporte
 */
@WebServlet("/descargaReporte")
public class DescargaReporte extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(DescargaReporte.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DescargaReporte() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		descarga(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		descarga(request,response);
	}
	
	
	public void descarga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String tipo = (String)request.getSession().getAttribute("tipo");
        String anio = (String)request.getSession().getAttribute("año");
        String mes = (String)request.getSession().getAttribute("mes");
        String ruta = (String)request.getSession().getAttribute("exportacion_ruta");

        String archivo=tipo+"_"+anio+""+mes+".xls";
        
        java.io.File file = new java.io.File(ruta+archivo);
        
    	if(file.exists()){
    		
    		//response.setContentType ("text/plain");
    		response.setHeader ("Content-Disposition", "attachment; filename=" + archivo);
    		byte[] bFile = new byte[(int) file.length()];
    		FileInputStream fileInputStream=null;
            try {
                //convert file into array of bytes
    	    fileInputStream = new FileInputStream(file);
    	    fileInputStream.read(bFile);
    	    fileInputStream.close();
     
    	    //convert array of bytes into file
    	    ServletOutputStream fileOuputStream = response.getOutputStream(); 
    	    fileOuputStream.write(bFile);
    	    fileOuputStream.close();
    	  } catch(Exception e){
    			logger.error("Error en utilitario " + e.getMessage());
    		}
    	}else{
    		response.setContentType ("text/html");
    		//out.println("<script>alert('No se encontro el reporte'); window.close();</script>");	
    	}

	}

}
