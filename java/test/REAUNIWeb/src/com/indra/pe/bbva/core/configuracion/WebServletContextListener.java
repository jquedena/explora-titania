package com.indra.pe.bbva.core.configuracion;

import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebServletContextListener implements ServletContextListener {

	private static WebApplicationContext springContext;
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		springContext = null;
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		springContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
		try{
			FacesContext fc = FacesContext.getCurrentInstance();
	        fc.getViewRoot().setLocale(new Locale("es_PE"));
	        fc.getApplication().setDefaultLocale(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		}catch (Exception e) {
			
		}
		 
	}
	
	public static ApplicationContext getApplicationContext() {
	        return springContext;
	}

}
