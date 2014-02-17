package com.indra.pe.bbva.core.configuracion;

import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;

/**
 *
 * @author INDRA PERU SA
 */
public class ApplicationInitServlet extends HttpServlet{
        
	private static final long serialVersionUID = -3125474794678604270L;
	private static Logger logger = null;

    @SuppressWarnings("static-access")
	@Override
    public void init() throws ServletException {
        try {
        	ParametroBO parametroBO = (ParametroBO)WebServletContextListener.getApplicationContext().getBean("parametroBO");
        	ParametroDto parametroDto = new ParametroDto(); 
        	CatalogoParametroDto catalogoParametroDto = new CatalogoParametroDto();
			catalogoParametroDto.setId(Constantes.VariablesCatalogoParametros.VARIABLE_ID_LOG); 
			parametroDto.setCatalogoParametroDto(catalogoParametroDto); 
        	parametroDto = parametroBO.obtenerParametro(parametroDto);
            Properties prop = new Properties();
            // prop.setProperty("log4j.rootCategory", "INFO, stdout, ERROR, LOGFILE");
            prop.setProperty("log4j.rootCategory", "ERROR, LOGFILE");
            prop.setProperty("log4j.appender.LOGFILE", "org.apache.log4j.RollingFileAppender");
            prop.setProperty("log4j.appender.LOGFILE.file",parametroDto.getDescripcion()+Constantes.LOG_REAUNI);
            prop.setProperty("log4j.appender.LOGFILE.MaxFileSize", "20000KB");
            prop.setProperty("log4j.appender.LOGFILE.MaxBackupIndex", "5");
            prop.setProperty("log4j.appender.LOGFILE.append", "true");
            prop.setProperty("log4j.appender.LOGFILE.layout", "org.apache.log4j.PatternLayout");
            prop.setProperty("log4j.appender.LOGFILE.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss}] - [%5p] (%C{1}.%M:%L) - %m%n");
        
            /*
            prop.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
            prop.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
            prop.setProperty("log4j.appender.stdout.layout.ConversionPattern","[%d{HH:mm:ss}]%p - %C{1}.%M(%L)  %m%n");	            
             */
            PropertyConfigurator.configure(prop); 
            logger = Logger.getLogger(ApplicationInitServlet.class);        
            logger.error("****************************");
            logger.error("Se inicio el log ");
            logger.error("****************************");

            AplicacionMBean aplicacionMBean = (AplicacionMBean)WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
            
            aplicacionMBean.setListaCatalogos(parametroBO.obtenerTodosCatalogosParametros());
    		//aplicacionMBean.setListaParametros(parametroBO.obtenerTodosParametros());
    		
    		
        } catch (Exception e) {
            BasicConfigurator.configure();
            logger = Logger.getLogger(ApplicationInitServlet.class);
            logger.error("Error al inicializar el log ",e);
        }
    }
    
    
}
