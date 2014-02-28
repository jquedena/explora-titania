package com.indra.pe.bbva.reauni.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.dao.DAOFechaCorte;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;
import com.indra.pe.bbva.reauni.service.FechaCorteBO;

@Service("fechaCorteBO")
public class FechaCorteBOImpl implements FechaCorteBO {

	@Autowired
	@Qualifier("fechaCorteDAO")
	private DAOFechaCorte<FechaCorteDto> fechaCorteDAO;
	
	@Override
	public void insertarFechaCorte(FechaCorteDto fechaCorteDto)
			throws ServiceException {
		try {
			fechaCorteDAO.save(fechaCorteDto);
		} catch (DAOException e) {
			throw new ServiceException(e); 
		}
	}

	@Override
	public void actualizarFechaCorte(FechaCorteDto fechaCorteDto)
			throws ServiceException {
		try {
			fechaCorteDAO.saveOrUpdate(fechaCorteDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminarFechaCorte(Long id) throws ServiceException {
		FechaCorteDto fechaCorteDto =  new FechaCorteDto();
		fechaCorteDto.setId(id);
		try {
			fechaCorteDAO.delete(fechaCorteDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<FechaCorteDto> obtenerListaFechaCorte(
			FechaCorteDto fechaCorteDto) throws ServiceException {
		List<FechaCorteDto> listaFechaCorteDto =  new ArrayList<FechaCorteDto>();
		Map<String,Object> parametro =  new HashMap<String,Object>();
		if(fechaCorteDto.getId()!=null){
			parametro.put("id",fechaCorteDto.getId());
		}	
		if(fechaCorteDto.getEstadoAcceso()!=null && !fechaCorteDto.getEstadoAcceso().equalsIgnoreCase("")){
			parametro.put("estadoAcceso",fechaCorteDto.getEstadoAcceso());
		}	
		if(fechaCorteDto.getNombreActividad()!=null && !fechaCorteDto.getNombreActividad().equalsIgnoreCase("")){
			parametro.put("nombreActividad",fechaCorteDto.getNombreActividad());
		}
		if(fechaCorteDto.getFechaInicio()!=null){
			parametro.put("fechaInicio",fechaCorteDto.getFechaInicio());
		}
		if(fechaCorteDto.getFechaFin()!=null){
			parametro.put("fechaFin",fechaCorteDto.getFechaFin());
		}	
		if(fechaCorteDto.getEstadoCorte()!=null && !fechaCorteDto.getEstadoCorte().equalsIgnoreCase("")){
			parametro.put("estadoCorte",fechaCorteDto.getEstadoCorte());
		}
		if(fechaCorteDto.getFechaCreacion()!=null){
			parametro.put("fechaCreacion",fechaCorteDto.getFechaCreacion());
		}
		if(fechaCorteDto.getFechaModificacion()!=null){
			parametro.put("fechaModificacion",fechaCorteDto.getFechaModificacion());
		}
		if(fechaCorteDto.getUsuarioCreacion()!=null && fechaCorteDto.getUsuarioCreacion().equalsIgnoreCase("")){
			parametro.put("usuarioCreacion",fechaCorteDto.getUsuarioCreacion());
		}
		if(fechaCorteDto.getUsuarioModificacion()!=null){
			parametro.put("usuarioModificacion",fechaCorteDto.getUsuarioModificacion());
		}
		try {
			listaFechaCorteDto = fechaCorteDAO.obtenerDtosConFiltros(FechaCorteDto.class,parametro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaFechaCorteDto;
	}

	@Override
	public FechaCorteDto obtenerFechaCortePorId(Long id)
			throws ServiceException {
		FechaCorteDto fechaCorteDto =  null;
		try {
			fechaCorteDto = fechaCorteDAO.obtenerDtoPorId(FechaCorteDto.class,id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return fechaCorteDto;
	}
	
	@Override
	public List<FechaCorteDto> obtenerListaFechaCortePorRangoFecha(FechaCorteDto fechaCorteDto) throws ServiceException {
		try {
			return fechaCorteDAO.obtenerListaFechaCorte(fechaCorteDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public FechaCorteDto obtenerFechaCorte(Date fecha, Long exceptoIdFc) throws DAOException {

		String query = "SELECT f FROM FechaCorteDto f where ? between f.fechaInicio and f.fechaFin and f.id != ? and f.estadoCorte=1008";
		List<Object> listaParametros =  new ArrayList<Object>();
        listaParametros.add(fecha);
        listaParametros.add(exceptoIdFc);
        
        List<FechaCorteDto> lista =  fechaCorteDAO.ejecutarQuery(query, listaParametros);
        
        if (lista!=null && lista.size()>0) {
        	return lista.get(0);
        }else {
        	return null;
        }
	}
}
