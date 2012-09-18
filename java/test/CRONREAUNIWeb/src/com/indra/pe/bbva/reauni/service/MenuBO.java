package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.OpcionMenuDto;


public interface MenuBO {
	
	public List<OpcionMenuDto> obtenerListaOpcionesMenu(Long codPerfil) throws ServiceException;

}
