package com.indra.pe.bbva.reauni.service;

import java.math.BigDecimal;
import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDetaDto;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;

public interface AccesoFechaCorteBO {
	public void insertarAccesoFechaCorte(FechaCorteDetaDto fechaCorteDetaDto) throws ServiceException;
	public void actualizarAccesoFechaCorte(FechaCorteDetaDto fechaCorteDetaDto) throws ServiceException;
	public void eliminarAccesoFechaCorte(FechaCorteDetaDto fechaCorteDetaDto) throws ServiceException;
	public List<FechaCorteDetaDto> obtenerListaAccesoFechaCorte(FechaCorteDetaDto fechaCorteDetaDto)throws ServiceException;
	public FechaCorteDetaDto obtenerAccesoFechaCortePorId(Long id)throws ServiceException;
	public List<FechaCorteDetaDto> obtenerListaAccesoFechaCorteBusqueda(FechaCorteDetaDto fechaCorteDetaDto)throws ServiceException;
	
	public BigDecimal validarFechaCorte(String registro, FechaCorteDto fechaCorteDto) throws ServiceException;
	
	public boolean existeRegistroFechaCorte(String registro, FechaCorteDto fechaCorte, Long id) throws ServiceException;
}
