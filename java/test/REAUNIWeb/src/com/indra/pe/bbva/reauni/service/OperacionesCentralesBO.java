package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.OperacionCentralizadaDto;

public interface OperacionesCentralesBO {
	public void insertarOperacionesCentrales(OperacionCentralizadaDto operacionCentralizadaDto) throws ServiceException;
	public void actualizarOperacionesCentrales(OperacionCentralizadaDto operacionCentralizadaDto) throws ServiceException;
	public void eliminarOperacionesCentrales(Long id) throws ServiceException;
	public List<OperacionCentralizadaDto> obtenerListaSituaciones(OperacionCentralizadaDto operacionCentralizadaDto)throws ServiceException;
	public OperacionCentralizadaDto obtenerOperacionesCentralesPorId(Long id)throws ServiceException;
	public String validarExistenciaRegistro(String registro) throws ServiceException;
	public boolean noSeRepiteCombinacion(
			OperacionCentralizadaDto operacionCentralizadaDto)
			throws ServiceException;
}
