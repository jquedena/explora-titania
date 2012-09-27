package com.indra.pe.bbva.reauni.view.mbean;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.com.grupobbva.ReaUniDatosClienteDataRq;
import pe.com.grupobbva.ReaUniDatosClienteHdrRq;
import pe.com.grupobbva.ReaUniDatosClienteRq;
import pe.com.grupobbva.ReaUniDatosClienteRs;
import pe.com.grupobbva.ReaUniServiceServiceProxy;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.ldap.model.entidad.LdapDto;
import com.indra.pe.bbva.ldap.service.LdapService;
import com.indra.pe.bbva.reauni.mail.GestionCorreo;
import com.indra.pe.bbva.reauni.mail.TipoCorreoEnum;
import com.indra.pe.bbva.reauni.model.entidad.ContratoDto;
import com.indra.pe.bbva.reauni.model.entidad.ContratoTemporalDto;
import com.indra.pe.bbva.reauni.model.entidad.EstadoSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.GestorDto;
import com.indra.pe.bbva.reauni.model.entidad.InvolucradoDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaInvolucradoDto;
import com.indra.pe.bbva.reauni.model.entidad.OficinaSolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.model.entidad.TerritorioDto;
import com.indra.pe.bbva.reauni.service.SolicitudBO;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;
import com.indra.pe.bbva.reauni.view.helper.ContratoTemporalDataModel;
import com.indra.pe.bbva.reauni.view.helper.SelectOneMenuHelper;
import com.indra.pe.bbva.reauni.view.helper.SessionHelper;

@SuppressWarnings({"unused", "unchecked", "rawtypes"})
@Controller("solicitudMBean")
@Scope("session")
public class SolicitudMBean extends GenericMBean {
	private static Logger logger = Logger.getLogger(SolicitudMBean.class);

	private SolicitudDto dto;
	
	private List<SolicitudDto> lista;
	private List<ParametroDto> tiposSolicitud;
	private List<ParametroDto> estadosSolicitud;
	private List<ParametroDto> motivosSolicitud;
	private List<TerritorioDto> listaTerritorios;
	private List<OficinaDto> listaOficinas;
	private List<OficinaDto> listaOficinasBuscar;
	private List<GestorDto> listaGestores;

	private SolicitudDto dtoFiltro;
	private List<ParametroDto> tiposSolicitudFiltro;
	private List<ParametroDto> estadosSolicitudFiltro;
	private List<ParametroDto> listaEstadoArobacion;

	private ContratoDto contratoDto;
	private OficinaSolicitudDto oficinaSolicitudDto;

	private List<ContratoTemporalDto> listaContratosTemporal;
	private ContratoTemporalDto[] listaContratosTemporalSelected;
	private ContratoTemporalDataModel mediumCarsModel;

	private Boolean mostrarGestionFile;
	private String mensajeMostrarGestionFile;

	private OficinaSolicitudDto oficinaReceptoraDto;
	
	private OficinaInvolucradoDto oficinaInvolucradoDto;

	@Autowired
	private SolicitudBO bo;

	@Autowired
	private SessionMBean sessionMBean;

	@Autowired
	private LdapService ldapService;
	

	@Autowired
	private GestionCorreo gestionCorreo;

	private String lblBonificacionOtros;
	private String lblBonificacion2;
	private String lblBonificacionNoExcede7Dias;
	private String lblAjustesOtros;
	
	
	private String lblAjustesGrupoEconomico;
	private String lblAjustesVentaUltimoEjercicio;
	
	private Boolean restringirGestionFiles;
	
	private Boolean activaOficinaSolicitante;
	private Boolean activaOficinaReceptora;
	private Boolean activaOficinaCedente;
	
	private Boolean bloquearControles;
	private Boolean mostrarDeclaracionJurada;
	
	public SolicitudMBean() {
		this.dtoFiltro = new SolicitudDto();
		this.dtoFiltro.setTramiteSolicitudDto(ApplicationHelper.obtenerParametroPorId(1003L));
		this.dtoFiltro.setTipoDto(ApplicationHelper.obtenerParametroPorId(1003L));
	}

	private void cargarEtiquetas() {
		this.lblAjustesOtros = ApplicationHelper.obtenerParametroPorId(1074L).getValorCadena().toUpperCase();
		this.lblAjustesGrupoEconomico = ApplicationHelper.obtenerParametroPorId(1050L).getValorCadena().toUpperCase();
		this.lblAjustesVentaUltimoEjercicio = ApplicationHelper.obtenerParametroPorId(1073L).getValorCadena().toUpperCase();		

		this.lblBonificacionOtros = ApplicationHelper.obtenerParametroPorId(1049L).getValorCadena().toUpperCase();
		this.lblBonificacionNoExcede7Dias = ApplicationHelper.obtenerParametroPorId(1048L).getValorCadena().toUpperCase();
		this.lblBonificacion2 = ApplicationHelper.obtenerParametroPorId(1076L).getValorCadena();
		if(this.lblBonificacion2 != null) {
			this.lblBonificacion2 = this.lblBonificacion2.toUpperCase();
		}
	}

	private void inicializarPerfil() {
		this.setListaGestores(new ArrayList<GestorDto>());
		AplicacionMBean aplicacionMBean = (AplicacionMBean) WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
		
		this.setActivaOficinaSolicitante(Boolean.FALSE);
		this.setActivaOficinaReceptora(Boolean.FALSE);
		this.setActivaOficinaCedente(Boolean.FALSE);
		switch(sessionMBean.getRol()) {
		case com.indra.pe.bbva.reauni.util.Constantes.Rol.ADM:
			setListaOficinasBuscar(aplicacionMBean.getListaOficinas());
			break;
		case com.indra.pe.bbva.reauni.util.Constantes.Rol.GTE:
			if(sessionMBean.getEsGerenteTerritorial()) {
				this.setListaOficinasBuscar(SelectOneMenuHelper.obtenerOficinasPorTerritorio(sessionMBean.getCodOficina()));
			} else {
				this.setListaOficinasBuscar(SelectOneMenuHelper.obtenerOficinasPorTerritorio(sessionMBean.getCodTerritorio()));
			}
			break;
		case com.indra.pe.bbva.reauni.util.Constantes.Rol.GOF:
			OficinaDto ofic = SelectOneMenuHelper.obtenerOficina(sessionMBean.getCodOficina());
			this.setListaOficinasBuscar(new ArrayList<OficinaDto>());
			this.setActivaOficinaSolicitante(Boolean.TRUE);
			this.setActivaOficinaReceptora(Boolean.TRUE);
			this.setActivaOficinaCedente(Boolean.TRUE);
			this.dtoFiltro.setOficSolicitante(ofic);
			this.dtoFiltro.setOficinaReceptora(ofic);
			this.dtoFiltro.setOficinaCedente(ofic);
			this.dtoFiltro.setFlag_oficinaSolicitante(Boolean.FALSE);
			this.dtoFiltro.setFlag_oficinaReceptora(Boolean.FALSE);
			this.dtoFiltro.setFlag_oficinaCedente(Boolean.FALSE);
			break;
		}
	}
	
	public String iniciar() {
		this.setLista(new ArrayList());
		this.dtoFiltro = new SolicitudDto();
		this.dtoFiltro.setTramiteSolicitudDto(ApplicationHelper.obtenerParametroPorId(1003L));
		this.dtoFiltro.setTipoDto(ApplicationHelper.obtenerParametroPorId(1003L));

		this.dtoFiltro.setFechaInicio(new Date());
		this.dtoFiltro.setFechaHasta(new Date());
		
		AplicacionMBean aplicacionMBean = (AplicacionMBean) WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
		this.setListaOficinas(aplicacionMBean.getListaOficinas());
		Utilitarios.General.ordena(this.listaOficinas, "codOficina");
		
		inicializarPerfil();
		
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_LISTA_SOLICITUD;
	
	}

	public String listar() {
		cargarEtiquetas();
		this.sessionMBean.setAccion(Constantes.Form.LISTA);
		this.dtoFiltro = new SolicitudDto();
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_LISTA_SOLICITUD;

	}

	public void buscar(ActionEvent ae) {
		try {
			this.dtoFiltro.setUsuarioCreacion(sessionMBean.getRegistro());
			this.lista = this.bo.obtenerSolicitudes(this.dtoFiltro, sessionMBean);
		} catch (ServiceException ex) {
			logger.error("", ex);
			showError(ex.getMessage());
		}
	}

