package com.indra.pe.bbva.reauni.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.dao.DAOContratoTemporal;
import com.indra.pe.bbva.reauni.dao.DAOSolicitud;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.ContratoTemporalDto;
import com.indra.pe.bbva.reauni.model.entidad.EstadoSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaInvolucradoDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.service.SolicitudBO;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

@Service("solicitudBO")
@Transactional
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SolicitudBOImple implements SolicitudBO {

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<SolicitudDto> dao;

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<OficinaSolicitudDto> daoOficinaSolicitud;

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<ContratoDto> daoContrato;

	@Resource
	private DAOSolicitud<SolicitudDto> daoSolicitud;

	@Resource
	private DAOSolicitud<EstadoSolicitudDto> daoEstado;

	@Resource
	private DAOSolicitud<OficinaInvolucradoDto> daoOficinaInvolucrado;

	@Resource
	private DAOContratoTemporal<ContratoTemporalDto> daoContratoTemporal;

	@Override
	public void insertar(SolicitudDto solicitudDto) throws ServiceException {
		try {
			dao.save(solicitudDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void editar(SolicitudDto solicitudDto) throws ServiceException {
		try {
			// dao.update(solicitudDto);
			dao.merge(solicitudDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public SolicitudDto obtener(Long id) throws ServiceException {
		SolicitudDto dto = null;
		try {
			dto = dao.obtenerDtoPorId(SolicitudDto.class, id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return dto;
	}

	@Override
	public List<SolicitudDto> obtenerSolicitudes(SolicitudDto solicitudDto,
			SessionMBean sessionMBean) throws ServiceException {

		try {
			return daoSolicitud.listaSolicitudes(solicitudDto, sessionMBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminarContrato(ContratoDto contratoDto)
			throws ServiceException {
		try {
			daoContrato.delete(contratoDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void eliminarOficinaSolicitud(OficinaSolicitudDto oficinaSolicitudDto)
			throws ServiceException {
		try {
			daoOficinaSolicitud.delete(oficinaSolicitudDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void guardarOficinaSolicitud(OficinaSolicitudDto oficinaSolicitudDto)
			throws ServiceException {
		try {
			this.daoOficinaSolicitud.saveOrUpdate(oficinaSolicitudDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<ContratoTemporalDto> obtenerContratosTemporalesCliente(
			String codigoCentral) throws ServiceException {

		List<ContratoTemporalDto> lista;
		try {
			lista = daoContratoTemporal.listaContratosTemporalesPorCliente(codigoCentral);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return lista;
	}

	@Override
	public List<ContratoDto> listaContratosEstadoPendiente(
			ContratoDto contratoDto, SessionMBean sessionMBean)
			throws ServiceException {
		List<ContratoDto> listaContratos = null;

		try {
			listaContratos = daoSolicitud.listaContratosEstadoPendiente(
					contratoDto, sessionMBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaContratos;

	}

	@Override
	public void guardarContratos(List<ContratoDto> listaContratos)
			throws ServiceException {
		try {
			daoContrato.guardarColeccion(listaContratos);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void guardarContrato(ContratoDto contratoDto) throws ServiceException {
		try {
			daoContrato.saveOrUpdate(contratoDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public ContratoTemporalDto obtenerContratoTemporalesPorNumeroContrato(
			String numeroContrato) throws ServiceException {
		try {
			return daoContratoTemporal.obtenerContratoTemporalesPorNumeroContrato(numeroContrato);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public List<ContratoDto> listaContratosFile(ContratoDto contratoDto,
			SessionMBean sessionMBean) throws ServiceException {
		List<ContratoDto> listaContratos = null;

		try {
			listaContratos = daoSolicitud.listaContratosFile(contratoDto,
					sessionMBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaContratos;
	}

	@Override
	public void insertarOficinaSolicitud(OficinaSolicitudDto os)
			throws ServiceException {
		try {
			daoOficinaSolicitud.save(os);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void editarOficinaSolicitud(OficinaSolicitudDto os)
			throws ServiceException {
		try {
			// daoOficinaSolicitud.update(os);
			daoOficinaSolicitud.merge(os);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public OficinaSolicitudDto obtenerOficinaSolicitud(Long id)
			throws ServiceException {
		OficinaSolicitudDto dto = null;
		try {
			dto = daoOficinaSolicitud.obtenerDtoPorId(
					OficinaSolicitudDto.class, id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return dto;
	}

	@Override
	public void insertarEstado(EstadoSolicitudDto estado)
			throws ServiceException {
		try {
			daoEstado.save(estado);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void editarEstado(EstadoSolicitudDto estado) throws ServiceException {
		try {
			daoEstado.update(estado);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void insertarOficinaInvolucrado(OficinaInvolucradoDto oi)
			throws ServiceException {
		try {
			daoOficinaInvolucrado.save(oi);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void editarOficinaInvolucrado(OficinaInvolucradoDto oi)
			throws ServiceException {
		try {
			// daoOficinaInvolucrado.update(oi);
			daoOficinaInvolucrado.merge(oi);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void cambiarEstadoOficinaSolicitud(Long idOficinaSolicitud,
			Boolean estado) throws ServiceException {
		try {
			int a = 0;
			if (estado)
				a = 1;
			else
				a = 0;
			daoOficinaSolicitud
					.ejecutarSQL("UPDATE REAUNI.TREAUNI_OFICINA_SOLICITUD SET ESTADO="
							+ a + " WHERE ID=" + idOficinaSolicitud);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void actualizarOficinaInvolucrado(Long idOficinaInvolucrado,
			Long estado, Date fecha, String comentario) throws ServiceException {
		try {
			daoOficinaSolicitud
					.ejecutarSQL("UPDATE REAUNI.TREAUNI_OFICINA_INVOLUCRADO SET ESTADO="
							+ estado
							+ " comentario = '"
							+ comentario
							+ "' WHERE ID=" + idOficinaInvolucrado);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean puedeCrearNuevaSolicitud(String codigoCliente,
			String ofiReceptor, String ofiCedente, Long codigoSolicitud)
			throws ServiceException {
		boolean retorno = false;
		try {
			retorno = daoSolicitud.puedeCrearNuevaSolicitud(codigoCliente, ofiReceptor, ofiCedente, codigoSolicitud);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return retorno;

	}

	@Override
	public SolicitudDto obtenerSolicitud(ContratoDto contrato) {
		return daoSolicitud.obtenerSolicitud(contrato);
	}
}
