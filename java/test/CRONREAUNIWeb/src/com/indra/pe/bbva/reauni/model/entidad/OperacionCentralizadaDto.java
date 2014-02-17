package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_OPERACION_CENTRALIZADA",schema="REAUNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacionCentralizadaDto.findAll", query = "SELECT t FROM OperacionCentralizadaDto t"),
    @NamedQuery(name = "OperacionCentralizadaDto.findById", query = "SELECT t FROM OperacionCentralizadaDto t WHERE t.id = :id"),
    @NamedQuery(name = "OperacionCentralizadaDto.findByRegistro", query = "SELECT t FROM OperacionCentralizadaDto t WHERE t.registro = :registro"),
    @NamedQuery(name = "OperacionCentralizadaDto.findByProducto", query = "SELECT t FROM OperacionCentralizadaDto t WHERE t.producto = :producto"),
    @NamedQuery(name = "OperacionCentralizadaDto.findByEstado", query = "SELECT t FROM OperacionCentralizadaDto t WHERE t.estado = :estado"),
    @NamedQuery(name = "OperacionCentralizadaDto.findByFechaCreacion", query = "SELECT t FROM OperacionCentralizadaDto t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "OperacionCentralizadaDto.findByUsuarioCreacion", query = "SELECT t FROM OperacionCentralizadaDto t WHERE t.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "OperacionCentralizadaDto.findByFechaModificacion", query = "SELECT t FROM OperacionCentralizadaDto t WHERE t.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "OperacionCentralizadaDto.findByUsuarioModificacion", query = "SELECT t FROM OperacionCentralizadaDto t WHERE t.usuarioModificacion = :usuarioModificacion")})
public class OperacionCentralizadaDto implements Serializable {
 
	private static final long serialVersionUID = 4271725985915749698L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_OPERACION_CENTRALIZADA")
    @TableGenerator(name = "SEQ_OPERACION_CENTRALIZADA", schema="REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_OPERACION_CENTRALIZADA", allocationSize = 1)
    private Long id;
	
    @Column(name = "REGISTRO")
    private String registro;
    
    @Column(name = "PRODUCTO")
    private String producto;
    
    @Column(name = "ESTADO")
    private BigInteger estado;
    
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;

    public OperacionCentralizadaDto() {
    }

    public OperacionCentralizadaDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof OperacionCentralizadaDto)) {
            return false;
        }
        OperacionCentralizadaDto other = (OperacionCentralizadaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.OperacionCentralizadaDto[ id=" + id + " ]";
    }
    
}
