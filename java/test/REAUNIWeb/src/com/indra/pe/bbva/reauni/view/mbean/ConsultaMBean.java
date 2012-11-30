package com.indra.pe.bbva.reauni.view.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.util.DocumentoExcel;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.ldap.service.LdapService;
import com.indra.pe.bbva.reauni.mail.GestionCorreo;
import com.indra.pe.bbva.reauni.mail.TipoCorreoEnum;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.EstadoSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.TerritorioDto;
import com.indra.pe.bbva.reauni.service.SolicitudBO;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;
import com.indra.pe.bbva.reauni.view.helper.SelectOneMenuHelper;

@Controller("consultaMBean")
@Scope("session")
public class ConsultaMBean extends GenericMBean {

	private static Logger logger = Logger.getLogger(ConsultaMBean.class);

	@Autowired
	private LdapService ldapService;

	private List<ContratoDto> listaContratos;

	private ContratoDto contratoDto;

	private ContratoDto contrato;

	@Autowired
	private SessionMBean sessionMBean;

	@Autowired
	private SolicitudBO solicitudBo;

	private List<ParametroDto> estadosHost;

	private SelectItem[] productos;

	private List<ParametroDto> listaEstados;

	@Autowired
	private GestionCorreo gestionCorreo;

	private List<OficinaDto> listaOficinas;
	private SolicitudDto dtoFiltro;
	private Boolean activaOficinaSolicitante;
	private Boolean activaOficinaReceptora;
	private Boolean activaOficinaCedente;
	
