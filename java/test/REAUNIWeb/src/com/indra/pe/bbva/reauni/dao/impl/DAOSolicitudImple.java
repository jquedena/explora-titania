package com.indra.pe.bbva.reauni.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.indra.pe.bbva.core.dao.impl.DAOGenericoImpl;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.reauni.dao.DAOSolicitud;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

@SuppressWarnings({"unchecked", "unused"})
@Repository("DAOSolicitudImpl")
public class DAOSolicitudImple extends DAOGenericoImpl<SolicitudDto> implements
		DAOSolicitud<SolicitudDto> {

	private static final long serialVersionUID = 6154342653666929247L;
	private static Logger logger = Logger.getLogger(DAOSolicitudImple.class);
	
	@Autowired
	public DAOSolicitudImple(@Qualifier("sessionFactoryReauni") SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public List<SolicitudDto> listaSolicitudes(SolicitudDto solicitudDto, SessionMBean sessionMBean) throws DAOException {
		List<SolicitudDto> lista = null;
		String query = "select e from SolicitudDto e ";
		String condition = "";
		String codTerritorio = "";
		
		if (solicitudDto != null) {
			if (solicitudDto.getId() != null && !solicitudDto.getId().equals(0L)) {
				if(condition.length() > 0) condition += " and "; 
				condition += "e.id = " + solicitudDto.getId();
			}

			if (solicitudDto.getCodigoCliente() != null && solicitudDto.getCodigoCliente().length() > 0) {
				if(condition.length() > 0) condition += " and ";
				condition += "e.codigoCliente = '" + solicitudDto.getCodigoCliente() + "'";
			}

			if (solicitudDto.getNombreCliente() != null && solicitudDto.getNombreCliente().length() > 0) {
				if(condition.length() > 0) condition += " and ";
				condition += "upper(e.nombreCliente) like '%" + solicitudDto.getNombreCliente().toUpperCase() + "%'";
			}

			if (solicitudDto.getTipoDto() != null && !solicitudDto.getTipoDto().getId().equals(1003L)) {
				if(condition.length() > 0) condition += " and ";
				condition += "e.tipoDto.id = " + solicitudDto.getTipoDto().getId();
			}

			if (solicitudDto.getCodigoSolicitud() != null && solicitudDto.getCodigoSolicitud().length() > 0) {
				if(condition.length() > 0) condition += " and ";
				condition += "e.codigoSolicitud = '" + solicitudDto.getCodigoSolicitud() + "'";
			}

			if (solicitudDto.getTramiteSolicitudDto() != null && !solicitudDto.getTramiteSolicitudDto().getId().equals(1003L)) {
				if(condition.length() > 0) condition += " and ";
				condition += "e.tramiteSolicitudDto.id = " + solicitudDto.getTramiteSolicitudDto().getId();
			}
			
			if (solicitudDto.getFechaInicio() != null && solicitudDto.getFechaHasta() != null) {
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				if(condition.length() > 0) condition += " and ";
				condition += "(e.fechaCreacion >= to_date('" + formater.format(solicitudDto.getFechaInicio()) + " 00:00:00', 'dd/MM/yyyy  HH24:mi:ss')";
				condition += " and e.fechaCreacion <= to_date('" + formater.format(solicitudDto.getFechaHasta()) + " 23:59:59', 'dd/MM/yyyy  HH24:mi:ss') )";
			}
			
			if(condition.length() > 0) condition = " where (" + condition + ") ";
			
			if (sessionMBean.getRol() == Constantes.Rol.GTE) {
				if(esGerenteTerritorial(sessionMBean)) {
					codTerritorio = sessionMBean.getCodOficina();
				} else {
					codTerritorio = sessionMBean.getCodTerritorio();
				}
				
				if (condition.length() > 0)
					condition += " and (";
				else
					condition += " where ( ";

				condition += "e.oficinaSolicitante='" + codTerritorio + "'";
				condition += " or e.oficinaSolicitante in (select codOficina from OficinaDto where territorioDto.codTerritorio='" + codTerritorio + "')";
				condition += " or e.oficinaReceptorDto.territorioDto.codTerritorio = '" + codTerritorio + "'";
				condition += " or e.id in (select osx.solicitudDto.id from OficinaSolicitudDto osx where (osx.solicitudDto.id = e.id and osx.oficinaDto.territorioDto.codTerritorio = '" + codTerritorio + "'))";
				condition += ")";
				
			}
			
			if (solicitudDto.getOficSolicitante() != null || solicitudDto.getOficinaReceptora() != null || solicitudDto.getOficinaCedente() != null) {
				if(condition.length() > 0) condition += " and (";
				else condition += " where (";
					
				if (solicitudDto.getOficSolicitante() != null) {
					condition += " e.oficinaSolicitante = '" + solicitudDto.getOficSolicitante().getCodOficina() + "'";
				}
				
				if(solicitudDto.getOficinaReceptora() != null) {
					if (solicitudDto.getOficSolicitante() != null) {
						condition += " or ";
					}	
					condition += " e.oficinaReceptorDto.codOficina = '" + solicitudDto.getOficinaReceptora().getCodOficina() + "'";
				}
				
				if(solicitudDto.getOficinaCedente()!= null) {
					if (solicitudDto.getOficSolicitante() != null || solicitudDto.getOficinaReceptora() != null) {
						condition += " or ";
					}
					condition += " exists (select osx.solicitudDto.id from OficinaSolicitudDto osx where (osx.solicitudDto.id = e.id and osx.oficinaDto.codOficina = '" + solicitudDto.getOficinaCedente().getCodOficina() + "'))";
				}
				
				condition += ")";
			}
		}
		
		query += condition;
		query += " order by e.id desc";
		logger.info(query);
		Session session = getSession();
		Query q = session.createQuery(query);
		lista = q.list();
		session.close();
		return lista;
	}

	@Override
	public List<ContratoDto> listaContratosEstadoPendiente(ContratoDto contratoDto, SessionMBean sessionMBean) throws DAOException {
		List<ContratoDto> listaContratos = null;

		String query = "select e from ContratoDto e join fetch e.oficinaSolicitudDto os join fetch os.solicitudDto s, OperacionCentralizadaDto o ";
		query += "where e.producto=o.producto ";
		query += "and o.registro='" + sessionMBean.getRegistro() + "' ";
		query += "and os.estadoEvaluacion = 1 ";
		query += "and e.oficinaSolicitudDto.solicitudDto.tramiteSolicitudDto.id not in (1018, 1022) ";

		String condition = "";
		String codTerritorio = "";
		
		if(contratoDto != null) {
			if (contratoDto.getCodigoContrato() != null	&& contratoDto.getCodigoContrato().length() != 0) {
				condition += " and e.codigoContrato = '" + contratoDto.getCodigoContrato() + "'";
			}
	
			if (contratoDto.getOficinaSolicitudDto().getSolicitudDto().getCodigoCliente() != null && contratoDto.getOficinaSolicitudDto().getSolicitudDto().getCodigoCliente().length() != 0) {
				condition += " and e.oficinaSolicitudDto.solicitudDto.codigoCliente = '" + contratoDto.getOficinaSolicitudDto().getSolicitudDto().getCodigoCliente() + "'";
			}
	
			if (contratoDto.getEstadoDto() != null && !contratoDto.getEstadoDto().getId().equals(1003L)) {
				condition += " and e.estadoDto.id = " + contratoDto.getEstadoDto().getId();
			}
			
			SolicitudDto s = null;
			
			if(contratoDto.getOficinaSolicitudDto() != null && contratoDto.getOficinaSolicitudDto().getSolicitudDto() != null) {
				s = contratoDto.getOficinaSolicitudDto().getSolicitudDto();
				
				if (s.getCodigoSolicitud() != null && s.getCodigoSolicitud().length()!=0){
					condition += " and e.oficinaSolicitudDto.solicitudDto.codigoSolicitud = '" + s.getCodigoSolicitud() + "'";	
				}
				
				if (s.getFechaInicio() != null && s.getFechaHasta() != null) {
					SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
					// if(condition.length() > 0) condition += " and ";
					condition += " and (e.oficinaSolicitudDto.solicitudDto.fechaCreacion >= to_date('" + formater.format(s.getFechaInicio()) + " 00:00:00', 'dd/MM/yyyy  HH24:mi:ss')";
					condition += " and e.oficinaSolicitudDto.solicitudDto.fechaCreacion <= to_date('" + formater.format(s.getFechaHasta()) + " 23:59:59', 'dd/MM/yyyy  HH24:mi:ss') )";
				}
				
				if (s.getOficinaCedente() != null || s.getOficinaReceptora() != null || s.getOficSolicitante() != null) {
					condition += " and ( ";
					if (s.getOficinaCedente() != null) {
						condition += "os.oficinaDto.codOficina = '" + s.getOficinaCedente().getCodOficina() + "'";
					}
					if (s.getOficSolicitante() != null || s.getOficinaReceptora() != null) {
						if(s.getOficinaCedente() != null) {
							condition += " or ";
						}
						// condition += " exists ( select e.id from SolicitudDto e  where e.id=os.solicitudDto.id and ( ";
						condition += " e.oficinaSolicitudDto.solicitudDto.id in (select e.id from SolicitudDto e  where ( ";
						if (s.getOficSolicitante() != null) {
							condition += "e.oficinaSolicitante = '" + s.getOficSolicitante().getCodOficina() + "'";
						}
						if (s.getOficSolicitante() != null && s.getOficinaReceptora() != null) {
							condition += " or ";
						}
						if (s.getOficinaReceptora() != null) {
							condition += "e.oficinaReceptorDto.codOficina = '" + s.getOficinaReceptora().getCodOficina() + "'";
						}
						condition += " ) )";
					}
					condition += " )";
				}
			}
		}
		
		query += condition;
		query += " order by s.fechaCreacion desc";
		logger.info(query);
		Session session = getSession();
		Query q = session.createQuery(query);
		listaContratos = q.list();
		session.close();
		
		return listaContratos;
	}

	@Override
	public List<ContratoDto> listaContratosFile(ContratoDto contratoDto, SessionMBean sessionMBean) throws DAOException {
		List<ContratoDto> listaContratos = null;
		
		String query = "select e from ContratoDto e join fetch e.oficinaSolicitudDto os join fetch os.solicitudDto s ";
		query += "where os.estadoEvaluacion = 1 ";
		query += "and s.tramiteSolicitudDto.id not in (1018, 1022) ";

		String condition = "";
		String codTerritorio = "";
		
		if(contratoDto != null) {
			if (contratoDto.getCodigoContrato() != null	&& contratoDto.getCodigoContrato().length() != 0) {
				condition += " and e.codigoContrato = '" + contratoDto.getCodigoContrato() + "'";
			}
	
			if (contratoDto.getOficinaSolicitudDto().getSolicitudDto().getCodigoCliente() != null && contratoDto.getOficinaSolicitudDto().getSolicitudDto().getCodigoCliente().length() != 0) {
				condition += " and e.oficinaSolicitudDto.solicitudDto.codigoCliente = '" + contratoDto.getOficinaSolicitudDto().getSolicitudDto().getCodigoCliente() + "'";
			}
	
			if (contratoDto.getEstadoDto() != null && !contratoDto.getEstadoDto().getId().equals(1003L)) {
				condition += " and e.estadoDto.id = " + contratoDto.getEstadoDto().getId();
			}
			
			SolicitudDto s = null;
			
			if(contratoDto.getOficinaSolicitudDto() != null && contratoDto.getOficinaSolicitudDto().getSolicitudDto() != null) {
				s = contratoDto.getOficinaSolicitudDto().getSolicitudDto();
				
				if (s.getCodigoSolicitud() != null && s.getCodigoSolicitud().length()!=0){
					condition += " and e.oficinaSolicitudDto.solicitudDto.codigoSolicitud = '" + s.getCodigoSolicitud() + "'";	
				}
				
				if (s.getFechaInicio() != null && s.getFechaHasta() != null) {
					SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
					if(condition.length() > 0) condition += " and ";
					condition += " and (e.oficinaSolicitudDto.solicitudDto.fechaCreacion >= to_date('" + formater.format(s.getFechaInicio()) + " 00:00:00', 'dd/MM/yyyy  HH24:mi:ss')";
					condition += " and e.oficinaSolicitudDto.solicitudDto.fechaCreacion <= to_date('" + formater.format(s.getFechaHasta()) + " 23:59:59', 'dd/MM/yyyy  HH24:mi:ss') )";
				}
				
				if (sessionMBean.getRol() == Constantes.Rol.GTE) {
					if(esGerenteTerritorial(sessionMBean)) {
						codTerritorio = sessionMBean.getCodOficina();
					} else {
						codTerritorio = sessionMBean.getCodTerritorio();
					}
					
					condition += " and (";
					condition += "e.oficinaSolicitudDto.solicitudDto.oficinaSolicitante='" + codTerritorio + "'";
					condition += " or e.oficinaSolicitudDto.solicitudDto.oficinaSolicitante in (select codOficina from OficinaDto where territorioDto.codTerritorio='" + codTerritorio + "')";
					condition += " or e.oficinaSolicitudDto.solicitudDto.oficinaReceptorDto.territorioDto.codTerritorio = '" + codTerritorio + "'";
					condition += " or e.oficinaSolicitudDto.oficinaDto.territorioDto.codTerritorio = '" + codTerritorio + "')";
					condition += ")";
					
				}				
				
				if (s.getOficinaCedente() != null || s.getOficinaReceptora() != null || s.getOficSolicitante() != null) {
					condition += " and ( ";
					if (s.getOficinaCedente() != null) {
						condition += "os.oficinaDto.codOficina = '" + s.getOficinaCedente().getCodOficina() + "'";
					}
					if (s.getOficSolicitante() != null || s.getOficinaReceptora() != null) {
						if(s.getOficinaCedente() != null) {
							condition += " or ";
						}
						// condition += " exists ( select e.id from SolicitudDto e  where e.id=os.solicitudDto.id and ( ";
						condition += " e.oficinaSolicitudDto.solicitudDto.id in (select e.id from SolicitudDto e  where ( ";
						if (s.getOficSolicitante() != null) {
							condition += "e.oficinaSolicitante = '" + s.getOficSolicitante().getCodOficina() + "'";
						}
						if (s.getOficSolicitante() != null && s.getOficinaReceptora() != null) {
							condition += " or ";
						}
						if (s.getOficinaReceptora() != null) {
							condition += "e.oficinaReceptorDto.codOficina = '" + s.getOficinaReceptora().getCodOficina() + "'";
						}
						condition += " ) )";
					}
					condition += " )";
				}
			}
		}
		
		query += condition;
		query += " order by s.fechaCreacion desc";
		logger.info(query);
		Session session = getSession();
		Query q = session.createQuery(query);
		listaContratos = q.list();
		session.close();
		
		return listaContratos;
	}
	
	@Override
	public boolean puedeCrearNuevaSolicitud (String codigoCliente, String ofiReceptor, String ofiCedente, Long codigoSolicitud) throws DAOException {
		boolean retorno = false;
		List<SolicitudDto> l= null;
		/*
		 *  select S
			from REAUNI.TREAUNI_SOLICITUD S, REAUNI.TREAUNI_OFICINA_SOLICITUD OS 
            WHERE  S.ID = OS.SOLICITUD AND OS.TIPO_OFICINA = 1031 AND S.CODIGO_CLIENTE = '00830518'
            AND S.OFICINA_RECEPTOR = '0252' AND OS.CODIGO_OFICINA = '0370' AND S.TRAMITE_SOLICITUD NOT IN (1018,1022);
		 * */
		
		String query = "select e from SolicitudDto e, OficinaSolicitudDto os where os.solicitudDto.id=e.id and os.tipoOficinaDto.id=1031 " +
				"and e.codigoCliente = '"+codigoCliente+"' and e.oficinaReceptorDto.id='"+ofiReceptor+"' and os.oficinaDto.id = '" +ofiCedente+"' " +
				"and e.tramiteSolicitudDto.id not in (1018,1022,1021) and e.id!="+codigoSolicitud;		
		Session session = getSession();
		Query q = session.createQuery(query);
		
		
		
		l = q.list();
		session.close();
		if (l!=null && l.size()==0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public SolicitudDto obtenerSolicitud(ContratoDto contrato) {
		SolicitudDto result = new SolicitudDto();
		List<SolicitudDto> listaSolicitud = new ArrayList<SolicitudDto>();
		String query = "select os.solicitudDto from ContratoDto e, OficinaSolicitudDto os ";
		query += "where e.oficinaSolicitudDto.id=os.id ";
		query += "and os.estadoEvaluacion = 1 ";
		query += "and e.id=" + contrato.getId().toString();
		logger.info(query);
		Session session = getSession();
		Query q = session.createQuery(query);
		listaSolicitud = q.list();
		session.close();
		
		if(listaSolicitud != null && listaSolicitud.size() > 0) {
			result = listaSolicitud.get(0);
		}
		
		return result;
	}
	
	private Boolean esGerenteTerritorial(SessionMBean sessionMBean) {
		Boolean esGerenteTerritorial = Boolean.FALSE;
		
		if (sessionMBean.getCodCargo().equals("CH1")||sessionMBean.getCodCargo().equals("CH6")||sessionMBean.getCodCargo().equals("OS8"))
			esGerenteTerritorial = Boolean.TRUE;
		
		return esGerenteTerritorial;
	}
}
