package com.indra.pe.bbva.reauni.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.GestorDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.service.GestorBO;

@Service("gestorBO")
@Transactional
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class GestorBOImple implements GestorBO {
	
	private static Logger logger = Logger.getLogger(GestorBOImple.class);
	
	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<GestorDto> dao;
	
	@Override
	public List<GestorDto> obtenerGestores(GestorDto gestorDto) throws ServiceException{
		List<GestorDto> lista =  new ArrayList<GestorDto>();
		Map<String,Object> o =  new HashMap<String,Object>();	
		
		try {
			lista = dao.obtenerDtosConFiltros(GestorDto.class,o);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lista;
	}

	@Override
	public GestorDto obtenerGestor(SolicitudDto s) {
		GestorDto gestor = new GestorDto("", "", "");
		List<GestorDto> gestores =  new ArrayList<GestorDto>();
		
		if(s != null) {
			if(s.getTerritorioReceptorDto() != null && s.getOficinaReceptorDto() != null && s.getGestorReceptor() != null) {
				Map<String,Object> o =  new HashMap<String,Object>();
				o.put("codTerritorio", s.getTerritorioReceptorDto().getCodTerritorio());
				o.put("codOficina", s.getOficinaReceptorDto().getCodOficina());
				o.put("regGestor", s.getGestorReceptor());
				
				try {
					gestores = dao.obtenerDtosConFiltros(GestorDto.class, o);
					if(gestores != null && gestores.size() > 0) {
						gestor = gestores.get(0);
					}
				} catch (DAOException e) {
					logger.error("obtenerGestor ", e);
				}
			}
		}
		
		return gestor;
	} 
}
