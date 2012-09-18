package com.indra.pe.bbva.reauni.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.PermisoPerfilDto;

public interface PermisoPerfilBO {
	
	public void insertarPermisoPerfil(PermisoPerfilDto permisoPerfilDto) throws ServiceException;
	public void actualizarPermisoPerfil(PermisoPerfilDto permisoPerfilDto) throws ServiceException;
	public void eliminarPermisoPerfil(Long id) throws ServiceException;
	public List<PermisoPerfilDto> obtenerListaPermisoPerfil(PermisoPerfilDto permisoPerfilDto)throws ServiceException;
	public PermisoPerfilDto obtenerPermisoPerfilPorId(Long id)throws ServiceException;
	public PermisoPerfilDto obtenerPerfilSegunRegistroOCargo(String registro,String codCargo)throws ServiceException;
	
}
