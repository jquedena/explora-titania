package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.SituacionDto;

public interface SituacionesBO {

	public void insertarSituacion(SituacionDto situacionDto) throws ServiceException;
	public void actualizarSituacion(SituacionDto situacionDto) throws ServiceException;
	public void eliminarSituacion(Long id) throws ServiceException;
	public List<SituacionDto> obtenerListaSituaciones(SituacionDto situacionDto)throws ServiceException;
	public SituacionDto obtenerSituacionPorId(Long id)throws ServiceException;
	public SituacionDto obtenerSituacionPorApicativoCodigo(String aplicativo, String situacion) throws ServiceException;
	public String verificarExistenciaSituacion(String codSituacion) throws ServiceException;
	
	
}
