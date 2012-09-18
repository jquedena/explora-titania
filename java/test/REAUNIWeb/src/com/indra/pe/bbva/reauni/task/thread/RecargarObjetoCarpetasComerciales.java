package com.indra.pe.bbva.reauni.task.thread;

import org.apache.log4j.Logger;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.GestorDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;
import com.indra.pe.bbva.reauni.model.entidad.TerritorioDto;
import com.indra.pe.bbva.reauni.service.GestorBO;
import com.indra.pe.bbva.reauni.service.OficinaBO;
import com.indra.pe.bbva.reauni.service.TerritorioBO;
import com.indra.pe.bbva.reauni.view.mbean.AplicacionMBean;

public class RecargarObjetoCarpetasComerciales  extends Thread  {

	private static Logger logger = Logger.getLogger(RecargarObjetoCarpetasComerciales.class);
	
	@Override
	public void run() {
		AplicacionMBean aplicacionMBean = (AplicacionMBean) WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
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
	}
}
