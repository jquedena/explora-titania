package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_TIPO_PRESTAMO",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPrestamoDto.findAll", query = "SELECT t FROM TipoPrestamoDto t"),
    @NamedQuery(name = "TipoPrestamoDto.findById", query = "SELECT t FROM TipoPrestamoDto t WHERE t.id = :id"),
    @NamedQuery(name = "TipoPrestamoDto.findByDescripcion", query = "SELECT t FROM TipoPrestamoDto t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoPrestamoDto.findByCodigo", query = "SELECT t FROM TipoPrestamoDto t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TipoPrestamoDto.findByEstado", query = "SELECT t FROM TipoPrestamoDto t WHERE t.estado = :estado"),
    @NamedQuery(name = "TipoPrestamoDto.findByUsuarioCreacion", query = "SELECT t FROM TipoPrestamoDto t WHERE t.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "TipoPrestamoDto.findByFechaCreacion", query = "SELECT t FROM TipoPrestamoDto t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TipoPrestamoDto.findByUsuarioModificacion", query = "SELECT t FROM TipoPrestamoDto t WHERE t.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "TipoPrestamoDto.findByFechaModificacion", query = "SELECT t FROM TipoPrestamoDto t WHERE t.fechaModificacion = :fechaModificacion")})

public class TipoPrestamoDto implements Serializable {

	private static final long serialVersionUID = 8568894090203848493L;

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_TIPO_PRESTAMO")
    @TableGenerator(name = "SEQ_TIPO_PRESTAMO", schema="REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_TIPO_PRESTAMO", allocationSize = 1)
    private Long id;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "CODIGO")
    private String codigo;
    
    @Column(name = "ESTADO")
    private BigInteger estado;
    
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    
    @OneToMany(mappedBy = "tipoPrestamo", fetch = FetchType.LAZY)
    private List<ContratoDto> treauniContratoList;

    public TipoPrestamoDto() {
    }

    public TipoPrestamoDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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
        
        if (!(object instanceof TipoPrestamoDto)) {
            return false;
        }
        TipoPrestamoDto other = (TipoPrestamoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.TipoPrestamoDto[ id=" + id + " ]";
    }
    
}
