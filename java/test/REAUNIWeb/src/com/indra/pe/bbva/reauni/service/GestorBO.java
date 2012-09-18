package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.GestorDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;

public interface GestorBO {
	
	public List<GestorDto> obtenerGestores(GestorDto gestorDto) throws ServiceException;
	public GestorDto obtenerGestor(SolicitudDto solicitud);
}
