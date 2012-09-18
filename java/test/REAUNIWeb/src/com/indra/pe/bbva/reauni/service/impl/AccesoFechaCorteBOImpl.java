package com.indra.pe.bbva.reauni.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.dao.DAOFechaCorteDeta;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDetaDto;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;
import com.indra.pe.bbva.reauni.service.AccesoFechaCorteBO;

@Service("accesoFechaCorteBO")
public class AccesoFechaCorteBOImpl implements AccesoFechaCorteBO {

	@Autowired
	@Qualifier("fechaCorteDetaDAO")
	private DAOFechaCorteDeta<FechaCorteDetaDto> fechaCorteDetDAO;
	
	@Override
	public void insertarAccesoFechaCorte(FechaCorteDetaDto fechaCorteDetaDto)
			throws ServiceException {
		try {
			fechaCorteDetDAO.save(fechaCorteDetaDto);
		} catch (DAOException e) {			
			throw new ServiceException(e); 
		}
	}

	@Override
	public void actualizarAccesoFechaCorte(FechaCorteDetaDto fechaCorteDetaDto)
			throws ServiceException {
		try {
			fechaCorteDetDAO.saveOrUpdate(fechaCorteDetaDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminarAccesoFechaCorte(FechaCorteDetaDto fechaCorteDetaDto) throws ServiceException {
		try {
			fechaCorteDetDAO.delete(fechaCorteDetaDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<FechaCorteDetaDto> obtenerListaAccesoFechaCorte(FechaCorteDetaDto fechaCorteDetaDto) throws ServiceException {
		
		List<FechaCorteDetaDto> listaFechaCorteDetaDto =  new ArrayList<FechaCorteDetaDto>();
		Map<String,Object> parametro =  new HashMap<String,Object>();
		if(fechaCorteDetaDto.getId()!=null){
			parametro.put("id",fechaCorteDetaDto.getId());
		}	
		if(fechaCorteDetaDto.getRegistroResponsable()!=null && !fechaCorteDetaDto.getRegistroResponsable().equalsIgnoreCase("")){
			parametro.put("registroResponsable",fechaCorteDetaDto.getRegistroResponsable());
		}	
	
		if(fechaCorteDetaDto.getCantidadSolicitud()!=null){
			parametro.put("cantidadSolicitud",fechaCorteDetaDto.getCantidadSolicitud());
		}
		if(fechaCorteDetaDto.getFechaCorteDto()!=null && fechaCorteDetaDto.getFechaCorteDto().getId()!=null){
			parametro.put("fechaCorte.id",fechaCorteDetaDto.getFechaCorteDto().getId());
		}	
		 
		try {
			listaFechaCorteDetaDto = fechaCorteDetDAO.obtenerDtosConFiltros(FechaCorteDetaDto.class,parametro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaFechaCorteDetaDto;
	}

	@Override
	public FechaCorteDetaDto obtenerAccesoFechaCortePorId(Long id)
			throws ServiceException {
		FechaCorteDetaDto fechaCorteDetaDto =  null;
		try {
			fechaCorteDetaDto = fechaCorteDetDAO.obtenerDtoPorId(FechaCorteDetaDto.class,new BigDecimal(id));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return fechaCorteDetaDto;
	}

	@Override
	public List<FechaCorteDetaDto> obtenerListaAccesoFechaCorteBusqueda(FechaCorteDetaDto fechaCorteDetaDto) throws ServiceException {
		try {
			return fechaCorteDetDAO.obtenerListaFechaCorteDeta(fechaCorteDetaDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public BigDecimal validarFechaCorte(String registro, FechaCorteDto fechaCorteDto) throws ServiceException {
		try {
			return fechaCorteDetDAO.validarFechaCorte(registro,fechaCorteDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}		
	}
	@Override
	public boolean existeRegistroFechaCorte(String registro, FechaCorteDto fechaCorte, Long id) throws ServiceException {
		try {
			return fechaCorteDetDAO.existeRegistroFechaCorte(registro, fechaCorte, id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}		
	}
 
}
