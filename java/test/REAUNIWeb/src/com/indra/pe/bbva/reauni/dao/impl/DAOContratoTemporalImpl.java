package com.indra.pe.bbva.reauni.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.indra.pe.bbva.core.dao.impl.DAOGenericoImpl;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.dao.DAOContratoTemporal;
import com.indra.pe.bbva.reauni.model.entidad.ContratoTemporalDto;

@SuppressWarnings("unchecked")
@Repository("DAOContratoTemporalImpl")
public class DAOContratoTemporalImpl extends DAOGenericoImpl<ContratoTemporalDto> implements DAOContratoTemporal<ContratoTemporalDto>{
 
	private static final long serialVersionUID = 6154342653666929247L;
	private static Logger logger = Logger.getLogger(DAOContratoTemporalImpl.class);
	
	@Autowired
	public DAOContratoTemporalImpl(@Qualifier("sessionFactoryReauni") SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	@Override
	public List<ContratoTemporalDto> listaContratosTemporalesPorCliente(String codigoCliente) {
		List<ContratoTemporalDto> lista = null;
		String query = "";
		try {
	    	query += "select e from ContratoTemporalDto as e where e.codigoCentral = ";
			query += "'" + codigoCliente +"' and not exists (select c.codigoContrato from ContratoDto c, OficinaSolicitudDto os, SolicitudDto s where c.oficinaSolicitudDto.id = os.id and os.solicitudDto.id = s.id and s.tramiteSolicitudDto.id not in (1021) and s.codigoCliente = '"+codigoCliente+"' and c.codigoContrato = e.codigoContrato)" +
					" and exists (select x.codOficina from OficinaDto x where x.codOficina=e.oficina)";		
					
			Session session = getSession();
			Query q = session.createQuery(query);
			lista = q.list();
			session.close();   	
		} catch(Exception e) {
			logger.error("[SQL :: " + query + "]", e);
		}
    	return lista;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ContratoTemporalDto obtenerContratoTemporalesPorNumeroContrato(
			String numeroContrato) throws DAOException {
		List<ContratoTemporalDto> lista = null;
    	
    	Session session = getSession();
		Criteria criteria = session.createCriteria(ContratoTemporalDto.class);
		criteria.add(org.hibernate.criterion.Expression.eq("codigoContrato", numeroContrato));		
		lista = criteria.list();
		session.close();
		if (lista.size()>0) {
			return lista.get(0);
		}else {
			return null;
		}
	}

}
