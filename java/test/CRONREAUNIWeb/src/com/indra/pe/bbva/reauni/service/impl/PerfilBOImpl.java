package com.indra.pe.bbva.reauni.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.pe.bbva.core.transactional.AppReauniTxReadOnly;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.PerfilDto;
import com.indra.pe.bbva.reauni.service.PerfilBO;

@Service("perfilBO")
public class PerfilBOImpl implements PerfilBO {

	@Autowired
	private DAOGenerico<PerfilDto> perfilDAO;
	
	@Override
	@AppReauniTxReadOnly
	public List<PerfilDto> obtenerListaPerfiles(PerfilDto perfilDto)
			throws ServiceException {
		List<PerfilDto> listaPerfilDto =  new ArrayList<PerfilDto>();
		Map<String,Object> parametro =  new HashMap<String,Object>();

		if(perfilDto.getId()!=null){
			parametro.put("id",perfilDto.getId());
		}	
		if(perfilDto.getDescripcion()!=null){
			if(!perfilDto.getDescripcion().equalsIgnoreCase("")){
				parametro.put("descripcion",perfilDto.getDescripcion());
			}
		}	
		if(perfilDto.getNombre()!=null){
			if(!perfilDto.getNombre().equalsIgnoreCase("")){
				parametro.put("nombre",perfilDto.getNombre());
			}
		}
		try {
			listaPerfilDto = perfilDAO.obtenerDtosConFiltros(PerfilDto.class,parametro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaPerfilDto;
	}

	@Override
	@AppReauniTxReadOnly
	public PerfilDto obtenerPerfilPorId(Long id) throws ServiceException {
		PerfilDto PerfilDto =  null;
		try {
			PerfilDto = perfilDAO.obtenerDtoPorId(PerfilDto.class,new BigDecimal(id));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return PerfilDto;
	}

}
