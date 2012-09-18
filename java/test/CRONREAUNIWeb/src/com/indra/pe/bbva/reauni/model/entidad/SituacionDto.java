package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_SITUACION",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacionDto.findAll", query = "SELECT t FROM SituacionDto t"),
    @NamedQuery(name = "SituacionDto.findById", query = "SELECT t FROM SituacionDto t WHERE t.id = :id"),
    @NamedQuery(name = "SituacionDto.findByCodigoAplicativo", query = "SELECT t FROM SituacionDto t WHERE t.codigoAplicativo = :codigoAplicativo"),
    @NamedQuery(name = "SituacionDto.findByCodigoSituacion", query = "SELECT t FROM SituacionDto t WHERE t.codigoSituacion = :codigoSituacion"),
    @NamedQuery(name = "SituacionDto.findByDescripcion", query = "SELECT t FROM SituacionDto t WHERE t.descripcion = :descripcion")})
public class SituacionDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_SITUACION")
    @TableGenerator(name = "SEQ_SITUACION", schema="REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_SITUACION", allocationSize = 1)
    private Long id;
    
    @Column(name = "CODIGO_APLICATIVO")
    private String codigoAplicativo;
    
    @Column(name = "CODIGO_SITUACION")
    private String codigoSituacion;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @OneToMany(mappedBy = "situacion", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ContratoDto> treauniContratoList;

    public SituacionDto() {
    }

    public SituacionDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoAplicativo() {
        return codigoAplicativo;
    }

    public void setCodigoAplicativo(String codigoAplicativo) {
        this.codigoAplicativo = codigoAplicativo;
    }

    public String getCodigoSituacion() {
        return codigoSituacion;
    }

    public void setCodigoSituacion(String codigoSituacion) {
        this.codigoSituacion = codigoSituacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        
        if (!(object instanceof SituacionDto)) {
            return false;
        }
        SituacionDto other = (SituacionDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.SituacionDto[ id=" + id + " ]";
    }
    
}