	public ConsultaMBean() {
		inicializar();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String iniciar() {
		this.setListaContratos(new ArrayList());
		
		inicializar();
		AplicacionMBean aplicacionMBean = (AplicacionMBean) WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
		setListaOficinas(aplicacionMBean.getListaOficinas());
		
		this.dtoFiltro = this.contratoDto.getOficinaSolicitudDto().getSolicitudDto();
		this.setActivaOficinaSolicitante(Boolean.FALSE);
		this.setActivaOficinaReceptora(Boolean.FALSE);
		this.setActivaOficinaCedente(Boolean.FALSE);
		this.dtoFiltro.setFechaInicio(new Date());
		this.dtoFiltro.setFechaHasta(new Date());

		return Constantes.UrlNavegacion.URL_LISTA_CONTRATO;
	}

	void inicializar() {
		this.contratoDto = new ContratoDto();

		this.contratoDto.setEstadoDto(ApplicationHelper.obtenerParametroPorId(1003L));
		this.contratoDto.setOficinaSolicitudDto(new OficinaSolicitudDto());
		this.contratoDto.getOficinaSolicitudDto().setSolicitudDto(new SolicitudDto());
		this.contratoDto.getOficinaSolicitudDto().setOficinaDto(new OficinaDto());
		this.contratoDto.setProducto("");
	}

	public void buscar(ActionEvent actionEvent) {
		try {
			this.listaContratos = this.solicitudBo.listaContratosEstadoPendiente(this.contratoDto, sessionMBean);
			for (ContratoDto c : this.listaContratos) {
				c.setEstadoBkp(c.getEstadoDto());
			}
		} catch (ServiceException e) {
			logger.error("", e);
		}
	}

//	public void guardarEstados(ActionEvent actionEvent) {
//		try {
//			this.contrato.setUsuarioEstado(sessionMBean.getRegistro());
//			this.contrato.setFechaEstado(Utilitarios.Fecha
//					.obtenerFechaActualDate());
//			this.solicitudBo.guardarContrato(this.contrato);			
//			SolicitudDto s = this.solicitudBo.obtener(this.contrato.getOficinaSolicitudDto().getSolicitudDto().getId());
//			cambiarEstadoSolicitudSegunContratos(s);
//		} catch (ServiceException e) {
//			logger.error("", e);
//		}
//	}

	public void cambiarEstadoSolicitudSegunContratos(SolicitudDto s) {
		
		@SuppressWarnings("unused")
		Long pendiente = 1034L;		
		Long estadoSolicitud = 1017L; // En evaluacion
		int contratosPendientes = 0;
		int contratosObservados = 0;
		int contratosAnulados = 0;
		int contratosAprobados = 0;
		int cantidadContratos = 0;
		int cedentesPendientes = 0;
		
		
		//Solo si la solicitud esta aprobada (1017), en proceso (1019) o en proceso observada (1020)
		if (s.getTramiteSolicitudDto().getId().equals(1019L) || s.getTramiteSolicitudDto().getId().equals(1020L) || s.getTramiteSolicitudDto().getId().equals(1017L)) {
			for (OficinaSolicitudDto os : s.getListaOficinasSolicitud()) {				
				boolean estaPendiente = false; 
				
				
				if (os.getTipoOficinaDto().getId().equals(1031L)) { //Solo los cedentes tienen contrato
					if (os.getEstadoEvaluacion()==null) { //Si la evaluacion esta pendiente
						estaPendiente = true;
						cedentesPendientes += 1;
					}else if (os.getEstadoEvaluacion()){ //Si la evaluacion está aprobada
						estaPendiente = false;
					}else { //Si es rechazada
						estaPendiente = true;
					}
					
					if (!estaPendiente) { // Si ya dieron su veredicto
						cantidadContratos += os.getListaContratos().size(); //Sumamos todos los contratos de todas las oficinas
						for (ContratoDto c : os.getListaContratos()) {
							if (c.getEstadoDto().getId().equals(1037L)) { //Pendientes
								contratosPendientes += 1;							
							}else if (c.getEstadoDto().getId().equals(1036L)) { //Observados
								contratosObservados += 1;
							}else if (c.getEstadoDto().getId().equals(1035L)) { //Procesados
								contratosAprobados += 1;
							}else if (c.getEstadoDto().getId().equals(1038L)) { //Anulados
								contratosAnulados += 1;
							}
						}
						
						
					}				
				}
			}
			
			if (contratosObservados!=0) { // Si al menos un contrato está observado
				estadoSolicitud = 1019L; // Procesada Observada			
			}else if ((cantidadContratos-contratosAnulados)==contratosAprobados && cedentesPendientes==0) { //Si todos los contratos exceptos los anulados (por batch) estan aprobados 
				estadoSolicitud = 1021L; // Procesada
			}else if (contratosPendientes>0){ //Si hay contratos pendientes y si no hay observados 
				estadoSolicitud = 1020L;
			}
			
			if (cedentesPendientes==0) { //Solo cambiamos el estado de la solicitud si no queda ningun cedente pendiente.
				try {			
					//Agregamos una bitacora del estado
					EstadoSolicitudDto es = new EstadoSolicitudDto();
					es.setEstadoDto(ApplicationHelper.obtenerParametroPorId(estadoSolicitud));
					es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());
					es.setSolicitudDto(s);
					es.setUsuario(this.sessionMBean.getRegistro());
					es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
					if (estadoSolicitud.equals(1019L))
						es.setComentario("LA SOLICITUD PASA A PROCESADA OBSERVADA");
					else if (estadoSolicitud.equals(1021L)){
						es.setComentario("LA SOLICITUD PASA A PROCESADA");
					}else if (estadoSolicitud.equals(1020L)){
						es.setComentario("LA SOLICITUD PASA A EN PROCESO");
					}
					this.solicitudBo.insertarEstado(es);
					
					//Cambiamos el estado de la solicitud
					s.setTramiteSolicitudDto(ApplicationHelper.obtenerParametroPorId(estadoSolicitud));
					s.setFechaModificacion(Utilitarios.Fecha.obtenerFechaActualDate());
					s.setUsuarioModificacion(this.sessionMBean.getRegistro());
					this.solicitudBo.editar(s);
					s.getListaEstados().add(es); // TODO: Parche
				} catch (ServiceException e) {
					logger.error(e);
				}
			}else if (cedentesPendientes>0 && !estadoSolicitud.equals(1021L)){  //Si hay veredictos pendientes y el nuevo estado a cambiar es en proceso o en proceso observada 
				try {			
					//Agregamos una bitacora del estado
					EstadoSolicitudDto es = new EstadoSolicitudDto();
					es.setEstadoDto(ApplicationHelper.obtenerParametroPorId(estadoSolicitud));
					es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());
					es.setSolicitudDto(s);
					es.setUsuario(this.sessionMBean.getRegistro());
					es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
					if (estadoSolicitud.equals(1019L))
						es.setComentario("LA SOLICITUD PASA A PROCESADA OBSERVADA");
					else if (estadoSolicitud.equals(1020L)){
						es.setComentario("LA SOLICITUD PASA A EN PROCESO");
					}
					this.solicitudBo.insertarEstado(es);
					
					//Cambiamos el estado de la solicitud
					s.setTramiteSolicitudDto(ApplicationHelper.obtenerParametroPorId(estadoSolicitud));
					s.setFechaModificacion(Utilitarios.Fecha.obtenerFechaActualDate());
					s.setUsuarioModificacion(this.sessionMBean.getRegistro());
					this.solicitudBo.editar(s);
					s.getListaEstados().add(es); // TODO: Parche
				} catch (ServiceException e) {
					logger.error(e);
				}
			}
		}
		
	}

	public String guardarContrato() {
		try {
			
			if (!contrato.getEstadoDto().getId().equals(1037L)) { // Si es diferente de pendiente
				this.contrato.setUsuarioEstado(sessionMBean.getRegistro());
				this.contrato.setFechaEstado(Utilitarios.Fecha.obtenerFechaActualDate());
				this.solicitudBo.guardarContrato(this.contrato);				
				
				SolicitudDto s = this.solicitudBo.obtenerSolicitud(this.contrato);
				EstadoSolicitudDto es = new EstadoSolicitudDto();
				es.setEstadoDto(s.getTramiteSolicitudDto());
				es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());
				es.setSolicitudDto(s);
				es.setUsuario(this.sessionMBean.getRegistro());
				es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
				es.setComentario("OPERACIONES CENTRALIZADAS - CONTRATO #"+this.contrato.getCodigoContrato());			
				this.solicitudBo.insertarEstado(es);
				
				cambiarEstadoSolicitudSegunContratos(s);
				buscar(null);
				
				// Enviar Correo
				if (this.contrato.getEstadoDto().getId() == 1036L) {
					try {
						gestionCorreo.lanzarTipoCorreo(s, TipoCorreoEnum.CONTRATO_OBSERVADO, this.contrato);
					} catch (Exception e) {					
						logger.error("", e);
						showWarning("SE GUARDÓ EL CONTRATO, PERO NO SE PUDO ENVIAR EL CORREO DE CONTRATO OBSERVADO");
					}
				}
			}else {
				showWarning("PARA GRABAR EL CONTRATO SE DEBE SELECCIONAR UN ESTADO DISTINTO A PENDIENTE.");
			}
		} catch (ServiceException e) {
			logger.error("", e);
		}

		return null;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		ConsultaMBean.logger = logger;
	}

	public LdapService getLdapService() {
		return ldapService;
	}

	public void setLdapService(LdapService ldapService) {
		this.ldapService = ldapService;
	}

	public List<ContratoDto> getListaContratos() {
		return listaContratos;
	}

	public void setListaContratos(List<ContratoDto> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public ContratoDto getContratoDto() {
		return contratoDto;
	}

	public void setContratoDto(ContratoDto contratoDto) {
		this.contratoDto = contratoDto;
	}

	public SessionMBean getSessionMBean() {
		return sessionMBean;
	}

	public void setSessionMBean(SessionMBean sessionMBean) {
		this.sessionMBean = sessionMBean;
	}

	public SolicitudBO getSolicitudBo() {
		return solicitudBo;
	}

	public void setSolicitudBo(SolicitudBO solicitudBo) {
		this.solicitudBo = solicitudBo;
	}

	public List<ParametroDto> getEstadosHost() {
		this.estadosHost = SelectOneMenuHelper
				.obtenerParametrosActivosPorCatalogo(1009L);
		this.estadosHost.remove(new ParametroDto(1038L));
		return estadosHost;
	}

	public void setEstadosHost(List<ParametroDto> estadosHost) {
		this.estadosHost = estadosHost;
	}

	public SelectItem[] getProductos() {
		productos = SelectOneMenuHelper.listaProductos();
		return productos;
	}

	public void setProductos(SelectItem[] productos) {
		this.productos = productos;
	}

	public List<ParametroDto> getListaEstados() {
		this.listaEstados = SelectOneMenuHelper
				.obtenerParametrosActivosPorCatalogoTodos(1009L);
		return listaEstados;
	}

	public void setListaEstados(List<ParametroDto> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public ContratoDto getContrato() {
		return contrato;
	}

	public void setContrato(ContratoDto contrato) {
		this.contrato = contrato;
	}


	
	public SolicitudDto getDtoFiltro() {
		return dtoFiltro;
	}

	public void setDtoFiltro(SolicitudDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}

	public Boolean getActivaOficinaSolicitante() {
		return activaOficinaSolicitante;
	}

	public void setActivaOficinaSolicitante(Boolean activaOficinaSolicitante) {
		this.activaOficinaSolicitante = activaOficinaSolicitante;
	}

	public Boolean getActivaOficinaReceptora() {
		return activaOficinaReceptora;
	}

	public void setActivaOficinaReceptora(Boolean activaOficinaReceptora) {
		this.activaOficinaReceptora = activaOficinaReceptora;
	}

	public Boolean getActivaOficinaCedente() {
		return activaOficinaCedente;
	}

	public void setActivaOficinaCedente(Boolean activaOficinaCedente) {
		this.activaOficinaCedente = activaOficinaCedente;
	}

	public void listenerSeleccionarOficinaSolicitante(SelectEvent event) {
		this.dtoFiltro.setOficSolicitante((OficinaDto) event.getObject());
	}

	public void listenerSeleccionarOficinaReceptora(SelectEvent event) {
		this.dtoFiltro.setOficinaReceptora((OficinaDto) event.getObject());
	}

	public void listenerSeleccionarOficinaCedente(SelectEvent event) {
		this.dtoFiltro.setOficinaCedente((OficinaDto) event.getObject());
	}

	public void listenerCheckOficinaSolicitante() {
		this.dtoFiltro.setOficSolicitante(null);
	}

	public void listenerCheckOficinaReceptora() {
		this.dtoFiltro.setOficinaReceptora(null);
	}

	public void listenerCheckOficinaCedente() {
		this.dtoFiltro.setOficinaCedente(null);
	}

	public void listenerAsignarFechaInicio(DateSelectEvent event) {
        this.dtoFiltro.setFechaInicio(event.getDate());
    }
	
	public void listenerAsignarFechaHasta(DateSelectEvent event) {  
        this.dtoFiltro.setFechaHasta(event.getDate());  
    }

	public List<OficinaDto> getListaOficinas() {
		return listaOficinas;
	}

	public void setListaOficinas(List<OficinaDto> listaOficinas) {
		this.listaOficinas = listaOficinas;
	}	
	
	public List<OficinaDto> buscarSolicitante(String query) {
		List<OficinaDto> resultado = new ArrayList<OficinaDto>();
		boolean encontro = false;
		String mensaje = "No se cargo correctamente la lista de oficinas.";
		if(listaOficinas != null) {
			for (OficinaDto ofic : listaOficinas) {
				if (ofic.getDesOficina().toUpperCase().contains(query.toUpperCase()) 
					|| ofic.getCodOficina().toUpperCase().contains(query.toUpperCase())
					|| ofic.getTerritorioDto().getDesTerritorio().toUpperCase().contains(query.toUpperCase())) {
					resultado.add(ofic);
					encontro = true;
				}
			}
			mensaje = "No encontraron coincidencias.";
		}
		if(!encontro) {
			OficinaDto ofic = new OficinaDto();
			ofic.setDesOficina(mensaje);
			ofic.setTerritorioDto(new TerritorioDto());
			ofic.getTerritorioDto().setDesTerritorio("");
			resultado.add(ofic);
		}
		return resultado;
	}
	
	public void exportar(Object document) {
		try {
			DocumentoExcel docExcel = new DocumentoExcel(document, "OperacionesCentralizadas");
			docExcel.postProcessXLS(document);
		} catch (Exception e) {
			logger.error("Exportar", e);
		}
	}
}
