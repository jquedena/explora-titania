package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_FECHA_CORTE",schema="REAUNI")
@NamedQueries({
    @NamedQuery(name = "FechaCorteDto.findAll", query = "SELECT t FROM FechaCorteDto t"),
    @NamedQuery(name = "FechaCorteDto.findById", query = "SELECT t FROM FechaCorteDto t WHERE t.id = :id"),
    @NamedQuery(name = "FechaCorteDto.findByEstadoAcceso", query = "SELECT t FROM FechaCorteDto t WHERE t.estadoAcceso = :estadoAcceso"),
    @NamedQuery(name = "FechaCorteDto.findByNombreActividad", query = "SELECT t FROM FechaCorteDto t WHERE t.nombreActividad = :nombreActividad"),
    @NamedQuery(name = "FechaCorteDto.findByFechaInicio", query = "SELECT t FROM FechaCorteDto t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "FechaCorteDto.findByFechaFin", query = "SELECT t FROM FechaCorteDto t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "FechaCorteDto.findByEstadoCorte", query = "SELECT t FROM FechaCorteDto t WHERE t.estadoCorte = :estadoCorte"),
    @NamedQuery(name = "FechaCorteDto.findByFechaCreacion", query = "SELECT t FROM FechaCorteDto t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "FechaCorteDto.findByFechaModificacion", query = "SELECT t FROM FechaCorteDto t WHERE t.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "FechaCorteDto.findByUsuarioCreacion", query = "SELECT t FROM FechaCorteDto t WHERE t.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "FechaCorteDto.findByUsuarioModificacion", query = "SELECT t FROM FechaCorteDto t WHERE t.usuarioModificacion = :usuarioModificacion")})
public class FechaCorteDto implements Serializable {
 
	private static final long serialVersionUID = -4199092875270096277L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_FECHA_CORTE")
	@TableGenerator(name = "SEQ_FECHA_CORTE", schema="REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_FECHA_CORTE", allocationSize = 1)
    private Long id;
    
    @Column(name = "ESTADO_ACCESO")
    private String estadoAcceso;
    
    @Column(name = "NOMBRE_ACTIVIDAD")
    private String nombreActividad;
    
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    @Column(name = "ESTADO_CORTE")
    private String estadoCorte;
    
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "fechaCorteDto", fetch = FetchType.LAZY)
    //private List<FechaCorteDetaDto> FechaCorteDtoDetaList;

    public FechaCorteDto() {
    }

    public FechaCorteDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstadoAcceso() {
        return estadoAcceso;
    }

    public void setEstadoAcceso(String estadoAcceso) {
        this.estadoAcceso = estadoAcceso;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstadoCorte() {
        return estadoCorte;
    }

    public void setEstadoCorte(String estadoCorte) {
        this.estadoCorte = estadoCorte;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

//    @XmlTransient
//    public List<FechaCorteDetaDto> getFechaCorteDtoDetaList() {
//        return FechaCorteDtoDetaList;
//    }
//
//    public void setFechaCorteDtoDetaList(List<FechaCorteDetaDto> FechaCorteDtoDetaList) {
//        this.FechaCorteDtoDetaList = FechaCorteDtoDetaList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof FechaCorteDto)) {
            return false;
        }
        FechaCorteDto other = (FechaCorteDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.FechaCorteDto[ id=" + id + " ]";
    }
    
}
