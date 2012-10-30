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

@Controller("consultaContratoFileMBean")
@Scope("session")
public class ConsultaContratoFileMBean extends GenericMBean{
	
	private static Logger logger = Logger.getLogger(ConsultaContratoFileMBean.class);

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
	
	private List<OficinaDto> listaOficinasBuscar;
	private SolicitudDto dtoFiltro;
	private Boolean activaOficinaSolicitante;
	private Boolean activaOficinaReceptora;
	private Boolean activaOficinaCedente;
	
	public ConsultaContratoFileMBean() {
		inicializar();
		
	}
	
	public void keyupOficinaReceptoraBuscar(SelectEvent event) {
		if(event.getObject() != null) {
			String o = (String) event.getObject();
			if(o.length() < 4) {
				this.dtoFiltro.setOficinaReceptora(null);
			}
		} else {
			this.dtoFiltro.setOficinaReceptora(null);
		}
	}
	
	public void keyupOficinaCedenteBuscar(SelectEvent event) {
		if(event.getObject() != null) {
			String o = (String) event.getObject();
			if(o.length() < 4) {
				this.dtoFiltro.setOficinaCedente(null); 
			}
		} else {
			this.dtoFiltro.setOficinaCedente(null);
		}
	}
	
	public void keyupOficinaSolicitanteBuscar(SelectEvent event) {
		if(event.getObject() != null) {
			String o = (String) event.getObject();
			if(o.length() < 4) {
				this.dtoFiltro.setOficSolicitante(null);
			}
		} else {
			this.dtoFiltro.setOficSolicitante(null);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String iniciar () {
		
		inicializar();
		
		this.dtoFiltro = this.contratoDto.getOficinaSolicitudDto().getSolicitudDto();
		this.setActivaOficinaSolicitante(Boolean.FALSE);
		this.setActivaOficinaReceptora(Boolean.FALSE);
		this.setActivaOficinaCedente(Boolean.FALSE);
		
		inicializarPerfil();
		setListaContratos(new ArrayList());
		
		this.dtoFiltro.setFechaInicio(new Date());
		this.dtoFiltro.setFechaHasta(new Date());
		
		return Constantes.UrlNavegacion.URL_LISTA_CONTRATO_FILE;
	}
	
	void inicializar () {
		this.contratoDto = new ContratoDto();
		
		this.contratoDto.setEstadoDto(ApplicationHelper.obtenerParametroPorId(1003L));
		this.contratoDto.setOficinaSolicitudDto(new OficinaSolicitudDto());
		this.contratoDto.getOficinaSolicitudDto().setSolicitudDto(new SolicitudDto());
		this.contratoDto.getOficinaSolicitudDto().setOficinaDto(new OficinaDto());
		this.contratoDto.setProducto("");
	}
 
	private void inicializarPerfil() {
		AplicacionMBean aplicacionMBean = (AplicacionMBean) WebServletContextListener.getApplicationContext().getBean("aplicacionMBean");
		
		this.setActivaOficinaSolicitante(Boolean.FALSE);
		this.setActivaOficinaReceptora(Boolean.FALSE);
		this.setActivaOficinaCedente(Boolean.FALSE);
		switch(sessionMBean.getRol()) {
		case com.indra.pe.bbva.reauni.util.Constantes.Rol.ADM:
			setListaOficinasBuscar(aplicacionMBean.getListaOficinas());
			break;
		case com.indra.pe.bbva.reauni.util.Constantes.Rol.GTE:
			this.setListaOficinasBuscar(SelectOneMenuHelper.obtenerOficinasPorTerritorio(sessionMBean.getCodOficina()));
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
	
	public void buscar(ActionEvent actionEvent) {
		try {			
			
			this.listaContratos = this.solicitudBo.listaContratosFile(this.contratoDto, sessionMBean);
		} catch (ServiceException e) {
			logger.error("",e);
		}		
	}
	
	public void guardarFiles(ActionEvent actionEvent) {
		try {			
			
			this.solicitudBo.guardarContratos(this.listaContratos);		
		} catch (ServiceException e) {			
			logger.error("",e);
		}
	}
	
	public String guardarContrato () {
		try {
			this.contrato.setUsuarioRecepcionFile(sessionMBean.getRegistro());
			this.contrato.setFechaRecepcionFile(Utilitarios.Fecha.obtenerFechaActualDate());			
			this.contrato.setEstadoFile(Boolean.TRUE);
			this.solicitudBo.guardarContrato(this.contrato);		
			
			SolicitudDto s = this.solicitudBo.obtenerSolicitud(contrato);
			//Agregamos una bitacora del estado
			EstadoSolicitudDto es = new EstadoSolicitudDto();
			es.setEstadoDto(s.getTramiteSolicitudDto());
			es.setFecha(Utilitarios.Fecha.obtenerFechaActualDate());
			es.setSolicitudDto(s);
			es.setUsuario(this.sessionMBean.getRegistro());
			es.setUsuarioDto(this.sessionMBean.getUsuarioLdapSesion());
			es.setComentario("RECEPCION DE CONTRATO #"+this.contrato.getCodigoContrato());			
			this.solicitudBo.insertarEstado(es);
			
		} catch (ServiceException e) {			
			logger.error("",e);
		}

		return null;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		ConsultaContratoFileMBean.logger = logger;
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
		this.estadosHost = SelectOneMenuHelper.obtenerParametrosActivosPorCatalogo(1009L);
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
		this.listaEstados = SelectOneMenuHelper.obtenerParametrosActivosPorCatalogoTodos(1009L);
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

	public List<OficinaDto> getListaOficinasBuscar() {
		return listaOficinasBuscar;
	}

	public void setListaOficinasBuscar(List<OficinaDto> listaOficinas) {
		this.listaOficinasBuscar = listaOficinas;
	}	
	
	public List<OficinaDto> buscarSolicitante(String query) {
		List<OficinaDto> resultado = new ArrayList<OficinaDto>();
		boolean encontro = false;
		String mensaje = "No se cargo correctamente la lista de oficinas.";
		if(listaOficinasBuscar != null) {
			for (OficinaDto ofic : listaOficinasBuscar) {
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
			DocumentoExcel docExcel = new DocumentoExcel(document, "GestionFiles");
			docExcel.postProcessXLS(document);
		} catch (Exception e) {
			logger.error("Exportar", e);
		}
	}
}
