package com.grupobbva.bc.per.tel.iilc.servlet;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.task.Mensajero;

@SuppressWarnings({"serial","unused"})
public class InitPropertiesServlet extends HttpServlet {

    Logger log;
	
	public InitPropertiesServlet() {
        log = null;
    }
	
	public void destroy() {
		super.destroy();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		loadLog4JProperties(config);
	}
	
	private void loadLog4JProperties(ServletConfig config) throws ServletException {
		String prefix = null;
		String file = null;
		Mensajero mail = null;
		Multitabla multiTabla = null;
		String nombreLog = null;
		
		try {
			mail = new Mensajero(); 
			multiTabla = mail.findMultitabla("T17");
			
			prefix = multiTabla.getValor1();
			file = "propertiesLog4J.properties";
			
			if (file == null || file.length() == 0 || !(new File(prefix + file)).isFile()) {
				System.err.println("ERROR IILC: No puede leer el archivo de configuracion de Log4J. ");
			} else {
				PropertyConfigurator.configure(prefix + file);
				log = Logger.getLogger(InitPropertiesServlet.class);
				
				log.warn("LOG4J inicializado correctamente*");
			}
		} catch(Exception e) {
			System.err.println("ERROR IILC: No puede leer el archivo de configuracion de Log4J. ");
		}
		
		return;
	}
}