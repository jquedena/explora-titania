package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.PerfilDto;

public interface PerfilBO {
	public List<PerfilDto> obtenerListaPerfiles(PerfilDto perfilDto)throws ServiceException;
	public PerfilDto obtenerPerfilPorId(Long id)throws ServiceException;
}
