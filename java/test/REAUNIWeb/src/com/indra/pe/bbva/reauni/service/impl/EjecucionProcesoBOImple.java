package com.indra.pe.bbva.reauni.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.model.entidad.EjecucionProcesoDto;
import com.indra.pe.bbva.reauni.service.EjecucionProcesoBO;

@Service("ejecucionProcesoBO")
public class EjecucionProcesoBOImple implements EjecucionProcesoBO {
	private static Logger logger = Logger.getLogger(EjecucionProcesoBOImple.class);	
	
	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<EjecucionProcesoDto> dao;
	
	@Override
	public List<EjecucionProcesoDto> obtenerEjecuciones(String nombreProceso,String fechaEjecucion) {
		String hsql = "select a from EjecucionProcesoDto a where a.ejecucionProcesoDtoPK.proceso=? and a.ejecucionProcesoDtoPK.fecha=? order by a.ejecucionProcesoDtoPK.fecha desc, a.ejecucionProcesoDtoPK.hora desc";
		try {
			return dao.obtenerDtosPorQuery(hsql, nombreProceso,fechaEjecucion);
		} catch (DAOException e) {
			logger.error("Error en EjecucionProcesoBOImple.obtenerEjecuciones", e);
			return null;
		}
	}
	
	@Override
	public List<EjecucionProcesoDto> obtenerEjecuciones(String nombreProceso,String fechaEjecucion, String horaEjecucion) {
		String hsql = "select a from EjecucionProcesoDto a where a.ejecucionProcesoDtoPK.proceso=? and a.ejecucionProcesoDtoPK.fecha=? and a.ejecucionProcesoDtoPK.hora=? order by a.ejecucionProcesoDtoPK.fecha desc, a.ejecucionProcesoDtoPK.hora desc";
		try {
			return dao.obtenerDtosPorQuery(hsql, nombreProceso,fechaEjecucion,horaEjecucion);
		} catch (DAOException e) {
			logger.error("Error en EjecucionProcesoBOImple.obtenerEjecuciones", e);
			return null;
		}
	}
	
	@Override
	public void insertar(EjecucionProcesoDto ejecucionProcesoDto) {
		try {
			dao.save(ejecucionProcesoDto);
		} catch (DAOException e) {
			logger.error("Error ", e);
		}
	}

	@Override
	public void editar(EjecucionProcesoDto ejecucionProcesoDto) {
		try {
			dao.saveOrUpdate(ejecucionProcesoDto);
		} catch (DAOException e) {
			logger.error("Error ", e);
		}
	}
}
