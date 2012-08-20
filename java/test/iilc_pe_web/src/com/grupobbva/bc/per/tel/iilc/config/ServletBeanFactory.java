package com.grupobbva.bc.per.tel.iilc.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;

public class ServletBeanFactory extends HttpServlet {

	private static final long serialVersionUID = 1643546027635026830L;
	private Logger logger = Logger.getLogger(ServletBeanFactory.class);
	
	public void init() throws ServletException {
		BeanFactory factory = SingletonBeanFactory.getInstancia().getBeanFactory();
		logger.info(factory);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("shutdown") != null && request.getParameter("shutdown").equalsIgnoreCase("now")) {
			SingletonBeanFactory.getInstancia().getScheduler().shutdown();
			logger.info("Shutdown now...");
			logger.info("Hilos apagados");
		}
		if(request.getParameter("startup") != null && request.getParameter("startup").equalsIgnoreCase("now")) {
			// SingletonBeanFactory.getInstancia().getScheduler();
			logger.info("Startup now...");
			logger.info("Inicializando los hilos");
		}
	}
}
