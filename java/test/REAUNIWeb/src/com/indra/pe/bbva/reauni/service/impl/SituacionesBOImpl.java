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
import com.indra.pe.bbva.reauni.model.entidad.SituacionDto;
import com.indra.pe.bbva.reauni.service.SituacionesBO;

@Service("situacionesBO")
public class SituacionesBOImpl implements SituacionesBO {

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<SituacionDto> situacionesDAO;
	
	@Override
	public void insertarSituacion(SituacionDto situacionDto) throws ServiceException {
		try {
			situacionesDAO.save(situacionDto);
		} catch (DAOException e) {
			throw new ServiceException(e); 
		}
	}

	@Override
	public void actualizarSituacion(SituacionDto situacionDto) throws ServiceException {
		try {
			situacionesDAO.saveOrUpdate(situacionDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminarSituacion(Long id) throws ServiceException {
		SituacionDto situacionesDto =  new SituacionDto();
		situacionesDto.setId(id);
		try {
			situacionesDAO.delete(situacionesDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<SituacionDto> obtenerListaSituaciones(SituacionDto situacionDto) throws ServiceException {
		List<SituacionDto> listaSituacionesDto =  new ArrayList<SituacionDto>();
		Map<String,Object> parametro =  new HashMap<String,Object>();
		if(situacionDto.getId()!=null){
			parametro.put("id",situacionDto.getId());
		}	
		if(situacionDto.getCodigoAplicativo()!=null && !situacionDto.getCodigoAplicativo().equalsIgnoreCase("")){
			parametro.put("codigoAplicativo",situacionDto.getCodigoAplicativo());
		}	
		if(situacionDto.getCodigoSituacion()!=null && !situacionDto.getCodigoSituacion().equalsIgnoreCase("")){
			parametro.put("codigoSituacion",situacionDto.getCodigoSituacion());
		}
		if(situacionDto.getDescripcion()!=null && !situacionDto.getDescripcion().equalsIgnoreCase("")){
			parametro.put("descripcion",situacionDto.getDescripcion());
		}	
		try {
			listaSituacionesDto = situacionesDAO.obtenerDtosConFiltros(SituacionDto.class,parametro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaSituacionesDto;
	}

	@Override
	public SituacionDto obtenerSituacionPorId(Long id) throws ServiceException {
		SituacionDto situacionDto =  null;
		try {
			situacionDto = situacionesDAO.obtenerDtoPorId(SituacionDto.class,new BigDecimal(id));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return situacionDto;
	}
	
	@Override
	public SituacionDto obtenerSituacionPorApicativoCodigo(String aplicativo, String situacion) throws ServiceException {
		SituacionDto situacionDto =  null;
		List<SituacionDto> listaSituacionesDto =  null;
		Map<String,Object> parametro =  new HashMap<String,Object>();		
		parametro.put("codigoAplicativo",aplicativo);
		parametro.put("codigoSituacion",situacion);
		
		try {
			listaSituacionesDto = situacionesDAO.obtenerDtosConFiltros(SituacionDto.class,parametro);
			if (listaSituacionesDto!=null && listaSituacionesDto.size()>0) {
				situacionDto =  listaSituacionesDto.get(0);
			}else {
				situacionDto =  null;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return situacionDto;
	}

	@Override
	public String verificarExistenciaSituacion(String codSituacion)throws ServiceException {
		SituacionDto obj = new SituacionDto();
		obj.setCodigoSituacion(codSituacion);
		List<SituacionDto> lista = this.obtenerListaSituaciones(obj);
		if(lista!=null && lista.size()>0){
			return "La situación ya se encuentra registrado en el sistema";
		}
		return "";
	}
	
}
