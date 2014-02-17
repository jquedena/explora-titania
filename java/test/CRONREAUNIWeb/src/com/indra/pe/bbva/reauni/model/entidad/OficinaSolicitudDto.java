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
@Table(name = "TREAUNI_OFICINA_SOLICITUD",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OficinaSolicitudDto.findAll", query = "SELECT t FROM OficinaSolicitudDto t"),
    @NamedQuery(name = "OficinaSolicitudDto.findById", query = "SELECT t FROM OficinaSolicitudDto t WHERE t.id = :id"),
    @NamedQuery(name = "OficinaSolicitudDto.findByCodigoOficina", query = "SELECT t FROM OficinaSolicitudDto t WHERE t.codigoOficina = :codigoOficina"),
    @NamedQuery(name = "OficinaSolicitudDto.findByTipoOficina", query = "SELECT t FROM OficinaSolicitudDto t WHERE t.tipoOficina = :tipoOficina"),
    @NamedQuery(name = "OficinaSolicitudDto.findByTotalPasivo", query = "SELECT t FROM OficinaSolicitudDto t WHERE t.totalPasivo = :totalPasivo"),
    @NamedQuery(name = "OficinaSolicitudDto.findByTotalActivo", query = "SELECT t FROM OficinaSolicitudDto t WHERE t.totalActivo = :totalActivo"),
    @NamedQuery(name = "OficinaSolicitudDto.findByEstadoEvaluacion", query = "SELECT t FROM OficinaSolicitudDto t WHERE t.estadoEvaluacion = :estadoEvaluacion"),
    @NamedQuery(name = "OficinaSolicitudDto.findByUsuarioEvaluacion", query = "SELECT t FROM OficinaSolicitudDto t WHERE t.usuarioEvaluacion = :usuarioEvaluacion"),
    @NamedQuery(name = "OficinaSolicitudDto.findByFechaEvaluacion", query = "SELECT t FROM OficinaSolicitudDto t WHERE t.fechaEvaluacion = :fechaEvaluacion")})
public class OficinaSolicitudDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CODIGO_OFICINA")
    private String codigoOficina;
    @Column(name = "TIPO_OFICINA")
    private BigInteger tipoOficina;
    @Column(name = "TOTAL_PASIVO")
    private BigInteger totalPasivo;
    @Column(name = "TOTAL_ACTIVO")
    private BigInteger totalActivo;
    @Column(name = "ESTADO_EVALUACION")
    private Short estadoEvaluacion;
    @Column(name = "USUARIO_EVALUACION")
    private String usuarioEvaluacion;
    @Column(name = "FECHA_EVALUACION")
    @Temporal(TemporalType.DATE)
    private Date fechaEvaluacion;
    @OneToMany(mappedBy = "oficinaSolicitud", fetch = FetchType.LAZY)
    private List<OficinaInvolucradoDto> treauniOficinaInvolucradoList;
    @JoinColumn(name = "SOLICITUD", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SolicitudDto solicitud;
    @OneToMany(mappedBy = "oficinaSolicitud", fetch = FetchType.LAZY)
    private List<ContratoDto> treauniContratoList;

    public OficinaSolicitudDto() {
    }

    public OficinaSolicitudDto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public BigInteger getTipoOficina() {
        return tipoOficina;
    }

    public void setTipoOficina(BigInteger tipoOficina) {
        this.tipoOficina = tipoOficina;
    }

    public BigInteger getTotalPasivo() {
        return totalPasivo;
    }

    public void setTotalPasivo(BigInteger totalPasivo) {
        this.totalPasivo = totalPasivo;
    }

    public BigInteger getTotalActivo() {
        return totalActivo;
    }

    public void setTotalActivo(BigInteger totalActivo) {
        this.totalActivo = totalActivo;
    }

    public Short getEstadoEvaluacion() {
        return estadoEvaluacion;
    }

    public void setEstadoEvaluacion(Short estadoEvaluacion) {
        this.estadoEvaluacion = estadoEvaluacion;
    }

    public String getUsuarioEvaluacion() {
        return usuarioEvaluacion;
    }

    public void setUsuarioEvaluacion(String usuarioEvaluacion) {
        this.usuarioEvaluacion = usuarioEvaluacion;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    @XmlTransient
    public List<OficinaInvolucradoDto> getTreauniOficinaInvolucradoList() {
        return treauniOficinaInvolucradoList;
    }

    public void setTreauniOficinaInvolucradoList(List<OficinaInvolucradoDto> treauniOficinaInvolucradoList) {
        this.treauniOficinaInvolucradoList = treauniOficinaInvolucradoList;
    }

    public SolicitudDto getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDto solicitud) {
        this.solicitud = solicitud;
    }

    @XmlTransient
    public List<ContratoDto> getTreauniContratoList() {
        return treauniContratoList;
    }

    public void setTreauniContratoList(List<ContratoDto> treauniContratoList) {
        this.treauniContratoList = treauniContratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof OficinaSolicitudDto)) {
            return false;
        }
        OficinaSolicitudDto other = (OficinaSolicitudDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.OficinaSolicitudDto[ id=" + id + " ]";
    }
    
}
