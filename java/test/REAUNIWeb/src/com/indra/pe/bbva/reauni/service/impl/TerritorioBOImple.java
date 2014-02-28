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
import com.indra.pe.bbva.reauni.model.entidad.TerritorioDto;
import com.indra.pe.bbva.reauni.service.TerritorioBO;

@Service("territorioBO")
public class TerritorioBOImple implements TerritorioBO {

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<TerritorioDto> dao;
		
	@Override
	public List<TerritorioDto> obtenerTerritorios(TerritorioDto territorioDto) throws ServiceException{
		List<TerritorioDto> listaTerritorioDto =  new ArrayList<TerritorioDto>();
		Map<String,Object> territorio =  new HashMap<String,Object>();
		if(territorioDto.getCodTerritorio()!=null){
			territorio.put("codTerritorio",territorioDto.getCodTerritorio());
		}	
		if(territorioDto.getDesTerritorio()!=null){
			territorio.put("descTerritorio",territorioDto.getDesTerritorio());				
		}	
		try {
			listaTerritorioDto = dao.obtenerDtosConFiltros(TerritorioDto.class,territorio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaTerritorioDto;
	}
	
    @Override
    public TerritorioDto obtenerTerritorio(TerritorioDto territorioDto) throws ServiceException {
    	TerritorioDto dto = null;
    	Map<String,Object> o =  new HashMap<String,Object>();
    	try {
    		if(territorioDto.getCodTerritorio()!=null){
    			o.put("codTerritorio",territorioDto.getCodTerritorio());
    				
    		}	
			List<TerritorioDto> lista = dao.obtenerDtosConFiltros(TerritorioDto.class,o);
			if(lista!=null && lista.size()>0){
				dto = lista.get(0);
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
    	return dto;
    } 
}
