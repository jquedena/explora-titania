package pe.com.titania.jasper.servlet;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ApplicationInitServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static Logger logger;
	
    public ApplicationInitServlet() {
        super();
    }

	public void init() throws ServletException {	
		
		Properties property = new Properties();
		property.setProperty("log4j.rootLogger", "INFO,FILE,stdout");
		property.setProperty("log4j.appender.FILE", "org.apache.log4j.DailyRollingFileAppender");
		property.setProperty("log4j.appender.FILE.layout", "org.apache.log4j.PatternLayout");
		property.setProperty("log4j.appender.FILE.File", "/de/titania/titania_report.log");
		property.setProperty("log4j.appender.FILE.append", "true");
		property.setProperty("log4j.appender.FILE.datePattern", "'.'dd-MM-yyyy");
		property.setProperty("log4j.appender.FILE.layout.ConversionPattern", "[%d{HH:mm:ss}]%p - %C{1}.%M(%L)  %m%n");
		property.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
		property.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
		property.setProperty("log4j.appender.stdout.layout.ConversionPattern", "[%d{HH:mm:ss}]%p - %C{1}.%M(%L)  %m%n");
        PropertyConfigurator.configure(property);
        logger = Logger.getLogger(ApplicationInitServlet.class);
        logger.info("Configuración leida correctamente");
	}

}
