package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.TipoPrestamoDto;

public interface TipoPrestamoBO {

	public void insertarTipoPrestamo(TipoPrestamoDto tipoPrestamoDto) throws ServiceException;
	public void actualizarTipoPrestamo(TipoPrestamoDto tipoPrestamoDto) throws ServiceException;
	public void eliminarTipoPrestamo(Long id) throws ServiceException;
	public List<TipoPrestamoDto> obtenerListaTipoPrestamos(TipoPrestamoDto tipoPrestamoDto)throws ServiceException;
	public TipoPrestamoDto obtenerTipoPrestamoPorId(Long id)throws ServiceException;
	public String validarExistenciaTipoPrestamo(String codTipoPrestamo)throws ServiceException;
}
