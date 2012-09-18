package com.indra.pe.bbva.reauni.service.impl;

import java.math.BigDecimal;
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
import com.indra.pe.bbva.reauni.model.entidad.TipoPrestamoDto;
import com.indra.pe.bbva.reauni.service.TipoPrestamoBO;

@Service("tipoPrestamoBO")
public class TipoPrestamoBOImpl implements TipoPrestamoBO {

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<TipoPrestamoDto> tipoPrestamoDAO;
	
	@Override
	public void insertarTipoPrestamo(TipoPrestamoDto tipoPrestamoDto)
			throws ServiceException {
		try {
			tipoPrestamoDAO.save(tipoPrestamoDto);
		} catch (DAOException e) {
			throw new ServiceException(e); 
		}
	}

	@Override
	public void actualizarTipoPrestamo(TipoPrestamoDto tipoPrestamoDto)
			throws ServiceException {
		try {
			tipoPrestamoDAO.saveOrUpdate(tipoPrestamoDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminarTipoPrestamo(Long id) throws ServiceException {
		TipoPrestamoDto tipoPrestamoaDto =  new TipoPrestamoDto();
		tipoPrestamoaDto.setId(id);
		try {
			tipoPrestamoDAO.delete(tipoPrestamoaDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<TipoPrestamoDto> obtenerListaTipoPrestamos(TipoPrestamoDto tipoPrestamoDto) throws ServiceException {
		List<TipoPrestamoDto> listaTipoPrestamoDto =  new ArrayList<TipoPrestamoDto>();
		Map<String,Object> parametro =  new HashMap<String,Object>();
		if(tipoPrestamoDto.getId()!=null){
			parametro.put("id",tipoPrestamoDto.getId());
		}	
		if(tipoPrestamoDto.getCodigo()!=null && !tipoPrestamoDto.getCodigo().equalsIgnoreCase("")){
			parametro.put("codigo",tipoPrestamoDto.getCodigo());
		}	
		if(tipoPrestamoDto.getDescripcion()!=null && !tipoPrestamoDto.getDescripcion().equalsIgnoreCase("")){
			parametro.put("descripcion",tipoPrestamoDto.getDescripcion());
		}
		 
		try {
			listaTipoPrestamoDto = tipoPrestamoDAO.obtenerDtosConFiltrosEq(TipoPrestamoDto.class, parametro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaTipoPrestamoDto;
	}

	@Override
	public TipoPrestamoDto obtenerTipoPrestamoPorId(Long id)
			throws ServiceException {
		TipoPrestamoDto tipoPrestamoDto =  null;
		try {
			tipoPrestamoDto = tipoPrestamoDAO.obtenerDtoPorId(TipoPrestamoDto.class,new BigDecimal(id));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return tipoPrestamoDto;
	}
	
	@Override
	public String validarExistenciaTipoPrestamo(String codTipoPrestamo) throws ServiceException {
		TipoPrestamoDto obj = new TipoPrestamoDto();
		obj.setCodigo(codTipoPrestamo);
		List<TipoPrestamoDto> lista = this.obtenerListaTipoPrestamos(obj);
		if(lista!=null && lista.size()>0){
			return "El tipo de préstamo ya está registrado en el sistema";
		}else{
			return "";
		}
	}

}

