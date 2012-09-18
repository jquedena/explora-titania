package com.indra.pe.bbva.reauni.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.indra.pe.bbva.core.dao.impl.DAOGenericoImpl;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.dao.DAOFechaCorte;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;

@SuppressWarnings({"rawtypes", "unchecked", "deprecation"})
@Repository("fechaCorteDAO")
public class DAOFechaCorteImpl extends DAOGenericoImpl<FechaCorteDto> implements
		DAOFechaCorte<FechaCorteDto> {

	private static final long serialVersionUID = 2260836895429222227L;

	@Autowired
	public DAOFechaCorteImpl(@Qualifier("sessionFactoryReauni")SessionFactory sessionFactory) {
		super(sessionFactory);
	}
 
	
	@Override
	public List<FechaCorteDto> obtenerListaFechaCorte(FechaCorteDto fechaCorteDto) throws DAOException {
		List<FechaCorteDto> listaFechaCorte = new ArrayList<FechaCorteDto>();
		Session session = null;
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(FechaCorteDto.class);
			
			if(fechaCorteDto.getFechaInicio()!=null){
				criteria.add(org.hibernate.criterion.Expression.ge("fechaInicio", fechaCorteDto.getFechaInicio()));
			}
			if(fechaCorteDto.getFechaFin()!=null){
				criteria.add(org.hibernate.criterion.Expression.le("fechaFin", fechaCorteDto.getFechaFin()));
			}
			if(fechaCorteDto.getFechaCreacion()!=null){
				criteria.add(org.hibernate.criterion.Expression.eq("fechaCreacion", fechaCorteDto.getFechaCreacion()));
			}
			if(fechaCorteDto.getNombreActividad()!=null){
				criteria.add(org.hibernate.criterion.Expression.like("nombreActividad","%"+fechaCorteDto.getNombreActividad()+"%"));
			}
			if(fechaCorteDto.getEstadoCorte()!=null){
				criteria.add(org.hibernate.criterion.Expression.eq("estadoCorte", fechaCorteDto.getEstadoCorte()));
			}
			List lista = criteria.list();
			
			if(lista!=null){
				listaFechaCorte = (List<FechaCorteDto>)lista;
			}			
		}finally{
			session.close();
		}	
		return listaFechaCorte;
	}

}
