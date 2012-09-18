package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.TerritorioDto;

public interface TerritorioBO {
	
	public List<TerritorioDto> obtenerTerritorios(TerritorioDto territorioDto) throws ServiceException;
	public TerritorioDto obtenerTerritorio(TerritorioDto territorioDto) throws ServiceException;

}
