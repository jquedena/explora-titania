package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.reauni.service.GestorBO;
import com.indra.pe.bbva.reauni.service.ProductoBO;
import com.indra.pe.bbva.reauni.view.helper.SessionHelper;

@SuppressWarnings("unused")
@Entity
@Table(name = "TREAUNI_SOLICITUD", schema = "REAUNI")
public class SolicitudDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_SOLICITUD")
	@TableGenerator(name = "SEQ_SOLICITUD", schema = "REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_SOLICITUD", allocationSize = 1)
	private Long id;
	
	@Column(name = "NUMERO")
	private String numero;

	@JoinColumn(name = "TIPO", referencedColumnName = "ID")
	@ManyToOne
	private ParametroDto tipoDto;

	@Column(name = "CODIGO_CLIENTE")
	private String codigoCliente;
	
	@Column(name = "NOMBRE_CLIENTE")
	private String nombreCliente;
	
	@Column(name = "SEGMENTO_CLIENTE")
	private String segmentoCliente;
	
	@Column(name = "CLASIFICACION_CLIENTE")
	private String clasificacionCliente;
	
	@Column(name = "FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	@JoinColumn(name = "TRAMITE_SOLICITUD", referencedColumnName = "ID")
	@ManyToOne
	private ParametroDto tramiteSolicitudDto;

	@Column(name = "OFICINA_SOLICITANTE")
	private String oficinaSolicitante;
	
	@Column(name = "RESPONSABLE_SOLICITANTE")
	private String responsableSolicitante;

	@JoinColumn(name = "TERRITORIO_RECEPTOR", referencedColumnName = "COD_TERRITORIO", nullable = true)
	@ManyToOne
	private TerritorioDto territorioReceptorDto;

	@Column(name = "GESTOR_RECEPTOR")
	private String gestorReceptor;

	@JoinColumn(name = "OFICINA_RECEPTOR", referencedColumnName = "COD_OFICINA", nullable = true)
	@ManyToOne
	private OficinaDto oficinaReceptorDto;

	@Column(name = "TOTAL_ACTIVO")
	private BigDecimal totalActivo;
	
	@Column(name = "TOTAL_PASIVO")
	private BigDecimal totalPasivo;

	@Column(name = "BONIFICACION_NO_EXCEDE_7_DIAS")
	private Boolean bonificacionNoExcede7Dias;
	
	@Column(name = "BONIFICACION_2")
	private Boolean bonificacion2;
	
	@Column(name = "BONIFICACION_OTROS")
	private Boolean bonificacionOtros;
	
	@Column(name = "BONIFICACION_COMENTARIOS")
	private String bonificacionComentarios;

	@Column(name = "AJUSTE_OTROS")
	private Boolean ajusteOtros;
	
	@Column(name = "AJUSTE_FORMA_GRUPO")
	private Boolean ajusteFormaGrupo;
	
	@Column(name = "AJUSTE_VENTA_ULTIMO")
	private Boolean ajusteVentaUltimo;
	
	@Column(name = "AJUSTE_COMENTARIOS")
	private String ajusteComentarios;

	@JoinColumn(name = "MOTIVO_TRASLADO", referencedColumnName = "ID")
	@ManyToOne
	private ParametroDto motivoTrasladoDto;

	@Column(name = "MOTIVO_COMENTARIOS")
	private String motivoComentarios;

	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name = "USUARIO_CREACION")
	private String usuarioCreacion;
	
	@Column(name = "USUARIO_MODIFICACION")
	private String usuarioModificacion;
	
	@Column(name = "CODIGO_SOLICITUD")
	private String codigoSolicitud;
	
	@Column(name = "TERRITORIO_SOLICITANTE")
	private String territorioSolicitante;

	@Column(name = "OFICINA_SOLICITANTE_DESC")
	private String oficinaSolicitanteDesc;

	@Column(name = "RESPONSABLE_SOLICITANTE_DESC")
	private String responsableSolicitanteDesc;

	@Column(name = "TERRITORIO_SOLICITANTE_DESC")
	private String territorioSolicitanteDesc;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudDto", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<OficinaSolicitudDto> listaOficinasSolicitud;

	@Transient
	private Boolean contratosGenerados;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudDto", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<EstadoSolicitudDto> listaEstados;

	@Column(name = "EMAIL_SOLICITANTE")
	private String emailSolicitante;

	@Column(name = "EMAIL_RECEPTOR")
	private String emailReceptor;

	@Column(name = "OFICINA_PRINCIPAL_CLIENTE")
	private String oficinaPrincipalCliente;

	@Column(name = "GESTOR_PRINCIPAL_CLIENTE")
	private String gestorPrincipalCliente;
	
	@Transient
	private Boolean mostrarDeclaracionJurada;

	@Transient
	private Date fechaInicio;

	@Transient
	private Date fechaHasta;

	@Transient
	private OficinaDto oficSolicitante;

	@Transient
	private OficinaDto oficinaReceptora;

	@Transient
	private OficinaDto oficinaCedente;

	@Transient
	private Boolean flag_oficinaSolicitante = Boolean.TRUE;

	@Transient
	private Boolean flag_oficinaReceptora = Boolean.TRUE;

	@Transient
	private Boolean flag_oficinaCedente = Boolean.TRUE;

	@Column(name = "FECHA_APROBACION_SILENCIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAprobacionSilencio;

	@Column(name = "APROBADA_POR_SILENCIO")
	private Boolean aprobadaPorSilencio;

	@Column(name = "OFICINA_PRINCIPAL_CLIENTE_DESC")
	private String oficinaPrincipalClienteDesc;

	@Column(name = "GESTOR_PRINCIPAL_CLIENTE_DESC")
	private String gestorPrincipalClienteDesc;

	@Column(name = "SEGMENTO_CLIENTE_DESC")
	private String segmentoClienteDesc;

	@Column(name = "CLASIFICACION_CLIENTE_DESC")
	private String clasificacionClienteDesc;
	
	public SolicitudDto() {
	}

	public String getOficinaPrincipalClienteDesc() {
		return oficinaPrincipalClienteDesc;
	}

	public void setOficinaPrincipalClienteDesc(
			String oficinaPrincipalClienteDesc) {
		this.oficinaPrincipalClienteDesc = oficinaPrincipalClienteDesc;
	}

	public String getGestorPrincipalClienteDesc() {
		return gestorPrincipalClienteDesc;
	}

	public void setGestorPrincipalClienteDesc(String gestorPrincipalClienteDesc) {
		this.gestorPrincipalClienteDesc = gestorPrincipalClienteDesc;
	}

	public String getSegmentoClienteDesc() {
		return segmentoClienteDesc;
	}

	public void setSegmentoClienteDesc(String segmentoClienteDesc) {
		this.segmentoClienteDesc = segmentoClienteDesc;
	}

	public String getClasificacionClienteDesc() {
		return clasificacionClienteDesc;
	}

	public void setClasificacionClienteDesc(String clasificacionClienteDesc) {
		this.clasificacionClienteDesc = clasificacionClienteDesc;
	}

	public SolicitudDto(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getSegmentoCliente() {
		return segmentoCliente;
	}

	public void setSegmentoCliente(String segmentoCliente) {
		this.segmentoCliente = segmentoCliente;
	}

	public String getClasificacionCliente() {
		return clasificacionCliente;
	}

	public void setClasificacionCliente(String clasificacionCliente) {
		this.clasificacionCliente = clasificacionCliente;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getOficinaSolicitante() {
		return oficinaSolicitante;
	}

	public void setOficinaSolicitante(String oficinaSolicitante) {
		this.oficinaSolicitante = oficinaSolicitante;
	}

	public String getResponsableSolicitante() {
		return responsableSolicitante;
	}

	public void setResponsableSolicitante(String responsableSolicitante) {
		this.responsableSolicitante = responsableSolicitante;
	}

	public TerritorioDto getTerritorioReceptorDto() {
		return territorioReceptorDto;
	}

	public void setTerritorioReceptorDto(TerritorioDto territorioReceptorDto) {
		this.territorioReceptorDto = territorioReceptorDto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public GestorDto getGestorReceptorDto() {
		GestorBO gestorBO = (GestorBO) WebServletContextListener.getApplicationContext().getBean("gestorBO");
		GestorDto gestor;
		gestor = gestorBO.obtenerGestor(this);
		return gestor;
	}
	
	public void setGestorReceptorDto(GestorDto gestorReceptorDto) {
		if(gestorReceptorDto != null) {
			this.gestorReceptor = gestorReceptorDto.getRegGestor();
		} else {
			this.gestorReceptor = "";
		}
	}
	
	public String getGestorReceptor() {
		return gestorReceptor;
	}

	public void setGestorReceptor(String gestorReceptor) {
		this.gestorReceptor = gestorReceptor;
	}

	public BigDecimal getTotalActivo() {
		return totalActivo;
	}

	public void setTotalActivo(BigDecimal totalActivo) {
		this.totalActivo = totalActivo;
	}

	public BigDecimal getTotalPasivo() {
		return totalPasivo;
	}

	public void setTotalPasivo(BigDecimal totalPasivo) {
		this.totalPasivo = totalPasivo;
	}

	public List<EstadoSolicitudDto> getListaEstados() {
		if (this.listaEstados == null)
			this.listaEstados = new ArrayList<EstadoSolicitudDto>();
		Utilitarios.General.ordena(this.listaEstados, "id");
		return listaEstados;

	}

	public void setListaEstados(List<EstadoSolicitudDto> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public Boolean getBonificacionNoExcede7Dias() {
		return bonificacionNoExcede7Dias;
	}

	public void setBonificacionNoExcede7Dias(Boolean bonificacionNoExcede7Dias) {
		this.bonificacionNoExcede7Dias = bonificacionNoExcede7Dias;
	}

	public Boolean getAjusteFormaGrupo() {
		return ajusteFormaGrupo;
	}

	public void setAjusteFormaGrupo(Boolean ajusteFormaGrupo) {
		this.ajusteFormaGrupo = ajusteFormaGrupo;
	}

	public Boolean getAjusteVentaUltimo() {
		return ajusteVentaUltimo;
	}

	public void setAjusteVentaUltimo(Boolean ajusteVentaUltimo) {
		this.ajusteVentaUltimo = ajusteVentaUltimo;
	}

	public Boolean getBonificacionOtros() {
		return bonificacionOtros;
	}

	public void setBonificacionOtros(Boolean bonificacionOtros) {
		this.bonificacionOtros = bonificacionOtros;
	}

	public String getBonificacionComentarios() {
		return bonificacionComentarios;
	}

	public void setBonificacionComentarios(String bonificacionComentarios) {
		this.bonificacionComentarios = bonificacionComentarios;
	}

	public Boolean getAjusteOtros() {
		return ajusteOtros;
	}

	public void setAjusteOtros(Boolean ajusteOtros) {
		this.ajusteOtros = ajusteOtros;
	}

	public String getAjusteComentarios() {
		return ajusteComentarios;
	}

	public void setAjusteComentarios(String ajusteComentarios) {
		this.ajusteComentarios = ajusteComentarios;
	}

	public String getMotivoComentarios() {
		return motivoComentarios;
	}

	public void setMotivoComentarios(String motivoComentarios) {
		this.motivoComentarios = motivoComentarios;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	public String getTerritorioSolicitante() {
		return territorioSolicitante;
	}

	public void setTerritorioSolicitante(String territorioSolicitante) {
		this.territorioSolicitante = territorioSolicitante;
	}

	public Boolean getContratosGenerados() {
		if (this.listaOficinasSolicitud != null)
			return (this.listaOficinasSolicitud.size() > 0 ? Boolean.TRUE : Boolean.FALSE);
		else
			return Boolean.FALSE;
	}

	public void setContratosGenerados(Boolean contratosGenerados) {
		this.contratosGenerados = contratosGenerados;
	}

	public List<OficinaSolicitudDto> getListaOficinasSolicitud() {
		if (this.listaOficinasSolicitud == null) {
			this.listaOficinasSolicitud = new ArrayList<OficinaSolicitudDto>();
		}
		Collections.sort(this.listaOficinasSolicitud, Collections.reverseOrder(OficinaSolicitudDto.COMPARATOR_TIPO_OFICINA));
		return listaOficinasSolicitud;
	}
	
	public void setListaOficinasSolicitud(
			List<OficinaSolicitudDto> listaOficinasSolicitud) {
		this.listaOficinasSolicitud = listaOficinasSolicitud;
	}

	public ParametroDto getTipoDto() {
		return tipoDto;
	}

	public void setTipoDto(ParametroDto tipoDto) {
		this.tipoDto = tipoDto;
	}

	public ParametroDto getTramiteSolicitudDto() {
		return tramiteSolicitudDto;
	}

	public void setTramiteSolicitudDto(ParametroDto tramiteSolicitudDto) {
		this.tramiteSolicitudDto = tramiteSolicitudDto;
	}

	public ParametroDto getMotivoTrasladoDto() {
		return motivoTrasladoDto;
	}

	public void setMotivoTrasladoDto(ParametroDto motivoTrasladoDto) {
		this.motivoTrasladoDto = motivoTrasladoDto;
	}

	public String getOficinaSolicitanteDesc() {
		return oficinaSolicitanteDesc;
	}

	public void setOficinaSolicitanteDesc(String oficinaSolicitanteDesc) {
		this.oficinaSolicitanteDesc = oficinaSolicitanteDesc;
	}

	public String getResponsableSolicitanteDesc() {
		return responsableSolicitanteDesc;
	}

	public void setResponsableSolicitanteDesc(String responsableSolicitanteDesc) {
		this.responsableSolicitanteDesc = responsableSolicitanteDesc;
	}

	public String getTerritorioSolicitanteDesc() {
		return territorioSolicitanteDesc;
	}

	public void setTerritorioSolicitanteDesc(String territorioSolicitanteDesc) {
		this.territorioSolicitanteDesc = territorioSolicitanteDesc;
	}

	public OficinaDto getOficinaReceptorDto() {
		return oficinaReceptorDto;
	}

	public void setOficinaReceptorDto(OficinaDto oficinaReceptorDto) {
		this.oficinaReceptorDto = oficinaReceptorDto;
	}

	public String getEmailSolicitante() {
		if(SessionHelper.getModoDebug()) {
			return SessionHelper.getEmailDebug();
		}
		
		return emailSolicitante;
	}

	public void setEmailSolicitante(String emailSolicitante) {
		this.emailSolicitante = emailSolicitante;
	}

	public String getEmailReceptor() {
		return emailReceptor;
	}

	public void setEmailReceptor(String emailReceptor) {
		this.emailReceptor = emailReceptor;
	}

	public String getOficinaPrincipalCliente() {
		return oficinaPrincipalCliente;
	}

	public void setOficinaPrincipalCliente(String oficinaPrincipalCliente) {
		this.oficinaPrincipalCliente = oficinaPrincipalCliente;
	}

	public String getGestorPrincipalCliente() {
		return gestorPrincipalCliente;
	}

	public void setGestorPrincipalCliente(String gestorPrincipalCliente) {
		this.gestorPrincipalCliente = gestorPrincipalCliente;
	}

	/** 
	 * 1006 Unificacion 
	 * 1007 Reasignacion
	 * @return Boolean.TRUE Si se aplico Ajuste o Bonificación
	 */
	public Boolean getMostrarDeclaracionJurada() {
		mostrarDeclaracionJurada = Boolean.FALSE;
		
		if (Long.valueOf(1007).compareTo(getTipoDto().getId()) == 0
				&& (getAjusteFormaGrupo() || getAjusteOtros() || getAjusteVentaUltimo())) {
			mostrarDeclaracionJurada = Boolean.TRUE;
		}
		if (Long.valueOf(1006).compareTo(getTipoDto().getId()) == 0
				&& (getBonificacionNoExcede7Dias() || getBonificacionOtros() || getBonificacion2())) {
			mostrarDeclaracionJurada = Boolean.TRUE;
		}

		return mostrarDeclaracionJurada;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof SolicitudDto)) {
			return false;
		}
		SolicitudDto other = (SolicitudDto) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public OficinaDto getOficSolicitante() {
		return oficSolicitante;
	}

	public void setOficSolicitante(OficinaDto oficSolicitante) {
		this.oficSolicitante = oficSolicitante;
	}

	public OficinaDto getOficinaReceptora() {
		return oficinaReceptora;
	}

	public void setOficinaReceptora(OficinaDto oficinaReceptora) {
		this.oficinaReceptora = oficinaReceptora;
	}

	public OficinaDto getOficinaCedente() {
		return oficinaCedente;
	}

	public void setOficinaCedente(OficinaDto oficinaCedente) {
		this.oficinaCedente = oficinaCedente;
	}

	public Boolean getFlag_oficinaSolicitante() {
		return flag_oficinaSolicitante;
	}

	public void setFlag_oficinaSolicitante(
			Boolean flag_oficinaSolicitante) {
		this.flag_oficinaSolicitante = flag_oficinaSolicitante;
	}

	public Boolean getFlag_oficinaReceptora() {
		return flag_oficinaReceptora;
	}

	public void setFlag_oficinaReceptora(
			Boolean flag_oficinaReceptora) {
		this.flag_oficinaReceptora = flag_oficinaReceptora;
	}

	public Boolean getFlag_oficinaCedente() {
		return flag_oficinaCedente;
	}

	public void setFlag_oficinaCedente(Boolean flag_oficinaCedente) {
		this.flag_oficinaCedente = flag_oficinaCedente;
	}

	public Date getFechaAprobacionSilencio() {
		return fechaAprobacionSilencio;
	}

	public void setFechaAprobacionSilencio(Date fechaAprobacionSilencio) {
		this.fechaAprobacionSilencio = fechaAprobacionSilencio;
	}

	public Boolean getAprobadaPorSilencio() {
		return aprobadaPorSilencio;
	}

	public void setAprobadaPorSilencio(Boolean aprobadaPorSilencio) {
		this.aprobadaPorSilencio = aprobadaPorSilencio;
	}

	
	
	public Boolean getBonificacion2() {
		return bonificacion2;
	}

	public void setBonificacion2(Boolean bonificacion2) {
		this.bonificacion2 = bonificacion2;
	}

	@Override
	public String toString() {
		return "com.indra.pe.bbva.reauni.entidad.SolicitudDto[ id=" + id + " ]";
	}
	
	public String getTipoDeclaracion() {
		String tipo = "";

		// 1006 Uni 1007 Rea
		if (Long.valueOf(1007).compareTo(getTipoDto().getId()) == 0
				&& (getAjusteFormaGrupo() || getAjusteOtros() || getAjusteVentaUltimo())) {
			tipo = "AJUSTE";
		}
		if (Long.valueOf(1006).compareTo(getTipoDto().getId()) == 0
				&& (getBonificacionNoExcede7Dias() || getBonificacionOtros() || getBonificacion2())) {
			tipo = "BONIFICACIÓN";
		}

		return tipo;
	}

}
