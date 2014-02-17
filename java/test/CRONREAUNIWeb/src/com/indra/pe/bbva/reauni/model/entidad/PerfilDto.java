package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author INDRA PERU SAC
 */

@Entity
@Table(name = "TREAUNI_PERFIL",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilDto.findAll", query = "SELECT t FROM PerfilDto t"),
    @NamedQuery(name = "PerfilDto.findById", query = "SELECT t FROM PerfilDto t WHERE t.id = :id"),
    @NamedQuery(name = "PerfilDto.findByNombre", query = "SELECT t FROM PerfilDto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "PerfilDto.findByDescripcion", query = "SELECT t FROM PerfilDto t WHERE t.descripcion = :descripcion")})
public class PerfilDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PermisoPerfilDto> treauniPermisoPerfilList;
    
    @OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PerfilOpcionMenuDto> PerfilDtoOpcionMenuList;

    public PerfilDto() {
    }

    public PerfilDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @XmlTransient
    public List<PermisoPerfilDto> getTreauniPermisoPerfilList() {
        return treauniPermisoPerfilList;
    }

    public void setTreauniPermisoPerfilList(List<PermisoPerfilDto> treauniPermisoPerfilList) {
        this.treauniPermisoPerfilList = treauniPermisoPerfilList;
    }

    @XmlTransient
    public List<PerfilOpcionMenuDto> getPerfilDtoOpcionMenuList() {
        return PerfilDtoOpcionMenuList;
    }

    public void setPerfilDtoOpcionMenuList(List<PerfilOpcionMenuDto> PerfilDtoOpcionMenuList) {
        this.PerfilDtoOpcionMenuList = PerfilDtoOpcionMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PerfilDto)) {
            return false;
        }
        PerfilDto other = (PerfilDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.PerfilDto[ id=" + id + " ]";
    }
    
}
