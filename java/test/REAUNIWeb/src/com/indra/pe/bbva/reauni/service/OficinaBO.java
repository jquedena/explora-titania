package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;

public interface OficinaBO {
	
	public List<OficinaDto> obtenerOficinas(OficinaDto oficinaDto) throws ServiceException;
	
	public OficinaDto obtenerOficina(String codOficina) throws ServiceException;
}
