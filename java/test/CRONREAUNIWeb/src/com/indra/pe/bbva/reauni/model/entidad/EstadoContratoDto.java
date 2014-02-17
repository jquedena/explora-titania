package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_ESTADO_CONTRATO",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoContratoDto.findAll", query = "SELECT t FROM EstadoContratoDto t"),
    @NamedQuery(name = "EstadoContratoDto.findById", query = "SELECT t FROM EstadoContratoDto t WHERE t.id = :id"),
    @NamedQuery(name = "EstadoContratoDto.findByEstado", query = "SELECT t FROM EstadoContratoDto t WHERE t.estado = :estado"),
    @NamedQuery(name = "EstadoContratoDto.findByFecha", query = "SELECT t FROM EstadoContratoDto t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "EstadoContratoDto.findByUsuario", query = "SELECT t FROM EstadoContratoDto t WHERE t.usuario = :usuario")})
public class EstadoContratoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "USUARIO")
    private String usuario;
    @JoinColumn(name = "CONTRATO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ContratoDto contrato;

    public EstadoContratoDto() {
    }

    public EstadoContratoDto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ContratoDto getContrato() {
        return contrato;
    }

    public void setContrato(ContratoDto contrato) {
        this.contrato = contrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EstadoContratoDto)) {
            return false;
        }
        EstadoContratoDto other = (EstadoContratoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.EstadoContratoDto[ id=" + id + " ]";
    }
    
}
