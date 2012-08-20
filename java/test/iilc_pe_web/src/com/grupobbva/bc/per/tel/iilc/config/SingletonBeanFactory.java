package com.grupobbva.bc.per.tel.iilc.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.grupobbva.bc.per.tel.iilc.dao.ICargaDAO;
import com.grupobbva.bc.per.tel.iilc.service.ICargaConduccionService;
import com.grupobbva.bc.per.tel.iilc.service.ICargaOfertasService;
import com.grupobbva.bc.per.tel.iilc.service.ICargaOtrasOfertasService;

public class SingletonBeanFactory {
	
	private static SingletonBeanFactory instancia = null;
	private BeanFactory beanFactory = null;
	
    private SingletonBeanFactory() {
        inicializar();
    }

    private synchronized void inicializar() {
    	String CTX_NAME = "/" + getClass().getPackage().getName().replace(".", "/") + "/Bean-factoria.xml";
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(CTX_NAME);
    	beanFactory = (BeanFactory) ctx;
    }
    
    private synchronized static void crearInstancia() {
        if (instancia == null) {
        	instancia = new SingletonBeanFactory();
        }
    }

    public synchronized static SingletonBeanFactory getInstancia() {
        crearInstancia();
        return instancia;
    }

	public synchronized BeanFactory getBeanFactory() {
		return beanFactory;
	}
	
	public synchronized ICargaConduccionService getCargaConduccionService() {
		return (ICargaConduccionService) getBeanFactory().getBean("iCargaConduccionService");
	}
	
	public synchronized ICargaOfertasService getCargaOfertasService() {
		return (ICargaOfertasService) getBeanFactory().getBean("iCargaOfertasService");
	}
	
	public synchronized ICargaOtrasOfertasService getCargaOtrasOfertasService() {
		return (ICargaOtrasOfertasService) getBeanFactory().getBean("iCargaOtrasOfertasService");
	}

	public synchronized ICargaDAO getCargaDAO() {
		return (ICargaDAO) getBeanFactory().getBean("iCargaDAO");
	}
	
	public synchronized ThreadPoolTaskScheduler getScheduler() {
		return (ThreadPoolTaskScheduler) getBeanFactory().getBean("scheduler");
	}
}
