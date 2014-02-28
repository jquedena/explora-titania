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
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;
import com.indra.pe.bbva.reauni.service.OficinaBO;

@Service("oficinaBO")
public class OficinaBOImple implements OficinaBO {

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<OficinaDto> dao;

	@Override
	public List<OficinaDto> obtenerOficinas(OficinaDto oficinaDto) throws ServiceException{
		List<OficinaDto> lista =  new ArrayList<OficinaDto>();
		Map<String,Object> o =  new HashMap<String,Object>();
		if(oficinaDto.getCodOficina()!=null){
			o.put("codOficina",oficinaDto.getCodOficina());
		}	
		
		try {
			lista = dao.obtenerDtosConFiltros(OficinaDto.class,o);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lista;
	}
	
	@Override
	public OficinaDto obtenerOficina(String codOficina) throws ServiceException{
		List<OficinaDto> lista =  new ArrayList<OficinaDto>();
		Map<String,Object> o =  new HashMap<String,Object>();
		
		o.put("codOficina",codOficina);

		try {
			lista = dao.obtenerDtosConFiltros(OficinaDto.class,o);
			if (lista.size()>0) {
				return lista.get(0);
			}else {
				return null;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
