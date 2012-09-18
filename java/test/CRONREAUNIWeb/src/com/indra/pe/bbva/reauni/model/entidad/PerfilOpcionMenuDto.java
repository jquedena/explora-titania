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

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_PERFIL_OPCION_MENU",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilOpcionMenuDto.findAll", query = "SELECT t FROM PerfilOpcionMenuDto t"),
    @NamedQuery(name = "PerfilOpcionMenuDto.findById", query = "SELECT t FROM PerfilOpcionMenuDto t WHERE t.id = :id")})
public class PerfilOpcionMenuDto implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    
    @JoinColumn(name = "PERFIL", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PerfilDto perfil;
    
    @JoinColumn(name = "OPCION_MENU", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.FALSE)
    private OpcionMenuDto opcionMenu;

    public PerfilOpcionMenuDto() {
    }

    public PerfilOpcionMenuDto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public PerfilDto getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDto perfil) {
        this.perfil = perfil;
    }

    public OpcionMenuDto getOpcionMenu() {
        return opcionMenu;
    }

    public void setOpcionMenu(OpcionMenuDto opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PerfilOpcionMenuDto)) {
            return false;
        }
        PerfilOpcionMenuDto other = (PerfilOpcionMenuDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.PerfilOpcionMenuDto[ id=" + id + " ]";
    }
    
}
