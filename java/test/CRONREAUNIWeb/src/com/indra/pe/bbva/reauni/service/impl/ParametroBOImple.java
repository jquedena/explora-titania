package com.indra.pe.bbva.reauni.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.everis.pe.bbva.core.transactional.AppReauniTx;
import com.everis.pe.bbva.core.transactional.AppReauniTxReadOnly;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.CatalogoParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.service.ParametroBO;

@Service("parametroBO")
public class ParametroBOImple implements ParametroBO {
	private static Logger logger = Logger.getLogger(ParametroBOImple.class);
	
	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<CatalogoParametroDto> dao;
	
	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<ParametroDto> daoParametro;

	@Override
	@AppReauniTx
	public void insertar(CatalogoParametroDto catalogoParametro) {
		try {
			dao.save(catalogoParametro);
		} catch (DAOException e) {
			logger.error("Error en utilitario ", e);
		}
	}
	
	@Override
	@AppReauniTx
	public void editar(CatalogoParametroDto catalogoParametro) {
		try {
			dao.saveOrUpdate(catalogoParametro);
		} catch (DAOException e) {
			logger.error("Error en utilitario ", e);
		}
	}

	@Override
	@AppReauniTxReadOnly
	public CatalogoParametroDto obtenerCatalogoParametro(Long id) {
		try {
			return dao.obtenerDtoPorId(CatalogoParametroDto.class, id);
		} catch (DAOException e) {
			logger.error("Error en utilitario ", e);
			return null;
		}		
	}

	@Override
	@AppReauniTxReadOnly
	public List<CatalogoParametroDto> obtenerCatalogosParametro(CatalogoParametroDto catalogoParametro) {
		
		Map<String,Object> m = new HashMap<String, Object>();
		if (catalogoParametro.getId()!=null && !catalogoParametro.getId().equals(0L))
			m.put("id", catalogoParametro.getId());
		if(catalogoParametro.getDescripcion()!=null && catalogoParametro.getDescripcion().length()!=0)
			m.put("descripcion", catalogoParametro.getDescripcion());
		
		Map<String,String> f = new HashMap<String, String>();
		f.put("descripcion", "asc");
		
		try {
			return dao.obtenerDtosConFiltrosConOrden(CatalogoParametroDto.class, m, f);
		} catch (DAOException e) {		
			logger.error("Error en utilitario ", e);
			return null;
		}
	}

	@Override
	@AppReauniTxReadOnly
	public List<ParametroDto> obtenerTodosParametros() {
		Map<String,Object> m = new HashMap<String, Object>();		
		Map<String,String> f = new HashMap<String, String>();
		f.put("descripcion", "asc");
		
		try {
			return daoParametro.obtenerDtosConFiltrosConOrden(ParametroDto.class, m, f);
		} catch (DAOException e) {		
			logger.error("Error en utilitario ", e);
			return null;
		}
	}

	@Override
	@AppReauniTxReadOnly
	public List<CatalogoParametroDto> obtenerTodosCatalogosParametros() {
		Map<String,Object> m = new HashMap<String, Object>();		
		Map<String,String> f = new HashMap<String, String>();
		f.put("descripcion", "asc");
		
		try {
			return dao.obtenerDtosConFiltrosConOrden(CatalogoParametroDto.class, m, f);
		} catch (DAOException e) {		
			logger.error("Error en utilitario ", e);
			return null;
		}
	}
	
	@Override
	@AppReauniTxReadOnly
	public List<ParametroDto> obtenerListaParametros(ParametroDto parametroDto) throws ServiceException {
		List<ParametroDto> listaParametroDto =  new ArrayList<ParametroDto>();
		Map<String,Object> parametro =  new HashMap<String,Object>();
		if(parametroDto.getId()!=null){
			parametro.put("id",parametroDto.getId());
		}	
		if(parametroDto.getCatalogoParametroDto()!=null){
			if(parametroDto.getCatalogoParametroDto().getId()!=null){	
				parametro.put("catalogoParametroDto.id",parametroDto.getCatalogoParametroDto().getId());
			}	
		}
		
		try {
			listaParametroDto = daoParametro.obtenerDtosConFiltros(ParametroDto.class,parametro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaParametroDto;
	}
	
    @Override
    @AppReauniTxReadOnly
    public ParametroDto obtenerParametro(ParametroDto parametroDto) throws ServiceException {
    	ParametroDto objParametroDto = null;
    	Map<String,Object> parametro =  new HashMap<String,Object>();
    	try {
    		if(parametroDto.getCatalogoParametroDto()!=null){
    			if(parametroDto.getCatalogoParametroDto().getId()!=null){	
    				parametro.put("catalogoParametroDto.id",parametroDto.getCatalogoParametroDto().getId());
    			}	
    		}	
			List<ParametroDto> listaParametroDto = daoParametro.obtenerDtosConFiltros(ParametroDto.class,parametro);
			if(listaParametroDto!=null && listaParametroDto.size()>0){
				objParametroDto = listaParametroDto.get(0);
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
    	return objParametroDto;
    }

	@Override
	@AppReauniTxReadOnly
	public ParametroDto obtenerParametro(Long id) throws ServiceException {
		try {
			return daoParametro.obtenerDtoPorId(ParametroDto.class, id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@AppReauniTxReadOnly
	public List<ParametroDto> obtenerParametrosActivos(ParametroDto parametroDto) throws ServiceException {
		List<ParametroDto> listaParametroDto =  new ArrayList<ParametroDto>();
		
		Map<String,Object> filtro =  new HashMap<String,Object>();
			
		if(parametroDto.getCatalogoParametroDto()!=null){
			if(parametroDto.getCatalogoParametroDto().getId()!=null){	
				filtro.put("catalogoParametroDto.id",parametroDto.getCatalogoParametroDto().getId());
			}	
		}
		
		if(parametroDto.getParametroPadreDto()!=null){
			if(parametroDto.getParametroPadreDto().getId()!=null){	
				filtro.put("parametroPadreDto",parametroDto.getParametroPadreDto().getId());
			}	
		}
		
		Map<String,String> orden =  new HashMap<String,String>();
		orden.put("descripcion", "asc");
		
		try {
			listaParametroDto = daoParametro.obtenerDtosConFiltrosConOrden(ParametroDto.class, filtro, orden);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaParametroDto;
	} 
 
}
