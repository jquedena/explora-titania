package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;

public interface ParametroBO {
	
	public void insertar(CatalogoParametroDto catalogoParametro);
	public void editar(CatalogoParametroDto catalogoParametro);
	public CatalogoParametroDto obtenerCatalogoParametro(Long id);
	public List<CatalogoParametroDto> obtenerCatalogosParametro(CatalogoParametroDto catalogoParametro);
	public List<ParametroDto> obtenerTodosParametros();
	public List<CatalogoParametroDto> obtenerTodosCatalogosParametros();
	public List<ParametroDto> obtenerListaParametros(ParametroDto parametroDto) throws ServiceException;
	public ParametroDto obtenerParametro(ParametroDto parametroDto) throws ServiceException;
	public ParametroDto obtenerParametro(Long id) throws ServiceException;
	public List<ParametroDto> obtenerParametrosActivos(ParametroDto parametroDto) throws ServiceException;

}
