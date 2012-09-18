
package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_INVOLUCRADO",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvolucradoDto.findAll", query = "SELECT t FROM InvolucradoDto t"),
    @NamedQuery(name = "InvolucradoDto.findById", query = "SELECT t FROM InvolucradoDto t WHERE t.id = :id"),
    @NamedQuery(name = "InvolucradoDto.findByRegistro", query = "SELECT t FROM InvolucradoDto t WHERE t.registro = :registro"),
    @NamedQuery(name = "InvolucradoDto.findByNombres", query = "SELECT t FROM InvolucradoDto t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "InvolucradoDto.findByApellidoPaterno", query = "SELECT t FROM InvolucradoDto t WHERE t.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "InvolucradoDto.findByApellidoMaterno", query = "SELECT t FROM InvolucradoDto t WHERE t.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "InvolucradoDto.findByCargo", query = "SELECT t FROM InvolucradoDto t WHERE t.cargo = :cargo"),
    @NamedQuery(name = "InvolucradoDto.findByDescripcionCargo", query = "SELECT t FROM InvolucradoDto t WHERE t.descripcionCargo = :descripcionCargo")})
public class InvolucradoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "REGISTRO")
    private String registro;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "DESCRIPCION_CARGO")
    private String descripcionCargo;
    @OneToMany(mappedBy = "involucrado", fetch = FetchType.LAZY)
    private List<OficinaInvolucradoDto> treauniOficinaInvolucradoList;

    public InvolucradoDto() {
    }

    public InvolucradoDto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    @XmlTransient
    public List<OficinaInvolucradoDto> getTreauniOficinaInvolucradoList() {
        return treauniOficinaInvolucradoList;
    }

    public void setTreauniOficinaInvolucradoList(List<OficinaInvolucradoDto> treauniOficinaInvolucradoList) {
        this.treauniOficinaInvolucradoList = treauniOficinaInvolucradoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof InvolucradoDto)) {
            return false;
        }
        InvolucradoDto other = (InvolucradoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.InvolucradoDto[ id=" + id + " ]";
    }
    
}
