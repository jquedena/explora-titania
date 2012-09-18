package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.ProductoDto;

public interface ProductoBO {
	
	public List<ProductoDto> obtenerProductos() throws ServiceException;
	public ProductoDto obtenerProducto(String producto) throws ServiceException;
}
