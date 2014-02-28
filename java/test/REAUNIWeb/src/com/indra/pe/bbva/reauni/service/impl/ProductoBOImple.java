package com.indra.pe.bbva.reauni.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.ProductoDto;
import com.indra.pe.bbva.reauni.service.ProductoBO;

@Service("productoBO")
public class ProductoBOImple implements ProductoBO {

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<ProductoDto> dao;
	
	@Override
	public List<ProductoDto> obtenerProductos() throws ServiceException{
		List<ProductoDto> lista =  new ArrayList<ProductoDto>();
		Map<String,Object> o =  new HashMap<String,Object>();	
		
		try {
			lista = dao.obtenerDtosConFiltros(ProductoDto.class,o);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lista;
	}

	@Override
	public ProductoDto obtenerProducto(String producto) throws ServiceException {
		List<ProductoDto> productos =  new ArrayList<ProductoDto>();
		ProductoDto result =  new ProductoDto();
		result.setCodProd(producto);
		result.setDescProd("");
		Map<String,Object> o =  new HashMap<String,Object>();	
		o.put("codProd", producto);
		
		try {
			productos = dao.obtenerDtosConFiltros(ProductoDto.class, o);
			if(productos != null && productos.size() > 0) {
				result = productos.get(0);
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return result;
	}
}
