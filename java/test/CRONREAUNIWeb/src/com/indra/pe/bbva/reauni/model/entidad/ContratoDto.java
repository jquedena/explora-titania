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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TREAUNI_CONTRATO",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratoDto.findAll", query = "SELECT t FROM ContratoDto t"),
    @NamedQuery(name = "ContratoDto.findById", query = "SELECT t FROM ContratoDto t WHERE t.id = :id"),
    @NamedQuery(name = "ContratoDto.findByCodigoContrato", query = "SELECT t FROM ContratoDto t WHERE t.codigoContrato = :codigoContrato"),
    @NamedQuery(name = "ContratoDto.findByProducto", query = "SELECT t FROM ContratoDto t WHERE t.producto = :producto"),
    @NamedQuery(name = "ContratoDto.findByEstado", query = "SELECT t FROM ContratoDto t WHERE t.estado = :estado"),
    @NamedQuery(name = "ContratoDto.findByImporte", query = "SELECT t FROM ContratoDto t WHERE t.importe = :importe"),
    @NamedQuery(name = "ContratoDto.findByMonedaImporte", query = "SELECT t FROM ContratoDto t WHERE t.monedaImporte = :monedaImporte"),
    @NamedQuery(name = "ContratoDto.findByFechaSolicitud", query = "SELECT t FROM ContratoDto t WHERE t.fechaSolicitud = :fechaSolicitud")})
public class ContratoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CODIGO_CONTRATO")
    private String codigoContrato;
    @Column(name = "PRODUCTO")
    private String producto;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @Column(name = "IMPORTE")
    private BigDecimal importe;
    @Column(name = "MONEDA_IMPORTE")
    private String monedaImporte;
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @OneToMany(mappedBy = "contrato", fetch = FetchType.LAZY)
    private List<EstadoContratoDto> treauniEstadoContratoList;
    @JoinColumn(name = "TIPO_PRESTAMO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoPrestamoDto tipoPrestamo;
    @JoinColumn(name = "SITUACION", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SituacionDto situacion;
    @JoinColumn(name = "OFICINA_SOLICITUD", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OficinaSolicitudDto oficinaSolicitud;
    
    @Column(name = "FECHA_RECEPCION_FILE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcionFile;
    
    
    @Column(name = "USUARIO_RECEPCION_FILE")
	private String usuarioRecepcionFile;

    public ContratoDto() {
    }

    public ContratoDto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getMonedaImporte() {
        return monedaImporte;
    }

    public void setMonedaImporte(String monedaImporte) {
        this.monedaImporte = monedaImporte;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    @XmlTransient
    public List<EstadoContratoDto> getTreauniEstadoContratoList() {
        return treauniEstadoContratoList;
    }

    public void setTreauniEstadoContratoList(List<EstadoContratoDto> treauniEstadoContratoList) {
        this.treauniEstadoContratoList = treauniEstadoContratoList;
    }

    public TipoPrestamoDto getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(TipoPrestamoDto tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public SituacionDto getSituacion() {
        return situacion;
    }

    public void setSituacion(SituacionDto situacion) {
        this.situacion = situacion;
    }

    public OficinaSolicitudDto getOficinaSolicitud() {
        return oficinaSolicitud;
    }

    public void setOficinaSolicitud(OficinaSolicitudDto oficinaSolicitud) {
        this.oficinaSolicitud = oficinaSolicitud;
    }

    public Date getFechaRecepcionFile() {
		return fechaRecepcionFile;
	}

	public void setFechaRecepcionFile(Date fechaRecepcionFile) {
		this.fechaRecepcionFile = fechaRecepcionFile;
	}

	public String getUsuarioRecepcionFile() {
		return usuarioRecepcionFile;
	}

	public void setUsuarioRecepcionFile(String usuarioRecepcionFile) {
		this.usuarioRecepcionFile = usuarioRecepcionFile;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ContratoDto)) {
            return false;
        }
        ContratoDto other = (ContratoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.ContratoDto[ id=" + id + " ]";
    }
    
}
