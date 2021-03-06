package com.indra.pe.bbva.reauni.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

@SuppressWarnings("rawtypes")
@Service("solicitudBO")
public class SolicitudBOImple implements SolicitudBO {
	private static Logger logger = Logger.getLogger(SolicitudBOImple.class);
	
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
			daoOficinaSolicitud.ejecutarSQL("UPDATE REAUNI.TREAUNI_OFICINA_SOLICITUD SET ESTADO="
							+ a + " WHERE ID=" + idOficinaSolicitud);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void actualizarOficinaInvolucrado(Long idOficinaInvolucrado,
			Long estado, Date fecha, String comentario) throws ServiceException {
		try {
			daoOficinaSolicitud.ejecutarSQL("UPDATE REAUNI.TREAUNI_OFICINA_INVOLUCRADO SET ESTADO="
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

	@Override
	public int existenContratos(Long id) {
		int count = -1;
		String query = "select count(1) from reauni.treauni_contrato a "
			+ "inner join reauni.treauni_oficina_solicitud b on a.oficina_solicitud=b.id "
			+ "where a.estado<>1037 and b.solicitud=" + id;
		try {
			List result = daoOficinaSolicitud.ejecutarSQL(query);
			if(result != null && result.size() > 0) {
				count = Integer.parseInt(result.get(0).toString());
			}
		} catch (DAOException e) {
			logger.error("existenContratos", e);
		}
		return count;
	}

	@Override
	public int validarContratos(Long id) {
		int count = -1;
		String query = "select count(1) from reauni.vreauni_gestion_files s "
			+ "where s.id<>" + id + " and s.codigo_contrato in( "
			+ "select t.codigo_contrato from reauni.vreauni_gestion_files t " 
			+ "where t.id=" + id + " and t.tramite_solicitud=1018 ) and s.tramite_solicitud not in (1018, 1022, 1021)";
		try {
			List result = daoOficinaSolicitud.ejecutarSQL(query);
			if(result != null && result.size() > 0) {
				count = Integer.parseInt(result.get(0).toString());
			}
		} catch (DAOException e) {
			logger.error("existenContratos", e);
		}
		return count;
	}
}
