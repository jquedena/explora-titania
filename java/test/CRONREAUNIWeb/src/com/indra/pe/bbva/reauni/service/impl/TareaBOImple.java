package com.indra.pe.bbva.reauni.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.pe.bbva.core.transactional.AppReauniTx;
import com.everis.pe.bbva.core.transactional.AppReauniTxReadOnly;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.model.entidad.CargaDto;
import com.indra.pe.bbva.reauni.model.entidad.TareaDto;
import com.indra.pe.bbva.reauni.service.TareaBO;
import com.indra.pe.bbva.reauni.task.thread.CargaDiaria;

@Service("tareaBO")
public class TareaBOImple implements TareaBO {
	private static Logger logger = Logger.getLogger(TareaBOImple.class);
	
	@Autowired
	private DAOGenerico<TareaDto> dao;
	
	@Autowired
	private DAOGenerico<CargaDto> daoCarga;
 
	@Override
	@AppReauniTx
	public void insertar(TareaDto tareaDto) {
		try {
			dao.save(tareaDto);
		} catch (DAOException e) {
			logger.error("Error ", e);
		}
		
	}

	@Override
	@AppReauniTxReadOnly
	public void editar(TareaDto tareaDto) {
		try {
			dao.saveOrUpdate(tareaDto);
		} catch (DAOException e) {
			logger.error("Error ", e);
		}
		
	}

	@Override
	@AppReauniTxReadOnly
	public TareaDto obtenerTarea(Long id) {
		try {
			return dao.obtenerDtoPorId(TareaDto.class, id);
		} catch (DAOException e) {
			logger.error("Error ", e);
			return null;
		}		
	}

	@Override
	@AppReauniTxReadOnly
	public List<TareaDto> obtenerTareas(TareaDto tareaDto) {
		Map<String,Object> m = new HashMap<String, Object>();
		if (tareaDto.getId()!=null && !tareaDto.getId().equals(0L))
			m.put("id", tareaDto.getId());
		if(tareaDto.getDescripcion()!=null && tareaDto.getDescripcion().length()!=0)
			m.put("descripcion", tareaDto.getDescripcion());
		if(tareaDto.getProceso()!=null && tareaDto.getProceso().length()!=0)
			m.put("proceso", tareaDto.getProceso());
		
		Map<String,String> f = new HashMap<String, String>();
		f.put("descripcion", "asc");
		
		try {
			return dao.obtenerDtosConFiltrosConOrden(TareaDto.class, m, f);
		} catch (DAOException e) {		
			logger.error("Error ", e);
			return null;
		}
	}
	
	@AppReauniTxReadOnly
	public void mostrarMemoria() {          
        try {
        	List<CargaDto> l = daoCarga.obtenerDtosConFiltros(CargaDto.class, null);
        	logger.info(l);
        }catch (Exception e) {
        	logger.error("Error ", e);
        }
    }
	
	/*EJECUION DE CARGA DIARIA A LAS 20:00 HRS DE LUNES A DOMINGO*/
	public void ejecutarCargaDiaria()  {
		Runnable  cargaDiariaThread = new CargaDiaria();
		cargaDiariaThread.run();
    }
 
}
