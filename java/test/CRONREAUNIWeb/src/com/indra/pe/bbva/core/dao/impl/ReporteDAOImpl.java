package com.indra.pe.bbva.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.dao.ReporteDAO;

@SuppressWarnings("rawtypes")
@Service("reporteDAO")
public class ReporteDAOImpl implements ReporteDAO{
	
	private static Logger logger = Logger.getLogger(ReporteDAOImpl.class);
		
	@Autowired
	private DAOGenerico dao;

	public List generarReportePorOficina(){
		try{
			List lista=dao.ejecutarSQL( "select * from REAUNI.VREAUNI_REPORTE_OFICINA");
			return lista;
		}catch(Exception e){
			logger.error("Error en utilitario.", e);
			return new ArrayList();
		}	
	}
	
	public List generarReportePorTerritorio(){
		try{
			List lista=dao.ejecutarSQL( " select * from REAUNI.VREAUNI_REPORTE_TERRITORIO");
			return lista ;
		}catch(Exception e){
			logger.error("Error en utilitario.", e);
			return new ArrayList();
		}
	}
	
	public List generarReportePorTiempoTramite(){
		try{
			List lista=dao.ejecutarSQL("select * from REAUNI.VREAUNI_REPORTE_TRAMITE");
			return lista;
		}catch(Exception e){
			logger.error("Error en utilitario.", e);
			return new ArrayList();
		}
	}

	public List generarReportePorTipoSolicitante(){
		try{
			List lista=dao.ejecutarSQL("SELECT * FROM REAUNI.VREAUNI_REPORTE_SOLICITANTE");
			return lista;
		}catch(Exception e){
			logger.error("Error en utilitario.", e);
			return new ArrayList();
		}
	}
}
