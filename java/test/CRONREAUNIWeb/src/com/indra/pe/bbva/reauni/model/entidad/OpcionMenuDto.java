package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_OPCION_MENU",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionMenuDto.findAll", query = "SELECT t FROM OpcionMenuDto t"),
    @NamedQuery(name = "OpcionMenuDto.findById", query = "SELECT t FROM OpcionMenuDto t WHERE t.id = :id"),
    @NamedQuery(name = "OpcionMenuDto.findByNombre", query = "SELECT t FROM OpcionMenuDto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "OpcionMenuDto.findByDescripcion", query = "SELECT t FROM OpcionMenuDto t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "OpcionMenuDto.findByAccion", query = "SELECT t FROM OpcionMenuDto t WHERE t.accion = :accion")})
public class OpcionMenuDto implements Serializable {
    
	private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "ACCION")
    private String accion;
    
    @OneToMany(mappedBy = "padre", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OpcionMenuDto> OpcionMenuDtoList;
    
    @JoinColumn(name = "PADRE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OpcionMenuDto padre;
    
    @OneToMany(mappedBy = "opcionMenu", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PerfilOpcionMenuDto> treauniPerfilOpcionMenuList;


    public OpcionMenuDto() {
    }

    public OpcionMenuDto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @XmlTransient
    public List<OpcionMenuDto> getOpcionMenuDtoList() {
        return OpcionMenuDtoList;
    }

    public void setOpcionMenuDtoList(List<OpcionMenuDto> OpcionMenuDtoList) {
        this.OpcionMenuDtoList = OpcionMenuDtoList;
    }

    public OpcionMenuDto getPadre() {
        return padre;
    }

    public void setPadre(OpcionMenuDto padre) {
        this.padre = padre;
    }

    @XmlTransient
    public List<PerfilOpcionMenuDto> getTreauniPerfilOpcionMenuList() {
        return treauniPerfilOpcionMenuList;
    }

    public void setTreauniPerfilOpcionMenuList(List<PerfilOpcionMenuDto> treauniPerfilOpcionMenuList) {
        this.treauniPerfilOpcionMenuList = treauniPerfilOpcionMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof OpcionMenuDto)) {
            return false;
        }
        OpcionMenuDto other = (OpcionMenuDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.model.entidad.OpcionMenuDto[ id=" + id + " ]";
    }
    
}
