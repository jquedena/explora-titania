package com.indra.pe.bbva.reauni.dao;

import java.util.List;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

public interface DAOSolicitud<SolicitudDto> extends DAOGenerico<SolicitudDto> {
	
	public List<SolicitudDto> listaSolicitudes(SolicitudDto solicitudDto, SessionMBean sessionMBean)throws DAOException;
	
	public List<ContratoDto> listaContratosEstadoPendiente(ContratoDto contratoDto, SessionMBean sessionMBean) throws DAOException;
	
	public List<ContratoDto> listaContratosFile(ContratoDto contratoDto, SessionMBean sessionMBean) throws DAOException;
	
	public boolean puedeCrearNuevaSolicitud (String codigoCliente, String ofiReceptor, String ofiCedente, Long codigoSolicitud) throws DAOException;
	
	public SolicitudDto obtenerSolicitud(ContratoDto contrato);
}