	public String nuevo() {
		cargarEtiquetas();
		
		// Revalidamos la fecha de corte
		SessionHelper.validarFechaCorte();
		
		if (sessionMBean.getFechaCorte()) {
						
			this.sessionMBean.setAccion(Constantes.Form.NUEVO);
			this.dto = new SolicitudDto();
			this.dto.setTipoDto(ApplicationHelper.obtenerParametroPorId(1007L));
			this.dto.setTramiteSolicitudDto(ApplicationHelper.obtenerParametroPorId(1015L));
			this.dto.setMotivoTrasladoDto(ApplicationHelper.obtenerParametroPorId(1026L));
			this.dto.setBonificacionNoExcede7Dias(Boolean.FALSE);
			this.dto.setBonificacion2(Boolean.FALSE);
			this.dto.setBonificacionOtros(Boolean.FALSE);
			
			this.dto.setAjusteFormaGrupo(Boolean.FALSE);
			this.dto.setAjusteOtros(Boolean.FALSE);
			this.dto.setAjusteVentaUltimo(Boolean.FALSE);
			this.dto.setTerritorioReceptorDto(SelectOneMenuHelper.obtenerTerritorio(sessionMBean.getCodTerritorio()));
			this.dto.setOficinaReceptorDto(SelectOneMenuHelper.obtenerOficina(sessionMBean.getCodOficina()));
			
			this.dto.setListaOficinasSolicitud(new ArrayList<OficinaSolicitudDto>());
			
			this.dto.setOficinaSolicitante(sessionMBean.getCodOficina());
			this.dto.setOficinaSolicitanteDesc(sessionMBean.getDesOficina());
						
			this.dto.setResponsableSolicitante(sessionMBean.getRegistro());
			this.dto.setResponsableSolicitanteDesc(sessionMBean.getNombresApellidos());

			this.aplicaAjusteBonificacion = false;
			// showMessage(sessionMBean.getMensajeFechaCorte());
			return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_SOLICITUD;
		} else {
			showWarning(sessionMBean.getMensajeFechaCorte());
			return null;
		}

	}

	public String editar() {
		cargarEtiquetas();
		this.sessionMBean.setAccion(Constantes.Form.EDITAR);

		try {
			this.dto = this.bo.obtener(this.dto.getId());
			this.aplicaAjusteBonificacion = (this.dto.getTipoDeclaracion().length() > 0);
			
			for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {				
				for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
					oi.setEstadoDtoBkp(oi.getEstadoDto());
				}
			}
		} catch (ServiceException e) {
			logger.error("editar", e);
		}

		Long tramiteActual = this.dto.getTramiteSolicitudDto().getId();

		// Si está en evaluacion obtenemos la oficina receptora
		if (tramiteActual.equals(1016L)) {
			obtenerOficinaReceptora();
		}
		
		mostrarGestionFile();

