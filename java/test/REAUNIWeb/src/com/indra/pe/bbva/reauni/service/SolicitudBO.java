package com.indra.pe.bbva.reauni.service;

import java.util.Date;
import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.ContratoTemporalDto;
import com.indra.pe.bbva.reauni.model.entidad.EstadoSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaInvolucradoDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

public interface SolicitudBO {
	
	public void insertar(SolicitudDto solicitudDto) throws ServiceException;
	public void editar(SolicitudDto solicitudDto) throws ServiceException;
	public SolicitudDto obtener(Long id) throws ServiceException;
	public List<SolicitudDto> obtenerSolicitudes(SolicitudDto solicitudDto, SessionMBean sessionMBean) throws ServiceException;
	
	public void eliminarContrato(ContratoDto contratoDto) throws ServiceException;
	public void eliminarOficinaSolicitud(OficinaSolicitudDto oficinaSolicitudDto) throws ServiceException;
	
	public void guardarOficinaSolicitud (OficinaSolicitudDto oficinaSolicitudDto)  throws ServiceException;
	
	public List<ContratoTemporalDto> obtenerContratosTemporalesCliente (String codigoCentral)  throws ServiceException;
	
	public ContratoTemporalDto obtenerContratoTemporalesPorNumeroContrato (String numeroContrato)  throws ServiceException;
	
	public List<ContratoDto> listaContratosEstadoPendiente(ContratoDto contratoDto, SessionMBean sessionMBean)  throws ServiceException;
	
	public List<ContratoDto> listaContratosFile(ContratoDto contratoDto, SessionMBean sessionMBean)  throws ServiceException;
	
	public void guardarContratos(List<ContratoDto> listaContratos) throws ServiceException;
	
	public void guardarContrato(ContratoDto contratoDto)
	throws ServiceException;

	public void insertarOficinaSolicitud(OficinaSolicitudDto os) throws ServiceException;
	
	public void insertarEstado(EstadoSolicitudDto estado) throws ServiceException;
	public void editarEstado(EstadoSolicitudDto estado) throws ServiceException;
	
	public void actualizarOficinaInvolucrado(Long idOficinaInvolucrado,
			Long estado, Date fecha, String comentario) throws ServiceException;
	public void cambiarEstadoOficinaSolicitud (Long idOficinaSolicitud, Boolean estado) throws ServiceException;
	public void editarOficinaInvolucrado (OficinaInvolucradoDto oi) throws ServiceException;
	public void insertarOficinaInvolucrado (OficinaInvolucradoDto oi) throws ServiceException;
	
	public void editarOficinaSolicitud(OficinaSolicitudDto os) throws ServiceException;
	
	public OficinaSolicitudDto obtenerOficinaSolicitud(Long id) throws ServiceException;
	public boolean puedeCrearNuevaSolicitud (String codigoCliente, String ofiReceptor, String ofiSolicitante, Long codigoSolicitud)throws ServiceException;
	
	public SolicitudDto obtenerSolicitud(ContratoDto contrato);
}