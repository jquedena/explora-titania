package com.indra.pe.bbva.reauni.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.indra.pe.bbva.core.dao.impl.DAOGenericoImpl;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.reauni.dao.DAOFechaCorteDeta;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDetaDto;
import com.indra.pe.bbva.reauni.model.entidad.FechaCorteDto;

@SuppressWarnings({"unused", "rawtypes", "unchecked", "deprecation"})
@Repository("fechaCorteDetaDAO")
public class DAOFechaCorteDetaImpl extends DAOGenericoImpl<FechaCorteDetaDto> implements DAOFechaCorteDeta<FechaCorteDetaDto>{
 
	private static final long serialVersionUID = 6154342653666929247L;

	@Autowired
	public DAOFechaCorteDetaImpl(@Qualifier("sessionFactoryReauni") SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	@Override
	public List<FechaCorteDetaDto> obtenerListaFechaCorteDeta(FechaCorteDetaDto fechaCorteDetaDto) throws DAOException {
		List<FechaCorteDetaDto> listaFechaCorteDeta = new ArrayList<FechaCorteDetaDto>();
		Session session = getSession();
		Criteria criteria = session.createCriteria(FechaCorteDetaDto.class);
		
		if(fechaCorteDetaDto.getFechaCorteDto()!=null && fechaCorteDetaDto.getFechaCorteDto().getFechaInicio()!=null){
			criteria.add(org.hibernate.criterion.Expression.ge("fechaCorteDto.fechaInicio", fechaCorteDetaDto.getFechaCorteDto().getFechaInicio()));
		}
		if(fechaCorteDetaDto.getFechaCorteDto()!=null && fechaCorteDetaDto.getFechaCorteDto().getFechaFin()!=null){
			criteria.add(org.hibernate.criterion.Expression.le("fechaCorteDto.fechaFin", fechaCorteDetaDto.getFechaCorteDto().getFechaFin()));
		}
 
		if(fechaCorteDetaDto.getRegistroResponsable()!=null){
			criteria.add(org.hibernate.criterion.Expression.like("registroResponsable","%"+fechaCorteDetaDto.getRegistroResponsable()+"%"));
		}
		
		List lista = criteria.list();
		if(lista!=null){
			listaFechaCorteDeta = (List<FechaCorteDetaDto>)lista;
		}
		
		session.close();
		return listaFechaCorteDeta;
	}
	
	@Override
	public List<FechaCorteDetaDto> obtenerFechasCorte(String registro) throws DAOException {
		List<FechaCorteDetaDto> listaFechaCorteDeta = new ArrayList<FechaCorteDetaDto>();
		Session session = getSession();
		Criteria criteria = session.createCriteria(FechaCorteDetaDto.class);
		
		Date fechaActual = Utilitarios.Fecha.obtenerFechaActualDate();
		
		String query = "select e from FechaCorteDetaDto e, FechaCorteDto fc  where e.fechaCorteDto.id = fc.id and fechaActual beetwen fc.fechaInicio and fc.fechaFin and ";
		
		
		List lista = criteria.list();
		if(lista!=null){
			listaFechaCorteDeta = (List<FechaCorteDetaDto>)lista;
		}
		session.close();
		return listaFechaCorteDeta;
	}

	@Override
	public BigDecimal validarFechaCorte(String registro, FechaCorteDto fechaCorte) throws DAOException {
		
		String query = "select d.cantidad_solicitud - (select count(1) from reauni.treauni_solicitud s where s.usuario_creacion = d.registro_responsable and s.fecha_creacion between f.fecha_inicio and (f.fecha_fin + 1)) cant " +
						"from reauni.treauni_fecha_corte_deta d ,reauni.treauni_fecha_corte f  where d.fecha_corte = f.id and f.estado_corte = 1008 and f.id="+fechaCorte.getId()+" and d.registro_responsable = '" +registro+"'";
		
		Session session = getSession();
		
		SQLQuery q = session.createSQLQuery(query);
		List x = q.list();
		session.close();
		if (x!=null && x.size()!=0) {
			
			return (BigDecimal) x.get(0);
		}else {
			return null;
		}		
	}
	
	@Override
	public boolean existeRegistroFechaCorte(String registro, FechaCorteDto fechaCorte, Long id) throws DAOException {
		
		String query = "select * from REAUNI.TREAUNI_FECHA_CORTE_DETA D WHERE D.REGISTRO_RESPONSABLE = '"+registro+"' AND D.FECHA_CORTE = "+ fechaCorte.getId() +  " AND D.ID != "+ id;
		
		Session session = getSession();
		
		SQLQuery q = session.createSQLQuery(query);
		List x = q.list();
		session.close();
		if (x!=null && x.size()!=0) {
			return true;
			
		}else {
			return false;
		}		
	}
	
	
	
	

}
