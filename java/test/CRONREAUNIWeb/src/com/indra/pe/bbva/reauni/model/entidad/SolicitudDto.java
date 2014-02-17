package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_SOLICITUD",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudDto.findAll", query = "SELECT t FROM SolicitudDto t"),
    @NamedQuery(name = "SolicitudDto.findById", query = "SELECT t FROM SolicitudDto t WHERE t.id = :id"),
    @NamedQuery(name = "SolicitudDto.findByNumero", query = "SELECT t FROM SolicitudDto t WHERE t.numero = :numero"),
    @NamedQuery(name = "SolicitudDto.findByTipo", query = "SELECT t FROM SolicitudDto t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "SolicitudDto.findByCodigoCliente", query = "SELECT t FROM SolicitudDto t WHERE t.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "SolicitudDto.findByNombreCliente", query = "SELECT t FROM SolicitudDto t WHERE t.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "SolicitudDto.findBySegmentoCliente", query = "SELECT t FROM SolicitudDto t WHERE t.segmentoCliente = :segmentoCliente"),
    @NamedQuery(name = "SolicitudDto.findByClasificacionCliente", query = "SELECT t FROM SolicitudDto t WHERE t.clasificacionCliente = :clasificacionCliente"),
    @NamedQuery(name = "SolicitudDto.findByFechaModificacion", query = "SELECT t FROM SolicitudDto t WHERE t.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "SolicitudDto.findByTramiteSolicitud", query = "SELECT t FROM SolicitudDto t WHERE t.tramiteSolicitud = :tramiteSolicitud"),
    @NamedQuery(name = "SolicitudDto.findByOficinaSolicitante", query = "SELECT t FROM SolicitudDto t WHERE t.oficinaSolicitante = :oficinaSolicitante"),
    @NamedQuery(name = "SolicitudDto.findByResponsableSolicitante", query = "SELECT t FROM SolicitudDto t WHERE t.responsableSolicitante = :responsableSolicitante"),
    @NamedQuery(name = "SolicitudDto.findByTerritorioReceptor", query = "SELECT t FROM SolicitudDto t WHERE t.territorioReceptor = :territorioReceptor"),
    @NamedQuery(name = "SolicitudDto.findByGestorReceptor", query = "SELECT t FROM SolicitudDto t WHERE t.gestorReceptor = :gestorReceptor"),
    @NamedQuery(name = "SolicitudDto.findByOficinaReceptor", query = "SELECT t FROM SolicitudDto t WHERE t.oficinaReceptor = :oficinaReceptor"),
    @NamedQuery(name = "SolicitudDto.findByTotalActivo", query = "SELECT t FROM SolicitudDto t WHERE t.totalActivo = :totalActivo"),
    @NamedQuery(name = "SolicitudDto.findByTotalPasivo", query = "SELECT t FROM SolicitudDto t WHERE t.totalPasivo = :totalPasivo"),
    @NamedQuery(name = "SolicitudDto.findByAjusteNoExcede7Dias", query = "SELECT t FROM SolicitudDto t WHERE t.ajusteNoExcede7Dias = :ajusteNoExcede7Dias"),
    @NamedQuery(name = "SolicitudDto.findByAjusteOtros", query = "SELECT t FROM SolicitudDto t WHERE t.ajusteOtros = :ajusteOtros"),
    @NamedQuery(name = "SolicitudDto.findByMotivoTraslado", query = "SELECT t FROM SolicitudDto t WHERE t.motivoTraslado = :motivoTraslado"),
    @NamedQuery(name = "SolicitudDto.findByAjusteComentarios", query = "SELECT t FROM SolicitudDto t WHERE t.ajusteComentarios = :ajusteComentarios"),
    @NamedQuery(name = "SolicitudDto.findByMotivoComentarios", query = "SELECT t FROM SolicitudDto t WHERE t.motivoComentarios = :motivoComentarios"),
    @NamedQuery(name = "SolicitudDto.findByFechaCreacion", query = "SELECT t FROM SolicitudDto t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "SolicitudDto.findByUsuarioCreacion", query = "SELECT t FROM SolicitudDto t WHERE t.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "SolicitudDto.findByUsuarioModificacion", query = "SELECT t FROM SolicitudDto t WHERE t.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "SolicitudDto.findByCodigoSolicitud", query = "SELECT t FROM SolicitudDto t WHERE t.codigoSolicitud = :codigoSolicitud"),
    @NamedQuery(name = "SolicitudDto.findByTerritorioSolicitante", query = "SELECT t FROM SolicitudDto t WHERE t.territorioSolicitante = :territorioSolicitante")})
public class SolicitudDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "CODIGO_CLIENTE")
    private String codigoCliente;
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Column(name = "SEGMENTO_CLIENTE")
    private String segmentoCliente;
    @Column(name = "CLASIFICACION_CLIENTE")
    private String clasificacionCliente;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Column(name = "TRAMITE_SOLICITUD")
    private BigInteger tramiteSolicitud;
    @Column(name = "OFICINA_SOLICITANTE")
    private String oficinaSolicitante;
    @Column(name = "RESPONSABLE_SOLICITANTE")
    private String responsableSolicitante;
    @Column(name = "TERRITORIO_RECEPTOR")
    private String territorioReceptor;
    @Column(name = "GESTOR_RECEPTOR")
    private String gestorReceptor;
    @Column(name = "OFICINA_RECEPTOR")
    private String oficinaReceptor;
    @Column(name = "TOTAL_ACTIVO")
    private BigInteger totalActivo;
    @Column(name = "TOTAL_PASIVO")
    private BigInteger totalPasivo;
    @Column(name = "AJUSTE_NO_EXCEDE_7_DIAS")
    private Short ajusteNoExcede7Dias;
    @Column(name = "AJUSTE_OTROS")
    private Short ajusteOtros;
    @Column(name = "MOTIVO_TRASLADO")
    private BigInteger motivoTraslado;
    @Column(name = "AJUSTE_COMENTARIOS")
    private String ajusteComentarios;
    @Column(name = "MOTIVO_COMENTARIOS")
    private String motivoComentarios;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    @Column(name = "CODIGO_SOLICITUD")
    private String codigoSolicitud;
    @Column(name = "TERRITORIO_SOLICITANTE")
    private String territorioSolicitante;
    @OneToMany(mappedBy = "solicitud", fetch = FetchType.LAZY)
    private List<OficinaSolicitudDto> treauniOficinaSolicitudList;
    
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

    public SolicitudDto(BigDecimal id) {
        this.id = id;
    }

    public String getOficinaPrincipalClienteDesc() {
		return oficinaPrincipalClienteDesc;
	}

	public void setOficinaPrincipalClienteDesc(String oficinaPrincipalClienteDesc) {
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

	public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public BigInteger getTramiteSolicitud() {
        return tramiteSolicitud;
    }

    public void setTramiteSolicitud(BigInteger tramiteSolicitud) {
        this.tramiteSolicitud = tramiteSolicitud;
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

    public String getTerritorioReceptor() {
        return territorioReceptor;
    }

    public void setTerritorioReceptor(String territorioReceptor) {
        this.territorioReceptor = territorioReceptor;
    }

    public String getGestorReceptor() {
        return gestorReceptor;
    }

    public void setGestorReceptor(String gestorReceptor) {
        this.gestorReceptor = gestorReceptor;
    }

    public String getOficinaReceptor() {
        return oficinaReceptor;
    }

    public void setOficinaReceptor(String oficinaReceptor) {
        this.oficinaReceptor = oficinaReceptor;
    }

    public BigInteger getTotalActivo() {
        return totalActivo;
    }

    public void setTotalActivo(BigInteger totalActivo) {
        this.totalActivo = totalActivo;
    }

    public BigInteger getTotalPasivo() {
        return totalPasivo;
    }

    public void setTotalPasivo(BigInteger totalPasivo) {
        this.totalPasivo = totalPasivo;
    }

    public Short getAjusteNoExcede7Dias() {
        return ajusteNoExcede7Dias;
    }

    public void setAjusteNoExcede7Dias(Short ajusteNoExcede7Dias) {
        this.ajusteNoExcede7Dias = ajusteNoExcede7Dias;
    }

    public Short getAjusteOtros() {
        return ajusteOtros;
    }

    public void setAjusteOtros(Short ajusteOtros) {
        this.ajusteOtros = ajusteOtros;
    }

    public BigInteger getMotivoTraslado() {
        return motivoTraslado;
    }

    public void setMotivoTraslado(BigInteger motivoTraslado) {
        this.motivoTraslado = motivoTraslado;
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

    @XmlTransient
    public List<OficinaSolicitudDto> getTreauniOficinaSolicitudList() {
        return treauniOficinaSolicitudList;
    }

    public void setTreauniOficinaSolicitudList(List<OficinaSolicitudDto> treauniOficinaSolicitudList) {
        this.treauniOficinaSolicitudList = treauniOficinaSolicitudList;
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.SolicitudDto[ id=" + id + " ]";
    }
    
}
