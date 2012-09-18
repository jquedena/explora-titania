package com.indra.pe.bbva.reauni.service;

import java.util.Date;
import java.util.List;

import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;

public interface FechaCorteBO {

	public void insertarFechaCorte(FechaCorteDto fechaCorteDto) throws ServiceException;
	public void actualizarFechaCorte(FechaCorteDto fechaCorteDto) throws ServiceException;
	public void eliminarFechaCorte(Long id) throws ServiceException;
	public List<FechaCorteDto> obtenerListaFechaCorte(FechaCorteDto fechaCorteDto)throws ServiceException;
	public FechaCorteDto obtenerFechaCortePorId(Long id)throws ServiceException;
	public List<FechaCorteDto> obtenerListaFechaCortePorRangoFecha(FechaCorteDto fechaCorteDto) throws ServiceException; 
	public FechaCorteDto obtenerFechaCorte(Date fecha, Long exceptoIdFc) throws DAOException;
}
