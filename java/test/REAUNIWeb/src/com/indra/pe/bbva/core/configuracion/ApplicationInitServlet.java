package com.indra.pe.bbva.core.configuracion;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.GestorDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.TerritorioDto;
import com.indra.pe.bbva.reauni.service.GestorBO;
import com.indra.pe.bbva.reauni.service.OficinaBO;
import com.indra.pe.bbva.reauni.service.ParametroBO;
import com.indra.pe.bbva.reauni.service.TerritorioBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.helper.SessionHelper;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;

public class ApplicationInitServlet extends HttpServlet {

	private static final long serialVersionUID = -3125474794678604270L;
	private static Logger logger = null;

	@Override
	public void init() throws ServletException {
		try {
			String modo = "";
			
			ParametroBO parametroBO = (ParametroBO) WebServletContextListener.getApplicationContext().getBean("parametroBO");
			ParametroDto parametroDto = new ParametroDto();
			CatalogoParametroDto catalogoParametroDto = new CatalogoParametroDto();
			
			catalogoParametroDto.setId(Constantes.VariablesCatalogoParametros.VARIABLE_ID_LOG);
			parametroDto.setCatalogoParametroDto(catalogoParametroDto);
			parametroDto = parametroBO.obtenerParametro(parametroDto);
			
			if(SessionHelper.getModoDebug()) {
				modo = "INFO, stdout, ERROR, LOGFILE";
			} else {
				modo = "ERROR, LOGFILE";
			}
						
			Properties prop = new Properties();
			prop.setProperty("log4j.rootCategory", modo);
			prop.setProperty("log4j.appender.LOGFILE", "org.apache.log4j.RollingFileAppender");
			prop.setProperty("log4j.appender.LOGFILE.file", parametroDto.getDescripcion()+Constantes.LOG_REAUNI);
			prop.setProperty("log4j.appender.LOGFILE.MaxFileSize", "20000KB");
			prop.setProperty("log4j.appender.LOGFILE.MaxBackupIndex", "5");
			prop.setProperty("log4j.appender.LOGFILE.append", "true");
			prop.setProperty("log4j.appender.LOGFILE.layout", "org.apache.log4j.PatternLayout");
			prop.setProperty("log4j.appender.LOGFILE.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss}] - [%5p] (%C{1}.%M:%L) - %m%n");
			prop.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
			prop.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
			prop.setProperty("log4j.appender.stdout.layout.ConversionPattern","[%d{HH:mm:ss}]%p - %C{1}.%M(%L)  %m%n");	            
			    
			PropertyConfigurator.configure(prop);
			logger = Logger.getLogger(ApplicationInitServlet.class);
		

			AplicacionMBean aplicacionMBean = (AplicacionMBean) WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
			aplicacionMBean.setListaCatalogos(parametroBO.obtenerTodosCatalogosParametros());

			try {
				TerritorioBO boTerritorio = (TerritorioBO) WebServletContextListener.getApplicationContext().getBean("territorioBO");
				aplicacionMBean.setListaTerritorios(boTerritorio.obtenerTerritorios(new TerritorioDto()));
			} catch (ServiceException e) {
				logger.error("Error al cargar los territorios", e);
			}

			try {
				OficinaBO boOficina = (OficinaBO) WebServletContextListener.getApplicationContext().getBean("oficinaBO");
				aplicacionMBean.setListaOficinas(boOficina.obtenerOficinas(new OficinaDto()));
			} catch (ServiceException e) {
				logger.error("Error al cargar las oficinas", e);
			}

			try {
				GestorBO boGestor = (GestorBO) WebServletContextListener.getApplicationContext().getBean("gestorBO");
				aplicacionMBean.setListaGestores(boGestor.obtenerGestores(new GestorDto()));

			} catch (ServiceException e) {
				logger.error("Error al cargar los gestores", e);
			}
		} catch (Exception e) {
			BasicConfigurator.configure();
			logger = Logger.getLogger(ApplicationInitServlet.class);
			logger.error("Error al inicializar el log ", e);
		}
	}

}
