package igrupobbva.pe.sistemasdoweb.util;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;

public class InitPropertiesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(InitPropertiesServlet.class);
	
	public InitPropertiesServlet() {
	}
	
	@Override
	public void destroy() {
	    super.destroy();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	    ServletContext servletContext = config.getServletContext();
	    String webAppPath = servletContext.getRealPath("/");
	    String log4jLocation = config.getInitParameter("log4j-properties-location");
	
	    if (log4jLocation == null) {
	        System.err.println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
	        BasicConfigurator.configure();
	    } else {
	        String log4jProp = webAppPath + log4jLocation;
	        File fileLog4 = new File(log4jProp);
	        if (fileLog4.exists()) {
	            System.out.println("Initializing log4j with: " + log4jProp);
	            PropertyConfigurator.configure(log4jProp);
	        } else {
	            System.err.println("*** " + log4jProp + " file not found, so initializing log4j with BasicConfigurator");
	            BasicConfigurator.configure();
	        }
	    }
	    super.init(config);
	    loadLog4JProperties(servletContext);
	}
	
	private void loadLog4JProperties(ServletContext servletContext)
	        throws ServletException {
		
		Connection con = null;
		Multitabla multiTabla = null;
		
	    try {
			con = new Connection(); 
			multiTabla = con.findMultiByPrimaryKey("T15", "1");
			
	        String log4jProp = multiTabla.getValor1() + "propertiesLog4J.properties";
	        File fileLog4j = new File(log4jProp);
	        if (fileLog4j.exists()) {
	            PropertyConfigurator.configure(log4jProp);
	            log.error("Initializing log4j with: " + log4jProp);
	        }
	    } catch (Exception e) {
	        log.error(e);
	    }
	}
}