		// Solo si el estado es creada se cargan los contratos de los clientes
		if (tramiteActual.equals(1015L)) {
			cargarContratosCliente();
		}

		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_SOLICITUD;
	}

	// Mostramos Gestion File si al menos existe un oficina que ha aprobado
	void mostrarGestionFile() {		
		
		if (this.dto.getTramiteSolicitudDto().getId().equals(1017L)||this.dto.getTramiteSolicitudDto().getId().equals(1019L)||this.dto.getTramiteSolicitudDto().getId().equals(1020L)||this.dto.getTramiteSolicitudDto().getId().equals(1021L)) {
			this.mostrarGestionFile = Boolean.TRUE;
		}else {
			this.mostrarGestionFile = Boolean.FALSE;
			this.mensajeMostrarGestionFile = "NO SE PUEDE GESTIONAR LOS FILES; PUESTO QUE LA SOLICITUD AUN NO ESTÁ APROBADA";
		}

	}

	// Cargamos los contratos pendientes del cliente
	void cargarContratosCliente() {
		if (this.dto.getTramiteSolicitudDto().getId().equals(1015L)) {
			this.listaContratosTemporal = obtenerContratosTemporales(null);
			
			if (this.listaContratosTemporal == null)
				this.listaContratosTemporal = new ArrayList<ContratoTemporalDto>();
			Utilitarios.General.ordena(this.listaContratosTemporal, "oficina");

			mediumCarsModel = new ContratoTemporalDataModel(this.listaContratosTemporal);
		}
	}

	// Onchange cambiar tipo de solicitud
	public void cambioTipoSolicitud(javax.faces.event.AjaxBehaviorEvent a) {
		if (this.dto.getNombreCliente() != null) {
			this.dto.setCodigoSolicitud(autogenerarCodigoSolicitud());
		}
		this.dto.setBonificacionNoExcede7Dias(Boolean.FALSE);
		this.dto.setBonificacion2(Boolean.FALSE);
		this.dto.setBonificacionOtros(Boolean.FALSE);
		this.dto.setBonificacionComentarios(null);
		this.dto.setAjusteFormaGrupo(Boolean.FALSE);
		this.dto.setAjusteOtros(Boolean.FALSE);
		this.dto.setAjusteVentaUltimo(Boolean.FALSE);
		this.dto.setAjusteComentarios(null);
	}

	// Onchange cambiar territorio receptor
	public void cambioTerritorioReceptor(javax.faces.event.AjaxBehaviorEvent a) {
		this.getListaOficinas();
		this.listaGestores = new ArrayList<GestorDto>();
		this.dto.setGestorReceptor(null);
	}

	// Onchange cambiar oficina receptor
	public void cambioOficinaReceptor(SelectEvent event) {
		boolean e = true;
		if(event.getObject() == null) {
			this.dto.setOficinaReceptorDto(null);
			this.dto.setTerritorioReceptorDto(null);
		} else {
			OficinaDto o = (OficinaDto) event.getObject();
			
			for(OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
				if(os.getTipoOficina().compareTo(1031L) == 0 && os.getOficinaDto().getCodOficina().equalsIgnoreCase(o.getCodOficina())) {
					e = false;
					showWarning("OFICINA RECEPTORA - UD. TIENE YA REASIGNADO UN CONTRATO A LA OFICINA RECEPTORA, POR FAVOR VERIFIQUE.", "");
					break;
				}
			}
			
			if(e) {
				this.dto.setOficinaReceptorDto(o);
				this.dto.setTerritorioReceptorDto(o.getTerritorioDto());
			}
		}
		
		if(e) {
			this.cargarContratosCliente();
		}
		this.getListaGestores();
		this.dto.setGestorReceptor(null);
	}
	
	public void cambioCliente(SelectEvent event) {
		if(event.getObject() != null) {
			String o = (String) event.getObject();
			this.dto.setCodigoCliente(o);
		} else {
			this.dto.setCodigoCliente(null);
		}
	}
	
	public void keyupOficina(SelectEvent event) {
		if(event.getObject() != null) {
			String o = (String) event.getObject();
			if(o.length() < 4) {
				this.dto.setOficinaReceptorDto(null);
				this.dto.setTerritorioReceptorDto(null);
			}
		} else {
			this.dto.setOficinaReceptorDto(null);
			this.dto.setTerritorioReceptorDto(null);
		}
	}
	
	public void keyupOficinaReceptoraBuscar(SelectEvent event) {
		if(event.getObject() != null) {
			String o = (String) event.getObject();
			if(o.length() < 4) {
				this.dto.setOficinaReceptora(null);
			}
		} else {
			this.dto.setOficinaReceptora(null);
		}
	}
	
	public void keyupOficinaCedenteBuscar(SelectEvent event) {
		if(event.getObject() != null) {
			String o = (String) event.getObject();
			if(o.length() < 4) {
				this.dto.setOficinaCedente(null); 
			}
		} else {
			this.dto.setOficinaCedente(null);
		}
	}
	
	public void keyupOficinaSolicitanteBuscar(SelectEvent event) {
		if(event.getObject() != null) {
			String o = (String) event.getObject();
			if(o.length() < 4) {
				this.dto.setOficSolicitante(null);
			}
		} else {
			this.dto.setOficSolicitante(null);
		}
	}
		
	public void cambiarDecisionEvaluacion (ValueChangeEvent e) {
		ParametroDto p= (ParametroDto) e.getNewValue();		
		if (p.getId().equals(1029L)) {
			showMessage("SI ACEPTA SU EVALUACIÓN, PODRÍA APROBAR LA SOLICITUD.");
		}else if (p.getId().equals(1030L)) {
			showWarning("SI RECHAZA SU EVALUACIÓN, PODRÍA RECHAZAR LA SOLICITUD.");
		}
	}
	
	public void cambiarCodigoCliente () {
		this.dto.setCodigoCliente(null);
		this.dto.setNombreCliente(null);
		this.dto.setCodigoSolicitud(null);
		this.dto.setSegmentoCliente(null);
		this.dto.setSegmentoClienteDesc(null);
		this.dto.setClasificacionCliente(null);
		this.dto.setClasificacionClienteDesc(null);
		this.dto.setOficinaPrincipalCliente(null);
		this.dto.setOficinaPrincipalClienteDesc(null);
	}
	
	// Obtenemos informacion Cliente
	public void obtenerCliente(ActionEvent ae) {
		String  codigoCliente = this.dto.getCodigoCliente();
		
		if (this.dto.getCodigoCliente()!=null && this.dto.getCodigoCliente().length()>=6 && this.dto.getCodigoCliente().length()<=8) {
			try {
				ReaUniDatosClienteRs host = null;
				host = obtenerDatosClienteHost(this.dto.getCodigoCliente(), sessionMBean.getRegistro()); // "P007395"
				
				if (host != null) {
					if (host.getData() != null 
							&& host.getData().getPaterno() != null
							&& !host.getData().getPaterno().equals("")
							&& host.getData().getNombres() != null
							&& !host.getData().getNombres().equals("")
							&& host.getData().getCodigoSegmento() != null
							&& !host.getData().getCodigoSegmento().equals("")
							&& host.getData().getCodigoOficina() != null
							&& !host.getData().getCodigoOficina().equals("")) {
						this.dto.setCodigoSolicitud(autogenerarCodigoSolicitud());
						this.dto.setNombreCliente(host.getData().getNombres() + " " + host.getData().getPaterno() + " " + host.getData().getMaterno());
						
						this.dto.setSegmentoCliente(host.getData().getCodigoSegmento());	
						this.dto.setSegmentoClienteDesc(host.getData().getDescripcionSegmento());
						
						this.dto.setOficinaPrincipalCliente(host.getData().getCodigoOficina());
						this.dto.setOficinaPrincipalClienteDesc(host.getData().getDescripcionOficina());
						
						this.dto.setGestorPrincipalCliente(host.getData().getCodigoGestor());
						this.dto.setGestorPrincipalClienteDesc(host.getData().getDescripcionGestor());
						
						this.dto.setClasificacionCliente(host.getData().getCodigoClasificacion());
						this.dto.setClasificacionClienteDesc(host.getData().getDescripcionClasificacion());
						
					} else {
						cambiarCodigoCliente();
						this.dto.setCodigoCliente(codigoCliente);
						showWarning("EL CÓDIGO DE CLIENTE : "
								+ this.dto.getCodigoCliente()
								+ " NO ES VÁLIDO O NO TRAE INFORMACIÓN COMPLETA.");
					}
			
				}else {
					
					if(SessionHelper.getModoDebug()) {
						this.dto.setNombreCliente("CLIENTE " + codigoCliente);
						this.dto.setCodigoSolicitud(autogenerarCodigoSolicitud());
						this.dto.setSegmentoCliente("20100");
						this.dto.setSegmentoClienteDesc("NO PREMIUM" + codigoCliente);
						this.dto.setClasificacionCliente("CLS");
						this.dto.setClasificacionClienteDesc("CLS" + codigoCliente);
						this.dto.setOficinaPrincipalCliente("0127");
						this.dto.setOficinaPrincipalClienteDesc("OFIC. MINKA");
						this.dto.setGestorPrincipalCliente("P007776");
						this.dto.setGestorPrincipalClienteDesc("GOF - TEST - " + codigoCliente);
					} else {
						cambiarCodigoCliente();
						showError("HA OCURRIDO UN PROBLEMA AL TRAER LA INFORMACIÓN DEL CLIENTE, INTENTELO NUEVAMENTE.");
					}
					
					this.dto.setCodigoCliente(codigoCliente);
				}		
			} catch (Exception e) {
				cambiarCodigoCliente();
				this.dto.setCodigoCliente(codigoCliente);
				showError("HA OCURRIDO ERRORES AL TRAER LA INFORMACIÓN DE HOST!");
				logger.error("", e);
			}
		
		} else {
			showWarning("NO SE PUDO REALIZAR LA BUSQUEDA DEL CLIENTE; PUESTO QUE, EL CÓDIGO DEL CLIENTE DEBE ESTAR ENTRE 6 Y 8 CARACTERES");
			cambiarCodigoCliente();
			this.dto.setCodigoCliente(codigoCliente);
		}
	}

	public void cambioMotivo(javax.faces.event.AjaxBehaviorEvent a) {
	}

	public void cambioAjuste(javax.faces.event.AjaxBehaviorEvent a) {
	}

	public void cambioBonificacion(javax.faces.event.AjaxBehaviorEvent a) {
	}

	// Obtenemos los contratos pendientes de un cliente
	private List<ContratoTemporalDto> obtenerContratosTemporales(String codigoCentral) {

		List<ContratoTemporalDto> lista = null;
		List<ContratoTemporalDto> temp = new ArrayList<ContratoTemporalDto>();
		
		try {
			lista = this.bo.obtenerContratosTemporalesCliente(this.dto.getCodigoCliente());
		} catch (ServiceException e) {
			logger.error("", e);
		}
		
		// Borrar Contratos Seleccionados
		if (lista != null && lista.size() != 0) {
			if (this.dto.getListaOficinasSolicitud() != null) {
				for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
					if (os.getListaContratos() != null) {
						for (ContratoDto c : os.getListaContratos()) {
							lista.remove(new ContratoTemporalDto(c.getCodigoContrato()));
						}
					}
				}
				
				if(this.dto.getOficinaReceptorDto() != null) {
					for (ContratoTemporalDto c : lista) {
						if(!c.getOficina().equalsIgnoreCase(this.dto.getOficinaReceptorDto().getCodOficina())) {
							temp.add(c);
						}
					}
				} else {
					temp = lista;
				}
			}
		}

		return temp;
	}
	
	// Autogenera codigo de la solicitud
	private String autogenerarCodigoSolicitud() {
		StringBuffer codigoSolicitud = new StringBuffer();
		codigoSolicitud.append("F");
		codigoSolicitud.append(this.dto.getTipoDto().getDescripcion().substring(0, 1));
		codigoSolicitud.append("-");
		codigoSolicitud.append(this.dto.getCodigoCliente());
		return codigoSolicitud.toString();
	}

	private void mustraMensajeSolicitanteExterno (OficinaDto of) {
		if (getEsGerenteTerritorial()) {
			if (!of.getTerritorioDto().getCodTerritorio().equals(sessionMBean.getCodOficina()) || !sessionMBean.getCodOficina().equals(this.dto.getOficinaReceptorDto().getTerritorioDto().getCodTerritorio())) {
				if (!of.getTerritorioDto().getCodTerritorio().equals(sessionMBean.getCodOficina())) {
					showWarning("SE ESTÁ SOLICITANDO CONTRATOS DEL TERRITORIO : " + of.getTerritorioDto().getDesTerritorio() + " AL " + sessionMBean.getDesOficina());
				} else if (!sessionMBean.getCodOficina().equals(this.dto.getOficinaReceptorDto().getTerritorioDto().getCodTerritorio())) {
					showWarning("SE ESTÁ SOLICITANDO SEGMENTAR CONTRATOS A OTRO TERRITORIO RECEPTOR : " + this.dto.getOficinaReceptorDto().getTerritorioDto().getDesTerritorio());	
				}
			} else {
				if (!of.getCodOficina().equals(sessionMBean.getCodOficina())|| !sessionMBean.getCodOficina().equals(this.dto.getOficinaReceptorDto().getCodOficina())) {
					if (!of.getCodOficina().equals(sessionMBean.getCodOficina())) {
						showWarning("SE ESTÁ SOLICITANDO CONTRATOS DE LA OFICINA : " + of.getDesOficina() + " A LA " + sessionMBean.getDesOficina());
					} else if (!sessionMBean.getCodOficina().equals(this.dto.getOficinaReceptorDto().getTerritorioDto().getCodTerritorio())) {
						showWarning("SE ESTÁ SOLICITANDO SEGMENTAR CONTRATOS A OTRO TERRITORIO RECEPTOR : " + this.dto.getOficinaReceptorDto().getTerritorioDto().getDesTerritorio());	
					}
				}
			}
		}
	}
	
	// Reasignamos o Unificamos los contratos seleccionados a la solicitud
	public void grabarContratos(ActionEvent ae) {
		if (this.listaContratosTemporalSelected != null) {
			try {
				if (this.dto.getListaOficinasSolicitud() == null)
					this.dto.setListaOficinasSolicitud(new ArrayList<OficinaSolicitudDto>());

				List<ContratoTemporalDto> listaRemover = new ArrayList<ContratoTemporalDto>();
				
				for (ContratoTemporalDto ct : this.listaContratosTemporalSelected) {
					
					boolean mrx =bo.puedeCrearNuevaSolicitud(this.dto.getCodigoCliente(), this.dto.getOficinaReceptorDto().getCodOficina(), ct.getOficina(), this.dto.getId());
					
					if (mrx) {
						listaRemover.add(new ContratoTemporalDto(ct.getCodigoContrato()));
						OficinaSolicitudDto os = null;
						if (ct.getOficinaDto() != null) {
							os = validarExisteOficinaSolicitud(ct.getOficinaDto());
						}

						// INGRESANDO SOLICITUDES OFICINAS
						if (os == null) {
							os = new OficinaSolicitudDto();
							os.setTipoOficinaDto(ApplicationHelper.obtenerParametroPorId(1031L));
							os.setEstadoEvaluacion(null);
							os.setFechaEvaluacion(null);
							os.setUsuarioEvaluacion(null);
							os.setSilencioAdministrativo(Boolean.FALSE);
							os.setEstadoAprobacionAjuBonDto(ApplicationHelper.obtenerParametroPorId(1034L));
							os.setSolicitudDto(this.dto);
							os.setOficinaDto(ct.getOficinaDto());
							mustraMensajeSolicitanteExterno(os.getOficinaDto());
							os.setListaInvolucrados(new ArrayList<OficinaInvolucradoDto>());
							os.setListaContratos(new ArrayList<ContratoDto>());							
							
							this.dto.getListaOficinasSolicitud().add(os);
							this.bo.guardarOficinaSolicitud(os);
						}

						// INGRESANDO CONTRATOS
						ContratoDto c = new ContratoDto();
						c.setCodigoContrato(ct.getCodigoContrato());
						c.setFechaSolicitud(Utilitarios.Fecha.obtenerFechaActualDate());
						c.setId(null);
						c.setEstadoFile(Boolean.FALSE);
						c.setEstadoDto(ApplicationHelper.obtenerParametroPorId(1037L));
						c.setImporte(ct.getImporte());
						c.setMonedaImporte(ct.getMoneda());
						c.setOficinaSolicitudDto(os);
						c.setProducto(ct.getProductoDto().getCodProd());
						c.setSituacion(null);
						c.setTipoPrestamo(null);
						c.setSaldoA(ct.getSaldoA());
						c.setSaldoD(ct.getSaldoD());
						c.setSaldoVen(ct.getSaldoVen());
						c.setSalMora(ct.getSalMora());
						c.setTotalActivo(ct.getTotalActivo());
						c.setTotalPasivo(ct.getTotalPasivo());
						c.setCodigoAplicativo(ct.getCodigoAplicativo());
						c.setCodigoSituacion(ct.getSituacion());
						c.setFechaApertura(ct.getFechaApertura());
						c.setTipoPrestamo(ct.getTipoPrestamo());
						
						os.getListaContratos().add(c);						
						this.bo.guardarContrato(c);
						actualizarActivoPasivo();
						
					}else {
						showWarning("NO SE PUEDE SEGMENTAR EL CONTRATO; PUESTO QUE, PARA ESTE CLIENTE Y LA OFICINA RECEPTORA EXISTE UNA SOLICITUD EN PROCESO QUE TIENE A LA OFICINA : " + ct.getOficina() + " COMO CEDENTE." );
						return;
					}				
					
				}

				// eliminando contratos seleccionados
				if (this.listaContratosTemporal == null) {
					this.listaContratosTemporal = new ArrayList<ContratoTemporalDto>();
				}
				this.listaContratosTemporal.removeAll(listaRemover);
				mediumCarsModel = new ContratoTemporalDataModel(this.listaContratosTemporal);

				this.listaContratosTemporalSelected = null;

			} catch (Exception ex) {
				logger.error("", ex);
			}
		}
	}
	
	private void actualizarActivoPasivo () {
		try {
			this.dto = this.bo.obtener(this.dto.getId());
			for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
				for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
					oi.setEstadoDtoBkp(oi.getEstadoDto());
				}
			}
			
			this.dto.setTotalActivo(BigDecimal.ZERO);
			this.dto.setTotalPasivo(BigDecimal.ZERO);
			for (OficinaSolicitudDto os1:this.dto.getListaOficinasSolicitud()) {
				os1.setTotalActivo(BigDecimal.ZERO);
				os1.setTotalPasivo(BigDecimal.ZERO);							
				for (ContratoDto c1 : os1.getListaContratos()) {
					os1.setTotalActivo(os1.getTotalActivo().add(c1.getTotalActivo()));
					os1.setTotalPasivo(os1.getTotalPasivo().add(c1.getTotalPasivo()));
				}							
				this.dto.setTotalActivo(this.dto.getTotalActivo().add(os1.getTotalActivo()));
				this.dto.setTotalPasivo(this.dto.getTotalPasivo().add(os1.getTotalPasivo()));							
			}
			this.bo.editar(this.dto);
		} catch (ServiceException e) {
			logger.error("ERROR AL ACTUALIZAR ACTIVO Y PASIVO " , e);
		}
		
	}

	// Reasignamos o Unificamos todos los contratos a la solicitud
	public void grabarContratosAll(ActionEvent ae) {
		this.listaContratosTemporalSelected = new ContratoTemporalDto[this.listaContratosTemporal
				.size()];
		int i = 0;
		for (ContratoTemporalDto t : this.listaContratosTemporal) {
			this.listaContratosTemporalSelected[i++] = t;
		}
		grabarContratos(ae);

	}

	// Eliminamos un contrato
	public String eliminarContrato() {
		String to = null;
		try {
						// Obtenemos contrato temporal de la db
			ContratoTemporalDto ct = this.bo
					.obtenerContratoTemporalesPorNumeroContrato(this.contratoDto
							.getCodigoContrato());

			if (this.listaContratosTemporal == null) {
				this.listaContratosTemporal = new ArrayList<ContratoTemporalDto>();
			}			
			
			// Agregamos el contrato a la lista temporal
			this.listaContratosTemporal.add(ct);
			mediumCarsModel = new ContratoTemporalDataModel(
					this.listaContratosTemporal);
			if (this.contratoDto.getOficinaSolicitudDto().getListaContratos()
					.size() > 1) {
				this.bo.eliminarContrato(contratoDto);
			} else {
				this.bo.eliminarOficinaSolicitud(this.contratoDto
						.getOficinaSolicitudDto());
			}

			this.dto = this.bo.obtener(this.dto.getId());
			for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
				for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
					oi.setEstadoDtoBkp(oi.getEstadoDto());
				}
			}
			actualizarActivoPasivo();

		} catch (ServiceException e) {
			logger.error("", e);
			showError(e.getMessage());
		}
		return to;
	}

	// Grabamos los checks de las los Files
	public String grabarFiles() {
		String to = null;

		try {
			EstadoSolicitudDto es = new EstadoSolicitudDto();
			es.setEstadoDto(this.dto.getTramiteSolicitudDto());
			es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());
			es.setUsuario(this.sessionMBean.getRegistro());
			es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
			es.setComentario("GRABA FILES DE LA SOLICITUD");
			es.setSolicitudDto(this.dto);
			this.dto.getListaEstados().add(es);
			
			for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
				for (ContratoDto c : os.getListaContratos()) {
					if (c.getEstadoFile()) {
						c.setUsuarioRecepcionFile(sessionMBean.getRegistro());
						c.setFechaRecepcionFile(Utilitarios.Fecha.obtenerFechaActualDate());
					}
				}
			}
			
			this.bo.editar(this.dto);
			
		} catch (ServiceException ex) {
			logger.error("", ex);
			showError(ex.getMessage());
			return null;
		}
		return to;
	}

	private boolean puedeCrearNuevaSolicitud(String codigoCliente,
			String ofiReceptor, String ofiSolicitante) {
		boolean retorno = false;

		return retorno;
	}

	// Grabamos las evaluaciones
	public String grabarEvaluacion() {
		String to = null;
		boolean continuar=true;
		// Guardando OFICINAS_SOLICITUDES y CONTRATOS
		try {
			
			
			if (!oficinaInvolucradoDto.getEstadoDto().getId().equals(1034L)) {
				if (oficinaInvolucradoDto.getEstadoDto().getId().equals(1030L) && (oficinaInvolucradoDto.getComentario()==null|| oficinaInvolucradoDto.getComentario().length()==0 )) {
					showWarning("PARA RECHAZAR LA EVALUACION DEBE INGRESAR UN COMENTARIO");
				}else {
					
					/* (oficinaInvolucradoDto.getInvolucradoDto().getCargo().equals("CH1") 
					 * || oficinaInvolucradoDto.getInvolucradoDto().getCargo().equals("CH6") 
					 * || oficinaInvolucradoDto.getInvolucradoDto().getCargo().equals("OS8"))*/
					
					if (getMostrarDeclaracionJurada() && sessionMBean.getEsGerenteTerritorial() || this.dto.getResponsableSolicitante().equalsIgnoreCase(sessionMBean.getRegistro())) {
						if (oficinaInvolucradoDto.getOficinaSolicitudDto() != null
							&& oficinaInvolucradoDto.getOficinaSolicitudDto().getEstadoAprobacionAjuBonDto() != null 
							&& Long.valueOf(1034).equals(oficinaInvolucradoDto.getOficinaSolicitudDto().getEstadoAprobacionAjuBonDto().getId())
							&& dto.getMostrarDeclaracionJurada()) {
							showWarning("PARA GUARDAR SU EVALUACIÓN, ES NECESARIO QUE EVALÚE LA DECLARACIÓN JURADA.");
							continuar = false;				
						}	
					}			
					
					if (continuar) {
						
						this.oficinaInvolucradoDto.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());
						if (oficinaInvolucradoDto.getEstadoDto().getId().equals(1029L)) {
							this.oficinaSolicitudDto.setEstadoEvaluacion(Boolean.TRUE);
						} else if (oficinaInvolucradoDto.getEstadoDto().getId().equals(1030L)) {
							this.oficinaSolicitudDto.setEstadoEvaluacion(Boolean.FALSE);
						}
						
						this.bo.editarOficinaInvolucrado(this.oficinaInvolucradoDto);
						
						if(sessionMBean.getEsGerenteTerritorial() || this.oficinaInvolucradoDto.getPerfil().equalsIgnoreCase("GTE") || this.oficinaInvolucradoDto.getPerfil().equalsIgnoreCase("GR")) {
							this.oficinaSolicitudDto.setFechaEvaluacion(Utilitarios.Fecha.obtenerFechaActualDate());
							this.oficinaSolicitudDto.setUsuarioEvaluacion(this.sessionMBean.getRegistro());
							this.bo.editarOficinaSolicitud(this.oficinaSolicitudDto);
						}
						
						EstadoSolicitudDto es = new EstadoSolicitudDto();
						es.setEstadoDto(this.dto.getTramiteSolicitudDto());
						es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());

						es.setSolicitudDto(this.dto);
						es.setUsuario(this.sessionMBean.getRegistro());
						es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
						es.setComentario("EVALUACION DEL INVOLUCRADO DE LA SOLICITUD");
						this.dto.getListaEstados().add(es);
						this.bo.insertarEstado(es);
										
						this.dto = this.bo.obtener(this.dto.getId());				
						actualizarEstadoRechazoAprobacion(this.dto);
						this.dto = this.bo.obtener(this.dto.getId());
						actualizarEstadoProcesadaObservada(this.dto);					
						this.dto = this.bo.obtener(this.dto.getId());
						
						for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
							for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
								oi.setEstadoDtoBkp(oi.getEstadoDto());
							}
						}

						obtenerOficinaReceptora();
						mostrarGestionFile();
					}
				}
				
			}else {
				showWarning("PARA GRABAR LA EVALUACIÓN DEBE SELECCIONAR UN ESTADO DIFERENTE A PENDIENTE");
			}
			
			return null;// retroceder();
			
		} catch (Exception ex) {
			logger.error("", ex);
			showError("HUBO UN ERROR AL GUARDAR LA EVALUACIÓN");
			return null;
		}

	}
	
	private void actualizarEstadoProcesadaObservada (SolicitudDto s) {
		ConsultaMBean consultaMBean = (ConsultaMBean) WebServletContextListener.getApplicationContext().getBean("consultaMBean");
		consultaMBean.cambiarEstadoSolicitudSegunContratos(s);
	}
	
	private void actualizarEstadoRechazoAprobacion (SolicitudDto solicitudDto) {		
		Long estadoSolicitud = 1016L; // En evaluacion		
		Boolean estReceptora = null;
		Boolean estCedente = null;
		
		int cedentesPendientes = 0;		
		int receptoraPendientes = 0;
		
		if (solicitudDto.getTramiteSolicitudDto().getId().equals(1016L)) {//Solo se revisa si la solicitud está estado de en evaluacion
			
			for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
				
				boolean estaPendiente = false;
				
				if (!os.getTipoOficinaDto().getId().equals(1033L)) { //Si es el tipo de oficina es diferente a solicitante
					if (os.getTipoOficinaDto().getId().equals(1031L)){ //CEDENTES
						if (os.getEstadoEvaluacion()==null) {
							cedentesPendientes += 1;
						}else if (os.getEstadoEvaluacion()){
							estCedente = Boolean.TRUE;
						}else if (estCedente==null || !estCedente){
							estCedente = Boolean.FALSE;
						}
					}else if (os.getTipoOficinaDto().getId().equals(1032L)){ //Receptora
						if (os.getEstadoEvaluacion()==null) {
							receptoraPendientes += 1;
						}else if (os.getEstadoEvaluacion()){
							estReceptora = Boolean.TRUE;
						}else if (estReceptora==null || !estReceptora){
							estReceptora = Boolean.FALSE;
						}
					}
				}
			}
			
			if (estCedente!=null && estReceptora!=null) {
				if (estReceptora && estCedente) { //si aprobo el receptor y al menos un cedente
					estadoSolicitud = 1017L; // Solicitud Aprobada
				}else if (!estReceptora) { // Si el receptor rechaza la solicitud
					estadoSolicitud = 1018L; // Solicitud Rechazada
				}else if (!estCedente && cedentesPendientes==0) { //si no hay cedentes pendientes y el estado es rechazado 
					estadoSolicitud = 1018L; // Solicitud Rechazada
				}else {
					estadoSolicitud = 1016L; // Solicitud Pendiente
				}
			}else if (estReceptora!=null && !estReceptora){
				estadoSolicitud = 1018L; // Solicitud Rechazada
			}else if (estCedente!=null && !estCedente && cedentesPendientes==0) {
				estadoSolicitud = 1018L; // Solicitud Rechazada
			}else {
				estadoSolicitud = 1016L; // Solicitud Pendiente
			}
			
			//Enviamos correo si y solo sí se aprueba o se rechaza la solicitud
			if (estadoSolicitud.equals(1017L) || estadoSolicitud.equals(1018L)) {
				try {					
					EstadoSolicitudDto es = new EstadoSolicitudDto();
					es.setEstadoDto(ApplicationHelper.obtenerParametroPorId(estadoSolicitud));
					es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());
					es.setSolicitudDto(this.dto);
					es.setUsuario(this.sessionMBean.getRegistro());
					es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
					if (estadoSolicitud.equals(1017L))
						es.setComentario("SE APRUEBA LA SOLICITUD");
					else if (estadoSolicitud.equals(1018L)){
						es.setComentario("SE RECHAZA LA SOLICITUD");
					}				
					this.bo.insertarEstado(es);
					
					solicitudDto.setTramiteSolicitudDto(ApplicationHelper.obtenerParametroPorId(estadoSolicitud));					
					solicitudDto.setFechaModificacion(Utilitarios.Fecha.obtenerFechaActualDate());
					solicitudDto.setUsuarioModificacion(this.sessionMBean.getRegistro());					
					this.bo.editar(solicitudDto);
				} catch (ServiceException e1) {
					logger.error("", e1);
				}
				
				try {
					gestionCorreo.lanzarTipoCorreo(solicitudDto, TipoCorreoEnum.RECHAZO_APROBACION, null);
					showMessage("SOLICITUD EVALUADA DE MANERA SATISFACTORIA");
				} catch (Exception e) {
					logger.error("", e);
					showWarning("SE EVALUÓ LA SOLICITUD, PERO NO SE PUDO ENVIAR EL CORREO DE EVALUACIÓN");
				}
			}
			
		}
		
		if((solicitudDto.getTramiteSolicitudDto().getId().equals(1017L) || solicitudDto.getTramiteSolicitudDto().getId().equals(1020L)) && (estadoSolicitud.equals(1017L) || estadoSolicitud.equals(1016L))) {
			try {
				for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
					if(os.getEstadoEvaluacion() != null && os.getEnvioGestionFile() == null) {
						os.setEnvioGestionFile(BigDecimal.ONE);
						this.bo.editarOficinaSolicitud(os);
					}
				}
				
				gestionCorreo.lanzarTipoCorreo(solicitudDto, TipoCorreoEnum.GESTION_FILE, null);
				showMessage("SE ESTA ENVIANDO LA LISTA DE CONTRATOS APROBADOS A GESTIÓN DE FILES");
			} catch (Exception e) {
				logger.error("", e);
				showWarning("NO SE HA PODIDO ENVIAR LA LISTA DE CONTRATOS APROBADOS A GESTION DE FILES");
			}
		}
	}

	// Validamos si ya existe una oficinaOficina en la solicitud
	private OficinaSolicitudDto validarExisteOficinaSolicitud(OficinaDto oficinaDto) {
		for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
			if (os.getOficinaDto() != null && os.getOficinaDto().equals(oficinaDto)) {
				return os;
			}
		}
		return null;
	}

	// Cambiamos de estado a enviada
	public String enviar() {
		String to = com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_SOLICITUD;
		if (this.dto.getListaOficinasSolicitud() != null
				&& this.dto.getListaOficinasSolicitud().size() > 0) {
			try {
				// Agregando la Oficina Receptora
				OficinaSolicitudDto osReceptora = new OficinaSolicitudDto();
			    osReceptora.setEstadoAprobacionAjuBonDto(ApplicationHelper.obtenerParametroPorId(1034L));
			    osReceptora.setSilencioAdministrativo(Boolean.FALSE);
				osReceptora.setEstadoEvaluacion(null);
				osReceptora.setListaContratos(null);
				osReceptora.setListaInvolucrados(null);
				osReceptora.setOficinaDto(this.dto.getOficinaReceptorDto());
				osReceptora.setSolicitudDto(this.dto);
				osReceptora.setTipoOficinaDto(ApplicationHelper.obtenerParametroPorId(1032L));
				this.dto.getListaOficinasSolicitud().add(osReceptora);

				// Agregando la Oficina Receptora
				OficinaSolicitudDto osSolicitante = new OficinaSolicitudDto();
				osSolicitante.setEstadoAprobacionAjuBonDto(ApplicationHelper.obtenerParametroPorId(1034L));
				osSolicitante.setSilencioAdministrativo(Boolean.FALSE);
				osSolicitante.setEstadoEvaluacion(null);
				osSolicitante.setListaContratos(null);
				osSolicitante.setListaInvolucrados(null);
				osSolicitante.setOficinaDto(SelectOneMenuHelper.obtenerOficina(this.dto.getOficinaSolicitante()));
				osSolicitante.setSolicitudDto(this.dto);
				osSolicitante.setTipoOficinaDto(ApplicationHelper.obtenerParametroPorId(1033L));
				this.dto.getListaOficinasSolicitud().add(osSolicitante);

				// Agregando Involucrados
				for (OficinaSolicitudDto osx : this.dto.getListaOficinasSolicitud()) {
					List<InvolucradoDto> listaInvolucradosTmp = new ArrayList<InvolucradoDto>();
					List<OficinaInvolucradoDto> listaOficinaInvolucradoTmp = new ArrayList<OficinaInvolucradoDto>();

					if (osx.getOficinaDto() != null
							&& osx.getOficinaDto().getCodOficina() != null) {

						// Obtenemos los cargos
						List<ParametroDto> listaCargos = SelectOneMenuHelper.obtenerParametrosActivosPorCatalogo(1017L);
						String[] cargos = new String[listaCargos.size()];
						for (int i = 0; i < listaCargos.size(); i++) {
							ParametroDto p = listaCargos.get(i);
							cargos[i] = p.getValorCadena();
						}

						List<LdapDto> lista = this.ldapService.obtenerDtosInvolucrados(osx.getOficinaDto().getCodOficina(), cargos);
						lista.addAll(this.ldapService.obtenerDtosInvolucrados(osx.getOficinaDto().getTerritorioDto().getCodTerritorio(), cargos));
						for (LdapDto l1 : lista) {
							// CREANDO LOS INVOLUCRADOS
							InvolucradoDto d1 = new InvolucradoDto();
							d1.setApellidoMaterno(l1.getApemat().toUpperCase());
							d1.setApellidoPaterno(l1.getApepat().toUpperCase());
							d1.setCargo(l1.getCodcargo());
							d1.setDescripcionCargo(l1.getNomcargo().toUpperCase());
							d1.setRegistro(l1.getCodusu());
							d1.setNombres(l1.getNombre().toUpperCase());
							d1.setEmail(l1.getCorelec());

							listaInvolucradosTmp.add(d1);

							// RELACIONANDO OFICINA INVOLUCRADO
							OficinaInvolucradoDto oi = new OficinaInvolucradoDto();
							oi.setInvolucradoDto(d1);
							oi.setEstadoDto(ApplicationHelper.obtenerParametroPorId(1034L));
							oi.setOficinaSolicitudDto(osx);
							listaOficinaInvolucradoTmp.add(oi);

						}

						osx.setListaInvolucrados(listaOficinaInvolucradoTmp);
					}

				}

				this.dto.setUsuarioModificacion(sessionMBean.getRegistro());
				this.dto.setFechaModificacion(Utilitarios.Fecha.obtenerFechaActualDate());
				this.dto.setTramiteSolicitudDto(ApplicationHelper.obtenerParametroPorId(1016L));
				EstadoSolicitudDto es = new EstadoSolicitudDto();
				es.setEstadoDto(this.dto.getTramiteSolicitudDto());
				es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());

				es.setSolicitudDto(this.dto);
				es.setUsuario(this.sessionMBean.getRegistro());
				es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
				es.setComentario("SE ENVIA LA SOLICITUD");
				this.dto.getListaEstados().add(es);
				this.bo.editar(this.dto);

				/* this.dto = this.bo.obtener(this.dto.getId());
				for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
					for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
						oi.setEstadoDtoBkp(oi.getEstadoDto());
					}
				}
				
				obtenerOficinaReceptora();
				mostrarGestionFile(); */

				// to = null;// retroceder();

				// Enviar Correo
				try {
					dto = this.bo.obtener(this.dto.getId());
					gestionCorreo.lanzarTipoCorreo(dto, TipoCorreoEnum.EVALUACION, null);
					showMessage("SOLICITUD ENVIADA SATISFACTORIAMENTE");
				} catch (Exception e) {
					logger.error("e-mail", e);
					showWarning("SE ENVIÓ LA SOLICITUD, PERO NO SE PUDO ENVIAR EL CORREO");
				}

			} catch (Exception ex) {
				logger.error("", ex);
				to = null;
			}
		} else {
			showWarning("PARA ENVIAR LA SOLICITUD, AL MENOS DEBER TENER UN CONTRATO A REASIGNAR O UNIFICAR!");
		}

		return editar();
		
	}

	// Obtenemos la oficina Receptora
	void obtenerOficinaReceptora() {
		for (OficinaSolicitudDto os : this.dto.getListaOficinasSolicitud()) {
			if (os.getTipoOficinaDto().getId().equals(1032L)) {
				this.oficinaReceptoraDto = os;
			}
		}
	}

	// Cambiamos de estado anulado
	public String anular() {
		String to = null;
		try {
			this.dto.setUsuarioModificacion(sessionMBean.getRegistro());
			this.dto.setFechaModificacion(Utilitarios.Fecha
					.obtenerFechaActualDate());
			this.dto.setTramiteSolicitudDto(ApplicationHelper
					.obtenerParametroPorId(1022L));

			EstadoSolicitudDto es = new EstadoSolicitudDto();
			es.setEstadoDto(this.dto.getTramiteSolicitudDto());
			es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());

			es.setSolicitudDto(this.dto);
			es.setUsuario(this.sessionMBean.getRegistro());
			es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
			es.setComentario("ANULACION DE LA SOLICITUD");
			this.dto.getListaEstados().add(es);

			this.bo.editar(this.dto);

			showMessage("SOLICITUD ANULADA SATISFACTORIAMENTE");
			to = retroceder();
		} catch (Exception ex) {
			logger.error(ex);
			showError(ex.getMessage());
			to = null;
		}
		return to;
	}
	
	// Cambiamos de estado anulado
	public String reevaluar() {
		String to = null;
		
		try {
			this.dto.setUsuarioModificacion(sessionMBean.getRegistro());
			this.dto.setFechaModificacion(Utilitarios.Fecha.obtenerFechaActualDate());
			this.dto.setTramiteSolicitudDto(ApplicationHelper.obtenerParametroPorId(1016L));

			EstadoSolicitudDto es = new EstadoSolicitudDto();
			es.setEstadoDto(this.dto.getTramiteSolicitudDto());
			es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());			

			es.setSolicitudDto(this.dto);
			es.setUsuario(this.sessionMBean.getRegistro());
			es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
			es.setComentario("REEVALUACIÓN DE LA SOLICITUD");
			
			for(OficinaSolicitudDto os:this.dto.getListaOficinasSolicitud()) {
				os.setEstadoEvaluacion(null);
				os.setEstadoAprobacionAjuBonDto(ApplicationHelper.obtenerParametroPorId(1034L));
				os.setFechaEvaluacion(null);				
				os.setSilencioAdministrativo(Boolean.FALSE);
				os.setHabilitarEvaluacion(Boolean.TRUE);	
				
				for (OficinaInvolucradoDto oi : os.getListaInvolucrados()) {
					oi.setEstadoDto(ApplicationHelper.obtenerParametroPorId(1034L));
					oi.setComentario(null);
					oi.setFecha(null);
				}
			}			
			this.dto.getListaEstados().add(es);

			this.bo.editar(this.dto);

			showMessage("SOLICITUD REEVALUADA SATISFACTORIAMENTE");
			to = retroceder();
		} catch (Exception ex) {
			logger.error(ex);
			showError(ex.getMessage());
			to = null;
		}
		return to;
	}

	// Guardamos la solicitud
	public String guardar() {
		String to = null;
		String mensajeTrx = "";

		if (validar()) {
			if (this.sessionMBean.getAccion() == Constantes.Form.NUEVO) {
				try {

					this.dto.setUsuarioCreacion(sessionMBean.getRegistro());
					this.dto.setFechaCreacion(Utilitarios.Fecha.obtenerFechaActualDate());
					this.dto.setEmailSolicitante(sessionMBean.getUsuarioLdapSesion().getCorelec());

					LdapDto ldapReceptor = ldapService.obtenerInformacionPorRegistro(this.dto.getGestorReceptorDto().getCodGestor());

					if (ldapReceptor != null) {
						this.dto.setEmailReceptor(ldapReceptor.getCorelec());
					}

					EstadoSolicitudDto es = new EstadoSolicitudDto();
					es.setEstadoDto(this.dto.getTramiteSolicitudDto());
					es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());

					es.setSolicitudDto(this.dto);
					es.setUsuario(this.sessionMBean.getRegistro());
					es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
					es.setComentario("CREACION DE LA SOLICITUD");
					this.dto.getListaEstados().add(es);

					this.bo.insertar(this.dto);
					showMessage(Utilitarios.Internacionalizacion.getMensajeInternacional("form.general.mensaje.transaccion.ok"));
					this.sessionMBean.setAccion(Constantes.Form.EDITAR);
					cargarContratosCliente();
					to = null;

				} catch (Exception ex) {
					logger.error("", ex);
					to = null;
				}
			} else if (this.sessionMBean.getAccion() == Constantes.Form.EDITAR) {
				try {
					this.dto.setUsuarioModificacion(sessionMBean.getRegistro());
					this.dto.setFechaModificacion(Utilitarios.Fecha.obtenerFechaActualDate());
					EstadoSolicitudDto es = new EstadoSolicitudDto();
					es.setEstadoDto(this.dto.getTramiteSolicitudDto());
					es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());
					es.setUsuario(this.sessionMBean.getRegistro());
					es.setSolicitudDto(this.dto);
					es.setUsuario(this.sessionMBean.getRegistro());
					es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
					es.setComentario("ACTUALIZACION DE LA SOLICITUD");
					this.dto.getListaEstados().add(es);

					this.sessionMBean.setAccion(Constantes.Form.EDITAR);

					this.bo.editar(this.dto);

					showMessage(Utilitarios.Internacionalizacion.getMensajeInternacional("form.general.mensaje.transaccion.ok"));

					to = null;
				} catch (Exception ex) {
					logger.error("", ex);
					to = null;
				}
			}
		} else {
			to = "";
		}

		return to;
	}

	private boolean validar() {
		boolean retorno = true;
		
		if (this.dto.getNombreCliente() == null || this.dto.getNombreCliente().length()==0 ) {
			showError("CLIENTE NO HA SIDO VALIDADO");
			retorno = false;
		}
		if (this.dto.getCodigoSolicitud() == null || this.dto.getCodigoSolicitud().length()==0 ) {
			showError("EL CODIGO DE LA SOLICITUD NO ES VÁLIDO");
			retorno = false;
		}

		if (this.dto.getOficinaReceptorDto() == null) {
			showError("LA OFICINA DEL RECEPTOR ES OBLIGATORIO.");
			retorno = false;
		}

		if (this.dto.getGestorReceptorDto() == null) {
			showError("EL GESTOR DEL RECEPTOR ES OBLIGATORIO.");
			retorno = false;
		}

		return retorno;
	}

	public String retroceder() {
		// inicializarPerfil();
		buscar(null);
		this.sessionMBean.setAccion(Constantes.Form.LISTA);
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_LISTA_SOLICITUD;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		SolicitudMBean.logger = logger;
	}

	public SolicitudDto getDto() {
		return dto;
	}

	public void setDto(SolicitudDto dto) {
		this.dto = dto;
	}

	public SolicitudDto getDtoFiltro() {
		return dtoFiltro;
	}

	public void setDtoFiltro(SolicitudDto dtoFiltro) {
		this.dtoFiltro = dtoFiltro;
	}

	public List<SolicitudDto> getLista() {
		return lista;
	}

	public void setLista(List<SolicitudDto> lista) {
		this.lista = lista;
	}

	public List<ParametroDto> getTiposSolicitud() {
		return SelectOneMenuHelper.obtenerParametrosActivosPorCatalogo(1004L);
	}

	public void setTiposSolicitud(List<ParametroDto> tiposSolicitud) {
		this.tiposSolicitud = tiposSolicitud;
	}

	public List<ParametroDto> getEstadosSolicitud() {
		return SelectOneMenuHelper.obtenerParametrosActivosPorCatalogo(1005L);
	}

	public void setEstadosSolicitud(List<ParametroDto> estadosSolicitud) {
		this.estadosSolicitud = estadosSolicitud;
	}

	public List<ParametroDto> getMotivosSolicitud() {
		List<ParametroDto> lista = null;
		
		if(this.dto.getSegmentoCliente() != null) {
			lista = SelectOneMenuHelper.obtenerMotivosTraslado(this.dto.getSegmentoCliente(), this.dto.getTipoDto().getId().intValue());
		}
		
		if(lista == null) {
			lista = SelectOneMenuHelper.obtenerParametrosActivosPorCatalogo(1006L);
		} else {
			if(lista.size() == 0) {
				lista = SelectOneMenuHelper.obtenerParametrosActivosPorCatalogo(1006L);
			}
		}
		
		return lista;
	}

	public void setMotivosSolicitud(List<ParametroDto> motivosSolicitud) {
		this.motivosSolicitud = motivosSolicitud;
	}

	public List<TerritorioDto> getListaTerritorios() {
		this.listaTerritorios = SelectOneMenuHelper.obtenerTerritorios(null);
		Utilitarios.General.ordena(listaTerritorios, "codTerritorio");
		return listaTerritorios;
	}

	public void setListaTerritorios(List<TerritorioDto> listaTerritorios) {
		this.listaTerritorios = listaTerritorios;
	}

	public List<OficinaDto> getListaOficinas() {
		// if (this.dto.getTerritorioReceptorDto() != null) {
		if(listaOficinas == null) {
			AplicacionMBean aplicacionMBean = (AplicacionMBean) WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
			this.setListaOficinas(aplicacionMBean.getListaOficinas());
			// this.listaOficinas = SelectOneMenuHelper.obtenerOficinasPorTerritorio(this.dto.getTerritorioReceptorDto().getCodTerritorio());
			Utilitarios.General.ordena(listaOficinas, "codOficina");
		}
		return listaOficinas;
	}

	public void setListaOficinas(List<OficinaDto> listaOficinas) {
		this.listaOficinas = listaOficinas;
	}

	public List<GestorDto> getListaGestores() {
		if (this.dto.getOficinaReceptorDto() != null) {
			this.listaGestores = SelectOneMenuHelper.obtenerGestoresPorOficina(this.dto.getOficinaReceptorDto().getCodOficina());
			if(this.listaGestores != null) {
				Utilitarios.General.ordena(listaGestores, "ID");
			} else {
				this.listaGestores = new ArrayList<GestorDto>();
			}
		}else {
			this.listaGestores = new ArrayList<GestorDto>();
		}

		return listaGestores;
	}

	public void setListaGestores(List<GestorDto> listaGestores) {
		this.listaGestores = listaGestores;
	}

	public SolicitudBO getBo() {
		return bo;
	}

	public void setBo(SolicitudBO bo) {
		this.bo = bo;
	}

	public SessionMBean getSessionMBean() {
		return sessionMBean;
	}

	public void setSessionMBean(SessionMBean sessionMBean) {
		this.sessionMBean = sessionMBean;
	}

	public LdapService getLdapService() {
		return ldapService;
	}

	public void setLdapService(LdapService ldapService) {
		this.ldapService = ldapService;
	}

	public List<ParametroDto> getTiposSolicitudFiltro() {
		return SelectOneMenuHelper.obtenerParametrosActivosPorCatalogoTodos(1004L);
	}

	public void setTiposSolicitudFiltro(List<ParametroDto> tiposSolicitudFiltro) {
		this.tiposSolicitudFiltro = tiposSolicitudFiltro;
	}

	public List<ParametroDto> getEstadosSolicitudFiltro() {
		return SelectOneMenuHelper.obtenerParametrosActivosPorCatalogoTodos(1005L);
	}

	public void setEstadosSolicitudFiltro(List<ParametroDto> estadosSolicitudFiltro) {
		this.estadosSolicitudFiltro = estadosSolicitudFiltro;
	}

	public List<ContratoTemporalDto> getListaContratosTemporal() {
		if (this.listaContratosTemporal == null)
			this.listaContratosTemporal = new ArrayList<ContratoTemporalDto>();
		Utilitarios.General.ordena(this.listaContratosTemporal, "oficina");
		return listaContratosTemporal;
	}

	public void setListaContratosTemporal(List<ContratoTemporalDto> listaContratosTemporal) {
		this.listaContratosTemporal = listaContratosTemporal;
	}

	public ContratoTemporalDto[] getListaContratosTemporalSelected() {
		return listaContratosTemporalSelected;
	}

	public void setListaContratosTemporalSelected(ContratoTemporalDto[] listaContratosTemporalSelected) {
		this.listaContratosTemporalSelected = listaContratosTemporalSelected;
	}

	public ContratoTemporalDataModel getMediumCarsModel() {
		return mediumCarsModel;
	}

	public void setMediumCarsModel(ContratoTemporalDataModel mediumCarsModel) {
		this.mediumCarsModel = mediumCarsModel;
	}

	public List<ParametroDto> getListaEstadoArobacion() {
		return SelectOneMenuHelper.obtenerParametrosActivosPorCatalogo(1007L);
	}

	public void setListaEstadoArobacion(List<ParametroDto> listaEstadoArobacion) {
		this.listaEstadoArobacion = listaEstadoArobacion;
	}

	public ContratoDto getContratoDto() {
		return contratoDto;
	}

	public void setContratoDto(ContratoDto contratoDto) {
		this.contratoDto = contratoDto;
	}

	public OficinaSolicitudDto getOficinaSolicitudDto() {
		return oficinaSolicitudDto;
	}

	public void setOficinaSolicitudDto(OficinaSolicitudDto oficinaSolicitudDto) {
		this.oficinaSolicitudDto = oficinaSolicitudDto;
	}

	public Boolean getMostrarGestionFile() {
		return mostrarGestionFile;
	}

	public void setMostrarGestionFile(Boolean mostrarGestionFile) {
		this.mostrarGestionFile = mostrarGestionFile;
	}

	public String getMensajeMostrarGestionFile() {
		return mensajeMostrarGestionFile;
	}

	public void setMensajeMostrarGestionFile(String mensajeMostrarGestionFile) {
		this.mensajeMostrarGestionFile = mensajeMostrarGestionFile;
	}

	public OficinaSolicitudDto getOficinaReceptoraDto() {
		return oficinaReceptoraDto;
	}

	public void setOficinaReceptoraDto(OficinaSolicitudDto oficinaReceptoraDto) {
		this.oficinaReceptoraDto = oficinaReceptoraDto;
	}

	public ReaUniDatosClienteRs obtenerDatosClienteHost(String codigoCliente, String registroUsuario) throws Exception {

		ReaUniServiceServiceProxy proxy = new ReaUniServiceServiceProxy();
		
		String servidorServicioWeb = ApplicationHelper.obtenerParametroPorId(1064L).getValorCadena();

		proxy.setEndpoint("http://" + servidorServicioWeb + "/reauni/consultaDatosCliente/");
		ReaUniDatosClienteHdrRq header = new ReaUniDatosClienteHdrRq();
		header.setUsuario(registroUsuario);

		ReaUniDatosClienteDataRq data = new ReaUniDatosClienteDataRq();
		data.setCodigoCliente(codigoCliente);

		ReaUniDatosClienteRq request = new ReaUniDatosClienteRq();
		request.setHeader(header);
		request.setData(data);
		ReaUniDatosClienteRs res = new ReaUniDatosClienteRs();

		try {
			res = proxy.datosCliente(request);
			return res;
		} catch (RemoteException e) {
			logger.error("", e);
			return null;
		}
	}

	public GestionCorreo getGestionCorreo() {
		return gestionCorreo;
	}

	public void setGestionCorreo(GestionCorreo gestionCorreo) {
		this.gestionCorreo = gestionCorreo;
	}

	public String getLblBonificacionOtros() {
		return lblBonificacionOtros;
	}

	public void setLblBonificacionOtros(String lblBonificacionOtros) {
		this.lblBonificacionOtros = lblBonificacionOtros;
	}

	public String getLblBonificacionNoExcede7Dias() {
		return lblBonificacionNoExcede7Dias;
	}

	public void setLblBonificacionNoExcede7Dias(
			String lblBonificacionNoExcede7Dias) {
		this.lblBonificacionNoExcede7Dias = lblBonificacionNoExcede7Dias;
	}

	public String getLblAjustesOtros() {
		return lblAjustesOtros;
	}

	public void setLblAjustesOtros(String lblAjustesOtros) {
		this.lblAjustesOtros = lblAjustesOtros;
	}

	public String getLblAjustesGrupoEconomico() {
		return lblAjustesGrupoEconomico;
		
	}

	public void setLblAjustesGrupoEconomico(String lblAjustesGrupoEconomico) {
		this.lblAjustesGrupoEconomico = lblAjustesGrupoEconomico;
	}

	public String getLblAjustesVentaUltimoEjercicio() {
		return lblAjustesVentaUltimoEjercicio;
	}

	public void setLblAjustesVentaUltimoEjercicio(
			String lblAjustesVentaUltimoEjercicio) {
		this.lblAjustesVentaUltimoEjercicio = lblAjustesVentaUltimoEjercicio;
	}

	public OficinaInvolucradoDto getOficinaInvolucradoDto() {
		return oficinaInvolucradoDto;
	}

	public void setOficinaInvolucradoDto(OficinaInvolucradoDto oficinaInvolucradoDto) {
		this.oficinaInvolucradoDto = oficinaInvolucradoDto;
	}

	public Boolean getEsGerenteTerritorial() {	
		return this.getSessionMBean().getEsGerenteTerritorial();
	}

	public Boolean getRestringirGestionFiles() {
		restringirGestionFiles = Boolean.FALSE;
		for (OficinaSolicitudDto os2:this.dto.getListaOficinasSolicitud()) {
			if (os2.getTipoOficinaDto().getId().equals(1032L)) // Cualquier receptor
				for (OficinaInvolucradoDto oi2 : os2.getListaInvolucrados()) {
					if (this.sessionMBean.getRegistro().equals(oi2.getInvolucradoDto().getRegistro())) {
						restringirGestionFiles = Boolean.TRUE;
						break;
					}
				}
		}

		return restringirGestionFiles;
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

	public List<OficinaDto> buscarSolicitante(String query) {
		return buscarSolicitante(query, this.listaOficinasBuscar);
	}
	
	public List<OficinaDto> buscarOficina(String query) {
		return buscarSolicitante(query, this.getListaOficinas());
	}
	
	public List<OficinaDto> buscarSolicitante(String query, List<OficinaDto> listaOriginal) {
		List<OficinaDto> resultado = new ArrayList<OficinaDto>();
		boolean encontro = false;
		String mensaje = "No se cargo correctamente la lista de oficinas.";
		if(listaOriginal != null) {
			for (OficinaDto ofic : listaOriginal) {
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

	public Boolean getBloquearControles() {
		if (this.dto.getTramiteSolicitudDto().getId().equals(1021L)||this.dto.getTramiteSolicitudDto().getId().equals(1022L)||
				this.dto.getTramiteSolicitudDto().getId().equals(1018L)||this.dto.getTramiteSolicitudDto().getId().equals(1015L)){
			bloquearControles = Boolean.TRUE;
		}else {
			bloquearControles = Boolean.FALSE;
		}
		return bloquearControles;
	}

	public void setBloquearControles(Boolean bloquearControles) {
		this.bloquearControles = bloquearControles;
	}

	public void setRestringirGestionFiles(Boolean restringirGestionFiles) {
		this.restringirGestionFiles = restringirGestionFiles;
	}

	public Boolean getMostrarDeclaracionJurada() {
		if (this.dto.getTipoDto().getId().equals(1006L)) { //uni
			if (this.dto.getBonificacionNoExcede7Dias()||this.dto.getBonificacionOtros()||this.dto.getBonificacion2()) {
				mostrarDeclaracionJurada = Boolean.TRUE;
			}else {
				mostrarDeclaracionJurada = Boolean.FALSE;
			}
		}else { //rea
			if (this.dto.getAjusteFormaGrupo()||this.dto.getAjusteOtros()||this.dto.getAjusteVentaUltimo()) {
				mostrarDeclaracionJurada = Boolean.TRUE;
			}else {
				mostrarDeclaracionJurada = Boolean.FALSE;
			}
				
		}
		return mostrarDeclaracionJurada;
		
	}

	public void setMostrarDeclaracionJurada(Boolean mostrarDeclaracionJurada) {
		this.mostrarDeclaracionJurada = mostrarDeclaracionJurada;
	}

	public List<OficinaDto> getListaOficinasBuscar() {
		if(listaOficinasBuscar == null) {
			inicializarPerfil();
		}
		return listaOficinasBuscar;
	}

	public void setListaOficinasBuscar(List<OficinaDto> listaOficinasBuscar) {
		this.listaOficinasBuscar = listaOficinasBuscar;
	}

	public String getLblBonificacion2() {
		return lblBonificacion2;
	}

	public void setLblBonificacion2(String lblBonificacion2) {
		this.lblBonificacion2 = lblBonificacion2;
	}
	
	public boolean getBonificacion2() {
		return (this.lblBonificacion2 != null && this.lblBonificacion2.trim().length() > 0);
	}
	
	public String getBr() {
		return "<br />";
	}
	
	boolean aplicaAjusteBonificacion;
	
	public boolean getAplicaAjusteBonificacion() {
		return aplicaAjusteBonificacion;
	}
	
	public void setAplicaAjusteBonificacion(boolean aplicaAjusteBonificacion) {
		this.dto.setAjusteComentarios("");
		this.dto.setAjusteOtros(false);
		this.dto.setAjusteVentaUltimo(false);
		this.dto.setAjusteFormaGrupo(false);
		
		this.dto.setBonificacionComentarios("");
		this.dto.setBonificacionOtros(false);
		this.dto.setBonificacion2(false);
		this.dto.setBonificacionNoExcede7Dias(false);
		
		this.aplicaAjusteBonificacion = aplicaAjusteBonificacion;
	}
}
