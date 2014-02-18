package com.indra.pe.bbva.reauni.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.pe.bbva.core.transactional.AppReauniTxReadOnly;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.reauni.model.entidad.CargaDto;
import com.indra.pe.bbva.reauni.service.CargaBO;

@Service("cargaBO")
public class CargaBOImple implements CargaBO {
	private static Logger logger = Logger.getLogger(CargaBOImple.class);
	
	@Autowired
	private DAOGenerico<CargaDto> dao;

	@Override
	@AppReauniTxReadOnly
	public List<CargaDto> obtenerCargasPorFecha(Date fecha) {
		Date inicio = fecha;
		Date fin = Utilitarios.Fecha.agregarDiasFechaDate(fecha, +1);		
		String hsql = "select a from CargaDto a where a.cargaDtoPK.fecha between ? and ? order by a.cargaDtoPK.proceso desc";				
		try {
			return dao.obtenerDtosPorQuery(hsql, inicio,fin);
		} catch (DAOException e) {
			logger.error("CargaBOImple:obtenerCargasPorFecha", e);
			return null;
		}
	}

}
