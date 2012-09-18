package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_FECHA_CORTE_DETA",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechaCorteDetaDto.findAll", query = "SELECT t FROM FechaCorteDetaDto t"),
    @NamedQuery(name = "FechaCorteDetaDto.findById", query = "SELECT t FROM FechaCorteDetaDto t WHERE t.id = :id"),
    @NamedQuery(name = "FechaCorteDetaDto.findByRegistroResponsable", query = "SELECT t FROM FechaCorteDetaDto t WHERE t.registroResponsable = :registroResponsable"),
    @NamedQuery(name = "FechaCorteDetaDto.findByPerfil", query = "SELECT t FROM FechaCorteDetaDto t WHERE t.perfil = :perfil"),
    @NamedQuery(name = "FechaCorteDetaDto.findByCantidadSolicitud", query = "SELECT t FROM FechaCorteDetaDto t WHERE t.cantidadSolicitud = :cantidadSolicitud")})
public class FechaCorteDetaDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    
    @Column(name = "REGISTRO_RESPONSABLE")
    private String registroResponsable;
    
    @Column(name = "PERFIL")
    private BigInteger perfil;
    
    @Column(name = "CANTIDAD_SOLICITUD")
    private BigInteger cantidadSolicitud;
    
    @JoinColumn(name = "FECHA_CORTE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private FechaCorteDto fechaCorte;

    public FechaCorteDetaDto() {
    }

    public FechaCorteDetaDto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRegistroResponsable() {
        return registroResponsable;
    }

    public void setRegistroResponsable(String registroResponsable) {
        this.registroResponsable = registroResponsable;
    }

    public BigInteger getPerfil() {
        return perfil;
    }

    public void setPerfil(BigInteger perfil) {
        this.perfil = perfil;
    }

    public BigInteger getCantidadSolicitud() {
        return cantidadSolicitud;
    }

    public void setCantidadSolicitud(BigInteger cantidadSolicitud) {
        this.cantidadSolicitud = cantidadSolicitud;
    }

    public FechaCorteDto getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(FechaCorteDto fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof FechaCorteDetaDto)) {
            return false;
        }
        FechaCorteDetaDto other = (FechaCorteDetaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.FechaCorteDetaDto[ id=" + id + " ]";
    }
    
}
