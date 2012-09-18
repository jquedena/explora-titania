package com.indra.pe.bbva.reauni.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.PermisoPerfilDto;
import com.indra.pe.bbva.reauni.service.PermisoPerfilBO;

@Service("permisoPerfilBO")
public class PermisoPerfilBOImpl implements PermisoPerfilBO {

	@Autowired
	private DAOGenerico<PermisoPerfilDto> permisoPerfilDAO;
	
	@Override
	public void insertarPermisoPerfil(PermisoPerfilDto permisoPerfilDto)throws ServiceException {
		try {
			permisoPerfilDAO.save(permisoPerfilDto);
		} catch (DAOException e) {
			throw new ServiceException(e); 
		}
	}

	@Override
	public void actualizarPermisoPerfil(PermisoPerfilDto permisoPerfilDto) throws ServiceException {
		try {
			permisoPerfilDAO.saveOrUpdate(permisoPerfilDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminarPermisoPerfil(Long id) throws ServiceException {
		PermisoPerfilDto permisoPerfilDto =  new PermisoPerfilDto();
		permisoPerfilDto.setId(id);
		try {
			permisoPerfilDAO.delete(permisoPerfilDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<PermisoPerfilDto> obtenerListaPermisoPerfil(PermisoPerfilDto permisoPerfilDto) throws ServiceException {
		List<PermisoPerfilDto> listaPermisoPerfilDto =  new ArrayList<PermisoPerfilDto>();
		Map<String,Object> parametro =  new HashMap<String,Object>();
		
		if(permisoPerfilDto.getId()!=null){
				parametro.put("id",permisoPerfilDto.getId());
		}	
		
		if(permisoPerfilDto.getValor()!=null){
			if(!permisoPerfilDto.getValor().equalsIgnoreCase("")){
				parametro.put("valor",permisoPerfilDto.getValor());
			}
		}
		
		if(permisoPerfilDto.getPerfil().getId()!=null){
			if(permisoPerfilDto.getPerfil().getId()!=-1L && permisoPerfilDto.getPerfil().getId()!=0L){
				parametro.put("perfil.id",permisoPerfilDto.getPerfil().getId());
			}	
		}
		
		try {
			listaPermisoPerfilDto = permisoPerfilDAO.obtenerDtosConFiltros(PermisoPerfilDto.class,parametro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaPermisoPerfilDto;
	}

	@Override
	public PermisoPerfilDto obtenerPermisoPerfilPorId(Long id)throws ServiceException {
		PermisoPerfilDto permisoPerfilDto =  null;
		try {
			permisoPerfilDto = permisoPerfilDAO.obtenerDtoPorId(PermisoPerfilDto.class,new BigDecimal(id));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return permisoPerfilDto;
	}

	@Override
	public PermisoPerfilDto obtenerPerfilSegunRegistroOCargo(String registro, String codCargo) throws ServiceException {
		PermisoPerfilDto permisoPerfilDto =  null;
		List<PermisoPerfilDto> listaPermisoPerfil  = null;
		Map<String,Object> parametro = null;
		try {
			parametro = new HashMap<String,Object>();
			parametro.put("valor",registro);
			listaPermisoPerfil = permisoPerfilDAO.obtenerDtosConFiltros(PermisoPerfilDto.class, parametro);
			if(listaPermisoPerfil.size()<=0){
				parametro = new HashMap<String,Object>();
				parametro.put("valor",codCargo);
				listaPermisoPerfil = permisoPerfilDAO.obtenerDtosConFiltros(PermisoPerfilDto.class, parametro);
			}
			if(listaPermisoPerfil.size()>0){
				permisoPerfilDto = listaPermisoPerfil.get(0); 
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return permisoPerfilDto;
	}

}
