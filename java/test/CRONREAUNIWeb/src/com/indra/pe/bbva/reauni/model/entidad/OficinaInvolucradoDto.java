package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TREAUNI_OFICINA_INVOLUCRADO",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OficinaInvolucradoDto.findAll", query = "SELECT t FROM OficinaInvolucradoDto t"),
    @NamedQuery(name = "OficinaInvolucradoDto.findById", query = "SELECT t FROM OficinaInvolucradoDto t WHERE t.id = :id")})
public class OficinaInvolucradoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "OFICINA_SOLICITUD", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OficinaSolicitudDto oficinaSolicitud;
    @JoinColumn(name = "INVOLUCRADO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private InvolucradoDto involucrado;

    public OficinaInvolucradoDto() {
    }

    public OficinaInvolucradoDto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public OficinaSolicitudDto getOficinaSolicitud() {
        return oficinaSolicitud;
    }

    public void setOficinaSolicitud(OficinaSolicitudDto oficinaSolicitud) {
        this.oficinaSolicitud = oficinaSolicitud;
    }

    public InvolucradoDto getInvolucrado() {
        return involucrado;
    }

    public void setInvolucrado(InvolucradoDto involucrado) {
        this.involucrado = involucrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof OficinaInvolucradoDto)) {
            return false;
        }
        OficinaInvolucradoDto other = (OficinaInvolucradoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.OficinaInvolucradoDto[ id=" + id + " ]";
    }
    
}
